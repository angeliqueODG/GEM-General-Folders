package pageobjects;

// Import class packages for this Page Object (PO)
import org.openqa.selenium.WebDriver; // Selenium WebDriver

import customizations.automation.CU_Appian;// Automation framework customizations for Appian
import framework.utilities.FW_ConfigMgr; // Automation framework Configuration Manager to retrieve testConfig.properties values
import framework.utilities.FW_StringUtils; // Automation framework String Utilities

/**
 * Page Object (PO) class used in the Page Object (PO) design pattern. Inherits
 * from the CU_Appian class.
 */
// [Note: Automation Engineer, rename this Page Object (PO) class to match the
// filename.]
public class PO_Save_Claim_As_A_Draft extends CU_Appian {

    // [Note: Automation Engineer, define the Page Object (PO) locators (LO) here.]
    private static final String LO_TXT_SAVE_CLAIM_AS_A_DRAFT_PAGE_VERIFY = "//div//h2[contains(text(),'SAUVEGARDER LE BROUILLON DE VOTRE RÉCLAMATION')]";
    private static final String LO_TXT_INSURED_EMAIL = "//div[div[div[label[contains(text(),\"Adresse courriel de la personne assurée\")]]]]";
    private static final String LO_TXT_COUNTRY_CODE = "//div[div[div[span[contains(text(),\"Indicatif de pays\")]]]]";
    private static final String LO_TXT_MOBILE_PHONE_NUMBER = "//div[div[div[label[contains(text(),\"Numéro de téléphone cellulaire\")]]]]";
    private static final String LO_BUT_BACK = "//span[text()='Retour']";
    private static final String LO_BUT_SEND_CODE = "//span[contains(text(),\"Envoyer le code\")]";
    //private static final String LO_TXT_PRECLAIM_SUBMISSION_HEADER = "//h2[contains(text(),\"SOUMISSION D'UNE PRÉ-RÉCLAMATION\")]')]";


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
    public String scrollTop() {
        waitForDuration(10, "s", true);
        String result = scrollToLocator(LO_TXT_SAVE_CLAIM_AS_A_DRAFT_PAGE_VERIFY);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if current webpage is loaded and correct.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String validateOnPage() {
        waitForDuration(10, "s", true);
        String result = validateLocatorExists(LO_TXT_SAVE_CLAIM_AS_A_DRAFT_PAGE_VERIFY, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Clicks the  "Back" button.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String clickBackButton() {
        String result = clickLocator(LO_BUT_BACK, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates the insured email address.
     *
     * @param expectedEmail The expected email address to validate.
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateInsuredEmail(String expectedEmail) {
        String result = validateWithinLocatorText(LO_TXT_INSURED_EMAIL, expectedEmail, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval(), true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates the country code.
     *
     * @param expectedCountryCode The expected country code to validate.
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateCountryCode(String expectedCountryCode) {
        String result = validateWithinLocatorText(LO_TXT_COUNTRY_CODE, expectedCountryCode, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval(), true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates the mobile phone number.
     *
     * @param expectedPhoneNumber The expected mobile phone number to validate.
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateMobilePhoneNumber(String expectedPhoneNumber) {
        String result = validateWithinLocatorText(LO_TXT_MOBILE_PHONE_NUMBER, expectedPhoneNumber, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval(), true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates the "Send Code" button.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateSendCodeButton() {
        String result = validateLocatorExists(LO_BUT_SEND_CODE, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
}
