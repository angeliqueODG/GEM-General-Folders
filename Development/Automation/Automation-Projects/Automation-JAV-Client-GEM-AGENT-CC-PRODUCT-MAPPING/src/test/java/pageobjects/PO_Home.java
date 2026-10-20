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
 * Page Object (PO) class used in the Page Object (PO) design pattern. Inherits
 * from the CU_Appian class.
 */
// [Note: Automation Engineer, rename this Page Object (PO) class to match the
// filename.]
public class PO_Home extends CU_Appian {

    // [Note: Automation Engineer, define the Page Object (PO) locators (LO) here.]
    private static final String LO_HOME_PAGE_VERIFY = "//h1[contains(text(), 'Welcome to your  Claim Centre')]";
    private static final String LO_TXT_HOME_PAGE_VERIFY_ZURICH = "//h1[contains(text(), 'Welcome to your Travel  Claim Centre')]";
    private static final String LO_TXT_AMEX_HOME_PAGE_VERIFY = "//h1[text()='Welcome to your Travel Claim Centre for your  AMEX Card']";
    private static final String LO_HOME_PAGE_VERIFY_CIBC = "//h1[text()='Welcome to your Claim Centre for your  CIBC Credit Card']";
    private static final String LO_HOME_PAGE_VERIFY_ORION = "//span[text()='Welcome to your ' and strong='Orion Claim Centre' and span='administered by' and span='Global Excel Management']";
    private static final String LO_HOME_PAGE_VERIFY_MGB = "//h1[text()='Welcome to your Manulife Group Benefits Travel  Claim Centre']";
    private static final String LO_BUT_START_NEW_CLAIM = "//div[button[span[span[contains(text(),'START A NEW CLAIM')]]]]";
    private static final String LO_LNK_SSGEM_ACCOUNT = "//a[text()=' Single Sign-On with GEM Account (SSO)']";
    private static final String LO_RAD_EXTERNAL = "(//div[span[text()='Search Source']]/following-sibling::div/div//div)[2]";
    private static final String LO_RAD_EXTERNAL_FR = "(//div[span[text()='Search Source']]/following-sibling::div/div//div)[2]";
    private static final String LO_TXT_PRIMARY_CONTACT = "//div[span[text()='Primary Contact?']]";
    private static final String LO_TXT_PRIMARY_CONTACT_FR = "";
    private static final String LO_EDT_G_EMAIL = "//input[@type='email']";
    private static final String LO_EDT_POLICY_REFERENCE = "//div[label='Policy Reference']/following-sibling::div//div//input";
    private static final String LO_EDT_OTHER_REFERENCE = "//div[label='Other Reference']/following-sibling::div//div//input";
    private static final String LO_EDT_OTHER_REFERENCE_FR = "//div[label='Other Reference']/following-sibling::div//div//input";
    private static final String LO_EDT_POLICY_REFERENCE_FR = "//div[label='Policy Reference']/following-sibling::div//div//input";
    private static final String LO_BUT_NEXT = "//input[@type='submit']";
    private static final String LO_EDT_G_PASSWORD = "//input[@type='password']";
    private static final String LO_BUT_G_SIGN_IN = "//input[@type='submit' and @id='idSIButton9']";
    private static final String LO_BUT_SEARCH = "//button[span//span[text()='Search']]";
    private static final String LO_BUT_SEARCH_FR = "//button[span//span[text()='Search']]";
    private static final String LO_BUT_YES_STAY_SIGNED_IN_G = "//input[@type='submit' and @id='idSIButton9' and @value='Yes']";
    private static final String LO_BUT_CREATE_NEW_CLAIM_AS_AGENT = "//button[span//span[text()='Create new claim']]";
    private static final String LO_BUT_POLICIES = "//div[span[text()='Policies']]";
    private static final String LO_BUT_SEARCH_AND_CREATE_POLICY = "//button//span//span[text()='Search & create policy']";
    private static final String LO_BUT_SEARCH_AND_CREATE_POLICY_FR = "";
    private static final String LO_BUT_POLICIES_FR = "";
    private static final String LO_BUT_CREATE_NEW_CLAIM = "//span[text()='Create new claim']";
    private static final String LO_BUT_START_NEW_CLAIM_MGB = "//div[button[span[span[contains(text(),'Start A New Claim')]]]]";
    private static final String LO_BUT_CONTINUE_DRAFT_CLAIM = "//div[button[span[span[contains(text(),'CONTINUE DRAFT CLAIM')]]]]";
    private static final String LO_BUT_CHECK_CLAIM_STATUS = "//button//span[contains(text(), 'CHECK CLAIM STATUS')]";
    private static final String LO_BUT_SUBMIT_HERE = "//div[button[span[span[contains(text(),'Submit here')]]]]";
    private static final String LO_BUT_SUBMIT_HERE_ALL_CAPS = "//div[button[span[span[contains(text(),'SUBMIT HERE')]]]]";
    private static final String LO_BUT_VISIT_OUR_HELP_CENTRE = "//strong[contains(text(), 'VISIT OUR HELP CENTRE')]";
    private static final String LO_TXT_GEM_FOOTER_DISCLAIMER_CIBC = "//span[text()=\"Coverage under this policy is underwritten by Belair Insurance Company Inc. Belair Insurance Company Inc. has appointed Global Excel Management Inc. operating as “Global Excel” as the provider of all assistance and claims services under this coverage.\"]";
    private static final String LO_TXT_TRADE_MARK_NOTICE_AND_LOGOS = "//span[text()='All trademarks and logos are the property of their respective owners.']";
    private static final String LO_TXT_FOOTER_DISCLAIMER_SUNLIFE = "//span[contains(text(), 'The Sun Life Assurance Company of Canada (“Sun Life”) has appointed Global Excel Management Inc., as the provider of all assistance and claims services.')]";
    private static final String LO_TXT_GEM_FOOTER_DISCLAIMER_BELAIR = "//span[text()='Coverage under this policy is underwritten by Belair Insurance Company Inc. and administered by belairdirect Agency Inc. Belair Insurance Company Inc. has appointed Global Excel Management Inc. operating as “Global Excel” as the provider of all assistance and claims services under this coverage.']";
    private static final String LO_BUT_SIGN_IN = "//strong[contains(text(), 'SIGN IN')]";
    private static final String LO_TXT_SYSTEM_STATUS = "//h4[contains(text(), 'The System Has Encountered an Error')]";
    private static final String LO_BUT_VIEW_STATUS = "//strong[contains(text(),'VIEW STATUS')]";
    private static final String LO_TXT_ON_PAGE_VERIFICATION_APPIAN = "//h1[text()='Claim Opening']";
    private static final String LO_TXT_ELIGIBILITY = "//div[text()='Eligibility']";
    private static final String LO_TXT_CUSTOMER = "//div[text()='Customer']";
    private static final String LO_TXT_CUSTOMER_FR = "//div[text()='Customer']";
    private static final String LO_TXT_ELIGIBILITY_FR = "";
    private static final String LO_LST_CORPORATE_CLIENT = "//div[span[text()='Corporate Client']]/following-sibling::div//div[@role='combobox']";
    private static final String LO_RAD_CLIENT_DATABASE = "//div[span[text()='Where do you want to search?']]/following-sibling::div//label[text()='Client Database']";
    private static final String LO_RAD_CLIENT_DATABASE_FR = "";
    private static final String LO_LST_INSURANCE_TYPE = "//div[span[text()='Insurance Type']]/following-sibling::div//div[@role='combobox']";
    private static final String LO_TXT_POLICY_NUMBER_CERTIFICATE_ID = "//div[label='Policy Number/Certificate ID']/following-sibling::div//input";
    private static final String LO_EDT_CLAIM_NUMBER_AGENT = "//div[label='Claim Number']/following-sibling::div//input";
    private static final String LO_BUT_CONTINUE_AGENT = "//button[span//span[text()='Continue']]";
    private static final String LO_TXT_CORPORATE_CLIENT = "//div[span[text()='Corporate Client']]/following-sibling::div";
    private static final String LO_TXT_CORPORATE_CLIENT_FR = "//div[span[text()='Corporate Client']]/following-sibling::div";
    private static final String LO_EDT_GROUP_NAME_AGENT = "//div[label='Group name']/following-sibling::div//input";
    private static final String LO_TXT_POLICY_REFERENCE_VERIFICATION = "//div[span[text()='Policy Reference']]/following-sibling::div";
    private static final String LO_TXT_CORPORATE_CLIENT_VERIFICATION = "//div[div[div[p[text()='Corporate Client']]]]/following-sibling::div";
    private static final String LO_TXT_CORPORATE_CLIENT_UPDATED = "//div[div[div[p[text()='Corporate Client']]]]";
    private static final String LO_TXT_CORPORATE_CLIENT_UPDATED_FR = "//div[div[div[p[text()='Corporate Client']]]]/following-sibling::div";
    private static final String LO_TXT_ORGANIZATION_CODE_VERIFICATION = "//div[span[text()='Organization Code']]/following-sibling::div";
    private static final String LO_TXT_ISSUE_DATE_VERIFICATION = "//div[span[text()='Issue Date']]/following-sibling::div";
    private static final String LO_TXT_START_DATE_VERIFICATION = "//div[span[text()='Start Date']]/following-sibling::div";
    private static final String LO_TXT_END_DATE_VERIFICATION = "//div[span[text()='End Date']]/following-sibling::div";
    private static final String LO_TXT_FIRST_NAME_UPDATED = "//div[span[text()='First Name']]/following-sibling::div";
    private static final String LO_TXT_LAST_NAME_UPDATED = "//div[span[text()='Last Name']]/following-sibling::div";
    private static final String LO_TXT_LAST_NAME_UPDATED_FR = "//div[span[text()='Last Name']]/following-sibling::div";
    private static final String LO_TXT_PRODUCT_CODE_VERIFICATION = "//div[span[text()='Product Code']]/following-sibling::div";
    private static final String LO_TXT_PRODUCT_CODE_VERIFICATION_FR = "//div[span[text()='Product Code']]/following-sibling::div";
    private static final String LO_TXT_END_DATE_VERIFICATION_FR = "//div[span[text()='End Date']]/following-sibling::div";
    private static final String LO_TXT_START_DATE_VERIFICATION_FR = "//div[span[text()='Start Date']]/following-sibling::div";
    private static final String LO_TXT_ISSUE_DATE_VERIFICATION_FR = "//div[span[text()='Issue Date']]/following-sibling::div";
    private static final String LO_TXT_ORGANIZATION_CODE_VERIFICATION_FR = "//div[span[text()='Organization Code']]/following-sibling::div";
    private static final String LO_TXT_CORPORATE_CLIENT_VERIFICATION_FR = "(//div[span[text()='Corporate Client']]/following-sibling::div)[2]";
    private static final String LO_TXT_POLICY_REFERENCE_VERIFICATION_FR = "//div[span[text()='Policy Reference']]/following-sibling::div";
    private static final String LO_EDT_GROUP_NAME_AGENT_VERIFICATION = "//div[label='Group name']/following-sibling::div//input[@value='New Testing Group ltd']";
    private static final String LO_EDT_CITY_NAME_AGENT_VERIFICATION = "//div[label='City']/following-sibling::div//input[@value='New City Of Testing']";
    private static final String LO_RAD_PREFERRED_METHOD_COMMUNICATION_EMAIL_AGENT = "//div[span='Preferred Method of Communication']/following-sibling::div//label[text()='Email']";
    private static final String LO_RAD_YES_COB_IN_AGENT = "//div[span='Is this a Coordination of Benefit (COB-IN) claim?']/following-sibling::div//label[text()='Yes']";
    private static final String LO_LST_REASON_FOR_INTERRUPTION_AGENT = "//div[span[text()='Reason for the interruption']]/following-sibling::div//div[@role='combobox']";
    private static final String LO_LST_REASON_FOR_CANCELLING_AGENT = "//div[span[text()='Reason for cancelling']]/following-sibling::div//div[@role='combobox']";
    private static final String LO_LST_REASON_FOR_INTERRUPTION_RELATED_TO_AGENT = "//div[span[text()='Is the reason for interruption related to:']]/following-sibling::div//div[@role='combobox']";
    private static final String LO_LST_REASON_FOR_CANCELLATION_RELATED_TO_AGENT = "//div[span[text()='Is the reason for cancelling related to:']]/following-sibling::div//div[@role='combobox']";
    private static final String LO_RAD_YES_EXISTING_GE_CLAIM_NUMBER_AGENT = "//div[span='Do you have an existing Global Excel claim number related to this claim that you have already submitted?']/following-sibling::div//label[text()='Yes']";
    private static final String LO_LST_CLAIM_TYPE_AGENT = "//div[span[text()='Claim Type']]/following-sibling::div//div[@role='combobox']";
    private static final String LO_LNK_HELP_CENTRE_HEADER = "((//span[text()='FR' or text()='FRANÇAIS']/ancestor::div[1]/../../preceding-sibling::div)[2]/div) | (//a[contains(text(), 'HELP CENTRE')])[1]";
    private static final String LO_LNK_HELP_CENTRE_FOOTER = "(//span/a[text()='HELP CENTRE'])[1] | (//span/a[text()='HELP CENTRE'])[2]";
    private static final String LO_BUT_FRANÇAIS = "//div[p[span[a[text()='FRANÇAIS']]]]";
    private static final String LO_HOME_PAGE_VERIFY_FRENCH__TRAVEL_CLAIM_CENTER = "//h1[contains(text(), 'Bienvenue au  centre de réclamation de voyage')]";
    private static final String LO_HOME_PAGE_VERIFY_FRENCH_MGB = "//h1[text()=\"Bienvenue à votre  centre de réclamation voyage de l'assurance collective de Manuvie\"]";
    private static final String LO_HOME_PAGE_VERIFY_FRENCH = "//h1[contains(text(), 'Bienvenue au  centre de réclamation')]";
    private static final String LO_TXT_HOME_PAGE_VERIFY_FRENCH_PAGE_AMEX = "//span[contains(text(), 'Bienvenue à votre centre de réclamation de voyage pour votre ') and strong[contains(text(), 'carte AMEX')]]";
    private static final String LO_FR_HOME_PAGE_VERIFY = "//strong[contains(text(), 'carte de crédit CIBC')]";
    private static final String LO_BUT_ENGLISH = "//div[p[span[a[text()='ENGLISH']]]]";
    private static final String LO_HOME_PAGE_VERIFY_TRAVEL_CLAIM_CENTER = "//h1[contains(text(), 'Welcome to your Travel  Claim Centre')]";
    private static final String LO_BUT_BURNNER_TOP_YELLOW_IMPORTANT_MESSAGE = "//div[@class='SideBySideGroup---side_by_side SideBySideGroup---default_direction SideBySideGroup---top']/div[div//strong[contains(text(), ' Important Information – Potential Canada Post mail disruption')]]/following-sibling::div//div[@class='FieldLayout---input_below']";
    private static final String LO_BUT_BURNNER_TOP_YELLOW_TEST_INDIVIDUAL_MESSAGE = "//div[@class='SideBySideGroup---side_by_side SideBySideGroup---default_direction SideBySideGroup---top']/div[div//strong[contains(text(), 'Test Individual message')]]/following-sibling::div//div[@class='FieldLayout---input_below']";
    private static final String LO_IMG_GEM_TOP_LOGO = "//a//img[@src='https://geihpvqvwebgencacn1.blob.core.windows.net/appian-portal/logo_header_en_GEM.png' or @src='https://geihpvtvwebgencacn1.blob.core.windows.net/appian-portal/logo_header_en_GEM.png']";
    private static final String LO_IMG_GEM_TOP_LOGO_BCAA = "//a//img[@src='https://geihpvqvwebgencacn1.blob.core.windows.net/appian-portal/logo_header_en_BCAA.png' or @src='https://geihpvtvwebgencacn1.blob.core.windows.net/appian-portal/logo_header_en_BCAA.png']";
    private static final String LO_TXT_MAIN_HEADING_PARAGRAPH = "//p//span[contains(text(), 'We understand that facing unexpected situations in an unfamiliar environment can be stressful. In order to help, we offer assistance services with experts ready to support you in case of an emergency.')]";
    private static final String LO_LNK_HELP_CENTRE_TOP = "//span[a[contains(text(), 'HELP CENTRE')]]";
    private static final String LO_HOME_PAGE_VERIFY_BELAIR = "//h1[text()='Welcome to your  Travel Claim Centre']";
    private static final String LO_LNK_HELP_CENTRE_TOP_AS_LINK = "//p[span[@class='IconWidget---inLightBackground']/following-sibling::span[a[contains(text(), 'HELP CENTRE')]]]";
    private static final String LO_TXT_NEW_CLAIM_HEADING_CARD = "//h2[contains(text(), 'Start A New Claim')]";
    private static final String LO_TXT_NEW_CLAIM_PARAGRAPH_CARD = "//span[contains(text(), 'Ready to submit a new claim? Begin the process here.')]";
    private static final String LO_TXT_DRAFT_CLAIM_HEADING_CARD = "//h2[contains(text(), 'Draft Claim')]";
    private static final String LO_TXT_DRAFT_CLAIM_PARAGRAPH_CARD = "//span[contains(text(), 'Already started a new claim? Continue your submission here.')]";
    private static final String LO_TXT_ACTIVE_CLAIM_HEADING_CARD = "//h2[contains(text(), 'Active Claim')]";
    private static final String LO_TXT_SUBMIT_DOCUMENTS_HEADING_CARD = "//h2[contains(text(), 'Submit Documents')]";
    private static final String LO_TXT_ACTIVE_CLAIM_PARAGRAPH_CARD = "//span[contains(text(), 'Submitted a claim and want to check the status? Get updates here.')]";
    private static final String LO_TXT_SUBMIT_DOCUMENTS_PARAGRAPH_CARD = "//span[contains(text(), 'Want to submit additional documents for an existing claim?')]";
    private static final String LO_TXT_NEED_HELP_HEADING = "//h2[contains(text(), \"Need help? We're here to assist you!\")]";
    private static final String LO_TXT_NEED_HELP_PARAGRAPH = "//span[text()=\"Whether you're at home or travelling, Global Excel is here to assist you. Visit our Help Centre to learn more about the tools and services available to you.\"]";
    private static final String LO_IMG_ASSISTANCE_ICON_AMEX = "//div//img[@src='https://geihpvqvwebgencacn1.blob.core.windows.net/appian-portal/assistance_icon_AMEX.png' or @src='https://geihpvtvwebgencacn1.blob.core.windows.net/appian-portal/assistance_icon_AMEX.png']";
    private static final String LO_IMG_ASSISTANCE_ICON_BCAA = "//div//img[@src='https://geihpvqvwebgencacn1.blob.core.windows.net/appian-portal/assistance_icon_BCAA.png' or @src='https://geihpvtvwebgencacn1.blob.core.windows.net/appian-portal/assistance_icon_BCAA.png']";
    private static final String LO_IMG_GEM_BOTTOM_LOGO_DARK = "//div//img[@src='https://geihpvqvwebgencacn1.blob.core.windows.net/appian-portal/logo_footer_GEM_claim_center_en_dark.png' or @src='https://geihpvtvwebgencacn1.blob.core.windows.net/appian-portal/logo_footer_GEM_claim_center_en_dark.png']";
    private static final String LO_IMG_GEM_BOTTOM_LOGO_BCAA = "//div//img[@src='https://geihpvqvwebgencacn1.blob.core.windows.net/appian-portal/logo_footer_en_BCAA.png' or @src='https://geihpvtvwebgencacn1.blob.core.windows.net/appian-portal/logo_footer_en_BCAA.png']";
    private static final String LO_LNK_START_NEW_CLAIM_FOOTER = "//p[span[@class='IconWidget---medium IconWidget---inDarkBackground']/following-sibling::span/a[contains(text(), 'START A NEW CLAIM')]]";
    private static final String LO_LNK_CONTINUE_DRAFT_CLAIM_FOOTER = "//p[span[@class='IconWidget---medium IconWidget---inDarkBackground']/following-sibling::span/a[contains(text(), 'CONTINUE DRAFT CLAIM')]]";
    private static final String LO_LNK_SUBMIT_DOCUMENTS_FOOTER = "//p[span[@class='IconWidget---medium IconWidget---inDarkBackground']/following-sibling::span/a[contains(text(), 'SUBMIT DOCUMENTS')]]";
    private static final String LO_LNK_HELP_CENTRE_BOTTOM = "//p[span[@class='IconWidget---medium IconWidget---inDarkBackground']/following-sibling::span[a[contains(text(), 'HELP CENTRE')]]]";
    private static final String LO_TXT_MEDICAL_EMERGENCY_HELPLINE_HEADING = "//h2[text()='MEDICAL EMERGENCY HELPLINE']";
    private static final String LO_TXT_FOLLOW_UP_ON_YOUR_CLAIM_HEADING = "//h3/span[contains(text(), 'FOLLOW UP ON YOUR CLAIM')]";
    private static final String LO_TXT_FOLLOW_UP_ON_YOUR_CLAIM_PARAGRAPH = "//p[contains(text(), 'You have an active claim? Follow up on your claim today in our Claim Centre!')]";
    private static final String LO_TXT_GEM_FOOTER_DISCLAIMER = "//p[text()=\"Global Excel Management provides claims and assistance services for Royal & Sun Alliance Insurance Company of Canada.\"]";
    private static final String LO_TXT_GEM_FOOTER_DISCLAIMER_BCAA = "//span[text()=\"BCAA (British Columbia Automobile Association) has appointed Global Excel Management Inc., as the provider of all assistance and claims services.\"]";
    private static final String LO_TXT_COPY_RIGHT_NOTICE = "//span[contains(text(), '2024') and text()='Global Excel Management Inc.' and text()='All rights reserved.']";
     private static final String LO_TXT_COPY_RIGHT_NOTICE_2025 = "//p[span[text()='2026' and text()='Global Excel Management Inc.' and text()='All rights reserved.']]";
     private static final String LO_TXT_TRADE_MARK_NOTICE = "//span[text()='All trademarks are the property of their respective owners.']";
     private static final String LO_TXT_FOOTER_DISCLAIMER_ZURICH = "//span[contains(text(), 'Benefits are underwritten by Zurich Insurance Company Ltd (Canadian Branch) “Zurich”. Zurich has appointed Global Excel Management Inc. operating as “Global Excel” as the provider of all assistance and claims services under this policy. For complete coverage information, please refer to your policy documents.')]";
    String LO_TXT_MEDICAL_EMERGENCY_HELPLINE_NON_TOLL_FREE = "//span/a[text()=";
    String LO_TXT_FIRST_NAME_SEARCHED = "(//p[text()=";
    // String LO_TXT_FIRST_NAME_UPDATED = "//div[span[text()=";
    String LO_TXT_FIRST_NAME_UPDATED_FR = "//div[span[text()=";
    //String LO_TXT_FIRST_NAME_SEARCHED = "(//p[text()=";
    String LO_TXT_POLICY_REFERENCE= "//p[strong[text()=";
    String LO_TXT_POLICY_REFERENCE_FR= "//p[strong[text()=";
    String LO_TXT_FIRST_NAME_SEARCHED_FR = "(//p[text()=";
    String  CLICK_ON_CORPORATE_CLIENT= "//div[span[text()='Corporate Client']]/following-sibling::div//p[text()='";
    String  CLICK_ON_REFERENCE_NUMBER= "//div[div[div[p[text()='Policy number']]]]/following-sibling::div//p[strong[text()='";
    String LO_TXT_PRODUCT_VERIFICATION = "//div[span[text()='Product']]/following-sibling::div//p[text()='";
    String LO_TXT_PRODUCT_VERIFICATION_FR = "//div[span[text()='Corporate Client']]/following-sibling::div//p[text()='";
    String  CLICK_ON_REFERENCE_NUMBER_FR= "//div[div[div[p[text()='Policy number']]]]/following-sibling::div//p[strong[text()='";
    String  CLICK_ON_CORPORATE_CLIENT_FR= "//div[span[text()='Corporate Client']]/following-sibling::div//p[text()='";
    String LO_TXT_MEDICAL_EMERGENCY_HELPLINE_TOLL_FREE = "//p[text()=\"(Toll free)\"]//span/a[text()=";
    String LO_TXT_MEDICAL_EMERGENCY_HELPLINE_NON_TOLL_FREE2 = "//span/a[text()=";
    String LO_TXT_MEDICAL_EMERGENCY_HELPLINE_TOLL_FREE2 = "//p[text()=\"(Toll free)\"]//span/a[text()=";
    private static final String LO_IMG_ASSISTANCE_ICON_GEM = "//div//img[@src='https://geihpvqvwebgencacn1.blob.core.windows.net/appian-portal/assistance_icon_GEM.png' or @src='https://geihpvtvwebgencacn1.blob.core.windows.net/appian-portal/assistance_icon_GEM.png']";
    private static final String LO_HOME_PAGE_VERIFY_FRENCH_CIBC = "//span[span and text()='Bienvenue au centre de réclamations pour votre ' and strong='carte de crédit CIBC']";
    private static final String LO_IMG_GEM_TOP_LOGO_CIBC = "//a//img[@src='https://geihpvqvwebgencacn1.blob.core.windows.net/appian-portal/logo_header_en_CIBC.png' or @src='https://geihpvtvwebgencacn1.blob.core.windows.net/appian-portal/logo_header_en_CIBC.png']";
    private static final String LO_IMG_GEM_BOTTOM_LOGO_DARK_GEM = "//div//img[@src='https://geihpvqvwebgencacn1.blob.core.windows.net/appian-portal/logo_footer_GEM_dark.png' or @src='https://geihpvtvwebgencacn1.blob.core.windows.net/appian-portal/logo_footer_GEM_dark.png']";
    private static final String LO_IMG_ASSISTANCE_ICON_CL = "//div//img[@src='https://geihpvqvwebgencacn1.blob.core.windows.net/appian-portal/assistance_icon_CanadaLife.png' or @src='https://geihpvtvwebgencacn1.blob.core.windows.net/appian-portal/assistance_icon_CanadaLife.png']";
    private static final String LO_IMG_GEM_BOTTOM_LOGO_PLAIN = "//div//img[@src='https://geihpvqvwebgencacn1.blob.core.windows.net/appian-portal/logo_footer_en_GEM.png' or @src='https://geihpvtvwebgencacn1.blob.core.windows.net/appian-portal/logo_footer_en_GEM.png']";
    private static final String LO_LNK_START_NEW_CLAIM_FOOTER_LIGHT = "//p[span[@class='IconWidget---medium IconWidget---inLightBackground']/following-sibling::span/a[contains(text(), 'START A NEW CLAIM')]]";
    private static final String LO_LNK_CONTINUE_DRAFT_CLAIM_FOOTER_LIGHT = "//p[span[@class='IconWidget---medium IconWidget---inLightBackground']/following-sibling::span/a[contains(text(), 'CONTINUE DRAFT CLAIM')]]";
    private static final String LO_LNK_SUBMIT_DOCUMENTS_FOOTER_LIGHT = "//p[span[@class='IconWidget---medium IconWidget---inLightBackground']/following-sibling::span/a[contains(text(), 'SUBMIT DOCUMENTS')]]";
    private static final String LO_LNK_HELP_CENTRE_BOTTOM_LIGHT = "//p[span[@class='IconWidget---medium IconWidget---inLightBackground']/following-sibling::span[a[contains(text(), 'HELP CENTRE')]]]";
    private static final String LO_TXT_GEM_FOOTER_DISCLAIMER_CL = "//span[text()='The Canada Life Assurance Company has appointed Global Excel Management Inc. as the provider of Travel Assistance and Out of Country claims services.']";
    private static final String LO_LNK_PRIVACY_STATEMENT = "//span[a[contains(text(), 'Privacy Statement')]]";
    private static final String LO_LNK_CONDITIONS_OF_USE = "//span[a[contains(text(), 'Conditions of Use')]]";
    private static final String LO_LNK_COMPLAINT_POLICY = "//span[a[contains(text(), 'Complaint Policy')]]";
    private static final String LO_LNK_PRIVACY_STATEMENT_STRONG = "//strong[a[contains(text(), 'Privacy Statement')]]";
    private static final String LO_LNK_CONDITIONS_OF_USE_STRONG = "//strong[a[contains(text(), 'Conditions of Use')]]";
    private static final String LO_LNK_COMPLAINT_POLICY_STRONG = "//strong[a[contains(text(), 'Complaint Policy')]]";
    private static final String LO_TXT_MEDICAL_EMERGENCY_HELPLINE_HEADING_LIGHT = "//h2[contains(text(), 'MEDICAL EMERGENCY HELPLINE')]";
    private static final String LO_IMG_GEM_BOTTOM_LOGO_CL = "//div//img[@src='https://geihpvqvwebgencacn1.blob.core.windows.net/appian-portal/logo_footer_en_CanadaLife.png' or @src='https://geihpvtvwebgencacn1.blob.core.windows.net/appian-portal/logo_footer_en_CanadaLife.png']";
    private static final String LO_TXT_GEM_FOOTER_DISCLAIMER_2 = "//span[text()='Assistance and Claims Services are administered by Global Excel Management Inc.']";
    private static final String LO_IMG_ASSISTANCE_ICON_INTACT = "//div//img[@src='https://geihpvqvwebgencacn1.blob.core.windows.net/appian-portal/assistance_icon_Intact.png' or @src='https://geihpvtvwebgencacn1.blob.core.windows.net/appian-portal/assistance_icon_Intact.png']";
    private static final String LO_IMG_GEM_TOP_LOGO_INTACT = "//a//img[@src='https://geihpvqvwebgencacn1.blob.core.windows.net/appian-portal/logo_header_en_Intact.png' or @src='https://geihpvtvwebgencacn1.blob.core.windows.net/appian-portal/logo_header_en_Intact.png']";
    private static final String LO_IMG_GEM_BOTTOM_LOGO_INTACT = "//div//img[@src='https://geihpvqvwebgencacn1.blob.core.windows.net/appian-portal/logo_footer_en_Intact.png' or @src='https://geihpvtvwebgencacn1.blob.core.windows.net/appian-portal/logo_footer_en_Intact.png']";
    private static final String LO_LNK_HELP_CENTRE_TOP_DARK = "//p[span[a[(span/span[@class='IconWidget---inDarkBackground'][not(following-sibling::span)]) or (span[@class='IconWidget---inDarkBackground'] and text()='HELP CENTRE')]]]";
    private static final String LO_BUT_FRANÇAIS_DARK = "//p[span[a[(span[span[@class='IconWidget---inDarkBackground'] and span[contains(text(), 'FR')]]) or (span[@class='IconWidget---inDarkBackground'] and span[contains(text(), 'FRANÇAIS')])]]]";
    private static final String LO_BUT_ENGLISH_DARK = "//a[(span[span[@class='IconWidget---inDarkBackground'] and span[contains(text(), 'EN')]]) or (span[@class='IconWidget---inDarkBackground'] and span[contains(text(), 'ENGLISH')])]";
    private static final String LO_IMG_GEM_TOP_LOGO_MANULIFE = "//a//img[@src='https://geihpvqvwebgencacn1.blob.core.windows.net/appian-portal/logo_header_en_Manulife.png'or @src='https://geihpvtvwebgencacn1.blob.core.windows.net/appian-portal/logo_header_en_Manulife.png']";
    private static final String LO_IMG_ASSISTANCE_ICON_MANULIFE = "//div//img[@src='https://geihpvqvwebgencacn1.blob.core.windows.net/appian-portal/assistance_icon_Manulife.png' or @src='https://geihpvtvwebgencacn1.blob.core.windows.net/appian-portal/assistance_icon_Manulife.png']";
    private static final String LO_IMG_GEM_BOTTOM_LOGO_MANULIFE = "//div//img[@src='https://geihpvqvwebgencacn1.blob.core.windows.net/appian-portal/logo_footer_en_Manulife.png' or @src='https://geihpvtvwebgencacn1.blob.core.windows.net/appian-portal/logo_footer_en_Manulife.png']";
    private static final String LO_TXT_GEM_FOOTER_DISCLAIMER_MANULIFE = "//span[text()='Global Excel Management provides Claims and Assistance Services for The Manufacturers Life Insurance Company (Manulife).']";
    private static final String LO_IMG_GEM_TOP_LOGO_MGB = "//a//img[@src='https://geihpvqvwebgencacn1.blob.core.windows.net/appian-portal/logo_header_en_ManulifeGroupBenefits.png' or @src='https://geihpvtvwebgencacn1.blob.core.windows.net/appian-portal/logo_header_en_ManulifeGroupBenefits.png']";
    private static final String LO_TXT_GEM_FOOTER_DISCLAIMER_MGB = "//p[text()='Global Excel Management provides Claims and Assistance Services for The Manufacturers Life Insurance Company (Manulife).']";
    private static final String LO_IMG_GEM_BOTTOM_LOGO_GEM_MGB = "//div//img[@src='https://geihpvqvwebgencacn1.blob.core.windows.net/appian-portal/logo_footer_en_ManulifeGroupBenefits_GEM.png' or @src='https://geihpvtvwebgencacn1.blob.core.windows.net/appian-portal/logo_footer_en_ManulifeGroupBenefits_GEM.png']";
    private static final String LO_IMG_GEM_BOTTOM_LOGO_MANULIFE_MGB = "//div//img[@src='https://geihpvqvwebgencacn1.blob.core.windows.net/appian-portal/logo_footer_en_ManulifeGroupBenefits.png' or @src='https://geihpvtvwebgencacn1.blob.core.windows.net/appian-portal/logo_footer_en_ManulifeGroupBenefits.png']";
    private static final String LO_IMG_ASSISTANCE_ICON_MGB = "//div//img[@src='https://geihpvqvwebgencacn1.blob.core.windows.net/appian-portal/assistance_icon_ManulifeGroupBenefits.png' or @src='https://geihpvtvwebgencacn1.blob.core.windows.net/appian-portal/assistance_icon_ManulifeGroupBenefits.png']";
    private static final String LO_IMG_GEM_TOP_LOGO_ORION = "//a//img[@src='https://geihpvqvwebgencacn1.blob.core.windows.net/appian-portal/logo_header_en_Orion.png' or @src='https://geihpvtvwebgencacn1.blob.core.windows.net/appian-portal/logo_header_en_Orion.png']";
    private static final String LO_IMG_GEM_BOTTOM_LOGO_ORION = "//img[@src='https://geihpvqvwebgencacn1.blob.core.windows.net/appian-portal/logo_footer_en_Orion.png' or @src='https://geihpvtvwebgencacn1.blob.core.windows.net/appian-portal/logo_footer_en_Orion.png']";
    private static final String LO_IMG_ASSISTANCE_ICON_ORION = "//div//img[@src='https://geihpvqvwebgencacn1.blob.core.windows.net/appian-portal/assistance_icon_Orion.png' or @src='https://geihpvtvwebgencacn1.blob.core.windows.net/appian-portal/assistance_icon_Orion.png']";
    private static final String LO_TXT_GEM_FOOTER_DISCLAIMER_ORION = "//p[text()='Global Excel Management provides claims and assistance services for Orion Travel Insurance Company.']";
    private static final String LO_TXT_MEDICAL_EMERGENCY_HELPLINE_PARAGRAPH_LIGHT_CSBC = "//p[contains(text(), 'Consumer or Small Business Cards')]";
    private static final String LO_TXT_MEDICAL_EMERGENCY_HELPLINE_PARAGRAPH_LIGHT_CSVBC = "//p[span[@class='IconWidget---medium IconWidget---inLightBackground'] and text()='Commercial or Scotia Visa Business Cards']";
    private static final String LO_TXT_MEDICAL_EMERGENCY_HELPLINE_HEADING_NO_CALL_ICON = "//h3/span[text()='MEDICAL EMERGENCY HELPLINE']";
    private static final String LO_IMG_GEM_TOP_LOGO_SCOTIA = "//a//img[@src='https://geihpvqvwebgencacn1.blob.core.windows.net/appian-portal/logo_header_en_Scotiabank.png' or @src='https://geihpvtvwebgencacn1.blob.core.windows.net/appian-portal/logo_header_en_Scotiabank.png']";
    private static final String LO_IMG_ASSISTANCE_ICON_SCOTIA = "//div//img[@src='https://geihpvqvwebgencacn1.blob.core.windows.net/appian-portal/assistance_icon_Scotiabank.png' or @src='https://geihpvtvwebgencacn1.blob.core.windows.net/appian-portal/assistance_icon_Scotiabank.png']";
    private static final String LO_IMG_GEM_BOTTOM_LOGO_LIGHT_GEM = "//div//img[@src='https://geihpvqvwebgencacn1.blob.core.windows.net/appian-portal/logo_footer_GEM_light.png' or @src='https://geihpvtvwebgencacn1.blob.core.windows.net/appian-portal/logo_footer_GEM_light.png']";
    private static final String LO_IMG_GEM_BOTTOM_LOGO_SCOTIA = "//div//img[@src='https://geihpvqvwebgencacn1.blob.core.windows.net/appian-portal/logo_footer_en_Scotiabank.png' or @src='https://geihpvtvwebgencacn1.blob.core.windows.net/appian-portal/logo_footer_en_Scotiabank.png']";
    private static final String LO_IMG_GEM_TOP_LOGO_SUNLIFE = "//a//img[@src='https://geihpvqvwebgencacn1.blob.core.windows.net/appian-portal/logo_header_en_SunLife.png' or @src='https://geihpvtvwebgencacn1.blob.core.windows.net/appian-portal/logo_header_en_SunLife.png']";
    private static final String LO_IMG_GEM_BOTTOM_LOGO_SUNLIFE = "//img[@src='https://geihpvqvwebgencacn1.blob.core.windows.net/appian-portal/logo_footer_en_SunLife.png' or @src='https://geihpvtvwebgencacn1.blob.core.windows.net/appian-portal/logo_footer_en_SunLife.png']";
    private static final String LO_TXT_GEM_FOOTER_DISCLAIMER_SUNLIFE = "//p[text()='The Sun Life Assurance Company of Canada (“Sun Life”) has appointed Global Excel Management Inc., as the provider of all assistance and claims services.']";
    private static final String LO_IMG_ASSISTANCE_ICON_SUNLIFE = "//div//img[@src='https://geihpvqvwebgencacn1.blob.core.windows.net/appian-portal/assistance_icon_SunLife.png' or @src='https://geihpvtvwebgencacn1.blob.core.windows.net/appian-portal/assistance_icon_SunLife.png']";
    private static final String LO_IMG_GEM_TOP_LOGO_TD = "//a//img[@src='https://geihpvqvwebgencacn1.blob.core.windows.net/appian-portal/logo_header_en_TD.png' or @src='https://geihpvtvwebgencacn1.blob.core.windows.net/appian-portal/logo_header_en_TD.png']";
    private static final String LO_IMG_ASSISTANCE_ICON_TD = "//div//img[@src='https://geihpvqvwebgencacn1.blob.core.windows.net/appian-portal/assistance_icon_TD.png' or @src='https://geihpvtvwebgencacn1.blob.core.windows.net/appian-portal/assistance_icon_TD.png']";
    private static final String LO_IMG_GEM_BOTTOM_LOGO_TD = "//div//img[@src='https://geihpvqvwebgencacn1.blob.core.windows.net/appian-portal/logo_footer_en_TD.png' or @src='https://geihpvtvwebgencacn1.blob.core.windows.net/appian-portal/logo_footer_en_TD.png']";
    private static final String LO_TXT_GEM_FOOTER_DISCLAIMER_TD = "//span[text()='Global Excel Management provides Claims and Assistance Services for TD Life Insurance Company and TD Home and Auto Insurance Company.']";


