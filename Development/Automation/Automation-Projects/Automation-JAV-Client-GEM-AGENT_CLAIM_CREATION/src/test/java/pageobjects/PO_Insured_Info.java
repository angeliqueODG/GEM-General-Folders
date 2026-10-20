package pageobjects;

// Import class packages for this Page Object (PO)
import org.openqa.selenium.WebDriver;

import customizations.automation.CU_Appian; // Customization for Appian and where FW_Page is extended

import framework.junit.FW_TestStep;
import framework.utilities.FW_ConfigMgr;
import framework.utilities.FW_DateTimeUtils;
import framework.utilities.FW_StringUtils;
import framework.utilities.FW_TestStepUtils;

// Secendory support imports (Typically not required)
import org.openqa.selenium.WebElement;
import java.io.File;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

/**
 * Page Object (PO) class used in the Page Object (PO) design pattern. Inherits
 * from the CU_Appian class.
 */
// [Note: Automation Engineer, rename this Page Object (PO) class to match the
// filename.]
public class PO_Insured_Info extends CU_Appian {

    // [Note: Automation Engineer, define the Page Object (PO) locators (LO) here.]
    private static final String LO_TXT_INSURED_INFO_HEADER = "//h2[contains(text(), 'INSURED INFO')]";
    private static final String LO_TXT_ABOUT_YOUR_INSURANCE_HEADER = "//h3[contains(text(), 'ABOUT YOUR INSURANCE')]";
    private static final String LO_TXT_ABOUT_YOUR_CLAIMANT_HEADER_NEW_UI = "//h3[contains(text(), 'ABOUT THE CLAIMANT')]";
    private static final String LO_TXT_ABOUT_YOUR_INSURANCE_TITLE = "//h3[contains(text(), 'ABOUT YOUR INSURANCE')]";
    private static final String LO_TXT_ABOUT_THE_CLAIMANT_TITLE = "//h3[contains(text(), 'ABOUT THE CLAIMANT')]";
    private static final String LO_TXT_ADDRESS_DETAILS_TITLE = "//h3[contains(text(), 'ADDRESS DETAILS')]";
    private static final String LO_TXT_INSURANCE_TYPE_NEW = "//div[span[contains(text(), 'Insurance Type')]]/following-sibling::div";
    private static final String LO_TXT_ENTER_YOUR_CREDIT_CARD_NUMBER_TITLE = "//strong[contains(text(), 'Enter your credit card number:')]";
    private static final String LO_TXT_ENTER_YOUR_CREDIT_CARD_NUMBER_PARAGRAPH = "//p[text()=\"Ensure that the credit card details entered were used to make the purchase(s) you are claiming for. E.g., Trip, Item(s), Rental Vehicle\"]";
    private static final String LO_TXT_CATEGORY_TYPE_NEW = "//div[span[contains(text(), 'Card Category')]]/following-sibling::div";
    private static final String LO_TXT_CARD_TYPE_NEW = "//div[span[contains(text(), 'Card Type')]]/following-sibling::div";
    // About your instuance
    private static final String LO_EDT_GROUP_NAME = "//div[label='Group name']/following-sibling::div//input";
    //private static final String LO_EDT_POLICY_ID = "//div[label='Policy Number/Certificate ID']/following-sibling::div//input";
    private static final String LO_EDT_POLICY_NUMBER = "//div[label='Policy Number']/following-sibling::div//input";
    private static final String LO_EDT_FIRST_NAME = "//div[label='First Name']/following-sibling::div//div//input";
    private static final String LO_EDT_LAST_NAME = "//div[label='Last Name']/following-sibling::div//div//input";
    private static final String LO_EDT_DATE_OF_BIRTH = "//div[label='Date of Birth']/following-sibling::div//div//input";
    private static final String LO_EDT_EMAIL = "//div[label='Email']/following-sibling::div/div/input";
    private static final String LO_EDT_CONFIRM_EMAIL = "//div[label[contains(text(), 'Confirm Email')]]/following-sibling::div//input";
    private static final String LO_EDT_MOBILE_PHONE_NUMBER = "//div[label='Mobile Phone Number']/following-sibling::div//div//input";
    private static final String LO_RAD_PRIMARY_PLACE_RESIDENCE = "//div[span='Primary place of residence is:']/following-sibling::div//div[@role='radiogroup']";
    private static final String LO_EDT_HOME_ADDRESS_LINE_1 = "//div[label='Address Line 1']/following-sibling::div//div//input";
    private static final String LO_EDT_HOME_ADDRESS_LINE_2 = "//div[label='Address Line 2']/following-sibling::div//div//input";
    private static final String LO_EDT_CITY = "//div[label='City']/following-sibling::div//div//input";
    private static final String LO_LST_COUNTRY = "//div[span='Country']/following-sibling::div//div[@role='combobox']";
    private static final String LO_EDT_PROVINCE_OR_STATE = "//div[label='Province/State']/following-sibling::div//input";
    private static final String LO_EDT_PROVINCE = "//div[span='Province']/following-sibling::div//div[@role='combobox']";
    private static final String LO_EDT_COUNTRY_EXP = "//div[label='Country']/following-sibling::div//input";
    private static final String LO_EDT_COUNTRY = "//div[label='Country']/following-sibling::div//div//input";
    private static final String LO_TXT_ABOUT_CLAIMANT_HEADING = "//h3[contains(text(), 'ABOUT THE CLAIMANT')]";
    private static final String LO_EDT_POSTAL_CODE = "//div[label='Postal Code']/following-sibling::div//div//input";
    private static final String LO_RAD_PREFERRED_METHOD_COMMUNICATION_EMAIL = "//div[span='Preferred Method of Communication']/following-sibling::div//label[text()='Email']";
    private static final String LO_TXT_ADDRESS_DETAILS_HEADER_NEW_UI = "//h3[contains(text(), 'ADDRESS DETAILS')]";
    private static final String LO_RAD_POLICY_HOLDER_YES = "//div[span='Are you the policy holder?']//label[contains(text(),'Yes')]";
    private static final String LO_RAD_POLICY_HOLDER_YES_CL = "//div[span='Are you the policy holder?']/following-sibling::div//label[text()='Yes']";
    private static final String LO_RAD_INDIVIDUAL_EMBEDDED = "//label[contains(text(), 'Individual/Embedded')]";
    private static final String LO_EDT_CREDIT_CARD_FIRST_4_DIGITS = "//div[label='First 4 Digits']/following-sibling::div/div/input";
    private static final String LO_TXT_CREDIT_CARD = "//strong[contains(text(), 'Enter your credit card number:')]";
    private static final String LO_EDT_CREDIT_CARD_LAST_4_DIGITS = "//div[label='Last 4 Digits']/following-sibling::div/div/input";
    private static final String LO_TXT_ABOUT_THE_CLAIMANT_HEADER = "//h3[contains(text(), 'About the Claimant')]";
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
    private static final String LO_EDT_HEALTH_CARD_NUMBER = "//div[label='Provincial Health Card Number']/following-sibling::div//input";
    private static final String LO_TXT_CARD_HOLDER_HEADER_NEW_UI = "//h3[contains(text(), 'CARDHOLDER INFORMATION')]";
    private static final String LO_EDT_SCHOOL_NAME = "//div[label='Name of School']/following-sibling::div/div/input";
    private static final String LO_EDT_PROVINCIAL_HEALTH_CARD_NUMBER = "//div[label='Provincial Health Card Number (if applicable)']/following-sibling::div//div//input";
    private static final String LO_RAD_NO_PROGRAM_COORDINATOR = "//span[contains(text(),'organization or cardholder')]/../following-sibling::div//label[text()='No']";
    private static final String LO_EDT_COMPANY_NAME = "//div[label='Name of Company']/following-sibling::div/div/input";
    private static final String LO_RAD_NO_PROGRAM_CORDINATOR = "//div[span='Are you the Program Coordinator completing the claim on behalf of the organization or cardholder?']/following-sibling::div//label[text()='No']";
    private static final String LO_LNK_WHERE_TO_FIND_INORMATION = " //strong[contains(text(),'Where can I find this information?')]";
    private static final String LO_TXT_PURCHASED_INSURANCE = "//p[text()='Purchased Insurance']";
    private static final String LO_TXT_INDIVIDUAL_INSURANCE_INFO_PAGE = "//strong[text()='Individual Insurance']";
    private static final String LO_EDT_PROVINCIAL_HEALTH_CARD = "//div[label='Provincial Health Card Number']/following-sibling::div//div//input";
    private static final String LO_TXT_INDIVIDUAL_INSURANCE_INSURANCE_TYPE = "//h4[span[text()='Insurance Type']]/following-sibling::div//p[text()='Individual Insurance']";
    private static final String LO_BUT_BACK = "//span[text()='Back']";
    //private static final String LO_BUT_SAVE_DRAFT = "//span//span[contains(text(),'Save as Draft')]";
    private static final String LO_TXT_PURCHASED_INSURANCE_INSURANCE_TYPE = "//h4[span[contains(text(), 'Insurance Type')]]/following-sibling::div//p[contains(text(), 'Purchased Insurance')]";
    private static final String LO_RAD_NO_POLICY_HOLDER = "//div[span='Are you the policy holder?']/following-sibling::div//label[text()='No']";
    private static final String LO_LST__YOUR_RELATIONSHIP_TO_INSURED = "//div[span=\"What is your relationship to the insured/policy holder?\"]/following-sibling::div//div[span[contains(text(), '--Select Relationship--')] and @role='combobox']";
    private static final String LO_EDT_FIRST_NAME_POLICY_HOLDER = "//div[label='First Name of Policy holder']/following-sibling::div//input";
    private static final String LO_EDT_LAST_NAME_POLICY_HOLDER = "//div[label='Last Name of Policy holder']/following-sibling::div//input";
    private static final String LO_EDT_DATE_OF_BIRTH_POLICY_HOLDER = "//div[div[div[div[label='Last Name of Policy holder']]]]/following-sibling::div//div[label='Date of Birth']/following-sibling::div//input";
    private static final String LO_EDT_PHONE_NUMBER_POLICY_HOLDER = "//div[div[div[div[label='Last Name of Policy holder']]]]/following-sibling::div//div[label='Phone']/following-sibling::div//input";
    private static final String LO_EDT_EMAIL_POLICY_HOLDER = "//div[div[div[div[label='Last Name of Policy holder']]]]/following-sibling::div//div[label='Email']/following-sibling::div//input";
    private static final String LO_EDT_CONFIRM_EMAIL_POLICY_HOLDER = "//div[div[div[div[label='Last Name of Policy holder']]]]/following-sibling::div//div[label='Confirm Email']/following-sibling::div//input";
    private static final String LO_RAD_YES_POLICY_HOLDER_ADDRESS_SAME_AS_CLAIMANT = "//div[span=\"Is the Policyholder's address the same as the Claimant's address?\"]/following-sibling::div//label[text()='Yes']";
    private static final String LO_RAD_YES_CLAIMING_FOR_OTHER_INSURED_PERSON = "//div[span='Are you claiming for any other insured person(s)?']/following-sibling::div//label[text()='Yes']";
    private static final String LO_RAD_YES_OTHER_INSURED_PERSON_UNDER_SAME_POLICY = "//div[span='Is the other insured person under the same policy?']/following-sibling::div//label[text()='Yes']";
    private static final String LO_EDT_FIRST_NAME_OTHER_INSURED_PERSON = "//div[div[div[div[div[div[span='Is the other insured person under the same policy?']]]]]]/following-sibling::div//div[label='First Name']/following-sibling::div//input";
    private static final String LO_EDT_LAST_NAME_OTHER_INSURED_PERSON = "//div[div[div[div[div[div[span='Is the other insured person under the same policy?']]]]]]/following-sibling::div//div[label='Last Name']/following-sibling::div//input";
    private static final String LO_LST_OTHER_INSURED_PERSON_RELATIONSHIP_TO_POLICY_HOLDER = "//div[span=\"Relation of other insured person to the policy holder/claimant?\"]/following-sibling::div//div[span[contains(text(), '--Select Relationship--')] and @role='combobox']";
    private static final String LO_EDT_DATE_OF_BIRTH_OTHER_INSURED_PERSON = "//div[div[div[div[div[div[span='Is the other insured person under the same policy?']]]]]]/following-sibling::div//div[label='Date of Birth']/following-sibling::div//input";
    private static final String LO_RAD_YES_OTHER_INSURANCE_RELATED_TO_THIS_CLAIM = "//div[span=\"Do you have any other insurance related to this claim?\"]/following-sibling::div//label[text()='Yes']";
    private static final String LO_LST_TYPE_OF_INSURANCE_YOU_HAVE = "//div[span=\"What type of insurance do you have?\"]/following-sibling::div//div[span[contains(text(), '--Select Insurance Type--')] and @role='combobox']";
    private static final String LO_EDT_CARD_ISSUER_NAME = "//div[label=\"Card issuer name\"]/following-sibling::div//input";
    private static final String LO_EDT_FIRST_6_DIGITS_OF_CREDIT_CARD = "//div[label=\"First 6 Digits\"]/following-sibling::div//input";
    private static final String LO_EDT_LAST_4_DIGITS_OF_CREDIT_CARD = "//div[label=\"Last 4 Digits\"]/following-sibling::div//input";
    private static final String LO_RAD_YES_FILED_A_CLAIM_WITH_THEM = "//div[span='Have you filed a claim with them?']/following-sibling::div//label[text()='Yes']";
    private static final String LO_UPLOAD_A_COPY_OF_CLAIM = "//div[span='Attach a copy of the claim']/following-sibling::div//input";
    private static final String LO_EDT_CREDIT_CARD_TYPE = "//div[label[contains(text(), 'Credit Card Type')]]/following-sibling::div//input";
    private static final String LO_EDT_MEMBER_ID_ONLY = "//div[label[contains(text(), 'Member ID')]]/following-sibling::div//input";
    private static final String LO_EDT_PROVINCIAL_HEALTH_CARD_NUMBER_ONLY = "//div[label='Provincial Health Card Number']/following-sibling::div//div//input";
    //private static final String LO_EDT_CREDIT_CARD_TYPE = "//div[label='Credit Card Type']/following-sibling::div/div/input";
    private static final String LO_EDT_POLICY_ID = "//div[label[contains(text(), 'Policy Number/Certificate ID ')] or label[contains(text(), 'Policy Number/Certificate ID')]]//following-sibling::div//input";
    private static final String LO_EDT_INSURANCE_COMPANY = "//div[label[contains(text(), 'Insurance Company')]]/following-sibling::div//input";
    private static final String LO_TXT_POLICY_NUMBER_LABEL = "//label[contains(text(), 'Policy Number')]";
    private static final String LO_TXT_POLICY_NUMBER_CERTIFICATE_ID_LABEL = "//label[contains(text(), 'Policy Number/Certificate ID')]";
    private static final String LO_LST_COUNTRY_CODE = "//div[span[text()='Country code']]/following-sibling::div//div[@role='combobox']";
    private static final String LO_EDT_EMPLOYEE_NAME = "//div[label='Employer Name']/following-sibling::div//input";
    private static final String LO_TXT_SESSION_EXPIRATION = "//div[h3[contains(text(), 'Session expires in:')]]";
    private static final String LO_TXT_PRE_CLAIM_SUBMISSION_PAGE_VERIFY = "//h2[contains(text(), 'PRE-CLAIM SUBMISSION')]";
    private static final String LO_TXT_POLICY_HOLDER_HEADER_NEW_UI = "//h3[contains(text(), 'POLICY HOLDER')]";
    private static final String LO_TXT_OTHER_INSURED_PERSON_HEADER_NEW_UI = "//h3[contains(text(), 'OTHER INSURED PERSON(S)')]";
    private static final String LO_TXT_OTHER_INSURANCE_TYPE_HEADER_NEW_UI = "//h3[contains(text(), 'OTHER INSURANCE TYPE')]";

