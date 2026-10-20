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
 * Page Object (PO) class used in the Page Object (PO) design pattern. Inherits from the CU_Appian class.
 */
// [Note: Automation Engineer, rename this Page Object (PO) class to match the filename.]
public class PO_Help_Centre extends PO_Required_Documents {

    // [Note: Automation Engineer, define the Page Object (PO) locators (LO) here.]
    
   
    private static final String LO_TXT_HELP_CENTER_PAGE_VERIFY = "//h1[contains(text(), 'Help Centre')]";
    private static final String LO_LST_CLAIM_TYPE2 = "//div[span= 'Claim Type ']/following-sibling::div//div[@role='combobox' and span[text()='Claim Type ']]";
    private static final String LO_LST_DOCUMENT_TYPE2 = "//div[span= 'Document Type']/following-sibling::div//div[@role='combobox' and span[text()='Document Type']]";
    private static final String LO_LST_SELECT_TOPIC = "//div[span= 'To help us better understand your situation, please select the topic that best applies to your request.']/following-sibling::div//div[@role='combobox' and span[text()='Select topic']]";
    private static final String LO_TXT_MAILING_ADDRESS_INFO_HEADING = "//h2[contains(text(), 'Mailing Address Information')]";
    private static final String LO_TXT_GEMINC_HEADING = "(//strong[contains(text(), 'Global Excel Management Inc.')])[1]";
    private static final String LO_TXT_CAD_HEADING = "//h3[text()='Canada']";
    private static final String LO_TXT_USA_HEADING = "//h3[text()='United States of America']";
    private static final String LO_TXT_ADDRESS_INFO = "//p[text()='73 Queen Street']";
    private static final String LO_TXT_ADDRESS_INFO_USA = "//p[text()='P.O. Box 10']";
    private static final String LO_TXT_TRAVEL_AND_ASSISTANCE_VERIFY = "//strong[contains(text(), 'Travel and Assistance')]";
    private static final String LO_IMG_TOP_LOGO_LIGHT_ZURICH = "//a//img[@src='https://geihpvqvwebgencacn1.blob.core.windows.net/appian-portal/logo_header_en_Zurich.png']";
    private static final String LO_BUT_CONTACT_US = "//span[contains(text(), 'CONTACT US')]";
    private static final String LO_BUT_CHECK_CLAIM_STATUS = "//span[contains(text(), 'Check Claim Status')]";
    private static final String LO_BUT_SUBMIT_DOCUMENTS = "//span[contains(text(), 'Submit Documents')]";
    private static final String LO_BUT_CONTACT_US_EMERGENCY_TRAVEL_ASSISTANCE = "//span/strong[text()='Emergency Travel Assistance']";
    private static final String LO_BUT_CONTACT_US_CLAIM_STATUS = "//span/strong[text()='Claim Status']";
    private static final String LO_BUT_CONTACT_US_SUBMIT_BILLS_OR_MISSING_DOCUMENTS = "//span/strong[text()='Submit Bills or Documents']";
    private static final String LO_BUT_CONTACT_US_CUSTOMER_RELATIONS = "//span/strong[text()='Customer Relations']";
    private static final String LO_BUT_CONTACT_US_GENERAL_QUESTIONS = "//span/strong[text()='General Questions']";
    private static final String LO_LNK_CONTACT_US_GENERAL_QUESTIONS_HERE = "//a[text()='here']";
    private static final String LO_TXT_HOW_CAN_WE_ASSIST_YOU = "//h2[text()='HOW CAN WE ASSIST YOU ?']";
    private static final String LO_TXT_HOW_CAN_WE_ASSIST_YOU_PARAGRAPH = "//p[text()='To get started, please select an option below']";
    private static final String LO_TXT_CONTACT_US_EMERGENCY_TRAVEL_ASSISTANCE_PARAGRAPH = "//p/span[text()='Submit a request for Travel Assistance (excludes immediate assistance).']";
    private static final String LO_TXT_CONTACT_US_CLAIM_STATUS_PARAGRAPH = "//p/span[text()=\"Request the status of a claim you've already submitted.\"]";
    private static final String LO_TXT_CONTACT_US_SUBMIT_BILLS_OR_MISSING_DOCUMENTS_PARAGRAPH = "//p/span[text()=\"Submit outstanding bills or missing document(s) required to process your claim.\"]";
    private static final String LO_TXT_CONTACT_US_GENERAL_QUESTIONS_PARAGRAPH = "//p/span[text()=\"We're here to assist you with any questions you may have. If you have general inquiries or need assistance, please feel free to share them with us here.\"]";
    private static final String LO_TXT_CONTACT_US_CUSTOMER_RELATIONS_PARAGRAPH = "//p/span[text()=\"Your feedback is crucial to us. If you have any complaints, concerns requiring attention, or feel that a decision regarding your claim warrants further review, please use this form.\"]";
    private static final String LO_TXT_CONTACT_US_CUSTOMER_RELATIONS_PARAGRAPH_MANULIFE = "//p/span[text()=\"Your feedback is crucial to us. If you have any complaints or concerns that need our attention, please share them with us here.\"]";
    private static final String LO_TXT_CONTACT_US_EMERGENCY_TRAVEL_ASSISTANCE_PARAGRAPH2 = "//p[text()='Submit a request for Travel Assistance (excludes immediate assistance).']";
    private static final String LO_TXT_CONTACT_US_CLAIM_STATUS_PARAGRAPH2 = "//p[text()=\"Request the status of a claim you've already submitted.\"]";
    private static final String LO_TXT_CONTACT_US_SUBMIT_BILLS_OR_MISSING_DOCUMENTS_PARAGRAPH2 = "//p[text()=\"Submit outstanding bills or missing document(s) required to process your claim.\"]";
    private static final String LO_TXT_CONTACT_US_CUSTOMER_RELATIONS_PARAGRAPH2 = "//p[text()=\"Your feedback is crucial to us. If you have any complaints, concerns requiring attention, or feel that a decision regarding your claim warrants further review, please use this form.\"]";
    private static final String LO_RAD_NO_DECISION_LETTER_RECEIVED = "//div[span[contains(text(), 'Is this related to a claim decision letter you received?')]]/following-sibling::div//label[contains(text(), 'No')]";
    private static final String LO_RAD_YES_DECISION_LETTER_RECEIVED = "//div[span[contains(text(), 'Is this related to a claim decision letter you received?')]]/following-sibling::div//label[contains(text(), 'Yes')]";
    private static final String LO_TXT_CONTACT_US_GENERAL_QUESTIONS_PARAGRAPH2 = "//p[text()=\"We're here to assist you with any questions you may have. If you have general inquiries or need assistance, please feel free to share them with us here. Additionally, if you have any concerns about a recent claim decision and wish to provide feedback, please click\" and a[text()=\"here\"] and text()=\"to access our feedback form.\"]";
    private static final String LO_TXT_CONTACT_US_CLAIM_STATUS_INFO_BOX = "//p[contains(text(), 'This form should be used to request the status of a claim that has already been submitted. You can also track the status of your claim on our ') and text()='page using your claim number and email address.']";
    private static final String LO_TXT_CUSTOMER_RELATIONS_CARD = "//h3/span[contains(text(), 'Customer Relations')]";
    private static final String LO_TXT_CUSTOMER_RELATIONS_VERIFY = "//h2/span[contains(text(), 'Customer Relations')]";
    private static final String LO_TXT_CUSTOMER_RELATIONS_CAP_LETTERS_VERIFY = "//h2[text()='CUSTOMER RELATIONS']";
    private static final String LO_EDT_POLICY_NUMBER = "//div[label='Policy Number']/following-sibling::div//input";
    private static final String LO_EDT_CLAIM_NUMBER = "//div[label='Global Excel Claim Number']/following-sibling::div//input";
    private static final String LO_EDT_FIRST_NAME = "//div[label='First Name']/following-sibling::div//div//input";
    private static final String LO_EDT_LAST_NAME = "//div[label='Last Name']/following-sibling::div//div//input";
    private static final String LO_EDT_DATE_OF_BIRTH = "//div[label='Date of Birth']/following-sibling::div//div//input";
    private static final String LO_EDT_EMAIL = "//div[label='Email']/following-sibling::div//div//input";
    private static final String LO_EDT_PHONE_NUMBER = "//div[label='Phone Number']/following-sibling::div//div//input";
    private static final String LO_EDT_ALTERNATE_PHONE_NUMBER = "//div[label='Alternate Phone Number']/following-sibling::div//div//input";
    private static final String LO_EDT_TEXT_TEXTAREA= "//div[label='What is your request/How can we assist you? (Maximum of 2000 characters allowed)']/following-sibling::div//textarea";
    private static final String LO_BUT_VIEW_CHECK_CLAIM_STATUS = "//button//span[contains(text(), 'Check Claim Status')]";
    private static final String LO_BUT_VIEW_SUBMIT_DOCUMENTS = "//div[h2[span[contains(text(), 'Submit Documents')]]]/following-sibling::div//span[contains(text(), 'VIEW')]";
    private static final String LO_TXT_SUBMIT_BILLS_OR_DOCUMENTS_SECTION = "//h2/span[contains(text(), 'Submit Bills or Documents')]";
    private static final String LO_TXT_CUSTOMER_RELATIONS_FORM_SECTION = "//h2/span[contains(text(), 'Customer Relations')]";
    private static final String LO_BUT_SUBMIT = "//button//span[text()='Submit']";
    private static final String LO_TXT_UPLOAD_DOCUMENTS_INFO_BOX = "//p[text()=\"Please ensure the uploaded documents are not password-protected or encrypted. If they are, please remove the password protection or encryption before uploading them to ensure a smoother claims process.\"]";
    private static final String LO_TXT_DOCUMENT_TYPE_HEADING = "//h2[text()='DOCUMENT TYPE']";
    private static final String LO_TXT_DOCUMENT_TYPE_SUB_HEADING = "//div[span[text()='Document Type *']]";
    private static final String LO_TXT_UPLOAD_DOCUMENT_SUB_HEADING = "//div[span[text()='Document Upload *']]";
    private static final String LO_TXT_ACCEPTED_FILE_TYPES_AND_SIZE = "//div[p[text()='Accepted File Types :' and strong[text()='Pdf, Tiff, Png, Jpeg, Jpg, Gif, Bmp, Doc, Docx, Rtf, Txt, Odt.'] and text()='Accepted File Size :' and strong[text()='Less than'] and span/strong[text()='7MB']]]";
    private static final String LO_TXT_ACCEPTED_FILE_TYPES_AND_SIZE2 = "//div[div[div[p[text()=\"Accepted File Types :\" and text()=\" : \" and strong[text()=\"Pdf, Tiff, Png, Jpeg, Jpg, Gif, Bmp, Doc, Docx, Rtf, Txt, Odt.\"]]]]]/following-sibling::div//div/following-sibling::div//p[text()=\"Accepted File Size :\" and text()=\" : \" and strong[text()=\"Less than\"] and span/strong[text()=\"7MB\"]]";
    private static final String LO_LNK_CLICK_HERE = "//div[div[div[div/p[text()='Are you starting a new claim?']]]]/following-sibling::div//p/strong[text()='CLICK HERE']";
    private static final String LO_LST_WHAT_YOU_NEED_TO_SUBMIT = "//div[span='I need to submit:']/following-sibling::div//div[span='--Select--']";
    private static final String LO_LST_CLAIM_TYPE = "//div[span='Claim Type ']/following-sibling::div//div[span='Claim Type ']";
    private static final String LO_LST_DOCUMENT_TYPE = "//div[span='Document Type']/following-sibling::div//div[span='Document Type']";
    private static final String LO_DOC_DOCUMENT_TYPE1 = "//h3[a[span[contains(text(), 'Document Type 1')]]]/following-sibling::div//input";
    private static final String LO_DOC_DOCUMENT_TYPE2 = "(//div[div[div[p='Accepted file types are pdf, tiff, png, jpeg, jpg, gif, bmp, doc, docx, rtf, txt, odt.']]])[2]/following-sibling::div//input";
    private static final String LO_BUT_ADD_ANOTHER_DOCUMENT = "//a[contains(text(), '+ Add another Document')]";
    private static final String LO_TXT_CLAIM_STATUS_CARD = "//h3/span[contains(text(), 'Claim Status')]";
    private static final String LO_TXT_CLAIM_STATUS_SECTION = "//h2/span[contains(text(), 'Claim Status')]";
    private static final String LO_LNK_VIEW_YOUR_CLAIM_STATUS= "//a[contains(text(), 'View your Claim Status')]";
    private static final String LO_TXT_SUBMIT_BILLS_OR_DOCUMENTS_CARD= "//h3/span[contains(text(), 'Submit Bills or Documents')]";
    private static final String LO_TXT_VALID_EMARGENCY_ASSISTANCE = "//h2/span[contains(text(), 'Emergency Assistance')]";
    private static final String LO_TXT_VALID_EMERGENCY_ASSISTANCE_NUMBER = "//span[strong='+1 819-566-3970']";
    private static final String LO_BUT_GENERAL_QUESTION= "//h3/span[contains(text(), 'General Questions')]";
    private static final String LO_TXT_GENERAL_QUESTIONS_VERIFY = "//h2/span[contains(text(), 'General Questions')]";
    private static final String LO_TXT_VALID_MGB_EMERGENCY_ASSISTANCE_NUMBER = "//span[strong='+1 819-566-8335']";
    private static final String LO_TXT_FQA = "//span[contains(text(),'How will I know when my claim is settled?')]";
    private static final String LO_TXT_FIRST_QUESTION_RESPONSE = "//p[contains(text(),'You can follow the status of your claim by using the Claim Status section.')]";
    private static final String LO_BUT_VIEW_ALL_FAQs = "//button//span[contains(text(), 'View all FAQs')]";
    private static final String LO_BUT_BACK = "//span[text()='Back']";
    private static final String LO_BUT_CONTINUE = "//div[button//span[text()='Continue']]";
    private static final String LO_BUT_CONTINUE_CONTACT_US = "//button//span[text()='Submit']";
    private static final String LO_TXT_TRAVEL_AND_ASSISTANCE = "//span[contains(text(),'Travel and Assistance')]";
    private static final String LO_TXT_CLAIMING = "//span[contains(text(),'Claiming')]";
    private static final String LO_SLCT_EMERGENCY_TRAVEL_ASSISTANCE = "//h3/span[contains(text(), 'Emergency Travel Assistance')]";
    private static final String LO_TXT_EMERGENCY_TRAVEL_ASSISTANCE = "//h3/span[contains(text(), 'Emergency Travel Assistance')]";
    private static final String LO_TXT_VALID_CONSUMER_NUMBER = "//span/strong[contains(text(), 'Consumer or Small Business Cards')]";
    private static final String LO_TXT_VALID_COMERCIAL_NUMBER = "//span/strong[contains(text(), 'Commercial or Scotia Visa Business Cards')]";
    private static final String LO_IMG_MANULIFE_LOGO_TOP = "//img[@alt='Manulife Claim Center Page']";
    private static final String LO_RAD_RELATED_TO_CLAIM_DECISION_LETTER_NO = "//label[text()='No']";
    //private static final String LO_LST_SELECT_TOPIC = "//div[@role='combobox']";
    private static final String LO_DOC_UPLOAD = "//div[@class='MultipleFileUploadWidget---uploads_wrapper MultipleFileUploadWidget---drag_drop_zone_wrapper']/input";
    private static final String LO_IMG_GEM_TOP_LOGO = "//a//img[@src='https://geihpvqvwebgencacn1.blob.core.windows.net/appian-portal/logo_header_en_GEM.png' or @src='https://geihpvtvwebgencacn1.blob.core.windows.net/appian-portal/logo_header_en_GEM.png']";
    private static final String LO_LNK_HELP_CENTRE_TOP = "//h1[contains(text(), 'Help Centre')]";
    private static final String LO_BUT_FRANÇAIS = "//p//span/a[text()='FRANÇAIS']";
    private static final String LO_TXT_MAILING_ADDRESS_HEADING = "//h2[text()='Mailing Address Information']";
    private static final String LO_TXT_GEM_INC_LEFT_CAD = "(//h3[text()='Global Excel Management Inc.'])[1]";
    private static final String LO_TXT_MAILING_ADDRESS_73_QUEEN_STREET = "(//p[text()='Global Excel Management Inc.'])[1]";
    private static final String LO_TXT_MAILING_ADDRESS_PO_BOX_10 = "(//p[text()='Global Excel Management Inc.'])[2]";
    private static final String LO_TXT_GEM_NO_INC_LEFT_CAD = "(//div[h3[text()='Global Excel Management']])[1]";
    private static final String LO_TXT_GEM_NO_INC_RIGHT_USA = "(//div[h3[text()='Global Excel Management']])[2]";
    private static final String LO_TXT_GEM_INC_RIGHT_USD = "(//h3[text()='Global Excel Management Inc.'])[2]";
    private static final String LO_TXT_EMERGENCY_ASSISTANCE_HEADING = "//h2[text()='Emergency Assistance']";
    private static final String LO_TXT_SEND_US_A_MESSAGE_HEADING = "//h2[text()='Send us a message']";
    private static final String LO_TXT_CHECK_CLAIM_STATUS_HEADING = "//h2[text()='Check Claim Status']";
    private static final String LO_TXT_SUBMIT_DOCUMENTS_HEADING = "//h2[text()='Submit Documents']";
    private static final String LO_TXT_EMERGENCY_TRAVEL_ASSISTANCE_HEADING = "//h2[text()='EMERGENCY TRAVEL ASSISTANCE']";
    private static final String LO_TXT_CLAIM_STATUS_HEADING = "//h2[text()='CLAIM STATUS']";
    private static final String LO_TXT_SUBMIT_BILLS_OR_MISSING_DOCUMENTS_HEADING = "//h2[text()='SUBMIT BILLS OR DOCUMENTS']";
    private static final String LO_TXT_GENERAL_QUESTIONS_HEADING = "//h2[text()='GENERAL QUESTIONS']";
    private static final String LO_TXT_CUSTOMER_RELATIONS_HEADING = "//h2[text()='CUSTOMER RELATIONS']";
    private static final String LO_TXT_CUSTOMER_RELATIONS_CUSTOMER_COMPLAINT_RESOLUTION_PROCESS_HEADING = "//h2[text()='CUSTOMER COMPLAINT RESOLUTION PROCESS']";
    private static final String LO_TXT_CUSTOMER_RELATIONS_CUSTOMER_COMPLAINT_RESOLUTION_PROCESS_HEADING_PARAGRAPH = "//p[text()='This is how the Customer Relations department will handle your complaint.']";
    private static final String LO_TXT_CUSTOMER_RELATIONS_CUSTOMER_COMPLAINT_RESOLUTION_PROCESS1 = "//div[strong[text()=\"Acknowledgement\" and text()=\" : \"] and text()=\"Once we receive your formal written request for your written complaint, we will acknowledge receipt and let you know when you can reasonably expect a response.\"]";
    private static final String LO_TXT_CUSTOMER_RELATIONS_CUSTOMER_COMPLAINT_RESOLUTION_PROCESS2 = "//div[strong[text()=\"File review and investigation\" and text()=\" : \"] and text()=\"Customer relations staff will conduct a careful review of your file, investigate service complaints thoroughly and impartially, and consult with the parties involved with and/or responsible for your concerns. Once completed, a recommendation is made and a decision rendered.\"]";
    private static final String LO_TXT_CUSTOMER_RELATIONS_CUSTOMER_COMPLAINT_RESOLUTION_PROCESS3 = "//div[strong[text()=\"Resolution\" and text()=\" : \"] and text()=\"Customer relations will communicate with you once a decision has been made.\"]";
    private static final String LO_TXT_CUSTOMER_RELATIONS_SUB_HEADING = "//span/strong[text()='Complaints and Appeals']";
    private static final String LO_TXT_EMERGENCY_ASSISTANCE_PARAGRAPH = "//p/span[text()='If you need immediate assistance, call us at :']";
    private static final String LO_TXT_SEND_US_A_MESSAGE_PARAGRAPH = "//p/span[text()='You have a question? Visit the Contact Us section to send us a message.']";
    private static final String LO_TXT_CHECK_CLAIM_STATUS_PARAGRAPH = "//p/span[text()='Checking the status of your ongoing claim?']";
    private static final String LO_TXT_SUBMIT_DOCUMENTS_PARAGRAPH = "//p/span[text()='Want to submit additional documents for an existing claim?']";
    private static final String LO_TXT_MAILING_ADDRESS_HEADING_SUB_LEFT = "(//p/strong[contains(text(), 'Global Excel Management')])[1]";
    private static final String LO_TXT_MAILING_ADDRESS_HEADING_SUB_LEFT_MANULIFE = "(//h3[contains(text(), 'Manulife')])[1]";
    private static final String LO_TXT_MAILING_ADDRESS_POBOX_1237 = "//p[contains(text(), 'P.O. Box 1237')]";
    private static final String LO_TXT_MAILING_ADDRESS_535_GRISWOLD_ST = "//p[contains(text(), '535 Griswold St')]";
    private static final String LO_TXT_MAILING_ADDRESS_LEFT = "(//div[p[contains(text(), 'C/O Global Excel Management')]])[1]";
    private static final String LO_TXT_MAILING_ADDRESS_HEADING_SUB_RIGHT = "(//div[p[contains(text(), 'C/O Global Excel Management')]])[2]";
    private static final String LO_TXT_MAILING_ADDRESS_HEADING_SUB_RIGHT_MANULIFE = "(//h3[contains(text(), 'Manulife')])[2]";
    private static final String LO_TXT_MAILING_ADDRESS_RIGHT = "(//div[p[contains(text(), 'C/O Global Excel Management')]])[2]";
    private static final String LO_IMG_GEM_TOP_LOGO_BCAA = "//a//img[@src='https://geihpvqvwebgencacn1.blob.core.windows.net/appian-portal/logo_header_en_BCAA.png' or @src='https://geihpvtvwebgencacn1.blob.core.windows.net/appian-portal/logo_header_en_BCAA.png']";
    private static final String LO_IMG_GEM_TOP_LOGO_CIBC = "//a//img[@src='https://geihpvqvwebgencacn1.blob.core.windows.net/appian-portal/logo_header_en_CIBC.png' or @src='https://geihpvtvwebgencacn1.blob.core.windows.net/appian-portal/logo_header_en_CIBC.png']";
    private static final String LO_LNK_HELP_CENTRE_TOP_DARK = "//p[span[a[(span/span[@class='IconWidget---inDarkBackground'][not(following-sibling::span)]) or (span[@class='IconWidget---inDarkBackground'] and text()='HELP CENTRE')]]]";
    private static final String LO_IMG_GEM_TOP_LOGO_INTACT = "//a//img[@src='https://geihpvqvwebgencacn1.blob.core.windows.net/appian-portal/logo_header_en_Intact.png' or @src='https://geihpvtvwebgencacn1.blob.core.windows.net/appian-portal/logo_header_en_Intact.png']";
    private static final String LO_BUT_FRANÇAIS_DARK = "//p[span[a[(span[span[@class='IconWidget---inDarkBackground'] and span[contains(text(), 'FR')]]) or (span[@class='IconWidget---inDarkBackground'] and span[contains(text(), 'FRANÇAIS')])]]]";
    private static final String LO_IMG_GEM_TOP_LOGO_MANULIFE = "//a//img[@src='https://geihpvqvwebgencacn1.blob.core.windows.net/appian-portal/logo_header_en_Manulife.png'or @src='https://geihpvtvwebgencacn1.blob.core.windows.net/appian-portal/logo_header_en_Manulife.png']";
    private static final String LO_IMG_GEM_TOP_LOGO_MGB = "//a//img[@src='https://geihpvqvwebgencacn1.blob.core.windows.net/appian-portal/logo_header_en_ManulifeGroupBenefits.png' or @src='https://geihpvtvwebgencacn1.blob.core.windows.net/appian-portal/logo_header_en_ManulifeGroupBenefits.png']";
    private static final String LO_IMG_GEM_TOP_LOGO_ORION = "//a//img[@src='https://geihpvqvwebgencacn1.blob.core.windows.net/appian-portal/logo_header_en_Orion.png' or @src='https://geihpvtvwebgencacn1.blob.core.windows.net/appian-portal/logo_header_en_Orion.png']";
    private static final String LO_IMG_GEM_TOP_LOGO_SCOTIA = "//a//img[@src='https://geihpvqvwebgencacn1.blob.core.windows.net/appian-portal/logo_header_en_Scotiabank.png' or @src='https://geihpvtvwebgencacn1.blob.core.windows.net/appian-portal/logo_header_en_Scotiabank.png']";
    private static final String LO_IMG_GEM_TOP_LOGO_SUNLIFE = "//a//img[@src='https://geihpvqvwebgencacn1.blob.core.windows.net/appian-portal/logo_header_en_SunLife.png' or @src='https://geihpvtvwebgencacn1.blob.core.windows.net/appian-portal/logo_header_en_SunLife.png']";

