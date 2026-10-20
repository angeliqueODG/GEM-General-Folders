package pageobjects;

// Import class packages for this Page Object (PO)
import org.openqa.selenium.WebDriver; // Selenium WebDriver
import org.openqa.selenium.support.ui.Wait;

import framework.automation.FW_Page; // Automation framework Page Object (PO) class
import framework.utilities.FW_ConfigMgr; // Automation framework Configuration Manager to retrieve testConfig.properties values
import framework.utilities.FW_StringUtils; // Automation framework String Utilities

/**
 * Page Object (PO) class used in the Page Object (PO) design pattern.
 * Inherits from the FW_Page class.
 */
// [Note: Automation Engineer, rename this Page Object (PO) class to match the
// filename.]
public class PO_Claims_Portal extends FW_Page {

    // [Note: Automation Engineer, define the Page Object (PO) locators (LO) here.]
    private static final String LO_LBL_MANULIFE_VERIFY = "(//span[@class='SizedText---large SizedText---predefined'])[1]";
    private static final String LO_BUT_START_NEW_CLAIM = "//strong[contains(text(),'START A NEW CLAIM')]";
    private static final String LO_LBL_INSURANCE_TYPE = "//h4[contains(text(),'Which insurance type are you claiming under?')]";
    private static final String LO_BUT_GROUP_INSURANCE = "(//div[@class='ContentLayout---content_layout'])[1]";
    private static final String LO_LBL_CLAIM_TYPE = "//h4[contains(text(),'What are you claiming for?')]";
    private static final String LO_BUT_HOME = "//button[@class='Button---btn Button---default_direction Button---link_v1 Button---large Button---minimize_width appian-context-first-in-list appian-context-last-in-list Button---inDarkBackground Button---icon_only Button---no_label Button---icon_start undefined']";

    private static final String LO_BUT_INDIVIDUAL_INSURANCE = "(//div[@class='ContentLayout---content_layout'])[2]";

    private static final String LO_BUT_TRIP_CANCELLATION = "(//div[@class='ContentLayout---content_layout'])[1]";
    private static final String LO_LBL_TRIP_CANCELLATION = "(//h4[@class='HeaderText---richtext_header HeaderText---align_start'])[1]";
    private static final String LO_BUT_YES = "//label[@class='RadioSelect---choice_label'][contains(text(),'Yes')]";
    private static final String LO_BUT_SWITCH_TO_TRIP_CANCELLATION = "//strong[contains(text(),'SWITCH TO TRIP INTERRUPTION')]";

    private static final String LO_RAD_NO = "//label[@class='RadioSelect---choice_label'][contains(text(),'No')]";
    private static final String LO_SLCT_REASON_FOR_CANCELLATION = "//span[contains(text(),'--Select Reason--')]";
    private static final String LO_SLCT_REASON_FOR_CANCELLATION_RELATED_TO = "//span[contains(text(),'Select a value')]";
    private static final String LO_RAD_NO_DUE_TO_WHOM = "(//label[contains(text(),'No')])[2]";
    private static final String LO_RAD_YES = "(//label[@class='RadioSelect---choice_label'][contains(text(),'Yes')])[2]";
    private static final String LO_RAD_NO_CLAIM_NUMBER = "(//label[@class='RadioSelect---choice_label'])[6]";
    private static final String LO_TXT_REQUIRED_DOCUMENTS = "//h4[@class='HeaderText---richtext_header HeaderText---align_start'][contains(text(),'Required Documents')]";
    private static final String LO_BUT_READ_GET_STARTED = "//button[@class='Button---btn Button---default_direction Button---solid appian-context-first-in-list appian-context-last-in-list Button---inSideBySide Button---icon_start undefined']";

    /**
     * Define the Page Object (PO) constructor.
     * 
     * @param driver The WebDriver object passed from the test method.
     */
    // [Note: Automation Engineer, rename this Page Object (PO) class to match the
    // filename.]
    public PO_Claims_Portal(WebDriver driver) {
        super(driver);
    }

    // [Note: Automation Engineer, define the Page Object (PO) methods here.]

    /**
     * Verify Manulife Claim centre page by "Welcome to your Claim Centre"
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */

    public String validateManulife() {
        String result = validateWithinLocatorText(LO_LBL_MANULIFE_VERIFY, "Welcome to your Claim Centre",
                FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval(), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName());
        return result;
    }

