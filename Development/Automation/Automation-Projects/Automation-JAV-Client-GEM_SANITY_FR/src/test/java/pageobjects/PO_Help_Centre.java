package pageobjects;
// Import class packages for this Page Object (PO)
import org.openqa.selenium.WebDriver;   // Selenium WebDriver

import framework.utilities.FW_ConfigMgr;// Automation framework customizations for Appian
import framework.utilities.FW_StringUtils;   // Automation framework Configuration Manager to retrieve testConfig.properties values

/**
 * Page Object (PO) class used in the Page Object (PO) design pattern. Inherits from the CU_Appian class.
 */
// [Note: Automation Engineer, rename this Page Object (PO) class to match the filename.]
public class PO_Help_Centre extends PO_Required_Documents {

    // [Note: Automation Engineer, define the Page Object (PO) locators (LO) here.]
    
   
    private static final String LO_TXT_HELP_CENTER_PAGE_VERIFY = "//h1[contains(text(), \"Centre d'aide \")]";
    private static final String LO_TXT_HELP_CENTER = "//h1[contains(text(), \"Centre d'aide\")]";
    private static final String LO_TXT_HELP_CENTER_LINK = "//a[contains(text(), \"CENTRE D'ASSISTANCE\")]";
    private static final String LO_BUT_CONTACT_US = "//span[contains(text(), 'NOUS JOINDRE')]";
    private static final String LO_TXT_HOW_CAN_WE_ASSIST_YOU = "//h2/span[contains(text(), 'Comment pouvons-nous vous aider?')]";
    private static final String LO_TXT_HOW_CAN_WE_ASSIST_YOU_NEW = "//div//h2[contains(text(),'COMMENT POUVONS-NOUS VOUS AIDER?')]";
    private static final String LO_TXT_CUSTOMER_RELATIONS_CARD = "//div[h3/span[contains(text(), 'Faire une plainte')]]";
    private static final String LO_TXT_CUSTOMER_RELATIONS = "//h3/span[contains(text(), 'Relations clients')]";
    private static final String LO_TXT_CUSTOMER_RELATIONS_VERIFY = "//h2/span[contains(text(), 'Relations clients')]";
    private static final String LO_EDT_POLICY_NUMBER = "//div[label='Numéro de la police']/following-sibling::div//input";
    private static final String LO_EDT_CLAIM_NUMBER = "//div[label='Numéro de réclamation Global Excel']/following-sibling::div//input";
    private static final String LO_EDT_FIRST_NAME = "//div[label='Prénom']/following-sibling::div//div//input";
    private static final String LO_EDT_LAST_NAME = "//div[label='Nom de famille']/following-sibling::div//div//input";
    private static final String LO_EDT_DATE_OF_BIRTH = "//div[label='Date de naissance']/following-sibling::div//div//input";
    private static final String LO_EDT_EMAIL = "//div[label='Adresse courriel']/following-sibling::div//div//input";
    private static final String LO_EDT_PHONE_NUMBER = "//div[label='Numéro de téléphone']/following-sibling::div//div//input";
    private static final String LO_EDT_ALTERNATE_PHONE_NUMBER = "//div[label='Numéro de téléphone alternatif']/following-sibling::div//div//input";
    private static final String LO_EDT_TEXT_TEXTAREA= "//div[label='Quelle est votre demande / comment pouvons-nous vous aider? (Un maximum de 2000 caractères est permis.)']/following-sibling::div//textarea";
    private static final String LO_BUT_VIEW_CHECK_CLAIM_STATUS = "//div[h2[span[contains(text(), \"Vérifier l'état d'une réclamation\")]]]/following-sibling::div//span[text()='CLIQUER ICI']";
    private static final String LO_BUT_VIEW_SUBMIT_DOCUMENTS = "//div[h2[span[contains(text(), 'Envoyer des documents')]]]/following-sibling::div//span[contains(text(), 'CLIQUER ICI')]";
    private static final String LO_TXT_SUBMIT_BILLS_OR_DOCUMENTS_SECTION = "//div//h2[contains(text(),'SOUMISSION DE FACTURES OU DOCUMENTS')]";
    private static final String LO_TXT_CUSTOMER_RELATIONS_FORM_SECTION = "//h2/span[text()='Relations clients']";
    //private static final String LO_TXT_CUSTOMER_RELATIONS_FORM_SECTION = "//h2/span[contains(text(), 'Faire une plainte')]";
    private static final String LO_LNK_CLICK_HERE = "//strong[a='Cliquez ici']";
    private static final String LO_LST_WHAT_YOU_NEED_TO_SUBMIT = "//div[span=\"Je dois soumettre:\"]/following-sibling::div//div[span='--Sélectionner--']";
    private static final String LO_LST_CLAIM_TYPE = "//div[span='Type de réclamation ']/following-sibling::div//div[span='Type de réclamation ']";
    private static final String LO_LST_DOCUMENT_TYPE = "//div[span='Type de document']/following-sibling::div//div[span='Type de document']";
    private static final String LO_LST_DOCUMENT_TYPE2 = "";
    private static final String LO_DOC_DOCUMENT_TYPE1 = "//h3[a[span[contains(text(), 'Type de document 1')]]]/following-sibling::div//input";
    private static final String LO_DOC_DOCUMENT_TYPE2 = "(//div[div[div[p='Les types de fichiers acceptés sont pdf, tiff, png, jpeg, jpg, gif, bmp, doc, docx, rtf, txt, odt.']]])[2]/following-sibling::div//input";
    private static final String LO_BUT_ADD_ANOTHER_DOCUMENT = "//a[contains(text(), '+ ')]";
    private static final String LO_TXT_CLAIM_STATUS_CARD = "//span/strong[contains(text(), 'État de votre réclamation')]";
    private static final String LO_TXT_CLAIM_STATUS_SECTION = "//div/h2[contains(text(), 'ÉTAT DE VOTRE RÉCLAMATION')]";
    private static final String LO_LNK_VIEW_YOUR_CLAIM_STATUS= "//a[contains(text(), \"Consulter l'état de votre réclamation\")]";
    private static final String LO_TXT_SUBMIT_BILLS_OR_DOCUMENTS_CARD= "//h3/span[contains(text(), 'Soumission de factures ou documents')]";
    private static final String LO_TXT_VALID_EMARGENCY_ASSISTANCE = "//h2/span[contains(text(), \"Assistance en cas d'urgence\")]";
    private static final String LO_TXT_VALID_EMERGENCY_ASSISTANCE_NEW = "//h2[contains(text(), \"Assistance en cas d'urgence\")]";
    private static final String LO_TXT_VALID_EMERGENCY_ASSISTANCE_NUMBER = "//strong[a='+1 819-566-3970']";
    private static final String LO_TXT_VALID_EMERGENCY_ASSISTANCE_OTHER_NUMBER = "//strong//a[contains(text(),'+1 866-873-3970')]";
    private static final String LO_BUT_GENERAL_QUESTION= "//span/strong[contains(text(), 'Questions générales')]";
    private static final String LO_TXT_GENERAL_QUESTIONS_VERIFY = "//div/h2[contains(text(), 'QUESTIONS GÉNÉRALES')]";
    private static final String LO_TXT_GENERAL_QUESTIONS_PARAGRAPH = "//div//p[contains(text(), \"Nous sommes là pour répondre à toute question que vous pourriez avoir. Pour toute question générale ou pour obtenir de l'assistance, faites-nous-en part ici. Si vous avez des inquiétudes par rapport à une décision qui a été récemment rendue sur une réclamation et souhaitez nous faire part de vos commentaires, cliquez\")]";
    private static final String LO_TXT_VALID_MGB_EMERGENCY_ASSISTANCE_NUMBER = "//span[strong='+1 819-566-8335']";
    private static final String LO_TXT_FQA = "//div[contains(text(),'Comment vais-je savoir quand ma réclamation est réglée?')]";
    private static final String LO_TXT_FIRST_QUESTION_RESPONSE = "//p[contains(text(),'Pour suivre l’état de votre réclamation, rendez-vous à la section État de la réclamation.')]";
    private static final String LO_LINK_VIEW_ALL_FAQs = "(//a)[11]";
    private static final String LO_TXT_TRAVEL_AND_ASSISTANCE = "//span[contains(text(),'Voyage et assistance')]";
    private static final String LO_TXT_CLAIMING = "//span[contains(text(),'Réclamations')]";
    private static final String LO_SLCT_EMERGENCY_TRAVEL_ASSISTANCE = "//h3/span[contains(text(), \"Assistance Voyage\")]";
    private static final String LO_TXT_EMERGENCY_TRAVEL_ASSISTANCE = "//h3/span[contains(text(), \"Assistance Voyage\")]";
    private static final String LO_TXT_VALID_CONSUMER_NUMBER = "//p[contains(text(), 'Consumer or Small Business Cards')]";
    private static final String LO_TXT_VALID_COMERCIAL_NUMBER = "//p[contains(text(), 'Commercial or Scotia Visa Business Cards')]";
    private static final String LO_IMG_MANULIFE_LOGO_TOP = "//img[@alt='Manulife Claim Center Page']";
    private static final String LO_RAD_RELATED_TO_CLAIM_DECISION_LETTER_NO = "//label[text()='Non']";
    private static final String LO_LST_SELECT_TOPIC = "//div[@role='combobox']";
    private static final String LO_DOC_UPLOAD = "//div[@class='MultipleFileUploadWidget---uploads_wrapper MultipleFileUploadWidget---drag_drop_zone_wrapper']/input";
    private static final String LO_IMG_GEM_TOP_LOGO_MGB = "//a//img[@src='https://geihpvqvwebgencacn1.blob.core.windows.net/appian-portal/logo_header_fr_ManulifeGroupBenefits.png' or @src='https://geihpvtvwebgencacn1.blob.core.windows.net/appian-portal/logo_header_en_ManulifeGroupBenefits.png']";
    private static final String LO_LNK_HELP_CENTRE_TOP = "//p[span[a[(span/span[@class='IconWidget---inLightBackground'][not(following-sibling::span)]) or (span[@class='IconWidget---inLightBackground'] and text()='HELP CENTRE')]]]";
    private static final String LO_BUT_FRANÇAIS = "//p[span[a[(span[span[@class='ColorText---color_custom'] and span[contains(text(), 'EN')]]) or (span[@class='IconWidget---inLightBackground'] and span[contains(text(), 'ENGLISH')])]]]";
    private static final String LO_TXT_MAILING_ADDRESS_HEADING = "//h2/span[text()='Mailing Address Information']";
    private static final String LO_TXT_MAILING_ADDRESS_HEADING_SUB_LEFT_MANULIFE = "(//p/strong[contains(text(), 'Manulife')])[1]";
    private static final String LO_TXT_MAILING_ADDRESS_LEFT = "(//div/p[strong])[1]";
    private static final String LO_TXT_MAILING_ADDRESS_HEADING_SUB_RIGHT_MANULIFE = "(//p/strong[contains(text(), 'Manulife')])[2]";
    private static final String LO_TXT_MAILING_ADDRESS_RIGHT = "(//div/p[strong])[2]";
    private static final String LO_TXT_VERIFY_SEND_US_MESSAGE_CONTAINS_CONTACT_US = "//div[h2[contains(text(), \"Nous envoyer un message\")]]";
    private static final String LO_TXT_VERIFY_CHECK_CLAIM_STATUS_CARD = "//div[h2[contains(text(), \"Vérifier l'état d'une réclamation\")]]";
    private static final String LO_BUT_CHECK_CLAIM_STATUS = "//div//span[contains(text(),\"Vérifier l'état d'une réclamation\")]";
    private static final String LO_TXT_VERIFY_SUBMIT_DOCUMENTS_CARD = "//div[h2[contains(text(), \"Envoyer des documents\")]]";
    private static final String LO_BUT_SUBMIT_DOCUMENTS = "//div//span[contains(text(),\"Envoyer des documents\")]";
    private static final String LO_BUT_BACK = "//span[contains(text(), 'Retour')]";
    private static final String LO_TXT_VERIFY_FAQ_SECTION = "//div[h2[contains(text(), 'Foire aux questions (FAQ)')]]";
    private static final String LO_BUT_VIEW_ALL_FAQS = "//span[contains(text(), 'Consulter la FAQ')]";
    private static final String LO_TXT_VERIFY_MAILING_ADDRESSES = "//div[h2[contains(text(), 'Adresse postale')]]";
    private static final String LO_TXT_SECOND_FAQ = "//div[contains(text(),'Dans combien de temps ma réclamation sera-t-elle réglée? ')]";
    private static final String LO_TXT_SECOND_FAQ_RESPONSE = "//div//p[contains(text(),'Nous nous efforçons de régler votre réclamation le plus efficacement possible. Assurez-vous de fournir tous les documents exigés dans les meilleurs délais afin d’accélérer le traitement de votre réclamation. Nous rendons une décision sur la plupart des réclamations dans les 30 jours suivant la réception des documents requis.')]";
    private static final String LO_TXT_THIRD_FAQ = "//div[contains(text(),'À quel moment vais-je recevoir mon numéro de réclamation?')]";
    private static final String LO_TXT_THIRD_FAQ_RESPONSE = "//div//p[contains(text(),'Lorsque vous soumettez les documents requis et confirmez les renseignements de votre réclamation, notamment votre nom, votre date de naissance ainsi que la raison pour laquelle vous soumettez une demande, une réclamation sera créée et vous recevrez votre numéro de réclamation par courriel.')]";

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
    public String validateOnPage() {
        String result = validateLocatorExists(LO_TXT_HELP_CENTER_PAGE_VERIFY , FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

     /**
     * Validates if current webpage is loaded and correct.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateOnHelpCenter() {
        String result = validateLocatorExists(LO_TXT_HELP_CENTER , FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if current webpage is loaded and correct.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateOnHelpCenterLink() {
        String result = validateLocatorExists(LO_TXT_HELP_CENTER_LINK , FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Clicks the 'CONTACT US' button.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String clickContactUsButton() {
        String result = clickLocator(LO_BUT_CONTACT_US, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Clicks the 'Manulife' logo.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String clickOnManulifeLogoTopLeftCorner() {
        String result = clickLocator(LO_IMG_MANULIFE_LOGO_TOP, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Clicks the 'VIEW' button under Check Claim Status option.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String clickOnViewUnderCheckClaimStatusOption() {
        String result = clickLocator(LO_BUT_VIEW_CHECK_CLAIM_STATUS, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Clicks the 'VIEW' button under the Submit Documents card layout.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String clickOnViewUnderSubmitDocumentsOption() {
        String result = clickLocator(LO_BUT_VIEW_SUBMIT_DOCUMENTS, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    
     /**
     * Validates if current webpage is loaded and correct.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String verifyContactUsHelpCentreSection() {
        String result = validateLocatorExists(LO_TXT_HOW_CAN_WE_ASSIST_YOU, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

     /**
     * Validates if current webpage is loaded and correct.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String verifyContactUsHelpCentreSectionNew() {
        String result = validateLocatorExists(LO_TXT_HOW_CAN_WE_ASSIST_YOU_NEW, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    /**
     * Clicks the 'Customer relation' card under the help centre page.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String clickCustomerRelations() {
        String result = clickLocator(LO_TXT_CUSTOMER_RELATIONS, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    /**
     * Validates if current webpage is loaded and correct.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String verifyCustomerRelationsPage() {
        String result = validateLocatorExists(LO_TXT_CUSTOMER_RELATIONS_VERIFY, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    /**
     * Enters the policy number.
     * 
     * @param policyNumber The policy number to be entered.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String enterPolicyNumber(String policyNumber) {
        String result = setText(LO_EDT_POLICY_NUMBER, policyNumber, FW_ConfigMgr.getDefaultTimeout(), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Enters the claim number.
     * 
     * @param claimNumber The claim number to be entered.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String enterClaimNumber(String claimNumber) {
        String result = setText(LO_EDT_CLAIM_NUMBER, claimNumber, FW_ConfigMgr.getDefaultTimeout(), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    
    /**
     * Enters the First Name.
     * 
     * @param firstName The First Name to be entered.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String enterFirstName(String firstName) {
        String result = setText(LO_EDT_FIRST_NAME, firstName, FW_ConfigMgr.getDefaultTimeout(), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Enters the Last Name.
     * 
     * @param lastName The Last Name to be entered.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String enterLastName(String lastName) {
        String result = setText(LO_EDT_LAST_NAME, lastName, FW_ConfigMgr.getDefaultTimeout(), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Enters the Date of Birth.
     * 
     * @param datOfBirth The date of birth to be entered.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String enterDOB(String dateOfBirth) {
        String result = setText(LO_EDT_DATE_OF_BIRTH, dateOfBirth, FW_ConfigMgr.getDefaultTimeout(), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Enters the Email.
     * 
     * @param email The email to be entered.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String enterEmail(String email) {
        String result = setText(LO_EDT_EMAIL, email, FW_ConfigMgr.getDefaultTimeout(), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Enters the Phone Number.
     * 
     * @param phone The phone number to be entered.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String enterPhone(String phone) {
        String result = setText(LO_EDT_PHONE_NUMBER, phone, FW_ConfigMgr.getDefaultTimeout(), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Enters the text in textarea.
     * 
     * @param text The text to be entered in the textarea.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String enterText(String text) {
        String result = setText(LO_EDT_TEXT_TEXTAREA, text, FW_ConfigMgr.getDefaultTimeout(), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Enters the text in textarea.
     * 
     * @param text The text to be entered in the textarea.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String enterTextInTextArea(String text) {
        String result = setText(LO_EDT_TEXT_TEXTAREA, text, FW_ConfigMgr.getDefaultTimeout(), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Verifies if the header "Submit Bills or Documents" exists.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String verifySubmitBillsOrDocumentsHeader() {
        String result = validateLocatorExists(LO_TXT_SUBMIT_BILLS_OR_DOCUMENTS_SECTION, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Verifies if the header "Customer Relations" exists.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String verifyCustomerRelationsHeader() {
        String result = validateLocatorExists(LO_TXT_CUSTOMER_RELATIONS_FORM_SECTION, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * clicks on the "Click here" link under Submit Bill or Documents.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */

    public String clickHereTextLink() {
        String result = clickLocator(LO_LNK_CLICK_HERE, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Selects what you need to submit.
     * 
     * @param whatYouNeedToSubmit what you need to submit is selected from a dropdown.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String selectWhatYouNeedToSubmit(String whatYouNeedToSubmit) {
        String result = setDropdownAppian(LO_LST_WHAT_YOU_NEED_TO_SUBMIT, whatYouNeedToSubmit, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Selects the claim type from a dropdown.
     * 
     * @param claimType what you need to submit is selected from a dropdown.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String selectClaimType(String claimType) {
        String result = setDropdownAppian(LO_LST_CLAIM_TYPE, claimType, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Selects the document type from a dropdown.
     * 
     * @param documentType the type of document is selected from a dropdown.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String selectDocumentType(String documentType) {
        String result = setDropdownAppian(LO_LST_DOCUMENT_TYPE, documentType, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

     /**
     * Selects the document type from a dropdown.
     * 
     * @param documentType the type of document is selected from a dropdown.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String selectDocumentType2(String documentType) {
        String result = setDropdownAppian(LO_LST_DOCUMENT_TYPE, documentType, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Uploads the first Document.
     * 
     * @param filePath The relative path of the itinerary file from the user's home directory.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String uploadDocumentType1(String filePath) {
        String result = uploadFileV2(filePath, LO_DOC_DOCUMENT_TYPE1);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Uploads the second Document.
     * 
     * @param filePath The relative path of the itinerary file from the user's home directory.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String uploadDocumentType2(String filePath) {
        waitForDuration(15, "s", false); // Wait to perform next check
        String result = uploadFileV2(filePath, LO_DOC_DOCUMENT_TYPE2);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * clicks on Add another Document.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
     public String clickOnAddAnotherDocument() {
        String result = clickLocator(LO_BUT_ADD_ANOTHER_DOCUMENT, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Clicks the 'Claim Status' card.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String clickClaimStatusCard() {
        String result = clickLocator(LO_TXT_CLAIM_STATUS_CARD, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

     /**
     * Clicks the "View your Claim Status" Link highlighted in red
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String clickOnViewYourClaimStatusLink() {
        String result = clickLocator(LO_LNK_VIEW_YOUR_CLAIM_STATUS, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if the Claim Status section is displayed.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String verifyClaimStatusSection() {
        String result = validateLocatorExists(LO_TXT_CLAIM_STATUS_SECTION, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * clicks on the "Submit Bill or Documents" card.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */

     public String clickSubmitBillOrDocumentCard() {
        String result = clickLocator(LO_TXT_SUBMIT_BILLS_OR_DOCUMENTS_CARD, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
     /**
     * Validates if current webpage is loaded and correct.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String VerifyEmergencyAssistanceCard() {
        String result = validateLocatorExists(LO_TXT_VALID_EMARGENCY_ASSISTANCE, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }  

    /**
     * Validates if current webpage is loaded and correct.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String VerifyEmergencyAssistanceCardNew() {
        String result = validateLocatorExists(LO_TXT_VALID_EMERGENCY_ASSISTANCE_NEW, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }  
     /**
     * Validates if current webpage is loaded and correct.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String VerifyEmergencyNumber() {
        String result = validateLocatorExists(LO_TXT_VALID_EMERGENCY_ASSISTANCE_NUMBER , FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }   

     /**
     * Validates if current webpage is loaded and correct.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String VerifyEmergencyOtherNumber() {
        String result = validateLocatorExists(LO_TXT_VALID_EMERGENCY_ASSISTANCE_OTHER_NUMBER , FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }  
     
     /**
     * Validates if current webpage is loaded and correct.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String VerifyMgbEmergencyNumber() {
        String result = validateLocatorExists(LO_TXT_VALID_MGB_EMERGENCY_ASSISTANCE_NUMBER , FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }   

/**
 * Clicks the 'General Question' card under the help centre page.
 * 
 * @return A string including [PASS] or [FAIL] along with specific result details.
 */
public String clickGeneralQuestion() {
    String result = clickLocator(LO_BUT_GENERAL_QUESTION, FW_ConfigMgr.getDefaultTimeout());
    result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
    return result;

}
/**
 * Validates if current webpage is loaded and correct.
 *
 * @return A string including [PASS] or [FAIL] along with specific result details.
 */
public String verifyGeneralQuestionsPage() {
    String result = validateLocatorExists(LO_TXT_GENERAL_QUESTIONS_VERIFY, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
    result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
    return result;
}

/**
 * Scrolls down on the page.
 * 
 * @return A string including [PASS] or [FAIL] along with specific result details.
 */
public String scrollDown() {
    String result = scrollToLocator(LO_TXT_FQA);
    result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
    return result;
}

/**
 * Clicks the 'Second Frequently Asked Question'
 * 
 * @return A string including [PASS] or [FAIL] along with specific result details.
 */
public String clickOnFirstFAQ() {
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
public String validateFirstQuestionResponse() {
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
public String clickOnViewAllFAQs() {
    String result = clickLocator(LO_LINK_VIEW_ALL_FAQs, FW_ConfigMgr.getDefaultTimeout());
    result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
    return result;
}

/**
 * Validates if the Travel and Assistance questions displayed correctly.
 *
 * @return A string including [PASS] or [FAIL] along with specific result details.
 */
public String validateTravelAndAssistanceQuestions() {
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
public String validateClaimingQuestions() {
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
public String clickEmergencyTravelAssistance() {
    String result = clickLocator(LO_SLCT_EMERGENCY_TRAVEL_ASSISTANCE, FW_ConfigMgr.getDefaultTimeout());
    result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
    return result;
}

/**
 * Validates if the Emergency Travel Assistance section displayed correctly.
 *
 * @return A string including [PASS] or [FAIL] along with specific result details.
 */
public String validateEmergencyTravelAssistance() {
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
public String enterAlternatePhoneNumber(String alternatePhone) {
    String result = setText(LO_EDT_ALTERNATE_PHONE_NUMBER, alternatePhone, FW_ConfigMgr.getDefaultTimeout(), false);
    result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
    return result;
}
/**
 * Validates if the Consumer or Small Business Number displayed correctly.
 *
 * @return A string including [PASS] or [FAIL] along with specific result
 *         details.
 */
public String validateConsumerorSmallBusinessNumber() {
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
    public String validateCommercialNumber() {
        String result = validateLocatorExists(LO_TXT_VALID_COMERCIAL_NUMBER, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Selects radio button "No" for the dropdown for the question : Is this related to a claim decision letter you received? .
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String selectNoToRelatedToClaimDecisionLetter() {
        String result = clickLocator(LO_RAD_RELATED_TO_CLAIM_DECISION_LETTER_NO, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Selects a value from the dropdown of field To help us better understand your situation, please select the topic that best applies to your request.
     * @param topic The topic that best applies to your request.
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String selectTopicThatAppliesToRequest(String topic) {
        String result = setDropdownAppian(LO_LST_SELECT_TOPIC, topic, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Uploads a document.
     * 
     * @param filePath The relative path of the payment proof file from the user's home directory.
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String uploadDocument(String filePath) {
        String result = uploadFileV2(filePath, LO_DOC_UPLOAD);
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
     * Validates if the French/English Button toggle at top right is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String validateFrenchButtonToggle() {
        String result = validateLocatorExists(LO_BUT_FRANÇAIS, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    /**
     * Validates if the Mailing Address heading at bottom towards footer of page is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String validateMailingAddressHeader() {
        String result = validateLocatorExists(LO_TXT_MAILING_ADDRESS_HEADING, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    /**
     * Validates if the Sub-Title 1 for Mailing Address heading at bottom towards footer of page is present(Manulife).
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String validateMailingAddressSubHeadingTitleLeft_Manulife(String input) {
        String result = validateWithinLocatorText(LO_TXT_MAILING_ADDRESS_HEADING_SUB_LEFT_MANULIFE,input,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
     /**
     * Validates if the Sub-Title 2 for Mailing Address heading at bottom towards footer of page is present(Manulife).
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String validateMailingAddressSubHeadingTitleLeft_Manulife2(String input) {
        String result = validateWithinLocatorText(LO_TXT_MAILING_ADDRESS_LEFT,input,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
     /**
     * Validates if the PO.BOX for Mailing Address heading at bottom towards footer of page is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String validateMailingAddressPOBOXLeft(String input) {
        String result = validateWithinLocatorText(LO_TXT_MAILING_ADDRESS_LEFT,input,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    /**
     * Validates if the PO.BOX for Mailing Address heading at bottom towards footer of page is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String validateMailingAddressPOBOXStationLeft(String input) {
        String result = validateWithinLocatorText(LO_TXT_MAILING_ADDRESS_LEFT,input,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    /**
     * Validates if the City for Mailing Address heading at bottom towards footer of page is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String validateMailingAddressCityLeft(String input) {
        String result = validateWithinLocatorText(LO_TXT_MAILING_ADDRESS_LEFT,input,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
     /**
     * Validates if the Province for Mailing Address heading at bottom towards footer of page is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String validateMailingAddressProvinceLeft(String input) {
        String result = validateWithinLocatorText(LO_TXT_MAILING_ADDRESS_LEFT,input,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    /**
     * Validates if the Country for Mailing Address heading at bottom towards footer of page is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String validateMailingAddressCountryLeft(String input) {
        String result = validateWithinLocatorText(LO_TXT_MAILING_ADDRESS_LEFT,input,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
     /**
     * Validates if the Country for Mailing Address heading at bottom towards footer of page is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String validateMailingAddressPostalCodeLeft(String input) {
        String result = validateWithinLocatorText(LO_TXT_MAILING_ADDRESS_LEFT,input,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
     /**
     * Validates if the Sub-Title 1 for Mailing Address heading at bottom towards footer of page is present(Manulife).
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String validateMailingAddressSubHeadingTitleRight_Manulife(String input) {
        String result = validateWithinLocatorText(LO_TXT_MAILING_ADDRESS_HEADING_SUB_RIGHT_MANULIFE,input,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    /**
     * Validates if the Sub-Title 2 for Mailing Address heading at bottom towards footer of page is present(Manulife).
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String validateMailingAddressSubHeadingTitleRight_Manulife2(String input) {
        String result = validateWithinLocatorText(LO_TXT_MAILING_ADDRESS_RIGHT,input,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
     /**
     * Validates if the Street for Mailing Address heading at bottom towards footer of page is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String validateMailingAddressPOBOXRight(String input) {
        String result = validateWithinLocatorText(LO_TXT_MAILING_ADDRESS_RIGHT,input,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    /**
     * Validates if the Building for Mailing Address heading at bottom towards footer of page is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String validateMailingAddressBuildingRight(String input) {
        String result = validateWithinLocatorText(LO_TXT_MAILING_ADDRESS_RIGHT,input,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
     /**
     * Validates if the Province for Mailing Address heading at bottom towards footer of page is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String validateMailingAddressStateRight(String input) {
        String result = validateWithinLocatorText(LO_TXT_MAILING_ADDRESS_RIGHT,input,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    /**
     * Validates if the Province for Mailing Address heading at bottom towards footer of page is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String validateMailingAddressProvinceRight(String input) {
        String result = validateWithinLocatorText(LO_TXT_MAILING_ADDRESS_RIGHT,input,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
     /**
     * Validates if the Country for Mailing Address heading at bottom towards footer of page is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String validateMailingAddressZipCodeRight(String input) {
        String result = validateWithinLocatorText(LO_TXT_MAILING_ADDRESS_RIGHT,input,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

     /**
     * Validates if Emergency Assistance section displays two TD phone numbers by default
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String VerifyEmergencyAssistanceSectionDisplaysTwoPhoneNumbers(String expectedFirstNumber, String expectedSecondNumber) {
        String result = validateWithinLocatorText(LO_TXT_VALID_EMERGENCY_ASSISTANCE_NEW, expectedFirstNumber, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(), true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }  

     /**
     * Validates if Send us a message includes a Contact Us card with a button at the bottom.
     * @return A string including [PASS] or [FAIL] along with specific result details.
     * 
     */
    public String verifySendUsMessageContainsContactUsCart(String button) {
        String result = validateWithinLocatorText(LO_TXT_VERIFY_SEND_US_MESSAGE_CONTAINS_CONTACT_US, button, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(), true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

     /**
     * Validates if Check Claim Status card has a button.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String verifyCheckClaimStatusCardContainsButton(String button) {
        String result = validateWithinLocatorText(LO_TXT_VERIFY_CHECK_CLAIM_STATUS_CARD, button, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(), true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

     /**
     *Test to chech if "Check Claim Status's button is functional.
    * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String clickCheckClaimStatusButton() {
        String result = clickLocator(LO_BUT_CHECK_CLAIM_STATUS, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

     /**
     * Validates if "Submit Documents" card with a button at the bottom is available.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String verifySubmitDocumentsCardContainsButton(String button) {
        String result = validateWithinLocatorText(LO_TXT_VERIFY_SUBMIT_DOCUMENTS_CARD, button, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(), true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

     /**
     * Test to check if "Submit Documents" button is functional.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String clickSubmitDocumentsButton() {
        String result = clickLocator(LO_BUT_SUBMIT_DOCUMENTS, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

     /**
     * Clicks "BACK" button on the page.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String clickBackButton() {
        String result = clickLocator(LO_BUT_BACK, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;      
    }

     /**
     * Validates if the "FAQ" section displays three common questions.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String verifyFAQSectionDisplaysThreeCommonQuestions(String expectedFirstQuestion, String expectedSecondQuestion, String expectedThirdQuestion) {
        String result = validateLocatorExists(LO_TXT_VERIFY_FAQ_SECTION, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result += validateWithinLocatorText(LO_TXT_VERIFY_FAQ_SECTION, expectedFirstQuestion, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(), true);
        result += validateWithinLocatorText(LO_TXT_VERIFY_FAQ_SECTION, expectedSecondQuestion, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(), true);
        result += validateWithinLocatorText(LO_TXT_VERIFY_FAQ_SECTION, expectedThirdQuestion, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(), true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

     /**
     * Validates if "VIEW ALL FAQS" button to access all FAQs is under the "FAQ" section.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String verifyViewAllFAQsButton(String buttonText) {
        String result = validateWithinLocatorText(LO_TXT_VERIFY_FAQ_SECTION, buttonText, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(), true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

     /**
     * Clicks the "VIEW ALL FAQS" button to access all FAQs.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String clickViewAllFAQsButton() {
        String result = clickLocator(LO_BUT_VIEW_ALL_FAQS, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

     /**
     * Validates if "Mailing addresses" information is displayed.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String verifyMailingAddressesInformation(String expectedText) {
        String result = validateWithinLocatorText(LO_TXT_VERIFY_MAILING_ADDRESSES, expectedText, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(), true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
 * Validates if the response displayed correctly.
 *
 * @return A string including [PASS] or [FAIL] along with specific result
 *         details.
 */
public String clickSecondQuestionResponse() {
    String clickResult = clickLocator(LO_TXT_SECOND_FAQ, FW_ConfigMgr.getDefaultTimeout());
    String validateResult = validateLocatorExists(LO_TXT_SECOND_FAQ_RESPONSE, FW_ConfigMgr.getDefaultTimeout(),
            FW_ConfigMgr.getDefaultInterval());
    String result = clickResult + validateResult;
    result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
    return result;
}

/**
 * Validates if the response displayed correctly.
 *
 * @return A string including [PASS] or [FAIL] along with specific result
 *         details.
 */
public String clickThirdQuestionResponse() {
    String clickResult = clickLocator(LO_TXT_THIRD_FAQ, FW_ConfigMgr.getDefaultTimeout());
    String validateResult = validateLocatorExists(LO_TXT_THIRD_FAQ_RESPONSE, FW_ConfigMgr.getDefaultTimeout(),
            FW_ConfigMgr.getDefaultInterval());
    String result = clickResult + validateResult;
    result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
    return result;
}

/**
 * Validates if "general questions" paragraph is displayed.
 *
 * @return A string including [PASS] or [FAIL] along with specific result
 *         details.
 */
public String validateGeneralQuestionsParagraph() {
    String result = validateLocatorExists(LO_TXT_GENERAL_QUESTIONS_PARAGRAPH, FW_ConfigMgr.getDefaultTimeout(),
            FW_ConfigMgr.getDefaultInterval());
    result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
    return result;
}



   
}

