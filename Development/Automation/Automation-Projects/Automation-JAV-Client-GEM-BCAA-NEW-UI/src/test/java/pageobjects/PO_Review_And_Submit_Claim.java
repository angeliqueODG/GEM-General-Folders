package pageobjects;

// Import class packages for this Page Object (PO)
import org.openqa.selenium.WebDriver;

import customizations.automation.CU_Appian; // Customization for Appian and where FW_Page is extended

import framework.junit.FW_TestStep;
import framework.utilities.FW_ConfigMgr;
import framework.utilities.FW_StringUtils;
import framework.utilities.FW_TestStepUtils;

public class PO_Review_And_Submit_Claim extends CU_Appian {

    private static final String LO_TXT_REVIEW_AND_SUBMIT_CLAIM_PAGE_VERIFY = "//h2/span[contains(text(), 'Review & Submit Claim')]";
    private static final String LO_BUT_REVIEW_AND_SUBMIT_PARAGRAPH = "//p[contains(text(),'Please review all the information about your claim before submitting it.')]";
    private static final String LO_BUT_SAVE_AS_DRAFT = "//span//span[contains(text(),'Save as Draft')]";
    private static final String LO_TXT_GLOBAL_INSURANCE_TYPE = "//div[div[div[div[div/p/strong[contains(text(),'Insurance Type')]]]]]";
    private static final String LO_TXT_GLOBAL_INSURANCE_TYPE_FOLLOWING_POLICY_NUMBER = "//div[div//strong[text()='Insurance Type'] and following-sibling::div[div//strong[text()='Policy Number/Certificate ID']]]";
    private static final String LO_TXT_GLOBAL_INSURANCE_TYPE_FOLLOWING_GROUP_NAME = "//div[div//strong[text()='Insurance Type'] and following-sibling::div[div//strong[text()='Group name']]]";
    private static final String LO_TXT_GLOBAL_FIRST_6_DIGITS = "//div[div//strong[text()='First 6 Digits']and following-sibling::div[div//strong[text()='Last 4 Digits']]]";
    private static final String LO_TXT_GLOBAL_LAST_4_DIGITS = "//div[div[div[div[div/p/strong[contains(text(),\"Last 4 Digits\")]]]]]";
    private static final String LO_TXT_GLOBAL_THE_INSURED = "//div[div[div[div[div/p/strong[contains(text(),'The Insured')]]]]]";
    private static final String LO_TXT_GLOBAL_OTHER_INSURED_PERSONS = "//div[div[div[div[div/p/strong[contains(text(),'Other Insured Person(s)')]]]]]";
    private static final String LO_TXT_GLOBAL_OTHER_INSURANCE_TYPE = "//div[div[div[div[div/p/strong[contains(text(),'Other Insurance Type')]]]]]";
    private static final String LO_TXT_GLOBAL_PREFERRED_METHOD_OF_COMMUNICATION = "//div[div[div//span[text()='Preferred Method of Communication']]/following-sibling::div[div//label[contains(text(), 'Email')]]]";
    private static final String LO_TXT_GLOBAL_DATE_OF_LOSS = "//div[div//strong[text()='Date of Loss'] and following-sibling::div[div//strong[text()='Trip Dates']]]";
    private static final String LO_TXT_GLOBAL_TRIP_DATES = "//div[div[div[div[div/p/strong[contains(text(),'Trip Dates')]]]]]";
    private static final String LO_TXT_GLOBAL_TRAVELLING_FROM = "//div[div[div[div[div/p/strong[contains(text(),'Travelling from')]]]]]";
    private static final String LO_TXT_GLOBAL_TRAVEL_DESTINATION = "//div[div//strong[text()='Travel destination'] and following-sibling::div[div//strong[text()='Incident happened at travel destination']]]";
    private static final String LO_TXT_GLOBAL_INCIDENT_HAPPENED_AT_TRAVEL_DESTINATION = "//div[div[div[div[div/p/strong[contains(text(),\"Incident happened at travel destination\")]]]]]";
    private static final String LO_TXT_GLOBAL_INCIDENT_LOCATION = "//div[div[div[div[div/p/strong[contains(text(),'Incident Location')]]]]]";
    private static final String LO_TXT_GLOBAL_PERSONAL_EFFECTS_IN_CUSTODY = "//div[div//strong[text()='Personal effects in custody(airline,bus,cruise)'] and following-sibling::div[div//strong[text()='Name of travel provider']]]";
    private static final String LO_TXT_GLOBAL_NAME_OF_TRAVEL_PROVIDER = "//div[div//strong[text()='Name of travel provider'] and following-sibling::div[div//strong[text()='Bags delayed']]]";
    private static final String LO_TXT_GLOBAL_BAGS_DELAYED = "//div[div//strong[text()='Bags delayed'] and following-sibling::div[div//strong[text()='Baggage(s) expected date']]]";
    private static final String LO_TXT_GLOBAL_BAGGAGE_EXPECTED_DATE = "//div[div//strong[text()='Baggage(s) expected date'] and following-sibling::div[div//strong[text()='Baggage(s) received date']]]";
    private static final String LO_TXT_GLOBAL_BAGGAGE_RECEIVED_DATE = "//div[div//strong[text()='Baggage(s) received date'] and following-sibling::div[div//strong[text()='Report filed date']]]";
    private static final String LO_TXT_GLOBAL_REPORT_FILED_DATE = "//div[div//strong[text()='Report filed date'] and following-sibling::div[div//strong[text()='What Happened?']]]";
    private static final String LO_TXT_GLOBAL_WHAT_HAPPENED = "//div[div[div[div[div/p/strong[contains(text(),'What Happened?')]]]]]";
    private static final String LO_TXT_GLOBAL_TYPE_OF_EXPENSE = "//div[div[div[div[div/p/strong[contains(text(),\"Type of Expense\")]]]]]";
    private static final String LO_TXT_GLOBAL_AMOUNT_PAID = "//div[div[div[div[div/p/strong[contains(text(),'Amount Paid (Equivalent in CAD)')]]]]]";
    private static final String LO_TXT_GLOBAL_REFUND_OBTAINED = "//div[div//strong[text()='Refund Obtained (Equivalent in CAD)'] and following-sibling::div[div//strong[text()='Total Amount of Expenses Claimed']]]";
    private static final String LO_TXT_GLOBAL_REFUND_OR_CREDIT_OBTAINED = "//div[div//strong[text()='Refund or Credit Obtained (Equivalent in CAD)'] and following-sibling::div[div//strong[text()='Total Amount of Expenses Claimed']]]";
    private static final String LO_TXT_GLOBAL_TOTAL_AMOUNT_OF_EXPENSES_CLAIMED = "//div[div[div[div[div/p/strong[contains(text(),\"Total Amount of Expenses Claimed\")]]]]]";
    private static final String LO_TXT_GLOBAL_TOTAL_AMOUNT_OF_EXPENSES_CLAIMED_REFUND_OR_CREDIT = "//div[div//strong[contains(text(), 'Total Amount of Expenses Claimed')] and preceding-sibling::div[div//strong[text()='Refund or Credit Obtained (Equivalent in CAD)']]]";
    private static final String LO_TXT_GLOBAL_TOTAL_AMOUNT_OF_EXPENSES_CLAIMED_WITHOUT_DOTS = "//div[div//strong[text()='Total Amount of Expenses Claimed'] and preceding-sibling::div[div//strong[text()='Refund Obtained (Equivalent in CAD)']]]";
    private static final String LO_TXT_GLOBAL_PREFERRED_METHOD_OF_PAYMENT_REIMBURSEMENT = "//div[div[div[div[div/p/strong[contains(text(),\"Preferred Method of Payment/Reimbursement\")]]]]]";
    private static final String LO_TXT_GLOBAL_MAILING_ADDRESS = "//div[div[div[div[div/p/strong[contains(text(),\"Mailing address same as home address provided under 'About yourself'\")]]]]]";
    private static final String LO_TXT_GLOBAL_REASON_FOR_DELAY = "//div[div//strong[text()='Reason for delay'] and following-sibling::div[div//strong[text()='Global Excel Claim Number']]]";
    private static final String LO_TXT_GLOBAL_GLOBAL_EXCEL_CLAIM_NUMBER = "//div[div[div[div[div/p/strong[contains(text(),\"Global Excel Claim Number\")]]]]]";
    private static final String LO_TXT_GLOBAL_WHEN_DID_THE_INCIDENT_OCCUR = "//div[div//strong[text()='When did the incident occur?'] and following-sibling::div[div//strong[text()='Travelling from']]]";
    private static final String LO_TXT_GLOBAL_WHEN_WAS_YOUR_SCHEDULED_DATE_AND_DEPARTURE_TIME = "//div[div//strong[text()='When was your scheduled date and departure time?'] and following-sibling::div[div//strong[text()='When was your actual date and departure time?']]]";
    private static final String LO_TXT_GLOBAL_WHEN_WAS_YOUR_ACTUAL_DATE_AND_DEPARTURE_TIME = "//div[div//strong[text()='When was your actual date and departure time?'] and following-sibling::div[div//strong[text()='Flight/Trip was delayed for: ']]]";
    private static final String LO_TXT_GLOBAL_FLIGHT_TRIP_WAS_DELAYED_FOR = "//div[div//strong[text()='Flight/Trip was delayed for: '] and following-sibling::div[div//strong[text()='Did your flight or trip delay cause you to miss a connection? ']]]";
    private static final String LO_TXT_GLOBAL_DID_YOUR_FLIGHT_OR_TRIP_DELAY_CAUSE_YOU_TO_MISS_A_CONNECTION = "//div[div//strong[text()='Did your flight or trip delay cause you to miss a connection? '] and following-sibling::div[div//strong[text()='What Happened?']]]";
    private static final String LO_TXT_GLOBAL_EMAIL_ADDRESS = "//div[div[div[div[div/p/strong[contains(text(),\"Email Address\")]]]]]";
    private static final String LO_TXT_GLOBAL_TRAVELLING_FROM_PRECEDING_INCIDENT_OCCURANCE = "//div[div//strong[text()='Travelling from'] and preceding-sibling::div[div//strong[text()='When did the incident occur?']]]";
    private static final String LO_TXT_GLOBAL_WHAT_HAPPENED_FOR_FLIGHT_DELAY = "//div[div//strong[text()='What Happened?']and preceding-sibling::div[div//strong[text()='Did your flight or trip delay cause you to miss a connection? ']]]";
    private static final String LO_TXT_GLOBAL_PREFERRED_METHOD_OF_PAYMENT_REIMBURSEMENT_ON_FLIGHT_DELAY = "//div[div[div[div[div/p/strong[contains(text(),\"Preferred Method of Payment/Reimbursement\")]]]]]";
    private static final String LO_TXT_GLOBAL_INCIDENT_DATE = "//div[div[div[div[div/p/strong[contains(text(),\"Incident Date\")]]]]]";
    private static final String LO_TXT_GLOBAL_NAME_OF_HOTEL_MOTEL = "//div[div//strong[text()='Name of Hotel/Motel:'] and following-sibling::div[div//strong[text()='Hotel/Motel Address is:']]]";
    private static final String LO_TXT_GLOBAL_HOTEL_MOTEL_ADDRESS = "//div[div//strong[text()='Hotel/Motel Address is:'] and following-sibling::div[div//strong[text()='What Happened?']]]";
    private static final String LO_TXT_GLOBAL_WHAT_HAPPENED_FOR_HOTEL = "//div[div[div[div[div/p/strong[contains(text(),'What Happened?')]]]]]";
    private static final String LO_TXT_GLOBAL_REASON_FOR_CLAIM = "//div[div//strong[text()='Reason for Claim'] and following-sibling::div[div//strong[text()='Global Excel Claim Number']]]";
    private static final String LO_TXT_GLOBAL_GLOBAL_INSURANCE_COMPANY = "//div[div//strong[text()='Insurance Company'] and following-sibling::div[div//strong[text()='Policy Number/Certificate ID']]]";
    private static final String LO_TXT_GLOBAL_POLICY_NUMBER_CERTIFICATE_ID = "//div[div[div[div[div/p/strong[contains(text(),'Policy Number/Certificate ID')]]]]]";
    private static final String LO_TXT_GLOBAL_GLOBAL_EXCEL_CLAIM_NUMBER_FOR_BAGGAGE_LOSS = "//div[div//strong[text()='Global Excel Claim Number'] and preceding-sibling::div[div//strong[text()='Reason for Claim']]]";
    private static final String LO_TXT_GLOBAL_INSURANCE_TYPE_FOR_BAGGAGE_LOSS = "//div[div//strong[text()='Insurance Type'] and following-sibling::div[div//strong[text()='Insurance Company']]]";
    private static final String LO_TXT_GLOBAL_INCIDENT_HAPPENED_AT_TRAVEL_DESTINATION_FOR_BAGGAGE_LOSS = "//div[div//strong[text()='Incident happened at travel destination'] and following-sibling::div[div//strong[text()='Personal effects in custody(airline,bus,cruise)']]]";
    private static final String LO_TXT_GLOBAL_PERSONAL_EFFECTS_IN_CUSTODY_FOR_BAGGAGE_LOSS = "//div[div//strong[text()='Personal effects in custody(airline,bus,cruise)'] and following-sibling::div[div//strong[text()='Report filed date']]]";
    private static final String LO_TXT_GLOBAL_MAIN_REASON_FOR_CANCELLING_YOUR_TRIP = "//div[div//strong[text()='Main Reason for Cancelling your Trip'] and following-sibling::div[div//strong[text()='Other due to']]]";
    private static final String LO_TXT_GLOBAL_OTHER_DUE_TO = "//div[div//strong[text()='Other due to'] and following-sibling::div[div//strong[text()='Global Excel Claim Number']]]";
    private static final String LO_TXT_GLOBAL_GLOBAL_EXCEL_CLAIM_NUMBER_FOR_PRECEDING_OTHER_DUE_TO = "//div[div//strong[text()='Global Excel Claim Number'] and preceding-sibling::div[div//strong[text()='Other due to']]]";
    private static final String LO_TXT_GLOBAL_TRIP_DATES_FOLLOWING_TRAVEL_DESTINATION = "//div[div//strong[text()='Trip Dates'] and following-sibling::div[div//strong[text()='Travel destination']]]";
    private static final String LO_TXT_GLOBAL_TRAVEL_DESTINATION_FOLLOWING_INCIDENT_DATE = "//div[div//strong[text()='Travel destination'] and following-sibling::div[div//strong[text()='Incident Date']]]";
    private static final String LO_TXT_GLOBAL_INCIDENT_DATE_FOLLOWING_CANCELLATION_DATE = "//div[div//strong[text()='Incident Date'] and following-sibling::div[div//strong[text()='Cancellation Date']]]";
    private static final String LO_TXT_GLOBAL_CANCELLATION_DATE_FOLLOWING_TRIP_PURCHASE_DATE = "//div[div//strong[text()='Cancellation Date'] and following-sibling::div[div//strong[text()='Trip Purchase Date']]]";
    private static final String LO_TXT_GLOBAL_TRIP_PURCHASE_DATE = "//div[div//strong[text()='Trip Purchase Date'] and following-sibling::div[div//strong[text()='What Happened?']]]";
    private static final String LO_TXT_GLOBAL_WHAT_HAPPENED_PREDEDING_TRIP_PURCHASE_DATE = "//div[div//strong[text()='What Happened?']and preceding-sibling::div[div//strong[text()='Trip Purchase Date']]]";
    private static final String LO_TXT_GLOBAL_ASSIGNMENT_OF_BENEFIT = "//div[div[div[div[div/p/strong[contains(text(),'Assignment of Benefit')]]]]]";
    private static final String LO_TXT_GLOBAL_GROUP_NAME = "//div[div//strong[text()='Group name'] and following-sibling::div[div//strong[text()='Policy Number/Certificate ID']]]";
    private static final String LO_TXT_GLOBAL_POLICY_REFUND_OBTAINED_EQUIVALENT_IN_CAD_WITH_SPACE = "//div[div[div[div[div/p/strong[contains(text(),\"Amount Paid (Equivalent in CAD)\")]]]]]";
    private static final String LO_TXT_GLOBAL_TOTAL_AMOUNT_OF_EXPENSES_CLAIMED_WITH_SPACE = "//div[div//strong[text()='Total Amount of Expenses Claimed '] and preceding-sibling::div[div//strong[text()='Refund Obtained (Equivalent in CAD)']]]";
    private static final String LO_TXT_GLOBAL_MAIN_REASON_FOR_CANCELLING_YOUR_TRIP_MEDICAL = "//div[div//strong[text()='Main Reason for Cancelling your Trip'] and following-sibling::div[div//strong[text()='Medical due to']]]";
    private static final String LO_TXT_GLOBAL_MEDICAL_DUE_TO = "//div[div//strong[text()='Medical due to'] and following-sibling::div[div//strong[text()='Global Excel Claim Number']]]";
    private static final String LO_TXT_GLOBAL_GLOBAL_EXCEL_CLAIM_NUMBER_FOR_PRECEDING_MEDICAL_DUE_TO = "//div[div//strong[text()='Global Excel Claim Number'] and preceding-sibling::div[div//strong[text()='Medical due to']]]";
    private static final String LO_TXT_GLOBAL_CLAIM_TYPE = "//div[div[div[div[div/p/strong[contains(text(),'Claim Type ')]]]]]";
    private static final String LO_TXT_GLOBAL_CLAIM_TYPE_FOLLOWING_GLOBAL_EXCEL_CLAIM_NUMBER = "//div[div//strong[text()='Claim Type '] and following-sibling::div[div//strong[text()='Global Excel Claim Number']]]";
    private static final String LO_TXT_GLOBAL_PROVINCE = "//div[div//strong[text()='Province'] and following-sibling::div[div//strong[text()='Global Excel Claim Number']]]";
    private static final String LO_TXT_GLOBAL_GLOBAL_EXCEL_CLAIM_NUMBER_PRECEDING_PROVINCE = "//div[div//strong[text()='Global Excel Claim Number'] and preceding-sibling::div[div//strong[text()='Province']]]";
    private static final String LO_TXT_GLOBAL_EMPLOYER_NAME = "//div[div[div[div[div/p/strong[contains(text(),'Employer Name')]]]]]";
    private static final String LO_TXT_GLOBAL_PROVINCIAL_HEALTH_CARD_NUMBER = "//div[div[div[div[div/p/strong[contains(text(),'Provincial Health Card Number')]]]]]";
    private static final String LO_TXT_GLOBAL_TRAVEL_DESTINATION_FOLLOWING_TRIP_DATES = "//div[div//strong[text()='Travel destination'] and following-sibling::div[div//strong[text()='Trip Dates']]]";
    private static final String LO_TXT_GLOBAL_TRIP_DATES_FOLLOWING_ORIGINAL_RETURN_DATE = "//div[div//strong[text()='Trip Dates'] and following-sibling::div[div//strong[text()='Original Return Date']]]";
    private static final String LO_TXT_GLOBAL_ORIGINAL_RETURN_DATE = "//div[div[div[div[div/p/strong[contains(text(),'Original Return Date')]]]]]";
    private static final String LO_TXT_GLOBAL_REASON_FOR_CONSULT = "//div[div[div[div[div/p/strong[contains(text(),'Reason for Consult')]]]]]";
    private static final String LO_TXT_GLOBAL_FIRST_DATE_OF_TREATMENT = "//div[div//strong[text()='First date of treatment'] and following-sibling::div[div//strong[text()='When did first symptoms appear?']]]";
    private static final String LO_TXT_GLOBAL_WHEN_DID_FIRST_SYMPTOMS_APPEAR = "//div[div//strong[text()='When did first symptoms appear?'] and following-sibling::div[div//strong[text()='What Happened?']]]";
    private static final String LO_TXT_GLOBAL_WHAT_HAPPENED_PRECEDING_WHEN_DID_FIRST_SYMPTOMS_APPEAR = "//div[div//strong[text()='What Happened?'] and preceding-sibling::div[div//strong[text()='When did first symptoms appear?']]]";
    private static final String LO_TXT_GLOBAL_EXPENSES = "//div[div[div[div[div/p/strong[contains(text(),'Expenses')]]]]]";
    private static final String LO_TXT_GLOBAL_EXPENSE_ITEM_1 = "//div[div[div[div[div/p/strong[contains(text(),'Expense')]]]]]";
    private static final String LO_TXT_GLOBAL_AMOUNT_BILLED_EQUIVALENT_IN_CAD = "//div[div[div[div[div/p/strong[contains(text(),'Amount Billed (Equivalent in CAD)')]]]]]";
    private static final String LO_TXT_GLOBAL_AMOUNT_PAID_EQUIVALENT_IN_CAD = "//div[div//strong[text()='Amount Paid (Equivalent in CAD)'] and following-sibling::div[div//strong[text()='Receipt Included']]]";
    private static final String LO_TXT_GLOBAL_RECEIPT_INCLUDED = "//div[div[div[div[div/p/strong[contains(text(),'Receipt Included')]]]]]";
    private static final String LO_TXT_GLOBAL_TOTAL_ESTIMATED_PAID_AMOUNT = "//div[div[div[div[div/p/strong[contains(text(),'Total Estimated Paid Amount (CAD)')]]]]]";
    private static final String LO_TXT_GLOBAL_INSURANCE_TYPE_FOLLOWING_EMPLOYER_NAME = "//div[div//strong[text()='Insurance Type'] and following-sibling::div[div//strong[text()='Employer Name']]]";
    private static final String LO_TXT_GLOBAL_PREFERRED_METHOD_OF_PAYMENT_REIMBURSEMENT_FOLLOWING_IS_THE_EMAIL_ADDRESS_THE_SAME = "//div[div//strong[text()='Preferred Method of Payment/Reimbursement'] and following-sibling::div[div//strong[text()=\"Is the email address the same as the Claimant's email address?\"]]]";
    private static final String LO_TXT_GLOBAL_IS_THE_EMAIL_ADDRESS_THE_SAME_AS_THE_CLAIMANTS_EMAIL_ADDRESS = "//div[div[div[div[div/p/strong[contains(text(),\"Is the email address the same as the Claimant's email address?\")]]]]]";
    private static final String LO_TXT_GLOBAL_GLOBAL_EXCEL_CLAIM_NUMBER_PRECEDING_CLAIM_TYPE = "//div[div//strong[text()='Global Excel Claim Number'] and preceding-sibling::div[div//strong[text()='Claim Type ']]]";
    private static final String LO_TXT_GLOBAL_COUNTRY_OF_ORIGIN = "//div[div//strong[text()='Country of Origin']and following-sibling::div[div//strong[text()='Trip Dates']]]";
    private static final String LO_TXT_GLOBAL_TEMPORARY_TRAVEL_DESTINATION = "//div[div//strong[text()='Temporary Travel Destination'] and following-sibling::div[div//strong[text()='Temporary Trip dates']]]";
    private static final String LO_TXT_GLOBAL_TEMPORARY_TRIP_DATES = "//div[div//strong[text()='Temporary Trip dates'] and following-sibling::div[div//strong[text()='Reason for Consult']]]";
    private static final String LO_TXT_GLOBAL_GLOBAL_EXCEL_CLAIM_NUMBER_FOLLOWING_ABOUT_YOUR_INSURANCE = "//div[div//strong[text()='Global Excel Claim Number'] and following-sibling::div[div//h3//span[text()='About Your Insurance']]]";
    private static final String LO_TXT_GLOBAL_CREDIT_CARD_TYPE = "//div[div//strong[text()='Credit Card Type'] and following-sibling::div[div//strong[text()='First 6 Digits']]]";
    private static final String LO_TXT_GLOBAL_ITEM_DESCRIPTION = "//div[div//strong[text()='Item Description: '] and following-sibling::div[div//strong[text()='Original Purchase Date:']]]";
    private static final String LO_TXT_GLOBAL_ORIGINAL_PURCHASE_DATE = "//div[div//strong[text()='Original Purchase Date:'] and following-sibling::div[div//strong[text()='Incident Date']]]";
    private static final String LO_TXT_GLOBAL_INCIDENT_DATE_FOLLOWING_DID_YOU_PAY_FOR_THE_ITEM_IN_MULTIPLE_INSTALLMENTS = "//div[div//strong[text()='Incident Date'] and following-sibling::div[div//strong[text()='Did you pay for the item in multiple installments?']]]";
    private static final String LO_TXT_GLOBAL_DID_YOU_PAY_FOR_THE_ITEM_IN_MULTIPLE_INSTALLMENTS = "//div[div//strong[text()='Did you pay for the item in multiple installments?'] and following-sibling::div[div//strong[text()='Manufacturer Name']]]";
    private static final String LO_TXT_GLOBAL_MANUFACTURER_NAME = "//div[div//strong[text()='Manufacturer Name'] and preceding-sibling::div[div//strong[text()='Did you pay for the item in multiple installments?']]]";
    private static final String LO_TXT_GLOBAL_DURATION_OF_MANUFACTURER_WARRANTY = "//div[div//strong[text()=\"Duration of Manufacturer's Warranty\"] and following-sibling::div[div//strong[text()='Serial Number ']]]";
    private static final String LO_TXT_GLOBAL_SERIAL_NUMBER = "//div[div//strong[text()='Serial Number '] and preceding-sibling::div[div//strong[text()=\"Duration of Manufacturer's Warranty\"]]]";
    private static final String LO_TXT_GLOBAL_THE_INSURED_FOLLOWING_OTHER_INSURANCE_TYPE = "//div[div//strong[text()='The Insured'] and preceding-sibling::div[div//strong[text()='Last 4 Digits']]] and //div[div//strong[text()='The Insured'] and following-sibling::div[div//strong[text()='Other Insurance Type']]]";
    private static final String LO_TXT_GLOBAL_OTHER_INSURANCE_TYPE_FOLLOWING_THE_INSURED = "//div[div//strong[text()='Other Insurance Type']and preceding-sibling::div[div//strong[text()='The Insured']]]";
    private static final String LO_TXT_GLOBAL_WHAT_HAPPENED_PRECEDING_SERIAL_NUMBER = "//div[div//strong[text()='What Happened?']and preceding-sibling::div[div//strong[text()='Serial Number ']]]";
    private static final String LO_TXT_GLOBAL_REFUND_OBTAINED_FOLLOWING_TOTAL_AMOUNT_OF_EXPENSES_CLAIMED = "//div[div//strong[text()='Refund Obtained (Equivalent in CAD)'] and following-sibling::div[div//strong[text()='Total Amount of Expenses Claimed: ']]]";
    private static final String LO_TXT_GLOBAL_REFUND_OBTAINED_FOLLOWING_TOTAL_AMOUNT_OF_EXPENSES_CLAIMED_WITHOUT_DOTS = "//div[div//strong[text()='Refund Obtained (Equivalent in CAD)'] and following-sibling::div[div//strong[text()='Total Amount of Expenses Claimed']]]";
    private static final String LO_TXT_GLOBAL_INCIDENT_HAPPENED_AT_TRAVEL_DESTINATION_PRECEDING_TRAVEL_DESTINATION = "//div[div//strong[text()='Incident happened at travel destination'] and preceding-sibling::div[div//strong[text()='Travel destination']]]";
    private static final String LO_TXT_GLOBAL_NAME_OF_TRAVEL_PROVIDER_FOLLOWING_REPORT_FILED_DATE = "//div[div//strong[text()='Name of travel provider'] and following-sibling::div[div//strong[text()='Report filed date']]]";
    private static final String LO_TXT_GLOBAL_REASON_FOR_LOSS = "//div[div//strong[text()='Reason for Loss: '] and following-sibling::div[div//strong[text()='Global Excel Claim Number']]]";
    private static final String LO_TXT_GLOBAL_GLOBAL_EXCEL_CLAIM_NUMBER_PRECEDING_REASON_FOR_LOSS = "//div[div//strong[text()='Global Excel Claim Number'] and preceding-sibling::div[div//strong[text()='Reason for Loss: ']]]";
    private static final String LO_TXT_GLOBAL_COUNTRY = "//div[div//strong[text()='Country'] and following-sibling::div[div//strong[text()='Province']]]";
    private static final String LO_TXT_GLOBAL_PROVINCE_FOLLOWING_CITY = "//div[div//strong[text()='Province'] and following-sibling::div[div//strong[text()='City']]]";
    private static final String LO_TXT_GLOBAL_CITY = "//div[div//strong[text()='City'] and preceding-sibling::div[div//strong[text()='Province']]]";
    private static final String LO_TXT_GLOBAL_WHAT_HAPPENED_PRECEDING_CITY = "//div[div//strong[text()='What Happened?']and preceding-sibling::div[div//strong[text()='City']]]";
    private static final String LO_TXT_GLOBAL_INCIDENT_DATE_FOLLOWING_COUNTRY = "//div[div//strong[text()='Incident Date'] and following-sibling::div[div//strong[text()='Country']]]";
    private static final String LO_TXT_GLOBAL_REASON_FOR_LOSS_WITH_SPACE = "//div[div//strong[text()='Reason for loss'] and following-sibling::div[div//strong[text()='Global Excel Claim Number']]]";
    private static final String LO_TXT_GLOBAL_GLOBAL_EXCEL_CLAIM_NUMBER_PRECEDING_REASON_FOR_LOSS_WITH_SPACE = "//div[div//strong[text()='Global Excel Claim Number'] and preceding-sibling::div[div//strong[text()='Reason for loss']]]";
    private static final String LO_TXT_GLOBAL_RENTAL_AGENCY_NAME = "//div[div//strong[text()='Rental Agency Name:'] and following-sibling::div[div//strong[text()='Was the full cost of the rental charged to your credit card?']]]";
    private static final String LO_TXT_GLOBAL_WAS_THE_FULL_COST_OF_THE_RENTAL_CHARGED_TO_YOUR_CREDIT_CARD = "//div[div//strong[text()='Was the full cost of the rental charged to your credit card?'] and following-sibling::div[div//strong[text()='Did you have another rental agreement within a 48h period from the start or the end of this current rental?']]]";
    private static final String LO_TXT_GLOBAL_DID_YOU_HAVE_ANOTHER_RENTAL_AGREEMENT_WITHIN_A_48H_PERIOD_FROM_THE_START_OR_THE_END_OF_THIS_CURRENT_RENTAL = "//div[div//strong[text()='Did you have another rental agreement within a 48h period from the start or the end of this current rental?'] and following-sibling::div[div//strong[text()='When did the incident occur?']]]";
    private static final String LO_TXT_GLOBAL_WHEN_DID_THE_INCIDENT_OCCUR_FOLLOWING_WAS_THE_POLICY_HOLDER_THE_DRIVER = "//div[div//strong[text()='When did the incident occur?'] and following-sibling::div[div//strong[text()='Was the Policyholder the driver at the time of incident? ']]]";
    private static final String LO_TXT_GLOBAL_WAS_THE_POLICY_HOLDER_THE_DRIVER_AT_THE_TIME_OF_INCIDENT = "//div[div//strong[text()='Was the Policyholder the driver at the time of incident? '] and following-sibling::div[div//strong[text()='Did the incident involve another vehicle? ']]]";
    private static final String LO_TXT_GLOBAL_DID_THE_INCIDENT_INVOLVE_ANOTHER_VEHICLE = "//div[div//strong[text()='Did the incident involve another vehicle? '] and following-sibling::div[div//strong[text()='What Happened?']]]";
    private static final String LO_TXT_GLOBAL_EMPLOYER_NAME_FOLLOWING_THE_INSURED = "//div[div//strong[text()='Employer Name'] and following-sibling::div[div//strong[text()='The Insured']]]";
    private static final String LO_TXT_GLOBAL_PLAN_NUMBER = "//div[div[div[div[div/p/strong[contains(text(),'Plan Number')]]]]]";
    private static final String LO_TXT_GLOBAL_THE_INSURED_FOLLOWING_OTHER_INSURED_PERSONS = "//div[div//strong[text()='The Insured'] and following-sibling::div[div//strong[text()='Other Insured Person(s)']]]";
    private static final String LO_TXT_GLOBAL_DESCRIPTION_OF_DAMAGE = "//div[div//strong[text()='Description of Damage :'] and following-sibling::div[div//strong[text()='What Happened?']]]";
    private static final String LO_TXT_GLOBAL_MAIN_REASON_FOR_INTERRUPTION = "//div[div//strong[text()='Main Reason for Interruption'] and following-sibling::div[div//strong[text()='Deceased Person Insurance']]]";
    private static final String LO_TXT_GLOBAL_DECEASED_PERSON_INSURANCE = "//div[div//strong[text()='Deceased Person Insurance'] and following-sibling::div[div//strong[text()='Global Excel Claim Number']]]";
    private static final String LO_TXT_GLOBAL_GLOBAL_EXCEL_CLAIM_NUMBER_PRECEDING_DECEASED_PERSON_INSURANCE = "//div[div//strong[text()='Global Excel Claim Number'] and preceding-sibling::div[div//strong[text()='Deceased Person Insurance']]]";
    private static final String LO_TXT_GLOBAL_WHAT_WERE_YOUR_ORIGINAL_TRIP_DATES = "//div[div//strong[text()='What were your original trip dates?'] and following-sibling::div[div//strong[text()='What Happened?']]]";
    private static final String LO_TXT_GLOBAL_INCIDENT_DATE_FOLLOWING_WHAT_HAPPENED = "//div[div//strong[text()='Incident Date'] and following-sibling::div[div//strong[text()='What Happened?']]]";
    private static final String LO_TXT_GLOBAL_WHAT_HAPPENED_PRECEDING_WHAT_WERE_YOUR_ORIGINAL_TRIP_DATES = "//div[div//strong[text()='What Happened?']and preceding-sibling::div[div//strong[text()='What were your original trip dates?']]]";
    private static final String LO_TXT_GLOBAL_CONTRACT_NUMBER = "//div[div//strong[text()='Contract Number'] and following-sibling::div[div//strong[text()='Member Certificate Number']]]";
    private static final String LO_TXT_GLOBAL_MEMBER_CERTIFICATE_NUMBER = "//div[div//strong[text()='Member Certificate Number'] and following-sibling::div[div//strong[text()='Plan Number']]]";
    private static final String LO_TXT_GLOBAL_INSURANCE_TYPE_FOLLOWING_EMPLOYER_GROUP_NAME = "//div[div//strong[text()='Insurance Type'] and following-sibling::div[div//strong[text()='Employer/Group Name ']]]";
    private static final String LO_TXT_GLOBAL_GROUP_NAME_PLAN_NUMBER = "//div[div//strong[text()='Group name'] and following-sibling::div[div//strong[text()='Plan Number']]]";
    private static final String LO_TXT_GLOBAL_EMPLOYER_GROUP_NAME = "//div[div//strong[text()='Employer/Group Name '] and following-sibling::div[div//strong[text()='Contract Number']]]";
    private static final String LO_TXT_GLOBAL_ARE_YOU_CURRENTLY_TRAVELLING = "//div[div//strong[text()='Are you currently travelling?'] and following-sibling::div[div//strong[text()='Travel destination']]]";
    private static final String LO_TXT_GLOBAL_DATE_OF_INJURY = "//div[div[div[div[div/p/strong[contains(text(),'Date of Injury')]]]]]";
    private static final String LO_TXT_GLOBAL_REASON_FOR_CONSULT_FOLLOWING_DATE_OF_INJURY = "//div[div//strong[text()='Reason for Consult'] and following-sibling::div[div//strong[text()='Date of Injury']]]";
    private static final String LO_TXT_GLOBAL_INCIDENT_LOCATION_FOLLOWING_WHAT_HAPPENED = "//div[div//strong[text()='Incident Location'] and following-sibling::div[div//strong[text()='What Happened?']]]";
    private static final String LO_TXT_GLOBAL_WHAT_HAPPENED_PRECEDING_INCIDENT_LOCATION = "//div[div//strong[text()='What Happened?'] and preceding-sibling::div[div//strong[text()='Incident Location']]]";
    private static final String LO_TXT_GLOBAL_EMPLOYER_NAME_FOLLOWING_PLAN_NUMBER = "//div[div//strong[text()='Employer Name'] and following-sibling::div[div//strong[text()='Plan Number']]]";
    private static final String LO_TXT_GLOBAL_THE_INSURED_FOLLOWING_OTHER_INSURANCE = "//div[div//strong[text()='The Insured']and following-sibling::div[div//strong[text()='Other Insurance Type']]]";
    private static final String LO_TXT_GLOBAL_MANUFACTURER_NAME_FOLLOWING_WHERE_DID_THE_INCIDENT_OCCUR = "//div[div//strong[text()='Manufacturer Name'] and following-sibling::div[div//strong[text()='Where did the incident occur? ']]]";
    private static final String LO_TXT_GLOBAL_WHERE_DID_THE_INCIDENT_OCCUR = "//div[div//strong[text()='Where did the incident occur? '] and following-sibling::div[div//strong[text()='Incident Date']]]";
    private static final String LO_TXT_GLOBAL_TRANSIT_NUMBER = "//div[div//strong[text()='Transit Number'] and following-sibling::div[div//strong[text()='Institution Number']]]";
    private static final String LO_TXT_GLOBAL_INSTITUTION_NUMBER = "//div[div//strong[text()='Institution Number'] and following-sibling::div[div//strong[text()='Account Number']]]";
    private static final String LO_TXT_GLOBAL_ACCOUNT_NUMBER = "//div[div//strong[text()='Account Number'] and preceding-sibling::div[div//strong[text()='Institution Number']]]";
    private static final String LO_TXT_GLOBAL_WHAT_HAPPENED_PRECEDING_INCIDENT_DATE = "//div[div//strong[text()='What Happened?']and preceding-sibling::div[div//strong[text()='Incident Date']]]";
    private static final String LO_TXT_GLOBAL_PREFERRED_METHOD_OF_PAYMENT_REIMBURSEMENT_FOLLOWING_TRANSIT_NUMBER = "//div[div//strong[text()='Preferred Method of Payment/Reimbursement'] and following-sibling::div[div//strong[text()='Transit Number']]]";
    private static final String LO_TXT_GLOBAL_TRAVELLING_FROM_FOLLOWING_WHEN_WAS_YOUR_SCHEDULED_DATE_AND_DEPARTURE_TIME = "//div[div//strong[text()='Travelling from'] and following-sibling::div[div//strong[text()='When was your scheduled date and departure time?']]]"; 
    private static final String LO_TXT_GLOBAL_MEMBER_ID = "//div[div//strong[text()='Member ID'] and following-sibling::div[div//strong[text()='The Insured']]]";
    private static final String LO_TXT_GLOBAL_CONTRACT_GROUP_NUMBER = "//div[div//strong[text()='Contract/Group Number'] and following-sibling::div[div//strong[text()='Member ID']]]";
    private static final String LO_TXT_GLOBAL_EMPLOYER_NAME_FOLLOWING_CONTRACT_GROUP_NUMBER = "//div[div//strong[text()='Employer Name'] and following-sibling::div[div//strong[text()='Contract/Group Number']]]";
    private static final String LO_TXT_GLOBAL_PREFERRED_METHOD_OF_PAYMENT_REIMBURSEMENT_FOLLOWING_IS_THE_EMAIL_ADDRESS_THE_SAME_AS_THE_CLAIMANTS_EMAIL_ADDRESS = "//div[div//strong[text()='Preferred Method of Payment/Reimbursement'] and following-sibling::div[div//strong[text()=\"Is the email address the same as the Claimant's email address?\"]]]";
    private static final String LO_TXT_GLOBAL_IS_THE_EMAIL_ADDRESS_THE_SAME_AS_THE_CLAIMANTS_EMAIL_ADDRESS_SYMBOL = "//div[div//strong[text()=\"Is the email address the same as the Claimant's email address?|\"] and following-sibling::div[div//strong[text()='Email Address']]]";
    private static final String LO_TXT_GLOBAL_EXPENSE_ITEM_1_FOLLOWING_TYPE_OF_EXPENSE = "//div[div//strong[text()='Expense Item 1'] and following-sibling::div[div//strong[text()='Type of Expense']]]";
    private static final String LO_TXT_GLOBAL_WHEN_DID_THE_INCIDENT_OCCUR_FOLLOWING_WHERE_DID_THE_INCIDENT_OCCUR = "//div[div//strong[text()='When did the incident occur?'] and following-sibling::div[div//strong[text()='Where did the incident occur? ']]]";
    private static final String LO_TXT_GLOBAL_WHERE_DID_THE_INCIDENT_OCCUR_FOLLOWING_WAS_THE_POLICYHOLDER_THE_DRIVER = "//div[div//strong[text()='Where did the incident occur? '] and following-sibling::div[div//strong[text()='Was the Policyholder the driver at the time of incident? ']]]";
    private static final String LO_TXT_GLOBAL_WHAT_HAPPENED_PRECEDING_DID_THE_INCIDENT_INVOLVE_ANOTHER_VEHICLE = "//div[div//strong[text()='What Happened?'] and preceding-sibling::div[div//strong[text()='Did the incident involve another vehicle? ']]]";
    private static final String LO_TXT_GLOBAL_PREFERRED_METHOD_OF_PAYMENT_REIMBURSEMENT_FOLLOWING_IS_THE_EMAIL_ADDRESS = "//div[div//strong[text()='Preferred Method of Payment/Reimbursement'] and following-sibling::div[div//strong[text()=\"Is the email address the same as the Claimant's email address?\"]]]";
    private static final String LO_TXT_GLOBAL_INSURANCE_TYPE_FOLLOWING_EMPLOYEE_NAME = "//div[div//strong[text()='Insurance Type'] and following-sibling::div[div//strong[text()='Employer Name']]]";
    private static final String LO_TXT_GLOBAL_EMPLOYEE_NAME_PLAN_NUMBER = "//div[div//strong[text()='Employer Name'] and following-sibling::div[div//strong[text()='Plan Number']]]";
    private static final String LO_TXT_TRAVEL_STATUS_AND_INTERRUPTION_REASON = "//h3//span[contains(text(),'Travel Status & Interruption Reason')]";
    private static final String LO_TXT_ABOUT_YOUR_INSURANCE = "//h3//span[contains(text(),'About Your Insurance')]";
    private static final String LO_BUT_EDIT = "//strong[contains(text(),'EDIT')]";
    private static final String LO_TXT_EMPLOYEE_MEMBER_ID = "//div[div[div[div[div/p/strong[contains(text(),'Employee/Member ID')]]]]]";
    private static final String LO_TXT_CONTACT_INFORMATION = "//h3//span[contains(text(),'Contact Information')]";
    private static final String LO_TXT_ABOUT_THE_EVENT = "//h3//span[contains(text(),'About the Event')]";
    private static final String LO_TXT_INCURRED_EXPENSES = "//h3//span[contains(text(),'Incurred Expenses')]";
    private static final String LO_TXT_REIMBURSED_DETAILS = "//h3//span[contains(text(),'Reimbursement Details')]";
    private static final String LO_TXT_GLOBAL_EXPENSE_ITEM_1_INTACT = "//div[div[div[div[div/p//strong[contains(text(),\"Expense Item 1\")]]]]]";
    private static final String LO_LBL_DELAYED_BAGGAGE = "//h3/span[contains(text(), 'Delayed Baggage')]";
    private static final String LO_TXT_CLAIMANTS_RELATIONSHIP_WITH_POLICY_HOLDER = "//div[div[div[div[div/p/strong[contains(text(),\"Claimant's Relationship with Policy holder\")]]]]]";
    private static final String LO_TXT_HOME_ADDRESS_OF_POLICY_HOLDER = "//div[div[div[div[div/p/strong[contains(text(),\"Home Address of Policy holder (in Canada)\")]]]]]";
    public static final String LO_TXT_OTHER_INSURED_PERSONS_RELATIONSHIP_WITH_POLICY_HOLDER = "//div[div[div[div[div/p/strong[contains(text(),\"Other Insured Person`s Relationship with Policy holder\")]]]]]";
    public static final String LO_TXT_FIRST_NAME = "//div[div[div[div[div/p/strong[contains(text(),'First Name')]]]]]";
    public static final String LO_TXT_LAST_NAME = "//div[div[div[div[div/p/strong[contains(text(),'Last Name')]]]]]";
    public static final String LO_TXT_DATE_OF_BIRTH = "//div[div[div[div[div/p/strong[contains(text(),'Date of Birth')]]]]]";
    public static final String LO_TXT_WHAT_TYPE_OF_TRAVEL_INSURANCE_DO_YOU_HAVE = "//div[div[div[div[div/p/strong[contains(text(),'What type of travel insurance do you have?')]]]]]";
    public static final String LO_TXT_CARD_ISSUER_NAME = "//div[div[div[div[div/p/strong[contains(text(),'Card issuer name')]]]]]";
    public static final String LO_TXT_DATE_OF_LOSS = "//div[div[div[div[div/p/strong[contains(text(),'Date of Loss')]]]]]";
    public static final String LO_TXT_MAILING_ADDRESS = "(//div[div[div[div[div/p/strong[contains(text(),\"Mailing address\")]]]]])[2]";

