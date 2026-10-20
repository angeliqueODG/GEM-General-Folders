package pageobjects;

// Import class packages for this Page Object (PO)
import org.openqa.selenium.WebDriver;

import customizations.automation.CU_Appian; // Customization for Appian and where FW_Page is extended

import framework.junit.FW_TestStep;
import framework.utilities.FW_ConfigMgr;
import framework.utilities.FW_DateTimeUtils;
import framework.utilities.FW_TestStepUtils;

public class PO_Insurance_Type extends CU_Appian {

    private static final String LO_BUT_CONTINUE_DRAFT_CLAIM = "//span/strong[contains(text(),'CONTINUE DRAFT CLAIM')]";
    private static final String LO_BUT_NEED_HELP = "//strong[contains(text(),'Need Help?')]";
    private static final String LO_BUT_HELP_CENTRE = "//p[span[@class='IconWidget---inLightBackground']/following-sibling::span[a[contains(text(), 'HELP CENTRE')]]]";
    private static final String LO_BUT_SWITCH_LANGUAGE = "//strong[contains(text(),'Switch Language')]";
    private static final String LO_BUT_PRIVACY_STATEMENT = "//strong[contains(text(),'Privacy Statement')]";
    private static final String LO_BUT_CONDITIONS_OF_USE = "//strong[contains(text(),'Conditions of Use')]";
    private static final String LO_BUT_BACK = "//button[@type='button']//span//span[contains(text(),'Back')]"; // Had to use double span to isolate from accessibility
    private static final String LO_TXT_WHICH_INSURANCE_TYPE = "//h2/span[contains(text(), 'Which insurance type are you claiming under?')]";
    private static final String LO_BUT_GROUP_INSURANCE = "//h3/span[contains(text(), 'Group Insurance')]";
    private static final String LO_BUT_INDIVIDUAL_INSURANCE = "//h3/span[contains(text(), 'Individual Insurance')]";
    private static final String LO_BUT_PURCHASED_INSURANCE = "//h3/span[contains(text(), 'Purchased Insurance')]";
    private static final String LO_BUT_CREDIT_CARD_INSURANCE = "//h3/span[contains(text(), 'Credit Card Insurance')]";
    private static final String LO_BUT_CONTINUE = "//span/span[contains(text(),'Continue')]";
    private static final String LO_TXT_RETAIL_CREDIT_CARD = "//span[text()='--Select category type--']";
    private static final String LO_TXT_CARD_TYPE = "//span[text()='--Select card type--']";
    private static final String LO_LST_CREDIT_CARD_INSURNCE_CATEGORY_TYPE = "//div[span='Select your category type:']/following-sibling::div//div[@role='combobox']";
    private static final String LO_LST_CREDIT_CARD_INSURNCE_CARD_TYPE = "//div[span='Select your card type:']/following-sibling::div//div[@role='combobox']";
    private static final String LO_TXT_TD_INSURANCE_TYPE_VERIFY = "//span[contains(text(),'Which insurance type are you claiming under?')]";
    private static final String LO_TXT_CREDIT_CARD_INSURNCE = "//h3/span[contains(text(), 'Credit Card Insurance')]";
    private static final String LO_TXT_PURCHASED_INSURNCE = "//h3/span[contains(text(),'Purchased Insurance')]";
    private static final String LO_TXT_CATEGORY_TYPE_DROP_DOWN = "//div[span='Select your category type:']";
    private static final String LO_TXT_CARD_TYPE_DROP_DOWN = "(//div[span='Select your card type:'])[1]";
    private static final String LO_TXT_GROUP_INSURANCE_OPTION = "//h3/span[contains(text(),'Group Insurance')]";
    private static final String LO_TXT_INDIVIDUAL_INSURANCE_OPTION = "//h3/span[contains(text(),'Individual Insurance')]";
    private static final String LO_LNK_FRENCH_BUTTON = "//p[span[a[span[@class='IconWidget---inLightBackground']/following-sibling::span[contains(text(), 'FRANÇAIS')]]]]";
    private static final String LO_IMG_GEM_TOP_LOGO = "//a//img[@src='https://geihpvqvwebgencacn1.blob.core.windows.net/appian-portal/logo_header_en_GEM.png' or @src='https://geihpvtvwebgencacn1.blob.core.windows.net/appian-portal/logo_header_en_GEM.png']";
    private static final String LO_IMG_GEM_TOP_LOGO_BCAA = "//a//img[@src='https://geihpvqvwebgencacn1.blob.core.windows.net/appian-portal/logo_header_en_BCAA.png' or @src='https://geihpvtvwebgencacn1.blob.core.windows.net/appian-portal/logo_header_en_BCAA.png']";
    private static final String LO_TXT_CLAIM_OPENING_HEADING = "//h1/span[contains(text(), 'Claim Opening')]";
    private static final String LO_TXT_HERE_TO_HELP_HEADING = "//p[span[span[contains(text(), 'We are here')]]/following-sibling::span[span[text()='to' and strong[contains(text(), 'help')]]]]";
    private static final String LO_TXT_CONTINUE_DRAFT_CLAIM_PARAGRAPH = "//p[contains(text(), \"Your claim was already started and you'd like to continue filing it?\")]";
    private static final String LO_TXT_WHICH_INSURANCE_TYPE_PARAGRAPH = "//p[contains(text(),'To get started, please select your insurance type.')]";
    private static final String LO_TXT_CREDIT_CARD_INSURANCE_PARAGRAPH = "//p[contains(text(),'Insurance offered through your credit card.')]";
    private static final String LO_TXT_PURCHASED_INSURANCE_PARAGRAPH = "//p[contains(text(),'Insurance purchased directly from an insurance provider.')]";
    private static final String LO_TXT_COPY_RIGHT_NOTICE = "//p[span[@class=\"IconWidget---inDarkBackground\"] and span[span=\"2025\"] and span[span=\"Global Excel Management Inc.\"]]";
    private static final String LO_IMG_GEM_TOP_LOGO_CIBC = "//a//img[@src='https://geihpvqvwebgencacn1.blob.core.windows.net/appian-portal/logo_header_en_CIBC.png' or @src='https://geihpvtvwebgencacn1.blob.core.windows.net/appian-portal/logo_header_en_CIBC.png']";
    private static final String LO_TXT_GROUP_INSURANCE_PARAGRAPH = "//p[contains(text(),'Insurance offered by your employer, organization or association.')]";
    private static final String LO_IMG_GEM_TOP_LOGO_INTACT = "//a//img[@src='https://geihpvqvwebgencacn1.blob.core.windows.net/appian-portal/logo_header_en_Intact.png' or @src='https://geihpvtvwebgencacn1.blob.core.windows.net/appian-portal/logo_header_en_Intact.png']";
    private static final String LO_LNK_HELP_CENTRE_TOP_DARK = "//p[span[a[(span/span[@class='IconWidget---inDarkBackground'][not(following-sibling::span)]) or (span[@class='IconWidget---inDarkBackground'] and text()='HELP CENTRE')]]]";
    private static final String LO_BUT_FRANÇAIS_DARK = "//p[span[a[(span[span[@class='IconWidget---inDarkBackground'] and span[contains(text(), 'FR')]]) or (span[@class='IconWidget---inDarkBackground'] and span[contains(text(), 'FRANÇAIS')])]]]";
    private static final String LO_IMG_GEM_TOP_LOGO_MANULIFE = "//a//img[@src='https://geihpvqvwebgencacn1.blob.core.windows.net/appian-portal/logo_header_en_Manulife.png'or @src='https://geihpvtvwebgencacn1.blob.core.windows.net/appian-portal/logo_header_en_Manulife.png']";
    private static final String LO_TXT_INDIVIDUAL_INSURANCE_PARAGRAPH = "//p[contains(text(),'Insurance purchased directly from an insurance provider.')]";
    private static final String LO_IMG_GEM_TOP_LOGO_MGB = "//a//img[@src='https://geihpvqvwebgencacn1.blob.core.windows.net/appian-portal/logo_header_en_ManulifeGroupBenefits.png' or @src='https://geihpvtvwebgencacn1.blob.core.windows.net/appian-portal/logo_header_en_ManulifeGroupBenefits.png']";
    private static final String LO_IMG_GEM_TOP_LOGO_ORION = "//a//img[@src='https://geihpvqvwebgencacn1.blob.core.windows.net/appian-portal/logo_header_en_Orion.png' or @src='https://geihpvtvwebgencacn1.blob.core.windows.net/appian-portal/logo_header_en_Orion.png']";
    private static final String LO_IMG_GEM_TOP_LOGO_SCOTIA = "//a//img[@src='https://geihpvqvwebgencacn1.blob.core.windows.net/appian-portal/logo_header_en_Scotiabank.png' or @src='https://geihpvtvwebgencacn1.blob.core.windows.net/appian-portal/logo_header_en_Scotiabank.png']";
    private static final String LO_IMG_GEM_TOP_LOGO_SUNLIFE = "//a//img[@src='https://geihpvqvwebgencacn1.blob.core.windows.net/appian-portal/logo_header_en_SunLife.png' or @src='https://geihpvtvwebgencacn1.blob.core.windows.net/appian-portal/logo_header_en_SunLife.png']";
    private static final String LO_IMG_GEM_TOP_LOGO_TD = "//a//img[@src='https://geihpvqvwebgencacn1.blob.core.windows.net/appian-portal/logo_header_en_TD.png' or @src='https://geihpvtvwebgencacn1.blob.core.windows.net/appian-portal/logo_header_en_TD.png']";
    