    //----------------------------------------------------------- FR2 ------------------------------------------------
    private static final String LO_LNK_HELP_CENTRE_TOP_FR = "";
    private static final String LO_TXT_CUSTOMER_RELATIONS_CARD_FR = "";
    private static final String LO_TXT_HELP_CENTER_PAGE_VERIFY_FR = "";
    private static final String LO_TXT_MAILING_ADDRESS_PO_BOX_10_FR = "";
    private static final String LO_TXT_USA_HEADING_FR = "";
    private static final String LO_TXT_MAILING_ADDRESS_73_QUEEN_STREET_FR = "";
    private static final String LO_TXT_CAD_HEADING_FR = "";
    private static final String LO_BUT_FRANÇAIS_EN = "";
    private static final String LO_TXT_VALID_COMERCIAL_NUMBER_FR = "";
    private static final String LO_BUT_VIEW_CHECK_CLAIM_STATUS_FR = "";
    private static final String LO_TXT_MAILING_ADDRESS_HEADING_FR = "";
    private static final String LO_TXT_GEM_INC_LEFT_CAD_FR = "";
    private static final String LO_TXT_ADDRESS_INFO_FR = "";
    private static final String LO_TXT_GEM_INC_RIGHT_USD_FR = "";
    private static final String LO_TXT_ADDRESS_INFO_USA_FR = "";
    private static final String LO_TXT_EMERGENCY_ASSISTANCE_HEADING_FR = "";
    private static final String LO_TXT_EMERGENCY_ASSISTANCE_PARAGRAPH_FR = "";
    private static final String LO_TXT_SEND_US_A_MESSAGE_HEADING_FR = "";
    private static final String LO_TXT_SEND_US_A_MESSAGE_PARAGRAPH_FR = "";
    private static final String LO_BUT_CONTACT_US_FR = "";
    private static final String LO_TXT_HOW_CAN_WE_ASSIST_YOU_FR = "";
    private static final String LO_TXT_HOW_CAN_WE_ASSIST_YOU_PARAGRAPH_FR = "";
    private static final String LO_TXT_CONTACT_US_EMERGENCY_TRAVEL_ASSISTANCE_PARAGRAPH_FR = "";
    private static final String LO_BUT_CONTACT_US_EMERGENCY_TRAVEL_ASSISTANCE_FR = "";
    private static final String LO_TXT_EMERGENCY_TRAVEL_ASSISTANCE_HEADING_FR = "";
    private static final String LO_TXT_CONTACT_US_EMERGENCY_TRAVEL_ASSISTANCE_PARAGRAPH2_FR = "";
    private static final String LO_EDT_POLICY_NUMBER_FR = "";
    private static final String LO_EDT_CLAIM_NUMBER_FR = "";
    private static final String LO_EDT_FIRST_NAME_FR = "";
    private static final String LO_EDT_LAST_NAME_FR = "";
    private static final String LO_EDT_DATE_OF_BIRTH_FR = "";
    private static final String LO_EDT_EMAIL_FR = "";
    private static final String LO_EDT_PHONE_NUMBER_FR = "";
    private static final String LO_EDT_ALTERNATE_PHONE_NUMBER_FR = "";
    private static final String LO_EDT_TEXT_TEXTAREA_FR = "";
    private static final String LO_BUT_SUBMIT_FR = "";
    private static final String LO_BUT_BACK_FR = "";
    private static final String LO_BUT_CONTINUE_CONTACT_US_FR = "";
    private static final String LO_TXT_CONTACT_US_CLAIM_STATUS_PARAGRAPH_FR = "";
    private static final String LO_BUT_CONTACT_US_CLAIM_STATUS_FR = "";
    private static final String LO_TXT_CLAIM_STATUS_HEADING_FR = "";
    private static final String LO_TXT_CONTACT_US_CLAIM_STATUS_PARAGRAPH2_FR = "";
    private static final String LO_TXT_CONTACT_US_CLAIM_STATUS_INFO_BOX_FR = "";
     private static final String LO_TXT_CONTACT_US_SUBMIT_BILLS_OR_MISSING_DOCUMENTS_PARAGRAPH_FR = "";
     private static final String LO_BUT_CONTACT_US_SUBMIT_BILLS_OR_MISSING_DOCUMENTS_FR = "";
     private static final String LO_TXT_SUBMIT_BILLS_OR_MISSING_DOCUMENTS_HEADING_FR = "";
     private static final String LO_TXT_CONTACT_US_SUBMIT_BILLS_OR_MISSING_DOCUMENTS_PARAGRAPH2_FR = "";
     private static final String LO_LST_CLAIM_TYPE2_FR = "";
     private static final String LO_LST_DOCUMENT_TYPE2_FR = "";
     private static final String LO_TXT_DOCUMENT_TYPE_HEADING_FR = "";
     private static final String LO_TXT_DOCUMENT_TYPE_SUB_HEADING_FR = "";
     private static final String LO_TXT_UPLOAD_DOCUMENT_SUB_HEADING_FR = "";
     private static final String LO_TXT_ACCEPTED_FILE_TYPES_AND_SIZE_FR = "";
     private static final String LO_TXT_CONTACT_US_GENERAL_QUESTIONS_PARAGRAPH_FR = "";
     private static final String LO_BUT_CONTACT_US_GENERAL_QUESTIONS_FR = "";
     private static final String LO_TXT_GENERAL_QUESTIONS_HEADING_FR = "";
     private static final String LO_TXT_CONTACT_US_GENERAL_QUESTIONS_PARAGRAPH2_FR = "";
     private static final String LO_TXT_CONTACT_US_CUSTOMER_RELATIONS_PARAGRAPH_FR = "";
      private static final String LO_BUT_CONTACT_US_CUSTOMER_RELATIONS_FR = "";
      private static final String LO_TXT_CUSTOMER_RELATIONS_HEADING_FR = "";
      private static final String LO_TXT_CUSTOMER_RELATIONS_SUB_HEADING_FR = "";
      private static final String LO_TXT_CONTACT_US_CUSTOMER_RELATIONS_PARAGRAPH2_FR = "";
      private static final String LO_RAD_NO_DECISION_LETTER_RECEIVED_FR = "";
      private static final String LO_LST_SELECT_TOPIC_FR = "";
      private static final String LO_RAD_YES_DECISION_LETTER_RECEIVED_FR = "";
      private static final String LO_TXT_CUSTOMER_RELATIONS_CUSTOMER_COMPLAINT_RESOLUTION_PROCESS_HEADING_FR = "";
      private static final String LO_TXT_CUSTOMER_RELATIONS_CUSTOMER_COMPLAINT_RESOLUTION_PROCESS_HEADING_PARAGRAPH_FR = "";
      private static final String LO_TXT_CUSTOMER_RELATIONS_CUSTOMER_COMPLAINT_RESOLUTION_PROCESS1_FR = "";
      private static final String LO_TXT_CUSTOMER_RELATIONS_CUSTOMER_COMPLAINT_RESOLUTION_PROCESS2_FR = "";
      private static final String LO_TXT_CUSTOMER_RELATIONS_CUSTOMER_COMPLAINT_RESOLUTION_PROCESS3_FR = "";
      private static final String LO_TXT_UPLOAD_DOCUMENTS_INFO_BOX_FR = "";
      private static final String LO_TXT_ACCEPTED_FILE_TYPES_AND_SIZE2_FR = "";
      private static final String LO_DOC_DOCUMENT_TYPE1_FR = "";
      private static final String LO_BUT_VIEW_ALL_FAQs_FR = "";
      private static final String LO_TXT_SUBMIT_DOCUMENTS_HEADING_FR = "";
      private static final String LO_TXT_SUBMIT_DOCUMENTS_PARAGRAPH_FR = "";
      private static final String LO_BUT_SUBMIT_DOCUMENTS_FR = "";
      private static final String LO_LST_CLAIM_TYPE_FR = "";
      private static final String LO_TXT_CHECK_CLAIM_STATUS_HEADING_FR = "";
      private static final String LO_TXT_CHECK_CLAIM_STATUS_PARAGRAPH_FR = "";
      private static final String LO_BUT_CHECK_CLAIM_STATUS_FR = "";
      private static final String LO_LNK_CLICK_HERE_FR = "";
      private static final String LO_LNK_VIEW_YOUR_CLAIM_STATUS_FR = "";
      private static final String LO_LNK_CONTACT_US_GENERAL_QUESTIONS_HERE_FR = "";
      private static final String LO_TXT_CUSTOMER_RELATIONS_CAP_LETTERS_VERIFY_FR = "";
      private static final String LO_TXT_TRAVEL_AND_ASSISTANCE_VERIFY_FR = "";
      private static final String LO_TXT_GEM_NO_INC_LEFT_CAD_FR = "";
      private static final String LO_TXT_GEM_NO_INC_RIGHT_USA_FR = "";
      private static final String LO_TXT_MAILING_ADDRESS_535_GRISWOLD_ST_FR = "";
      private static final String LO_TXT_MAILING_ADDRESS_POBOX_1237_FR = "";
      private static final String LO_TXT_MAILING_ADDRESS_RIGHT_FR = "";
      private static final String LO_TXT_MAILING_ADDRESS_LEFT_FR = "";
      private static final String LO_TXT_MAILING_ADDRESS_HEADING_SUB_LEFT_MANULIFE_FR = "";
      private static final String LO_TXT_VALID_CONSUMER_NUMBER_FR = "";
    /**
     * Define the Page Object (PO) constructor.
     * @param driver The WebDriver object passed from the test method.
     */
    // [Note: Automation Engineer, rename this Page Object (PO) class to match the filename.]
    public PO_Help_Centre(WebDriver driver) {
        super(driver);
    }