    /**
     * Define the Page Object (PO) constructor.
     * 
     * @param driver The WebDriver object passed from the test method.
     */
    public PO_Review_And_Submit_Claim(WebDriver driver) {
        super(driver);
    }

    /**
     * Scrolls at a given locator.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object scrollTop() {
        String result = scrollToLocator(LO_TXT_REVIEW_AND_SUBMIT_CLAIM_PAGE_VERIFY);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if current webpage is loaded and correct.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateOnPage() {
        String result = validateLocatorExists(LO_TXT_REVIEW_AND_SUBMIT_CLAIM_PAGE_VERIFY, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

     /**
     * Validates Insurance type provided is correct.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object verifyInsuranceType(String insuranceType) {
        String result = validateWithinLocatorText(LO_TXT_GLOBAL_INSURANCE_TYPE,insuranceType ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Click "Save As Draft" button.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object clickSaveAsDraftButton() {
        String result = clickLocator(LO_BUT_SAVE_AS_DRAFT, 30000);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;

    }

    /**
     * Validates If the First 6 Digits of the credit card number entered is correct.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object verifyFirst6Digits(String first6Digits) {
        String result = validateWithinLocatorText(LO_TXT_GLOBAL_FIRST_6_DIGITS,first6Digits ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates If the Last 4 Digits of the credit card number entered is correct.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object verifyLast4Digits(String last4Digits) {
        String result = validateWithinLocatorText(LO_TXT_GLOBAL_LAST_4_DIGITS,last4Digits ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates If the Insured information entered is correct.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object verifyTheInsured(String insured) {
        String result = validateWithinLocatorText(LO_TXT_GLOBAL_THE_INSURED,insured ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates If Other Insured Persons is correct.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object verifyOtherInsuredPersons(String otherInsuredPersons) {
        String result = validateWithinLocatorText(LO_TXT_GLOBAL_OTHER_INSURED_PERSONS,otherInsuredPersons ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates If Other Insurance Type selection is Yes or No.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object verifyOtherInsuranceType(String otherInsuranceType) {
        String result = validateWithinLocatorText(LO_TXT_GLOBAL_OTHER_INSURANCE_TYPE,otherInsuranceType ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates If the preferred method of communication is correct.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object verifyPreferredMethodOfCommunication(String preferredMethodOfCommunication) {
        String result = validateWithinLocatorText(LO_TXT_GLOBAL_PREFERRED_METHOD_OF_COMMUNICATION,preferredMethodOfCommunication ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates If Date of loss is correct.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object verifyDateOfLoss(String dateOfLoss) {
        String result = validateWithinLocatorText(LO_TXT_GLOBAL_DATE_OF_LOSS,dateOfLoss ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates If Trip Dates entered are correct.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object verifyTripDates(String tripDates) {
        String result = validateWithinLocatorText(LO_TXT_GLOBAL_TRIP_DATES,tripDates ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates If "Travelling From" place entered is correct.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object verifyTravellingFrom(String travellingFrom) {
        String result = validateWithinLocatorText(LO_TXT_GLOBAL_TRAVELLING_FROM,travellingFrom ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates If "Travel Destination" place entered is correct.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object verifyTravelDestination(String travelDestination) {
        String result = validateWithinLocatorText(LO_TXT_GLOBAL_TRAVEL_DESTINATION,travelDestination ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates If "Incident happened at travel destination".
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object verifyIncidentHappenedAtTravelDestination(String incidentHappenedAtTravelDestination) {
        String result = validateWithinLocatorText(LO_TXT_GLOBAL_INCIDENT_HAPPENED_AT_TRAVEL_DESTINATION,incidentHappenedAtTravelDestination ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates If "Incident location" entered is correct.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object verifyIncidentLocation(String incidentLocation) {
        String result = validateWithinLocatorText(LO_TXT_GLOBAL_INCIDENT_LOCATION,incidentLocation ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates If there were Personal effects in custody(airline,bus,cruise). Yes or No
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object verifyPersonalEffectsInCustody(String yesToPersonalEffectsInCustody) {
        String result = validateWithinLocatorText(LO_TXT_GLOBAL_PERSONAL_EFFECTS_IN_CUSTODY,yesToPersonalEffectsInCustody ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates If "Name of Travel Provider" entered is correct.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object verifyNameOfTravelProvider(String nameOfTravelProvider) {
        String result = validateWithinLocatorText(LO_TXT_GLOBAL_NAME_OF_TRAVEL_PROVIDER,nameOfTravelProvider ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates If "Bags Delayed" number is displayed correcty.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object verifyBagsDelayed(String bagsDelayed) {
        String result = validateWithinLocatorText(LO_TXT_GLOBAL_BAGS_DELAYED,bagsDelayed ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates If "Baggage(s) expected date" is displayed correcty.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object verifyBagsExpectedDate(String bagsExpectedDate) {
        String result = validateWithinLocatorText(LO_TXT_GLOBAL_BAGGAGE_EXPECTED_DATE,bagsExpectedDate ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates If "Baggage(s) received date" is displayed correcty.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object verifyBagsReceivedDate(String bagsReceivedDate) {
        String result = validateWithinLocatorText(LO_TXT_GLOBAL_BAGGAGE_RECEIVED_DATE,bagsReceivedDate ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates If "Report filed date" is displayed correcty.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object verifyReportFiledDate(String reportFiledDate) {
        String result = validateWithinLocatorText(LO_TXT_GLOBAL_REPORT_FILED_DATE,reportFiledDate ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates If "What Happened?" entered is correct.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object verifyWhatHappened(String whatHappened) {
        String result = validateWithinLocatorText(LO_TXT_GLOBAL_WHAT_HAPPENED,whatHappened ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if "Type of Expense" entered is correct
     * 
     * @return AA string including [PASS] or [FAIL] along with specific result details.
     */
    public Object verifyTypeOfExpense(String typeOfExpense) {
        String result = validateWithinLocatorText(LO_TXT_GLOBAL_TYPE_OF_EXPENSE,typeOfExpense ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if "Amount Paid" entered is correct
     * 
     * @return AA string including [PASS] or [FAIL] along with specific result details.
     */
    public Object verifyAmountPaid(String amountPaid) {
        String result = validateWithinLocatorText(LO_TXT_GLOBAL_AMOUNT_PAID,amountPaid ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if "Refund Obtained" entered is correct
     * 
     * @return AA string including [PASS] or [FAIL] along with specific result details.
     */
    public Object verifyRefundObtained(String refundObtained) {
        String result = validateWithinLocatorText(LO_TXT_GLOBAL_REFUND_OBTAINED,refundObtained ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object verifyRefundOrCreditObtained(String refundObtained) {
        String result = validateWithinLocatorText(LO_TXT_GLOBAL_REFUND_OR_CREDIT_OBTAINED,refundObtained ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if "Total Amount of Expenses Claimed" entered is correct
     * 
     * @return AA string including [PASS] or [FAIL] along with specific result details.
     */
    public Object verifyTotalAmountOfExpensesClaimed(String totalAmountOfExpensesClaimed) {
        String result = validateWithinLocatorText(LO_TXT_GLOBAL_TOTAL_AMOUNT_OF_EXPENSES_CLAIMED,totalAmountOfExpensesClaimed ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if "Preferred Method of Payment/Reimbursement" entered is correct
     * 
     * @return AA string including [PASS] or [FAIL] along with specific result details.
     */
    public Object verifyPreferredMethodOfPaymentReimbursement(String preferredMethodOfPaymentReimbursement) {
        String result = validateWithinLocatorText(LO_TXT_GLOBAL_PREFERRED_METHOD_OF_PAYMENT_REIMBURSEMENT,preferredMethodOfPaymentReimbursement ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if "Mailing Address" entered is correct
     * 
     * @return AA string including [PASS] or [FAIL] along with specific result details.
     */
    public Object verifyMailingAddressSameAsHomeAddress(String mailingAddress) {
        String result = validateWithinLocatorText(LO_TXT_GLOBAL_MAILING_ADDRESS,mailingAddress ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if "Reason for delay" entered is correct
     * 
     * @return AA string including [PASS] or [FAIL] along with specific result details.
     */
    public Object verifyReasonForDelay(String reasonForDelay) {
        String result = validateWithinLocatorText(LO_TXT_GLOBAL_REASON_FOR_DELAY,reasonForDelay ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if "Global Excel Claim Number" entered is correct
     * 
     * @return AA string including [PASS] or [FAIL] along with specific result details.
     */
    public Object verifyGlobalExcelClaimNumber(String globalExcelClaimNumber) {
        String result = validateWithinLocatorText(LO_TXT_GLOBAL_GLOBAL_EXCEL_CLAIM_NUMBER,globalExcelClaimNumber ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if "When did the incident occur?" entered is correct
     * 
     * @return AA string including [PASS] or [FAIL] along with specific result details.
     */
    public Object verifyWhenDidTheIncidentOccur(String whenDidTheIncidentOccur) {
        String result = validateWithinLocatorText(LO_TXT_GLOBAL_WHEN_DID_THE_INCIDENT_OCCUR,whenDidTheIncidentOccur ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if "When was your scheduled date and departure time?" entered is correct
     * 
     * @return AA string including [PASS] or [FAIL] along with specific result details.
     */
    public Object verifyWhenWasYourScheduledDateAndDepartureTime(String whenWasYourScheduledDateAndDepartureTime) {
        String result = validateWithinLocatorText(LO_TXT_GLOBAL_WHEN_WAS_YOUR_SCHEDULED_DATE_AND_DEPARTURE_TIME,whenWasYourScheduledDateAndDepartureTime ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if "When was your actual date and departure time?" entered is correct
     * 
     * @return AA string including [PASS] or [FAIL] along with specific result details.
     */
    public Object verifyWhenWasYourActualDateAndDepartureTime(String whenWasYourActualDateAndDepartureTime) {
        String result = validateWithinLocatorText(LO_TXT_GLOBAL_WHEN_WAS_YOUR_ACTUAL_DATE_AND_DEPARTURE_TIME,whenWasYourActualDateAndDepartureTime ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if "Flight/Trip was delayed for: " entered is correct
     * 
     * @return AA string including [PASS] or [FAIL] along with specific result details.
     */
    public Object verifyFlightTripWasDelayedFor(String flightTripWasDelayedFor) {
        String result = validateWithinLocatorText(LO_TXT_GLOBAL_FLIGHT_TRIP_WAS_DELAYED_FOR,flightTripWasDelayedFor ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if "Did your flight or trip delay cause you to miss a connection?" entered is correct
     * 
     * @return AA string including [PASS] or [FAIL] along with specific result details.
     */
    public Object verifyDidYourFlightOrTripDelayCauseYouToMissAConnection(String didYourFlightOrTripDelayCauseYouToMissAConnection) {
        String result = validateWithinLocatorText(LO_TXT_GLOBAL_DID_YOUR_FLIGHT_OR_TRIP_DELAY_CAUSE_YOU_TO_MISS_A_CONNECTION,didYourFlightOrTripDelayCauseYouToMissAConnection ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if "Email Address" entered is correct.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object verifyEmailAddress(String emailAddress) {
        String result = validateWithinLocatorText(LO_TXT_GLOBAL_EMAIL_ADDRESS,emailAddress ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if "Travelling from" entered is correct.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object verifyTravellingFromPrecedingIncidentOccurance(String travellingFromPrecedingIncidentOccurance) {
        String result = validateWithinLocatorText(LO_TXT_GLOBAL_TRAVELLING_FROM_PRECEDING_INCIDENT_OCCURANCE,travellingFromPrecedingIncidentOccurance ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if "What Happened?" for flight delay was entered is correct.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object verifyWhatHappenedForFlightDelay(String whatHappenedForFlightDelay) {
        String result = validateWithinLocatorText(LO_TXT_GLOBAL_WHAT_HAPPENED_FOR_FLIGHT_DELAY,whatHappenedForFlightDelay ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if "Preferred Method of Payment/Reimbursement" for flight delay was entered is correct.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object verifyPreferredMethodOfPaymentOnFlightDelay(String preferredMethodOfPaymentOnFlightDelay) {
        String result = validateWithinLocatorText(LO_TXT_GLOBAL_PREFERRED_METHOD_OF_PAYMENT_REIMBURSEMENT_ON_FLIGHT_DELAY,preferredMethodOfPaymentOnFlightDelay ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
    * Validates if "Incident Date" entered is correct.
    * 
    * @return A string including [PASS] or [FAIL] along with specific result details.
    */
    public Object verifyIncidentDate(String incidentDate) {
        String result = validateWithinLocatorText(LO_TXT_GLOBAL_INCIDENT_DATE,incidentDate ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
    * Validates if "Name of Hotel/Motel" entered is correct.
    *
    * @return A string including [PASS] or [FAIL] along with specific result details.
    */
    public Object verifyNameOfHotelMotel(String nameOfHotelMotel) {
        String result = validateWithinLocatorText(LO_TXT_GLOBAL_NAME_OF_HOTEL_MOTEL,nameOfHotelMotel ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
    * Validates if "Hotel/Motel Address is" entered is correct.
    *
    * @return A string including [PASS] or [FAIL] along with specific result details.
    */
    public Object verifyHotelMotelAddress(String hotelMotelAddress) {
        String result = validateWithinLocatorText(LO_TXT_GLOBAL_HOTEL_MOTEL_ADDRESS,hotelMotelAddress ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
    * Validates if "What Happened?" for Hotel/Motel entered is correct.
    *
    * @return A string including [PASS] or [FAIL] along with specific result details.
    */
    public Object verifyWhatHappenedForHotel(String whatHappenedForHotel) {
        String result = validateWithinLocatorText(LO_TXT_GLOBAL_WHAT_HAPPENED_FOR_HOTEL,whatHappenedForHotel ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
    * Validates if "Reason for Claim" entered is correct.
    *
    * @return A string including [PASS] or [FAIL] along with specific result details.
    */
    public Object verifyReasonForClaim(String reasonForClaim) {
        String result = validateWithinLocatorText(LO_TXT_GLOBAL_REASON_FOR_CLAIM,reasonForClaim ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
    * Validates if "Insurance Company" entered is correct.
    *
    * @return A string including [PASS] or [FAIL] along with specific result details.
    */
    public Object verifyInsuranceCompany(String insuranceCompany) {
        String result = validateWithinLocatorText(LO_TXT_GLOBAL_GLOBAL_INSURANCE_COMPANY,insuranceCompany ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
    * Validates if "Policy Number/Certificate ID" entered is correct.
    *
    * @return A string including [PASS] or [FAIL] along with specific result details.
    */
    public Object verifyPolicyNumberCertificateID(String policyNumberCertificateID) {
        String result = validateWithinLocatorText(LO_TXT_GLOBAL_POLICY_NUMBER_CERTIFICATE_ID,policyNumberCertificateID ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
    * Validates if "Global Excel Claim Number" for Baggage Loss entered is correct.
    *
    * @return A string including [PASS] or [FAIL] along with specific result details.
    */
    public Object verifyGlobalExcelClaimNumberForBaggageLoss(String globalExcelClaimNumberForBaggageLoss) {
        String result = validateWithinLocatorText(LO_TXT_GLOBAL_GLOBAL_EXCEL_CLAIM_NUMBER_FOR_BAGGAGE_LOSS,globalExcelClaimNumberForBaggageLoss ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
    * Validates if "Insurance Type" for Baggage Loss entered is correct.
    *
    * @return A string including [PASS] or [FAIL] along with specific result details.
    */
    public Object verifyInsuranceTypeForBaggageLoss(String insuranceTypeForBaggageLoss) {
        String result = validateWithinLocatorText(LO_TXT_GLOBAL_INSURANCE_TYPE_FOR_BAGGAGE_LOSS,insuranceTypeForBaggageLoss ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
    * Validates if "Incident happened at travel destination" for Baggage Loss entered is correct.
    *
    * @return A string including [PASS] or [FAIL] along with specific result details.
    */
    public Object verifyIncidentHappenedAtTravelDestinationForBaggageLoss(String incidentHappenedAtTravelDestinationForBaggageLoss) {
        String result = validateWithinLocatorText(LO_TXT_GLOBAL_INCIDENT_HAPPENED_AT_TRAVEL_DESTINATION_FOR_BAGGAGE_LOSS,incidentHappenedAtTravelDestinationForBaggageLoss ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
    * Validates if "Personal effects in custody(airline,bus,cruise)" for Baggage Loss entered is correct.
    *
    * @return A string including [PASS] or [FAIL] along with specific result details.
    */
    public Object verifyPersonalEffectsInCustodyForBaggageLoss(String personalEffectsInCustodyForBaggageLoss) {
        String result = validateWithinLocatorText(LO_TXT_GLOBAL_PERSONAL_EFFECTS_IN_CUSTODY_FOR_BAGGAGE_LOSS,personalEffectsInCustodyForBaggageLoss ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
    * Validates if "Main Reason for Cancelling your Trip" entered is correct.
    *
    * @return A string including [PASS] or [FAIL] along with specific result details.
    */
    public Object verifyMainReasonForCancellingYourTrip(String mainReasonForCancellingYourTrip) {
        String result = validateWithinLocatorText(LO_TXT_GLOBAL_MAIN_REASON_FOR_CANCELLING_YOUR_TRIP,mainReasonForCancellingYourTrip ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
    * Validates if "Other due to" entered is correct.
    *
    * @return A string including [PASS] or [FAIL] along with specific result details.
    */
    public Object verifyOtherDueTo(String otherDueTo) {
        String result = validateWithinLocatorText(LO_TXT_GLOBAL_OTHER_DUE_TO,otherDueTo ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
    * Validates if "Global Excel Claim Number" for preceding "Other due to" entered is correct.
    *
    * @return A string including [PASS] or [FAIL] along with specific result details.
    */
    public Object verifyGlobalExcelClaimNumberForPrecedingOtherDueTo(String globalExcelClaimNumberForPrecedingOtherDueTo) {
        String result = validateWithinLocatorText(LO_TXT_GLOBAL_GLOBAL_EXCEL_CLAIM_NUMBER_FOR_PRECEDING_OTHER_DUE_TO,globalExcelClaimNumberForPrecedingOtherDueTo ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
    * Validates if "Trip Dates" for following travel destination entered is correct.
    *
    * @return A string including [PASS] or [FAIL] along with specific result details.
    */
    public Object verifyTripDatesFollowingTravelDestination(String tripDatesForAmexExploratory) {
        String result = validateWithinLocatorText(LO_TXT_GLOBAL_TRIP_DATES_FOLLOWING_TRAVEL_DESTINATION,tripDatesForAmexExploratory ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
    * Validates if "Travel destination" Following Incident Date entered is correct.
    *
    * @return A string including [PASS] or [FAIL] along with specific result details.
    */
    public Object verifyTravelDestinationFollowingIncidentDate(String travelDestinationFollowingIncidentDate) {
        String result = validateWithinLocatorText(LO_TXT_GLOBAL_TRAVEL_DESTINATION_FOLLOWING_INCIDENT_DATE,travelDestinationFollowingIncidentDate ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
    * Validates if "Incident Date" for Amex Exploratory entered is correct.
    *
    * @return A string including [PASS] or [FAIL] along with specific result details.
    */
    public Object verifyIncidentDateFollowingCancellationDate(String incidentDateFollowingCancellationDate) {
        String result = validateWithinLocatorText(LO_TXT_GLOBAL_INCIDENT_DATE_FOLLOWING_CANCELLATION_DATE,incidentDateFollowingCancellationDate ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
    * Validates if "Cancellation Date" for Amex Exploratory entered is correct.
    *
    * @return A string including [PASS] or [FAIL] along with specific result details.
    */
    public Object verifyCancellationDateFollowingTripPurchaseDate(String cancellationDateFollowingTripPurchaseDate) {
        String result = validateWithinLocatorText(LO_TXT_GLOBAL_CANCELLATION_DATE_FOLLOWING_TRIP_PURCHASE_DATE,cancellationDateFollowingTripPurchaseDate ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
    * Validates if "Trip Purchase Date" entered is correct.
    *
    * @return A string including [PASS] or [FAIL] along with specific result details.
    */
    public Object verifyTripPurchaseDate(String tripPurchaseDate) {
        String result = validateWithinLocatorText(LO_TXT_GLOBAL_TRIP_PURCHASE_DATE,tripPurchaseDate ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
    * Validates if "What Happened" for Amex Exploratory entered is correct.
    *
    * @return A string including [PASS] or [FAIL] along with specific result details.
    */
    public Object verifyWhatHappenedPrecedingTripPurchaseDate(String whatHappenedForAmexExploratory) {
        String result = validateWithinLocatorText(LO_TXT_GLOBAL_WHAT_HAPPENED_PREDEDING_TRIP_PURCHASE_DATE,whatHappenedForAmexExploratory ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
    * Validates if "Insurance Type" following policy number entered is correct.
    *
    * @return A string including [PASS] or [FAIL] along with specific result details.
    */
    public Object verifyInsuranceTypeFollowingPolicyNumber(String insuranceTypeFollowingPolicyNumber) {
        String result = validateWithinLocatorText(LO_TXT_GLOBAL_INSURANCE_TYPE_FOLLOWING_POLICY_NUMBER,insuranceTypeFollowingPolicyNumber ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
    * Validates if "Assignment of benefit" entered is correct.
    
    * @return A string including [PASS] or [FAIL] along with specific result details.
    */
    public Object verifyAssignmentOfBenefit(String assignmentOfBenefit) {
        String result = validateWithinLocatorText(LO_TXT_GLOBAL_ASSIGNMENT_OF_BENEFIT,assignmentOfBenefit ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
    * Validates if "Group name" entered is correct.
    *
    * @return A string including [PASS] or [FAIL] along with specific result details.
    */
    public Object verifyGroupName(String groupName) {
        String result = validateWithinLocatorText(LO_TXT_GLOBAL_GROUP_NAME,groupName ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
    * Validates if "Insurance Type" following Group Name entered is correct.
    *
    * @return A string including [PASS] or [FAIL] along with specific result details.
    */
    public Object verifyInsuranceTypeFollowingGroupName(String insuranceTypeFollowingGroupName) {
        String result = validateWithinLocatorText(LO_TXT_GLOBAL_INSURANCE_TYPE_FOLLOWING_GROUP_NAME,insuranceTypeFollowingGroupName ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
    * Validates if "Refund Obtained (Equivalent in CAD)" for Amex Exploratory entered is correct.
    *
    * @return A string including [PASS] or [FAIL] along with specific result details.
    */
    public Object verifyRefundObtainedWithSpace(String refundObtainedEquivalentInCAD) {
        String result = validateWithinLocatorText(LO_TXT_GLOBAL_POLICY_REFUND_OBTAINED_EQUIVALENT_IN_CAD_WITH_SPACE,refundObtainedEquivalentInCAD ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
    * Validates if "Total Amount of Expenses obtained" with space entered is correct.
    *
    * @return A string including [PASS] or [FAIL] along with specific result details.
    */
    public Object verifyTotalAmountOfExpensesObtainedWithSpace(String totalAmountOfExpensesObtainedWithSpace) {
        String result = validateWithinLocatorText(LO_TXT_GLOBAL_TOTAL_AMOUNT_OF_EXPENSES_CLAIMED_WITH_SPACE,totalAmountOfExpensesObtainedWithSpace ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
    * Validates if "Main Reason for cancelling your trip" medical entered is correct.
    *
    * @return A string including [PASS] or [FAIL] along with specific result details.
    */
    public Object verifyMainReasonForCancellingYourTripMedical(String mainReasonForCancellingYourTripMedical) {
        String result = validateWithinLocatorText(LO_TXT_GLOBAL_MAIN_REASON_FOR_CANCELLING_YOUR_TRIP_MEDICAL,mainReasonForCancellingYourTripMedical ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
    * Validates if "Medical due to" entered is correct.
    *
    * @return A string including [PASS] or [FAIL] along with specific result details.
    */
    public Object verifyMedicalDueTo(String medicalDueTo) {
        String result = validateWithinLocatorText(LO_TXT_GLOBAL_MEDICAL_DUE_TO,medicalDueTo ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
    * Validates if "Global Excel Claim Number" for preceding "Medical due to" entered is correct.
    *
    * @return A string including [PASS] or [FAIL] along with specific result details.
    */
    public Object verifyGlobalExcelClaimNumberPrecedingMedicalDueTo(String globalExcelClaimNumberForPrecedingMedicalDueTo) {
        String result = validateWithinLocatorText(LO_TXT_GLOBAL_GLOBAL_EXCEL_CLAIM_NUMBER_FOR_PRECEDING_MEDICAL_DUE_TO,globalExcelClaimNumberForPrecedingMedicalDueTo ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
    * Validates if "Claim Type" entered is correct.
    *
    * @return A string including [PASS] or [FAIL] along with specific result details.
    */
    public Object verifyClaimType(String claimType) {
        String result = validateWithinLocatorText(LO_TXT_GLOBAL_CLAIM_TYPE,claimType ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
    * Validates if "Province" entered is correct.
    *
    * @return A string including [PASS] or [FAIL] along with specific result details.
    */
    public Object verifyProvince(String province) {
        String result = validateWithinLocatorText(LO_TXT_GLOBAL_PROVINCE,province ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
    * Validates if "Global Excel Claim Number" preceding "Province" entered is correct.
    *
    * @return A string including [PASS] or [FAIL] along with specific result details.
    */
    public Object verifyGlobalExcelClaimNumberPrecedingProvince(String globalExcelClaimNumberPrecedingProvince) {
        String result = validateWithinLocatorText(LO_TXT_GLOBAL_GLOBAL_EXCEL_CLAIM_NUMBER_PRECEDING_PROVINCE,globalExcelClaimNumberPrecedingProvince ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
    * Validates if "Employer Name" entered is correct.
    *
    * @return A string including [PASS] or [FAIL] along with specific result details.
    */
    public Object verifyEmployerName(String employerName) {
        String result = validateWithinLocatorText(LO_TXT_GLOBAL_EMPLOYER_NAME,employerName ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
    * Validates if "Provincial Health Card Number" entered is correct.
    *
    * @return A string including [PASS] or [FAIL] along with specific result details.
    */
    public Object verifyProvincialHealthCardNumber(String provincialHealthCardNumber) {
        String result = validateWithinLocatorText(LO_TXT_GLOBAL_PROVINCIAL_HEALTH_CARD_NUMBER,provincialHealthCardNumber ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
    * Validates if "Travel destination" following "Trip Dates" entered is correct.
    *
    * @return A string including [PASS] or [FAIL] along with specific result details.
    */
    public Object verifyTravelDestinationFollowingTripDates(String travelDestinationFollowingTripDates) {
        String result = validateWithinLocatorText(LO_TXT_GLOBAL_TRAVEL_DESTINATION_FOLLOWING_TRIP_DATES,travelDestinationFollowingTripDates ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
    * Validates if "Trip Dates" following "Original Return Date" entered is correct.
    *
    * @return A string including [PASS] or [FAIL] along with specific result details.
    */
    public Object verifyTripDatesFollowingOriginalReturnDate(String tripDates) {
        String result = validateWithinLocatorText(LO_TXT_GLOBAL_TRIP_DATES_FOLLOWING_ORIGINAL_RETURN_DATE,tripDates ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
    * Validates if "Original Return Date" entered is correct.
    *
    * @return A string including [PASS] or [FAIL] along with specific result details.
    */
    public Object verifyOriginalReturnDate(String originalReturnDate) {
        String result = validateWithinLocatorText(LO_TXT_GLOBAL_ORIGINAL_RETURN_DATE,originalReturnDate ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
    * Validates if "Reason for consult" entered is correct.
    *
    * @return A string including [PASS] or [FAIL] along with specific result details.
    */
    public Object verifyReasonForConsult(String reasonForConsult) {
        String result = validateWithinLocatorText(LO_TXT_GLOBAL_REASON_FOR_CONSULT,reasonForConsult ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
    * Validates if "First date of treatment" entered is correct.
    *
    * @return A string including [PASS] or [FAIL] along with specific result details.
    */
    public Object verifyFirstDateOfTreatment(String firstDateOfTreatment) {
        String result = validateWithinLocatorText(LO_TXT_GLOBAL_FIRST_DATE_OF_TREATMENT,firstDateOfTreatment ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
    * Validates if "When did first symptoms appear" entered is correct.
    *
    * @return A string including [PASS] or [FAIL] along with specific result details.
    */
    public Object verifyWhenDidFirstSymptomsAppear(String whenDidFirstSymptomsAppear) {
        String result = validateWithinLocatorText(LO_TXT_GLOBAL_WHEN_DID_FIRST_SYMPTOMS_APPEAR,whenDidFirstSymptomsAppear ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
    * Validates if "What Happened" entered is correct.
    *
    * @return A string including [PASS] or [FAIL] along with specific result details.
    */
    public Object verifyWhatHappenedPrecedingWhenDidFirstSymptomsAppear(String whatHappened) {
        String result = validateWithinLocatorText(LO_TXT_GLOBAL_WHAT_HAPPENED_PRECEDING_WHEN_DID_FIRST_SYMPTOMS_APPEAR,whatHappened ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
    * Validates if "Expenses" entered is correct.
    *
    * @return A string including [PASS] or [FAIL] along with specific result details.
    */
    public Object verifyExpenses(String expenses) {
        String result = validateWithinLocatorText(LO_TXT_GLOBAL_EXPENSES,expenses ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
    * Validates if "Expense Item 1" is correct.
    *
    * @return A string including [PASS] or [FAIL] along with specific result details.
    */
    public Object verifyExpenseItem1(String expenseItem1) {
        String result = validateWithinLocatorText(LO_TXT_GLOBAL_EXPENSE_ITEM_1,expenseItem1 ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

      /**
         * Validates If "Expense Item 1" entered is correct.
         * @return A string including [PASS] or [FAIL] along with specific result
         * details.
         */
        public String verifyExpenseItem1Intact(String expenseItem1) {
            String result = validateWithinLocatorText(LO_TXT_GLOBAL_EXPENSE_ITEM_1_INTACT,expenseItem1 ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
            result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
            return result;
        }

    /**
    * Validates if "Amount Billed" is correct.
    *
    * @return A string including [PASS] or [FAIL] along with specific result details.
    */
    public Object verifyAmountBilled(String amountBilled) {
        String result = validateWithinLocatorText(LO_TXT_GLOBAL_AMOUNT_BILLED_EQUIVALENT_IN_CAD,amountBilled ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
    * Validates if "Amount Paid" is correct.
    *
    * @return A string including [PASS] or [FAIL] along with specific result details.
    */
    public Object verifyAmountPaidFollowingReceiptIncluded(String amountPaid) {
        String result = validateWithinLocatorText(LO_TXT_GLOBAL_AMOUNT_PAID_EQUIVALENT_IN_CAD,amountPaid ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
    * Validates if "Receipt Included" is correct.
    *
    * @return A string including [PASS] or [FAIL] along with specific result details.
    */
    public Object verifyReceiptIncluded(String receiptIncluded) {
        String result = validateWithinLocatorText(LO_TXT_GLOBAL_RECEIPT_INCLUDED,receiptIncluded ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
    * Validates if "Total Estimated Paid Amount" is correct.
    *
    * @return A string including [PASS] or [FAIL] along with specific result details.
    */
    public Object verifyTotalEstimatedPaidAmount(String totalEstimatedPaidAmount) {
        String result = validateWithinLocatorText(LO_TXT_GLOBAL_TOTAL_ESTIMATED_PAID_AMOUNT,totalEstimatedPaidAmount ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
    * Validates if "Insurance Type" following Employer Name is correct.
    *
    * @return A string including [PASS] or [FAIL] along with specific result details.
    */
    public Object verifyInsuranceTypeFollowingEmployerName(String insuranceTypeFollowingEmployerName) {
        String result = validateWithinLocatorText(LO_TXT_GLOBAL_INSURANCE_TYPE_FOLLOWING_EMPLOYER_NAME,insuranceTypeFollowingEmployerName ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
    * Validates if "Preferred Method of Payment/Reimbursement" following "Is the email address the same as the Claimant's email address?" is correct.
    *
    * @return A string including [PASS] or [FAIL] along with specific result details.
    */
    public Object verifyPreferredMethodOfPaymentFollowingIsTheEmailAddressTheSame(String preferredMethodOfPaymentFollowingIsTheEmailAddressTheSame) {
        String result = validateWithinLocatorText(LO_TXT_GLOBAL_PREFERRED_METHOD_OF_PAYMENT_REIMBURSEMENT_FOLLOWING_IS_THE_EMAIL_ADDRESS_THE_SAME,preferredMethodOfPaymentFollowingIsTheEmailAddressTheSame ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
    * Validates if "Is the email address the same as the Claimant's email address?" is correct.
    *
    * @return A string including [PASS] or [FAIL] along with specific result details.
    */
    public Object verifyIsTheEmailAddressTheSameAsTheClaimantsEmailAddress(String isTheEmailAddressTheSameAsTheClaimantsEmailAddress) {
        String result = validateWithinLocatorText(LO_TXT_GLOBAL_IS_THE_EMAIL_ADDRESS_THE_SAME_AS_THE_CLAIMANTS_EMAIL_ADDRESS,isTheEmailAddressTheSameAsTheClaimantsEmailAddress ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
    * Validates if "Claim Type" following "Global Excel Claim Number" is correct.
    *
    * @return A string including [PASS] or [FAIL] along with specific result details.
    */
    public Object verifyClaimTypeFollowingGlobalExcelClaimNumber(String claimTypeFollowingGlobalExcelClaimNumber) {
        String result = validateWithinLocatorText(LO_TXT_GLOBAL_CLAIM_TYPE_FOLLOWING_GLOBAL_EXCEL_CLAIM_NUMBER,claimTypeFollowingGlobalExcelClaimNumber ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
    * Validates if "Global Excel Claim Number" for preceding "Claim Type" is correct.
    *
    * @return A string including [PASS] or [FAIL] along with specific result details.
    */
    public Object verifyGlobalExcelClaimNumberPrecedingClaimType(String globalExcelClaimNumberPrecedingClaimType) {
        String result = validateWithinLocatorText(LO_TXT_GLOBAL_GLOBAL_EXCEL_CLAIM_NUMBER_PRECEDING_CLAIM_TYPE,globalExcelClaimNumberPrecedingClaimType ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
    * Validates if "Country of origin" is correct.
    *
    * @return A string including [PASS] or [FAIL] along with specific result details.
    */
    public Object verifyCountryOfOrigin(String countryOfOrigin) {
        String result = validateWithinLocatorText(LO_TXT_GLOBAL_COUNTRY_OF_ORIGIN,countryOfOrigin ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
    * Validates if "Temporary Travel Destination" is correct.
    *
    * @return A string including [PASS] or [FAIL] along with specific result details.
    */
    public Object verifyTemporaryTravelDestination(String temporaryTravelDestination) {
        String result = validateWithinLocatorText(LO_TXT_GLOBAL_TEMPORARY_TRAVEL_DESTINATION,temporaryTravelDestination ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
    * Validates if "Temporary Trip Dates" is correct.
    *
    * @return A string including [PASS] or [FAIL] along with specific result details.
    */
    public Object verifyTemporaryTripDates(String temporaryTripDates) {
        String result = validateWithinLocatorText(LO_TXT_GLOBAL_TEMPORARY_TRIP_DATES,temporaryTripDates ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
    * Validates if "Global Excel Claim Number" is correct.
    *
    * @return A string including [PASS] or [FAIL] along with specific result details.
    */
    public Object verifyGlobalExcelClaimNumberFollowingAboutYourInsurance(String globalExcelClaimNumber) {
        String result = validateWithinLocatorText(LO_TXT_GLOBAL_GLOBAL_EXCEL_CLAIM_NUMBER_FOLLOWING_ABOUT_YOUR_INSURANCE,globalExcelClaimNumber ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
    * Validates if "Credit Card Type" is correct.
    *
    * @return A string including [PASS] or [FAIL] along with specific result details.
    */
    public Object verifyCreditCardType(String creditCardType) {
        String result = validateWithinLocatorText(LO_TXT_GLOBAL_CREDIT_CARD_TYPE,creditCardType ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
    * Validates if "Item Description" is correct.
    *
    * @return A string including [PASS] or [FAIL] along with specific result details.
    */
    public Object verifyItemDescription(String itemDescription) {
        String result = validateWithinLocatorText(LO_TXT_GLOBAL_ITEM_DESCRIPTION,itemDescription ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
    * Validates if "Original Purchase Date" is correct.
    *
    * @return A string including [PASS] or [FAIL] along with specific result details.
    */
    public Object verifyOriginalPurchaseDate(String originalPurchaseDate) {
        String result = validateWithinLocatorText(LO_TXT_GLOBAL_ORIGINAL_PURCHASE_DATE,originalPurchaseDate ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
    * Validates if "Incident Date" is correct.
    *
    * @return A string including [PASS] or [FAIL] along with specific result details.
    */
    public Object verifyIncidentDateFollowingDidYouPayForTheItemInMultipleInstallments(String incidentDate) {
        String result = validateWithinLocatorText(LO_TXT_GLOBAL_INCIDENT_DATE_FOLLOWING_DID_YOU_PAY_FOR_THE_ITEM_IN_MULTIPLE_INSTALLMENTS,incidentDate ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
    * Validates if "Did you pay for the item in multiple installments?" is correct.
    *
    * @return A string including [PASS] or [FAIL] along with specific result details.
    */
    public Object verifyDidYouPayForTheItemInMultipleInstallments(String didYouPayForTheItemInMultipleInstallments) {
        String result = validateWithinLocatorText(LO_TXT_GLOBAL_DID_YOU_PAY_FOR_THE_ITEM_IN_MULTIPLE_INSTALLMENTS,didYouPayForTheItemInMultipleInstallments ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
    * Validates if "Manufacturer name" is correct.
    *
    * @return A string including [PASS] or [FAIL] along with specific result details.
    */
    public Object verifyManufacturerName(String manufacturerName) {
        String result = validateWithinLocatorText(LO_TXT_GLOBAL_MANUFACTURER_NAME,manufacturerName ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
    * Validates if "Duration of Manufacturer's Warranty" is correct.
    *
    * @return A string including [PASS] or [FAIL] along with specific result details.
    */
    public Object verifyDurationOfManufacturersWarranty(String durationOfManufacturersWarranty) {
        String result = validateWithinLocatorText(LO_TXT_GLOBAL_DURATION_OF_MANUFACTURER_WARRANTY,durationOfManufacturersWarranty ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
    * Validates if "Serial Number" is correct.
    *
    * @return A string including [PASS] or [FAIL] along with specific result details.
    */
    public Object verifySerialNumber(String serialNumber) {
        String result = validateWithinLocatorText(LO_TXT_GLOBAL_SERIAL_NUMBER,serialNumber ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
    * Validates if "The Insured" following Insurance Typeis correct.
    *
    *
    * @return A string including [PASS] or [FAIL] along with specific result details.
    */
    public Object verifyTheInsuredFollowingInsuranceType(String theInsuredFollowingInsuranceType) {
        String result = validateWithinLocatorText(LO_TXT_GLOBAL_THE_INSURED_FOLLOWING_OTHER_INSURANCE_TYPE,theInsuredFollowingInsuranceType ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
    * Validates if "Other Insurance Type" is correct.
    *
    * @return A string including [PASS] or [FAIL] along with specific result details.
    */
    public Object verifyOtherInsuranceTypeFollowingTheInsured(String otherInsuranceType) {
        String result = validateWithinLocatorText(LO_TXT_GLOBAL_OTHER_INSURANCE_TYPE_FOLLOWING_THE_INSURED,otherInsuranceType ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
    * Validates if "What Happened" preceding "Serial Number" is correct.
    *
    * @return A string including [PASS] or [FAIL] along with specific result details.
    */
    public Object verifyWhatHappenedPrecedingSerialNumber(String whatHappened) {
        String result = validateWithinLocatorText(LO_TXT_GLOBAL_WHAT_HAPPENED_PRECEDING_SERIAL_NUMBER,whatHappened ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
    * Validates if "Refund Obtained" following "Total Amount of Expenses Claimed" is correct.
    *
    * @return A string including [PASS] or [FAIL] along with specific result details.
    */
    public Object verifyRefundObtainedFollowingTotalAmountOfExpensesClaimed(String amountPaid) {
        String result = validateWithinLocatorText(LO_TXT_GLOBAL_REFUND_OBTAINED_FOLLOWING_TOTAL_AMOUNT_OF_EXPENSES_CLAIMED,amountPaid ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
    * Validates if "Total Amount of Expenses Claimed" is correct.
    *
    * @return A string including [PASS] or [FAIL] along with specific result details.
    */
    public Object verifyTotalAmountOfExpensesClaimedPrecedingRefundObtained(String totalAmountOfExpensesClaimed) {
        String result = validateWithinLocatorText(LO_TXT_GLOBAL_TOTAL_AMOUNT_OF_EXPENSES_CLAIMED,totalAmountOfExpensesClaimed ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if "Total Amount of Expenses Claimed" preceding "Refund or Credit Obtained" is correct.
     * @param totalAmountOfExpensesClaimed
     * 
     * @return
     */
    public Object verifyTotalAmountOfExpensesClaimedPrecedingRefundOrCreditObtained(String totalAmountOfExpensesClaimed) {
        String result = validateWithinLocatorText(LO_TXT_GLOBAL_TOTAL_AMOUNT_OF_EXPENSES_CLAIMED_REFUND_OR_CREDIT,totalAmountOfExpensesClaimed ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
    * Validates if "Incident happened at travel destination" preceding travel destination is correct.
    *
    * @return A string including [PASS] or [FAIL] along with specific result details.
    */
    public Object verifyIncidentHappenedAtTravelDestinationPrecedingTravelDestination(String incidentHappenedAtTravelDestination) {
        String result = validateWithinLocatorText(LO_TXT_GLOBAL_INCIDENT_HAPPENED_AT_TRAVEL_DESTINATION_PRECEDING_TRAVEL_DESTINATION,incidentHappenedAtTravelDestination ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
    * Validates if "Name of Travel Provider" is correct.
    *
    * @return A string including [PASS] or [FAIL] along with specific result details.
    */
    public Object verifyNameOfTravelProviderFollowingReportFiledDate(String reportFiledDate) {
        String result = validateWithinLocatorText(LO_TXT_GLOBAL_NAME_OF_TRAVEL_PROVIDER_FOLLOWING_REPORT_FILED_DATE,reportFiledDate ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
    * Validates if "The Insured" following other Insurance Type is correct.
    *
    * @return A string including [PASS] or [FAIL] along with specific result details.
    */
    public Object verifyTheInsuredFollowingOtherInsuranceType(String theInsuredFollowingOtherInsuranceType) {
        String result = validateWithinLocatorText(LO_TXT_GLOBAL_THE_INSURED_FOLLOWING_OTHER_INSURANCE_TYPE,theInsuredFollowingOtherInsuranceType ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
    * Validates if "Reason for loss" is correct.
    *
    * @return A string including [PASS] or [FAIL] along with specific result details.
    */
    public Object verifyReasonForLoss(String reasonForLoss) {
        String result = validateWithinLocatorText(LO_TXT_GLOBAL_REASON_FOR_LOSS,reasonForLoss ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
    * Validates if "Global Excel Claim Number" preceing "Reason for loss" is correct.
    *
    * @return A string including [PASS] or [FAIL] along with specific result details.
    */
    public Object verifyGlobalExcelClaimNumberPrecedingReasonForLoss(String globalExcelClaimNumber) {
        String result = validateWithinLocatorText(LO_TXT_GLOBAL_GLOBAL_EXCEL_CLAIM_NUMBER_PRECEDING_REASON_FOR_LOSS,globalExcelClaimNumber ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
    * Validates if "Country" is correct.
    *
    * @return A string including [PASS] or [FAIL] along with specific result details.
    */
    public Object verifyCountry(String country) {
        String result = validateWithinLocatorText(LO_TXT_GLOBAL_COUNTRY,country ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
    * Validates if "Province" following "City" is correct.
    *
    * @return A string including [PASS] or [FAIL] along with specific result details.
    */
    public Object verifyProvinceFollowingCity(String province) {
        String result = validateWithinLocatorText(LO_TXT_GLOBAL_PROVINCE_FOLLOWING_CITY,province ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
    * Validates if "City" is correct.
    *
    * @return A string including [PASS] or [FAIL] along with specific result details.
    */
    public Object verifyCity(String city) {
        String result = validateWithinLocatorText(LO_TXT_GLOBAL_CITY,city ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
    * Validates if "What Happened" preceding "City"is correct.
    *
    * @return A string including [PASS] or [FAIL] along with specific result details.
    */
    public Object verifyWhatHappenedPrecedingCity(String whatHappened) {
        String result = validateWithinLocatorText(LO_TXT_GLOBAL_WHAT_HAPPENED_PRECEDING_CITY,whatHappened ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
    * Validates if "Incident Date" following "Country"is correct.
    *
    * @return A string including [PASS] or [FAIL] along with specific result details.
    */
    public Object verifyIncidentDateFollowingCountry(String incidentDate) {
        String result = validateWithinLocatorText(LO_TXT_GLOBAL_INCIDENT_DATE_FOLLOWING_COUNTRY,incidentDate ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
    * Validates if "Reason For Loss" is correct.
    *
    * @return A string including [PASS] or [FAIL] along with specific result details.
    */
    public Object verifyReasonForLossFollowingGlobalExcelClaimNumber(String reasonForLoss) {
        String result = validateWithinLocatorText(LO_TXT_GLOBAL_REASON_FOR_LOSS_WITH_SPACE,reasonForLoss ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
    * Validates if "Global Excel Claim Number" is correct.
    *
    * @return A string including [PASS] or [FAIL] along with specific result details.
    */
    public Object verifyGlobalExcelClaimNumberPrecedingReasonForLoss2(String globalExcelClaimNumber) {
        String result = validateWithinLocatorText(LO_TXT_GLOBAL_GLOBAL_EXCEL_CLAIM_NUMBER_PRECEDING_REASON_FOR_LOSS_WITH_SPACE,globalExcelClaimNumber ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
    * Validates if "Rental Agency Name" is correct.
    * @return A string including [PASS] or [FAIL] along with specific result details.

    */
    public Object verifyRentalAgencyName(String rentalAgencyName) {
        String result = validateWithinLocatorText(LO_TXT_GLOBAL_RENTAL_AGENCY_NAME,rentalAgencyName ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
    * Validates if "Was the full cost of the rental charged to your credit card?" is correct.
    *
    * @return A string including [PASS] or [FAIL] along with specific result details.
    */
    public Object verifyWasTheFullCostOfTheRentalChargedToYourCreditCard(String wasTheFullCostOfTheRentalChargedToYourCreditCard) {
        String result = validateWithinLocatorText(LO_TXT_GLOBAL_WAS_THE_FULL_COST_OF_THE_RENTAL_CHARGED_TO_YOUR_CREDIT_CARD,wasTheFullCostOfTheRentalChargedToYourCreditCard ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
    * Validates if "Did you have another rental agreement within a 48h period from the start or the end of this current rental?" is correct.
    *
    * @return A string including [PASS] or [FAIL] along with specific result details.
    */
    public Object verifyRentalAgreementWithinA48h(String rentalAgreementWithinA48h) {
        String result = validateWithinLocatorText(LO_TXT_GLOBAL_DID_YOU_HAVE_ANOTHER_RENTAL_AGREEMENT_WITHIN_A_48H_PERIOD_FROM_THE_START_OR_THE_END_OF_THIS_CURRENT_RENTAL,rentalAgreementWithinA48h ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
    * Validates if "When Did the Incident Occur" is correct.
    *
    * @return A string including [PASS] or [FAIL] along with specific result details.
    */
    public Object verifyWhenDidTheIncidentOccurFollowingWasThePolicyHolderTheDriver(String whenDidTheIncidentOccur) {
        String result = validateWithinLocatorText(LO_TXT_GLOBAL_WHEN_DID_THE_INCIDENT_OCCUR_FOLLOWING_WAS_THE_POLICY_HOLDER_THE_DRIVER,whenDidTheIncidentOccur ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
    * Validates if "Was the policy holder the driver?" is correct.
    *
    * @return A string including [PASS] or [FAIL] along with specific result details.
    */
    public Object verifyWasThePolicyHolderTheDriver(String wasThePolicyHolderTheDriver) {
        String result = validateWithinLocatorText(LO_TXT_GLOBAL_WAS_THE_POLICY_HOLDER_THE_DRIVER_AT_THE_TIME_OF_INCIDENT,wasThePolicyHolderTheDriver ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
    * Validates if "Did the incident involve another vehicle" is correct.
    *
    * @return A string including [PASS] or [FAIL] along with specific result details.
    */
    public Object verifyDidTheIncidentInvolveAnotherVehicle(String didTheIncidentInvolveAnotherVehicle) {
        String result = validateWithinLocatorText(LO_TXT_GLOBAL_DID_THE_INCIDENT_INVOLVE_ANOTHER_VEHICLE,didTheIncidentInvolveAnotherVehicle ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
    * Validates if "What Happened" preceding "Did the incident involve another vehicle" is correct.
    *
    * @return A string including [PASS] or [FAIL] along with specific result details.
    */
    public Object verifyWhatHappenedPrecedingDidTheIncidentInvolveAnotherVehicle(String whatHappened) {
        String result = validateWithinLocatorText(LO_TXT_GLOBAL_WHAT_HAPPENED_PRECEDING_DID_THE_INCIDENT_INVOLVE_ANOTHER_VEHICLE,whatHappened ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
    * Validates if "Employer Name" following "The Insured" is correct.
    *
    * @return A string including [PASS] or [FAIL] along with specific result details.
    */
    public Object verifyEmployerNameFollowingTheInsured(String employerName) {
        String result = validateWithinLocatorText(LO_TXT_GLOBAL_EMPLOYER_NAME_FOLLOWING_THE_INSURED,employerName ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

        /**
    * Validates if "Refund Obtained" following "Total Amount of Expenses Claimed without dots" is correct.
    *
    * @return A string including [PASS] or [FAIL] along with specific result details.
    */
    public Object verifyRefundObtainedFollowingTotalAmountOfExpensesClaimedWithoutDots(String refundObtained) {
        String result = validateWithinLocatorText(LO_TXT_GLOBAL_REFUND_OBTAINED_FOLLOWING_TOTAL_AMOUNT_OF_EXPENSES_CLAIMED_WITHOUT_DOTS,refundObtained ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
    * Validates if "Total Amount of Expenses Claimed without dots" is correct.
    *
    * @return A string including [PASS] or [FAIL] along with specific result details.
    */
    public Object verifyTotalAmountOfExpensesClaimedWithoutDotsPrecedingRefundObtained(String totalAmountOfExpensesClaimedWithoutDots) {
        String result = validateWithinLocatorText(LO_TXT_GLOBAL_TOTAL_AMOUNT_OF_EXPENSES_CLAIMED_WITHOUT_DOTS,totalAmountOfExpensesClaimedWithoutDots ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
    * Validates if "Plan Number" is correct.
    *
    * @return A string including [PASS] or [FAIL] along with specific result details.
    */
    public Object verifyPlanNumber(String planNumber) {
        String result = validateWithinLocatorText(LO_TXT_GLOBAL_PLAN_NUMBER,planNumber ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
    * Validates if "The Insured" "Other Insured Persons" is correct.
    *
    * @return A string including [PASS] or [FAIL] along with specific result details.
    */
    public Object verifyTheInsuredFollowingOtherInsuredPersons(String theInsured) {
        String result = validateWithinLocatorText(LO_TXT_GLOBAL_THE_INSURED_FOLLOWING_OTHER_INSURED_PERSONS,theInsured ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
    * Validates if "Description of Damage" is correct.
    *
    * @return A string including [PASS] or [FAIL] along with specific result details.
    */
    public Object verifyDescriptionOfDamage(String descriptionOfDamage) {
        String result = validateWithinLocatorText(LO_TXT_GLOBAL_DESCRIPTION_OF_DAMAGE,descriptionOfDamage ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
    * Validates if "Main Reason for Interruption" is correct.
    *
    * @return A string including [PASS] or [FAIL] along with specific result details.
    */
    public Object verifyMainReasonForInterruption(String mainReasonForInterruption) {
        String result = validateWithinLocatorText(LO_TXT_GLOBAL_MAIN_REASON_FOR_INTERRUPTION,mainReasonForInterruption ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
    * Validates if "Deceased Person Insurance" is correct.
    *
    * @return A string including [PASS] or [FAIL] along with specific result details.
    */
    public Object verifyDeceasedPersonInsurance(String deceasedPersonInsurance) {
        String result = validateWithinLocatorText(LO_TXT_GLOBAL_DECEASED_PERSON_INSURANCE,deceasedPersonInsurance ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
    * Validates if "Global Excel Claim Number" Preceding "Deceased Person Insurance" is correct.
    *
    * @return A string including [PASS] or [FAIL] along with specific result details.
    */
    public Object verifyGlobalExcelClaimNumberPrecedingDeceasedPersonInsurance(String globalExcelClaimNumber) {
        String result = validateWithinLocatorText(LO_TXT_GLOBAL_GLOBAL_EXCEL_CLAIM_NUMBER_PRECEDING_DECEASED_PERSON_INSURANCE,globalExcelClaimNumber ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
    * Validates if "What were your original trip dates" is correct.
    *
    * @return A string including [PASS] or [FAIL] along with specific result details.
    */
    public Object verifyWhatWereYourOriginalTripDates(String whatWereYourOriginalTripDates) {
        String result = validateWithinLocatorText(LO_TXT_GLOBAL_WHAT_WERE_YOUR_ORIGINAL_TRIP_DATES,whatWereYourOriginalTripDates ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
    * Validates if "Incident Date" following "Trip Purchase Date" is correct.
    *
    * @return A string including [PASS] or [FAIL] along with specific result details.
    */
    public Object verifyIncidentDateFollowingWhatHappened(String incidentDate) {
        String result = validateWithinLocatorText(LO_TXT_GLOBAL_INCIDENT_DATE_FOLLOWING_WHAT_HAPPENED,incidentDate ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
    * Validates if "What Happened" preceding "What were your original trip dates" is correct.
    *
    * @return A string including [PASS] or [FAIL] along with specific result details.
    */
    public Object verifyWhatHappenedPrecedingWhatWereYourOriginalTripDates(String whatHappened) {
        String result = validateWithinLocatorText(LO_TXT_GLOBAL_WHAT_HAPPENED_PRECEDING_WHAT_WERE_YOUR_ORIGINAL_TRIP_DATES,whatHappened ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
    * Validates if "Contract Number" is correct.
    *
    * @return A string including [PASS] or [FAIL] along with specific result details.
    */
    public Object verifyContractNumber(String contractNumber) {
        String result = validateWithinLocatorText(LO_TXT_GLOBAL_CONTRACT_NUMBER,contractNumber ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
    * Validates if "Member Certificate Number" is correct.
    *
    * @return A string including [PASS] or [FAIL] along with specific result details.
    */
    public Object verifyMemberCertificateNumber(String memberCertificateNumber) {
        String result = validateWithinLocatorText(LO_TXT_GLOBAL_MEMBER_CERTIFICATE_NUMBER,memberCertificateNumber ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
    * Validates if "Insurance Type" following "Employer/Group Name" is correct.
    *
    * @return A string including [PASS] or [FAIL] along with specific result details.
    */
    public Object verifyInsuranceTypeFollowingEmployerGroupName(String insuranceType) {
        String result = validateWithinLocatorText(LO_TXT_GLOBAL_INSURANCE_TYPE_FOLLOWING_EMPLOYER_GROUP_NAME,insuranceType ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
    * Validates if "Group name" entered is correct.
    *
    * @return A string including [PASS] or [FAIL] along with specific result details.
    */
    public Object verifyGroupNamePlanNumber(String groupNamePlanNumber) {
        String result = validateWithinLocatorText(LO_TXT_GLOBAL_GROUP_NAME_PLAN_NUMBER,groupNamePlanNumber ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
    * Validates if "Employer Group Name" entered is correct.
    *
    * A string including [PASS] or [FAIL] along with specific result details.
    */
    public Object verifyEmployerGroupName(String employerGroupName) {
        String result = validateWithinLocatorText(LO_TXT_GLOBAL_EMPLOYER_GROUP_NAME,employerGroupName ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
    * Validates if "Are you currently Travelling" chose option is correct.
    *
    * @return A string including [PASS] or [FAIL] along with specific result details.
    */
    public Object verifyAreYouCurrentlyTravelling(String areYouCurrentlyTravelling) {
        String result = validateWithinLocatorText(LO_TXT_GLOBAL_ARE_YOU_CURRENTLY_TRAVELLING,areYouCurrentlyTravelling ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
    * Validates if "Date of Injury" entered is correct.
    *
    * @return A string including [PASS] or [FAIL] along with specific result details.
    */
    public Object verifyDateOfInjury(String dateOfInjury) {
        String result = validateWithinLocatorText(LO_TXT_GLOBAL_DATE_OF_INJURY,dateOfInjury ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
    * Validates if "Reason For Consult" following Date of Injury entered is correct.
    *
    * @return A string including [PASS] or [FAIL] along with specific result details.
    */
    public Object verifyReasonForConsultFollowingDateOfInjury(String reasonForConsult) {
        String result = validateWithinLocatorText(LO_TXT_GLOBAL_REASON_FOR_CONSULT_FOLLOWING_DATE_OF_INJURY,reasonForConsult ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
    * Validates if "Incident Location" following What Happened is correct.
    *
    * @return A string including [PASS] or [FAIL] along with specific result details.
    */
    public Object verifyIncidentLocationFollowingWhatHappened(String incidentLocation) {
        String result = validateWithinLocatorText(LO_TXT_GLOBAL_INCIDENT_LOCATION_FOLLOWING_WHAT_HAPPENED,incidentLocation ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
    * Validates if "What Happened" preceding Incident Location is correct.
    *
    * @return A string including [PASS] or [FAIL] along with specific result details.
    */
    public Object verifyWhatHappenedPrecedingIncidentLocation(String whatHappened) {
        String result = validateWithinLocatorText(LO_TXT_GLOBAL_WHAT_HAPPENED_PRECEDING_INCIDENT_LOCATION,whatHappened ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
    * Validates if "Employer Name" following "Plan Number" is correct.
    *
    * @return A string including [PASS] or [FAIL] along with specific result details.
    */
    public Object verifyEmployerNameFollowingPlanNumber(String employerName) {
        String result = validateWithinLocatorText(LO_TXT_GLOBAL_EMPLOYER_NAME_FOLLOWING_PLAN_NUMBER,employerName ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
    * Validates if "The Insured" Following "Other Insurance" entered is correct.
    *
    * @return A string including [PASS] or [FAIL] along with specific result details.
    */
    public Object verifyTheInsuredFollowingOtherInsurance(String theInsured) {
        String result = validateWithinLocatorText(LO_TXT_GLOBAL_THE_INSURED_FOLLOWING_OTHER_INSURANCE,theInsured ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
    * Validates if "Manufacturer Name" following "Where did the incident occur" entered is correct.
    *
    * @return A string including [PASS] or [FAIL] along with specific result details.
    */
    public Object verifyManufacturerNameFollowingWhereDidTheIncidentOccur(String manufacturerName) {
        String result = validateWithinLocatorText(LO_TXT_GLOBAL_MANUFACTURER_NAME_FOLLOWING_WHERE_DID_THE_INCIDENT_OCCUR,manufacturerName ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
    * Validates if "Where did the incident occur" entered is correct.
    *
    * @return A string including [PASS] or [FAIL] along with specific result details.
    */
    public Object verifyWhereDidTheIncidentOccur(String whereDidTheIncidentOccur) {
        String result = validateWithinLocatorText(LO_TXT_GLOBAL_WHERE_DID_THE_INCIDENT_OCCUR,whereDidTheIncidentOccur ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
    * Validates if "Transit Number" entered is correct.
    *
    * @return A string including [PASS] or [FAIL] along with specific result details.
    */
    public Object verifyTransitNumber(String transitNumber) {
        String result = validateWithinLocatorText(LO_TXT_GLOBAL_TRANSIT_NUMBER,transitNumber ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
    * Validates if "Institution Number" entered is correct.
    *
    * @return A string including [PASS] or [FAIL] along with specific result details.
    */
    public Object verifyInstitutionNumber(String institutionNumber) {
        String result = validateWithinLocatorText(LO_TXT_GLOBAL_INSTITUTION_NUMBER,institutionNumber ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
    * Validates if "Account Number" entered is correct.
    *
    * @return A string including [PASS] or [FAIL] along with specific result details.
    */
    public Object verifyAccountNumber(String accountNumber) {
        String result = validateWithinLocatorText(LO_TXT_GLOBAL_ACCOUNT_NUMBER,accountNumber ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
    * Validates if "What Happened" preceding "Incident Date" entered is correct.
    *
    * @return A string including [PASS] or [FAIL] along with specific result details.
    */
    public Object verifyWhatHappenedPrecedingIncidentDate(String whatHappened) {
        String result = validateWithinLocatorText(LO_TXT_GLOBAL_WHAT_HAPPENED_PRECEDING_INCIDENT_DATE,whatHappened ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
    * Validates if "Preferred Method Of Payment?Reimbursement" following Transit Number entered is correct.
    *
    * @return A string including [PASS] or [FAIL] along with specific result details.
    */
    public Object verifyPreferredMethodOfPaymentReimbursementFollowingTransitNumber(String preferredMethodOfPaymentReimbursement) {
        String result = validateWithinLocatorText(LO_TXT_GLOBAL_PREFERRED_METHOD_OF_PAYMENT_REIMBURSEMENT_FOLLOWING_TRANSIT_NUMBER,preferredMethodOfPaymentReimbursement ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
    * Validates if "Travelling From" following "When was your scheduled date and departure time?" entered is correct.
    *
    * @return A string including [PASS] or [FAIL] along with specific result details.
    */
    public Object verifyTravellingFromFollowingWhenWasYourScheduledDateAndDepartureTime(String travellingFrom) {
        String result = validateWithinLocatorText(LO_TXT_GLOBAL_TRAVELLING_FROM_FOLLOWING_WHEN_WAS_YOUR_SCHEDULED_DATE_AND_DEPARTURE_TIME,travellingFrom ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
    * Validates if "Member ID" entered is correct.
    *
    * @return A string including [PASS] or [FAIL] along with specific result details.
    */
    public Object verifyMemberID(String memberID) {
        String result = validateWithinLocatorText(LO_TXT_GLOBAL_MEMBER_ID,memberID ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
    * Validates if "Contract/Group Number" entered is correct.
    *
    * @return A string including [PASS] or [FAIL] along with specific result details.
    */
    public Object verifyContractGroupNumber(String contractGroupNumber) {
        String result = validateWithinLocatorText(LO_TXT_GLOBAL_CONTRACT_GROUP_NUMBER,contractGroupNumber ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
    * Validates if "Employer Name" following "contract/Group Number" entered is correct.
    *
    * @return A string including [PASS] or [FAIL] along with specific result details.
    */
    public Object verifyEmployerNameFollowingContractGroupNumber(String employerName) {
        String result = validateWithinLocatorText(LO_TXT_GLOBAL_EMPLOYER_NAME_FOLLOWING_CONTRACT_GROUP_NUMBER,employerName ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
    * Validates if "Preferred Method of Payment/Reimbursement" following "Is the email address the same as the Claimant's email address?|" entered is correct.
    *
    * @return A string including [PASS] or [FAIL] along with specific result details.
    */
    public Object verifyPreferredMethodOfPaymentReimbursementFollowingIsTheEmailAddressTheSameAsTheClaimantsEmailAddress(String preferredMethodOfPaymentReimbursement) {
        String result = validateWithinLocatorText(LO_TXT_GLOBAL_PREFERRED_METHOD_OF_PAYMENT_REIMBURSEMENT_FOLLOWING_IS_THE_EMAIL_ADDRESS_THE_SAME_AS_THE_CLAIMANTS_EMAIL_ADDRESS,preferredMethodOfPaymentReimbursement ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
    * Validates if "Is the email address the same as the Claimant's email address?" entered is correct.
    *
    * @return A string including [PASS] or [FAIL] along with specific result details.
    */
    public Object verifyIsTheEmailAddressTheSameAsTheClaimantsEmailAddressWithSymbol(String isTheEmailAddressTheSameAsTheClaimantsEmailAddress) {
        String result = validateWithinLocatorText(LO_TXT_GLOBAL_IS_THE_EMAIL_ADDRESS_THE_SAME_AS_THE_CLAIMANTS_EMAIL_ADDRESS_SYMBOL,isTheEmailAddressTheSameAsTheClaimantsEmailAddress ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
    * Validates if "Expense Item 1" following "Type of Expense" entered is correct.
    *
    * @return A string including [PASS] or [FAIL] along with specific result details.
    */
    public Object verifyExpenseItem1FollowingTypeOfExpense(String expenseItem1) {
        String result = validateWithinLocatorText(LO_TXT_GLOBAL_EXPENSE_ITEM_1_FOLLOWING_TYPE_OF_EXPENSE,expenseItem1 ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
    * Validates if "When Did the Incident Occur" following "Where did the incident occur? "entered is correct.
    *
    * @return A string including [PASS] or [FAIL] along with specific result details.
    */
    public Object verifyWhenDidTheIncidentOccurFollowingWhereDidTheIncidentOccur(String whenDidTheIncidentOccur) {
        String result = validateWithinLocatorText(LO_TXT_GLOBAL_WHEN_DID_THE_INCIDENT_OCCUR_FOLLOWING_WHERE_DID_THE_INCIDENT_OCCUR,whenDidTheIncidentOccur ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
    * Validates if "Where did the incident occur?" entered is correct.
    *
    * @return A string including [PASS] or [FAIL] along with specific result details.
    */
    public Object verifyWhereDidTheIncidentOccurFollowingWasThePolicyHolderTheDriverAtTheTimeOfIncident(String whereDidTheIncidentOccur) {
        String result = validateWithinLocatorText(LO_TXT_GLOBAL_WHERE_DID_THE_INCIDENT_OCCUR_FOLLOWING_WAS_THE_POLICYHOLDER_THE_DRIVER,whereDidTheIncidentOccur ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
    * Validates if "Preferred Method of Payment/Reimbursement" following "Preferred Method of Payment/Reimbursement'] and following-sibling::div[div//strong[text()="Is the email address the same as the Claimant's email address?" entered is correct.
    *
    * @return A string including [PASS] or [FAIL] along with specific result details.
    */
    public Object verifyPreferredMethodOfPaymentReimbursementFollowingIsTheEmailAddress(String preferredMethodOfPaymentReimbursement) {
        String result = validateWithinLocatorText(LO_TXT_GLOBAL_PREFERRED_METHOD_OF_PAYMENT_REIMBURSEMENT_FOLLOWING_IS_THE_EMAIL_ADDRESS,preferredMethodOfPaymentReimbursement ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
    * Validates if "Insurance Type" following Employee Name entered is correct.
    *
    * @return A string including [PASS] or [FAIL] along with specific result details.
    */
    public Object verifyInsuranceTypeFollowingEmployeeName(String insuranceTypeFollowingEmployeeName) {
    String result = validateWithinLocatorText(LO_TXT_GLOBAL_INSURANCE_TYPE_FOLLOWING_EMPLOYEE_NAME,insuranceTypeFollowingEmployeeName,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
    FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
    return resultObj;
    }

    /**
    /* Validates if "Employee name" entered is correct.
    *
    * @return A string including [PASS] or [FAIL] along with specific result details.
    */
    public Object verifyEmployeeNamePlanNumber(String employeeNamePlanNumber) {
        String result = validateWithinLocatorText(LO_TXT_GLOBAL_EMPLOYEE_NAME_PLAN_NUMBER,employeeNamePlanNumber ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates the presence of the paragraph on the Review & Submit Claim page.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object verifyReviewAndSubmitParagraph() {
        String result = validateLocatorExists(LO_BUT_REVIEW_AND_SUBMIT_PARAGRAPH, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if "Travel Status & Interruption" text is displayed.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object verifyTravelStatusAndInterruptionText() {
         String result = validateLocatorExists(LO_TXT_TRAVEL_STATUS_AND_INTERRUPTION_REASON, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if "About Your Insurance" text exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object verifyAboutYourInsuranceText() {
        String result = validateLocatorExists(LO_TXT_ABOUT_YOUR_INSURANCE, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if "Edit" button exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object verifyEditButton() {
        String result = validateLocatorExists(LO_BUT_EDIT, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if "Employee/Member ID" entered is correct.
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object verifyEmployeeMemberID(String employeeMemberID) {
        String result = validateWithinLocatorText(LO_TXT_EMPLOYEE_MEMBER_ID,employeeMemberID ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if "Contact Information" text exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object verifyContactInformationText() {
        String result = validateLocatorExists(LO_TXT_CONTACT_INFORMATION, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if "About the event" text exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object verifyAboutTheEventText() {
        String result = validateLocatorExists(LO_TXT_ABOUT_THE_EVENT, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if "Incurred Expenses" text exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object verifyIncurredExpensesText() {
        String result = validateLocatorExists(LO_TXT_INCURRED_EXPENSES, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if "Reimbursement Details" text exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object verifyReimbursementDetailsText() {
        String result = validateLocatorExists(LO_TXT_REIMBURSED_DETAILS, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
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
     * Validates if "Claimant's Relationship with the Policy holder" entered is correct.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object verifyClaimantsRelationshipWithPolicyHolder(String Relationship) {
        String result = validateWithinLocatorText(LO_TXT_CLAIMANTS_RELATIONSHIP_WITH_POLICY_HOLDER, Relationship, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(), true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if "Home Address of Policy Holder" entered is correct.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object verifyHomeAddressOfPolicyHolder(String HomeAddress) {
        String result = validateWithinLocatorText(LO_TXT_HOME_ADDRESS_OF_POLICY_HOLDER, HomeAddress, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(), true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if "Other Insured Person`s Relationship with Policy holder" entered is correct.
     */
    public Object verifyOtherInsuredPersonsRelationshipWithPolicyHolder(String Relationship) {
        String result = validateWithinLocatorText(LO_TXT_OTHER_INSURED_PERSONS_RELATIONSHIP_WITH_POLICY_HOLDER, Relationship, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(), true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if "First Name of Policy Holder" entered is correct.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object verifyFirstName(String FirstName) {
        String result = validateWithinLocatorText(LO_TXT_FIRST_NAME, FirstName, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(), true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if "Last Name of Policy Holder" entered is correct.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object verifyLastName(String LastName) {
        String result = validateWithinLocatorText(LO_TXT_LAST_NAME, LastName, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(), true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if "Date of Birth of Policy Holder" entered is correct.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object verifyDateOfBirth(String DateOfBirth) {
        String result = validateWithinLocatorText(LO_TXT_DATE_OF_BIRTH, DateOfBirth, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(), true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if "What type of travel insurance do you have?" entered is correct.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object verifyWhatTypeOfTravelInsuranceDoYouHave(String TravelInsuranceType) {
        String result = validateWithinLocatorText(LO_TXT_WHAT_TYPE_OF_TRAVEL_INSURANCE_DO_YOU_HAVE, TravelInsuranceType, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(), true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if "Card Issuer Name" entered is correct.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object verifyCardIssuerName(String CardIssuerName) {
        String result = validateWithinLocatorText(LO_TXT_CARD_ISSUER_NAME, CardIssuerName, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(), true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if "Mailing Address" entered is correct.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object verifyMailingAddress(String MailingAddress) {
        String result = validateWithinLocatorText(LO_TXT_MAILING_ADDRESS, MailingAddress, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(), true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    }