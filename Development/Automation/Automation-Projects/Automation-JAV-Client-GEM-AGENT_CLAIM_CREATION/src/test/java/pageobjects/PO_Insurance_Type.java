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
public class PO_Insurance_Type extends CU_Appian {

    // [Note: Automation Engineer, define the Page Object (PO) locators (LO) here.]
    private static final String LO_BUT_CONTINUE_DRAFT_CLAIM = "//span/strong[contains(text(),'CONTINUE DRAFT CLAIM')]";
    private static final String LO_BUT_NEED_HELP = "//strong[contains(text(),'Need Help?')]";
    private static final String LO_BUT_HELP_CENTRE = "//a[contains(text(), 'HELP CENTRE')]";
    private static final String LO_BUT_SWITCH_LANGUAGE = "//strong[contains(text(),'Switch Language')]";
    private static final String LO_LNK_PRIVACY_STATEMENT = "//span[a[contains(text(), 'Privacy Statement')]]";
    private static final String LO_LNK_CONDITIONS_OF_USE = "//span[a[contains(text(), 'Conditions of Use')]]";
    private static final String LO_LNK_COMPLAINT_POLICY = "//span[a[contains(text(), 'Complaint Policy')]]";
    private static final String LO_BUT_BACK = "//button[@type='button']//span//span[contains(text(),'Back')]"; // Had to use double span to isolate from accessibility

    private static final String LO_TXT_WHICH_INSURANCE_TYPE = "//h2[contains(text(), 'WHICH INSURANCE TYPE ARE YOU CLAIMING UNDER?')]";
    private static final String LO_LNK_HELP_CENTRE_TOP = "//span[a[contains(text(), 'HELP CENTRE')]]";
    private static final String LO_BUT_GROUP_INSURANCE = "//span/strong[contains(text(), 'Group Insurance')]";
    private static final String LO_BUT_INDIVIDUAL_INSURANCE = "//span/strong[contains(text(), 'Individual Insurance')]";
    private static final String LO_BUT_PURCHASED_INSURANCE = "//span/strong[contains(text(), 'Purchased Insurance')]";
    private static final String LO_BUT_CREDIT_CARD_INSURANCE = "//span[strong[contains(text(), 'Credit Card Insurance')]]";

