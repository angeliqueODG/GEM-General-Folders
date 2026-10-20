package pageobjects;

import org.openqa.selenium.WebDriver;

import customizations.automation.CU_Appian; // Selenium WebDriver
import framework.utilities.FW_ConfigMgr;// Automation framework customizations for Appian
import framework.utilities.FW_StringUtils; // Automation framework Configuration Manager to retrieve testConfig.properties values

/**
 * Page Object (PO) class used in the Page Object (PO) design pattern. Inherits
 * from the CU_Appian class.
 */
// [Note: Automation Engineer, rename this Page Object (PO) class to match the
// filename.]
public class PO_Review_And_Submit_Claim extends CU_Appian {

    // [Note: Automation Engineer, define the Page Object (PO) locators (LO) here.]
    private static final String LO_TXT_REVIEW_AND_SUBMIT_CLAIM_PAGE_VERIFY = "//h2[contains(text(), 'REVIEW & SUBMIT CLAIM')]";
    private static final String LO_TXT_TRAVEL_STATUS_CANCELLATION_REASON_TITLE= "//h3[contains(text(), 'TRAVEL STATUS & CANCELLATION REASON')]";
    private static final String LO_TXT_TRAVEL_STATUS_INTERRUPTION_REASON_TITLE= "//h3[contains(text(), 'TRAVEL STATUS & INTERRUPTION REASON')]";
    private static final String LO_TXT_ABOUT_THE_INSURED_TITLE= "//h3[contains(text(), 'ABOUT THE INSURED')]";
    private static final String LO_TXT_OTHER_INSURED_PERSON_TITLE= "//h3[contains(text(), 'OTHER INSURED PERSON(S)')]";
    private static final String LO_TXT_OTHER_INSURANCE_TYPE_TITLE= "//h3[contains(text(), 'OTHER INSURANCE TYPE')]";
    private static final String LO_TXT_DONT_HAVE_OTHER_INSURED_PERSON= "//p[contains(text(), 'I') and strong[contains(text(), 'am not')] and text()='claiming for any other insured person']";
    private static final String LO_TXT_DONT_HAVE_OTHER_INSURANCE_TYPE= "//p[contains(text(), \"I don't have any other insurance.\")]";
    private static final String LO_TXT_CONTACT_INFORMATION_TITLE= "//h3[contains(text(), 'CONTACT INFORMATION')]";
    private static final String LO_TXT_EMAIL_AUTHORIZATION_TXT= "//p[contains(text(), 'I authorize Global Excel to communicate with me regarding my claim using this e-mail address with the understanding that these communications may contain personal information')]";
    private static final String LO_TXT_PHONE_NUMBER_AUTHORIZATION_TXT= "//p[contains(text(), 'I authorize Global Excel to communicate with me regarding my claim using this phone number with the understanding that these communications may contain personal information')]";
    private static final String LO_TXT_ABOUT_THE_EVENT_TITLE= "//h3[contains(text(), 'ABOUT THE EVENT')]";
    private static final String LO_TXT_INCURED_EXPENSES_TITLE= "//h3[contains(text(), 'INCURRED EXPENSES')]";
    private static final String LO_TXT_REFUND_OBTAINED_EQUIV_CAD_TITLE_NEW= "//div[span[contains(text(), 'Expense Type')]]";
    private static final String LO_TXT_TOTAL_IN_CAD_TITLE_NEW= "//div[span[contains(text(), 'Total In CAD')]]";
    private static final String LO_TXT_INVOICE_DESCRIPTION_TITLE_NEW= "//div[span[contains(text(), 'Invoice Description')]]";
    private static final String LO_TXT_DOCUMENT_UPLOADED_TITLE_NEW= "//div[@class='FieldLayout---label_above' and span[contains(text(), 'Document Uploaded')]]";
    private static final String LO_TXT_TYPE_OF_EXPENSE_TITLE_NEW= "//div[span[contains(text(), 'Refund Obtained (Equivalent in CAD)')]]";
    private static final String LO_TXT_AMOUNT_PAID_EQUIV_CAD_TITLE_NEW= "//div[span[contains(text(), 'Amount Paid (Equivalent in CAD)')]]";
    private static final String LO_TXT_REQUIRED_DOCUMENTS_TITLE= "//h3[contains(text(), 'REQUIRED DOCUMENTS')]";
    private static final String LO_TXT_REIMBURSEMENT_DETAILS_TITLE= "//h3[contains(text(), 'REIMBURSEMENT DETAILS')]";
    private static final String LO_TXT_PROOF_OF_PAYMENT_ORIGINAL= "//p[contains(text(), 'Proof of Payment - Original')]";
    private static final String LO_TXT_ORIGINAL_TRAVEL_ITENARY= "//p[contains(text(), 'Original Travel Itinerary')]";
    private static final String LO_TXT_OUT_OF_POCKET_EXPENSES= "//p[contains(text(), 'Receipts for Out of Pocket Expenses')]";
    private static final String LO_TXT_NEW_TRAVEL_ITENARY= "//p[contains(text(), 'New Travel Itinerary')]";
    private static final String LO_TXT_PROOF_OF_CAUSE_OF_CLAIM_DEATH_CERTIFICATE= "//p[contains(text(), 'Proof of Cause of Claim - Death Certificate')]";
    private static final String LO_TXT_CREDIT_CARD_STATEMENT= "//p[contains(text(), 'Credit Card Statement')]";
    private static final String LO_TXT_ORIGINAL_BOOKING_INVOICE= "//p[contains(text(), 'Original Booking Invoice')]";
    private static final String LO_TXT_PROOF_OF_CANCELLATION= "//p[contains(text(), 'Proof of Cancellation')]";
    private static final String LO_TXT_PROOF_OF_CAUSE_OF_CLAIM_NOTIFICATION_OF_EVENT= "//p[contains(text(), 'Proof of Cause of Claim - Notification of event cancellation')]";
    private static final String LO_TXT_TERMS_TITLE= "//h3[contains(text(), 'TERMS')]";
    private static final String LO_TXT_TERMS_1= "//div[contains(text(), 'If you have selected email as one of your preferred methods of communication, you consent to us communicating with you via electronic means regarding your claim at the email address you have provided, and understand that this communication will contain personal information.')]";
    private static final String LO_TXT_TERMS_2= "//div[contains(text(), 'I declare that all the statements made in this claim form are accurate, true and complete. I understand that making false, misleading or incomplete statements may cause not only the claim to be denied, but insurance coverage to be void. The undersigned agrees to refund the amount of any payments that should not have been made.')]";
    private static final String LO_TXT_TERMS_3= "//div[contains(text(), 'By signing below, you agree that we may collect, use and disclose your Information as described in the Privacy Policy including for, but not limited to, the purposes of identifying you, providing ongoing service, processing your claims, understanding your financial needs, protecting us both from fraud and error and complying with legal and regulatory requirements. For further details about this Privacy Policy and our privacy practices, visit TD Privacy Policy | TD Canada Trust or contact us for a copy.')]";
    private static final String LO_TXT_TERMS_4= "//div[contains(text(), 'I authorize any other insurance carrier to release and exchange with TD Life Insurance Company (“TD Life’’) and/or TD Home & Auto Insurance Company (“TD H&A”) and its administrator Global Excel Management Inc. (“Global Excel “) or its representatives benefits payment information relating to this claim.')]";
    private static final String LO_TXT_TERMS_5= "//div[contains(text(), 'The information provided with respect to this claim will be used by TD Life and/or TD H&A and its administrator Global Excel or their representatives to investigate any losses, assess any entitlement to benefits and to administer this claim, and as otherwise indicated in the privacy terms provided in the Policy/Certificate of Insurance. We will investigate and administer this claim by consulting the insurer’s existing files and by exchanging information with the undersigned and third parties, such as indicated in this authorization. This may, in some cases, include the transfer of your data outside the territory of Canada.')]";
    private static final String LO_TXT_TERMS_6= "//div[contains(text(), 'I authorize Global Excel (including its representatives or affiliates) to disclose to TD Life and/or TD H&A any information relating to this claim that it may have in its possession including information it obtains from third parties. I am aware that any authorization I provide to Global Excel to obtain information about this claim from any third party is also an authorization for TD Life and/or TD H&A to obtain copies of the information.')]";
    private static final String LO_TXT_TERMS_7= "//div[contains(text(), 'I also authorize the Insurer, its reinsurers and its respective agents to exchange and/or transmit information concerning this claim to the organizations listed above as is necessary to evaluate this claim. This consent shall be valid during the continuation of such claim.')]";
    private static final String LO_TXT_TERMS_8= "//div[contains(text(), 'I hereby authorize and request any physician, hospital, clinic, individual, law enforcement or government organization, insurance company, worker’s compensation body, current or former employer, or other entity that has any personal and medical records, information or knowledge in regard to the Insured Person, if other than the Claimant, or where applicable, to release and provide full details (including furnishing copies) of all available personal and medical information records and knowledge, including prior medical history, toxicological or pathological findings which they may possess to with TD Life and its administrator Global Excel, its re-insurers or their respective agents. This information is to be used in the evaluation of an insurance claim and for purposes relating to such claim.')]";
    private static final String LO_TXT_TERMS_9= "//div[contains(text(), 'I agree to provide all necessary assistance to secure the rights and remedies to subrogation of the claim against third parties who may be responsible for the claim.')]";
    private static final String LO_TXT_TERMS_10= "//div[contains(text(), 'I understand that if I am a dependent under this insurance coverage, the named Insured Person will have access to information related to this claim in connection with the administration of this plan.')]";
    private static final String LO_TXT_TERMS_11= "//div[contains(text(), 'I agree that a photocopy or facsimile of this authorization shall be valid as the original and that this authorization shall be considered valid for the duration of this claim, but not to exceed two years from the date it is signed. I understand information about me may be reviewed in the event that this plan is audited.')]";
    private static final String LO_BUT_I_AGREE = "//label[contains(text(), 'I agree to all')]";
    private static final String LO_BUT_SUBMIT_ACTIVE = "//div//button[not(@disabled) and span/span/following-sibling::span[text()='Submit']]";
    private static final String LO_TXT_REVIEW_INFORMATION_BEFORE_SUBMITTING_CLAIM_PARAGRAPH = "//div[p[contains(text(), 'Please review all the information about your claim before submitting it.')]]";
    private static final String LO_TXT_ITEM1_HEADING = "//div[p/strong[contains(text(), 'Expense Item 1')]]";
    private static final String LO_TXT_CLIENT_SIGNATURE_HEADING = "//h2[contains(text(), 'CLIENT SIGNATURE')]";
    private static final String LO_BUT_SAVE_AS_DRAFT = "//span//span[contains(text(),'Save as Draft')]";
    private static final String LO_TXT_GLOBAL_INSURANCE_TYPE = "//div[div[span[contains(text(), 'Insurance Type')]]]";
    private static final String LO_TXT_ABOUT_THE_INSURED = "//h2[contains(text(), 'ABOUT THE INSURED')]";
    private static final String LO_TXT_GLOBAL_INSURANCE_TYPE_FOLLOWING_POLICY_NUMBER = "//div[div//strong[text()='Insurance Type'] and following-sibling::div[div//strong[text()='Policy Number/Certificate ID']]]";
    private static final String LO_TXT_GLOBAL_INSURANCE_TYPE_FOLLOWING_GROUP_NAME = "//div[div//strong[text()='Insurance Type'] and following-sibling::div[div//strong[text()='Group name']]]";
    private static final String LO_TXT_GLOBAL_FIRST_6_DIGITS = "//div[div[span[contains(text(), 'First 6 Digits')]]]";
    private static final String LO_TXT_GLOBAL_LAST_4_DIGITS = "//div[div[span[contains(text(), 'Last 4 Digits')]]]";
    private static final String LO_TXT_NAME = "//div[div/span[contains(text(), 'Name')]]";
    private static final String LO_TXT_DATE_OF_BIRTH = "//div[div/span[contains(text(), 'Date of Birth')]]";
    private static final String LO_TXT_PHONE_NUMBER = "//div[div/span[contains(text(), 'Phone Number')]]";
    private static final String LO_TXT_EMAIL = "//div[div/span[contains(text(), 'Email')]]";
    private static final String LO_TXT_ADDRESS_STREET_CITY_PROVINCE_COUNTRY_PASTAL_CODE = "//div/p[contains(text(), '825 Ontario, WellandOntario, ')]";
    private static final String LO_TXT_GLOBAL_THE_INSURED = "//div[div//strong[text()='The Insured']and following-sibling::div[div//strong[text()='Other Insured Person(s)']]]";
    private static final String LO_TXT_GLOBAL_OTHER_INSURED_PERSONS = "//div[div//strong[text()='Other Insured Person(s)']and following-sibling::div[div//strong[text()='Other Insurance Type']]]";
    private static final String LO_TXT_GLOBAL_OTHER_INSURANCE_TYPE = "//div[div//strong[text()='Other Insurance Type']and preceding-sibling::div[div//strong[text()='Other Insured Person(s)']]]";
    private static final String LO_TXT_GLOBAL_PREFERRED_METHOD_OF_COMMUNICATION = "//div[div[div//span[text()='Preferred Method of Communication']]/following-sibling::div[div//label[contains(text(), 'Email')]]]";
    private static final String LO_TXT_PREFERRED_METHOD_OF_PAYMENT_REIMBURSEMENT = "//div[div[div[div[span[contains(text(), 'Preferred Method of Payment/Reimbursement')]]]]]";
    private static final String LO_TXT_ADDRESS = "//div[span[contains(text(), 'Address')]]/following-sibling::div";
    private static final String LO_TXT_MAILING_ADDRESS_SAME_AS_HOME_ADDRESS = "//div[div[div[div[div[p/strong[contains(text(), \"Mailing address same as home address provided under 'About yourself'\")]]]]]]";
    private static final String LO_TXT_GLOBAL_DATE_OF_LOSS = "//div[div//strong[text()='Date of Loss'] and following-sibling::div[div//strong[text()='Trip Dates']]]";
    private static final String LO_TXT_GLOBAL_TRIP_DATES = "//div[div//strong[text()='Trip Dates'] and following-sibling::div[div//strong[text()='Travelling from']]]";
    private static final String LO_TXT_GLOBAL_TRAVELLING_FROM = "//div[div//strong[text()='Travelling from'] and following-sibling::div[div//strong[text()='Travel destination']]]";
    private static final String LO_TXT_GLOBAL_TRAVEL_DESTINATION = "//div[div[span[contains(text(), 'Travel destination')]]]";
    private static final String LO_TXT_TRIP_DATES_FROM = "//div[div[span[contains(text(), 'Trip Dates')]]]/following-sibling::div/div[div//span[contains(text(), 'From :')]]";
    private static final String LO_TXT_ORIGINAL_TRIP_DATES_FROM = "//div[div[span[contains(text(), 'What were your original trip dates?')]]]/following-sibling::div[//span[text()='From :']]";
    private static final String LO_TXT_ORIGINAL_TRIP_DATES_TO = "//div[div[span[contains(text(), 'What were your original trip dates?')]]]/following-sibling::div[//span[text()='To :']]";
     private static final String LO_TXT_TRIP_DATES_TO = "//div[div[span[contains(text(), 'Trip Dates')]]]/following-sibling::div/div[div//span[contains(text(), 'To :')]]";
    private static final String LO_TXT_GLOBAL_INCIDENT_HAPPENED_AT_TRAVEL_DESTINATION = "//div[div//strong[text()='Incident happened at travel destination'] and following-sibling::div[div//strong[text()='Incident Location']]]";
    private static final String LO_TXT_GLOBAL_INCIDENT_LOCATION = "//div[div//strong[text()='Incident Location'] and following-sibling::div[div//strong[text()='Personal effects in custody(airline,bus,cruise)']]]";
    private static final String LO_TXT_GLOBAL_PERSONAL_EFFECTS_IN_CUSTODY = "//div[div//strong[text()='Personal effects in custody(airline,bus,cruise)'] and following-sibling::div[div//strong[text()='Name of travel provider']]]";
    private static final String LO_TXT_GLOBAL_NAME_OF_TRAVEL_PROVIDER = "//div[div//strong[text()='Name of travel provider'] and following-sibling::div[div//strong[text()='Bags delayed']]]";
    private static final String LO_TXT_GLOBAL_BAGS_DELAYED = "//div[div//strong[text()='Bags delayed'] and following-sibling::div[div//strong[text()='Baggage(s) expected date']]]";
    private static final String LO_TXT_GLOBAL_BAGGAGE_EXPECTED_DATE = "//div[div//strong[text()='Baggage(s) expected date'] and following-sibling::div[div//strong[text()='Baggage(s) received date']]]";
    private static final String LO_TXT_GLOBAL_BAGGAGE_RECEIVED_DATE = "//div[div//strong[text()='Baggage(s) received date'] and following-sibling::div[div//strong[text()='Report filed date']]]";
    private static final String LO_TXT_GLOBAL_REPORT_FILED_DATE = "//div[div//strong[text()='Report filed date'] and following-sibling::div[div//strong[text()='What Happened?']]]";
    private static final String LO_TXT_WHAT_HAPPENED = "//div[div[span[contains(text(), 'What Happened?')]]]";
   private static final String LO_TXT_TYPE_OF_EXPENSE_NEW = "//p[contains(text(), 'OUT-PATIENT EXAM FEES')]";
   private static final String LO_TXT_TYPE_OF_EXPENSE_NEW_AIRLINE_TICKETS = "//p[contains(text(), 'AIRLINE TICKETS')]";
    private static final String LO_TXT_TYPE_OF_EXPENSE_VALUE = "//h5[contains(text(), 'MISC FEES')]";
    private static final String LO_TXT_AMOUNT_BILLED_EQUIV_IN_CAD_VALUE_ZURICH = "//p[contains(text(), '300')]";
    private static final String LO_TXT_AMOUNT_PAID_EQUIV_IN_CAD_VALUE_ZURICH = "(//p[contains(text(), '200')])[1]";
    private static final String LO_TXT_TOTAL_CAD_VALUE_ZURICH = "(//p[contains(text(), '200')])[2]";
    private static final String LO_TXT_INVOICE_DESCRIPTION_ZURICH_BLOOD = "//p[contains(text(), 'Dr. Visit and Blood test')]";
    private static final String LO_TXT_AMOUNT_BILLED_IN_CAD_ZURICH = "//div[div[div[div[div[p[contains(text(), 'Amount Billed in CAD') and text()=':']]]]]]";
    private static final String LO_TXT_AMOUNT_PAID_IN_CAD_ZURICH = "//div[div[div[div[div[p[contains(text(), 'Amount Paid in CAD') and text()=':']]]]]]";
    private static final String LO_TXT_AMOUNT_PAID_EQUIV_IN_CAD_VALUE = "//div[div[span[contains(text(), 'Amount Paid (Equivalent in CAD)')]]]";
    private static final String LO_TXT_AMOUNT_PAID_EQUVIVALENT_IN_NEW = "//p[contains(text(), '1340.9')]";
    private static final String LO_TXT_REFUND_OBTAINED_EQUVIVALENT_IN_NEW = "//p[contains(text(), '402.27')]";
    private static final String LO_TXT_TOTAL_IN_CAD_NEW = "//p[contains(text(), '938.63')]";
    private static final String LO_TXT_INVOICE_DESCRIPTION_TXT_NEW = "//p[contains(text(), 'RT Airfare Vancouver to Montreal')]";
    //private static final String LO_TXT_INVOICE_DESCRIPTION_TXT_NEW = "";
    private static final String LO_TXT_TYPE_OF_EXPENSE = "//div[div[div[div[div[p/strong[contains(text(), 'Type of Expense')]]]]]]";
    private static final String LO_TXT_REFUND_OBTAINED_EQUIV_IN_CAD_VALUE = "//p[contains(text(), '402.27')]";
    private static final String LO_TXT_TOTAL_IN_CAD_VALUE = "//div[div[span[contains(text(), 'Total In CAD')]]]";
    private static final String LO_TXT_INVOICE_DESCRIPTION_VALUE = "//div[div[span[contains(text(), 'Invoice Description')]]]";
    private static final String LO_TXT_DOCUMENT_UPLOAD_NAME1 = "//div[div[span[contains(text(), 'Document Uploaded')]]]";
    private static final String LO_TXT_AMOUNT_PAID_IN_CAD_WITH_DOLLAR_SIGN = "//div[div[div[div[div[p[contains(text(), 'Amount Paid in CAD') and text()=':']]]]]]";
    private static final String LO_TXT_FULL_OR_PARTIAL_REFUND_IN_CAD_WITH_DOLLAR_SIGN = "//div[div[div[div[div[p[contains(text(), 'Full or partial refund in CAD') and text()=':']]]]]]";
    private static final String LO_TXT_TOTAL_AMOUNT_OF_EXPENSES_CLAIMED_WITH_DOLLAR_SIGN = "//div[div[div[div[div[p[contains(text(), 'Total amount of expenses claimed:')]]]]]]";
    private static final String LO_TXT_INTERAC_AS_METHOD_OF_COMMUNICATION = "//div[span[contains(text(), 'Preferred Method of Payment/Reimbursement')]]/following-sibling::div";
    private static final String LO_TXT_TYPE_OF_EXPENSE_TITLE = "//h5[contains(text(), 'MISC FEES')]";
    private static final String LO_TXT_AMOUNT_PAID_EQUIV_IN_CAD = "//div[div[span[contains(text(), 'Amount Paid (Equivalent in CAD)')]]]";
    private static final String LO_TXT_REFUND_OBTAINED_EQUIV_IN_CAD = "//div[span[contains(text(), 'Refund Obtained (Equivalent in CAD)')]]";
    private static final String LO_TXT_TOTAL_IN_CAD = "//div[span[contains(text(), 'Total In CAD')]]";
    private static final String LO_TXT_INVOICE_DESCRIPTION = "//div[span[contains(text(), 'Invoice Description')]]";
    private static final String LO_TXT_DOCUMENT_UPLOAD_TITLE = "//div[span[contains(text(), 'Document Upload')]]";
    private static final String LO_TXT_AMOUNT_PAID_EQUIV_CAD = "//div[div[div[div[div[span[contains(text(), 'Amount Paid (Equivalent in CAD)')]]]]]]";
    private static final String LO_TXT_REFUND_OBTAINED_EQUIV_CAD = "//div[div[div[div[div[span[contains(text(), 'Refund Obtained (Equivalent in CAD)')]]]]]]";
    private static final String LO_TXT_TOTAL_AMOUNT_OF_EXPESNES_CLAIMED_EQUIV_CAD = "//div[div[div[div[div[span[contains(text(), 'Total Amount of Expenses Claimed')]]]]]]";
    private static final String LO_TXT_GLOBAL_AMOUNT_PAID = "//div[div[div[div[div[p[contains(text(), 'Amount Paid in CAD')]]]]]]";
    private static final String LO_TXT_TOTAL_AMOUNT_OF_EXPENSES_CLAIMED = "//div[div[div[div[div[p[contains(text(), 'Total amount of expenses claimed:')]]]]]]";
    private static final String LO_TXT_GLOBAL_REFUND_OBTAINED = "//div[div[div[div[div[p[contains(text(), 'Full or partial refund in CAD')]]]]]]";
    private static final String LO_TXT_GLOBAL_TOTAL_AMOUNT_OF_EXPENSES_CLAIMED_WITHOUT_DOTS = "//div[div//strong[text()='Total Amount of Expenses Claimed'] and preceding-sibling::div[div//strong[text()='Refund Obtained (Equivalent in CAD)']]]";
    private static final String LO_TXT_GLOBAL_PREFERRED_METHOD_OF_PAYMENT_REIMBURSEMENT = "//div[div//strong[text()='Preferred Method of Payment/Reimbursement'] and following-sibling::div[div//strong[text()='Mailing address']]]";
    private static final String LO_TXT_MAILING_ADDRESS_SAME_AS_HOME_ADDRESS_PROVIDED = "//div[span[contains(text(), \"Mailing address same as home address provided under 'About yourself'\")]]/following-sibling::div";
    private static final String LO_TXT_MAILING_ADDRESS_SAME_AS_HOME_ADDRESS_SAME_AS_QUESTION = "//div[div[span[contains(text(), 'Is the mailing address the same as your home address?')]]]";
    private static final String LO_TXT_GLOBAL_REASON_FOR_DELAY = "//div[span[contains(text(), 'Reason for delay')]]/following-sibling::div";
    private static final String LO_TXT_MAILING_ADDRESS = "//div[div[span[text()='Mailing address']]]";
    private static final String LO_BUT_SAVE_AS_DRAFT_SCROLLED_TO= "//span[contains(text(), 'Save as Draft')]";
    private static final String LO_TXT_GLOBAL_GLOBAL_EXCEL_CLAIM_NUMBER = "//div[span[contains(text(), 'Global Excel Claim Number')]]/following-sibling::div";
    private static final String LO_TXT_GLOBAL_WHEN_DID_THE_INCIDENT_OCCUR = "//div[div//strong[text()='When did the incident occur?'] and following-sibling::div[div//strong[text()='Travelling from']]]";
    private static final String LO_TXT_GLOBAL_WHEN_WAS_YOUR_SCHEDULED_DATE_AND_DEPARTURE_TIME = "//div[div//strong[text()='When was your scheduled date and departure time?'] and following-sibling::div[div//strong[text()='When was your actual date and departure time?']]]";
    private static final String LO_TXT_GLOBAL_WHEN_WAS_YOUR_ACTUAL_DATE_AND_DEPARTURE_TIME = "//div[div//strong[text()='When was your actual date and departure time?'] and following-sibling::div[div//strong[text()='Flight/Trip was delayed for: ']]]";
    private static final String LO_TXT_GLOBAL_FLIGHT_TRIP_WAS_DELAYED_FOR = "//div[div//strong[text()='Flight/Trip was delayed for: '] and following-sibling::div[div//strong[text()='Did your flight or trip delay cause you to miss a connection? ']]]";
    private static final String LO_TXT_GLOBAL_DID_YOUR_FLIGHT_OR_TRIP_DELAY_CAUSE_YOU_TO_MISS_A_CONNECTION = "//div[div//strong[text()='Did your flight or trip delay cause you to miss a connection? '] and following-sibling::div[div//strong[text()='What Happened?']]]";
    private static final String LO_TXT_GLOBAL_EMAIL_ADDRESS = "//div[div//strong[text()='Email Address'] and preceding-sibling::div[div//strong[text()='Preferred Method of Payment/Reimbursement']]]";
    private static final String LO_TXT_GLOBAL_TRAVELLING_FROM_PRECEDING_INCIDENT_OCCURANCE = "//div[div//strong[text()='Travelling from'] and preceding-sibling::div[div//strong[text()='When did the incident occur?']]]";
    private static final String LO_TXT_GLOBAL_WHAT_HAPPENED_FOR_FLIGHT_DELAY = "//div[div//strong[text()='What Happened?']and preceding-sibling::div[div//strong[text()='Did your flight or trip delay cause you to miss a connection? ']]]";
    private static final String LO_TXT_GLOBAL_PREFERRED_METHOD_OF_PAYMENT_REIMBURSEMENT_ON_FLIGHT_DELAY = "//div[div//strong[text()='Preferred Method of Payment/Reimbursement'] and following-sibling::div[div//strong[text()='Email Address']]]";
    private static final String LO_TXT_INCIDENT_DATE = "//div[div[span[contains(text(), 'When did the incident occur?')]]]";
    private static final String LO_TXT_INCIDENT_DATE_NEW = "//div[div[span[contains(text(), 'Incident Date')]]]";
    private static final String LO_TXT_DATES_OF_OTHER_RENTAL_PERIOD = "//div[div[span[contains(text(), 'What were the dates of the other rental period?')]]]";
    private static final String LO_TXT_CANCELLATION_DATE = "//div[div[span[contains(text(), 'Cancellation Date')]]]";
    private static final String LO_TXT_GLOBAL_NAME_OF_HOTEL_MOTEL = "//div[div//strong[text()='Name of Hotel/Motel:'] and following-sibling::div[div//strong[text()='Hotel/Motel Address is:']]]";
    private static final String LO_TXT_GLOBAL_HOTEL_MOTEL_ADDRESS = "//div[div//strong[text()='Hotel/Motel Address is:'] and following-sibling::div[div//strong[text()='What Happened?']]]";
    private static final String LO_TXT_GLOBAL_WHAT_HAPPENED_FOR_HOTEL = "//div[div//strong[text()='What Happened?']and preceding-sibling::div[div//strong[text()='Hotel/Motel Address is:']]]";
    private static final String LO_TXT_GLOBAL_REASON_FOR_CLAIM = "//div[span[contains(text(), 'Reason for Claim')]]/following-sibling::div";
    private static final String LO_TXT_GLOBAL_GLOBAL_INSURANCE_COMPANY = "//div[div//strong[text()='Insurance Company'] and following-sibling::div[div//strong[text()='Policy Number/Certificate ID']]]";
    private static final String LO_TXT_GLOBAL_POLICY_NUMBER_CERTIFICATE_ID = "//div[div//strong[text()='Policy Number/Certificate ID'] and following-sibling::div[div//strong[text()='The Insured']]]";
    private static final String LO_TXT_GLOBAL_GLOBAL_EXCEL_CLAIM_NUMBER_FOR_BAGGAGE_LOSS = "//div[div//strong[text()='Global Excel Claim Number'] and preceding-sibling::div[div//strong[text()='Reason for Claim']]]";
    private static final String LO_TXT_GLOBAL_INSURANCE_TYPE_FOR_BAGGAGE_LOSS = "//div[div//strong[text()='Insurance Type'] and following-sibling::div[div//strong[text()='Insurance Company']]]";
    private static final String LO_TXT_GLOBAL_INCIDENT_HAPPENED_AT_TRAVEL_DESTINATION_FOR_BAGGAGE_LOSS = "//div[div//strong[text()='Incident happened at travel destination'] and following-sibling::div[div//strong[text()='Personal effects in custody(airline,bus,cruise)']]]";
    private static final String LO_TXT_GLOBAL_PERSONAL_EFFECTS_IN_CUSTODY_FOR_BAGGAGE_LOSS = "//div[div//strong[text()='Personal effects in custody(airline,bus,cruise)'] and following-sibling::div[div//strong[text()='Report filed date']]]";
    private static final String LO_TXT_GLOBAL_MAIN_REASON_FOR_CANCELLING_YOUR_TRIP = "//div[div[span[contains(text(), 'Main Reason for Cancelling your Trip')]]]";
    private static final String LO_TXT_GLOBAL_MAIN_REASON_FOR_INTERRUPTION_NEW = "//div[div[span[contains(text(), 'Main Reason for Interruption')]]]";
    private static final String LO_TXT_TRAVEL_STATUS_CANCELLATION_REASON_HEADER = "//h3[contains(text(), 'TRAVEL STATUS & CANCELLATION REASON')]";
    private static final String LO_TXT_OTHER_INSURED_PERSON_HEADER = "//h2[contains(text(), 'OTHER INSURED PERSON(S)')]";
    private static final String LO_TXT_NO_CLAIMING_FOR_OTHER_INSURED_PERSON = "//div/p[contains(text(), 'I') and strong[contains(text(), 'am not')] and text()='claiming for any other insured person']";
     private static final String LO_TXT_NO_OTHER_INSURANCE_TYPE = "//div[p[contains(text(), \"I don't have any other insurance.\")]]";
    private static final String LO_TXT_GLOBAL_OTHER_DUE_TO = "//div[div[span[contains(text(), 'Other due to')]]]";
    private static final String LO_BUT_ENABLED = "//button[not(@disabled) and span//span[contains(text(), 'Submit')]]";
    private static final String LO_TXT_GLOBAL_GLOBAL_EXCEL_CLAIM_NUMBER_FOR_PRECEDING_OTHER_DUE_TO = "//div[div//strong[text()='Global Excel Claim Number'] and preceding-sibling::div[div//strong[text()='Other due to']]]";
    private static final String LO_TXT_GLOBAL_TRIP_DATES_FOLLOWING_TRAVEL_DESTINATION = "//div[div//strong[text()='Trip Dates'] and following-sibling::div[div//strong[text()='Travel destination']]]";
    private static final String LO_TXT_GLOBAL_TRAVEL_DESTINATION_FOLLOWING_INCIDENT_DATE = "//div[div//strong[text()='Travel destination'] and following-sibling::div[div//strong[text()='Incident Date']]]";
    private static final String LO_TXT_GLOBAL_INCIDENT_DATE_FOLLOWING_CANCELLATION_DATE = "//div[div//strong[text()='Incident Date'] and following-sibling::div[div//strong[text()='Cancellation Date']]]";
    private static final String LO_TXT_GLOBAL_CANCELLATION_DATE_FOLLOWING_TRIP_PURCHASE_DATE = "//div[div//strong[text()='Cancellation Date'] and following-sibling::div[div//strong[text()='Trip Purchase Date']]]";
    private static final String LO_TXT_GLOBAL_TRIP_PURCHASE_DATE = "//div[div[span[contains(text(), 'Trip Purchase Date')]]]";
    private static final String LO_TXT_GLOBAL_WHAT_HAPPENED_PREDEDING_TRIP_PURCHASE_DATE = "//div[div//strong[text()='What Happened?']and preceding-sibling::div[div//strong[text()='Trip Purchase Date']]]";
    private static final String LO_TXT_GLOBAL_ASSIGNMENT_OF_BENEFIT = "//div[div//strong[text()='Assignment of Benefit'] and following-sibling::div[div//strong[text()='Preferred Method of Payment/Reimbursement']]]";
    private static final String LO_TXT_GLOBAL_GROUP_NAME = "//div[div//strong[text()='Group name'] and following-sibling::div[div//strong[text()='Policy Number/Certificate ID']]]";
    private static final String LO_TXT_GLOBAL_POLICY_REFUND_OBTAINED_EQUIVALENT_IN_CAD_WITH_SPACE = "//div[div//strong[text()='Refund Obtained (Equivalent in CAD)'] and following-sibling::div[div//strong[text()='Total Amount of Expenses Claimed ']]]";
    private static final String LO_TXT_GLOBAL_TOTAL_AMOUNT_OF_EXPENSES_CLAIMED_WITH_SPACE = "//div[div//strong[text()='Total Amount of Expenses Claimed '] and preceding-sibling::div[div//strong[text()='Refund Obtained (Equivalent in CAD)']]]";
    private static final String LO_TXT_GLOBAL_MAIN_REASON_FOR_CANCELLING_YOUR_TRIP_MEDICAL = "//div[div//strong[text()='Main Reason for Cancelling your Trip'] and following-sibling::div[div//strong[text()='Medical due to']]]";
    private static final String LO_TXT_GLOBAL_MEDICAL_DUE_TO = "//div[div//strong[text()='Medical due to'] and following-sibling::div[div//strong[text()='Global Excel Claim Number']]]";
    private static final String LO_TXT_GLOBAL_GLOBAL_EXCEL_CLAIM_NUMBER_FOR_PRECEDING_MEDICAL_DUE_TO = "//div[div//strong[text()='Global Excel Claim Number'] and preceding-sibling::div[div//strong[text()='Medical due to']]]";
    private static final String LO_TXT_GLOBAL_CLAIM_TYPE = "//div[div//strong[text()='Claim Type '] and following-sibling::div[div//strong[text()='Province']]]";
    private static final String LO_TXT_GLOBAL_CLAIM_TYPE_FOLLOWING_GLOBAL_EXCEL_CLAIM_NUMBER = "//div[div//strong[text()='Claim Type '] and following-sibling::div[div//strong[text()='Global Excel Claim Number']]]";
    private static final String LO_TXT_GLOBAL_PROVINCE = "//div[div//strong[text()='Province'] and following-sibling::div[div//strong[text()='Global Excel Claim Number']]]";
    private static final String LO_TXT_GLOBAL_GLOBAL_EXCEL_CLAIM_NUMBER_PRECEDING_PROVINCE = "//div[div//strong[text()='Global Excel Claim Number'] and preceding-sibling::div[div//strong[text()='Province']]]";
    private static final String LO_TXT_GLOBAL_EMPLOYER_NAME = "//div[div//strong[text()='Employer Name'] and following-sibling::div[div//strong[text()='Policy Number/Certificate ID']]]";
    private static final String LO_TXT_GLOBAL_PROVINCIAL_HEALTH_CARD_NUMBER = "//div[div//strong[text()='Provincial Health Card Number']and following-sibling::div[div//strong[text()='Other Insured Person(s)']]]";
    private static final String LO_TXT_GLOBAL_TRAVEL_DESTINATION_FOLLOWING_TRIP_DATES = "//div[div//strong[text()='Travel destination'] and following-sibling::div[div//strong[text()='Trip Dates']]]";
    private static final String LO_TXT_GLOBAL_TRIP_DATES_FOLLOWING_ORIGINAL_RETURN_DATE = "//div[div//strong[text()='Trip Dates'] and following-sibling::div[div//strong[text()='Original Return Date']]]";
    private static final String LO_TXT_GLOBAL_ORIGINAL_RETURN_DATE = "//div[div//strong[text()='Original Return Date'] and following-sibling::div[div//strong[text()='Reason for Consult']]]";
    private static final String LO_TXT_GLOBAL_REASON_FOR_CONSULT = "//div[div//strong[text()='Reason for Consult'] and following-sibling::div[div//strong[text()='First date of treatment']]]";
    private static final String LO_TXT_GLOBAL_FIRST_DATE_OF_TREATMENT = "//div[div//strong[text()='First date of treatment'] and following-sibling::div[div//strong[text()='When did first symptoms appear?']]]";
    private static final String LO_TXT_GLOBAL_WHEN_DID_FIRST_SYMPTOMS_APPEAR = "//div[div//strong[text()='When did first symptoms appear?'] and following-sibling::div[div//strong[text()='What Happened?']]]";
    private static final String LO_TXT_GLOBAL_WHAT_HAPPENED_PRECEDING_WHEN_DID_FIRST_SYMPTOMS_APPEAR = "//div[div//strong[text()='What Happened?'] and preceding-sibling::div[div//strong[text()='When did first symptoms appear?']]]";
    private static final String LO_TXT_GLOBAL_EXPENSES = "//div[div//strong[text()='Expenses'] and following-sibling::div[div//strong[text()='Expense Item 1']]]";
    private static final String LO_TXT_GLOBAL_EXPENSE_ITEM_1 = "//div[div//strong[text()='Expense Item 1'] and following-sibling::div[div//strong[text()='Amount Billed (Equivalent in CAD)']]]";
    private static final String LO_TXT_GLOBAL_AMOUNT_BILLED_EQUIVALENT_IN_CAD = "//div[div//strong[text()='Amount Billed (Equivalent in CAD)'] and following-sibling::div[div//strong[text()='Amount Paid (Equivalent in CAD)']]]";
    private static final String LO_TXT_GLOBAL_AMOUNT_PAID_EQUIVALENT_IN_CAD = "//div[div//strong[text()='Amount Paid (Equivalent in CAD)'] and following-sibling::div[div//strong[text()='Receipt Included']]]";
    private static final String LO_TXT_GLOBAL_RECEIPT_INCLUDED = "//div[div//strong[text()='Receipt Included'] and preceding-sibling::div[div//strong[text()='Amount Paid (Equivalent in CAD)']]]";
    private static final String LO_TXT_GLOBAL_TOTAL_ESTIMATED_PAID_AMOUNT = "//div[div//strong[text()='Total Estimated Paid Amount (CAD)'] and preceding-sibling::div[div//strong[text()='Amount Paid (Equivalent in CAD)']]]";
    private static final String LO_TXT_GLOBAL_INSURANCE_TYPE_FOLLOWING_EMPLOYER_NAME = "//div[div//strong[text()='Insurance Type'] and following-sibling::div[div//strong[text()='Employer Name']]]";
    private static final String LO_TXT_GLOBAL_PREFERRED_METHOD_OF_PAYMENT_REIMBURSEMENT_FOLLOWING_IS_THE_EMAIL_ADDRESS_THE_SAME = "//div[div//strong[text()='Preferred Method of Payment/Reimbursement'] and following-sibling::div[div//strong[text()=\"Is the email address the same as the Claimant's email address?\"]]]";
    private static final String LO_TXT_GLOBAL_IS_THE_EMAIL_ADDRESS_THE_SAME_AS_THE_CLAIMANTS_EMAIL_ADDRESS = "//div[div//strong[text()=\"Is the email address the same as the Claimant's email address?\"] and following-sibling::div[div//strong[text()='Email Address']]]";
    private static final String LO_TXT_GLOBAL_GLOBAL_EXCEL_CLAIM_NUMBER_PRECEDING_CLAIM_TYPE = "//div[div//strong[text()='Global Excel Claim Number'] and preceding-sibling::div[div//strong[text()='Claim Type ']]]";
    private static final String LO_TXT_GLOBAL_COUNTRY_OF_ORIGIN = "//div[div//strong[text()='Country of Origin']and following-sibling::div[div//strong[text()='Trip Dates']]]";
    private static final String LO_TXT_GLOBAL_TEMPORARY_TRAVEL_DESTINATION = "//div[div//strong[text()='Temporary Travel Destination'] and following-sibling::div[div//strong[text()='Temporary Trip dates']]]";
    private static final String LO_TXT_GLOBAL_TEMPORARY_TRIP_DATES = "//div[div//strong[text()='Temporary Trip dates'] and following-sibling::div[div//strong[text()='Reason for Consult']]]";
    private static final String LO_TXT_GLOBAL_EXCEL_CLAIM_NUMBER = "//div[div[span[contains(text(), 'Global Excel Claim Number')]]]";
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
    private static final String LO_TXT_REASON_FOR_LOSS = "//div[div[span[contains(text(), 'Reason for loss')]]]";
    private static final String LO_TXT_REASON_FOR_CLAIM = "//div[div[span[contains(text(), 'Reason for Claim')]]]";
    private static final String LO_TXT_GLOBAL_GLOBAL_EXCEL_CLAIM_NUMBER_PRECEDING_REASON_FOR_LOSS_WITH_SPACE = "//div[div//strong[text()='Global Excel Claim Number'] and preceding-sibling::div[div//strong[text()='Reason for loss']]]";
    private static final String LO_TXT_GLOBAL_RENTAL_AGENCY_NAME = "//div[span[contains(text(), 'Rental Agency Name:')]]/following-sibling::div";
    private static final String LO_TXT_GLOBAL_WAS_THE_FULL_COST_OF_THE_RENTAL_CHARGED_TO_YOUR_CREDIT_CARD = "//div[span[contains(text(), 'Was the full cost of the rental charged to your credit card?')]]/following-sibling::div";
    private static final String LO_TXT_GLOBAL_DID_YOU_HAVE_ANOTHER_RENTAL_AGREEMENT_WITHIN_A_48H_PERIOD_FROM_THE_START_OR_THE_END_OF_THIS_CURRENT_RENTAL = "//div[span[contains(text(), 'Did you have another rental agreement within a 48h period from the start or the end of this current rental?')]]/following-sibling::div";
    private static final String LO_TXT_GLOBAL_WHEN_DID_THE_INCIDENT_OCCUR_FOLLOWING_WAS_THE_POLICY_HOLDER_THE_DRIVER = "//div[div//strong[text()='When did the incident occur?'] and following-sibling::div[div//strong[text()='Was the Policyholder the driver at the time of incident? ']]]";
    private static final String LO_TXT_GLOBAL_WAS_THE_POLICY_HOLDER_THE_DRIVER_AT_THE_TIME_OF_INCIDENT = "//div[span[contains(text(), 'Was the Policyholder the driver at the time of incident? ')]]/following-sibling::div";
    private static final String LO_TXT_GLOBAL_DID_THE_INCIDENT_INVOLVE_ANOTHER_VEHICLE = "//div[span[contains(text(), 'Did the incident involve another vehicle? ')]]/following-sibling::div";
    private static final String LO_TXT_GLOBAL_EMPLOYER_NAME_FOLLOWING_THE_INSURED = "//div[div//strong[text()='Employer Name'] and following-sibling::div[div//strong[text()='The Insured']]]";
    private static final String LO_TXT_GLOBAL_PLAN_NUMBER = "//div[div//strong[text()='Plan Number'] and following-sibling::div[div//strong[text()='The Insured']]]";
    private static final String LO_TXT_GLOBAL_THE_INSURED_FOLLOWING_OTHER_INSURED_PERSONS = "//div[div/span[contains(text(), 'Name')]]";
    private static final String LO_TXT_NAMES= "//div[div[span[text()='Name']]]";
    private static final String LO_TXT_GLOBAL_DESCRIPTION_OF_DAMAGE = "//div[div//strong[text()='Description of Damage :'] and following-sibling::div[div//strong[text()='What Happened?']]]";
    private static final String LO_TXT_GLOBAL_MAIN_REASON_FOR_INTERRUPTION = "//div[div//strong[text()='Main Reason for Interruption'] and following-sibling::div[div//strong[text()='Deceased Person Insurance']]]";
     private static final String LO_TXT_DECEASED_PERSON_INSURANCE_NEW = "//div[div[span[contains(text(), 'Deceased Person Insurance')]]]";
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
    private static final String LO_TXT_GLOBAL_DATE_OF_INJURY = "//div[div//strong[text()='Date of Injury'] and following-sibling::div[div//strong[text()='Incident Location']]]";
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
    private static final String LO_TXT_EMAIL_AS_PREFERRED_METHOD_COMMUNICATION = "//div[div[div[p[span[contains(text(), 'Preferred Method of Communication')]]]]]/following-sibling::div[div//div[label[contains(text(), 'Email')] and input[@checked]]]";
    private static final String LO_TXT_EMAIL_AUTHORIZATION_PARAGRAPH = "//div[p[contains(text(), 'I authorize Global Excel to communicate with me regarding my claim using this e-mail address with the understanding that these communications may contain personal information.')]]";
    private static final String LO_TXT_PHONE_NUMBER_AS_POSSIBLE_METHOD_COMMUNICATION = "//div[div[div[p[span[contains(text(), 'Preferred Method of Communication')]]]]]/following-sibling::div[div//div[label[contains(text(), 'Mobile Phone Number - +1-')] and not(input[@checked])]]";
    private static final String LO_TXT_MOBILE_PHONE_NUMBER_AUTHORIZATION_PARAGRAPH = "//div[p[contains(text(), 'I authorize Global Excel to communicate with me regarding my claim using this phone number with the understanding that these communications may contain personal information.')]]";
    private static final String LO_TXT_AMOUNT_PAID_IN_CAD_WITH_C$ = "//div[div[div[div[div[p[text()='Amount Paid in CAD' and text()=':']]]]]]";
    private static final String LO_TXT_FULL_OR_PARTIAL_REFUND_OBTAINED_IN_CAD_WITH_C$ = "//div[div[div[div[div[p[text()='Full or partial refund in CAD' and text()=':']]]]]]";
    private static final String LO_TXT_TOTAL_AMOUNT_OF_EXPENSES_CLAIMED_IN_CAD_WITH_C$ = "//div[div[div[div[div[p[text()='Total amount of expenses claimed:']]]]]]";
    private static final String LO_TXT_NOT_CLAIMING_FOR_OTHER = "//p[contains(text(), 'I') and strong='am not' and text()='claiming for any other insured person']";
    private static final String LO_TXT_DONT_HAVE_ANY_OTHER_INSURANCE = "//p[contains(text(), \"I don't have any other insurance.\")]";
    private static final String LO_TXT_WHERE_DID_THE_INCIDENT_OCCUR_REVIEW_PAGE = "//div[span[contains(text(), 'When did the incident occur?')]]/following-sibling::div";
     private static final String LO_TXT_WHAT_HAPPENED_REVIEW_PAGE = "//div[span[contains(text(), 'What Happened?')]]/following-sibling::div";
     private static final String LO_TXT_EMAIL_REVIEW_PAGE = "//div[span[contains(text(), 'Email Address')]]/following-sibling::div";
      private static final String LO_TXT_REASON_FOR_CONSULT= "//div[span[contains(text(), 'Reason for Consult')]]/following-sibling::div";
    private static final String LO_TXT_ORIGINAL_RETURN_DATE= "//div[span[contains(text(), 'Original Return Date')]]/following-sibling::div";
    private static final String LO_TXT_FIRST_DATE_OF_TREATMENT= "//div[span[contains(text(), 'First date of treatment')]]/following-sibling::div";
    private static final String LO_TXT_FIRST_SYMPTOMS_APPEARANCE= "//div[span[contains(text(), 'When did first symptoms appear?')]]/following-sibling::div";
    private static final String LO_TXT_INCURRED_EXPENSES_TITLE= "//h3[contains(text(), 'INCURRED EXPENSES')]";
    private static final String LO_TXT_TRANSIT_NUMBER_ZURICH= "//div[span[contains(text(), 'Transit Number')]]/following-sibling::div";
    private static final String LO_TXT_INSTITUTION_NUMBER_ZURICH= "//div[span[contains(text(), 'Institution Number')]]/following-sibling::div";
    private static final String LO_TXT_ACCOUNT_NUMBER_ZURICH= "//div[span[contains(text(), 'Account Number')]]/following-sibling::div";
    private static final String LO_TXT_DOC_ITEMIZED_RECEIPTS_BILLS_INVOICES= "//p[contains(text(), 'Itemized receipts for bills and invoices')]";
    private static final String LO_TXT_TYPE_OF_EXPENSE_TITLE_MED= "//span[contains(text(), 'Expense Type')]";
    private static final String LO_TXT_AMOUNT_BILLED_EQUIV_IN_CAD_TITLE_MED= "//span[contains(text(), 'Amount Billed (Equivalent in CAD)')]";
    private static final String LO_TXT_AMOUNT_PAID_EQUIV_IN_CAD_TITLE_MED= "//span[contains(text(), 'Amount Paid (Equivalent in CAD)')]";
    private static final String LO_TXT_TOTAL_IN_CAD_TITLE_MED= "//span[contains(text(), 'Total In CAD')]";
    private static final String LO_TXT_INVOICE_DESCRIPTION_TITLE_MED= "//span[contains(text(), 'Invoice Description')]";
    private static final String LO_TXT_DOCUMENT_UPLOADED_TITLE_MED= "(//div[span[contains(text(), 'Document Uploaded')]])[1]";
    private static final String LO_TXT_DOC_PROOF_OF_TRAVEL= "//p[contains(text(), 'Proof of Travel')]";
    private static final String LO_TXT_DOC_GHIP= "//p[contains(text(), 'Government Health Insurance Plan Form (GHIP)')]";
    private static final String LO_TXT_DOC_MEDICAL_RECORDS_INCLUDING_COMPLETE_DIAGNOSIS= "//p[contains(text(), 'Medical Records including complete diagnosis by attending physician')]";
    String LO_TXT_H2_EDIT_BUTTON = "//div[h2[contains(text(),";
    String LO_TXT_H2_HEADING = "//div[h2[contains(text(),";
    String LO_TXT_H3_EDIT_BUTTON = "//div[div[h3[span[contains(text(),";
    String LO_TXT_H3_HEADING = "//div[div[h3[span[contains(text(),";
    String LO_TXT_INCURRED_EXPENSE_SUB_TITLE_EXPENSE_REIMBURSEMENT_PAGE = "//div[div[div[div[div[span[contains(text(),";
    String LO_TXT_INCURRED_EXPENSE_VALUE_EXPENSE_REIMBURSEMENT_PAGE = "//div[p[contains(text(),";