    /**
     * Click Start a New Claim.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     * 
     */
    public String clickStartNewClaim() {
        String result = clickLocator(LO_BUT_START_NEW_CLAIM, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Verify Insurance Type page by "Which insurance type are you claiming under?"
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String validateInsuranceType() {
        String result = validateWithinLocatorText(LO_LBL_INSURANCE_TYPE, "Which insurance type are you claiming under?",
                FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval(), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName());
        return result;
    }

    /**
     * Click Group Insurance.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     * 
     */
    public String clickGroupInsurance() {
        String result = clickLocator(LO_BUT_GROUP_INSURANCE, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Verify Claim Type page by "What are you claiming for?"
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String validateClaimType() {
        String result = validateWithinLocatorText(LO_LBL_CLAIM_TYPE, "What are you claiming for?",
                FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval(), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName());
        return result;
    }

    /**
     * Click Home button.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     * 
     */
    public String clickHome() {
        String result = clickLocator(LO_BUT_HOME, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Click Individual Insurance.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     * 
     */
    public String clickIndividualInsurance() {
        String result = clickLocator(LO_BUT_INDIVIDUAL_INSURANCE, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Click Trip Cancellation.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     * 
     */
    public String clickTripCancellation() {
        String result = clickLocator(LO_BUT_TRIP_CANCELLATION, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Verify Trip Cancellation page by "Trip Cancellation Claim"
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String validateTripCancellation() {
        String result = validateWithinLocatorText(LO_LBL_TRIP_CANCELLATION, "Trip Cancellation Claim", 10,
                FW_ConfigMgr.getDefaultInterval(), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName());
        return result;
    }

    /**
     * Click Yes button.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     * 
     */
    public String clickYes() {
        String result = clickLocator(LO_BUT_YES, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Click Switch to Trip Interruption button.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     * 
     */
    public String clickSwitchToTripInterruption() {
        String result = clickLocator(LO_BUT_SWITCH_TO_TRIP_CANCELLATION, 10);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Click No button.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     * 
     */
    public String clickNo() {
        String result = clickLocator(LO_RAD_NO, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Select Reason for Cancellation.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     * 
     */
    public String selectReasonForCancellation() {
        String result = clickLocator(LO_SLCT_REASON_FOR_CANCELLATION, 30);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Type on Keyboard ENTER key.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String pressEnterKey() throws Exception {
        typeOnKeyboard("ENTER");
        return "[PASS]- Pressed the ENTER Key";
    }

    /**
     * Press on Keyboard ARROW_DOWN key.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String pressArrowDownKey() throws Exception {
        typeOnKeyboard("ARROW_DOWN");
        return "[PASS]- Pressed the ARROW_DOWN Key";
    }

    /**
     * This block of code will select the reason related to the cancelling of travel .
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String selectCancellingRelatedTo() {
        String dropdownValue = "Select a value";
        String locator = LO_SLCT_REASON_FOR_CANCELLATION_RELATED_TO;
        for (int i = 0; i < 3; i++) {
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
     * Select Reason For Cancellation Related to.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     * 
     */
    public String selectReasonForCancellationRelatedTo() {
        String result = clickLocator(LO_SLCT_REASON_FOR_CANCELLATION_RELATED_TO, 30);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    
    }

    /**
     * Click No button for cancellation cause due to whom.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     * 
     */
    public String clickNoTocancellationCauseDueToWhom() {
        String result = clickLocator(LO_RAD_NO_DUE_TO_WHOM, 10);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Click Yes button.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     * 
     */
    public String clickYes2() {
        String result = clickLocator(LO_RAD_YES, 10);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Click No button for Claim Number.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     * 
     */
    public String clickNoClaimNumber() {
        String result = clickLocator(LO_RAD_NO_CLAIM_NUMBER, 10);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Verify Required Documents page by "Required Documents"
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String validateRequiredDocuments() {
        String result = validateWithinLocatorText(LO_TXT_REQUIRED_DOCUMENTS, "Required Documents", 10,
                FW_ConfigMgr.getDefaultInterval(), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName());
        return result;
    }

    /**
     * Click Read and Get Started button.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     * 
     */
    public String clickReadGetStarted() {
        String result = clickLocator(LO_BUT_READ_GET_STARTED, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

}