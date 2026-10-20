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
public class PO_Home extends CU_Appian {

    // [Note: Automation Engineer, define the Page Object (PO) locators (LO) here.]
    private static final String LO_HOME_PAGE_VERIFY = "//strong[contains(text(), 'Claim Centre')]/..";
    private static final String LO_BUT_START_NEW_CLAIM = "//strong[contains(text(),'START A NEW CLAIM')]";
    private static final String LO_BUT_CONTINUE_DRAFT_CLAIM = "//strong[contains(text(), 'CONTINUE DRAFT CLAIM')]";
    private static final String LO_BUT_CHECK_CLAIM_STATUS = "//strong[contains(text(), 'CHECK CLAIM STATUS')]";
    private static final String LO_BUT_VISIT_OUR_HELP_CENTRE = "//strong[contains(text(), 'VISIT OUR HELP CENTRE')]";
    private static final String LO_BUT_SIGN_IN = "//strong[contains(text(), 'SIGN IN')]";
    private static final String LO_TXT_SYSTEM_STATUS = "//h4[contains(text(), 'The System Has Encountered an Error')]";
    private static final String LO_BUT_VIEW_STATUS="//strong[contains(text(),'VIEW STATUS')]";
    private static final String LO_LNK_HELP_CENTRE="(//a[contains(text(), 'HELP CENTRE')])[1]";
    /**
     * Define the Page Object (PO) constructor.
     * @param driver The WebDriver object passed from the test method.
     */
    // [Note: Automation Engineer, rename this Page Object (PO) class to match the filename.]
    public PO_Home(WebDriver driver) {
        super(driver);
    }

    /**
     * Validates if current webpage is loaded and correct.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateOnPage() {
        String result = validateLocatorExists(LO_HOME_PAGE_VERIFY, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if the 'Start New Claim' exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateStartNewClaim() {
        String result = validateLocatorExists(LO_BUT_START_NEW_CLAIM, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if the 'Continue Draft Claim' exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateContinueDraftClaim() {
        String result = validateLocatorExists(LO_BUT_CONTINUE_DRAFT_CLAIM, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if the 'Check Claim Status' exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateCheckClaimStatus() {
        String result = validateLocatorExists(LO_BUT_CHECK_CLAIM_STATUS, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if the 'Visit Our Help Centre' exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateVisitOurHelpCentre() {
        String result = validateLocatorExists(LO_BUT_VISIT_OUR_HELP_CENTRE, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if the 'Sign In' exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateSignIn() {
        String result = validateLocatorExists(LO_BUT_SIGN_IN, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Clicks the 'Continue Draft Claim' button.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String clickContinueDraftClaimButton() {
        String result = clickLocator(LO_BUT_CONTINUE_DRAFT_CLAIM, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Clicks the 'Start New Claim' button.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String clickButtonStartNewClaim() {
        String result = clickLocator(LO_BUT_START_NEW_CLAIM, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Clicks the 'CHECK CLAIM STATUS' button.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String clickCheckClaimStatusButton() {
        String result = clickLocator(LO_BUT_CHECK_CLAIM_STATUS, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Checks to see if the System is down error message exist.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateSystemNotDown() {
        String result = validateLocatorNotExists(LO_TXT_SYSTEM_STATUS, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if the 'View Status' exists.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateViewStatus() {
        String result = validateLocatorExists(LO_BUT_VIEW_STATUS, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
 /**
     * Clicks the 'HELP CENTER' button.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String clickHelpCentreLink() {
        waitForDuration(5, "s", false); // Wait to perform next check
        String result = clickLocator(LO_LNK_HELP_CENTRE, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

}