    //---------------------------------------------------------------------------- FR ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    private static final String LO_HOME_PAGE_VERIFY_AMEX_CLAIM_FR = "//strong[contains(text(), 'carte AMEX')]/..";
    private static final String LO_LST_INSURANCE_TYPE_FR = "";
    private static final String LO_LST_REASON_FOR_CANCELLING_AGENT_FR = "";
    private static final String LO_EDT_CITY_NAME_AGENT_VERIFICATION_FR = "";
    private static final String LO_EDT_GROUP_NAME_AGENT_VERIFICATION_FR = "";
    private static final String LO_BUT_CONTINUE_AGENT_FR = "";
    private static final String LO_RAD_YES_EXISTING_GE_CLAIM_NUMBER_AGENT_FR = "";
    private static final String LO_EDT_CLAIM_NUMBER_AGENT_FR = "";
    private static final String LO_LST_REASON_FOR_INTERRUPTION_RELATED_TO_AGENT_FR = "";
    private static final String LO_LST_REASON_FOR_INTERRUPTION_AGENT_FR = "";
    private static final String LO_RAD_PREFERRED_METHOD_COMMUNICATION_EMAIL_AGENT_FR = "";
    private static final String LO_LST_REASON_FOR_CANCELLATION_RELATED_TO_AGENT_FR = "";
    private static final String LO_RAD_YES_COB_IN_AGENT_FR = "";
    private static final String LO_EDT_GROUP_NAME_AGENT_FR = "";
    private static final String LO_LST_CLAIM_TYPE_AGENT_FR = "";
    private static final String LO_TXT_POLICY_NUMBER_CERTIFICATE_ID_FR = "";
    private static final String LO_BUT_CREATE_NEW_CLAIM_AS_AGENT_FR = "";
    private static final String LO_TXT_ON_PAGE_VERIFICATION_APPIAN_FR = "";
    private static final String LO_LST_CORPORATE_CLIENT_FR = "";
    private static final String LO_BUT_NEXT_FR = "";
    private static final String LO_BUT_YES_STAY_SIGNED_IN_G_FR = "";
    private static final String LO_EDT_G_PASSWORD_FR = "";
    private static final String LO_BUT_G_SIGN_IN_FR = "";
    private static final String LO_EDT_G_EMAIL_FR = "";
    private static final String LO_LNK_SSGEM_ACCOUNT_FR = "";
    private static final String LO_TXT_AMEX_HOME_PAGE_VERIFY_FR = "";
    private static final String LO_TXT_MEDICAL_EMERGENCY_HELPLINE_PARAGRAPH_LIGHT_CSBC_FR = "";
    private static final String LO_TXT_FOOTER_DISCLAIMER_SUNLIFE_FR = "";
    private static final String LO_LNK_COMPLAINT_POLICY_STRONG_FR = "";
    private static final String LO_LNK_CONDITIONS_OF_USE_STRONG_FR = "";
    private static final String LO_LNK_PRIVACY_STATEMENT_STRONG_FR = "";
    private static final String LO_TXT_GEM_FOOTER_DISCLAIMER_TD_FR = "//span[text()='Global Excel Management fournit des services de réclamation et d'assistance pour TD Life Insurance Company et TD Home and Auto Insurance Company.']";
    private static final String LO_HOME_PAGE_VERIFY_FR = "//strong[contains(text(), 'centre de réclamation')]/..";
    private static final String LO_HOME_PAGE_VERIFY_NEW_FR = "//div//h3[contains(text(), 'centre de réclamation')]/..";
    private static final String LO_HOME_PAGE_VERIFY_ORION_CLAIM_FR = "//strong[contains(text(), \"centre de réclamation d'Orion\")]/..";
    private static final String LO_HOME_PAGE_VERIFY_CIBC_FR = "//h1[contains(text(),'Bienvenue au centre de réclamations pour votre  carte de crédit CIBC')]";
    private static final String LO_HOME_PAGE_VERIFY_NEW_MGB_FR = "//h1[contains(text(),\"Bienvenue à votre  centre de réclamation voyage de l'assurance collective de Manuvie\")]";
    private static final String LO_HOME_PAGE_VERIFY_ORION_FR = "//span[text()='Welcome to your  Orion Claim Centre']";
    private static final String LO_HOME_PAGE_VERIFY_MGB_FR = "//span[text()='Welcome to your Manulife Group Benefits Travel  Claim Centre']";
    private static final String LO_BUT_START_NEW_CLAIM_NEW_FR = "//span[contains(text(),'COMMENCER UNE NOUVELLE RÉCLAMATION')]";
    private static final String LO_BUT_START_NEW_CLAIM_MGB_FR = "//span[contains(text(),'Commencer Une Nouvelle Réclamation')]";
    private static final String LO_BUT_CONTINUE_DRAFT_CLAIM_FR = "//strong[contains(text(), 'POURSUIVRE VOTRE DEMANDE')]";   
    private static final String LO_BUT_CONTINUE_DRAFT_CLAIM_CIBC_FR = "//span[contains(text(), 'POURSUIVRE VOTRE DEMANDE')]";           
    private static final String LO_BUT_CHECK_CLAIM_STATUS_FR = "//strong[contains(text(), \"VÉRIFIEZ L'ÉTAT DE VOTRE RÉCLAMATION\")]";
    private static final String LO_BUT_VISIT_OUR_HELP_CENTRE_FR = "//strong[contains(text(), \"CONSULTEZ NOTRE CENTRE D'ASSISTANCE\")]";
    private static final String LO_BUT_SIGN_IN_FR = "//strong[contains(text(), 'CONNEXION')]";
    private static final String LO_TXT_SYSTEM_STATUS_FR = "//h4[contains(text(), 'The System Has Encountered an Error')]";
    private static final String LO_BUT_VIEW_STATUS_FR = "//strong[contains(text(),\"VÉRIFIEZ L'ÉTAT DE VOTRE RÉCLAMATION\")]";
    private static final String LO_BUT_VIEW_STATUS_CIBC_FR = "//span[contains(text(),\"VÉRIFIEZ L'ÉTAT DE VOTRE RÉCLAMATION\")]";
    // private static final String LO_LNK_HELP_CENTRE_HEADER="(//a[contains(text(),
    // 'HELP CENTRE')])[1]";
    private static final String LO_LNK_HELP_CENTRE_HEADER_FR = "((//span[text()='FR' or text()='FRANÇAIS']/ancestor::div[1]/../../preceding-sibling::div)[2]/div) | (//a[contains(text(), \"CENTRE D'ASSISTANCE\")])[1]";
    private static final String LO_LNK_HELP_CENTRE_FOOTER_FR = "(//span/a[text()=\"CENTRE D'ASSISTANCE\"])[1] | (//span/a[text()=\"CENTRE D'ASSISTANCE\"])[2]";
    private static final String LO_BUT_FRANÇAIS_FR = "//span[text()='FR' or text()='FRANÇAIS']";
    private static final String LO_HOME_PAGE_VERIFY_FRENCH_FR = "//strong[contains(text(), 'carte AMEX')]";
    private static final String LO_HOME_PAGE_VERIFY_FRENCH_CARTE_AMEX_FR = "//strong[contains(text(), 'carte AMEX')]";
    private static final String LO_FR_HOME_PAGE_VERIFY_FR = "//strong[contains(text(), 'carte de crédit CIBC')]";
    private static final String LO_BUT_ENGLISH_FR = "//span[text()='EN' or text()='ENGLISH']";
    private static final String LO_BUT_BURNNER_TOP_YELLOW_IMPORTANT_MESSAGE_FR = "//div[@class='SideBySideGroup---side_by_side SideBySideGroup---default_direction SideBySideGroup---top']/div[div//strong[contains(text(), ' Important Information – Potential Canada Post mail disruption')]]/following-sibling::div//div[@class='FieldLayout---input_below']";
    private static final String LO_BUT_BURNNER_TOP_YELLOW_TEST_INDIVIDUAL_MESSAGE_FR = "//div[@class='SideBySideGroup---side_by_side SideBySideGroup---default_direction SideBySideGroup---top']/div[div//strong[contains(text(), 'Test Individual message')]]/following-sibling::div//div[@class='FieldLayout---input_below']";
    private static final String LO_LNK_HELP_CENTRE_TOP_FR = "//p[span[a[(span/span[@class='IconWidget---inLightBackground'][not(following-sibling::span)]) or (span[@class='IconWidget---inLightBackground'] and text()='HELP CENTRE')]]]";
    private static final String LO_TXT_MAIN_HEADING_PARAGRAPH_FR = "//p//span[contains(text(), \"Nous comprenons que de faire face à des situations inattendues dans un environnement inconnu peut être stressant. Pour vous aider, nous vous offrons un service d'assistance avec des experts prêts à vous aider en cas d'urgence.\")]";
    private static final String LO_TXT_HOME_PAGE_VERIFY_FRENCH_PAGE_AMEX_FR = "//div//h1[contains(text(),'Bienvenue à votre centre de réclamation de voyage pour votre  carte AMEX')]";
    private static final String LO_IMG_GEM_TOP_LEFT_LOGO_FR = "//IMG[@src='https://geihpvdvwebgencacn1.blob.core.windows.net/appian-portal/logo_header_fr_GEM.png']";
    private static final String LO_TXT_NEW_CLAIM_HEADING_CARD_FR = "//h3[contains(text(),'Nouvelle réclamation')]";
    private static final String LO_TXT_NEW_CLAIM_PARAGRAPH_CARD_FR = "//p[contains(text(), 'Vous voulez soumettre une nouvelle réclamation? Commencez le processus ici.')]";
    private static final String O_TXT_NEW_CLAIM_PARAGRAPH_CARD_CIBC_FR = "//span[contains(text(), 'Vous voulez soumettre une nouvelle réclamation? Commencez le processus ici.')]";
    private static final String LO_TXT_ACTIVE_CLAIM_HEADING_CARD_FR = "//h2[contains(text(),'Réclamation en cours')]";
    private static final String LO_TXT_DRAFT_CLAIM_PARAGRAPH_CARD_FR = "//p[contains(text(), 'Vous avez déjà commencé une réclamation? Continuez votre demande ici.')]";
    private static final String LO_TXT_DRAFT_CLAIM_PARAGRAPH_CARD_CIBC_FR = "//span[contains(text(), 'Vous avez déjà commencé une réclamation? Continuez votre demande ici.')]";
    private static final String LO_TXT_EXISTING_CLAIM_HEADING_CARD_FR = "//h3[contains(text(),'Réclamation existante')]";
    private static final String LO_TXT_EXISTING_CLAIM_HEADING_CARD_CIBC_FR = "//h2[contains(text(),'Réclamation existante')]";
    private static final String LO_TXT_ACTIVE_CLAIM_PARAGRAPH_CARD_FR = "//p[contains(text(), \"Vous avez soumis une réclamation et voulez en vérifier l'état? Obtenez les mises à jour ici.\")]";
    private static final String LO_TXT_ACTIVE_CLAIM_PARAGRAPH_CARD_CIBC_FR = "//span[contains(text(), \"Vous avez soumis une réclamation et voulez en vérifier l'état? Obtenez les mises à jour ici.\")]";
    private static final String LO_TXT_NEED_HELP_HEADING_FR = "//h3[contains(text(), \"Besoin d'aide? Nous sommes là pour vous aider!\")]";
    private static final String LO_TXT_NEED_HELP_HEADING_CIBC_FR = "//h2[contains(text(), \"Besoin d'aide? Nous sommes là pour vous aider!\")]";
    private static final String LO_TXT_NEED_HELP_PARAGRAPH_FR = "//p[text()=\"Que vous soyez à la maison ou en voyage, Global Excel est là pour vous aider. Consultez notre Centre d'aide pour en savoir plus sur les outils et les services mis à votre disposition.\"]";
    private static final String LO_TXT_NEED_HELP_PARAGRAPH_CIBC_FR = "//span[text()=\"Que vous soyez à la maison ou en voyage, Global Excel est là pour vous aider. Consultez notre Centre d'aide pour en savoir plus sur les outils et les services mis à votre disposition.\"]";
    private static final String LO_IMG_BOTTOM_LEFT_GEM_LOGO_FR = "//IMG[@src='https://geihpvqvwebgencacn1.blob.core.windows.net/appian-portal/logo_footer_GEM_claim_center_fr_dark.png']";
    private static final String LO_IMG_UP_LEFT_CIBC_LOGO_FR = "//IMG[@src='https://geihpvdvwebgencacn1.blob.core.windows.net/appian-portal/logo_header_fr_CIBC.png']";
    private static final String LO_TXT_START_A_NEW_CLAIM_HEADING_CARD_FR = "//h2[contains(text(),'Commencer une nouvelle réclamation')]";
    private static final String LO_TXT_RESUME_DRAFT_CLAIM_HEADING_CARD_FR = "//h2[contains(text(),\"Récupération d'un brouillon de réclamation\")]";
    private static final String LO_TXT_SUBMIT_DOCUMENT_HEADING_CARD_FR = "//h2[contains(text(),\"Soumission de documents\")]";
    private static final String LO_TXT_SUBMIT_DOCUMENT_PARAGRAPH_FR = "//span[contains(text(),\"Vous souhaitez soumettre des documents supplémentaires pour une réclamation existante ?\")]";
    private static final String LO_BUT_SUBMIT_HERE_FR = "//span[contains(text(),\"Soumettre ici\")]";
    private static final String LO_BUT_SUBMIT_HERE_CL_FR = "//span[contains(text(),\"SOUMETTRE ICI\")]";
    private static final String LO_IMG_HELP_CENTER_ICON_FR = "//IMG[@src='https://geihpvdvwebgencacn1.blob.core.windows.net/appian-portal/helpCenter_CIBC.png']";
    private static final String LO_TXT_MEDICAL_EMERGENCY_HELPLINE_HEADING_FR = "//h2[text()=\"LIGNE MÉDICALE D'URGENCE\"]";
    String LO_TXT_MEDICAL_EMERGENCY_HELPLINE_NON_TOLL_FREE_FR = "//span/a[text()=";
    String LO_TXT_MEDICAL_EMERGENCY_HELPLINE_TOLL_FREE_FR = "//p[text()=\"(Toll free)\"]//span/a[text()=";
    String LO_TXT_MEDICAL_EMERGENCY_HELPLINE_NON_TOLL_FREE2_FR = "//span/a[text()=";
    String LO_TXT_MEDICAL_EMERGENCY_HELPLINE_TOLL_FREE2_FR = "//p[text()=\"(Toll free)\"]//span/a[text()=";
    private static final String LO_IMG_GEM_BOTTOM_LEFT_LOGO_FR = "//IMG[@src='https://geihpvdvwebgencacn1.blob.core.windows.net/appian-portal/logo_footer_GEM_light.png']";
    private static final String LO_TXT_FOOTER_DECLARATIONS_FR = "//span[contains(text(),\"Cette couverture est souscrite auprès de la Compagnie d'assurance Belair inc. La Compagnie d'assurance Belair inc. a désigné Gestion Global Excel inc. qui exerce ses activités sous le nom de « Global Excel » comme prestataire de services d’assistance et de gestion des demandes de règlement au titre de cette couverture.\")]";
    private static final String LO_TXT_FOOTER_DECLARATIONS_AMEX_FR = "//span[contains(text(),\"Cette couverture est souscrite auprès de la Compagnie d'assurance Belair inc. La Compagnie d'assurance Belair inc. a désigné Gestion Global Excel inc. qui exerce ses activités sous le nom de \")]";
    private static final String LO_TXT_COPY_RIGHT_NOTICE_2025_FR = "//span[span and text()=\"2025\" and text()=\"Gestion Global Excel inc.\" and text()=\"Tous droits réservés.\"]";
    private static final String LO_TXT_PRIVACY_STATEMENT_FR = "//span[contains(text(),'Déclaration de confidentialité ')]";
    private static final String LO_TXT_CONDITIONS_OF_USE_FR = "//span[contains(text(),\"conditions d'utilisation \")]";
    private static final String LO_TXT_SUBMIT_DOCUMENTS_HEADING_CARD_FR = "//h2[contains(text(),'Soumettre des documents')]";
    private static final String LO_TXT_SUBMIT_DOCUMENTS_PARAGRAPH_FR = "//span[contains(text(),'Vous voulez nous envoyer des documents?')]";
    private static final String LO_IMG_HELP_CENTER_ICON_CL_FR = "//IMG[@src='https://geihpvdvwebgencacn1.blob.core.windows.net/appian-portal/helpCenter_canadaLife.png']";
    private static final String LO_IMG_CL_LOGO_FR = "https://geihpvqvwebgencacn1.blob.core.windows.net/appian-portal/logo_footer_fr_CanadaLife.png";
    private static final String LO_TXT_FOOTER_CL_DECLARATION_FR = "//span[contains(text(),'La Compagnie d’Assurance du Canada sur la Vie a désigné Global Excel comme prestataire de services d’assistance voyage et de gestion des demandes de règlement hors pays.')]";
    private static final String LO_TXT_DOCUMENTS_SUBMISSION_PARAGRAPH_FR = "//span[contains(text(),'Vous souhaitez soumettre des documents supplémentaires pour une réclamation existante?')]";
    private static final String LO_TXT_ASSISTANCE_SERVICES_TEXT_FR = "//span[contains(text(),\"Les services d'assistance et de gestion des demandes de règlement sont administrés par Gestion Global Excel inc.\")]";
    private static final String LO_TXT_ASSISTANCE_SERVICES_TEXT_BELAIR_FR = "//span[contains(text(),\"Cette couverture est souscrite auprès de la Compagnie d'assurance Belair inc. et est administrée par l'Agence belairdirect inc. La Compagnie d'assurance Belair inc. a désigné Gestion Global Excel inc. qui exerce ses activités sous le nom de « Global Excel » comme prestataire de services d’assistance et de gestion des demandes de règlement au titre de cette couverture.\")]";
    private static final String LO_TXT_ASSISTANCE_SERVICES_TEXT_MANULIFE_FR = "//span[contains(text(),\"Que vous soyez à la maison ou en voyage, Global Excel est là pour vous aider. Consultez notre Centre d'aide pour en savoir plus sur les outils et les services mis à votre disposition.\")]";
    private static final String LO_IMG_BELAIR_LOGO_FR = "//IMG[@src='https://geihpvdvwebgencacn1.blob.core.windows.net/appian-portal/logo_header_fr_Intact_new.png']";
    private static final String LO_IMG_MANULIFE_LOGO_FR = "//IMG[@src='https://geihpvdvwebgencacn1.blob.core.windows.net/appian-portal/logo_header_fr_Manulife.png']";
    private static final String LO_IMG_GEM_LOGO_FR = "//IMG[@src='https://geihpvdvwebgencacn1.blob.core.windows.net/appian-portal/logo_header_light_fr_MGB.png']";
    private static final String LO_IMG_MANULIFE_BOTTOM_LOGO_FR = "//IMG[@src='https://geihpvdvwebgencacn1.blob.core.windows.net/appian-portal/logo_footer_fr_ManulifeGroupBenefits.png']";
    private static final String LO_TXT_MGB_BOTTOM_GEM_OFFER_SERVICES_FR = "//span[contains(text(),\"Gestion Global Excel offre des services de réclamation pour La Compagnie d'Assurance-Vie Manufacturers (Manuvie).\")]";
    private static final String LO_TXT_SUNLIFE_OFFER_SERVICES_FR = "//span[contains(text(),\"Sun Life du Canada, compagnie d'assurance-vie (« Sun Life ») a désigné Gestion Global Excel inc., comme prestataire de services d'assistance et de gestion des demandes de règlement.\")]";
    private static final String LO_TXT_TD_OFFER_SERVICES_FR = "//span[contains(text(),'Gestion Global Excel inc offre des services de réclamation et de soutien pour TD,') and //span[contains(text(),\"Compagnie d'assurance-vie et Compagnie d'assurance habitation et auto TD.\")]]";
    private static final String LO_TXT_ZURICH_OFFER_SERVICES_FR = "//span[contains(text(),\"Les garanties sont souscrites par Zurich Compagnie d'Assurances SA (Direction canadienne) « Zurich ». Zurich a désigné Gestion Global Excel inc., opérant sous le nom de « Global Excel », comme fournisseur de tous les services d'assistance et de règlement en vertu de cette couverture. Pour obtenir des renseignements complets sur la couverture, veuillez consulter les documents de votre police.\")]";
    private static final String LO_IMG_SCOTIABANK_LOGO_FR = "//IMG[@src='https://geihpvdvwebgencacn1.blob.core.windows.net/appian-portal/logo_header_fr_Scotiabank.png']";
    private static final String LO_IMG_SUNLIFE_LOGO_FR = "//IMG[@src='https://geihpvdvwebgencacn1.blob.core.windows.net/appian-portal/logo_header_fr_SunLife.png']";
    private static final String LO_IMG_AMEX_ASSISTANCE_ICON_FR = "//IMG[@src='https://geihpvdvwebgencacn1.blob.core.windows.net/appian-portal/helpCenter_AMEX.png']";
    private static final String LO_IMG_TD_LOGO_FR = "//IMG[@src='https://geihpvdvwebgencacn1.blob.core.windows.net/appian-portal/logo_header_fr_TD.png']";
    private static final String LO_IMG_ZURICH_LOGO_FR = "//IMG[@src='https://geihpvdvwebgencacn1.blob.core.windows.net/appian-portal/logo_header_fr_Zurich.png']";
    private static final String LO_TXT_HOME_PAGE_VERIFY_CL_FR = "//h1[contains(text(),'Bienvenue au  centre de réclamation')]";

