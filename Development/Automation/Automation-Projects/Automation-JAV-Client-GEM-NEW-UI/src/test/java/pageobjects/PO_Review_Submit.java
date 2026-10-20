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
public class PO_Review_Submit extends CU_Appian {

    // [Note: Automation Engineer, define the Page Object (PO) locators (LO) here.]
    private static final String LO_REVIEW_SUBMIT_PAGE_VERIFY = "//h2[contains(text(), 'REVIEW & SUBMIT CLAIM')]";
    private static final String LO_BUT_SAVE_DRAFT = "//button//span[contains(text(), 'Save as Draft')]";
    private static final String LO_CHK_AGREE_TO_ALL = "//label[@class='CheckboxGroup---choice_label']";
    private static final String LO_BUT_SUBMIT_CLAIM = "//span//span[contains(text(),'Submit Claim')]";
    private static final String LO_TXT_CLAIM_TYPE_STATUS_EMT = "//h3[contains(text(), 'TRAVEL STATUS')]";
    private static final String LO_TXT_CLAIM_TYPE_STATUS_EXPATRIATE = "//h3[contains(text(), 'EXPATRIATE ')]";
    private static final String LO_TXT_CLAIM_TYPE = "//div[span[contains(text(), 'Claim Type ')]]/following-sibling::div";
    private static final String LO_TXT_PROVINCE = "//div[span[contains(text(), 'Province')]]/following-sibling::div";
    private static final String LO_TXT_GE_CLAIM_NUMBER = "//div[span[contains(text(), 'Global Excel Claim Number')]]/following-sibling::div";
    private static final String LO_TXT_ABOUT_THE_INSURED_TITLE = "//h3[contains(text(), 'ABOUT THE INSURED')]";
    private static final String LO_TXT_INSURANCE_TYPE = "//div[span[contains(text(), 'Insurance Type')]]/following-sibling::div";
    private static final String LO_TXT_POLICY_NUMBER_OR_CERTIFICATE_ID = "//div[span[contains(text(), 'Policy Number/Certificate ID')]]/following-sibling::div";
    private static final String LO_TXT_EMPLOYER_NAMES = "//div[span[text()='Employer Name']]/following-sibling::div";
    private static final String LO_TXT_NAMES = "//div[span[contains(text(), 'Name')]]/following-sibling::div";
    private static final String LO_TXT_DOB = "//div[span[contains(text(), 'Date of Birth')]]/following-sibling::div";
    private static final String LO_TXT_PHONE_NUMBER = "//div[span[contains(text(), 'Phone Number')]]/following-sibling::div";
    private static final String LO_TXT_EMAIL = "//div[span[contains(text(), 'Email')]]/following-sibling::div";
    private static final String LO_TXT_LINE1_CITY_PROVINCE = "//div[span[contains(text(), 'Address')]]/following-sibling::div";
    private static final String LO_TXT_COUNTRY_POSTAL_CODE = "//div[span[contains(text(), 'Address')]]/following-sibling::div";
    private static final String LO_TXT_PROVINCIAL_HEALTH_CARD_NUMBER = "//div[span[contains(text(), 'Provincial Health Card Number')]]/following-sibling::div";

    /**
     * Define the Page Object (PO) constructor.
     * @param driver The WebDriver object passed from the test method.
     */
    // [Note: Automation Engineer, rename this Page Object (PO) class to match the filename.]
    public PO_Review_Submit(WebDriver driver) {
        super(driver);
    }

    /**
     * Validates if current webpage is loaded and correct.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateOnPage() {
        String result = validateLocatorExists(LO_REVIEW_SUBMIT_PAGE_VERIFY, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String validateAboutTheInsuredTitle() {
        String result = validateLocatorExists(LO_TXT_ABOUT_THE_INSURED_TITLE, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String validateClaimTypeStatus(String status) {
        clickLocator("//h1[contains(text(), 'Claim Opening')]", FW_ConfigMgr.getDefaultTimeout());
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
        String result = validateWithinLocatorText(LO_TXT_CLAIM_TYPE_STATUS_EMT,status,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String validateClaimTypeStatusExpatriate(String status) {
        String result = validateWithinLocatorText(LO_TXT_CLAIM_TYPE_STATUS_EXPATRIATE,status,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String validateClaimType(String claimType) {
        String result = validateWithinLocatorText(LO_TXT_CLAIM_TYPE,claimType,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String validateProvince(String province) {
        String result = validateWithinLocatorText(LO_TXT_PROVINCE,province,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String validateGEClaimNumber(String geClaimNumber) {
        String result = validateWithinLocatorText(LO_TXT_GE_CLAIM_NUMBER,geClaimNumber,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String validateInsuranceType(String insurance_type) {
        String result = validateWithinLocatorText(LO_TXT_INSURANCE_TYPE,insurance_type,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String validatePolicyNumberOrCertificateID(String insurance_type) {
        String result = validateWithinLocatorText(LO_TXT_POLICY_NUMBER_OR_CERTIFICATE_ID,insurance_type,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String validateEmployerNames(String employer_names) {
        String result = validateWithinLocatorText(LO_TXT_EMPLOYER_NAMES,employer_names,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String validateNames(String insurance_type) {
        String result = validateWithinLocatorText(LO_TXT_NAMES,insurance_type,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String validateDOB(String insurance_type) {
        String result = validateWithinLocatorText(LO_TXT_DOB,insurance_type,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String validatePhoneNumber(String insurance_type) {
        String result = validateWithinLocatorText(LO_TXT_PHONE_NUMBER,insurance_type,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String validateEmail(String insurance_type) {
        String result = validateWithinLocatorText(LO_TXT_EMAIL,insurance_type,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String validateLine1CityProvince(String insurance_type) {
        String result = validateWithinLocatorText(LO_TXT_LINE1_CITY_PROVINCE,insurance_type,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String validateCountryPostalCode(String insurance_type) {
        String result = validateWithinLocatorText(LO_TXT_COUNTRY_POSTAL_CODE,insurance_type,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String validateProvincialHealthCardNumber(String insurance_type) {
        String result = validateWithinLocatorText(LO_TXT_PROVINCIAL_HEALTH_CARD_NUMBER,insurance_type,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Click "Save As Draft" button.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String clickSaveAsDraftButton() {
        String result = clickLocator(LO_BUT_SAVE_DRAFT, 30000);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
        
    }

    /**
     * Scrolls at a given locator.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String scrollTop() {
        String result = scrollToLocator(LO_REVIEW_SUBMIT_PAGE_VERIFY);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Click "I Agree to All" checkbox.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String clickAgreeToAllCheckbox() {
        String result = clickLocator(LO_CHK_AGREE_TO_ALL, 30000);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Click "Submit Claim" button.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String clickSubmitClaimButton() {
        String result = clickLocator(LO_BUT_SUBMIT_CLAIM, 30000);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
}