    //---------------------------------------------------- FR locators -----------------------------------------------------------

    private static final String LO_TXT_INSURED_INFO_HEADER_FR = "";
    private static final String LO_EDT_FIRST_6_DIGITS_OF_CREDIT_CARD_FR = "";
    private static final String LO_EDT_LAST_4_DIGITS_OF_CREDIT_CARD_FR = "";
    private static final String LO_EDT_CONTRACT_OR_GROUP_NUMBER_FR = "";
    private static final String LO_EDT_MEMBER_IDSL_FR = "";
    private static final String LO_EDT_CREDIT_CARD_LAST_4_DIGITS_FR = "";
    private static final String LO_EDT_FIRST_NAME_FR = "//div[label='Prénom']/following-sibling::div//div//input";
    private static final String LO_EDT_LAST_NAME_FR = "//div[label='Nom de famille']/following-sibling::div//div//input";
    private static final String LO_EDT_DATE_OF_BIRTH_FR = "//div[label='Date de naissance']/following-sibling::div//div//input";
    private static final String LO_LST_COUNTRY_CODE_FR = "//div[label='Country Code']/following-sibling::div//div//input";
    private static final String LO_EDT_MOBILE_PHONE_NUMBER_FR = "";
    private static final String LO_EDT_EMPLOYEE_NAME_FR = "//div[label='Nom de l\'employeur']/following-sibling::div//input";
    private static final String LO_EDT_EMAIL_FR = "//div[label='Courriel']/following-sibling::div/div/input";
    private static final String LO_EDT_CONFIRM_EMAIL_FR = "";
    private static final String LO_RAD_PREFERRED_METHOD_COMMUNICATION_EMAIL_FR = "";
    private static final String LO_EDT_HOME_ADDRESS_LINE_1_FR = "";
    private static final String LO_EDT_HOME_ADDRESS_LINE_2_FR = "";
    private static final String LO_EDT_CITY_FR = "";
    private static final String LO_EDT_COMPANY_NAME_FR = "";
    private static final String LO_EDT_PROVINCE_FR = "";
    private static final String LO_EDT_COUNTRY_FR = "";
    private static final String LO_EDT_POSTAL_CODE_FR = "";
    private static final String LO_EDT_PROVINCIAL_HEALTH_CARD_FR = "";
    private static final String LO_RAD_YES_CARD_HOLDER_FR = "";
    private static final String LO_RAD_PRIMARY_CARD_HOLDER_FR = "";
    private static final String LO_RAD_NO_CLAIM_OTHER_INSURED_PERSON_FR = "";
    private static final String LO_RAD_NO_OTHER_INSURANCE_FR = "";
    private static final String LO_BUT_CONTINUE_FR = "";
    private static final String LO_EDT_POLICY_ID_FR = "";
    private static final String LO_RAD_POLICY_HOLDER_YES_CL_FR = "";
    private static final String LO_EDT_PROVINCE_OR_STATE_FR = "";
    private static final String LO_LST_COUNTRY_FR = "";
    private static final String LO_RAD_NO_INSURED_PERSON_CL_FR = "";
    private static final String LO_TXT_ABOUT_YOUR_INSURANCE_HEADER_FR = "";
    private static final String LO_TXT_ABOUT_YOUR_CLAIMANT_HEADER_NEW_UI_FR = "";
    private static final String LO_TXT_ADDRESS_DETAILS_HEADER_NEW_UI_FR = "";
    private static final String LO_TXT_POLICY_HOLDER_HEADER_NEW_UI_FR = "";
    private static final String LO_TXT_OTHER_INSURED_PERSON_HEADER_NEW_UI_FR = "";
    private static final String LO_TXT_OTHER_INSURANCE_TYPE_HEADER_NEW_UI_FR = "";
    private static final String LO_RAD_PRIMARY_PLACE_RESIDENCE_FR = "";
    private static final String LO_EDT_PROVINCIAL_HEALTH_CARD_NUMBER_FR = "";
    private static final String LO_EDT_HEALTH_CARD_NUMBER_FR = "";
    private static final String LO_TXT_ADDRESS_DETAILS_TITLE_FR = "";
    private static final String LO_TXT_ENTER_YOUR_CREDIT_CARD_NUMBER_PARAGRAPH_FR = "//p";
    private static final String LO_TXT_ENTER_YOUR_CREDIT_CARD_NUMBER_TITLE_FR = "";
    private static final String LO_TXT_ABOUT_THE_CLAIMANT_TITLE_FR = "";
    private static final String LO_TXT_CARD_TYPE_NEW_FR = "";
    private static final String LO_TXT_CATEGORY_TYPE_NEW_FR = "";
    private static final String LO_TXT_INSURANCE_TYPE_NEW_FR = "";
    private static final String LO_TXT_ABOUT_YOUR_INSURANCE_TITLE_FR = "";
    private static final String LO_TXT_CARD_HOLDER_HEADER_NEW_UI_FR = "";
    private static final String LO_EDT_MEMBER_ID_CL_FR = "";
    private static final String LO_EDT_PLAN_NUMBER_FR = "";
    private static final String LO_EDT_EMPLOYER_NAME_FR = "";
    private static final String LO_EDT_CREDIT_CARD_TYPE_FR = "";
    private static final String LO_EDT_INSURANCE_COMPANY_FR = "";
    private static final String LO_TXT_INDIVIDUAL_INSURANCE_INFO_PAGE_FR = "";
    private static final String LO_EDT_GROUP_NAME_FR = "";
    private static final String LO_EDT_SCHOOL_NAME_FR = "";
    private static final String LO_EDT_CONTRACT_NUMBER_FR = "";
    private static final String LO_EDT_EMPLOYER_OR_GROUP_NAME_FR = "";
    private static final String LO_LNK_WHERE_TO_FIND_INORMATION_FR = "";
    private static final String LO_EDT_CREDIT_CARD_FIRST_4_DIGITS_FR = "";
    private static final String LO_RAD_NO_PROGRAM_COORDINATOR_FR = "";
    private static final String LO_RAD_YES_PROGRAM_COORDINATOR_FR = "";
    private static final String LO_TXT_CLAIM_OPENING_HEADING_FR = "";

