package pageobjects;

// Import class packages for this Page Object (PO)
import org.openqa.selenium.WebDriver;   // Selenium WebDriver

import customizations.automation.CU_Appian;
import framework.utilities.FW_ConfigMgr;    // Automation framework Page Object (PO) class
import framework.utilities.FW_StringUtils;   // Automation framework Configuration Manager to retrieve testConfig.properties values

/**
 * Page Object (PO) class used in the Page Object (PO) design pattern. Inherits from the FW_Page class.
 */
// [Note: Automation Engineer, rename this Page Object (PO) class to match the filename.]
public class PO_Baggage_Delay extends CU_Appian{
    /**
     * Define the Page Object (PO) constructor.
     * @param driver The WebDriver object passed from the test method.
     */
    // [Note: Automation Engineer, rename this Page Object (PO) class to match the filename.]
    private static final String LO_TXT_BAGGAGE_DELAY_PAGE_VERIFY = "//h2/span[contains(text(), 'Réclamation pour retard de bagages')]";
    private static final String LO_RAD_YES_CLAIM_NUMBER = "//div[span[contains(text(), 'Avez-vous un numéro de réclamation Global Excel lié à cette réclamation déjà envoyée?')]]/following-sibling::div//label[text()='Oui']";
    private static final String LO_EDT_CLAIM_NUMBER = "//div[label='Veuillez inscrire le numéro de la réclamation']//following-sibling::div//input";
    private static final String LO_TXT_REQUIRED_DOCS_TITLE = "//h4[contains(text(),'Documents requis')]";
    private static final String LO_TXT_Original_Travel_Itinerary = "//p[text()='Itinéraire de voyage initial']";
    private static final String LO_TXT_Proof_of_Event_Irregularity_Report = "//p[text()='Preuve de livraison']";
    private static final String LO_TXT_Proof_of_Delivery = "//p[text()='Relevé de carte de crédit']";
    private static final String LO_TXT_Proof_of_Payment = "//p[text()='Devis de réservation originale']";
    private static final String LO_TXT_Credit_Card_Statement = "//p[text()='Relevé de carte de crédit']";
    private static final String LO_TXT_Baggage_Delay_Report = "//p[text()='Rapport de retard de bagages']";
    private static final String LO_TXT_Receipts_for_Essential_Items = "//p[text()='Reçus des articles essentiels']";
    private static final String LO_TXT_GENERATE_DOCUMENT_CHECKLIST = "//strong/a[contains(text(), 'Obtenir la liste des documents')]";
    private static final String LO_TXT_DOWNLOAD_CHECKLIST = "//strong/a[contains(text(), 'Download Checklist')]";
    private static final String LO_BUT_GET_STARTED = "//span[contains(text(), \"Vous êtes prêt? Commençons\")]";

    /**
     * Define the Page Object (PO) constructor.
     * @param driver The WebDriver object passed from the test method.
     */
    // [Note: Automation Engineer, rename this Page Object (PO) class to match the filename.]
    public PO_Baggage_Delay(WebDriver driver) {
        super(driver);
    }

    /**
     * Validates if current webpage is loaded and correct.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateOnPage() {
        String result = validateLocatorExists(LO_TXT_BAGGAGE_DELAY_PAGE_VERIFY, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    // TODO: This method needs some cleanup. PLease review.
    /**
     * Selects Yes option from the dropdown menu for the question of whether you have an existing Global Excel claim number.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String selectYesToExistingGlobalExcelClaimNumber() {
        String result = clickLocator(LO_RAD_YES_CLAIM_NUMBER, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Enter the your global excel existing cliam number.
     * 
     * @param claim_number The six digits to be entered for the credit card.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String enterGlobalExcelClaimNumber(String claim_nuber) {
        String result = setText(LO_EDT_CLAIM_NUMBER, claim_nuber, FW_ConfigMgr.getDefaultTimeout(), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

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
     * Validates if "Original Travel Itinerary" text exists.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String verifyOriginalTravelItineraryTxt() {
        String result = validateLocatorExists(LO_TXT_Original_Travel_Itinerary, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if "Proof of Event - Irregularity Report" text exists.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String verifyProofOfEventIrregularityReportTxt() {
        String result = validateLocatorExists(LO_TXT_Proof_of_Event_Irregularity_Report, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    
    /**
     * Validates if "Proof of Delivery" text exists.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String verifyProofOfDeliveryTxt() {
        String result = validateLocatorExists(LO_TXT_Proof_of_Delivery, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if "Proof of Payment" text exists.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String verifyProofOfPaymentTxt() {
        String result = validateLocatorExists(LO_TXT_Proof_of_Payment, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if "Credit Card Statement" text exists.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String verifyCreditCardStatementTxt() {
        String result = validateLocatorExists(LO_TXT_Credit_Card_Statement, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if "Baggage Delay Report" text exists.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String verifyBaggageDelayReportTxt() {
        String result = validateLocatorExists(LO_TXT_Baggage_Delay_Report, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if "Receipts for Essential Items" text exists.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String verifyReceiptsForEssentialItemsTxt() {
        String result = validateLocatorExists(LO_TXT_Receipts_for_Essential_Items, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Clicks the  "GENERATE DOCUMENT CHECKLIST" link.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String clickGenerateDocumentChecklist() {
        String result = clickLocator(LO_TXT_GENERATE_DOCUMENT_CHECKLIST, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Verifies if the  "Download Checklist" txt exists
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String verifyDownloadChecklisTxt() {
        String result = validateLocatorExists(LO_TXT_DOWNLOAD_CHECKLIST, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * click on get started button.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String clickGetStarted() {
        waitForDuration(2, "s", false); // Wait to perform next check
        String result = clickLocator(LO_BUT_GET_STARTED, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    
}
