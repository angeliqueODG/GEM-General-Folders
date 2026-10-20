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
    private static final String LO_BUT_GET_STARTED = "//span[contains(text(), 'Vous êtes prêt? Commençons')]";
    private static final String LO_TXT_REQUIRED_DOCS_TITLE = "//h4[contains(text(),'Documents requis')]";
    private static final String LO_TXT_FLIGHT_DELAY_REPORT = "//p[text()='Rapport de retard de vol']";
    private static final String LO_TXT_ORIGINAL_RESERVATION_STATEMENT = "//p[text()='Devis de réservation originale']";
    private static final String LO_BUT_CLAIM_NUMBER = "//div[span[contains(text(), 'Avez-vous un numéro de réclamation Global Excel lié à cette réclamation déjà envoyée?')]]/following-sibling::div//label[text()='Non']";
    private static final String LO_LST_REASON_FOR_DELAY = "//div[span='Raison du retard :']/following-sibling::div//div[@role='combobox']";
    private static final String LO_TXT_INITIAL_TRAVEL_ITINERARY = "//p[text()='Itinéraire de voyage initial']";
    private static final String LO_TXT_NEW_TRAVEL_ITINERARY = "//p[text()='Nouvel itinéraire de voyage']";
    private static final String LO_TXT_EXPENSES_RECEIPT = "//p[text()='Reçus pour les dépenses engagées']";
    private static final String LO_TXT_PRE_CLAIM_SUBMISSION = "//h2[contains(text(), \"SOUMISSION D'UNE PRÉ-RÉCLAMATION\")]";
    private static final String LO_TXT_PRE_CLAIM_SUBMISSION_BEFORE_GETTING_STARTED_TITLE = "//p[contains(text(),\"Nous sommes désolés d'apprendre que votre vol a été retardé. Nous sommes là pour vous aider! Tout d'abord, nous devons savoir :\")]";
    private static final String LO_REQUIRED_DOC_PAGE_VERIFY3 = "//h3[contains(text(), 'DOCUMENTS REQUIS')]";
    private static final String LO_BUT_CONTINUE = "(//span/span[contains(text(), 'Continuer')])";

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
     * Verify the text "Flight Delay Report" is present.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateFlightDelayReport() {
        String result = validateLocatorExists(LO_TXT_FLIGHT_DELAY_REPORT, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Verify the text "Original Reservation Statement" is present.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateOriginalReservationStatement() {
        String result = validateLocatorExists(LO_TXT_ORIGINAL_RESERVATION_STATEMENT, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;  
    }

    /**
     * Verify the text "Initial Travel Itinerary" is present.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateInitialTravelItinerary() {
        String result = validateLocatorExists(LO_TXT_INITIAL_TRAVEL_ITINERARY, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Verify the text "New Travel Itinerary" is present.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateNewTravelItinerary() {
        String result = validateLocatorExists(LO_TXT_NEW_TRAVEL_ITINERARY, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Verify the text "Expenses Receipt" is present.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateExpensesReceipt() {
        String result = validateLocatorExists(LO_TXT_EXPENSES_RECEIPT, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

     /**
     * Validates the pre-claim submission title.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validatePreClaimSubmissionTitle() {
        String result = validateLocatorExists(LO_TXT_PRE_CLAIM_SUBMISSION, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;  
    }

     public String validatePreClaimSubmissionBeforeGettingStartedTitle() {
        String result = validateLocatorExists(LO_TXT_PRE_CLAIM_SUBMISSION_BEFORE_GETTING_STARTED_TITLE, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String scrollUp(){
        String result = scrollToLocator(LO_TXT_PRE_CLAIM_SUBMISSION);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String validateRequiredDocumentsTextExists() {
        String result = validateLocatorExists(LO_REQUIRED_DOC_PAGE_VERIFY3, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

     /**
     * Clicks the 'Continue' button.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String clickButtonContinue() {
        String result = clickLocator(LO_BUT_CONTINUE, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

}