    private static final String LO_BUT_CONTINUE = "//span/span[contains(text(),'Continue')]";
    private static final String LO_TXT_RETAIL_CREDIT_CARD = "//span[text()='--Select category type--']";
    private static final String LO_TXT_CARD_TYPE = "//span[text()='--Select card type--']";
    private static final String LO_LST_CREDIT_CARD_INSURNCE_CATEGORY_TYPE = "//div[span='Select your category type:']/following-sibling::div//div[@role='combobox']";
    private static final String LO_LST_CREDIT_CARD_INSURNCE_CARD_TYPE = "//div[span='Select your card type:']/following-sibling::div//div[@role='combobox']";
    private static final String LO_TXT_TD_INSURANCE_TYPE_VERIFY = "//h2[contains(text(), 'WHICH INSURANCE TYPE ARE YOU CLAIMING UNDER?')]";
    private static final String LO_TXT_CREDIT_CARD_INSURNCE = "//span/strong[contains(text(), 'Credit Card Insurance')]";
    private static final String LO_TXT_PURCHASED_INSURNCE = "//span/strong[contains(text(),'Purchased Insurance')]";
    private static final String LO_TXT_CATEGORY_TYPE_DROP_DOWN = "//div[span='Select your category type:']";
    private static final String LO_TXT_CARD_TYPE_DROP_DOWN = "(//div[span='Select your card type:'])[1]";
    private static final String LO_TXT_INDIVIDUAL_INSURANCE_OPTION = "//span/strong[contains(text(),'Individual Insurance')]";
    private static final String LO_BUT_ENGLISH = "//div[p[span[a[text()='ENGLISH']]]]";
    private static final String LO_LNK_FRENCH_BUTTON = "//div[p[span[a[contains(text(), 'FRANÇAIS')]]]]";
    private static final String LO_IMG_GEM_TOP_LOGO = "//a//img[@src='https://geihpvqvwebgencacn1.blob.core.windows.net/appian-portal/logo_header_en_GEM.png' or @src='https://geihpvtvwebgencacn1.blob.core.windows.net/appian-portal/logo_header_en_GEM.png']";
    private static final String LO_IMG_GEM_TOP_LOGO_BCAA = "//a//img[@src='https://geihpvqvwebgencacn1.blob.core.windows.net/appian-portal/logo_header_en_BCAA.png' or @src='https://geihpvtvwebgencacn1.blob.core.windows.net/appian-portal/logo_header_en_BCAA.png']";
    private static final String LO_TXT_CLAIM_OPENING_HEADING = "//h1[contains(text(), 'Claim Opening')]";
    private static final String LO_TXT_HERE_TO_HELP_HEADING = "//p[span[span[contains(text(), 'We are here')]]/following-sibling::span[span[text()='to' and strong[contains(text(), 'help')]]]]";
    private static final String LO_TXT_CONTINUE_DRAFT_CLAIM_PARAGRAPH = "//p[contains(text(), \"Your claim was already started and you'd like to continue filing it?\")]";
    private static final String LO_TXT_WHICH_INSURANCE_TYPE_PARAGRAPH = "//p[contains(text(),'To get started, please select your insurance type.')]";
    private static final String LO_TXT_CREDIT_CARD_INSURANCE_PARAGRAPH = "//span[contains(text(),'Insurance offered through your credit card.')]";
    private static final String LO_TXT_PURCHASED_INSURANCE_PARAGRAPH = "//span[contains(text(),'Insurance purchased directly from an insurance provider.')]";
    private static final String LO_TXT_COPY_RIGHT_NOTICE = "//div[p[text()='2026' and text()='Global Excel Management Inc.' and text()='All rights reserved.']]";
    private static final String LO_IMG_GEM_TOP_LOGO_CIBC = "//a//img[@src='https://geihpvqvwebgencacn1.blob.core.windows.net/appian-portal/logo_header_en_CIBC.png' or @src='https://geihpvtvwebgencacn1.blob.core.windows.net/appian-portal/logo_header_en_CIBC.png']";
    private static final String LO_TXT_GROUP_INSURANCE_PARAGRAPH = "//span[contains(text(),'Insurance offered by your employer, organization or association.')]";
    private static final String LO_IMG_GEM_TOP_LOGO_INTACT = "//a//img[@src='https://geihpvqvwebgencacn1.blob.core.windows.net/appian-portal/logo_header_en_Intact.png' or @src='https://geihpvtvwebgencacn1.blob.core.windows.net/appian-portal/logo_header_en_Intact.png']";
    private static final String LO_LNK_HELP_CENTRE_TOP_DARK = "//p[span[a[(span/span[@class='IconWidget---inDarkBackground'][not(following-sibling::span)]) or (span[@class='IconWidget---inDarkBackground'] and text()='HELP CENTRE')]]]";
    private static final String LO_BUT_FRANÇAIS_DARK = "//p[span[a[(span[span[@class='IconWidget---inDarkBackground'] and span[contains(text(), 'FR')]]) or (span[@class='IconWidget---inDarkBackground'] and span[contains(text(), 'FRANÇAIS')])]]]";
    private static final String LO_IMG_GEM_TOP_LOGO_MANULIFE = "//a//img[@src='https://geihpvqvwebgencacn1.blob.core.windows.net/appian-portal/logo_header_en_Manulife.png'or @src='https://geihpvtvwebgencacn1.blob.core.windows.net/appian-portal/logo_header_en_Manulife.png']";
    private static final String LO_TXT_INDIVIDUAL_INSURANCE_PARAGRAPH = "//span[contains(text(),'Insurance purchased directly from an insurance provider.')]";
    private static final String LO_IMG_GEM_TOP_LOGO_MGB = "//a//img[@src='https://geihpvqvwebgencacn1.blob.core.windows.net/appian-portal/logo_header_en_ManulifeGroupBenefits.png' or @src='https://geihpvtvwebgencacn1.blob.core.windows.net/appian-portal/logo_header_en_ManulifeGroupBenefits.png']";
    private static final String LO_IMG_GEM_TOP_LOGO_ORION = "//a//img[@src='https://geihpvqvwebgencacn1.blob.core.windows.net/appian-portal/logo_header_en_Orion.png' or @src='https://geihpvtvwebgencacn1.blob.core.windows.net/appian-portal/logo_header_en_Orion.png']";
    private static final String LO_IMG_GEM_TOP_LOGO_SCOTIA = "//a//img[@src='https://geihpvqvwebgencacn1.blob.core.windows.net/appian-portal/logo_header_en_Scotiabank.png' or @src='https://geihpvtvwebgencacn1.blob.core.windows.net/appian-portal/logo_header_en_Scotiabank.png']";
    private static final String LO_IMG_GEM_TOP_LOGO_SUNLIFE = "//a//img[@src='https://geihpvqvwebgencacn1.blob.core.windows.net/appian-portal/logo_header_en_SunLife.png' or @src='https://geihpvtvwebgencacn1.blob.core.windows.net/appian-portal/logo_header_en_SunLife.png']";
    private static final String LO_IMG_GEM_TOP_LOGO_TD = "//a//img[@src='https://geihpvqvwebgencacn1.blob.core.windows.net/appian-portal/logo_header_en_TD.png' or @src='https://geihpvtvwebgencacn1.blob.core.windows.net/appian-portal/logo_header_en_TD.png']";
    private static final String LO_LNK_PRIVACY_STATEMENT_STRONG = "//strong[a[contains(text(), 'Privacy Statement')]]";
    private static final String LO_LNK_CONDITIONS_OF_USE_STRONG = "//strong[a[contains(text(), 'Conditions of Use')]]";
    private static final String LO_LNK_COMPLAINT_POLICY_STRONG = "//strong[a[contains(text(), 'Complaint Policy')]]";
    private static final String LO_LNK_PRIVACY_STATEMENT_ANCHOR_STRONG = "//a[strong[contains(text(), 'Privacy Statement')]]";
    private static final String LO_LNK_CONDITIONS_OF_USE_ANCHOR_STRONG = "//a[strong[contains(text(), 'Conditions of Use')]]";
    private static final String LO_LNK_COMPLAINT_POLICY_ANCHOR_STRONG = "//a[strong[contains(text(), 'Complaint Policy')]]";

