package pageobjects;

// Import class packages for this Page Object (PO)
import org.openqa.selenium.WebDriver;

import customizations.automation.CU_Appian; // Customization for Appian and where FW_Page is extended

import framework.junit.FW_TestStep;
import framework.utilities.FW_ConfigMgr;
import framework.utilities.FW_StringUtils;
import framework.utilities.FW_TestStepUtils;

public class PO_Waiver_Of_Liability extends CU_Appian {

    private static final String LO_TXT_WAIVER_LIABILITY_PAGE_VERIFY = "//h2/span[contains(text(), 'Waiver of Liability Program')]";

    /**
     * Define the Page Object (PO) constructor.
     * @param driver The WebDriver object passed from the test method.
     */
    public PO_Waiver_Of_Liability(WebDriver driver) {
        super(driver);
    }

    /**
     * Validates if current webpage is loaded and correct.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateOnPage() {
        String result = validateLocatorExists(LO_TXT_WAIVER_LIABILITY_PAGE_VERIFY, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
}