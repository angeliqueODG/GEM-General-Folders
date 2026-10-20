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
public class PO_Common_Carrier_Travel_Accident extends CU_Appian {

    // [Note: Automation Engineer, define the Page Object (PO) locators (LO) here.]
    private static final String LO_LNK_COMMON_CARRIER_TRAVEL_ACCIDENT = "//h2/span[contains(text(), 'Common Carrier Travel Accident')]";
    private static final String LO_TXT_PRE_CLAIM_SUBMISSION_PAGE_VERIFY = "//h2[contains(text(), 'PRE-CLAIM SUBMISSION')]";
    private static final String LO_TXT_COMMON_CARRIER_TRAVEL_ACCIDENT_PAGE_VERIFY_NEW_UI = "//h1[contains(text(), 'Claim Opening - Common Carrier Travel Accident')]";
    private static final String LO_TXT_COMMON_CARRIER_TRAVEL_ACCIDENT_PARA_AFTER_PRE_CLAIM_SUBMISSION = "//p[contains(text(), 'When an insured person sustains a loss or injury while travelling on a common carrier.')]";
    private static final String LO_TXT_CONTACT_US_HEADING = "//h2[contains(text(), 'CONTACT US')]";
    private static final String LO_TXT_CONTACT_US_HEADINGH3 = "//h3[contains(text(), 'CONTACT US')]";
    private static final String LO_TXT_COMMON_CARRIER_TRAVEL_ACCIDENT_AFTER_CONTACT_US_HEADING = "//p[contains(text(), 'Our knowledgeable Claims Assistance agents will be happy to assist you. To begin your claim process, please call us at:')]";
    private static final String LO_BUT_CHANGE_TYPE_NZ = "//button[span[span[contains(text(), 'Change Type')]]]";
    private static final String LO_TXT_NON_TOLL_FREE_CONTACT = "//p[span[text()='+1 819-566-6365']]";
    private static final String LO_TXT_TOLL_FREE_CONTACT = "//p[span[text()='+1 866-235-4463' and text()='(Toll free)']]";
    private static final String LO_BUT_BACK = "//div[button[span//span[text()='Back']]]";
    /**
     * Define the Page Object (PO) constructor.
     * @param driver The WebDriver object passed from the test method.
     */
    // [Note: Automation Engineer, rename this Page Object (PO) class to match the filename.]
    public PO_Common_Carrier_Travel_Accident(WebDriver driver) {
        super(driver);
    }

    /**
     * Validates if current webpage is loaded and correct.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateOnPage() {
        String result = validateLocatorExists(LO_LNK_COMMON_CARRIER_TRAVEL_ACCIDENT, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
     public String validateOnPageNewUI() {
        String result = validateLocatorExists(LO_TXT_COMMON_CARRIER_TRAVEL_ACCIDENT_PAGE_VERIFY_NEW_UI, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String validatePreClaimSubmissionPage() {
        String result = validateLocatorExists(LO_TXT_PRE_CLAIM_SUBMISSION_PAGE_VERIFY, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
     public String verifyCommonCarrierTravelAccidentParaAfterPreClaimSubmission() {
        String result = validateLocatorExists(LO_TXT_COMMON_CARRIER_TRAVEL_ACCIDENT_PARA_AFTER_PRE_CLAIM_SUBMISSION, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String verifyContactUsHeading() {
        String result = validateLocatorExists(LO_TXT_CONTACT_US_HEADING, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String verifyContactUsHeadingH3() {
        String result = validateLocatorExists(LO_TXT_CONTACT_US_HEADINGH3, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String verifyParagraphAfterContactUs() {
        String result = validateLocatorExists(LO_TXT_COMMON_CARRIER_TRAVEL_ACCIDENT_AFTER_CONTACT_US_HEADING, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String validateChangeTypeButton_NZ() {
        String result = validateLocatorExists(LO_BUT_CHANGE_TYPE_NZ, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String verifyBackButton() {
        String result = validateLocatorExists(LO_BUT_BACK, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String verifyNonTollFreeContact() {
        String result = validateLocatorExists(LO_TXT_NON_TOLL_FREE_CONTACT, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String verifyTollFreeContact() {
        String result = validateLocatorExists(LO_TXT_TOLL_FREE_CONTACT, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

}
