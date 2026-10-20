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
public class PO_Review_Submit extends CU_Appian {

    // [Note: Automation Engineer, define the Page Object (PO) locators (LO) here.]
    private static final String LO_REVIEW_SUBMIT_PAGE_VERIFY = "//span[contains(text(),'Réviser et soumettre la réclamation')]/..";
    private static final String LO_TXT_REVIEW_SUBMIT_PAGE_VERIFY_ZURICH = "//h2[contains(text(),'VÉRIFIER ET SOUMETTRE LA RÉCLAMATION')]/..";
    private static final String LO_BUT_SAVE_DRAFT = "//span//span[contains(text(),'Enregistrer comme brouillon')]";
    private static final String LO_CHK_AGREE_TO_ALL = "//label[@class='CheckboxGroup---choice_label']";
    private static final String LO_BUT_SUBMIT_CLAIM = "//span//span[contains(text(),'Soumettre la réclamation')]";
    private static final String LO_TXT_GLOBAL_TYPE_OF_EXPENSE_FOLLOWING_PROVINCE = "//div[div//strong[text()='Type de réclamation '] and following-sibling::div[div//strong[text()='Province']]]";

    private static final String LO_TXT_REVIEW_AND_SUBMIT_CLAIM_PAGE_VERIFY = "//h2/span[contains(text(), 'Réviser et soumettre la réclamation')]";
    private static final String LO_BUT_SAVE_AS_DRAFT = "//span//span[contains(text(),'Enregistrer comme brouillon')]";
    private static final String LO_TXT_GLOBAL_INSURANCE_TYPE = "//div[div//strong[text()=\"Type d'assurance\"] and following-sibling::div[div//strong[text()='Six premiers chiffres']]]";
    private static final String LO_TXT_GLOBAL_INSURANCE_TYPE_FOLLOWING_POLICY_NUMBER = "//div[div//strong[text()=\"Type d'assurance\"] and following-sibling::div[div//strong[text()='Six premiers chiffres']]]";
    private static final String LO_TXT_GLOBAL_INSURANCE_TYPE_FOLLOWING_GROUP_NAME = "//div[div//strong[text()='Insurance Type'] and following-sibling::div[div//strong[text()='Group name']]]";
    private static final String LO_TXT_GLOBAL_FIRST_6_DIGITS = "//div[div[div[span[contains(text(), \"Six premiers chiffres\")]]]]";
    private static final String LO_TXT_GLOBAL_LAST_4_DIGITS = "//div[div[div[span[contains(text(), \"Quatre derniers chiffres\")]]]]";
    private static final String LO_TXT_GLOBAL_THE_INSURED = "//div[div//strong[text()='La personne assurée']and following-sibling::div[div//strong[text()='Autre(s) personne(s) assurée(s)']]]";
    private static final String LO_TXT_GLOBAL_OTHER_INSURED_PERSONS = "//div[div[div[h3[contains(text(), \"AUTRE(S) PERSONNE(S) ASSURÉE(S)\")]]]]";
    private static final String LO_TXT_GLOBAL_OTHER_INSURANCE_TYPE = "//div[div//strong[text()=\"Autre assurance\"]and preceding-sibling::div[div//strong[text()='Autre(s) personne(s) assurée(s)']]]";
    private static final String LO_TXT_GLOBAL_PREFERRED_METHOD_OF_COMMUNICATION = "//div[div[div//span[text()=\"Mode de communication privilégié\"]]/following-sibling::div[div//label[contains(text(), 'Adresse courriel')]]]";
    private static final String LO_TXT_GLOBAL_DATE_OF_LOSS = "//div[div//strong[text()='Date of Loss'] and following-sibling::div[div//strong[text()='Trip Dates']]]";
    private static final String LO_TXT_GLOBAL_TRIP_DATES = "//div[div//strong[text()='Dates de voyage'] and following-sibling::div[div//strong[text()='Date de retour prévue']]]";
    private static final String LO_TXT_GLOBAL_TRAVELLING_FROM = "//div[div//strong[text()='Lieu de départ'] and following-sibling::div[div//strong[text()='Destination de voyage']]]";
    private static final String LO_TXT_GLOBAL_INCIDENT_HAPPENED_AT_TRAVEL_DESTINATION = "//div[div//strong[text()=\"L'incident a eu lieu à la destination de voyage\"] and following-sibling::div[div//strong[text()=\"Lieu de l'incident\"]]]";
    private static final String LO_TXT_GLOBAL_INCIDENT_LOCATION = "//div[div//strong[text()=\"Lieu de l'incident\"] and following-sibling::div[div//strong[text()=\"Que s'est-il passé ?\"]]]";
    private static final String LO_TXT_GLOBAL_PERSONAL_EFFECTS_IN_CUSTODY = "//div[div//strong[text()='Biens personnels sous la responsabilité de la compagnie aérienne, du transporteur par autobus ou de la croisière'] and following-sibling::div[div//strong[text()='Nom du fournisseur de voyage']]]";
    private static final String LO_TXT_GLOBAL_NAME_OF_TRAVEL_PROVIDER = "//div[div//strong[text()='Nom du fournisseur de voyage'] and following-sibling::div[div//strong[text()='Nombre de bagages en retard']]]";
    private static final String LO_TXT_GLOBAL_BAGS_DELAYED = "//div[div//strong[text()=\"Nombre de bagages en retard\"] and following-sibling::div[div//strong[text()=\"Date d'arrivée prévue des bagages\"]]]";
    private static final String LO_TXT_GLOBAL_BAGGAGE_EXPECTED_DATE = "//div[div//strong[text()=\"Date d'arrivée prévue des bagages\"] and following-sibling::div[div//strong[text()='Date de réception prévue des bagages']]]";
    private static final String LO_TXT_GLOBAL_BAGGAGE_RECEIVED_DATE = "//div[div//strong[text()='Date de réception prévue des bagages'] and following-sibling::div[div//strong[text()='Date du dépôt de la déclaration']]]";
    private static final String LO_TXT_GLOBAL_REPORT_FILED_DATE = "//div[div//strong[text()=\"Date du dépôt de la déclaration\"] and following-sibling::div[div//strong[text()=\"Que s'est-il passé ?\"]]]";
    private static final String LO_TXT_GLOBAL_WHAT_HAPPENED = "//div[div[div[div[div[p[strong[contains(text(), \"Que s'est-il passé ?\")]]]]]]]";
    private static final String LO_TXT_GLOBAL_CLAIM_TYPE_ZURICH = "//div[div[div[span[contains(text(), \"Type de réclamation \")]]]]";
    private static final String LO_TXT_GLOBAL_TYPE_OF_EXPENSE = "//div[div//strong[text()='Type de dépense'] and following-sibling::div[div//strong[text()='Montant payé (Équivalence en CAD)']]]";
    private static final String LO_TXT_GLOBAL_AMOUNT_PAID = "//div[div//strong[text()='Montant payé (Équivalence en CAD)'] and following-sibling::div[div//strong[text()='Remboursement obtenu (Équivalence en CAD)']]]";
    private static final String LO_TXT_GLOBAL_REFUND_OBTAINED = "//div[div//strong[text()='Remboursement obtenu (Équivalence en CAD)'] and following-sibling::div[div//strong[text()='Montant total des dépenses réclamées ']]]";
    private static final String LO_TXT_GLOBAL_TOTAL_AMOUNT_OF_EXPENSES_CLAIMED = "//div[div//strong[contains(text(), 'Montant total des dépenses réclamées ')] and preceding-sibling::div[div//strong[text()='Remboursement obtenu (Équivalence en CAD)']]]";
    private static final String LO_TXT_GLOBAL_TOTAL_AMOUNT_OF_EXPENSES_CLAIMED_WITHOUT_DOTS = "//div[div//strong[text()='Total Amount of Expenses Claimed'] and preceding-sibling::div[div//strong[text()='Refund Obtained (Equivalent in CAD)']]]";
    private static final String LO_TXT_GLOBAL_PREFERRED_METHOD_OF_PAYMENT_REIMBURSEMENT = "//div[div//strong[text()=\"Mode de remboursement/paiement privilégié\"] and following-sibling::div[div//strong[text()=\"Adresse postale\"]]]";
    private static final String LO_TXT_GLOBAL_MAILING_ADDRESS = "//div[div[div[div[div[p[strong[contains(text(), \"L'adresse postale est la même que l'adresse à domicile inscrite à la section \")] and strong[contains(text(), \"«\")] and strong[contains(text(), \"À propos de vous\")] and strong[contains(text(), \"»\")]]]]]]]";
    private static final String LO_TXT_GLOBAL_REASON_FOR_DELAY = "//div[div//strong[text()='Reason for delay'] and following-sibling::div[div//strong[text()='Global Excel Claim Number']]]";
    private static final String LO_TXT_GLOBAL_GLOBAL_EXCEL_CLAIM_NUMBER = "//div[div[div[span[contains(text(), \"Numéro de réclamation Global Excel\")]]]]";
    private static final String LO_TXT_GLOBAL_WHEN_DID_THE_INCIDENT_OCCUR = "//div[div//strong[text()='When did the incident occur?'] and following-sibling::div[div//strong[text()='Travelling from']]]";
    private static final String LO_TXT_GLOBAL_WHEN_WAS_YOUR_SCHEDULED_DATE_AND_DEPARTURE_TIME = "//div[div//strong[text()='When was your scheduled date and departure time?'] and following-sibling::div[div//strong[text()='When was your actual date and departure time?']]]";
    private static final String LO_TXT_GLOBAL_WHEN_WAS_YOUR_ACTUAL_DATE_AND_DEPARTURE_TIME = "//div[div//strong[text()='When was your actual date and departure time?'] and following-sibling::div[div//strong[text()='Flight/Trip was delayed for: ']]]";
    private static final String LO_TXT_GLOBAL_FLIGHT_TRIP_WAS_DELAYED_FOR = "//div[div//strong[text()='Flight/Trip was delayed for: '] and following-sibling::div[div//strong[text()='Did your flight or trip delay cause you to miss a connection? ']]]";
    private static final String LO_TXT_GLOBAL_DID_YOUR_FLIGHT_OR_TRIP_DELAY_CAUSE_YOU_TO_MISS_A_CONNECTION = "//div[div//strong[text()='Did your flight or trip delay cause you to miss a connection? '] and following-sibling::div[div//strong[text()='What Happened?']]]";
    private static final String LO_TXT_GLOBAL_EMAIL_ADDRESS = "//div[div[div[span[contains(text(), \"Adresse courriel\")]]]]";
    private static final String LO_TXT_GLOBAL_TRAVELLING_FROM_PRECEDING_INCIDENT_OCCURANCE = "//div[div//strong[text()='Travelling from'] and preceding-sibling::div[div//strong[text()='When did the incident occur?']]]";
    private static final String LO_TXT_GLOBAL_WHAT_HAPPENED_FOR_FLIGHT_DELAY = "//div[div//strong[text()='What Happened?']and preceding-sibling::div[div//strong[text()='Did your flight or trip delay cause you to miss a connection? ']]]";
    private static final String LO_TXT_GLOBAL_PREFERRED_METHOD_OF_PAYMENT_REIMBURSEMENT_ON_FLIGHT_DELAY = "//div[div//strong[text()='Preferred Method of Payment/Reimbursement'] and following-sibling::div[div//strong[text()='Email Address']]]";
    private static final String LO_TXT_GLOBAL_INCIDENT_DATE = "//div[div//strong[text()=\"Date de l'incident\"] and following-sibling::div[div//strong[text()='Dates de voyage']]]";
    private static final String LO_TXT_GLOBAL_NAME_OF_HOTEL_MOTEL = "//div[div//strong[text()='Name of Hotel/Motel:'] and following-sibling::div[div//strong[text()='Hotel/Motel Address is:']]]";
    private static final String LO_TXT_GLOBAL_HOTEL_MOTEL_ADDRESS = "//div[div//strong[text()='Hotel/Motel Address is:'] and following-sibling::div[div//strong[text()='What Happened?']]]";
    private static final String LO_TXT_GLOBAL_WHAT_HAPPENED_FOR_HOTEL = "//div[div//strong[text()='What Happened?']and preceding-sibling::div[div//strong[text()='Hotel/Motel Address is:']]]";
    private static final String LO_TXT_GLOBAL_REASON_FOR_CLAIM = "//div[div//strong[text()='Reason for Claim'] and following-sibling::div[div//strong[text()='Global Excel Claim Number']]]";
    private static final String LO_TXT_GLOBAL_GLOBAL_INSURANCE_COMPANY = "//div[div//strong[text()=\"Compagnie d'assurance\"] and following-sibling::div[div//strong[text()='Numéro de certificat/police']]]";
    private static final String LO_TXT_GLOBAL_POLICY_NUMBER_CERTIFICATE_ID = "//div[div//strong[text()='Numéro de certificat/police'] and following-sibling::div[div//strong[text()='La personne assurée']]]";
    private static final String LO_TXT_GLOBAL_GLOBAL_EXCEL_CLAIM_NUMBER_FOR_BAGGAGE_LOSS = "//div[div//strong[text()='Global Excel Claim Number'] and preceding-sibling::div[div//strong[text()='Reason for Claim']]]";
    private static final String LO_TXT_GLOBAL_INSURANCE_TYPE_FOR_BAGGAGE_LOSS = "//div[div//strong[text()='Insurance Type'] and following-sibling::div[div//strong[text()='Insurance Company']]]";
    private static final String LO_TXT_GLOBAL_INCIDENT_HAPPENED_AT_TRAVEL_DESTINATION_FOR_BAGGAGE_LOSS = "//div[div//strong[text()='Incident happened at travel destination'] and following-sibling::div[div//strong[text()='Personal effects in custody(airline,bus,cruise)']]]";
    private static final String LO_TXT_GLOBAL_PERSONAL_EFFECTS_IN_CUSTODY_FOR_BAGGAGE_LOSS = "//div[div//strong[text()='Personal effects in custody(airline,bus,cruise)'] and following-sibling::div[div//strong[text()='Report filed date']]]";
    private static final String LO_TXT_GLOBAL_MAIN_REASON_FOR_CANCELLING_YOUR_TRIP = "//div[div//strong[text()=\"Raison principale de l'annulation\"] and following-sibling::div[div//strong[text()='Autre en raison de']]]";
    private static final String LO_TXT_GLOBAL_OTHER_DUE_TO = "//div[div//strong[text()=\"Autre en raison de\"] and following-sibling::div[div//strong[text()='Numéro de réclamation Global Excel']]]";
    private static final String LO_TXT_GLOBAL_GLOBAL_EXCEL_CLAIM_NUMBER_FOR_PRECEDING_OTHER_DUE_TO = "//div[div//strong[text()=\"Numéro de réclamation Global Excel\"] and preceding-sibling::div[div//strong[text()='Autre en raison de']]]";
    private static final String LO_TXT_GLOBAL_TRIP_DATES_FOLLOWING_TRAVEL_DESTINATION = "//div[div//strong[text()=\"Dates de voyage\"] and following-sibling::div[div//strong[text()='Destination de voyage']]]";
    private static final String LO_TXT_GLOBAL_TRAVEL_DESTINATION_FOLLOWING_INCIDENT_DATE = "//div[div//strong[text()=\"Destination de voyage\"] and following-sibling::div[div//strong[text()=\"Date de l'incident\"]]]";
    private static final String LO_TXT_GLOBAL_INCIDENT_DATE_FOLLOWING_CANCELLATION_DATE = "//div[div//strong[text()=\"Date de l'incident\"] and following-sibling::div[div//strong[text()=\"Date de l'annulation\"]]]";
    private static final String LO_TXT_PRINCIPAL_REASON_FOR_CANCELLATION ="//div[div//strong[text()=\"Raison principale de l'annulation\"] and following-sibling::div[div//strong[text()=\"Médical en raison de\"]]]";
    private static final String LO_TXT_GLOBAL_CANCELLATION_DATE_FOLLOWING_TRIP_PURCHASE_DATE = "//div[div//strong[text()=\"Date de l'annulation\"] and following-sibling::div[div//strong[text()=\"Date d'achat du voyage\"]]]";
    private static final String LO_TXT_GLOBAL_TRIP_PURCHASE_DATE = "//div[div//strong[text()=\"Date d'achat du voyage\"] and following-sibling::div[div//strong[text()=\"Que s'est-il passé ?\"]]]";
    private static final String LO_TXT_GLOBAL_WHAT_HAPPENED_PREDEDING_TRIP_PURCHASE_DATE = "//div[div//strong[text()=\"Que s'est-il passé ?\"]and preceding-sibling::div[div//strong[text()=\"Date d'achat du voyage\"]]]";
    private static final String LO_TXT_GLOBAL_ASSIGNMENT_OF_BENEFIT = "//div[div//strong[text()='Assignment of Benefit'] and following-sibling::div[div//strong[text()='Preferred Method of Payment/Reimbursement']]]";
    private static final String LO_TXT_GLOBAL_GROUP_NAME = "//div[div//strong[text()='Group name'] and following-sibling::div[div//strong[text()='Policy Number/Certificate ID']]]";
    private static final String LO_TXT_GLOBAL_POLICY_REFUND_OBTAINED_EQUIVALENT_IN_CAD_WITH_SPACE = "//div[div//strong[text()='Refund Obtained (Equivalent in CAD)'] and following-sibling::div[div//strong[text()='Total Amount of Expenses Claimed ']]]";
    private static final String LO_TXT_GLOBAL_TOTAL_AMOUNT_OF_EXPENSES_CLAIMED_WITH_SPACE = "//div[div//strong[text()='Total Amount of Expenses Claimed '] and preceding-sibling::div[div//strong[text()='Refund Obtained (Equivalent in CAD)']]]";
    private static final String LO_TXT_GLOBAL_MAIN_REASON_FOR_CANCELLING_YOUR_TRIP_MEDICAL = "//div[div//strong[text()='Main Reason for Cancelling your Trip'] and following-sibling::div[div//strong[text()='Medical due to']]]";
    private static final String LO_TXT_GLOBAL_MEDICAL_DUE_TO = "//div[div//strong[text()='Médical en raison de'] and following-sibling::div[div//strong[text()='Numéro de réclamation Global Excel']]]";
    private static final String LO_TXT_GLOBAL_GLOBAL_EXCEL_CLAIM_NUMBER_FOR_PRECEDING_MEDICAL_DUE_TO = "//div[div//strong[text()='Global Excel Claim Number'] and preceding-sibling::div[div//strong[text()='Medical due to']]]";
    private static final String LO_TXT_GLOBAL_CLAIM_TYPE = "//div[div//strong[text()='Claim Type '] and following-sibling::div[div//strong[text()='Province']]]";
    private static final String LO_TXT_GLOBAL_CLAIM_TYPE_FOLLOWING_GLOBAL_EXCEL_CLAIM_NUMBER = "//div[div//strong[text()='Claim Type '] and following-sibling::div[div//strong[text()='Global Excel Claim Number']]]";
    private static final String LO_TXT_GLOBAL_PROVINCE = "//div[div//strong[text()='Province'] and following-sibling::div[div//strong[text()='Numéro de réclamation Global Excel']]]";
    private static final String LO_TXT_GLOBAL_GLOBAL_EXCEL_CLAIM_NUMBER_PRECEDING_PROVINCE = "//div[div//strong[text()='Global Excel Claim Number'] and preceding-sibling::div[div//strong[text()='Province']]]";
    private static final String LO_TXT_GLOBAL_EMPLOYER_NAME = "//div[div//strong[text()='Employer Name'] and following-sibling::div[div//strong[text()='Policy Number/Certificate ID']]]";
    private static final String LO_TXT_GLOBAL_PROVINCIAL_HEALTH_CARD_NUMBER = "//div[div//strong[text()=\"Numéro de la carte d'assurance maladie provinciale\"]and following-sibling::div[div//strong[text()='Autre(s) personne(s) assurée(s)']]]";
    private static final String LO_TXT_GLOBAL_TRAVEL_DESTINATION_FOLLOWING_TRIP_DATES = "//div[div//strong[text()=\"Destination de voyage\"] and following-sibling::div[div//strong[text()=\"Dates de voyage\"]]]";
    private static final String LO_TXT_GLOBAL_TRIP_DATES_FOLLOWING_ORIGINAL_RETURN_DATE = "//div[div//strong[text()='Dates de voyage'] and following-sibling::div[div//strong[text()='Date de retour prévue']]]";
    private static final String LO_TXT_GLOBAL_ORIGINAL_RETURN_DATE = "//div[div//strong[text()='Date de retour prévue'] and following-sibling::div[div//strong[text()='Raison de la consultation']]]";
    private static final String LO_TXT_GLOBAL_REASON_FOR_CONSULT = "//div[div[div[div[div[p[strong[contains(text(), 'Raison de la consultation')]]]]]]]";
    private static final String LO_TXT_GLOBAL_FIRST_DATE_OF_TREATMENT = "//div[div//strong[text()='Date du premier traitement'] and following-sibling::div[div//strong[text()='Quand les premiers symptômes sont-ils apparus?']]]";
    private static final String LO_TXT_GLOBAL_WHEN_DID_FIRST_SYMPTOMS_APPEAR = "//div[div//strong[text()=\"Quand les premiers symptômes sont-ils apparus?\"] and following-sibling::div[div//strong[text()=\"Que s'est-il passé ?\"]]]";
    private static final String LO_TXT_GLOBAL_WHAT_HAPPENED_PRECEDING_WHEN_DID_FIRST_SYMPTOMS_APPEAR = "//div[div//strong[text()='What Happened?'] and preceding-sibling::div[div//strong[text()='When did first symptoms appear?']]]";
    private static final String LO_TXT_GLOBAL_EXPENSES = "//div[div//strong[text()='Dépenses'] and following-sibling::div[div//strong[text()='Dépense 1']]]";
    private static final String LO_TXT_GLOBAL_EXPENSE_ITEM_1 = "//div[div//strong[text()='Dépense 1'] and following-sibling::div[div//strong[text()='Montant facturé (Équivalence en CAD)']]]";
    private static final String LO_TXT_GLOBAL_AMOUNT_BILLED_EQUIVALENT_IN_CAD = "//div[div//strong[text()='Montant facturé (Équivalence en CAD)'] and following-sibling::div[div//strong[text()='Montant payé (Équivalence en CAD)']]]";
    private static final String LO_TXT_GLOBAL_AMOUNT_PAID_EQUIVALENT_IN_CAD = "//div[div//strong[text()='Montant payé (Équivalence en CAD)'] and following-sibling::div[div//strong[text()='Reçu inclus']]]";
    private static final String LO_TXT_GLOBAL_RECEIPT_INCLUDED = "//div[div//strong[text()=\"Reçu inclus\"] and preceding-sibling::div[div//strong[text()=\"Montant payé (Équivalence en CAD)\"]]]";
    private static final String LO_TXT_GLOBAL_TOTAL_ESTIMATED_PAID_AMOUNT = "//div[div//strong[text()='Estimation du montant total payé (CAD)'] and preceding-sibling::div[div//strong[text()='Reçu inclus']]]";
    private static final String LO_TXT_GLOBAL_INSURANCE_TYPE_FOLLOWING_EMPLOYER_NAME = "//div[div//strong[text()='Insurance Type'] and following-sibling::div[div//strong[text()='Employer Name']]]";
    private static final String LO_TXT_GLOBAL_PREFERRED_METHOD_OF_PAYMENT_REIMBURSEMENT_FOLLOWING_IS_THE_EMAIL_ADDRESS_THE_SAME = "//div[div//strong[text()='Preferred Method of Payment/Reimbursement'] and following-sibling::div[div//strong[text()=\"Is the email address the same as the Claimant's email address?\"]]]";
    private static final String LO_TXT_GLOBAL_IS_THE_EMAIL_ADDRESS_THE_SAME_AS_THE_CLAIMANTS_EMAIL_ADDRESS = "//div[div//strong[text()=\"L’adresse courriel est-elle la même que celle du demandeur?\"] and following-sibling::div[div//strong[text()='Adresse courriel']]]";
    private static final String LO_TXT_GLOBAL_GLOBAL_EXCEL_CLAIM_NUMBER_PRECEDING_CLAIM_TYPE = "//div[div//strong[text()='Global Excel Claim Number'] and preceding-sibling::div[div//strong[text()='Claim Type ']]]";
    private static final String LO_TXT_GLOBAL_COUNTRY_OF_ORIGIN = "//div[div//strong[text()='Country of Origin']and following-sibling::div[div//strong[text()='Trip Dates']]]";
    private static final String LO_TXT_GLOBAL_TEMPORARY_TRAVEL_DESTINATION = "//div[div//strong[text()='Temporary Travel Destination'] and following-sibling::div[div//strong[text()='Temporary Trip dates']]]";
    private static final String LO_TXT_GLOBAL_TEMPORARY_TRIP_DATES = "//div[div//strong[text()='Temporary Trip dates'] and following-sibling::div[div//strong[text()='Reason for Consult']]]";
    private static final String LO_TXT_GLOBAL_GLOBAL_EXCEL_CLAIM_NUMBER_FOLLOWING_ABOUT_YOUR_INSURANCE = "//div[div//strong[text()=\"Numéro de réclamation Global Excel\"] and following-sibling::div[div//h3//span[text()=\"À propos de votre assurance\"]]]";
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
    private static final String LO_TXT_GLOBAL_REFUND_OBTAINED_FOLLOWING_TOTAL_AMOUNT_OF_EXPENSES_CLAIMED = "//div[div[div[div[div[p[strong[contains(text(), 'Estimation du montant total payé (CAD):')]]]]]]]";
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
    private static final String LO_TXT_GLOBAL_PLAN_NUMBER = "//div[div//strong[text()='Plan Number'] and following-sibling::div[div//strong[text()='The Insured']]]";
    private static final String LO_TXT_GLOBAL_THE_INSURED_FOLLOWING_OTHER_INSURED_PERSONS = "//div[div//strong[text()=\"La personne assurée\"] and following-sibling::div[div//strong[text()='Autre(s) personne(s) assurée(s)']]]";
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
    private static final String LO_TXT_GLOBAL_DATE_OF_INJURY = "//div[div//strong[text()=\"Date de la blessure\"] and following-sibling::div[div//strong[text()=\"Lieu de l'incident\"]]]";
    private static final String LO_TXT_GLOBAL_REASON_FOR_CONSULT_FOLLOWING_DATE_OF_INJURY = "//div[div//strong[text()='Raison de la consultation'] and following-sibling::div[div//strong[text()='Date de la blessure']]]";
    private static final String LO_TXT_GLOBAL_INCIDENT_LOCATION_FOLLOWING_WHAT_HAPPENED = "//div[div//strong[text()='Incident Location'] and following-sibling::div[div//strong[text()='What Happened?']]]";
    private static final String LO_TXT_GLOBAL_WHAT_HAPPENED_PRECEDING_INCIDENT_LOCATION = "//div[div//strong[text()=\"Que s'est-il passé ?\"] and preceding-sibling::div[div//strong[text()=\"Lieu de l'incident\"]]]";
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
    private static final String LO_TXT_GLOBAL_PREFERRED_METHOD_OF_PAYMENT_REIMBURSEMENT_FOLLOWING_IS_THE_EMAIL_ADDRESS_THE_SAME_AS_THE_CLAIMANTS_EMAIL_ADDRESS = "//div[div//strong[text()='Preferred Method of Payment/Reimbursement'] and following-sibling::div[div//strong[text()=\"Is the email address the same as the Claimant's email address?|\"]]]";
    private static final String LO_TXT_GLOBAL_IS_THE_EMAIL_ADDRESS_THE_SAME_AS_THE_CLAIMANTS_EMAIL_ADDRESS_SYMBOL = "//div[div//strong[text()=\"Is the email address the same as the Claimant's email address?|\"] and following-sibling::div[div//strong[text()='Email Address']]]";
    private static final String LO_TXT_GLOBAL_EXPENSE_ITEM_1_FOLLOWING_TYPE_OF_EXPENSE = "//div[div//strong[text()='Expense Item 1'] and following-sibling::div[div//strong[text()='Type of Expense']]]";
    private static final String LO_TXT_GLOBAL_WHEN_DID_THE_INCIDENT_OCCUR_FOLLOWING_WHERE_DID_THE_INCIDENT_OCCUR = "//div[div//strong[text()='When did the incident occur?'] and following-sibling::div[div//strong[text()='Where did the incident occur? ']]]";
    private static final String LO_TXT_GLOBAL_WHERE_DID_THE_INCIDENT_OCCUR_FOLLOWING_WAS_THE_POLICYHOLDER_THE_DRIVER = "//div[div//strong[text()='Where did the incident occur? '] and following-sibling::div[div//strong[text()='Was the Policyholder the driver at the time of incident? ']]]";
    private static final String LO_TXT_GLOBAL_WHAT_HAPPENED_PRECEDING_DID_THE_INCIDENT_INVOLVE_ANOTHER_VEHICLE = "//div[div//strong[text()='What Happened?'] and preceding-sibling::div[div//strong[text()='Did the incident involve another vehicle? ']]]";
    private static final String LO_TXT_GLOBAL_PREFERRED_METHOD_OF_PAYMENT_REIMBURSEMENT_FOLLOWING_IS_THE_EMAIL_ADDRESS = "//div[div//strong[text()='Preferred Method of Payment/Reimbursement'] and following-sibling::div[div//strong[text()=\"Is the email address the same as the Claimant's email address?\"]]]";
    private static final String LO_TXT_GLOBAL_POSTAL_ADDRESS = "//div[div//strong[text()=\"Adresse postale\"] and preceding-sibling::div[div//strong[text()=\"Mode de remboursement/paiement privilégié\"]]]";
    private static final String LO_TXT_GLOBAL_INSURANCE_TYPE_FOLLOWING_INSURANCE_COMPANY = "//div[div//strong[text()=\"Type d'assurance\"] and following-sibling::div[div//strong[text()=\"Compagnie d'assurance\"]]]";
    private static final String LO_TXT_GLOBAL_PREFERRED_METHOD_OF_PAYMENT_OR_REIMBURSEMENT = "//div[div//strong[text()=\"Mode de remboursement/paiement privilégié\"] and following-sibling::div[div//strong[text()=\"L’adresse courriel est-elle la même que celle du demandeur?\"]]]";
    private static final String LO_TXT_GLOBAL_NAME = "//div[div[div[span[contains(text(), \"Nom\")]]]]";
    private static final String LO_TXT_CLAIM_TYPE_STATUS_EMT = "//h3[contains(text(), 'TRAVEL STATUS')]";
    private static final String LO_TXT_CLAIM_TYPE = "//div[span[contains(text(), 'Claim Type ')]]/following-sibling::div";
    private static final String LO_TXT_PROVINCE = "//div[div[div[span[contains(text(), \"Province\")]]]]";
    private static final String LO_TXT_GE_CLAIM_NUMBER = "//div[span[contains(text(), 'Global Excel Claim Number')]]/following-sibling::div";
    private static final String LO_TXT_ABOUT_THE_INSURED_TITLE = "//h3[contains(text(), 'ABOUT THE INSURED')]";
    private static final String LO_TXT_INSURANCE_TYPE = "//div[div[div[span[contains(text(), \"Type d'assurance\")]]]]";
    private static final String LO_TXT_POLICY_NUMBER_OR_CERTIFICATE_ID = "//div[span[contains(text(), 'Policy Number/Certificate ID')]]/following-sibling::div";
    private static final String LO_TXT_NAMES = "//div[span[contains(text(), 'Name')]]/following-sibling::div";
    private static final String LO_TXT_DOB = "//div[div[div[span[contains(text(), \"Date de naissance\")]]]]";
    private static final String LO_TXT_PHONE_NUMBER = "//div[div[div[span[contains(text(), \"Numéro de téléphone\")]]]]";
    private static final String LO_TXT_EMAIL = "//div[span[contains(text(), 'Email')]]/following-sibling::div";
    private static final String LO_TXT_LINE1_CITY_PROVINCE = "//div[span[contains(text(), 'Address')]]/following-sibling::div";
    private static final String LO_TXT_COUNTRY_POSTAL_CODE = "//div[span[contains(text(), 'Address')]]/following-sibling::div";
    private static final String LO_TXT_PROVINCIAL_HEALTH_CARD_NUMBER = "//div[div[div[span[contains(text(), \"Numéro de la carte d'assurance maladie provinciale\")]]]]";
    private static final String LO_TXT_ABOUT_INSURED = "//h3[contains(text(), \"A PROPOS DE L'ASSURÉ\")]";
    private static final String LO_TXT_TRAVEL_SITUATION = "//h3[contains(text(), 'SITUATION DE VOYAGE')]";
    private static final String LO_TXT_ADDRESS = "//div[div[div[span[contains(text(), \"Adresse\")]]]]";