    /**
     * Validates if current webpage is loaded and correct.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateOnPage(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_HELP_CENTER_PAGE_VERIFY_FR : LO_TXT_HELP_CENTER_PAGE_VERIFY;
        String result = validateLocatorExists(locator , FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object selectClaimType2(String language, String typeOfExpense) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_LST_CLAIM_TYPE2_FR : LO_LST_CLAIM_TYPE2;
        String result = setDropdownAppian(locator, typeOfExpense, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    public Object selectUploadType2(String language, String typeOfExpense) {
        waitForDuration(10, "s", false); // Wait to perform next check
        String locator = "fr".equalsIgnoreCase(language) ? LO_LST_DOCUMENT_TYPE2_FR : LO_LST_DOCUMENT_TYPE2;
        String result = setDropdownAppian(locator, typeOfExpense, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    public Object verifyContactUsCustomerRelationsSelectSelectTopic(String language, String topic) {
        waitForDuration(2, "s", false); // Wait to perform next check
        String locator = "fr".equalsIgnoreCase(language) ? LO_LST_SELECT_TOPIC_FR : LO_LST_SELECT_TOPIC;
        String result = setDropdownAppian(locator, topic, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }


    public Object validateMailingAddressInfoHeading() {
        String result = validateLocatorExists(LO_TXT_MAILING_ADDRESS_INFO_HEADING, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object validateGlobalExcelManagementIncTitleCAD() {
        String result = validateLocatorExists(LO_TXT_ADDRESS_INFO, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object validateUSAHeading() {
        String result = validateLocatorExists(LO_TXT_USA_HEADING, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object validateCADHeading() {
        String result = validateLocatorExists(LO_TXT_CAD_HEADING, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object validateGlobalExcelManagementIncTitleUSA(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_ADDRESS_INFO_USA_FR : LO_TXT_ADDRESS_INFO_USA;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object validateStreetCAD(String language, String street) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_ADDRESS_INFO_FR : LO_TXT_ADDRESS_INFO;
        String result = validateWithinLocatorText(locator,street,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object validatePOBOXUSA(String language, String street) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_ADDRESS_INFO_USA_FR : LO_TXT_ADDRESS_INFO_USA;
        String result = validateWithinLocatorText(locator,street,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object validateProvinceAndCityUSA(String language, String street) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_ADDRESS_INFO_USA_FR : LO_TXT_ADDRESS_INFO_USA;
        String result = validateWithinLocatorText(locator,street,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object validateProvinceAndCityOnProvinceUSA(String language, String street) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_ADDRESS_INFO_USA_FR : LO_TXT_ADDRESS_INFO_USA;
        String result = validateWithinLocatorText(locator,street,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object validateCountryUSA(String language, String street) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_ADDRESS_INFO_USA_FR : LO_TXT_ADDRESS_INFO_USA;
        String result = validateWithinLocatorText(locator,street,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object validatePostalCodeUSA(String language, String street) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_ADDRESS_INFO_USA_FR : LO_TXT_ADDRESS_INFO_USA;
        String result = validateWithinLocatorText(locator,street,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    public Object validateProvinceAndCityCAD(String language, String street) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_ADDRESS_INFO_FR : LO_TXT_ADDRESS_INFO;
        String result = validateWithinLocatorText(locator,street,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object validateCountryCAD(String language, String street) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_ADDRESS_INFO_FR : LO_TXT_ADDRESS_INFO;
        String result = validateWithinLocatorText(locator,street,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object validatePostalCodeCAD(String language, String street) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_ADDRESS_INFO_FR : LO_TXT_ADDRESS_INFO;
        String result = validateWithinLocatorText(locator,street,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object validateTravelAndAssistance(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_TRAVEL_AND_ASSISTANCE_VERIFY_FR : LO_TXT_TRAVEL_AND_ASSISTANCE_VERIFY;
        String result = validateLocatorExists(locator , FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object validateTop_Left_Logo_Light_Zurich() {
        String result = clickLocator(LO_IMG_TOP_LOGO_LIGHT_ZURICH, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if Gem top logo is present and it's a link.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object validateGem_Top_Left_Logo_ORION() {
        String result = validateLocatorExists(LO_IMG_GEM_TOP_LOGO_ORION, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if Gem top logo is present and it's a link.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object validateGem_Top_Left_Logo_MGB() {
        String result = validateLocatorExists(LO_IMG_GEM_TOP_LOGO_MGB, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if Gem top logo is present and it's a link.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object validateGem_Top_Left_Logo_Intact() {
        String result = validateLocatorExists(LO_IMG_GEM_TOP_LOGO_INTACT, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if the Help Centre at top right is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object validateHelpCentreHeader_Dark() {
        String result = validateLocatorExists(LO_LNK_HELP_CENTRE_TOP_DARK, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if Gem top logo is present and it's a link.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object validateGem_Top_Left_Logo_SCOTIA() {
        String result = validateLocatorExists(LO_IMG_GEM_TOP_LOGO_SCOTIA, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if Gem top logo is present and it's a link.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object validateGem_Top_Left_Logo_Manulife() {
        String result = validateLocatorExists(LO_IMG_GEM_TOP_LOGO_MANULIFE, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if the Help Centre link or icon is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object validateFrancaisButton_Dark() {
        String result = validateLocatorExists(LO_BUT_FRANÇAIS_DARK, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if Gem top logo is present and it's a link.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object validateGem_Top_Left_Logo_CIBC() {
        String result = validateLocatorExists(LO_IMG_GEM_TOP_LOGO_CIBC, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if Gem top logo is present and it's a link.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object validateGem_Top_Left_Logo_SunLife() {
        String result = validateLocatorExists(LO_IMG_GEM_TOP_LOGO_SUNLIFE, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if Gem top logo is present and it's a link.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object validateGem_Top_Left_Logo() {
        String result = validateLocatorExists(LO_IMG_GEM_TOP_LOGO, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    /**
     * Validates if the Help Centre at top right is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object validateHelpCentreHeader(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_LNK_HELP_CENTRE_TOP_FR : LO_LNK_HELP_CENTRE_TOP;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Clicks the 'CONTACT US' button.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object clickContactUsButton(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_BUT_CONTACT_US_FR : LO_BUT_CONTACT_US;
        String result = clickLocator(locator, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    public Object clickCheckClaimStatusButton(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_BUT_CHECK_CLAIM_STATUS_FR : LO_BUT_CHECK_CLAIM_STATUS;
        String result = clickLocator(locator, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    public Object clickSubmitDocumentsButton(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_BUT_SUBMIT_DOCUMENTS_FR : LO_BUT_SUBMIT_DOCUMENTS;
        String result = clickLocator(locator, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    public Object clickContactUsEmergencyTravelAssistance(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_BUT_CONTACT_US_EMERGENCY_TRAVEL_ASSISTANCE_FR : LO_BUT_CONTACT_US_EMERGENCY_TRAVEL_ASSISTANCE;
        String result = clickLocator(locator, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    public Object clickContactUsClaimStatus(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_BUT_CONTACT_US_CLAIM_STATUS_FR : LO_BUT_CONTACT_US_CLAIM_STATUS;
        String result = clickLocator(locator, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    public Object clickContactUsSubmitBillsOrMissingDocuments(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_BUT_CONTACT_US_SUBMIT_BILLS_OR_MISSING_DOCUMENTS_FR : LO_BUT_CONTACT_US_SUBMIT_BILLS_OR_MISSING_DOCUMENTS;
        String result = clickLocator(locator, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    public Object clickContactUsGeneralQuestions(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_BUT_CONTACT_US_GENERAL_QUESTIONS_FR : LO_BUT_CONTACT_US_GENERAL_QUESTIONS;
        String result = clickLocator(locator, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object clickHereLink(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_LNK_CONTACT_US_GENERAL_QUESTIONS_HERE_FR : LO_LNK_CONTACT_US_GENERAL_QUESTIONS_HERE;
        String result = clickLocator(locator, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    public Object clickContactUsCustomerRelations(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_BUT_CONTACT_US_CUSTOMER_RELATIONS_FR : LO_BUT_CONTACT_US_CUSTOMER_RELATIONS;
        String result = clickLocator(locator, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Clicks the 'Manulife' logo.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object clickOnManulifeLogoTopLeftCorner() {
        String result = clickLocator(LO_IMG_MANULIFE_LOGO_TOP, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Clicks the 'VIEW' button under Check Claim Status option.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object clickOnViewUnderCheckClaimStatusOption() {
        String result = clickLocator(LO_BUT_VIEW_CHECK_CLAIM_STATUS, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object clickOnCheckClaimStatusButton() {
        String result = clickLocator(LO_BUT_VIEW_CHECK_CLAIM_STATUS, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

     /**
     * Validates if Gem top logo is present and it's a link.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object validateGem_Top_Left_Logo_BCAA() {
        String result = validateLocatorExists(LO_IMG_GEM_TOP_LOGO_BCAA, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Clicks the 'VIEW' button under the Submit Documents card layout.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object clickOnViewUnderSubmitDocumentsOption() {
        String result = clickLocator(LO_BUT_VIEW_SUBMIT_DOCUMENTS, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    
     /**
     * Validates if current webpage is loaded and correct.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object verifyContactUsHelpCentreSection(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_HOW_CAN_WE_ASSIST_YOU_FR : LO_TXT_HOW_CAN_WE_ASSIST_YOU;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    public Object verifyHowCanWeAssistYouParagraph(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_HOW_CAN_WE_ASSIST_YOU_PARAGRAPH_FR : LO_TXT_HOW_CAN_WE_ASSIST_YOU_PARAGRAPH;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    public Object verifyContactUsEmergencyTravelAssistanceParagraph(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_CONTACT_US_EMERGENCY_TRAVEL_ASSISTANCE_PARAGRAPH_FR : LO_TXT_CONTACT_US_EMERGENCY_TRAVEL_ASSISTANCE_PARAGRAPH;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    public Object verifyContactUsClaimStatusParagraph(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_CONTACT_US_CLAIM_STATUS_PARAGRAPH_FR : LO_TXT_CONTACT_US_CLAIM_STATUS_PARAGRAPH;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    public Object verifySubmitBillsOrMissingDocumentsParagraph(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_CONTACT_US_SUBMIT_BILLS_OR_MISSING_DOCUMENTS_PARAGRAPH_FR : LO_TXT_CONTACT_US_SUBMIT_BILLS_OR_MISSING_DOCUMENTS_PARAGRAPH;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    public Object verifyGeneralQuestionsParagraph(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_CONTACT_US_GENERAL_QUESTIONS_PARAGRAPH_FR : LO_TXT_CONTACT_US_GENERAL_QUESTIONS_PARAGRAPH;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    public Object verifyCustomerRelationsParagraph(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_CONTACT_US_CUSTOMER_RELATIONS_PARAGRAPH_FR : LO_TXT_CONTACT_US_CUSTOMER_RELATIONS_PARAGRAPH;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object verifyCustomerRelationsParagraphManulife() {
        String result = validateLocatorExists(LO_TXT_CONTACT_US_CUSTOMER_RELATIONS_PARAGRAPH_MANULIFE, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    public Object verifyContactUsEmergencyTravelAssistanceParagraph2(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_CONTACT_US_EMERGENCY_TRAVEL_ASSISTANCE_PARAGRAPH2_FR : LO_TXT_CONTACT_US_EMERGENCY_TRAVEL_ASSISTANCE_PARAGRAPH2;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    public Object verifyContactUsClaimStatusParagraph2(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_CONTACT_US_CLAIM_STATUS_PARAGRAPH2_FR : LO_TXT_CONTACT_US_CLAIM_STATUS_PARAGRAPH2;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    public Object verifyContactUsSubmitBillsOrMissingDocumentsParagraph2(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_CONTACT_US_SUBMIT_BILLS_OR_MISSING_DOCUMENTS_PARAGRAPH2_FR : LO_TXT_CONTACT_US_SUBMIT_BILLS_OR_MISSING_DOCUMENTS_PARAGRAPH2;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    public Object verifyContactUsGeneralQuestionsParagraph2(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_CONTACT_US_GENERAL_QUESTIONS_PARAGRAPH2_FR : LO_TXT_CONTACT_US_GENERAL_QUESTIONS_PARAGRAPH2;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    public Object verifyContactUsCustomerRelationsParagraph2(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_CONTACT_US_CUSTOMER_RELATIONS_PARAGRAPH2_FR : LO_TXT_CONTACT_US_CUSTOMER_RELATIONS_PARAGRAPH2;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    public Object verifyContactUsCustomerRelationsSelectNoToDecisionLetter(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_RAD_NO_DECISION_LETTER_RECEIVED_FR : LO_RAD_NO_DECISION_LETTER_RECEIVED;
        String result = clickLocator(locator, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    public Object verifyContactUsCustomerRelationsSelectYesToDecisionLetter(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_RAD_YES_DECISION_LETTER_RECEIVED_FR : LO_RAD_YES_DECISION_LETTER_RECEIVED;
        String result = clickLocator(locator, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    public Object verifyContactUsClaimStatusInfoBox(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_CONTACT_US_CLAIM_STATUS_INFO_BOX_FR : LO_TXT_CONTACT_US_CLAIM_STATUS_INFO_BOX;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    /**
     * Clicks the 'Customer relation' card under the help centre page.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object clickCustomerRelations(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_CUSTOMER_RELATIONS_CARD_FR : LO_TXT_CUSTOMER_RELATIONS_CARD;
        String result = clickLocator(locator, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    /**
     * Validates if current webpage is loaded and correct.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object verifyCustomerRelationsPage() {
        String result = validateLocatorExists(LO_TXT_CUSTOMER_RELATIONS_VERIFY, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object verifyCustomerRelationsPageCapLetters(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_CUSTOMER_RELATIONS_CAP_LETTERS_VERIFY_FR : LO_TXT_CUSTOMER_RELATIONS_CAP_LETTERS_VERIFY;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    /**
     * Enters the policy number.
     * 
     * @param policyNumber The policy number to be entered.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object enterPolicyNumber(String language, String policyNumber) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_EDT_POLICY_NUMBER_FR : LO_EDT_POLICY_NUMBER;
        String result = setText(locator, policyNumber, FW_ConfigMgr.getDefaultTimeout(), false);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Enters the claim number.
     * 
     * @param claimNumber The claim number to be entered.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object enterClaimNumber(String language, String claimNumber) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_EDT_CLAIM_NUMBER_FR : LO_EDT_CLAIM_NUMBER;
        String result = setText(locator, claimNumber, FW_ConfigMgr.getDefaultTimeout(), false);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    
    /**
     * Enters the First Name.
     * 
     * @param firstName The First Name to be entered.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object enterFirstName(String language, String firstName) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_EDT_FIRST_NAME_FR : LO_EDT_FIRST_NAME;
        String result = setText(locator, firstName, FW_ConfigMgr.getDefaultTimeout(), false);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Enters the Last Name.
     * 
     * @param lastName The Last Name to be entered.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object enterLastName(String language, String lastName) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_EDT_LAST_NAME_FR : LO_EDT_LAST_NAME;
        String result = setText(locator, lastName, FW_ConfigMgr.getDefaultTimeout(), false);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Enters the Date of Birth.
     * 
     * @param datOfBirth The date of birth to be entered.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object enterDOB(String language, String dateOfBirth) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_EDT_DATE_OF_BIRTH_FR : LO_EDT_DATE_OF_BIRTH;
        String result = setText(locator, dateOfBirth, FW_ConfigMgr.getDefaultTimeout(), false);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Enters the Email.
     * 
     * @param email The email to be entered.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object enterEmail(String language, String email) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_EDT_EMAIL_FR : LO_EDT_EMAIL;
        String result = setText(locator, email, FW_ConfigMgr.getDefaultTimeout(), false);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Enters the Phone Number.
     * 
     * @param phone The phone number to be entered.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object enterPhone(String language, String phone) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_EDT_PHONE_NUMBER_FR : LO_EDT_PHONE_NUMBER;
        String result = setText(locator, phone, FW_ConfigMgr.getDefaultTimeout(), false);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Enters the text in textarea.
     * 
     * @param text The text to be entered in the textarea.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object enterText(String text) {
        String result = setText(LO_EDT_TEXT_TEXTAREA, text, FW_ConfigMgr.getDefaultTimeout(), false);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Enters the text in textarea.
     * 
     * @param text The text to be entered in the textarea.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object enterTextInTextArea(String language, String text) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_EDT_TEXT_TEXTAREA_FR : LO_EDT_TEXT_TEXTAREA;
        String result = setText(locator, text, FW_ConfigMgr.getDefaultTimeout(), false);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Verifies if the header "Submit Bills or Documents" exists.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object verifySubmitBillsOrDocumentsHeader() {
        String result = validateLocatorExists(LO_TXT_SUBMIT_BILLS_OR_DOCUMENTS_SECTION, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object verifySubmitButton(String language) {
String locator = "fr".equalsIgnoreCase(language) ? LO_BUT_SUBMIT_FR : LO_BUT_SUBMIT;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    public Object verifyUploadDocumentsInfoBox(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_UPLOAD_DOCUMENTS_INFO_BOX_FR : LO_TXT_UPLOAD_DOCUMENTS_INFO_BOX;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    public Object verifyAcceptedFileTypesAndSize(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_ACCEPTED_FILE_TYPES_AND_SIZE_FR : LO_TXT_ACCEPTED_FILE_TYPES_AND_SIZE;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    public Object verifyAcceptedFileTypesAndSize2(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_ACCEPTED_FILE_TYPES_AND_SIZE2_FR : LO_TXT_ACCEPTED_FILE_TYPES_AND_SIZE2;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    public Object verifyDocumentTypeHeading(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_DOCUMENT_TYPE_HEADING_FR : LO_TXT_DOCUMENT_TYPE_HEADING;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    public Object verifyDocumentTypeSubHeading(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_DOCUMENT_TYPE_SUB_HEADING_FR : LO_TXT_DOCUMENT_TYPE_SUB_HEADING;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    public Object verifyUploadDocumentSubHeading(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_UPLOAD_DOCUMENT_SUB_HEADING_FR : LO_TXT_UPLOAD_DOCUMENT_SUB_HEADING;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }


    /**
     * Verifies if the header "Customer Relations" exists.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object verifyCustomerRelationsHeader() {
        String result = validateLocatorExists(LO_TXT_CUSTOMER_RELATIONS_FORM_SECTION, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * clicks on the "Click here" link under Submit Bill or Documents.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */

