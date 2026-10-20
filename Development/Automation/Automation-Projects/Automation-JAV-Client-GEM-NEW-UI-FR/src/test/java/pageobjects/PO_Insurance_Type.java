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
public class PO_Insurance_Type extends CU_Appian {

    // [Note: Automation Engineer, define the Page Object (PO) locators (LO) here.]
    private static final String LO_BUT_CONTINUE_DRAFT_CLAIM = "//span[contains(text(),'POURSUIVRE VOTRE DEMANDE')]";
    private static final String LO_BUT_NEED_HELP = "//strong[contains(text(),'Need Help?')]";
    private static final String LO_BUT_HELP_CENTRE = "//a[contains(text(),\"CENTRE D'ASSISTANCE\")]";
    private static final String LO_BUT_SWITCH_LANGUAGE = "//strong[contains(text(),'Switch Language')]";
    private static final String LO_BUT_PRIVACY_STATEMENT = "//strong[contains(text(),'Privacy Statement')]";
    private static final String LO_BUT_CONDITIONS_OF_USE = "//a[contains(text(),\"conditions d'utilisation \")]";
    private static final String LO_BUT_BACK = "//button[@type='button']//span//span[contains(text(),'Retour')]"; // Had to use double span to isolate from accessibility
    

    private static final String LO_TXT_WHICH_INSURANCE_TYPE = "//h2[contains(text(), \"POUR QUEL TYPE D'ASSURANCE PRÉSENTEZ-VOUS UNE RÉCLAMATION?\")]";
    private static final String LO_TXT_WHICH_INSURANCE_TYPE_NEW = "//div/h2[contains(text(), \"POUR QUEL TYPE D'ASSURANCE PRÉSENTEZ-VOUS UNE RÉCLAMATION?\") or contains(text(), 'Pour quel type d')]";
    private static final String LO_BUT_GROUP_INSURANCE = "//h3/span[contains(text(), 'Group Insurance') or contains(text(), 'Assurance collective')]";
    private static final String LO_BUT_INDIVIDUAL_INSURANCE = "//span/strong[contains(text(), 'Assurance individuelle')]";
    private static final String LO_BUT_PURCHASED_INSURANCE = "//strong[contains(text(), 'Assurance achetée')]";
    //private static final String LO_BUT_CREDIT_CARD_INSURANCE = "//div[div/div/div/div/div[p[contains(text(),'Assurance de carte de crédit')]]]/following-sibling::span";
    private static final String LO_BUT_CREDIT_CARD_INSURANCE = "//strong[contains(text(), \"Assurance de carte de crédit\")]";
    private static final String LO_BUT_CREDIT_CARD_INSURANCE_NEW = "//strong[contains(text(),'Assurance de carte de crédit')]";
    private static final String LO_BUT_CREDIT_CARD_INSURANCE_BIG = "//span/strong[contains(text(),'Assurance de carte de crédit')]";
    private static final String LO_BUT_CREDIT_CARD_CIBC = "//span//strong[contains(text(),\"Assurance de carte de crédit\")]";
    private static final String LO_BUT_BOUGHT_INSURANCE = "//div/p[contains(text(), 'Assurance achetée')]";
    private static final String LO_BUT_CONTINUE = "//span/span[contains(text(),'Continuer')]";
    private static final String LO_TXT_RETAIL_CREDIT_CARD = "//span[text()='--Select category type--']";
    private static final String LO_TXT_CARD_TYPE = "//span[text()='--Select card type--']";
    private static final String LO_LST_CREDIT_CARD_INSURANCE_CATEGORY_TYPE = "//div[span='Sélectionnez la catégorie de votre carte:']/following-sibling::div//div[@role='combobox']";
    private static final String LO_LST_CREDIT_CARD_INSURANCE_CATEGORY_TYPE_NEW = "//div[span='Sélectionnez la catégorie de votre carte:']/following-sibling::div//div[@role='combobox']";
    private static final String LO_LST_CREDIT_CARD_INSURNCE_CARD_TYPE = "//div[span='Sélectionnez votre type de carte:']/following-sibling::div//div[@role='combobox']";
    private static final String LO_TXT_TD_INSURANCE_TYPE_VERIFY = "//h2[contains(text(),\"POUR QUEL TYPE D'ASSURANCE PRÉSENTEZ-VOUS UNE RÉCLAMATION?\")]";
    private static final String LO_TXT_CREDIT_CARD_INSURNCE = "//span/strong[contains(text(), 'Assurance de carte de crédit')]";
    private static final String LO_TXT_PURCHASED_INSURNCE = "//span//strong[contains(text(),'Assurance achetée')]";
    private static final String LO_TXT_CATEGORY_TYPE_DROP_DOWN = "//div[span=\"Sélectionnez la catégorie de votre carte:\"]";
    private static final String LO_TXT_CARD_TYPE_DROP_DOWN = "(//div[span=\"Sélectionnez votre type de carte:\"])[1]";
    private static final String LO_TXT_GROUP_INSURANCE_OPTION = "//span/strong[contains(text(),'Assurance collective')]";
    private static final String LO_TXT_GROUP_INSURANCE_HEADING_CARD = "//span//strong[contains(text(),'Assurance collective')]";
    private static final String LO_TXT_INDIVIDUAL_INSURANCE_OPTION = "//h3/span[contains(text(),'Assurance individuelle')]";
    private static final String LO_TXT_INDIVIDUAL_INSURANCE_HEADING_CARD = "//span//strong[contains(text(),'Assurance individuelle')]"; 
    private static final String LO_LNK_FRENCH_BUTTON = "//a[contains(text(), 'ENGLISH')]";
    private static final String LO_IMG_GEM_TOP_LOGO_TD = "//a//img[@src='https://geihpvqvwebgencacn1.blob.core.windows.net/appian-portal/logo_header_fr_TD.png']";
    private static final String LO_TXT_CLAIM_OPENING_HEADING = "//h1[contains(text(), 'Ouverture de réclamation')]";
    private static final String LO_TXT_HERE_TO_HELP_HEADING = "//img[@src='https://portal-qa.globalexcel.com/portal-2-0/content/ww0ECQMCPdCWI-gGpDcB0mEBGlUODFt5Mv9PbX5sprH9-R58MA3wjN61_C9eEQJS0ADYN5zIL-1UxXnzoSmzAvsvbriJRgp2DvTewnw4QcXQR3G0_JlCiw_Me7KeX1wuEn2jo2NGj1cBILuwseCBsL6k']";
    private static final String LO_TXT_CONTINUE_DRAFT_CLAIM_PARAGRAPH = "//p[contains(text(), \"Your claim was already started and you'd like to continue filing it?\")]";
    private static final String LO_TXT_WHICH_INSURANCE_TYPE_PARAGRAPH = "//p[contains(text(),\"Pour commencer, veuillez sélectionner le type d'assurance\")]";
    private static final String LO_TXT_CREDIT_CARD_INSURANCE_PARAGRAPH = "//span[contains(text(),\"Assurance offerte par votre carte de crédit.\")]";
    private static final String LO_TXT_PURCHASED_INSURANCE_PARAGRAPH = "//span[contains(text(),\"Assurance achetée directement auprès d'un assureur.\")]";
    private static final String LO_TXT_COPY_RIGHT_NOTICE = "//p[span[@class=\"IconWidget---inLightBackground\"]]";
    private static final String LO_TXT_CLAIMING_REASON = "//div//h2[contains(text(), \"POUR QUELLE RAISON FAITES-VOUS UNE RÉCLAMATION?\")]";
    private static final String LO_TXT_EMERGENCY_MEDICAL_TRAVEL = "//strong[contains(text(), \"Soins médicaux d'urgence en voyage\")]";
    private static final String LO_TXT_STUDENTS = "//strong[contains(text(), \"Étudiants\")]";
    private static final String LO_TXT_VISITORS_TO_CANADA = "//strong[contains(text(), \"Visiteurs au Canada\")]";
    private static final String LO_TXT_EXPATRIATE = "//strong[contains(text(), \"Expatriés\")]";