    /**
     * Define the Page Object (PO) constructor.
     * 
     * @param driver The WebDriver object passed from the test method.
     */
    // [Note: Automation Engineer, rename this Page Object (PO) class to match the
    // filename.]
    public PO_Insured_Info(WebDriver driver) {
        super(driver);
    }

    /**
     * Validates if current webpage is loaded and correct.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object validateOnPage(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_INSURED_INFO_HEADER_FR : LO_TXT_INSURED_INFO_HEADER;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    public Object scrolled() {
        typeOnKeyboard("ARROW_DOWN");
        typeOnKeyboard("ARROW_DOWN");
        typeOnKeyboard("ARROW_DOWN");
        return "[Pass] - srcolled down";
    }
    public Object verifyAboutYourInsuranceTitle(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_ABOUT_YOUR_INSURANCE_TITLE_FR : LO_TXT_ABOUT_YOUR_INSURANCE_TITLE;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object verifyAboutYourClaimantNewUITitle(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_ABOUT_YOUR_CLAIMANT_HEADER_NEW_UI_FR : LO_TXT_ABOUT_YOUR_CLAIMANT_HEADER_NEW_UI;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    public Object validateAboutYourInsuranceHeading(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_ABOUT_YOUR_INSURANCE_TITLE_FR : LO_TXT_ABOUT_YOUR_INSURANCE_TITLE;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    public Object clickTheAboutTheClaimantHeading(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_ABOUT_THE_CLAIMANT_TITLE_FR : LO_TXT_ABOUT_THE_CLAIMANT_TITLE;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    public Object validateAddressDetailsHeading(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_ADDRESS_DETAILS_TITLE_FR : LO_TXT_ADDRESS_DETAILS_TITLE;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    public Object validateEnterYourCreditCardNumberHeading(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_ENTER_YOUR_CREDIT_CARD_NUMBER_TITLE_FR : LO_TXT_ENTER_YOUR_CREDIT_CARD_NUMBER_TITLE;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object validateEnterYourCreditCardNumberParagraph(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_ENTER_YOUR_CREDIT_CARD_NUMBER_PARAGRAPH_FR : LO_TXT_ENTER_YOUR_CREDIT_CARD_NUMBER_PARAGRAPH;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    public Object verifyInsuranceType(String insuranceType) {
        String result = validateWithinLocatorText(LO_TXT_INSURANCE_TYPE_NEW,insuranceType,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    public Object verifyCategoryType(String insuranceType) {
        String result = validateWithinLocatorText(LO_TXT_CATEGORY_TYPE_NEW,insuranceType,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    public Object verifyCardType(String insuranceType) {
        String result = validateWithinLocatorText(LO_TXT_CARD_TYPE_NEW,insuranceType,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object validatePreClaimSubmissionPage() {
        String result = validateLocatorExists(LO_TXT_PRE_CLAIM_SUBMISSION_PAGE_VERIFY, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object verifySessionExpiration() {
        String result = validateLocatorExists(LO_TXT_SESSION_EXPIRATION, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if current webpage is loaded and correct.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object verifyPurchasedInsurance() {
        String result = validateLocatorExists(LO_TXT_PURCHASED_INSURANCE, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if current webpage is loaded and correct.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object verifyIndividualInsurance() {
        String result = validateLocatorExists(LO_TXT_INDIVIDUAL_INSURANCE_INFO_PAGE, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Enter the name of school a student goes to.
     * 
     * @param nameOfSchool The name of scholl to be entered.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object enterNameOfSchool(String creditCardSixDigits) {
        String result = setText(LO_EDT_SCHOOL_NAME, creditCardSixDigits, FW_ConfigMgr.getDefaultTimeout(), false);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object scrollTop3() {
        String result = scrollToLocator(LO_TXT_CREDIT_CARD);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object verifyAboutTheClaimantHeader() {
        String result = validateLocatorExists(LO_TXT_ABOUT_THE_CLAIMANT_HEADER, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Selects the 'Individual Embedded' option.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object selectIndividual_Embedded() {
        String result = clickLocator(LO_RAD_INDIVIDUAL_EMBEDDED, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Enters a first name.
     * 
     * @param firstName The first name to be entered.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object enterFirstName(String language, String firstName) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_EDT_FIRST_NAME_FR : LO_EDT_FIRST_NAME;
        String result = setText(locator, firstName, FW_ConfigMgr.getDefaultTimeout(), false);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Enters a last name.
     * 
     * @param lastName The last name to be entered.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object enterLastName(String language, String lastName) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_EDT_LAST_NAME_FR : LO_EDT_LAST_NAME;
        String result = setText(locator, lastName, FW_ConfigMgr.getDefaultTimeout(), false);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Enters a date of birth.
     * 
     * @param dateOfBirth The date of birth to be entered.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object enterDOB(String language, String dateOfBirth) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_EDT_DATE_OF_BIRTH_FR : LO_EDT_DATE_OF_BIRTH;
        String result = setText(locator, dateOfBirth, FW_ConfigMgr.getDefaultTimeout(), false);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        clickLocator("//div[label='Date of Birth']", FW_ConfigMgr.getDefaultTimeout());
        return resultObj;
    }

    /**
     * Enters an email.
     * 
     * @param email The email to be entered.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object enterEmail(String language, String email) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_EDT_EMAIL_FR : LO_EDT_EMAIL;
        String result = setText(locator, email, FW_ConfigMgr.getDefaultTimeout(), false);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Enters a confirmation email.
     * 
     * @param confirmEmail The confirmation email to be entered.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object enterConfirmEmail(String language, String confirmEmail) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_EDT_CONFIRM_EMAIL_FR : LO_EDT_CONFIRM_EMAIL;
        String result = setText(locator, confirmEmail, FW_ConfigMgr.getDefaultTimeout(), false);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Enter primary place of residence.
     * 
     * @param placeOfResidence The place of residence to be entered.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object enterPrimaryPlaceOfResidence(String placeOfResidence) {
        String result = selectRadioButtonInGroup(LO_RAD_PRIMARY_PLACE_RESIDENCE, placeOfResidence,
                FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Enters a employer name.
     * 
     * @param employerName The employer name to be entered.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object enterEmployerName(String employerName) {
        String result = setText(LO_EDT_EMPLOYER_NAME, employerName, FW_ConfigMgr.getDefaultTimeout(), false);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Enters a Contract/Group Number.
     * 
     * @param contractOrGroupNumber The employer name to be entered.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object enterContractOrGroupNumber(String contractOrGroupNumber) {
        String result = setText(LO_EDT_CONTRACT_OR_GROUP_NUMBER, contractOrGroupNumber,
                FW_ConfigMgr.getDefaultTimeout(), false);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Enters a employer name.
     * 
     * @param groupName The group name to be entered.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object enterGroupName(String language, String groupName) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_EDT_GROUP_NAME_FR : LO_EDT_GROUP_NAME;
        String result = setText(locator, groupName, FW_ConfigMgr.getDefaultTimeout(), false);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Enters a plan number.
     * 
     * @param planNumber The plan number to be entered.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object enterPlanNumber(String planNumber) {
        String result = setText(LO_EDT_PLAN_NUMBER, planNumber, FW_ConfigMgr.getDefaultTimeout(), false);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    // TODO: Determine if Orion really needs it's own specilized version of this
    // method.
    /**
     * Enters a plan number. (Orion specific)
     * 
     * @param planNumber The plan number to be entered.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object enterPlanNumberOrion(String planNumber) {
        String result = setText(LO_EDT_PLAN_NUMBER_ORION, planNumber, FW_ConfigMgr.getDefaultTimeout(), false);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Enters a member id .
     * 
     * @param memberID The member id to be entered.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object enterMemberId(String memberID) {
        String result = setText(LO_EDT_MEMBER_ID, memberID, FW_ConfigMgr.getDefaultTimeout(), false);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Enters a member id for SunLife.
     * 
     * @param memberIdSn The member id to be entered.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object enterMemberIdSL(String memberIdSn) {
        String result = setText(LO_EDT_MEMBER_IDSL, memberIdSn, FW_ConfigMgr.getDefaultTimeout(), false);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Enters a member id for CL portal.
     * 
     * @param memberID The member id to be entered.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object enterMemberId_CL(String memberID) {
        String result = setText(LO_EDT_MEMBER_ID_CL, memberID, FW_ConfigMgr.getDefaultTimeout(), false);
        clickLocator("//div[label='Employee/Member ID']", FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Enters a employer/Group name.
     * 
     * @param employerGroupName The employer Group name to be entered.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object enterEmployerOrGroupName(String employerGroupName) {
        String result = setText(LO_EDT_EMPLOYER_OR_GROUP_NAME, employerGroupName, FW_ConfigMgr.getDefaultTimeout(),
                false);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Enters a contract number.
     * 
     * @param contractNumber The contract number to be entered.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object enterContractNumber(String contractNumber) {
        String result = setText(LO_EDT_CONTRACT_NUMBER, contractNumber, FW_ConfigMgr.getDefaultTimeout(), false);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Enters a member certificate number .
     * 
     * @param memberCertificateNumber The certificate number to be entered.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object enterMemberCertificateNumber(String memberCertificateNumber) {
        String result = setText(LO_EDT_MEMBER_CERTIFICATE_NUMBER, memberCertificateNumber,
                FW_ConfigMgr.getDefaultTimeout(), false);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Enters a policy id .
     * 
     * @param policyNumberCertID The policy number certificate id to be entered.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object enterPolicyNumberCertificateId(String language, String policyNumberCertID) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_EDT_POLICY_ID_FR : LO_EDT_POLICY_ID;
        String result = setText(locator, policyNumberCertID, FW_ConfigMgr.getDefaultTimeout(), false);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Enters a policy Number .
     * 
     * @param policyNumber The policy number certificate id to be entered.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object enterPolicyNumber(String policyNumber) {
        String result = setText(LO_EDT_POLICY_NUMBER, policyNumber, FW_ConfigMgr.getDefaultTimeout(), false);
        clickLocator(LO_TXT_POLICY_NUMBER_LABEL, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Selects 'No' for the travel companion option.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object selectNoForOtherInsuredPerson(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_RAD_NO_CLAIM_OTHER_INSURED_PERSON_FR : LO_RAD_NO_CLAIM_OTHER_INSURED_PERSON;
        String result = clickLocator(locator, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Enters an address line 1.
     * 
     * @param addressLine1 The address line 1 to be entered.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object enterAddressLine1(String language, String addressLine1) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_EDT_HOME_ADDRESS_LINE_1_FR : LO_EDT_HOME_ADDRESS_LINE_1;
        String result = setText(locator, addressLine1, FW_ConfigMgr.getDefaultTimeout(), false);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Enters an address line 2.
     * 
     * @param addressLine2 The address line 2 to be entered.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object enterAddressLine2(String language, String addressLine2) {
        String result = setText(LO_EDT_HOME_ADDRESS_LINE_2, addressLine2, FW_ConfigMgr.getDefaultTimeout(), false);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Enters a city.
     * 
     * @param city The city to be entered.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object enterCity(String language, String city) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_EDT_CITY_FR : LO_EDT_CITY;
        String result = setText(locator, city, FW_ConfigMgr.getDefaultTimeout(), false);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object selectCountry(String language, String country) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_LST_COUNTRY_FR : LO_LST_COUNTRY;
        String result = setDropdownAppian(locator, country, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object enterProvinceOrState(String language, String provinceOrState) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_EDT_PROVINCE_OR_STATE_FR : LO_EDT_PROVINCE_OR_STATE;
        String result = setText(locator, provinceOrState, FW_ConfigMgr.getDefaultTimeout(), false);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Selects a province.
     * 
     * @param province The province to be selected.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object selectProvince(String language, String province) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_EDT_PROVINCE_FR : LO_EDT_PROVINCE;
        String result = setDropdownAppian(locator, province, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    // TODO_this method was implemented as a workaround to the issue with the
    // dropdown menu.
    /**
     * 
     * Will revisit this method to implement a better solution.
     * 
     * Selects "Other" option from the dropdown menu.
     * 
     * @return True if the key was typed, false otherwise.
     */
    public Object clickOntario() {
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
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Enters a country.
     * 
     * @param country The country to be entered.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object enterCountry(String language, String country) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_EDT_COUNTRY_FR : LO_EDT_COUNTRY;
        String result = setText(locator, country, FW_ConfigMgr.getDefaultTimeout(), true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Enters a postal code.
     *
     * @param postalCode The postal code to be entered.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object enterPostalCode(String language, String postalCode) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_EDT_POSTAL_CODE_FR : LO_EDT_POSTAL_CODE;
        String result = setText(locator, postalCode, FW_ConfigMgr.getDefaultTimeout(), false);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Selects the method of communication.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object selectMethodOfCommunication(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_RAD_PREFERRED_METHOD_COMMUNICATION_EMAIL_FR : LO_RAD_PREFERRED_METHOD_COMMUNICATION_EMAIL;
        String result = clickLocator(locator, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    public Object verifyAddressDetailsNewUITitle(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_ADDRESS_DETAILS_HEADER_NEW_UI_FR : LO_TXT_ADDRESS_DETAILS_HEADER_NEW_UI;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object clickTheAboutTheClaimant() {
        clickLocator("//h1[contains(text(), 'Claim Opening')]", FW_ConfigMgr.getDefaultTimeout());
        typeOnKeyboard("ARROW_UP");
        typeOnKeyboard("ARROW_UP");
        typeOnKeyboard("ARROW_UP");
        typeOnKeyboard("ARROW_UP");
        typeOnKeyboard("ARROW_UP");
        waitForDuration(2, "s", true);
        String result = clickLocator(LO_TXT_ABOUT_CLAIMANT_HEADING, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Selects "Email" as your preferred method of communication.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object selectEmailAsMethodOfCommunication(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_RAD_PREFERRED_METHOD_COMMUNICATION_EMAIL_FR : LO_RAD_PREFERRED_METHOD_COMMUNICATION_EMAIL;
        String result = clickLocator(locator, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Selects 'Yes' for the policy holder option.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object selectYesAsPolicyHolder(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_RAD_POLICY_HOLDER_YES_CL_FR : LO_RAD_POLICY_HOLDER_YES_CL;
        String result = clickLocator(locator, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Selects 'No' to question : Are you claiming for any other insured person(s)?.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object selectNoClaimingforOtherInsuredPerson(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_RAD_NO_CLAIM_OTHER_INSURED_PERSON_FR : LO_RAD_NO_CLAIM_OTHER_INSURED_PERSON;
        String result = clickLocator(locator, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Selects 'No' for the other insurance option.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object selectNoOtherInsuranceRelatedToThisClaim(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_RAD_NO_OTHER_INSURANCE_FR : LO_RAD_NO_OTHER_INSURANCE;
        String result = clickLocator(locator, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Selects 'Yes' for the card holder option.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object selectYesforCardHolder(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_RAD_YES_CARD_HOLDER_FR : LO_RAD_YES_CARD_HOLDER;
        String result = clickLocator(locator, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Selects the primary card holder option.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object selectPrimaryCardHolder(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_RAD_PRIMARY_CARD_HOLDER_FR : LO_RAD_PRIMARY_CARD_HOLDER;
        String result = clickLocator(locator, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Selects 'Yes' for the program coordinator option.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object selectYesforProgamCoordinator() {
        String result = clickLocator(LO_RAD_YES_PROGRAM_COORDINATOR, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Selects 'No' for the program coordinator option.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object selectNoForProgamCoordinator() {
        String result = clickLocator(LO_RAD_NO_PROGRAM_CORDINATOR, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Selects 'No' for the travel companion option.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object selectNoFORTRAVELCOMPANION() {
        String result = clickLocator(LO_RAD_NO_TRAVEL_COMPANION, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Enters health card number.
     * 
     * @param HealthcardNumber The employer name to be entered.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object enterHealtCardNumber(String language, String HealthcardNumber) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_EDT_HEALTH_CARD_NUMBER_FR : LO_EDT_HEALTH_CARD_NUMBER;
        String result = setText(locator, HealthcardNumber, FW_ConfigMgr.getDefaultTimeout(), false);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object varidatCardHolderTitle(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_CARD_HOLDER_HEADER_NEW_UI_FR : LO_TXT_CARD_HOLDER_HEADER_NEW_UI;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    public Object varidatPolicyHolderTitle(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_POLICY_HOLDER_HEADER_NEW_UI_FR : LO_TXT_POLICY_HOLDER_HEADER_NEW_UI;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object varidateOtherInsuredPersonsTitle(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_OTHER_INSURED_PERSON_HEADER_NEW_UI_FR : LO_TXT_OTHER_INSURED_PERSON_HEADER_NEW_UI;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object varidateOtherInsuranceTypeTitle(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_OTHER_INSURANCE_TYPE_HEADER_NEW_UI_FR : LO_TXT_OTHER_INSURANCE_TYPE_HEADER_NEW_UI;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Clicks the 'Continue' button.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object clickButtonContinue(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_BUT_CONTINUE_FR : LO_BUT_CONTINUE;
        String result = clickLocator(locator, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Selects 'No' for the program coordinator option.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object selectNoforProgamCoordinator() {
        String result = clickLocator(LO_RAD_NO_PROGRAM_COORDINATOR, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Enter the company name.
     * 
     * @param companyName The name of scholl to be entered.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object enterCompanyName(String companyName) {
        String result = setText(LO_EDT_COMPANY_NAME, companyName, FW_ConfigMgr.getDefaultTimeout(), false);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /*
     * Clicks on "Where can I find this information?"
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     * details.
     */

    public Object clickOnWhereToFindInformation() {
        String result = clickLocator(LO_LNK_WHERE_TO_FIND_INORMATION, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName());
        return result;
    }

    /**
     * Selects 'Outside Canada' as the primary place of residence.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object selectOutsideCanada() {
        String result = clickLocator(LO_RAD_PRIMARY_PLACE_RESIDENCE, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName());
        return result;
    }

    /**
     * Scrolls to the top of the page.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object scrollTop() {
        String result = scrollToLocator(LO_TXT_INSURED_INFO_HEADER);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if individual insurance was selected and visible in the insured
     * info page.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object verifyIndividualInsuranceWasSelected() {
        String result = validateLocatorExists(LO_TXT_INDIVIDUAL_INSURANCE_INSURANCE_TYPE,
                FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Clicks the "Back" button.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object clickBackButton() {
        String result = clickLocator(LO_BUT_BACK, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if purchase insurance was selected and visible in the insured info
     * page.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object verifyPurchasedInsuranceWasSelected() {
        String result = validateLocatorExists(LO_TXT_PURCHASED_INSURANCE_INSURANCE_TYPE,
                FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
<<<<<<< HEAD
     * Selects 'Yes' for the policy holder option.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object selectNoAsPolicyHolder() {
        String result = clickLocator(LO_RAD_NO_POLICY_HOLDER, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Selects from the dropdown : What is your relationship to the insured/policy holder?.
     * 
     * @param yourRelationshipToInsuredPerson to be selected.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object selectYourRelationshipToTheInsured(String yourRelationshipToInsuredPerson) {
        String result = setDropdownAppian(LO_LST__YOUR_RELATIONSHIP_TO_INSURED, yourRelationshipToInsuredPerson, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Enters First Name of Policy holder.
     * 
     * @param firstName The First Name of Policy holder to be entered.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object enterFirstNameOfPolicyHolder(String firstNameOfPolicyHolder) {
        String result = setText(LO_EDT_FIRST_NAME_POLICY_HOLDER, firstNameOfPolicyHolder, FW_ConfigMgr.getDefaultTimeout(), false);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Enters Last Name of Policy holder.
     * 
     * @param lastName The Last Name of Policy holder to be entered.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object enterLastNameOfPolicyHolder(String lastNameOfPolicyHolder) {
        String result = setText(LO_EDT_LAST_NAME_POLICY_HOLDER, lastNameOfPolicyHolder, FW_ConfigMgr.getDefaultTimeout(), false);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Enters Date of Birth of Policy holder.
     * 
     * @param dateOfBirthOfPolicyHolder The Date of Birth of Policy holder to be entered.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object enterDateOfBirthOfPolicyHolder(String dateOfBirthOfPolicyHolder) {
        String result = setText(LO_EDT_DATE_OF_BIRTH_POLICY_HOLDER,dateOfBirthOfPolicyHolder, FW_ConfigMgr.getDefaultTimeout(), false);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Enters Phone Number of Policy holder.
     * 
     * @param phoneNumberOfPolicyHolder The Phone Number of Policy holder to be entered.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object enterPhoneNumberOfPolicyHolder(String phoneNumberOfPolicyHolder) {
        String result = setText(LO_EDT_PHONE_NUMBER_POLICY_HOLDER,phoneNumberOfPolicyHolder, FW_ConfigMgr.getDefaultTimeout(), false);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Enters Email of Policy holder.
     * 
     * @param emailOfPolicyHolder The Email of Policy holder to be entered.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object enterEmailOfPolicyHolder(String emailOfPolicyHolder) {
        String result = setText(LO_EDT_EMAIL_POLICY_HOLDER,emailOfPolicyHolder, FW_ConfigMgr.getDefaultTimeout(), false);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Enters Confirm Email of Policy holder.
     * 
     * @param confirmEmailOfPolicyHolder The Email of Policy holder to be entered.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object enterConfirmEmailOfPolicyHolder(String confirmEmailOfPolicyHolder) {
        String result = setText(LO_EDT_CONFIRM_EMAIL_POLICY_HOLDER,confirmEmailOfPolicyHolder, FW_ConfigMgr.getDefaultTimeout(), false);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Selects 'Yes' to question : Is the Policyholder's address the same as the Claimant's address?.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object selectYesPolicyHoldersAddressSameAsClaimant() {
        String result = clickLocator(LO_RAD_YES_POLICY_HOLDER_ADDRESS_SAME_AS_CLAIMANT, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Selects 'Yes' to question : Are you claiming for any other insured person(s)?.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object selectYesClaimingForOtherInsuredPerson() {
        String result = clickLocator(LO_RAD_YES_CLAIMING_FOR_OTHER_INSURED_PERSON, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

     /**
     * Selects 'Yes' to question : Is the other insured person under the same policy? .
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object selectYesOtherInsuredPersonUnderSamePolicy() {
        String result = clickLocator(LO_RAD_YES_OTHER_INSURED_PERSON_UNDER_SAME_POLICY, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Enters First Name of other Insured Person.
     * 
     * @param firstNameOfOtherInsuredPerson The First Name of other Insured Person to be entered.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object enterFirstNameOfOtherInsuredPerson(String firstNameOfOtherInsuredPerson) {
        String result = setText(LO_EDT_FIRST_NAME_OTHER_INSURED_PERSON,firstNameOfOtherInsuredPerson, FW_ConfigMgr.getDefaultTimeout(), false);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Enters Last Name of other Insured Person.
     * 
     * @param lastNameOfOtherInsuredPerson The last Name of other Insured Person to be entered.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object enterLastNameOfOtherInsuredPerson(String lastNameOfOtherInsuredPerson) {
        String result = setText(LO_EDT_LAST_NAME_OTHER_INSURED_PERSON,lastNameOfOtherInsuredPerson, FW_ConfigMgr.getDefaultTimeout(), false);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Selects from the dropdown : Relation of other insured person to the policy holder/claimant?.
     * 
     * @param relationOfOtherInsuredPersonToPolicyHolder The relationship to be selected.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object selectRelationOfInsuredPersonToPolicyHolder(String relationOfOtherInsuredPersonToPolicyHolder) {
        String result = setDropdownAppian(LO_LST_OTHER_INSURED_PERSON_RELATIONSHIP_TO_POLICY_HOLDER, relationOfOtherInsuredPersonToPolicyHolder, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Enters Date of Birth of other Insured Person.
     * 
     * @param dateOfBirthOfOtherInsuredPerson The last Name of other Insured Person to be entered.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object enterDateOfBirthOfOtherInsuredPerson(String dateOfBirthOfOtherInsuredPerson) {
        String result = setText(LO_EDT_DATE_OF_BIRTH_OTHER_INSURED_PERSON,dateOfBirthOfOtherInsuredPerson, FW_ConfigMgr.getDefaultTimeout(), false);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Selects 'Yes' to question : Do you have any other insurance related to this claim?.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object selectYesToOtherInsuranceRelatedToThisClaim() {
        String result = clickLocator(LO_RAD_YES_OTHER_INSURANCE_RELATED_TO_THIS_CLAIM, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Selects from the dropdown : What type of insurance do you have?.
     * 
     * @param typeOfInsuranceYouHave The type of insurance you have to be selected.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object selectTypeOfInsuranceYouHave(String typeOfInsuranceYouHave) {
        String result = setDropdownAppian(LO_LST_TYPE_OF_INSURANCE_YOU_HAVE,typeOfInsuranceYouHave, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Enters Card issuer name.
     * 
     * @param cardIssuerName The Card Issuer Name to be entered.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object enterCardIssuerName(String cardIssuerName) {
        String result = setText(LO_EDT_CARD_ISSUER_NAME,cardIssuerName, FW_ConfigMgr.getDefaultTimeout(), false);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Enters first 6 digits of Credit Card.
     * 
     * @param first6DigitsOfCreditCard The first 6 digits to be entered.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object enterFirst6DigitsOfCreditCard(String language, String first6DigitsOfCreditCard) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_EDT_FIRST_6_DIGITS_OF_CREDIT_CARD_FR : LO_EDT_FIRST_6_DIGITS_OF_CREDIT_CARD;
        String result = setText(locator, first6DigitsOfCreditCard, FW_ConfigMgr.getDefaultTimeout(), false);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Enters last 4 digits of Credit Card.
     * 
     * @param last4DigitsOfCreditCard The last 4 digits of credit card to be entered.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object enterLast4DigitsOfCreditCard(String language, String last4DigitsOfCreditCard) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_EDT_LAST_4_DIGITS_OF_CREDIT_CARD_FR : LO_EDT_LAST_4_DIGITS_OF_CREDIT_CARD;
        String result = setText(locator, last4DigitsOfCreditCard, FW_ConfigMgr.getDefaultTimeout(), false);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Selects 'Yes' to question : Have you filed a claim with them?.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object selectYesFiledAClaimWithThem() {
        String result = clickLocator(LO_RAD_YES_FILED_A_CLAIM_WITH_THEM, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public String uploadFileV2(String filePath, String locator) {

        String currentDirectory = System.getProperty("user.dir");
        filePath = currentDirectory + "/src/test/resources/" + filePath;
        File file = new File(filePath);
        if (!file.exists()) {
            System.out.println("File " + filePath + " does not exist.");
            return "[Fail] - Expected the file path '" + filePath + "'' to be a valid file path.";
        }

        WebElement fileInput = driver.findElement(By.xpath(locator));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.visibility='visible';", fileInput);

        fileInput.sendKeys(filePath);
        return "[Pass] - Successfully uploaded the file '" + filePath + "'' into " + locator + ".";
    }

    /**
     * Attach a copy of the claim
     * 
     * @param filePath The relative path of the invoice file from the user's home directory.
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object attachACopyOfTheClaim(String filePath) {
        waitForDuration(15, "s", false); // Wait to perform next check
        String result = uploadFileV2(filePath, LO_UPLOAD_A_COPY_OF_CLAIM);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    
     /* Enters a credit card type.
     * 
     * @param creditCardType The credit card type to be entered.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     * 
     */
    public Object enterCreditCardType(String creditCardType) {
        String result = setText(LO_EDT_CREDIT_CARD_TYPE, creditCardType, FW_ConfigMgr.getDefaultTimeout(), false);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
<<<<<<< HEAD
     * Enters a member id .
     * 
     * @param memberID The member id to be entered.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object enterMemberIdOnly(String memberID) {
        String result = setText(LO_EDT_MEMBER_ID_ONLY, memberID, FW_ConfigMgr.getDefaultTimeout(), false);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Enters a member id .
     * 
     * @param memberID The member id to be entered.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    // public Object enterMemberIdOnly(String memberID) {
    //     String result = setText(LO_EDT_MEMBER_ID_ONLY, memberID, FW_ConfigMgr.getDefaultTimeout(), false);
    //     result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
    //     return result;
    // }

     /* Enters a Provincial Health Card Number.
     * 
     * @param enterProvincialHealthCardNumber The credit card number to be entered.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     * 
     */
    public Object enterProvincialHealthCardNumber(String language, String enterProvincialHealthCardNumber) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_EDT_PROVINCIAL_HEALTH_CARD_FR : LO_EDT_PROVINCIAL_HEALTH_CARD;
        String result = setText(locator, enterProvincialHealthCardNumber, FW_ConfigMgr.getDefaultTimeout(), false);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Enters the insurance company name .
     * 
     * @param insuranceCompany The insurance company to be entered.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object enterInsuranceCompany(String insuranceCompany) {
        String result = setText(LO_EDT_INSURANCE_COMPANY, insuranceCompany, FW_ConfigMgr.getDefaultTimeout(), false);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Verify txt sustained.
     * 
     * @param expectedText the value that we expect in the field.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object verifyIfInsuranceCompanySustained(String expectedTxt, String locator) {
        waitForDuration(60, "s", true);
        String result = validateWithinLocatorText(locator, expectedTxt,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Verify txt sustained.
     * 
     * @param expectedText the value that we expect in the field.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object verifyIfFieldTextSustained(String expectedTxt, String locator) {
        //waitForDuration(60, "s", true);
        String result = validateWithinLocatorText(locator, expectedTxt,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    /**
     * Apply a wait.
     */
    public Object applyWait() {
        waitForDuration(7, "s", true);
        String result = "[Pass] - Wait applied.";
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Selects '+1 Canada ' as Country Code
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object selectCountryCode(String language, String CountryCode) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_LST_COUNTRY_CODE_FR : LO_LST_COUNTRY_CODE;
        String result = setDropdownAppian(locator, CountryCode, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Enters Mobile Phone Number.
     * 
     * @param mobilePhoneNumber The Phone Number of Policy holder to be entered.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */

    public Object enterMobilePhoneNumber(String language, String mobilePhoneNumber) {
        waitForDuration(25);
        String locator = "fr".equalsIgnoreCase(language) ? LO_EDT_MOBILE_PHONE_NUMBER_FR : LO_EDT_MOBILE_PHONE_NUMBER;
        String result = setText(locator, mobilePhoneNumber, FW_ConfigMgr.getDefaultTimeout(), false);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Enters a employee name.
     * 
     * @param employeeName The group name to be entered.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object enterEmployeeName(String groupName) {
        String result = setText(LO_EDT_EMPLOYEE_NAME, groupName, FW_ConfigMgr.getDefaultTimeout(), false);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Consoles the array of list elements in the dropdown, including the size, which accounts for the default placeholder value (even though it's not part of the list).
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */

     public Object checkItemsInList(String locator, int expectedCount) {
        waitForDuration(10, "s", false); // Wait to perform next check
        String result = getAllDropdownOptionsAsString(locator, 10,expectedCount);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object countItemsInList(String locator, String expectedString, int expectedValue) {
        waitForDuration(10, "s", false); // Wait to perform next check
        String result = countDropdownAppian(locator,expectedString,expectedValue,10);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
}
