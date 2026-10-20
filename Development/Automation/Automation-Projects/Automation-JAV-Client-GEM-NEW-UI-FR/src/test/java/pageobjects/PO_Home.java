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
public class PO_Home extends CU_Appian {

    // [Note: Automation Engineer, define the Page Object (PO) locators (LO) here.]
    //private static final String LO_HOME_PAGE_VERIFY_AMEX_CLAIM = "//strong[contains(text(), 'carte AMEX')]/..";
    private static final String LO_HOME_PAGE_VERIFY_NEW = "//div//h1[contains(text(), 'centre de réclamation')]/..";
    private static final String LO_HOME_PAGE_VERIFY_ORION_CLAIM = "//strong[contains(text(), \"centre de réclamation d'Orion\")]/..";
    // private static final String LO_LNK_HELP_CENTRE_HEADER="(//a[contains(text(),
    // 'HELP CENTRE')])[1]";
    private static final String LO_HOME_PAGE_VERIFY_FRENCH_CARTE_AMEX = "//strong[contains(text(), 'carte AMEX')]";
    private static final String LO_HOME_PAGE_VERIFY = "//h1[contains(text(), 'Bienvenue')]/..";
    private static final String LO_TXT_AMEX_HOME_PAGE_VERIFY = "//h1[contains(text(), 'Bienvenue à votre centre de réclamation de voyage pour votre  carte AMEX')]/..";
    private static final String LO_HOME_PAGE_VERIFY_CIBC = "//h1[contains(text(), 'Bienvenue au centre de réclamations pour votre  carte de crédit CIBC')]/..";
    private static final String LO_HOME_PAGE_VERIFY_ORION = "//span[text()='Welcome to your ' and strong='Orion Claim Centre' and span='administered by' and span='Global Excel Management']";
    private static final String LO_HOME_PAGE_VERIFY_MGB = "//span[text()='Welcome to your Manulife Group Benefits Travel  Claim Centre']";
    private static final String LO_BUT_START_NEW_CLAIM = "//span[contains(text(),'COMMENCER UNE NOUVELLE RÉCLAMATION')]";
    private static final String LO_BUT_START_NEW_CLAIM_MGB = "//span[contains(text(),'Commencer Une Nouvelle Réclamation')]";
    private static final String LO_BUT_CONTINUE_DRAFT_CLAIM = "//span[contains(text(), 'POURSUIVRE VOTRE DEMANDE')]";
    private static final String LO_BUT_CHECK_CLAIM_STATUS = "//span[contains(text(), \"VÉRIFIEZ L'ÉTAT DE VOTRE RÉCLAMATION\")]";
    private static final String LO_BUT_VISIT_OUR_HELP_CENTRE = "//strong[contains(text(), \"CONSULTEZ NOTRE CENTRE D'ASSISTANCE\")]";
    private static final String LO_BUT_SIGN_IN = "//strong[contains(text(), 'SIGN IN')]";
    private static final String LO_TXT_SYSTEM_STATUS = "//h4[contains(text(), 'The System Has Encountered an Error')]";
    private static final String LO_BUT_VIEW_STATUS = "//strong[contains(text(),'VIEW STATUS')]";
    private static final String LO_LNK_HELP_CENTRE_HEADER = "//a[contains(text(), \"CENTRE D'ASSISTANCE\")]";
    private static final String LO_LNK_HELP_CENTRE_FOOTER = "(//span/a[text()='HELP CENTRE'])[1] | (//span/a[text()='HELP CENTRE'])[2]";
    private static final String LO_BUT_FRANCAIS = "//span[a[contains(text(), \"FRANÇAIS\")]]";
    private static final String LO_HOME_PAGE_VERIFY_ENGLISH = "//h1[contains(text(), 'Welcome to your  Claim Centre')]";
    private static final String LO_TXT_HOME_PAGE_VERIFY_FRENCH_PAGE_AMEX = "//span[contains(text(), 'Bienvenue à votre centre de réclamation de voyage pour votre ') and strong[contains(text(), 'carte AMEX')]]";
    private static final String LO_FR_HOME_PAGE_VERIFY = "//strong[contains(text(), 'carte de crédit CIBC')]";
    private static final String LO_BUT_ENGLISH = "//span[a[contains(text(), \"ENGLISH\")]]";
    private static final String LO_BUT_BURNNER_TOP_YELLOW_IMPORTANT_MESSAGE = "//div[@class='SideBySideGroup---side_by_side SideBySideGroup---default_direction SideBySideGroup---top']/div[div//strong[contains(text(), ' Important Information – Potential Canada Post mail disruption')]]/following-sibling::div//div[@class='FieldLayout---input_below']";
    private static final String LO_BUT_BURNNER_TOP_YELLOW_TEST_INDIVIDUAL_MESSAGE = "//div[@class='SideBySideGroup---side_by_side SideBySideGroup---default_direction SideBySideGroup---top']/div[div//strong[contains(text(), 'Test Individual message')]]/following-sibling::div//div[@class='FieldLayout---input_below']";
    private static final String LO_IMG_GEM_TOP_LOGO = "//a//img[@src='https://geihpvqvwebgencacn1.blob.core.windows.net/appian-portal/logo_header_en_GEM.png' or @src='https://geihpvtvwebgencacn1.blob.core.windows.net/appian-portal/logo_header_en_GEM.png']";
    private static final String LO_IMG_GEM_TOP_LOGO_BCAA = "//a//img[@src='https://geihpvqvwebgencacn1.blob.core.windows.net/appian-portal/logo_header_en_BCAA.png' or @src='https://geihpvtvwebgencacn1.blob.core.windows.net/appian-portal/logo_header_en_BCAA.png']";
    private static final String LO_TXT_MAIN_HEADING_PARAGRAPH = "//p//span[contains(text(), \"Nous comprenons que de faire face à des situations inattendues dans un environnement inconnu peut être stressant. Pour vous aider, nous vous offrons un service d'assistance avec des experts prêts à vous aider en cas d'urgence.\")]";
    private static final String LO_LNK_HELP_CENTRE_TOP = "//span[a[contains(text(), \"CENTRE D'ASSISTANCE\")]]";
    private static final String LO_TXT_NEW_CLAIM_HEADING_CARD = "//h2[contains(text(), \"Commencer une nouvelle réclamation\")]";
    private static final String LO_TXT_NEW_CLAIM_PARAGRAPH_CARD = "//span[contains(text(), 'Vous voulez soumettre une nouvelle réclamation? Commencez le processus ici.')]";
    private static final String LO_TXT_DRAFT_CLAIM_HEADING_CARD = "//h2[contains(text(), \"Récupération d'un brouillon de réclamation\")]";
    private static final String LO_TXT_DRAFT_CLAIM_PARAGRAPH_CARD = "//span[contains(text(), 'Vous avez déjà commencé une réclamation? Continuez votre demande ici.')]";
    private static final String LO_TXT_ACTIVE_CLAIM_HEADING_CARD = "//h2[contains(text(), 'Réclamation existante')]";
    private static final String LO_TXT_ACTIVE_CLAIM_PARAGRAPH_CARD = "//span[contains(text(), \"Vous avez soumis une réclamation et voulez en vérifier l'état? Obtenez les mises à jour ici.\")]";
    private static final String LO_TXT_NEED_HELP_HEADING = "//h2[contains(text(), \"Besoin d'aide? Nous sommes là pour vous aider!\")]";
    private static final String LO_TXT_NEED_HELP_PARAGRAPH = "//span[text()=\"Que vous soyez à la maison ou en voyage, Global Excel est là pour vous aider. Consultez notre Centre d'aide pour en savoir plus sur les outils et les services mis à votre disposition.\"]";
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
    private static final String LO_TXT_GEM_FOOTER_DISCLAIMER = "//p[text()=\"Global Excel Management provides claims and assistance services for Royal & Sun Alliance Insurance Company of Canada.\"]";
    private static final String LO_TXT_GEM_FOOTER_DISCLAIMER_BCAA = "//p[text()=\"BCAA (British Columbia Automobile Association) has appointed Global Excel Management Inc., as the provider of all assistance and claims services.\"]";
    private static final String LO_TXT_TRADE_MARK_NOTICE = "//span[text()=\"Tous droits réservés.\"]";
    private static final String LO_TXT_COPY_RIGHT_NOTICE = "//span[contains(text(), '2024') and text()='Global Excel Management Inc.' and text()='All rights reserved.']";
     private static final String LO_TXT_COPY_RIGHT_NOTICE_2025 = "//span[span and text()=\"2025\" and text()=\"Gestion Global Excel inc.\" and text()=\"Tous droits réservés.\"]";
    private static final String LO_LNK_PRIVACY_STATEMENT = "//a[span[contains(text(), 'Privacy Statement ') and span[@class='IconWidget---inDarkBackground']]]";
    private static final String LO_LNK_CONDITIONS_OF_USE = "//a[span[contains(text(), 'Conditions of Use ') and span[@class='IconWidget---inDarkBackground']]]";
    String LO_TXT_MEDICAL_EMERGENCY_HELPLINE_NON_TOLL_FREE = "//span/a[text()=";
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
    private static final String LO_TXT_GEM_FOOTER_DISCLAIMER_CL = "//p[text()='The Canada Life Assurance Company has appointed Global Excel Management Inc. as the provider of Travel Assistance and Out of Country claims services.']";
    private static final String LO_LNK_PRIVACY_STATEMENT_LIGHT = "//a[span[contains(text(), \"Déclaration de confidentialité \")]]/span[@class]";
    private static final String LO_LNK_CONDITIONS_OF_USE_LIGHT = "//a[span[contains(text(), \"conditions d'utilisation \") and span[@class=\"\"]]]";
    private static final String LO_TXT_MEDICAL_EMERGENCY_HELPLINE_HEADING_LIGHT = "//h2[text()=\"LIGNE MÉDICALE D'URGENCE\"]";
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
    private static final String LO_IMG_GEM_TOP_LOGO_TD = "//a//img[@src=\"https://geihpvqvwebgencacn1.blob.core.windows.net/appian-portal/logo_header_fr_TD.png\"]";
    private static final String LO_IMG_ASSISTANCE_ICON_TD = "//div//img[@src='https://geihpvqvwebgencacn1.blob.core.windows.net/appian-portal/helpCenter_TD.png' or @src='']";
    private static final String LO_IMG_GEM_BOTTOM_LOGO_TD = "//div//img[@src='https://geihpvqvwebgencacn1.blob.core.windows.net/appian-portal/logo_footer_en_TD.png' or @src='https://geihpvtvwebgencacn1.blob.core.windows.net/appian-portal/logo_footer_en_TD.png']";
    private static final String LO_TXT_GEM_FOOTER_DISCLAIMER_TD = "//span[text()=\"Gestion Global Excel inc offre des services de réclamation et de soutien pour TD,\"]";


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
    public String validateOnPage() {
        // waitForDuration(5, "s", false); // Wait to perform next check
        String result = validateLocatorExists(LO_HOME_PAGE_VERIFY, FW_ConfigMgr.getDefaultTimeout(),
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
    public String validateOnNewPage() {
        // waitForDuration(5, "s", false); // Wait to perform next check
        String result = validateLocatorExists(LO_HOME_PAGE_VERIFY_NEW, FW_ConfigMgr.getDefaultTimeout(),
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
        // waitForDuration(5, "s", false); // Wait to perform next check
        String result = validateLocatorExists(LO_TXT_AMEX_HOME_PAGE_VERIFY, FW_ConfigMgr.getDefaultTimeout(),
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
    public String validateOnPageCIBC() {
        // waitForDuration(5, "s", false); // Wait to perform next check
        String result = validateLocatorExists(LO_HOME_PAGE_VERIFY_CIBC, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if current Orion webpage is loaded and correct.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String validateOnPageOrion() {
        String result = validateLocatorExists(LO_HOME_PAGE_VERIFY_ORION, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if current MGB webpage is loaded and correct.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String validateOnPageMGB() {
        String result = validateLocatorExists(LO_HOME_PAGE_VERIFY_MGB, FW_ConfigMgr.getDefaultTimeout(),
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
     * Validates if current ORION webpage is loaded and correct.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String validateOnPageOrionClaim() {
        String result = validateLocatorExists(LO_HOME_PAGE_VERIFY_ORION_CLAIM, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if the 'Continue Draft Claim' exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String validateContinueDraftClaim() {
        String result = validateLocatorExists(LO_BUT_CONTINUE_DRAFT_CLAIM, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if the 'Check Claim Status' exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String validateCheckClaimStatus() {
        String result = validateLocatorExists(LO_BUT_CHECK_CLAIM_STATUS, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Clicks the 'ENGLISH' button.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String clickEnglishButton_Dark() {
        String result = clickLocator(LO_BUT_ENGLISH_DARK, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if the 'Visit Our Help Centre' exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String validateVisitOurHelpCentre() {
        String result = validateLocatorExists(LO_BUT_VISIT_OUR_HELP_CENTRE, FW_ConfigMgr.getDefaultTimeout(),
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
     * Clicks the 'Continue Draft Claim' button.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String clickContinueDraftClaimButton() {
        String result = clickLocator(LO_BUT_CONTINUE_DRAFT_CLAIM, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Clicks the 'Start New Claim' button.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String clickButtonStartNewClaim() {
        String result = clickLocator(LO_BUT_START_NEW_CLAIM, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

     /**
     * Clicks the 'Start New Claim' button.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String clickButtonStartNewClaimNew() {
        String result = clickLocator(LO_BUT_START_NEW_CLAIM, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }


    /**
     * Clicks the 'CHECK CLAIM STATUS' button.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String clickCheckClaimStatusButton() {
        String result = clickLocator(LO_BUT_CHECK_CLAIM_STATUS, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Checks to see if the System is down error message exist.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String validateSystemNotDown() {
        String result = validateLocatorNotExists(LO_TXT_SYSTEM_STATUS, FW_ConfigMgr.getDefaultTimeout(),
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
     * Clicks the 'HELP CENTER' link.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String clickHelpCentreLink() {
        waitForDuration(5, "s", false); // Wait to perform next check
        String result = clickLocator(LO_LNK_HELP_CENTRE_HEADER, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Clicks the 'HELP CENTER' link in the footer.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String clickHelpCentreLinkFooter() {
        waitForDuration(5, "s", false); // Wait to perform next check
        String result = clickLocator(LO_LNK_HELP_CENTRE_FOOTER, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Clicks the 'Visit our help centre' button.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String clickVisitOurHelpCentreButton() {
        waitForDuration(5, "s", false); // Wait to perform next check
        scrollToLocator(LO_BUT_VISIT_OUR_HELP_CENTRE);
        String result = clickLocator(LO_BUT_VISIT_OUR_HELP_CENTRE, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Clicks the 'FRANÇAIS' button.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String clickFrancaisButton() {
        String result = clickLocator(LO_BUT_FRANCAIS, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if current french webpage is loaded and correct.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String verifyOnEnglishPage() {
        String result = validateLocatorExists(LO_HOME_PAGE_VERIFY_ENGLISH, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if current french webpage is loaded and correct.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String verifyOnFrenchPageCarteAmex() {
        String result = validateLocatorExists(LO_HOME_PAGE_VERIFY_FRENCH_CARTE_AMEX, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if current french webpage is loaded and correct.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String verifyOnFrPage() {
        String result = validateLocatorExists(LO_FR_HOME_PAGE_VERIFY, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Clicks the 'ENGLISH' button.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String clickEnglishButton() {
        String result = clickLocator(LO_BUT_ENGLISH, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if the "FRANÇAIS" button does not exist on the BCAA portal.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String verifyFrancaisButtonDoesNotExist() {
        String result = validateLocatorNotExists(LO_BUT_FRANCAIS, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Clicks the X button on the yellow bunner - Important Message.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String closeYellowImportantInformationBunnerAtTop() {
        boolean bunner = waitToExist(LO_BUT_BURNNER_TOP_YELLOW_IMPORTANT_MESSAGE, 1, FW_ConfigMgr.getDefaultInterval());
        if (bunner == true) {
            String result = clickLocator(LO_BUT_BURNNER_TOP_YELLOW_IMPORTANT_MESSAGE, FW_ConfigMgr.getDefaultTimeout());
            result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
            return result;
        }
        String result = "[PASS] Yellow bunner does not exist - continuie with the normal flow";
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

     /**
     * Clicks the 'HELP CENTER' link.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String clickHelpCentreHeaderLight() {
        waitForDuration(5, "s", false); // Wait to perform next check
        String result = clickLocator(LO_LNK_HELP_CENTRE_TOP, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

     /**
     * Validates if the 'Start New Claim' exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String validateStartNewClaimButton() {
        String result = validateLocatorExists(LO_BUT_START_NEW_CLAIM, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

     /**
     * Clicks the 'FRANÇAIS' button.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String clickFrancaisButton_Dark() {
        String result = clickLocator(LO_BUT_FRANÇAIS_DARK, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if the French/English Button toggle at top right is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String validateFrenchButtonToggle() {
        String result = validateLocatorExists(LO_BUT_FRANCAIS, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if the 'Continue Draft Claim' exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String validateContinueDraftClaimButton() {
        String result = validateLocatorExists(LO_BUT_CONTINUE_DRAFT_CLAIM, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }


    /**
     * Validates if current french webpage is loaded and correct.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String verifyOnFrenchPageAmex() {
        String result = validateLocatorExists(LO_TXT_HOME_PAGE_VERIFY_FRENCH_PAGE_AMEX, FW_ConfigMgr.getDefaultTimeout(),
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
     * Validates if the NEW CLAIM heading card is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String validateNewClaimHeadingCard() {
        String result = validateLocatorExists(LO_TXT_NEW_CLAIM_HEADING_CARD, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    /**
     * Validates if the NEW CLAIM paragraph card is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String validateNewClaimParagraphCard() {
        String result = validateLocatorExists(LO_TXT_NEW_CLAIM_PARAGRAPH_CARD, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    /**
     * Validates if the Draft Claim heading card is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String validateDraftClaimHeadingCard() {
        String result = validateLocatorExists(LO_TXT_DRAFT_CLAIM_HEADING_CARD, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    /**
     * Validates if the Draft CLAIM paragraph card is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String validateDraftClaimParagraphCard() {
        String result = validateLocatorExists(LO_TXT_DRAFT_CLAIM_PARAGRAPH_CARD, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

     /**
     * Validates if the Active Claim heading card is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String validateActiveClaimHeadingCard() {
        String result = validateLocatorExists(LO_TXT_ACTIVE_CLAIM_HEADING_CARD, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

     /**
     * Validates if the Active CLAIM paragraph card is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String validateActiveClaimParagraphCard() {
        String result = validateLocatorExists(LO_TXT_ACTIVE_CLAIM_PARAGRAPH_CARD, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }


    /**
     * Validates if the "Need help? We're here to assist you!" heading is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String validateNeedHelpHeader() {
        String result = validateLocatorExists(LO_TXT_NEED_HELP_HEADING, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

     /**
     * Validates if the paragraph below the "Need help? We're here to assist you!" heading is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String validateNeedHelpParagraph() {
        String result = validateLocatorExists(LO_TXT_NEED_HELP_PARAGRAPH, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

     /**
     * Validates if the Assistance Icon is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String validateAssistanceIconAmex() {
        String result = validateLocatorExists(LO_IMG_ASSISTANCE_ICON_AMEX, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if the Assistance Icon is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String validateAssistanceIconBCAA() {
        String result = validateLocatorExists(LO_IMG_ASSISTANCE_ICON_BCAA, FW_ConfigMgr.getDefaultTimeout(),
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
    public String validateGemBottom_Left_Logo_BCAA() {
        String result = validateLocatorExists(LO_IMG_GEM_BOTTOM_LOGO_BCAA, FW_ConfigMgr.getDefaultTimeout(),
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
    public String validateGemBottom_Left_Logo_TD() {
        String result = validateLocatorExists(LO_IMG_GEM_BOTTOM_LOGO_TD, FW_ConfigMgr.getDefaultTimeout(),
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
    public String validateHelpCentreFooterLink() {
        String result = validateLocatorExists(LO_LNK_HELP_CENTRE_BOTTOM, FW_ConfigMgr.getDefaultTimeout(),
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
     * Validates if the 'Check Claim Status' exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String validateCheckClaimStatusButton() {
        String result = validateLocatorExists(LO_BUT_CHECK_CLAIM_STATUS, FW_ConfigMgr.getDefaultTimeout(),
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
     * Validates if the Assistance Icon is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String validateAssistanceIconIntact() {
        String result = validateLocatorExists(LO_IMG_ASSISTANCE_ICON_INTACT, FW_ConfigMgr.getDefaultTimeout(),
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
    public String validateFooterDisclaimerBCAA() {
        String result = validateLocatorExists(LO_TXT_GEM_FOOTER_DISCLAIMER_BCAA, FW_ConfigMgr.getDefaultTimeout(),
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
    public String validateGem_Top_Left_Logo_Intact() {
        String result = validateLocatorExists(LO_IMG_GEM_TOP_LOGO_INTACT, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

     /**
     * Validates if the Assistance Icon is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String validateAssistanceIconGem() {
        String result = validateLocatorExists(LO_IMG_ASSISTANCE_ICON_GEM, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

     /**
     * Validates if the Assistance Icon is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String validateAssistanceIconTD() {
        String result = validateLocatorExists(LO_IMG_ASSISTANCE_ICON_TD, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if the 'Visit Our Help Centre' exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String validateVisitOurHelpCentreButton() {
        String result = validateLocatorExists(LO_BUT_VISIT_OUR_HELP_CENTRE, FW_ConfigMgr.getDefaultTimeout(),
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
     * Validates if current french webpage is loaded and correct.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String verifyOnFrenchPageCIBC() {
        String result = validateLocatorExists(LO_HOME_PAGE_VERIFY_FRENCH_CIBC, FW_ConfigMgr.getDefaultTimeout(),
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
    public String validateGem_Top_Left_Logo_CIBC() {
        String result = validateLocatorExists(LO_IMG_GEM_TOP_LOGO_CIBC, FW_ConfigMgr.getDefaultTimeout(),
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
     * Validates if Clicks the Help Centre at top right is present(Dark_background).
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String clickHelpCentreHeader_Dark() {
        String result = clickLocator(LO_LNK_HELP_CENTRE_TOP_DARK, FW_ConfigMgr.getDefaultTimeout());
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
     * Validates if the Assistance Icon is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String validateAssistanceIconCL() {
        String result = validateLocatorExists(LO_IMG_ASSISTANCE_ICON_CL, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Clicks button to start a new claim for MGB.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String clickStartNewClaimButton_MGB() {
        String result = clickLocator(LO_BUT_START_NEW_CLAIM_MGB, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }







    

    
}
