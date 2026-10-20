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
public class PO_Insured_Info extends CU_Appian {

    // [Note: Automation Engineer, define the Page Object (PO) locators (LO) here.]
    private static final String LO_TXT_INSURED_INFO_HEADER = "//span[contains(text(),'Insured Info')]/..";
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
    private static final String LO_EDT_HOME_ADDRESS_LINE_1 = "//div[label='Address Line 1']/following-sibling::div//div//input";
    private static final String LO_EDT_HOME_ADDRESS_LINE_2 = "//div[label='Address Line 2']/following-sibling::div//div//input";
    private static final String LO_EDT_CITY = "//div[label='City']/following-sibling::div//div//input";
    private static final String LO_EDT_PROVINCE = "//div[span='Province']/following-sibling::div//div[@role='combobox']";
    private static final String LO_EDT_COUNTRY = "//div[label='Country']/following-sibling::div//div//input";
    private static final String LO_EDT_POSTAL_CODE = "//div[label='Postal Code']/following-sibling::div//div//input";
    private static final String LO_RAD_PREFERRED_METHOD_COMMUNICATION_EMAIL = "//div[span='Preferred Method of Communication']/following-sibling::div//label[text()='Email']";
    private static final String LO_RAD_POLICY_HOLDER_YES = "//div[span='Are you the policy holder?']//label[contains(text(),'Yes')]";
    private static final String LO_RAD_POLICY_HOLDER_YES_CL = "//div[span='Are you the policy holder?']/following-sibling::div//label[text()='Yes']";
    private static final String LO_RAD_INDIVIDUAL_EMBEDDED = "//label[contains(text(), 'Individual/Embedded')]";
    private static final String LO_EDT_CREDIT_CARD_FIRST_6_DIGITS = "//div[label='First 6 Digits']/following-sibling::div/div/input";
    private static final String LO_EDT_CREDIT_CARD_LAST_4_DIGITS = "//div[label='Last 4 Digits']/following-sibling::div/div/input";
    private static final String LO_RAD_YES_CARD_HOLDER = "//div[span='Are you the Cardholder?']/following-sibling::div//label[text()='Yes']";
    private static final String LO_RAD_PRIMARY_CARD_HOLDER = "//label[text()='Primary Cardholder']";
    private static final String LO_RAD_YES_PROGRAM_COORDINATOR = "//span[contains(text(),'organization or cardholder')]/../following-sibling::div//label[text()='No']";
    private static final String LO_RAD_NO_CLAIM_OTHER_INSURED_PERSON = "//span[contains(text(),'claiming for any other insured person(s)?')]/../following-sibling::div//label[text()='No']";
    private static final String LO_RAD_NO_TRAVEL_COMPANION = "//div[span='Are you claiming for a travel companion?']//label[contains(text(),'No')]";
    private static final String LO_RAD_NO_OTHER_INSURANCE = "//div[span='Do you have any other insurance related to this claim?']/following-sibling::div//label[contains(text(),'No')]";
    private static final String LO_BUT_CONTINUE = "(//span/span[contains(text(), 'Continue')])";
    private static final String LO_EDT_EMPLOYER_NAME = "//div[label='Employer Name']/following-sibling::div//input";
    private static final String LO_EDT_CONTRACT_OR_GROUP_NUMBER = "//div[label[text()='Contract/Group Number']]/following-sibling::div//input";
    private static final String LO_EDT_PLAN_NUMBER = "//div[label='Plan Number']/following-sibling::div//input";
    private static final String LO_EDT_MEMBER_ID = "//label[contains(text(), 'Member/Employee ID ')]/../following-sibling::div//input";
    private static final String LO_EDT_MEMBER_IDSL = "//label[contains(text(), 'Member ID')]/../following-sibling::div//input";
    private static final String LO_EDT_MEMBER_ID_CL = "//div[label='Employee/Member ID']/following-sibling::div//input";
    private static final String LO_RAD_NO_INSURED_PERSON_CL = "//div[span='Are you claiming for any other insured person(s)?']/following-sibling::div//label[text()='No']";
    private static final String LO_EDT_EMPLOYER_OR_GROUP_NAME = "//div[label='Employer/Group Name ']/following-sibling::div//input";
    private static final String LO_EDT_CONTRACT_NUMBER = "//div[label='Contract Number']/following-sibling::div//input";
    private static final String LO_EDT_MEMBER_CERTIFICATE_NUMBER = "//div[label='Member Certificate Number']/following-sibling::div//input";
    private static final String LO_EDT_PLAN_NUMBER_ORION = "//div[span='Refer to your insurance policy documentation for the Plan number.']//input";
    private static final String LO_EDT_HEALTH_CARD_NUMBER="//div[label='Provincial Health Card Number']/following-sibling::div//input";
    private static final String LO_EDT_SCHOOL_NAME="//div[label='Name of School']/following-sibling::div/div/input";
    private static final String LO_EDT_PROVINCIAL_HEALTH_CARD_NUMBER = "//div[label='Provincial Health Card Number (if applicable)']/following-sibling::div//div//input";
    private static final String LO_RAD_NO_PROGRAM_COORDINATOR = "//span[contains(text(),'organization or cardholder')]/../following-sibling::div//label[text()='No']";
    private static final String LO_EDT_COMPANY_NAME="//div[label='Name of Company']/following-sibling::div/div/input";
    private static final String LO_RAD_NO_PROGRAM_CORDINATOR="//div[span='Are you the Program Coordinator completing the claim on behalf of the organization or cardholder?']/following-sibling::div//label[text()='No']";
    private static final String LO_LNK_WHERE_TO_FIND_INORMATION = " //strong[contains(text(),'Where can I find this information?')]";
    private static final String LO_TXT_PURCHASED_INSURANCE = "//p[text()='Purchased Insurance']";
    private static final String LO_TXT_INDIVIDUAL_INSURANCE_INFO_PAGE = "//p[text()='Individual Insurance']";
    private static final String LO_BUT_PURCHESED_INSURANCE = "//h5[text()='Purchased Insurance']";
    
