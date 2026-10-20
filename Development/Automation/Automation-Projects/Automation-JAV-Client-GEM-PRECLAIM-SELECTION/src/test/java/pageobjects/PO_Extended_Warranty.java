package pageobjects;

// Import class packages for this Page Object (PO)
import org.openqa.selenium.WebDriver;

import customizations.automation.CU_Appian; // Customization for Appian and where FW_Page is extended

import framework.junit.FW_TestStep;
import framework.utilities.FW_ConfigMgr;
import framework.utilities.FW_TestStepUtils;

public class PO_Extended_Warranty extends CU_Appian {

    private static final String LO_TXT_EXTENDED_WARRANTY_PAGE_VERIFY = "//h2/span[contains(text(), 'Extended Warranty')]";
    private static final String LO_RAD_NO_CLAIM_NUMBER= "//div[span[contains(text(), 'Do you have an existing Global Excel claim number')]]/following-sibling::div//label[text()='No']";
    private static final String LO_TXT_CREDIT_CARD_STATEMENT = "//p[text()='Credit Card Statement']";
    private static final String LO_TXT_MANUFACTURER_WARRANTY = "//p[text()=\"Manufacturer's Warranty\"]";
    private static final String LO_TXT_REPAIR_ESTIMATE = "//p[text()='Repair Estimate ']";
    private static final String LO_TXT_RECEIPT_OF_PURCHASE= "//p[text()='Receipt of Purchase ']";
    private static final String LO_BUT_GET_STARTED = "//span/span[contains(text(), \"Ready? Let's get Started\")]";

    /**
     * Define the Page Object (PO) constructor.
     * 
     * @param driver The WebDriver object passed from the test method.
     */
    public PO_Extended_Warranty(WebDriver driver) {
        super(driver);
    }

    /**
     * Validates if current webpage is loaded and correct.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateOnPage() {
        String result = validateLocatorExists(LO_TXT_EXTENDED_WARRANTY_PAGE_VERIFY, FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

     /**
     * Clicks the 'Student' option.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object selectNoHaveExistingGlobalExcelClaimNumber() {
        String result = clickLocator(LO_RAD_NO_CLAIM_NUMBER, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if "Credit Card Statement" text exists.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object verifyCreditCardStatementTxt() {
        String result = validateLocatorExists(LO_TXT_CREDIT_CARD_STATEMENT, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if "Manufacturer's Warranty" text exists.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object verifyManufacturerWarrantyTxt() {
        String result = validateLocatorExists(LO_TXT_MANUFACTURER_WARRANTY, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if "Repair Estimate" text exists.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object verifyRepairEstimateTxt() {
        String result = validateLocatorExists(LO_TXT_REPAIR_ESTIMATE, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if "Receipt of Purchase" text exists.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object verifyReceiptOfPurchaseTxt() {
        String result = validateLocatorExists(LO_TXT_RECEIPT_OF_PURCHASE, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * click on Let's Get Started Button.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object clickGetStarted() {
        String result = clickLocator(LO_BUT_GET_STARTED, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
}