    /**
     * Define the Page Object (PO) constructor.
     * @param driver The WebDriver object passed from the test method.
     */
    public PO_Insurance_Type(WebDriver driver) {
        super(driver);
    }

    /**
     * Validates if current webpage is loaded and correct.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateOnPage() {
        String result = validateLocatorExists(LO_TXT_WHICH_INSURANCE_TYPE, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Verify that the credit card insurance option displays.
     * 
     * @param credit_card_insurance the value that we expect in CAD.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object verifyCreditCardInsuranceOption(String credit_card_insurance) {
        String result = validateWithinLocatorText(LO_TXT_CREDIT_CARD_INSURNCE,credit_card_insurance,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
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
    public Object validateHelpCentre() {
        String result = validateLocatorExists(LO_BUT_HELP_CENTRE, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj; 
    }

    /**
     * Validates if the Help Centre at top right is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateHelpCentreHeader_Dark() {
        String result = validateLocatorExists(LO_LNK_HELP_CENTRE_TOP_DARK, FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval());
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
    public Object validatePrivacyStatement() {
        String result = validateLocatorExists(LO_BUT_PRIVACY_STATEMENT, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if 'Conditions of Use' exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateConditionsOfUse() {
        String result = validateLocatorExists(LO_BUT_CONDITIONS_OF_USE, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if 'Which insurance type are you claiming under?' exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateWhichInsuranceType() {
        String result = validateLocatorExists(LO_TXT_WHICH_INSURANCE_TYPE, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if 'Group Insurance' exists.
     * 
     * @return
     */
    public Object validateGroupInsurance() {
        String result = validateLocatorExists(LO_BUT_GROUP_INSURANCE, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if 'Individual Insurance' exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateIndividualInsurance() {
        String result = validateLocatorExists(LO_BUT_INDIVIDUAL_INSURANCE, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
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
    public Object validatePurchasedInsurance() {
        String result = validateLocatorExists(LO_BUT_PURCHASED_INSURANCE, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Selects purchased Insurance type.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object selectPurchasedInsurance() {
        String result = clickLocator(LO_BUT_PURCHASED_INSURANCE, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if 'Credit Card Insurance' exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateCreditCardInsurance() {
        String result = validateLocatorExists(LO_BUT_CREDIT_CARD_INSURANCE, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if 'Back' exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateBack() {
        String result = validateLocatorExists(LO_BUT_BACK, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Click "Back" button.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object clickBackButton() {
        String result = clickLocator(LO_BUT_BACK, FW_ConfigMgr.getDefaultTimeout());
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
    public Object selectGroup() {
        String result = clickLocator(LO_BUT_GROUP_INSURANCE, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Selects an insurance type of Credit Card.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object selectCreditCardInsurance() {
        String result = clickLocator(LO_BUT_CREDIT_CARD_INSURANCE, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
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
    public Object selectCreditCardInsuranceCategoryType(String categoryType) {
        String result = setDropdownAppian(LO_LST_CREDIT_CARD_INSURNCE_CATEGORY_TYPE, categoryType, FW_ConfigMgr.getDefaultTimeout());
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
            FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
            return resultObj;
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
            FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
            return resultObj;
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
    public Object selectCreditCardInsuranceCardType(String cardType) {
        String result = setDropdownAppian(LO_LST_CREDIT_CARD_INSURNCE_CARD_TYPE, cardType, FW_ConfigMgr.getDefaultTimeout());
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
        FW_DateTimeUtils.waitForDuration(5,"s",true);
        String dropdownValue = "Consumer Credit Card";
        String locator = LO_TXT_CARD_TYPE;
        clickLocator(LO_TXT_CARD_TYPE, FW_ConfigMgr.getDefaultTimeout());
        for (int i = 0; i < 8; i++) {
            typeOnKeyboard("ARROW_DOWN");
        }
        Boolean trueOrFalse = typeOnKeyboard("ENTER");
        if (trueOrFalse) {
            String result = "[Pass] - Selected dropdown '" + dropdownValue + "' from locator '" + locator + "'.";
            FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
            return resultObj;
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
        FW_DateTimeUtils.waitForDuration(5,"s",true);
        String dropdownValue = "Consumer Credit Card";
        String locator = LO_TXT_CARD_TYPE;
        clickLocator(LO_TXT_CARD_TYPE, FW_ConfigMgr.getDefaultTimeout());
        for (int i = 0; i < 1; i++) {
            typeOnKeyboard("ARROW_DOWN");
        }
        Boolean trueOrFalse = typeOnKeyboard("ENTER");
        if (trueOrFalse) {
            String result = "[Pass] - Selected dropdown '" + dropdownValue + "' from locator '" + locator + "'.";
            FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
            return resultObj;
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
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
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
        String result = validateLocatorExists(LO_TXT_GROUP_INSURANCE_OPTION, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
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
    public Object validateFrenchButton() {
        String result = validateLocatorExists(LO_LNK_FRENCH_BUTTON, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj; 
    }

    /**
     * Validates if Gem top logo is present and it's a link.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateGem_Top_Left_Logo_CIBC() {
        String result = validateLocatorExists(LO_IMG_GEM_TOP_LOGO_CIBC, FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if Gem top logo is present and it's a link.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateGem_Top_Left_Logo() {
        String result = validateLocatorExists(LO_IMG_GEM_TOP_LOGO, FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if Gem top logo is present and it's a link.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateGem_Top_Left_Logo_Intact() {
        String result = validateLocatorExists(LO_IMG_GEM_TOP_LOGO_INTACT, FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Clicks the 'FRANÇAIS' button.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateFrancaisButton_Dark() {
        String result = validateLocatorExists(LO_BUT_FRANÇAIS_DARK, FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }


    /**
     * Validates if Gem top logo is present and it's a link.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateGem_Top_Left_Logo_BCAA() {
        String result = validateLocatorExists(LO_IMG_GEM_TOP_LOGO_BCAA, FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if the 'Claim opening' heading is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateClaimOpeningHeading() {
        String result = validateLocatorExists(LO_TXT_CLAIM_OPENING_HEADING, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if Gem top logo is present and it's a link.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateGem_Top_Left_Logo_TD() {
        String result = validateLocatorExists(LO_IMG_GEM_TOP_LOGO_TD, FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if Gem top logo is present and it's a link.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateGem_Top_Left_Logo_SunLife() {
        String result = validateLocatorExists(LO_IMG_GEM_TOP_LOGO_SUNLIFE, FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if Gem top logo is present and it's a link.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateGem_Top_Left_Logo_SCOTIA() {
        String result = validateLocatorExists(LO_IMG_GEM_TOP_LOGO_SCOTIA, FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if Gem top logo is present and it's a link.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateGem_Top_Left_Logo_ORION() {
        String result = validateLocatorExists(LO_IMG_GEM_TOP_LOGO_ORION, FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if Gem top logo is present and it's a link.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateGem_Top_Left_Logo_MGB() {
        String result = validateLocatorExists(LO_IMG_GEM_TOP_LOGO_MGB, FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if Gem top logo is present and it's a link.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateGem_Top_Left_Logo_Manulife() {
        String result = validateLocatorExists(LO_IMG_GEM_TOP_LOGO_MANULIFE, FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if the 'Here to help' heading is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateHereToHelpHeading() {
        String result = validateLocatorExists(LO_TXT_HERE_TO_HELP_HEADING, FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if the paragraph for continue draft claim is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateContinueDraftClaimParagraph() {
        String result = validateLocatorExists(LO_TXT_CONTINUE_DRAFT_CLAIM_PARAGRAPH, FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if the paragraph for which insurance type you are claiming under is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateWhichInsuranceTypeParagraph() {
        String result = validateLocatorExists(LO_TXT_WHICH_INSURANCE_TYPE_PARAGRAPH, FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if the paragraph for the credit card insurance is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateCreditCardInsuranceParagraph() {
        String result = validateLocatorExists(LO_TXT_CREDIT_CARD_INSURANCE_PARAGRAPH, FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if the paragraph for the purchased insurance is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validatePurchasedInsuranceParagraph() {
        String result = validateLocatorExists(LO_TXT_PURCHASED_INSURANCE_PARAGRAPH, FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if the paragraph for the purchased insurance is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateGroupInsuranceParagraph() {
        String result = validateLocatorExists(LO_TXT_GROUP_INSURANCE_PARAGRAPH, FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if the paragraph for the purchased insurance is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateIndividualInsuranceParagraph() {
        String result = validateLocatorExists(LO_TXT_INDIVIDUAL_INSURANCE_PARAGRAPH, FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if the copy right notice is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateCopyRightNotice() {
        String result = validateLocatorExists(LO_TXT_COPY_RIGHT_NOTICE, FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
}