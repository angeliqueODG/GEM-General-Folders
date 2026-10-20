package pageobjects;

// Import class packages for this Page Object (PO)
import org.openqa.selenium.WebDriver;

import customizations.automation.CU_Appian; // Customization for Appian and where FW_Page is extended

import framework.junit.FW_TestStep;
import framework.utilities.FW_ConfigMgr;
import framework.utilities.FW_StringUtils;
import framework.utilities.FW_TestStepUtils;

// Secendory support imports (Typically not required)
import org.openqa.selenium.WebElement;
import java.io.File;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

public class PO_About_Event extends CU_Appian {

    private static final String LO_ABOUT_EVENT_PAGE_VERIFY= "//div/h3[contains(text(), 'ABOUT THE EVENT')]";
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
    private static final String LO_EDT_INCIDENT_DATE_WHEN_DID_THE_INCIDENT_OCCUR = "//div//h4[contains(text(),'When did the incident occur?')]/following-sibling::div//input";
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
    private static final String LO_RAD_BUT_NO_INCIDENT_HAPPEN_TRAVEL_DESTINATION ="//div[span[contains(text(), 'Did the incident happen at the travel destination?')]]/following-sibling::div//label[contains(text(), 'No')]"; 
    private static final String LO_RAD_YES_CASTODY_OF_A_COMMON_CARRIER ="//div[span[contains(text(), 'Was your baggage or personal effects in custody of a common carrier?')]]/following-sibling::div//label[contains(text(), 'Yes')]";
    private static final String LO_EDT_TRAVEL_PROVIDER_NAME ="//div[label='What is the name of the travel provider or company?']/following-sibling::div//div//input"; 
    private static final String LO_EDT_HOW_MANY_BAGS = "//div[label='How many bags were delayed?']/following-sibling::div//div//input"; 
    private static final String LO_EDT_SCHEDULED_DATE="(//div[span='When was your scheduled date and arrival time?'])/following-sibling::div//input[@data-testid='DatePickerWidget-textInput']";
    private static final String LO_EDT_SCHEDULED_TIME="//div[span='When was your scheduled date and arrival time?']/following-sibling::div/div/div/following-sibling::div//input";
    private static final String LO_EDT_ACTUAL_DATE_BAGGAGE_WAS_RECEIVED = "(//div[span='When was the actual date and time your baggage(s) was received or delivered?'])/following-sibling::div//input[@data-testid='DatePickerWidget-textInput']";
    private static final String LO_EDT_ACTUAL_TIME_BAGGAGE_WAS_RECEIVED = "//div[span='When was the actual date and time your baggage(s) was received or delivered?']/following-sibling::div/div/div/following-sibling::div//input";
    private static final String LO_RAD_FILE_REPORT = "//div[span[contains(text(), 'Did you file a report with the airline, bus, cruise, travel provider, police or any other authority?')]]/following-sibling::div//label[contains(text(), 'No')]";
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
    private static final String LO_RAD_NO_FLIGHT_DELAY_CAUSE = "//div[span[contains(text(), 'Did your flight or trip delay cause you to miss a connection? ')]]/following-sibling::div//div/label[text()='No']";
    private static final String LO_EDT_ITEM_DESCRIPTION = "//div[label='Item Description: ']/following-sibling::div//div//input";
    private static final String LO_EDT_ORIGINAL_PURCHASE_DATE = "//div[label='Original Purchase Date:']/following-sibling::div//div//div//input";
    private static final String LO_EDT_WHEN_INCIDENT_DATE_OCCURED = "//div[label='Incident Date']/following-sibling::div//div//div//input";
    private static final String LO_LST_PROVINCE = "//div[span='Province']/following-sibling::div//div//div//div[@role='combobox']";
    private static final String LO_EDT_RENTAL_AGENT_NAME="//div[label='Rental Agency Name:']/following-sibling::div//input";
    private static final String LO_RAD_YES_CREDIT_CARD="//div[span=\"Was the full cost of the rental charged to your credit card?\"]/following-sibling::div//label[text()='Yes']";
    private static final String LO_INCIDENT_COUNTRY="//div[span='Country']/following-sibling::div//div[@role='combobox']";
    private static final String LO_EDT_PROVINCE_OR_STATE = "//div[label='Province/State']/following-sibling::div//input";
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
    private static final String LO_LST_VISITOR_COUNTRY_OF_ORIGIN = "//div[span='Country of Origin']/following-sibling::div//div[@role='combobox']";
    private static final String LO_EDT_DATE_OF_ARRIVAL = "//div[label='Date of Arrival in Canada']/following-sibling::div//input";
    private static final String LO_EDT_ARRIVAL_DATE = "//div[label='Arrival Date']/following-sibling::div//input";
    private static final String LO_EDT_PLANNED_RETURN_DATE = "//div[label='Planned Return Date']/following-sibling::div//input";
    private static final String LO_EDT_PLANNED_DEPARTURE_DATE = "//div[label='Planned Departure']/following-sibling::div//input";
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
    private static final String LO_BUT_BACK = "//span[text()='Back']";
    private static final String LO_BUT_SAVE_DRAFT = "//span//span[contains(text(),'Save as Draft')]";
    private static final String LO_LST_TRAVEL_DESTINATION_COUNTRY = "//div[h3[span='What was your travel destination?']]//div[span='Country']/following-sibling::div//div[@role='combobox']";
    private static final String LO_TXT_TIMER= "//h5[text()='Session expires in:']/following-sibling::p";
    private static final String LO_EDT_TRAVEL_DESTINATION_CITY = "//div[label='City']/following-sibling::div//input";
    private static final String LO_EDT_ORIGINAL_TRIP_DATE_FROM = "//div[label='From']/following-sibling::div//input";
    private static final String LO_EDT_ORIGINAL_TRIP_DATE_TO = "//div[label='To']/following-sibling::div//input";
    private static final String LO_EDT_ACUAL_TRAVEL_DATES_FROM = "(//div[label='From']/following-sibling::div//input)[2]";
    private static final String LO_EDT_ACUAL_TRAVEL_DATES_TO = "(//div[label='To']/following-sibling::div//input)[2]";
    private static final String LO_EDT_TRIP_PURCHASE_DATE = "//div[label='Trip Purchase Date']/following-sibling::div//input";
    private static final String LO_RAD_PERSON_CAUSING_CLAIM= "//div[span[contains(text(), 'Are you the person causing the claim?')]]/following-sibling::div//label[contains(text(), 'Yes')]";
    private static final String LO_EDT_CLICK_OUTSIDE_BOX= "//div/span[contains(text(), 'When was your scheduled date and arrival time?')]";
    private static final String LO_UPLOAD_ACCIDENT_FORM = "//div[div='Accident Form']//input";
    private static final String LO_LST_COUNTRY_TRAVELLING_FROM = "(//div[span='Country']/following-sibling::div//div//div//div)[1]";
    private static final String LO_EDT_CITY_TRAVELLING_FROM = "(//div[label='City']/following-sibling::div//input)[1]";
    private static final String LO_LST_COUNTRY_TRAVELLING_DESTINATION = "(//div[span='Country']/following-sibling::div//div//div//div)[2]";
    private static final String LO_EDT_CITY_TRAVELLING_DESTINATION = "(//div[label='City']/following-sibling::div//input)[2]";
    private static final String LO_LST_COUNTRY_WHERE_INCIDENT_OCCURED = "(//div[span='Country']/following-sibling::div//div//div//div)[3]";
    private static final String LO_EDT_CITY_WHERE_INCIDENT_OCCURED = "(//div[label='City']/following-sibling::div//input)[3]";
    private static final String LO_EDT_INCIDENT_DATE_OCCURANCE_H3="//h3[span='When did the incident occur?']/following-sibling::div//input";
    private static final String LO_EDT_PROVINCE_STATE="//div[label[contains(text(), 'Province/State')]]/following-sibling::div//input";
    private static final String LO_LST_COUNTRY_INJURY_OCCURED="//div[div[span[contains(text(), 'Where did the injury occur?')]]]/following-sibling::div//div[span='Country']/following-sibling::div//div[@role='combobox']";
    private static final String LO_LST_CITY_INJURY_OCCURED="//div[div[span[contains(text(), 'Where did the injury occur?')]]]/following-sibling::div//div[label='City']/following-sibling::div//input";
    private static final String LO_LST_TRAVEL_DESTINATION_COUNTRY_PARAGRAPH = "//div[div[div[p='What was your travel destination?']]]/following-sibling::div//div[span='Country']/following-sibling::div//div[@role='combobox']";
    private static final String LO_LST_TRAVEL_DESTINATION_CITY_PARAGRAPH = "//div[div[div[p='What was your travel destination?']]]/following-sibling::div//div[label='City']/following-sibling::div//input";
    private static final String LO_TXT_NEED_TO_CONTINUE_THIS_CLAIM_LATER = "//p[contains(text(),'Need to continue this claim later?')]";
    private static final String LO_TXT_SAVE_AS_DRAFT = "//span//span[contains(text(),'Save as Draft')]";
    private static final String LO_TXT_ABOUT_THE_EVENT_PARAGRAPH = "//p[contains(text(),'Now, tell us what happened.')]";
    private static final String LO_TXT_ABOUT_THE_EVENT_SECOND_PARAGRAPH = "//p[contains(text(),'To be able to process the claim, we need to better understand what happened. Fill in the following section.')]";
    private static final String LO_ABOUT_EVENT_PAGE_VERIFY_CLAIM_DETAILS= "//h2[contains(text(), 'CLAIM DETAILS')]";
    private static final String LO_TXT_REASON_FOR_CLAIMING = "//div//label[contains(text(),'Reason for Claiming :')]";