    //----------------------------------------------------------------------------------- FR2---------------------------------------------------------------------------------------------------------------------------------------------------------

    private static final String LO_BUT_START_NEW_CLAIM_FR = "";
    private static final String LO_TXT_DRAFT_CLAIM_HEADING_CARD_FR = "";
    private static final String LO_TXT_TRADE_MARK_NOTICE_AND_LOGOS_FR = "";
    private static final String LO_TXT_TRADE_MARK_NOTICE_FR = "";
    private static final String LO_LNK_PRIVACY_STATEMENT_FR = "";
    private static final String LO_LNK_CONDITIONS_OF_USE_FR = "";
    private static final String LO_TXT_MEDICAL_EMERGENCY_HELPLINE_HEADING_LIGHT_FR = "";
    private static final String LO_LNK_COMPLAINT_POLICY_FR = "";
    private static final String LO_TXT_SUBMIT_DOCUMENTS_PARAGRAPH_CARD_FR = "";
    private static final String LO_TXT_GEM_FOOTER_DISCLAIMER_BELAIR_FR = "";
    private static final String LO_HOME_PAGE_VERIFY_FRENCH__TRAVEL_CLAIM_CENTER_FR = "";
    private static final String LO_TXT_GEM_FOOTER_DISCLAIMER_BCAA_FR = "";
    private static final String LO_HOME_PAGE_VERIFY_BELAIR_FR = "";
    private static final String LO_TXT_GEM_FOOTER_DISCLAIMER_CIBC_FR = "";
    private static final String LO_TXT_GEM_FOOTER_DISCLAIMER_CL_FR = "";
    private static final String LO_BUT_SUBMIT_HERE_ALL_CAPS_FR = "";
    private static final String LO_TXT_GEM_FOOTER_DISCLAIMER_2_FR = "";
    private static final String LO_TXT_GEM_FOOTER_DISCLAIMER_MANULIFE_FR = "";
    private static final String LO_HOME_PAGE_VERIFY_FRENCH_MGB_FR = "";
    private static final String LO_BUT_CREATE_NEW_CLAIM_FR = "";

