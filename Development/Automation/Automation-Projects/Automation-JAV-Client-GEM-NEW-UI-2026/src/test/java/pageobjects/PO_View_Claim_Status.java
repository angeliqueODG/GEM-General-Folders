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
public class PO_View_Claim_Status extends CU_Appian {

    // [Note: Automation Engineer, define the Page Object (PO) locators (LO) here.]
    private static final String LO_TXT_VIEW_CLAIM_STATUS_PAGE_VERIFY = "//h2[contains(text(), 'VIEW CLAIM STATUS')]";
    private static final String LO_TXT_FREQUENTLY_ASKED_QUESTIONS_TITLE = "//h2[contains(text(), 'Frequently Asked Questions (FAQ)')]";
    private static final String LO_TXT_HOW_WILL_KNOW_QUESTIONS_TITLE = "//div[contains(text(), 'How will I know when my claim is settled?')]";
    private static final String LO_TXT_HOW_LONG_QUESTIONS_TITLE = "//div[contains(text(), 'How long will my claim take to be settled?')]";
    private static final String LO_TXT_WHEN_WILL_I_RECEIVE_MY_CLAIM_NUMBER_QUESTIONS_TITLE = "//div[contains(text(), 'When will I receive my claim number?')]";
    private static final String LO_TXT_HOW_LONG_QUESTIONS_PARAGRAPH = "//p[contains(text(), 'We strive to pay your claim as efficiently as we can. Providing all requested documentation as quickly as possible will help ensure the fastest claim processing time. Upon receipt of all required documentation, a decision is rendered on most claims within 30 days.')]";
    private static final String LO_TXT_WHEN_WILL_I_RECEIVE_MY_CLAIM_NUMBER_QUESTIONS_PARAGRAPH = "//p[contains(text(), 'Upon confirming the submission of your claim information, which includes your name, date of birth, reason for claiming, and required documentation, a claim will be created, and you will receive your claim number via email.')]";
    private static final String LO_TXT_HOW_WILL_KNOW_QUESTIONS_PARAGRAPH = "//p[contains(text(), 'You can follow the status of your claim by using the Claim Status section.')]";
    private static final String LO_TXT_NEED_HELP_HEADING = "//h2[contains(text(), 'Need Help?')]";
    private static final String LO_IMG_MESSAGING_ASSISTANCE_ICON = "//div[img[@src='https://portal-uat.globalexcel.com/portal-2-0/content/ww0ECQMC1YMg-mS1Cf4B0mEBzvGS8n7jW119KTfnqNvN9RKGU3Fb3-v-we8q_Rb_riygk0LDcHqgmN85s69omMKRzUD4y8596kwlKJcT0izXvvXeZUV9SPv86sJI992AvfDF0p9G0JeWlnMn6ErroIX3']]";
    private static final String LO_TXT_NEED_HELP_PARAGRAPH = "//span[contains(text(), 'Visit our Help Centre to learn more about the tools and services available to you.')]";
    private static final String LO_IMG_TOP_LOGO_LIGHT_ZURICH = "//a//img[@src='https://geihpvqvwebgencacn1.blob.core.windows.net/appian-portal/logo_header_en_Zurich.png']";
    private static final String LO_BUT_BACK = "//span/span[contains(text(), 'Back')]";
    private static final String LO_BUT_FAQS = "//button[span[span[contains(text(), 'View all FAQs')]]]";
    private static final String LO_TXT_FREQUENTLY_ASKED_QUESTIONS_TITLE_CAP_LETTERS = "//h2[contains(text(), 'FREQUENTLY ASKED QUESTIONS (FAQ)')]";
    private static final String LO_TXT_TRAVEL_AND_ASSISTANCE_VERIFY = "//strong[contains(text(), 'Travel and Assistance')]";
    private static final String LO_TXT_CLAIMING_TAB = "//strong[contains(text(), 'Claiming')]";
    private static final String LO_TXT_CLAIM_DOCUMENTS_TAB = "//strong[contains(text(), 'Claim Documents')]";
    private static final String LO_TXT_TRAVEL_AND_ASSISTANCE_VERIFY_SUB_INFO = "//div[div[div[div[div[text()='How can I retrieve a draft claim?']]]]]/following-sibling::div";
    private static final String LO_TXT_DID_NOT_RECEIVE_ONE_TIME_VERIFICATION_CODE_SUB_INFO = "//div[div[div[div[div[text()='I did not receive the one-time verification code. What should I do?']]]]]/following-sibling::div";
    private static final String LO_TXT_ONE_TIME_VERIFICATION_CODE_RECEIVED_NOT_WORKING_SUB_INFO = "//div[div[div[div[div[text()='The one-time verification code I received is not working. What should I do?']]]]]/following-sibling::div";
    private static final String LO_TXT_MOBILE_PHONE_VERIFICATION_FAILS_SUB_INFO = "//div[div[div[div[div[text()='What should I do if my mobile phone number  verification fails while saving the draft claim?']]]]]/following-sibling::div";
    private static final String LO_TXT_WHICH_INSURANCE_INFORMATION_DO_I_NEED_TO_BRING_ON_MY_TRIP_SUB_INFO = "//div[div[div[div[div[text()='Which insurance information do I need to bring on my trip?']]]]]/following-sibling::div";
    private static final String LO_TXT_DO_I_NEED_MOBILE_PHONE_TO_RECEIVE_ONE_TIME_VC_SUB_INFO = "//div[div[div[div[div[text()='Do I need a mobile phone to receive the one-time verification code?']]]]]/following-sibling::div";
    private static final String LO_TXT_WHAT_CAN_I_DO_IF_I_NO_LONGER_HAVE_ACCESS_TO_MY_PHONE_SUB_INFO = "//div[div[div[div[div[text()='What can I do if I no longer have access to my phone?']]]]]/following-sibling::div";
    private static final String LO_TXT_TO_WHICH_MOBILE_PHONE_THE_ONE_TIME_VC_SENT_SUB_INFO = "//div[div[div[div[div[text()='To which mobile phone number is the one-time verification code sent?']]]]]/following-sibling::div";
    private static final String LO_TXT_HOW_LONG_DOES_IT_TAKE_TO_RECEIVE_THE_ONE_TIME_VC_SUB_INFO = "//div[div[div[div[div[text()='How long does it take to receive the one-time verification code?']]]]]/following-sibling::div";
    private static final String LO_TXT_DO_I_NEED_TO_ENTER_A_VC_EACH_TIME_I_ACCESS_MY_CLAIM_SUB_INFO = "//div[div[div[div[div[text()='Do I need to enter a verification code each time I access my claim?']]]]]/following-sibling::div";
    private static final String LO_TXT_CAN_I_RECEIVE_THE_ONE_TIME_VERIFICATION_CODE_BY_EMAIL_SUB_INFO = "//div[div[div[div[div[text()='Can I receive the one-time verification code by email?']]]]]/following-sibling::div";
    private static final String LO_TXT_WILL_I_INCUR_CHARGES_FOR_RECEIVING_THE_VERIFICATION_CODE_SUB_INFO = "//div[div[div[div[div[text()='Will I incur charges for receiving the verification code?']]]]]/following-sibling::div";
    private static final String LO_TXT_CAN_I_USE_AN_INTERNATIONAL_MOBILE_PHONE_TO_AUTHENTICATE_SUB_INFO = "//div[div[div[div[div[text()='Can I use an international mobile phone number to authenticate?']]]]]/following-sibling::div";
    private static final String LO_TXT_CAN_I_REPLY_TO_THE_NUMBER_THAT_SENDS_THE_ONE_TIME_VC_SUB_INFO = "//div[div[div[div[div[text()='Can I reply to the number that sends the one-time verification code?']]]]]/following-sibling::div";
    private static final String LO_TXT_WHICH_INSURANCE_INFO_DO_I_NEED = "//div[contains(text(), 'Which insurance information do I need to bring on my trip?')]";
    private static final String LO_TXT_CLAIMING = "//strong[contains(text(), 'Claiming')]";
    private static final String LO_TXT_WHAT_SHOULD_I_DO_IF_I_RECEIVE_BILLS = "//div[contains(text(), 'What should I do if I receive bills?')]";
    private static final String LO_TXT_HOW_CAN_I_CONTACT_YOU_ABOUT_MY_CLAIM = "//div[contains(text(), 'How can I contact you about my claim?')]";
    private static final String LO_TXT_WHAT_TO_DO_IF_I_HAVE_OUT_OF_POCKET_EXPENSES = "//div[contains(text(), 'What should I do if I have out of pocket expenses?')]";
    private static final String LO_TXT_DO_YOU_TAKE_ORIGINAL_OR_COPY_OF_DOCUMENTS = "//div[contains(text(), 'Do I need to send you the original documents or do you accept copies?')]";
    private static final String LO_TXT_CURRENCY_TO_BE_REIMBURSED_IN = "//div[contains(text(), 'Which currency will I be reimbursed in?')]";
    private static final String LO_TXT_WHAT_IS_YOUR_MAILING_ADDRESS = "//div[contains(text(), 'What is your mailing address?')]";
    private static final String LO_TXT_HOW_DO_I_SUBMIT_A_CLAIM = "//div[contains(text(), 'How do I submit a claim?')]";
    private static final String LO_TXT_HOW_WILL_I_KNOW_CLAIM_IS_SETTLED = "//div[contains(text(), 'How will I know when my claim is settled?')]";
    private static final String LO_TXT_HOW_LONG_WILL_IT_TAKE_MY_CLAIM_TO_BE_SETTLED = "//div[contains(text(), 'How long will my claim take to be settled?')]";
    private static final String LO_TXT_WHEN_WILL_I_RECEIVE_A_CLAIM_NUMBER = "//div[contains(text(), 'When will I receive my claim number?')]";
    private static final String LO_TXT_WHY_SUBMIT_A_GEM_MEDICAL_CERTIFICATE_FROM_MY_FAMILY_PHYSICIAN = "//div[contains(text(), 'Why submit a Global Excel Management Medical Certificate from my family physician if I already provided one from my specialist?')]";
    private static final String LO_TXT_WHY_DO_I_NEED_TO_SUBMIT_MY_CREDIT_CARD_OR_BANK_STATEMENT = "//div[contains(text(), 'Why do I need to submit my credit card or bank statement(s)?')]";
    private static final String LO_TXT_WHAT_TO_DO_IF_CANNOT_FIND_MY_BOOKING_INVOICE = "//div[contains(text(), 'What should I do if I cannot find my booking invoice?')]";
    private static final String LO_TXT_WHAT_TO_DO_IF_I_DO_NOT_HAVE_A_CANCELLATION_INVOICE = "//div[contains(text(), 'What should I do if I do not have a cancellation invoice?')]";
    private static final String LO_TXT_WHAT_DOCUMENT_FORMAT_AND_SIZE_DO_YOU_ACCEPT_FOR_UPLOAD = "//div[contains(text(), 'What document format and size do you accept to be uploaded? ')]";
    private static final String LO_TXT_WHAT_DO_I_NEED_TO_PROVIDE_RECEIPTS_FOR_MY_OUT_OF_POCKET_EXPESES = "//div[contains(text(), 'Do I need to provide receipts for my out-of -pocket expenses?')]";
    private static final String LO_TXT_WHY_DO_I_NEED_TO_UPLOAD_GEM_MEDICAL_CERTIFICATE = "//div[contains(text(), \"Why do I need to upload a GEM Medical Certificate instead of my doctor's note? / Why do I need to provide a GEM Medical Certificate when I have already submitted a doctor's note?\")]";
    private static final String LO_TXT_WHY_IS_NECESSARY_TO_PROVIDE_CANCELLATION_INVOICE = "//div[contains(text(), 'Why is it necessary for me to provide a cancellation invoice from the travel supplier if I have already cancelled my trip with the travel agent?')]";
    private static final String LO_TXT_DIFFERENCE_BTN_T_AGENCY_AND_T_SUPPLIER = "//div[contains(text(), 'What is the difference between a travel agency and a travel supplier?')]";
    private static final String LO_TXT_REIMBURSEMENT_PAID_USING_CREDIT_CARD = "//div[contains(text(), 'How can I claim reimbursement for trips paid using Credit Card Reward/Travel points?')]";
    private static final String LO_TXT_HOW_CAN_I_RETRIEVE_A_DRAFT_CLAIM = "//div[contains(text(), 'How can I retrieve a draft claim?')]";
    private static final String LO_TXT_I_DID_NOT_RECEIVE_THE_ONE_TIME_VERIFICATION_CODE = "//div[contains(text(), 'I did not receive the one-time verification code. What should I do?')]";
    private static final String LO_TXT_ONE_TIME_VERIFICATION_CODE_RECEIVED_NOT_WORKING = "//div[contains(text(), 'The one-time verification code I received is not working. What should I do?')]";
    private static final String LO_TXT_WHAT_TO_DO_IF_MOBILE_PHONE_VERIFICATION_FAILS = "//div[contains(text(), 'What should I do if my mobile phone number  verification fails while saving the draft claim?')]";
    private static final String LO_TXT_WHAT_CAN_I_DO_IF_I_NO_LONGER_HAVE_ACCESS_TO_MY_PHONE = "//div[contains(text(), 'What can I do if I no longer have access to my phone?')]";
    private static final String LO_TXT_TO_WHICH_MOBILE_PHONE_THE_ONE_TIME_VC_SENT = "//div[contains(text(), 'To which mobile phone number is the one-time verification code sent?')]";
    private static final String LO_TXT_HOW_LONG_DOES_IT_TAKE_TO_RECEIVE_THE_ONE_TIME_VC = "//div[contains(text(), 'How long does it take to receive the one-time verification code?')]";
    private static final String LO_TXT_DO_I_NEED_TO_ENTER_A_VC_EACH_TIME_I_ACCESS_MY_CLAIM = "//div[contains(text(), 'Do I need to enter a verification code each time I access my claim?')]";
    private static final String LO_TXT_CAN_I_RECEIVE_THE_ONE_TIME_VERIFICATION_CODE_BY_EMAIL = "//div[contains(text(), 'Can I receive the one-time verification code by email?')]";
    private static final String LO_TXT_WILL_I_INCUR_CHARGES_FOR_RECEIVING_THE_VERIFICATION_CODE = "//div[contains(text(), 'Will I incur charges for receiving the verification code?')]";
    private static final String LO_TXT_CAN_I_USE_AN_INTERNATIONAL_MOBILE_PHONE_TO_AUTHENTICATE = "//div[contains(text(), 'Can I use an international mobile phone number to authenticate?')]";
    private static final String LO_TXT_CAN_I_REPLY_TO_THE_NUMBER_THAT_SENDS_THE_ONE_TIME_VC = "//div[contains(text(), 'Can I reply to the number that sends the one-time verification code?')]";
    private static final String LO_TXT_DO_I_NEED_MOBILE_PHONE_TO_RECEIVE_ONE_TIME_VC = "//div[contains(text(), 'Do I need a mobile phone to receive the one-time verification code?')]";
    private static final String LO_TXT_TECHNICAL_SUPPORT = "//strong[contains(text(), 'Technical Support')]";
    private static final String LO_BUT_VISIT_OUR_HELP_CENTRE = "//strong[contains(text(), 'VISIT OUR HELP CENTRE')]";
    private static final String LO_EDT_CLAIM_NUMBER_INPUT_FIELD = "//div[label[contains(text(), 'Claim Number or Intent ID')]]/following-sibling::div//input";
    private static final String LO_EDT_CLAIM_NUMBER_FIELD = "//div[label[contains(text(), 'Claim Number or Intent ID')]]/following-sibling::div//input";
    private static final String LO_TXT_CLAIM_NUMBER_LABEL = "//label[contains(text(), 'Claim Number or Intent ID')]";
    private static final String LO_TXT_ERROR_VALID_GLOBAL_EXCEL_NUMBER = "//div[label='Claim Number or Intent ID']/following-sibling::div//span[div]";
    private static final String LO_BUT_VIEW_STATUS = "//span/span[contains(text(), 'View Status')]";
    private static final String LO_TXT_ERROR_CLAIM_NOT_FOUND = "(//p[strong])[2]";
    private static final String LO_TXT_ERROR_CLAIM_NOT_FOUND_ZURICH_SUNLIFE = "(//p[strong])[1]";
    private static final String LO_TXT_ERROR_CLAIM_NOT_FOUND_2 = "//div[div[div[div[div[div[div[div[div[div[p[strong[text()=\"Claim Number not Found\"]]]]]]]]]]]]";
    private static final String LO_IMG_GEM_TOP_LOGO = "//a//img[@src='https://geihpvqvwebgencacn1.blob.core.windows.net/appian-portal/logo_header_en_GEM.png' or @src='https://geihpvtvwebgencacn1.blob.core.windows.net/appian-portal/logo_header_en_GEM.png']";
    private static final String LO_IMG_GEM_TOP_LOGO_BCAA = "//a//img[@src='https://geihpvqvwebgencacn1.blob.core.windows.net/appian-portal/logo_header_en_BCAA.png' or @src='https://geihpvtvwebgencacn1.blob.core.windows.net/appian-portal/logo_header_en_BCAA.png']";
    private static final String LO_IMG_GEM_TOP_LOGO_AMEX = "https://geihpvtvwebgencacn1.blob.core.windows.net/appian-portal/logo_header_en_GEM.png";
    private static final String LO_LNK_HELP_CENTRE_TOP = "//a[contains(text(), 'HELP CENTRE')]";
    private static final String LO_LNK_FRENCH_TOGGLE_FR = "//div[p[span[a[contains(text(), 'FRANÇAIS')]]]]";
    private static final String LO_TXT_AMEX_HOME_PAGE_VERIFY = "//span[contains(text(), 'Welcome to your Travel Claim Centre for your ') and strong[contains(text(), 'AMEX Card')]]";
    private static final String LO_TXT_MAIN_HEADING_PARAGRAPH = "//p//span[contains(text(), 'We understand that facing unexpected situations in an unfamiliar environment can be stressful. In order to help, we offer assistance services with experts ready to support you in case of an emergency.')]";
    private static final String LO_TXT_VIEW_CLAIM_STATUS_PARAGRAPH = "//p[contains(text(), 'To view status of the claim you will need to provide the following information:')]";
    private static final String LO_IMG_GEM_BOTTOM_LOGO_DARK = "//div//img[@src='https://geihpvqvwebgencacn1.blob.core.windows.net/appian-portal/logo_footer_GEM_claim_center_en_dark.png' or @src='https://geihpvtvwebgencacn1.blob.core.windows.net/appian-portal/logo_footer_GEM_claim_center_en_dark.png']";
    private static final String LO_LNK_START_NEW_CLAIM_FOOTER = "//p[span[@class='IconWidget---medium IconWidget---inDarkBackground']/following-sibling::span/a[contains(text(), 'START A NEW CLAIM')]]";
    private static final String LO_LNK_CONTINUE_DRAFT_CLAIM_FOOTER = "//p[span[@class='IconWidget---medium IconWidget---inDarkBackground']/following-sibling::span/a[contains(text(), 'CONTINUE DRAFT CLAIM')]]";
    private static final String LO_LNK_SUBMIT_DOCUMENTS_FOOTER = "//p[span[@class='IconWidget---medium IconWidget---inDarkBackground']/following-sibling::span/a[contains(text(), 'SUBMIT DOCUMENTS')]]";
    private static final String LO_LNK_HELP_CENTRE_BOTTOM = "//p[span[@class='IconWidget---medium IconWidget---inDarkBackground']/following-sibling::span[a[contains(text(), 'HELP CENTRE')]]]";
    private static final String LO_TXT_MEDICAL_EMERGENCY_HELPLINE_HEADING = "//h3[span[//span[@class='IconWidget---inDarkBackground IconWidget---inSectionLayout2Label'] and text()='MEDICAL EMERGENCY HELPLINE']]";
    private static final String LO_TXT_FOLLOW_UP_ON_YOUR_CLAIM_HEADING = "//h3/span[contains(text(), 'FOLLOW UP ON YOUR CLAIM')]";
    private static final String LO_TXT_FOLLOW_UP_ON_YOUR_CLAIM_PARAGRAPH = "//p[contains(text(), 'You have an active claim? Follow up on your claim today in our Claim Centre!')]";
    private static final String LO_BUT_SIGN_IN = "//strong[contains(text(), 'SIGN IN')]";
    private static final String LO_TXT_GEM_FOOTER_DISCLAIMER = "//p[text()=\"Global Excel Management provides claims and assistance services for Royal & Sun Alliance Insurance Company of Canada.\"]";
    private static final String LO_TXT_TRADE_MARK_NOTICE = "//p[text()='All trademarks and logos are the property of their respective owners.']";
    private static final String LO_TXT_COPY_RIGHT_NOTICE_2025 = "//span[span and text()=\"2025\" and text()=\"Global Excel Management Inc.\" and text()=\"All rights reserved.\"]";
    private static final String LO_TXT_COPY_RIGHT_NOTICE = "//span[contains(text(), '2024') and text()='Global Excel Management Inc.' and text()='All rights reserved.']";
    private static final String LO_LNK_PRIVACY_STATEMENT = "//a[span[contains(text(), 'Privacy Statement ') and span[@class='IconWidget---inDarkBackground']]]";
    private static final String LO_LNK_CONDITIONS_OF_USE = "//a[span[contains(text(), 'Conditions of Use ') and span[@class='IconWidget---inDarkBackground']]]";
    private static final String LO_TXT_GEM_FOOTER_DISCLAIMER_BCAA = "//p[text()=\"BCAA (British Columbia Automobile Association) has appointed Global Excel Management Inc., as the provider of all assistance and claims services.\"]";
    String LO_TXT_MEDICAL_EMERGENCY_HELPLINE_NON_TOLL_FREE = "//span/a[text()=";
    String LO_TXT_MEDICAL_EMERGENCY_HELPLINE_TOLL_FREE = "//p[text()=\"(Toll free)\"]//span/a[text()=";
    private static final String LO_IMG_GEM_BOTTOM_LOGO_BCAA = "//div//img[@src='https://geihpvqvwebgencacn1.blob.core.windows.net/appian-portal/logo_footer_en_BCAA.png' or @src='https://geihpvtvwebgencacn1.blob.core.windows.net/appian-portal/logo_footer_en_BCAA.png']";
    private static final String LO_IMG_GEM_TOP_LOGO_CIBC = "//a//img[@src='https://geihpvqvwebgencacn1.blob.core.windows.net/appian-portal/logo_header_en_CIBC.png' or @src='https://geihpvtvwebgencacn1.blob.core.windows.net/appian-portal/logo_header_en_CIBC.png']";
    private static final String LO_IMG_GEM_BOTTOM_LOGO_DARK_GEM = "//div//img[@src='https://geihpvqvwebgencacn1.blob.core.windows.net/appian-portal/logo_footer_GEM_dark.png' or @src='https://geihpvtvwebgencacn1.blob.core.windows.net/appian-portal/logo_footer_GEM_dark.png']";
    private static final String LO_HOME_PAGE_VERIFY_CIBC = "//span[span and text()='Welcome to your Claim Centre for your ' and strong='CIBC Credit Card']";
    private static final String LO_IMG_GEM_BOTTOM_LOGO_PLAIN = "//div//img[@src='https://geihpvqvwebgencacn1.blob.core.windows.net/appian-portal/logo_footer_en_GEM.png' or @src='https://geihpvtvwebgencacn1.blob.core.windows.net/appian-portal/logo_footer_en_GEM.png']";
    private static final String LO_LNK_START_NEW_CLAIM_FOOTER_LIGHT = "//p[span[@class='IconWidget---medium IconWidget---inLightBackground']/following-sibling::span/a[contains(text(), 'START A NEW CLAIM')]]";
    private static final String LO_LNK_CONTINUE_DRAFT_CLAIM_FOOTER_LIGHT = "//p[span[@class='IconWidget---medium IconWidget---inLightBackground']/following-sibling::span/a[contains(text(), 'CONTINUE DRAFT CLAIM')]]";
    private static final String LO_LNK_SUBMIT_DOCUMENTS_FOOTER_LIGHT = "//p[span[@class='IconWidget---medium IconWidget---inLightBackground']/following-sibling::span/a[contains(text(), 'SUBMIT DOCUMENTS')]]";
    private static final String LO_LNK_HELP_CENTRE_BOTTOM_LIGHT = "//p[span[@class='IconWidget---medium IconWidget---inLightBackground']/following-sibling::span[a[contains(text(), 'HELP CENTRE')]]]";
    private static final String LO_TXT_GEM_FOOTER_DISCLAIMER_CL = "//p[text()='The Canada Life Assurance Company has appointed Global Excel Management Inc. as the provider of Travel Assistance and Out of Country claims services.']";
    private static final String LO_LNK_PRIVACY_STATEMENT_LIGHT = "//a[span[contains(text(), 'Privacy Statement ') and span[@class='IconWidget---inLightBackground']]]";
    private static final String LO_LNK_CONDITIONS_OF_USE_LIGHT = "//a[span[contains(text(), 'Conditions of Use ') and span[@class='IconWidget---inLightBackground']]]";
    private static final String LO_TXT_MEDICAL_EMERGENCY_HELPLINE_HEADING_LIGHT = "//h3[span[//span[@class='IconWidget---inLightBackground IconWidget---inSectionLayout2Label'] and text()='MEDICAL EMERGENCY HELPLINE']]";
    private static final String LO_IMG_GEM_BOTTOM_LOGO_CL = "//div//img[@src='https://geihpvqvwebgencacn1.blob.core.windows.net/appian-portal/logo_footer_en_CanadaLife.png' or @src='https://geihpvtvwebgencacn1.blob.core.windows.net/appian-portal/logo_footer_en_CanadaLife.png']";
    private static final String LO_TXT_GEM_FOOTER_DISCLAIMER_2 = "//p[text()='Assistance and Claims Services are administered by Global Excel Management Inc.']";
    private static final String LO_IMG_GEM_TOP_LOGO_INTACT = "//a//img[@src='https://geihpvqvwebgencacn1.blob.core.windows.net/appian-portal/logo_header_en_Intact.png' or @src='https://geihpvtvwebgencacn1.blob.core.windows.net/appian-portal/logo_header_en_Intact.png']";
    private static final String LO_IMG_GEM_BOTTOM_LOGO_INTACT = "//div//img[@src='https://geihpvqvwebgencacn1.blob.core.windows.net/appian-portal/logo_footer_en_Intact.png' or @src='https://geihpvtvwebgencacn1.blob.core.windows.net/appian-portal/logo_footer_en_Intact.png']";
    private static final String LO_LNK_HELP_CENTRE_TOP_DARK = "//p[span[a[(span/span[@class='IconWidget---inDarkBackground'][not(following-sibling::span)]) or (span[@class='IconWidget---inDarkBackground'] and text()='HELP CENTRE')]]]";
    private static final String LO_LNK_FRENCH_TOGGLE_FR_DARK = "//p[span[a[(span[span[@class='IconWidget---inDarkBackground'] and span[contains(text(), 'FR')]]) or (span[@class='IconWidget---inDarkBackground'] and span[contains(text(), 'FRANÇAIS')])]]]";
    private static final String LO_IMG_GEM_TOP_LOGO_MANULIFE = "//a//img[@src='https://geihpvqvwebgencacn1.blob.core.windows.net/appian-portal/logo_header_en_Manulife.png'or @src='https://geihpvtvwebgencacn1.blob.core.windows.net/appian-portal/logo_header_en_Manulife.png']";
    private static final String LO_IMG_GEM_BOTTOM_LOGO_MANULIFE = "//div//img[@src='https://geihpvqvwebgencacn1.blob.core.windows.net/appian-portal/logo_footer_en_Manulife.png' or @src='https://geihpvtvwebgencacn1.blob.core.windows.net/appian-portal/logo_footer_en_Manulife.png']";
    private static final String LO_TXT_GEM_FOOTER_DISCLAIMER_MANULIFE = "//p[text()='Global Excel Management provides Claims and Assistance Services for The Manufacturers Life Insurance Company (Manulife).']";
    private static final String LO_IMG_GEM_TOP_LOGO_MGB = "//a//img[@src='https://geihpvqvwebgencacn1.blob.core.windows.net/appian-portal/logo_header_en_ManulifeGroupBenefits.png' or @src='https://geihpvtvwebgencacn1.blob.core.windows.net/appian-portal/logo_header_en_ManulifeGroupBenefits.png']";
    private static final String LO_TXT_GEM_FOOTER_DISCLAIMER_MGB = "//p[text()='Global Excel Management provides Claims and Assistance Services for The Manufacturers Life Insurance Company (Manulife).']";
    private static final String LO_IMG_GEM_BOTTOM_LOGO_GEM_MGB = "//div//img[@src='https://geihpvqvwebgencacn1.blob.core.windows.net/appian-portal/logo_footer_en_ManulifeGroupBenefits_GEM.png' or @src='https://geihpvtvwebgencacn1.blob.core.windows.net/appian-portal/logo_footer_en_ManulifeGroupBenefits_GEM.png']";
    private static final String LO_IMG_GEM_BOTTOM_LOGO_MANULIFE_MGB = "//div//img[@src='https://geihpvqvwebgencacn1.blob.core.windows.net/appian-portal/logo_footer_en_ManulifeGroupBenefits.png' or @src='https://geihpvtvwebgencacn1.blob.core.windows.net/appian-portal/logo_footer_en_ManulifeGroupBenefits.png']";
    private static final String LO_IMG_GEM_TOP_LOGO_ORION = "//a//img[@src='https://geihpvqvwebgencacn1.blob.core.windows.net/appian-portal/logo_header_en_Orion.png' or @src='https://geihpvtvwebgencacn1.blob.core.windows.net/appian-portal/logo_header_en_Orion.png']";
    private static final String LO_IMG_GEM_BOTTOM_LOGO_ORION = "//img[@src='https://geihpvqvwebgencacn1.blob.core.windows.net/appian-portal/logo_footer_en_Orion.png' or @src='https://geihpvtvwebgencacn1.blob.core.windows.net/appian-portal/logo_footer_en_Orion.png']";
    private static final String LO_TXT_GEM_FOOTER_DISCLAIMER_ORION = "//p[text()='Global Excel Management provides claims and assistance services for Orion Travel Insurance Company.']";
    private static final String LO_IMG_GEM_TOP_LOGO_SCOTIA = "//a//img[@src='https://geihpvqvwebgencacn1.blob.core.windows.net/appian-portal/logo_header_en_Scotiabank.png' or @src='https://geihpvtvwebgencacn1.blob.core.windows.net/appian-portal/logo_header_en_Scotiabank.png']";
    private static final String LO_IMG_GEM_BOTTOM_LOGO_LIGHT_GEM = "//div//img[@src='https://geihpvqvwebgencacn1.blob.core.windows.net/appian-portal/logo_footer_GEM_light.png' or @src='https://geihpvtvwebgencacn1.blob.core.windows.net/appian-portal/logo_footer_GEM_light.png']";
    private static final String LO_IMG_GEM_BOTTOM_LOGO_SCOTIA = "//div//img[@src='https://geihpvqvwebgencacn1.blob.core.windows.net/appian-portal/logo_footer_en_Scotiabank.png' or @src='https://geihpvtvwebgencacn1.blob.core.windows.net/appian-portal/logo_footer_en_Scotiabank.png']";
    private static final String LO_TXT_MEDICAL_EMERGENCY_HELPLINE_HEADING_NO_CALL_ICON = "//h3/span[text()='MEDICAL EMERGENCY HELPLINE']";
    private static final String LO_TXT_MEDICAL_EMERGENCY_HELPLINE_PARAGRAPH_LIGHT_CSBC = "//p[span[@class='IconWidget---medium IconWidget---inLightBackground'] and text()=' Consumer or Small Business Cards']";
    private static final String LO_TXT_MEDICAL_EMERGENCY_HELPLINE_PARAGRAPH_LIGHT_CSVBC = "//p[span[@class='IconWidget---medium IconWidget---inLightBackground'] and text()='Commercial or Scotia Visa Business Cards']";
    String LO_TXT_MEDICAL_EMERGENCY_HELPLINE_NON_TOLL_FREE2 = "//span/a[text()=";
    String LO_TXT_MEDICAL_EMERGENCY_HELPLINE_TOLL_FREE2 = "//p[text()=\"(Toll free)\"]//span/a[text()=";
    private static final String LO_IMG_GEM_TOP_LOGO_SUNLIFE = "//a//img[@src='https://geihpvqvwebgencacn1.blob.core.windows.net/appian-portal/logo_header_en_SunLife.png' or @src='https://geihpvtvwebgencacn1.blob.core.windows.net/appian-portal/logo_header_en_SunLife.png']";
    private static final String LO_IMG_GEM_BOTTOM_LOGO_SUNLIFE = "//img[@src='https://geihpvqvwebgencacn1.blob.core.windows.net/appian-portal/logo_footer_en_SunLife.png' or @src='https://geihpvtvwebgencacn1.blob.core.windows.net/appian-portal/logo_footer_en_SunLife.png']";
    private static final String LO_TXT_GEM_FOOTER_DISCLAIMER_SUNLIFE = "//p[text()='The Sun Life Assurance Company of Canada (“Sun Life”) has appointed Global Excel Management Inc., as the provider of all assistance and claims services.']";
    private static final String LO_IMG_GEM_TOP_LOGO_TD = "//a//img[@src='https://geihpvqvwebgencacn1.blob.core.windows.net/appian-portal/logo_header_en_TD.png' or @src='https://geihpvtvwebgencacn1.blob.core.windows.net/appian-portal/logo_header_en_TD.png']";
    private static final String LO_IMG_GEM_BOTTOM_LOGO_TD = "//div//img[@src='https://geihpvqvwebgencacn1.blob.core.windows.net/appian-portal/logo_footer_en_TD.png' or @src='https://geihpvtvwebgencacn1.blob.core.windows.net/appian-portal/logo_footer_en_TD.png']";
    private static final String LO_TXT_GEM_FOOTER_DISCLAIMER_TD = "//p[text()='Global Excel Management provides Claims and Assistance Services for TD Life Insurance Company and TD Home and Auto Insurance Company.']";
    private static final String LO_TXT_WHICH_INSURANCE_INFORMATION_DO_I_NEED_TO_BRING_ON_MY_TRIP = "//div[contains(text(), 'Which insurance information do I need to bring on my trip?')]";
    private static final String LO_TXT_WHAT_SHOULD_I_DO_IF_I_HAVE_A_MEDICAL_EMERGECY_WHEN_TRAVELLING = "//div[contains(text(), 'What should I do if I have a medical emergency when I am travelling?')]";
    private static final String LO_TXT_WHAT_IF_I_CAN_NOT_CALL_YOU_RIGHT_AWAY = "//div[contains(text(), \"What if I can't call you right away?\")]";
    private static final String LO_TXT_IF_I_NEED_MEDICAL_ATTENTION_CAN_YOU_REFER_ME_TO_A_DOCTOR_OR_CLINIC = "//div[contains(text(), 'If I need medical attention, can you refer me to a doctor or clinic?')]";
    private static final String LO_TXT_WHAT_DOES_GEM_DO = "//div[contains(text(), 'What does Global Excel Management do? / Why has Global Excel Management reached out to me?')]";


