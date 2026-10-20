package pageobjects;

// Import class packages for this Page Object (PO)
import org.openqa.selenium.WebDriver;

import customizations.automation.CU_Appian; // Customization for Appian and where FW_Page is extended

import framework.junit.FW_TestStep;
import framework.utilities.FW_ConfigMgr;
import framework.utilities.FW_DateTimeUtils;
import framework.utilities.FW_TestStepUtils;

public class PO_Home extends CU_Appian {

    private static final String LO_HOME_PAGE_VERIFY = "//strong[contains(text(), 'Claim Centre')]/..";
    private static final String LO_TXT_AMEX_HOME_PAGE_VERIFY = "//span[contains(text(), 'Welcome to your Travel Claim Centre for your ') and strong[contains(text(), 'AMEX Card')]]";
    private static final String LO_HOME_PAGE_VERIFY_CIBC = "//span[span and text()='Welcome to your Claim Centre for your ' and strong='CIBC Credit Card']";
    private static final String LO_HOME_PAGE_VERIFY_ORION = "//span[text()='Welcome to your ' and strong='Orion Claim Centre' and span='administered by' and span='Global Excel Management']";
    private static final String LO_HOME_PAGE_VERIFY_MGB = "//span[text()='Welcome to your Manulife Group Benefits Travel  Claim Centre']";
    private static final String LO_BUT_START_NEW_CLAIM = "//strong[contains(text(),'START A NEW CLAIM')]";
    private static final String LO_BUT_CONTINUE_DRAFT_CLAIM = "//strong[contains(text(), 'CONTINUE DRAFT CLAIM')]";
    private static final String LO_BUT_CHECK_CLAIM_STATUS = "//strong[contains(text(), 'CHECK CLAIM STATUS')]";
    private static final String LO_BUT_VISIT_OUR_HELP_CENTRE = "//strong[contains(text(), 'VISIT OUR HELP CENTRE')]";
    private static final String LO_BUT_SIGN_IN = "//strong[contains(text(), 'View Status')]";
    private static final String LO_BUT_SIGN_IN_TD = "//strong[contains(text(), 'SIGN IN')]";
    private static final String LO_TXT_SYSTEM_STATUS = "//h4[contains(text(), 'The System Has Encountered an Error')]";
    private static final String LO_BUT_VIEW_STATUS = "//strong[contains(text(),'View Status')]";
    private static final String LO_LNK_HELP_CENTRE_HEADER = "((//span[text()='FR' or text()='FRANÇAIS']/ancestor::div[1]/../../preceding-sibling::div)[2]/div) | (//a[contains(text(), 'HELP CENTRE')])[1]";
    private static final String LO_LNK_HELP_CENTRE_FOOTER = "(//span/a[text()='HELP CENTRE'])[1] | (//span/a[text()='HELP CENTRE'])[2]";
    private static final String LO_BUT_FRANÇAIS = "//p[span[a[(span[span[@class='IconWidget---inLightBackground'] and span[contains(text(), 'FR')]]) or (span[@class='IconWidget---inLightBackground'] and span[contains(text(), 'FRANÇAIS')])]]]";
    private static final String LO_HOME_PAGE_VERIFY_FRENCH = "//strong[contains(text(), 'centre de réclamation')]";
    private static final String LO_TXT_HOME_PAGE_VERIFY_FRENCH_PAGE_AMEX = "//span[contains(text(), 'Bienvenue à votre centre de réclamation de voyage pour votre ') and strong[contains(text(), 'carte AMEX')]]";
    private static final String LO_FR_HOME_PAGE_VERIFY = "//strong[contains(text(), 'carte de crédit CIBC')]";
    private static final String LO_BUT_ENGLISH = "//a[(span[span[@class='IconWidget---inLightBackground'] and span[contains(text(), 'EN')]]) or (span[@class='IconWidget---inLightBackground'] and span[contains(text(), 'ENGLISH')])]";
    private static final String LO_BUT_BURNNER_TOP_YELLOW_IMPORTANT_MESSAGE = "//div[@class='SideBySideGroup---side_by_side SideBySideGroup---default_direction SideBySideGroup---top']/div[div//strong[contains(text(), ' Important Information – Potential Canada Post mail disruption')]]/following-sibling::div//div[@class='FieldLayout---input_below']";
    private static final String LO_BUT_BURNNER_TOP_YELLOW_TEST_INDIVIDUAL_MESSAGE = "//div[@class='SideBySideGroup---side_by_side SideBySideGroup---default_direction SideBySideGroup---top']/div[div//strong[contains(text(), 'Test Individual message')]]/following-sibling::div//div[@class='FieldLayout---input_below']";
    private static final String LO_IMG_GEM_TOP_LOGO = "//a//img[@src='https://geihpvqvwebgencacn1.blob.core.windows.net/appian-portal/logo_header_en_GEM.png' or @src='https://geihpvtvwebgencacn1.blob.core.windows.net/appian-portal/logo_header_en_GEM.png']";
    private static final String LO_IMG_GEM_TOP_LOGO_BCAA = "//a//img[@src='https://geihpvqvwebgencacn1.blob.core.windows.net/appian-portal/logo_header_en_BCAA.png' or @src='https://geihpvtvwebgencacn1.blob.core.windows.net/appian-portal/logo_header_en_BCAA.png']";
    private static final String LO_TXT_MAIN_HEADING_PARAGRAPH = "//p//span[contains(text(), 'We understand that facing unexpected situations in an unfamiliar environment can be stressful. In order to help, we offer assistance services with experts ready to support you in case of an emergency.')]";
    private static final String LO_LNK_HELP_CENTRE_TOP = "//p[span[a[(span/span[@class='IconWidget---inLightBackground'][not(following-sibling::span)]) or (span[@class='IconWidget---inLightBackground'] and text()='HELP CENTRE')]]]";
    private static final String LO_TXT_NEW_CLAIM_HEADING_CARD = "//h3[contains(text(), 'New Claim')]";
    private static final String LO_TXT_NEW_CLAIM_PARAGRAPH_CARD = "//p[contains(text(), 'Ready to submit a new claim? Begin the process here.')]";
    private static final String LO_TXT_DRAFT_CLAIM_HEADING_CARD = "//h3[contains(text(), 'Draft Claim')]";
    private static final String LO_TXT_DRAFT_CLAIM_PARAGRAPH_CARD = "//p[contains(text(), 'Already started a new claim? Continue your submission here.')]";
    private static final String LO_TXT_ACTIVE_CLAIM_HEADING_CARD = "//h3[contains(text(), 'Active Claim')]";
    private static final String LO_TXT_ACTIVE_CLAIM_PARAGRAPH_CARD = "//p[contains(text(), 'Submitted a claim and want to check the status? Get updates here.')]";
    private static final String LO_TXT_NEED_HELP_HEADING = "//h3[contains(text(), \"Need help? We're here to assist you!\")]";
    private static final String LO_TXT_NEED_HELP_PARAGRAPH = "//p[text()=\"Whether you're at home or travelling, Global Excel is here to assist you. Visit our Help Centre to learn more about the tools and services available to you.\"]";
    private static final String LO_IMG_ASSISTANCE_ICON_AMEX = "//div//img[@src='https://geihpvqvwebgencacn1.blob.core.windows.net/appian-portal/assistance_icon_AMEX.png' or @src='https://geihpvtvwebgencacn1.blob.core.windows.net/appian-portal/assistance_icon_AMEX.png']";
    private static final String LO_IMG_ASSISTANCE_ICON_BCAA = "//div//img[@src='https://geihpvqvwebgencacn1.blob.core.windows.net/appian-portal/assistance_icon_BCAA.png' or @src='https://geihpvtvwebgencacn1.blob.core.windows.net/appian-portal/assistance_icon_BCAA.png']";
    private static final String LO_IMG_GEM_BOTTOM_LOGO_DARK = "//div//img[@src='https://geihpvqvwebgencacn1.blob.core.windows.net/appian-portal/logo_footer_GEM_claim_center_en_dark.png' or @src='https://geihpvtvwebgencacn1.blob.core.windows.net/appian-portal/logo_footer_GEM_claim_center_en_dark.png']";
    private static final String LO_IMG_GEM_BOTTOM_LOGO_BCAA = "//div//img[@src='https://geihpvqvwebgencacn1.blob.core.windows.net/appian-portal/logo_footer_en_BCAA.png' or @src='https://geihpvtvwebgencacn1.blob.core.windows.net/appian-portal/logo_footer_en_BCAA.png']";
    private static final String LO_LNK_START_NEW_CLAIM_FOOTER = "//p[span[@class='IconWidget---medium IconWidget---inDarkBackground']/following-sibling::span/a[contains(text(), 'START A NEW CLAIM')]]";
    private static final String LO_LNK_CONTINUE_DRAFT_CLAIM_FOOTER = "//p[span[@class='IconWidget---medium IconWidget---inDarkBackground']/following-sibling::span/a[contains(text(), 'CONTINUE DRAFT CLAIM')]]";
    private static final String LO_LNK_SUBMIT_DOCUMENTS_FOOTER = "//p[span[@class='IconWidget---medium IconWidget---inDarkBackground']/following-sibling::span/a[contains(text(), 'SUBMIT DOCUMENTS')]]";
    private static final String LO_LNK_HELP_CENTRE_BOTTOM = "//p[span[@class='IconWidget---medium IconWidget---inDarkBackground']/following-sibling::span[a[contains(text(), 'HELP CENTRE')]]]";
    private static final String LO_TXT_MEDICAL_EMERGENCY_HELPLINE_HEADING = "//h3[span[//span[@class='IconWidget---inDarkBackground IconWidget---inSectionLayout2Label'] and text()='MEDICAL EMERGENCY HELPLINE']]";
    private static final String LO_TXT_FOLLOW_UP_ON_YOUR_CLAIM_HEADING = "//h3/span[contains(text(), 'FOLLOW UP ON YOUR CLAIM')]";
    private static final String LO_TXT_FOLLOW_UP_ON_YOUR_CLAIM_PARAGRAPH = "//p[contains(text(), 'You have an active claim? Follow up on your claim today in our Claim Centre!')]";
    private static final String LO_TXT_GEM_FOOTER_DISCLAIMER = "//p[text()=\"Coverage under this policy is underwritten by Belair Insurance Company Inc. Belair Insurance Company Inc. has appointed Global Excel Management Inc. operating as “Global Excel” as the provider of all assistance and claims services under this coverage.\"]";
    private static final String LO_TXT_GEM_FOOTER_DISCLAIMER_AND_ADMINISTERED = "//p[text()=\"Coverage under this policy is underwritten by Belair Insurance Company Inc. and administered by belairdirect Agency Inc. Belair Insurance Company Inc. has appointed Global Excel Management Inc. operating as “Global Excel” as the provider of all assistance and claims services under this coverage.\"]";
    private static final String LO_TXT_GEM_FOOTER_DISCLAIMER_CIBC = "//p[text()=\"Coverage under this policy is underwritten by Belair Insurance Company Inc. Belair Insurance Company Inc. has appointed Global Excel Management Inc. operating as “Global Excel” as the provider of all assistance and claims services under this coverage.\"]";
    private static final String LO_TXT_GEM_FOOTER_DISCLAIMER_BCAA = "//p[text()=\"BCAA (British Columbia Automobile Association) has appointed Global Excel Management Inc., as the provider of all assistance and claims services.\"]";
    private static final String LO_TXT_TRADE_MARK_NOTICE = "//p[text()='All trademarks and logos are the property of their respective owners.']";
    private static final String LO_TXT_TRADE_MARK_NOTICE_NO_LOGO = "//p[text()='All trademarks are the property of their respective owners.']";
    private static final String LO_TXT_COPY_RIGHT_NOTICE = "//span[contains(text(), '2024') and text()='Global Excel Management Inc.' and text()='All rights reserved.']";
     private static final String LO_TXT_COPY_RIGHT_NOTICE_2025 = "//span[span and text()=\"2025\" and text()=\"Global Excel Management Inc.\" and text()=\"All rights reserved.\"]";
    private static final String LO_LNK_PRIVACY_STATEMENT = "//a[span[contains(text(), 'Privacy Statement ') and span[@class='IconWidget---inDarkBackground']]]";
    private static final String LO_LNK_CONDITIONS_OF_USE = "//a[span[contains(text(), 'Conditions of Use ') and span[@class='IconWidget---inDarkBackground']]]";
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
    private static final String LO_TXT_GEM_FOOTER_DISCLAIMER_CL = "//p[text()='The Canada Life Assurance Company has appointed Global Excel Management Inc. as the provider of Travel Assistance and Out of Country claims services.']";
    private static final String LO_LNK_PRIVACY_STATEMENT_LIGHT = "//a[span[contains(text(), 'Privacy Statement ') and span[@class='IconWidget---inLightBackground']]]";
    private static final String LO_LNK_CONDITIONS_OF_USE_LIGHT = "//a[span[contains(text(), 'Conditions of Use ') and span[@class='IconWidget---inLightBackground']]]";
    private static final String LO_TXT_MEDICAL_EMERGENCY_HELPLINE_HEADING_LIGHT = "//h3[span[//span[@class='IconWidget---inLightBackground IconWidget---inSectionLayout2Label'] and text()='MEDICAL EMERGENCY HELPLINE']]";
    private static final String LO_IMG_GEM_BOTTOM_LOGO_CL = "//div//img[@src='https://geihpvqvwebgencacn1.blob.core.windows.net/appian-portal/logo_footer_en_CanadaLife.png' or @src='https://geihpvtvwebgencacn1.blob.core.windows.net/appian-portal/logo_footer_en_CanadaLife.png']";
    private static final String LO_TXT_GEM_FOOTER_DISCLAIMER_2 = "//p[text()='Assistance and Claims Services are administered by Global Excel Management Inc.']";
    private static final String LO_IMG_ASSISTANCE_ICON_INTACT = "//div//img[@src='https://geihpvqvwebgencacn1.blob.core.windows.net/appian-portal/assistance_icon_Intact.png' or @src='https://geihpvtvwebgencacn1.blob.core.windows.net/appian-portal/assistance_icon_Intact.png']";
    private static final String LO_IMG_GEM_TOP_LOGO_INTACT = "//a//img[@src='https://geihpvqvwebgencacn1.blob.core.windows.net/appian-portal/logo_header_en_Intact.png' or @src='https://geihpvtvwebgencacn1.blob.core.windows.net/appian-portal/logo_header_en_Intact.png']";
    private static final String LO_IMG_GEM_BOTTOM_LOGO_INTACT = "//div//img[@src='https://geihpvqvwebgencacn1.blob.core.windows.net/appian-portal/logo_footer_en_Intact.png' or @src='https://geihpvtvwebgencacn1.blob.core.windows.net/appian-portal/logo_footer_en_Intact.png']";
    private static final String LO_LNK_HELP_CENTRE_TOP_DARK = "//p[span[a[(span/span[@class='IconWidget---inDarkBackground'][not(following-sibling::span)]) or (span[@class='IconWidget---inDarkBackground'] and text()='HELP CENTRE')]]]";
    private static final String LO_BUT_FRANÇAIS_DARK = "//p[span[a[(span[span[@class='IconWidget---inDarkBackground'] and span[contains(text(), 'FR')]]) or (span[@class='IconWidget---inDarkBackground'] and span[contains(text(), 'FRANÇAIS')])]]]";
    private static final String LO_BUT_ENGLISH_DARK = "//a[(span[span[@class='IconWidget---inDarkBackground'] and span[contains(text(), 'EN')]]) or (span[@class='IconWidget---inDarkBackground'] and span[contains(text(), 'ENGLISH')])]";
    private static final String LO_IMG_GEM_TOP_LOGO_MANULIFE = "//a//img[@src='https://geihpvqvwebgencacn1.blob.core.windows.net/appian-portal/logo_header_en_Manulife.png'or @src='https://geihpvtvwebgencacn1.blob.core.windows.net/appian-portal/logo_header_en_Manulife.png']";
    private static final String LO_IMG_ASSISTANCE_ICON_MANULIFE = "//div//img[@src='https://geihpvqvwebgencacn1.blob.core.windows.net/appian-portal/assistance_icon_Manulife.png' or @src='https://geihpvtvwebgencacn1.blob.core.windows.net/appian-portal/assistance_icon_Manulife.png']";
    private static final String LO_IMG_GEM_BOTTOM_LOGO_MANULIFE = "//div//img[@src='https://geihpvqvwebgencacn1.blob.core.windows.net/appian-portal/logo_footer_en_Manulife.png' or @src='https://geihpvtvwebgencacn1.blob.core.windows.net/appian-portal/logo_footer_en_Manulife.png']";
    private static final String LO_TXT_GEM_FOOTER_DISCLAIMER_MANULIFE = "//p[text()='Global Excel Management provides Claims and Assistance Services for The Manufacturers Life Insurance Company (Manulife).']";
    private static final String LO_IMG_GEM_TOP_LOGO_MGB = "//a//img[@src='https://geihpvqvwebgencacn1.blob.core.windows.net/appian-portal/logo_header_en_ManulifeGroupBenefits.png' or @src='https://geihpvtvwebgencacn1.blob.core.windows.net/appian-portal/logo_header_en_ManulifeGroupBenefits.png']";
    private static final String LO_TXT_GEM_FOOTER_DISCLAIMER_MGB = "//p[text()='Global Excel Management provides Claims and Assistance Services for The Manufacturers Life Insurance Company (Manulife).']";
    private static final String LO_IMG_GEM_BOTTOM_LOGO_GEM_MGB = "//div//img[@src='https://geihpvqvwebgencacn1.blob.core.windows.net/appian-portal/logo_footer_en_ManulifeGroupBenefits_GEM.png' or @src='https://geihpvtvwebgencacn1.blob.core.windows.net/appian-portal/logo_footer_en_ManulifeGroupBenefits_GEM.png']";
    private static final String LO_IMG_GEM_BOTTOM_LOGO_MANULIFE_MGB = "//div//img[@src='https://geihpvqvwebgencacn1.blob.core.windows.net/appian-portal/logo_footer_en_ManulifeGroupBenefits.png' or @src='https://geihpvtvwebgencacn1.blob.core.windows.net/appian-portal/logo_footer_en_ManulifeGroupBenefits.png']";
    private static final String LO_IMG_ASSISTANCE_ICON_MGB = "//div//img[@src='https://geihpvqvwebgencacn1.blob.core.windows.net/appian-portal/assistance_icon_ManulifeGroupBenefits.png' or @src='https://geihpvtvwebgencacn1.blob.core.windows.net/appian-portal/assistance_icon_ManulifeGroupBenefits.png']";
    private static final String LO_IMG_GEM_TOP_LOGO_ORION = "//a//img[@src='https://geihpvqvwebgencacn1.blob.core.windows.net/appian-portal/logo_header_en_Orion.png' or @src='https://geihpvtvwebgencacn1.blob.core.windows.net/appian-portal/logo_header_en_Orion.png']";
    private static final String LO_IMG_GEM_BOTTOM_LOGO_ORION = "//img[@src='https://geihpvqvwebgencacn1.blob.core.windows.net/appian-portal/logo_footer_en_Orion.png' or @src='https://geihpvtvwebgencacn1.blob.core.windows.net/appian-portal/logo_footer_en_Orion.png']";
    private static final String LO_IMG_ASSISTANCE_ICON_ORION = "//div//img[@src='https://geihpvqvwebgencacn1.blob.core.windows.net/appian-portal/assistance_icon_Orion.png' or @src='https://geihpvtvwebgencacn1.blob.core.windows.net/appian-portal/assistance_icon_Orion.png']";
    private static final String LO_TXT_GEM_FOOTER_DISCLAIMER_ORION = "//p[text()='Global Excel Management provides claims and assistance services for Orion Travel Insurance Company.']";
    private static final String LO_TXT_MEDICAL_EMERGENCY_HELPLINE_PARAGRAPH_LIGHT_CSBC = "//p[span[@class='IconWidget---medium IconWidget---inLightBackground'] and text()=' Consumer or Small Business Cards']";
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
    private static final String LO_TXT_GEM_FOOTER_DISCLAIMER_TD = "//p[text()='Global Excel Management provides Claims and Assistance Services for TD Life Insurance Company and TD Home and Auto Insurance Company.']";
    String LO_TXT_MEDICAL_EMERGENCY_HELPLINE_NON_TOLL_FREE = "//span/a[text()=";
    String LO_TXT_MEDICAL_EMERGENCY_HELPLINE_TOLL_FREE = "//p[text()=\"(Toll free)\"]//span/a[text()=";
    String LO_TXT_MEDICAL_EMERGENCY_HELPLINE_NON_TOLL_FREE2 = "//span/a[text()=";
    String LO_TXT_MEDICAL_EMERGENCY_HELPLINE_TOLL_FREE2 = "//p[text()=\"(Toll free)\"]//span/a[text()=";