    /**
     * Define the Page Object (PO) constructor.
     * @param driver The WebDriver object passed from the test method.
     */
    public PO_About_Event(WebDriver driver) {
        super(driver);
    }

     /**
     * Validates if current webpage is loaded and correct.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateOnPage() {
        String result = validateLocatorExists(LO_ABOUT_EVENT_PAGE_VERIFY, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if current webpage is loaded and correct.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateOnPageWithSpan() {
        String result = validateLocatorExists(LO_ABOUT_EVENT_PAGE_VERIFY_WITH_SPAN, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Select Canada from country dropdown.
     *
     * @param country The country injury occerd in.
     * 
     * @return A string containing the result of the operation.
     */
    public Object selectVisitorCountryOfOrigin(String country) {
        String result = setDropdownAppian(LO_LST_VISITOR_COUNTRY_OF_ORIGIN, country, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Enters the visitor date of arrival in canada
     * @param visitorDateOfArrival The date of arrival to be entered in the field.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
     public Object enterDateOfArrivalInCanada(String vistorDateOfArrival) {
        String result = setText(LO_EDT_DATE_OF_ARRIVAL, vistorDateOfArrival,(Integer) FW_ConfigMgr.getVarVal("defaultTimeout"), false);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Enters the visitor planned return date
     * @param visitorPlannedReturnDate The planned return date to be entered in the field.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
     public Object enterPlannedReturnDate(String visitorPlannedReturnDate) {
        String result = setText(LO_EDT_PLANNED_RETURN_DATE, visitorPlannedReturnDate,(Integer) FW_ConfigMgr.getVarVal("defaultTimeout"), false);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Enters the name of the car rental agency.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object enterNameOfRentalAgency(String car_rental_agency) {
        String result = setText(LO_EDT_RENTAL_AGENCY_NAME, car_rental_agency, FW_ConfigMgr.getDefaultTimeout(), false);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Selects 'Yes' to question : Was the full cost of the rental charged to your credit card?.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object selectYesFullCostOfRentalChargedOnCreditCard() {
        String result = clickLocator(LO_RAD_YES_FULL_COST_RENTAL_CREDIT_CARD, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Selects 'No' to question : Was the full cost of the rental charged to your credit card?.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object selectNoRentalAgreementWithin48Hours() {
        String result = clickLocator(LO_RAD_NO_RENTAL_AGREEMENT, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Select the country
     * 
     * @param country The country to select from the dropdown.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object selectCountry(String country) {
        String result = setDropdownAppian(LO_LST_COUNTRY, country, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /** 
     * @param province The text to enter in the province field.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object enterProvince(String province){
        String result = setDropdownAppian(LO_LST_PROVINCE, province, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

     /**
     * Enters the province/State
     * @param provinceOrState the province/State to be entered in the field.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object enterProvinceOrState(String provinceOrState) {
        String result = setText(LO_EDT_PROVINCE_OR_STATE, provinceOrState,(Integer) FW_ConfigMgr.getVarVal("defaultTimeout"), false);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    //TODO: May be a refactor oppertunity here.
    /**
     * Select the country dropdown.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object clickSelectCountryDropdown(){
        String result = clickLocator(LO_COUNTRY_COMBOBOX, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    //TODO: May be a refactor oppertunity here.
    /**
     * Selects "Canada" option from the dropdown menu.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
     public Object clickCanada(){
        String dropdownValue = "Canada";
        String locator = LO_COUNTRY_COMBOBOX;
        for (int i = 0; i < 1; i++) { 
            typeOnKeyboard("ARROW_DOWN");
        }
        Boolean trueOrFalse =  typeOnKeyboard("ENTER");
        if(trueOrFalse){
            String result = "[Pass] - Selected dropdown '" + dropdownValue + "' from locator '" + locator + "'.";
            FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
            return resultObj;
        }
        String result = "[Fail] - Dropdown '" + dropdownValue + "' does not exist for locator '" + locator + "'.";
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

     //TODO: May be a refactor oppertunity here.
    /**
     * Select the country dropdown.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object clickSelectCountryFromDropdown(){
        String result = clickLocator(LO_COUNTRY_FROM_COMBOBOX, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    //TODO: May be a refactor oppertunity here.
    /**
     * Selects "Afganistan" option from the dropdown menu.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object clickAfganistan(){
        String dropdownValue = "Afganistan";
        String locator = LO_COUNTRY_FROM_COMBOBOX;
        for (int i = 0; i < 3; i++) { 
            typeOnKeyboard("ARROW_DOWN");
        }
        Boolean trueOrFalse =  typeOnKeyboard("ENTER");
        if(trueOrFalse){
            String result = "[Pass] - Selected dropdown '" + dropdownValue + "' from locator '" + locator + "'.";
            FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
            return resultObj;
        }
        String result = "[Fail] - Dropdown '" + dropdownValue + "' does not exist for locator '" + locator + "'.";
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /** 
     * @param cityFrom The text to enter in the city field.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object enterCityFrom(String city){
        String result = setText(LO_EDT_CITY_FROM, city, (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"), false);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /** 
     * @param city The text to enter in the city field.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object enterCity(String city){
        String result = setText(LO_EDT_CITY, city, (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"), false);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    
     /** 
     * @param fromDate The from date to enter in the date field.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object enterFromDate(String fromDate){
        String result = setText(LO_EDT_FROM_DATE, fromDate, (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"), false);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /** 
     * @param toDate The to date to enter in the date field.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object enterToDate(String toDate){
        String result = setText(LO_EDT_TO_DATE, toDate, (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"), false);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /** 
     * @param purchase  The text to enter in the purchase field.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object enterPurchaseDate(String purchase){
        String result = setText(LO_EDT_PURCHASE_DATE, purchase, (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"), false);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /** 
     * @param incidentDate The text to enter in the incident date field.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object enterIncidentDate(String incidentDate){
        String result = setText(LO_EDT_INCIDENT_DATE, incidentDate, (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"), false);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /** 
     * @param incidentDate The text to enter in the incident date field.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object enterIncidentDateWhenDidTheIncidentOccur(String incidentDate){
        String result = setText(LO_EDT_INCIDENT_DATE_WHEN_DID_THE_INCIDENT_OCCUR, incidentDate, (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"), false);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Selects "No" to question "Did you pay for the item in multiple installments?"
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object selectNoMultipleInstallment() {
        String result = clickLocator(LO_RAD_NO_MULTIPLE_INSTALLMENTS, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Selects 'Yes' to question : Was the Policyholder the driver at the time of incident?.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object selectYesPolicyHolderWasDriver() {
        String result = clickLocator(LO_RAD_YES_POLICY_HOLDER_WAS_DRIVER, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Selects 'No' to question : Incident involved another vehicle.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object selectNoIncidentInvolvedAnotherVehicle() {
        String result = clickLocator(LO_RAD_NO_INCIDENT_INVOLVED_ANOTHER_VEHICLE, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /** 
     * @param cancellationDate  The text to enter in the cancellation date field.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object enterCancellationDate(String cancellationDate){
        String result = setText(LO_EDT_CANCELLATION_DATE, cancellationDate, (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"), false);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /** 
     * @param reasonFOrCancelation  The text to enter in the reason for cancelation field.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object enterReasonForCancelation(String reasonFOrCancelation){
        String result = setText(LO_EDT_REASON_FOR_CANCELATION, reasonFOrCancelation, (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"), false);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /** 
     * @param otherDueTo  The text to enter in the other due to field.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object enterOtherDueTo(String otherDueTo){
        String result = setText(LO_EDT_OTHER_DUE_TO, otherDueTo, (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"), false);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /** 
     * @param reason  The text to enter in the reason field.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object enterWhatHappened(String reason){
        String result = setText(LO_EDT_REASON, reason, (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"), false);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Click "Continue" button.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object clickContinueButton(){
        String result = clickLocator(LO_BUT_CONTINUE, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Scrolls to the top of the page.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object scrollTop() {
        String result = scrollToLocator(LO_ABOUT_EVENT_PAGE_VERIFY);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Scrolls to the top of the page.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object scrollTopWithSpan() {
        String result = scrollToLocator(LO_ABOUT_EVENT_PAGE_VERIFY_WITH_SPAN);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /** 
     * @param departureDate The departure date to enter in the date field.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object enterDepartureDate(String departureDate){
        String result = setText(LO_EDT_DEPARTURE_DATE, departureDate, (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"), false);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /** 
     * @param returnDate The return date to enter in the date field.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object enterReturnreDate(String returnDate){
        String result = setText(LO_EDT_RETURN_DATE, returnDate, (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"), false);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Selects "Yes" option for Is the return date you entered the original return date? .
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object clickYesOriginalReturnDate(){
        String result = clickLocator(LO_RAD_BUT_YES, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Selects "No" to question :Did you have a temporary trip outside Canada?.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object selectNoTemporaryTripOutsideCanada() {
        String result = clickLocator(LO_RAD_NO_TEMPORARY_TRIP_OUTSIDE_CANADA, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Select "Injury" to Are you claiming for an illness or injury? .
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object selectIllness() {
        String result = clickLocator(LO_RAD_ILLNESS, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Enter the reason for consultation.
     * 
     * @param reasonForConsult The text to enter in the reason for consult field.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object enterReasonForConsult(String reasonForConsult) {
        String result = setText(LO_EDT_REASON_FOR_CONSULT, reasonForConsult,(Integer) FW_ConfigMgr.getVarVal("defaultTimeout"), false);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Enters the firt date of Treatment.
     * 
     * @param firstDateOfTreatment The first date of treatment to be entered.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object enterFirstDateOfTreatment(String firstDateOfTreatment) {
        String result = setText(LO_EDT_FIRST_DATE_TREATMENT, firstDateOfTreatment,(Integer) FW_ConfigMgr.getVarVal("defaultTimeout"), false);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }   

    /**
     * Enters the firt date of Sysmptoms appearance.
     * 
     * @param firstDateOfSysmptoms The first date of treatment to be entered.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object enterFirstDateOfSymptoms(String firstDateOfSymptoms) {
        String result = setText(LO_EDT_FIRST_DATE_SYMPTOMS, firstDateOfSymptoms,(Integer) FW_ConfigMgr.getVarVal("defaultTimeout"), false);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

     /**
     * Selects "Yes" to question "Was there a diagnosis?"
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object selectYesThereWasADiagnosis() {
        String result = clickLocator(LO_RAD_YES__THERE_WAS_DIAGNOSIS, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Enters the diagnosis"
     * 
     * @param diagnosis The diagnosis to be entered.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object enterDiagnosis(String diagnosis) {
        String result = setText(LO_EDT_DIAGNOSIS, diagnosis,(Integer) FW_ConfigMgr.getVarVal("defaultTimeout"), false);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Enters the name of medical facility you went to"
     * 
     * @param nameOfMedicalFacility The diagnosis to be entered.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object enterNameofMedicalFacility(String nameOfMedicalFacility) {
        String result = setText(LO_EDT_NAME_MEDICAL_FACILITY, nameOfMedicalFacility,(Integer) FW_ConfigMgr.getVarVal("defaultTimeout"), false);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Enters the phone number of medical facility you went to"
     * 
     * @param phoneNumber The phone number to be entered.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object enterMedicalFacilityPhoneNumber(String phoneNumber) {
        String result = setText(LO_EDT_PHONE_NUMBER_MEDICAL_FACILITY, phoneNumber,(Integer) FW_ConfigMgr.getVarVal("defaultTimeout"), false);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Selects "Yes" to question "Have you ever experienced this medical condition before? "
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object selectYesExperiencedThisMedicalConditionBefore() {
        String result = clickLocator(LO_RAD_YES_TEMPORARY_TRIP_OUTSIDE_CANADA,FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Selects "No" to question "Have you ever experienced this medical condition before? "
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object selectNoExperiencedThisMedicalConditionBefore() {
        String result = clickLocator(LO_RAD_NO_EXPERIENCED_THIS_MEDICAL_CONDITION_BEFORE, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Selects "No" to question "Have you ever received a consult or treatment for this medical condition?"
     * 
     * @return A string including [PASS] or [FAIL] along with specific resultdetails.
     */
    public Object selectNoReceivedConsultTreatmentForThisCondition() {
        String result = clickLocator(LO_RAD_NO_RECEIVED_CONSULT_OR_TREATMENT, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Selects "No" to question "Have you ever received a consult or treatment for this medical condition?"
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object selectNoAdmittedForThisCondition() {
        String result = clickLocator(LO_RAD_NO_ADMITTED_TO_HOSPITAL_BEFORE, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Enters the medication you were taking.
     * 
     * @param medicationName The text to enter in the other due to field.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object enterMedicationName(String medicationName) {
        String result = setText(LO_EDT_MEDICATION_NAME, medicationName, (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"),false);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * select Yes to question: Do you have a primary family physician?.
     * 
     * @return A string including [PASS] or [FAIL] along with specific resultdetails.
     */
    public Object clickYesToPrimaryPhysian() {
        String result = clickLocator(LO_RAD_YES_PRIMARY_FAMILY_PHYSICIAN, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Enters Primary family physician's First Name.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object enterFirstNameOfFamilyPhysician(String firstNamefamilyPhysician) {
        String result = setText(LO_EDT_FIRST_NAME_FAMILY_PHYSICIAN, firstNamefamilyPhysician, (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"),false);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Enters Primary family physician's Last Name.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object enterLastNameOfFamilyPhysician(String lastNamefamilyPhysician) {
        String result = setText(LO_EDT_LAST_NAME_FAMILY_PHYSICIAN, lastNamefamilyPhysician, (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"),false);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Enters Primary family physician's Phone Number.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object enterPhoneNumberOfFamilyPhysician(String phoneNumberfamilyPhysician) {
        String result = setText(LO_EDT_PHONE_NUMBER_FAMILY_PHYSICIAN, phoneNumberfamilyPhysician, (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"),false);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * select No to question: Do you have any chronic illness or disease?.
     * 
     * @return A string including [PASS] or [FAIL] along with specific resultdetails.
     */
    public Object selectNoChronicIllnesOrDisease() {
        String result = clickLocator(LO_RAD_NO_ANY_CHRONIC_ILLNESS_OR_DISEASE, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Select "Injury" to Are you claiming for an illness or injury? .
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object selectInjury(){
        String result = clickLocator(LO_RAD_BUT_INJURY, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /** 
     * @param injuryDate The text to enter in the injury date field.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object enterInjuryDate(String injuryDate){
        String result = setText(LO_EDT_INJURY_DATE, injuryDate, (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"), false);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /** 
     * @param causeOfInjury  The text to enter in the reason for cancelation field.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object enterCauseOfInjury(String causeOfInjury){
        String result = setText(LO_EDT_INJURY_CAUSE, causeOfInjury, (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"), false);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

     /**
     * Select Canada from country dropdown.
     *
     * @param country The country injury occerd in.
     * 
     * @return A string containing the result of the operation.
     */
     public Object selectCountrtInjuryOccured(String country) {
        String result = setDropdownAppian(LO_EDT_COUNTRY_TWO, country, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /** 
     * @param city The text to enter in the city field.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object enterCityInjuryOccured(String city){
        String result = setText(LO_EDT_CITY_TWO, city, (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"), false);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * select No radio button to Is there another party who may be responsible for your injury?.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object clickNoAnotherParty() {
        String result = clickLocator(LO_BUT_NO_OTHER_PARTY, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * select No radio button to Do you have a primary family physician?.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object clickNoPhysician() {
        String result = clickLocator(LO_BUT_NO_PHYSICIAN, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * select No radio button to Do you have any chronic illness or disease?.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object clickNoChronicDesease() {
        String result = clickLocator(LO_BUT_NO_CHRONIC_DISEASE, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

     /** 
     * @param incidentDateOccurance The text to enter in the incident date field.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object enterIncidentDateOccurance(String incidentDateOccurance){
        String result = setText(LO_EDT_INCIDENT_DATE_OCCURANCE, incidentDateOccurance, (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"), false);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * select No radio button to Did the incident happen at your travel destination?.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object clickNoIncidentHappenTravelDestination() {
        String result = clickLocator(LO_RAD_BUT_NO_INCIDENT_HAPPEN_TRAVEL_DESTINATION, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * select No radio button to Was your baggage or personal effects in custody of a common carrier?.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object clickYesBaggageInCustody() {
        String result = clickLocator(LO_RAD_YES_CASTODY_OF_A_COMMON_CARRIER, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /** 
     * @param travelProviderName The text to enter in the travel provider name field.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object enterTravelProviderName(String travelProviderName){
        String result = setText(LO_EDT_TRAVEL_PROVIDER_NAME, travelProviderName, (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"), false);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /** 
     * @param howManyBags The text to enter in the how many bags field.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object enterHowManyBags(String howManyBags){
        String result = setText(LO_EDT_HOW_MANY_BAGS, howManyBags, (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"), false);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /** 
     * @param scheduledDate The text to enter in the scheduled date field.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object enterScheduledDate(String scheduledDate){
        String result = setText(LO_EDT_SCHEDULED_DATE, scheduledDate, (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"), false);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /** 
     * @param scheduledTime The text to enter in the scheduled time field.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object enterScheduledTime(String scheduledTime){
        clickLocator(LO_EDT_SCHEDULED_TIME, FW_ConfigMgr.getDefaultTimeout());
        clickLocator(LO_EDT_SCHEDULED_TIME, FW_ConfigMgr.getDefaultTimeout());
        String result = setText(LO_EDT_SCHEDULED_TIME, scheduledTime, (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"), false);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /** 
     * @param actualDate The text to enter in the actual date field.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object enterActualDateBaggageWasReceived(String actualDate){
        String result = setText(LO_EDT_ACTUAL_DATE_BAGGAGE_WAS_RECEIVED, actualDate, (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"), false);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /** 
     * @param actualTime The text to enter in the actual time field.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object enterActualTimeBaggageWasReceived(String actualTime){
        clickLocator(LO_EDT_ACTUAL_TIME_BAGGAGE_WAS_RECEIVED, FW_ConfigMgr.getDefaultTimeout());
        clickLocator(LO_EDT_ACTUAL_TIME_BAGGAGE_WAS_RECEIVED, FW_ConfigMgr.getDefaultTimeout());
        String result = setText(LO_EDT_ACTUAL_TIME_BAGGAGE_WAS_RECEIVED, actualTime, (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"), false);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * select No radio button to Did you file a report with the airline, bus, cruise, travel provider, police or any other authority?.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object clickNoFileReport() {
        String result = clickLocator(LO_RAD_FILE_REPORT, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * select Yes radio button to Did you file a report with the airline, bus, cruise, travel provider, police or any other authority?.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object clickYesFileReport() {
        String result = clickLocator(LO_BUT_YES_FILE_REPORT, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /** 
     * @param shortSummary The text to enter in the short summary field.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object enterShortSummaryOnWhatHappened(String shortSummary){
        String result = setText(LO_EDT_SHORT_SUMMARY_ON_WHAT_HAPPENED, shortSummary, (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"), false);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

     //TODO: May be a refactor oppertunity here.
    /**
     * Select the country dropdown.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object clickSelectCountryDestinationDropdown(){
        String result = clickLocator(LO_COUNTRY_DESTINATION_COMBOBOX, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    //TODO: May be a refactor oppertunity here.
    /**
     * Selects "Afganistan" option from the dropdown menu.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object clickAlgeria(){
        String dropdownValue = "Algeria";
        String locator = LO_COUNTRY_DESTINATION_COMBOBOX;
        for (int i = 0; i < 4; i++) { 
            typeOnKeyboard("ARROW_DOWN");
        }
        Boolean trueOrFalse =  typeOnKeyboard("ENTER");
        if(trueOrFalse){
            String result = "[Pass] - Selected dropdown '" + dropdownValue + "' from locator '" + locator + "'.";
            FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
            return resultObj;
        }
        String result = "[Fail] - Dropdown '" + dropdownValue + "' does not exist for locator '" + locator + "'.";
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /** 
     * @param city The text to enter in the city field.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object enterCityDestination(String city){
        String result = setText(LO_LST_CITY_DESTINATION, city, (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"), false);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

     //TODO: May be a refactor oppertunity here.
    /**
     * Select the country dropdown.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object clickSelectCountryIncidentOccuranceDropdown(){
        String result = clickLocator(LO_COUNTRY_INCIDENT_OCCURANCE_COMBOBOX, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    //TODO: May be a refactor oppertunity here.
    /**
     * Selects "Afganistan" option from the dropdown menu.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object clickIncidenceOccuranceCountry(){
        String dropdownValue = "Afganistan";
        String locator = LO_COUNTRY_INCIDENT_OCCURANCE_COMBOBOX;
        for (int i = 0; i < 3; i++) { 
            typeOnKeyboard("ARROW_DOWN");
        }
        Boolean trueOrFalse =  typeOnKeyboard("ENTER");
        if(trueOrFalse){
            String result = "[Pass] - Selected dropdown '" + dropdownValue + "' from locator '" + locator + "'.";
            FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
            return resultObj;
        }
        String result = "[Fail] - Dropdown '" + dropdownValue + "' does not exist for locator '" + locator + "'.";
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /** 
     * @param city The text to enter in the city field.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object enterCityOfOccurance(String city){
        String result = setText(LO_EDT_CITY_OF_OCCURANCE, city, (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"), false);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

     /**
     * Select Canada from country dropdown.
     *
     * @param country The country injury occerd in.
     * 
     * @return A string containing the result of the operation.
     */
    public Object selectDestinationCountry(String country) {
        String result = setDropdownAppian(LO_EDT_DESTINATION_COUNTRY, country, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Select Canada from country dropdown.
     *
     * @param country The country injury occerd in.
     * 
     * @return A string containing the result of the operation.
     */
    public Object selectDestinationCity(String country) {
        String result = setDropdownAppian(LO_LST_CITY_DESTINATION, country, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
     /**
     * Click Yes to Did the incident happen at the travel destination?.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object clickYesIncidentTravelDestination(){
        String result = clickLocator(LO_BUT_YES_INCIDENT_DESTINATION, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

     /**
     * Click No to Was your baggage or personal effects in custody of a common carrier?.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object clickNoCustodyCommonCarrier(){
        String result = clickLocator(LO_BUT_NO_CUSTODY_COMMON_CARRIER, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

     /**
     * Click Yes to Was your baggage or personal effects in custody of a common carrier?.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object clickYesCustodyCommonCarrier(){
        String result = clickLocator(LO_BUT_YES_CUSTODY_COMMON_CARRIER, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Click No to Was your baggage or personal effects in custody of a common carrier?.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object clickNoFileReportt(){
        String result = clickLocator(LO_BUT_NO_FILE_REPORT, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object selectBrokenSmashed(){
        String result = clickLocator(LO_DAMAGE_DESCRIPTION, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /** 
     * @param incidentOccuranceDate The text to enter in the incident occurance date field.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object enterIncidentOccuranceDate(String incidentOccuranceDate){
        String result = setText(LO_LST_INCIDENT_OCCURANCE_DATE, incidentOccuranceDate, (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"), false);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /** 
     * @param scheduledDepartureDate The text to enter in the scheduled departure date field.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object enterScheduledDepartureDate(String scheduledDepartureDate){
        String result = setText(LO_EDT_SCHEDULED_DEPARTURE_DATE, scheduledDepartureDate, (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"), false);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /** 
     * @param scheduledDepartureTime The text to enter in the scheduled departure time field.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object enterScheduledDepartureTime(String scheduledDepartureTime){
        clickLocator(LO_EDT_SCHEDULED_DEPARTURE_TIME, FW_ConfigMgr.getDefaultTimeout());
        clickLocator(LO_EDT_SCHEDULED_DEPARTURE_TIME, FW_ConfigMgr.getDefaultTimeout());
        String result = setText(LO_EDT_SCHEDULED_DEPARTURE_TIME, scheduledDepartureTime, (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"), false);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /** 
     * @param actualDepartureDate The text to enter in the actual departure date field.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object enterActualDepartureDate(String actualDepartureDate){
        String result = setText(LO_EDT_ACTUAL_DEPARTURE_DATE, actualDepartureDate, (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"), false);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /** 
     * @param actualDepartureTime The text to enter in the actual departure time field.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object enterActualDepartureTime(String actualDepartureTime){
        clickLocator(LO_EDT_ACTUAL_DEPARTURE_TIME, FW_ConfigMgr.getDefaultTimeout());
        clickLocator(LO_EDT_ACTUAL_DEPARTURE_TIME, FW_ConfigMgr.getDefaultTimeout());
        String result = setText(LO_EDT_ACTUAL_DEPARTURE_TIME, actualDepartureTime, (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"), false);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * select No radio button to What was the cause of the flight delay?.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object clickNoFlightDelayCause() {
        String result = clickLocator(LO_RAD_NO_FLIGHT_DELAY_CAUSE, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /** 
     * @param itemDescription The text to enter in the item description field.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object enterItemDescription(String itemDescription){
        String result = setText(LO_EDT_ITEM_DESCRIPTION, itemDescription, (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"), false);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /** 
     * @param originalPurchaseDate The text to enter in the original purchase date field.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object enterOriginalPurchaseDate(String originalPurchaseDate){
        String result = setText(LO_EDT_ORIGINAL_PURCHASE_DATE, originalPurchaseDate, (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"), false);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /** 
     * @param whenIncidentDateOccured The text to enter in the when incident date occured field.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object enterWhenIncidentDateOccured(String whenIncidentDateOccured){
        String result = setText(LO_EDT_WHEN_INCIDENT_DATE_OCCURED, whenIncidentDateOccured, (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"), false);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /** 
     * Selects "Ontario" option from the dropdown menu.
     * @param province The text to enter in the province field.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object selectProvince(String province){
        String result = setDropdownAppian(LO_LST_PROVINCE, province, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Enter Rental Agency Name.
     * 
     * @param agencyName The first name to be entered.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object enterRentalAgencyName(String agencyName) {
        String result = setText(LO_EDT_RENTAL_AGENT_NAME, agencyName, FW_ConfigMgr.getDefaultTimeout(), false);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * select Yes radio button to Was the full cost of the rental charged to your credit card?.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object clickYesToCreditCard() {
        String result = clickLocator(LO_RAD_YES_CREDIT_CARD, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * select No Did you have another rental agreement within a 48h period from the start or the end of this current rental?.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object clickNoRentalAgreement() {
        String result = clickLocator(LO_RAD_NO_RENTAL_AGREEMENT, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Select canada for incident country.
     * 
     * @param country The category type of the credit card insurance.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
     public Object selectIncidentCountry(String country) {
        String result = setDropdownAppian(LO_INCIDENT_COUNTRY, country, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * select YES Was the Policyholder the driver at the time of incident?
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object clickYesToDriverPolicyholder() {
        String result = clickLocator(LO_RAD_YES_DRIVER_POLICYHOLDER, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * select No Did the incident involve another vehicle? 
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object clickNoOtherVehicle() {
        String result = clickLocator(LO_RAD_NO_OTHER_VEHICLE, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /** 
     * @param travelFromDate The from date to enter in the date field.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object enterActualTravelFromDate(String travelFromDate){
        String result = setText(LO_EDT_ACTUAL_TRAVEL_FROM_DATE, travelFromDate, (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"), false);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /** 
     * @param travelToDate The from date to enter in the date field.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object enterActualTravelToDate(String travelToDate){
        String result = setText(LO_EDT_ACTUAL_TRAVEL_TO_DATE, travelToDate, (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"), false);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /** 
     * Enters Manufacturer Name
     * @param travelFromDate The from date to enter in the date field.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object enterManufacturerName(String manufacturerName){
        String result = setText(LO_EDT_MANUFACTURER_NAME, manufacturerName, (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"), false);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * @param manufacturerWarranty The text to enter in the manufacturer warranty field.
     * 
     * @return A string including [PASS] or [FAIL] along with specific resultdetails.
     */
    public Object enterManufacturerWarranty(String manufacturerWarranty) {
        String result = setText(LO_EDT_MANUFACTURER_WARRANTY, manufacturerWarranty, (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"), false);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Select the unit of time
     * 
     * @param unitOfTime The country to select from the dropdown.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object selectUnitOfTime(String unitOfTime) {
        String result = setDropdownAppian(LO_LST_UNIT_OF_TIME, unitOfTime, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * @param serialNumber The serial Number to be entered.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object enterSerialNumber(String serialNumber) {
        String result = setText(LO_EDT_SERIAL_NUMBER, serialNumber, (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"),false);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * @param whatHappened The short summary of what happened to be entered.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object enterWhatHappend(String whatHappened) {
        String result = setText(LO_EDT_WHAT_HAPPENED, whatHappened, (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"),false);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /** 
     * Enters When did the incident occur
     * @param modelName The from date to enter in the date field.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object enterWhenTheIncidentOccured(String incidentDate){
        String result = setText(LO_EDT_WHEN_DID_THE_INCIDENT_OCCUR, incidentDate, (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"), false);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Enter the hotel name.
     * 
     * @param hotelName The text to enter in the reason for consult field.
     * 
     * @return A string including [PASS] or [FAIL] along with specific resultdetails.
     */
    public Object enterHotelName(String hotelName) {
        String result = setText(LO_EDT_HOTEL_NAME, hotelName, (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"), false);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

     /**
     * Enters a postal code.
     *
     * @param postalCode The postal code to be entered.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object enterPostalCode(String postalCode) {
        String result = setText(LO_EDT_POSTAL_CODE, postalCode, FW_ConfigMgr.getDefaultTimeout(), false);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Enters an address line 1.
     * 
     * @param addressLine1 The address line 1 to be entered.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object enterAddressLine1(String addressLine1) {
        String result = setText(LO_EDT_HOME_ADDRESS_LINE_1, addressLine1, FW_ConfigMgr.getDefaultTimeout(), false);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Enters an address line 2.
     * 
     * @param addressLine2 The address line 2 to be entered.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object enterAddressLine2(String addressLine2) {
        String result = setText(LO_EDT_HOME_ADDRESS_LINE_2, addressLine2, FW_ConfigMgr.getDefaultTimeout(), false);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Enters a country.
     * 
     * @param country The country to be entered.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object enterCountry(String country) {
        String result = setText(LO_EDT_COUNTRY, country, FW_ConfigMgr.getDefaultTimeout(), true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Select "No" to answer "Is the return date you entered the original return date?"
     */
    public Object selectNoToOriginalReturnDate() {
        String result = clickLocator(LO_RAD_NO_RETURN_DATE_ORIGINALITY, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Enter "09/07/2024" to fill the "Original Return Date"
     * 
     * @param originalReturnDate The original return date to be entered.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object enterOriginalReturnDate(String originalReturnDate) {
        String result = setText(LO_EDT_ORIGINAL_RETURN_DATE, originalReturnDate, FW_ConfigMgr.getDefaultTimeout(), false);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

     /**
     * Select the country of injury dropdown.
     * 
     * @param country The country to select from the dropdown.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object selectCountryofInjury(String country) {
        String result = setDropdownAppian(LO_EDT_COUNTRY_OF_INJURY, country, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

     /** 
     * @param cityOfInjury The text to enter in the city field.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object enterCityOfInjury(String cityOfInjury){
        String result = setText(LO_EDT_CITY_OF_INJURY, cityOfInjury, (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"), false);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

     /**
     * select Yes to question: Do you have any chronic illness or disease?.
     * 
     * @return A string including [PASS] or [FAIL] along with specific resultdetails.
     */
    public Object selectYesChronicIllnesOrDisease() {
        String result = clickLocator(LO_RAD_YES_ANY_CHRONIC_ILLNESS_OR_DISEASE, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /** 
     * Enters the name of illness.
     * @param nameOfIllness The text to enter in the chronic illness field.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object enterNameOfIllness(String nameOfIllness){
        String result = setText(LO_EDT_NAME_OF_ILLNESS, nameOfIllness, (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"), false);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /** 
     * Enters Date last consulted.
     * @param dateLastConsulted The text to enter in the chronic illness field.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object enterDateLastConsulted(String dateLastConsulted){
        String result = setText(LO_EDT_DATE_LAST_CONSULTED, dateLastConsulted, (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"), false);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * select Yes to question: Still Seeking treatment.
     * 
     * @return A string including [PASS] or [FAIL] along with specific resultdetails.
     */
    public Object selectYesStillSeekingTretment() {
        String result = clickLocator(LO_RAD_YES_STILL_SEEKING_TREATMENT, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /** 
     * Selects Yes to  answer still seeking treatment.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object selectYesStillSeekingTreatment() {
        String result = clickLocator(LO_RAD_YES_STILL_SEEKING_TREATMENT, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Selects 'Yes' for Have you ever experienced this medical condition before?n.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object selectYesExperiencedMedicalCondition() {
        String result = clickLocator(LO_RAD_YES_EXP_MEDICAL_CONDITION, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Selects 'Yes' for Have you ever received a consult or treatment for this medical condition?.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object selectYesReceivedConsult() {
        String result = clickLocator(LO_RAD_YES_RECEIVED_CONSULT, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Selects 'No' for Have you ever been admitted to a hospital before for this medical condition?.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object selectNoForAdmittedHospital() {
        String result = clickLocator(LO_RAD_NO_HOSPITAL_ADMITTED, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Selects 'Yes' for Have you ever been admitted to a hospital before for this medical condition?.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object selectYesForAdmittedHospital() {
        String result = clickLocator(LO_RAD_YES_ADMITTED_TO_HOSPITAL_BEFORE, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

     /**
     * Enters a Last Episode Date.
     * 
     * @param episodeDate The date of birth to be entered.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object enterLastEpisodeDate(String episodeDate) {
        String result = setText(LO_EDT_LAST_EPISODE_DATE, episodeDate, FW_ConfigMgr.getDefaultTimeout(), false);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Selects "Yes" to question "Have you ever received a consult or treatment for this medical condition?"
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object selectYesReceivedConsultTreatmentForThisCondition() {
        String result = clickLocator(LO_RAD_YES_RECEIVED_CONSULT_OR_TREATMENT, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Enters the last appointment date for the same medical condition.
     * 
     * @param lastAppointmentDate The last episode date to be entered.
     * 
     * @return A string including [PASS] or [FAIL] along with specific resultdetails.
     */
    public Object enterLastAppointmentDate(String lastAppointmentDate) {
        String result = setText(LO_EDT_LAST_APPOINTMENT_DATE, lastAppointmentDate,(Integer) FW_ConfigMgr.getVarVal("defaultTimeout"), false);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Enters the Last appointment date.
     * 
     * @param appointmentDate The date of birth to be entered.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object enterAppointmentDate(String appointmentDate) {
        String result = setText(LO_EDT_LAST_APPOINTMENT_DATE, appointmentDate, FW_ConfigMgr.getDefaultTimeout(), false);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
    * Select 'No' to Did the incident happen at the travel destination?
    * 
    * @return A string including [PASS] or [FAIL] along with specific result details.
    */
    public Object selectNoIncidentTravelDestination() {
        String result = clickLocator(LO_BUT_NO_INCIDENT_DESTINATION, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

     /**
     * Select "Canada" as country to answer "Where did the incident occur?"
     *
     * @param country The country injury occerd in.
     * 
     * @return A string containing the result of the operation.
     */
    public Object selectWhereDidTheIncidentOccur(String country) {
        String result = setDropdownAppian(LO_COUNTRY_INCIDENT_OCCURANCE_COMBOBOX, country, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Enter "09/07/2024"  to fill "Please provide the date you filed the report."
     *
     * @param dateReportFiled The date the report was filed.
     * 
     * @return A string containing the result of the operation.
     */
    public Object enterDateReportFiled(String dateReportFiled) {
        String result = setText(LO_EDT_REPORT_FILED_DATE, dateReportFiled, FW_ConfigMgr.getDefaultTimeout(), false);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Enter "09/03/2024"  to fill The "Admitted Date."
     *
     * @param admitDate The date the report was filed.
     * 
     * @return A string containing the result of the operation.
     */
    public Object enterAdmitDate(String admitDate) {
        String result = setText(LO_EDT_ADMIT_DATE, admitDate, FW_ConfigMgr.getDefaultTimeout(), false);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Enter "09/03/2024"  to fill The "Discharge Date."
     *
     * @param dischargeDate The date the report was filed.
     * 
     * @return A string containing the result of the operation.
     */
    public Object enterDischargeDate(String dischargeDate) {
        String result = setText(LO_EDT_DISCHARGE_DATE, dischargeDate, FW_ConfigMgr.getDefaultTimeout(), false);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Enter "I felt better"  to fill The "Discharge Reason."
     *
     * @param  enterReasonForDischarge date the report was filed.
     * 
     * @return A string containing the result of the operation.
     */
    public Object enterReasonForDischarge(String enterReasonForDischarge) {
        String result = setText(LO_EDT_REASON_FOR_ADMISSION, enterReasonForDischarge, FW_ConfigMgr.getDefaultTimeout(), false);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /** 
     * @param incidentOccuranceDate The text to enter in the incident occurance date field.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
     public Object enterWhenDidTheIncidentOccur(String incidentOccuranceDate){
        String result = setText(LO_LST_WHEN_DID_THE_INCIDENT_OCCUR, incidentOccuranceDate, (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"), false);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Clicks the  "Back" button.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object clickBackButton() {
        String result = clickLocator(LO_BUT_BACK, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Click "Save As Draft" button.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object clickSaveAsDraftButton() {
        String result = clickLocator(LO_BUT_SAVE_DRAFT, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Select Canada from country dropdown.
     *
     * @param country The country injury occerd in.
     * 
     * @return A string containing the result of the operation.
     */
    public Object selectTravelDestinationCountry(String country) {
        String result = setDropdownAppian(LO_LST_TRAVEL_DESTINATION_COUNTRY, country, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

     /**
     * @param city The text to enter in the city field.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object enterTravelDestinationCity(String city) {
        String result = setText(LO_EDT_TRAVEL_DESTINATION_CITY, city, (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"), false);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * @param fromDateOriginalTrip The from date to enter in the date field.
     * 
     * @return A string including [PASS] or [FAIL] along with specific resultdetails.
     */
    public Object enterFromDateOriginalTrip(String fromDateOriginalTrip) {
        String result = setText(LO_EDT_ORIGINAL_TRIP_DATE_FROM, fromDateOriginalTrip, (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"), false);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * @param fromDateOriginalTrip The from date to enter in the date field.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object enterToDateOriginalTrip(String toDateOriginalTrip) {
        String result = setText(LO_EDT_ORIGINAL_TRIP_DATE_TO, toDateOriginalTrip, (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"), false);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * @param tripPurchaseDate The from date to enter in the date field.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object enterTripPurchaseDate(String tripPurchaseDate) {
        String result = setText(LO_EDT_TRIP_PURCHASE_DATE, tripPurchaseDate, (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"), false);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Selects "Yes" to question "Are you the person causing the claim?"
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object selectYesToPersonCausingClaim() {
        String result = clickLocator(LO_RAD_PERSON_CAUSING_CLAIM, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Uploads the Accident Form.
     * 
     * @param filePath The relative path of the itinerary file from the user's home directory.
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object uploadAccidentForm(String filePath) {
        waitForDuration(10, "s", true); // Wait to perform next check
        String result = uploadFileV2(filePath, LO_UPLOAD_ACCIDENT_FORM);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Selects a country from dropdown menu : Where were you travelling from?.
     *
     * @param country The country to be selected.
     * 
     * @return A string containing the result of the operation.
     */
    public Object selectCountryTravellingFrom(String country) {
        String result = setDropdownAppian(LO_LST_COUNTRY_TRAVELLING_FROM, country, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /** 
     * @param city from dropdown menu : Where were you travelling from?.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object selectCityTravellingFrom(String city){
        String result = setText(LO_EDT_CITY_TRAVELLING_FROM, city, (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"), false);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Selects a country from dropdown menu : What was your travel destination?.
     *
     * @param country The country to be selected.
     * 
     * @return A string containing the result of the operation.
     */
    public Object selectCountryTravelDestination(String country) {
        String result = setDropdownAppian(LO_LST_COUNTRY_TRAVELLING_DESTINATION, country, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /** 
     * @param city from dropdown menu : What was your travel destination?.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object selectCityTravelDestination(String city){
        String result = setText(LO_EDT_CITY_TRAVELLING_DESTINATION, city, (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"), false);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Selects a country from dropdown menu : Where did the incident occur?.
     *
     * @param country The country to be selected.
     * 
     * @return A string containing the result of the operation.
     */
    public Object selectCountryWhereIncidentOccured(String country) {
        String result = setDropdownAppian(LO_LST_COUNTRY_WHERE_INCIDENT_OCCURED, country, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /** 
     * @param city from dropdown menu : What was your travel destination?.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object selectCityWhereIncidentOccured(String city){
        String result = setText(LO_EDT_CITY_WHERE_INCIDENT_OCCURED, city, (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"), false);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /** 
     * @param incidentDate The text to enter in the incident date field.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object enterIncidentDateH3(String incidentDate){
        String result = setText(LO_EDT_INCIDENT_DATE_OCCURANCE_H3, incidentDate, (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"), false);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * @param whenIncidentDateOccured The text to enter in the province/state field.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object enterProvince_State(String whenIncidentDateOccured){
        String result = setText(LO_EDT_PROVINCE_STATE, whenIncidentDateOccured, (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"), false);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /** 
     * @param countryInjuryOccurred  The country to be selected.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object selectCountryInjuryOccured(String countryInjuryOccurred){
        String result = setDropdownAppian(LO_LST_COUNTRY_INJURY_OCCURED, countryInjuryOccurred, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /** 
     * @param city The text to enter in the city field.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object selectCityInjuryOccured(String city){
        String result = setText(LO_LST_CITY_INJURY_OCCURED, city, (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"), false);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Select Canada from country dropdown.
     *
     * @param country The country injury occerd in.
     * 
     * @return A string containing the result of the operation.
     */
    public Object selectTravelDestinationCountryParagraph(String country) {
        String result = setDropdownAppian(LO_LST_TRAVEL_DESTINATION_COUNTRY_PARAGRAPH, country, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * @param city The text to enter in the city field.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object enterTravelDestinationCityParagraph(String city) {
        String result = setText(LO_LST_TRAVEL_DESTINATION_CITY_PARAGRAPH, city, (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"), false);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Enters the Arrival Date.
     * 
     * @param arrivalDate The date of birth to be entered.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object enterArrivalDate(String arrivalDate) {
        String result = setText(LO_EDT_ARRIVAL_DATE, arrivalDate, FW_ConfigMgr.getDefaultTimeout(), false);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Enters the Planned Departure Date.
     * 
     * @param plannedDepartureDate The date of birth to be entered.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object enterPlannedDepartureDate(String plannedDepartureDate) {
        String result = setText(LO_EDT_PLANNED_DEPARTURE_DATE, plannedDepartureDate, FW_ConfigMgr.getDefaultTimeout(), false);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

 // ======================= Page Object Support Methods =======================

    /**
     * Uploads a file to a web app.
     * 
     * @param filePath The relative path of the file from the user's home directory.
     * @param locator  The XPath of the file input element on the web page.
     * 
     * @return A string message indicating the success or failure of the file upload.
     */
    public String uploadFileV2(String filePath, String locator) {

        String currentDirectory = System.getProperty("user.dir");
        filePath = currentDirectory + "/src/test/resources/" + filePath;
        File file = new File(filePath);
        if (!file.exists()) {
            System.out.println("File " + filePath + " does not exist.");
            return "[Fail] - Expected the file path '" + filePath + "'' to be a valid file path.";
        }

        WebElement fileInput = driver.findElement(By.xpath(locator));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.visibility='visible';", fileInput);

        fileInput.sendKeys(filePath);
        return "[Pass] - Successfully uploaded the file '" + filePath + "'' into " + locator + ".";
    }

  /**
   * Validates if "Need to continue this claim later?" text exists.
   * 
   * @return A string including [PASS] or [FAIL] along with specific result details.
   */
    public Object validateNeedToContinueThisClaimLaterTextExists() {
        String result = validateLocatorExists(LO_TXT_NEED_TO_CONTINUE_THIS_CLAIM_LATER, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if "Save as Draft" button exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateSaveAsDraftButtonExists() {
        String result = validateLocatorExists(LO_TXT_SAVE_AS_DRAFT, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if "About the Event" paragraph exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateAboutTheEventParagraphExists() {
        String result = validateLocatorExists(LO_TXT_ABOUT_THE_EVENT_PARAGRAPH, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if "About the Event" second paragraph exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateAboutTheEventSecondParagraphExists() {
        String result = validateLocatorExists(LO_TXT_ABOUT_THE_EVENT_SECOND_PARAGRAPH, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Enters "Actual Travel Dates" to fill "What were your actual travel dates?"
     * 
     * @param actualTravelDates The actual travel dates to be entered.
     */
    public Object enterActualTravelDatesFrom(String actualTravelDates) {
        String result = setText(LO_EDT_ACUAL_TRAVEL_DATES_FROM, actualTravelDates, FW_ConfigMgr.getDefaultTimeout(), false);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Enters "Actual Travel Dates" to fill "What were your actual travel dates?"
     * 
     * @param actualTravelDates The actual travel dates to be entered.
     */
    public Object enterActualTravelDatesTo(String actualTravelDates) {
        String result = setText(LO_EDT_ACUAL_TRAVEL_DATES_TO, actualTravelDates, FW_ConfigMgr.getDefaultTimeout(), false);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

     public String validateClaimDetailsHeading() {
        String result = validateLocatorExists(LO_ABOUT_EVENT_PAGE_VERIFY_CLAIM_DETAILS, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if "Reason for claiming" text exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateReasonForClaimingTextExists() {
        String result = validateLocatorExists(LO_TXT_REASON_FOR_CLAIMING, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    }