    /**
     * Define the Page Object (PO) constructor.
     * @param driver The WebDriver object passed from the test method.
     */
    // [Note: Automation Engineer, rename this Page Object (PO) class to match the filename.]
    public PO_Review_Submit(WebDriver driver) {
        super(driver);
    }

    /**
     * Validates if current webpage is loaded and correct.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateOnPage() {
        String result = validateLocatorExists(LO_REVIEW_SUBMIT_PAGE_VERIFY, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Click "Save As Draft" button.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String clickSaveAsDraftButton() {
        String result = clickLocator(LO_BUT_SAVE_DRAFT, 30000);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
        
    }

    /**
     * Scrolls at a given locator.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String scrollTop() {
        String result = scrollToLocator(LO_REVIEW_SUBMIT_PAGE_VERIFY);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Scrolls at a given locator.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String scrollTopZurich() {
        String result = scrollToLocator(LO_TXT_REVIEW_SUBMIT_PAGE_VERIFY_ZURICH);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Click "I Agree to All" checkbox.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String clickAgreeToAllCheckbox() {
        String result = clickLocator(LO_CHK_AGREE_TO_ALL, 30000);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Click "Submit Claim" button.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String clickSubmitClaimButton() {
        String result = clickLocator(LO_BUT_SUBMIT_CLAIM, 30000);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if "Type of Expense" entered is correct
     * 
     * @return AA string including [PASS] or [FAIL] along with specific result
     *         details.
     */

