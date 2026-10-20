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

public class PO_Flight_Delay extends CU_Appian{

    private static final String LO_Flight_Delay_PAGE_VERIFY = "//h2/span[contains(text(),'Réclamation pour retard de vol')]";
    private static final String LO_BUT_GET_STARTED = "//span/span[contains(text(), \"Vous êtes prêt? Commençons\")]";
    private static final String LO_TXT_REQUIRED_DOCS_TITLE = "//h3[contains(text(),'DOCUMENTS REQUIS')]";
    private static final String LO_BUT_CLAIM_NUMBER = "//div[span[contains(text(), 'Avez-vous un numéro de réclamation Global Excel lié à cette réclamation déjà envoyée?')]]/following-sibling::div//label[text()='Non']";
    private static final String LO_LST_REASON_FOR_CLAIM = "//div[span=\"Pour quelle raison faites-vous une réclamation?\"]/following-sibling::div//div[@role='combobox']";
    private static final String LO_LST_REASON_FOR_DELAY = "//div[span=\"Raison du retard :\"]/following-sibling::div//div[@role='combobox']";
    private static final String LO_TXT_PRECLAIM_SUBMISSION = "//h2[contains(text(),\"SOUMISSION D'UNE PRÉ-RÉCLAMATION\")]";
    private static final String LO_BUT_CONTINUE = "//span[contains(text(),'Continuer')]";

     /**
     * Define the Page Object (PO) constructor.
     * @param driver The WebDriver object passed from the test method.
     */
    // [Note: Automation Engineer, rename this Page Object (PO) class to match the filename.]
    public PO_Flight_Delay(WebDriver driver) {
        super(driver);
    }

    /**
     * Validates if current webpage is loaded and correct.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateOnPage() {
        String result = validateLocatorExists(LO_Flight_Delay_PAGE_VERIFY, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Select "No" to answer "Do you have an existing Global Excel claim number related to this claim that you have already submitted?"
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String selectNo(){
        String result = clickLocator(LO_BUT_CLAIM_NUMBER, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;}  
    
     // TODO: This method needs some cleanup. PLease review.
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

    /**
     * Select the reason for claim
     * 
     * @param reasonForClaim The category type of the credit card insurance.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String selectReasonForClaim(String reasonForClaim) {
        String result = setDropdownAppian(LO_LST_REASON_FOR_CLAIM, reasonForClaim, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Select the reason for delay
     * 
     * @param reasonForDelay The category type of the credit card insurance.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String selectReasonForDelay(String reasonForDelay) {
        String result = setDropdownAppian(LO_LST_REASON_FOR_DELAY, reasonForDelay, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Scroll up the page.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String scrollUp() {
        String result = scrollToLocator(LO_TXT_PRECLAIM_SUBMISSION);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Click on continue button.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String clickContinueButton() {
        String result = clickLocator(LO_BUT_CONTINUE, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    }