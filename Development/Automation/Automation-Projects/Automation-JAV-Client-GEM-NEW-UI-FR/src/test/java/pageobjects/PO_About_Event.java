package pageobjects;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;   // Selenium WebDriver
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import customizations.automation.CU_Appian;
import framework.utilities.FW_ConfigMgr;// Automation framework customizations for Appian
import framework.utilities.FW_StringUtils;   // Automation framework Configuration Manager to retrieve testConfig.properties values


/**
 * Page Object (PO) class used in the Page Object (PO) design pattern. Inherits from the CU_Appian class.
 */
// [Note: Automation Engineer, rename this Page Object (PO) class to match the filename.]
public class PO_About_Event extends CU_Appian {
    WebDriver driver; // Note sure why this is required but this will not work without it.

    // [Note: Automation Engineer, define the Page Object (PO) locators (LO) here.]
    private static final String LO_ABOUT_EVENT_PAGE_VERIFY= "//div/h4[contains(text(), \"À PROPOS DE VOTRE ASSURANCE\")]";
    private static final String LO_ABOUT_EVENT_PAGE_VERIFY_NEW = "//div/h3[contains(text(), \"À PROPOS DE L'INCIDENT\")]";
    private static final String LO_ABOUT_EVENT_PAGE_VERIFY_WITH_SPAN = "//span[contains(text(), 'À propos de l')]";
    private static final String LO_LST_COUNTRY= "//div[span= 'Pays']/following-sibling::div//div[@role='combobox']";
    private static final String LO_COUNTRY_FROM_COMBOBOX= "(//div[span='Pays']/following-sibling::div//div//div//div)[1]";
    private static final String LO_EDT_CITY_FROM = "(//div[label='Ville']/following-sibling::div//div//input)[1]";
    private static final String LO_COUNTRY_COMBOBOX= "//div[span='Pays']/following-sibling::div//div[@role='combobox']";
    private static final String LO_EDT_CITY = "//div[label='Ville']/following-sibling::div//div//input";
    private static final String LO_EDT_FROM_DATE ="//div[label='De']/following-sibling::div//input";
    private static final String LO_EDT_TO_DATE ="//div[label='À']/following-sibling::div//input";
    private static final String LO_EDT_PURCHASE_DATE="//div[label=\"Date d'achat du voyage\"]/following-sibling::div//input";
    private static final String LO_EDT_INCIDENT_DATE = "//div[label=\"Date de l'incident\"]/following-sibling::div//input";
    private static final String LO_EDT_INCIDENT_DATE_WHEN_DID_THE_INCIDENT_OCCUR = "//div[label=\"À quelle date l'incident a-t-il eu lieu?\"]/following-sibling::div//input";
    private static final String LO_EDT_CANCELLATION_DATE="//div[label=\"Date de l'annulation\"]/following-sibling::div//input";
    private static final String LO_EDT_REASON_FOR_CANCELATION="//div[label='What was the reason for cancellation?']/following-sibling::div//div//input";
    private static final String LO_EDT_OTHER_DUE_TO="//div[label='If Other, was this due to:']/following-sibling::div//div//input";
    private static final String LO_EDT_REASON="//div[label=\"Veuillez donner une brève description de ce qui s'est passé, de la manière dont cela s'est produit et des personnes impliquées.\"]/following-sibling::div//div//textarea";
    private static final String LO_BUT_CONTINUE = "(//span//span[contains(text(), 'Continuer')])"; 
    private static final String LO_EDT_DEPARTURE_DATE="//div[label='Date de départ']/following-sibling::div//input";
    private static final String LO_EDT_RETURN_DATE="//div[label=\"Date de retour\"]/following-sibling::div//input";
    private static final String LO_RAD_BUT_YES="//div[span='La date de retour que vous avez indiquée est-elle la date de retour prévue initialement?']/following-sibling::div//label[text()='Oui']";
    private static final String LO_RAD_BUT_INJURY="//div[span=\"Votre réclamation est-elle liée à un problème de santé ou à une blessure?\"]/following-sibling::div//label[text()='Blessure']";
    private static final String LO_EDT_INJURY_DATE="//div[label='Date de la blessure']/following-sibling::div//input";
    private static final String LO_EDT_INJURY_CAUSE="//div[label=\"Veuillez décrire comment la blessure s'est produite\"]/following-sibling::div//div//textarea";
    private static final String LO_EDT_COUNTRY_TWO = "(//div[span='Pays']/following-sibling::div//div[@role='combobox'])[2]";
    private static final String LO_EDT_CITY_TWO="(//div[label='Ville']/following-sibling::div//div//input)[2]";
    private static final String LO_BUT_NO_OTHER_PARTY="//div[span=\"Y a-t-il une autre partie qui pourrait être responsable de votre blessure?\"]/following-sibling::div//label[text()='Non']";
    private static final String LO_BUT_NO_PHYSICIAN="//div[span=\"Avez-vous un médecin de famille?\"]/following-sibling::div//label[text()='Non']";
    private static final String LO_BUT_NO_CHRONIC_DISEASE="//div[span=\"Avez-vous une maladie chronique?\"]/following-sibling::div//label[text()='Non']";
    private static final String LO_EDT_INCIDENT_DATE_OCCURANCE = "//div[label=\"À quelle date l'incident a-t-il eu lieu?\"]/following-sibling::div//input";
    private static final String LO_RAD_BUT_NO_INCIDENT_HAPPEN_TRAVEL_DESTINATION ="//div[span[contains(text(), \"L'incident a-t-il eu lieu à la destination de voyage?\")]]/following-sibling::div//label[contains(text(), 'Non')]"; 
    private static final String LO_RAD_YES_CASTODY_OF_A_COMMON_CARRIER ="//div[span[contains(text(), \"Vos bagages ou effets personnels étaient-ils sous la garde d'un transporteur public?\")]]/following-sibling::div//label[contains(text(), 'Oui')]";
    private static final String LO_EDT_TRAVEL_PROVIDER_NAME ="//div[label='Quel est le nom de la compagnie ou du fournisseur de voyage?']/following-sibling::div//div//input"; 
    private static final String LO_EDT_HOW_MANY_BAGS = "//div[label='Combien de bagages ont été retardés?']/following-sibling::div//div//input"; 
    private static final String LO_EDT_SCHEDULED_DATE="(//div[span=\"Quand était l'arrivée prévue des bagages?\"])/following-sibling::div//input[@data-testid='DatePickerWidget-textInput']";
    private static final String LO_EDT_SCHEDULED_TIME="//div[span=\"Quand était l'arrivée prévue des bagages?\"]/following-sibling::div/div/div/following-sibling::div//input";
    private static final String LO_EDT_ACTUAL_DATE_BAGGAGE_WAS_RECEIVED = "(//div[span='À quel moment les bagages ont-ils été reçus ou livrés?'])/following-sibling::div//input[@data-testid='DatePickerWidget-textInput']";
    private static final String LO_EDT_ACTUAL_TIME_BAGGAGE_WAS_RECEIVED = "//div[span='À quel moment les bagages ont-ils été reçus ou livrés?']/following-sibling::div/div/div/following-sibling::div//input";
    private static final String LO_RAD_FILE_REPORT = "//div[span[contains(text(), \"Avez-vous soumis un constat auprès de la compagnie aérienne, de l'autocar, du croisiériste, du fournisseur de services de voyage, d'un service de police ou de toute autre autorité?\")]]/following-sibling::div//label[contains(text(), 'Non')]";
    private static final String LO_EDT_SHORT_SUMMARY_ON_WHAT_HAPPENED = "//div[label=\"Veuillez donner une brève description de ce qui s'est passé, de la manière dont cela s'est produit et des personnes impliquées.\"]/following-sibling::div//div//textarea";
    private static final String LO_COUNTRY_DESTINATION_COMBOBOX = "(//div[span='Pays']/following-sibling::div//div//div//div)[2]";
    private static final String LO_LST_CITY_DESTINATION= "(//div[label='Ville']/following-sibling::div//div//input)[2]";
    private static final String LO_COUNTRY_INCIDENT_OCCURANCE_COMBOBOX = "(//div[span='Pays']/following-sibling::div//div//div//div[@role='combobox'])[3]";
    private static final String LO_EDT_CITY_OF_OCCURANCE = "(//div[label='Ville']/following-sibling::div//div//input)[3]";
    private static final String LO_EDT_DESTINATION_COUNTRY="(//div[span='Pays']/following-sibling::div//div[@role='combobox'])[2]";
    private static final String LO_BUT_YES_INCIDENT_DESTINATION = "//div[span=\"L'incident a-t-il eu lieu à la destination de voyage?\"]/following-sibling::div//label[text()='Oui']";
    private static final String LO_BUT_NO_INCIDENT_DESTINATION = "//div[span=\"L'incident a-t-il eu lieu à la destination de voyage?\"]/following-sibling::div//label[text()='Non']";
    private static final String LO_BUT_NO_CUSTODY_COMMON_CARRIER="//div[span=\"Vos bagages ou effets personnels étaient-ils sous la garde d'un transporteur public?\"]/following-sibling::div//label[text()='Non']";
    private static final String LO_BUT_NO_FILE_REPORT="//div[span=\"Avez-vous soumis un constat auprès de la compagnie aérienne, de l'autocar, du croisiériste, du fournisseur de services de voyage, d'un service de police ou de toute autre autorité?\"]/following-sibling::div//label[text()='Non']";
    private static final String LO_DAMAGE_DESCRIPTION="//label[normalize-space()='Broken/Smashed']";
    private static final String LO_LST_INCIDENT_OCCURANCE_DATE = "//div[span='Identify the date in which your flight/trip was confirmed to be delayed.']/div/div/input";
    private static final String LO_LST_WHEN_DID_THE_INCIDENT_OCCUR = "//div[label=\"À quelle date l'incident a-t-il eu lieu?\"]/following-sibling::div//div//input";
    private static final String LO_EDT_SCHEDULED_DEPARTURE_DATE = "//div[span=\"Quelles étaient la date et l'heure de départ prévues? \"]/following-sibling::div/div/div/div/div/input";
    private static final String LO_EDT_SCHEDULED_DEPARTURE_TIME = "//div[span=\"Quelles étaient la date et l'heure de départ prévues? \"]/following-sibling::div/div/div/div/input";
    private static final String LO_EDT_ACTUAL_DEPARTURE_DATE = "//div[span=\"Quelles étaient la date et l'heure de départ réelles?\"]/following-sibling::div/div/div/div/div/input";
    private static final String LO_EDT_ACTUAL_DEPARTURE_TIME = "//div[span=\"Quelles étaient la date et l'heure de départ réelles?\"]/following-sibling::div/div/div/div/input";
    private static final String LO_RAD_NO_FLIGHT_DELAY_CAUSE = "//div[span[contains(text(), 'Le retard de vol ou de voyage vous a-t-il fait manquer votre correspondance?')]]/following-sibling::div//div/label[text()='Non']";
    private static final String LO_EDT_ITEM_DESCRIPTION = "//div[label=\"Description de l'article\"]/following-sibling::div//div//input";
    private static final String LO_EDT_ORIGINAL_PURCHASE_DATE = "//div[label=\"Date d'achat initiale :  \"]/following-sibling::div//div//div//input";
    private static final String LO_EDT_WHEN_INCIDENT_DATE_OCCURED = "//div[label=\"Date de l'incident\"]/following-sibling::div//div//div//input";
    private static final String LO_LST_PROVINCE = "//div[span='Province']/following-sibling::div//div//div//div[@role='combobox']";
    private static final String LO_EDT_RENTAL_AGENT_NAME="//div[label=\"Nom de l'agence de location : \"]/following-sibling::div//input";
    private static final String LO_RAD_YES_CREDIT_CARD="//div[span=\"La totalité des frais de location a-t-elle été portée à votre compte de carte de crédit?\"]/following-sibling::div//label[text()='Oui']";
    private static final String LO_INCIDENT_COUNTRY = "(//div[span='Pays']/following-sibling::div//div[@role='combobox'])[3]";
    private static final String LO_EDT_PROVINCE_OR_STATE = "//div[label='Province/State']/following-sibling::div//input";
    private static final String LO_RAD_YES_DRIVER_POLICYHOLDER = "//div[span=\"Le titulaire de police était-il au volant au moment de l'incident? \"]/following-sibling::div//label[text()='Oui']";
    private static final String LO_RAD_NO_DRIVER_POLICYHOLDER = "//div[span=\"Le titulaire de police était-il au volant au moment de l'incident? \"]/following-sibling::div//label[text()='Non']";
    private static final String LO_RAD_NO_OTHER_VEHICLE="//div[span=\"L'incident impliquait-il un autre véhicule? \"]/following-sibling::div//label[text()='Non']";
    private static final String LO_RAD_YES_OTHER_VEHICLE="//div[span=\"L'incident impliquait-il un autre véhicule? \"]/following-sibling::div//label[text()='Oui']";
    private static final String LO_RAD_NO_RENTAL_AGREEMENT = "//div[span=\"Aviez-vous signé un autre contrat de location dans les 48h suivant le début ou la fin de cette location? \"]/following-sibling::div//label[contains(text(),'Non')]";
    private static final String LO_EDT_YES_RENTAL_AGREEMENT = "//div[span=\"Aviez-vous signé un autre contrat de location dans les 48h suivant le début ou la fin de cette location? \"]/following-sibling::div//label[contains(text(),'Oui')]";
    private static final String LO_EDT_RENTAL_AGENCY_NAME = "//div[label=\"Nom de l'agence de location : \"]/following-sibling::div//input";
    private static final String LO_RAD_YES_FULL_COST_RENTAL_CREDIT_CARD = "//div[span=\"La totalité des frais de location a-t-elle été portée à votre compte de carte de crédit?\"]/following-sibling::div//label[contains(text(),'Oui')]";
    private static final String LO_RAD_YES_POLICY_HOLDER_WAS_DRIVER = "//div[span=\"Le titulaire de police était-il au volant au moment de l'incident? \"]/following-sibling::div//label[contains(text(),'Oui')]";
    private static final String LO_RAD_NO_INCIDENT_INVOLVED_ANOTHER_VEHICLE = "//div[span=\"L'incident impliquait-il un autre véhicule? \"]/following-sibling::div//label[contains(text(),'Non')]";
    private static final String LO_EDT_ACTUAL_TRAVEL_FROM_DATE="(//div[label='De']/following-sibling::div//input)[2]";
    private static final String LO_EDT_ACTUAL_TRAVEL_TO_DATE="(//div[label='À']/following-sibling::div//input)[2]";
    private static final String LO_RAD_ILLNESS = "//div[span='Votre réclamation est-elle liée à un problème de santé ou à une blessure?']/following-sibling::div//label[contains(text(),'Problème de santé')]";
    private static final String LO_EDT_REASON_FOR_CONSULT = "//div[label='Raison de la consultation']/following-sibling::div//div//textarea";
    private static final String LO_EDT_FIRST_DATE_TREATMENT = "//div[label='Date du premier traitement']/following-sibling::div//input";
    private static final String LO_EDT_FIRST_DATE_SYMPTOMS = "//div[label='Quand les premiers symptômes sont-ils apparus?']/following-sibling::div//input";
    private static final String LO_RAD_YES_THERE_WAS_DIAGNOSIS = "//div[span=\"Est-ce qu'un diagnostic médical a été posé? \"]/following-sibling::div//label[contains(text(),'Oui')]";
    private static final String LO_RAD_YES_THERE_WAS_DIAGNOSIS_WITHOUT_SPACE = "//div[span=\"Est-ce qu'un diagnostic médical a été posé?\"]/following-sibling::div//label[contains(text(),'Oui')]";
    private static final String LO_EDT_DIAGNOSIS = "//div[label='Diagnostic']/following-sibling::div//input";
    private static final String LO_EDT_NAME_MEDICAL_FACILITY = "//div[label=\"Nom du fournisseur médical\"]/following-sibling::div//input";
    private static final String LO_EDT_PHONE_NUMBER_MEDICAL_FACILITY = "//div[label=\"Numéro de téléphone du fournisseur médical:\"]/following-sibling::div//input";
    private static final String LO_EDT_MEDICAL_FACILITY_PHONE_NUMBER = "//div[label=\"Numéro de téléphone du fournisseur médical\"]/following-sibling::div//input";
    private static final String LO_RAD_NO_EXPERIENCED_THIS_MEDICAL_CONDITION_BEFORE = "//div[span='Avez-vous déjà eu ce problème de santé?']/following-sibling::div//label[contains(text(),'Non')]";
    private static final String LO_RAD_NO_RECEIVED_CONSULT_OR_TREATMENT = "//div[span='Avez-vous déjà consulté ou reçu un traitement pour ce problème de santé?']/following-sibling::div//label[contains(text(),'Non')]";
    private static final String LO_RAD_NO_ADMITTED_TO_HOSPITAL_BEFORE= "//div[span=\"Avez-vous déjà été admis à l'hôpital pour ce problème de santé?\"]/following-sibling::div//label[contains(text(),'Non')]";
    private static final String LO_EDT_MEDICATION_NAME = "//div[label='Nom du médicament 1\t ']/following-sibling::div//input";
    private static final String LO_RAD_YES_PRIMARY_FAMILY_PHYSICIAN = "//div[span=\"Avez-vous un médecin de famille?\"]/following-sibling::div//label[contains(text(),'Oui')]";
    private static final String LO_EDT_FIRST_NAME_FAMILY_PHYSICIAN = "//div[label='Prénom']/following-sibling::div//input";
    private static final String LO_EDT_LAST_NAME_FAMILY_PHYSICIAN = "//div[label='Nom de famille']/following-sibling::div//input";
    private static final String LO_EDT_PHONE_NUMBER_FAMILY_PHYSICIAN = "//div[label='Numéro de téléphone']/following-sibling::div//input";
    private static final String LO_RAD_NO_ANY_CHRONIC_ILLNESS_OR_DISEASE = "//div[span='Avez-vous une maladie chronique?']/following-sibling::div//label[contains(text(),'Non')]";
    private static final String LO_EDT_MANUFACTURER_NAME = "//div[label='Nom du fabricant']/following-sibling::div//div//input";
    private static final String LO_EDT_WHEN_DID_THE_INCIDENT_OCCUR = "//div[label=\"Date de l'incident\"]/following-sibling::div//div//input";
    private static final String LO_EDT_HOTEL_NAME = "//div[label=\"Nom de l'hôtel/du motel :\"]/following-sibling::div//input";
    private static final String LO_EDT_HOME_ADDRESS_LINE_1 = "//div[label='Adresse Ligne 1']/following-sibling::div//div//input";
    private static final String LO_EDT_HOME_ADDRESS_LINE_2 = "//div[label='Adresse Ligne 2']/following-sibling::div//div//input";
    private static final String LO_EDT_POSTAL_CODE = "//div[label='Code postal']/following-sibling::div//div//input";
    private static final String LO_EDT_COUNTRY = "//div[label='Pays']/following-sibling::div//div//input";
    private static final String LO_RAD_NO_MULTIPLE_INSTALLMENTS = "//div[span=\"Avez-vous payé l'article en plusieurs versements échelonnés?\"]/following-sibling::div//label[text()='Non']";
    private static final String LO_EDT_MANUFACTURER_WARRANTY = "//div[label=\"Durée de la garantie du fabricant\"]/following-sibling::div//input";
    private static final String LO_LST_UNIT_OF_TIME = "//div[span= 'Unité de temps']/following-sibling::div//div[@role='combobox']";
    private static final String LO_EDT_SERIAL_NUMBER = "//div[label='Numéro de série:']/following-sibling::div//input";
    private static final String LO_EDT_WHAT_HAPPENED = "//div[label=\"Veuillez donner une brève description de ce qui s'est passé, de la manière dont cela s'est produit et des personnes impliquées.\"]/following-sibling::div//textarea";
    private static final String LO_RAD_NO_RETURN_DATE_ORIGINALITY = "//div[span='La date de retour que vous avez indiquée est-elle la date de retour prévue initialement?']/following-sibling::div//label[text()='Non']";
    private static final String LO_EDT_ORIGINAL_RETURN_DATE = "//div[label='Date de retour prévue']/following-sibling::div//div//div//input";
    private static final String LO_EDT_COUNTRY_OF_INJURY = "(//div[span= 'Pays']/following-sibling::div//div//div//div[@role='combobox'])[2]";
    private static final String LO_EDT_CITY_OF_INJURY = "(//div[label='Ville']/following-sibling::div//div//input)[2]";
    private static final String LO_RAD_YES_ANY_CHRONIC_ILLNESS_OR_DISEASE = "//div[span='Avez-vous une maladie chronique?']/following-sibling::div//label[contains(text(),'Oui')]";
    private static final String LO_EDT_NAME_OF_ILLNESS = "//div[label='Nom du problème de santé']/following-sibling::div//div//input";
    private static final String LO_EDT_DATE_LAST_CONSULTED = "(//div[label='Date de la dernière consultation']/following-sibling::div//div//input)[2]";
    private static final String LO_EDT_DATE_LAST_CONSULTED_TWO = "//div[label='Date de la dernière consultation']/following-sibling::div//div//input";
    private static final String LO_RAD_YES_STILL_SEEKING_TREATMENT = "//div[span='En attente de traitement']/following-sibling::div//label[contains(text(),'Oui')]";
    private static final String LO_RAD_YES_EXP_MEDICAL_CONDITION="//div[span='Avez-vous déjà eu ce problème de santé?']/following-sibling::div//label[contains(text(),'Oui')]";
    private static final String LO_EDT_LAST_EPISODE_DATE="//div[label='Date du dernier épisode']/following-sibling::div//input";
    private static final String LO_RAD_YES_RECEIVED_CONSULT="//div[span='Avez-vous déjà consulté ou reçu un traitement pour ce problème de santé?']/following-sibling::div//label[contains(text(),'Oui')]";
    private static final String LO_EDT_LAST_APPOINTMENT_DATE="(//div[label='Date de la dernière consultation']/following-sibling::div//input)[1]";
    private static final String LO_RAD_NO_HOSPITAL_ADMITTED="//div[span=\"Avez-vous déjà été admis à l'hôpital pour ce problème de santé?\"]/following-sibling::div//label[contains(text(),'Non')]";
    private static final String LO_LST_VISITOR_COUNTRY_OF_ORIGIN = "//div[span=\"Pays d'origine\"]/following-sibling::div//div[@role='combobox']";
    private static final String LO_EDT_DATE_OF_ARRIVAL = "//div[label=\"Date d'arrivée\"]/following-sibling::div//input";
    private static final String LO_EDT_PLANNED_RETURN_DATE = "//div[label='Date de retour prévue']/following-sibling::div//input";
    private static final String LO_RAD_NO_TEMPORARY_TRIP_OUTSIDE_CANADA = "//div[span=\"Avez-vous effectué un voyage temporaire à l'extérieur du Canada?\"]/following-sibling::div//label[contains(text(),'Non')]";
    private static final String LO_RAD_YES_TEMPORARY_TRIP_OUTSIDE_CANADA = "//div[span='Avez-vous déjà eu ce problème de santé?']/following-sibling::div//label[contains(text(),'Oui')]";
    private static final String LO_RAD_YES_RECEIVED_CONSULT_OR_TREATMENT = "//div[span=\"Avez-vous déjà consulté ou reçu un traitement pour ce problème de santé?\"]/following-sibling::div//label[contains(text(),'Oui')]";
    private static final String LO_BUT_YES_CUSTODY_COMMON_CARRIER = "//div[span=\"Vos bagages ou effets personnels étaient-ils sous la garde d'un transporteur public?\"]/following-sibling::div//label[text()='Oui']";
    private static final String LO_BUT_YES_FILE_REPORT="//div[span=\"Avez-vous soumis un constat auprès de la compagnie aérienne, de l'autocar, du croisiériste, du fournisseur de services de voyage, d'un service de police ou de toute autre autorité?\"]/following-sibling::div//label[text()='Oui']";
    private static final String LO_EDT_REPORT_FILED_DATE="//div[label='Veuillez fournir la date à laquelle la déclaration a été déposée.']/following-sibling::div//div//div//input";
    private static final String LO_RAD_YES_ADMITTED_TO_HOSPITAL_BEFORE = "//div[span=\"Avez-vous déjà été admis à l'hôpital pour ce problème de santé?\"]/following-sibling::div//label[contains(text(),'Oui')]";
    private static final String LO_EDT_ADMIT_DATE = "//div[label=\"Date d'admission\"]/following-sibling::div//input";
    private static final String LO_EDT_DISCHARGE_DATE = "//div[label=\"Date de sortie d'hôpital\"]/following-sibling::div//input";
    private static final String LO_EDT_REASON_FOR_ADMISSION = "//div[label=\"Raison de l'admission\"]/following-sibling::div//input";
    private static final String LO_BUT_BACK = "//span[text()='Retour']";
    private static final String LO_BUT_SAVE_DRAFT = "//span//span[contains(text(),'Enregistrer comme brouillon')]";
    private static final String LO_LST_TRAVEL_DESTINATION_COUNTRY = "(//div[span= 'Pays']/following-sibling::div//div[@role='combobox'])[2]";
    private static final String LO_TXT_TIMER= "//h5[text()='Session expires in:']/following-sibling::p";
    private static final String LO_EDT_TRAVEL_DESTINATION_CITY = "//div[label='Ville']/following-sibling::div//input";
    private static final String LO_EDT_ORIGINAL_TRIP_DATE_FROM = "//div[label='De']/following-sibling::div//input";
    private static final String LO_EDT_ORIGINAL_TRIP_DATE_TO = "//div[label='À']/following-sibling::div//input";
    private static final String LO_EDT_TRIP_PURCHASE_DATE = "//div[label=\"Date d'achat du voyage\"]/following-sibling::div//input";
    private static final String LO_RAD_PERSON_CAUSING_CLAIM= "//div[span[contains(text(), \"Êtes-vous la personne qui a causé cette réclamation?\")]]/following-sibling::div//label[contains(text(), 'Oui')]";
    private static final String LO_EDT_CLICK_OUTSIDE_BOX= "//div/span[contains(text(), 'When was your scheduled date and arrival time?')]";
    private static final String LO_UPLOAD_ACCIDENT_FORM = "//div[div='Accident Form']//input";
    private static final String LO_LST_COUNTRY_TRAVELLING_FROM = "(//div[span='Pays']/following-sibling::div//div//div//div)[1]";
    private static final String LO_EDT_CITY_TRAVELLING_FROM = "(//div[label='Ville']/following-sibling::div//input)[1]";
    private static final String LO_LST_COUNTRY_TRAVELLING_DESTINATION = "(//div[span='Pays']/following-sibling::div//div//div//div)[2]";
    private static final String LO_EDT_CITY_TRAVELLING_DESTINATION = "(//div[label='Ville']/following-sibling::div//input)[2]";
    private static final String LO_LST_COUNTRY_WHERE_INCIDENT_OCCURED = "//div[span='Pays']/following-sibling::div//div//div//div";
    private static final String LO_EDT_CITY_WHERE_INCIDENT_OCCURED = "(//div[label='Ville']/following-sibling::div//input)[3]";
    private static final String LO_EDT_INCIDENT_DATE_OCCURANCE_H3 ="//h3[span=\"À quelle date l'incident a-t-il eu lieu?\"]/following-sibling::div//input";
    private static final String LO_EDT_PROVINCE_STATE="//div[label[contains(text(), 'Province/État')]]/following-sibling::div//input";
    private static final String LO_LST_COUNTRY_INJURY_OCCURED="//div[h4[contains(text(), \"Où s'est produite la blessure?\")]]/following-sibling::div//div[span='Pays']/following-sibling::div//div[@role='combobox']";
    private static final String LO_LST_CITY_INJURY_OCCURED="//div[h4[contains(text(), \"Où s'est produite la blessure?\")]]/following-sibling::div//div[label='Ville']/following-sibling::div//input";
    private static final String LO_LST_TRAVEL_DESTINATION_COUNTRY_PARAGRAPH = "//div[div[div[p='What was your travel destination?']]]/following-sibling::div//div[span='Country']/following-sibling::div//div[@role='combobox']";
    private static final String LO_LST_TRAVEL_DESTINATION_CITY_PARAGRAPH = "//div[div[div[p='What was your travel destination?']]]/following-sibling::div//div[label='City']/following-sibling::div//input";
    private static final String LO_LST_COUNTRY_OF_OCCURANCE = "(//div[span= 'Pays']/following-sibling::div//div//div//div[@role='combobox'])[3]";
    private static final String LO_EDT_BEGINNING_DATE_OF_RENTAL = "//div[label=\"Date de début\"]/following-sibling::div//input";
    private static final String LO_EDT_ENDING_DATE_OF_RENTAL = "//div[label=\"Date de fin\"]/following-sibling::div//input";
    private static final String LO_EDT_DRIVER_FIRST_NAME = "//div[label=\"Prénom du conducteur\"]/following-sibling::div//input";
    private static final String LO_EDT_DRIVER_LAST_NAME = "//div[label=\"Nom de famille du conducteur\"]/following-sibling::div//input";
    private static final String LO_EDT_VEHICLE_OWNER_FIRST_NAME = "//div[label=\"Prénom du propriétaire du véhicule\"]/following-sibling::div//input";
    private static final String LO_EDT_VEHICLE_OWNER_LAST_NAME = "//div[label=\"Nom de famille du propriétaire du véhicule \"]/following-sibling::div//input";
    private static final String LO_EDT_REPORT_POLICE_NUMBER = "//div[label=\"Numéro du rapport de police \"]/following-sibling::div//input";
    private static final String LO_ABOUT_EVENT_PAGE_VERIFY3= "//h3[contains(text(), \"À PROPOS DE L'INCIDENT\")]";
    private static final String LO_ABOUT_EVENT_PAGE_VERIFY_PARAGRAPH= "//p[contains(text(), \"Dites-nous ce qui s'est produit.\")]";
    private static final String LO_ABOUT_EVENT_PAGE_VERIFY_NOTIFICATION= "//p[contains(text(), \"Afin de traiter votre réclamation, nous devons comprendre ce qui s'est passé. Veuillez remplir cette section au mieux de vos connaissances.\")]";
    private static final String LO_ABOUT_EVENT_PAGE_VERIFY_CLAIM_DETAILS= "//h2[contains(text(), \"DÉTAILS DE LA RÉCLAMATION\")]";
    private static final String LO_ABOUT_EVENT_PAGE_VERIFY_TRAVEL_INFO_HEADING= "//h4[contains(text(), \"Informations de voyage\")]";
    private static final String LO_ABOUT_EVENT_PAGE_VERIFY_ORIGINAL_TRIP_DATES_HEADING= "//h4[contains(text(), 'Quelles étaient vos dates de voyage initiales?')]";
    private static final String LO_ABOUT_EVENT_PAGE_VERIFY_REASON_FOR_CONSULT_HEADING= "//h3[contains(text(), 'RAISON DE LA CONSULTATION')]";
    private static final String LO_ABOUT_EVENT_PAGE_VERIFY_MEDICAL_INFO_HEADING = "//div[contains(text(), 'Maladie chronique 1')]";
    private static final String LO_ABOUT_EVENT_PAGE_ADD_MEDICATION_VERIFY = "//h4[contains(text(), 'Indiquez tout médicament que vous preniez avant votre urgence médicale :')]";
    private static final String LO_ABOUT_EVENT_PAGE_ADD_ANOTHER_ILLNESS_OR_DISEASE_VERIFY = "//a[contains(text(), '+Ajouter une autre maladie ou un problème de santé')]";
    private static final String LO_TXT_DATE_TIME_HEADING = "//span[contains(text(),\"Quelles étaient la date et l'heure de départ réelles?\")]";
    /**
     * Define the Page Object (PO) constructor.
     * @param driver The WebDriver object passed from the test method.
     */
    // [Note: Automation Engineer, rename this Page Object (PO) class to match the filename.]
    public PO_About_Event(WebDriver driver) {
        super(driver);
        this.driver = driver;
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

    public String validateReasonForConsultHeading() {
        String result = validateLocatorExists(LO_ABOUT_EVENT_PAGE_VERIFY_REASON_FOR_CONSULT_HEADING, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
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
     * Selects 'Yes' to question : Was the full cost of the rental charged to your credit card?.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String selectYesRentalAgreementWithin48Hours() {
        String result = clickLocator(LO_EDT_YES_RENTAL_AGREEMENT, FW_ConfigMgr.getDefaultTimeout());
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
        waitForDuration(20);
         WebElement element = driver.findElement(By.xpath(LO_LST_COUNTRY));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", element);
        org.openqa.selenium.support.ui.WebDriverWait wait = new org.openqa.selenium.support.ui.WebDriverWait(driver, java.time.Duration.ofSeconds(FW_ConfigMgr.getDefaultTimeout()));
        wait.until(ExpectedConditions.elementToBeClickable(element));
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

     /**
     * Enters the province/State
     * @param provinceOrState the province/State to be entered in the field.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String enterProvinceOrState(String provinceOrState) {
        String result = setText(LO_EDT_PROVINCE_OR_STATE, provinceOrState,
                (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName());
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
     * @param incidentDate The text to enter in the incident date field.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String enterIncidentDateWhenDidTheIncidentOccur(String incidentDate){
        String result = setText(LO_EDT_INCIDENT_DATE_WHEN_DID_THE_INCIDENT_OCCUR, incidentDate, (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"), false);
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
        waitForDuration(10);
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
    public String scrollTopNew() {
        String result = scrollToLocator(LO_ABOUT_EVENT_PAGE_VERIFY_NEW);
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
        String result = clickLocator(LO_RAD_YES_THERE_WAS_DIAGNOSIS, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Selects "Yes" to question "Was there a diagnosis?"
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String selectYesThereWasADiagnosisWitoutSpace() {
        String result = clickLocator(LO_RAD_YES_THERE_WAS_DIAGNOSIS_WITHOUT_SPACE, FW_ConfigMgr.getDefaultTimeout());
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
        clickLocator(LO_EDT_SCHEDULED_TIME, FW_ConfigMgr.getDefaultTimeout());
        clickLocator(LO_EDT_SCHEDULED_TIME, FW_ConfigMgr.getDefaultTimeout());
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
        clickLocator(LO_EDT_ACTUAL_TIME_BAGGAGE_WAS_RECEIVED, FW_ConfigMgr.getDefaultTimeout());
        clickLocator(LO_EDT_ACTUAL_TIME_BAGGAGE_WAS_RECEIVED, FW_ConfigMgr.getDefaultTimeout());
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
     * Selects the country of occurance.
     * 
     * @param country The country of occurance.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String selectCountryOfOccurance(String country) {
        String result = setDropdownAppian(LO_LST_COUNTRY_OF_OCCURANCE, country, FW_ConfigMgr.getDefaultTimeout());
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
        clickLocator(LO_EDT_SCHEDULED_DEPARTURE_TIME, FW_ConfigMgr.getDefaultTimeout());
        clickLocator(LO_EDT_SCHEDULED_DEPARTURE_TIME, FW_ConfigMgr.getDefaultTimeout());
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
        clickLocator(LO_EDT_ACTUAL_DEPARTURE_TIME, FW_ConfigMgr.getDefaultTimeout());
        clickLocator(LO_EDT_ACTUAL_DEPARTURE_TIME, FW_ConfigMgr.getDefaultTimeout());
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
     * select No Was the Policyholder the driver at the time of incident?
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String clickNoToDriverPolicyholder() {
        String result = clickLocator(LO_RAD_NO_DRIVER_POLICYHOLDER, FW_ConfigMgr.getDefaultTimeout());
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
     * select Yes Did the incident involve another vehicle?
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String clickYesOtherVehicle() {
        String result = clickLocator(LO_RAD_YES_OTHER_VEHICLE, FW_ConfigMgr.getDefaultTimeout());
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
     * Enters Date last consulted.
     * @param dateLastConsulted The text to enter in the chronic illness field.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */

     public String enterDateLastConsultedTwo(String dateLastConsulted){
        String result = setText(LO_EDT_DATE_LAST_CONSULTED_TWO, dateLastConsulted, (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"), false);
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

    /**
     * Clicks the  "Back" button.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String clickBackButton() {
        String result = clickLocator(LO_BUT_BACK, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Click "Save As Draft" button.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String clickSaveAsDraftButton() {
        String result = clickLocator(LO_BUT_SAVE_DRAFT, FW_ConfigMgr.getDefaultTimeout());
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
    public String selectTravelDestinationCountry(String country) {
        waitForDuration(60, "s", false); // Wait to perform next check
        String result = setDropdownAppian(LO_LST_TRAVEL_DESTINATION_COUNTRY, country, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Verify that 60 minutes displays as the time set for completing the required infomation.
     * 
     * @param minutes the time.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String verifyTimer60minutes(String minutes) {
        
        String result = validateWithinLocatorText(LO_TXT_TIMER,minutes,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        if(result.contains("[Pass]")){
            return result;
        }
        else{
            minutes = "59 min(s) ";
            result = validateWithinLocatorText(LO_TXT_TIMER,minutes,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
            return result;
        }
    }

     /**
     * @param city The text to enter in the city field.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String enterTravelDestinationCity(String city) {
        String result = setText(LO_EDT_TRAVEL_DESTINATION_CITY, city, (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * @param fromDateOriginalTrip The from date to enter in the date field.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String enterFromDateOriginalTrip(String fromDateOriginalTrip) {
        String result = setText(LO_EDT_ORIGINAL_TRIP_DATE_FROM, fromDateOriginalTrip, (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * @param fromDateOriginalTrip The from date to enter in the date field.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String enterToDateOriginalTrip(String toDateOriginalTrip) {
        String result = setText(LO_EDT_ORIGINAL_TRIP_DATE_TO, toDateOriginalTrip, (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * @param tripPurchaseDate The from date to enter in the date field.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String enterTripPurchaseDate(String tripPurchaseDate) {
        String result = setText(LO_EDT_TRIP_PURCHASE_DATE, tripPurchaseDate, (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Selects "Yes" to question "Are you the person causing the claim?"
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String selectYesToPersonCausingClaim() {
        String result = clickLocator(LO_RAD_PERSON_CAUSING_CLAIM, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

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
     * Uploads the Accident Form.
     * 
     * @param filePath The relative path of the itinerary file from the user's home directory.
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String uploadAccidentForm(String filePath) {
        waitForDuration(10, "s", false); // Wait to perform next check
        String result = uploadFileV2(filePath, LO_UPLOAD_ACCIDENT_FORM);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Selects a country from dropdown menu : Where were you travelling from?.
     *
     * @param country The country to be selected.
     * 
     * @return A string containing the result of the operation.
     */
    public String selectCountryTravellingFrom(String country) {
        String result = setDropdownAppian(LO_LST_COUNTRY_TRAVELLING_FROM, country, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /** 
     * @param city from dropdown menu : Where were you travelling from?.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String selectCityTravellingFrom(String city){
        String result = setText(LO_EDT_CITY_TRAVELLING_FROM, city, (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Selects a country from dropdown menu : What was your travel destination?.
     *
     * @param country The country to be selected.
     * 
     * @return A string containing the result of the operation.
     */
    public String selectCountryTravelDestination(String country) {
        String result = setDropdownAppian(LO_LST_COUNTRY_TRAVELLING_DESTINATION, country, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /** 
     * @param city from dropdown menu : What was your travel destination?.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String selectCityTravelDestination(String city){
        String result = setText(LO_EDT_CITY_TRAVELLING_DESTINATION, city, (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Selects a country from dropdown menu : Where did the incident occur?.
     *
     * @param country The country to be selected.
     * 
     * @return A string containing the result of the operation.
     */
    public String selectCountryWhereIncidentOccured(String country) {
        String result = setDropdownAppian(LO_LST_COUNTRY_WHERE_INCIDENT_OCCURED, country, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /** 
     * @param city from dropdown menu : What was your travel destination?.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String selectCityWhereIncidentOccured(String city){
        String result = setText(LO_EDT_CITY_WHERE_INCIDENT_OCCURED, city, (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /** 
     * @param incidentDate The text to enter in the incident date field.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String enterIncidentDateH3(String incidentDate){
        String result = setText(LO_EDT_INCIDENT_DATE_OCCURANCE_H3, incidentDate, (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String enterProvince_State(String whenIncidentDateOccured){
        String result = setText(LO_EDT_PROVINCE_STATE, whenIncidentDateOccured, (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /** 
     * @param countryInjuryOccurred  The country to be selected.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String selectCountryInjuryOccured(String countryInjuryOccurred){
        String result = setDropdownAppian(LO_LST_COUNTRY_INJURY_OCCURED, countryInjuryOccurred, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /** 
     * @param city The text to enter in the city field.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String selectCityInjuryOccured(String city){
        String result = setText(LO_LST_CITY_INJURY_OCCURED, city, (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"), false);
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
    public String selectTravelDestinationCountryParagraph(String country) {
        String result = setDropdownAppian(LO_LST_TRAVEL_DESTINATION_COUNTRY_PARAGRAPH, country, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * @param city The text to enter in the city field.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String enterTravelDestinationCityParagraph(String city) {
        String result = setText(LO_LST_TRAVEL_DESTINATION_CITY_PARAGRAPH, city, (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Enters Medical Facility Phone Number that doesn't have :.
     * 
     * @param phoneNumber The phone number to be entered.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     * details.
     */

    public String enterMedicalFacilityPhone(String phoneNumber) {
        String result = setText(LO_EDT_MEDICAL_FACILITY_PHONE_NUMBER, phoneNumber, FW_ConfigMgr.getDefaultTimeout(), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Enters Beginning Date of Rental.
     * 
     * @param beginningDate The date to be entered.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String enterBeginningDateOfRental(String beginningDate) {
        String result = setText(LO_EDT_BEGINNING_DATE_OF_RENTAL, beginningDate, FW_ConfigMgr.getDefaultTimeout(), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Enters Ending Date of Rental.
     * 
     * @param endingDate The date to be entered.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String enterEndingDateOfRental(String endingDate) {
        String result = setText(LO_EDT_ENDING_DATE_OF_RENTAL, endingDate, FW_ConfigMgr.getDefaultTimeout(), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Enters the driver first name.
     *  
     * @param driverFirstName The first name to be entered.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String enterDriverFirstName(String driverFirstName) {
        String result = setText(LO_EDT_DRIVER_FIRST_NAME, driverFirstName, FW_ConfigMgr.getDefaultTimeout(), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Enters the driver last name.
     * 
     * @param driverLastName The last name to be entered.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String enterDriverLastName(String driverLastName) {
        String result = setText(LO_EDT_DRIVER_LAST_NAME, driverLastName, FW_ConfigMgr.getDefaultTimeout(), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Enters The Vehicle Owner First Name.
     * 
     * @param vehicleOwnerFirstName The first name to be entered.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String enterVehicleOwnerFirstName(String vehicleOwnerFirstName) {
        String result = setText(LO_EDT_VEHICLE_OWNER_FIRST_NAME, vehicleOwnerFirstName, FW_ConfigMgr.getDefaultTimeout(), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Enters The Vehicle Owner Last Name.
     * 
     * @param vehicleOwnerLastName The last name to be entered.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String enterVehicleOwnerLastName(String vehicleOwnerLastName) {
        String result = setText(LO_EDT_VEHICLE_OWNER_LAST_NAME, vehicleOwnerLastName, FW_ConfigMgr.getDefaultTimeout(), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Enters The Report Policy Number.
     * 
     * @param reportPolicyNumber The policy number to be entered.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String enterReportPoliceNumber(String reportPolicyNumber) {
        String result = setText(LO_EDT_REPORT_POLICE_NUMBER, reportPolicyNumber, FW_ConfigMgr.getDefaultTimeout(), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

     public String validateOnPageh3() {
        String result = validateLocatorExists(LO_ABOUT_EVENT_PAGE_VERIFY3, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

     public String validateOriginalTripDatesHeading() {
        String result = validateLocatorExists(LO_ABOUT_EVENT_PAGE_VERIFY_ORIGINAL_TRIP_DATES_HEADING, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

     public String scrollTopUp() {
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
        //String result = scrollToLocator(LO_TXT_WHICH_INSURANCE_TYPE);
        //result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        //return result;
        return "[Pass] scrolled to top of the page.";
    }

     /**
     * Apply a wait.
     */
    public String applyWait() {
        waitForDuration(2, "s", true);
        String result = "[Pass] - Wait applied.";
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

     public String validateOnPageParagraph() {
        String result = validateLocatorExists(LO_ABOUT_EVENT_PAGE_VERIFY_PARAGRAPH, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String validateOnPageNotification() {
        String result = validateLocatorExists(LO_ABOUT_EVENT_PAGE_VERIFY_NOTIFICATION, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

     public String validateClaimDetailsHeading() {
        String result = validateLocatorExists(LO_ABOUT_EVENT_PAGE_VERIFY_CLAIM_DETAILS, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

     public String validateTravelInfoHeading() {
        String result = validateLocatorExists(LO_ABOUT_EVENT_PAGE_VERIFY_TRAVEL_INFO_HEADING, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String validateChronicMedicalConditionHeading() {
        String result = validateLocatorExists(LO_ABOUT_EVENT_PAGE_VERIFY_MEDICAL_INFO_HEADING, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;      
    }

    public String validateAddNewMedicationLink() {
        String result = validateLocatorExists(LO_ABOUT_EVENT_PAGE_ADD_MEDICATION_VERIFY, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String validateAddAnotherIllnessOrDiseaseLink() {
        String result = validateLocatorExists(LO_ABOUT_EVENT_PAGE_ADD_ANOTHER_ILLNESS_OR_DISEASE_VERIFY, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String clickDateTimeHeadig() {
        String result = clickLocator(LO_TXT_DATE_TIME_HEADING, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String scrollUp() {
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
        return "[Pass] scrolled up.";
    }


}
