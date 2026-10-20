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
    private static final String LO_BUT_CONTINUE_DRAFT_CLAIM = "//span/strong[contains(text(),'CONTINUE DRAFT CLAIM')]";
    private static final String LO_TXT_WHICH_INSURANCE_TYPE_NZ = "//h2[contains(text(), 'WHICH INSURANCE TYPE ARE YOU CLAIMING UNDER?')]";
    private static final String LO_BUT_NEED_HELP = "//strong[contains(text(),'Need Help?')]";
    private static final String LO_BUT_PURCHASED_INSURANCE_NZ = "//span/strong[contains(text(), 'Purchased Insurance')]";
    private static final String LO_BUT_CREDIT_CARD_INSURANCE_NZ = "//span[strong[contains(text(), 'Credit Card Insurance')]]";
    private static final String LO_BUT_CONTINUE_NZ = "//span/span[contains(text(),'Continue')]";
    private static final String LO_LST_CREDIT_CARD_INSURNCE_CATEGORY_TYPE_NZ = "//div[span='Select your category type:']/following-sibling::div//div[@role='combobox']";
    private static final String LO_LST_CREDIT_CARD_INSURNCE_CARD_TYPE_NZ = "//div[span='Select your card type:']/following-sibling::div//div[@role='combobox']";
    private static final String LO_TXT_TD_INSURANCE_TYPE_VERIFY_NZ = "//h2[contains(text(), 'WHICH INSURANCE TYPE ARE YOU CLAIMING UNDER?')]";
    private static final String LO_TXT_CREDIT_CARD_INSURNCE_NZ = "//span/strong[contains(text(), 'Credit Card Insurance')]";
    private static final String LO_TXT_PURCHASED_INSURNCE_NZ = "//span/strong[contains(text(),'Purchased Insurance')]";
    private static final String LO_TXT_CATEGORY_TYPE_DROP_DOWN_NZ = "//div[span='Select your category type:']";
    private static final String LO_TXT_CARD_TYPE_DROP_DOWN_NZ = "(//div[span='Select your card type:'])[1]";
    private static final String LO_BUT_HELP_CENTRE = "//span[a[contains(text(), 'HELP CENTRE')]]";
    private static final String LO_BUT_SWITCH_LANGUAGE = "//strong[contains(text(),'Switch Language')]";
    private static final String LO_BUT_PRIVACY_STATEMENT = "//a[contains(text(),'Privacy Statement')]";
    private static final String LO_BUT_CONDITIONS_OF_USE = "//a[contains(text(),'Conditions of Use')]";
    private static final String LO_BUT_BACK = "//button[@type='button']//span//span[contains(text(),'Back')]"; // Had to use double span to isolate from accessibility
    

    private static final String LO_TXT_WHICH_INSURANCE_TYPE = "//h2[contains(text(), 'WHICH INSURANCE TYPE ARE YOU CLAIMING UNDER?')]";
    private static final String LO_TXT_WHICH_INSURANCE_TYPE_PARAGRAPH = "//p[contains(text(), 'To get started, please select your insurance type')]";
    private static final String LO_BUT_GROUP_INSURANCE = "//h3/span[contains(text(), 'Group Insurance')]";
    private static final String LO_BUT_INDIVIDUAL_INSURANCE = "//h3/span[contains(text(), 'Individual Insurance')]";
    private static final String LO_BUT_PURCHASED_INSURANCE = "//span/strong[contains(text(), 'Purchased Insurance')]";
    private static final String LO_BUT_CREDIT_CARD_INSURANCE = "//span[strong[contains(text(), 'Credit Card Insurance')]]";

    private static final String LO_BUT_CONTINUE = "//span/span[contains(text(),'Continue')]";
    private static final String LO_TXT_RETAIL_CREDIT_CARD = "//span[text()='--Select category type--']";
    private static final String LO_TXT_CARD_TYPE = "//span[text()='--Select card type--']";

    private static final String LO_LST_CREDIT_CARD_INSURNCE_CATEGORY_TYPE = "//div[span='Select your category type:']/following-sibling::div//div[@role='combobox']";
    private static final String LO_LST_CREDIT_CARD_INSURNCE_CARD_TYPE = "//div[span='Select your card type:']/following-sibling::div//div[@role='combobox']";
    private static final String LO_TXT_TD_INSURANCE_TYPE_VERIFY = "//h2[contains(text(), 'WHICH INSURANCE TYPE ARE YOU CLAIMING UNDER?')]";
    private static final String LO_TXT_CREDIT_CARD_INSURNCE = "//span/strong[contains(text(), 'Credit Card Insurance')]";
    private static final String LO_HOME_PAGE_VERIFY_TRAVEL_CLAIM_CENTER = "//h1[contains(text(), 'Welcome to your Travel  Claim Centre')]";
    private static final String LO_TXT_PURCHASED_INSURNCE = "//span/strong[contains(text(),'Purchased Insurance')]";
    private static final String LO_TXT_CATEGORY_TYPE_DROP_DOWN = "//div[span='Select your category type:']";
    private static final String LO_TXT_CARD_TYPE_DROP_DOWN = "(//div[span='Select your card type:'])[1]";
    private static final String LO_TXT_GROUP_INSURANCE_OPTION = "//h3/span[contains(text(),'Group Insurance')]";
    private static final String LO_TXT_INDIVIDUAL_INSURANCE_OPTION = "//h3/span[contains(text(),'Individual Insurance')]";
    private static final String LO_LNK_FRENCH_BUTTON = "//div[p[span[a[contains(text(), 'FRANÇAIS')]]]]";
    private static final String LO_IMG_GEM_TOP_LOGO = "//a//img[@src='https://geihpvqvwebgencacn1.blob.core.windows.net/appian-portal/logo_header_en_GEM.png' or @src='https://geihpvtvwebgencacn1.blob.core.windows.net/appian-portal/logo_header_en_GEM.png']";
    private static final String LO_IMG_GEM_TOP_LOGO_BCAA = "//a//img[@src='https://geihpvqvwebgencacn1.blob.core.windows.net/appian-portal/logo_header_en_BCAA.png' or @src='https://geihpvtvwebgencacn1.blob.core.windows.net/appian-portal/logo_header_en_BCAA.png']";
    private static final String LO_TXT_CLAIM_OPENING_HEADING = "//h1[contains(text(), 'Claim Opening')]";
    private static final String LO_TXT_HERE_TO_HELP_HEADING = "//p[span[span[contains(text(), 'We are here')]]/following-sibling::span[span[text()='to' and strong[contains(text(), 'help')]]]]";
    private static final String LO_TXT_CONTINUE_DRAFT_CLAIM_PARAGRAPH = "//p[contains(text(), \"Your claim was already started and you'd like to continue filing it?\")]";
    private static final String LO_TXT_CREDIT_CARD_INSURANCE_PARAGRAPH = "//span[contains(text(),'Insurance offered through your credit card.')]";
    private static final String LO_TXT_PURCHASED_INSURANCE_PARAGRAPH = "//span[contains(text(),'Insurance purchased directly from an insurance provider.')]";
    private static final String LO_TXT_COPY_RIGHT_NOTICE = "//div[p[text()='2025' and text()='Global Excel Management Inc.' and text()='All rights reserved.']]";
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
    private static final String LO_IMG_TOP_LOGO_LIGHT_ZURICH = "//a//img[@src='https://geihpvqvwebgencacn1.blob.core.windows.net/appian-portal/logo_header_en_Zurich.png']";
    private static final String LO_IMG_HERE_TO_HELP_ASSISTANCE_ICON = "//div[img[@src='https://portal-qa.globalexcel.com/portal-2-0/content/ww0ECQMCEFNwIfvmr-0B0mEBmR9LtFRquOPlG7X4IDEM-mqlcYwbP4ZQWlZBnXojnKQ-iAphQwOgwPyLH-bHohyrG5J3A49e95ifBhIMcqJ1zzWYFIwhZH8Pt6KZ0iPdNm7OfaiOYKxita2In3DFjlXe']]";
    private static final String LO_RAD_NO_PROVIDE_CLAIM_NUMBER_NZ = "//label[contains(text(), 'No')]";
    private static final String LO_EDT_REASON_FOR_LOSS_NZ = "//div[span='Reason for Loss: ']/following-sibling::div//div[@role='combobox']";
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
     * Validates if current webpage is loaded and correct.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateOnPage_NZ() {
        String result = validateLocatorExists(LO_TXT_WHICH_INSURANCE_TYPE_NZ, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
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
    public String verifyCreditCardInsuranceOption_NZ(String credit_card_insurance) {
        String result = validateWithinLocatorText(LO_TXT_CREDIT_CARD_INSURNCE_NZ,credit_card_insurance,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
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
    public String verifyPurchasedInsuranceOption_NZ(String purchased_insurance) {
        String result = validateWithinLocatorText(LO_TXT_PURCHASED_INSURNCE_NZ,purchased_insurance,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    /**
     * Validates if 'Help Centre' exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateHelpCentre_NZ() {
        String result = validateLocatorExists(LO_BUT_HELP_CENTRE, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result; 
    }
    /**
     * Validates if 'Privacy Statement' exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validatePrivacyStatement_NZ() {
        String result = validateLocatorExists(LO_BUT_PRIVACY_STATEMENT, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if 'Conditions of Use' exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateConditionsOfUse_NZ() {
        String result = validateLocatorExists(LO_BUT_CONDITIONS_OF_USE, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if 'Which insurance type are you claiming under?' exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateWhichInsuranceType_NZ() {
        String result = validateLocatorExists(LO_TXT_WHICH_INSURANCE_TYPE_NZ, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    /**
     * Validates if 'Purchased Insurance' exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validatePurchasedInsurance_NZ() {
        String result = validateLocatorExists(LO_BUT_PURCHASED_INSURANCE_NZ, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Selects purchased Insurance type.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String selectPurchasedInsurance_NZ() {
        String result = clickLocator(LO_BUT_PURCHASED_INSURANCE_NZ, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if 'Back' exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateBack_NZ() {
        String result = validateLocatorExists(LO_BUT_BACK, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Click "Back" button.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String clickBackButton_NZ() {
        String result = clickLocator(LO_BUT_BACK, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    /**
     * Selects an insurance type of Credit Card.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String selectCreditCardInsurance_NZ() {
        String result = clickLocator(LO_BUT_CREDIT_CARD_INSURANCE_NZ, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String scrollTop3_NZ() {
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
    public String verifyCategoryTypeDropDownText_NZ(String category_type) {
        String result = validateWithinLocatorText(LO_TXT_CATEGORY_TYPE_DROP_DOWN_NZ,category_type,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
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
    public String verifyCardTypeDropDownText_NZ(String card_type) {
        String result = validateWithinLocatorText(LO_TXT_CARD_TYPE_DROP_DOWN_NZ,card_type,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
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
    public String selectCreditCardInsuranceCategoryType_NZ(String categoryType) {
        String result = setDropdownAppian(LO_LST_CREDIT_CARD_INSURNCE_CATEGORY_TYPE_NZ, categoryType, FW_ConfigMgr.getDefaultTimeout());
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
    public String selectCreditCardInsuranceCardType_NZ(String cardType) {
        String result = setDropdownAppian(LO_LST_CREDIT_CARD_INSURNCE_CARD_TYPE_NZ, cardType, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    /**
     * Clicks the continue button on the Insurance type page object.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String clickButtonContinue_NZ() {
        String result = clickLocator(LO_BUT_CONTINUE_NZ, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    } 

    public String applyWait_NZ() {
        waitForDuration(3, "s", true);
        String result = "[Pass] - Wait applied.";
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if the insurance type is displayed.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateInsuranceType_NZ() {
        String result = validateLocatorExists(LO_TXT_TD_INSURANCE_TYPE_VERIFY_NZ, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    /**
     * Select "MBNA Rewards Platinum Plus VISA" as the Card type
     * 
     * @param cardType The card type of the credit card insurance.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String selectCreditCardInsuranceCardTypeMBNA_NZ(String cardType) {
        String result = setDropdownAppian(LO_LST_CREDIT_CARD_INSURNCE_CARD_TYPE_NZ, cardType, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    /**
     * Validates if Frech link with its globe icon exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateFrenchButton_NZ() {
        String result = validateLocatorExists(LO_LNK_FRENCH_BUTTON, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result; 
    }
    /**
     * Validates if the 'Claim opening' heading is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String validateClaimOpeningHeading_NZ() {
        String result = validateLocatorExists(LO_TXT_CLAIM_OPENING_HEADING, FW_ConfigMgr.getDefaultTimeout(),
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
    public String validateWhichInsuranceTypeParagraph_NZ() {
        String result = validateLocatorExists(LO_TXT_WHICH_INSURANCE_TYPE_PARAGRAPH, FW_ConfigMgr.getDefaultTimeout(),
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
    public String validatePurchasedInsuranceParagraph_NZ() {
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
    public String validateCopyRightNotice_NZ() {
        String result = validateLocatorExists(LO_TXT_COPY_RIGHT_NOTICE, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String countItemsInList_NZ(String locator, String expectedString, int expectedValue) {
        waitForDuration(5, "s", false); // Wait to perform next check
        String result = countDropdownAppian(locator,expectedString,expectedValue,10);
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

    public String validateOnPageTravelClaimCenter() {
        // waitForDuration(5, "s", false); // Wait to perform next check
        String result = validateLocatorExists(LO_HOME_PAGE_VERIFY_TRAVEL_CLAIM_CENTER, FW_ConfigMgr.getDefaultTimeout(),
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
        String result = validateLocatorExists(LO_BUT_CREDIT_CARD_INSURANCE, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
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
        String result = clickLocator(LO_BUT_GROUP_INSURANCE, FW_ConfigMgr.getDefaultTimeout());
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

    public String scrollTop3() {
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
        String result = setDropdownAppian(LO_LST_CREDIT_CARD_INSURNCE_CATEGORY_TYPE, categoryType, FW_ConfigMgr.getDefaultTimeout());
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

    public String applyWait() {
        waitForDuration(5, "s", true);
        String result = "[Pass] - Wait applied.";
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
    public String validateGem_Top_Left_Logo_Intact() {
        String result = validateLocatorExists(LO_IMG_GEM_TOP_LOGO_INTACT, FW_ConfigMgr.getDefaultTimeout(),
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
    public String validateGem_Top_Left_Logo_BCAA() {
        String result = validateLocatorExists(LO_IMG_GEM_TOP_LOGO_BCAA, FW_ConfigMgr.getDefaultTimeout(),
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

    public String validateTop_Left_Logo_Light_Zurich() {
        String result = validateLocatorExists(LO_IMG_TOP_LOGO_LIGHT_ZURICH, FW_ConfigMgr.getDefaultTimeout(),
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
    public String validateGem_Top_Left_Logo_Manulife() {
        String result = validateLocatorExists(LO_IMG_GEM_TOP_LOGO_MANULIFE, FW_ConfigMgr.getDefaultTimeout(),
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
     * Validates if the paragraph for the purchased insurance is present.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String validateGroupInsuranceParagraph() {
        String result = validateLocatorExists(LO_TXT_GROUP_INSURANCE_PARAGRAPH, FW_ConfigMgr.getDefaultTimeout(),
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
    public String validateIndividualInsuranceParagraph() {
        String result = validateLocatorExists(LO_TXT_INDIVIDUAL_INSURANCE_PARAGRAPH, FW_ConfigMgr.getDefaultTimeout(),
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

    public String validateHereToHelpIcon() {
        String result = validateLocatorExists(LO_IMG_HERE_TO_HELP_ASSISTANCE_ICON, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Consoles the array of list elements in the dropdown, including the size, which accounts for the default placeholder value (even though it's not part of the list).
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */

    public String checkItemsInList(String locator, int expectedCount) {
        waitForDuration(5, "s", false); // Wait to perform next check
        String result = getAllDropdownOptionsAsString(locator, 10,expectedCount);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String countItemsInList(String locator, String expectedString, int expectedValue) {
        waitForDuration(5, "s", false); // Wait to perform next check
        String result = countDropdownAppian(locator,expectedString,expectedValue,10);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String selectNoToSubmittingClaimToProvideClaimNumber_NZ() {
        String result = clickLocator(LO_RAD_NO_PROVIDE_CLAIM_NUMBER_NZ, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Selects 'Theft' from the dropdown menu for the reason for loss.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String selectReasonForLoss_NZ(String reason_for_loss) {
        String result = setDropdownAppian(LO_EDT_REASON_FOR_LOSS_NZ, reason_for_loss, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
}