    private static final String LO_TXT_WHAT_SHOULD_I_DO_IF_I_HAVE_A_MEDICAL_EMERGECY_WHEN_TRAVELLING_SUB_INFO = "//div[div[div[div[div[text()='What should I do if I have a medical emergency when I am travelling?']]]]]/following-sibling::div";
    private static final String LO_TXT_WHAT_IF_I_CAN_NOT_CALL_YOU_RIGHT_AWAY_SUB_INFO = "//div[div[div[div[div[text()=\"What if I can't call you right away?\"]]]]]/following-sibling::div";
    private static final String LO_TXT_IF_I_NEED_MEDICAL_ATTENTION_CAN_YOU_REFER_ME_TO_A_DOCTOR_OR_CLINIC_SUB_INFO = "//div[div[div[div[div[text()='If I need medical attention, can you refer me to a doctor or clinic?']]]]]/following-sibling::div";
    private static final String LO_TXT_WHAT_DOES_GEM_DO_SUB_INFO = "//div[div[div[div[div[text()='What does Global Excel Management do? / Why has Global Excel Management reached out to me?']]]]]/following-sibling::div";
    private static final String LO_TXT_WHAT_SHOULD_I_DO_IF_I_RECEIVE_BILLS_SUB_INFO = "//div[div[div[div[div[text()='What should I do if I receive bills?']]]]]/following-sibling::div";
    private static final String LO_TXT_HOW_CAN_I_CONTACT_YOU_ABOUT_MY_CLAIM_SUB_INFO = "//div[div[div[div[div[text()='How can I contact you about my claim?']]]]]/following-sibling::div";
    private static final String LO_TXT_WHAT_TO_DO_IF_I_HAVE_OUT_OF_POCKET_EXPENSES_SUB_INFO = "//div[div[div[div[div[text()='What should I do if I have out of pocket expenses?']]]]]/following-sibling::div";
    private static final String LO_TXT_DO_YOU_TAKE_ORIGINAL_OR_COPY_OF_DOCUMENTS_SUB_INFO = "//div[div[div[div[div[text()='Do I need to send you the original documents or do you accept copies?']]]]]/following-sibling::div";
    private static final String LO_TXT_CURRENCY_TO_BE_REIMBURSED_IN_SUB_INFO = "//div[div[div[div[div[text()='Which currency will I be reimbursed in?']]]]]/following-sibling::div";
    private static final String LO_TXT_WHAT_IS_YOUR_MAILING_ADDRESS_SUB_INFO = "//div[div[div[div[div[text()='What is your mailing address?']]]]]/following-sibling::div";
    private static final String LO_TXT_HOW_DO_I_SUBMIT_A_CLAIM_SUB_INFO = "//div[div[div[div[div[text()='How do I submit a claim?']]]]]/following-sibling::div";
    private static final String LO_TXT_HOW_WILL_I_KNOW_CLAIM_IS_SETTLED_SUB_INFO = "//div[div[div[div[div[text()='How will I know when my claim is settled?']]]]]/following-sibling::div";
    private static final String LO_TXT_HOW_LONG_WILL_IT_TAKE_MY_CLAIM_TO_BE_SETTLED_SUB_INFO = "//div[div[div[div[div[text()='How long will my claim take to be settled?']]]]]/following-sibling::div";
    private static final String LO_TXT_WHEN_WILL_I_RECEIVE_A_CLAIM_NUMBER_SUB_INFO = "//div[div[div[div[div[text()='When will I receive my claim number?']]]]]/following-sibling::div";
    private static final String LO_TXT_REIMBURSEMENT_PAID_USING_CREDIT_CARD_SUB_INFO = "//div[div[div[div[div[text()='How can I claim reimbursement for trips paid using Credit Card Reward/Travel points?']]]]]/following-sibling::div";
    private static final String LO_TXT_DIFFERENCE_BTN_T_AGENCY_AND_T_SUPPLIER_SUB_INFO = "//div[div[div[div[div[text()='What is the difference between a travel agency and a travel supplier?']]]]]/following-sibling::div";
    private static final String LO_TXT_WHY_IS_NECESSARY_TO_PROVIDE_CANCELLATION_INVOICE_SUB_INFO = "//div[div[div[div[div[text()='Why is it necessary for me to provide a cancellation invoice from the travel supplier if I have already cancelled my trip with the travel agent?']]]]]/following-sibling::div";
    private static final String LO_TXT_WHY_DO_I_NEED_TO_UPLOAD_GEM_MEDICAL_CERTIFICATE_SUB_INFO = "//div[div[div[div[div[text()=\"Why do I need to upload a GEM Medical Certificate instead of my doctor's note? / Why do I need to provide a GEM Medical Certificate when I have already submitted a doctor's note?\"]]]]]/following-sibling::div";
    private static final String LO_TXT_WHY_SUBMIT_A_GEM_MEDICAL_CERTIFICATE_FROM_MY_FAMILY_PHYSICIAN_SUB_INFO = "//div[div[div[div[div[text()='Why submit a Global Excel Management Medical Certificate from my family physician if I already provided one from my specialist?']]]]]/following-sibling::div";
    private static final String LO_TXT_WHY_DO_I_NEED_TO_SUBMIT_MY_CREDIT_CARD_OR_BANK_STATEMENT_SUB_INFO = "//div[div[div[div[div[text()='Why do I need to submit my credit card or bank statement(s)?']]]]]/following-sibling::div";
    private static final String LO_TXT_WHAT_TO_DO_IF_CANNOT_FIND_MY_BOOKING_INVOICE_SUB_INFO = "//div[div[div[div[div[text()='What should I do if I cannot find my booking invoice?']]]]]/following-sibling::div";
    private static final String LO_TXT_WHAT_TO_DO_IF_I_DO_NOT_HAVE_A_CANCELLATION_INVOICE_SUB_INFO = "//div[div[div[div[div[text()='What should I do if I do not have a cancellation invoice?']]]]]/following-sibling::div";
    private static final String LO_TXT_WHAT_DOCUMENT_FORMAT_AND_SIZE_DO_YOU_ACCEPT_FOR_UPLOAD_SUB_INFO = "//div[div[div[div[div[text()='What document format and size do you accept to be uploaded? ']]]]]/following-sibling::div";
    private static final String LO_TXT_WHAT_DO_I_NEED_TO_PROVIDE_RECEIPTS_FOR_MY_OUT_OF_POCKET_EXPESES_SUB_INFO = "//div[div[div[div[div[text()='Do I need to provide receipts for my out-of -pocket expenses?']]]]]/following-sibling::div";

