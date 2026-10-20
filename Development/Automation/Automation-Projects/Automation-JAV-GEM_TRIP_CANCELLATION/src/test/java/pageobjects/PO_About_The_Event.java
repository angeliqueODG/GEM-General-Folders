package pageobjects;

// Import class packages for this Page Object (PO)
import org.openqa.selenium.WebDriver;   // Selenium WebDriver
import framework.automation.FW_Page;    // Automation framework Page Object (PO) class
import framework.utilities.FW_ConfigMgr;   // Automation framework Configuration Manager to retrieve testConfig.properties values
import framework.utilities.FW_StringUtils; // Automation framework String Utilities

/**
 * Page Object (PO) class used in the Page Object (PO) design pattern. Inherits from the FW_Page class.
 */
// [Note: Automation Engineer, rename this Page Object (PO) class to match the filename.]
public class PO_About_The_Event extends FW_Page{

    // [Note: Automation Engineer, define the Page Object (PO) locators (LO) here.]
    private static final String LO_LBL_ABOUT_THE_EVENT= "//h4[contains(text(),'About the Event')]/..";
    private static final String LO_SLCT_COUNTRY= "//div[span='Country']/following-sibling::div//div[@role='combobox']";
    private static final String LO_EDT_CITY="//div[label='City']/following-sibling::div//div//input";
    private static final String LO_EDT_FROM_DATE="//div[label='From']/following-sibling::div//input";
    private static final String LO_EDT_TO_DATE="//div[label='To']/following-sibling::div//input";
    private static final String LO_EDT_PURCHASE_DATE="//div[label='Trip Purchase Date']/following-sibling::div//input";
    private static final String LO_EDT_INCIDENT_DATE="//div[label='Incident Date']/following-sibling::div//input";
    private static final String LO_EDT_CANCELLATION_DATE="//div[label='Cancellation Date']/following-sibling::div//input";
    private static final String LO_EDT_REASON_FOR_CANCELATION="//div[label='What was the reason for cancellation?']/following-sibling::div//div//input";
    private static final String LO_RAD_YES_PERSON_CAUSING_THE_CLAIM="//label[contains(text(),'Yes')]";
    private static final String LO_TXT_SHORT_SUMMARY_ON_WHAT_HAPPENED="//div[@class='FieldLayout---input_below']//textarea";
    private static final String LO_BUT_CONTINUE2="//button[@class='Button---btn Button---default_direction Button---solid appian-context-last-in-list Button---inSideBySide Button---icon_start undefined']";
    
    

    /**
     * Define the Page Object (PO) constructor.
     * @param driver The WebDriver object passed from the test method.
     */
    // [Note: Automation Engineer, rename this Page Object (PO) class to match the filename.]
    public PO_About_The_Event(WebDriver driver) {
        super(driver);
    }

     /**
     * Validates if current webpage is loaded and correct.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateOnPage() {
        String result = validateLocatorExists(LO_LBL_ABOUT_THE_EVENT, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Select the country dropdown.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String clickSelectCountryDropdown(){
        String result = clickLocator(LO_SLCT_COUNTRY, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    //TODO: May be a refactor oppertunity here.
    /**
     * Selects "Canada" option from the dropdown menu.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
     public String clickCanada(){
        String dropdownValue = "Canada";
        String locator = LO_SLCT_COUNTRY;
        for (int i = 0; i < 1; i++) { 
            typeOnKeyboard("ARROW_DOWN");
        }
        Boolean trueOrFalse =  typeOnKeyboard("ENTER");
        if(trueOrFalse){
            String result = "[Pass] - Selected dropdown '" + dropdownValue + "' from locator '" + locator + "'.";
            result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
            return result;
        }
        String result = "[Fail] - Dropdown '" + dropdownValue + "' does not exist for locator '" + locator + "'.";
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /** 
     * @param city The text to enter in the city field.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String enterCity(String city){
        String result = setText(LO_EDT_CITY, city, (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    
     /** 
     * @param fromDate The from date to enter in the date field.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String enterFromDate(String fromDate){
        String result = setText(LO_EDT_FROM_DATE, fromDate, (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /** 
     * @param toDate The to date to enter in the date field.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String enterToDate(String toDate){
        String result = setText(LO_EDT_TO_DATE, toDate, (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /** 
     * @param purchase  The text to enter in the purchase field.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String enterBookedDate(String purchase){
        String result = setText(LO_EDT_PURCHASE_DATE, purchase, (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /** 
     * @param incidentDate The text to enter in the incident date field.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String enterIncidentDate(String incidentDate){
        String result = setText(LO_EDT_INCIDENT_DATE, incidentDate, (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /** 
     * @param cancellationDate  The text to enter in the cancellation date field.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String enterCancellationDate(String cancellationDate){
        String result = setText(LO_EDT_CANCELLATION_DATE, cancellationDate, (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /** 
     * @param reasonFOrCancelation  The text to enter in the reason for cancelation field.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String enterReasonForCancelation(String reasonFOrCancelation){
        String result = setText(LO_EDT_REASON_FOR_CANCELATION, reasonFOrCancelation, (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Click "Yes" radio button for person causing the claim.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String clickYesPersonCausingTheClaim(){
        String result = clickLocator(LO_RAD_YES_PERSON_CAUSING_THE_CLAIM, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /** 
     * @param shortSummary  The text to enter in the short summary field.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String enterShortSummaryOnWhatHappened(String shortSummary){
        String result = setText(LO_TXT_SHORT_SUMMARY_ON_WHAT_HAPPENED, shortSummary, (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Click "Continue" button.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String clickContinueButton2(){
        String result = clickLocator(LO_BUT_CONTINUE2, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

   

    // /** 
    //  * @param otherDueTo  The text to enter in the other due to field.
    //  * 
    //  * @return A string including [PASS] or [FAIL] along with specific result details.
    //  */
    // public String enterOtherDueTo(String otherDueTo){
    //     String result = setText(LO_EDT_OTHER_DUE_TO, otherDueTo, (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"), false);
    //     result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
    //     return result;
    // }

    // /** 
    //  * @param reason  The text to enter in the reason field.
    //  * 
    //  * @return A string including [PASS] or [FAIL] along with specific result details.
    //  */
    // public String enterWhatHappened(String reason){
    //     String result = setText(LO_EDT_REASON, reason, (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"), false);
    //     result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
    //     return result;
    // }

    // /**
    //  * Click "Continue" button.
    //  * 
    //  * @return A string including [PASS] or [FAIL] along with specific result details.
    //  */
    // public String clickContinueButton(){
    //     String result = clickLocator(LO_BUT_CONTINUE, FW_ConfigMgr.getDefaultTimeout());
    //     result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
    //     return result;
    // }

    // /**
    //  * Scrolls to the top of the page.
    //  * 
    //  * @return A string including [PASS] or [FAIL] along with specific result details.
    //  */
    // public String scrollTop() {
    //     String result = scrollToLocator(LO_ABOUT_EVENT_PAGE_VERIFY);
    //     result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
    //     return result;
    // }    
}