    /**
     * Define the Page Object (PO) constructor.
     * 
     * @param driver The WebDriver object passed from the test method.
     */
    // [Note: Automation Engineer, rename this Page Object (PO) class to match the
    // filename.]
    public PO_Review_And_Submit_Claim(WebDriver driver) {
        super(driver);
    }

    /**
     * Scrolls at a given locator.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String scrollTop() {
        String result = scrollToLocator(LO_TXT_REVIEW_AND_SUBMIT_CLAIM_PAGE_VERIFY);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String verifyDocumentUploadedHeadingMED() {
        String result = validateLocatorExists(LO_TXT_DOCUMENT_UPLOADED_TITLE_MED, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
     public String verifyDocumentProofOfTravel() {
        String result = validateLocatorExists(LO_TXT_DOC_PROOF_OF_TRAVEL, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String verifyDocumentGHIP() {
        String result = validateLocatorExists(LO_TXT_DOC_GHIP, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String verifyEditButtonForH2Heading(String h2Text) {
        LO_TXT_H2_EDIT_BUTTON= LO_TXT_H2_EDIT_BUTTON + "'" + h2Text + "')]]/following-sibling::div[div//button[span//span[contains(text(), 'edit')]]]";
        String result = validateLocatorExists(LO_TXT_H2_EDIT_BUTTON, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        LO_TXT_H2_EDIT_BUTTON="//div[h2[contains(text(),";
        return result;
    }

    public String verifyYouAreNotClaimingForOtherInsuredPersons() {
        String result = validateLocatorExists(LO_TXT_NOT_CLAIMING_FOR_OTHER, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        LO_TXT_H2_EDIT_BUTTON="//div[h2[contains(text(),";
        return result;
    }

    public String verifyYouDontHaveAnyOtherInsurance() {
        String result = validateLocatorExists(LO_TXT_DONT_HAVE_ANY_OTHER_INSURANCE, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        LO_TXT_H2_EDIT_BUTTON="//div[h2[contains(text(),";
        return result;
    }

    public String verifyEditButtonForH3Heading(String h3Text) {
        LO_TXT_H3_EDIT_BUTTON= LO_TXT_H3_EDIT_BUTTON + "'" + h3Text + "')]]]]/following-sibling::div[div//strong[contains(text(), 'EDIT')]]";
        String result = validateLocatorExists(LO_TXT_H3_EDIT_BUTTON, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        LO_TXT_H3_EDIT_BUTTON="//div[div[h3[span[contains(text(),";
        return result;
    }

    public String verifyItem1Heading() {
        String result = validateLocatorExists(LO_TXT_ITEM1_HEADING, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String verifyEmailAsPreferredMethodOfCommunication(String email) {
        String result = validateWithinLocatorText(LO_TXT_EMAIL_AS_PREFERRED_METHOD_COMMUNICATION,email ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String verifyPhoneNumberAsAPossibleMethodOfCommunication(String phoneNumber) {
        String result = validateWithinLocatorText(LO_TXT_PHONE_NUMBER_AS_POSSIBLE_METHOD_COMMUNICATION,phoneNumber ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String verifyAuthorizationForEmailParagraph() {
        String result = validateLocatorExists(LO_TXT_EMAIL_AUTHORIZATION_PARAGRAPH,  FW_ConfigMgr.getDefaultTimeout(),
        FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String verifyAuthorizationForPhoneNumberParagraph() {
        String result = validateLocatorExists(LO_TXT_MOBILE_PHONE_NUMBER_AUTHORIZATION_PARAGRAPH,  FW_ConfigMgr.getDefaultTimeout(),
        FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String verifyH2Heading(String h2Heading) {
        LO_TXT_H2_HEADING= LO_TXT_H2_HEADING + "'" + h2Heading + "')]]";
        String result = validateLocatorExists(LO_TXT_H2_HEADING, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        LO_TXT_H2_HEADING="//div[h2[contains(text(),";
        return result;
    }

    public String verifyH3Heading(String h3Heading) {
        LO_TXT_H3_HEADING= LO_TXT_H3_HEADING + "'" + h3Heading + "')]]]]";
        String result = validateLocatorExists(LO_TXT_H3_HEADING, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        LO_TXT_H3_HEADING="//div[div[h3[span[contains(text(),";
        return result;
    }

    /**
     * Validates if current webpage is loaded and correct.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String validateOnPage() {
        String result = validateLocatorExists(LO_TXT_REVIEW_AND_SUBMIT_CLAIM_PAGE_VERIFY, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

     public String verifyTravelStatusAndCancellationReasonHeading() {
        String result = validateLocatorExists(LO_TXT_TRAVEL_STATUS_CANCELLATION_REASON_TITLE, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String verifyTravelStatusAndInterruptionReasonHeading() {
        String result = validateLocatorExists(LO_TXT_GLOBAL_MAIN_REASON_FOR_INTERRUPTION_NEW, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String verifyAboutTheInsuredHeading() {
        String result = validateLocatorExists(LO_TXT_ABOUT_THE_INSURED_TITLE, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String verifyOtherInsuredPersonHeading() {
        String result = validateLocatorExists(LO_TXT_OTHER_INSURED_PERSON_TITLE, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String verifyContactInformationHeading() {
        String result = validateLocatorExists(LO_TXT_CONTACT_INFORMATION_TITLE, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String verifyEmailAuthorizationTxt() {
        String result = validateLocatorExists(LO_TXT_EMAIL_AUTHORIZATION_TXT, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String verifyPhoneNumberAuthorizationTxt() {
        String result = validateLocatorExists(LO_TXT_PHONE_NUMBER_AUTHORIZATION_TXT, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String verifyOtherInsuranceTypeHeading() {
        String result = validateLocatorExists(LO_TXT_OTHER_INSURANCE_TYPE_TITLE, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String verifyIDontHaveOtherInsuredPerson() {
        String result = validateLocatorExists(LO_TXT_DONT_HAVE_OTHER_INSURED_PERSON, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String verifyIDontHaveOtherInsuranceType() {
        String result = validateLocatorExists(LO_TXT_DONT_HAVE_OTHER_INSURANCE_TYPE, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String verifyAboutTheEventHeading() {
        String result = validateLocatorExists(LO_TXT_ABOUT_THE_EVENT_TITLE, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String verifyIncuredExpensestHeading() {
        String result = validateLocatorExists(LO_TXT_INCURED_EXPENSES_TITLE, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String verifyTypeOfExpenseHeadingNew() {
        String result = validateLocatorExists(LO_TXT_TYPE_OF_EXPENSE_TITLE_NEW, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String verifyAmountPaidEquiCADHeadingNew() {
        String result = validateLocatorExists(LO_TXT_AMOUNT_PAID_EQUIV_CAD_TITLE_NEW, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String verifyAmountRefundObtainedEquivInCADHeadingNew() {
        String result = validateLocatorExists(LO_TXT_REFUND_OBTAINED_EQUIV_CAD_TITLE_NEW, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String verifyAmountTotalInCADHeadingNew() {
        String result = validateLocatorExists(LO_TXT_TOTAL_IN_CAD_TITLE_NEW, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String verifyInvoiceDescriptionHeadingNew() {
        String result = validateLocatorExists(LO_TXT_INVOICE_DESCRIPTION_TITLE_NEW, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String verifyDocumentUploadedHeadingNew() {
        String result = validateLocatorExists(LO_TXT_DOCUMENT_UPLOADED_TITLE_NEW, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String verifyRequiredDocumentsHeading() {
        String result = validateLocatorExists(LO_TXT_REQUIRED_DOCUMENTS_TITLE, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String verifyReimbursementDetailsHeading() {
        String result = validateLocatorExists(LO_TXT_REIMBURSEMENT_DETAILS_TITLE, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String verifyDocumentProofOfPaymentOriginal() {
        String result = validateLocatorExists(LO_TXT_PROOF_OF_PAYMENT_ORIGINAL, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String verifyDocumentOriginalTravelItenary() {
        String result = validateLocatorExists(LO_TXT_ORIGINAL_TRAVEL_ITENARY, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String verifyDocumentReceiptForOutOfPocketExpenses() {
        String result = validateLocatorExists(LO_TXT_OUT_OF_POCKET_EXPENSES, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String verifyDocumentNewTravelItenary() {
        String result = validateLocatorExists(LO_TXT_NEW_TRAVEL_ITENARY, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String verifyDocumentProofOfCauseOfClaim() {
        String result = validateLocatorExists(LO_TXT_PROOF_OF_CAUSE_OF_CLAIM_DEATH_CERTIFICATE, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String verifyDocumentCreditCardStatement() {
        String result = validateLocatorExists(LO_TXT_CREDIT_CARD_STATEMENT, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String verifyDocumentOriginalBookingInvoice() {
        String result = validateLocatorExists(LO_TXT_ORIGINAL_BOOKING_INVOICE, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String verifyDocumentProofOfCancellation() {
        String result = validateLocatorExists(LO_TXT_PROOF_OF_CANCELLATION, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String verifyDocumentProofOfCauseOfEventNotificationOfEvent() {
        String result = validateLocatorExists(LO_TXT_PROOF_OF_CAUSE_OF_CLAIM_NOTIFICATION_OF_EVENT, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String verifyTermsHeading() {
        String result = validateLocatorExists(LO_TXT_TERMS_TITLE, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String verifyTerms1() {
        String result = validateLocatorExists(LO_TXT_TERMS_1, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String verifyTerms2() {
        String result = validateLocatorExists(LO_TXT_TERMS_2, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String verifyTerms3() {
        String result = validateLocatorExists(LO_TXT_TERMS_3, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String verifyTerms4() {
        String result = validateLocatorExists(LO_TXT_TERMS_4, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String verifyTerms5() {
        String result = validateLocatorExists(LO_TXT_TERMS_5, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String verifyTerms6() {
        String result = validateLocatorExists(LO_TXT_TERMS_6, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String verifyTerms7() {
        String result = validateLocatorExists(LO_TXT_TERMS_7, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String verifyTerms8() {
        String result = validateLocatorExists(LO_TXT_TERMS_8, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String verifyTerms9() {
        String result = validateLocatorExists(LO_TXT_TERMS_9, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String verifyTerms10() {
        String result = validateLocatorExists(LO_TXT_TERMS_10, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String verifyTerms11() {
        String result = validateLocatorExists(LO_TXT_TERMS_11, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String verifySubmitButtonIsActive() {
        String result = validateLocatorExists(LO_BUT_SUBMIT_ACTIVE, FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval());
        if (result.contains("[Pass]")) {
            result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
            return result;
        }
        return "[Fail] - Submit button is not active";
    }
    public String clickIagreeCheckbox() {
        String result = clickLocator(LO_BUT_I_AGREE, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    /**
     * Apply a wait.
     */
    public String applyWait() {
        waitForDuration(10, "s", true);
        String result = "[Pass] - Wait applied.";
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String verifyClientSignatureHeading() {
        String result = validateLocatorExists(LO_TXT_CLIENT_SIGNATURE_HEADING, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String verifyReviewInformationAboutClaimBeforeSubmittingParagraph() {
        String result = validateLocatorExists(LO_TXT_REVIEW_INFORMATION_BEFORE_SUBMITTING_CLAIM_PARAGRAPH, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

     /**
     * Validates Insurance type provided is correct.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String verifyInsuranceType(String insuranceType) {
        String result = validateWithinLocatorText(LO_TXT_GLOBAL_INSURANCE_TYPE,insuranceType ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates Insurance type provided is correct.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String verifyHeaderAboutTheInsured() {
        String result = validateLocatorExists(LO_TXT_ABOUT_THE_INSURED, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Click "Save As Draft" button.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String clickSaveAsDraftButton() {
        clickLocator("//h1[contains(text(), 'Claim Opening')]", FW_ConfigMgr.getDefaultTimeout());
        scrollTo(LO_BUT_SAVE_AS_DRAFT_SCROLLED_TO);
        String result = clickLocator(LO_BUT_SAVE_AS_DRAFT_SCROLLED_TO, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;

    }

    /**
     * Validates If the First 6 Digits of the credit card number entered is correct.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String verifyFirst6Digits(String first6Digits) {
        String result = validateWithinLocatorText(LO_TXT_GLOBAL_FIRST_6_DIGITS,first6Digits ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates If the Last 4 Digits of the credit card number entered is correct.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String verifyLast4Digits(String last4Digits) {
        String result = validateWithinLocatorText(LO_TXT_GLOBAL_LAST_4_DIGITS,last4Digits ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String verifyName(String name) {
        String result = validateWithinLocatorText(LO_TXT_NAME,name ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    /**
     * Validates If the date of birth entered is correct.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String verifyDateOfBirth(String dateOfBirth) {
        String result = validateWithinLocatorText(LO_TXT_DATE_OF_BIRTH,dateOfBirth ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String verifyPhoneNumber(String phoneNumber) {
        String result = validateWithinLocatorText(LO_TXT_PHONE_NUMBER,phoneNumber ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String verifyEmail(String email) {
        String result = validateWithinLocatorText(LO_TXT_EMAIL,email ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String verifyAddressStreetCityProvince(String streetCityProvince) {
        String result = validateWithinLocatorText(LO_TXT_ADDRESS_STREET_CITY_PROVINCE_COUNTRY_PASTAL_CODE,streetCityProvince ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String verifyAddressCountryPostalCode(String countryPostalCode) {
        String result = validateWithinLocatorText(LO_TXT_ADDRESS_STREET_CITY_PROVINCE_COUNTRY_PASTAL_CODE,countryPostalCode ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates If the Insured information entered is correct.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */

    public String verifyTheInsured(String insured) {
        String result = validateWithinLocatorText(LO_TXT_GLOBAL_THE_INSURED,insured ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates If Other Insured Persons is correct.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */

    public String verifyOtherInsuredPersons(String otherInsuredPersons) {
        String result = validateWithinLocatorText(LO_TXT_GLOBAL_OTHER_INSURED_PERSONS,otherInsuredPersons ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates If Other Insurance Type selection is Yes or No.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */

    public String verifyOtherInsuranceType(String otherInsuranceType) {
        String result = validateWithinLocatorText(LO_TXT_GLOBAL_OTHER_INSURANCE_TYPE,otherInsuranceType ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates If the preferred method of communication is correct.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */

    public String verifyPreferredMethodOfCommunication(String preferredMethodOfCommunication) {
        String result = validateWithinLocatorText(LO_TXT_GLOBAL_PREFERRED_METHOD_OF_COMMUNICATION,preferredMethodOfCommunication ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String verifyAddress(String address) {
        String result = validateWithinLocatorText(LO_TXT_ADDRESS,address ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String verifyCountryAndPostalCodeAddress(String address) {
        String result = validateWithinLocatorText(LO_TXT_ADDRESS,address ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String verifyLine1AndLine2CityProvinceAddresses(String address) {
        String result = validateWithinLocatorText(LO_TXT_ADDRESS,address ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String verifyPreferredMethodOfPaymentReimbursement(String preferredMethodOfPaymentReimbursement) {
        String result = validateWithinLocatorText(LO_TXT_PREFERRED_METHOD_OF_PAYMENT_REIMBURSEMENT,preferredMethodOfPaymentReimbursement ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String verifyTransitNumberZurich(String transit_number) {
        String result = validateWithinLocatorText(LO_TXT_TRANSIT_NUMBER_ZURICH,transit_number ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String verifyDocumentItemizedReceiptsForBillsAndInvoices() {
        String result = validateLocatorExists(LO_TXT_DOC_ITEMIZED_RECEIPTS_BILLS_INVOICES, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String verifyDocumentMedicalRecordsIncludingCompleteDiagnosis() {
        String result = validateLocatorExists(LO_TXT_DOC_MEDICAL_RECORDS_INCLUDING_COMPLETE_DIAGNOSIS, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String verifyIstitutionNmberZurich(String transit_number) {
        String result = validateWithinLocatorText(LO_TXT_INSTITUTION_NUMBER_ZURICH,transit_number ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String verifyAccountNmberZurich(String transit_number) {
        String result = validateWithinLocatorText(LO_TXT_ACCOUNT_NUMBER_ZURICH,transit_number ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String verifyMailingAddressSameAsHomeAddress(String mailingAddressSameAsHomeAddress) {
        String result = validateWithinLocatorText(LO_TXT_MAILING_ADDRESS_SAME_AS_HOME_ADDRESS_SAME_AS_QUESTION,mailingAddressSameAsHomeAddress ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates If Date of loss is correct.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */

    public String verifyDateOfLoss(String dateOfLoss) {
        String result = validateWithinLocatorText(LO_TXT_GLOBAL_DATE_OF_LOSS,dateOfLoss ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates If Trip Dates entered are correct.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */

    public String verifyTripDates(String tripDates) {
        String result = validateWithinLocatorText(LO_TXT_GLOBAL_TRIP_DATES,tripDates ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates If "Travelling From" place entered is correct.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */

    public String verifyTravellingFrom(String travellingFrom) {
        String result = validateWithinLocatorText(LO_TXT_GLOBAL_TRAVELLING_FROM,travellingFrom ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates If "Travel Destination" place entered is correct.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */

    public String verifyTravelDestination(String travelDestination) {
        String result = validateWithinLocatorText(LO_TXT_GLOBAL_TRAVEL_DESTINATION,travelDestination ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String verifyTripDatesFrom(String tripDatesFrom) {
        String result = validateWithinLocatorText(LO_TXT_TRIP_DATES_FROM,tripDatesFrom ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String verifyOriginalTripDatesFrom(String tripDatesFrom) {
        String result = validateWithinLocatorText(LO_TXT_ORIGINAL_TRIP_DATES_FROM,tripDatesFrom ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String verifyOriginalTripDatesTo(String tripDatesFrom) {
        String result = validateWithinLocatorText(LO_TXT_ORIGINAL_TRIP_DATES_TO,tripDatesFrom ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String verifyTripDatesTo(String tripDatesTo) {
        String result = validateWithinLocatorText(LO_TXT_TRIP_DATES_TO,tripDatesTo ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String verifyReasonForConsulZurich(String reason_for_consult) {
        String result = validateWithinLocatorText(LO_TXT_REASON_FOR_CONSULT,reason_for_consult ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String verifyOriginalReturnDateZurich(String original_return_date) {
        String result = validateWithinLocatorText(LO_TXT_ORIGINAL_RETURN_DATE,original_return_date ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String verifyFirstDateOfTreatmentZurich(String original_return_date) {
        String result = validateWithinLocatorText(LO_TXT_FIRST_DATE_OF_TREATMENT,original_return_date ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String verifyWhenDidTheFirstSymptomsAppearZurich(String original_return_date) {
        String result = validateWithinLocatorText(LO_TXT_FIRST_SYMPTOMS_APPEARANCE,original_return_date ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates If "Incident happened at travel destination".
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */

    public String verifyIncidentHappenedAtTravelDestination(String incidentHappenedAtTravelDestination) {
        String result = validateWithinLocatorText(LO_TXT_GLOBAL_INCIDENT_HAPPENED_AT_TRAVEL_DESTINATION,incidentHappenedAtTravelDestination ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates If "Incident location" entered is correct.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */

    public String verifyIncidentLocation(String incidentLocation) {
        String result = validateWithinLocatorText(LO_TXT_GLOBAL_INCIDENT_LOCATION,incidentLocation ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates If there were Personal effects in custody(airline,bus,cruise). Yes or No
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */

    public String verifyPersonalEffectsInCustody(String yesToPersonalEffectsInCustody) {
        String result = validateWithinLocatorText(LO_TXT_GLOBAL_PERSONAL_EFFECTS_IN_CUSTODY,yesToPersonalEffectsInCustody ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates If "Name of Travel Provider" entered is correct.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */

    public String verifyNameOfTravelProvider(String nameOfTravelProvider) {
        String result = validateWithinLocatorText(LO_TXT_GLOBAL_NAME_OF_TRAVEL_PROVIDER,nameOfTravelProvider ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates If "Bags Delayed" number is displayed correcty.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */

    public String verifyBagsDelayed(String bagsDelayed) {
        String result = validateWithinLocatorText(LO_TXT_GLOBAL_BAGS_DELAYED,bagsDelayed ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates If "Baggage(s) expected date" is displayed correcty.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */

    public String verifyBagsExpectedDate(String bagsExpectedDate) {
        String result = validateWithinLocatorText(LO_TXT_GLOBAL_BAGGAGE_EXPECTED_DATE,bagsExpectedDate ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates If "Baggage(s) received date" is displayed correcty.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */

    public String verifyBagsReceivedDate(String bagsReceivedDate) {
        String result = validateWithinLocatorText(LO_TXT_GLOBAL_BAGGAGE_RECEIVED_DATE,bagsReceivedDate ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates If "Report filed date" is displayed correcty.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */

    public String verifyReportFiledDate(String reportFiledDate) {
        String result = validateWithinLocatorText(LO_TXT_GLOBAL_REPORT_FILED_DATE,reportFiledDate ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates If "What Happened?" entered is correct.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */

    public String verifyWhatHappened(String whatHappened) {
        String result = validateWithinLocatorText(LO_TXT_WHAT_HAPPENED,whatHappened ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String verifyIncurredExpensesHeading() {
        String result = validateLocatorExists(LO_TXT_INCURRED_EXPENSES_TITLE, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String verifyTypeOfExpenseHeadingMED() {
        String result = validateLocatorExists(LO_TXT_TYPE_OF_EXPENSE_TITLE_MED, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String verifyAmountBilledEquivInCADHeadingMED() {
        String result = validateLocatorExists(LO_TXT_AMOUNT_BILLED_EQUIV_IN_CAD_TITLE_MED, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String verifyAmountPaidEqivInCADHeadingMED() {
        String result = validateLocatorExists(LO_TXT_AMOUNT_PAID_EQUIV_IN_CAD_TITLE_MED, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String verifyTotalInCADHeadingMED() {
        String result = validateLocatorExists(LO_TXT_TOTAL_IN_CAD_TITLE_MED, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String verifyInvoiceDescriptionHeadingMED() {
        String result = validateLocatorExists(LO_TXT_INVOICE_DESCRIPTION_TITLE_MED, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String verifyTypeOfExpenseNew(String typeOfExpenseNew) {
        String result = validateWithinLocatorText(LO_TXT_TYPE_OF_EXPENSE_NEW,typeOfExpenseNew ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String verifyTypeOfExpenseNewAirlineTickets(String typeOfExpenseNew) {
        String result = validateWithinLocatorText(LO_TXT_TYPE_OF_EXPENSE_NEW_AIRLINE_TICKETS,typeOfExpenseNew ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String verifyAmountBilledEquivInCADHeadingMEDValue(String typeOfExpenseNew) {
        String result = validateWithinLocatorText(LO_TXT_AMOUNT_BILLED_EQUIV_IN_CAD_VALUE_ZURICH,typeOfExpenseNew ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String verifyAmountPaidEqivInCADHeadingMEDValue(String typeOfExpenseNew) {
        String result = validateWithinLocatorText(LO_TXT_AMOUNT_PAID_EQUIV_IN_CAD_VALUE_ZURICH,typeOfExpenseNew ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String verifyTotalInCADHeadingMEDValue(String typeOfExpenseNew) {
        String result = validateWithinLocatorText(LO_TXT_TOTAL_CAD_VALUE_ZURICH,typeOfExpenseNew ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String verifyInvoiceDescriptionTxtZurichBlood(String typeOfExpenseNew) {
        String result = validateWithinLocatorText(LO_TXT_INVOICE_DESCRIPTION_ZURICH_BLOOD,typeOfExpenseNew ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String verifyAmountBilledInCADMED(String typeOfExpenseNew) {
        String result = validateWithinLocatorText(LO_TXT_AMOUNT_BILLED_IN_CAD_ZURICH,typeOfExpenseNew ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String verifyAmountPaidInCADMED(String typeOfExpenseNew) {
        String result = validateWithinLocatorText(LO_TXT_AMOUNT_PAID_IN_CAD_ZURICH,typeOfExpenseNew ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String verifyAmountPaidEquivInCADNew(String typeOfExpenseNew) {
        String result = validateWithinLocatorText(LO_TXT_AMOUNT_PAID_EQUVIVALENT_IN_NEW,typeOfExpenseNew ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String verifyRefundObtainedEquivInCADNew(String refundObtained) {
        String result = validateWithinLocatorText(LO_TXT_REFUND_OBTAINED_EQUVIVALENT_IN_NEW,refundObtained ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String verifyTotalInCADNew(String refundObtained) {
        String result = validateWithinLocatorText(LO_TXT_TOTAL_IN_CAD_NEW,refundObtained ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String verifyInvoiceDescriptionTxtNew(String refundObtained) {
        String result = validateWithinLocatorText(LO_TXT_INVOICE_DESCRIPTION_TXT_NEW,refundObtained ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    // public String verifyActualUploadedFileNew(String refundObtained) {
    //     String result = validateWithinLocatorText(LO_TXT_ACTUAL_UPLOADED_FILE_NEW,refundObtained ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
    //     result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
    //     return result;
    // }

    /**
     * Validates if "Type of Expense" entered is correct
     * 
     * @return AA string including [PASS] or [FAIL] along with specific result
     *         details.
     */

    public String verifyTypeOfExpense(String typeOfExpense) {
        String result = validateWithinLocatorText(LO_TXT_TYPE_OF_EXPENSE,typeOfExpense ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String verifyTypeOfExpenseValue(String typeOfExpenseValue) {
        String result = validateWithinLocatorText(LO_TXT_TYPE_OF_EXPENSE_VALUE,typeOfExpenseValue ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String verifyAmountPaidEquivInCadValue(String amountPaidEquivInCadValue) {
        String result = validateWithinLocatorText(LO_TXT_AMOUNT_PAID_EQUIV_IN_CAD_VALUE,amountPaidEquivInCadValue ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String verifyRefundObtainedEquivInCadValue(String refundObtainedEquivInCadValue) {
        String result = validateWithinLocatorText(LO_TXT_REFUND_OBTAINED_EQUIV_IN_CAD_VALUE,refundObtainedEquivInCadValue ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String verifyTotalInCadValue(String totalInCadValue) {
        String result = validateWithinLocatorText(LO_TXT_TOTAL_IN_CAD_VALUE,totalInCadValue ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String verifyInvoiceDescriptionValue(String invoiceDescriptionValue) {
        String result = validateWithinLocatorText(LO_TXT_INVOICE_DESCRIPTION_VALUE,invoiceDescriptionValue ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String verifyDocumentUploadName1(String documentUploadName) {
        String result = validateWithinLocatorText(LO_TXT_DOCUMENT_UPLOAD_NAME1,documentUploadName ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String verifyAmountPaidInCADWithDollarSign(String amountPaidInCADWithDollarSign) {
        String result = validateWithinLocatorText(LO_TXT_AMOUNT_PAID_IN_CAD_WITH_DOLLAR_SIGN,amountPaidInCADWithDollarSign ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String verifyFullOrPartialRefundInCADWithDollarSign(String fullOrPartialRefundInCADWithDollarSign) {
        String result = validateWithinLocatorText(LO_TXT_FULL_OR_PARTIAL_REFUND_IN_CAD_WITH_DOLLAR_SIGN,fullOrPartialRefundInCADWithDollarSign ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String verifyTotalAmountOfExpensesClaimedWithDollarSign(String totalAmountOfExpensesClaimedWithDollarSign) {
        String result = validateWithinLocatorText(LO_TXT_TOTAL_AMOUNT_OF_EXPENSES_CLAIMED_WITH_DOLLAR_SIGN,totalAmountOfExpensesClaimedWithDollarSign ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String verifyInteracAsMethodOfCommunication(String interacAsMethodOfCommunication) {
        String result = validateWithinLocatorText(LO_TXT_INTERAC_AS_METHOD_OF_COMMUNICATION,interacAsMethodOfCommunication ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String verifyTypeOfExpenseTitle() {
        String result = validateLocatorExists(LO_TXT_TYPE_OF_EXPENSE_TITLE, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String verifyAmountPaidEquivInCADTitle() {
        String result = validateLocatorExists(LO_TXT_AMOUNT_PAID_EQUIV_IN_CAD, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String verifyRefundObtainedEquivInCADTitle() {
        String result = validateLocatorExists(LO_TXT_REFUND_OBTAINED_EQUIV_IN_CAD, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String verifyTotalInCADTitle() {
        String result = validateLocatorExists(LO_TXT_TOTAL_IN_CAD, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String verifyInvoiceDescriptionTitle() {
        String result = validateLocatorExists(LO_TXT_INVOICE_DESCRIPTION, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String verifyDocumentUploadTitle() {
        String result = validateLocatorExists(LO_TXT_DOCUMENT_UPLOAD_TITLE, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String verifyAmountPaidEquivInCAD(String amountPaidEquivInCad) {
        String result = validateWithinLocatorText(LO_TXT_AMOUNT_PAID_EQUIV_CAD,amountPaidEquivInCad ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String verifyIncurredExpenseSubTitleOnReviewSubmitPage(String incurredExpenseTitle) {
        LO_TXT_INCURRED_EXPENSE_SUB_TITLE_EXPENSE_REIMBURSEMENT_PAGE= LO_TXT_INCURRED_EXPENSE_SUB_TITLE_EXPENSE_REIMBURSEMENT_PAGE + "'" + incurredExpenseTitle + "')]]]]]]";
        String result = validateLocatorExists(LO_TXT_INCURRED_EXPENSE_SUB_TITLE_EXPENSE_REIMBURSEMENT_PAGE, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        clickLocator(LO_TXT_INCURRED_EXPENSE_SUB_TITLE_EXPENSE_REIMBURSEMENT_PAGE, FW_ConfigMgr.getDefaultTimeout());
        LO_TXT_INCURRED_EXPENSE_SUB_TITLE_EXPENSE_REIMBURSEMENT_PAGE ="//div[div[div[div[div[span[contains(text(),";
        return result;
    }

    public String verifyIncurredExpenseValueOnReviewSubmitPage(String incurredExpenseValue) {
        LO_TXT_INCURRED_EXPENSE_VALUE_EXPENSE_REIMBURSEMENT_PAGE= LO_TXT_INCURRED_EXPENSE_VALUE_EXPENSE_REIMBURSEMENT_PAGE + "'" + incurredExpenseValue + "')]]";
        String result = validateLocatorExists(LO_TXT_INCURRED_EXPENSE_VALUE_EXPENSE_REIMBURSEMENT_PAGE, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        clickLocator(LO_TXT_INCURRED_EXPENSE_VALUE_EXPENSE_REIMBURSEMENT_PAGE, FW_ConfigMgr.getDefaultTimeout());
        LO_TXT_INCURRED_EXPENSE_VALUE_EXPENSE_REIMBURSEMENT_PAGE ="//div[p[contains(text(),";
        return result;
    }

    public String verifyAmountPaidInCADWithC$(String amountPaidInCADWithC$) {
        String result = validateWithinLocatorText(LO_TXT_AMOUNT_PAID_IN_CAD_WITH_C$,amountPaidInCADWithC$ ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String verifyFullOrPartialRefundObtaindedInCADWithC$(String fullOrPartialRefundObtainedCADWithC$) {
        String result = validateWithinLocatorText(LO_TXT_FULL_OR_PARTIAL_REFUND_OBTAINED_IN_CAD_WITH_C$,fullOrPartialRefundObtainedCADWithC$ ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String verifyTotalAmountClaimedInCADWithC$(String totalAmountOfExpensesClaimedCADWithC$) {
        String result = validateWithinLocatorText(LO_TXT_TOTAL_AMOUNT_OF_EXPENSES_CLAIMED_IN_CAD_WITH_C$,totalAmountOfExpensesClaimedCADWithC$ ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String verifyRefundObtainedEquivInCAD(String refundObtainedEquivInCad) {
        String result = validateWithinLocatorText(LO_TXT_REFUND_OBTAINED_EQUIV_CAD,refundObtainedEquivInCad ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String verifyTotalAmountOfExpensesClaimedEquivInCAD(String totalAmountOfExpensesClaimedEquivInCad) {
        String result = validateWithinLocatorText(LO_TXT_TOTAL_AMOUNT_OF_EXPESNES_CLAIMED_EQUIV_CAD,totalAmountOfExpensesClaimedEquivInCad ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if "Amount Paid" entered is correct
     * 
     * @return AA string including [PASS] or [FAIL] along with specific result
     *         details.
     */

    public String verifyAmountPaid(String amountPaid) {
        String result = validateWithinLocatorText(LO_TXT_GLOBAL_AMOUNT_PAID,amountPaid ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if "Refund Obtained" entered is correct
     * 
     * @return AA string including [PASS] or [FAIL] along with specific result
     *         details.
     */

    public String verifyRefundObtained(String refundObtained) {
        String result = validateWithinLocatorText(LO_TXT_GLOBAL_REFUND_OBTAINED,refundObtained ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if "Total Amount of Expenses Claimed" entered is correct
     * 
     * @return AA string including [PASS] or [FAIL] along with specific result
     *         details.
     */

    public String verifyTotalAmountOfExpensesClaimed(String totalAmountOfExpensesClaimed) {
        String result = validateWithinLocatorText(LO_TXT_TOTAL_AMOUNT_OF_EXPENSES_CLAIMED,totalAmountOfExpensesClaimed ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if "Mailing Address" entered is correct
     * 
     * @return AA string including [PASS] or [FAIL] along with specific result
     *         details.
     */

    public String verifyMailingAddress(String mailingAddress) {
        String result = validateWithinLocatorText(LO_TXT_MAILING_ADDRESS,mailingAddress ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String scrollToSaveAsDraftButton() {
        typeOnKeyboard("ARROW_UP");
        typeOnKeyboard("ARROW_UP");
        typeOnKeyboard("ARROW_UP");
        typeOnKeyboard("ARROW_UP");
        typeOnKeyboard("ARROW_UP");
        typeOnKeyboard("ARROW_UP");
        typeOnKeyboard("ARROW_UP");
        typeOnKeyboard("ARROW_UP");
        typeOnKeyboard("ARROW_UP");
        typeOnKeyboard("ARROW_UP");
        typeOnKeyboard("ARROW_UP");
        typeOnKeyboard("ARROW_UP");
        return "[Pass]: Scrolled to Save as Draft button";
    }

    public String verifySubmitButtonEnabled() {
        String result = validateLocatorExists(LO_BUT_ENABLED, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        if (true == result.contains("Pass")) {
            result = "[Fail]: Submit button is enabled and it should not be since the 'I agree to all' button is not checked";
        } else {
            result = "[Pass]: Submit button is not enabled";
            
        }
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if "Reason for delay" entered is correct
     * 
     * @return AA string including [PASS] or [FAIL] along with specific result
     *         details.
     */

    public String verifyReasonForDelay(String reasonForDelay) {
        String result = validateWithinLocatorText(LO_TXT_GLOBAL_REASON_FOR_DELAY,reasonForDelay ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if "Global Excel Claim Number" entered is correct
     * 
     * @return AA string including [PASS] or [FAIL] along with specific result
     *         details.
     */

    public String verifyGlobalExcelClaimNumber(String globalExcelClaimNumber) {
        String result = validateWithinLocatorText(LO_TXT_GLOBAL_GLOBAL_EXCEL_CLAIM_NUMBER,globalExcelClaimNumber ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if "When did the incident occur?" entered is correct
     * 
     * @return AA string including [PASS] or [FAIL] along with specific result
     *         details.
     */

    public String verifyWhenDidTheIncidentOccur(String whenDidTheIncidentOccur) {
        String result = validateWithinLocatorText(LO_TXT_GLOBAL_WHEN_DID_THE_INCIDENT_OCCUR,whenDidTheIncidentOccur ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if "When was your scheduled date and departure time?" entered is correct
     * 
     * @return AA string including [PASS] or [FAIL] along with specific result
     *         details.
     */

    public String verifyWhenWasYourScheduledDateAndDepartureTime(String whenWasYourScheduledDateAndDepartureTime) {
        String result = validateWithinLocatorText(LO_TXT_GLOBAL_WHEN_WAS_YOUR_SCHEDULED_DATE_AND_DEPARTURE_TIME,whenWasYourScheduledDateAndDepartureTime ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if "When was your actual date and departure time?" entered is correct
     * 
     * @return AA string including [PASS] or [FAIL] along with specific result
     *         details.
     */

    public String verifyWhenWasYourActualDateAndDepartureTime(String whenWasYourActualDateAndDepartureTime) {
        String result = validateWithinLocatorText(LO_TXT_GLOBAL_WHEN_WAS_YOUR_ACTUAL_DATE_AND_DEPARTURE_TIME,whenWasYourActualDateAndDepartureTime ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if "Flight/Trip was delayed for: " entered is correct
     * 
     * @return AA string including [PASS] or [FAIL] along with specific result
     *         details.
     */

    public String verifyFlightTripWasDelayedFor(String flightTripWasDelayedFor) {
        String result = validateWithinLocatorText(LO_TXT_GLOBAL_FLIGHT_TRIP_WAS_DELAYED_FOR,flightTripWasDelayedFor ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if "Did your flight or trip delay cause you to miss a connection?" entered is correct
     * 
     * @return AA string including [PASS] or [FAIL] along with specific result
     *         details.
     */

    public String verifyDidYourFlightOrTripDelayCauseYouToMissAConnection(String didYourFlightOrTripDelayCauseYouToMissAConnection) {
        String result = validateWithinLocatorText(LO_TXT_GLOBAL_DID_YOUR_FLIGHT_OR_TRIP_DELAY_CAUSE_YOU_TO_MISS_A_CONNECTION,didYourFlightOrTripDelayCauseYouToMissAConnection ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if "Email Address" entered is correct.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */

    public String verifyEmailAddress(String emailAddress) {
        String result = validateWithinLocatorText(LO_TXT_GLOBAL_EMAIL_ADDRESS,emailAddress ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if "Travelling from" entered is correct.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */

    public String verifyTravellingFromPrecedingIncidentOccurance(String travellingFromPrecedingIncidentOccurance) {
        String result = validateWithinLocatorText(LO_TXT_GLOBAL_TRAVELLING_FROM_PRECEDING_INCIDENT_OCCURANCE,travellingFromPrecedingIncidentOccurance ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if "What Happened?" for flight delay was entered is correct.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */

    public String verifyWhatHappenedForFlightDelay(String whatHappenedForFlightDelay) {
        String result = validateWithinLocatorText(LO_TXT_GLOBAL_WHAT_HAPPENED_FOR_FLIGHT_DELAY,whatHappenedForFlightDelay ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if "Preferred Method of Payment/Reimbursement" for flight delay was entered is correct.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */

    public String verifyPreferredMethodOfPaymentOnFlightDelay(String preferredMethodOfPaymentOnFlightDelay) {
        String result = validateWithinLocatorText(LO_TXT_GLOBAL_PREFERRED_METHOD_OF_PAYMENT_REIMBURSEMENT_ON_FLIGHT_DELAY,preferredMethodOfPaymentOnFlightDelay ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /*
        * Validates if "Incident Date" entered is correct.
        * 
        * @return A string including [PASS] or [FAIL] along with specific result
        * details.
        */
    
         public String verifyIncidentDate(String incidentDate) {
              String result = validateWithinLocatorText(LO_TXT_INCIDENT_DATE,incidentDate ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
              result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
              return result;
         }

         public String verifyIncidentDateNew(String incidentDate) {
              String result = validateWithinLocatorText(LO_TXT_INCIDENT_DATE_NEW,incidentDate ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
              result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
              return result;
         }

         public String verifyDatesOfTheOtherRentalPeriod(String incidentDate) {
              String result = validateWithinLocatorText(LO_TXT_DATES_OF_OTHER_RENTAL_PERIOD,incidentDate ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
              result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
              return result;
         }

         public String verifyCancellationDate(String cancellationDate) {
              String result = validateWithinLocatorText(LO_TXT_CANCELLATION_DATE,cancellationDate ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
              result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
              return result;
         }

         /*
        * Validates if "Name of Hotel/Motel" entered is correct.
        *
        * @return A string including [PASS] or [FAIL] along with specific result
        * details.
        */
    
         public String verifyNameOfHotelMotel(String nameOfHotelMotel) {
              String result = validateWithinLocatorText(LO_TXT_GLOBAL_NAME_OF_HOTEL_MOTEL,nameOfHotelMotel ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
              result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
              return result;
         }

         /*
        * Validates if "Hotel/Motel Address is" entered is correct.
        *
        * @return A string including [PASS] or [FAIL] along with specific result
        * details.
        */
    
         public String verifyHotelMotelAddress(String hotelMotelAddress) {
              String result = validateWithinLocatorText(LO_TXT_GLOBAL_HOTEL_MOTEL_ADDRESS,hotelMotelAddress ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
              result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
              return result;
         }

            /*
        * Validates if "What Happened?" for Hotel/Motel entered is correct.
        *
        * @return A string including [PASS] or [FAIL] along with specific result
        * details.
        */
    
         public String verifyWhatHappenedForHotel(String whatHappenedForHotel) {
              String result = validateWithinLocatorText(LO_TXT_GLOBAL_WHAT_HAPPENED_FOR_HOTEL,whatHappenedForHotel ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
              result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
              return result;
         }

            /*
        * Validates if "Reason for Claim" entered is correct.
        *
        * @return A string including [PASS] or [FAIL] along with specific result
        * details.
        */
    
         public String verifyReasonForClaim(String reasonForClaim) {
              String result = validateWithinLocatorText(LO_TXT_GLOBAL_REASON_FOR_CLAIM,reasonForClaim ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
              result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
              return result;
         }

            /*
        * Validates if "Insurance Company" entered is correct.
        *
        * @return A string including [PASS] or [FAIL] along with specific result
        * details.
        */
    
         public String verifyInsuranceCompany(String insuranceCompany) {
              String result = validateWithinLocatorText(LO_TXT_GLOBAL_GLOBAL_INSURANCE_COMPANY,insuranceCompany ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
              result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
              return result;
         }

            /*
        * Validates if "Policy Number/Certificate ID" entered is correct.
        *
        * @return A string including [PASS] or [FAIL] along with specific result
        * details.
        */
    
         public String verifyPolicyNumberCertificateID(String policyNumberCertificateID) {
              String result = validateWithinLocatorText(LO_TXT_GLOBAL_POLICY_NUMBER_CERTIFICATE_ID,policyNumberCertificateID ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
              result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
              return result;
         }

            /*
        * Validates if "Global Excel Claim Number" for Baggage Loss entered is correct.
        *
        * @return A string including [PASS] or [FAIL] along with specific result
        * details.
        */
    
         public String verifyGlobalExcelClaimNumberForBaggageLoss(String globalExcelClaimNumberForBaggageLoss) {
              String result = validateWithinLocatorText(LO_TXT_GLOBAL_GLOBAL_EXCEL_CLAIM_NUMBER_FOR_BAGGAGE_LOSS,globalExcelClaimNumberForBaggageLoss ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
              result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
              return result;
         }

            /*
        * Validates if "Insurance Type" for Baggage Loss entered is correct.
        *
        * @return A string including [PASS] or [FAIL] along with specific result
        * details.
        */
    
         public String verifyInsuranceTypeForBaggageLoss(String insuranceTypeForBaggageLoss) {
              String result = validateWithinLocatorText(LO_TXT_GLOBAL_INSURANCE_TYPE_FOR_BAGGAGE_LOSS,insuranceTypeForBaggageLoss ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
              result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
              return result;
         }

            /*
        * Validates if "Incident happened at travel destination" for Baggage Loss entered is correct.
        *
        * @return A string including [PASS] or [FAIL] along with specific result
        * details.
        */
    
         public String verifyIncidentHappenedAtTravelDestinationForBaggageLoss(String incidentHappenedAtTravelDestinationForBaggageLoss) {
              String result = validateWithinLocatorText(LO_TXT_GLOBAL_INCIDENT_HAPPENED_AT_TRAVEL_DESTINATION_FOR_BAGGAGE_LOSS,incidentHappenedAtTravelDestinationForBaggageLoss ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
              result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
              return result;
         }

            /*
        * Validates if "Personal effects in custody(airline,bus,cruise)" for Baggage Loss entered is correct.
        *
        * @return A string including [PASS] or [FAIL] along with specific result
        * details.
        */
    
         public String verifyPersonalEffectsInCustodyForBaggageLoss(String personalEffectsInCustodyForBaggageLoss) {
              String result = validateWithinLocatorText(LO_TXT_GLOBAL_PERSONAL_EFFECTS_IN_CUSTODY_FOR_BAGGAGE_LOSS,personalEffectsInCustodyForBaggageLoss ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
              result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
              return result;
         }

            /*
        * Validates if "Main Reason for Cancelling your Trip" entered is correct.
        *
        * @return A string including [PASS] or [FAIL] along with specific result
        * details.
        */
    
         public String verifyMainReasonForCancellingYourTrip(String mainReasonForCancellingYourTrip) {
              String result = validateWithinLocatorText(LO_TXT_GLOBAL_MAIN_REASON_FOR_CANCELLING_YOUR_TRIP,mainReasonForCancellingYourTrip ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
              result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
              return result;
         }

         public String verifyMainReasonForInterruptionNew(String mainReasonForCancellingYourTrip) {
              String result = validateWithinLocatorText(LO_TXT_GLOBAL_MAIN_REASON_FOR_INTERRUPTION_NEW,mainReasonForCancellingYourTrip ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
              result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
              return result;
         }
         public String verifyDeceasedPersonInsuranceNew(String mainReasonForCancellingYourTrip) {
              String result = validateWithinLocatorText(LO_TXT_DECEASED_PERSON_INSURANCE_NEW,mainReasonForCancellingYourTrip ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
              result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
              return result;
         }

         public String verifyTravelStatusAndCancellationReasonHeader() {
            String result = validateLocatorExists(LO_TXT_TRAVEL_STATUS_CANCELLATION_REASON_HEADER, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
            result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
            return result;
       }

       public String verifyOtherInsuredPersonHeader() {
        String result = validateLocatorExists(LO_TXT_OTHER_INSURED_PERSON_HEADER,  FW_ConfigMgr.getDefaultTimeout(),
            FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
   }

   public String verifyClaimingForOtherInsuredPersonNoSelection() {
    String result = validateLocatorExists(LO_TXT_NO_CLAIMING_FOR_OTHER_INSURED_PERSON,  FW_ConfigMgr.getDefaultTimeout(),
        FW_ConfigMgr.getDefaultInterval());
    result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
    return result;
}

 public String verifyOtherInsuranceTypeNoSelection() {
    String result = validateLocatorExists(LO_TXT_NO_OTHER_INSURANCE_TYPE,  FW_ConfigMgr.getDefaultTimeout(),
        FW_ConfigMgr.getDefaultInterval());
    result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
    return result;
}


            /*
        * Validates if "Other due to" entered is correct.
        *
        * @return A string including [PASS] or [FAIL] along with specific result
        * details.
        */
    
         public String verifyOtherDueTo(String otherDueTo) {
              String result = validateWithinLocatorText(LO_TXT_GLOBAL_OTHER_DUE_TO,otherDueTo ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
              result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
              return result;
         }

            /*
        * Validates if "Global Excel Claim Number" for preceding "Other due to" entered is correct.
        *
        * @return A string including [PASS] or [FAIL] along with specific result
        * details.
        */
    
         public String verifyGlobalExcelClaimNumberForPrecedingOtherDueTo(String globalExcelClaimNumberForPrecedingOtherDueTo) {
              String result = validateWithinLocatorText(LO_TXT_GLOBAL_GLOBAL_EXCEL_CLAIM_NUMBER_FOR_PRECEDING_OTHER_DUE_TO,globalExcelClaimNumberForPrecedingOtherDueTo ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
              result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
              return result;
         }

            /*
        * Validates if "Trip Dates" for following travel destination entered is correct.
        *
        * @return A string including [PASS] or [FAIL] along with specific result
        * details.
        */
    
         public String verifyTripDatesFollowingTravelDestination(String tripDatesForAmexExploratory) {
              String result = validateWithinLocatorText(LO_TXT_GLOBAL_TRIP_DATES_FOLLOWING_TRAVEL_DESTINATION,tripDatesForAmexExploratory ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
              result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
              return result;
         }

            /*
        * Validates if "Travel destination" Following Incident Date entered is correct.
        *
        * @return A string including [PASS] or [FAIL] along with specific result
        * details.
        */
    
         public String verifyTravelDestinationFollowingIncidentDate(String travelDestinationFollowingIncidentDate) {
              String result = validateWithinLocatorText(LO_TXT_GLOBAL_TRAVEL_DESTINATION_FOLLOWING_INCIDENT_DATE,travelDestinationFollowingIncidentDate ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
              result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
              return result;
         }

            /*
        * Validates if "Incident Date" for Amex Exploratory entered is correct.
        *
        * @return A string including [PASS] or [FAIL] along with specific result
        * details.
        */
    
         public String verifyIncidentDateFollowingCancellationDate(String incidentDateFollowingCancellationDate) {
              String result = validateWithinLocatorText(LO_TXT_GLOBAL_INCIDENT_DATE_FOLLOWING_CANCELLATION_DATE,incidentDateFollowingCancellationDate ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
              result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
              return result;
         }

            /*
        * Validates if "Cancellation Date" for Amex Exploratory entered is correct.
        *
        * @return A string including [PASS] or [FAIL] along with specific result
        * details.
        */
    
         public String verifyCancellationDateFollowingTripPurchaseDate(String cancellationDateFollowingTripPurchaseDate) {
              String result = validateWithinLocatorText(LO_TXT_GLOBAL_CANCELLATION_DATE_FOLLOWING_TRIP_PURCHASE_DATE,cancellationDateFollowingTripPurchaseDate ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
              result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
              return result;
         }

            /*
        * Validates if "Trip Purchase Date" entered is correct.
        *
        * @return A string including [PASS] or [FAIL] along with specific result
        * details.
        */
    
         public String verifyTripPurchaseDate(String tripPurchaseDate) {
              String result = validateWithinLocatorText(LO_TXT_GLOBAL_TRIP_PURCHASE_DATE,tripPurchaseDate ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
              result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
              return result;
         }

            /*
        * Validates if "What Happened" for Amex Exploratory entered is correct.
        *
        * @return A string including [PASS] or [FAIL] along with specific result
        * details.
        */

            public String verifyWhatHappenedPrecedingTripPurchaseDate(String whatHappenedForAmexExploratory) {
                String result = validateWithinLocatorText(LO_TXT_GLOBAL_WHAT_HAPPENED_PREDEDING_TRIP_PURCHASE_DATE,whatHappenedForAmexExploratory ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
                result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
                return result;
            }

            /*
        * Validates if "Insurance Type" following policy number entered is correct.
        *
        * @return A string including [PASS] or [FAIL] along with specific result
        * details.
        */

            public String verifyInsuranceTypeFollowingPolicyNumber(String insuranceTypeFollowingPolicyNumber) {
                String result = validateWithinLocatorText(LO_TXT_GLOBAL_INSURANCE_TYPE_FOLLOWING_POLICY_NUMBER,insuranceTypeFollowingPolicyNumber ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
                result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
                return result;
            }

            /*
        * Validates if "Assignment of benefit" entered is correct.
        
        * @return A string including [PASS] or [FAIL] along with specific result
        * details.
        */

            public String verifyAssignmentOfBenefit(String assignmentOfBenefit) {
                String result = validateWithinLocatorText(LO_TXT_GLOBAL_ASSIGNMENT_OF_BENEFIT,assignmentOfBenefit ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
                result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
                return result;
            }

            /*
        * Validates if "Group name" entered is correct.

        * @return A string including [PASS] or [FAIL] along with specific result
        * details.
        */

            public String verifyGroupName(String groupName) {
                String result = validateWithinLocatorText(LO_TXT_GLOBAL_GROUP_NAME,groupName ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
                result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
                return result;
            }

            /*
        * Validates if "Insurance Type" following Group Name entered is correct.
        *
        * @return A string including [PASS] or [FAIL] along with specific result
        * details.
        */

            public String verifyInsuranceTypeFollowingGroupName(String insuranceTypeFollowingGroupName) {
                String result = validateWithinLocatorText(LO_TXT_GLOBAL_INSURANCE_TYPE_FOLLOWING_GROUP_NAME,insuranceTypeFollowingGroupName ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
                result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
                return result;
            }

            /*
        * Validates if "Refund Obtained (Equivalent in CAD)" for Amex Exploratory entered is correct.
        *
        * @return A string including [PASS] or [FAIL] along with specific result
        * details.
        */

            public String verifyRefundObtainedWithSpace(String refundObtainedEquivalentInCAD) {
                String result = validateWithinLocatorText(LO_TXT_GLOBAL_POLICY_REFUND_OBTAINED_EQUIVALENT_IN_CAD_WITH_SPACE,refundObtainedEquivalentInCAD ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
                result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
                return result;
            }

            /*
        * Validates if "Total Amount of Expenses obtained" with space entered is correct.
        *
        * @return A string including [PASS] or [FAIL] along with specific result
        * details.
        */

            public String verifyTotalAmountOfExpensesObtainedWithSpace(String totalAmountOfExpensesObtainedWithSpace) {
                String result = validateWithinLocatorText(LO_TXT_GLOBAL_TOTAL_AMOUNT_OF_EXPENSES_CLAIMED_WITH_SPACE,totalAmountOfExpensesObtainedWithSpace ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
                result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
                return result;
            }

            /*
        * Validates if "Main Reason for cancelling your trip" medical entered is correct.
        *
        * @return A string including [PASS] or [FAIL] along with specific result
        * details.
        */

            public String verifyMainReasonForCancellingYourTripMedical(String mainReasonForCancellingYourTripMedical) {
                String result = validateWithinLocatorText(LO_TXT_GLOBAL_MAIN_REASON_FOR_CANCELLING_YOUR_TRIP_MEDICAL,mainReasonForCancellingYourTripMedical ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
                result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
                return result;
            }

            /*
        * Validates if "Medical due to" entered is correct.
        *
        * @return A string including [PASS] or [FAIL] along with specific result
        * details.
        */

            public String verifyMedicalDueTo(String medicalDueTo) {
                String result = validateWithinLocatorText(LO_TXT_GLOBAL_MEDICAL_DUE_TO,medicalDueTo ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
                result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
                return result;
            }

            /*
        * Validates if "Global Excel Claim Number" for preceding "Medical due to" entered is correct.
        *
        * @return A string including [PASS] or [FAIL] along with specific result
        * details.
        */

            public String verifyGlobalExcelClaimNumberPrecedingMedicalDueTo(String globalExcelClaimNumberForPrecedingMedicalDueTo) {
                String result = validateWithinLocatorText(LO_TXT_GLOBAL_GLOBAL_EXCEL_CLAIM_NUMBER_FOR_PRECEDING_MEDICAL_DUE_TO,globalExcelClaimNumberForPrecedingMedicalDueTo ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
                result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
                return result;
            }

            /*
        * Validates if "Claim Type" entered is correct.
        *
        * @return A string including [PASS] or [FAIL] along with specific result
        * details.
        */

            public String verifyClaimType(String claimType) {
                String result = validateWithinLocatorText(LO_TXT_GLOBAL_CLAIM_TYPE,claimType ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
                result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
                return result;
            }

            /*
        * Validates if "Province" entered is correct.
        *
        * @return A string including [PASS] or [FAIL] along with specific result
        * details.
        */

            public String verifyProvince(String province) {
                String result = validateWithinLocatorText(LO_TXT_GLOBAL_PROVINCE,province ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
                result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
                return result;
            }

            /*
        * Validates if "Global Excel Claim Number" preceding "Province" entered is correct.
        *
        * @return A string including [PASS] or [FAIL] along with specific result
        * details.
        */

            public String verifyGlobalExcelClaimNumberPrecedingProvince(String globalExcelClaimNumberPrecedingProvince) {
                String result = validateWithinLocatorText(LO_TXT_GLOBAL_GLOBAL_EXCEL_CLAIM_NUMBER_PRECEDING_PROVINCE,globalExcelClaimNumberPrecedingProvince ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
                result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
                return result;
            }

            /*
        * Validates if "Employer Name" entered is correct.
        *
        * @return A string including [PASS] or [FAIL] along with specific result
        * details.
        */

            public String verifyEmployerName(String employerName) {
                String result = validateWithinLocatorText(LO_TXT_GLOBAL_EMPLOYER_NAME,employerName ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
                result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
                return result;
            }

            /*
        * Validates if "Provincial Health Card Number" entered is correct.
        *
        * @return A string including [PASS] or [FAIL] along with specific result
        * details.
        */

            public String verifyProvincialHealthCardNumber(String provincialHealthCardNumber) {
                String result = validateWithinLocatorText(LO_TXT_GLOBAL_PROVINCIAL_HEALTH_CARD_NUMBER,provincialHealthCardNumber ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
                result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
                return result;
            }

            /*
        * Validates if "Travel destination" following "Trip Dates" entered is correct.
        *
        * @return A string including [PASS] or [FAIL] along with specific result
        * details.
        */

            public String verifyTravelDestinationFollowingTripDates(String travelDestinationFollowingTripDates) {
                String result = validateWithinLocatorText(LO_TXT_GLOBAL_TRAVEL_DESTINATION_FOLLOWING_TRIP_DATES,travelDestinationFollowingTripDates ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
                result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
                return result;
            }

            /*
        * Validates if "Trip Dates" following "Original Return Date" entered is correct.
        *
        * @return A string including [PASS] or [FAIL] along with specific result
        * details.
        */

            public String verifyTripDatesFollowingOriginalReturnDate(String tripDates) {
                String result = validateWithinLocatorText(LO_TXT_GLOBAL_TRIP_DATES_FOLLOWING_ORIGINAL_RETURN_DATE,tripDates ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
                result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
                return result;
            }

            /*
        * Validates if "Original Return Date" entered is correct.
        *
        * @return A string including [PASS] or [FAIL] along with specific result
        * details.
        */

            public String verifyOriginalReturnDate(String originalReturnDate) {
                String result = validateWithinLocatorText(LO_TXT_GLOBAL_ORIGINAL_RETURN_DATE,originalReturnDate ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
                result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
                return result;
            }

            /*
        * Validates if "Reason for consult" entered is correct.
        *
        * @return A string including [PASS] or [FAIL] along with specific result
        * details.
        */

            public String verifyReasonForConsult(String reasonForConsult) {
                String result = validateWithinLocatorText(LO_TXT_GLOBAL_REASON_FOR_CONSULT,reasonForConsult ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
                result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
                return result;
            }

            /*
        * Validates if "First date of treatment" entered is correct.
        *
        * @return A string including [PASS] or [FAIL] along with specific result
        * details.
        */

            public String verifyFirstDateOfTreatment(String firstDateOfTreatment) {
                String result = validateWithinLocatorText(LO_TXT_GLOBAL_FIRST_DATE_OF_TREATMENT,firstDateOfTreatment ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
                result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
                return result;
            }

            /*
        * Validates if "When did first symptoms appear" entered is correct.
        *
        * @return A string including [PASS] or [FAIL] along with specific result
        * details.
        */

            public String verifyWhenDidFirstSymptomsAppear(String whenDidFirstSymptomsAppear) {
                String result = validateWithinLocatorText(LO_TXT_GLOBAL_WHEN_DID_FIRST_SYMPTOMS_APPEAR,whenDidFirstSymptomsAppear ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
                result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
                return result;
            }

            /*
        * Validates if "What Happened" entered is correct.
        *
        * @return A string including [PASS] or [FAIL] along with specific result
        * details.
        */

            public String verifyWhatHappenedPrecedingWhenDidFirstSymptomsAppear(String whatHappened) {
                String result = validateWithinLocatorText(LO_TXT_GLOBAL_WHAT_HAPPENED_PRECEDING_WHEN_DID_FIRST_SYMPTOMS_APPEAR,whatHappened ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
                result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
                return result;
            }

            /*
        * Validates if "Expenses" entered is correct.
        *
        * @return A string including [PASS] or [FAIL] along with specific result
        * details.
        */

            public String verifyExpenses(String expenses) {
                String result = validateWithinLocatorText(LO_TXT_GLOBAL_EXPENSES,expenses ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
                result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
                return result;
            }

            /*
        * Validates if "Expense Item 1" is correct.
        *
        * @return A string including [PASS] or [FAIL] along with specific result
        * details.
        */

            public String verifyExpenseItem1(String expenseItem1) {
                String result = validateWithinLocatorText(LO_TXT_GLOBAL_EXPENSE_ITEM_1,expenseItem1 ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
                result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
                return result;
            }

            /*
        * Validates if "Amount Billed" is correct.

        * @return A string including [PASS] or [FAIL] along with specific result
        * details.
        */

            public String verifyAmountBilled(String amountBilled) {
                String result = validateWithinLocatorText(LO_TXT_GLOBAL_AMOUNT_BILLED_EQUIVALENT_IN_CAD,amountBilled ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
                result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
                return result;
            }

            /*
        * Validates if "Amount Paid" is correct.
        *
        * @return A string including [PASS] or [FAIL] along with specific result
        * details.
        */

            public String verifyAmountPaidFollowingReceiptIncluded(String amountPaid) {
                String result = validateWithinLocatorText(LO_TXT_GLOBAL_AMOUNT_PAID_EQUIVALENT_IN_CAD,amountPaid ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
                result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
                return result;
            }

            /*
        * Validates if "Receipt Included" is correct.
        *
        * @return A string including [PASS] or [FAIL] along with specific result
        * details.
        */

            public String verifyReceiptIncluded(String receiptIncluded) {
                String result = validateWithinLocatorText(LO_TXT_GLOBAL_RECEIPT_INCLUDED,receiptIncluded ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
                result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
                return result;
            }

            /*
        * Validates if "Total Estimated Paid Amount" is correct.
        *
        * @return A string including [PASS] or [FAIL] along with specific result
        * details.
        */

            public String verifyTotalEstimatedPaidAmount(String totalEstimatedPaidAmount) {
                String result = validateWithinLocatorText(LO_TXT_GLOBAL_TOTAL_ESTIMATED_PAID_AMOUNT,totalEstimatedPaidAmount ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
                result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
                return result;
            }

            /*
        * Validates if "Insurance Type" following Employer Name is correct.
        *
        * @return A string including [PASS] or [FAIL] along with specific result
        * details.
        */

            public String verifyInsuranceTypeFollowingEmployerName(String insuranceTypeFollowingEmployerName) {
                String result = validateWithinLocatorText(LO_TXT_GLOBAL_INSURANCE_TYPE_FOLLOWING_EMPLOYER_NAME,insuranceTypeFollowingEmployerName ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
                result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
                return result;
            }

            /*
        * Validates if "Preferred Method of Payment/Reimbursement" following "Is the email address the same as the Claimant's email address?" is correct.
        *
        * @return A string including [PASS] or [FAIL] along with specific result
        * details.
        */

            public String verifyPreferredMethodOfPaymentFollowingIsTheEmailAddressTheSame(String preferredMethodOfPaymentFollowingIsTheEmailAddressTheSame) {
                String result = validateWithinLocatorText(LO_TXT_GLOBAL_PREFERRED_METHOD_OF_PAYMENT_REIMBURSEMENT_FOLLOWING_IS_THE_EMAIL_ADDRESS_THE_SAME,preferredMethodOfPaymentFollowingIsTheEmailAddressTheSame ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
                result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
                return result;
            }

            /*
        * Validates if "Is the email address the same as the Claimant's email address?" is correct.
        *
        * @return A string including [PASS] or [FAIL] along with specific result
        * details.
        */

            public String verifyIsTheEmailAddressTheSameAsTheClaimantsEmailAddress(String isTheEmailAddressTheSameAsTheClaimantsEmailAddress) {
                String result = validateWithinLocatorText(LO_TXT_GLOBAL_IS_THE_EMAIL_ADDRESS_THE_SAME_AS_THE_CLAIMANTS_EMAIL_ADDRESS,isTheEmailAddressTheSameAsTheClaimantsEmailAddress ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
                result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
                return result;
            }

            /*
        * Validates if "Claim Type" following "Global Excel Claim Number" is correct.
        *
        * @return A string including [PASS] or [FAIL] along with specific result
        * details.
        */

            public String verifyClaimTypeFollowingGlobalExcelClaimNumber(String claimTypeFollowingGlobalExcelClaimNumber) {
                String result = validateWithinLocatorText(LO_TXT_GLOBAL_CLAIM_TYPE_FOLLOWING_GLOBAL_EXCEL_CLAIM_NUMBER,claimTypeFollowingGlobalExcelClaimNumber ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
                result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
                return result;
            }

            /*
        * Validates if "Global Excel Claim Number" for preceding "Claim Type" is correct.
        *
        * @return A string including [PASS] or [FAIL] along with specific result
        * details.
        */

            public String verifyGlobalExcelClaimNumberPrecedingClaimType(String globalExcelClaimNumberPrecedingClaimType) {
                String result = validateWithinLocatorText(LO_TXT_GLOBAL_GLOBAL_EXCEL_CLAIM_NUMBER_PRECEDING_CLAIM_TYPE,globalExcelClaimNumberPrecedingClaimType ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
                result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
                return result;
            }

            /*
        * Validates if "Country of origin" is correct.
        *
        * @return A string including [PASS] or [FAIL] along with specific result
        * details.
        */

            public String verifyCountryOfOrigin(String countryOfOrigin) {
                String result = validateWithinLocatorText(LO_TXT_GLOBAL_COUNTRY_OF_ORIGIN,countryOfOrigin ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
                result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
                return result;
            }

            /*
        * Validates if "Temporary Travel Destination" is correct.
        *
        * @return A string including [PASS] or [FAIL] along with specific result
        * details.
        */

            public String verifyTemporaryTravelDestination(String temporaryTravelDestination) {
                String result = validateWithinLocatorText(LO_TXT_GLOBAL_TEMPORARY_TRAVEL_DESTINATION,temporaryTravelDestination ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
                result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
                return result;
            }

            /*
        * Validates if "Temporary Trip Dates" is correct.
        *
        * @return A string including [PASS] or [FAIL] along with specific result
        * details.
        */

            public String verifyTemporaryTripDates(String temporaryTripDates) {
                String result = validateWithinLocatorText(LO_TXT_GLOBAL_TEMPORARY_TRIP_DATES,temporaryTripDates ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
                result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
                return result;
            }

            /*
        * Validates if "Global Excel Claim Number" is correct.
        *
        * @return A string including [PASS] or [FAIL] along with specific result
        * details.
        */

            // public String verifyGlobalExcelClaimNumber(String globalExcelClaimNumber) {
            //     String result = validateWithinLocatorText(LO_TXT_GLOBAL_EXCEL_CLAIM_NUMBER,globalExcelClaimNumber ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
            //     result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
            //     return result;
            // }

            /*
        * Validates if "Credit Card Type" is correct.
        *
        * @return A string including [PASS] or [FAIL] along with specific result
        * details.
        */

            public String verifyCreditCardType(String creditCardType) {
                String result = validateWithinLocatorText(LO_TXT_GLOBAL_CREDIT_CARD_TYPE,creditCardType ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
                result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
                return result;
            }

            /*
        * Validates if "Item Description" is correct.
        *
        * @return A string including [PASS] or [FAIL] along with specific result
        * details.
        */

            public String verifyItemDescription(String itemDescription) {
                String result = validateWithinLocatorText(LO_TXT_GLOBAL_ITEM_DESCRIPTION,itemDescription ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
                result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
                return result;
            }

            /*
            * Validates if "Original Purchase Date" is correct.
            *
            * @return A string including [PASS] or [FAIL] along with specific result
            * details.
            */

            public String verifyOriginalPurchaseDate(String originalPurchaseDate) {
                String result = validateWithinLocatorText(LO_TXT_GLOBAL_ORIGINAL_PURCHASE_DATE,originalPurchaseDate ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
                result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
                return result;
            }

            /*
            * Validates if "Incident Date" is correct.
            *
            * @return A string including [PASS] or [FAIL] along with specific result
            * details.
            */

            public String verifyIncidentDateFollowingDidYouPayForTheItemInMultipleInstallments(String incidentDate) {
                String result = validateWithinLocatorText(LO_TXT_GLOBAL_INCIDENT_DATE_FOLLOWING_DID_YOU_PAY_FOR_THE_ITEM_IN_MULTIPLE_INSTALLMENTS,incidentDate ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
                result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
                return result;
            }

            /*
            * Validates if "Did you pay for the item in multiple installments?" is correct.
            *
            * @return A string including [PASS] or [FAIL] along with specific result
            * details.
            */

            public String verifyDidYouPayForTheItemInMultipleInstallments(String didYouPayForTheItemInMultipleInstallments) {
                String result = validateWithinLocatorText(LO_TXT_GLOBAL_DID_YOU_PAY_FOR_THE_ITEM_IN_MULTIPLE_INSTALLMENTS,didYouPayForTheItemInMultipleInstallments ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
                result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
                return result;
            }

            /*
            * Validates if "Manufacturer name" is correct.
            *
            * @return A string including [PASS] or [FAIL] along with specific result
            * details.
            */

            public String verifyManufacturerName(String manufacturerName) {
                String result = validateWithinLocatorText(LO_TXT_GLOBAL_MANUFACTURER_NAME,manufacturerName ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
                result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
                return result;
            }

            /*
            * Validates if "Duration of Manufacturer's Warranty" is correct.

            * @return A string including [PASS] or [FAIL] along with specific result
            * details.
            */

            public String verifyDurationOfManufacturersWarranty(String durationOfManufacturersWarranty) {
                String result = validateWithinLocatorText(LO_TXT_GLOBAL_DURATION_OF_MANUFACTURER_WARRANTY,durationOfManufacturersWarranty ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
                result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
                return result;
            }

            /*
            * Validates if "Serial Number" is correct.
            *
            * @return A string including [PASS] or [FAIL] along with specific result
            * details.
            */

            public String verifySerialNumber(String serialNumber) {
                String result = validateWithinLocatorText(LO_TXT_GLOBAL_SERIAL_NUMBER,serialNumber ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
                result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
                return result;
            }

            /*
             * Validates if "The Insured" following Insurance Typeis correct.
             * @return A string including [PASS] or [FAIL] along with specific result
             * details.
             * 
             */

            public String verifyTheInsuredFollowingInsuranceType(String theInsuredFollowingInsuranceType) {
                String result = validateWithinLocatorText(LO_TXT_GLOBAL_THE_INSURED_FOLLOWING_OTHER_INSURANCE_TYPE,theInsuredFollowingInsuranceType ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
                result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
                return result;
            }

            /*
             * Validates if "Other Insurance Type" is correct.
             * @return A string including [PASS] or [FAIL] along with specific result
             * details.
             * 
             */

            public String verifyOtherInsuranceTypeFollowingTheInsured(String otherInsuranceType) {
                String result = validateWithinLocatorText(LO_TXT_GLOBAL_OTHER_INSURANCE_TYPE_FOLLOWING_THE_INSURED,otherInsuranceType ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
                result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
                return result;
            }

            /*
             * Validates if "What Happened" preceding "Serial Number" is correct.
             * @return A string including [PASS] or [FAIL] along with specific result
             * details.
             * 
             */

            public String verifyWhatHappenedPrecedingSerialNumber(String whatHappened) {
                String result = validateWithinLocatorText(LO_TXT_GLOBAL_WHAT_HAPPENED_PRECEDING_SERIAL_NUMBER,whatHappened ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
                result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
                return result;
            }

            /*
             * Validates if "Refund Obtained" following "Total Amount of Expenses Claimed" is correct.
             * @return A string including [PASS] or [FAIL] along with specific result
             * details.
             * 
             */

             public String verifyRefundObtainedFollowingTotalAmountOfExpensesClaimed(String amountPaid) {
                String result = validateWithinLocatorText(LO_TXT_GLOBAL_REFUND_OBTAINED_FOLLOWING_TOTAL_AMOUNT_OF_EXPENSES_CLAIMED,amountPaid ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
                result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
                return result;
             }

            /*
                * Validates if "Total Amount of Expenses Claimed" is correct.
                * @return A string including [PASS] or [FAIL] along with specific result
                * details.
                * 
                */
    
                // public String verifyTotalAmountOfExpensesClaimedPrecedingRefundObtained(String totalAmountOfExpensesClaimed) {
                //     String result = validateWithinLocatorText(LO_TXT_GLOBAL_TOTAL_AMOUNT_OF_EXPENSES_CLAIMED,totalAmountOfExpensesClaimed ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
                //     result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
                //     return result;
                // }

            /*
                * Validates if "Incident happened at travel destination" preceding travel destination is correct.
                * @return A string including [PASS] or [FAIL] along with specific result
                * details.
                * 
                */

                public String verifyIncidentHappenedAtTravelDestinationPrecedingTravelDestination(String incidentHappenedAtTravelDestination) {
                    String result = validateWithinLocatorText(LO_TXT_GLOBAL_INCIDENT_HAPPENED_AT_TRAVEL_DESTINATION_PRECEDING_TRAVEL_DESTINATION,incidentHappenedAtTravelDestination ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
                    result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
                    return result;
                }

                /*
                * Validates if "Name of Travel Provider" is correct.
                * @return A string including [PASS] or [FAIL] along with specific result
                * details.
                * 
                */

                public String verifyNameOfTravelProviderFollowingReportFiledDate(String reportFiledDate) {
                    String result = validateWithinLocatorText(LO_TXT_GLOBAL_NAME_OF_TRAVEL_PROVIDER_FOLLOWING_REPORT_FILED_DATE,reportFiledDate ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
                    result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
                    return result;
                }

                /*
                * Validates if "The Insured" following other Insurance Type is correct.
                * @return A string including [PASS] or [FAIL] along with specific result
                * details.
                * 
                */

                public String verifyTheInsuredFollowingOtherInsuranceType(String theInsuredFollowingOtherInsuranceType) {
                    String result = validateWithinLocatorText(LO_TXT_GLOBAL_THE_INSURED_FOLLOWING_OTHER_INSURANCE_TYPE,theInsuredFollowingOtherInsuranceType ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
                    result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
                    return result;
                }

                /*
                * Validates if "Reason for loss" is correct.
                * @return A string including [PASS] or [FAIL] along with specific result
                * details.
                * 
                */

                public String verifyReasonForLoss(String reasonForLoss) {
                    String result = validateWithinLocatorText(LO_TXT_GLOBAL_REASON_FOR_LOSS,reasonForLoss ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
                    result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
                    return result;
                }

                /*
                * Validates if "Global Excel Claim Number" preceing "Reason for loss" is correct.
                * @return A string including [PASS] or [FAIL] along with specific result
                * details.
                * 
                */

                public String verifyGlobalExcelClaimNumberPrecedingReasonForLoss(String globalExcelClaimNumber) {
                    String result = validateWithinLocatorText(LO_TXT_GLOBAL_GLOBAL_EXCEL_CLAIM_NUMBER_PRECEDING_REASON_FOR_LOSS,globalExcelClaimNumber ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
                    result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
                    return result;
                }

                /*
                * Validates if "Country" is correct.
                * @return A string including [PASS] or [FAIL] along with specific result
                * details.
                * 
                */

                public String verifyCountry(String country) {
                    String result = validateWithinLocatorText(LO_TXT_GLOBAL_COUNTRY,country ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
                    result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
                    return result;
                }

                /*
                * Validates if "Province" following "City" is correct.
                * @return A string including [PASS] or [FAIL] along with specific result
                * details.
                * 
                */

                public String verifyProvinceFollowingCity(String province) {
                    String result = validateWithinLocatorText(LO_TXT_GLOBAL_PROVINCE_FOLLOWING_CITY,province ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
                    result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
                    return result;
                }

                /*
                * Validates if "City" is correct.
                * @return A string including [PASS] or [FAIL] along with specific result
                * details.
                * 
                */

                public String verifyCity(String city) {
                    String result = validateWithinLocatorText(LO_TXT_GLOBAL_CITY,city ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
                    result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
                    return result;
                }

                /*
                * Validates if "What Happened" preceding "City"is correct.
                * @return A string including [PASS] or [FAIL] along with specific result
                * details.
                * 
                */

                public String verifyWhatHappenedPrecedingCity(String whatHappened) {
                    String result = validateWithinLocatorText(LO_TXT_GLOBAL_WHAT_HAPPENED_PRECEDING_CITY,whatHappened ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
                    result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
                    return result;
                }

                /*
                * Validates if "Incident Date" following "Country"is correct.
                * @return A string including [PASS] or [FAIL] along with specific result
                * details.
                * 
                */

                public String verifyIncidentDateFollowingCountry(String incidentDate) {
                    String result = validateWithinLocatorText(LO_TXT_GLOBAL_INCIDENT_DATE_FOLLOWING_COUNTRY,incidentDate ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
                    result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
                    return result;
                }

                /*
                * Validates if "Reason For Loss" is correct.
                * @return A string including [PASS] or [FAIL] along with specific result
                * details.
                * 
                */

                public String verifyReasonForLossFollowingGlobalExcelClaimNumber(String reasonForLoss) {
                    String result = validateWithinLocatorText(LO_TXT_GLOBAL_REASON_FOR_LOSS_WITH_SPACE,reasonForLoss ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
                    result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
                    return result;
                }
                public String verifyReasonForLossReviewPage(String reasonForLoss) {
                    String result = validateWithinLocatorText(LO_TXT_REASON_FOR_LOSS,reasonForLoss ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
                    result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
                    return result;
                }

                public String verifyReasonForClaimReviewPage(String reasonForClaim) {
                    String result = validateWithinLocatorText(LO_TXT_REASON_FOR_CLAIM,reasonForClaim ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
                    result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
                    return result;
                }

                /*
                * Validates if "Global Excel Claim Number" is correct.
                * @return A string including [PASS] or [FAIL] along with specific result
                * details.
                * 
                */

                public String verifyGlobalExcelClaimNumberPrecedingReasonForLoss2(String globalExcelClaimNumber) {
                    String result = validateWithinLocatorText(LO_TXT_GLOBAL_GLOBAL_EXCEL_CLAIM_NUMBER_PRECEDING_REASON_FOR_LOSS_WITH_SPACE,globalExcelClaimNumber ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
                    result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
                    return result;
                }

                /*
                * Validates if "Rental Agency Name" is correct.
                * @return A string including [PASS] or [FAIL] along with specific result
                * details.

                */

                public String verifyRentalAgencyName(String rentalAgencyName) {
                    String result = validateWithinLocatorText(LO_TXT_GLOBAL_RENTAL_AGENCY_NAME,rentalAgencyName ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
                    result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
                    return result;
                }

                /*
                * Validates if "Was the full cost of the rental charged to your credit card?" is correct.
                * @return A string including [PASS] or [FAIL] along with specific result
                * details.
                * 
                */

                public String verifyWasTheFullCostOfTheRentalChargedToYourCreditCard(String wasTheFullCostOfTheRentalChargedToYourCreditCard) {
                    String result = validateWithinLocatorText(LO_TXT_GLOBAL_WAS_THE_FULL_COST_OF_THE_RENTAL_CHARGED_TO_YOUR_CREDIT_CARD,wasTheFullCostOfTheRentalChargedToYourCreditCard ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
                    result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
                    return result;
                }

                /*
                * Validates if "Did you have another rental agreement within a 48h period from the start or the end of this current rental?" is correct.
                * @return A string including [PASS] or [FAIL] along with specific result
                * details.
                * 
                */

                public String verifyRentalAgreementWithinA48h(String rentalAgreementWithinA48h) {
                    String result = validateWithinLocatorText(LO_TXT_GLOBAL_DID_YOU_HAVE_ANOTHER_RENTAL_AGREEMENT_WITHIN_A_48H_PERIOD_FROM_THE_START_OR_THE_END_OF_THIS_CURRENT_RENTAL,rentalAgreementWithinA48h ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
                    result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
                    return result;
                }

                /*
                * Validates if "When Did the Incident Occur" is correct.
                * @return A string including [PASS] or [FAIL] along with specific result
                * details.
                * 
                */

                public String verifyWhenDidTheIncidentOccurFollowingWasThePolicyHolderTheDriver(String whenDidTheIncidentOccur) {
                    String result = validateWithinLocatorText(LO_TXT_GLOBAL_WHEN_DID_THE_INCIDENT_OCCUR_FOLLOWING_WAS_THE_POLICY_HOLDER_THE_DRIVER,whenDidTheIncidentOccur ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
                    result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
                    return result;
                }

                /*
                * Validates if "Was the policy holder the driver?" is correct.
                * @return A string including [PASS] or [FAIL] along with specific result
                * details.
                * 
                */

                public String verifyWasThePolicyHolderTheDriver(String wasThePolicyHolderTheDriver) {
                    String result = validateWithinLocatorText(LO_TXT_GLOBAL_WAS_THE_POLICY_HOLDER_THE_DRIVER_AT_THE_TIME_OF_INCIDENT,wasThePolicyHolderTheDriver ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
                    result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
                    return result;
                }

                /*
                * Validates if "Did the incident involve another vehicle" is correct.
                * @return A string including [PASS] or [FAIL] along with specific result
                * details.
                * 
                */

                public String verifyDidTheIncidentInvolveAnotherVehicle(String didTheIncidentInvolveAnotherVehicle) {
                    String result = validateWithinLocatorText(LO_TXT_GLOBAL_DID_THE_INCIDENT_INVOLVE_ANOTHER_VEHICLE,didTheIncidentInvolveAnotherVehicle ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
                    result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
                    return result;
                }

                /*
                * Validates if "What Happened" preceding "Did the incident involve another vehicle" is correct.
                * @return A string including [PASS] or [FAIL] along with specific result
                * details.
                * 
                */

                public String verifyWhatHappenedPrecedingDidTheIncidentInvolveAnotherVehicle(String whatHappened) {
                    String result = validateWithinLocatorText(LO_TXT_GLOBAL_WHAT_HAPPENED_PRECEDING_DID_THE_INCIDENT_INVOLVE_ANOTHER_VEHICLE,whatHappened ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
                    result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
                    return result;
                }

                public String verifyWhatHappenedReviewPage(String whatHappened) {
                    String result = validateWithinLocatorText(LO_TXT_WHAT_HAPPENED_REVIEW_PAGE,whatHappened ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
                    result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
                    return result;
                }

                /*
                * Validates if "Employer Name" following "The Insured" is correct.
                * @return A string including [PASS] or [FAIL] along with specific result
                * details.
                * 
                */

                public String verifyEmployerNameFollowingTheInsured(String employerName) {
                    String result = validateWithinLocatorText(LO_TXT_GLOBAL_EMPLOYER_NAME_FOLLOWING_THE_INSURED,employerName ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
                    result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
                    return result;
                }

                 /*
                * Validates if "Refund Obtained" following "Total Amount of Expenses Claimed without dots" is correct.
                * @return A string including [PASS] or [FAIL] along with specific result
                * details.
                * 
                */

                public String verifyRefundObtainedFollowingTotalAmountOfExpensesClaimedWithoutDots(String refundObtained) {
                    String result = validateWithinLocatorText(LO_TXT_GLOBAL_REFUND_OBTAINED_FOLLOWING_TOTAL_AMOUNT_OF_EXPENSES_CLAIMED_WITHOUT_DOTS,refundObtained ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
                    result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
                    return result;
                }

                /*
                * Validates if "Total Amount of Expenses Claimed without dots" is correct.
                * @return A string including [PASS] or [FAIL] along with specific result
                * details.
                * 
                */

                public String verifyTotalAmountOfExpensesClaimedWithoutDotsPrecedingRefundObtained(String totalAmountOfExpensesClaimedWithoutDots) {
                    String result = validateWithinLocatorText(LO_TXT_GLOBAL_TOTAL_AMOUNT_OF_EXPENSES_CLAIMED_WITHOUT_DOTS,totalAmountOfExpensesClaimedWithoutDots ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
                    result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
                    return result;
                }

                /*
                * Validates if "Plan Number" is correct.
                * @return A string including [PASS] or [FAIL] along with specific result
                * details.
                * 
                */

                public String verifyPlanNumber(String planNumber) {
                    String result = validateWithinLocatorText(LO_TXT_GLOBAL_PLAN_NUMBER,planNumber ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
                    result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
                    return result;
                }

                /*
                * Validates if "The Insured" "Other Insured Persons" is correct.
                * @return A string including [PASS] or [FAIL] along with specific result
                * details.
                * 
                */

                public String verifyTheInsuredFollowingOtherInsuredPersons(String theInsured) {
                    String result = validateWithinLocatorText(LO_TXT_GLOBAL_THE_INSURED_FOLLOWING_OTHER_INSURED_PERSONS,theInsured ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
                    result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
                    return result;
                }

                public String verifyNamesOfInsured(String theInsured) {
                    String result = validateWithinLocatorText(LO_TXT_NAMES,theInsured ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
                    result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
                    return result;
                }

                /*
                * Validates if "Description of Damage" is correct.
                * @return A string including [PASS] or [FAIL] along with specific result
                * details.
                * 
                */

                public String verifyDescriptionOfDamage(String descriptionOfDamage) {
                    String result = validateWithinLocatorText(LO_TXT_GLOBAL_DESCRIPTION_OF_DAMAGE,descriptionOfDamage ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
                    result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
                    return result;
                }

                /*
                * Validates if "Main Reason for Interruption" is correct.
                * @return A string including [PASS] or [FAIL] along with specific result
                * details.
                * 
                */

                public String verifyMainReasonForInterruption(String mainReasonForInterruption) {
                    String result = validateWithinLocatorText(LO_TXT_GLOBAL_MAIN_REASON_FOR_INTERRUPTION,mainReasonForInterruption ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
                    result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
                    return result;
                }

                /*
                * Validates if "Deceased Person Insurance" is correct.
                * @return A string including [PASS] or [FAIL] along with specific result
                * details.
                * 
                */

                public String verifyDeceasedPersonInsurance(String deceasedPersonInsurance) {
                    String result = validateWithinLocatorText(LO_TXT_GLOBAL_DECEASED_PERSON_INSURANCE,deceasedPersonInsurance ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
                    result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
                    return result;
                }

                /*
                * Validates if "Global Excel Claim Number" Preceding "Deceased Person Insurance" is correct.
                * @return A string including [PASS] or [FAIL] along with specific result
                * details.
                * 
                */

                public String verifyGlobalExcelClaimNumberPrecedingDeceasedPersonInsurance(String globalExcelClaimNumber) {
                    String result = validateWithinLocatorText(LO_TXT_GLOBAL_GLOBAL_EXCEL_CLAIM_NUMBER_PRECEDING_DECEASED_PERSON_INSURANCE,globalExcelClaimNumber ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
                    result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
                    return result;
                }

                /*
                * Validates if "What were your original trip dates" is correct.
                * @return A string including [PASS] or [FAIL] along with specific result
                * details.
                * 
                */

                public String verifyWhatWereYourOriginalTripDates(String whatWereYourOriginalTripDates) {
                    String result = validateWithinLocatorText(LO_TXT_GLOBAL_WHAT_WERE_YOUR_ORIGINAL_TRIP_DATES,whatWereYourOriginalTripDates ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
                    result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
                    return result;
                }

                /*
                * Validates if "Incident Date" following "Trip Purchase Date" is correct.
                * @return A string including [PASS] or [FAIL] along with specific result
                * details.
                * 
                */

                public String verifyIncidentDateFollowingWhatHappened(String incidentDate) {
                    String result = validateWithinLocatorText(LO_TXT_GLOBAL_INCIDENT_DATE_FOLLOWING_WHAT_HAPPENED,incidentDate ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
                    result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
                    return result;
                }

                /*
                * Validates if "What Happened" preceding "What were your original trip dates" is correct.
                * @return A string including [PASS] or [FAIL] along with specific result
                * details.
                * 
                */

                public String verifyWhatHappenedPrecedingWhatWereYourOriginalTripDates(String whatHappened) {
                    String result = validateWithinLocatorText(LO_TXT_GLOBAL_WHAT_HAPPENED_PRECEDING_WHAT_WERE_YOUR_ORIGINAL_TRIP_DATES,whatHappened ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
                    result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
                    return result;
                }

                /*
                * Validates if "Contract Number" is correct.
                * @return A string including [PASS] or [FAIL] along with specific result
                * details.
                * 
                */

                public String verifyContractNumber(String contractNumber) {
                    String result = validateWithinLocatorText(LO_TXT_GLOBAL_CONTRACT_NUMBER,contractNumber ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
                    result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
                    return result;
                }

                /*
                * Validates if "Member Certificate Number" is correct.
                * @return A string including [PASS] or [FAIL] along with specific result
                * details.
                * 
                */

                public String verifyMemberCertificateNumber(String memberCertificateNumber) {
                    String result = validateWithinLocatorText(LO_TXT_GLOBAL_MEMBER_CERTIFICATE_NUMBER,memberCertificateNumber ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
                    result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
                    return result;
                }

                /*
                * Validates if "Insurance Type" following "Employer/Group Name" is correct.
                * @return A string including [PASS] or [FAIL] along with specific result
                * details.
                * 
                */

                public String verifyInsuranceTypeFollowingEmployerGroupName(String insuranceType) {
                    String result = validateWithinLocatorText(LO_TXT_GLOBAL_INSURANCE_TYPE_FOLLOWING_EMPLOYER_GROUP_NAME,insuranceType ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
                    result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
                    return result;
                }

                /*
        * Validates if "Group name" entered is correct.

        * @return A string including [PASS] or [FAIL] along with specific result
        * details.
        */

            public String verifyGroupNamePlanNumber(String groupNamePlanNumber) {
                String result = validateWithinLocatorText(LO_TXT_GLOBAL_GROUP_NAME_PLAN_NUMBER,groupNamePlanNumber ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
                result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
                return result;
            }

            /*
        * Validates if "Employer Group Name" entered is correct.
        *@return A string including [PASS] or [FAIL] along with specific result
        * details.
        */

            public String verifyEmployerGroupName(String employerGroupName) {
                String result = validateWithinLocatorText(LO_TXT_GLOBAL_EMPLOYER_GROUP_NAME,employerGroupName ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
                result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
                return result;
            }

            /*
        * Validates if "Are you currently Travelling" chose option is correct.
        *@return A string including [PASS] or [FAIL] along with specific result
        * details.
        */

            public String verifyAreYouCurrentlyTravelling(String areYouCurrentlyTravelling) {
                String result = validateWithinLocatorText(LO_TXT_GLOBAL_ARE_YOU_CURRENTLY_TRAVELLING,areYouCurrentlyTravelling ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
                result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
                return result;
            }

            /*
        * Validates if "Date of Injury" entered is correct.
        *@return A string including [PASS] or [FAIL] along with specific result
        * details.
        */

            public String verifyDateOfInjury(String dateOfInjury) {
                String result = validateWithinLocatorText(LO_TXT_GLOBAL_DATE_OF_INJURY,dateOfInjury ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
                result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
                return result;
            }

            /*
        * Validates if "Reason For Consult" following Date of Injury entered is correct.
        *@return A string including [PASS] or [FAIL] along with specific result
        * details.
        */

            public String verifyReasonForConsultFollowingDateOfInjury(String reasonForConsult) {
                String result = validateWithinLocatorText(LO_TXT_GLOBAL_REASON_FOR_CONSULT_FOLLOWING_DATE_OF_INJURY,reasonForConsult ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
                result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
                return result;
            }

            /*
        * Validates if "Incident Location" following What Happened is correct.
        *@return A string including [PASS] or [FAIL] along with specific result
        * details.
        */

            public String verifyIncidentLocationFollowingWhatHappened(String incidentLocation) {
                String result = validateWithinLocatorText(LO_TXT_GLOBAL_INCIDENT_LOCATION_FOLLOWING_WHAT_HAPPENED,incidentLocation ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
                result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
                return result;
            }

            /*
        * Validates if "What Happened" preceding Incident Location is correct.
        *@return A string including [PASS] or [FAIL] along with specific result
        * details.
        */

            public String verifyWhatHappenedPrecedingIncidentLocation(String whatHappened) {
                String result = validateWithinLocatorText(LO_TXT_GLOBAL_WHAT_HAPPENED_PRECEDING_INCIDENT_LOCATION,whatHappened ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
                result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
                return result;
            }

            /*
        * Validates if "Employer Name" following "Plan Number" is correct.
        *@return A string including [PASS] or [FAIL] along with specific result
        * details.
        */

            public String verifyEmployerNameFollowingPlanNumber(String employerName) {
                String result = validateWithinLocatorText(LO_TXT_GLOBAL_EMPLOYER_NAME_FOLLOWING_PLAN_NUMBER,employerName ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
                result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
                return result;
            }

            /*
        * Validates if "The Insured" Following "Other Insurance" entered is correct.
        *@return A string including [PASS] or [FAIL] along with specific result
        * details.
        */

            public String verifyTheInsuredFollowingOtherInsurance(String theInsured) {
                String result = validateWithinLocatorText(LO_TXT_GLOBAL_THE_INSURED_FOLLOWING_OTHER_INSURANCE,theInsured ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
                result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
                return result;
            }

            /*
        * Validates if "Manufacturer Name" following "Where did the incident occur" entered is correct.
        *@return A string including [PASS] or [FAIL] along with specific result
        * details.
        */

            public String verifyManufacturerNameFollowingWhereDidTheIncidentOccur(String manufacturerName) {
                String result = validateWithinLocatorText(LO_TXT_GLOBAL_MANUFACTURER_NAME_FOLLOWING_WHERE_DID_THE_INCIDENT_OCCUR,manufacturerName ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
                result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
                return result;
            }

            /*
        * Validates if "Where did the incident occur" entered is correct.
        *@return A string including [PASS] or [FAIL] along with specific result
        * details.
        */

            public String verifyWhereDidTheIncidentOccur(String whereDidTheIncidentOccur) {
                String result = validateWithinLocatorText(LO_TXT_GLOBAL_WHERE_DID_THE_INCIDENT_OCCUR,whereDidTheIncidentOccur ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
                result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
                return result;
            }

            /*
        * Validates if "Transit Number" entered is correct.
        *@return A string including [PASS] or [FAIL] along with specific result
        * details.
        */

            public String verifyTransitNumber(String transitNumber) {
                String result = validateWithinLocatorText(LO_TXT_GLOBAL_TRANSIT_NUMBER,transitNumber ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
                result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
                return result;
            }

            /*
        * Validates if "Institution Number" entered is correct.
        *@return A string including [PASS] or [FAIL] along with specific result
        * details.
        */

            public String verifyInstitutionNumber(String institutionNumber) {
                String result = validateWithinLocatorText(LO_TXT_GLOBAL_INSTITUTION_NUMBER,institutionNumber ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
                result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
                return result;
            }

            /*
        * Validates if "Account Number" entered is correct.
        *@return A string including [PASS] or [FAIL] along with specific result
        * details.
        */

            public String verifyAccountNumber(String accountNumber) {
                String result = validateWithinLocatorText(LO_TXT_GLOBAL_ACCOUNT_NUMBER,accountNumber ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
                result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
                return result;
            }

            /*
        * Validates if "What Happened" preceding "Incident Date" entered is correct.
        *@return A string including [PASS] or [FAIL] along with specific result
        * details.
        */

            public String verifyWhatHappenedPrecedingIncidentDate(String whatHappened) {
                String result = validateWithinLocatorText(LO_TXT_GLOBAL_WHAT_HAPPENED_PRECEDING_INCIDENT_DATE,whatHappened ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
                result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
                return result;
            }

            /*
        * Validates if "Preferred Method Of Payment?Reimbursement" following Transit Number entered is correct.
        *@return A string including [PASS] or [FAIL] along with specific result
        * details.
        */

            public String verifyPreferredMethodOfPaymentReimbursementFollowingTransitNumber(String preferredMethodOfPaymentReimbursement) {
                String result = validateWithinLocatorText(LO_TXT_GLOBAL_PREFERRED_METHOD_OF_PAYMENT_REIMBURSEMENT_FOLLOWING_TRANSIT_NUMBER,preferredMethodOfPaymentReimbursement ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
                result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
                return result;
            }

            /*
        * Validates if "Travelling From" following "When was your scheduled date and departure time?" entered is correct.
        *@return A string including [PASS] or [FAIL] along with specific result
        * details.
        */

            public String verifyTravellingFromFollowingWhenWasYourScheduledDateAndDepartureTime(String travellingFrom) {
                String result = validateWithinLocatorText(LO_TXT_GLOBAL_TRAVELLING_FROM_FOLLOWING_WHEN_WAS_YOUR_SCHEDULED_DATE_AND_DEPARTURE_TIME,travellingFrom ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
                result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
                return result;
            }

            /*
        * Validates if "Member ID" entered is correct.
        *@return A string including [PASS] or [FAIL] along with specific result
        * details.
        */

            public String verifyMemberID(String memberID) {
                String result = validateWithinLocatorText(LO_TXT_GLOBAL_MEMBER_ID,memberID ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
                result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
                return result;
            }

            /*
        * Validates if "Contract/Group Number" entered is correct.
        *@return A string including [PASS] or [FAIL] along with specific result
        * details.
        */

            public String verifyContractGroupNumber(String contractGroupNumber) {
                String result = validateWithinLocatorText(LO_TXT_GLOBAL_CONTRACT_GROUP_NUMBER,contractGroupNumber ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
                result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
                return result;
            }

            /*
        * Validates if "Employer Name" following "contract/Group Number" entered is correct.
        *@return A string including [PASS] or [FAIL] along with specific result
        * details.
        */

            public String verifyEmployerNameFollowingContractGroupNumber(String employerName) {
                String result = validateWithinLocatorText(LO_TXT_GLOBAL_EMPLOYER_NAME_FOLLOWING_CONTRACT_GROUP_NUMBER,employerName ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
                result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
                return result;
            }

            /*
        * Validates if "Preferred Method of Payment/Reimbursement" following "Is the email address the same as the Claimant's email address?|" entered is correct.
        *@return A string including [PASS] or [FAIL] along with specific result
        * details.
        */

            public String verifyPreferredMethodOfPaymentReimbursementFollowingIsTheEmailAddressTheSameAsTheClaimantsEmailAddress(String preferredMethodOfPaymentReimbursement) {
                String result = validateWithinLocatorText(LO_TXT_GLOBAL_PREFERRED_METHOD_OF_PAYMENT_REIMBURSEMENT_FOLLOWING_IS_THE_EMAIL_ADDRESS_THE_SAME_AS_THE_CLAIMANTS_EMAIL_ADDRESS,preferredMethodOfPaymentReimbursement ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
                result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
                return result;
            }

            /*
        * Validates if "Is the email address the same as the Claimant's email address?" entered is correct.
        *@return A string including [PASS] or [FAIL] along with specific result
        * details.
        */

            public String verifyIsTheEmailAddressTheSameAsTheClaimantsEmailAddressWithSymbol(String isTheEmailAddressTheSameAsTheClaimantsEmailAddress) {
                String result = validateWithinLocatorText(LO_TXT_GLOBAL_IS_THE_EMAIL_ADDRESS_THE_SAME_AS_THE_CLAIMANTS_EMAIL_ADDRESS_SYMBOL,isTheEmailAddressTheSameAsTheClaimantsEmailAddress ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
                result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
                return result;
            }

            /*
        * Validates if "Expense Item 1" following "Type of Expense" entered is correct.
        *@return A string including [PASS] or [FAIL] along with specific result
        * details.
        */

            public String verifyExpenseItem1FollowingTypeOfExpense(String expenseItem1) {
                String result = validateWithinLocatorText(LO_TXT_GLOBAL_EXPENSE_ITEM_1_FOLLOWING_TYPE_OF_EXPENSE,expenseItem1 ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
                result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
                return result;
            }

            /*
        * Validates if "When Did the Incident Occur" following "Where did the incident occur? "entered is correct.
        *@return A string including [PASS] or [FAIL] along with specific result
        * details.
        */

            public String verifyWhenDidTheIncidentOccurFollowingWhereDidTheIncidentOccur(String whenDidTheIncidentOccur) {
                String result = validateWithinLocatorText(LO_TXT_GLOBAL_WHEN_DID_THE_INCIDENT_OCCUR_FOLLOWING_WHERE_DID_THE_INCIDENT_OCCUR,whenDidTheIncidentOccur ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
                result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
                return result;
            }

            /*
        * Validates if "Where did the incident occur?" entered is correct.
        *@return A string including [PASS] or [FAIL] along with specific result
        * details.
        */

            public String verifyWhereDidTheIncidentOccurFollowingWasThePolicyHolderTheDriverAtTheTimeOfIncident(String whereDidTheIncidentOccur) {
                String result = validateWithinLocatorText(LO_TXT_GLOBAL_WHERE_DID_THE_INCIDENT_OCCUR_FOLLOWING_WAS_THE_POLICYHOLDER_THE_DRIVER,whereDidTheIncidentOccur ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
                result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
                return result;
            }

            public String verifyWhereDidTheIncidentOccurReviewPage(String whereDidTheIncidentOccur) {
                String result = validateWithinLocatorText(LO_TXT_WHERE_DID_THE_INCIDENT_OCCUR_REVIEW_PAGE,whereDidTheIncidentOccur ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
                result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
                return result;
            }

            /*
        * Validates if "Preferred Method of Payment/Reimbursement" following "Preferred Method of Payment/Reimbursement'] and following-sibling::div[div//strong[text()="Is the email address the same as the Claimant's email address?" entered is correct.
        *@return A string including [PASS] or [FAIL] along with specific result
        * details.
        */

            public String verifyPreferredMethodOfPaymentReimbursementFollowingIsTheEmailAddress(String preferredMethodOfPaymentReimbursement) {
                String result = validateWithinLocatorText(LO_TXT_GLOBAL_PREFERRED_METHOD_OF_PAYMENT_REIMBURSEMENT_FOLLOWING_IS_THE_EMAIL_ADDRESS,preferredMethodOfPaymentReimbursement ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
                result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
                return result;
            }

            public String verifyEmailAddressReviewPage(String emailAddress) {
                String result = validateWithinLocatorText(LO_TXT_EMAIL_REVIEW_PAGE,emailAddress ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
                result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
                return result;
            }

              /*
        * Validates if "Insurance Type" following Employee Name entered is correct.
        *
        * @return A string including [PASS] or [FAIL] along with specific result
        * details.
        */

        public String verifyInsuranceTypeFollowingEmployeeName(String insuranceTypeFollowingEmployeeName) {
            String result = validateWithinLocatorText(LO_TXT_GLOBAL_INSURANCE_TYPE_FOLLOWING_EMPLOYEE_NAME,insuranceTypeFollowingEmployeeName,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
            result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
            return result;
        }

        /* Validates if "Employee name" entered is correct.

        * @return A string including [PASS] or [FAIL] along with specific result
        * details.
        */

            public String verifyEmployeeNamePlanNumber(String employeeNamePlanNumber) {
                String result = validateWithinLocatorText(LO_TXT_GLOBAL_EMPLOYEE_NAME_PLAN_NUMBER,employeeNamePlanNumber ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
                result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
                return result;
            }
    
}