    /**
     * Define the Page Object (PO) constructor.
     * @param driver The WebDriver object passed from the test method.
     */
    // [Note: Automation Engineer, rename this Page Object (PO) class to match the filename.]
    public PO_Insurance_Type(WebDriver driver) {
        super(driver);
    }

    /**
     * Validates if current webpage is loaded and correct.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateOnPage() {
        String result = validateLocatorExists(LO_TXT_WHICH_INSURANCE_TYPE, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Verify that the credit card insurance option displays.
     * 
     * @param credit_card_insurance the value that we expect in CAD.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String verifyCreditCardInsuranceOption(String credit_card_insurance) {
        String result = validateWithinLocatorText(LO_TXT_CREDIT_CARD_INSURNCE,credit_card_insurance,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

     /**
     * Validates if Frech link with its globe icon exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateFrenchButton() {
        String result = validateLocatorExists(LO_LNK_FRENCH_BUTTON, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
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
     * Validates if the 'Claim opening' heading is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String validateClaimOpeningHeading() {
        String result = validateLocatorExists(LO_TXT_CLAIM_OPENING_HEADING, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if the 'Here to help' heading is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String validateHereToHelpHeading() {
        String result = validateLocatorExists(LO_TXT_HERE_TO_HELP_HEADING, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if the paragraph for continue draft claim is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String validateContinueDraftClaimParagraph() {
        String result = validateLocatorExists(LO_TXT_CONTINUE_DRAFT_CLAIM_PARAGRAPH, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

     /**
     * Validates if the paragraph for which insurance type you are claiming under is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String validateWhichInsuranceTypeParagraph() {
        String result = validateLocatorExists(LO_TXT_WHICH_INSURANCE_TYPE_PARAGRAPH, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

     /**
     * Validates if the paragraph for the credit card insurance is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String validateCreditCardInsuranceParagraph() {
        String result = validateLocatorExists(LO_TXT_CREDIT_CARD_INSURANCE_PARAGRAPH, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if the paragraph for the purchased insurance is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String validatePurchasedInsuranceParagraph() {
        String result = validateLocatorExists(LO_TXT_PURCHASED_INSURANCE_PARAGRAPH, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

     /**
     * Validates if the copy right notice is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String validateCopyRightNotice() {
        String result = validateLocatorExists(LO_TXT_COPY_RIGHT_NOTICE, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Verify that the purchased insurance option displays.
     * 
     * @param purchased_insurance the value that we expect in CAD.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String verifyPurchasedInsuranceOption(String purchased_insurance) {
        String result = validateWithinLocatorText(LO_TXT_PURCHASED_INSURNCE,purchased_insurance,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if 'Continue Draft Claim' exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateContinueDraftClaim() {
        String result = validateLocatorExists(LO_BUT_CONTINUE_DRAFT_CLAIM, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if 'Need Help?' exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateNeedHelp() {
        String result = validateLocatorExists(LO_BUT_NEED_HELP, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if 'Help Centre' exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateHelpCentre() {
        String result = validateLocatorExists(LO_BUT_HELP_CENTRE, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result; 
    }

    /**
     * Validates if 'Switch Language' exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateSwitchLanguage() {
        String result = validateLocatorExists(LO_BUT_SWITCH_LANGUAGE, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if 'Privacy Statement' exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validatePrivacyStatement() {
        String result = validateLocatorExists(LO_BUT_PRIVACY_STATEMENT, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if 'Conditions of Use' exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateConditionsOfUse() {
        String result = validateLocatorExists(LO_BUT_CONDITIONS_OF_USE, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if 'Which insurance type are you claiming under?' exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateWhichInsuranceType() {
        String result = validateLocatorExists(LO_TXT_WHICH_INSURANCE_TYPE, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if 'Group Insurance' exists.
     * 
     * @return
     */
    public String validateGroupInsurance() {
        String result = validateLocatorExists(LO_BUT_GROUP_INSURANCE, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if 'Individual Insurance' exists. 
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateIndividualInsurance() {
        String result = validateLocatorExists(LO_BUT_INDIVIDUAL_INSURANCE, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if 'Individual Insurance' exists. LO_BUT_BOUGHT_INSURANCE
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validatePuchasedInsurance() {
        String result = validateLocatorExists(LO_BUT_PURCHASED_INSURANCE, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Selects an insurance type of Individual.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String selectIndividualInsurance() {
        String result = clickLocator(LO_BUT_INDIVIDUAL_INSURANCE, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if 'Purchased Insurance' exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validatePurchasedInsurance() {
        String result = validateLocatorExists(LO_BUT_PURCHASED_INSURANCE, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Selects purchased Insurance type.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String selectPurchasedInsurance() {
        String result = clickLocator(LO_BUT_PURCHASED_INSURANCE, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if 'Credit Card Insurance' exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateCreditCardInsurance() {
        String result = validateLocatorExists(LO_BUT_CREDIT_CARD_INSURANCE_NEW, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if 'Back' exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateBack() {
        String result = validateLocatorExists(LO_BUT_BACK, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Click "Back" button.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String clickBackButton() {
        String result = clickLocator(LO_BUT_BACK, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Selects an insurance type of Individual.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String selectIndividual() {
        String result = clickLocator(LO_BUT_INDIVIDUAL_INSURANCE, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Selects an insurance type of Group.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String selectGroup() {
        String result = clickLocator(LO_TXT_GROUP_INSURANCE_HEADING_CARD, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Selects an insurance type of Credit Card.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String selectCreditCardInsurance() {
        String result = clickLocator(LO_BUT_CREDIT_CARD_INSURANCE, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Selects an insurance type of Credit Card.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String selectCreditCardInsuranceBig() {
        String result = clickLocator(LO_BUT_CREDIT_CARD_INSURANCE_BIG, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

     /**
     * Selects an insurance type of Credit Card.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String selectCreditCardInsuranceNew() {
        String result = clickLocator(LO_BUT_CREDIT_CARD_INSURANCE_NEW, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Selects an insurance type of Credit Card.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String selectCreditCardCIBC() {
        String result = clickLocator(LO_BUT_CREDIT_CARD_CIBC, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Verify that text "Select your category type:" displays for that dropdown menu.
     * 
     * @param category_type the value that we expect in CAD.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String verifyCategoryTypeDropDownText(String category_type) {
        String result = validateWithinLocatorText(LO_TXT_CATEGORY_TYPE_DROP_DOWN,category_type,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Verify that text "Select your category type:" displays for that dropdown menu.
     * 
     * @param card_type the value that we expect in CAD.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String verifyCardTypeDropDownText(String card_type) {
        String result = validateWithinLocatorText(LO_TXT_CARD_TYPE_DROP_DOWN,card_type,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Select Credit Card Insurance Category Type.
     * 
     * @param categoryType The category type of the credit card insurance.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String selectCreditCardInsuranceCategoryType(String categoryType) {
        String result = setDropdownAppian(LO_LST_CREDIT_CARD_INSURANCE_CATEGORY_TYPE, categoryType, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Select Credit Card Insurance Category Type.
     * 
     * @param categoryType The category type of the credit card insurance.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String selectCreditCardInsuranceCategoryTypeNew(String categoryType) {
        String result = setDropdownAppian(LO_LST_CREDIT_CARD_INSURANCE_CATEGORY_TYPE_NEW, categoryType, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }


    // TODO: Refactor opportunity
    /**
     * Selects a category type for the credit card insurance.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String selectCategoryTypeOfCreditCard() {
        String dropdownValue = "Consumer Credit Card";
        String locator = LO_TXT_RETAIL_CREDIT_CARD;
        clickLocator(LO_TXT_RETAIL_CREDIT_CARD, FW_ConfigMgr.getDefaultTimeout());
        for (int i = 0; i < 2; i++) {
            typeOnKeyboard("ARROW_DOWN");
        }
        Boolean trueOrFalse = typeOnKeyboard("ENTER");
        if (trueOrFalse) {
            String result = "[Pass] - Selected dropdown '" + dropdownValue + "' from locator '" + locator + "'.";
            result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
            return result;
        }
        String result = "[Fail] - Dropdown '" + dropdownValue + "' does not exist for locator '" + locator + "'.";
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    // TODO Refactor opportunity
    /**
     * Selects a category type for the credit card insurance particulary for the TD platform.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String selectCategoryTypeOfCreditCardTD() {
        String dropdownValue = "Consumer Credit Card";
        String locator = LO_TXT_RETAIL_CREDIT_CARD;
        clickLocator(LO_TXT_RETAIL_CREDIT_CARD, FW_ConfigMgr.getDefaultTimeout());
        for (int i = 0; i < 1; i++) {
            typeOnKeyboard("ARROW_DOWN");
        }
        Boolean trueOrFalse = typeOnKeyboard("ENTER");
        if (trueOrFalse) {
            String result = "[Pass] - Selected dropdown '" + dropdownValue + "' from locator '" + locator + "'.";
            result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
            return result;
        }
        String result = "[Fail] - Dropdown '" + dropdownValue + "' does not exist for locator '" + locator + "'.";
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Select Credit Card Insurance Card Type.
     * 
     * @param cardType The card type of the credit card insurance.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String selectCreditCardInsuranceCardType(String cardType) {
        waitForDuration(7,"s",true);
        String result = setDropdownAppian(LO_LST_CREDIT_CARD_INSURNCE_CARD_TYPE, cardType, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    // TODO Refactor opportunity
    /**
     * Selects the card for the credit card insurance.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String selectCardType() {
        waitForDuration(5,"s",true);
        String dropdownValue = "Consumer Credit Card";
        String locator = LO_TXT_CARD_TYPE;
        clickLocator(LO_TXT_CARD_TYPE, FW_ConfigMgr.getDefaultTimeout());
        for (int i = 0; i < 8; i++) {
            typeOnKeyboard("ARROW_DOWN");
        }
        Boolean trueOrFalse = typeOnKeyboard("ENTER");
        if (trueOrFalse) {
            String result = "[Pass] - Selected dropdown '" + dropdownValue + "' from locator '" + locator + "'.";
            result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
            return result;
        }
        String result = "[Fail] - Dropdown '" + dropdownValue + "' does not exist for locator '" + locator + "'.";
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    // TODO Refactor opportunity`
    /**
     * Selects a category type for the credit card insurance particulary for the TD platform.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String selectCardTypeTD() {
        waitForDuration(5,"s",true);
        String dropdownValue = "Consumer Credit Card";
        String locator = LO_TXT_CARD_TYPE;
        clickLocator(LO_TXT_CARD_TYPE, FW_ConfigMgr.getDefaultTimeout());
        for (int i = 0; i < 1; i++) {
            typeOnKeyboard("ARROW_DOWN");
        }
        Boolean trueOrFalse = typeOnKeyboard("ENTER");
        if (trueOrFalse) {
            String result = "[Pass] - Selected dropdown '" + dropdownValue + "' from locator '" + locator + "'.";
            result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
            return result;
        }
        String result = "[Fail] - Dropdown '" + dropdownValue + "' does not exist for locator '" + locator + "'.";
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Clicks the continue button on the Insurance type page object.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String clickButtonContinue() {
        String result = clickLocator(LO_BUT_CONTINUE, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    } 

    /**
     * Validates if the insurance type is displayed.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateInsuranceType() {
        String result = validateLocatorExists(LO_TXT_TD_INSURANCE_TYPE_VERIFY, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

     /**
     * Select MBNA as the category Type.
     *
     * @param categoryType The country injury occerd in.
     * 
     * @return A string containing the result of the operation.
     */
    public String selectDestinationCity(String categoryType) {
        String result = setDropdownAppian(LO_TXT_RETAIL_CREDIT_CARD, categoryType, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); 
        return result;
    }

     /**
     * Select "MBNA Rewards Platinum Plus VISA" as the Card type
     * 
     * @param cardType The card type of the credit card insurance.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String selectCreditCardInsuranceCardTypeMBNA(String cardType) {
        String result = setDropdownAppian(LO_LST_CREDIT_CARD_INSURNCE_CARD_TYPE, cardType, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if "Group Insurance" option Displays
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateGroupeInsuranceOptionDisplays() {
        String result = validateLocatorExists(LO_TXT_GROUP_INSURANCE_OPTION, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

     /**
     * Validates if "Group Insurance" heading card Displays
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateGroupInsuranceHeadingCard() {
        String result = validateLocatorExists(LO_TXT_GROUP_INSURANCE_HEADING_CARD, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if "Group Insurance" option Displays
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateIndividualInsuranceOPtionDisplays() {
        String result = validateLocatorExists(LO_TXT_INDIVIDUAL_INSURANCE_OPTION, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if "which type of Insurance are you claiming for" exists
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateOnNewPage() {
        String result = validateLocatorExists(LO_TXT_WHICH_INSURANCE_TYPE_NEW, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if the claiming reason is displayed.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
   public String validateClaimingReason() {
       String result = validateLocatorExists(LO_TXT_CLAIMING_REASON, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
       result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
       return result;
   }

    /**
     * Validates if the emergency medical travel is displayed.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
   public String validateEmergencyMedicalTravel() {
       String result = validateLocatorExists(LO_TXT_EMERGENCY_MEDICAL_TRAVEL, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
       result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
       return result;
   }

   /**
    * Clicks on the 'Emergency Medical Travel' option.
    * @return A string including [PASS] or [FAIL] along with specific result details.
    */
   public String clickEmergencyMedicalTravel() {
       String result = clickLocator(LO_TXT_EMERGENCY_MEDICAL_TRAVEL, FW_ConfigMgr.getDefaultTimeout());
       result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
       return result;
   }

   
    /**
     * Validates if the students is displayed.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
   public String validateStudents() {
       String result = validateLocatorExists(LO_TXT_STUDENTS, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
       result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
       return result;
   }

    /**
     * Validates if the visitors to Canada is displayed.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateVisitorsToCanada() {
       String result = validateLocatorExists(LO_TXT_VISITORS_TO_CANADA, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
       result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
       return result;
    }

    /**
     * Validates if the expatriate is displayed.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
   public String validateExpatriate() {
       String result = validateLocatorExists(LO_TXT_EXPATRIATE, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
       result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
       return result;
   }

   /**
    * Validates if "Individual Insurance" heading card Displays
    *
    * @return A string including [PASS] or [FAIL] along with specific result details.
    */
    public String validateIndividualInsuranceHeadingCard() {
         String result = validateLocatorExists(LO_TXT_INDIVIDUAL_INSURANCE_HEADING_CARD, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
         result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
         return result;
    }
   }