    //--------------------------------------------------- FR locators ----------------------------------------------------------------------

    private static final String LO_TXT_WHICH_INSURANCE_TYPE_FR = "//h2[contains(text(), 'QUEL TYPE D'ASSURANCE RECLAMEZ-VOUS?')]";
    private static final String LO_BUT_CREDIT_CARD_INSURANCE_FR = "//span[strong[contains(text(), 'Assurance Carte de Crédit')]]";
    private static final String LO_LST_CREDIT_CARD_INSURNCE_CATEGORY_TYPE_FR = "";
     private static final String LO_LST_CREDIT_CARD_INSURNCE_CARD_TYPE_FR = "";
     private static final String LO_TXT_CREDIT_CARD_INSURNCE_FR = "";
     private static final String LO_BUT_PURCHASED_INSURANCE_FR = "";
     private static final String LO_TXT_CLAIM_OPENING_HEADING_FR = "";
     private static final String LO_LNK_HELP_CENTRE_TOP_DARK_FR = "";
     private static final String LO_LNK_FRENCH_BUTTON_FR = "";
     private static final String LO_TXT_WHICH_INSURANCE_TYPE_PARAGRAPH_FR = "";
     private static final String LO_TXT_CREDIT_CARD_INSURANCE_PARAGRAPH_FR = "";
     private static final String LO_LNK_PRIVACY_STATEMENT_FR = "";
     private static final String LO_LNK_CONDITIONS_OF_USE_FR = "";
     private static final String LO_LNK_COMPLAINT_POLICY_FR = "";
     private static final String LO_TXT_COPY_RIGHT_NOTICE_FR = "";
     private static final String LO_BUT_BACK_FR = "";
     private static final String LO_TXT_PURCHASED_INSURANCE_PARAGRAPH_FR = "";
      private static final String LO_BUT_GROUP_INSURANCE_FR = "";
      private static final String LO_TXT_GROUP_INSURANCE_PARAGRAPH_FR = "";
      private static final String LO_BUT_INDIVIDUAL_INSURANCE_FR = "";
      private static final String LO_TXT_INDIVIDUAL_INSURANCE_PARAGRAPH_FR = "";
      private static final String LO_LNK_PRIVACY_STATEMENT_ANCHOR_STRONG_FR = "";
      private static final String LO_LNK_COMPLAINT_POLICY_ANCHOR_STRONG_FR = "";
      private static final String LO_LNK_CONDITIONS_OF_USE_ANCHOR_STRONG_FR = "";
      private static final String LO_TXT_CATEGORY_TYPE_DROP_DOWN_FR = "";
      private static final String LO_TXT_CARD_TYPE_DROP_DOWN_FR = "";
      private static final String LO_BUT_CONTINUE_FR = "";
      private static final String LO_BUT_HELP_CENTRE_FR = "";
      private static final String LO_BUT_ENGLISH_FR = "//div[p[span[a[text()='FRANÇAIS']]]]";
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
    public Object validateOnPage(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_WHICH_INSURANCE_TYPE_FR : LO_TXT_WHICH_INSURANCE_TYPE;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    public Object clickHelpCentreLink() {
        waitForDuration(5, "s", false); // Wait to perform next check
        String result = clickLocator(LO_LNK_HELP_CENTRE_TOP, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Verify that the purchased insurance option displays.
     * 
     * @param purchased_insurance the value that we expect in CAD.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object verifyPurchasedInsuranceOption(String purchased_insurance) {
        String result = validateWithinLocatorText(LO_TXT_PURCHASED_INSURNCE,purchased_insurance,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if 'Continue Draft Claim' exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateContinueDraftClaim() {
        String result = validateLocatorExists(LO_BUT_CONTINUE_DRAFT_CLAIM, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if 'Need Help?' exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateNeedHelp() {
        String result = validateLocatorExists(LO_BUT_NEED_HELP, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if 'Help Centre' exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateHelpCentre(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_BUT_HELP_CENTRE_FR : LO_BUT_HELP_CENTRE;
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
     * Validates if 'Switch Language' exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateSwitchLanguage() {
        String result = validateLocatorExists(LO_BUT_SWITCH_LANGUAGE, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if 'Privacy Statement' exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validatePrivacyStatement(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_LNK_PRIVACY_STATEMENT_FR : LO_LNK_PRIVACY_STATEMENT;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if 'Conditions of Use' exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateConditionsOfUse(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_LNK_CONDITIONS_OF_USE_FR : LO_LNK_CONDITIONS_OF_USE;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    public Object validateComplaintPolicy(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_LNK_COMPLAINT_POLICY_FR : LO_LNK_COMPLAINT_POLICY;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if 'Which insurance type are you claiming under?' exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateWhichInsuranceType(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_WHICH_INSURANCE_TYPE_FR : LO_TXT_WHICH_INSURANCE_TYPE;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if 'Group Insurance' exists.
     * 
     * @return
     */
    public Object validateGroupInsurance(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_BUT_GROUP_INSURANCE_FR : LO_BUT_GROUP_INSURANCE;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if 'Individual Insurance' exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateIndividualInsurance(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_BUT_INDIVIDUAL_INSURANCE_FR : LO_BUT_INDIVIDUAL_INSURANCE;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Selects an insurance type of Individual.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object selectIndividualInsurance() {
        String result = clickLocator(LO_BUT_INDIVIDUAL_INSURANCE, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if 'Purchased Insurance' exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validatePurchasedInsurance(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_BUT_PURCHASED_INSURANCE_FR : LO_BUT_PURCHASED_INSURANCE;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Selects purchased Insurance type.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object selectPurchasedInsurance(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_BUT_PURCHASED_INSURANCE_FR : LO_BUT_PURCHASED_INSURANCE;
        String result = clickLocator(locator, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if 'Credit Card Insurance' exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateCreditCardInsurance(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_BUT_CREDIT_CARD_INSURANCE_FR : LO_BUT_CREDIT_CARD_INSURANCE;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if 'Back' exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateBack(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_BUT_BACK_FR : LO_BUT_BACK;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Click "Back" button.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object clickBackButton(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_BUT_BACK_FR : LO_BUT_BACK;
        String result = clickLocator(locator, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Selects an insurance type of Individual.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object selectIndividual() {
        String result = clickLocator(LO_BUT_INDIVIDUAL_INSURANCE, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Selects an insurance type of Group.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object selectGroup(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_BUT_GROUP_INSURANCE_FR : LO_BUT_GROUP_INSURANCE;
        String result = clickLocator(locator, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Selects an insurance type of Credit Card.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object selectCreditCardInsurance(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_BUT_CREDIT_CARD_INSURANCE_FR : LO_BUT_CREDIT_CARD_INSURANCE;
        String result = clickLocator(locator, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object scrollTop3() {
        typeOnKeyboard("ARROW_UP");
        typeOnKeyboard("ARROW_UP");
        typeOnKeyboard("ARROW_UP");
        typeOnKeyboard("ARROW_UP");
        typeOnKeyboard("ARROW_UP");
        typeOnKeyboard("ARROW_UP");
        typeOnKeyboard("ARROW_UP");
        typeOnKeyboard("ARROW_UP");
        typeOnKeyboard("ARROW_UP");
        typeOnKeyboard("ARROW_UP");
        typeOnKeyboard("ARROW_UP");
        typeOnKeyboard("ARROW_UP");
        //String result = scrollToLocator(LO_TXT_WHICH_INSURANCE_TYPE);
        //result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        //return result;
        return "[Pass] scrolled to top of the page.";
    }

    /**
     * Verify that text "Select your category type:" displays for that dropdown menu.
     * 
     * @param category_type the value that we expect in CAD.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object verifyCategoryTypeDropDownText(String category_type) {
        String result = validateWithinLocatorText(LO_TXT_CATEGORY_TYPE_DROP_DOWN,category_type,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Verify that text "Select your category type:" displays for that dropdown menu.
     * 
     * @param card_type the value that we expect in CAD.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object verifyCardTypeDropDownText(String card_type) {
        String result = validateWithinLocatorText(LO_TXT_CARD_TYPE_DROP_DOWN,card_type,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Select Credit Card Insurance Category Type.
     * 
     * @param categoryType The category type of the credit card insurance.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object selectCreditCardInsuranceCategoryType(String language, String categoryType) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_LST_CREDIT_CARD_INSURNCE_CATEGORY_TYPE_FR : LO_LST_CREDIT_CARD_INSURNCE_CATEGORY_TYPE;
        String result = setDropdownAppian(locator, categoryType, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }


    // TODO: Refactor opportunity
    /**
     * Selects a category type for the credit card insurance.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object selectCategoryTypeOfCreditCard() {
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
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    // TODO Refactor opportunity
    /**
     * Selects a category type for the credit card insurance particulary for the TD platform.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object selectCategoryTypeOfCreditCardTD() {
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
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Select Credit Card Insurance Card Type.
     * 
     * @param cardType The card type of the credit card insurance.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object selectCreditCardInsuranceCardType(String language, String cardType) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_LST_CREDIT_CARD_INSURNCE_CARD_TYPE_FR : LO_LST_CREDIT_CARD_INSURNCE_CARD_TYPE;
        String result = setDropdownAppian(locator, cardType, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    // TODO Refactor opportunity
    /**
     * Selects the card for the credit card insurance.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object selectCardType() {
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
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    // TODO Refactor opportunity`
    /**
     * Selects a category type for the credit card insurance particulary for the TD platform.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object selectCardTypeTD() {
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
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Clicks the continue button on the Insurance type page object.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object clickButtonContinue() {
        String result = clickLocator(LO_BUT_CONTINUE, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    } 

    public Object applyWait() {
        waitForDuration(3, "s", true);
        String result = "[Pass] - Wait applied.";
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if the insurance type is displayed.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateInsuranceType() {
        String result = validateLocatorExists(LO_TXT_TD_INSURANCE_TYPE_VERIFY, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

     /**
     * Select MBNA as the category Type.
     *
     * @param categoryType The country injury occerd in.
     * 
     * @return A string containing the result of the operation.
     */
    public Object selectDestinationCity(String categoryType) {
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
    public Object selectCreditCardInsuranceCardTypeMBNA(String cardType) {
        String result = setDropdownAppian(LO_LST_CREDIT_CARD_INSURNCE_CARD_TYPE, cardType, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if "Group Insurance" option Displays
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateGroupeInsuranceOptionDisplays() {
        String result = validateLocatorExists(LO_BUT_GROUP_INSURANCE, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if "Group Insurance" option Displays
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateIndividualInsuranceOPtionDisplays() {
        String result = validateLocatorExists(LO_TXT_INDIVIDUAL_INSURANCE_OPTION, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if Frech link with its globe icon exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateFrenchButton(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_BUT_ENGLISH_FR : LO_BUT_ENGLISH;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
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
    public Object validateGem_Top_Left_Logo_Intact() {
        String result = validateLocatorExists(LO_IMG_GEM_TOP_LOGO_INTACT, FW_ConfigMgr.getDefaultTimeout(),
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
    public Object validateGem_Top_Left_Logo_BCAA() {
        String result = validateLocatorExists(LO_IMG_GEM_TOP_LOGO_BCAA, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if the 'Claim opening' heading is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object validateClaimOpeningHeading(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_CLAIM_OPENING_HEADING_FR : LO_TXT_CLAIM_OPENING_HEADING;
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
     * Validates if the 'Here to help' heading is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object validateHereToHelpHeading() {
        String result = validateLocatorExists(LO_TXT_HERE_TO_HELP_HEADING, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if the paragraph for continue draft claim is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object validateContinueDraftClaimParagraph() {
        String result = validateLocatorExists(LO_TXT_CONTINUE_DRAFT_CLAIM_PARAGRAPH, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if the paragraph for which insurance type you are claiming under is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object validateWhichInsuranceTypeParagraph(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_WHICH_INSURANCE_TYPE_PARAGRAPH_FR : LO_TXT_WHICH_INSURANCE_TYPE_PARAGRAPH;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if the paragraph for the credit card insurance is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object validateCreditCardInsuranceParagraph(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_CREDIT_CARD_INSURANCE_PARAGRAPH_FR : LO_TXT_CREDIT_CARD_INSURANCE_PARAGRAPH;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if the paragraph for the purchased insurance is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object validatePurchasedInsuranceParagraph(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_PURCHASED_INSURANCE_PARAGRAPH_FR : LO_TXT_PURCHASED_INSURANCE_PARAGRAPH;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if the paragraph for the purchased insurance is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object validateGroupInsuranceParagraph(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_GROUP_INSURANCE_PARAGRAPH_FR : LO_TXT_GROUP_INSURANCE_PARAGRAPH;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if the paragraph for the purchased insurance is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object validateIndividualInsuranceParagraph() {
        String result = validateLocatorExists(LO_TXT_INDIVIDUAL_INSURANCE_PARAGRAPH, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if the copy right notice is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object validateCopyRightNotice(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_COPY_RIGHT_NOTICE_FR : LO_TXT_COPY_RIGHT_NOTICE;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Consoles the array of list elements in the dropdown, including the size, which accounts for the default placeholder value (even though it's not part of the list).
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */

    public Object checkItemsInList(String locator, int expectedCount) {
        waitForDuration(5, "s", false); // Wait to perform next check
        String result = getAllDropdownOptionsAsString(locator, 10,expectedCount);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object countItemsInList(String locator, String expectedString, int expectedValue) {
        waitForDuration(5, "s", false); // Wait to perform next check
        String result = countDropdownAppian(locator,expectedString,expectedValue,10);
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

    public Object validateFooterPrivacyStatementAnchorStrong() {
        String result = validateLocatorExists(LO_LNK_PRIVACY_STATEMENT_ANCHOR_STRONG, FW_ConfigMgr.getDefaultTimeout(),
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
    public Object validateFooterConditionsOfUseAnchorStrong() {
        String result = validateLocatorExists(LO_LNK_CONDITIONS_OF_USE_ANCHOR_STRONG, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    public Object validateFooterComplaintPolicyAnchorStrong() {
        String result = validateLocatorExists(LO_LNK_COMPLAINT_POLICY_ANCHOR_STRONG, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
}
