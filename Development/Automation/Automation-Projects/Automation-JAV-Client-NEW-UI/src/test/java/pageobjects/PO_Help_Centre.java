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
    
   
    private static final String LO_TXT_HELP_CENTER_PAGE_VERIFY_NZ = "//h1[contains(text(), 'Help Centre')]";
    private static final String LO_TXT_MAILING_ADDRESS_INFO_HEADING = "//h2[contains(text(), 'Mailing Address Information')]";
    private static final String LO_TXT_GEMINC_HEADING = "(//strong[contains(text(), 'Global Excel Management Inc.')])[1]";
    private static final String LO_TXT_CAD_HEADING = "//div[h2[contains(text(), 'Mailing Address Information')]]//div//p//strong[contains(text(), 'Canada')]";
    private static final String LO_TXT_USA_HEADING = "//div[h2[contains(text(), 'Mailing Address Information')]]//div//p//strong[contains(text(), 'United States of America')]";
    private static final String LO_TXT_ADDRESS_INFO_NZ = "//p[text()='73 Queen Street']";
    private static final String LO_TXT_ADDRESS_INFO_USA_NZ = "//p[text()='P.O. Box 10']";
    private static final String LO_TXT_TRAVEL_AND_ASSISTANCE_VERIFY = "//strong[contains(text(), 'Travel and Assistance')]";
    private static final String LO_IMG_TOP_LOGO_LIGHT_ZURICH = "//a//img[@src='https://geihpvqvwebgencacn1.blob.core.windows.net/appian-portal/logo_header_en_Zurich.png']";
    private static final String LO_BUT_CONTACT_US = "//span[contains(text(), 'CONTACT US')]";
    private static final String LO_TXT_HOW_CAN_WE_ASSIST_YOU = "//h2/span[contains(text(), 'How can we assist you ?')]";
    private static final String LO_TXT_CUSTOMER_RELATIONS_CARD = "//h3/span[contains(text(), 'Customer Relations')]";
    private static final String LO_TXT_CUSTOMER_RELATIONS_VERIFY = "//h2/span[contains(text(), 'Customer Relations')]";
    private static final String LO_EDT_POLICY_NUMBER = "//div[label='Policy Number']/following-sibling::div//input";
    private static final String LO_EDT_CLAIM_NUMBER = "//div[label='Global Excel Claim Number']/following-sibling::div//input";
    private static final String LO_EDT_FIRST_NAME = "//div[label='First Name']/following-sibling::div//div//input";
    private static final String LO_EDT_LAST_NAME = "//div[label='Last Name']/following-sibling::div//div//input";
    private static final String LO_EDT_DATE_OF_BIRTH = "//div[label='Date of Birth']/following-sibling::div//div//input";
    private static final String LO_EDT_EMAIL = "//div[label='Email']/following-sibling::div//div//input";
    private static final String LO_EDT_PHONE_NUMBER = "//div[label='Phone Number']/following-sibling::div//div//input";
    private static final String LO_EDT_ALTERNATE_PHONE_NUMBER = "//div[label='Alternate Phone Number']/following-sibling::div//div//input";
    private static final String LO_EDT_TEXT_TEXTAREA= "//div[label='What is your request/How can we assist you? (Maximum of 2000 characters allowed)']/following-sibling::div//textarea";
    private static final String LO_BUT_VIEW_CHECK_CLAIM_STATUS = "//div[h2[span[contains(text(), 'Check Claim Status')]]]/following-sibling::div//span[text()='VIEW']";
    private static final String LO_BUT_VIEW_SUBMIT_DOCUMENTS = "//div[h2[span[contains(text(), 'Submit Documents')]]]/following-sibling::div//span[contains(text(), 'VIEW')]";
    private static final String LO_TXT_SUBMIT_BILLS_OR_DOCUMENTS_SECTION = "//h2/span[contains(text(), 'Submit Bills or Documents')]";
    private static final String LO_TXT_SUBMIT_BILLS_OR_DOCUMENTS_SECTION_TD = "//h2[contains(text(), 'SUBMIT BILLS OR DOCUMENTS')]";
    private static final String LO_TXT_CUSTOMER_RELATIONS_FORM_SECTION = "//h2/span[contains(text(), 'Customer Relations')]";
    private static final String LO_LNK_CLICK_HERE = "//div[div[div[div[p[contains(text(), 'Are you starting a new claim?')]]]]]/following-sibling::div//div[p[strong[contains(text(), 'CLICK HERE')]]]";
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
    private static final String LO_BUT_BACK = "//button//span[contains(text(), 'Back')]";
    private static final String LO_TXT_TRAVEL_AND_ASSISTANCE = "//span[contains(text(),'Travel and Assistance')]";
    private static final String LO_TXT_CLAIMING = "//span[contains(text(),'Claiming')]";
    private static final String LO_SLCT_EMERGENCY_TRAVEL_ASSISTANCE = "//h3/span[contains(text(), 'Emergency Travel Assistance')]";
    private static final String LO_TXT_EMERGENCY_TRAVEL_ASSISTANCE = "//h3/span[contains(text(), 'Emergency Travel Assistance')]";
    private static final String LO_TXT_VALID_CONSUMER_NUMBER = "//p[contains(text(), 'Consumer or Small Business Cards')]";
    private static final String LO_TXT_VALID_COMERCIAL_NUMBER = "//p[contains(text(), 'Commercial or Scotia Visa Business Cards')]";
    private static final String LO_IMG_MANULIFE_LOGO_TOP = "//img[@alt='Manulife Claim Center Page']";
    private static final String LO_RAD_RELATED_TO_CLAIM_DECISION_LETTER_NO = "//label[text()='No']";
    private static final String LO_LST_SELECT_TOPIC = "//div[@role='combobox']";
    private static final String LO_DOC_UPLOAD = "//div[@class='MultipleFileUploadWidget---uploads_wrapper MultipleFileUploadWidget---drag_drop_zone_wrapper']/input";
    private static final String LO_IMG_GEM_TOP_LOGO = "//a//img[@src='https://geihpvqvwebgencacn1.blob.core.windows.net/appian-portal/logo_header_en_GEM.png' or @src='https://geihpvtvwebgencacn1.blob.core.windows.net/appian-portal/logo_header_en_GEM.png']";
    private static final String LO_LNK_HELP_CENTRE_TOP = "//p[span[a[(span/span[@class='IconWidget---inLightBackground'][not(following-sibling::span)]) or (span[@class='IconWidget---inLightBackground'] and text()='HELP CENTRE')]]]";
    private static final String LO_BUT_FRANÇAIS = "//p[span[a[(span[span[@class='IconWidget---inLightBackground'] and span[contains(text(), 'FR')]]) or (span[@class='IconWidget---inLightBackground'] and span[contains(text(), 'FRANÇAIS')])]]]";
    private static final String LO_TXT_MAILING_ADDRESS_HEADING = "//h2/span[text()='Mailing Address Information']";
    private static final String LO_TXT_MAILING_ADDRESS_HEADING_SUB_LEFT = "(//p/strong[contains(text(), 'Global Excel Management')])[1]";
    private static final String LO_TXT_MAILING_ADDRESS_HEADING_SUB_LEFT_MANULIFE = "(//p/strong[contains(text(), 'Manulife')])[1]";
    private static final String LO_TXT_MAILING_ADDRESS_LEFT = "(//div[div[div[h2/span='Mailing Address Information']]]/following-sibling::div//p)[1]";
    private static final String LO_TXT_MAILING_ADDRESS_HEADING_SUB_RIGHT = "(//p/strong[contains(text(), 'Global Excel Management')])[2]";
    private static final String LO_TXT_MAILING_ADDRESS_HEADING_SUB_RIGHT_MANULIFE = "(//p/strong[contains(text(), 'Manulife')])[2]";
    private static final String LO_TXT_MAILING_ADDRESS_RIGHT = "(//div[div[div[h2/span='Mailing Address Information']]]/following-sibling::div//p)[2]";
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
    private static final String LO_BUT_SUBMIT_DOCUMENTS = "//span[contains(text(), 'Submit Documents')]";
    private static final String LO_UPLOAD_DOC_NEW_UI = "//div[@class='MultipleFileUploadWidget---upload_field']/div//input";
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
    public String validateOnPage_NZ() {
        String result = validateLocatorExists(LO_TXT_HELP_CENTER_PAGE_VERIFY_NZ , FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String clickSubmitDocuments() {
        String result = clickLocator(LO_BUT_SUBMIT_DOCUMENTS, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String validateMailingAddressInfoHeading() {
        String result = validateLocatorExists(LO_TXT_MAILING_ADDRESS_INFO_HEADING, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String validateGlobalExcelManagementIncTitleCAD_NZ() {
        String result = validateLocatorExists(LO_TXT_ADDRESS_INFO_NZ, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String validateUSAHeading() {
        String result = validateLocatorExists(LO_TXT_USA_HEADING, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String validateCADHeading() {
        String result = validateLocatorExists(LO_TXT_CAD_HEADING, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String validateGlobalExcelManagementIncTitleUSA() {
        String result = validateLocatorExists(LO_TXT_ADDRESS_INFO_USA_NZ, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String validateStreetCAD(String street) {
        String result = validateWithinLocatorText(LO_TXT_ADDRESS_INFO_NZ,street,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String validatePOBOXUSA(String street) {
        String result = validateWithinLocatorText(LO_TXT_ADDRESS_INFO_USA_NZ,street,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String validateProvinceAndCityUSA(String street) {
        String result = validateWithinLocatorText(LO_TXT_ADDRESS_INFO_USA_NZ,street,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String validateProvinceAndCityOnProvinceUSA(String street) {
        String result = validateWithinLocatorText(LO_TXT_ADDRESS_INFO_USA_NZ,street,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String validateCountryUSA(String street) {
        String result = validateWithinLocatorText(LO_TXT_ADDRESS_INFO_USA_NZ,street,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String validatePostalCodeUSA(String street) {
        String result = validateWithinLocatorText(LO_TXT_ADDRESS_INFO_USA_NZ,street,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String validateProvinceAndCityCAD(String street) {
        String result = validateWithinLocatorText(LO_TXT_ADDRESS_INFO_NZ,street,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String validateCountryCAD(String street) {
        String result = validateWithinLocatorText(LO_TXT_ADDRESS_INFO_NZ,street,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String validatePostalCodeCAD(String street) {
        String result = validateWithinLocatorText(LO_TXT_ADDRESS_INFO_NZ,street,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String validateTravelAndAssistance_NZ() {
        String result = validateLocatorExists(LO_TXT_TRAVEL_AND_ASSISTANCE_VERIFY , FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String validateTop_Left_Logo_Light_Zurich() {
        String result = clickLocator(LO_IMG_TOP_LOGO_LIGHT_ZURICH, FW_ConfigMgr.getDefaultTimeout());
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
    public String validateGem_Top_Left_Logo_Intact() {
        String result = validateLocatorExists(LO_IMG_GEM_TOP_LOGO_INTACT, FW_ConfigMgr.getDefaultTimeout(),
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
    public String validateHelpCentreHeader_Dark() {
        String result = validateLocatorExists(LO_LNK_HELP_CENTRE_TOP_DARK, FW_ConfigMgr.getDefaultTimeout(),
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
    public String validateGem_Top_Left_Logo_Manulife() {
        String result = validateLocatorExists(LO_IMG_GEM_TOP_LOGO_MANULIFE, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if the Help Centre link or icon is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String validateFrancaisButton_Dark() {
        String result = validateLocatorExists(LO_BUT_FRANÇAIS_DARK, FW_ConfigMgr.getDefaultTimeout(),
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
    public String validateGem_Top_Left_Logo() {
        String result = validateLocatorExists(LO_IMG_GEM_TOP_LOGO, FW_ConfigMgr.getDefaultTimeout(),
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
     * Clicks the 'Customer relation' card under the help centre page.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String clickCustomerRelations() {
        String result = clickLocator(LO_TXT_CUSTOMER_RELATIONS_CARD, FW_ConfigMgr.getDefaultTimeout());
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
        String result = validateLocatorExists(LO_TXT_SUBMIT_BILLS_OR_DOCUMENTS_SECTION_TD, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String verifySubmitBillsOrDocumentsHeader_TD_NEWUI() {
        String result = validateLocatorExists(LO_TXT_SUBMIT_BILLS_OR_DOCUMENTS_SECTION_TD, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
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
    public String uploadDocumentUI(String filePath) {
        String result = uploadFileV2(filePath, LO_UPLOAD_DOC_NEW_UI);
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
public String clickOnViewAllFAQs_NZ() {
    String result = clickLocator(LO_BUT_VIEW_ALL_FAQs, FW_ConfigMgr.getDefaultTimeout());
    result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
    return result;
}

public String clickOnBackButton() {
    String result = clickLocator(LO_BUT_BACK, FW_ConfigMgr.getDefaultTimeout());
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
     * Validates if the Sub-Title 1 for Mailing Address heading at bottom towards footer of page is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String validateMailingAddressSubHeadingTitleLeft(String input) {
        String result = validateWithinLocatorText(LO_TXT_MAILING_ADDRESS_HEADING_SUB_LEFT,input,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
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
     * Validates if the Street for Mailing Address heading at bottom towards footer of page is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String validateMailingAddressStreetLeft(String input) {
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
     * Validates if the Sub-Title 1 for Mailing Address heading at bottom towards footer of page is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String validateMailingAddressSubHeadingTitleRight(String input) {
        String result = validateWithinLocatorText(LO_TXT_MAILING_ADDRESS_HEADING_SUB_RIGHT,input,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
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
     * Validates if the Street for Mailing Address heading at bottom towards footer of page is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String validateMailingAddressStreetRight(String input) {
        String result = validateWithinLocatorText(LO_TXT_MAILING_ADDRESS_RIGHT,input,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if the City for Mailing Address heading at bottom towards footer of page is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String validateMailingAddressCityRight(String input) {
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
     * Validates if the Country for Mailing Address heading at bottom towards footer of page is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String validateMailingAddressCountryRight(String input) {
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
}

