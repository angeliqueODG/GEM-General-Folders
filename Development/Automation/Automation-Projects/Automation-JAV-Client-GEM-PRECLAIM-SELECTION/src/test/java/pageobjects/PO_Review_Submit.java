package pageobjects;

// Import class packages for this Page Object (PO)
import org.openqa.selenium.WebDriver;

import customizations.automation.CU_Appian; // Customization for Appian and where FW_Page is extended

import framework.junit.FW_TestStep;
import framework.utilities.FW_ConfigMgr;
import framework.utilities.FW_TestStepUtils;

public class PO_Review_Submit extends CU_Appian {

    private static final String LO_REVIEW_SUBMIT_PAGE_VERIFY = "//span[contains(text(),'Review & Submit Claim')]/..";
    private static final String LO_BUT_SAVE_DRAFT = "//span//span[contains(text(),'Save as Draft')]";
    private static final String LO_CHK_AGREE_TO_ALL = "//label[@class='CheckboxGroup---choice_label']";
    private static final String LO_BUT_SUBMIT_CLAIM = "//span//span[contains(text(),'Submit Claim')]";

    /**
     * Define the Page Object (PO) constructor.
     * @param driver The WebDriver object passed from the test method.
     */
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

    /**
     * Click "Save As Draft" button.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object clickSaveAsDraftButton() {
        String result = clickLocator(LO_BUT_SAVE_DRAFT, 30000);
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