    /**
     * Define the Page Object (PO) constructor.
     * 
     * @param driver The WebDriver object passed from the test method.
     */
    // [Note: Automation Engineer, rename this Page Object (PO) class to match the
    // filename.]
    public PO_Home(WebDriver driver) {
        super(driver);
    }

    /**
     * Validates if current webpage is loaded and correct.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object validateOnPage(String language) {
        // waitForDuration(5, "s", false); // Wait to perform next check
        String locator = "fr".equalsIgnoreCase(language) ? LO_HOME_PAGE_VERIFY_FR : LO_HOME_PAGE_VERIFY;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object validateOnPageZurich() {
        // waitForDuration(5, "s", false); // Wait to perform next check
        String result = validateLocatorExists(LO_TXT_HOME_PAGE_VERIFY_ZURICH, FW_ConfigMgr.getDefaultTimeout(),
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
    public Object validateOnPageAMEX(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_AMEX_HOME_PAGE_VERIFY_FR : LO_TXT_AMEX_HOME_PAGE_VERIFY;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(),
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
    public Object validateOnPageCIBC() {
        String result = validateLocatorExists(LO_HOME_PAGE_VERIFY_CIBC, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if current Orion webpage is loaded and correct.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object validateOnPageOrion() {
        String result = validateLocatorExists(LO_HOME_PAGE_VERIFY_ORION, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if current MGB webpage is loaded and correct.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object validateOnPageMGB() {
        String result = validateLocatorExists(LO_HOME_PAGE_VERIFY_MGB, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if the 'Start New Claim' exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object validateStartNewClaimButton(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_BUT_START_NEW_CLAIM_FR : LO_BUT_START_NEW_CLAIM;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if the 'Continue Draft Claim' exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object validateContinueDraftClaimButton(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_BUT_CONTINUE_DRAFT_CLAIM_FR : LO_BUT_CONTINUE_DRAFT_CLAIM;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if the 'Check Claim Status' exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object validateCheckClaimStatusButton(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_BUT_CHECK_CLAIM_STATUS_FR : LO_BUT_CHECK_CLAIM_STATUS;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    public Object validateSubmitHereButton(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_BUT_SUBMIT_HERE_FR : LO_BUT_SUBMIT_HERE;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object validateSubmitHereButtonAllCaps() {
        String result = validateLocatorExists(LO_BUT_SUBMIT_HERE_ALL_CAPS, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if the 'Visit Our Help Centre' exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object validateVisitOurHelpCentreButton(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_BUT_VISIT_OUR_HELP_CENTRE_FR : LO_BUT_VISIT_OUR_HELP_CENTRE;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object validateFooterDisclaimerCIBC(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_GEM_FOOTER_DISCLAIMER_CIBC_FR : LO_TXT_GEM_FOOTER_DISCLAIMER_CIBC;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object validateFooterDisclaimerSunLife(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_FOOTER_DISCLAIMER_SUNLIFE_FR : LO_TXT_FOOTER_DISCLAIMER_SUNLIFE;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object validateFooterTradeMarkNoticeSunLife(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_TRADE_MARK_NOTICE_AND_LOGOS_FR : LO_TXT_TRADE_MARK_NOTICE_AND_LOGOS;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object validateFooterDisclaimerBelair(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_GEM_FOOTER_DISCLAIMER_BELAIR_FR : LO_TXT_GEM_FOOTER_DISCLAIMER_BELAIR;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(),
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
    public Object validateGemBottom_Left_Logo_ORION() {
        String result = validateLocatorExists(LO_IMG_GEM_BOTTOM_LOGO_ORION, FW_ConfigMgr.getDefaultTimeout(),
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
     * Clicks the 'Continue Draft Claim' button.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object clickContinueDraftClaimButton(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_BUT_CONTINUE_DRAFT_CLAIM_FR : LO_BUT_CONTINUE_DRAFT_CLAIM;
        String result = clickLocator(locator, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object applyWait() {
        waitForDuration(5, "s", true);
        String result = "[Pass] - Wait applied.";
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object clickSingleSignOnGEM(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_LNK_SSGEM_ACCOUNT_FR : LO_LNK_SSGEM_ACCOUNT;
        String result = clickLocator(locator, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object selectExternalSource(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_RAD_EXTERNAL_FR : LO_RAD_EXTERNAL;
        String result = clickLocator(locator, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    public Object clickToAcceptSpecialDropdown(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_PRIMARY_CONTACT_FR : LO_TXT_PRIMARY_CONTACT;
        String result = clickLocator(locator, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object enterGEmail(String language, String email) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_EDT_G_EMAIL_FR : LO_EDT_G_EMAIL;
        String result = setText(locator, email, FW_ConfigMgr.getDefaultTimeout(), false);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object enterPolicyReference(String language, String referenceNumber) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_EDT_POLICY_REFERENCE_FR : LO_EDT_POLICY_REFERENCE;
        String result = setText(locator, referenceNumber, FW_ConfigMgr.getDefaultTimeout(), false);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    public Object enterOtherReference(String language, String OtherreferenceNumber) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_EDT_OTHER_REFERENCE_FR : LO_EDT_OTHER_REFERENCE;
        String result = setText(locator, OtherreferenceNumber, FW_ConfigMgr.getDefaultTimeout(), false);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object clickNextButton(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_BUT_NEXT_FR : LO_BUT_NEXT;
        String result = clickLocator(locator, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object enterGPassword(String language, String password) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_EDT_G_PASSWORD_FR : LO_EDT_G_PASSWORD;
        String result = setText(locator, password, FW_ConfigMgr.getDefaultTimeout(), false);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object clickSignInButton(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_BUT_G_SIGN_IN_FR : LO_BUT_G_SIGN_IN;
        String result = clickLocator(locator, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object clickSearchButton(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_BUT_SEARCH_FR : LO_BUT_SEARCH;
        String result = clickLocator(locator, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    public Object clickFirstNameFound(String language, String FirstNameSearched) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_FIRST_NAME_SEARCHED_FR : LO_TXT_FIRST_NAME_SEARCHED;
        locator = locator + "'" + FirstNameSearched + "'])[1]";
        clickLocator(locator, FW_ConfigMgr.getDefaultTimeout());
        String result = clickLocator(locator, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object verifyFirstName(String language, String FirstName) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_FIRST_NAME_UPDATED_FR : LO_TXT_FIRST_NAME_UPDATED;
        String result = validateWithinLocatorText(locator,FirstName,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    public Object verifyLastName(String language, String LastName) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_LAST_NAME_UPDATED_FR : LO_TXT_LAST_NAME_UPDATED;
        String result = validateWithinLocatorText(locator,LastName,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    // public Object clickFirstNameFound(String language, String corporateClient) {
    //     String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_FIRST_NAME_SEARCHED_FR : LO_TXT_FIRST_NAME_SEARCHED;
    //     locator = locator + "'" + corporateClient + "'])[1]";
    //     clickLocator(locator, FW_ConfigMgr.getDefaultTimeout());
    //     String result = clickLocator(locator, FW_ConfigMgr.getDefaultTimeout());
    //     FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
    //     return resultObj;
    // }

    public Object clickPolicyNumber(String language, String policyReference) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_POLICY_REFERENCE_FR : LO_TXT_POLICY_REFERENCE;
        locator = locator + "'" + policyReference + "']]";
        //clickLocator(locator, FW_ConfigMgr.getDefaultTimeout());
        String result = clickLocator(locator, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    public Object verifyPolicyReference(String language, String policyReference) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_POLICY_REFERENCE_VERIFICATION_FR : LO_TXT_POLICY_REFERENCE_VERIFICATION;
        String result = validateWithinLocatorText(locator,policyReference,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    public Object verifyCoorporateClient(String language, String corporateClient) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_CORPORATE_CLIENT_VERIFICATION_FR : LO_TXT_CORPORATE_CLIENT_VERIFICATION;
        String result = validateWithinLocatorText(locator,corporateClient,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object clickOnReferenceNumber(String language, String policyNumber) {
        //waitForDuration(5);
        CLICK_ON_REFERENCE_NUMBER = CLICK_ON_REFERENCE_NUMBER + policyNumber +  "']]";
        String locator = "fr".equalsIgnoreCase(language) ? CLICK_ON_REFERENCE_NUMBER_FR : CLICK_ON_REFERENCE_NUMBER;
        String result = clickLocator(locator, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        CLICK_ON_REFERENCE_NUMBER= "//div[div[div[p[text()='Policy number']]]]/following-sibling::div//p[strong[text()='";
        return resultObj;
    }

    public Object clickOnCoorporateClient(String language, String corporateClient) {
       waitForDuration(5);
        CLICK_ON_CORPORATE_CLIENT = CLICK_ON_CORPORATE_CLIENT + corporateClient +  "']";
        String locator = "fr".equalsIgnoreCase(language) ? CLICK_ON_CORPORATE_CLIENT_FR : CLICK_ON_CORPORATE_CLIENT;
        String result = clickLocator(locator, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        CLICK_ON_CORPORATE_CLIENT= "//div[span[text()='Corporate Client']]/following-sibling::div//p[text()='";
        return resultObj;
    }

    public Object verifyOrganizationCode(String language, String organizationCode) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_ORGANIZATION_CODE_VERIFICATION_FR : LO_TXT_ORGANIZATION_CODE_VERIFICATION;
        String result = validateWithinLocatorText(locator,organizationCode,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    public Object verifyIssueDate(String language, String issueDate) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_ISSUE_DATE_VERIFICATION_FR : LO_TXT_ISSUE_DATE_VERIFICATION;
        String result = validateWithinLocatorText(locator,issueDate,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object verifyStartDate(String language, String startDate) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_START_DATE_VERIFICATION_FR : LO_TXT_START_DATE_VERIFICATION;
        String result = validateWithinLocatorText(locator,startDate,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object verifyEndDate(String language, String endDate) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_END_DATE_VERIFICATION_FR : LO_TXT_END_DATE_VERIFICATION;
        String result = validateWithinLocatorText(locator,endDate,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object verifyProduct(String language, String product) {
        //waitForDuration(5);
        LO_TXT_PRODUCT_VERIFICATION = LO_TXT_PRODUCT_VERIFICATION + product +  "']";
        String locator = "fr".equalsIgnoreCase(language) ? CLICK_ON_REFERENCE_NUMBER_FR : LO_TXT_PRODUCT_VERIFICATION;
        String result = validateWithinLocatorText(locator,product,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        LO_TXT_PRODUCT_VERIFICATION = "//div[span[text()='Corporate Client']]/following-sibling::div//p[text()='";
        return resultObj;
    }
    public Object verifyProductCode(String language, String productCode) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_PRODUCT_CODE_VERIFICATION_FR : LO_TXT_PRODUCT_CODE_VERIFICATION;
        String result = validateWithinLocatorText(locator,productCode,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object clickYesToStaySignedInButton(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_BUT_YES_STAY_SIGNED_IN_G_FR : LO_BUT_YES_STAY_SIGNED_IN_G;
        String result = clickLocator(locator, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object clickCreateNewClaimButtonAsAgent(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_BUT_CREATE_NEW_CLAIM_AS_AGENT_FR : LO_BUT_CREATE_NEW_CLAIM_AS_AGENT;
        String result = clickLocator(locator, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object clickOnPolicesButton(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_BUT_POLICIES_FR : LO_BUT_POLICIES;
        String result = clickLocator(locator, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    public Object clickSearchAndCreatePolicyButton(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_BUT_SEARCH_AND_CREATE_POLICY_FR : LO_BUT_SEARCH_AND_CREATE_POLICY;
        String result = clickLocator(locator, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object verifyOnPageAppian(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_ON_PAGE_VERIFICATION_APPIAN_FR : LO_TXT_ON_PAGE_VERIFICATION_APPIAN;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object verifyEligibilityLabel(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_ELIGIBILITY_FR : LO_TXT_ELIGIBILITY;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object verifyCustomerLabel(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_CUSTOMER_FR : LO_TXT_CUSTOMER;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object selectManulifeAsCorporateClient(String corporateClient, String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_LST_CORPORATE_CLIENT_FR : LO_LST_CORPORATE_CLIENT;
        String result = setDropdownAppian(locator, corporateClient, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    public Object selectDatabaseSearchOption(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_RAD_CLIENT_DATABASE_FR : LO_RAD_CLIENT_DATABASE;
        String result = clickLocator(locator, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object selectCountryAppian(String corporateClient, String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_LST_CORPORATE_CLIENT_FR : LO_LST_CORPORATE_CLIENT;
        String result = setDropdownAppian(locator, corporateClient, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object selectInsuranceType(String insuranceType, String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_LST_INSURANCE_TYPE_FR : LO_LST_INSURANCE_TYPE;
        String result = setDropdownAppian(locator, insuranceType, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object enterPolicyNumberOrCertificateID(String policyNumberOrCertificateID, String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_POLICY_NUMBER_CERTIFICATE_ID_FR : LO_TXT_POLICY_NUMBER_CERTIFICATE_ID;
        String result = setText(locator, policyNumberOrCertificateID, FW_ConfigMgr.getDefaultTimeout(), false);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object selectClaimTypeAgent(String claimType, String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_LST_CLAIM_TYPE_AGENT_FR : LO_LST_CLAIM_TYPE_AGENT;
        String result = setDropdownAppian(locator, claimType, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object enterGroupNameAgent(String policyNumberOrCertificateID, String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_EDT_GROUP_NAME_AGENT_FR : LO_EDT_GROUP_NAME_AGENT;
        String result = setText(locator, policyNumberOrCertificateID, FW_ConfigMgr.getDefaultTimeout(), false);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object verifyGroupNameAgentUpdate(String groupName, String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_EDT_GROUP_NAME_AGENT_VERIFICATION_FR : LO_EDT_GROUP_NAME_AGENT_VERIFICATION;
        String result = validateWithinLocatorText(locator,groupName,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    public Object verifyCityNameAgentUpdate(String cityName, String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_EDT_CITY_NAME_AGENT_VERIFICATION_FR : LO_EDT_CITY_NAME_AGENT_VERIFICATION;
        String result = validateWithinLocatorText(locator,cityName,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object selectEmailAsPreferredMethodOfCommunication(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_RAD_PREFERRED_METHOD_COMMUNICATION_EMAIL_AGENT_FR : LO_RAD_PREFERRED_METHOD_COMMUNICATION_EMAIL_AGENT;
        String result = clickLocator(locator, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object selectYesToCOBIN(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_RAD_YES_COB_IN_AGENT_FR : LO_RAD_YES_COB_IN_AGENT;
        String result = clickLocator(locator, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object selectReasonForInterruption(String reasonForInterruption, String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_LST_REASON_FOR_INTERRUPTION_AGENT_FR : LO_LST_REASON_FOR_INTERRUPTION_AGENT;
        String result = setDropdownAppian(locator, reasonForInterruption, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object selectReasonForCancelling(String reasonForCancellation, String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_LST_REASON_FOR_CANCELLING_AGENT : LO_LST_REASON_FOR_CANCELLING_AGENT;
        String result = setDropdownAppian(locator, reasonForCancellation, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object selectReasonForInterruptionRelatedTo(String reasonForInterruption, String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_LST_REASON_FOR_INTERRUPTION_RELATED_TO_AGENT_FR : LO_LST_REASON_FOR_INTERRUPTION_RELATED_TO_AGENT;
        String result = setDropdownAppian(locator, reasonForInterruption, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object selectReasonForCancellationRelatedTo(String reasonForCancellation, String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_LST_REASON_FOR_CANCELLATION_RELATED_TO_AGENT : LO_LST_REASON_FOR_CANCELLATION_RELATED_TO_AGENT;
        String result = setDropdownAppian(locator, reasonForCancellation, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object selectYesToExistingGEClaimNumber(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_RAD_YES_EXISTING_GE_CLAIM_NUMBER_AGENT_FR : LO_RAD_YES_EXISTING_GE_CLAIM_NUMBER_AGENT;
        String result = clickLocator(locator, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object enterClaimNumber(String claimNumber, String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_EDT_CLAIM_NUMBER_AGENT_FR : LO_EDT_CLAIM_NUMBER_AGENT;
        String result = setText(locator, claimNumber, FW_ConfigMgr.getDefaultTimeout(), false);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object clickContinueButton(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_BUT_CONTINUE_AGENT_FR : LO_BUT_CONTINUE_AGENT;
        String result = clickLocator(locator, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object verifyCorporateClient(String language, String corporateClient) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_CORPORATE_CLIENT_FR : LO_TXT_CORPORATE_CLIENT;
        String result = validateWithinLocatorText(locator,corporateClient,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object selectCreateNewClaimButton(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_BUT_CREATE_NEW_CLAIM_FR : LO_BUT_CREATE_NEW_CLAIM;
        String result = clickLocator(locator, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Clicks the 'Start New Claim' button.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object clickButtonStartNewClaim(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_BUT_START_NEW_CLAIM_FR : LO_BUT_START_NEW_CLAIM;
        String result = clickLocator(locator, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    public Object clickButtonStartNewClaimMGB() {
        String result = clickLocator(LO_BUT_START_NEW_CLAIM_MGB, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object clickTDLogo() {
        String result = clickLocator(LO_IMG_GEM_TOP_LOGO_TD, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Clicks the 'CHECK CLAIM STATUS' button.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object clickCheckClaimStatusButton(String language) {
        waitForDuration(5, "s", false); // Wait to perform next check
        String locator = "fr".equalsIgnoreCase(language) ? LO_BUT_CHECK_CLAIM_STATUS_FR : LO_BUT_CHECK_CLAIM_STATUS;
        String result = clickLocator(locator, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Checks to see if the System is down error message exist.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object validateSystemNotDown() {
        String result = validateLocatorNotExists(LO_TXT_SYSTEM_STATUS, FW_ConfigMgr.getDefaultTimeout(),
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
     * Clicks the 'HELP CENTER' link.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object clickHelpCentreLink(String language) {
        waitForDuration(5, "s", false); // Wait to perform next check
        String locator = "fr".equalsIgnoreCase(language) ? LO_LNK_HELP_CENTRE_HEADER_FR : LO_LNK_HELP_CENTRE_HEADER;
        String result = clickLocator(locator, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Clicks the 'HELP CENTER' link.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object clickHelpCentreHeaderLight(String language) {
        waitForDuration(5, "s", false); // Wait to perform next check
        String locator = "fr".equalsIgnoreCase(language) ? LO_LNK_HELP_CENTRE_TOP_FR : LO_LNK_HELP_CENTRE_TOP;
        String result = clickLocator(locator, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    public Object validateOnPageBelair(String language) {
        // waitForDuration(5, "s", false); // Wait to perform next check
        String locator = "fr".equalsIgnoreCase(language) ? LO_HOME_PAGE_VERIFY_BELAIR_FR : LO_HOME_PAGE_VERIFY_BELAIR;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Clicks the 'HELP CENTER' link in the footer.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object clickHelpCentreLinkFooter() {
        waitForDuration(5, "s", false); // Wait to perform next check
        String result = clickLocator(LO_LNK_HELP_CENTRE_FOOTER, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Clicks the 'Visit our help centre' button.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object clickVisitOurHelpCentreButton() {
        waitForDuration(5, "s", false); // Wait to perform next check
        scrollToLocator(LO_BUT_VISIT_OUR_HELP_CENTRE);
        String result = clickLocator(LO_BUT_VISIT_OUR_HELP_CENTRE, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Clicks the 'FRANÇAIS' button.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object clickFrancaisButton(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_BUT_FRANÇAIS : LO_BUT_ENGLISH;
        String result = clickLocator(locator, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object verifyOnFrenchPageTravelClaimCenter() {
        String result = validateLocatorExists(LO_HOME_PAGE_VERIFY_FRENCH__TRAVEL_CLAIM_CENTER, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object verifyOnFrenchPageMGB() {
        String result = validateLocatorExists(LO_HOME_PAGE_VERIFY_FRENCH_MGB, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Clicks the 'FRANÇAIS' button.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object clickFrancaisButton_Dark() {
        String result = clickLocator(LO_BUT_FRANÇAIS_DARK, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if current french webpage is loaded and correct.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object verifyOnFrenchPage(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_HOME_PAGE_VERIFY_FRENCH_FR : LO_HOME_PAGE_VERIFY_FRENCH;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if current french webpage is loaded and correct.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object verifyOnFrenchPageCIBC() {
        String result = validateLocatorExists(LO_HOME_PAGE_VERIFY_FRENCH_CIBC, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if current french webpage is loaded and correct.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object verifyOnFrenchPageAmex() {
        String result = validateLocatorExists(LO_TXT_HOME_PAGE_VERIFY_FRENCH_PAGE_AMEX, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if current french webpage is loaded and correct.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object verifyOnFrPage() {
        String result = validateLocatorExists(LO_FR_HOME_PAGE_VERIFY, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Clicks the 'ENGLISH' button.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object clickEnglishButton(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_BUT_ENGLISH : LO_BUT_ENGLISH_DARK;
        String result = clickLocator(locator, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object validateOnPageTravelClaimCenter() {
        // waitForDuration(5, "s", false); // Wait to perform next check
        String result = validateLocatorExists(LO_HOME_PAGE_VERIFY_TRAVEL_CLAIM_CENTER, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Clicks the 'ENGLISH' button.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object clickEnglishButton_Dark() {
        String result = clickLocator(LO_BUT_ENGLISH_DARK, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if the "FRANÇAIS" button does not exist on the BCAA portal.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object verifyFrancaisButtonDoesNotExist() {
        String result = validateLocatorNotExists(LO_BUT_FRANÇAIS, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Clicks the X button on the yellow bunner - Important Message.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object closeYellowImportantInformationBunnerAtTop() {
        boolean bunner = waitToExist(LO_BUT_BURNNER_TOP_YELLOW_IMPORTANT_MESSAGE, 1, FW_ConfigMgr.getDefaultInterval());
        if (bunner == true) {
            String result = clickLocator(LO_BUT_BURNNER_TOP_YELLOW_IMPORTANT_MESSAGE, FW_ConfigMgr.getDefaultTimeout());
            result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
            return result;
        }
        String result = "[PASS] Yellow bunner does not exist - continuie with the normal flow";
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
    public Object validateGem_Top_Left_Logo_Manulife() {
        String result = validateLocatorExists(LO_IMG_GEM_TOP_LOGO_MANULIFE, FW_ConfigMgr.getDefaultTimeout(),
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
    public Object validateGem_Top_Left_Logo_BCAA() {
        String result = validateLocatorExists(LO_IMG_GEM_TOP_LOGO_BCAA, FW_ConfigMgr.getDefaultTimeout(),
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
    public Object validateMainHeadingParagraph(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_MAIN_HEADING_PARAGRAPH_FR : LO_TXT_MAIN_HEADING_PARAGRAPH;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(),
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

    public Object validateHelpCentreHeaderAsLink() {
        String result = validateLocatorExists(LO_LNK_HELP_CENTRE_TOP_AS_LINK, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if the French/English Button toggle at top right is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object validateFrenchButtonToggle() {
        String result = validateLocatorExists(LO_BUT_FRANÇAIS, FW_ConfigMgr.getDefaultTimeout(),
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
     * Validates if Clicks the Help Centre at top right is present(Dark_background).
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object clickHelpCentreHeader_Dark() {
        String result = clickLocator(LO_LNK_HELP_CENTRE_TOP_DARK, FW_ConfigMgr.getDefaultTimeout());
result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
return result;
}
    

    /**
     * Validates if the NEW CLAIM heading card is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object validateNewClaimHeadingCard(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_NEW_CLAIM_HEADING_CARD_FR : LO_TXT_NEW_CLAIM_HEADING_CARD;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if the NEW CLAIM paragraph card is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object validateNewClaimParagraphCard(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_NEW_CLAIM_PARAGRAPH_CARD_FR : LO_TXT_NEW_CLAIM_PARAGRAPH_CARD;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if the Draft Claim heading card is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object validateDraftClaimHeadingCard(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_DRAFT_CLAIM_HEADING_CARD_FR : LO_TXT_DRAFT_CLAIM_HEADING_CARD;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if the Draft CLAIM paragraph card is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object validateDraftClaimParagraphCard(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_DRAFT_CLAIM_PARAGRAPH_CARD_FR : LO_TXT_DRAFT_CLAIM_PARAGRAPH_CARD;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if the Active Claim heading card is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object validateActiveClaimHeadingCard(String language) {
        String result = validateLocatorExists(LO_TXT_ACTIVE_CLAIM_HEADING_CARD, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    public Object validateSubmitDocumentsHeadingCard(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_SUBMIT_DOCUMENTS_HEADING_CARD_FR : LO_TXT_SUBMIT_DOCUMENTS_HEADING_CARD;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if the Active CLAIM paragraph card is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object validateActiveClaimParagraphCard(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_ACTIVE_CLAIM_PARAGRAPH_CARD_FR : LO_TXT_ACTIVE_CLAIM_PARAGRAPH_CARD;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object validateSubmitDocumentsParagraphCard(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_SUBMIT_DOCUMENTS_PARAGRAPH_CARD_FR : LO_TXT_SUBMIT_DOCUMENTS_PARAGRAPH_CARD;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if the "Need help? We're here to assist you!" heading is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object validateNeedHelpHeader(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_NEED_HELP_HEADING_FR : LO_TXT_NEED_HELP_HEADING;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if the paragraph below the "Need help? We're here to assist you!" heading is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object validateNeedHelpParagraph(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_NEED_HELP_PARAGRAPH_FR : LO_TXT_NEED_HELP_PARAGRAPH;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if the Assistance Icon is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object validateAssistanceIconAmex() {
        String result = validateLocatorExists(LO_IMG_ASSISTANCE_ICON_AMEX, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if the Assistance Icon is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object validateAssistanceIconIntact() {
        String result = validateLocatorExists(LO_IMG_ASSISTANCE_ICON_INTACT, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if the Assistance Icon is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object validateAssistanceIconCL() {
        String result = validateLocatorExists(LO_IMG_ASSISTANCE_ICON_CL, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if the Assistance Icon is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object validateAssistanceIconScotia() {
        String result = validateLocatorExists(LO_IMG_ASSISTANCE_ICON_SCOTIA, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if the Assistance Icon is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object validateAssistanceIconTD() {
        String result = validateLocatorExists(LO_IMG_ASSISTANCE_ICON_TD, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if the Assistance Icon is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object validateAssistanceIconMGB() {
        String result = validateLocatorExists(LO_IMG_ASSISTANCE_ICON_MGB, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if the Assistance Icon is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object validateAssistanceIconOrion() {
        String result = validateLocatorExists(LO_IMG_ASSISTANCE_ICON_ORION, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if the Assistance Icon is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object validateAssistanceIconSunLife() {
        String result = validateLocatorExists(LO_IMG_ASSISTANCE_ICON_SUNLIFE, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if the Assistance Icon is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object validateAssistanceIconGem() {
        String result = validateLocatorExists(LO_IMG_ASSISTANCE_ICON_GEM, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if the Assistance Icon is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object validateAssistanceIconManulife() {
        String result = validateLocatorExists(LO_IMG_ASSISTANCE_ICON_MANULIFE, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if the Assistance Icon is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object validateAssistanceIconBCAA() {
        String result = validateLocatorExists(LO_IMG_ASSISTANCE_ICON_BCAA, FW_ConfigMgr.getDefaultTimeout(),
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
    public Object validateGemBottom_Left_Logo_BCAA() {
        String result = validateLocatorExists(LO_IMG_GEM_BOTTOM_LOGO_BCAA, FW_ConfigMgr.getDefaultTimeout(),
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
    public Object validateGemBottom_Left_Logo_TD() {
        String result = validateLocatorExists(LO_IMG_GEM_BOTTOM_LOGO_TD, FW_ConfigMgr.getDefaultTimeout(),
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
    public Object validateHelpCentreFooterLink() {
        String result = validateLocatorExists(LO_LNK_HELP_CENTRE_BOTTOM, FW_ConfigMgr.getDefaultTimeout(),
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
    public Object validateMedicalEmergencyHelpLineNonTollFree(String language, String number) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_MEDICAL_EMERGENCY_HELPLINE_NON_TOLL_FREE_FR : LO_TXT_MEDICAL_EMERGENCY_HELPLINE_NON_TOLL_FREE;
        locator = locator + "'" + number + "']";
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(),
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
    public Object validateMedicalEmergencyHelpLineTollFree(String language, String tollFreeNumber) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_MEDICAL_EMERGENCY_HELPLINE_TOLL_FREE_FR : LO_TXT_MEDICAL_EMERGENCY_HELPLINE_TOLL_FREE;
        locator = locator + "'" + tollFreeNumber + "']";
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(),
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
    public Object validateMedicalEmergencyHelpLineTollFree2(String language, String tollFreeNumber) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_MEDICAL_EMERGENCY_HELPLINE_TOLL_FREE2_FR : LO_TXT_MEDICAL_EMERGENCY_HELPLINE_TOLL_FREE2;
        locator = locator + "'" + tollFreeNumber + "']";
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(),
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
    public Object validateFooterDisclaimer2(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_GEM_FOOTER_DISCLAIMER_2_FR : LO_TXT_GEM_FOOTER_DISCLAIMER_2;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(),
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
    public Object validateFooterDisclaimerBCAA(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_GEM_FOOTER_DISCLAIMER_BCAA_FR : LO_TXT_GEM_FOOTER_DISCLAIMER_BCAA;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(),
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
    public Object validateFooterTradeMarkNotice(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_TRADE_MARK_NOTICE_FR : LO_TXT_TRADE_MARK_NOTICE;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(),
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
     * Validates if the Copy Right Notice is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object validateFooterCopyRightNotice_2025(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_COPY_RIGHT_NOTICE_2025_FR : LO_TXT_COPY_RIGHT_NOTICE_2025;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object validateFooterTradeMarkNoticeZurich() {
        String result = validateLocatorExists(LO_TXT_TRADE_MARK_NOTICE, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object validateFooterDisclaimerZurich() {
        String result = validateLocatorExists(LO_TXT_FOOTER_DISCLAIMER_ZURICH, FW_ConfigMgr.getDefaultTimeout(),
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
    public Object validateMedicalEmergencyHelpLineHeading_LightBackground(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_MEDICAL_EMERGENCY_HELPLINE_HEADING_LIGHT_FR : LO_TXT_MEDICAL_EMERGENCY_HELPLINE_HEADING_LIGHT;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(),
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
    public Object validateFooterPrivacyStatement(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_LNK_PRIVACY_STATEMENT_FR : LO_LNK_PRIVACY_STATEMENT;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(),
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
    public Object validateFooterConditionsOfUse(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_LNK_CONDITIONS_OF_USE_FR : LO_LNK_CONDITIONS_OF_USE;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    public Object validateFooterComplaintPolicy(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_LNK_COMPLAINT_POLICY_FR : LO_LNK_COMPLAINT_POLICY;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object validateFooterPrivacyStatementStrong() {
        String result = validateLocatorExists(LO_LNK_PRIVACY_STATEMENT_STRONG, FW_ConfigMgr.getDefaultTimeout(),
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
    public Object validateFooterConditionsOfUseStrong() {
        String result = validateLocatorExists(LO_LNK_CONDITIONS_OF_USE_STRONG, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    public Object validateFooterComplaintPolicyStrong() {
        String result = validateLocatorExists(LO_LNK_COMPLAINT_POLICY_STRONG, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

}
