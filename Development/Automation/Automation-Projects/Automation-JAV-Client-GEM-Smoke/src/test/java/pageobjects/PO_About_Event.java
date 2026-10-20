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
public class PO_About_Event extends CU_Appian {

    // [Note: Automation Engineer, define the Page Object (PO) locators (LO) here.]
    private static final String LO_ABOUT_EVENT_PAGE_VERIFY= "//h4[contains(text(), 'About the Event')]";
    private static final String LO_ABOUT_EVENT_PAGE_VERIFY_WITH_SPAN= "//span[contains(text(), 'About the Event')]";
    private static final String LO_LST_COUNTRY= "//div[span= 'Country']/following-sibling::div//div[@role='combobox']";
    private static final String LO_COUNTRY_FROM_COMBOBOX= "(//div[span='Country']/following-sibling::div//div//div//div)[1]";
    private static final String LO_EDT_CITY_FROM = "(//div[label='City']/following-sibling::div//div//input)[1]";
    private static final String LO_COUNTRY_COMBOBOX= "//div[span='Country']/following-sibling::div//div[@role='combobox']";
    private static final String LO_EDT_CITY="//div[label='City']/following-sibling::div//div//input";
    private static final String LO_EDT_FROM_DATE ="//div[label='From']/following-sibling::div//input";
    private static final String LO_EDT_TO_DATE ="//div[label='To']/following-sibling::div//input";
    private static final String LO_EDT_PURCHASE_DATE="//div[label='Trip Purchase Date']/following-sibling::div//input";
    private static final String LO_EDT_INCIDENT_DATE="//div[label='Incident Date']/following-sibling::div//input";
    private static final String LO_EDT_CANCELLATION_DATE="//div[label='Cancellation Date']/following-sibling::div//input";
    private static final String LO_EDT_REASON_FOR_CANCELATION="//div[label='What was the reason for cancellation?']/following-sibling::div//div//input";
    private static final String LO_EDT_OTHER_DUE_TO="//div[label='If Other, was this due to:']/following-sibling::div//div//input";
    private static final String LO_EDT_REASON="//div[label='Please write a short summary on what happened, how it happened, and who was involved.']/following-sibling::div//div//textarea";
    private static final String LO_BUT_CONTINUE="(//span//span[contains(text(), 'Continue')])"; 
    private static final String LO_EDT_DEPARTURE_DATE="//div[label='Departure Date']/following-sibling::div//input";
    private static final String LO_EDT_RETURN_DATE="//div[label='Return Date']/following-sibling::div//input";
    private static final String LO_RAD_BUT_YES="//div[span='Is the return date you entered the original return date?']/following-sibling::div//label[text()='Yes']";
    private static final String LO_RAD_BUT_INJURY="//div[span=\"Are you claiming for an illness or injury?\"]/following-sibling::div//label[text()='Injury']";
    private static final String LO_EDT_INJURY_DATE="//div[label='Date of Injury']/following-sibling::div//input";
    private static final String LO_EDT_INJURY_CAUSE="//div[label='Please explain how the injury occurred?']/following-sibling::div//div//textarea";
    private static final String LO_EDT_COUNTRY_TWO="(//div[span='Country']/following-sibling::div//div[@role='combobox'])[2]";
    private static final String LO_EDT_CITY_TWO="(//div[label='City']/following-sibling::div//div//input)[2]";
    private static final String LO_BUT_NO_OTHER_PARTY="//div[span=\"Is there another party who may be responsible for your injury? \"]/following-sibling::div//label[text()='No']";
    private static final String LO_BUT_NO_PHYSICIAN="//div[span=\"Do you have a primary family physician?\"]/following-sibling::div//label[text()='No']";
    private static final String LO_BUT_NO_CHRONIC_DISEASE="//div[span=\"Do you have any chronic illness or disease?\"]/following-sibling::div//label[text()='No']";
    private static final String LO_EDT_INCIDENT_DATE_OCCURANCE="//div[label='When did the incident occur?']/following-sibling::div//input";
    private static final String LO_RAD_BUT_NO_INCIDENT_HAPPEN_TRAVEL_DESTINATION ="(//label[@class='RadioSelect---choice_label'])[2]"; 
    private static final String LO_RAD_YES_CASTODY_OF_A_COMMON_CARRIER ="(//label[@class='RadioSelect---choice_label'])[3]";
    private static final String LO_EDT_TRAVEL_PROVIDER_NAME ="//div[label='What is the name of the travel provider or company?']/following-sibling::div//div//input"; 
    private static final String LO_EDT_HOW_MANY_BAGS = "//div[label='How many bags were delayed?']/following-sibling::div//div//input"; 
    private static final String LO_EDT_SCHEDULED_DATE="(//div[span='When was your scheduled date and arrival time?'])/following-sibling::div//input[@data-testid='DatePickerWidget-textInput']";
    private static final String LO_EDT_SCHEDULED_TIME="//div[span='When was your scheduled date and arrival time?']/following-sibling::div/div/div/following-sibling::div//input";
    private static final String LO_EDT_ACTUAL_DATE_BAGGAGE_WAS_RECEIVED = "(//div[span='When was the actual date and time your baggage(s) was received or delivered?'])/following-sibling::div//input[@data-testid='DatePickerWidget-textInput']";
    private static final String LO_EDT_ACTUAL_TIME_BAGGAGE_WAS_RECEIVED = "//div[span='When was the actual date and time your baggage(s) was received or delivered?']/following-sibling::div/div/div/following-sibling::div//input";
    private static final String LO_RAD_FILE_REPORT = "(//label[@class='RadioSelect---choice_label'])[6]";
    private static final String LO_EDT_SHORT_SUMMARY_ON_WHAT_HAPPENED = "//div[label='Please write a short summary on what happened, how it happened, and who was involved.']/following-sibling::div//div//textarea";
    private static final String LO_COUNTRY_DESTINATION_COMBOBOX = "(//div[span='Country']/following-sibling::div//div//div//div)[2]";
    private static final String LO_LST_CITY_DESTINATION= "(//div[label='City']/following-sibling::div//div//input)[2]";
    private static final String LO_COUNTRY_INCIDENT_OCCURANCE_COMBOBOX = "(//div[span='Country']/following-sibling::div//div//div//div[@role='combobox'])[3]";
    private static final String LO_EDT_CITY_OF_OCCURANCE = "(//div[label='City']/following-sibling::div//div//input)[3]";
    private static final String LO_EDT_DESTINATION_COUNTRY="(//div[span='Country']/following-sibling::div//div[@role='combobox'])[2]";
    private static final String LO_BUT_YES_INCIDENT_DESTINATION = "//div[span=\"Did the incident happen at the travel destination?\"]/following-sibling::div//label[text()='Yes']";
    private static final String LO_BUT_NO_INCIDENT_DESTINATION = "//div[span=\"Did the incident happen at the travel destination?\"]/following-sibling::div//label[text()='No']";
    private static final String LO_BUT_NO_CUSTODY_COMMON_CARRIER="//div[span=\"Was your baggage or personal effects in custody of a common carrier?\"]/following-sibling::div//label[text()='No']";
    private static final String LO_BUT_NO_FILE_REPORT="//div[span=\"Did you file a report with the airline, bus, cruise, travel provider, police or any other authority?\"]/following-sibling::div//label[text()='No']";
    private static final String LO_DAMAGE_DESCRIPTION="//label[normalize-space()='Broken/Smashed']";
    private static final String LO_LST_INCIDENT_OCCURANCE_DATE = "//div[span='Identify the date in which your flight/trip was confirmed to be delayed.']/div/div/input";
    private static final String LO_LST_WHEN_DID_THE_INCIDENT_OCCUR = "//div[label='When did the incident occur?']/following-sibling::div//div//input";
    private static final String LO_EDT_SCHEDULED_DEPARTURE_DATE = "//div[span='When was your scheduled date and departure time?']/following-sibling::div/div/div/div/div/input";
    private static final String LO_EDT_SCHEDULED_DEPARTURE_TIME = "//div[span='When was your scheduled date and departure time?']/following-sibling::div/div/div/div/input";
    private static final String LO_EDT_ACTUAL_DEPARTURE_DATE = "//div[span='When was your actual date and departure time?']/following-sibling::div/div/div/div/div/input";
    private static final String LO_EDT_ACTUAL_DEPARTURE_TIME = "//div[span='When was your actual date and departure time?']/following-sibling::div/div/div/div/input";
    private static final String LO_RAD_NO_FLIGHT_DELAY_CAUSE = "(//label[@class='RadioSelect---choice_label'])[2]";
    private static final String LO_EDT_ITEM_DESCRIPTION = "//div[label='Item Description: ']/following-sibling::div//div//input";
    private static final String LO_EDT_ORIGINAL_PURCHASE_DATE = "//div[label='Original Purchase Date:']/following-sibling::div//div//div//input";
    private static final String LO_EDT_WHEN_INCIDENT_DATE_OCCURED = "//div[label='Incident Date']/following-sibling::div//div//div//input";
    private static final String LO_LST_PROVINCE = "//div[span='Province']/following-sibling::div//div//div//div[@role='combobox']";
    private static final String LO_EDT_RENTAL_AGENT_NAME="//div[label='Rental Agency Name:']/following-sibling::div//input";
    private static final String LO_RAD_YES_CREDIT_CARD="//div[span=\"Was the full cost of the rental charged to your credit card?\"]/following-sibling::div//label[text()='Yes']";
    private static final String LO_INCIDENT_COUNTRY="//div[span='Country']/following-sibling::div//div[@role='combobox']";
    private static final String LO_EDT_PROVINCE = "//div[span='Province']/following-sibling::div//div[@role='combobox']";
    private static final String LO_RAD_YES_DRIVER_POLICYHOLDER="//div[span=\"Was the Policyholder the driver at the time of incident? \"]/following-sibling::div//label[text()='Yes']";
    private static final String LO_RAD_NO_OTHER_VEHICLE="//div[span=\"Did the incident involve another vehicle? \"]/following-sibling::div//label[text()='No']";
    private static final String LO_RAD_NO_RENTAL_AGREEMENT = "//div[span='Did you have another rental agreement within a 48h period from the start or the end of this current rental?']/following-sibling::div//label[contains(text(),'No')]";
    private static final String LO_EDT_RENTAL_AGENCY_NAME = "//div[label='Rental Agency Name:']/following-sibling::div//input";
    private static final String LO_RAD_YES_FULL_COST_RENTAL_CREDIT_CARD = "//div[span='Was the full cost of the rental charged to your credit card?']/following-sibling::div//label[contains(text(),'Yes')]";
    private static final String LO_RAD_YES_POLICY_HOLDER_WAS_DRIVER = "//div[span='Was the Policyholder the driver at the time of incident? ']/following-sibling::div//label[contains(text(),'Yes')]";
    private static final String LO_RAD_NO_INCIDENT_INVOLVED_ANOTHER_VEHICLE = "//div[span='Did the incident involve another vehicle? ']/following-sibling::div//label[contains(text(),'No')]";
    private static final String LO_EDT_ACTUAL_TRAVEL_FROM_DATE="(//div[label='From']/following-sibling::div//input)[2]";
    private static final String LO_EDT_ACTUAL_TRAVEL_TO_DATE="(//div[label='To']/following-sibling::div//input)[2]";
    private static final String LO_RAD_ILLNESS = "//div[span='Are you claiming for an illness or injury?']/following-sibling::div//label[contains(text(),'Illness')]";
    private static final String LO_EDT_REASON_FOR_CONSULT = "//div[label='Reason for Consult']/following-sibling::div//div//textarea";
    private static final String LO_EDT_FIRST_DATE_TREATMENT = "//div[label='First date of treatment']/following-sibling::div//input";
    private static final String LO_EDT_FIRST_DATE_SYMPTOMS = "//div[label='When did first symptoms appear?']/following-sibling::div//input";
    private static final String LO_RAD_YES__THERE_WAS_DIAGNOSIS = "//div[span='Was there a diagnosis?']/following-sibling::div//label[contains(text(),'Yes')]";
    private static final String LO_EDT_DIAGNOSIS = "//div[label='Diagnosis']/following-sibling::div//input";
    private static final String LO_EDT_NAME_MEDICAL_FACILITY = "//div[label='Name of Medical Facility where you consulted']/following-sibling::div//input";
    private static final String LO_EDT_PHONE_NUMBER_MEDICAL_FACILITY = "//div[label='Phone Number of Medical Facility']/following-sibling::div//input";
    private static final String LO_RAD_NO_EXPERIENCED_THIS_MEDICAL_CONDITION_BEFORE = "//div[span='Have you ever experienced this medical condition before?']/following-sibling::div//label[contains(text(),'No')]";
    private static final String LO_RAD_NO_RECEIVED_CONSULT_OR_TREATMENT = "//div[span='Have you ever received a consult or treatment for this medical condition?']/following-sibling::div//label[contains(text(),'No')]";
    private static final String LO_RAD_NO_ADMITTED_TO_HOSPITAL_BEFORE= "//div[span='Have you ever been admitted to a hospital before for this medical condition?']/following-sibling::div//label[contains(text(),'No')]";
    private static final String LO_EDT_MEDICATION_NAME = "//div[label='Name']/following-sibling::div//input";
    private static final String LO_RAD_YES_PRIMARY_FAMILY_PHYSICIAN = "//div[span='Do you have a primary family physician?']/following-sibling::div//label[contains(text(),'Yes')]";
    private static final String LO_EDT_FIRST_NAME_FAMILY_PHYSICIAN = "//div[label='First Name']/following-sibling::div//input";
    private static final String LO_EDT_LAST_NAME_FAMILY_PHYSICIAN = "//div[label='Last Name']/following-sibling::div//input";
    private static final String LO_EDT_PHONE_NUMBER_FAMILY_PHYSICIAN = "//div[label='Phone Number']/following-sibling::div//input";
    private static final String LO_RAD_NO_ANY_CHRONIC_ILLNESS_OR_DISEASE = "//div[span='Do you have any chronic illness or disease?']/following-sibling::div//label[contains(text(),'No')]";
    private static final String LO_EDT_MANUFACTURER_NAME = "//div[label='Manufacturer Name']/following-sibling::div//div//input";
    private static final String LO_EDT_WHEN_DID_THE_INCIDENT_OCCUR = "//div[label='Incident Date']/following-sibling::div//div//input";
    private static final String LO_EDT_HOTEL_NAME="//div[label='Name of Hotel/Motel:']/following-sibling::div//input";
    private static final String LO_EDT_HOME_ADDRESS_LINE_1 = "//div[label='Address Line 1']/following-sibling::div//div//input";
    private static final String LO_EDT_HOME_ADDRESS_LINE_2 = "//div[label='Address Line 2']/following-sibling::div//div//input";
    private static final String LO_EDT_POSTAL_CODE = "//div[label='Postal Code']/following-sibling::div//div//input";
    private static final String LO_EDT_COUNTRY = "//div[label='Country']/following-sibling::div//div//input";
    private static final String LO_RAD_NO_MULTIPLE_INSTALLMENTS = "//div[span='Did you pay for the item in multiple installments?']/following-sibling::div//label[text()='No']";
    private static final String LO_EDT_MANUFACTURER_WARRANTY = "//div[label=\"Duration of Manufacturer's Warranty\"]/following-sibling::div//input";
    private static final String LO_LST_UNIT_OF_TIME = "//div[span= 'Unit of Time']/following-sibling::div//div[@role='combobox']";
    private static final String LO_EDT_SERIAL_NUMBER = "//div[label='Serial Number ']/following-sibling::div//input";
    private static final String LO_EDT_WHAT_HAPPENED = "//div[label='Please write a short summary on what happened, how it happened, and who was involved.']/following-sibling::div//textarea";
    private static final String LO_RAD_NO_RETURN_DATE_ORIGINALITY = "//div[span='Is the return date you entered the original return date?']/following-sibling::div//label[text()='No']";
    private static final String LO_EDT_ORIGINAL_RETURN_DATE = "//div[label='Original Return Date']/following-sibling::div//div//div//input";
    private static final String LO_EDT_COUNTRY_OF_INJURY = "(//div[span= 'Country']/following-sibling::div//div//div//div[@role='combobox'])[2]";
    private static final String LO_EDT_CITY_OF_INJURY = "(//div[label='City']/following-sibling::div//div//input)[2]";
    private static final String LO_RAD_YES_ANY_CHRONIC_ILLNESS_OR_DISEASE = "//div[span='Do you have any chronic illness or disease?']/following-sibling::div//label[contains(text(),'Yes')]";
    private static final String LO_EDT_NAME_OF_ILLNESS = "//div[label='Name of illness']/following-sibling::div//div//input";
    private static final String LO_EDT_DATE_LAST_CONSULTED = "//div[label='Date Last consulted']/following-sibling::div//div//input";
    private static final String LO_RAD_YES_STILL_SEEKING_TREATMENT = "//div[span='Still Seeking treatment']/following-sibling::div//label[contains(text(),'Yes')]";
    private static final String LO_RAD_YES_EXP_MEDICAL_CONDITION="//div[span='Have you ever experienced this medical condition before?']/following-sibling::div//label[contains(text(),'Yes')]";
    private static final String LO_EDT_LAST_EPISODE_DATE="//div[label='Last Episode Date']/following-sibling::div//input";
    private static final String LO_RAD_YES_RECEIVED_CONSULT="//div[span='Have you ever received a consult or treatment for this medical condition?']/following-sibling::div//label[contains(text(),'Yes')]";
    private static final String LO_EDT_LAST_APPOINTMENT_DATE="//div[label='Last Appointment Date']/following-sibling::div//input";
    private static final String LO_RAD_NO_HOSPITAL_ADMITTED="//div[span='Have you ever been admitted to a hospital before for this medical condition?']/following-sibling::div//label[contains(text(),'No')]";
    private static final String LO_LST_VISITOR_COUNTRY_OF_ORIGIN = "//div[div='Travel Information']/following-sibling::div//div[@role='combobox']";
    private static final String LO_EDT_DATE_OF_ARRIVAL = "//div[label='Date of Arrival in Canada']/following-sibling::div//input";
    private static final String LO_EDT_PLANNED_RETURN_DATE = "//div[label='Planned Return Date']/following-sibling::div//input";
    private static final String LO_RAD_NO_TEMPORARY_TRIP_OUTSIDE_CANADA = "//div[span='Did you have a temporary trip outside Canada?']/following-sibling::div//label[contains(text(),'No')]";
    private static final String LO_RAD_YES_TEMPORARY_TRIP_OUTSIDE_CANADA = "//div[span='Have you ever experienced this medical condition before?']/following-sibling::div//label[contains(text(),'Yes')]";
    private static final String LO_RAD_YES_RECEIVED_CONSULT_OR_TREATMENT = "//div[span='Have you ever received a consult or treatment for this medical condition?']/following-sibling::div//label[contains(text(),'Yes')]";
    private static final String LO_BUT_YES_CUSTODY_COMMON_CARRIER = "//div[span=\"Was your baggage or personal effects in custody of a common carrier?\"]/following-sibling::div//label[text()='Yes']";
    private static final String LO_BUT_YES_FILE_REPORT="//div[span=\"Did you file a report with the airline, bus, cruise, travel provider, police or any other authority?\"]/following-sibling::div//label[text()='Yes']";
    private static final String LO_EDT_REPORT_FILED_DATE="//div[label='Please provide the date you filed the report.']/following-sibling::div//div//div//input";
    private static final String LO_RAD_YES_ADMITTED_TO_HOSPITAL_BEFORE = "//div[span='Have you ever been admitted to a hospital before for this medical condition?']/following-sibling::div//label[contains(text(),'Yes')]";
    private static final String LO_EDT_ADMIT_DATE = "//div[label='Admit Date']/following-sibling::div//input";
    private static final String LO_EDT_DISCHARGE_DATE = "//div[label='Discharge Date']/following-sibling::div//input";
    private static final String LO_EDT_REASON_FOR_ADMISSION = "//div[label='Reason for Admission']/following-sibling::div//input";