    /**
     * Define the Page Object (PO) constructor.
     * @param driver The WebDriver object passed from the test method.
     */
    public PO_Home(WebDriver driver) {
        super(driver);
    }

    /**
     * Navigate to the URL.
     * 
     * @param url The URL to navigate to.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object navigateToURL(String url) {
        String result = navigateTo(url);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if current webpage is loaded and correct.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateOnPage() {
        String result = validateLocatorExists(LO_HOME_PAGE_VERIFY, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if current webpage is loaded and correct.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateOnPageAMEX() {
        String result = validateLocatorExists(LO_TXT_AMEX_HOME_PAGE_VERIFY, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if current webpage is loaded and correct.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateOnPageCIBC() {
        String result = validateLocatorExists(LO_HOME_PAGE_VERIFY_CIBC, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if current Orion webpage is loaded and correct.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateOnPageOrion() {
        String result = validateLocatorExists(LO_HOME_PAGE_VERIFY_ORION, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if current MGB webpage is loaded and correct.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateOnPageMGB() {
        String result = validateLocatorExists(LO_HOME_PAGE_VERIFY_MGB, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if the 'Start New Claim' exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateStartNewClaimButton() {
        String result = validateLocatorExists(LO_BUT_START_NEW_CLAIM, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if the 'Continue Draft Claim' exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateContinueDraftClaimButton() {
        String result = validateLocatorExists(LO_BUT_CONTINUE_DRAFT_CLAIM, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if the 'Check Claim Status' exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateCheckClaimStatusButton() {
        String result = validateLocatorExists(LO_BUT_CHECK_CLAIM_STATUS, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if the 'Visit Our Help Centre' exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateVisitOurHelpCentreButton() {
        String result = validateLocatorExists(LO_BUT_VISIT_OUR_HELP_CENTRE, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if Gem bottom logo is present and it's not a link.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateGemBottom_Left_Logo_Light_Gem() {
        String result = validateLocatorExists(LO_IMG_GEM_BOTTOM_LOGO_LIGHT_GEM, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if Gem bottom logo is present and it's not a link.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateGemBottom_Left_Logo_GEM_MGB() {
        String result = validateLocatorExists(LO_IMG_GEM_BOTTOM_LOGO_GEM_MGB, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if Gem bottom logo is present and it's not a link.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateGemBottom_Left_Logo_ORION() {
        String result = validateLocatorExists(LO_IMG_GEM_BOTTOM_LOGO_ORION, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if Gem bottom logo is present and it's not a link.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateGemBottom_Left_Logo_SunLife() {
        String result = validateLocatorExists(LO_IMG_GEM_BOTTOM_LOGO_SUNLIFE, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if Gem bottom logo is present and it's not a link.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateGemBottom_Left_Logo_MANULIFE_MGB() {
        String result = validateLocatorExists(LO_IMG_GEM_BOTTOM_LOGO_MANULIFE_MGB, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if the 'Sign In' exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateSignIn() {
        String result = validateLocatorExists(LO_BUT_SIGN_IN, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if the 'Sign In' exists in the TD section.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateSignInTD() {
        String result = validateLocatorExists(LO_BUT_SIGN_IN_TD, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Clicks the 'Continue Draft Claim' button.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object clickContinueDraftClaimButton() {
        String result = clickLocator(LO_BUT_CONTINUE_DRAFT_CLAIM, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Clicks the 'Start New Claim' button.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object clickButtonStartNewClaim() {
        String result = clickLocator(LO_BUT_START_NEW_CLAIM, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Clicks the 'CHECK CLAIM STATUS' button.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object clickCheckClaimStatusButton() {
        String result = clickLocator(LO_BUT_CHECK_CLAIM_STATUS, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Checks to see if the System is down error message exist.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateSystemNotDown() {
        String result = validateLocatorNotExists(LO_TXT_SYSTEM_STATUS, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if the 'View Status' exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateViewStatus() {
        String result = validateLocatorExists(LO_BUT_VIEW_STATUS, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Clicks the 'HELP CENTER' link.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object clickHelpCentreLink() {
        FW_DateTimeUtils.waitForDuration(5, "s", true); // Wait to perform next check
        String result = clickLocator(LO_LNK_HELP_CENTRE_HEADER, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Clicks the 'HELP CENTER' link.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object clickHelpCentreHeaderLight() {
        FW_DateTimeUtils.waitForDuration(5, "s", true); // Wait to perform next check
        String result = clickLocator(LO_LNK_HELP_CENTRE_TOP, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Clicks the 'HELP CENTER' link in the footer.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object clickHelpCentreLinkFooter() {
        FW_DateTimeUtils.waitForDuration(5, "s", true); // Wait to perform next check
        String result = clickLocator(LO_LNK_HELP_CENTRE_FOOTER, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Clicks the 'Visit our help centre' button.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object clickVisitOurHelpCentreButton() {
        FW_DateTimeUtils.waitForDuration(5, "s", true); // Wait to perform next check
        scrollToLocator(LO_BUT_VISIT_OUR_HELP_CENTRE);
        String result = clickLocator(LO_BUT_VISIT_OUR_HELP_CENTRE, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Clicks the 'FRANÇAIS' button.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object clickFrancaisButton() {
        String result = clickLocator(LO_BUT_FRANÇAIS, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Clicks the 'FRANÇAIS' button.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object clickFrancaisButton_Dark() {
        String result = clickLocator(LO_BUT_FRANÇAIS_DARK, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if current french webpage is loaded and correct.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object verifyOnFrenchPage() {
        String result = validateLocatorExists(LO_HOME_PAGE_VERIFY_FRENCH, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if current french webpage is loaded and correct.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object verifyOnFrenchPageCIBC() {
        String result = validateLocatorExists(LO_HOME_PAGE_VERIFY_FRENCH_CIBC, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if current french webpage is loaded and correct.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object verifyOnFrenchPageAmex() {
        String result = validateLocatorExists(LO_TXT_HOME_PAGE_VERIFY_FRENCH_PAGE_AMEX, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if current french webpage is loaded and correct.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object verifyOnFrPage() {
        String result = validateLocatorExists(LO_FR_HOME_PAGE_VERIFY, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Clicks the 'ENGLISH' button.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object clickEnglishButton() {
        String result = clickLocator(LO_BUT_ENGLISH, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Clicks the 'ENGLISH' button.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object clickEnglishButton_Dark() {
        String result = clickLocator(LO_BUT_ENGLISH_DARK, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if the "FRANÇAIS" button does not exist on the BCAA portal.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object verifyFrancaisButtonDoesNotExist() {
        String result = validateLocatorNotExists(LO_BUT_FRANÇAIS, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Clicks the X button on the yellow bunner - Important Message.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object closeYellowImportantInformationBunnerAtTop() {
        boolean bunner = waitToExist(LO_BUT_BURNNER_TOP_YELLOW_IMPORTANT_MESSAGE, 1, FW_ConfigMgr.getDefaultInterval());
        if (bunner == true) {
            String result = clickLocator(LO_BUT_BURNNER_TOP_YELLOW_IMPORTANT_MESSAGE, FW_ConfigMgr.getDefaultTimeout());
            FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
            return resultObj;
        }
        String result = "[Pass] {0.0} Yellow bunner does not exist - continuie with the normal flow";
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if Gem top logo is present and it's a link.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateGem_Top_Left_Logo() {
        String result = validateLocatorExists(LO_IMG_GEM_TOP_LOGO, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if Gem top logo is present and it's a link.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateGem_Top_Left_Logo_SCOTIA() {
        String result = validateLocatorExists(LO_IMG_GEM_TOP_LOGO_SCOTIA, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if Gem top logo is present and it's a link.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateGem_Top_Left_Logo_TD() {
        String result = validateLocatorExists(LO_IMG_GEM_TOP_LOGO_TD, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if Gem top logo is present and it's a link.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateGem_Top_Left_Logo_MGB() {
        String result = validateLocatorExists(LO_IMG_GEM_TOP_LOGO_MGB, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if Gem top logo is present and it's a link.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateGem_Top_Left_Logo_ORION() {
        String result = validateLocatorExists(LO_IMG_GEM_TOP_LOGO_ORION, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if Gem top logo is present and it's a link.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateGem_Top_Left_Logo_SunLife() {
        String result = validateLocatorExists(LO_IMG_GEM_TOP_LOGO_SUNLIFE, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if Gem top logo is present and it's a link.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateGem_Top_Left_Logo_Manulife() {
        String result = validateLocatorExists(LO_IMG_GEM_TOP_LOGO_MANULIFE, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if Gem top logo is present and it's a link.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateGem_Top_Left_Logo_Intact() {
        String result = validateLocatorExists(LO_IMG_GEM_TOP_LOGO_INTACT, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if Gem top logo is present and it's a link.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateGem_Top_Left_Logo_CIBC() {
        String result = validateLocatorExists(LO_IMG_GEM_TOP_LOGO_CIBC, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if Gem top logo is present and it's a link.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateGem_Top_Left_Logo_BCAA() {
        String result = validateLocatorExists(LO_IMG_GEM_TOP_LOGO_BCAA, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if the page main heading paragraph is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateMainHeadingParagraph() {
        String result = validateLocatorExists(LO_TXT_MAIN_HEADING_PARAGRAPH, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if the Help Centre at top right is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateHelpCentreHeader() {
        String result = validateLocatorExists(LO_LNK_HELP_CENTRE_TOP, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if the French/English Button toggle at top right is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateFrenchButtonToggle() {
        String result = validateLocatorExists(LO_BUT_FRANÇAIS, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if the Help Centre at top right is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateHelpCentreHeader_Dark() {
        String result = validateLocatorExists(LO_LNK_HELP_CENTRE_TOP_DARK, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if Clicks the Help Centre at top right is present(Dark_background).
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object clickHelpCentreHeader_Dark() {
        String result = clickLocator(LO_LNK_HELP_CENTRE_TOP_DARK, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    

    /**
     * Validates if the NEW CLAIM heading card is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateNewClaimHeadingCard() {
        String result = validateLocatorExists(LO_TXT_NEW_CLAIM_HEADING_CARD, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if the NEW CLAIM paragraph card is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateNewClaimParagraphCard() {
        String result = validateLocatorExists(LO_TXT_NEW_CLAIM_PARAGRAPH_CARD, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if the Draft Claim heading card is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateDraftClaimHeadingCard() {
        String result = validateLocatorExists(LO_TXT_DRAFT_CLAIM_HEADING_CARD, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if the Draft CLAIM paragraph card is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateDraftClaimParagraphCard() {
        String result = validateLocatorExists(LO_TXT_DRAFT_CLAIM_PARAGRAPH_CARD, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if the Active Claim heading card is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateActiveClaimHeadingCard() {
        String result = validateLocatorExists(LO_TXT_ACTIVE_CLAIM_HEADING_CARD, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if the Active CLAIM paragraph card is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateActiveClaimParagraphCard() {
        String result = validateLocatorExists(LO_TXT_ACTIVE_CLAIM_PARAGRAPH_CARD, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if the "Need help? We're here to assist you!" heading is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateNeedHelpHeader() {
        String result = validateLocatorExists(LO_TXT_NEED_HELP_HEADING, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if the paragraph below the "Need help? We're here to assist you!" heading is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateNeedHelpParagraph() {
        String result = validateLocatorExists(LO_TXT_NEED_HELP_PARAGRAPH, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if the Assistance Icon is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateAssistanceIconAmex() {
        String result = validateLocatorExists(LO_IMG_ASSISTANCE_ICON_AMEX, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if the Assistance Icon is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateAssistanceIconIntact() {
        String result = validateLocatorExists(LO_IMG_ASSISTANCE_ICON_INTACT, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if the Assistance Icon is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateAssistanceIconCL() {
        String result = validateLocatorExists(LO_IMG_ASSISTANCE_ICON_CL, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if the Assistance Icon is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateAssistanceIconScotia() {
        String result = validateLocatorExists(LO_IMG_ASSISTANCE_ICON_SCOTIA, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if the Assistance Icon is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateAssistanceIconTD() {
        String result = validateLocatorExists(LO_IMG_ASSISTANCE_ICON_TD, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if the Assistance Icon is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateAssistanceIconMGB() {
        String result = validateLocatorExists(LO_IMG_ASSISTANCE_ICON_MGB, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if the Assistance Icon is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateAssistanceIconOrion() {
        String result = validateLocatorExists(LO_IMG_ASSISTANCE_ICON_ORION, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if the Assistance Icon is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateAssistanceIconSunLife() {
        String result = validateLocatorExists(LO_IMG_ASSISTANCE_ICON_SUNLIFE, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if the Assistance Icon is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateAssistanceIconGem() {
        String result = validateLocatorExists(LO_IMG_ASSISTANCE_ICON_GEM, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if the Assistance Icon is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateAssistanceIconManulife() {
        String result = validateLocatorExists(LO_IMG_ASSISTANCE_ICON_MANULIFE, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if the Assistance Icon is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateAssistanceIconBCAA() {
        String result = validateLocatorExists(LO_IMG_ASSISTANCE_ICON_BCAA, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if Gem bottom logo is present and it's not a link.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateGemBottom_Left_Logo() {
        String result = validateLocatorExists(LO_IMG_GEM_BOTTOM_LOGO_DARK, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if Gem bottom logo is present and it's not a link.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateGemBottom_Left_Logo_Manulife() {
        String result = validateLocatorExists(LO_IMG_GEM_BOTTOM_LOGO_MANULIFE, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if Gem bottom logo is present and it's not a link.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateGemBottom_Left_Logo_Intact() {
        String result = validateLocatorExists(LO_IMG_GEM_BOTTOM_LOGO_INTACT, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if Gem bottom logo is present and it's not a link.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateGemBottom_Left_Logo_Plain() {
        String result = validateLocatorExists(LO_IMG_GEM_BOTTOM_LOGO_PLAIN, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if Gem bottom logo is present and it's not a link.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateGemBottom_Left_Logo_CL() {
        String result = validateLocatorExists(LO_IMG_GEM_BOTTOM_LOGO_CL, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if Gem bottom logo is present and it's not a link.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateGemBottom_Left_Logo_BCAA() {
        String result = validateLocatorExists(LO_IMG_GEM_BOTTOM_LOGO_BCAA, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if Gem bottom logo is present and it's not a link.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateGemBottom_Left_Logo_Dark_Gem() {
        String result = validateLocatorExists(LO_IMG_GEM_BOTTOM_LOGO_DARK_GEM, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if The "START A NEW CLAIM" link in the footer of the page is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateStartNewClaimFooterLink() {
        String result = validateLocatorExists(LO_LNK_START_NEW_CLAIM_FOOTER, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if The "START A NEW CLAIM" link in the footer of the page is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateStartNewClaimFooterLink_LightBackground() {
        String result = validateLocatorExists(LO_LNK_START_NEW_CLAIM_FOOTER_LIGHT, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if Gem bottom logo is present and it's not a link.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateGemBottom_Left_Logo_Scotia() {
        String result = validateLocatorExists(LO_IMG_GEM_BOTTOM_LOGO_SCOTIA, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if Gem bottom logo is present and it's not a link.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateGemBottom_Left_Logo_TD() {
        String result = validateLocatorExists(LO_IMG_GEM_BOTTOM_LOGO_TD, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    
    /**
     * Validates if The "CONTINUE DRAFT CLAIM" link in the footer of the page is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateContinueDraftClaimFooterLink() {
        String result = validateLocatorExists(LO_LNK_CONTINUE_DRAFT_CLAIM_FOOTER, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if The "CONTINUE DRAFT CLAIM" link in the footer of the page is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateContinueDraftClaimFooterLink_LightBackground() {
        String result = validateLocatorExists(LO_LNK_CONTINUE_DRAFT_CLAIM_FOOTER_LIGHT, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if The "SUBMIT DOCUMENTS" link in the footer of the page is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateSubmitDocumentsFooterLink() {
        String result = validateLocatorExists(LO_LNK_SUBMIT_DOCUMENTS_FOOTER, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if The "SUBMIT DOCUMENTS" link in the footer of the page is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateSubmitDocumentsFooterLink_LightBackground() {
        String result = validateLocatorExists(LO_LNK_SUBMIT_DOCUMENTS_FOOTER_LIGHT, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if the Help Centre at bottom right is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateHelpCentreFooterLink() {
        String result = validateLocatorExists(LO_LNK_HELP_CENTRE_BOTTOM, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if the Help Centre at bottom right is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateHelpCentreFooterLink_Light() {
        String result = validateLocatorExists(LO_LNK_HELP_CENTRE_BOTTOM_LIGHT, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if the "MEDICAL EMERGENCY HELPLINE" Heading is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateMedicalEmergencyHelpLineHeading() {
        String result = validateLocatorExists(LO_TXT_MEDICAL_EMERGENCY_HELPLINE_HEADING, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if the "MEDICAL EMERGENCY HELPLINE" Heading is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateMedicalEmergencyHelpLineHeading_LightBackgroundNoCallIcon() {
        String result = validateLocatorExists(LO_TXT_MEDICAL_EMERGENCY_HELPLINE_HEADING_NO_CALL_ICON, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if the "MEDICAL EMERGENCY HELPLINE" Heading is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateMedicalEmergencyHelpLineParagraph_LightBackground_CommercialSVBC() {
        String result = validateLocatorExists(LO_TXT_MEDICAL_EMERGENCY_HELPLINE_PARAGRAPH_LIGHT_CSVBC, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    /**
     * Validates if the "MEDICAL EMERGENCY HELPLINE" Heading is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateMedicalEmergencyHelpLineParagraph_LightBackground_ConsumerSBC() {
        String result = validateLocatorExists(LO_TXT_MEDICAL_EMERGENCY_HELPLINE_PARAGRAPH_LIGHT_CSBC, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    /**
     * Validates if the "MEDICAL EMERGENCY HELPLINE" Heading is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateMedicalEmergencyHelpLineHeading_LightBackground() {
        String result = validateLocatorExists(LO_TXT_MEDICAL_EMERGENCY_HELPLINE_HEADING_LIGHT, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if the "MEDICAL EMERGENCY HELPLINE" Non Toll Free Number is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateMedicalEmergencyHelpLineNonTollFree(String number) {
        LO_TXT_MEDICAL_EMERGENCY_HELPLINE_NON_TOLL_FREE = LO_TXT_MEDICAL_EMERGENCY_HELPLINE_NON_TOLL_FREE + "'" + number + "']";
        String result = validateLocatorExists(LO_TXT_MEDICAL_EMERGENCY_HELPLINE_NON_TOLL_FREE, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if the "MEDICAL EMERGENCY HELPLINE" Toll free Number is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateMedicalEmergencyHelpLineTollFree(String tollFreeNumber) {
        LO_TXT_MEDICAL_EMERGENCY_HELPLINE_TOLL_FREE = LO_TXT_MEDICAL_EMERGENCY_HELPLINE_TOLL_FREE + "'" + tollFreeNumber + "']";
        String result = validateLocatorExists(LO_TXT_MEDICAL_EMERGENCY_HELPLINE_TOLL_FREE, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if the "MEDICAL EMERGENCY HELPLINE" Non Toll Free Number is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateMedicalEmergencyHelpLineNonTollFree2(String number) {
        LO_TXT_MEDICAL_EMERGENCY_HELPLINE_NON_TOLL_FREE2 = LO_TXT_MEDICAL_EMERGENCY_HELPLINE_NON_TOLL_FREE2 + "'" + number + "']";
        String result = validateLocatorExists(LO_TXT_MEDICAL_EMERGENCY_HELPLINE_NON_TOLL_FREE2, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if the "MEDICAL EMERGENCY HELPLINE" Toll free Number is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateMedicalEmergencyHelpLineTollFree2(String tollFreeNumber) {
        LO_TXT_MEDICAL_EMERGENCY_HELPLINE_TOLL_FREE2 = LO_TXT_MEDICAL_EMERGENCY_HELPLINE_TOLL_FREE2 + "'" + tollFreeNumber + "']";
        String result = validateLocatorExists(LO_TXT_MEDICAL_EMERGENCY_HELPLINE_TOLL_FREE2, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if the "FOLLOW UP ON YOUR CLAIM" Heading is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateFollowUpOnYourClaimFooterHeading() {
        String result = validateLocatorExists(LO_TXT_FOLLOW_UP_ON_YOUR_CLAIM_HEADING, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if the "FOLLOW UP ON YOUR CLAIM" paragraph is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateFollowUpOnYourClaimFooterParagraph() {
        String result = validateLocatorExists(LO_TXT_FOLLOW_UP_ON_YOUR_CLAIM_PARAGRAPH, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if the GEM FOOTER DISCLAIMER is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateFooterDisclaimer() {
        String result = validateLocatorExists(LO_TXT_GEM_FOOTER_DISCLAIMER, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if the GEM FOOTER DISCLAIMER is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateFooterDisclaimerAndAdministered() {
        String result = validateLocatorExists(LO_TXT_GEM_FOOTER_DISCLAIMER_AND_ADMINISTERED, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object validateFooterDisclaimerCIBC() {
        String result = validateLocatorExists(LO_TXT_GEM_FOOTER_DISCLAIMER_CIBC, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if the GEM FOOTER DISCLAIMER is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateFooterDisclaimerManulife() {
        String result = validateLocatorExists(LO_TXT_GEM_FOOTER_DISCLAIMER_MANULIFE, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if the GEM FOOTER DISCLAIMER is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateFooterDisclaimerTD() {
        String result = validateLocatorExists(LO_TXT_GEM_FOOTER_DISCLAIMER_TD, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if the GEM FOOTER DISCLAIMER is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateFooterDisclaimer2() {
        String result = validateLocatorExists(LO_TXT_GEM_FOOTER_DISCLAIMER_2, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if the GEM FOOTER DISCLAIMER is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateFooterDisclaimer_CL() {
        String result = validateLocatorExists(LO_TXT_GEM_FOOTER_DISCLAIMER_CL, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if the GEM FOOTER DISCLAIMER is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateFooterDisclaimer_MGB() {
        String result = validateLocatorExists(LO_TXT_GEM_FOOTER_DISCLAIMER_MGB, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if the GEM FOOTER DISCLAIMER is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateFooterDisclaimer_Orion() {
        String result = validateLocatorExists(LO_TXT_GEM_FOOTER_DISCLAIMER_ORION, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if the GEM FOOTER DISCLAIMER is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateFooterDisclaimer_SunLife() {
        String result = validateLocatorExists(LO_TXT_GEM_FOOTER_DISCLAIMER_SUNLIFE, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if the GEM FOOTER DISCLAIMER is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateFooterDisclaimerBCAA() {
        String result = validateLocatorExists(LO_TXT_GEM_FOOTER_DISCLAIMER_BCAA, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if the Trade Mark Notice is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateFooterTradeMarkNotice() {
        String result = validateLocatorExists(LO_TXT_TRADE_MARK_NOTICE, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object validateFooterTradeMarkNoticeNoLogo() {
        String result = validateLocatorExists(LO_TXT_TRADE_MARK_NOTICE_NO_LOGO, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if the Copy Right Notice is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateFooterCopyRightNotice() {
        String result = validateLocatorExists(LO_TXT_COPY_RIGHT_NOTICE, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    /**
     * Validates if the Copy Right Notice is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateFooterCopyRightNotice_2025() {
        String result = validateLocatorExists(LO_TXT_COPY_RIGHT_NOTICE_2025, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if the Privacy Statement link is present with a go to icon.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateFooterPrivacyStatement() {
        String result = validateLocatorExists(LO_LNK_PRIVACY_STATEMENT, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if the Conditions of Use link is present with a go to icon.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateFooterConditionsOfUse_LightBackground() {
        String result = validateLocatorExists(LO_LNK_CONDITIONS_OF_USE_LIGHT, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if the Privacy Statement link is present with a go to icon.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateFooterPrivacyStatement_LightBackground() {
        String result = validateLocatorExists(LO_LNK_PRIVACY_STATEMENT_LIGHT, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if the Conditions of Use link is present with a go to icon.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateFooterConditionsOfUse() {
        String result = validateLocatorExists(LO_LNK_CONDITIONS_OF_USE, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
}