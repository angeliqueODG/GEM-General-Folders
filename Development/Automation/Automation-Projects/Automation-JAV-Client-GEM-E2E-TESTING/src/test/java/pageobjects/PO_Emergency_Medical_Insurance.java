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
public class PO_Emergency_Medical_Insurance extends CU_Appian {

    private static final String LO_RADIO_BUT_NO="//div[span=\"Are you currently travelling?\"]/following-sibling::div//label[text()='No']"; 
    private static final String LO_BUT_NO="//div[span=\"Are you seeking or planning to seek medical attention?\"]/following-sibling::div//label[text()='No']";
    private static final String LO_MIT_PAGE_VERIFY="//h2/span[contains(text(),'Emergency Medical Insurance')]";
    private static final String LO_BUT_NO_CLAIM_NUMBER="//div[span=\"Do you have an existing Global Excel claim number related to this claim that you have already submitted?\"]/following-sibling::div//label[text()='No']";
    private static final String LO_SELECT_PROVINCE="//div[span='Please select your province of residence']/following-sibling::div//div[@role='combobox']";
    private static final String LO_TXT_REQUIRED_DOCS_TITLE = "//h4[contains(text(),'Required Documents')]";
    private static final String LO_BUT_GET_STARTED = "//span/span[contains(text(), \"Ready? Let's get Started\")]";
    private static final String LO_RAD_YES_ARE_YOU_TRAVELLING = "//div[span='Are you currently travelling?']/following-sibling::div//div//label[text()='Yes']";
    

     /**
     * Define the Page Object (PO) constructor.
     * @param driver The WebDriver object passed from the test method.
     */
    // [Note: Automation Engineer, rename this Page Object (PO) class to match the filename.]
    public PO_Emergency_Medical_Insurance(WebDriver driver) {
        super(driver);
    }

    /**
     * Validates if current webpage is loaded and correct.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateOnPage() {
        String result = validateLocatorExists(LO_MIT_PAGE_VERIFY, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * select No radio button to Are you currently travelling?.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object clickNoCurrentTravelling() {
        String result = clickLocator(LO_RADIO_BUT_NO, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

      /**
     * select No radio button to Are you seeking or planning to seek medical attention?.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object clickNoToMedicalAttention() {
        String result = clickLocator(LO_BUT_NO, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

      /**
     * select No radio button to Are you seeking or planning to seek medical attention?.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object clickNoToClaimNumber() {
        String result = clickLocator(LO_BUT_NO_CLAIM_NUMBER, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Select Credit Card Insurance Category Type.
     * 
     * @param province The category type of the credit card insurance.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */

    public Object selectProvince(String province) {
        String result = setDropdownAppian(LO_SELECT_PROVINCE, province, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Method to upload documents.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateRequiredDocumentsExist() {
        String result = validateLocatorExists(LO_TXT_REQUIRED_DOCS_TITLE, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * click on get started button.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object clickGetStarted() {
        String result = clickLocator(LO_BUT_GET_STARTED, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * select Yes radio button to Are you currently travelling?.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object clickYesCurrentTravelling() {
        String result = clickLocator(LO_RAD_YES_ARE_YOU_TRAVELLING, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    

    

    
}
