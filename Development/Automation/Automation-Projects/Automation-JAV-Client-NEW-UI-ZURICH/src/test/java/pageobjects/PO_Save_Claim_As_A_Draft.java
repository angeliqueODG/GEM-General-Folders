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
public class PO_Save_Claim_As_A_Draft extends CU_Appian {

    // [Note: Automation Engineer, define the Page Object (PO) locators (LO) here.]
    private static final String LO_TXT_SAVE_CLAIM_AS_A_DRAFT_PAGE_VERIFY = "//h2[contains(text(), 'SAVE CLAIM AS A DRAFT')]";
    private static final String LO_EDT_INSURED_EMAIL_NZ = "//div[label[contains(text(), 'Insured email')]]/following-sibling::div//input";
    private static final String LO_EDT_COUNTRY_CODE_NZ = "//div[span[contains(text(), 'Country code')]]/following-sibling::div//div[@role='combobox']";
    private static final String LO_EDT_MOBILE_PHONE_NUMBER_NZ = "//div[label[contains(text(), 'Mobile Phone Number')]]/following-sibling::div//input";
    private static final String LO_BUT_SEND_CODE_NZ = "//button[span[span[contains(text(), 'Send Code')]]]";
    private static final String LO_TXT_SAVE_CLAIM_AS_A_DRAFT_PAGE_VERIFY_NZ = "//h2[contains(text(), 'SAVE CLAIM AS A DRAFT')]";
    private static final String LO_BUT_BACK = "//span[text()='Back']";
    private static final String LO_EDT_INSURED_EMAIL = "//div[label[contains(text(), 'Insured email')]]/following-sibling::div//input";
    private static final String LO_EDT_COUNTRY_CODE = "//div[span[contains(text(), 'Country code')]]/following-sibling::div//div[@role='combobox']";
    private static final String LO_EDT_MOBILE_PHONE_NUMBER = "//div[label[contains(text(), 'Mobile Phone Number')]]/following-sibling::div//input";
    private static final String LO_BUT_SEND_CODE = "//button[span[span[contains(text(), 'Send Code')]]]";

    /**
     * Define the Page Object (PO) constructor.
     * 
     * @param driver The WebDriver object passed from the test method.
     */
    // [Note: Automation Engineer, rename this Page Object (PO) class to match the
    // filename.]
    public PO_Save_Claim_As_A_Draft(WebDriver driver) {
        super(driver);
    }

    /**
     * Scrolls at a given locator.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String scrollTop() {
        String result = scrollToLocator(LO_TXT_SAVE_CLAIM_AS_A_DRAFT_PAGE_VERIFY);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if current webpage is loaded and correct.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String validateOnPage() {
        String result = validateLocatorExists(LO_TXT_SAVE_CLAIM_AS_A_DRAFT_PAGE_VERIFY, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String validateInsuredEmail_NZ(String insuredEmail) {
        String result = validateWithinLocatorText(LO_EDT_INSURED_EMAIL_NZ,insuredEmail ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String validateCountryCode_NZ(String insuredEmail) {
        String result = validateWithinLocatorText(LO_EDT_COUNTRY_CODE_NZ,insuredEmail ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String validateMobilePhoneNumber_NZ(String mobilePhoneNumber) {
        String result = validateWithinLocatorText(LO_EDT_MOBILE_PHONE_NUMBER_NZ,mobilePhoneNumber ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String validateSendCodeButton_NZ() {
        String result = validateLocatorExists(LO_BUT_SEND_CODE_NZ, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String validateOnPage_NZ() {
        clickLocator("//h1[contains(text(), 'Claim Opening')]", FW_ConfigMgr.getDefaultTimeout());
        scrollTo(LO_TXT_SAVE_CLAIM_AS_A_DRAFT_PAGE_VERIFY_NZ);
        String result = validateLocatorExists(LO_TXT_SAVE_CLAIM_AS_A_DRAFT_PAGE_VERIFY_NZ, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Clicks the  "Back" button.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String clickBackButton() {
        String result = clickLocator(LO_BUT_BACK, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String validateInsuredEmail(String insuredEmail) {
        String result = validateWithinLocatorText(LO_EDT_INSURED_EMAIL,insuredEmail ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String validateCountryCode(String insuredEmail) {
        String result = validateWithinLocatorText(LO_EDT_COUNTRY_CODE,insuredEmail ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String validateMobilePhoneNumber(String mobilePhoneNumber) {
        String result = validateWithinLocatorText(LO_EDT_MOBILE_PHONE_NUMBER,mobilePhoneNumber ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String validateSendCodeButton() {
        String result = validateLocatorExists(LO_BUT_SEND_CODE, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
}