    /**
     * Define the Page Object (PO) constructor.
     * @param driver The WebDriver object passed from the test method.
     */
    // [Note: Automation Engineer, rename this Page Object (PO) class to match the filename.]
    public PO_About_Event(WebDriver driver) {
        super(driver);
    }

     /**
     * Validates if current webpage is loaded and correct.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateOnPage() {
        String result = validateLocatorExists(LO_ABOUT_EVENT_PAGE_VERIFY, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if current webpage is loaded and correct.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateOnPageWithSpan() {
        String result = validateLocatorExists(LO_ABOUT_EVENT_PAGE_VERIFY_WITH_SPAN, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Select Canada from country dropdown.
     *
     * @param country The country injury occerd in.
     * 
     * @return A string containing the result of the operation.
     */
    public String selectVisitorCountryOfOrigin(String country) {
        String result = setDropdownAppian(LO_LST_VISITOR_COUNTRY_OF_ORIGIN, country, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Enters the visitor date of arrival in canada
     * @param visitorDateOfArrival The date of arrival to be entered in the field.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
     public String enterDateOfArrivalInCanada(String vistorDateOfArrival) {
        String result = setText(LO_EDT_DATE_OF_ARRIVAL, vistorDateOfArrival,
                (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Enters the visitor planned return date
     * @param visitorPlannedReturnDate The planned return date to be entered in the field.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
     public String enterPlannedReturnDate(String visitorPlannedReturnDate) {
        String result = setText(LO_EDT_PLANNED_RETURN_DATE, visitorPlannedReturnDate,
                (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Enters the name of the car rental agency.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String enterNameOfRentalAgency(String car_rental_agency) {
        String result = setText(LO_EDT_RENTAL_AGENCY_NAME, car_rental_agency, FW_ConfigMgr.getDefaultTimeout(), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Selects 'Yes' to question : Was the full cost of the rental charged to your credit card?.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String selectYesFullCostOfRentalChargedOnCreditCard() {
        String result = clickLocator(LO_RAD_YES_FULL_COST_RENTAL_CREDIT_CARD, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Selects 'No' to question : Was the full cost of the rental charged to your credit card?.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String selectNoRentalAgreementWithin48Hours() {
        String result = clickLocator(LO_RAD_NO_RENTAL_AGREEMENT, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Select the country
     * 
     * @param country The country to select from the dropdown.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String selectCountry(String country) {
        String result = setDropdownAppian(LO_LST_COUNTRY, country, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /** 
     * @param province The text to enter in the province field.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String enterProvince(String province){
        String result = setDropdownAppian(LO_LST_PROVINCE, province, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    //TODO: May be a refactor oppertunity here.
    /**
     * Select the country dropdown.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String clickSelectCountryDropdown(){
        String result = clickLocator(LO_COUNTRY_COMBOBOX, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    //TODO: May be a refactor oppertunity here.
    /**
     * Selects "Canada" option from the dropdown menu.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
     public String clickCanada(){
        String dropdownValue = "Canada";
        String locator = LO_COUNTRY_COMBOBOX;
        for (int i = 0; i < 1; i++) { 
            typeOnKeyboard("ARROW_DOWN");
        }
        Boolean trueOrFalse =  typeOnKeyboard("ENTER");
        if(trueOrFalse){
            String result = "[Pass] - Selected dropdown '" + dropdownValue + "' from locator '" + locator + "'.";
            result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
            return result;
        }
        String result = "[Fail] - Dropdown '" + dropdownValue + "' does not exist for locator '" + locator + "'.";
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

     //TODO: May be a refactor oppertunity here.
    /**
     * Select the country dropdown.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String clickSelectCountryFromDropdown(){
        String result = clickLocator(LO_COUNTRY_FROM_COMBOBOX, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    //TODO: May be a refactor oppertunity here.
    /**
     * Selects "Afganistan" option from the dropdown menu.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String clickAfganistan(){
        String dropdownValue = "Afganistan";
        String locator = LO_COUNTRY_FROM_COMBOBOX;
        for (int i = 0; i < 3; i++) { 
            typeOnKeyboard("ARROW_DOWN");
        }
        Boolean trueOrFalse =  typeOnKeyboard("ENTER");
        if(trueOrFalse){
            String result = "[Pass] - Selected dropdown '" + dropdownValue + "' from locator '" + locator + "'.";
            result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
            return result;
        }
        String result = "[Fail] - Dropdown '" + dropdownValue + "' does not exist for locator '" + locator + "'.";
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /** 
     * @param cityFrom The text to enter in the city field.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String enterCityFrom(String city){
        String result = setText(LO_EDT_CITY_FROM, city, (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /** 
     * @param city The text to enter in the city field.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String enterCity(String city){
        String result = setText(LO_EDT_CITY, city, (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    
     /** 
     * @param fromDate The from date to enter in the date field.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String enterFromDate(String fromDate){
        String result = setText(LO_EDT_FROM_DATE, fromDate, (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /** 
     * @param toDate The to date to enter in the date field.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String enterToDate(String toDate){
        String result = setText(LO_EDT_TO_DATE, toDate, (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /** 
     * @param purchase  The text to enter in the purchase field.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String enterPurchaseDate(String purchase){
        String result = setText(LO_EDT_PURCHASE_DATE, purchase, (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /** 
     * @param incidentDate The text to enter in the incident date field.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String enterIncidentDate(String incidentDate){
        String result = setText(LO_EDT_INCIDENT_DATE, incidentDate, (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Selects "No" to question "Did you pay for the item in multiple installments?"
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String selectNoMultipleInstallment() {
        String result = clickLocator(LO_RAD_NO_MULTIPLE_INSTALLMENTS, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Selects 'Yes' to question : Was the Policyholder the driver at the time of incident?.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String selectYesPolicyHolderWasDriver() {
        String result = clickLocator(LO_RAD_YES_POLICY_HOLDER_WAS_DRIVER, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Selects 'No' to question : Incident involved another vehicle.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String selectNoIncidentInvolvedAnotherVehicle() {
        String result = clickLocator(LO_RAD_NO_INCIDENT_INVOLVED_ANOTHER_VEHICLE, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /** 
     * @param cancellationDate  The text to enter in the cancellation date field.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String enterCancellationDate(String cancellationDate){
        String result = setText(LO_EDT_CANCELLATION_DATE, cancellationDate, (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /** 
     * @param reasonFOrCancelation  The text to enter in the reason for cancelation field.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String enterReasonForCancelation(String reasonFOrCancelation){
        String result = setText(LO_EDT_REASON_FOR_CANCELATION, reasonFOrCancelation, (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /** 
     * @param otherDueTo  The text to enter in the other due to field.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String enterOtherDueTo(String otherDueTo){
        String result = setText(LO_EDT_OTHER_DUE_TO, otherDueTo, (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /** 
     * @param reason  The text to enter in the reason field.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String enterWhatHappened(String reason){
        String result = setText(LO_EDT_REASON, reason, (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Click "Continue" button.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String clickContinueButton(){
        String result = clickLocator(LO_BUT_CONTINUE, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Scrolls to the top of the page.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String scrollTop() {
        String result = scrollToLocator(LO_ABOUT_EVENT_PAGE_VERIFY);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Scrolls to the top of the page.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String scrollTopWithSpan() {
        String result = scrollToLocator(LO_ABOUT_EVENT_PAGE_VERIFY_WITH_SPAN);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /** 
     * @param departureDate The departure date to enter in the date field.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String enterDepartureDate(String departureDate){
        String result = setText(LO_EDT_DEPARTURE_DATE, departureDate, (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /** 
     * @param returnDate The return date to enter in the date field.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String enterReturnreDate(String returnDate){
        String result = setText(LO_EDT_RETURN_DATE, returnDate, (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Selects "Yes" option for Is the return date you entered the original return date? .
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String clickYesOriginalReturnDate(){
        String result = clickLocator(LO_RAD_BUT_YES, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Selects "No" to question :Did you have a temporary trip outside Canada?.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String selectNoTemporaryTripOutsideCanada() {
        String result = clickLocator(LO_RAD_NO_TEMPORARY_TRIP_OUTSIDE_CANADA, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Select "Injury" to Are you claiming for an illness or injury? .
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String selectIllness() {
        String result = clickLocator(LO_RAD_ILLNESS, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Enter the reason for consultation.
     * 
     * @param reasonForConsult The text to enter in the reason for consult field.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String enterReasonForConsult(String reasonForConsult) {
        String result = setText(LO_EDT_REASON_FOR_CONSULT, reasonForConsult,
                (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Enters the firt date of Treatment.
     * 
     * @param firstDateOfTreatment The first date of treatment to be entered.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String enterFirstDateOfTreatment(String firstDateOfTreatment) {
        String result = setText(LO_EDT_FIRST_DATE_TREATMENT, firstDateOfTreatment,
                (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Enters the firt date of Sysmptoms appearance.
     * 
     * @param firstDateOfSysmptoms The first date of treatment to be entered.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String enterFirstDateOfSymptoms(String firstDateOfSymptoms) {
        String result = setText(LO_EDT_FIRST_DATE_SYMPTOMS, firstDateOfSymptoms,
                (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

     /**
     * Selects "Yes" to question "Was there a diagnosis?"
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String selectYesThereWasADiagnosis() {
        String result = clickLocator(LO_RAD_YES__THERE_WAS_DIAGNOSIS, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Enters the diagnosis"
     * 
     * @param diagnosis The diagnosis to be entered.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String enterDiagnosis(String diagnosis) {
        String result = setText(LO_EDT_DIAGNOSIS, diagnosis,(Integer) FW_ConfigMgr.getVarVal("defaultTimeout"), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Enters the name of medical facility you went to"
     * 
     * @param nameOfMedicalFacility The diagnosis to be entered.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String enterNameofMedicalFacility(String nameOfMedicalFacility) {
        String result = setText(LO_EDT_NAME_MEDICAL_FACILITY, nameOfMedicalFacility,(Integer) FW_ConfigMgr.getVarVal("defaultTimeout"), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Enters the phone number of medical facility you went to"
     * 
     * @param phoneNumber The phone number to be entered.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String enterMedicalFacilityPhoneNumber(String phoneNumber) {
        String result = setText(LO_EDT_PHONE_NUMBER_MEDICAL_FACILITY, phoneNumber,(Integer) FW_ConfigMgr.getVarVal("defaultTimeout"), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Selects "Yes" to question "Have you ever experienced this medical condition
     * before? "
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String selectYesExperiencedThisMedicalConditionBefore() {
        String result = clickLocator(LO_RAD_YES_TEMPORARY_TRIP_OUTSIDE_CANADA,FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Selects "No" to question "Have you ever experienced this medical condition before? "
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String selectNoExperiencedThisMedicalConditionBefore() {
        String result = clickLocator(LO_RAD_NO_EXPERIENCED_THIS_MEDICAL_CONDITION_BEFORE, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Selects "No" to question "Have you ever received a consult or treatment for this medical condition?"
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String selectNoReceivedConsultTreatmentForThisCondition() {
        String result = clickLocator(LO_RAD_NO_RECEIVED_CONSULT_OR_TREATMENT, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Selects "No" to question "Have you ever received a consult or treatment for this medical condition?"
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String selectNoAdmittedForThisCondition() {
        String result = clickLocator(LO_RAD_NO_ADMITTED_TO_HOSPITAL_BEFORE, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Enters the medication you were taking.
     * 
     * @param medicationName The text to enter in the other due to field.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String enterMedicationName(String medicationName) {
        String result = setText(LO_EDT_MEDICATION_NAME, medicationName, (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"),
                false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * select Yes to question: Do you have a primary family physician?.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String clickYesToPrimaryPhysian() {
        String result = clickLocator(LO_RAD_YES_PRIMARY_FAMILY_PHYSICIAN, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Enters Primary family physician's First Name.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String enterFirstNameOfFamilyPhysician(String firstNamefamilyPhysician) {
        String result = setText(LO_EDT_FIRST_NAME_FAMILY_PHYSICIAN, firstNamefamilyPhysician, (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"),
                false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Enters Primary family physician's Last Name.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String enterLastNameOfFamilyPhysician(String lastNamefamilyPhysician) {
        String result = setText(LO_EDT_LAST_NAME_FAMILY_PHYSICIAN, lastNamefamilyPhysician, (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"),
                false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Enters Primary family physician's Phone Number.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String enterPhoneNumberOfFamilyPhysician(String phoneNumberfamilyPhysician) {
        String result = setText(LO_EDT_PHONE_NUMBER_FAMILY_PHYSICIAN, phoneNumberfamilyPhysician, (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"),
                false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * select No to question: Do you have any chronic illness or disease?.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String selectNoChronicIllnesOrDisease() {
        String result = clickLocator(LO_RAD_NO_ANY_CHRONIC_ILLNESS_OR_DISEASE, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Select "Injury" to Are you claiming for an illness or injury? .
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String selectInjury(){
        String result = clickLocator(LO_RAD_BUT_INJURY, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;}    

    /** 
     * @param injuryDate The text to enter in the injury date field.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String enterInjuryDate(String injuryDate){
        String result = setText(LO_EDT_INJURY_DATE, injuryDate, (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /** 
     * @param causeOfInjury  The text to enter in the reason for cancelation field.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String enterCauseOfInjury(String causeOfInjury){
        String result = setText(LO_EDT_INJURY_CAUSE, causeOfInjury, (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

     /**
     * Select Canada from country dropdown.
     *
     * @param country The country injury occerd in.
     * 
     * @return A string containing the result of the operation.
     */
     public String selectCountrtInjuryOccured(String country) {
        String result = setDropdownAppian(LO_EDT_COUNTRY_TWO, country, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /** 
     * @param city The text to enter in the city field.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String enterCityInjuryOccured(String city){
        String result = setText(LO_EDT_CITY_TWO, city, (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * select No radio button to Is there another party who may be responsible for your injury?.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String clickNoAnotherParty() {
        String result = clickLocator(LO_BUT_NO_OTHER_PARTY, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * select No radio button to Do you have a primary family physician?.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String clickNoPhysician() {
        String result = clickLocator(LO_BUT_NO_PHYSICIAN, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * select No radio button to Do you have any chronic illness or disease?.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String clickNoChronicDesease() {
        String result = clickLocator(LO_BUT_NO_CHRONIC_DISEASE, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

     /** 
     * @param incidentDateOccurance The text to enter in the incident date field.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String enterIncidentDateOccurance(String incidentDateOccurance){
        String result = setText(LO_EDT_INCIDENT_DATE_OCCURANCE, incidentDateOccurance, (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * select No radio button to Did the incident happen at your travel destination?.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String clickNoIncidentHappenTravelDestination() {
        String result = clickLocator(LO_RAD_BUT_NO_INCIDENT_HAPPEN_TRAVEL_DESTINATION, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * select No radio button to Was your baggage or personal effects in custody of a common carrier?.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String clickYesBaggageInCustody() {
        String result = clickLocator(LO_RAD_YES_CASTODY_OF_A_COMMON_CARRIER, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /** 
     * @param travelProviderName The text to enter in the travel provider name field.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */

    public String enterTravelProviderName(String travelProviderName){
        String result = setText(LO_EDT_TRAVEL_PROVIDER_NAME, travelProviderName, (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /** 
     * @param howManyBags The text to enter in the how many bags field.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */

    public String enterHowManyBags(String howManyBags){
        String result = setText(LO_EDT_HOW_MANY_BAGS, howManyBags, (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /** 
     * @param scheduledDate The text to enter in the scheduled date field.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */

    public String enterScheduledDate(String scheduledDate){
        String result = setText(LO_EDT_SCHEDULED_DATE, scheduledDate, (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /** 
     * @param scheduledTime The text to enter in the scheduled time field.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */

    public String enterScheduledTime(String scheduledTime){
        String result = setText(LO_EDT_SCHEDULED_TIME, scheduledTime, (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /** 
     * @param actualDate The text to enter in the actual date field.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */

    public String enterActualDateBaggageWasReceived(String actualDate){
        String result = setText(LO_EDT_ACTUAL_DATE_BAGGAGE_WAS_RECEIVED, actualDate, (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /** 
     * @param actualTime The text to enter in the actual time field.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */

    public String enterActualTimeBaggageWasReceived(String actualTime){
        String result = setText(LO_EDT_ACTUAL_TIME_BAGGAGE_WAS_RECEIVED, actualTime, (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * select No radio button to Did you file a report with the airline, bus, cruise, travel provider, police or any other authority?.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String clickNoFileReport() {
        String result = clickLocator(LO_RAD_FILE_REPORT, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * select Yes radio button to Did you file a report with the airline, bus, cruise, travel provider, police or any other authority?.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String clickYesFileReport() {
        String result = clickLocator(LO_BUT_YES_FILE_REPORT, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /** 
     * @param shortSummary The text to enter in the short summary field.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */

    public String enterShortSummaryOnWhatHappened(String shortSummary){
        String result = setText(LO_EDT_SHORT_SUMMARY_ON_WHAT_HAPPENED, shortSummary, (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

     //TODO: May be a refactor oppertunity here.
    /**
     * Select the country dropdown.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String clickSelectCountryDestinationDropdown(){
        String result = clickLocator(LO_COUNTRY_DESTINATION_COMBOBOX, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    //TODO: May be a refactor oppertunity here.
    /**
     * Selects "Afganistan" option from the dropdown menu.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String clickAlgeria(){
        String dropdownValue = "Algeria";
        String locator = LO_COUNTRY_DESTINATION_COMBOBOX;
        for (int i = 0; i < 4; i++) { 
            typeOnKeyboard("ARROW_DOWN");
        }
        Boolean trueOrFalse =  typeOnKeyboard("ENTER");
        if(trueOrFalse){
            String result = "[Pass] - Selected dropdown '" + dropdownValue + "' from locator '" + locator + "'.";
            result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
            return result;
        }
        String result = "[Fail] - Dropdown '" + dropdownValue + "' does not exist for locator '" + locator + "'.";
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /** 
     * @param city The text to enter in the city field.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */

    public String enterCityDestination(String city){
        String result = setText(LO_LST_CITY_DESTINATION, city, (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

     //TODO: May be a refactor oppertunity here.
    /**
     * Select the country dropdown.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String clickSelectCountryIncidentOccuranceDropdown(){
        String result = clickLocator(LO_COUNTRY_INCIDENT_OCCURANCE_COMBOBOX, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    //TODO: May be a refactor oppertunity here.
    /**
     * Selects "Afganistan" option from the dropdown menu.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String clickIncidenceOccuranceCountry(){
        String dropdownValue = "Afganistan";
        String locator = LO_COUNTRY_INCIDENT_OCCURANCE_COMBOBOX;
        for (int i = 0; i < 3; i++) { 
            typeOnKeyboard("ARROW_DOWN");
        }
        Boolean trueOrFalse =  typeOnKeyboard("ENTER");
        if(trueOrFalse){
            String result = "[Pass] - Selected dropdown '" + dropdownValue + "' from locator '" + locator + "'.";
            result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
            return result;
        }
        String result = "[Fail] - Dropdown '" + dropdownValue + "' does not exist for locator '" + locator + "'.";
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /** 
     * @param city The text to enter in the city field.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */

    public String enterCityOfOccurance(String city){
        String result = setText(LO_EDT_CITY_OF_OCCURANCE, city, (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

     /**
     * Select Canada from country dropdown.
     *
     * @param country The country injury occerd in.
     * 
     * @return A string containing the result of the operation.
     */
    public String selectDestinationCountry(String country) {
        String result = setDropdownAppian(LO_EDT_DESTINATION_COUNTRY, country, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Select Canada from country dropdown.
     *
     * @param country The country injury occerd in.
     * 
     * @return A string containing the result of the operation.
     */
    public String selectDestinationCity(String country) {
        String result = setDropdownAppian(LO_LST_CITY_DESTINATION, country, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
     /**
     * Click Yes to Did the incident happen at the travel destination?.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String clickYesIncidentTravelDestination(){
        String result = clickLocator(LO_BUT_YES_INCIDENT_DESTINATION, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

     /**
     * Click No to Was your baggage or personal effects in custody of a common carrier?.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String clickNoCustodyCommonCarrier(){
        String result = clickLocator(LO_BUT_NO_CUSTODY_COMMON_CARRIER, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

     /**
     * Click Yes to Was your baggage or personal effects in custody of a common carrier?.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String clickYesCustodyCommonCarrier(){
        String result = clickLocator(LO_BUT_YES_CUSTODY_COMMON_CARRIER, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Click No to Was your baggage or personal effects in custody of a common carrier?.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String clickNoFileReportt(){
        String result = clickLocator(LO_BUT_NO_FILE_REPORT, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String selectBrokenSmashed(){
        String result = clickLocator(LO_DAMAGE_DESCRIPTION, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /** 
     * @param incidentOccuranceDate The text to enter in the incident occurance date field.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */

    public String enterIncidentOccuranceDate(String incidentOccuranceDate){
        String result = setText(LO_LST_INCIDENT_OCCURANCE_DATE, incidentOccuranceDate, (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /** 
     * @param scheduledDepartureDate The text to enter in the scheduled departure date field.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */

    public String enterScheduledDepartureDate(String scheduledDepartureDate){
        String result = setText(LO_EDT_SCHEDULED_DEPARTURE_DATE, scheduledDepartureDate, (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /** 
     * @param scheduledDepartureTime The text to enter in the scheduled departure time field.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */

    public String enterScheduledDepartureTime(String scheduledDepartureTime){
        String result = setText(LO_EDT_SCHEDULED_DEPARTURE_TIME, scheduledDepartureTime, (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /** 
     * @param actualDepartureDate The text to enter in the actual departure date field.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */

    public String enterActualDepartureDate(String actualDepartureDate){
        String result = setText(LO_EDT_ACTUAL_DEPARTURE_DATE, actualDepartureDate, (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /** 
     * @param actualDepartureTime The text to enter in the actual departure time field.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */

    public String enterActualDepartureTime(String actualDepartureTime){
        String result = setText(LO_EDT_ACTUAL_DEPARTURE_TIME, actualDepartureTime, (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * select No radio button to What was the cause of the flight delay?.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String clickNoFlightDelayCause() {
        String result = clickLocator(LO_RAD_NO_FLIGHT_DELAY_CAUSE, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /** 
     * @param itemDescription The text to enter in the item description field.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */

    public String enterItemDescription(String itemDescription){
        String result = setText(LO_EDT_ITEM_DESCRIPTION, itemDescription, (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /** 
     * @param originalPurchaseDate The text to enter in the original purchase date field.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */

    public String enterOriginalPurchaseDate(String originalPurchaseDate){
        String result = setText(LO_EDT_ORIGINAL_PURCHASE_DATE, originalPurchaseDate, (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /** 
     * @param whenIncidentDateOccured The text to enter in the when incident date occured field.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */

    public String enterWhenIncidentDateOccured(String whenIncidentDateOccured){
        String result = setText(LO_EDT_WHEN_INCIDENT_DATE_OCCURED, whenIncidentDateOccured, (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /** 
     * Selects "Ontario" option from the dropdown menu.
     * @param province The text to enter in the province field.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */

    public String selectProvince(String province){
        String result = setDropdownAppian(LO_LST_PROVINCE, province, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

       /**
     * Enter Rental Agency Name.
     * 
     * @param agencyName The first name to be entered.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String enterRentalAgencyName(String agencyName) {
        String result = setText(LO_EDT_RENTAL_AGENT_NAME, agencyName, FW_ConfigMgr.getDefaultTimeout(), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * select Yes radio button to Was the full cost of the rental charged to your credit card?.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String clickYesToCreditCard() {
        String result = clickLocator(LO_RAD_YES_CREDIT_CARD, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * select No Did you have another rental agreement within a 48h period from the start or the end of this current rental?.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String clickNoRentalAgreement() {
        String result = clickLocator(LO_RAD_NO_RENTAL_AGREEMENT, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Select canada for incident country.
     * 
     * @param country The category type of the credit card insurance.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
     public String selectIncidentCountry(String country) {
        String result = setDropdownAppian(LO_INCIDENT_COUNTRY, country, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * select YES Was the Policyholder the driver at the time of incident?
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String clickYesToDriverPolicyholder() {
        String result = clickLocator(LO_RAD_YES_DRIVER_POLICYHOLDER, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

       /**
     * select No Did the incident involve another vehicle? 
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String clickNoOtherVehicle() {
        String result = clickLocator(LO_RAD_NO_OTHER_VEHICLE, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

        /** 
     * @param travelFromDate The from date to enter in the date field.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String enterActualTravelFromDate(String travelFromDate){
        String result = setText(LO_EDT_ACTUAL_TRAVEL_FROM_DATE, travelFromDate, (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /** 
     * @param travelToDate The from date to enter in the date field.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String enterActualTravelToDate(String travelToDate){
        String result = setText(LO_EDT_ACTUAL_TRAVEL_TO_DATE, travelToDate, (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /** 
     * Enters Manufacturer Name
     * @param travelFromDate The from date to enter in the date field.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */

    public String enterManufacturerName(String manufacturerName){
        String result = setText(LO_EDT_MANUFACTURER_NAME, manufacturerName, (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * @param manufacturerWarranty The text to enter in the manufacturer warranty field.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String enterManufacturerWarranty(String manufacturerWarranty) {
        String result = setText(LO_EDT_MANUFACTURER_WARRANTY, manufacturerWarranty, (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"),
                false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Select the unit of time
     * 
     * @param unitOfTime The country to select from the dropdown.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String selectUnitOfTime(String unitOfTime) {
        String result = setDropdownAppian(LO_LST_UNIT_OF_TIME, unitOfTime, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * @param serialNumber The serial Number to be entered.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String enterSerialNumber(String serialNumber) {
        String result = setText(LO_EDT_SERIAL_NUMBER, serialNumber, (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"),
                false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * @param whatHappened The short summary of what happened to be entered.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String enterWhatHappend(String whatHappened) {
        String result = setText(LO_EDT_WHAT_HAPPENED, whatHappened, (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"),
                false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /** 
     * Enters When did the incident occur
     * @param modelName The from date to enter in the date field.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */

    public String enterWhenTheIncidentOccured(String incidentDate){
        String result = setText(LO_EDT_WHEN_DID_THE_INCIDENT_OCCUR, incidentDate, (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Enter the hotel name.
     * 
     * @param hotelName The text to enter in the reason for consult field.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String enterHotelName(String hotelName) {
        String result = setText(LO_EDT_HOTEL_NAME, hotelName, (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
     /**
     * Enters a postal code.
     *
     * @param postalCode The postal code to be entered.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String enterPostalCode(String postalCode) {
        String result = setText(LO_EDT_POSTAL_CODE, postalCode, FW_ConfigMgr.getDefaultTimeout(), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Enters an address line 1.
     * 
     * @param addressLine1 The address line 1 to be entered.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String enterAddressLine1(String addressLine1) {
        String result = setText(LO_EDT_HOME_ADDRESS_LINE_1, addressLine1, FW_ConfigMgr.getDefaultTimeout(), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Enters an address line 2.
     * 
     * @param addressLine2 The address line 2 to be entered.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String enterAddressLine2(String addressLine2) {
        String result = setText(LO_EDT_HOME_ADDRESS_LINE_2, addressLine2, FW_ConfigMgr.getDefaultTimeout(), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Enters a country.
     * 
     * @param country The country to be entered.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String enterCountry(String country) {
        String result = setText(LO_EDT_COUNTRY, country, FW_ConfigMgr.getDefaultTimeout(), true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Select "No" to answer "Is the return date you entered the original return date?"
     */
    public String selectNoToOriginalReturnDate() {
        String result = clickLocator(LO_RAD_NO_RETURN_DATE_ORIGINALITY, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Enter "09/07/2024" to fill the "Original Return Date"
     * 
     * @param originalReturnDate The original return date to be entered.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */

    public String enterOriginalReturnDate(String originalReturnDate) {
        String result = setText(LO_EDT_ORIGINAL_RETURN_DATE, originalReturnDate, FW_ConfigMgr.getDefaultTimeout(), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

     /**
     * Select the country of injury dropdown.
     * 
     * @param country The country to select from the dropdown.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String selectCountryofInjury(String country) {
        String result = setDropdownAppian(LO_EDT_COUNTRY_OF_INJURY, country, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

     /** 
     * @param cityOfInjury The text to enter in the city field.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String enterCityOfInjury(String cityOfInjury){
        String result = setText(LO_EDT_CITY_OF_INJURY, cityOfInjury, (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

     /**
     * select Yes to question: Do you have any chronic illness or disease?.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String selectYesChronicIllnesOrDisease() {
        String result = clickLocator(LO_RAD_YES_ANY_CHRONIC_ILLNESS_OR_DISEASE, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /** 
     * Enters the name of illness.
     * @param nameOfIllness The text to enter in the chronic illness field.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */

    public String enterNameOfIllness(String nameOfIllness){
        String result = setText(LO_EDT_NAME_OF_ILLNESS, nameOfIllness, (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

        /** 
     * Enters Date last consulted.
     * @param dateLastConsulted The text to enter in the chronic illness field.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */

    public String enterDateLastConsulted(String dateLastConsulted){
        String result = setText(LO_EDT_DATE_LAST_CONSULTED, dateLastConsulted, (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * select Yes to question: Still Seeking treatment.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String selectYesStillSeekingTretment() {
        String result = clickLocator(LO_RAD_YES_STILL_SEEKING_TREATMENT, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /** 
     * Selects Yes to  answer still seeking treatment.
     * 
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String selectYesStillSeekingTreatment() {
        String result = clickLocator(LO_RAD_YES_STILL_SEEKING_TREATMENT, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }


    /**
     * Selects 'Yes' for Have you ever experienced this medical condition before?n.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String selectYesExperiencedMedicalCondition() {
        String result = clickLocator(LO_RAD_YES_EXP_MEDICAL_CONDITION, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Selects 'Yes' for Have you ever received a consult or treatment for this medical condition?.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String selectYesReceivedConsult() {
        String result = clickLocator(LO_RAD_YES_RECEIVED_CONSULT, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Selects 'No' for Have you ever been admitted to a hospital before for this medical condition?.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String selectNoForAdmittedHospital() {
        String result = clickLocator(LO_RAD_NO_HOSPITAL_ADMITTED, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

       /**
     * Selects 'Yes' for Have you ever been admitted to a hospital before for this medical condition?.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String selectYesForAdmittedHospital() {
        String result = clickLocator(LO_RAD_YES_ADMITTED_TO_HOSPITAL_BEFORE, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

     /**
     * Enters a Last Episode Date.
     * 
     * @param episodeDate The date of birth to be entered.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String enterLastEpisodeDate(String episodeDate) {
        String result = setText(LO_EDT_LAST_EPISODE_DATE, episodeDate, FW_ConfigMgr.getDefaultTimeout(), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Selects "Yes" to question "Have you ever received a consult or treatment for
     * this medical condition?"
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String selectYesReceivedConsultTreatmentForThisCondition() {
        String result = clickLocator(LO_RAD_YES_RECEIVED_CONSULT_OR_TREATMENT, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Enters the last appointment date for the same medical condition.
     * 
     * @param lastAppointmentDate The last episode date to be entered.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String enterLastAppointmentDate(String lastAppointmentDate) {
        String result = setText(LO_EDT_LAST_APPOINTMENT_DATE, lastAppointmentDate,
                (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

     /**
     * Enters the Last appointment date.
     * 
     * @param appointmentDate The date of birth to be entered.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String enterAppointmentDate(String appointmentDate) {
        String result = setText(LO_EDT_LAST_APPOINTMENT_DATE, appointmentDate, FW_ConfigMgr.getDefaultTimeout(), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

        /**
        * Select 'No' to Did the incident happen at the travel destination?
        * 
        * 
        * @return A string including [PASS] or [FAIL] along with specific result details.
        */
        public String selectNoIncidentTravelDestination() {
            String result = clickLocator(LO_BUT_NO_INCIDENT_DESTINATION, FW_ConfigMgr.getDefaultTimeout());
            result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
            return result;
        }


     /**
     * Select "Canada" as country to answer "Where did the incident occur?"
     *
     * @param country The country injury occerd in.
     * 
     * @return A string containing the result of the operation.
     */
    public String selectWhereDidTheIncidentOccur(String country) {
        String result = setDropdownAppian(LO_COUNTRY_INCIDENT_OCCURANCE_COMBOBOX, country, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Enter "09/07/2024"  to fill "Please provide the date you filed the report."
     *
     * @param dateReportFiled The date the report was filed.
     * 
     * @return A string containing the result of the operation.
     */
    public String enterDateReportFiled(String dateReportFiled) {
        String result = setText(LO_EDT_REPORT_FILED_DATE, dateReportFiled, FW_ConfigMgr.getDefaultTimeout(), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Enter "09/03/2024"  to fill The "Admitted Date."
     *
     * @param admitDate The date the report was filed.
     * 
     * @return A string containing the result of the operation.
     */
    public String enterAdmitDate(String admitDate) {
        String result = setText(LO_EDT_ADMIT_DATE, admitDate, FW_ConfigMgr.getDefaultTimeout(), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Enter "09/03/2024"  to fill The "Discharge Date."
     *
     * @param dischargeDate The date the report was filed.
     * 
     * @return A string containing the result of the operation.
     */
    public String enterDischargeDate(String dischargeDate) {
        String result = setText(LO_EDT_DISCHARGE_DATE, dischargeDate, FW_ConfigMgr.getDefaultTimeout(), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Enter "I felt better"  to fill The "Discharge Reason."
     *
     * @param  enterReasonForDischarge date the report was filed.
     * 
     * @return A string containing the result of the operation.
     */

    public String enterReasonForDischarge(String enterReasonForDischarge) {
        String result = setText(LO_EDT_REASON_FOR_ADMISSION, enterReasonForDischarge, FW_ConfigMgr.getDefaultTimeout(), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /** 
     * @param incidentOccuranceDate The text to enter in the incident occurance date field.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */

     public String enterWhenDidTheIncidentOccur(String incidentOccuranceDate){
        String result = setText(LO_LST_WHEN_DID_THE_INCIDENT_OCCUR, incidentOccuranceDate, (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }








}
