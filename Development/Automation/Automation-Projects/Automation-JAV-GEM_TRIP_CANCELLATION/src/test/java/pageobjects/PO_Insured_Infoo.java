package pageobjects;

// Import class packages for this Page Object (PO)
import org.openqa.selenium.WebDriver; // Selenium WebDriver
import framework.automation.FW_Page; // Automation framework Page Object (PO) class
import framework.utilities.FW_ConfigMgr; // Automation framework Configuration Manager to retrieve testConfig.properties values
import framework.utilities.FW_StringUtils; // Automation framework String Utilities

/**
 * Page Object (PO) class used in the Page Object (PO) design pattern. Inherits
 * from the FW_Page class.
 */
// [Note: Automation Engineer, rename this Page Object (PO) class to match the
// filename.]
public class PO_Insured_Infoo extends FW_Page {

    // [Note: Automation Engineer, define the Page Object (PO) locators (LO) here.]
    private static final String LO_TXT_INSURED_INFO_PAGE = "//h4[contains(text(),'Insured Info')]";
    // About your instuance
    private static final String LO_EDT_GROUP_NAME = "//div[label='Group name']/following-sibling::div//input";
    private static final String LO_EDT_POLICY_ID = "//div[label='Policy Number/Certificate ID']/following-sibling::div//input";
    private static final String LO_EDT_FIRST_NAME = "//div[label='First Name']/following-sibling::div//div//input";
    private static final String LO_EDT_LAST_NAME = "//div[label='Last Name']/following-sibling::div//div//input";
    private static final String LO_EDT_DATE_OF_BIRTH = "//div[label='Date of Birth']/following-sibling::div//div//input";
    private static final String LO_EDT_EMAIL = "//div[label='Email']/following-sibling::div//div//input";
    private static final String LO_EDT_CONFIRM_EMAIL = "//div[label='Confirm Email']/following-sibling::div//div//input";
    private static final String LO_EDT_PHONE = "//div[label='Phone']/following-sibling::div//div//input";
    private static final String LO_RAD_PRIMARY_PLACE_RESIDENCE = "//div[span='Primary place of residence is:']/following-sibling::div//div[@role='radiogroup']";
    private static final String LO_EDT_HOME_ADDRESS_CANADA = "//div[span='Home Address (in Canada)']/following-sibling::div//input";
    private static final String LO_RAD_PREFERRED_METHOD_COMMUNICATION_EMAIL = "//div[span='Preferred Method of Communication']/following-sibling::div//label[text()='Email']";
    private static final String LO_RAD_POLICY_HOLDER_YES = "//div[span='Are you the policy holder?']//label[contains(text(),'Yes')]";
    private static final String LO_RAD_NO_CLAIM_OTHER_INSURED_PERSON = "//span[contains(text(),'claiming for any other insured person(s)?')]/../following-sibling::div//label[text()='No']";
    private static final String LO_RAD_NO_OTHER_INSURANCE = "//div[span='Do you have any other insurance related to this claim?']/following-sibling::div//label[contains(text(),'No')]";
    private static final String LO_BUT_CONTINUE = "(//span/span[contains(text(), 'Continue')])";

    /**
     * Define the Page Object (PO) constructor.
     * 
     * @param driver The WebDriver object passed from the test method.
     */
    // [Note: Automation Engineer, rename this Page Object (PO) class to match the
    // filename.]
    public PO_Insured_Infoo(WebDriver driver) {
        super(driver);
    }

    // /**
    //  * Validates if current webpage is loaded and correct.
    //  *
    //  * @return A string including [PASS] or [FAIL] along with specific result
    //  *         details.
    //  */
    // public String validateInsuredInfoPage() {
    //     String result = validateLocatorExists(LO_TXT_INSURED_INFO_PAGE, FW_ConfigMgr.getDefaultTimeout(),
    //             FW_ConfigMgr.getDefaultInterval());
    //     result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
    //     return result;
    // }

    /**
     * Enters a Group name.
     * 
     * @param groupName The first name to be entered.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String enterGroupName(String groupName) {
        String result = setText(LO_EDT_GROUP_NAME, groupName, FW_ConfigMgr.getDefaultTimeout(), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Enters a policy Number .
     * 
     * @param policyNumberCertID The policy number certificate id to be entered.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String enterPolicyNumberCertificateId(String policyNumberCertID) {
        String result = setText(LO_EDT_POLICY_ID, policyNumberCertID, FW_ConfigMgr.getDefaultTimeout(), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Enters a first name.
     * 
     * @param firstName The last name to be entered.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String enterFirstName(String firstName) {
        String result = setText(LO_EDT_FIRST_NAME, firstName, FW_ConfigMgr.getDefaultTimeout(), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Enters a last name.
     * 
     * @param lastName The last name to be entered.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String enterLastName(String lastName) {
        String result = setText(LO_EDT_LAST_NAME, lastName, FW_ConfigMgr.getDefaultTimeout(), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Enters a date of birth.
     * 
     * @param dateOfBirth The date of birth to be entered.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String enterDateOfBirth(String dateOfBirth) {
        String result = setText(LO_EDT_DATE_OF_BIRTH, dateOfBirth, FW_ConfigMgr.getDefaultTimeout(), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Enters an email.
     * 
     * @param email The email to be entered.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String enterEmail(String email) {
        String result = setText(LO_EDT_EMAIL, email, FW_ConfigMgr.getDefaultTimeout(), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Enters a confirmation email.
     * 
     * @param confirmEmail The confirmation email to be entered.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String enterConfirmationEmail(String confirmEmail) {
        String result = setText(LO_EDT_CONFIRM_EMAIL, confirmEmail, FW_ConfigMgr.getDefaultTimeout(), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Enters a phone number.
     * 
     * @param phone The phone number to be entered.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String enterPhone(String phone) {
        String result = setText(LO_EDT_PHONE, phone, FW_ConfigMgr.getDefaultTimeout(), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Click place of residence.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     * 
     */
    public String clickPlaceOfResidence() {
        String result = clickLocator(LO_RAD_PRIMARY_PLACE_RESIDENCE, 10);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    // TODO refactor for better selection of dropdown.
    /**
     * Enters a Canadian home address.
     * 
     * @param homeAddress The Canadian home address to be entered.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     * 
     */
    public String enterHomeAddressCanadian(String homeAddress) {
        String result = setText(LO_EDT_HOME_ADDRESS_CANADA, homeAddress, FW_ConfigMgr.getDefaultTimeout(), false);
        waitForDuration(15, "s", true);
        typeOnKeyboard("ENTER"); // Selects first item in list.
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Selects the method of communication.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String selectMethodOfCommunication() {
        String result = clickLocator(LO_RAD_PREFERRED_METHOD_COMMUNICATION_EMAIL, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Selects 'Yes' for the policy holder option.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String selectYesAsPolicyHolder() {
        String result = clickLocator(LO_RAD_POLICY_HOLDER_YES, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Selects 'No' for other insured person.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String selectNoforOtherInsuredPerson() {
        String result = clickLocator(LO_RAD_NO_CLAIM_OTHER_INSURED_PERSON, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Selects 'No' for the other insurance option.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String selectNoOtherInsurance() {
        String result = clickLocator(LO_RAD_NO_OTHER_INSURANCE, FW_ConfigMgr.getDefaultTimeout());
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
