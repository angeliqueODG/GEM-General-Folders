package pageobjects;

// Import class packages for this Page Object (PO)
import org.openqa.selenium.WebDriver; // Selenium WebDriver

import customizations.automation.CU_Appian;// Automation framework customizations for Appian
import framework.utilities.FW_ConfigMgr; // Automation framework Configuration Manager to retrieve testConfig.properties values
import framework.utilities.FW_StringUtils; // Automation framework String Utilities

/**
 * Page Object (PO) class used in the Page Object (PO) design pattern. Inherits
 * from the CU_Appian class.
 */
// [Note: Automation Engineer, rename this Page Object (PO) class to match the
// filename.]
public class PO_Home extends CU_Appian {

    // [Note: Automation Engineer, define the Page Object (PO) locators (LO) here.]
    private static final String LO_HOME_PAGE_VERIFY_AMEX_CLAIM = "//strong[contains(text(), 'carte AMEX')]/..";
    private static final String LO_HOME_PAGE_VERIFY = "//strong[contains(text(), 'centre de réclamation')]/..";
    private static final String LO_HOME_PAGE_VERIFY_NEW = "//div//h3[contains(text(), 'centre de réclamation')]/..";
    private static final String LO_HOME_PAGE_VERIFY_ORION_CLAIM = "//strong[contains(text(), \"centre de réclamation d'Orion\")]/..";
    private static final String LO_HOME_PAGE_VERIFY_CIBC = "//h1[contains(text(),'Bienvenue au centre de réclamations pour votre  carte de crédit CIBC')]";
    private static final String LO_HOME_PAGE_VERIFY_NEW_MGB = "//h1[contains(text(),\"Bienvenue à votre  centre de réclamation voyage de l'assurance collective de Manuvie\")]";
    private static final String LO_HOME_PAGE_VERIFY_ORION = "//span[text()='Welcome to your  Orion Claim Centre']";
    private static final String LO_HOME_PAGE_VERIFY_MGB = "//span[text()='Welcome to your Manulife Group Benefits Travel  Claim Centre']";
    private static final String LO_BUT_START_NEW_CLAIM = "//strong[contains(text(),'COMMENCER UNE NOUVELLE RÉCLAMATION')]";
    private static final String LO_BUT_START_NEW_CLAIM_NEW = "//span[contains(text(),'COMMENCER UNE NOUVELLE RÉCLAMATION')]";
    private static final String LO_BUT_START_NEW_CLAIM_MGB = "//span[contains(text(),'Commencer Une Nouvelle Réclamation')]";
    private static final String LO_BUT_CONTINUE_DRAFT_CLAIM = "//strong[contains(text(), 'POURSUIVRE VOTRE DEMANDE')]";   
    private static final String LO_BUT_CONTINUE_DRAFT_CLAIM_CIBC = "//span[contains(text(), 'POURSUIVRE VOTRE DEMANDE')]";           
    private static final String LO_BUT_CHECK_CLAIM_STATUS = "//strong[contains(text(), \"VÉRIFIEZ L'ÉTAT DE VOTRE RÉCLAMATION\")]";
    private static final String LO_BUT_VISIT_OUR_HELP_CENTRE = "//strong[contains(text(), \"CONSULTEZ NOTRE CENTRE D'ASSISTANCE\")]";
    private static final String LO_BUT_SIGN_IN = "//strong[contains(text(), 'CONNEXION')]";
    private static final String LO_TXT_SYSTEM_STATUS = "//h4[contains(text(), 'The System Has Encountered an Error')]";
    private static final String LO_BUT_VIEW_STATUS = "//strong[contains(text(),\"VÉRIFIEZ L'ÉTAT DE VOTRE RÉCLAMATION\")]";
    private static final String LO_BUT_VIEW_STATUS_CIBC = "//span[contains(text(),\"VÉRIFIEZ L'ÉTAT DE VOTRE RÉCLAMATION\")]";
    // private static final String LO_LNK_HELP_CENTRE_HEADER="(//a[contains(text(),
    // 'HELP CENTRE')])[1]";
    private static final String LO_LNK_HELP_CENTRE_HEADER = "((//span[text()='FR' or text()='FRANÇAIS']/ancestor::div[1]/../../preceding-sibling::div)[2]/div) | (//a[contains(text(), \"CENTRE D'ASSISTANCE\")])[1]";
    private static final String LO_LNK_HELP_CENTRE_FOOTER = "(//span/a[text()=\"CENTRE D'ASSISTANCE\"])[1] | (//span/a[text()=\"CENTRE D'ASSISTANCE\"])[2]";
    private static final String LO_BUT_FRANÇAIS = "//span[text()='FR' or text()='FRANÇAIS']";
    private static final String LO_HOME_PAGE_VERIFY_FRENCH = "//strong[contains(text(), 'carte AMEX')]";
    private static final String LO_HOME_PAGE_VERIFY_FRENCH_CARTE_AMEX = "//strong[contains(text(), 'carte AMEX')]";
    private static final String LO_FR_HOME_PAGE_VERIFY = "//strong[contains(text(), 'carte de crédit CIBC')]";
    private static final String LO_BUT_ENGLISH = "//span[text()='EN' or text()='ENGLISH']";
    private static final String LO_BUT_BURNNER_TOP_YELLOW_IMPORTANT_MESSAGE = "//div[@class='SideBySideGroup---side_by_side SideBySideGroup---default_direction SideBySideGroup---top']/div[div//strong[contains(text(), ' Important Information – Potential Canada Post mail disruption')]]/following-sibling::div//div[@class='FieldLayout---input_below']";
    private static final String LO_BUT_BURNNER_TOP_YELLOW_TEST_INDIVIDUAL_MESSAGE = "//div[@class='SideBySideGroup---side_by_side SideBySideGroup---default_direction SideBySideGroup---top']/div[div//strong[contains(text(), 'Test Individual message')]]/following-sibling::div//div[@class='FieldLayout---input_below']";
    private static final String LO_LNK_HELP_CENTRE_TOP = "//p[span[a[(span/span[@class='IconWidget---inLightBackground'][not(following-sibling::span)]) or (span[@class='IconWidget---inLightBackground'] and text()='HELP CENTRE')]]]";
    private static final String LO_TXT_MAIN_HEADING_PARAGRAPH = "//p//span[contains(text(), \"Nous comprenons que de faire face à des situations inattendues dans un environnement inconnu peut être stressant. Pour vous aider, nous vous offrons un service d'assistance avec des experts prêts à vous aider en cas d'urgence.\")]";
    private static final String LO_TXT_HOME_PAGE_VERIFY_FRENCH_PAGE_AMEX = "//div//h1[contains(text(),'Bienvenue à votre centre de réclamation de voyage pour votre  carte AMEX')]";
    private static final String LO_IMG_GEM_TOP_LEFT_LOGO = "//IMG[@src='https://geihpvdvwebgencacn1.blob.core.windows.net/appian-portal/logo_header_fr_GEM.png']";
    private static final String LO_TXT_NEW_CLAIM_HEADING_CARD = "//h3[contains(text(),'Nouvelle réclamation')]";
    private static final String LO_TXT_NEW_CLAIM_PARAGRAPH_CARD = "//p[contains(text(), 'Vous voulez soumettre une nouvelle réclamation? Commencez le processus ici.')]";
    private static final String O_TXT_NEW_CLAIM_PARAGRAPH_CARD_CIBC = "//span[contains(text(), 'Vous voulez soumettre une nouvelle réclamation? Commencez le processus ici.')]";
    private static final String LO_TXT_ACTIVE_CLAIM_HEADING_CARD = "//h2[contains(text(),'Réclamation en cours')]";
    private static final String LO_TXT_DRAFT_CLAIM_PARAGRAPH_CARD = "//p[contains(text(), 'Vous avez déjà commencé une réclamation? Continuez votre demande ici.')]";
    private static final String LO_TXT_DRAFT_CLAIM_PARAGRAPH_CARD_CIBC = "//span[contains(text(), 'Vous avez déjà commencé une réclamation? Continuez votre demande ici.')]";
    private static final String LO_TXT_EXISTING_CLAIM_HEADING_CARD = "//h3[contains(text(),'Réclamation existante')]";
    private static final String LO_TXT_EXISTING_CLAIM_HEADING_CARD_CIBC = "//h2[contains(text(),'Réclamation existante')]";
    private static final String LO_TXT_ACTIVE_CLAIM_PARAGRAPH_CARD = "//p[contains(text(), \"Vous avez soumis une réclamation et voulez en vérifier l'état? Obtenez les mises à jour ici.\")]";
    private static final String LO_TXT_ACTIVE_CLAIM_PARAGRAPH_CARD_CIBC = "//span[contains(text(), \"Vous avez soumis une réclamation et voulez en vérifier l'état? Obtenez les mises à jour ici.\")]";
    private static final String LO_TXT_NEED_HELP_HEADING = "//h3[contains(text(), \"Besoin d'aide? Nous sommes là pour vous aider!\")]";
    private static final String LO_TXT_NEED_HELP_HEADING_CIBC = "//h2[contains(text(), \"Besoin d'aide? Nous sommes là pour vous aider!\")]";
    private static final String LO_TXT_NEED_HELP_PARAGRAPH = "//p[text()=\"Que vous soyez à la maison ou en voyage, Global Excel est là pour vous aider. Consultez notre Centre d'aide pour en savoir plus sur les outils et les services mis à votre disposition.\"]";
    private static final String LO_TXT_NEED_HELP_PARAGRAPH_CIBC = "//span[text()=\"Que vous soyez à la maison ou en voyage, Global Excel est là pour vous aider. Consultez notre Centre d'aide pour en savoir plus sur les outils et les services mis à votre disposition.\"]";
    private static final String LO_IMG_BOTTOM_LEFT_GEM_LOGO = "//IMG[@src='https://geihpvqvwebgencacn1.blob.core.windows.net/appian-portal/logo_footer_GEM_claim_center_fr_dark.png']";
    private static final String LO_IMG_UP_LEFT_CIBC_LOGO = "//IMG[@src='https://geihpvdvwebgencacn1.blob.core.windows.net/appian-portal/logo_header_fr_CIBC.png']";
    private static final String LO_TXT_START_A_NEW_CLAIM_HEADING_CARD = "//h2[contains(text(),'Commencer une nouvelle réclamation')]";
    private static final String LO_TXT_RESUME_DRAFT_CLAIM_HEADING_CARD = "//h2[contains(text(),\"Récupération d'un brouillon de réclamation\")]";
    private static final String LO_TXT_SUBMIT_DOCUMENT_HEADING_CARD = "//h2[contains(text(),\"Soumission de documents\")]";
    private static final String LO_TXT_SUBMIT_DOCUMENT_PARAGRAPH = "//span[contains(text(),\"Vous souhaitez soumettre des documents supplémentaires pour une réclamation existante ?\")]";
    private static final String LO_BUT_SUBMIT_HERE = "//span[contains(text(),\"Soumettre ici\")]";
    private static final String LO_BUT_SUBMIT_HERE_CL = "//span[contains(text(),\"SOUMETTRE ICI\")]";
    private static final String LO_IMG_HELP_CENTER_ICON = "//IMG[@src='https://geihpvdvwebgencacn1.blob.core.windows.net/appian-portal/helpCenter_CIBC.png']";
    private static final String LO_TXT_MEDICAL_EMERGENCY_HELPLINE_HEADING = "//h2[text()=\"LIGNE MÉDICALE D'URGENCE\"]";
    String LO_TXT_MEDICAL_EMERGENCY_HELPLINE_NON_TOLL_FREE = "//span/a[text()=";
    String LO_TXT_MEDICAL_EMERGENCY_HELPLINE_TOLL_FREE = "//p[text()=\"(Toll free)\"]//span/a[text()=";
    String LO_TXT_MEDICAL_EMERGENCY_HELPLINE_NON_TOLL_FREE2 = "//span/a[text()=";
    String LO_TXT_MEDICAL_EMERGENCY_HELPLINE_TOLL_FREE2 = "//p[text()=\"(Toll free)\"]//span/a[text()=";
    private static final String LO_IMG_GEM_BOTTOM_LEFT_LOGO = "//IMG[@src='https://geihpvdvwebgencacn1.blob.core.windows.net/appian-portal/logo_footer_GEM_light.png']";
    private static final String LO_TXT_FOOTER_DECLARATIONS = "//span[contains(text(),\"Cette couverture est souscrite auprès de la Compagnie d'assurance Belair inc. La Compagnie d'assurance Belair inc. a désigné Gestion Global Excel inc. qui exerce ses activités sous le nom de « Global Excel » comme prestataire de services d’assistance et de gestion des demandes de règlement au titre de cette couverture.\")]";
    private static final String LO_TXT_FOOTER_DECLARATIONS_AMEX = "//span[contains(text(),\"Cette couverture est souscrite auprès de la Compagnie d'assurance Belair inc. La Compagnie d'assurance Belair inc. a désigné Gestion Global Excel inc. qui exerce ses activités sous le nom de \")]";
    private static final String LO_TXT_COPY_RIGHT_NOTICE_2025 = "//span[span and text()=\"2025\" and text()=\"Gestion Global Excel inc.\" and text()=\"Tous droits réservés.\"]";
    private static final String LO_TXT_PRIVACY_STATEMENT = "//span[contains(text(),'Déclaration de confidentialité ')]";
    private static final String LO_TXT_CONDITIONS_OF_USE = "//span[contains(text(),\"conditions d'utilisation \")]";
    private static final String LO_TXT_SUBMIT_DOCUMENTS_HEADING_CARD = "//h2[contains(text(),'Soumettre des documents')]";
    private static final String LO_TXT_SUBMIT_DOCUMENTS_PARAGRAPH = "//span[contains(text(),'Vous voulez nous envoyer des documents?')]";
    private static final String LO_IMG_HELP_CENTER_ICON_CL = "//IMG[@src='https://geihpvdvwebgencacn1.blob.core.windows.net/appian-portal/helpCenter_canadaLife.png']";
    private static final String LO_IMG_CL_LOGO = "https://geihpvqvwebgencacn1.blob.core.windows.net/appian-portal/logo_footer_fr_CanadaLife.png";
    private static final String LO_TXT_FOOTER_CL_DECLARATION = "//span[contains(text(),'La Compagnie d’Assurance du Canada sur la Vie a désigné Global Excel comme prestataire de services d’assistance voyage et de gestion des demandes de règlement hors pays.')]";
    private static final String LO_TXT_DOCUMENTS_SUBMISSION_PARAGRAPH = "//span[contains(text(),'Vous souhaitez soumettre des documents supplémentaires pour une réclamation existante?')]";
    private static final String LO_TXT_ASSISTANCE_SERVICES_TEXT = "//span[contains(text(),\"Les services d'assistance et de gestion des demandes de règlement sont administrés par Gestion Global Excel inc.\")]";
    private static final String LO_TXT_ASSISTANCE_SERVICES_TEXT_BELAIR = "//span[contains(text(),\"Cette couverture est souscrite auprès de la Compagnie d'assurance Belair inc. et est administrée par l'Agence belairdirect inc. La Compagnie d'assurance Belair inc. a désigné Gestion Global Excel inc. qui exerce ses activités sous le nom de « Global Excel » comme prestataire de services d’assistance et de gestion des demandes de règlement au titre de cette couverture.\")]";
    private static final String LO_TXT_ASSISTANCE_SERVICES_TEXT_MANULIFE = "//span[contains(text(),\"Que vous soyez à la maison ou en voyage, Global Excel est là pour vous aider. Consultez notre Centre d'aide pour en savoir plus sur les outils et les services mis à votre disposition.\")]";
    private static final String LO_IMG_BELAIR_LOGO = "//IMG[@src='https://geihpvdvwebgencacn1.blob.core.windows.net/appian-portal/logo_header_fr_Intact_new.png']";
    private static final String LO_IMG_MANULIFE_LOGO = "//IMG[@src='https://geihpvdvwebgencacn1.blob.core.windows.net/appian-portal/logo_header_fr_Manulife.png']";
    private static final String LO_IMG_GEM_LOGO = "//IMG[@src='https://geihpvdvwebgencacn1.blob.core.windows.net/appian-portal/logo_header_light_fr_MGB.png']";
    private static final String LO_IMG_MANULIFE_BOTTOM_LOGO = "//IMG[@src='https://geihpvdvwebgencacn1.blob.core.windows.net/appian-portal/logo_footer_fr_ManulifeGroupBenefits.png']";
    private static final String LO_TXT_MGB_BOTTOM_GEM_OFFER_SERVICES = "//span[contains(text(),\"Gestion Global Excel offre des services de réclamation pour La Compagnie d'Assurance-Vie Manufacturers (Manuvie).\")]";
    private static final String LO_TXT_SUNLIFE_OFFER_SERVICES = "//span[contains(text(),\"Sun Life du Canada, compagnie d'assurance-vie (« Sun Life ») a désigné Gestion Global Excel inc., comme prestataire de services d'assistance et de gestion des demandes de règlement.\")]";
    private static final String LO_TXT_TD_OFFER_SERVICES = "//span[contains(text(),'Gestion Global Excel inc offre des services de réclamation et de soutien pour TD,') and //span[contains(text(),\"Compagnie d'assurance-vie et Compagnie d'assurance habitation et auto TD.\")]]";
    private static final String LO_TXT_ZURICH_OFFER_SERVICES = "//span[contains(text(),\"Les garanties sont souscrites par Zurich Compagnie d'Assurances SA (Direction canadienne) « Zurich ». Zurich a désigné Gestion Global Excel inc., opérant sous le nom de « Global Excel », comme fournisseur de tous les services d'assistance et de règlement en vertu de cette couverture. Pour obtenir des renseignements complets sur la couverture, veuillez consulter les documents de votre police.\")]";
    private static final String LO_IMG_SCOTIABANK_LOGO = "//IMG[@src='https://geihpvdvwebgencacn1.blob.core.windows.net/appian-portal/logo_header_fr_Scotiabank.png']";
    private static final String LO_IMG_SUNLIFE_LOGO = "//IMG[@src='https://geihpvdvwebgencacn1.blob.core.windows.net/appian-portal/logo_header_fr_SunLife.png']";
    private static final String LO_IMG_AMEX_ASSISTANCE_ICON = "//IMG[@src='https://geihpvdvwebgencacn1.blob.core.windows.net/appian-portal/helpCenter_AMEX.png']";
    private static final String LO_IMG_TD_LOGO = "//IMG[@src='https://geihpvdvwebgencacn1.blob.core.windows.net/appian-portal/logo_header_fr_TD.png']";
    private static final String LO_IMG_ZURICH_LOGO = "//IMG[@src='https://geihpvdvwebgencacn1.blob.core.windows.net/appian-portal/logo_header_fr_Zurich.png']";
    private static final String LO_TXT_HOME_PAGE_VERIFY_CL = "//h1[contains(text(),'Bienvenue au  centre de réclamation')]";


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
    public String validateOnPageNewMGB() {
        // waitForDuration(5, "s", false); // Wait to perform next check
        String result = validateLocatorExists(LO_HOME_PAGE_VERIFY_NEW_MGB, FW_ConfigMgr.getDefaultTimeout(),
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
     * Validates if the 'Start New Claim' exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String validateStartNewClaim() {
        String result = validateLocatorExists(LO_BUT_START_NEW_CLAIM, FW_ConfigMgr.getDefaultTimeout(),
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
     * Validates if the 'Continue Draft Claim' for CIBCexists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String validateContinueDraftClaimCIBC() {
        String result = validateLocatorExists(LO_BUT_CONTINUE_DRAFT_CLAIM_CIBC, FW_ConfigMgr.getDefaultTimeout(),
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
        String result = clickLocator(LO_BUT_START_NEW_CLAIM_NEW, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

     /**
     * Clicks the 'Start New Claim' button.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String clickButtonStartNewClaimMGB() {
        String result = clickLocator(LO_BUT_START_NEW_CLAIM_MGB, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

     /**
     * Validates the 'Start New Claim' button.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String validateButtonStartNewClaimNew() {
        String result = validateLocatorExists(LO_BUT_START_NEW_CLAIM_NEW, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

     /**
     * Validates the 'Start New Claim' button.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String validateButtonStartNewClaimMGB() {
        String result = validateLocatorExists(LO_BUT_START_NEW_CLAIM_MGB, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
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
     * Validates if the 'View Status' exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String validateViewStatusCIBC() {
        String result = validateLocatorExists(LO_BUT_VIEW_STATUS_CIBC, FW_ConfigMgr.getDefaultTimeout(),
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
        String result = clickLocator(LO_BUT_FRANÇAIS, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if current french webpage is loaded and correct.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String verifyOnFrenchPage() {
        String result = validateLocatorExists(LO_HOME_PAGE_VERIFY_FRENCH, FW_ConfigMgr.getDefaultTimeout(),
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
        String result = validateLocatorNotExists(LO_BUT_FRANÇAIS, FW_ConfigMgr.getDefaultTimeout(),
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
     * Validates if the GEM Top Left Logo is present.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String validateGEMTopLeftLogo() {
        String result = validateLocatorExists(LO_IMG_GEM_TOP_LEFT_LOGO, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if the 'New Claim' heading card is present.
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
     * Validates if the ACTIVE CLAIM heading card is present.
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
     * Validates if the Draft CLAIM paragraph card is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String validateDraftClaimParagraphCardCIBC() {
        String result = validateLocatorExists(LO_TXT_DRAFT_CLAIM_PARAGRAPH_CARD_CIBC, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if the EXISTING CLAIM heading card is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String validateExistingClaimHeadingCard() {
        String result = validateLocatorExists(LO_TXT_EXISTING_CLAIM_HEADING_CARD, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

     /**
     * Validates if the EXISTING CLAIM heading card is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String validateExistingClaimHeadingCardCIBC() {
        String result = validateLocatorExists(LO_TXT_EXISTING_CLAIM_HEADING_CARD_CIBC, FW_ConfigMgr.getDefaultTimeout(),
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
     * Validates if the Active CLAIM paragraph card is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String validateActiveClaimParagraphCardCIBC() {
        String result = validateLocatorExists(LO_TXT_ACTIVE_CLAIM_PARAGRAPH_CARD_CIBC, FW_ConfigMgr.getDefaultTimeout(),
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
     * Validates if the "Need help? We're here to assist you!" heading is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String validateNeedHelpHeaderCIBC() {
        String result = validateLocatorExists(LO_TXT_NEED_HELP_HEADING_CIBC, FW_ConfigMgr.getDefaultTimeout(),
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
     * Validates if the paragraph below the "Need help? We're here to assist you!" heading is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String validateNeedHelpParagraphCIBC() {
        String result = validateLocatorExists(LO_TXT_NEED_HELP_PARAGRAPH_CIBC, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

        /**
        * Validates if the GEM Bottom Left Logo is present.
        * 
        * @return A string including [PASS] or [FAIL] along with specific result
        *         details.
        */
    public String validateGEMBottomLeftLogo() {
        String result = validateLocatorExists(LO_IMG_BOTTOM_LEFT_GEM_LOGO, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if the CIBC Top Left Logo is present.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String validateCIBCUpLeftLogo() {
        String result = validateLocatorExists(LO_IMG_UP_LEFT_CIBC_LOGO, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if "Helpe Centre" link is present in the header.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String validateHelpCentreLink() {
        String result = validateLocatorExists(LO_LNK_HELP_CENTRE_HEADER, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

        /**
        * Validates if the "Start a New Claim" heading card is present.
        *
        * @return A string including [PASS] or [FAIL] along with specific result
        *         details.
        */
    public String validateStartANewClaimHeadingCard() {
        String result = validateLocatorExists(LO_TXT_START_A_NEW_CLAIM_HEADING_CARD, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if the Start New Claim paragraph card is present for CIBC.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String validateStartANewClaimParagraphCardCIBC() {
        String result = validateLocatorExists(O_TXT_NEW_CLAIM_PARAGRAPH_CARD_CIBC, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    
        /**
        * Validates if the "Resume Draft Claim" heading card is present.
        *
        * @return A string including [PASS] or [FAIL] along with specific result
        *         details.
        */
    public String validateResumeDraftClaimHeadingCard() {
        String result = validateLocatorExists(LO_TXT_RESUME_DRAFT_CLAIM_HEADING_CARD, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

        /**
        * Validates if the "Submit Document" heading card is present.
        *
        * @return A string including [PASS] or [FAIL] along with specific result
        *         details.
        */
    public String validateSubmitDocumentHeadingCard() {
        String result = validateLocatorExists(LO_TXT_SUBMIT_DOCUMENT_HEADING_CARD, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

        /**
        * Validates if the "Submit Document" paragraph is present.
        *
        * @return A string including [PASS] or [FAIL] along with specific result
        *         details.
        */
    public String validateSubmitDocumentParagraph() {
        String result = validateLocatorExists(LO_TXT_SUBMIT_DOCUMENT_PARAGRAPH, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * validates if the 'Submit Here' button exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String validateSubmitHereButton() {
        String result = validateLocatorExists(LO_BUT_SUBMIT_HERE, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if the Help Center icon is present.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String validateHelpCenterIcon() {
        String result = validateLocatorExists(LO_IMG_HELP_CENTER_ICON, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if the "MEDICAL EMERGENCY HELPLINE" Heading is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateMedicalEmergencyHelpLineHeading() {
        String result = validateLocatorExists(LO_TXT_MEDICAL_EMERGENCY_HELPLINE_HEADING, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

     /**
     * Validates if the "MEDICAL EMERGENCY HELPLINE" Non Toll Free Number is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateMedicalEmergencyHelpLineNonTollFree(String number) {
        LO_TXT_MEDICAL_EMERGENCY_HELPLINE_NON_TOLL_FREE = LO_TXT_MEDICAL_EMERGENCY_HELPLINE_NON_TOLL_FREE + "'" + number + "']";
        String result = validateLocatorExists(LO_TXT_MEDICAL_EMERGENCY_HELPLINE_NON_TOLL_FREE, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        // Return result directly as String, or use the correct utility method if available
        return result;
    }

     /**
     * Validates if the "MEDICAL EMERGENCY HELPLINE" Non Toll Free Number is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateMedicalEmergencyHelpLineNonTollFree2(String number) {
        LO_TXT_MEDICAL_EMERGENCY_HELPLINE_NON_TOLL_FREE2 = LO_TXT_MEDICAL_EMERGENCY_HELPLINE_NON_TOLL_FREE2 + "'" + number + "']";
        String result = validateLocatorExists(LO_TXT_MEDICAL_EMERGENCY_HELPLINE_NON_TOLL_FREE2, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        return result;
    }

    /**
     * Validates if "GEM logo" in the footer is present.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String validateGEMLogoInFooter() {
        String result = validateLocatorExists(LO_IMG_GEM_BOTTOM_LEFT_LOGO, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if "Footer declaration text" is present.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String validateFooterDeclarationText() {
        String result = validateLocatorExists(LO_TXT_FOOTER_DECLARATIONS, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

     /**
     * Validates if "Footer declaration text" is present.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String validateFooterDeclarationAmex() {
        String result = validateLocatorExists(LO_TXT_FOOTER_DECLARATIONS_AMEX, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if "Copyright Notice" is present.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String validateCopyrightNotice() {
        String result = validateLocatorExists(LO_TXT_COPY_RIGHT_NOTICE_2025, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if the "Privacy Statement" link is present in the footer.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String validatePrivacyStatementLink() {
        String result = validateLocatorExists(LO_TXT_PRIVACY_STATEMENT, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if the "Conditions of Use" link is present in the footer.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String validateConditionsOfUseLink() {
        String result = validateLocatorExists(LO_TXT_CONDITIONS_OF_USE, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if "Submit Documents" heading card is present.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String validateSubmitDocumentsHeadingCard() {
        String result = validateLocatorExists(LO_TXT_SUBMIT_DOCUMENTS_HEADING_CARD, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Valihdates if "Submit Documents" paragraph card is present.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *        details.
     */
    public String validateSubmitDocumentsParagraphCard() {
        String result = validateLocatorExists(LO_TXT_SUBMIT_DOCUMENTS_PARAGRAPH, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if "SUBMIT HERE" button is present.`
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *        details.
     */
    public String validateSubmitHereButtonExists() {
        String result = validateLocatorExists(LO_BUT_SUBMIT_HERE_CL, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if "Help Cennter Icon" for CL exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *        details.
     */
    public String validateHelpCenterIconCLExists() {
        String result = validateLocatorExists(LO_IMG_HELP_CENTER_ICON_CL, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if "CL logo" exists
     * 
      * @return A string including [PASS] or [FAIL] along with specific result
     *        details.
     */
     public String validateCLLogoExists() {
        String result = validateLocatorExists(LO_IMG_CL_LOGO, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if "CL footer declaration" text exists
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *        details.
     */
    public String validateCLFooterDeclarationTextExists() {
        String result = validateLocatorExists(LO_TXT_FOOTER_CL_DECLARATION, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * validates if "Documents Submission" paragraph exists
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *        details.
     */
    public String validateDocumentsSubmissionParagraphExists() {
        String result = validateLocatorExists(LO_TXT_DOCUMENTS_SUBMISSION_PARAGRAPH, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * validates if "Assistance Services" text exists
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *        details.
     */
    public String validateAssistanceServicesTextExists() {
        String result = validateLocatorExists(LO_TXT_ASSISTANCE_SERVICES_TEXT, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;  
    }

     /**
     * validates if "Assistance Services" text exists
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *        details.
     */
    public String validateAssistanceServicesTextExistsBelair() {
        String result = validateLocatorExists(LO_TXT_ASSISTANCE_SERVICES_TEXT_BELAIR, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;  
    }

    /**
     * validates if "Assistance Services" text exists
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *        details.
     */
    public String validateAssistanceServicesManulife() {
        String result = validateLocatorExists(LO_TXT_ASSISTANCE_SERVICES_TEXT_MANULIFE, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;  
    }

    /**
     * Validates if Belair Logo exists
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *        details.
     */
    public String validateBelairLogoExists() {
        String result = validateLocatorExists(LO_IMG_BELAIR_LOGO, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if Manulife Logo exists
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *        details.
     */
    public String validateManulifeLogoExists() {
        String result = validateLocatorExists(LO_IMG_MANULIFE_LOGO, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if "GEM logo" is present in the header.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *        details.
     */
    public String validateGEMLogoExists() {
        String result = validateLocatorExists(LO_IMG_GEM_LOGO, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if "MANULIFE logo" is present at the bottom.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *        details.
     */
    public String validateManulifeLogoBottomExists() {
        String result = validateLocatorExists(LO_IMG_MANULIFE_BOTTOM_LOGO, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if "GEM offer Services" text exists
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *        details.
     */
    public String validateGEMOfferServicesTextExists() {
        String result = validateLocatorExists(LO_TXT_MGB_BOTTOM_GEM_OFFER_SERVICES, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if "Scotia logo" is present at the top left.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *        details.
     */
    public String validateScotiaLogoExists() {
        String result = validateLocatorExists(LO_IMG_SCOTIABANK_LOGO, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if "Sunlife logo" is present at the top left.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *        details.
     */
    public String validateSunlifeLogoExists() {
        String result = validateLocatorExists(LO_IMG_SUNLIFE_LOGO, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if "Sunlife offer Services" text exists
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *        details.
     */
    public String validateSunlifeOfferServicesTextExists() {
        String result = validateLocatorExists(LO_TXT_SUNLIFE_OFFER_SERVICES, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

     /**
     * Validates if "Sunlife offer Services" text exists
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *        details.
     */
    public String validateTDOfferServicesTextExists() {
        String result = validateLocatorExists(LO_TXT_TD_OFFER_SERVICES, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

     /**
     * Validates if "Zurich offer Services" text exists
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *        details.
     */
    public String validateZurichOfferServicesTextExists() {
        String result = validateLocatorExists(LO_TXT_ZURICH_OFFER_SERVICES, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /** 
     * Validates if "AMEX Assistance" icon is present at the top left.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *        details.
     */
    public String validateAMEXAssistanceIconExists() {
        String result = validateLocatorExists(LO_IMG_AMEX_ASSISTANCE_ICON, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if "Home page" text  for CL exists
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *        details.
     */
    public String validateHomePageTextCLExists() {
        String result = validateLocatorExists(LO_TXT_HOME_PAGE_VERIFY_CL, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if "TD logo" is present at the top left.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *        details.
     */
    public String validateTDLogoExists() {
        String result = validateLocatorExists(LO_IMG_TD_LOGO, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

     /**
     * Validates if "TD logo" is present at the top left.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *        details.
     */
    public String validateZurichLogoExists() {
        String result = validateLocatorExists(LO_IMG_ZURICH_LOGO, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }


    }