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

public class PO_Collision_Damage_Waiver extends CU_Appian{

    private static final String LO_TXT_COLLISION_DAMAGE_WAIVER_PAGE_VERIFY="//h2/span[contains(text(), 'Collision Damage Waiver Claim')]";
    private static final String LO_BUT_NO_CLAIM_NUMBER_RENTAL_AGENCY="//div[span=\"Are you submitting this claim to provide a claim number to a rental agency?\"]/following-sibling::div//label[text()='No']";
    private static final String LO_LST_REASON_FOR_LOSS="//div[span='Reason for Loss: ']/following-sibling::div//div[@role='combobox']";
    private static final String LO_BUT_NO_CLAIM_NUMBER="//div[span=\"Do you have an existing Global Excel claim number related to this claim that you have already submitted?\"]/following-sibling::div//label[text()='No']";
    private static final String LO_BUT_GET_STARTED="//span/span[contains(text(), \"Ready? Let's get Started\")]";
    private static final String LO_TXT_REQUIRED_DOCS_TITLE = "//h2[contains(text(),'Required Documents')]";
    private static final String LO_TXT_REQUIRED_DOCS_TITLE_NZ = "//h2[contains(text(),'Required Documents')]";
    private static final String LO_BUT_NO_CLAIM_NUMBER_RENTAL_AGENCY_NZ="//div[span=\"Are you submitting this claim to provide a claim number to a rental agency?\"]/following-sibling::div//label[text()='No']";
    private static final String LO_LST_REASON_FOR_LOSS_NZ="//div[span='Reason for Loss: ']/following-sibling::div//div[@role='combobox']";
    private static final String LO_BUT_NO_CLAIM_NUMBER_NZ="//div[span=\"Do you have an existing Global Excel claim number related to this claim that you have already submitted?\"]/following-sibling::div//label[text()='No']";

    /**
     * Define the Page Object (PO) constructor.
     * @param driver The WebDriver object passed from the test method.
     */
    // [Note: Automation Engineer, rename this Page Object (PO) class to match the filename.]
    public PO_Collision_Damage_Waiver(WebDriver driver) {
        super(driver);
    }

     /**
     * Validates if current webpage is loaded and correct.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateOnPage() {
        String result = validateLocatorExists(LO_TXT_COLLISION_DAMAGE_WAIVER_PAGE_VERIFY, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    /**
     * select No radio button to Are you submitting this claim to provide a claim number to a rental agency?.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String clickNoClaimNumberToRentalAgency_NZ() {
        String result = clickLocator(LO_BUT_NO_CLAIM_NUMBER_RENTAL_AGENCY_NZ, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String countItemsInList_NZ(String locator, String expectedString, int expectedValue) {
        waitForDuration(5, "s", false); // Wait to perform next check
        String result = countDropdownAppian(locator,expectedString,expectedValue,10);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Select Reason for loss.
     * 
     * @param reason The category type of the credit card insurance.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */

     public String selectReasonForLoss_NZ(String reason) {
        String result = setDropdownAppian(LO_LST_REASON_FOR_LOSS_NZ, reason, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * select No radio button to Are you seeking or planning to seek medical attention?.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String clickNoToClaimNumber_NZ() {
        String result = clickLocator(LO_BUT_NO_CLAIM_NUMBER_NZ, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Method to upload documents.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateRequiredDocumentsExist_NZ() {
        String result = validateLocatorExists(LO_TXT_REQUIRED_DOCS_TITLE_NZ, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * select No radio button to Are you submitting this claim to provide a claim number to a rental agency?.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String clickNoClaimNumberToRentalAgency() {
        String result = clickLocator(LO_BUT_NO_CLAIM_NUMBER_RENTAL_AGENCY, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Select Reason for loss.
     * 
     * @param reason The category type of the credit card insurance.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */

     public String selectReasonForLoss(String reason) {
        String result = setDropdownAppian(LO_LST_REASON_FOR_LOSS, reason, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * select No radio button to Are you seeking or planning to seek medical attention?.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String clickNoToClaimNumber() {
        String result = clickLocator(LO_BUT_NO_CLAIM_NUMBER, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Method to upload documents.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateRequiredDocumentsExist() {
        String result = validateLocatorExists(LO_TXT_REQUIRED_DOCS_TITLE, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * click on get started button.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String clickGetStarted() {
        String result = clickLocator(LO_BUT_GET_STARTED, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }    
}
