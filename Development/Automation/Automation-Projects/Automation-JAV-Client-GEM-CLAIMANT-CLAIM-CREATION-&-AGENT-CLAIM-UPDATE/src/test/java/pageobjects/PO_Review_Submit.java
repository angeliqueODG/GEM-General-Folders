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
public class PO_Review_Submit extends CU_Appian {

    // [Note: Automation Engineer, define the Page Object (PO) locators (LO) here.]
    private static final String LO_REVIEW_SUBMIT_PAGE_VERIFY = "//h2[contains(text(), 'REVIEW & SUBMIT CLAIM')]";
    //private static final String LO_BUT_SAVE_DRAFT = "//button//span[contains(text(), 'Save as Draft')]";
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
    public Object validateOnPage() {
        String result = validateLocatorExists(LO_REVIEW_SUBMIT_PAGE_VERIFY, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object validateAboutTheInsuredTitle() {
        String result = validateLocatorExists(LO_TXT_ABOUT_THE_INSURED_TITLE, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object validateClaimTypeStatus(String status) {
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
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object validateClaimTypeStatusExpatriate(String status) {
        String result = validateWithinLocatorText(LO_TXT_CLAIM_TYPE_STATUS_EXPATRIATE,status,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object validateClaimType(String claimType) {
        String result = validateWithinLocatorText(LO_TXT_CLAIM_TYPE,claimType,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object validateProvince(String province) {
        String result = validateWithinLocatorText(LO_TXT_PROVINCE,province,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object validateGEClaimNumber(String geClaimNumber) {
        String result = validateWithinLocatorText(LO_TXT_GE_CLAIM_NUMBER,geClaimNumber,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object validateInsuranceType(String insurance_type) {
        String result = validateWithinLocatorText(LO_TXT_INSURANCE_TYPE,insurance_type,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object validatePolicyNumberOrCertificateID(String insurance_type) {
        String result = validateWithinLocatorText(LO_TXT_POLICY_NUMBER_OR_CERTIFICATE_ID,insurance_type,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    public Object validateEmployerNames(String employer_names) {
        String result = validateWithinLocatorText(LO_TXT_EMPLOYER_NAMES,employer_names,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    public Object validateNames(String insurance_type) {
        String result = validateWithinLocatorText(LO_TXT_NAMES,insurance_type,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object validateDOB(String insurance_type) {
        String result = validateWithinLocatorText(LO_TXT_DOB,insurance_type,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    public Object validatePhoneNumber(String insurance_type) {
        String result = validateWithinLocatorText(LO_TXT_PHONE_NUMBER,insurance_type,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object validateEmail(String insurance_type) {
        String result = validateWithinLocatorText(LO_TXT_EMAIL,insurance_type,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object validateLine1CityProvince(String insurance_type) {
        String result = validateWithinLocatorText(LO_TXT_LINE1_CITY_PROVINCE,insurance_type,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object validateCountryPostalCode(String insurance_type) {
        String result = validateWithinLocatorText(LO_TXT_COUNTRY_POSTAL_CODE,insurance_type,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object validateProvincialHealthCardNumber(String insurance_type) {
        String result = validateWithinLocatorText(LO_TXT_PROVINCIAL_HEALTH_CARD_NUMBER,insurance_type,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Scrolls at a given locator.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object scrollTop() {
        String result = scrollToLocator(LO_REVIEW_SUBMIT_PAGE_VERIFY);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Click "I Agree to All" checkbox.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object clickAgreeToAllCheckbox() {
        String result = clickLocator(LO_CHK_AGREE_TO_ALL, 30000);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Click "Submit Claim" button.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object clickSubmitClaimButton() {
        String result = clickLocator(LO_BUT_SUBMIT_CLAIM, 30000);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
}
