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
 * Page Object (PO) class used in the Page Object (PO) design pattern. Inherits
 * from the CU_Appian class.
 */
// [Note: Automation Engineer, rename this Page Object (PO) class to match the
// filename.]
public class PO_Save_Claim_As_A_Draft extends CU_Appian {

    // [Note: Automation Engineer, define the Page Object (PO) locators (LO) here.]
    String LO_TXT_TYPE_HEADING = "//h2[contains(text(), '";
    private static final String LO_TXT_SAVE_CLAIM_AS_A_DRAFT_HEADING = "//h2[contains(text(), 'SAVE CLAIM AS A DRAFT')]";
    private static final String LO_BUT_BACK = "//span[text()='Back']";
    private static final String LO_EDT_INSURED_EMAIL = "//div[label[contains(text(), 'Insured email')]]/following-sibling::div//input";
    private static final String LO_EDT_COUNTRY_CODE = "//div[span[contains(text(), 'Country code')]]/following-sibling::div//div[@role='combobox']";
    private static final String LO_EDT_MOBILE_PHONE_NUMBER = "//div[label[contains(text(), 'Mobile Phone Number')]]/following-sibling::div//input";
    private static final String LO_BUT_SEND_CODE = "//button[span[span[contains(text(), 'Send Code')]]]";
    //private static final String LO_BUT_SEND_CODE = "//button[span[span[contains(text(), 'Send Code')]]]";

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
    public Object scrollTop() {
        String result = scrollToLocator(LO_TXT_SAVE_CLAIM_AS_A_DRAFT_HEADING);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if current webpage is loaded and correct.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object validateOnPage(String ClaimType) {
        clickLocator("//h1[contains(text(), 'Claim Opening')]", FW_ConfigMgr.getDefaultTimeout());
        scrollTo(LO_TXT_SAVE_CLAIM_AS_A_DRAFT_HEADING);
        LO_TXT_TYPE_HEADING=LO_TXT_TYPE_HEADING + ClaimType + "']";
        String result = validateLocatorExists(LO_TXT_TYPE_HEADING, FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        LO_TXT_TYPE_HEADING = "//h2[contains(text(), '";
        return result;
    }
    public Object verifySaveAsDraftHeading() {
        String result = validateLocatorExists(LO_TXT_SAVE_CLAIM_AS_A_DRAFT_HEADING, FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Clicks the  "Back" button.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object clickBackButton() {
        String result = clickLocator(LO_BUT_BACK, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    public Object validateInsuredEmail(String insuredEmail) {
        String result = validateWithinLocatorText(LO_EDT_INSURED_EMAIL,insuredEmail ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object validateCountryCode(String insuredEmail) {
        String result = validateWithinLocatorText(LO_EDT_COUNTRY_CODE,insuredEmail ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    public Object validateMobilePhoneNumber(String mobilePhoneNumber) {
        String result = validateWithinLocatorText(LO_EDT_MOBILE_PHONE_NUMBER,mobilePhoneNumber ,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    public Object validateSendCodeButton() {
        String result = validateLocatorExists(LO_BUT_SEND_CODE, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    // public Object validateSendCodeButton() {
    //     String result = validateLocatorExists(LO_BUT_SEND_CODE, FW_ConfigMgr.getDefaultTimeout(),
    //             FW_ConfigMgr.getDefaultInterval());
    //     result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
    //     return result;
    // }
}
