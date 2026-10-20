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
    private static final String LO_EDT_CLAIM_NUMBER_INPUT_FIELD = "//div[label[contains(text(), 'Claim Reference Number')]]/following-sibling::div//input";
    private static final String LO_EDT_CLAIM_NUMBER_FIELD = "//div[label[contains(text(), 'Claim Reference Number')]]/following-sibling::div//input";
    private static final String LO_TXT_CLAIM_NUMBER_LABEL = "//label[contains(text(), 'Claim Reference Number')]";
    private static final String LO_TXT_ERROR_VALID_GLOBAL_EXCEL_NUMBER = "//div[label='Claim Reference Number']/following-sibling::div//span[div]";
    private static final String LO_BUT_VIEW_STATUS = "//span/span[contains(text(), 'View Status')]";
    private static final String LO_TXT_ERROR_CLAIM_NOT_FOUND = "//p[strong]";
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

    //---------------------------------------------------------------------- FR2 ---------------------------------------------------------------------------------------------
    private static final String LO_EDT_CLAIM_NUMBER_INPUT_FIELD_FR = "";
    private static final String LO_TXT_CLAIMING_FR = "";
    private static final String LO_TXT_WHICH_INSURANCE_INFO_DO_I_NEED_FR = "";
    private static final String LO_TXT_VIEW_CLAIM_STATUS_PAGE_VERIFY_FR = "";
    private static final String LO_BUT_BACK_FR = "";
    private static final String LO_TXT_ERROR_VALID_GLOBAL_EXCEL_NUMBER_FR = "";
    private static final String LO_BUT_VIEW_STATUS_FR = "";
    private static final String LO_TXT_ERROR_CLAIM_NOT_FOUND_FR = "";
    private static final String LO_TXT_ERROR_CLAIM_NOT_FOUND_2_FR = "";
    private static final String LO_TXT_FREQUENTLY_ASKED_QUESTIONS_TITLE_FR = "//h2[contains(text(), 'Questions Fréquemment Posées (FAQ)')]";
    private static final String LO_TXT_HOW_WILL_KNOW_QUESTIONS_TITLE_FR = "//div[contains(text(), 'Comment saurai-je quand mon dossier est réglé?')]";
    private static final String LO_TXT_HOW_LONG_QUESTIONS_TITLE_FR = "";
    private static final String LO_TXT_WHEN_WILL_I_RECEIVE_MY_CLAIM_NUMBER_QUESTIONS_TITLE_FR = "";
    private static final String LO_BUT_FAQS_FR = "";
    private static final String LO_TXT_FREQUENTLY_ASKED_QUESTIONS_TITLE_CAP_LETTERS_FR = "";
    private static final String LO_TXT_TRAVEL_AND_ASSISTANCE_VERIFY_FR = "";
    private static final String LO_TXT_WHICH_INSURANCE_INFORMATION_DO_I_NEED_TO_BRING_ON_MY_TRIP_FR = "";
    private static final String LO_TXT_WHICH_INSURANCE_INFORMATION_DO_I_NEED_TO_BRING_ON_MY_TRIP_SUB_INFO_FR = "";
    private static final String LO_TXT_WHAT_SHOULD_I_DO_IF_I_HAVE_A_MEDICAL_EMERGECY_WHEN_TRAVELLING_FR = "";
    private static final String LO_TXT_WHAT_SHOULD_I_DO_IF_I_HAVE_A_MEDICAL_EMERGECY_WHEN_TRAVELLING_SUB_INFO_FR = "";
    private static final String LO_TXT_WHAT_IF_I_CAN_NOT_CALL_YOU_RIGHT_AWAY_FR = "";
    private static final String LO_TXT_WHAT_IF_I_CAN_NOT_CALL_YOU_RIGHT_AWAY_SUB_INFO_FR = "";
    private static final String LO_TXT_IF_I_NEED_MEDICAL_ATTENTION_CAN_YOU_REFER_ME_TO_A_DOCTOR_OR_CLINIC_FR = "";
    private static final String LO_TXT_IF_I_NEED_MEDICAL_ATTENTION_CAN_YOU_REFER_ME_TO_A_DOCTOR_OR_CLINIC_SUB_INFO_FR = "";
    private static final String LO_TXT_WHAT_DOES_GEM_DO_FR = "";
    private static final String LO_TXT_WHAT_DOES_GEM_DO_SUB_INFO_FR = "";
    private static final String LO_TXT_CLAIMING_TAB_FR = "";
    private static final String LO_TXT_WHAT_SHOULD_I_DO_IF_I_RECEIVE_BILLS_FR = "";
    private static final String LO_TXT_WHAT_SHOULD_I_DO_IF_I_RECEIVE_BILLS_SUB_INFO_FR = "";
    private static final String LO_TXT_HOW_CAN_I_CONTACT_YOU_ABOUT_MY_CLAIM_FR = "";
    private static final String LO_TXT_HOW_CAN_I_CONTACT_YOU_ABOUT_MY_CLAIM_SUB_INFO_FR = "";
    private static final String LO_TXT_WHAT_TO_DO_IF_I_HAVE_OUT_OF_POCKET_EXPENSES_FR = "";
    private static final String LO_TXT_WHAT_TO_DO_IF_I_HAVE_OUT_OF_POCKET_EXPENSES_SUB_INFO_FR = "";
    private static final String LO_TXT_DO_YOU_TAKE_ORIGINAL_OR_COPY_OF_DOCUMENTS_FR = "";
    private static final String LO_TXT_DO_YOU_TAKE_ORIGINAL_OR_COPY_OF_DOCUMENTS_SUB_INFO_FR = "";
    private static final String LO_TXT_CURRENCY_TO_BE_REIMBURSED_IN_FR = "";
    private static final String LO_TXT_CURRENCY_TO_BE_REIMBURSED_IN_SUB_INFO_FR = "";
    private static final String LO_TXT_WHAT_IS_YOUR_MAILING_ADDRESS_FR = "";
     private static final String LO_TXT_WHAT_IS_YOUR_MAILING_ADDRESS_SUB_INFO_FR = "";
     private static final String LO_TXT_HOW_DO_I_SUBMIT_A_CLAIM_FR = "";
     private static final String LO_TXT_HOW_DO_I_SUBMIT_A_CLAIM_SUB_INFO_FR = "";
     private static final String LO_TXT_HOW_WILL_I_KNOW_CLAIM_IS_SETTLED_FR = "";
     private static final String LO_TXT_HOW_WILL_I_KNOW_CLAIM_IS_SETTLED_SUB_INFO_FR = "";
     private static final String LO_TXT_HOW_LONG_WILL_IT_TAKE_MY_CLAIM_TO_BE_SETTLED_FR = "";
     private static final String LO_TXT_HOW_LONG_WILL_IT_TAKE_MY_CLAIM_TO_BE_SETTLED_SUB_INFO_FR = "";
     private static final String LO_TXT_WHEN_WILL_I_RECEIVE_A_CLAIM_NUMBER_FR = "";
     private static final String LO_TXT_WHEN_WILL_I_RECEIVE_A_CLAIM_NUMBER_SUB_INFO_FR = "";
     private static final String LO_TXT_REIMBURSEMENT_PAID_USING_CREDIT_CARD_FR = "";
     private static final String LO_TXT_REIMBURSEMENT_PAID_USING_CREDIT_CARD_SUB_INFO_FR = "";
     private static final String LO_TXT_CLAIM_DOCUMENTS_TAB_FR = "";
     private static final String LO_TXT_DIFFERENCE_BTN_T_AGENCY_AND_T_SUPPLIER_FR = "";
     private static final String LO_TXT_DIFFERENCE_BTN_T_AGENCY_AND_T_SUPPLIER_SUB_INFO_FR = "";
     private static final String LO_TXT_WHY_IS_NECESSARY_TO_PROVIDE_CANCELLATION_INVOICE_FR = "";
     private static final String LO_TXT_WHY_IS_NECESSARY_TO_PROVIDE_CANCELLATION_INVOICE_SUB_INFO_FR = "";
     private static final String LO_TXT_WHY_DO_I_NEED_TO_UPLOAD_GEM_MEDICAL_CERTIFICATE_FR = "";
      private static final String LO_TXT_WHY_SUBMIT_A_GEM_MEDICAL_CERTIFICATE_FROM_MY_FAMILY_PHYSICIAN_FR = "";
       private static final String LO_TXT_WHY_SUBMIT_A_GEM_MEDICAL_CERTIFICATE_FROM_MY_FAMILY_PHYSICIAN_SUB_INFO_FR = "";
       private static final String LO_TXT_WHY_DO_I_NEED_TO_SUBMIT_MY_CREDIT_CARD_OR_BANK_STATEMENT_FR = "";
       private static final String LO_TXT_WHY_DO_I_NEED_TO_SUBMIT_MY_CREDIT_CARD_OR_BANK_STATEMENT_SUB_INFO_FR = "";
    private static final String LO_TXT_WHAT_TO_DO_IF_CANNOT_FIND_MY_BOOKING_INVOICE_FR = "";
    private static final String LO_TXT_WHAT_TO_DO_IF_CANNOT_FIND_MY_BOOKING_INVOICE_SUB_INFO_FR = "";
    private static final String LO_TXT_WHAT_TO_DO_IF_I_DO_NOT_HAVE_A_CANCELLATION_INVOICE_FR = "";
    private static final String LO_TXT_WHAT_TO_DO_IF_I_DO_NOT_HAVE_A_CANCELLATION_INVOICE_SUB_INFO_FR = "";
    private static final String LO_TXT_WHAT_DOCUMENT_FORMAT_AND_SIZE_DO_YOU_ACCEPT_FOR_UPLOAD_FR = "";
    private static final String LO_TXT_WHAT_DOCUMENT_FORMAT_AND_SIZE_DO_YOU_ACCEPT_FOR_UPLOAD_SUB_INFO_FR = "";
    private static final String LO_TXT_WHAT_DO_I_NEED_TO_PROVIDE_RECEIPTS_FOR_MY_OUT_OF_POCKET_EXPESES_SUB_INFO_FR = "";
    private static final String LO_TXT_TECHNICAL_SUPPORT_FR = "//strong[contains(text(), 'Technical Support')]";
    private static final String LO_TXT_HOW_CAN_I_RETRIEVE_A_DRAFT_CLAIM_FR = "";
    private static final String LO_TXT_TRAVEL_AND_ASSISTANCE_VERIFY_SUB_INFO_FR = "";
     private static final String LO_TXT_DID_NOT_RECEIVE_ONE_TIME_VERIFICATION_CODE_SUB_INFO_FR = "";
     private static final String LO_TXT_ONE_TIME_VERIFICATION_CODE_RECEIVED_NOT_WORKING_SUB_INFO_FR = "";
     private static final String LO_TXT_MOBILE_PHONE_VERIFICATION_FAILS_SUB_INFO_FR = "";
     private static final String LO_TXT_DO_I_NEED_MOBILE_PHONE_TO_RECEIVE_ONE_TIME_VC_FR = "//div[contains(text(), 'Do I need a mobile phone to receive the one-time verification code?')]";
      private static final String LO_TXT_DO_I_NEED_MOBILE_PHONE_TO_RECEIVE_ONE_TIME_VC_SUB_INFO_FR = "";
      private static final String LO_TXT_WHAT_CAN_I_DO_IF_I_NO_LONGER_HAVE_ACCESS_TO_MY_PHONE_FR = "";
      private static final String LO_TXT_WHAT_CAN_I_DO_IF_I_NO_LONGER_HAVE_ACCESS_TO_MY_PHONE_SUB_INFO_FR = "";
       private static final String LO_TXT_TO_WHICH_MOBILE_PHONE_THE_ONE_TIME_VC_SENT_FR = "";
       private static final String LO_TXT_TO_WHICH_MOBILE_PHONE_THE_ONE_TIME_VC_SENT_SUB_INFO_FR = "";
     private static final String LO_TXT_HOW_LONG_DOES_IT_TAKE_TO_RECEIVE_THE_ONE_TIME_VC_FR = "";
    private static final String LO_TXT_HOW_LONG_DOES_IT_TAKE_TO_RECEIVE_THE_ONE_TIME_VC_SUB_INFO_FR = "";
    private static final String LO_TXT_DO_I_NEED_TO_ENTER_A_VC_EACH_TIME_I_ACCESS_MY_CLAIM_FR = "";
    private static final String LO_TXT_WHY_DO_I_NEED_TO_UPLOAD_GEM_MEDICAL_CERTIFICATE_SUB_INFO_FR = "";
    private static final String LO_TXT_DO_I_NEED_TO_ENTER_A_VC_EACH_TIME_I_ACCESS_MY_CLAIM_SUB_INFO_FR = "";
    private static final String LO_TXT_CAN_I_RECEIVE_THE_ONE_TIME_VERIFICATION_CODE_BY_EMAIL_FR = "";
    private static final String LO_TXT_CAN_I_RECEIVE_THE_ONE_TIME_VERIFICATION_CODE_BY_EMAIL_SUB_INFO_FR = "";
    private static final String LO_TXT_WILL_I_INCUR_CHARGES_FOR_RECEIVING_THE_VERIFICATION_CODE_FR = "";
    private static final String LO_TXT_WILL_I_INCUR_CHARGES_FOR_RECEIVING_THE_VERIFICATION_CODE_SUB_INFO_FR = "";
    private static final String LO_TXT_CAN_I_USE_AN_INTERNATIONAL_MOBILE_PHONE_TO_AUTHENTICATE_FR = "";
    private static final String LO_TXT_CAN_I_USE_AN_INTERNATIONAL_MOBILE_PHONE_TO_AUTHENTICATE_SUB_INFO_FR = "";
    private static final String LO_TXT_CAN_I_REPLY_TO_THE_NUMBER_THAT_SENDS_THE_ONE_TIME_VC_FR = "";
    private static final String LO_TXT_CAN_I_REPLY_TO_THE_NUMBER_THAT_SENDS_THE_ONE_TIME_VC_SUB_INFO_FR = "//div[div[div[div[div[text()='Can I reply to the number that sends the one-time verification code?']]]]]/following-sibling::div";
    private static final String LO_BUT_VISIT_OUR_HELP_CENTRE_FR = "";
    private static final String LO_TXT_NEED_HELP_PARAGRAPH_FR = "";
    private static final String LO_TXT_NEED_HELP_HEADING_FR = "";
    private static final String LO_EDT_CLAIM_NUMBER_FIELD_FR = "";
    private static final String LO_TXT_VIEW_CLAIM_STATUS_PARAGRAPH_FR = "";
    private static final String LO_LNK_FRENCH_TOGGLE_EN = "";
    private static final String LO_LNK_HELP_CENTRE_TOP_FR = "";
    private static final String LO_TXT_WHAT_DO_I_NEED_TO_PROVIDE_RECEIPTS_FOR_MY_OUT_OF_POCKET_EXPESES_FR = "";
    private static final String LO_TXT_I_DID_NOT_RECEIVE_THE_ONE_TIME_VERIFICATION_CODE_FR = "";
    private static final String LO_TXT_ONE_TIME_VERIFICATION_CODE_RECEIVED_NOT_WORKING_FR = "";
    private static final String LO_TXT_WHAT_TO_DO_IF_MOBILE_PHONE_VERIFICATION_FAILS_FR = "";

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
    public Object validateOnPage(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_VIEW_CLAIM_STATUS_PAGE_VERIFY_FR : LO_TXT_VIEW_CLAIM_STATUS_PAGE_VERIFY;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    /**
     * Clicks the 'HELP CENTER' link.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object clickHelpCentreHeaderLight() {
        waitForDuration(5, "s", false); // Wait to perform next check
        String result = clickLocator(LO_LNK_HELP_CENTRE_TOP, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object validateNeedHelpHeading(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_NEED_HELP_HEADING_FR : LO_TXT_NEED_HELP_HEADING;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object validateNeedHelpParagraph(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_NEED_HELP_PARAGRAPH_FR : LO_TXT_NEED_HELP_PARAGRAPH;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object validateMessagingAssistanceIcon() {
        String result = validateLocatorExists(LO_IMG_MESSAGING_ASSISTANCE_ICON, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object validateFrequentlyAskedQuestionsTitle(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_FREQUENTLY_ASKED_QUESTIONS_TITLE_FR : LO_TXT_FREQUENTLY_ASKED_QUESTIONS_TITLE;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object validateKnowWhenClaimSettledQuestion(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_HOW_WILL_KNOW_QUESTIONS_TITLE_FR : LO_TXT_HOW_WILL_KNOW_QUESTIONS_TITLE;
        clickLocator(locator, FW_ConfigMgr.getDefaultTimeout());
        String result = validateLocatorExists(LO_TXT_HOW_WILL_KNOW_QUESTIONS_PARAGRAPH, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    

    public Object validateHowLongWillTakeClaimToBeSettledQuestion(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_HOW_LONG_QUESTIONS_TITLE_FR : LO_TXT_HOW_LONG_QUESTIONS_TITLE;
        clickLocator(locator, FW_ConfigMgr.getDefaultTimeout());
        String result = validateLocatorExists(LO_TXT_HOW_LONG_QUESTIONS_PARAGRAPH, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object validateWhenWillIReivedMyClaimNumberQuestion(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_WHEN_WILL_I_RECEIVE_MY_CLAIM_NUMBER_QUESTIONS_TITLE_FR : LO_TXT_WHEN_WILL_I_RECEIVE_MY_CLAIM_NUMBER_QUESTIONS_TITLE;
        clickLocator(locator, FW_ConfigMgr.getDefaultTimeout());
        String result = validateLocatorExists(LO_TXT_WHEN_WILL_I_RECEIVE_MY_CLAIM_NUMBER_QUESTIONS_PARAGRAPH, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object validateTop_Left_Logo_Light_Zurich() {
        String result = validateLocatorExists(LO_IMG_TOP_LOGO_LIGHT_ZURICH, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    public Object clickViewAllFAQs(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_BUT_FAQS_FR : LO_BUT_FAQS;
        String result = clickLocator(locator, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    public Object validateFrequentlyAskedQuestionsTitleCAPLetters(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_FREQUENTLY_ASKED_QUESTIONS_TITLE_CAP_LETTERS_FR : LO_TXT_FREQUENTLY_ASKED_QUESTIONS_TITLE_CAP_LETTERS;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object validateTravelAndAssistance() {
        String result = clickLocator(LO_TXT_TRAVEL_AND_ASSISTANCE_VERIFY, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
     public Object clickTravelAndAssistanceTitle(String language) {
         String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_TRAVEL_AND_ASSISTANCE_VERIFY_FR : LO_TXT_TRAVEL_AND_ASSISTANCE_VERIFY;
        String result = clickLocator(locator, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    public Object clickClaimingTab() {
        String result = clickLocator(LO_TXT_CLAIMING_TAB, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    public Object clickClaimDocumentsTab(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_CLAIM_DOCUMENTS_TAB_FR : LO_TXT_CLAIM_DOCUMENTS_TAB;
        String result = clickLocator(locator, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    public Object clickWhichInsuranceInformationDoINeedToBringOnMyTripQuestion(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_WHICH_INSURANCE_INFORMATION_DO_I_NEED_TO_BRING_ON_MY_TRIP_FR : LO_TXT_WHICH_INSURANCE_INFORMATION_DO_I_NEED_TO_BRING_ON_MY_TRIP;
        String result = clickLocator(locator, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    public Object clickWhatShouldIDoIfIHaveAMedicalEmergencyWhenIAmTravellingQuestion(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_WHAT_SHOULD_I_DO_IF_I_HAVE_A_MEDICAL_EMERGECY_WHEN_TRAVELLING_FR : LO_TXT_WHAT_SHOULD_I_DO_IF_I_HAVE_A_MEDICAL_EMERGECY_WHEN_TRAVELLING;
        String result = clickLocator(locator, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    public Object clickWhatIfICannotCallYouRightAwayQuestion(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_WHAT_IF_I_CAN_NOT_CALL_YOU_RIGHT_AWAY_FR : LO_TXT_WHAT_IF_I_CAN_NOT_CALL_YOU_RIGHT_AWAY;
        String result = clickLocator(locator, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    public Object clickIfINeedMedicalAttentionCanYouReferMeToADoctorOrClinicQuestion(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_IF_I_NEED_MEDICAL_ATTENTION_CAN_YOU_REFER_ME_TO_A_DOCTOR_OR_CLINIC_FR : LO_TXT_IF_I_NEED_MEDICAL_ATTENTION_CAN_YOU_REFER_ME_TO_A_DOCTOR_OR_CLINIC;
        String result = clickLocator(locator, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    public Object clickWhatDoesGlobalExeclManagementDoQuestion(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_WHAT_DOES_GEM_DO_FR : LO_TXT_WHAT_DOES_GEM_DO;
        String result = clickLocator(locator, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    public Object clickWhatShouldIDoIfIReceiveBillsQuestion(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_WHAT_SHOULD_I_DO_IF_I_RECEIVE_BILLS_FR : LO_TXT_WHAT_SHOULD_I_DO_IF_I_RECEIVE_BILLS;
        String result = clickLocator(locator, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    public Object clickHowCanIConctactYouAboutMyClaimQuestion(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_HOW_CAN_I_CONTACT_YOU_ABOUT_MY_CLAIM_FR : LO_TXT_HOW_CAN_I_CONTACT_YOU_ABOUT_MY_CLAIM;
        String result = clickLocator(locator, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    public Object clickWhatShouldIDoIfIHaveOutOfPocketsExpensesQuestion(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_WHAT_TO_DO_IF_I_HAVE_OUT_OF_POCKET_EXPENSES_FR : LO_TXT_WHAT_TO_DO_IF_I_HAVE_OUT_OF_POCKET_EXPENSES;
        String result = clickLocator(locator, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    public Object clicKDoYouAcceptOriginalOrCopyOfDocumentsQuestion(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_DO_YOU_TAKE_ORIGINAL_OR_COPY_OF_DOCUMENTS_FR : LO_TXT_DO_YOU_TAKE_ORIGINAL_OR_COPY_OF_DOCUMENTS;
        String result = clickLocator(locator, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    public Object clickCurrecyToBeReimbursedInQuestion(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_CURRENCY_TO_BE_REIMBURSED_IN_FR : LO_TXT_CURRENCY_TO_BE_REIMBURSED_IN;
        String result = clickLocator(locator, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    public Object clickWhatIsYourMailingAddressQuestion(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_WHAT_IS_YOUR_MAILING_ADDRESS_FR : LO_TXT_WHAT_IS_YOUR_MAILING_ADDRESS;
        String result = clickLocator(locator, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    public Object clickHowDoISubmitAClaimQuestion(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_HOW_DO_I_SUBMIT_A_CLAIM_FR : LO_TXT_HOW_DO_I_SUBMIT_A_CLAIM;
        String result = clickLocator(locator, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    public Object clickHowWillIKnowWhenMyClaimIsSettledQuestion(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_HOW_WILL_I_KNOW_CLAIM_IS_SETTLED_FR : LO_TXT_HOW_WILL_I_KNOW_CLAIM_IS_SETTLED;
        String result = clickLocator(locator, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    public Object clickHowLongWillItTakeMyClaimToBeSettledMyClaimIsSettledQuestion(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_HOW_LONG_WILL_IT_TAKE_MY_CLAIM_TO_BE_SETTLED_FR : LO_TXT_HOW_LONG_WILL_IT_TAKE_MY_CLAIM_TO_BE_SETTLED;
        String result = clickLocator(locator, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    public Object clickWhenWillIReceiveMyClaimNumberQuestion(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_WHEN_WILL_I_RECEIVE_A_CLAIM_NUMBER_FR : LO_TXT_WHEN_WILL_I_RECEIVE_A_CLAIM_NUMBER;
        String result = clickLocator(locator, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    public Object clickReimbursemntForTripPaidUsingCreditCardQuestion(String language) {
         String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_REIMBURSEMENT_PAID_USING_CREDIT_CARD_FR : LO_TXT_REIMBURSEMENT_PAID_USING_CREDIT_CARD;
        String result = clickLocator(locator, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    public Object clickDifferenceBetweenTravelAgectAndTravelSupplierQuestion(String language) {
         String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_DIFFERENCE_BTN_T_AGENCY_AND_T_SUPPLIER_FR : LO_TXT_DIFFERENCE_BTN_T_AGENCY_AND_T_SUPPLIER;
        String result = clickLocator(locator, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    public Object clickWhyIsItNessessaryToProvideACancellaionInvoiceQuestion(String language) {
         String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_WHY_IS_NECESSARY_TO_PROVIDE_CANCELLATION_INVOICE_FR : LO_TXT_WHY_IS_NECESSARY_TO_PROVIDE_CANCELLATION_INVOICE;
        String result = clickLocator(locator, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    public Object clickWhyDoINeedToUploadGEMmedecalCertificateQuestion(String language) {
         String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_WHY_DO_I_NEED_TO_UPLOAD_GEM_MEDICAL_CERTIFICATE_FR : LO_TXT_WHY_DO_I_NEED_TO_UPLOAD_GEM_MEDICAL_CERTIFICATE;
        String result = clickLocator(locator, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    public Object clickWhySubmitAGemMedicalCertificateFromMyFamilyPhysicianQuestion(String language) {
         String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_WHY_SUBMIT_A_GEM_MEDICAL_CERTIFICATE_FROM_MY_FAMILY_PHYSICIAN_FR : LO_TXT_WHY_SUBMIT_A_GEM_MEDICAL_CERTIFICATE_FROM_MY_FAMILY_PHYSICIAN;
        String result = clickLocator(locator, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    public Object clickWhyDoINeedToSubmitMyCreditCardOrBankStatementQuestion(String language) {
         String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_WHY_DO_I_NEED_TO_SUBMIT_MY_CREDIT_CARD_OR_BANK_STATEMENT_FR : LO_TXT_WHY_DO_I_NEED_TO_SUBMIT_MY_CREDIT_CARD_OR_BANK_STATEMENT;
        String result = clickLocator(locator, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    public Object clickWhyShouldIDoIfICannotFindMyBookingInvoiceQuestion(String language) {
         String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_WHAT_TO_DO_IF_CANNOT_FIND_MY_BOOKING_INVOICE_FR : LO_TXT_WHAT_TO_DO_IF_CANNOT_FIND_MY_BOOKING_INVOICE;
        String result = clickLocator(locator, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    public Object clickWhyShouldIDoIfIDoNotHaveACancellationInvoiceQuestion(String language) {
         String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_WHAT_TO_DO_IF_I_DO_NOT_HAVE_A_CANCELLATION_INVOICE_FR : LO_TXT_WHAT_TO_DO_IF_I_DO_NOT_HAVE_A_CANCELLATION_INVOICE;
        String result = clickLocator(locator, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    public Object clickWhatDocumentFormatAndSizeDoYouAcceptToBeUploadedInvoiceQuestion(String language) {
         String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_WHAT_DOCUMENT_FORMAT_AND_SIZE_DO_YOU_ACCEPT_FOR_UPLOAD_FR : LO_TXT_WHAT_DOCUMENT_FORMAT_AND_SIZE_DO_YOU_ACCEPT_FOR_UPLOAD;
        String result = clickLocator(locator, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    public Object clickWhatDoINeedToProvideReceiptsForMyOutOfPocketExpensesQuestion(String language) {
         String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_WHAT_DO_I_NEED_TO_PROVIDE_RECEIPTS_FOR_MY_OUT_OF_POCKET_EXPESES_FR : LO_TXT_WHAT_DO_I_NEED_TO_PROVIDE_RECEIPTS_FOR_MY_OUT_OF_POCKET_EXPESES;
        String result = clickLocator(locator, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    public Object validateTravelAndAssistance1stQuestionSubInfo1(String language, String txt) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_WHICH_INSURANCE_INFORMATION_DO_I_NEED_TO_BRING_ON_MY_TRIP_SUB_INFO_FR : LO_TXT_WHICH_INSURANCE_INFORMATION_DO_I_NEED_TO_BRING_ON_MY_TRIP_SUB_INFO;
        String result = validateWithinLocatorText(locator,txt,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    public Object validateTravelAndAssistance2stQuestionSubInfo1(String language, String txt) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_WHAT_SHOULD_I_DO_IF_I_HAVE_A_MEDICAL_EMERGECY_WHEN_TRAVELLING_SUB_INFO_FR : LO_TXT_WHAT_SHOULD_I_DO_IF_I_HAVE_A_MEDICAL_EMERGECY_WHEN_TRAVELLING_SUB_INFO;
        String result = validateWithinLocatorText(locator,txt,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    public Object validateTravelAndAssistance3stQuestionSubInfo1(String language, String txt) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_WHAT_IF_I_CAN_NOT_CALL_YOU_RIGHT_AWAY_SUB_INFO_FR : LO_TXT_WHAT_IF_I_CAN_NOT_CALL_YOU_RIGHT_AWAY_SUB_INFO;
        String result = validateWithinLocatorText(locator,txt,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    public Object validateTravelAndAssistance4stQuestionSubInfo1(String language, String txt) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_IF_I_NEED_MEDICAL_ATTENTION_CAN_YOU_REFER_ME_TO_A_DOCTOR_OR_CLINIC_SUB_INFO_FR : LO_TXT_IF_I_NEED_MEDICAL_ATTENTION_CAN_YOU_REFER_ME_TO_A_DOCTOR_OR_CLINIC_SUB_INFO;
        String result = validateWithinLocatorText(locator,txt,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object validateTravelAndAssistance5stQuestionSubInfo1(String language, String txt) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_WHAT_DOES_GEM_DO_SUB_INFO_FR : LO_TXT_WHAT_DOES_GEM_DO_SUB_INFO;
        String result = validateWithinLocatorText(locator,txt,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    public Object validateClaiming1stQuestionSubInfo(String language, String txt) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_WHAT_SHOULD_I_DO_IF_I_RECEIVE_BILLS_SUB_INFO_FR : LO_TXT_WHAT_SHOULD_I_DO_IF_I_RECEIVE_BILLS_SUB_INFO;
        String result = validateWithinLocatorText(locator,txt,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    public Object validateClaiming2stQuestionSubInfo(String language, String txt) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_HOW_CAN_I_CONTACT_YOU_ABOUT_MY_CLAIM_SUB_INFO_FR : LO_TXT_HOW_CAN_I_CONTACT_YOU_ABOUT_MY_CLAIM_SUB_INFO;
        String result = validateWithinLocatorText(locator,txt,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    public Object validateClaiming3stQuestionSubInfo(String language, String txt) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_WHAT_TO_DO_IF_I_HAVE_OUT_OF_POCKET_EXPENSES_SUB_INFO_FR : LO_TXT_WHAT_TO_DO_IF_I_HAVE_OUT_OF_POCKET_EXPENSES_SUB_INFO;
        String result = validateWithinLocatorText(locator,txt,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    public Object validateClaiming4stQuestionSubInfo(String language, String txt) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_DO_YOU_TAKE_ORIGINAL_OR_COPY_OF_DOCUMENTS_SUB_INFO_FR : LO_TXT_DO_YOU_TAKE_ORIGINAL_OR_COPY_OF_DOCUMENTS_SUB_INFO;
        String result = validateWithinLocatorText(locator,txt,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    public Object validateClaiming5stQuestionSubInfo(String language, String txt) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_CURRENCY_TO_BE_REIMBURSED_IN_SUB_INFO_FR : LO_TXT_CURRENCY_TO_BE_REIMBURSED_IN_SUB_INFO;
        String result = validateWithinLocatorText(locator,txt,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    public Object validateClaiming6stQuestionSubInfo(String language, String txt) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_WHAT_IS_YOUR_MAILING_ADDRESS_SUB_INFO_FR : LO_TXT_WHAT_IS_YOUR_MAILING_ADDRESS_SUB_INFO;
        String result = validateWithinLocatorText(locator,txt,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    public Object validateClaiming7stQuestionSubInfo(String language, String txt) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_HOW_DO_I_SUBMIT_A_CLAIM_SUB_INFO_FR : LO_TXT_HOW_DO_I_SUBMIT_A_CLAIM_SUB_INFO;
        String result = validateWithinLocatorText(locator,txt,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    public Object validateClaiming8stQuestionSubInfo(String language, String txt) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_HOW_WILL_I_KNOW_CLAIM_IS_SETTLED_SUB_INFO_FR : LO_TXT_HOW_WILL_I_KNOW_CLAIM_IS_SETTLED_SUB_INFO;
        String result = validateWithinLocatorText(locator,txt,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    public Object validateClaiming9stQuestionSubInfo(String language, String txt) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_HOW_LONG_WILL_IT_TAKE_MY_CLAIM_TO_BE_SETTLED_SUB_INFO_FR : LO_TXT_HOW_LONG_WILL_IT_TAKE_MY_CLAIM_TO_BE_SETTLED_SUB_INFO;
        String result = validateWithinLocatorText(locator,txt,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    public Object validateClaiming10stQuestionSubInfo(String language, String txt) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_WHEN_WILL_I_RECEIVE_A_CLAIM_NUMBER_SUB_INFO_FR : LO_TXT_WHEN_WILL_I_RECEIVE_A_CLAIM_NUMBER_SUB_INFO;
        String result = validateWithinLocatorText(locator,txt,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    public Object validateClaiming11stQuestionSubInfo(String language, String txt) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_REIMBURSEMENT_PAID_USING_CREDIT_CARD_SUB_INFO_FR : LO_TXT_REIMBURSEMENT_PAID_USING_CREDIT_CARD_SUB_INFO;
        String result = validateWithinLocatorText(locator,txt,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    public Object validateClaimingDocuments1stQuestionSubInfo(String language, String txt) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_DIFFERENCE_BTN_T_AGENCY_AND_T_SUPPLIER_SUB_INFO_FR : LO_TXT_DIFFERENCE_BTN_T_AGENCY_AND_T_SUPPLIER_SUB_INFO;
        String result = validateWithinLocatorText(locator,txt,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    public Object validateClaimingDocuments2stQuestionSubInfo(String language, String txt) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_WHY_IS_NECESSARY_TO_PROVIDE_CANCELLATION_INVOICE_SUB_INFO_FR : LO_TXT_WHY_IS_NECESSARY_TO_PROVIDE_CANCELLATION_INVOICE_SUB_INFO;
        String result = validateWithinLocatorText(locator,txt,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    public Object validateClaimingDocuments3stQuestionSubInfo(String language, String txt) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_WHY_DO_I_NEED_TO_UPLOAD_GEM_MEDICAL_CERTIFICATE_SUB_INFO_FR : LO_TXT_WHY_DO_I_NEED_TO_UPLOAD_GEM_MEDICAL_CERTIFICATE_SUB_INFO;
        String result = validateWithinLocatorText(locator,txt,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    public Object validateClaimingDocuments4stQuestionSubInfo(String language, String txt) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_WHY_SUBMIT_A_GEM_MEDICAL_CERTIFICATE_FROM_MY_FAMILY_PHYSICIAN_SUB_INFO_FR : LO_TXT_WHY_SUBMIT_A_GEM_MEDICAL_CERTIFICATE_FROM_MY_FAMILY_PHYSICIAN_SUB_INFO;
        String result = validateWithinLocatorText(locator,txt,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    public Object validateClaimingDocuments5stQuestionSubInfo(String language, String txt) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_WHY_DO_I_NEED_TO_SUBMIT_MY_CREDIT_CARD_OR_BANK_STATEMENT_SUB_INFO_FR : LO_TXT_WHY_DO_I_NEED_TO_SUBMIT_MY_CREDIT_CARD_OR_BANK_STATEMENT_SUB_INFO;
        String result = validateWithinLocatorText(locator,txt,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    public Object validateClaimingDocuments6stQuestionSubInfo(String language, String txt) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_WHAT_TO_DO_IF_CANNOT_FIND_MY_BOOKING_INVOICE_SUB_INFO_FR : LO_TXT_WHAT_TO_DO_IF_CANNOT_FIND_MY_BOOKING_INVOICE_SUB_INFO;
        String result = validateWithinLocatorText(locator,txt,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    public Object validateClaimingDocuments7stQuestionSubInfo(String language, String txt) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_WHAT_TO_DO_IF_I_DO_NOT_HAVE_A_CANCELLATION_INVOICE_SUB_INFO_FR : LO_TXT_WHAT_TO_DO_IF_I_DO_NOT_HAVE_A_CANCELLATION_INVOICE_SUB_INFO;
        String result = validateWithinLocatorText(locator,txt,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    public Object validateClaimingDocuments8stQuestionSubInfo(String language, String txt) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_WHAT_DOCUMENT_FORMAT_AND_SIZE_DO_YOU_ACCEPT_FOR_UPLOAD_SUB_INFO_FR : LO_TXT_WHAT_DOCUMENT_FORMAT_AND_SIZE_DO_YOU_ACCEPT_FOR_UPLOAD_SUB_INFO;
        String result = validateWithinLocatorText(locator,txt,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    public Object validateClaimingDocuments9stQuestionSubInfo(String language, String txt) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_WHAT_DO_I_NEED_TO_PROVIDE_RECEIPTS_FOR_MY_OUT_OF_POCKET_EXPESES_SUB_INFO_FR : LO_TXT_WHAT_DO_I_NEED_TO_PROVIDE_RECEIPTS_FOR_MY_OUT_OF_POCKET_EXPESES_SUB_INFO;
        String result = validateWithinLocatorText(locator,txt,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object validateTravelAndAssistance1stQuestionSubInfo(String language, String txt) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_TRAVEL_AND_ASSISTANCE_VERIFY_SUB_INFO_FR : LO_TXT_TRAVEL_AND_ASSISTANCE_VERIFY_SUB_INFO;
        String result = validateWithinLocatorText(locator,txt,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    public Object validateTravelAndAssistance2ndQuestionSubInfo(String language, String txt) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_DID_NOT_RECEIVE_ONE_TIME_VERIFICATION_CODE_SUB_INFO_FR : LO_TXT_DID_NOT_RECEIVE_ONE_TIME_VERIFICATION_CODE_SUB_INFO;
        String result = validateWithinLocatorText(locator,txt,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object validateTechnicalSupport3rdQuestionSubInfo(String language, String txt) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_ONE_TIME_VERIFICATION_CODE_RECEIVED_NOT_WORKING_SUB_INFO_FR : LO_TXT_ONE_TIME_VERIFICATION_CODE_RECEIVED_NOT_WORKING_SUB_INFO;
        String result = validateWithinLocatorText(locator,txt,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    public Object validateTechnicalSupport4thQuestionSubInfo(String language, String txt) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_MOBILE_PHONE_VERIFICATION_FAILS_SUB_INFO_FR : LO_TXT_MOBILE_PHONE_VERIFICATION_FAILS_SUB_INFO;
        String result = validateWithinLocatorText(locator,txt,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    public Object validateTechnicalSupport5thQuestionSubInfo(String language, String txt) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_DO_I_NEED_MOBILE_PHONE_TO_RECEIVE_ONE_TIME_VC_SUB_INFO_FR : LO_TXT_DO_I_NEED_MOBILE_PHONE_TO_RECEIVE_ONE_TIME_VC_SUB_INFO;
        String result = validateWithinLocatorText(locator,txt,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    public Object validateTechnicalSupport6thQuestionSubInfo(String language, String txt) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_WHAT_CAN_I_DO_IF_I_NO_LONGER_HAVE_ACCESS_TO_MY_PHONE_SUB_INFO_FR : LO_TXT_WHAT_CAN_I_DO_IF_I_NO_LONGER_HAVE_ACCESS_TO_MY_PHONE_SUB_INFO;
        String result = validateWithinLocatorText(locator,txt,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    public Object validateTechnicalSupport7thQuestionSubInfo(String language, String txt) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_TO_WHICH_MOBILE_PHONE_THE_ONE_TIME_VC_SENT_SUB_INFO_FR : LO_TXT_TO_WHICH_MOBILE_PHONE_THE_ONE_TIME_VC_SENT_SUB_INFO;
        String result = validateWithinLocatorText(locator,txt,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    public Object validateTechnicalSupport8thQuestionSubInfo(String language, String txt) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_HOW_LONG_DOES_IT_TAKE_TO_RECEIVE_THE_ONE_TIME_VC_SUB_INFO_FR : LO_TXT_HOW_LONG_DOES_IT_TAKE_TO_RECEIVE_THE_ONE_TIME_VC_SUB_INFO;
        String result = validateWithinLocatorText(locator,txt,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    public Object validateTechnicalSupport9thQuestionSubInfo(String language, String txt) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_DO_I_NEED_TO_ENTER_A_VC_EACH_TIME_I_ACCESS_MY_CLAIM_SUB_INFO_FR : LO_TXT_DO_I_NEED_TO_ENTER_A_VC_EACH_TIME_I_ACCESS_MY_CLAIM_SUB_INFO;
        String result = validateWithinLocatorText(locator,txt,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    public Object validateTechnicalSupport10thQuestionSubInfo(String language, String txt) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_CAN_I_RECEIVE_THE_ONE_TIME_VERIFICATION_CODE_BY_EMAIL_SUB_INFO_FR : LO_TXT_CAN_I_RECEIVE_THE_ONE_TIME_VERIFICATION_CODE_BY_EMAIL_SUB_INFO;
        String result = validateWithinLocatorText(locator,txt,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    public Object validateTechnicalSupport11thQuestionSubInfo(String language, String txt) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_WILL_I_INCUR_CHARGES_FOR_RECEIVING_THE_VERIFICATION_CODE_SUB_INFO_FR : LO_TXT_WILL_I_INCUR_CHARGES_FOR_RECEIVING_THE_VERIFICATION_CODE_SUB_INFO;
        String result = validateWithinLocatorText(locator,txt,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    public Object validateTechnicalSupport12thQuestionSubInfo(String language, String txt) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_CAN_I_USE_AN_INTERNATIONAL_MOBILE_PHONE_TO_AUTHENTICATE_SUB_INFO_FR : LO_TXT_CAN_I_USE_AN_INTERNATIONAL_MOBILE_PHONE_TO_AUTHENTICATE_SUB_INFO;
        String result = validateWithinLocatorText(locator,txt,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    public Object validateTechnicalSupport13thQuestionSubInfo(String language, String txt) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_CAN_I_REPLY_TO_THE_NUMBER_THAT_SENDS_THE_ONE_TIME_VC_SUB_INFO_FR : LO_TXT_CAN_I_REPLY_TO_THE_NUMBER_THAT_SENDS_THE_ONE_TIME_VC_SUB_INFO;
        String result = validateWithinLocatorText(locator,txt,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }


    public Object validateWhichInsuranceInfoQuestion() {
        String result = clickLocator(LO_TXT_WHICH_INSURANCE_INFO_DO_I_NEED, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    public Object clickClaimingTitle() {
        String result = clickLocator(LO_TXT_CLAIMING, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    public Object validateWhatShouldIdoIfIreceiveBillsQuestion() {
        String result = validateLocatorExists(LO_TXT_WHAT_SHOULD_I_DO_IF_I_RECEIVE_BILLS , FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object clickHowCanIRetrieveADraftClaimQuestion(String language) {
         String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_HOW_CAN_I_RETRIEVE_A_DRAFT_CLAIM_FR : LO_TXT_HOW_CAN_I_RETRIEVE_A_DRAFT_CLAIM;
        String result = clickLocator(locator, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    public Object clickDidNotReceiveOneTimeVerificationCodeQuestion(String language) {
         String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_I_DID_NOT_RECEIVE_THE_ONE_TIME_VERIFICATION_CODE_FR : LO_TXT_I_DID_NOT_RECEIVE_THE_ONE_TIME_VERIFICATION_CODE;
        String result = clickLocator(locator, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    public Object clickOneTimeVerificationCodeReceivedNotWorkingQuestion(String language) {
         String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_ONE_TIME_VERIFICATION_CODE_RECEIVED_NOT_WORKING_FR : LO_TXT_ONE_TIME_VERIFICATION_CODE_RECEIVED_NOT_WORKING;
        String result = clickLocator(locator, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    public Object clickWhatShouldIDoIfMobilePhoneVerificationFailsQuestion(String language) {
         String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_WHAT_TO_DO_IF_MOBILE_PHONE_VERIFICATION_FAILS_FR : LO_TXT_WHAT_TO_DO_IF_MOBILE_PHONE_VERIFICATION_FAILS;
        String result = clickLocator(locator, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object clickWhatCanIDoIfINoLongerHaveAccessToMyPhoneQuestion(String language) {
         String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_WHAT_CAN_I_DO_IF_I_NO_LONGER_HAVE_ACCESS_TO_MY_PHONE_FR : LO_TXT_WHAT_CAN_I_DO_IF_I_NO_LONGER_HAVE_ACCESS_TO_MY_PHONE;
        String result = clickLocator(locator, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object clickToWhichMobilePhoneIsTheOneTimeVCSentQuestion(String language) {
         String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_TO_WHICH_MOBILE_PHONE_THE_ONE_TIME_VC_SENT_FR : LO_TXT_TO_WHICH_MOBILE_PHONE_THE_ONE_TIME_VC_SENT;
        String result = clickLocator(locator, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    public Object clickHowLongDoesItTakeToReceiveTheOneTimeVCQuestion(String language) {
         String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_HOW_LONG_DOES_IT_TAKE_TO_RECEIVE_THE_ONE_TIME_VC_FR : LO_TXT_HOW_LONG_DOES_IT_TAKE_TO_RECEIVE_THE_ONE_TIME_VC;
        String result = clickLocator(locator, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    public Object clickDoINeedToEnterAVerificationCodeEachTimeIAccessMyClaimQuestion(String language) {
         String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_DO_I_NEED_TO_ENTER_A_VC_EACH_TIME_I_ACCESS_MY_CLAIM_FR : LO_TXT_DO_I_NEED_TO_ENTER_A_VC_EACH_TIME_I_ACCESS_MY_CLAIM;
        String result = clickLocator(locator, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    public Object clickCanIReceiveTheOneTimeVCByEmailQuestion(String language) {
         String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_CAN_I_RECEIVE_THE_ONE_TIME_VERIFICATION_CODE_BY_EMAIL_FR : LO_TXT_CAN_I_RECEIVE_THE_ONE_TIME_VERIFICATION_CODE_BY_EMAIL;
        String result = clickLocator(locator, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    public Object clickWillIIncurChargesForReceivingTheVerificationCodeQuestion(String language) {
         String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_WILL_I_INCUR_CHARGES_FOR_RECEIVING_THE_VERIFICATION_CODE_FR : LO_TXT_WILL_I_INCUR_CHARGES_FOR_RECEIVING_THE_VERIFICATION_CODE;
        String result = clickLocator(locator, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    public Object clickCanIUseAnInternationalMobilePhoneToAuthenticateQuestion(String language) {
         String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_CAN_I_USE_AN_INTERNATIONAL_MOBILE_PHONE_TO_AUTHENTICATE_FR : LO_TXT_CAN_I_USE_AN_INTERNATIONAL_MOBILE_PHONE_TO_AUTHENTICATE;
        String result = clickLocator(locator, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    public Object clickCanIReplyToTheNumberThatSendstheOneTimeVCQuestion(String language) {
         String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_CAN_I_REPLY_TO_THE_NUMBER_THAT_SENDS_THE_ONE_TIME_VC_FR : LO_TXT_CAN_I_REPLY_TO_THE_NUMBER_THAT_SENDS_THE_ONE_TIME_VC;
        String result = clickLocator(locator, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object clickDoINeedAMobilePhoneToReceiveTheOneTimeVerificationCodeQuestion(String language) {
         String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_DO_I_NEED_MOBILE_PHONE_TO_RECEIVE_ONE_TIME_VC_FR : LO_TXT_DO_I_NEED_MOBILE_PHONE_TO_RECEIVE_ONE_TIME_VC;
        String result = clickLocator(locator, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object clickTechnicalSupportTitle(String language) {
         String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_TECHNICAL_SUPPORT_FR : LO_TXT_TECHNICAL_SUPPORT;
        String result = clickLocator(locator, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object validateHowCanIRetrieveADraftClaimQuestion() {
        String result = validateLocatorExists(LO_TXT_HOW_CAN_I_RETRIEVE_A_DRAFT_CLAIM , FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
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
     * Validates if the claim number input field exists.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateclaimNumberInputFieldExists(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_EDT_CLAIM_NUMBER_INPUT_FIELD_FR : LO_EDT_CLAIM_NUMBER_INPUT_FIELD;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if the BACK button exists.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateBackButtonExists(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_BUT_BACK_FR : LO_BUT_BACK;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
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
     * Validates if Frech link with its globe icon exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateFrenchToggle_Dark() {
        String result = validateLocatorExists(LO_LNK_FRENCH_TOGGLE_FR_DARK, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj; 
    }

    /**
     * Enter invalid Claim Number with 4 digits.
     * 
     * @param claimNumber The six digits to be entered for the credit card.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object enterClaimNumber(String language, String claimNumber) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_EDT_CLAIM_NUMBER_FIELD_FR : LO_EDT_CLAIM_NUMBER_FIELD;
        String result = setText(locator, claimNumber, FW_ConfigMgr.getDefaultTimeout(), false);
        clickLocator(LO_TXT_CLAIM_NUMBER_LABEL , FW_ConfigMgr.getDefaultTimeout());
        waitForDuration(12, "s", false); // Wait to perform next check
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if the error message "Please enter a valid global excel claim number (i.e. 7 digits)" is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateValidGlobalExcelNumberErrorPresent(String language, String errorMessage) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_ERROR_VALID_GLOBAL_EXCEL_NUMBER_FR : LO_TXT_ERROR_VALID_GLOBAL_EXCEL_NUMBER;
        String result = validateWithinLocatorText(locator,errorMessage,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if the error message "Claim not found. Please ensure that you have entered the claim number correctly and try again." is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateClaimNotFoundErrorPresent(String language, String errorMessage) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_ERROR_CLAIM_NOT_FOUND_FR : LO_TXT_ERROR_CLAIM_NOT_FOUND;
        String result = validateWithinLocatorText(locator,errorMessage,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if the error message "Claim not found. Please ensure that you have entered the claim number correctly and try again." is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateClaimNotFoundErrorPresent2(String language, String errorMessage) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_ERROR_CLAIM_NOT_FOUND_2_FR : LO_TXT_ERROR_CLAIM_NOT_FOUND_2;
        String result = validateWithinLocatorText(locator,errorMessage,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if the error message "Claim not found. Please ensure that you have entered the claim number correctly and try again." is not present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateClaimNotFoundErrorNotPresent(String language, String errorMessage) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_ERROR_CLAIM_NOT_FOUND_FR : LO_TXT_ERROR_CLAIM_NOT_FOUND;
        String result = validateNotWithinLocatorText(locator,errorMessage,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if the error message "Please enter a valid global excel claim number (i.e. 7 digits)" is not present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateValidGlobalExcelNumberErrorNotPresent(String language, String errorMessage) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_ERROR_VALID_GLOBAL_EXCEL_NUMBER_FR : LO_TXT_ERROR_VALID_GLOBAL_EXCEL_NUMBER;
        String result = validateNotWithinLocatorText(locator,errorMessage,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Clear the existing value in the claim number input field by setting it to an empty string before entering a new value.
     * 
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object clearOutTheClaimNumberInputField(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_EDT_CLAIM_NUMBER_FIELD_FR : LO_EDT_CLAIM_NUMBER_FIELD;
        String result = setText(locator, "", FW_ConfigMgr.getDefaultTimeout() , true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    };

    /**
     * Clicks the 'Back' button.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object clickBackButton() {
        String result = clickLocator(LO_BUT_BACK, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object clickVisitOurHelpCentre(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_BUT_VISIT_OUR_HELP_CENTRE_FR : LO_BUT_VISIT_OUR_HELP_CENTRE;
        String result = clickLocator(locator, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Clicks the 'VIEW STATUS' button.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object clickViewStatusButton(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_BUT_VIEW_STATUS_FR : LO_BUT_VIEW_STATUS;
        String result = clickLocator(locator, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    public Object applyWait() {
        waitForDuration(8, "s", true);
        String result = "[Pass] - Wait applied.";
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
     * Validates if Gem top logo is present and it's a link.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object validateGem_Top_Left_Logo_TD() {
        String result = validateLocatorExists(LO_IMG_GEM_TOP_LOGO_TD, FW_ConfigMgr.getDefaultTimeout(),
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
    public Object validateGem_Top_Left_Logo_Manulife() {
        String result = validateLocatorExists(LO_IMG_GEM_TOP_LOGO_MANULIFE, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if Gem bottom logo is present and it's not a link.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object validateGemBottom_Left_Logo_GEM_MGB() {
        String result = validateLocatorExists(LO_IMG_GEM_BOTTOM_LOGO_GEM_MGB, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if Gem bottom logo is present and it's not a link.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object validateGemBottom_Left_Logo_MANULIFE_MGB() {
        String result = validateLocatorExists(LO_IMG_GEM_BOTTOM_LOGO_MANULIFE_MGB, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if Frech link with its globe icon exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateFrenchToggle(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_LNK_FRENCH_TOGGLE_FR : LO_LNK_FRENCH_TOGGLE_EN;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj; 
    }

    /**
     * Validates if current webpage is loaded and correct.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object validateOnPageCIBC() {
        // waitForDuration(5, "s", false); // Wait to perform next check
        String result = validateLocatorExists(LO_HOME_PAGE_VERIFY_CIBC, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if current webpage is loaded and correct.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object validateOnPageAMEX() {
        String result = validateLocatorExists(LO_TXT_AMEX_HOME_PAGE_VERIFY, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if the page main heading paragraph is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object validateMainHeadingParagraph() {
        String result = validateLocatorExists(LO_TXT_MAIN_HEADING_PARAGRAPH, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    /**
     * Validates if the paragraph for the veiw claim status heading is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object validateViewClaimParagraph(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_VIEW_CLAIM_STATUS_PARAGRAPH_FR : LO_TXT_VIEW_CLAIM_STATUS_PARAGRAPH;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

     /**
     * Validates if the Claim Number filed is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object validateClaimNumberField(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_EDT_CLAIM_NUMBER_INPUT_FIELD_FR : LO_EDT_CLAIM_NUMBER_INPUT_FIELD;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if the VIEW STATUS button is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object validateViewStatusButton(String language) {
        String claimNumber="1234567";
        setText(LO_EDT_CLAIM_NUMBER_FIELD, claimNumber, FW_ConfigMgr.getDefaultTimeout(), false);
        clickLocator("//label[contains(text(), 'Claim Number')]", FW_ConfigMgr.getDefaultTimeout());
        //waitForDuration(5,"s",true);
        String result = validateLocatorExists(LO_BUT_VIEW_STATUS, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if Gem bottom logo is present and it's not a link.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object validateGemBottom_Left_Logo_Light_Gem() {
        String result = validateLocatorExists(LO_IMG_GEM_BOTTOM_LOGO_LIGHT_GEM, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if Gem bottom logo is present and it's not a link.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object validateGemBottom_Left_Logo_Plain() {
        String result = validateLocatorExists(LO_IMG_GEM_BOTTOM_LOGO_PLAIN, FW_ConfigMgr.getDefaultTimeout(),
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
     * Validates if Gem bottom logo is present and it's not a link.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object validateGemBottom_Left_Logo_CL() {
        String result = validateLocatorExists(LO_IMG_GEM_BOTTOM_LOGO_CL, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if Gem bottom logo is present and it's not a link.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object validateGemBottom_Left_Logo_Scotia() {
        String result = validateLocatorExists(LO_IMG_GEM_BOTTOM_LOGO_SCOTIA, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

     /**
     * Validates if Gem bottom logo is present and it's not a link.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object validateGemBottom_Left_Logo_Dark_Gem() {
        String result = validateLocatorExists(LO_IMG_GEM_BOTTOM_LOGO_DARK_GEM, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if Gem bottom logo is present and it's not a link.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object validateGemBottom_Left_Logo_SunLife() {
        String result = validateLocatorExists(LO_IMG_GEM_BOTTOM_LOGO_SUNLIFE, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if The "START A NEW CLAIM" link in the footer of the page is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object validateStartNewClaimFooterLink_LightBackground() {
        String result = validateLocatorExists(LO_LNK_START_NEW_CLAIM_FOOTER_LIGHT, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if Gem bottom logo is present and it's not a link.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object validateGemBottom_Left_Logo_TD() {
        String result = validateLocatorExists(LO_IMG_GEM_BOTTOM_LOGO_TD, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if Gem bottom logo is present and it's not a link.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object validateGemBottom_Left_Logo_ORION() {
        String result = validateLocatorExists(LO_IMG_GEM_BOTTOM_LOGO_ORION, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if the 'View Status' exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object validateViewStatus() {
        String result = validateLocatorExists(LO_BUT_VIEW_STATUS, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if Gem bottom logo is present and it's not a link.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object validateGemBottom_Left_Logo() {
        String result = validateLocatorExists(LO_IMG_GEM_BOTTOM_LOGO_DARK, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if Gem bottom logo is present and it's not a link.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object validateGemBottom_Left_Logo_BCAA() {
        String result = validateLocatorExists(LO_IMG_GEM_BOTTOM_LOGO_BCAA, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if The "START A NEW CLAIM" link in the footer of the page is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object validateStartNewClaimFooterLink() {
        String result = validateLocatorExists(LO_LNK_START_NEW_CLAIM_FOOTER, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if Gem bottom logo is present and it's not a link.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object validateGemBottom_Left_Logo_Manulife() {
        String result = validateLocatorExists(LO_IMG_GEM_BOTTOM_LOGO_MANULIFE, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if Gem bottom logo is present and it's not a link.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object validateGemBottom_Left_Logo_Intact() {
        String result = validateLocatorExists(LO_IMG_GEM_BOTTOM_LOGO_INTACT, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if The "CONTINUE DRAFT CLAIM" link in the footer of the page is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object validateContinueDraftClaimFooterLink() {
        String result = validateLocatorExists(LO_LNK_CONTINUE_DRAFT_CLAIM_FOOTER, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if The "SUBMIT DOCUMENTS" link in the footer of the page is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object validateSubmitDocumentsFooterLink() {
        String result = validateLocatorExists(LO_LNK_SUBMIT_DOCUMENTS_FOOTER, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if The "SUBMIT DOCUMENTS" link in the footer of the page is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object validateSubmitDocumentsFooterLink_LightBackground() {
        String result = validateLocatorExists(LO_LNK_SUBMIT_DOCUMENTS_FOOTER_LIGHT, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if the Help Centre at bottom right is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object validateHelpCentreFooterLink_Light() {
        String result = validateLocatorExists(LO_LNK_HELP_CENTRE_BOTTOM_LIGHT, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if The "CONTINUE DRAFT CLAIM" link in the footer of the page is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object validateContinueDraftClaimFooterLink_LightBackground() {
        String result = validateLocatorExists(LO_LNK_CONTINUE_DRAFT_CLAIM_FOOTER_LIGHT, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if the Help Centre at bottom right is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object validateHelpCentreFooterLink() {
        String result = validateLocatorExists(LO_LNK_HELP_CENTRE_BOTTOM, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if the "MEDICAL EMERGENCY HELPLINE" Heading is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object validateMedicalEmergencyHelpLineHeading() {
        String result = validateLocatorExists(LO_TXT_MEDICAL_EMERGENCY_HELPLINE_HEADING, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if the "MEDICAL EMERGENCY HELPLINE" Non Toll Free Number is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object validateMedicalEmergencyHelpLineNonTollFree(String number) {
        LO_TXT_MEDICAL_EMERGENCY_HELPLINE_NON_TOLL_FREE = LO_TXT_MEDICAL_EMERGENCY_HELPLINE_NON_TOLL_FREE + "'" + number + "']";
        String result = validateLocatorExists(LO_TXT_MEDICAL_EMERGENCY_HELPLINE_NON_TOLL_FREE, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if the "MEDICAL EMERGENCY HELPLINE" Toll free Number is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object validateMedicalEmergencyHelpLineTollFree(String tollFreeNumber) {
        LO_TXT_MEDICAL_EMERGENCY_HELPLINE_TOLL_FREE = LO_TXT_MEDICAL_EMERGENCY_HELPLINE_TOLL_FREE + "'" + tollFreeNumber + "']";
        String result = validateLocatorExists(LO_TXT_MEDICAL_EMERGENCY_HELPLINE_TOLL_FREE, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if the "FOLLOW UP ON YOUR CLAIM" Heading is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object validateFollowUpOnYourClaimFooterHeading() {
        String result = validateLocatorExists(LO_TXT_FOLLOW_UP_ON_YOUR_CLAIM_HEADING, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if the "FOLLOW UP ON YOUR CLAIM" paragraph is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object validateFollowUpOnYourClaimFooterParagraph() {
        String result = validateLocatorExists(LO_TXT_FOLLOW_UP_ON_YOUR_CLAIM_PARAGRAPH, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if the 'Sign In' exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object validateSignIn() {
        String result = validateLocatorExists(LO_BUT_SIGN_IN, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if the GEM FOOTER DISCLAIMER is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object validateFooterDisclaimer2() {
        String result = validateLocatorExists(LO_TXT_GEM_FOOTER_DISCLAIMER_2, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if the GEM FOOTER DISCLAIMER is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object validateFooterDisclaimer_CL() {
        String result = validateLocatorExists(LO_TXT_GEM_FOOTER_DISCLAIMER_CL, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if the GEM FOOTER DISCLAIMER is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object validateFooterDisclaimer() {
        String result = validateLocatorExists(LO_TXT_GEM_FOOTER_DISCLAIMER, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if the Trade Mark Notice is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object validateFooterTradeMarkNotice() {
        String result = validateLocatorExists(LO_TXT_TRADE_MARK_NOTICE, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if the GEM FOOTER DISCLAIMER is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object validateFooterDisclaimer_SunLife() {
        String result = validateLocatorExists(LO_TXT_GEM_FOOTER_DISCLAIMER_SUNLIFE, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if the GEM FOOTER DISCLAIMER is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object validateFooterDisclaimerTD() {
        String result = validateLocatorExists(LO_TXT_GEM_FOOTER_DISCLAIMER_TD, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if the GEM FOOTER DISCLAIMER is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object validateFooterDisclaimer_Orion() {
        String result = validateLocatorExists(LO_TXT_GEM_FOOTER_DISCLAIMER_ORION, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if the GEM FOOTER DISCLAIMER is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object validateFooterDisclaimer_MGB() {
        String result = validateLocatorExists(LO_TXT_GEM_FOOTER_DISCLAIMER_MGB, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if the GEM FOOTER DISCLAIMER is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object validateFooterDisclaimerManulife() {
        String result = validateLocatorExists(LO_TXT_GEM_FOOTER_DISCLAIMER_MANULIFE, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if the Copy Right Notice is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object validateFooterCopyRightNotice() {
        String result = validateLocatorExists(LO_TXT_COPY_RIGHT_NOTICE, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    /**
     * Validates if the GEM FOOTER DISCLAIMER is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object validateFooterDisclaimerBCAA() {
        String result = validateLocatorExists(LO_TXT_GEM_FOOTER_DISCLAIMER_BCAA, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if the Copy Right Notice is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object validateFooterCopyRightNotice_2025() {
        String result = validateLocatorExists(LO_TXT_COPY_RIGHT_NOTICE_2025, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    /**
     * Validates if the Privacy Statement link is present with a go to icon.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object validateFooterPrivacyStatement() {
        String result = validateLocatorExists(LO_LNK_PRIVACY_STATEMENT, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if the Conditions of Use link is present with a go to icon.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object validateFooterConditionsOfUse_LightBackground() {
        String result = validateLocatorExists(LO_LNK_CONDITIONS_OF_USE_LIGHT, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if the "MEDICAL EMERGENCY HELPLINE" Heading is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object validateMedicalEmergencyHelpLineHeading_LightBackgroundNoCallIcon() {
        String result = validateLocatorExists(LO_TXT_MEDICAL_EMERGENCY_HELPLINE_HEADING_NO_CALL_ICON, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if the "MEDICAL EMERGENCY HELPLINE" Heading is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object validateMedicalEmergencyHelpLineParagraph_LightBackground_CommercialSVBC() {
        String result = validateLocatorExists(LO_TXT_MEDICAL_EMERGENCY_HELPLINE_PARAGRAPH_LIGHT_CSVBC, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    /**
     * Validates if the "MEDICAL EMERGENCY HELPLINE" Heading is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object validateMedicalEmergencyHelpLineParagraph_LightBackground_ConsumerSBC() {
        String result = validateLocatorExists(LO_TXT_MEDICAL_EMERGENCY_HELPLINE_PARAGRAPH_LIGHT_CSBC, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if the "MEDICAL EMERGENCY HELPLINE" Non Toll Free Number is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object validateMedicalEmergencyHelpLineNonTollFree2(String number) {
        LO_TXT_MEDICAL_EMERGENCY_HELPLINE_NON_TOLL_FREE2 = LO_TXT_MEDICAL_EMERGENCY_HELPLINE_NON_TOLL_FREE2 + "'" + number + "']";
        String result = validateLocatorExists(LO_TXT_MEDICAL_EMERGENCY_HELPLINE_NON_TOLL_FREE2, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if the "MEDICAL EMERGENCY HELPLINE" Toll free Number is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object validateMedicalEmergencyHelpLineTollFree2(String tollFreeNumber) {
        LO_TXT_MEDICAL_EMERGENCY_HELPLINE_TOLL_FREE2 = LO_TXT_MEDICAL_EMERGENCY_HELPLINE_TOLL_FREE2 + "'" + tollFreeNumber + "']";
        String result = validateLocatorExists(LO_TXT_MEDICAL_EMERGENCY_HELPLINE_TOLL_FREE2, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if the "MEDICAL EMERGENCY HELPLINE" Heading is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object validateMedicalEmergencyHelpLineHeading_LightBackground() {
        String result = validateLocatorExists(LO_TXT_MEDICAL_EMERGENCY_HELPLINE_HEADING_LIGHT, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if the Privacy Statement link is present with a go to icon.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object validateFooterPrivacyStatement_LightBackground() {
        String result = validateLocatorExists(LO_LNK_PRIVACY_STATEMENT_LIGHT, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if the Conditions of Use link is present with a go to icon.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object validateFooterConditionsOfUse() {
        String result = validateLocatorExists(LO_LNK_CONDITIONS_OF_USE, FW_ConfigMgr.getDefaultTimeout(),
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
    public Object validateGem_Top_Left_Logo_Amex() {
        String result = validateLocatorExists(LO_IMG_GEM_TOP_LOGO_AMEX, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

}
