package pageobjects;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
// Import class packages for this Page Object (PO)
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import customizations.automation.CU_Appian; // Customization for Appian and where FW_Page is extended

import framework.junit.FW_TestStep;
import framework.utilities.FW_ConfigMgr;
import framework.utilities.FW_StringUtils;
import framework.utilities.FW_TestStepUtils;

public class PO_Insured_Info extends CU_Appian {

    private static final String LO_TXT_INSURED_INFO_HEADER = "//h2/span[contains(text(), 'Insured Info')]";
    private static final String LO_EDT_GROUP_NAME = "//div[label='Group name']/following-sibling::div//input";
    //private static final String LO_EDT_POLICY_ID = "//div[label='Policy Number/Certificate ID']/following-sibling::div//input";
    private static final String LO_EDT_POLICY_NUMBER = "//div[label='Policy Number']/following-sibling::div//input";
    private static final String LO_EDT_FIRST_NAME = "//div[label='First Name']/following-sibling::div//div//input";
    private static final String LO_EDT_LAST_NAME = "//div[label='Last Name']/following-sibling::div//div//input";
    private static final String LO_EDT_DATE_OF_BIRTH = "//div[label='Date of Birth']/following-sibling::div//div//input";
    private static final String LO_EDT_EMAIL = "(//div[label[contains(text(), 'Email')]])[1]/following-sibling::div//input";
    private static final String LO_EDT_CONFIRM_EMAIL = "//div[label[contains(text(), 'Confirm Email')]]/following-sibling::div//input";
    private static final String LO_EDT_MOBILE_PHONE_NUMBER = "//div[label='Mobile Phone Number']/following-sibling::div//div//input";
    private static final String LO_RAD_PRIMARY_PLACE_RESIDENCE = "//div[span='Primary place of residence is:']/following-sibling::div//div[@role='radiogroup']";
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
    private static final String LO_EDT_HEALTH_CARD_NUMBER = "//div[label='Provincial Health Card Number']/following-sibling::div//input";
    private static final String LO_EDT_SCHOOL_NAME = "//div[label='Name of School']/following-sibling::div/div/input";
    private static final String LO_EDT_PROVINCIAL_HEALTH_CARD_NUMBER = "//div[label='Provincial Health Card Number (if applicable)']/following-sibling::div//div//input";
    private static final String LO_RAD_NO_PROGRAM_COORDINATOR = "//span[contains(text(),'organization or cardholder')]/../following-sibling::div//label[text()='No']";
    private static final String LO_EDT_COMPANY_NAME = "//div[label='Name of Company']/following-sibling::div/div/input";
    private static final String LO_RAD_NO_PROGRAM_CORDINATOR = "//div[span='Are you the Program Coordinator completing the claim on behalf of the organization or cardholder?']/following-sibling::div//label[text()='No']";
    private static final String LO_LNK_WHERE_TO_FIND_INORMATION = " //strong[contains(text(),'Where can I find this information?')]";
    private static final String LO_TXT_PURCHASED_INSURANCE = "//p[text()='Purchased Insurance']";
    private static final String LO_TXT_INDIVIDUAL_INSURANCE_INFO_PAGE = "//p[text()='Individual Insurance']";
    private static final String LO_EDT_PROVINCIAL_HEALTH_CARD = "//div[label='Provincial Health Card Number']/following-sibling::div//div//input";
    private static final String LO_TXT_INDIVIDUAL_INSURANCE_INSURANCE_TYPE = "//h4[span[text()='Insurance Type']]/following-sibling::div//p[text()='Individual Insurance']";
    private static final String LO_BUT_BACK = "//span[text()='Back']";
    private static final String LO_BUT_SAVE_DRAFT = "//span//span[contains(text(),'Save as Draft')]";
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
    private static final String LO_RAD_YES_OTHER_INSURED_PERSON_UNDER_SAME_POLICY = "//div[span=\"Is the other insured person under the same policy?\"]/following-sibling::div//label[text()='Yes']";
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
    private static final String LO_LST_COUNTRY_CODE = "//div[span='--Select country code--']";
    private static final String LO_EDT_EMPLOYEE_NAME = "//div[label='Employer Name']/following-sibling::div//input";

    /**
     * Define the Page Object (PO) constructor.
     * 
     * @param driver The WebDriver object passed from the test method.
     */
    public PO_Insured_Info(WebDriver driver) {
        super(driver);
    }