    /**
     * Define the Page Object (PO) constructor.
     * @param driver The WebDriver object passed from the test method.
     */
    // [Note: Automation Engineer, rename this Page Object (PO) class to match the filename.]
    public PO_Insured_Info(WebDriver driver) {
        super(driver);
    }

    /**
     * Validates if current webpage is loaded and correct.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateOnPage() {
        String result = validateLocatorExists(LO_TXT_INSURED_INFO_HEADER, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if current webpage is loaded and correct.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String verifyPurchasedInsurance() {
        String result = validateLocatorExists(LO_TXT_PURCHASED_INSURANCE, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

     /**
     * Validates if current webpage is loaded and correct.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String verifyIndividualInsurance() {
        String result = validateLocatorExists(LO_TXT_INDIVIDUAL_INSURANCE_INFO_PAGE, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Enter the name of school a student goes to.
     * 
     * @param nameOfSchool The name of scholl to be entered.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String enterNameOfSchool(String creditCardSixDigits) {
        String result = setText(LO_EDT_SCHOOL_NAME, creditCardSixDigits, FW_ConfigMgr.getDefaultTimeout(), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Enter the first 6 digits.
     * 
     * @param creditCardSixDigits The six digits to be entered for the credit card.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String enterFirst6Digits(String creditCardSixDigits) {
        String result = setText(LO_EDT_CREDIT_CARD_FIRST_6_DIGITS, creditCardSixDigits, FW_ConfigMgr.getDefaultTimeout(), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Enters the last 4 digits.
     * 
     * @param creditCardFourDigits The four digits to be entered for the credit card.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String enterLast4Digits(String creditCardFourDigits) {
        String result = setText(LO_EDT_CREDIT_CARD_LAST_4_DIGITS, creditCardFourDigits, FW_ConfigMgr.getDefaultTimeout(), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Selects the 'Individual Embedded' option.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result  details.
     */
    public String selectIndividual_Embedded() {
        String result = clickLocator(LO_RAD_INDIVIDUAL_EMBEDDED, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Enters a first name.
     * 
     * @param firstName The first name to be entered.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
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
     * @return A string including [PASS] or [FAIL] along with specific result details.
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
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String enterDOB(String dateOfBirth) {
        String result = setText(LO_EDT_DATE_OF_BIRTH, dateOfBirth, FW_ConfigMgr.getDefaultTimeout(), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Enters an email.
     * 
     * @param email The email to be entered.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result  details.
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
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String enterConfirmEmail(String confirmEmail) {
        String result = setText(LO_EDT_CONFIRM_EMAIL, confirmEmail, FW_ConfigMgr.getDefaultTimeout(), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Enters a phone number.
     * 
     * @param phone The phone number to be entered.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String enterPhone(String phone) {
        String result = setText(LO_EDT_PHONE, phone, FW_ConfigMgr.getDefaultTimeout(), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Enter primary place of residence.
     * 
     * @param placeOfResidence The place of residence to be entered.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String enterPrimaryPlaceOfResidence(String placeOfResidence) {
        String result = selectRadioButtonInGroup(LO_RAD_PRIMARY_PLACE_RESIDENCE, placeOfResidence, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Enters a employer name.
     * 
     * @param employerName The employer name to be entered.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String enterEmployerName(String employerName) {
        String result = setText(LO_EDT_EMPLOYER_NAME, employerName, FW_ConfigMgr.getDefaultTimeout(), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Enters a Contract/Group Number.
     * 
     * @param contractOrGroupNumber The employer name to be entered.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String enterContractOrGroupNumber(String contractOrGroupNumber) {
        String result = setText(LO_EDT_CONTRACT_OR_GROUP_NUMBER, contractOrGroupNumber, FW_ConfigMgr.getDefaultTimeout(), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Enters a employer name.
     * 
     * @param groupName The group name to be entered.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String enterGroupName(String groupName) {
        String result = setText(LO_EDT_GROUP_NAME, groupName, FW_ConfigMgr.getDefaultTimeout(), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Enters a plan number.
     * 
     * @param planNumber The plan number to be entered.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String enterPlanNumber(String planNumber) {
        String result = setText(LO_EDT_PLAN_NUMBER, planNumber, FW_ConfigMgr.getDefaultTimeout(), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    // TODO: Determine if Orion really needs it's own specilized version of this method.
    /**
     * Enters a plan number. (Orion specific)
     * 
     * @param planNumber The plan number to be entered.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String enterPlanNumberOrion(String planNumber) {
        String result = setText(LO_EDT_PLAN_NUMBER_ORION, planNumber, FW_ConfigMgr.getDefaultTimeout(), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Enters a member id .
     * 
     * @param memberID The member id to be entered.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String enterMemberId(String memberID) {
        String result = setText(LO_EDT_MEMBER_ID, memberID, FW_ConfigMgr.getDefaultTimeout(), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Enters a member id for SunLife.
     * 
     * @param memberIdSn The member id to be entered.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String enterMemberIdSL(String memberIdSn) {
        String result = setText(LO_EDT_MEMBER_IDSL, memberIdSn, FW_ConfigMgr.getDefaultTimeout(), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Enters a member id for CL portal.
     * 
     * @param memberID The member id to be entered.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String enterMemberId_CL(String memberID) {
        String result = setText(LO_EDT_MEMBER_ID_CL, memberID, FW_ConfigMgr.getDefaultTimeout(), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Enters a employer/Group name.
     * 
     * @param employerGroupName The employer Group name to be entered.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String enterEmployerOrGroupName(String employerGroupName) {
        String result = setText(LO_EDT_EMPLOYER_OR_GROUP_NAME, employerGroupName, FW_ConfigMgr.getDefaultTimeout(), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Enters a contract number.
     * 
     * @param contractNumber The contract number to be entered.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String enterContractNumber(String contractNumber) {
        String result = setText(LO_EDT_CONTRACT_NUMBER, contractNumber, FW_ConfigMgr.getDefaultTimeout(), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Enters a member certificate number .
     * 
     * @param memberCertificateNumber The certificate number to be entered.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String enterMemberCertificateNumber(String memberCertificateNumber) {
        String result = setText(LO_EDT_MEMBER_CERTIFICATE_NUMBER, memberCertificateNumber, FW_ConfigMgr.getDefaultTimeout(), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Enters a policy id .
     * 
     * @param policyNumberCertID The policy number certificate id to be entered.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String enterPolicyNumberCertificateId(String policyNumberCertID) {
        String result = setText(LO_EDT_POLICY_ID, policyNumberCertID, FW_ConfigMgr.getDefaultTimeout(), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Selects 'No' for the travel companion option.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String selectNoForOtherInsuredPerson() {
        String result = clickLocator(LO_RAD_NO_INSURED_PERSON_CL, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    // TODO refactor for better selection of dropdown.
    /**
     * Enters a Canadian home address.
     * 
     * @param homeAddress The Canadian home address to be entered.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     * 
     */
    public String enterHomeAddressCanadian(String homeAddress) {
        String result = setText(LO_EDT_HOME_ADDRESS_CANADA, homeAddress, 30, false);
        waitForDuration(15, "s", true);
        typeOnKeyboard("ENTER"); // Selects first item in list.
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Enters an address line 1.
     * 
     * @param addressLine1 The address line 1 to be entered.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String enterAddressLine1(String addressLine1) {
        String result = setText(LO_EDT_HOME_ADDRESS_LINE_1, addressLine1, FW_ConfigMgr.getDefaultTimeout(), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Enters an address line 2.
     * 
     * @param addressLine2 The address line 2 to be entered.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String enterAddressLine2(String addressLine2) {
        String result = setText(LO_EDT_HOME_ADDRESS_LINE_2, addressLine2, FW_ConfigMgr.getDefaultTimeout(), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Enters a city.
     * 
     * @param city The city to be entered.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String enterCity(String city) {
        String result = setText(LO_EDT_CITY, city, FW_ConfigMgr.getDefaultTimeout(), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Selects a province.
     * 
     * @param province The province to be selected.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String selectProvince(String province) {
        String result = setDropdownAppian(LO_EDT_PROVINCE, province, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

        // TODO_this method was implemented as a workaround to the issue with the dropdown menu.
    /**
     * 
     * Will revisit this method to implement a better solution.
     * 
     * Selects "Other" option from the dropdown menu.
     * 
     * @return True if the key was typed, false otherwise.
     */
    public String clickOntario() {
        String dropdownValue = "Onterio";
        String locator = LO_EDT_PROVINCE;
        clickLocator(LO_EDT_PROVINCE, FW_ConfigMgr.getDefaultTimeout());
        for (int i = 0; i < 9; i++) {
            
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
     * Enters a country.
     * 
     * @param country The country to be entered.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String enterCountry(String country) {
        String result = setText(LO_EDT_COUNTRY, country, FW_ConfigMgr.getDefaultTimeout(), true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Enters a postal code.
     *
     * @param postalCode The postal code to be entered.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String enterPostalCode(String postalCode) {
        String result = setText(LO_EDT_POSTAL_CODE, postalCode, FW_ConfigMgr.getDefaultTimeout(), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Enters a provincial health card number .
     * 
     * @param provincialHealthCardNumber The provincial health card number to be entered.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String provincialHealthCardNumber(String provincialHealthCardNumber) {
        String result = setText(LO_EDT_PROVINCIAL_HEALTH_CARD_NUMBER, provincialHealthCardNumber, FW_ConfigMgr.getDefaultTimeout(), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Selects the method of communication.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String selectMethodOfCommunication() {
        String result = clickLocator(LO_RAD_PREFERRED_METHOD_COMMUNICATION_EMAIL, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Selects "Email" as your preferred method of communication.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String selectEmailAsMethodOfCommunication() {
        String result = clickLocator(LO_RAD_PREFERRED_METHOD_COMMUNICATION_EMAIL, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Selects 'Yes' for the policy holder option.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String selectYesAsPolicyHolder() {
        String result = clickLocator(LO_RAD_POLICY_HOLDER_YES_CL, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Selects 'No' to question : Are you claiming for any other insured person(s)?.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String selectNoClaimingforOtherInsuredPerson() {
        String result = clickLocator(LO_RAD_NO_CLAIM_OTHER_INSURED_PERSON, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Selects 'No' for the other insurance option.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String selectNoOtherInsuranceRelatedToThisClaim() {
        String result = clickLocator(LO_RAD_NO_OTHER_INSURANCE, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Selects 'Yes' for the card holder option.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String selectYesforCardHolder() {
        String result = clickLocator(LO_RAD_YES_CARD_HOLDER, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Selects the primary card holder option.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String selectPrimaryCardHolder() {
        String result = clickLocator(LO_RAD_PRIMARY_CARD_HOLDER, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Selects 'Yes' for the program coordinator option.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String selectYesforProgamCoordinator() {
        String result = clickLocator(LO_RAD_YES_PROGRAM_COORDINATOR, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Selects 'No' for the program coordinator option.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String selectNoForProgamCoordinator() {
        String result = clickLocator(LO_RAD_NO_PROGRAM_CORDINATOR, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Selects 'No' for other insured person.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String selectNoforOtherInsuredPerson() {
        String result = clickLocator(LO_RAD_NO_CLAIM_OTHER_INSURED_PERSON, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Selects 'No' for the travel companion option.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String selectNoFORTRAVELCOMPANION() {
        String result = clickLocator(LO_RAD_NO_TRAVEL_COMPANION, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Selects 'No' for the other insurance option.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String selectNoOtherInsurance() {
        String result = clickLocator(LO_RAD_NO_OTHER_INSURANCE, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Enters health card number.
     * 
     * @param HealthcardNumber The employer name to be entered.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String enterHealtCardNumber(String HealthcardNumber) {
        String result = setText(LO_EDT_HEALTH_CARD_NUMBER, HealthcardNumber, FW_ConfigMgr.getDefaultTimeout(), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Clicks the 'Continue' button.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String clickButtonContinue() {
        String result = clickLocator(LO_BUT_CONTINUE, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Selects 'No' for the program coordinator option.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String selectNoforProgamCoordinator() {
        String result = clickLocator(LO_RAD_NO_PROGRAM_COORDINATOR, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Enter the company name.
     * 
     * @param companyName The name of scholl to be entered.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String enterCompanyName(String companyName) {
        String result = setText(LO_EDT_COMPANY_NAME, companyName, FW_ConfigMgr.getDefaultTimeout(), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /* Clicks on "Where can I find this information?"
    *
    * @return A string including [PASS] or [FAIL] along with specific result details.
    */

    public String clickOnWhereToFindInformation() {
        String result = clickLocator(LO_LNK_WHERE_TO_FIND_INORMATION, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName());
        return result;
    }

    /**
     * Selects 'Outside Canada' as the primary place of residence.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String selectOutsideCanada() {
        String result = clickLocator(LO_RAD_PRIMARY_PLACE_RESIDENCE, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName());
        return result;
    }
}