    /**
     * Define the Page Object (PO) constructor.
     * @param driver The WebDriver object passed from the test method.
     */
    // [Note: Automation Engineer, rename this Page Object (PO) class to match the filename.]
    public PO_View_Claim_Status(WebDriver driver) {
        super(driver);
    }

    /**
     * Validates if current webpage is loaded and correct.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateOnPage() {
        String result = validateLocatorExists(LO_TXT_VIEW_CLAIM_STATUS_PAGE_VERIFY, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String validateNeedHelpHeading() {
        String result = validateLocatorExists(LO_TXT_NEED_HELP_HEADING, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String validateNeedHelpParagraph() {
        String result = validateLocatorExists(LO_TXT_NEED_HELP_PARAGRAPH, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String validateMessagingAssistanceIcon() {
        String result = validateLocatorExists(LO_IMG_MESSAGING_ASSISTANCE_ICON, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String validateFrequentlyAskedQuestionsTitle() {
        String result = validateLocatorExists(LO_TXT_FREQUENTLY_ASKED_QUESTIONS_TITLE, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String validateKnowWhenClaimSettledQuestion() {
        clickLocator(LO_TXT_HOW_WILL_KNOW_QUESTIONS_TITLE , FW_ConfigMgr.getDefaultTimeout());
        String result = validateLocatorExists(LO_TXT_HOW_WILL_KNOW_QUESTIONS_PARAGRAPH, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    

    public String validateHowLongWillTakeClaimToBeSettledQuestion() {
        clickLocator(LO_TXT_HOW_LONG_QUESTIONS_TITLE , FW_ConfigMgr.getDefaultTimeout());
        String result = validateLocatorExists(LO_TXT_HOW_LONG_QUESTIONS_PARAGRAPH, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String validateWhenWillIReivedMyClaimNumberQuestion() {
        clickLocator(LO_TXT_WHEN_WILL_I_RECEIVE_MY_CLAIM_NUMBER_QUESTIONS_TITLE , FW_ConfigMgr.getDefaultTimeout());
        String result = validateLocatorExists(LO_TXT_WHEN_WILL_I_RECEIVE_MY_CLAIM_NUMBER_QUESTIONS_PARAGRAPH, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String validateTop_Left_Logo_Light_Zurich() {
        String result = validateLocatorExists(LO_IMG_TOP_LOGO_LIGHT_ZURICH, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String clickViewAllFAQs() {
        String result = clickLocator(LO_BUT_FAQS, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String validateFrequentlyAskedQuestionsTitleCAPLetters() {
        String result = validateLocatorExists(LO_TXT_FREQUENTLY_ASKED_QUESTIONS_TITLE_CAP_LETTERS, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String validateTravelAndAssistance() {
        String result = clickLocator(LO_TXT_TRAVEL_AND_ASSISTANCE_VERIFY, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
     public String clickTravelAndAssistanceTitle() {
        String result = clickLocator(LO_TXT_TRAVEL_AND_ASSISTANCE_VERIFY, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String clickClaimingTab() {
        String result = clickLocator(LO_TXT_CLAIMING_TAB, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String clickClaimDocumentsTab() {
        String result = clickLocator(LO_TXT_CLAIM_DOCUMENTS_TAB, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String clickWhichInsuranceInformationDoINeedToBringOnMyTripQuestion() {
        String result = clickLocator(LO_TXT_WHICH_INSURANCE_INFORMATION_DO_I_NEED_TO_BRING_ON_MY_TRIP, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String clickWhatShouldIDoIfIHaveAMedicalEmergencyWhenIAmTravellingQuestion() {
        String result = clickLocator(LO_TXT_WHAT_SHOULD_I_DO_IF_I_HAVE_A_MEDICAL_EMERGECY_WHEN_TRAVELLING, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String clickWhatIfICannotCallYouRightAwayQuestion() {
        String result = clickLocator(LO_TXT_WHAT_IF_I_CAN_NOT_CALL_YOU_RIGHT_AWAY, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String clickIfINeedMedicalAttentionCanYouReferMeToADoctorOrClinicQuestion() {
        String result = clickLocator(LO_TXT_IF_I_NEED_MEDICAL_ATTENTION_CAN_YOU_REFER_ME_TO_A_DOCTOR_OR_CLINIC, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String clickWhatDoesGlobalExeclManagementDoQuestion() {
        String result = clickLocator(LO_TXT_WHAT_DOES_GEM_DO, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String clickWhatShouldIDoIfIReceiveBillsQuestion() {
        String result = clickLocator(LO_TXT_WHAT_SHOULD_I_DO_IF_I_RECEIVE_BILLS, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String clickHowCanIConctactYouAboutMyClaimQuestion() {
        String result = clickLocator(LO_TXT_HOW_CAN_I_CONTACT_YOU_ABOUT_MY_CLAIM, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String clickWhatShouldIDoIfIHaveOutOfPocketsExpensesQuestion() {
        String result = clickLocator(LO_TXT_WHAT_TO_DO_IF_I_HAVE_OUT_OF_POCKET_EXPENSES, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String clicKDoYouAcceptOriginalOrCopyOfDocumentsQuestion() {
        String result = clickLocator(LO_TXT_DO_YOU_TAKE_ORIGINAL_OR_COPY_OF_DOCUMENTS, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String clickCurrecyToBeReimbursedInQuestion() {
        String result = clickLocator(LO_TXT_CURRENCY_TO_BE_REIMBURSED_IN, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String clickWhatIsYourMailingAddressQuestion() {
        String result = clickLocator(LO_TXT_WHAT_IS_YOUR_MAILING_ADDRESS, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String clickHowDoISubmitAClaimQuestion() {
        String result = clickLocator(LO_TXT_HOW_DO_I_SUBMIT_A_CLAIM, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String clickHowWillIKnowWhenMyClaimIsSettledQuestion() {
        String result = clickLocator(LO_TXT_HOW_WILL_I_KNOW_CLAIM_IS_SETTLED, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String clickHowLongWillItTakeMyClaimToBeSettledMyClaimIsSettledQuestion() {
        String result = clickLocator(LO_TXT_HOW_LONG_WILL_IT_TAKE_MY_CLAIM_TO_BE_SETTLED, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String clickWhenWillIReceiveMyClaimNumberQuestion() {
        String result = clickLocator(LO_TXT_WHEN_WILL_I_RECEIVE_A_CLAIM_NUMBER, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String clickReimbursemntForTripPaidUsingCreditCardQuestion() {
        String result = clickLocator(LO_TXT_REIMBURSEMENT_PAID_USING_CREDIT_CARD, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String clickDifferenceBetweenTravelAgectAndTravelSupplierQuestion() {
        String result = clickLocator(LO_TXT_DIFFERENCE_BTN_T_AGENCY_AND_T_SUPPLIER, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String clickWhyIsItNessessaryToProvideACancellaionInvoiceQuestion() {
        String result = clickLocator(LO_TXT_WHY_IS_NECESSARY_TO_PROVIDE_CANCELLATION_INVOICE, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String clickWhyDoINeedToUploadGEMmedecalCertificateQuestion() {
        String result = clickLocator(LO_TXT_WHY_DO_I_NEED_TO_UPLOAD_GEM_MEDICAL_CERTIFICATE, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String clickWhySubmitAGemMedicalCertificateFromMyFamilyPhysicianQuestion() {
        String result = clickLocator(LO_TXT_WHY_SUBMIT_A_GEM_MEDICAL_CERTIFICATE_FROM_MY_FAMILY_PHYSICIAN, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String clickWhyDoINeedToSubmitMyCreditCardOrBankStatementQuestion() {
        String result = clickLocator(LO_TXT_WHY_DO_I_NEED_TO_SUBMIT_MY_CREDIT_CARD_OR_BANK_STATEMENT, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String clickWhyShouldIDoIfICannotFindMyBookingInvoiceQuestion() {
        String result = clickLocator(LO_TXT_WHAT_TO_DO_IF_CANNOT_FIND_MY_BOOKING_INVOICE, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String clickWhyShouldIDoIfIDoNotHaveACancellationInvoiceQuestion() {
        String result = clickLocator(LO_TXT_WHAT_TO_DO_IF_I_DO_NOT_HAVE_A_CANCELLATION_INVOICE, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String clickWhatDocumentFormatAndSizeDoYouAcceptToBeUploadedInvoiceQuestion() {
        String result = clickLocator(LO_TXT_WHAT_DOCUMENT_FORMAT_AND_SIZE_DO_YOU_ACCEPT_FOR_UPLOAD, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String clickWhatDoINeedToProvideReceiptsForMyOutOfPocketExpensesQuestion() {
        String result = clickLocator(LO_TXT_WHAT_DO_I_NEED_TO_PROVIDE_RECEIPTS_FOR_MY_OUT_OF_POCKET_EXPESES, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String validateTravelAndAssistance1stQuestionSubInfo1(String txt) {
        String result = validateWithinLocatorText(LO_TXT_WHICH_INSURANCE_INFORMATION_DO_I_NEED_TO_BRING_ON_MY_TRIP_SUB_INFO,txt,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String validateTravelAndAssistance2stQuestionSubInfo1(String txt) {
        String result = validateWithinLocatorText(LO_TXT_WHAT_SHOULD_I_DO_IF_I_HAVE_A_MEDICAL_EMERGECY_WHEN_TRAVELLING_SUB_INFO,txt,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String validateTravelAndAssistance3stQuestionSubInfo1(String txt) {
        String result = validateWithinLocatorText(LO_TXT_WHAT_IF_I_CAN_NOT_CALL_YOU_RIGHT_AWAY_SUB_INFO,txt,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String validateTravelAndAssistance4stQuestionSubInfo1(String txt) {
        String result = validateWithinLocatorText(LO_TXT_IF_I_NEED_MEDICAL_ATTENTION_CAN_YOU_REFER_ME_TO_A_DOCTOR_OR_CLINIC_SUB_INFO,txt,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String validateTravelAndAssistance5stQuestionSubInfo1(String txt) {
        String result = validateWithinLocatorText(LO_TXT_WHAT_DOES_GEM_DO_SUB_INFO,txt,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String validateClaiming1stQuestionSubInfo(String txt) {
        String result = validateWithinLocatorText(LO_TXT_WHAT_SHOULD_I_DO_IF_I_RECEIVE_BILLS_SUB_INFO,txt,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String validateClaiming2stQuestionSubInfo(String txt) {
        String result = validateWithinLocatorText(LO_TXT_HOW_CAN_I_CONTACT_YOU_ABOUT_MY_CLAIM_SUB_INFO,txt,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String validateClaiming3stQuestionSubInfo(String txt) {
        String result = validateWithinLocatorText(LO_TXT_WHAT_TO_DO_IF_I_HAVE_OUT_OF_POCKET_EXPENSES_SUB_INFO,txt,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String validateClaiming4stQuestionSubInfo(String txt) {
        String result = validateWithinLocatorText(LO_TXT_DO_YOU_TAKE_ORIGINAL_OR_COPY_OF_DOCUMENTS_SUB_INFO,txt,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String validateClaiming5stQuestionSubInfo(String txt) {
        String result = validateWithinLocatorText(LO_TXT_CURRENCY_TO_BE_REIMBURSED_IN_SUB_INFO,txt,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String validateClaiming6stQuestionSubInfo(String txt) {
        String result = validateWithinLocatorText(LO_TXT_WHAT_IS_YOUR_MAILING_ADDRESS_SUB_INFO,txt,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String validateClaiming7stQuestionSubInfo(String txt) {
        String result = validateWithinLocatorText(LO_TXT_HOW_DO_I_SUBMIT_A_CLAIM_SUB_INFO,txt,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String validateClaiming8stQuestionSubInfo(String txt) {
        String result = validateWithinLocatorText(LO_TXT_HOW_WILL_I_KNOW_CLAIM_IS_SETTLED_SUB_INFO,txt,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String validateClaiming9stQuestionSubInfo(String txt) {
        String result = validateWithinLocatorText(LO_TXT_HOW_LONG_WILL_IT_TAKE_MY_CLAIM_TO_BE_SETTLED_SUB_INFO,txt,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String validateClaiming10stQuestionSubInfo(String txt) {
        String result = validateWithinLocatorText(LO_TXT_WHEN_WILL_I_RECEIVE_A_CLAIM_NUMBER_SUB_INFO,txt,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String validateClaiming11stQuestionSubInfo(String txt) {
        String result = validateWithinLocatorText(LO_TXT_REIMBURSEMENT_PAID_USING_CREDIT_CARD_SUB_INFO,txt,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String validateClaimingDocuments1stQuestionSubInfo(String txt) {
        String result = validateWithinLocatorText(LO_TXT_DIFFERENCE_BTN_T_AGENCY_AND_T_SUPPLIER_SUB_INFO,txt,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String validateClaimingDocuments2stQuestionSubInfo(String txt) {
        String result = validateWithinLocatorText(LO_TXT_WHY_IS_NECESSARY_TO_PROVIDE_CANCELLATION_INVOICE_SUB_INFO,txt,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String validateClaimingDocuments3stQuestionSubInfo(String txt) {
        String result = validateWithinLocatorText(LO_TXT_WHY_DO_I_NEED_TO_UPLOAD_GEM_MEDICAL_CERTIFICATE_SUB_INFO,txt,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String validateClaimingDocuments4stQuestionSubInfo(String txt) {
        String result = validateWithinLocatorText(LO_TXT_WHY_SUBMIT_A_GEM_MEDICAL_CERTIFICATE_FROM_MY_FAMILY_PHYSICIAN_SUB_INFO,txt,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String validateClaimingDocuments5stQuestionSubInfo(String txt) {
        String result = validateWithinLocatorText(LO_TXT_WHY_DO_I_NEED_TO_SUBMIT_MY_CREDIT_CARD_OR_BANK_STATEMENT_SUB_INFO,txt,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String validateClaimingDocuments6stQuestionSubInfo(String txt) {
        String result = validateWithinLocatorText(LO_TXT_WHAT_TO_DO_IF_CANNOT_FIND_MY_BOOKING_INVOICE_SUB_INFO,txt,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String validateClaimingDocuments7stQuestionSubInfo(String txt) {
        String result = validateWithinLocatorText(LO_TXT_WHAT_TO_DO_IF_I_DO_NOT_HAVE_A_CANCELLATION_INVOICE_SUB_INFO,txt,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String validateClaimingDocuments8stQuestionSubInfo(String txt) {
        String result = validateWithinLocatorText(LO_TXT_WHAT_DOCUMENT_FORMAT_AND_SIZE_DO_YOU_ACCEPT_FOR_UPLOAD_SUB_INFO,txt,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String validateClaimingDocuments9stQuestionSubInfo(String txt) {
        String result = validateWithinLocatorText(LO_TXT_WHAT_DO_I_NEED_TO_PROVIDE_RECEIPTS_FOR_MY_OUT_OF_POCKET_EXPESES_SUB_INFO,txt,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String validateTravelAndAssistance1stQuestionSubInfo(String txt) {
        String result = validateWithinLocatorText(LO_TXT_TRAVEL_AND_ASSISTANCE_VERIFY_SUB_INFO,txt,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String validateTravelAndAssistance2ndQuestionSubInfo(String txt) {
        String result = validateWithinLocatorText(LO_TXT_DID_NOT_RECEIVE_ONE_TIME_VERIFICATION_CODE_SUB_INFO,txt,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String validateTechnicalSupport3rdQuestionSubInfo(String txt) {
        String result = validateWithinLocatorText(LO_TXT_ONE_TIME_VERIFICATION_CODE_RECEIVED_NOT_WORKING_SUB_INFO,txt,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String validateTechnicalSupport4thQuestionSubInfo(String txt) {
        String result = validateWithinLocatorText(LO_TXT_MOBILE_PHONE_VERIFICATION_FAILS_SUB_INFO,txt,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String validateTechnicalSupport5thQuestionSubInfo(String txt) {
        String result = validateWithinLocatorText(LO_TXT_DO_I_NEED_MOBILE_PHONE_TO_RECEIVE_ONE_TIME_VC_SUB_INFO,txt,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String validateTechnicalSupport6thQuestionSubInfo(String txt) {
        String result = validateWithinLocatorText(LO_TXT_WHAT_CAN_I_DO_IF_I_NO_LONGER_HAVE_ACCESS_TO_MY_PHONE_SUB_INFO,txt,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String validateTechnicalSupport7thQuestionSubInfo(String txt) {
        String result = validateWithinLocatorText(LO_TXT_TO_WHICH_MOBILE_PHONE_THE_ONE_TIME_VC_SENT_SUB_INFO,txt,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String validateTechnicalSupport8thQuestionSubInfo(String txt) {
        String result = validateWithinLocatorText(LO_TXT_HOW_LONG_DOES_IT_TAKE_TO_RECEIVE_THE_ONE_TIME_VC_SUB_INFO,txt,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String validateTechnicalSupport9thQuestionSubInfo(String txt) {
        String result = validateWithinLocatorText(LO_TXT_DO_I_NEED_TO_ENTER_A_VC_EACH_TIME_I_ACCESS_MY_CLAIM_SUB_INFO,txt,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String validateTechnicalSupport10thQuestionSubInfo(String txt) {
        String result = validateWithinLocatorText(LO_TXT_CAN_I_RECEIVE_THE_ONE_TIME_VERIFICATION_CODE_BY_EMAIL_SUB_INFO,txt,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String validateTechnicalSupport11thQuestionSubInfo(String txt) {
        String result = validateWithinLocatorText(LO_TXT_WILL_I_INCUR_CHARGES_FOR_RECEIVING_THE_VERIFICATION_CODE_SUB_INFO,txt,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String validateTechnicalSupport12thQuestionSubInfo(String txt) {
        String result = validateWithinLocatorText(LO_TXT_CAN_I_USE_AN_INTERNATIONAL_MOBILE_PHONE_TO_AUTHENTICATE_SUB_INFO,txt,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String validateTechnicalSupport13thQuestionSubInfo(String txt) {
        String result = validateWithinLocatorText(LO_TXT_CAN_I_REPLY_TO_THE_NUMBER_THAT_SENDS_THE_ONE_TIME_VC_SUB_INFO,txt,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }


    public String validateWhichInsuranceInfoQuestion() {
        String result = clickLocator(LO_TXT_WHICH_INSURANCE_INFO_DO_I_NEED, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String clickClaimingTitle() {
        String result = clickLocator(LO_TXT_CLAIMING, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String validateWhatShouldIdoIfIreceiveBillsQuestion() {
        String result = validateLocatorExists(LO_TXT_WHAT_SHOULD_I_DO_IF_I_RECEIVE_BILLS , FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String clickHowCanIRetrieveADraftClaimQuestion() {
        String result = clickLocator(LO_TXT_HOW_CAN_I_RETRIEVE_A_DRAFT_CLAIM, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String clickDidNotReceiveOneTimeVerificationCodeQuestion() {
        String result = clickLocator(LO_TXT_I_DID_NOT_RECEIVE_THE_ONE_TIME_VERIFICATION_CODE, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String clickOneTimeVerificationCodeReceivedNotWorkingQuestion() {
        String result = clickLocator(LO_TXT_ONE_TIME_VERIFICATION_CODE_RECEIVED_NOT_WORKING, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String clickWhatShouldIDoIfMobilePhoneVerificationFailsQuestion() {
        String result = clickLocator(LO_TXT_WHAT_TO_DO_IF_MOBILE_PHONE_VERIFICATION_FAILS, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String clickWhatCanIDoIfINoLongerHaveAccessToMyPhoneQuestion() {
        String result = clickLocator(LO_TXT_WHAT_CAN_I_DO_IF_I_NO_LONGER_HAVE_ACCESS_TO_MY_PHONE, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String clickToWhichMobilePhoneIsTheOneTimeVCSentQuestion() {
        String result = clickLocator(LO_TXT_TO_WHICH_MOBILE_PHONE_THE_ONE_TIME_VC_SENT, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String clickHowLongDoesItTakeToReceiveTheOneTimeVCQuestion() {
        String result = clickLocator(LO_TXT_HOW_LONG_DOES_IT_TAKE_TO_RECEIVE_THE_ONE_TIME_VC, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String clickDoINeedToEnterAVerificationCodeEachTimeIAccessMyClaimQuestion() {
        String result = clickLocator(LO_TXT_DO_I_NEED_TO_ENTER_A_VC_EACH_TIME_I_ACCESS_MY_CLAIM, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String clickCanIReceiveTheOneTimeVCByEmailQuestion() {
        String result = clickLocator(LO_TXT_CAN_I_RECEIVE_THE_ONE_TIME_VERIFICATION_CODE_BY_EMAIL, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String clickWillIIncurChargesForReceivingTheVerificationCodeQuestion() {
        String result = clickLocator(LO_TXT_WILL_I_INCUR_CHARGES_FOR_RECEIVING_THE_VERIFICATION_CODE, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String clickCanIUseAnInternationalMobilePhoneToAuthenticateQuestion() {
        String result = clickLocator(LO_TXT_CAN_I_USE_AN_INTERNATIONAL_MOBILE_PHONE_TO_AUTHENTICATE, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String clickCanIReplyToTheNumberThatSendstheOneTimeVCQuestion() {
        String result = clickLocator(LO_TXT_CAN_I_REPLY_TO_THE_NUMBER_THAT_SENDS_THE_ONE_TIME_VC, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String clickDoINeedAMobilePhoneToReceiveTheOneTimeVerificationCodeQuestion() {
        String result = clickLocator(LO_TXT_DO_I_NEED_MOBILE_PHONE_TO_RECEIVE_ONE_TIME_VC, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String clickTechnicalSupportTitle() {
        String result = clickLocator(LO_TXT_TECHNICAL_SUPPORT, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String validateHowCanIRetrieveADraftClaimQuestion() {
        String result = validateLocatorExists(LO_TXT_HOW_CAN_I_RETRIEVE_A_DRAFT_CLAIM , FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if Gem top logo is present and it's a link.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String validateGem_Top_Left_Logo_CIBC() {
        String result = validateLocatorExists(LO_IMG_GEM_TOP_LOGO_CIBC, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if the claim number input field exists.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateclaimNumberInputFieldExists() {
        String result = validateLocatorExists(LO_EDT_CLAIM_NUMBER_INPUT_FIELD, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if the BACK button exists.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateBackButtonExists() {
        String result = validateLocatorExists(LO_BUT_BACK, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if the Help Centre at top right is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String validateHelpCentreHeader_Dark() {
        String result = validateLocatorExists(LO_LNK_HELP_CENTRE_TOP_DARK, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if Frech link with its globe icon exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateFrenchToggle_Dark() {
        String result = validateLocatorExists(LO_LNK_FRENCH_TOGGLE_FR_DARK, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result; 
    }

    /**
     * Enter invalid Claim Number with 4 digits.
     * 
     * @param claimNumber The six digits to be entered for the credit card.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String enterClaimNumber(String claimNumber) {
        String result = setText(LO_EDT_CLAIM_NUMBER_FIELD, claimNumber, FW_ConfigMgr.getDefaultTimeout(), false);
        clickLocator(LO_TXT_CLAIM_NUMBER_LABEL , FW_ConfigMgr.getDefaultTimeout());
        waitForDuration(15, "s", false); // Wait to perform next check
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if the error message "Please enter a valid Global Excel claim number or Intent ID" is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateValidGlobalExcelNumberErrorPresent(String errorMessage) {
        String result = validateWithinLocatorText(LO_TXT_ERROR_VALID_GLOBAL_EXCEL_NUMBER,errorMessage,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if the error message "Claim not found. Please ensure that you have entered the claim number correctly and try again." is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateClaimNotFoundErrorPresent(String errorMessage) {
        String result = validateWithinLocatorText(LO_TXT_ERROR_CLAIM_NOT_FOUND,errorMessage,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String validateClaimNotFoundErrorPresentZurichSunlife(String errorMessage) {
        String result = validateWithinLocatorText(LO_TXT_ERROR_CLAIM_NOT_FOUND_ZURICH_SUNLIFE,errorMessage,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if the error message "Claim not found. Please ensure that you have entered the claim number correctly and try again." is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateClaimNotFoundErrorPresent2(String errorMessage) {
        String result = validateWithinLocatorText(LO_TXT_ERROR_CLAIM_NOT_FOUND_2,errorMessage,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if the error message "Claim not found. Please ensure that you have entered the claim number correctly and try again." is not present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateClaimNotFoundErrorNotPresent(String errorMessage) {
        String result = validateNotWithinLocatorText(LO_TXT_ERROR_CLAIM_NOT_FOUND,errorMessage,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if the error message "Please enter a valid Global Excel claim number or Intent ID" is not present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateValidGlobalExcelNumberErrorNotPresent(String errorMessage) {
        String result = validateNotWithinLocatorText(LO_TXT_ERROR_VALID_GLOBAL_EXCEL_NUMBER,errorMessage,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Clear the existing value in the claim number input field by setting it to an empty string before entering a new value.
     * 
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String clearOutTheClaimNumberInputField(){
        String result = setText(LO_EDT_CLAIM_NUMBER_FIELD, "", FW_ConfigMgr.getDefaultTimeout() , true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    };

    /**
     * Clicks the 'Back' button.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String clickBackButton() {
        String result = clickLocator(LO_BUT_BACK, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String clickVisitOurHelpCentre() {
        String result = clickLocator(LO_BUT_VISIT_OUR_HELP_CENTRE, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Clicks the 'VIEW STATUS' button.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String clickViewStatusButton() {
        String result = clickLocator(LO_BUT_VIEW_STATUS, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String applyWait() {
        waitForDuration(8, "s", true);
        String result = "[Pass] - Wait applied.";
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if Gem top logo is present and it's a link.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String validateGem_Top_Left_Logo() {
        String result = validateLocatorExists(LO_IMG_GEM_TOP_LOGO, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if Gem top logo is present and it's a link.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String validateGem_Top_Left_Logo_BCAA() {
        String result = validateLocatorExists(LO_IMG_GEM_TOP_LOGO_BCAA, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if the Help Centre at top right is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String validateHelpCentreHeader() {
        String result = validateLocatorExists(LO_LNK_HELP_CENTRE_TOP, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if Gem top logo is present and it's a link.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String validateGem_Top_Left_Logo_TD() {
        String result = validateLocatorExists(LO_IMG_GEM_TOP_LOGO_TD, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if Gem top logo is present and it's a link.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String validateGem_Top_Left_Logo_SunLife() {
        String result = validateLocatorExists(LO_IMG_GEM_TOP_LOGO_SUNLIFE, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if Gem top logo is present and it's a link.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String validateGem_Top_Left_Logo_SCOTIA() {
        String result = validateLocatorExists(LO_IMG_GEM_TOP_LOGO_SCOTIA, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if Gem top logo is present and it's a link.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String validateGem_Top_Left_Logo_ORION() {
        String result = validateLocatorExists(LO_IMG_GEM_TOP_LOGO_ORION, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if Gem top logo is present and it's a link.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String validateGem_Top_Left_Logo_MGB() {
        String result = validateLocatorExists(LO_IMG_GEM_TOP_LOGO_MGB, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if Gem top logo is present and it's a link.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String validateGem_Top_Left_Logo_Manulife() {
        String result = validateLocatorExists(LO_IMG_GEM_TOP_LOGO_MANULIFE, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if Gem bottom logo is present and it's not a link.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String validateGemBottom_Left_Logo_GEM_MGB() {
        String result = validateLocatorExists(LO_IMG_GEM_BOTTOM_LOGO_GEM_MGB, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if Gem bottom logo is present and it's not a link.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String validateGemBottom_Left_Logo_MANULIFE_MGB() {
        String result = validateLocatorExists(LO_IMG_GEM_BOTTOM_LOGO_MANULIFE_MGB, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if Frech link with its globe icon exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateFrenchToggle() {
        String result = validateLocatorExists(LO_LNK_FRENCH_TOGGLE_FR, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result; 
    }

    /**
     * Validates if current webpage is loaded and correct.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String validateOnPageCIBC() {
        // waitForDuration(5, "s", false); // Wait to perform next check
        String result = validateLocatorExists(LO_HOME_PAGE_VERIFY_CIBC, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if current webpage is loaded and correct.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String validateOnPageAMEX() {
        String result = validateLocatorExists(LO_TXT_AMEX_HOME_PAGE_VERIFY, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if the page main heading paragraph is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String validateMainHeadingParagraph() {
        String result = validateLocatorExists(LO_TXT_MAIN_HEADING_PARAGRAPH, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    /**
     * Validates if the paragraph for the veiw claim status heading is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String validateViewClaimParagraph() {
        String result = validateLocatorExists(LO_TXT_VIEW_CLAIM_STATUS_PARAGRAPH, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

     /**
     * Validates if the Claim Number filed is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String validateClaimNumberField() {
        String result = validateLocatorExists(LO_EDT_CLAIM_NUMBER_INPUT_FIELD, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if the VIEW STATUS button is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String validateViewStatusButton() {
        String claimNumber="1234567";
        setText(LO_EDT_CLAIM_NUMBER_FIELD, claimNumber, FW_ConfigMgr.getDefaultTimeout(), false);
        clickLocator("//label[contains(text(), 'Claim Number')]", FW_ConfigMgr.getDefaultTimeout());
        //waitForDuration(5,"s",true);
        String result = validateLocatorExists(LO_BUT_VIEW_STATUS, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if Gem bottom logo is present and it's not a link.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String validateGemBottom_Left_Logo_Light_Gem() {
        String result = validateLocatorExists(LO_IMG_GEM_BOTTOM_LOGO_LIGHT_GEM, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if Gem bottom logo is present and it's not a link.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String validateGemBottom_Left_Logo_Plain() {
        String result = validateLocatorExists(LO_IMG_GEM_BOTTOM_LOGO_PLAIN, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if Gem top logo is present and it's a link.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String validateGem_Top_Left_Logo_Intact() {
        String result = validateLocatorExists(LO_IMG_GEM_TOP_LOGO_INTACT, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }


    /**
     * Validates if Gem bottom logo is present and it's not a link.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String validateGemBottom_Left_Logo_CL() {
        String result = validateLocatorExists(LO_IMG_GEM_BOTTOM_LOGO_CL, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if Gem bottom logo is present and it's not a link.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String validateGemBottom_Left_Logo_Scotia() {
        String result = validateLocatorExists(LO_IMG_GEM_BOTTOM_LOGO_SCOTIA, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

     /**
     * Validates if Gem bottom logo is present and it's not a link.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String validateGemBottom_Left_Logo_Dark_Gem() {
        String result = validateLocatorExists(LO_IMG_GEM_BOTTOM_LOGO_DARK_GEM, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if Gem bottom logo is present and it's not a link.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String validateGemBottom_Left_Logo_SunLife() {
        String result = validateLocatorExists(LO_IMG_GEM_BOTTOM_LOGO_SUNLIFE, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if The "START A NEW CLAIM" link in the footer of the page is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String validateStartNewClaimFooterLink_LightBackground() {
        String result = validateLocatorExists(LO_LNK_START_NEW_CLAIM_FOOTER_LIGHT, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if Gem bottom logo is present and it's not a link.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String validateGemBottom_Left_Logo_TD() {
        String result = validateLocatorExists(LO_IMG_GEM_BOTTOM_LOGO_TD, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if Gem bottom logo is present and it's not a link.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String validateGemBottom_Left_Logo_ORION() {
        String result = validateLocatorExists(LO_IMG_GEM_BOTTOM_LOGO_ORION, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if the 'View Status' exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String validateViewStatus() {
        String result = validateLocatorExists(LO_BUT_VIEW_STATUS, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if Gem bottom logo is present and it's not a link.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String validateGemBottom_Left_Logo() {
        String result = validateLocatorExists(LO_IMG_GEM_BOTTOM_LOGO_DARK, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if Gem bottom logo is present and it's not a link.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String validateGemBottom_Left_Logo_BCAA() {
        String result = validateLocatorExists(LO_IMG_GEM_BOTTOM_LOGO_BCAA, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if The "START A NEW CLAIM" link in the footer of the page is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String validateStartNewClaimFooterLink() {
        String result = validateLocatorExists(LO_LNK_START_NEW_CLAIM_FOOTER, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if Gem bottom logo is present and it's not a link.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String validateGemBottom_Left_Logo_Manulife() {
        String result = validateLocatorExists(LO_IMG_GEM_BOTTOM_LOGO_MANULIFE, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if Gem bottom logo is present and it's not a link.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String validateGemBottom_Left_Logo_Intact() {
        String result = validateLocatorExists(LO_IMG_GEM_BOTTOM_LOGO_INTACT, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if The "CONTINUE DRAFT CLAIM" link in the footer of the page is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String validateContinueDraftClaimFooterLink() {
        String result = validateLocatorExists(LO_LNK_CONTINUE_DRAFT_CLAIM_FOOTER, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if The "SUBMIT DOCUMENTS" link in the footer of the page is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String validateSubmitDocumentsFooterLink() {
        String result = validateLocatorExists(LO_LNK_SUBMIT_DOCUMENTS_FOOTER, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if The "SUBMIT DOCUMENTS" link in the footer of the page is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String validateSubmitDocumentsFooterLink_LightBackground() {
        String result = validateLocatorExists(LO_LNK_SUBMIT_DOCUMENTS_FOOTER_LIGHT, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if the Help Centre at bottom right is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String validateHelpCentreFooterLink_Light() {
        String result = validateLocatorExists(LO_LNK_HELP_CENTRE_BOTTOM_LIGHT, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if The "CONTINUE DRAFT CLAIM" link in the footer of the page is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String validateContinueDraftClaimFooterLink_LightBackground() {
        String result = validateLocatorExists(LO_LNK_CONTINUE_DRAFT_CLAIM_FOOTER_LIGHT, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if the Help Centre at bottom right is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String validateHelpCentreFooterLink() {
        String result = validateLocatorExists(LO_LNK_HELP_CENTRE_BOTTOM, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if the "MEDICAL EMERGENCY HELPLINE" Heading is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String validateMedicalEmergencyHelpLineHeading() {
        String result = validateLocatorExists(LO_TXT_MEDICAL_EMERGENCY_HELPLINE_HEADING, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if the "MEDICAL EMERGENCY HELPLINE" Non Toll Free Number is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String validateMedicalEmergencyHelpLineNonTollFree(String number) {
        LO_TXT_MEDICAL_EMERGENCY_HELPLINE_NON_TOLL_FREE = LO_TXT_MEDICAL_EMERGENCY_HELPLINE_NON_TOLL_FREE + "'" + number + "']";
        String result = validateLocatorExists(LO_TXT_MEDICAL_EMERGENCY_HELPLINE_NON_TOLL_FREE, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if the "MEDICAL EMERGENCY HELPLINE" Toll free Number is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String validateMedicalEmergencyHelpLineTollFree(String tollFreeNumber) {
        LO_TXT_MEDICAL_EMERGENCY_HELPLINE_TOLL_FREE = LO_TXT_MEDICAL_EMERGENCY_HELPLINE_TOLL_FREE + "'" + tollFreeNumber + "']";
        String result = validateLocatorExists(LO_TXT_MEDICAL_EMERGENCY_HELPLINE_TOLL_FREE, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if the "FOLLOW UP ON YOUR CLAIM" Heading is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String validateFollowUpOnYourClaimFooterHeading() {
        String result = validateLocatorExists(LO_TXT_FOLLOW_UP_ON_YOUR_CLAIM_HEADING, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if the "FOLLOW UP ON YOUR CLAIM" paragraph is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String validateFollowUpOnYourClaimFooterParagraph() {
        String result = validateLocatorExists(LO_TXT_FOLLOW_UP_ON_YOUR_CLAIM_PARAGRAPH, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if the 'Sign In' exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String validateSignIn() {
        String result = validateLocatorExists(LO_BUT_SIGN_IN, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if the GEM FOOTER DISCLAIMER is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String validateFooterDisclaimer2() {
        String result = validateLocatorExists(LO_TXT_GEM_FOOTER_DISCLAIMER_2, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if the GEM FOOTER DISCLAIMER is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String validateFooterDisclaimer_CL() {
        String result = validateLocatorExists(LO_TXT_GEM_FOOTER_DISCLAIMER_CL, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if the GEM FOOTER DISCLAIMER is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String validateFooterDisclaimer() {
        String result = validateLocatorExists(LO_TXT_GEM_FOOTER_DISCLAIMER, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if the Trade Mark Notice is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String validateFooterTradeMarkNotice() {
        String result = validateLocatorExists(LO_TXT_TRADE_MARK_NOTICE, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if the GEM FOOTER DISCLAIMER is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String validateFooterDisclaimer_SunLife() {
        String result = validateLocatorExists(LO_TXT_GEM_FOOTER_DISCLAIMER_SUNLIFE, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if the GEM FOOTER DISCLAIMER is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String validateFooterDisclaimerTD() {
        String result = validateLocatorExists(LO_TXT_GEM_FOOTER_DISCLAIMER_TD, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if the GEM FOOTER DISCLAIMER is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String validateFooterDisclaimer_Orion() {
        String result = validateLocatorExists(LO_TXT_GEM_FOOTER_DISCLAIMER_ORION, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if the GEM FOOTER DISCLAIMER is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String validateFooterDisclaimer_MGB() {
        String result = validateLocatorExists(LO_TXT_GEM_FOOTER_DISCLAIMER_MGB, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if the GEM FOOTER DISCLAIMER is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String validateFooterDisclaimerManulife() {
        String result = validateLocatorExists(LO_TXT_GEM_FOOTER_DISCLAIMER_MANULIFE, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if the Copy Right Notice is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String validateFooterCopyRightNotice() {
        String result = validateLocatorExists(LO_TXT_COPY_RIGHT_NOTICE, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    /**
     * Validates if the GEM FOOTER DISCLAIMER is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String validateFooterDisclaimerBCAA() {
        String result = validateLocatorExists(LO_TXT_GEM_FOOTER_DISCLAIMER_BCAA, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if the Copy Right Notice is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String validateFooterCopyRightNotice_2025() {
        String result = validateLocatorExists(LO_TXT_COPY_RIGHT_NOTICE_2025, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    /**
     * Validates if the Privacy Statement link is present with a go to icon.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String validateFooterPrivacyStatement() {
        String result = validateLocatorExists(LO_LNK_PRIVACY_STATEMENT, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if the Conditions of Use link is present with a go to icon.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String validateFooterConditionsOfUse_LightBackground() {
        String result = validateLocatorExists(LO_LNK_CONDITIONS_OF_USE_LIGHT, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if the "MEDICAL EMERGENCY HELPLINE" Heading is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String validateMedicalEmergencyHelpLineHeading_LightBackgroundNoCallIcon() {
        String result = validateLocatorExists(LO_TXT_MEDICAL_EMERGENCY_HELPLINE_HEADING_NO_CALL_ICON, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if the "MEDICAL EMERGENCY HELPLINE" Heading is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String validateMedicalEmergencyHelpLineParagraph_LightBackground_CommercialSVBC() {
        String result = validateLocatorExists(LO_TXT_MEDICAL_EMERGENCY_HELPLINE_PARAGRAPH_LIGHT_CSVBC, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    /**
     * Validates if the "MEDICAL EMERGENCY HELPLINE" Heading is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String validateMedicalEmergencyHelpLineParagraph_LightBackground_ConsumerSBC() {
        String result = validateLocatorExists(LO_TXT_MEDICAL_EMERGENCY_HELPLINE_PARAGRAPH_LIGHT_CSBC, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if the "MEDICAL EMERGENCY HELPLINE" Non Toll Free Number is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String validateMedicalEmergencyHelpLineNonTollFree2(String number) {
        LO_TXT_MEDICAL_EMERGENCY_HELPLINE_NON_TOLL_FREE2 = LO_TXT_MEDICAL_EMERGENCY_HELPLINE_NON_TOLL_FREE2 + "'" + number + "']";
        String result = validateLocatorExists(LO_TXT_MEDICAL_EMERGENCY_HELPLINE_NON_TOLL_FREE2, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if the "MEDICAL EMERGENCY HELPLINE" Toll free Number is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String validateMedicalEmergencyHelpLineTollFree2(String tollFreeNumber) {
        LO_TXT_MEDICAL_EMERGENCY_HELPLINE_TOLL_FREE2 = LO_TXT_MEDICAL_EMERGENCY_HELPLINE_TOLL_FREE2 + "'" + tollFreeNumber + "']";
        String result = validateLocatorExists(LO_TXT_MEDICAL_EMERGENCY_HELPLINE_TOLL_FREE2, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if the "MEDICAL EMERGENCY HELPLINE" Heading is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String validateMedicalEmergencyHelpLineHeading_LightBackground() {
        String result = validateLocatorExists(LO_TXT_MEDICAL_EMERGENCY_HELPLINE_HEADING_LIGHT, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if the Privacy Statement link is present with a go to icon.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String validateFooterPrivacyStatement_LightBackground() {
        String result = validateLocatorExists(LO_LNK_PRIVACY_STATEMENT_LIGHT, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if the Conditions of Use link is present with a go to icon.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String validateFooterConditionsOfUse() {
        String result = validateLocatorExists(LO_LNK_CONDITIONS_OF_USE, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if Gem top logo is present and it's a link.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String validateGem_Top_Left_Logo_Amex() {
        String result = validateLocatorExists(LO_IMG_GEM_TOP_LOGO_AMEX, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

}