    /**
     * Validates if current webpage is loaded and correct.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateOnPage() {
        String result = validateLocatorExists(LO_TXT_INSURED_INFO_HEADER, FW_ConfigMgr.getDefaultTimeout() ,FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if current webpage is loaded and correct.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object verifyPurchasedInsurance() {
        String result = validateLocatorExists(LO_TXT_PURCHASED_INSURANCE, FW_ConfigMgr.getDefaultTimeout() ,FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if current webpage is loaded and correct.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object verifyIndividualInsurance() {
        String result = validateLocatorExists(LO_TXT_INDIVIDUAL_INSURANCE_INFO_PAGE, FW_ConfigMgr.getDefaultTimeout() ,FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Enter the name of school a student goes to.
     * 
     * @param nameOfSchool The name of scholl to be entered.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object enterNameOfSchool(String creditCardSixDigits) {
        String result = setText(LO_EDT_SCHOOL_NAME, creditCardSixDigits, FW_ConfigMgr.getDefaultTimeout(), false);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Enter the first 6 digits.
     * 
     * @param creditCardSixDigits The six digits to be entered for the credit card.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object enterFirst6Digits(String creditCardSixDigits) {
        String result = setText(LO_EDT_CREDIT_CARD_FIRST_6_DIGITS, creditCardSixDigits ,FW_ConfigMgr.getDefaultTimeout(), false);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Enters the last 4 digits.
     * 
     * @param creditCardFourDigits The four digits to be entered for the credit card.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object enterLast4Digits(String creditCardFourDigits) {
        String result = setText(LO_EDT_CREDIT_CARD_LAST_4_DIGITS, creditCardFourDigits ,FW_ConfigMgr.getDefaultTimeout(), false);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Selects the 'Individual Embedded' option.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
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
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object enterFirstName(String firstName) {
        String result = setText(LO_EDT_FIRST_NAME, firstName, FW_ConfigMgr.getDefaultTimeout(), false);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Enters a last name.
     * 
     * @param lastName The last name to be entered.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object enterLastName(String lastName) {
        String result = setText(LO_EDT_LAST_NAME, lastName, FW_ConfigMgr.getDefaultTimeout(), false);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Enters a date of birth.
     * 
     * @param dateOfBirth The date of birth to be entered.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object enterDOB(String dateOfBirth) {
        String result = setText(LO_EDT_DATE_OF_BIRTH, dateOfBirth, FW_ConfigMgr.getDefaultTimeout(), false);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Enters an email.
     * 
     * @param email The email to be entered.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object enterEmail(String email) {
        String result = setText(LO_EDT_EMAIL, email, FW_ConfigMgr.getDefaultTimeout(), false);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Enters a confirmation email.
     * 
     * @param confirmEmail The confirmation email to be entered.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object enterConfirmEmail(String confirmEmail) {
        String result = setText(LO_EDT_CONFIRM_EMAIL, confirmEmail, FW_ConfigMgr.getDefaultTimeout(), false);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Enter primary place of residence.
     * 
     * @param placeOfResidence The place of residence to be entered.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object enterPrimaryPlaceOfResidence(String placeOfResidence) {
        String result = selectRadioButtonInGroup(LO_RAD_PRIMARY_PLACE_RESIDENCE, placeOfResidence ,FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Enters a employer name.
     * 
     * @param employerName The employer name to be entered.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
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
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object enterContractOrGroupNumber(String contractOrGroupNumber) {
        String result = setText(LO_EDT_CONTRACT_OR_GROUP_NUMBER, contractOrGroupNumber ,FW_ConfigMgr.getDefaultTimeout(), false);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Enters a employer name.
     * 
     * @param groupName The group name to be entered.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object enterGroupName(String groupName) {
        String result = setText(LO_EDT_GROUP_NAME, groupName, FW_ConfigMgr.getDefaultTimeout(), false);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Enters a plan number.
     * 
     * @param planNumber The plan number to be entered.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object enterPlanNumber(String planNumber) {
        String result = setText(LO_EDT_PLAN_NUMBER, planNumber, FW_ConfigMgr.getDefaultTimeout(), false);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    // TODO: Determine if Orion really needs it's own specilized version of this method.
    /**
     * Enters a plan number. (Orion specific)
     * 
     * @param planNumber The plan number to be entered.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
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
     * @return A string including [PASS] or [FAIL] along with specific result details.
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
     * @return A string including [PASS] or [FAIL] along with specific result details.
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
     * @return A string including [PASS] or [FAIL] along with specific result details.
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
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object enterEmployerOrGroupName(String employerGroupName) {
        String result = setText(LO_EDT_EMPLOYER_OR_GROUP_NAME, employerGroupName, FW_ConfigMgr.getDefaultTimeout() ,false);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Enters a contract number.
     * 
     * @param contractNumber The contract number to be entered.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
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
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object enterMemberCertificateNumber(String memberCertificateNumber) {
        String result = setText(LO_EDT_MEMBER_CERTIFICATE_NUMBER, memberCertificateNumber ,FW_ConfigMgr.getDefaultTimeout(), false);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Enters a policy id .
     * 
     * @param policyNumberCertID The policy number certificate id to be entered.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object enterPolicyNumberCertificateId(String policyNumberCertID) {
        String result = setText(LO_EDT_POLICY_ID, policyNumberCertID, FW_ConfigMgr.getDefaultTimeout(), false);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Enters a policy Number .
     * 
     * @param policyNumber The policy number certificate id to be entered.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
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
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object selectNoForOtherInsuredPerson() {
        String result = clickLocator(LO_RAD_NO_INSURED_PERSON_CL, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Enters an address line 1.
     * 
     * @param addressLine1 The address line 1 to be entered.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object enterAddressLine1(String addressLine1) {
        String result = setText(LO_EDT_HOME_ADDRESS_LINE_1, addressLine1, FW_ConfigMgr.getDefaultTimeout(), false);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Enters an address line 2.
     * 
     * @param addressLine2 The address line 2 to be entered.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object enterAddressLine2(String addressLine2) {
        String result = setText(LO_EDT_HOME_ADDRESS_LINE_2, addressLine2, FW_ConfigMgr.getDefaultTimeout(), false);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Enters a city.
     * 
     * @param city The city to be entered.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object enterCity(String city) {
        String result = setText(LO_EDT_CITY, city, FW_ConfigMgr.getDefaultTimeout(), false);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Selects a province.
     * 
     * @param province The province to be selected.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object selectProvince(String province) {
        String result = setDropdownAppian(LO_EDT_PROVINCE, province, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
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
            FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
            return resultObj;
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
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object enterCountry(String country) {
        String result = setText(LO_EDT_COUNTRY, country, FW_ConfigMgr.getDefaultTimeout(), true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Enters a postal code.
     *
     * @param postalCode The postal code to be entered.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object enterPostalCode(String postalCode) {
        String result = setText(LO_EDT_POSTAL_CODE, postalCode, FW_ConfigMgr.getDefaultTimeout(), false);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Enters a provincial health card number .
     * 
     * @param provincialHealthCardNumber The provincial health card number to be entered.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object provincialHealthCardNumber(String provincialHealthCardNumber) {
        String result = setText(LO_EDT_PROVINCIAL_HEALTH_CARD_NUMBER, provincialHealthCardNumber ,FW_ConfigMgr.getDefaultTimeout(), false);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Selects the method of communication.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object selectMethodOfCommunication() {
        String result = clickLocator(LO_RAD_PREFERRED_METHOD_COMMUNICATION_EMAIL, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Selects "Email" as your preferred method of communication.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object selectEmailAsMethodOfCommunication() {
        String result = clickLocator(LO_RAD_PREFERRED_METHOD_COMMUNICATION_EMAIL, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Selects 'Yes' for the policy holder option.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object selectYesAsPolicyHolder() {
        String result = clickLocator(LO_RAD_POLICY_HOLDER_YES_CL, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Selects 'No' to question : Are you claiming for any other insured person(s)?.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object selectNoClaimingforOtherInsuredPerson() {
        String result = clickLocator(LO_RAD_NO_CLAIM_OTHER_INSURED_PERSON, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Selects 'No' for the other insurance option.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object selectNoOtherInsuranceRelatedToThisClaim() {
        String result = clickLocator(LO_RAD_NO_OTHER_INSURANCE, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Selects 'Yes' for the card holder option.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object selectYesforCardHolder() {
        String result = clickLocator(LO_RAD_YES_CARD_HOLDER, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Selects the primary card holder option.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object selectPrimaryCardHolder() {
        String result = clickLocator(LO_RAD_PRIMARY_CARD_HOLDER, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Selects 'Yes' for the program coordinator option.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object selectYesforProgamCoordinator() {
        String result = clickLocator(LO_RAD_YES_PROGRAM_COORDINATOR, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Selects 'No' for the program coordinator option.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object selectNoForProgamCoordinator() {
        String result = clickLocator(LO_RAD_NO_PROGRAM_CORDINATOR, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Selects 'No' for other insured person.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object selectNoforOtherInsuredPerson() {
        String result = clickLocator(LO_RAD_NO_CLAIM_OTHER_INSURED_PERSON, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Selects 'No' for the travel companion option.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object selectNoFORTRAVELCOMPANION() {
        String result = clickLocator(LO_RAD_NO_TRAVEL_COMPANION, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Selects 'No' for the other insurance option.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object selectNoOtherInsurance() {
        String result = clickLocator(LO_RAD_NO_OTHER_INSURANCE, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Enters health card number.
     * 
     * @param HealthcardNumber The employer name to be entered.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object enterHealtCardNumber(String HealthcardNumber) {
        String result = setText(LO_EDT_HEALTH_CARD_NUMBER, HealthcardNumber, FW_ConfigMgr.getDefaultTimeout(), false);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Clicks the 'Continue' button.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object clickButtonContinue() {
        String result = clickLocator(LO_BUT_CONTINUE, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Selects 'No' for the program coordinator option.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
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
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object enterCompanyName(String companyName) {
        String result = setText(LO_EDT_COMPANY_NAME, companyName, FW_ConfigMgr.getDefaultTimeout(), false);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Clicks on "Where can I find this information?"
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     * details.
     */
    public Object clickOnWhereToFindInformation() {
        String result = clickLocator(LO_LNK_WHERE_TO_FIND_INORMATION, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Selects 'Outside Canada' as the primary place of residence.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object selectOutsideCanada() {
        String result = clickLocator(LO_RAD_PRIMARY_PLACE_RESIDENCE, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Scrolls to the top of the page.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
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
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object verifyIndividualInsuranceWasSelected() {
        String result = validateLocatorExists(LO_TXT_INDIVIDUAL_INSURANCE_INSURANCE_TYPE ,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Clicks the "Back" button.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object clickBackButton() {
        String result = clickLocator(LO_BUT_BACK, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Click "Save As Draft" button.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object clickSaveAsDraftButton() {
        String result = clickLocator(LO_BUT_SAVE_DRAFT, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if purchase insurance was selected and visible in the insured info page.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object verifyPurchasedInsuranceWasSelected() {
        String result = validateLocatorExists(LO_TXT_PURCHASED_INSURANCE_INSURANCE_TYPE ,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
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
    public Object enterFirst6DigitsOfCreditCard(String first6DigitsOfCreditCard) {
        String result = setText(LO_EDT_FIRST_6_DIGITS_OF_CREDIT_CARD, first6DigitsOfCreditCard, FW_ConfigMgr.getDefaultTimeout(), false);
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
    public Object enterLast4DigitsOfCreditCard(String last4DigitsOfCreditCard) {
        String result = setText(LO_EDT_LAST_4_DIGITS_OF_CREDIT_CARD, last4DigitsOfCreditCard, FW_ConfigMgr.getDefaultTimeout(), false);
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

    /**
     * Attach a copy of the claim
     * 
     * @param filePath The relative path of the invoice file from the user's home directory.
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object attachACopyOfTheClaim(String filePath) {
        waitForDuration(15, "s", true); // Wait to perform next check
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
     * Enters a member id .
     * 
     * @param memberID The member id to be entered.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object enterMemberIdOnly(String memberID) {
        String result = setText(LO_EDT_MEMBER_ID_ONLY, memberID, FW_ConfigMgr.getDefaultTimeout(), false);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

     /* Enters a Provincial Health Card Number.
     * 
     * @param enterProvincialHealthCardNumber The credit card number to be entered.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     * 
     */
    public Object enterProvincialHealthCardNumber(String enterProvincialHealthCardNumber) {
        String result = setText(LO_EDT_PROVINCIAL_HEALTH_CARD, enterProvincialHealthCardNumber, FW_ConfigMgr.getDefaultTimeout(), false);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Enters the insurance company name .
     * 
     * @param insuranceCompany The insurance company to be entered.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
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
        String result = validateWithinLocatorText(locator, expectedTxt,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    /**
     * Apply a wait.
     * 
     * @return A [PASS] when the wait is applied successfully.
     */
    public Object applyWait() {
        waitForDuration(5, "s", true);
        String result = "[Pass] - Wait applied.";
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Selects '+1 Canada ' as Country Code
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object selectCountryCode(String CountryCode) {
        String result = setDropdownAppian(LO_LST_COUNTRY_CODE, CountryCode, FW_ConfigMgr.getDefaultTimeout());
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
    public Object enterMobilePhoneNumber(String mobilePhoneNumber) {
        waitForDuration(20, "s", true);
        String result = setText(LO_EDT_MOBILE_PHONE_NUMBER, mobilePhoneNumber, FW_ConfigMgr.getDefaultTimeout(), false);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Enters a employee name.
     * 
     * @param employeeName The group name to be entered.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object enterEmployeeName(String groupName) {
        String result = setText(LO_EDT_EMPLOYEE_NAME, groupName, FW_ConfigMgr.getDefaultTimeout(), false);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

     // ======================= Page Object Support Methods =======================

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
}