     public String verifyTypeOfExpense(String typeOfExpense) {
        String result = validateWithinLocatorText(LO_TXT_GLOBAL_TYPE_OF_EXPENSE_FOLLOWING_PROVINCE,typeOfExpense ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
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
        String result = validateWithinLocatorText(LO_TXT_GLOBAL_TOTAL_AMOUNT_OF_EXPENSES_CLAIMED,totalAmountOfExpensesClaimed ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if "Preferred Method of Payment/Reimbursement" entered is correct
     * 
     * @return AA string including [PASS] or [FAIL] along with specific result
     *         details.
     */

    public String verifyPreferredMethodOfPaymentReimbursement(String preferredMethodOfPaymentReimbursement) {
        String result = validateWithinLocatorText(LO_TXT_GLOBAL_PREFERRED_METHOD_OF_PAYMENT_REIMBURSEMENT,preferredMethodOfPaymentReimbursement ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
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
        String result = validateWithinLocatorText(LO_TXT_GLOBAL_MAILING_ADDRESS,mailingAddress ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
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
              String result = validateWithinLocatorText(LO_TXT_GLOBAL_INCIDENT_DATE,incidentDate ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
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

            public String verifyGlobalExcelClaimNumberFollowingAboutYourInsurance(String globalExcelClaimNumber) {
                String result = validateWithinLocatorText(LO_TXT_GLOBAL_GLOBAL_EXCEL_CLAIM_NUMBER_FOLLOWING_ABOUT_YOUR_INSURANCE,globalExcelClaimNumber ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
                result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
                return result;
            }

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
    
                public String verifyTotalAmountOfExpensesClaimedPrecedingRefundObtained(String totalAmountOfExpensesClaimed) {
                    String result = validateWithinLocatorText(LO_TXT_GLOBAL_TOTAL_AMOUNT_OF_EXPENSES_CLAIMED,totalAmountOfExpensesClaimed ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
                    result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
                    return result;
                }

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

            /*
        * Validates if "Postal Address" entered is correct.
        *@return A string including [PASS] or [FAIL] along with specific result
        * details.
        */

            public String verifyPostalAddress(String postalAddress) {
                String result = validateWithinLocatorText(LO_TXT_GLOBAL_POSTAL_ADDRESS,postalAddress ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
                result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
                return result;
            }

            /*
        * Validates if "First six digits" entered is correct.
        *@return A string including [PASS] or [FAIL] along with specific result
        * details.
        */

            public String verifyFirstSixDigits(String firstSixDigits) {
                String result = validateWithinLocatorText(LO_TXT_GLOBAL_FIRST_6_DIGITS,firstSixDigits ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
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
        String result = validateWithinLocatorText(LO_TXT_GLOBAL_WHAT_HAPPENED,whatHappened ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates If "Insurance Type" entered is correct.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */

        public String verifyInsuranceTypeFollowingInsuranceCompany(String insuranceType) {
            String result = validateWithinLocatorText(LO_TXT_GLOBAL_INSURANCE_TYPE_FOLLOWING_INSURANCE_COMPANY,insuranceType ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
            result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
            return result;
        }

        /**
     * Validates If "Preferred Method of Payment or reimbursement" entered is correct.
     * @return A string including [PASS] or [FAIL] along with specific result
     * details.
     */

        public String verifyPreferredMethodOfPaymentOrReimbursement(String preferredMethodOfPaymentOrReimbursement) {
            String result = validateWithinLocatorText(LO_TXT_GLOBAL_PREFERRED_METHOD_OF_PAYMENT_OR_REIMBURSEMENT,preferredMethodOfPaymentOrReimbursement ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
            result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
            return result;
        }

        /**
         * Validates If "Name" entered is correct.
         * @return A string including [PASS] or [FAIL] along with specific result
         * details.
         */

        public String verifyName(String name) {
            String result = validateWithinLocatorText(LO_TXT_GLOBAL_NAME,name ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
            result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
            return result;
        }

        /**
         * Validates If "Principal reason of cancellation" entered is correct.
         * @return A string including [PASS] or [FAIL] along with specific result
         * details.
         */

        public String verifyPrincipalReasonForCancellation(String principalReasonOfCancellation) {
            String result = validateWithinLocatorText(LO_TXT_PRINCIPAL_REASON_FOR_CANCELLATION,principalReasonOfCancellation ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
            result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
            return result;
        }

        public String validateClaimTypeStatus(String status) {
        String result = validateWithinLocatorText(LO_TXT_CLAIM_TYPE_STATUS_EMT,status,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

     public String validateClaimType(String claimType) {
        String result = validateWithinLocatorText(LO_TXT_CLAIM_TYPE,claimType,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String validateProvince(String province) {
        String result = validateWithinLocatorText(LO_TXT_PROVINCE,province,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String validateGEClaimNumber(String geClaimNumber) {
        String result = validateWithinLocatorText(LO_TXT_GE_CLAIM_NUMBER,geClaimNumber,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String validateInsuranceType(String insurance_type) {
        String result = validateWithinLocatorText(LO_TXT_INSURANCE_TYPE,insurance_type,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String validatePolicyNumberOrCertificateID(String insurance_type) {
        String result = validateWithinLocatorText(LO_TXT_POLICY_NUMBER_OR_CERTIFICATE_ID,insurance_type,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String validateNames(String insurance_type) {
        String result = validateWithinLocatorText(LO_TXT_NAMES,insurance_type,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String validateDOB(String insurance_type) {
        String result = validateWithinLocatorText(LO_TXT_DOB,insurance_type,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String validatePhoneNumber(String insurance_type) {
        String result = validateWithinLocatorText(LO_TXT_PHONE_NUMBER,insurance_type,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String validateEmail(String insurance_type) {
        String result = validateWithinLocatorText(LO_TXT_EMAIL,insurance_type,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String validateLine1CityProvince(String insurance_type) {
        String result = validateWithinLocatorText(LO_TXT_LINE1_CITY_PROVINCE,insurance_type,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String validateCountryPostalCode(String insurance_type) {
        String result = validateWithinLocatorText(LO_TXT_COUNTRY_POSTAL_CODE,insurance_type,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String validateProvincialHealthCardNumber(String insurance_type) {
        String result = validateWithinLocatorText(LO_TXT_PROVINCIAL_HEALTH_CARD_NUMBER,insurance_type,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String validateAboutTheInsuredTitle() {
        String result = validateLocatorExists(LO_TXT_ABOUT_THE_INSURED_TITLE, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String validateAboutTheInsured() {
        String result = validateLocatorExists(LO_TXT_ABOUT_INSURED, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String validateTravelSituation() {
        String result = validateLocatorExists(LO_TXT_TRAVEL_SITUATION, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String validateClaimTypeZurich(String claimTypeZurich) {
        String result = validateWithinLocatorText(LO_TXT_GLOBAL_CLAIM_TYPE_ZURICH, claimTypeZurich, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(), true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

     public String validateOnReviewAndSubmitPage() {
        String result = validateLocatorExists(LO_TXT_REVIEW_SUBMIT_PAGE_VERIFY_ZURICH, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String verifyAddress(String address) {
        String result = validateLocatorExists(LO_TXT_ADDRESS, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

}