    public Object clickHereTextLink(String language) {
         String locator = "fr".equalsIgnoreCase(language) ? LO_LNK_CLICK_HERE_FR : LO_LNK_CLICK_HERE;   
        String result = clickLocator(locator, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Selects what you need to submit.
     * 
     * @param whatYouNeedToSubmit what you need to submit is selected from a dropdown.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object selectWhatYouNeedToSubmit(String whatYouNeedToSubmit) {
        String result = setDropdownAppian(LO_LST_WHAT_YOU_NEED_TO_SUBMIT, whatYouNeedToSubmit, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Selects the claim type from a dropdown.
     * 
     * @param claimType what you need to submit is selected from a dropdown.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object selectClaimType(String claimType) {
        String result = setDropdownAppian(LO_LST_CLAIM_TYPE, claimType, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Selects the document type from a dropdown.
     * 
     * @param documentType the type of document is selected from a dropdown.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object selectDocumentType(String documentType) {
        String result = setDropdownAppian(LO_LST_DOCUMENT_TYPE, documentType, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

     /**
     * Selects the document type from a dropdown.
     * 
     * @param documentType the type of document is selected from a dropdown.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object selectDocumentType2(String documentType) {
        String result = setDropdownAppian(LO_LST_DOCUMENT_TYPE, documentType, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Uploads the first Document.
     * 
     * @param filePath The relative path of the itinerary file from the user's home directory.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object uploadDocumentType1(String filePath) {
        String result = uploadFileV2(filePath, LO_DOC_DOCUMENT_TYPE1);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Uploads the second Document.
     * 
     * @param filePath The relative path of the itinerary file from the user's home directory.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object uploadDocumentType2(String filePath) {
        waitForDuration(15, "s", false); // Wait to perform next check
        String result = uploadFileV2(filePath, LO_DOC_DOCUMENT_TYPE2);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * clicks on Add another Document.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
     public Object clickOnAddAnotherDocument() {
        String result = clickLocator(LO_BUT_ADD_ANOTHER_DOCUMENT, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Clicks the 'Claim Status' card.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object clickClaimStatusCard() {
        String result = clickLocator(LO_TXT_CLAIM_STATUS_CARD, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

     /**
     * Clicks the "View your Claim Status" Link highlighted in red
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object clickOnViewYourClaimStatusLink(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_LNK_VIEW_YOUR_CLAIM_STATUS_FR : LO_LNK_VIEW_YOUR_CLAIM_STATUS;
        String result = clickLocator(locator, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if the Claim Status section is displayed.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object verifyClaimStatusSection() {
        String result = validateLocatorExists(LO_TXT_CLAIM_STATUS_SECTION, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * clicks on the "Submit Bill or Documents" card.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */

     public Object clickSubmitBillOrDocumentCard() {
        String result = clickLocator(LO_TXT_SUBMIT_BILLS_OR_DOCUMENTS_CARD, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
     /**
     * Validates if current webpage is loaded and correct.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object VerifyEmergencyAssistanceCard() {
        String result = validateLocatorExists(LO_TXT_VALID_EMARGENCY_ASSISTANCE, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }  
     /**
     * Validates if current webpage is loaded and correct.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object VerifyEmergencyNumber() {
        String result = validateLocatorExists(LO_TXT_VALID_EMERGENCY_ASSISTANCE_NUMBER , FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }   
     /**
     * Validates if current webpage is loaded and correct.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object VerifyMgbEmergencyNumber() {
        String result = validateLocatorExists(LO_TXT_VALID_MGB_EMERGENCY_ASSISTANCE_NUMBER , FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }   

/**
 * Clicks the 'General Question' card under the help centre page.
 * 
 * @return A string including [PASS] or [FAIL] along with specific result details.
 */
public Object clickGeneralQuestion() {
    String result = clickLocator(LO_BUT_GENERAL_QUESTION, FW_ConfigMgr.getDefaultTimeout());
    result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
    return result;

}
/**
 * Validates if current webpage is loaded and correct.
 *
 * @return A string including [PASS] or [FAIL] along with specific result details.
 */
public Object verifyGeneralQuestionsPage() {
    String result = validateLocatorExists(LO_TXT_GENERAL_QUESTIONS_VERIFY, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
    result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
    return result;
}

/**
 * Scrolls down on the page.
 * 
 * @return A string including [PASS] or [FAIL] along with specific result details.
 */
public Object scrollDown() {
    String result = scrollToLocator(LO_TXT_FQA);
    result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
    return result;
}

/**
 * Clicks the 'Second Frequently Asked Question'
 * 
 * @return A string including [PASS] or [FAIL] along with specific result details.
 */
public Object clickOnFirstFAQ() {
    String result = clickLocator(LO_TXT_FQA, FW_ConfigMgr.getDefaultTimeout());
    result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
    return result;
}

/**
 * Validates if the response displayed correctly.
 *
 * @return A string including [PASS] or [FAIL] along with specific result
 *         details.
 */
public Object validateFirstQuestionResponse() {
    String result = validateLocatorExists(LO_TXT_FIRST_QUESTION_RESPONSE, FW_ConfigMgr.getDefaultTimeout(),
            FW_ConfigMgr.getDefaultInterval());
    result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
    return result;
}

/**
 * Clicks the 'View All FAQs'link.
 * 
 * @return A string including [PASS] or [FAIL] along with specific result details.
 */
public Object clickOnViewAllFAQs(String language) {
    String locator = "fr".equalsIgnoreCase(language) ? LO_BUT_VIEW_ALL_FAQs_FR : LO_BUT_VIEW_ALL_FAQs;
    String result = clickLocator(locator, FW_ConfigMgr.getDefaultTimeout());
    result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
    return result;
}

public Object clickOnBackButton() {
    waitForDuration(5, "s", false); // Wait to perform next check
    String result = clickLocator(LO_BUT_BACK, FW_ConfigMgr.getDefaultTimeout());
    result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
    return result;
}
public Object verifyBackButton(String language) {
    String locator = "fr".equalsIgnoreCase(language) ? LO_BUT_BACK_FR : LO_BUT_BACK;
    String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(),
            FW_ConfigMgr.getDefaultInterval());
    result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
    return result;
}

public Object verifyContinueButton(String language) {
    String locator = "fr".equalsIgnoreCase(language) ? LO_BUT_CONTINUE_CONTACT_US_FR : LO_BUT_CONTINUE_CONTACT_US;
    String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(),
            FW_ConfigMgr.getDefaultInterval());
    result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
    return result;
}

public Object clickOnContinueButton() {
    waitForDuration(3, "s", false); // Wait to perform next check
    String result = clickLocator(LO_BUT_CONTINUE, FW_ConfigMgr.getDefaultTimeout());
    result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
    return result;
}

/**
 * Validates if the Travel and Assistance questions displayed correctly.
 *
 * @return A string including [PASS] or [FAIL] along with specific result details.
 */
public Object validateTravelAndAssistanceQuestions() {
    String result = validateLocatorExists(LO_TXT_TRAVEL_AND_ASSISTANCE, FW_ConfigMgr.getDefaultTimeout(),
            FW_ConfigMgr.getDefaultInterval());
    result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
    return result;
}

/**
 * Validates if the claiming questions displayed correctly.
 *
 * @return A string including [PASS] or [FAIL] along with specific result
 *         details.
 */
public Object validateClaimingQuestions() {
    String result = validateLocatorExists(LO_TXT_CLAIMING, FW_ConfigMgr.getDefaultTimeout(),
            FW_ConfigMgr.getDefaultInterval());
    result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
    return result;
}

/**
 * Clicks the 'Emergency Travel Assistance' card.
 * 
 * @return A string including [PASS] or [FAIL] along with specific result details.
 */
public Object clickEmergencyTravelAssistance() {
    String result = clickLocator(LO_SLCT_EMERGENCY_TRAVEL_ASSISTANCE, FW_ConfigMgr.getDefaultTimeout());
    result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
    return result;
}

/**
 * Validates if the Emergency Travel Assistance section displayed correctly.
 *
 * @return A string including [PASS] or [FAIL] along with specific result details.
 */
public Object validateEmergencyTravelAssistance() {
    String result = validateLocatorExists(LO_TXT_EMERGENCY_TRAVEL_ASSISTANCE, FW_ConfigMgr.getDefaultTimeout(),
            FW_ConfigMgr.getDefaultInterval());
    return result = FW_StringUtils.metaInsert(result, getClass().getSimpleName());
}

/**
 * Enters the Alternate Phone Number.
 * 
 * @param alternatePhone The alternate phone number to be entered.
 * 
 * @return A string including [PASS] or [FAIL] along with specific result details.
 */
public Object enterAlternatePhoneNumber(String language, String alternatePhone) {
    String locator = "fr".equalsIgnoreCase(language) ? LO_EDT_ALTERNATE_PHONE_NUMBER_FR : LO_EDT_ALTERNATE_PHONE_NUMBER;
    String result = setText(locator, alternatePhone, FW_ConfigMgr.getDefaultTimeout(), false);
    result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
    return result;
}
/**
 * Validates if the Consumer or Small Business Number displayed correctly.
 *
 * @return A string including [PASS] or [FAIL] along with specific result
 *         details.
 */
public Object validateConsumerorSmallBusinessNumber() {
    String result = validateLocatorExists(LO_TXT_VALID_CONSUMER_NUMBER, FW_ConfigMgr.getDefaultTimeout(),
            FW_ConfigMgr.getDefaultInterval());
    result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
    return result;
}

    /**
     * Validates if the Commercial or Scotia Visa Business Cards Number displayed correctly.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object validateCommercialNumber() {
        String result = validateLocatorExists(LO_TXT_VALID_COMERCIAL_NUMBER, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Selects radio button "No" for the dropdown for the question : Is this related to a claim decision letter you received? .
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object selectNoToRelatedToClaimDecisionLetter() {
        String result = clickLocator(LO_RAD_RELATED_TO_CLAIM_DECISION_LETTER_NO, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Selects a value from the dropdown of field To help us better understand your situation, please select the topic that best applies to your request.
     * @param topic The topic that best applies to your request.
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object selectTopicThatAppliesToRequest(String topic) {
        String result = setDropdownAppian(LO_LST_SELECT_TOPIC, topic, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Uploads a document.
     * 
     * @param filePath The relative path of the payment proof file from the user's home directory.
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object uploadDocument(String filePath) {
        String result = uploadFileV2(filePath, LO_DOC_UPLOAD);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if the French/English Button toggle at top right is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object validateFrenchButtonToggle(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_BUT_FRANÇAIS_EN : LO_BUT_FRANÇAIS;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if the Mailing Address heading at bottom towards footer of page is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object validateMailingAddressHeader(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_MAILING_ADDRESS_HEADING_FR : LO_TXT_MAILING_ADDRESS_HEADING;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object validateGEMIncLeftCAD(String language, String address) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_GEM_INC_LEFT_CAD_FR : LO_TXT_GEM_INC_LEFT_CAD;
        String result = validateWithinLocatorText(locator,address,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object validateCADGEM73QueenStreet(String address) {
        String result = validateWithinLocatorText(LO_TXT_MAILING_ADDRESS_73_QUEEN_STREET,address,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object validateUSAGEMPox10(String address) {
        String result = validateWithinLocatorText(LO_TXT_MAILING_ADDRESS_PO_BOX_10,address,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object validateGEMIncRightUSA(String language, String address) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_GEM_INC_RIGHT_USD_FR : LO_TXT_GEM_INC_RIGHT_USD;
        String result = validateWithinLocatorText(locator,address,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object validateAddGEMNoIncLeftCAD(String language, String data) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_GEM_NO_INC_LEFT_CAD_FR : LO_TXT_GEM_NO_INC_LEFT_CAD;
        String result = validateWithinLocatorText(locator,data,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object validateAddGEMNoIncRightUSA(String language, String data) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_GEM_NO_INC_RIGHT_USA_FR : LO_TXT_GEM_NO_INC_RIGHT_USA;
        String result = validateWithinLocatorText(locator,data,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
     public Object verifyEmergencyHeading(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_EMERGENCY_ASSISTANCE_HEADING_FR : LO_TXT_EMERGENCY_ASSISTANCE_HEADING;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    public Object verifySendUsAMessageHeading(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_SEND_US_A_MESSAGE_HEADING_FR : LO_TXT_SEND_US_A_MESSAGE_HEADING;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    public Object verifyCheckClaimStatusHeading(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_CHECK_CLAIM_STATUS_HEADING_FR : LO_TXT_CHECK_CLAIM_STATUS_HEADING;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    public Object verifySubmitDocumentsHeading(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_SUBMIT_DOCUMENTS_HEADING_FR : LO_TXT_SUBMIT_DOCUMENTS_HEADING;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    public Object clickContactUsEmergencyTravelAssistanceHeading(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_EMERGENCY_TRAVEL_ASSISTANCE_HEADING_FR : LO_TXT_EMERGENCY_TRAVEL_ASSISTANCE_HEADING;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    public Object clickContactUsClaimStatusHeading(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_CLAIM_STATUS_HEADING_FR : LO_TXT_CLAIM_STATUS_HEADING;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    public Object clickContactUsSubmitBillsOrMissingDocumentsHeading(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_SUBMIT_BILLS_OR_MISSING_DOCUMENTS_HEADING_FR : LO_TXT_SUBMIT_BILLS_OR_MISSING_DOCUMENTS_HEADING;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    public Object clickContactUsGeneralQuestionsHeading(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_GENERAL_QUESTIONS_HEADING_FR : LO_TXT_GENERAL_QUESTIONS_HEADING;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    public Object clickContactUsCustomerRelationsHeading(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_CUSTOMER_RELATIONS_HEADING_FR : LO_TXT_CUSTOMER_RELATIONS_HEADING;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    public Object clickContactUsCustomerRelationsCustomerComplaintResolutionProcessHeading(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_CUSTOMER_RELATIONS_CUSTOMER_COMPLAINT_RESOLUTION_PROCESS_HEADING_FR : LO_TXT_CUSTOMER_RELATIONS_CUSTOMER_COMPLAINT_RESOLUTION_PROCESS_HEADING;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    public Object clickContactUsCustomerRelationsCustomerComplaintResolutionProcessHeadingParagraph(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_CUSTOMER_RELATIONS_CUSTOMER_COMPLAINT_RESOLUTION_PROCESS_HEADING_PARAGRAPH_FR : LO_TXT_CUSTOMER_RELATIONS_CUSTOMER_COMPLAINT_RESOLUTION_PROCESS_HEADING_PARAGRAPH;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    public Object clickContactUsCustomerRelationsCustomerComplaintResolutionProcess1stProcess(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_CUSTOMER_RELATIONS_CUSTOMER_COMPLAINT_RESOLUTION_PROCESS1_FR : LO_TXT_CUSTOMER_RELATIONS_CUSTOMER_COMPLAINT_RESOLUTION_PROCESS1;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    public Object clickContactUsCustomerRelationsCustomerComplaintResolutionProcess2stProcess(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_CUSTOMER_RELATIONS_CUSTOMER_COMPLAINT_RESOLUTION_PROCESS2_FR : LO_TXT_CUSTOMER_RELATIONS_CUSTOMER_COMPLAINT_RESOLUTION_PROCESS2;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    public Object clickContactUsCustomerRelationsCustomerComplaintResolutionProcess3stProcess(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_CUSTOMER_RELATIONS_CUSTOMER_COMPLAINT_RESOLUTION_PROCESS3_FR : LO_TXT_CUSTOMER_RELATIONS_CUSTOMER_COMPLAINT_RESOLUTION_PROCESS3;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    public Object clickContactUsCustomerRelationsSubHeading(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_CUSTOMER_RELATIONS_SUB_HEADING_FR : LO_TXT_CUSTOMER_RELATIONS_SUB_HEADING;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    public Object verifyEmergencyParagraph(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_EMERGENCY_ASSISTANCE_PARAGRAPH_FR : LO_TXT_EMERGENCY_ASSISTANCE_PARAGRAPH;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    public Object verifySendUsAMessageParagraph(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_SEND_US_A_MESSAGE_PARAGRAPH_FR : LO_TXT_SEND_US_A_MESSAGE_PARAGRAPH;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    public Object verifyCheckClaimStatusParagraph(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_CHECK_CLAIM_STATUS_PARAGRAPH_FR : LO_TXT_CHECK_CLAIM_STATUS_PARAGRAPH;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    public Object verifySubmitDocumentsParagraph(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_SUBMIT_DOCUMENTS_PARAGRAPH_FR : LO_TXT_SUBMIT_DOCUMENTS_PARAGRAPH;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if the Sub-Title 1 for Mailing Address heading at bottom towards footer of page is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object validateMailingAddressSubHeadingTitleLeft(String input) {
        String result = validateWithinLocatorText(LO_TXT_MAILING_ADDRESS_HEADING_SUB_LEFT,input,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if the Sub-Title 1 for Mailing Address heading at bottom towards footer of page is present(Manulife).
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object validateMailingAddressSubHeadingTitleLeft_Manulife(String input) {
        String result = validateWithinLocatorText(LO_TXT_MAILING_ADDRESS_HEADING_SUB_LEFT_MANULIFE,input,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if the Sub-Title 2 for Mailing Address heading at bottom towards footer of page is present(Manulife).
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object validateMailingAddressSubHeadingTitleLeft_Manulife2(String input) {
        String result = validateWithinLocatorText(LO_TXT_MAILING_ADDRESS_LEFT,input,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if the Sub-Title 2 for Mailing Address heading at bottom towards footer of page is present(Manulife).
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object validateMailingAddressSubHeadingTitleRight_Manulife2(String input) {
        String result = validateWithinLocatorText(LO_TXT_MAILING_ADDRESS_RIGHT,input,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if the PO.BOX for Mailing Address heading at bottom towards footer of page is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object validateMailingAddressPOBOXLeft(String input) {
        String result = validateWithinLocatorText(LO_TXT_MAILING_ADDRESS_LEFT,input,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if the PO.BOX for Mailing Address heading at bottom towards footer of page is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object validateMailingAddressPOBOX1237(String language, String input) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_MAILING_ADDRESS_POBOX_1237_FR : LO_TXT_MAILING_ADDRESS_POBOX_1237;
        String result = validateWithinLocatorText(locator,input,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if the PO.BOX for Mailing Address heading at bottom towards footer of page is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object validateMailingAddress535GriswoldSt(String language, String input) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_MAILING_ADDRESS_535_GRISWOLD_ST_FR : LO_TXT_MAILING_ADDRESS_535_GRISWOLD_ST;
        String result = validateWithinLocatorText(locator,input,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if the PO.BOX for Mailing Address heading at bottom towards footer of page is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object validateMailingAddressPOBOXStationLeft(String input) {
        String result = validateWithinLocatorText(LO_TXT_MAILING_ADDRESS_LEFT,input,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if the Street for Mailing Address heading at bottom towards footer of page is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object validateMailingAddressStreetLeft(String input) {
        String result = validateWithinLocatorText(LO_TXT_MAILING_ADDRESS_LEFT,input,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    /**
     * Validates if the City for Mailing Address heading at bottom towards footer of page is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object validateMailingAddressCityLeft(String input) {
        String result = validateWithinLocatorText(LO_TXT_MAILING_ADDRESS_LEFT,input,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if the Province for Mailing Address heading at bottom towards footer of page is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object validateMailingAddressProvinceLeft(String input) {
        String result = validateWithinLocatorText(LO_TXT_MAILING_ADDRESS_LEFT,input,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if the Province for Mailing Address heading at bottom towards footer of page is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object validateMailingAddressProvinceRight(String input) {
        String result = validateWithinLocatorText(LO_TXT_MAILING_ADDRESS_RIGHT,input,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if the Country for Mailing Address heading at bottom towards footer of page is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object validateMailingAddressCountryLeft(String input) {
        String result = validateWithinLocatorText(LO_TXT_MAILING_ADDRESS_LEFT,input,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if the Country for Mailing Address heading at bottom towards footer of page is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object validateMailingAddressPostalCodeLeft(String input) {
        String result = validateWithinLocatorText(LO_TXT_MAILING_ADDRESS_LEFT,input,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if the Sub-Title 1 for Mailing Address heading at bottom towards footer of page is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object validateMailingAddressSubHeadingTitleRight(String input) {
        String result = validateWithinLocatorText(LO_TXT_MAILING_ADDRESS_HEADING_SUB_RIGHT,input,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if the Sub-Title 1 for Mailing Address heading at bottom towards footer of page is present(Manulife).
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object validateMailingAddressSubHeadingTitleRight_Manulife(String input) {
        String result = validateWithinLocatorText(LO_TXT_MAILING_ADDRESS_HEADING_SUB_RIGHT_MANULIFE,input,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if the Street for Mailing Address heading at bottom towards footer of page is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object validateMailingAddressPOBOXRight(String input) {
        String result = validateWithinLocatorText(LO_TXT_MAILING_ADDRESS_RIGHT,input,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    /**
     * Validates if the Street for Mailing Address heading at bottom towards footer of page is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object validateMailingAddressStreetRight(String input) {
        String result = validateWithinLocatorText(LO_TXT_MAILING_ADDRESS_RIGHT,input,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if the City for Mailing Address heading at bottom towards footer of page is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object validateMailingAddressCityRight(String input) {
        String result = validateWithinLocatorText(LO_TXT_MAILING_ADDRESS_RIGHT,input,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if the Province for Mailing Address heading at bottom towards footer of page is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object validateMailingAddressStateRight(String input) {
        String result = validateWithinLocatorText(LO_TXT_MAILING_ADDRESS_RIGHT,input,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if the Building for Mailing Address heading at bottom towards footer of page is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object validateMailingAddressBuildingRight(String input) {
        String result = validateWithinLocatorText(LO_TXT_MAILING_ADDRESS_RIGHT,input,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if the Country for Mailing Address heading at bottom towards footer of page is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object validateMailingAddressCountryRight(String input) {
        String result = validateWithinLocatorText(LO_TXT_MAILING_ADDRESS_RIGHT,input,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if the Country for Mailing Address heading at bottom towards footer of page is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object validateMailingAddressZipCodeRight(String input) {
        String result = validateWithinLocatorText(LO_TXT_MAILING_ADDRESS_RIGHT,input,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

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
}

