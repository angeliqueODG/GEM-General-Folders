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
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;

import java.io.FileWriter;

import org.checkerframework.checker.units.qual.s;
import org.junit.jupiter.api.Test;
import java.util.*;

// Current Date
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.Instant;

import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebDriverException;

/**
 * Page Object (PO) class used in the Page Object (PO) design pattern. Inherits
 * from the CU_Appian class.
 */
// [Note: Automation Engineer, rename this Page Object (PO) class to match the
// filename.]
public class PO_Claim_Submission extends CU_Appian {

    // [Note: Automation Engineer, define the Page Object (PO) locators (LO) here.]
    private static final String LO_TXT_CLAIM_SUBMISSION_PAGE_VERIFY = "//h2[text()='YOUR CLAIM HAS BEEN SUBMITTED!']";
    private static final String LO_TXT_CLAIM_NUMBER = "//p[span[text()='Your Intent ID is']]";
    private static final String LO_TXT_SUBMIT_DOCUMENTS_CLAIM_NUMBER = "//p[span//strong[text()='Thank you for submitting your document(s) for ']]";
    private static final String LO_BUT_CLAIMS_NAV_LINK = "//div[span='Claims']";
    private static final String LO_EDT_CLAIM_NUMBER_OBTAINED = "//div[div[div[div[button[span//span[text()='Search']]]]]]/div//input";
    private static final String LO_EDT_SEARCH_BUTTON_CLAIM_NUMBER = "//button[span//span[text()='Search']]";
    private static final String LO_TXT_FRONT_PAGE_VERIFICATION_VALUES = "//tr[@data-dnd-name='row 2']";
    private static final String LO_TXT_FRONT_PAGE_VERIFICATION_HEADERS = "//thead";
    private static final String LO_TXT_INFORMATION_POLICY_INSURANCE_VERIFICATION = "//p[contains(., 'Canadian Travel Insurance')]";
    private static final String LO_TXT_INFORMATION_SECTION_CUSTOMER_NAME = "//div[div[div[div[div[p[span[text()='Customer']]]]]]]";
    private static final String LO_TXT_INFORMATION_SECTION_CLAIMANT_NAME = "//div[div[div[div[div[p[span[text()='Claimant']]]]]]]";
    private static final String LO_TXT_LOSS_DETAILS_SECTION_AMOUNT_LOST= "//div[div[div[div[div[div[div[h2[text()='Loss Details']]]]]]]]/following-sibling::div";
    private static final String LO_TXT_TASKS_SECTION_ACTIVE= "//div[div[div[div[p[span[strong[text()='Active']]]]]]]/following-sibling::div[1]";
    private static final String LO_TXT_TASKS_SECTION_RESOLVED= "//div[div[div[div[p[span[text()='Resolved']]]]]]/following-sibling::div[1]";
    private static final String LO_BUT_UPDATE_CLAIM_TYPES = "(//button[span//span[text()='Update Claims']])[1]";
    private static final String LO_LINK_MANUAL_POLICY_VALIDATION = "//strong[a='Manual Policy Validation']";
    private static final String LO_TXT_READY_STATUS = "//p[text()='Ready']";
    private static final String LO_TXT_PROCESSED_AUTOMATION_ASSIGNEE = "//span[text()='Process Automation']";
    private static final String LO_TXT_OPENED_CLAIM_VALIDATION= "//div[div[h5[text()='Opened Claim']]]";
    private static final String LO_TXT_CLOSED = "//div[div[h5[text()='Closed']]]";
    private static final String LO_TXT_UNDER_REVIEW = "//div[div[h5[text()='Under Review']]]";
    private static final String LO_TXT_CLAIM_LAST_UPDATED_DATE= "//span//span[contains(normalize-space(.),'Last Updated:')]";
    private static final String LO_TXT_VALIDATION_PARAGRAPH= "//p[text()='Claim is undergoing system validation checks.']";
    private static final String LO_TXT_QUICK_ACTIONS_TITLE= "//p[strong[text()='Quick Actions:']]";
    private static final String LO_BUT_ADD_COMMENT_QUICK_ACTIONS = "//div[div[div[div[p[strong[text()='Quick Actions:']]]]]]/following-sibling::div//button[span//span[text()='Add Comment']]";
    private static final String LO_TXT_ADDITIONAL_INFORMATION_HEADING= "//div/h6[text()='Additional Information']";
    private static final String LO_EDT_VALID_COVERAGE_COMMENT = "//div[span[text()='Comments']]/following-sibling::div/div/div/div[2]";
    private static final String LO_EDT_VALID_COVERAGE_COMMENT_FR = "//div[span[text()='Comments']]/following-sibling::div/div/div[2]";
    private static final String LO_LST_ASSESSMENT_REVIEW_STATUS = "//div[span[text()='Assessment Review Status']]/following-sibling::div//div[@role='combobox']";
    private static final String LO_LST_ASSESSMENT_REVIEW_STATUS_FR = "//div[span[text()='Assessment Review Status']]/following-sibling::div//div[@role='combobox']";
    private static final String LO_TXT_PRIORITY_VERIFY = "//div[span[text()='Priority']]"; 
    private static final String LO_BUT_CLONE_CLAIM = "//span[contains(text(), 'Clone Claim')]";  
    private static final String LO_BUT_CREATE_UPDATE_OTHER_INSURANCE = "//span[contains(text(), 'Create Update Other Insurance')]";
    private static final String LO_LNK_VIEW_ALL = "//a[contains(text(), 'View All')]"; 
    private static final String LO_BUT_ADD_COMMENT = "(//button[span//span[text()='Add Comment']])[1]";
    private static final String LO_LST_SELECT_DOCUMENTS = "//div[span[text()='Select Documents']]/following-sibling::div//div[@role='combobox']";
    private static final String LO_BUT_ACTIONS = "(//span/span)[12]";
    private static final String LO_TXT_FIRST_NAME_VERIFY = "//div[span[text()='First Name']]/following-sibling::div";   
    private static final String LO_TXT_LAST_NAME_VERIFY = "//div[span[text()='Last Name']]/following-sibling::div";
    private static final String LO_TXT_PHONE_NUMBER_VERIFY = " //div[span[text()='Phone Number']]/following-sibling::div";  
    private static final String LO_TXT_EMAIL_VERIFY = "(//div[span[text()='Email']]/following-sibling::div)[1]";  
    private static final String LO_TXT_CLAIM_STATUS = "//div[span[text()='Claim Status']]/following-sibling::div";
    private static final String LO_TXT_OUTCOME_STATUS_VERIFY = "//div[span[text()='Outcome Status']]/following-sibling::div";    
    private static final String LO_TXT_OUTCOME = "//h1[contains(text(),'Outcome')]";  
    private static final String LO_TXT_COMMENTS = "//span[contains(text(),'Comments')]";
    private static final String LO_TXT_CLAIM_ACTIVITY = "//strong[contains(text(),'Claim Activity')]";  
    private static final String LO_TXT_VERIFY_TOTAL_AMOUNT_CLAIMED = "//div[label[text()='Total Amount Claimed']]/following-sibling::div//input";
    private static final String LO_TXT_VERIFY_TOTAL_AMOUNT_PAID = "//div[label[text()='Total Amount Paid']]/following-sibling::div//input";  
    private static final String LO_TXT_REVIEW_STATUS = "//div[span[text()='Review Status']]/following-sibling::div";
    private static final String LO_TXT_REQUEST_INFORMATION = "//h1[contains(text(),'Request Information')]";  
    private static final String LO_LNK_ADD_NEW = "//a[contains(text(),'Add New')]"; 
    private static final String LO_LNK_CANCEL = "(//div//p//a)[4]";
    private static final String LO_EDT_EMAIL = "//input[@id='identifierId']";
    private static final String LO_BUT_NEXT = "//button[@id='identifierNext']";
    private static final String LO_EDT_PASSWORD = "//input[@id='password']";
    private static final String LO_BUT_PASSWORD_NEXT = "//button[@id='passwordNext']";
    private static final String LO_BUT_ABOUT_PRODUCTS = "//a[@href='https://www.google.rw/intl/en/about/products?tab=kh']";  
    private static final String LO_BUT_FOCUSED = "//div//button[span[contains(text(),'Focused')]]";
    private static final String LO_LNK_VERIFY_AND_UPLOAD_DOCUMENTS = "//a[contains(text(),'Verify and Upload Document(s)')]";
    private static final String LO_EDT_POLICY_ISSUE_DATE = "//div[label[contains(text(), 'Policy Issue Date')]]/following-sibling::div//input";
    private static final String LO_COMMON_REFERENCE_NUMBER = "//div[label[contains(text(), 'Common Reference Number')]]/following-sibling::div//input";
    private static final String LO_EDT_ADD_COMMENT = "//div[span[normalize-space()='Add Comment']]/following-sibling::div//div[@contenteditable='true']";
    private static final String LO_BUT_SUBMIT = "//span[contains(text(), 'SUBMIT')]";
    private static final String LO_TXT_TYPE = "//span[text()='Medical Event - Medical']";
    private static final String LO_TXT_NON_MEDICAL_TYPE = "//span[text()='Non-Medical Event - Travel Document Related']";
    private static final String LO_TXT_NON_MEDICAL_CRIME_RELATED = "//span[text()='Non-Medical Event - Crime Related']";
    private static final String LO_TXT_CLAIM_FINALIZED = "//div[p[contains(text(), 'Claim has been finalized and is now closed.')]]";
    private static final String LO_TXT_CLAIM_IN_ASSESSMENT = "//div[p[contains(text(), 'Claim is in now in assessment.')]]";
    private static final String LO_TXT_VIEW_ASSESSMENT_HUB = "//h6//a[contains(text(), 'View Assessment Hub for (Claim Decision, Payment Info., Bills Info.)')]";
    private static final String LO_TXT_REQUIRED_FIELD_PARAGRAPH = "//div[contains(text(), 'Required fields are marked with an asterisk *')]";
    private static final String LO_TXT_VERIFY_CORPORATE_CLIENT = "//div[span[contains(text(), 'Corporate Client')]]/following-sibling::div";
    private static final String LO_TXT_VERIFY_POLICY_NUMBER = "//div[span[contains(text(), 'Policy Number')]]/following-sibling::div";
    private static final String LO_TXT_VERIFY_ISSUE_DATE = "//div[span[contains(text(), 'Issue Date')]]/following-sibling::div";
    private static final String LO_TXT_VERIFY_INSURANCE_TYPE = "//div[span[contains(text(), 'Insurance Type')]]/following-sibling::div";
    private static final String LO_TXT_VERIFY_STATUS = "(//div[span[contains(text(), 'Status')]]/following-sibling::div)[1]";
    private static final String LO_TXT_VERIFY_FIRST_NAME = "(//div[div[span[contains(text(), 'First Name')]]])[1]";
    private static final String LO_TXT_VERIFY_LAST_NAME = "(//div[div[span[contains(text(), 'Last Name')]]])[1]";
    private static final String LO_TXT_VERIFY_RELATION = "//div[div[span[contains(text(), 'Relation')]]]";
    private static final String LO_TXT_VERIFY_PHONE_NUMBER = "(//div[div[span[contains(text(), 'Phone Number')]]])[1]";
    private static final String LO_TXT_VERIFY_EMAIL = "(//div[div[span[contains(text(), 'Email')]]])[1]";
    private static final String LO_TXT_VERIFY_PPHI_EMAIL = "(//div[div[span[contains(text(), 'Email')]]])[2]";
    private static final String LO_TXT_VERIFY_DATE_OF_BIRTH = "(//div[div[span[contains(text(), 'Date of Birth')]]])[1]";
    private static final String LO_TXT_VERIFY_ADDRESS = "(//div[div[span[contains(text(), 'Address')]]])[1]";
    private static final String LO_TXT_VERIFY_TRAVEL_DATE_FROM = "(//div[div[span[contains(text(), 'Travel Date From')]]])[1]";
    private static final String LO_TXT_VERIFY_TRAVEL_DATE_TO = "(//div[div[span[contains(text(), 'Travel Date To')]]])[1]";
    private static final String LO_TXT_VERIFY_INCIDENT_DATE = "(//div[div[span[contains(text(), 'Incident Date')]]])[1]";
    private static final String LO_TXT_VERIFY_REPORTED_DATE = "(//div[div[span[contains(text(), 'Reported Date')]]])[1]";
    private static final String LO_TXT_VERIFY_JOURNEY_NAME = "(//div[div[span[contains(text(), 'Journey Name')]]])[1]";
    private static final String LO_TXT_VERIFY_RELATED_POLICY = "(//div[div[span[contains(text(), 'Related Policy')]]])[1]";
    private static final String LO_TXT_VERIFY_LOSS_VALUE = "(//div[div[span[contains(text(), 'Loss Value')]]])[1]";
    private static final String LO_TXT_VERIFY_CHANNEL = "(//div[div[span[contains(text(), 'Channel')]]])[1]";
    private static final String LO_TXT_VERIFY_REVIEW_STATUS = "(//div[div[span[contains(text(), 'Review Status')]]])[1]";
    private static final String LO_TXT_VERIFY_PRIMARY_CONTACT = "(//div[div[span[contains(text(), 'Primary Contact')]]])[1]";
    private static final String LO_TXT_VERIFY_MOBILE = "(//div[div[span[contains(text(), 'Mobile')]]])[1]";
    private static final String LO_TXT_VERIFY_PREFERRED_LANGUAGE = "(//div[div[span[contains(text(), 'Preferred Language')]]])[1]";
    private static final String LO_TXT_VERIFY_SOURCE = "(//div[div[span[contains(text(), 'Source')]]])[1]";
    private static final String LO_TXT_VERIFY_COVERAGE = "(//div[div[span[contains(text(), 'Coverage')]]])[1]";
    private static final String LO_TXT_VERIFY_CATEGORY_TYPE = "(//div[div[span[contains(text(), 'Category Type')]]])[1]";
    private static final String LO_TXT_VERIFY_PRODUCTS = "(//div[div[span[contains(text(), 'Products')]]])[1]";
    private static final String LO_TXT_VERIFY_COMMON_REFERENCE = "(//div[div[span[contains(text(), 'Common Ref#')]]])[1]";
    private static final String LO_TXT_VERIFY_LINE_OF_BUSINESS = "(//div[div[span[contains(text(), 'Line of Business')]]])[1]";
    private static final String LO_TXT_VERIFY_EFFECTIVE_START_DATE = "(//div[div[span[contains(text(), 'Effective Start Date')]]])[1]";
    private static final String LO_TXT_VERIFY_EFFECTIVE_END_DATE = "(//div[div[span[contains(text(), 'Effective End Date')]]])[1]";
    private static final String LO_TXT_VERIFY_CLIENT_REF = "(//div[div[span[contains(text(), 'Client Ref#')]]])[1]";
    private static final String LO_TXT_VERIFY_BROKER_SPONSOR_CODE_SELLING_AGENT = "(//div[div[span[contains(text(), 'Broker / Sponsor Code / Selling Agent')]]])[1]";
    private static final String LO_TXT_VERIFY_MASTER_POLICY_HOLDER = "(//div[div[span[contains(text(), 'Master Policy Holder')]]])[1]";
    private static final String LO_TXT_VERIFY_POLICY_REFERENCE = "(//div[div[span[contains(text(), 'Policy Reference')]]])[1]";
    private static final String LO_TXT_VERIFY_PRODUCT = "(//div[div[span[contains(text(), 'Product')]]])[1]";
    private static final String LO_TXT_VERIFY_POLICY_ISSUE_DATE = "(//div[div[span[contains(text(), 'Policy Issue Date')]]])[1]";
    private static final String LO_TXT_VERIFY_MASTER_POLICY_EFFECTIVE_START_DATE = "(//div[div[span[contains(text(), 'Effective Start Date')]]])[1]";
    private static final String LO_TXT_VERIFY_MASTER_POLICY_EFFECTIVE_END_DATE = "(//div[div[span[contains(text(), 'Effective End Date')]]])[1]";
    private static final String LO_TXT_VERIFY_PPHI_SOURCE = "(//div[div[span[contains(text(), 'Source')]]])[2]";
    private static final String LO_TXT_FINANCIALS_PAGE = "//h2[normalize-space()='Reserves Summary']";
    private static final String LO_TXT_RESERVES_SUMMARY = "//h2[normalize-space()='Reserves Summary']";
    private static final String LO_TXT_RESERVE_SECTION = "//span[normalize-space()='";
    private static final String LO_TXT_TRANSACTION_TAB = "//div[@role='link'][.//span[normalize-space()='";
    private static final String LO_TXT_TRANSACTION_HEADER = "//span[@data-sort-button and normalize-space()='";
    private static final String LO_EDT_REOPEN_CLAIM_VERIFY = "//div[label[contains(text(), '";
    private static final String LO_EDT_DUE_DATE = "//div[label[contains(text(), 'Due Date')]]/following-sibling::div//input";
    private static final String LO_EDT_TIME = "//div[label[contains(text(), 'Time')]]/following-sibling::div//input";
    private static final String TXT_STATUS_OPEN = "(//div[div[div[div[div[p[span[contains(text(), 'Status')]]]]]]])[1]";
   
    //





    String CLICK_CLAIM_NUMBER = "//strong[a[text()='";
    String CLICK_HORIZONTAL_NAV_LINK = "//div[text()='";
    String CLICK_BUTTON = "//button/span//span[text()='";
    String CLICK_YES_OR_NO_TO_SUBMITTING = "//h1[normalize-space()='Do you want to Submit']/following::button[.//span[normalize-space()='";
    String CLICK_YES_OR_NO_TO_SUBMITTING_FR = "'";
    String CLICK_YES_OR_NO_TO_SUBMIT = "//h1[normalize-space()='Do you want to Submit']/following::button[.//span[contains(text(), '";
    String CLICK_YES_OR_NO_TO_FINALYZE = "//div[div[div[div[div[h4[text()='Are you sure you want to finalize?']]]]]]/following-sibling::div//button//span[text()='";
    String CLICK_COVERAGE = "//div[span[text()='Want to validate coverage?']]/following-sibling::div//label[text()='";
    String LO_LST_SUB_OUTCOME = "//div[span[text()='Sub Outcome']]/following-sibling::div//div[@role='combobox']";
    String CLICK_COVERAGE_FR = "//div[span[text()='Want to validate coverage?']]/following-sibling::div//label[text()='";
    String LO_LST_SUB_OUTCOME_FR = "";
    String CLICK_BUTTON_FR = "//button/span//span[text()='";
    String CLICK_HORIZONTAL_NAV_LINK_FR = "//div[text()='";
    String LO_TXT_SUMMARY_LABEL = "//div[h2[text()='";
    String LO_TXT_TASKS_LABELS = "//div[span[text()='";
    String LO_TXT_STATUSES = "//p[text()='";
    String LO_TXT_CLAIMS_LANDING_PAGE_STATUS = "//div[span[text()='";
    String LO_TXT_OUTCOME_STATUS = "//div[span[text()='Outcome Status']]/following-sibling::div//span[text()='";
    String LO_TXT_OUTCOME_STATUS_FR = "//div[span[text()='Outcome Status']]/following-sibling::div//span[text()='";
    String LO_TXT_SUB_OUTCOME_STATUS = "//div[span[text()='Sub Outcome']]/following-sibling::div//span[text()='";
    String LO_TXT_SUB_OUTCOME_STATUS_FR = "";
    String LO_TXT_CLAIMS_LANDING_PAGE_STATUS_FR = "//div[span[text()='";
    String LO_TXT_ADDITIONAL_INFORMATION_LABELS = "//div[span[text()='";
    String LO_LNK_NAVIGATION_LINKS = "//div[text()='";
    String LO_BUT_LANDING_PAGE_UP_RIGHT_BUTTONS = "//span[contains(text(), '";
    String LO_LNK_RECENT_DOCUMENTS = "//a[contains(text(), '"; 
    String LO_RECENT_DOCUMENTS = "//strong[contains(text(), '";
    String LO_LNK_UPDATED_LINKS = "//a[.//span[text()='";
    String LO_TXT_SUMMARY_SECTION_LABELS = "//div/h2[text()='"; 
    String LO_TXT_POLICY_VALIDATION_HUB_SECTION_LABELS = "//div/h5[text()='"; 
    String LO_RAD_INFO_REQUESTED_FROM = "//div[label[contains(text(), '"; 
    String LO_BUT_CLOSE = "//button//span[text()='CLOSE']";
    String LO_BUT_YES = "(//h1[normalize-space()='Are you sure you want to finalize?']/following::button)[2]";
    String LO_TXT_TOTAL_BILLED = "//p[span[contains(text(), '";
    
    //-------------------------------------------- FR locators----------------------------------------------------------------------
    private static final String LO_TXT_CLAIM_SUBMISSION_PAGE_VERIFY_FR = "";
    private static final String LO_TXT_ADDITIONAL_INFORMATION_HEADING_FR= "";
    private static final String LO_BUT_ADD_COMMENT_QUICK_ACTIONS_FR = "";
    private static final String LO_TXT_CLAIM_NUMBER_FR = "";
    private static final String LO_BUT_CLAIMS_NAV_LINK_FR = "";
    private static final String LO_EDT_CLAIM_NUMBER_OBTAINED_FR = "";
    private static final String LO_EDT_SEARCH_BUTTON_CLAIM_NUMBER_FR = "";
    String CLICK_CLAIM_NUMBER_FR = "";
    private static final String LO_BUT_UPDATE_CLAIM_TYPES_FR = "";
    private static final String LO_TXT_FRONT_PAGE_VERIFICATION_VALUES_FR = "";
    private static final String LO_TXT_FRONT_PAGE_VERIFICATION_HEADERS_FR = "";
    private static final String LO_TXT_INFORMATION_POLICY_INSURANCE_VERIFICATION_FR = "";
    private static final String LO_TXT_INFORMATION_SECTION_CUSTOMER_NAME_FR = "";
    private static final String LO_TXT_INFORMATION_SECTION_CLAIMANT_NAME_FR = "";
    private static final String LO_TXT_LOSS_DETAILS_SECTION_AMOUNT_LOST_FR= "";
    private static final String LO_TXT_TASKS_SECTION_ACTIVE_FR= "";
    private static final String LO_TXT_TASKS_SECTION_RESOLVED_FR= "";
    private static final String LO_LINK_MANUAL_POLICY_VALIDATION_FR = "";
    private static final String LO_TXT_READY_STATUS_FR = "";
    private static final String LO_TXT_PROCESSED_AUTOMATION_ASSIGNEE_FR = "";
    private static final String LO_TXT_OPENED_CLAIM_VALIDATION_FR= "";
    private static final String LO_TXT_CLAIM_LAST_UPDATED_DATE_FR= "";
    private static final String LO_TXT_VALIDATION_PARAGRAPH_FR= "";
    private static final String LO_TXT_QUICK_ACTIONS_TITLE_FR= "";
    private static final String LO_TXT_PRIORITY_VERIFY_FR = "";
    private static final String LO_BUT_LANDING_PAGE_UP_RIGHT_BUTTONS_FR = "";
    private static final String LO_BUT_CLONE_CLAIM_FR = "";
    private static final String LO_BUT_CREATE_UPDATE_OTHER_INSURANCE_FR = "";
    private static final String LO_LNK_NAVIGATION_LINKS_FR = "";
    private static final String LO_LNK_VIEW_ALL_FR = "";
    private static final String LO_BUT_ADD_COMMENT_FR = "";
    private static final String LO_BUT_ACTIONS_FR = "";
    private static final String LO_LST_SELECT_DOCUMENTS_FR = "";
    private static final String LO_TXT_FIRST_NAME_VERIFY_FR = "";
    private static final String LO_TXT_LAST_NAME_VERIFY_FR = "";
    private static final String LO_TXT_PHONE_NUMBER_VERIFY_FR = "";  
    private static final String LO_TXT_EMAIL_VERIFY_FR = "";  
    private static final String LO_TXT_CLAIM_STATUS_FR = "";   
    private static final String LO_TXT_OUTCOME_FR = ""; 
    private static final String LO_TXT_COMMENTS_FR = "";
    private static final String LO_TXT_CLAIM_ACTIVITY_FR = "";
    private static final String LO_TXT_VERIFY_TOTAL_AMOUNT_CLAIMED_FR = "";
    private static final String LO_TXT_VERIFY_TOTAL_AMOUNT_PAID_FR = "";
    private static final String LO_TXT_REVIEW_STATUS_FR = "";
    private static final String LO_TXT_OUTCOME_STATUS_VERIFY_FR = "";
    private static final String LO_TXT_REQUEST_INFORMATION_FR = "";  
    private static final String LO_LNK_ADD_NEW_FR = "";
    private static final String LO_LNK_CANCEL_FR = "";
    private static final String LO_EDT_EMAIL_FR = "";
    private static final String LO_BUT_NEXT_FR = "";
    private static final String LO_EDT_PASSWORD_FR = "";
    private static final String LO_BUT_PASSWORD_NEXT_FR = "";
    private static final String LO_BUT_ABOUT_PRODUCTS_FR = "";
    private static final String LO_TXT_SUBMIT_DOCUMENTS_CLAIM_NUMBER_FR = "";
    private static final String LO_BUT_FOCUSED_FR = "";
    private static final String LO_LNK_VERIFY_AND_UPLOAD_DOCUMENTS_FR = "";
    private static final String LO_EDT_POLICY_ISSUE_DATE_FR = "";
    private static final String LO_COMMON_REFERENCE_NUMBER_FR = "";
    private static final String LO_EDT_ADD_COMMENT_FR = "";
    private static final String LO_BUT_SUBMIT_FR = "";
    private static final String CLICK_YES_OR_NO_TO_SUBMIT_FR = "";
    private static final String LO_TXT_TYPE_FR = "";
    private static final String LO_TXT_NON_MEDICAL_TYPE_FR = "";
    private static final String LO_TXT_CLOSED_FR = "";
    private static final String LO_TXT_CLAIM_FINALIZED_FR = "";
    private static final String LO_TXT_VIEW_ASSESSMENT_HUB_FR = "";
    private static final String LO_TXT_REQUIRED_FIELD_PARAGRAPH_FR = "";
    private static final String LO_TXT_VERIFY_CORPORATE_CLIENT_FR = "";
    private static final String LO_TXT_VERIFY_POLICY_NUMBER_FR = "";
    private static final String LO_TXT_VERIFY_ISSUE_DATE_FR = "";
    private static final String LO_TXT_VERIFY_INSURANCE_TYPE_FR = "";
    private static final String LO_TXT_VERIFY_STATUS_FR = "";
    private static final String LO_TXT_VERIFY_FIRST_NAME_FR = "";
    private static final String LO_TXT_VERIFY_LAST_NAME_FR = "";
    private static final String LO_TXT_VERIFY_RELATION_FR = "";
    private static final String LO_TXT_VERIFY_PHONE_NUMBER_FR = "";
    private static final String LO_TXT_VERIFY_EMAIL_FR = "";
    private static final String LO_TXT_VERIFY_DATE_OF_BIRTH_FR = "";
    private static final String LO_TXT_VERIFY_ADDRESS_FR = "";
    private static final String LO_TXT_VERIFY_TRAVEL_DATE_FROM_FR = "";
    private static final String LO_TXT_VERIFY_TRAVEL_DATE_TO_FR = "";
    private static final String LO_TXT_VERIFY_INCIDENT_DATE_FR = "";
    private static final String LO_TXT_VERIFY_REPORTED_DATE_FR = "";
    private static final String LO_TXT_VERIFY_JOURNEY_NAME_FR = "";
    private static final String LO_TXT_VERIFY_RELATED_POLICY_FR = "";
    private static final String LO_TXT_VERIFY_LOSS_VALUE_FR = "";
    private static final String LO_TXT_VERIFY_CHANNEL_FR = "";
    private static final String LO_TXT_VERIFY_REVIEW_STATUS_FR = "";
    private static final String LO_TXT_VERIFY_PRIMARY_CONTACT_FR = "";
    private static final String LO_TXT_VERIFY_MOBILE_FR = "";
    private static final String LO_TXT_VERIFY_PREFERRED_LANGUAGE_FR = "";
    private static final String LO_TXT_VERIFY_SOURCE_FR = "";
    private static final String LO_TXT_VERIFY_PPHI_EMAIL_FR = "";
    private static final String LO_TXT_VERIFY_PPHI_SOURCE_FR = "";
    private static final String LO_TXT_VERIFY_COVERAGE_FR = "";
    private static final String LO_TXT_VERIFY_CATEGORY_TYPE_FR = "";
    private static final String LO_TXT_VERIFY_PRODUCTS_FR = "";
    private static final String LO_TXT_VERIFY_COMMON_REFERENCE_FR = "";
    private static final String LO_TXT_VERIFY_LINE_OF_BUSINESS_FR = "";
    private static final String LO_TXT_VERIFY_EFFECTIVE_START_DATE_FR = "";
    private static final String LO_TXT_VERIFY_EFFECTIVE_END_DATE_FR = "";
    private static final String LO_TXT_VERIFY_CLIENT_REF_FR = "";
    private static final String LO_TXT_VERIFY_BROKER_SPONSOR_CODE_SELLING_AGENT_FR = "";
    private static final String LO_TXT_VERIFY_MASTER_POLICY_HOLDER_FR = "";
    private static final String LO_TXT_VERIFY_POLICY_REFERENCE_FR = "";
    private static final String LO_TXT_VERIFY_PRODUCT_FR = "";
    private static final String LO_TXT_VERIFY_POLICY_ISSUE_DATE_FR = "";
    private static final String LO_TXT_VERIFY_MASTER_POLICY_EFFECTIVE_START_DATE_FR = "";
    private static final String LO_TXT_VERIFY_MASTER_POLICY_EFFECTIVE_END_DATE_FR = "";
    private static final String LO_TXT_TOTAL_BILLED_FR = "";
    private static final String LO_EDT_REOPEN_CLAIM_VERIFY_FR = "";
     private static final String LO_EDT_DUE_DATE_FR = "";
    private static final String LO_EDT_TIME_FR = "";
    private static final String LO_TXT_UNDER_REVIEW_FR = "";
    private static final String LO_TXT_CLAIM_IN_ASSESSMENT_FR = "";
    private static final String LO_TXT_NON_MEDICAL_CRIME_RELATED_FR = "";


    String LO_BUT_CLOSE_FR = "";
    String CLICK_YES_OR_NO_TO_FINALYZE_FR = "";
    String LO_BUT_YES_FR = "";

    String LO_LNK_RECENT_DOCUMENTS_FR = "";
    String LO_TXT_SUMMARY_SECTION_LABELS_FR = "";
    String LO_RAD_INFO_REQUESTED_FROM_FR = "";
    String LO_LNK_UPDATED_LINKS_FR = "";
    String LO_TXT_POLICY_VALIDATION_HUB_SECTION_LABELS_FR = ""; 
    String LO_RECENT_DOCUMENTS_FR = "";
    

   private String claimNumber = "";

    public String getStoredClaimNumber() {
    return claimNumber;
}

    String updateFromHistoryTab="";
    String temp="";
    List<String> set_claim_numbers = new ArrayList<>();
    List<String> updated_data = new ArrayList<>();
    




    /**
     * Define the Page Object (PO) constructor.
     * 
     * @param driver The WebDriver object passed from the test method.
     */
    // [Note: Automation Engineer, rename this Page Object (PO) class to match the
    // filename.]
    public PO_Claim_Submission(WebDriver driver) {
        super(driver);
    }

    /**
     * Scrolls at a given locator.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object scrollTop() {
        String result = scrollToLocator(LO_TXT_CLAIM_SUBMISSION_PAGE_VERIFY);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    
    public String VerifygetStoredClaimNumber() {

    if (claimNumber == null || claimNumber.trim().isEmpty()) {
        throw new IllegalStateException(
                "Claim Number was not generated/saved by the previous Test Case. " +
                "Validation Test Case cannot continue."
        );
    }

    return claimNumber;
}

    /**
     * Validates if current webpage is loaded and correct.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object validateOnPage(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_CLAIM_SUBMISSION_PAGE_VERIFY_FR : LO_TXT_CLAIM_SUBMISSION_PAGE_VERIFY;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object getClaimNumber(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_CLAIM_NUMBER_FR : LO_TXT_CLAIM_NUMBER;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        try {
        String text = driver.findElement(By.xpath(locator)).getText();
        claimNumber = text.replaceAll("\\D+", "");
        if (claimNumber == null || claimNumber.isEmpty()) {
        System.out.println("ERROR: Claim Number was not extracted.");
        } else {
            System.out.println("====================================================");
            System.out.println("Extracted Claim Number: " + claimNumber);
            System.out.println("====================================================");
        }

    } catch (Exception e) {

        System.out.println("ERROR: Unable to extract Claim Number.");
        System.out.println("Exception: " + e.getMessage());

    }

    return resultObj;
}

    public Object clickOnClaimsNavLink(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_BUT_CLAIMS_NAV_LINK_FR : LO_BUT_CLAIMS_NAV_LINK;
        String result = clickLocator(locator, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object enterObtainedClaimNumber(String language) {
        waitForDuration(5);
        String locator = "fr".equalsIgnoreCase(language) ? LO_EDT_CLAIM_NUMBER_OBTAINED_FR : LO_EDT_CLAIM_NUMBER_OBTAINED;
        String result = setText(locator, claimNumber, FW_ConfigMgr.getDefaultTimeout(), false);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        temp = claimNumber;
        claimNumber="";
        return resultObj;
    }

    public Object enterKnownClaimNumber(String language, String claimNumber) {
        waitForDuration(5);
        String locator = "fr".equalsIgnoreCase(language) ? LO_EDT_CLAIM_NUMBER_OBTAINED_FR : LO_EDT_CLAIM_NUMBER_OBTAINED;
        String result = setText(locator, claimNumber, FW_ConfigMgr.getDefaultTimeout(), false);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object clickOnClaimNumber(String language) {
        waitForDuration(5);
        String locator = "//strong[a[text()='" + temp + "']]";
        if ("fr".equalsIgnoreCase(language)) {
        locator = "//strong[a[text()='" + temp + "']]";
        }
        String result = clickLocator(locator, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj =FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        temp = "";
        return resultObj;
        }

    public String verifyLabel(String label) {
        LO_TXT_SUMMARY_LABEL = LO_TXT_SUMMARY_LABEL + label + "']]";
        String result = validateWithinLocatorText(LO_TXT_SUMMARY_LABEL,label,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        LO_TXT_SUMMARY_LABEL = "//div[h2[text()='";
        return result;
    }

    public Object clickOnKnownClaimNumber(String language, String knownClaimNumber) {
        waitForDuration(5);
        CLICK_CLAIM_NUMBER = CLICK_CLAIM_NUMBER + knownClaimNumber +  "']]";
        String locator = "fr".equalsIgnoreCase(language) ? CLICK_CLAIM_NUMBER_FR : CLICK_CLAIM_NUMBER;
        String result = clickLocator(locator, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    public Object clickOnHorizontalNavLink(String language, String horizontalNavLink) {
        waitForDuration(5);
        CLICK_HORIZONTAL_NAV_LINK = CLICK_HORIZONTAL_NAV_LINK + horizontalNavLink +  "']";
        String locator = "fr".equalsIgnoreCase(language) ? CLICK_HORIZONTAL_NAV_LINK_FR : CLICK_HORIZONTAL_NAV_LINK;
        String result = clickLocator(locator, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        CLICK_HORIZONTAL_NAV_LINK = "//div[text()='";
        return resultObj;
    }

    public Object clickTheButton(String language, String button) {
        waitForDuration(5);
        CLICK_BUTTON = CLICK_BUTTON + button +  "']";
        String locator = "fr".equalsIgnoreCase(language) ? CLICK_BUTTON_FR : CLICK_BUTTON;
        String result = clickLocator(locator, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        CLICK_BUTTON = "//button/span//span[text()='";
        return resultObj;
    }

    public Object selectChoiceOfSubmission(String language, String yesOrNo) {
        waitForDuration(5);
        CLICK_YES_OR_NO_TO_SUBMITTING = CLICK_YES_OR_NO_TO_SUBMITTING + yesOrNo +  "']][1]";
        String locator = "fr".equalsIgnoreCase(language) ? CLICK_YES_OR_NO_TO_SUBMITTING_FR : CLICK_YES_OR_NO_TO_SUBMITTING;
        String result = clickLocator(locator, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        CLICK_YES_OR_NO_TO_SUBMITTING = "//h1[normalize-space()='Do you want to Submit']/following::button[.//span[normalize-space()=''";
        return resultObj;
    }

     public Object selectYesOrNoToSubmit(String language, String yesOrNo) {
        waitForDuration(5);
        CLICK_YES_OR_NO_TO_SUBMIT = CLICK_YES_OR_NO_TO_SUBMIT + yesOrNo +  "')]][1]";
        String locator = "fr".equalsIgnoreCase(language) ? CLICK_YES_OR_NO_TO_SUBMIT_FR : CLICK_YES_OR_NO_TO_SUBMIT;
        String result = clickLocator(locator, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        CLICK_YES_OR_NO_TO_SUBMIT = "//h1[normalize-space()='Do you want to Submit']/following::button[.//span[contains(text(), '";
        return resultObj;
    }

    public Object selectAssessmentReviewStatus(String language, String status) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_LST_ASSESSMENT_REVIEW_STATUS_FR : LO_LST_ASSESSMENT_REVIEW_STATUS;
        String result = setDropdownAppian(locator, status, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public String verifyOutComeStatus(String status,String outComeStatus) {
        LO_TXT_OUTCOME_STATUS = LO_TXT_OUTCOME_STATUS + outComeStatus + "']";
        String result = validateWithinLocatorText(LO_TXT_OUTCOME_STATUS,outComeStatus,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        LO_TXT_OUTCOME_STATUS = "//div[span[text()='Outcome Status']]/following-sibling::div//span[text()='";
        return result;
    }

     public String verifySubOutcomeStatus(String status,String subOutComeStatus) {
        LO_TXT_SUB_OUTCOME_STATUS = LO_TXT_SUB_OUTCOME_STATUS + subOutComeStatus + "']";
        String result = validateWithinLocatorText(LO_TXT_SUB_OUTCOME_STATUS,subOutComeStatus,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        LO_TXT_SUB_OUTCOME_STATUS = "//div[span[text()='Outcome Status']]/following-sibling::div//span[text()='";
        return result;
    }

    public Object selectCoverage(String language, String coverage) {
        waitForDuration(5);
        CLICK_COVERAGE = CLICK_COVERAGE + coverage +  "']";
        String locator = "fr".equalsIgnoreCase(language) ? CLICK_COVERAGE_FR : CLICK_COVERAGE;
        String result = clickLocator(locator, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

     public Object selectSubOutcome(String language, String subCoverage) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_LST_SUB_OUTCOME_FR : LO_LST_SUB_OUTCOME;
        String result = setDropdownAppian(locator, subCoverage, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object addCommentOnCoverage(String language, String comment) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_EDT_VALID_COVERAGE_COMMENT_FR : LO_EDT_VALID_COVERAGE_COMMENT;
        String result = setText(locator, comment, FW_ConfigMgr.getDefaultTimeout(), false);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object clickOnUpdateClaimButtonTopRight(String language) {
        waitForDuration(15);
        String locator = "fr".equalsIgnoreCase(language) ? LO_BUT_UPDATE_CLAIM_TYPES_FR : LO_BUT_UPDATE_CLAIM_TYPES;
        String result = clickLocator(locator, 3);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object clearGroupName(String newGroup) {
        WebElement existingGroupName = driver.findElement(By.xpath("//div[label[text()='Group name']]/following-sibling::div//input"));
        existingGroupName.clear();
        String result = setText("//div[label[text()='Group name']]/following-sibling::div//input", newGroup, (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"), false);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object clearCity(String city) {
        typeOnKeyboard("ARROW_UP");
        typeOnKeyboard("ARROW_UP");
        typeOnKeyboard("ARROW_UP");
        typeOnKeyboard("ARROW_UP");
        WebElement existingCityName = driver.findElement(By.xpath("//div[label[text()='City']]/following-sibling::div//input"));
        existingCityName.clear();
        String result = setText("//div[label[text()='City']]/following-sibling::div//input", city, (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"), false);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object clickButtonContinue() {
        String result = clickLocator("//button[span[span[text()='Continue']]]", 3);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object clickUpdateClaimButton() {
        typeOnKeyboard("ARROW_DOWN");
        typeOnKeyboard("ARROW_DOWN");
        typeOnKeyboard("ARROW_DOWN");
        typeOnKeyboard("ARROW_DOWN");
        String result = clickLocator("//button[span[span[text()='Update Claim']]]", 3);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        waitForDuration(10, "s", false); // Wait to perform next check
        return resultObj;
    }

    public Object clickOnHistoryLink() {
        String result = clickLocator("//div[text()='History']", FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    public Object clickOnSummaryNavLink() {
        String result = clickLocator("//div[text()='Summary']", FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        waitForDuration(10, "s", false); // Wait to perform next check
        return resultObj;
    }
    public Object clickOnFirstLog() {
        waitForDuration(5, "s", false); // Wait to perform next check
        String result = clickLocator("(//p[text()='submitted a claim'])[1]", FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object getUpdatesFromHistoryTab() {
        waitForDuration(5, "s", false); // Wait to perform next check
        String result = validateLocatorExists("//p[contains(text(), '/0')]", FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        String textUpdate = driver.findElement(By.xpath("//p[contains(text(), '/0')]")).getText();
        String[] parts = textUpdate.split("value changed: ");
        for (int i=2; i<parts.length;i++) {
            String change = parts[i].split(";")[0].trim();
            updated_data.add(change);
            System.out.println(i +" is : " + change);
        }
        //System.out.println("updated_data: "+ updated_data);
        try {
            FileWriter writer = new FileWriter("historyupdates.txt", true);
            writer.write(updated_data + "\n");
        writer.close();
        } catch (Exception e) {
            
        }
        return resultObj;
    }
    //String[] parts;
    public Object verifyChanges(String expectedString) {
        waitForDuration(5, "s", false); // Wait to perform next check
        String result = validateLocatorExists("//p[contains(text(), '/0')]", FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        if(expectedString.equals(updated_data)){
            System.out.println("expctedString: "+expectedString+ "EQULAS ACTUAL STRING = : "+ updated_data);
        }
        else{
            System.out.println("exctedString: "+expectedString+ "DOES NOT EQUAL!= : "+ "actual String: "+ updated_data);
        }
        // System.out.println("ConvertedString: "+ array);
        // System.out.println("Check This: "+ parts);
        // try {
        //     FileWriter writer = new FileWriter("historyupdates.txt", true);
        //     writer.write(updated_data + "\n");
        // writer.close();
        // } catch (Exception e) {
            
        // }
        return resultObj;
    }

    public Object clickSearchButton(String language) {
        waitForDuration(5);
        String locator = "fr".equalsIgnoreCase(language) ? LO_EDT_SEARCH_BUTTON_CLAIM_NUMBER_FR : LO_EDT_SEARCH_BUTTON_CLAIM_NUMBER;
        String result = clickLocator(locator, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object frontPageVerificationHeaders(String language, String header) {
        waitForDuration(5);
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_FRONT_PAGE_VERIFICATION_HEADERS_FR : LO_TXT_FRONT_PAGE_VERIFICATION_HEADERS;
        String result = validateWithinLocatorText(locator,header,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object frontPageVerificationValues(String language, String value) {
        waitForDuration(5);
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_FRONT_PAGE_VERIFICATION_VALUES_FR : LO_TXT_FRONT_PAGE_VERIFICATION_VALUES;
        String result = validateWithinLocatorText(locator,value,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

  
public Object verifyCurrentDate(String language) {
    waitForDuration(5);
    String currentDate = LocalDate.now().format(DateTimeFormatter.ofPattern("MMM d, yyyy"));
    String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_FRONT_PAGE_VERIFICATION_VALUES_FR : LO_TXT_FRONT_PAGE_VERIFICATION_VALUES;
    String resultDate = validateWithinLocatorText(locator, currentDate, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(), true);
    String finalResult =  resultDate;
    FW_TestStep resultObj = FW_TestStepUtils.createTestStep(finalResult, Thread.currentThread());
    return resultObj;
}


    public Object verifyPolicyNumberOrInsuranceType(String language, String policyOrInsuranceType) {
        waitForDuration(5);
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_INFORMATION_POLICY_INSURANCE_VERIFICATION_FR : LO_TXT_INFORMATION_POLICY_INSURANCE_VERIFICATION;
        String result = validateWithinLocatorText(locator,policyOrInsuranceType,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object verifyCustomerName(String language, String customerName) {
        waitForDuration(5);
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_INFORMATION_SECTION_CUSTOMER_NAME_FR : LO_TXT_INFORMATION_SECTION_CUSTOMER_NAME;
        String result = validateWithinLocatorText(locator,customerName,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    public Object verifyClaimantName(String language, String customerName) {
        waitForDuration(5);
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_INFORMATION_SECTION_CLAIMANT_NAME_FR : LO_TXT_INFORMATION_SECTION_CLAIMANT_NAME;
        String result = validateWithinLocatorText(locator,customerName,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    public Object verifyLossDetailsAmount(String language, String lossAmount) {
        waitForDuration(5);
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_LOSS_DETAILS_SECTION_AMOUNT_LOST_FR : LO_TXT_LOSS_DETAILS_SECTION_AMOUNT_LOST;
        String result = validateWithinLocatorText(locator,lossAmount,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    public Object verifyActiveTasks(String language, String activeTasks) {
        waitForDuration(5);
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_TASKS_SECTION_ACTIVE_FR : LO_TXT_TASKS_SECTION_ACTIVE;
        String result = validateWithinLocatorText(locator,activeTasks,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    public Object verifyResolvedTasks(String language, String resolvedTasks) {
        waitForDuration(5);
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_TASKS_SECTION_RESOLVED_FR : LO_TXT_TASKS_SECTION_RESOLVED;
        String result = validateWithinLocatorText(locator,resolvedTasks,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public String verifyTasksLabels(String taskLabels) {
        LO_TXT_TASKS_LABELS = LO_TXT_TASKS_LABELS + taskLabels + "']]";
        String result = validateWithinLocatorText(LO_TXT_TASKS_LABELS,taskLabels,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        LO_TXT_TASKS_LABELS = "//div[span[text()='";
        return result;
    }

    public Object veriyManualPolicyValidation(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_LINK_MANUAL_POLICY_VALIDATION_FR : LO_LINK_MANUAL_POLICY_VALIDATION;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    public Object veriyReadyStatus(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_READY_STATUS_FR : LO_TXT_READY_STATUS;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    public Object veriyProcessedAutomationAsAssignee(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_PROCESSED_AUTOMATION_ASSIGNEE_FR : LO_TXT_PROCESSED_AUTOMATION_ASSIGNEE;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public String verifyStatus(String status,String completionDate) {
        LO_TXT_STATUSES = LO_TXT_STATUSES + status + "']]";
        String result = validateWithinLocatorText(LO_TXT_STATUSES,completionDate,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        LO_TXT_STATUSES = "//p[text()='";
        return result;
    }

    public String verifyStatusTimelineLabels(String status,String completionDate) {
        LO_TXT_STATUSES = LO_TXT_STATUSES + status + "']";
        String result = validateWithinLocatorText(LO_TXT_STATUSES,completionDate,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        LO_TXT_STATUSES = "//p[text()='";
        return result;
    }

    public String verifyClaimLandingPageStatus(String status,String landingPageStatus) {
        LO_TXT_CLAIMS_LANDING_PAGE_STATUS = LO_TXT_CLAIMS_LANDING_PAGE_STATUS + landingPageStatus + "']]";
        String result = validateWithinLocatorText(LO_TXT_CLAIMS_LANDING_PAGE_STATUS,landingPageStatus,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        LO_TXT_CLAIMS_LANDING_PAGE_STATUS = "//div[span[text()='";
        return result;
    }

    public Object verifyOpenedClaimAtWhichValidation(String language, String validationStage) {
        waitForDuration(5);
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_OPENED_CLAIM_VALIDATION_FR : LO_TXT_OPENED_CLAIM_VALIDATION;
        String result = validateWithinLocatorText(locator,validationStage,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
        
        public Object verifyClaimLastUpdatedDate(String language) {
        waitForDuration(5);
        String locator = "fr".equalsIgnoreCase(language)? LO_TXT_CLAIM_LAST_UPDATED_DATE_FR : LO_TXT_CLAIM_LAST_UPDATED_DATE;
        String today = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        String result = validateWithinLocatorText( locator,today,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object verifyValidationParagraph(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_VALIDATION_PARAGRAPH_FR : LO_TXT_VALIDATION_PARAGRAPH;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object verifyQuickActionsTitle(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_QUICK_ACTIONS_TITLE_FR : LO_TXT_QUICK_ACTIONS_TITLE;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    public Object verifyAddCommentButton(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_BUT_ADD_COMMENT_FR : LO_BUT_ADD_COMMENT;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    public Object verifyAdditionalInformationHeading(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_ADDITIONAL_INFORMATION_HEADING_FR : LO_TXT_ADDITIONAL_INFORMATION_HEADING;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public String verifyAdditionalInformationLabels(String language, String additionalInformationLabels) {
        LO_TXT_ADDITIONAL_INFORMATION_LABELS = LO_TXT_ADDITIONAL_INFORMATION_LABELS + additionalInformationLabels + "']]";
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_ADDITIONAL_INFORMATION_HEADING_FR : LO_TXT_ADDITIONAL_INFORMATION_HEADING;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval());
        LO_TXT_ADDITIONAL_INFORMATION_LABELS = "//div[span[text()='";
        return result;
    }

    public Object verifyCloneClaimButton(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_BUT_CLONE_CLAIM_FR : LO_BUT_CLONE_CLAIM;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

     public Object verifyCreateUpdateOtherInsuranceButton(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_BUT_CREATE_UPDATE_OTHER_INSURANCE_FR : LO_BUT_CREATE_UPDATE_OTHER_INSURANCE;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object verifyNavigationLinks(String language, String navigationLinks) {
        LO_LNK_NAVIGATION_LINKS = LO_LNK_NAVIGATION_LINKS + navigationLinks + "']";
        String locator = "fr".equalsIgnoreCase(language) ? LO_LNK_NAVIGATION_LINKS_FR : LO_LNK_NAVIGATION_LINKS;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        LO_LNK_NAVIGATION_LINKS = "//div[text()='";
        return resultObj;
    }

    public Object verifyPriority(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_PRIORITY_VERIFY_FR : LO_TXT_PRIORITY_VERIFY;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

      public Object verifyLandingPageUpRightButtons(String language, String landingPageUpRightButtons) {
        LO_BUT_LANDING_PAGE_UP_RIGHT_BUTTONS = LO_BUT_LANDING_PAGE_UP_RIGHT_BUTTONS + landingPageUpRightButtons + "')]";
        String locator = "fr".equalsIgnoreCase(language) ? LO_BUT_LANDING_PAGE_UP_RIGHT_BUTTONS_FR : LO_BUT_LANDING_PAGE_UP_RIGHT_BUTTONS;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        LO_BUT_LANDING_PAGE_UP_RIGHT_BUTTONS = "//span[contains(text(), '";
        return resultObj;
    }

     public Object clickViewAllLink(String language) { 
        waitForDuration(5);
        String locator = "fr".equalsIgnoreCase(language) ? LO_LNK_VIEW_ALL_FR : LO_LNK_VIEW_ALL;
        String result = clickLocator(locator, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

     public Object verifyRecentDocuments(String language, String recentdocuments) {
        LO_LNK_RECENT_DOCUMENTS = LO_LNK_RECENT_DOCUMENTS + recentdocuments + "')]";
        String locator = "fr".equalsIgnoreCase(language) ? LO_LNK_RECENT_DOCUMENTS_FR : LO_LNK_RECENT_DOCUMENTS;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        LO_LNK_RECENT_DOCUMENTS = "//a[contains(text(), '";
        return resultObj;
    }

    public Object verifyOtherRecentDocuments(String language, String recentdocuments) {
        LO_RECENT_DOCUMENTS = LO_RECENT_DOCUMENTS + recentdocuments + "')]";
        String locator = "fr".equalsIgnoreCase(language) ? LO_RECENT_DOCUMENTS_FR : LO_RECENT_DOCUMENTS;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        LO_RECENT_DOCUMENTS = "//strong[contains(text(), '";
        return resultObj;
    }

     public Object verifySummarySectionLabels(String language, String summarySectionLabels) {
        LO_TXT_SUMMARY_SECTION_LABELS = LO_TXT_SUMMARY_SECTION_LABELS + summarySectionLabels + "']";
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_SUMMARY_SECTION_LABELS_FR : LO_TXT_SUMMARY_SECTION_LABELS;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        LO_TXT_SUMMARY_SECTION_LABELS = "//div/h2[text()='";
        return resultObj;
    }

    public Object verifyPolicyValidationHubSectionLabels(String language, String summarySectionLabels) {
        LO_TXT_POLICY_VALIDATION_HUB_SECTION_LABELS = LO_TXT_POLICY_VALIDATION_HUB_SECTION_LABELS + summarySectionLabels + "']";
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_POLICY_VALIDATION_HUB_SECTION_LABELS_FR : LO_TXT_POLICY_VALIDATION_HUB_SECTION_LABELS;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        LO_TXT_POLICY_VALIDATION_HUB_SECTION_LABELS = "//div/h5[text()='";
        return resultObj;
    }

     public Object clickAddComment(String language) { 
        waitForDuration(5);
        String locator = "fr".equalsIgnoreCase(language) ? LO_BUT_ADD_COMMENT_FR : LO_BUT_ADD_COMMENT;
        String result = clickLocator(locator, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object clickInfoRequestedFromButton(String language, String infoRequestedFromButton) { 
        LO_RAD_INFO_REQUESTED_FROM = LO_RAD_INFO_REQUESTED_FROM + infoRequestedFromButton + "')]]";
        waitForDuration(5);
        String locator = "fr".equalsIgnoreCase(language) ? LO_RAD_INFO_REQUESTED_FROM_FR : LO_RAD_INFO_REQUESTED_FROM;
        String result = clickLocator(locator, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        LO_RAD_INFO_REQUESTED_FROM = "//div[label[contains(text(), '";
        waitForDuration(5);
        return resultObj;
    }
    
    public Object clickThreeDots(String language) { 
        waitForDuration(5);
        String locator = "fr".equalsIgnoreCase(language) ? LO_BUT_ACTIONS_FR : LO_BUT_ACTIONS;
        String result = clickLocator(locator, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object verifyFirstName(String language, String firstName) {
        waitForDuration(5);
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_FIRST_NAME_VERIFY_FR : LO_TXT_FIRST_NAME_VERIFY;
        String result = validateWithinLocatorText(locator,firstName,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

     public Object verifyLastName(String language, String lastName) {
        waitForDuration(5);
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_LAST_NAME_VERIFY_FR : LO_TXT_LAST_NAME_VERIFY;
        String result = validateWithinLocatorText(locator,lastName,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    } 

    public Object verifyPhoneNumber(String language, String phoneNumber) {
        waitForDuration(5);
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_PHONE_NUMBER_VERIFY_FR : LO_TXT_PHONE_NUMBER_VERIFY;
        String result = validateWithinLocatorText(locator,phoneNumber,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object verifyEmail(String language, String email) {
        waitForDuration(5);
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_EMAIL_VERIFY_FR : LO_TXT_EMAIL_VERIFY;
        String result = validateWithinLocatorText(locator,email,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

     public Object verifyClaimStatus(String language, String claimStatus) {
        waitForDuration(5);
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_CLAIM_STATUS_FR : LO_TXT_CLAIM_STATUS;
        String result = validateWithinLocatorText(locator,claimStatus,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object verifyOutcome(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_OUTCOME_FR : LO_TXT_OUTCOME;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object verifyComments(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_COMMENTS_FR : LO_TXT_COMMENTS;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

     public Object verifyClaimActivityTitle(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_CLAIM_ACTIVITY_FR : LO_TXT_CLAIM_ACTIVITY;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

     public Object verifyTotalAmountClaimed(String language, String totalAmountClaimed) {
        waitForDuration(5);
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_VERIFY_TOTAL_AMOUNT_CLAIMED_FR : LO_TXT_VERIFY_TOTAL_AMOUNT_CLAIMED;
        String result = validateWithinLocatorText(locator,totalAmountClaimed,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

      public Object verifyTotalAmountPaid(String language, String totalAmountPaid) {
        waitForDuration(5);
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_VERIFY_TOTAL_AMOUNT_PAID_FR : LO_TXT_VERIFY_TOTAL_AMOUNT_PAID;
        String result = validateWithinLocatorText(locator,totalAmountPaid,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object verifyReviewStatus(String language, String reviewStatus) {
        waitForDuration(5);
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_REVIEW_STATUS_FR : LO_TXT_REVIEW_STATUS;
        String result = validateWithinLocatorText(locator,reviewStatus,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

     public Object verifyOutcomeStatusVerify(String language, String outcomeStatus) {
        waitForDuration(5);
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_OUTCOME_STATUS_VERIFY_FR : LO_TXT_OUTCOME_STATUS_VERIFY;
        String result = validateWithinLocatorText(locator,outcomeStatus,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

     public Object clickToSelectDocumentOne(String language) { 
        waitForDuration(5);
        String locator = "fr".equalsIgnoreCase(language) ? LO_LST_SELECT_DOCUMENTS_FR : LO_LST_SELECT_DOCUMENTS;
        String result = clickLocator(locator, FW_ConfigMgr.getDefaultTimeout());
        typeOnKeyboard("ENTER");
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
     }

       public Object clickToSelectDocumentTwo(String language) { 
        waitForDuration(5);
        String locator = "fr".equalsIgnoreCase(language) ? LO_LST_SELECT_DOCUMENTS_FR : LO_LST_SELECT_DOCUMENTS;
        String result = clickLocator(locator, FW_ConfigMgr.getDefaultTimeout());
        typeOnKeyboard("ARROW_UP");
        typeOnKeyboard("ENTER");
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
     }

public Object typeEnter(String language) { 
     waitForDuration(5);
    String locator = "fr".equalsIgnoreCase(language) ? LO_LST_SELECT_DOCUMENTS_FR : LO_LST_SELECT_DOCUMENTS;
    typeOnKeyboard("ENTER");
    FW_TestStep resultObj = FW_TestStepUtils.createTestStep(locator, Thread.currentThread());
    return resultObj;
}


 public Object verifyRequestInformation(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_REQUEST_INFORMATION_FR : LO_TXT_REQUEST_INFORMATION;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

     public Object clickRequestInformation(String language) { 
        waitForDuration(5);
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_REQUEST_INFORMATION_FR : LO_TXT_REQUEST_INFORMATION;
        String result = clickLocator(locator, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
     }

 public Object clickAddNew(String language) { 
        waitForDuration(5);
        String locator = "fr".equalsIgnoreCase(language) ? LO_LNK_ADD_NEW_FR : LO_LNK_ADD_NEW;
        String result = clickLocator(locator, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
     }

     public Object clickCancel(String language) { 
        waitForDuration(5);
        String locator = "fr".equalsIgnoreCase(language) ? LO_LNK_CANCEL_FR : LO_LNK_CANCEL;
        String result = clickLocator(locator, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
     }

      public Object getSubmitDocumentClaimNumber(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_SUBMIT_DOCUMENTS_CLAIM_NUMBER_FR : LO_TXT_SUBMIT_DOCUMENTS_CLAIM_NUMBER;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        String text = driver.findElement(By.xpath(locator)).getText();
        claimNumber = text.replaceAll("\\D+", "");
        System.out.println("Extracted number: "+claimNumber);
        set_claim_numbers.add(claimNumber);
        System.out.println("Extracted number: " + set_claim_numbers);
        try {
            FileWriter writer = new FileWriter("collect.txt", true);
            writer.write(claimNumber + "\n");
        writer.close();
        } catch (Exception e) {
            
        }
        return resultObj;
    }

    /**
     * Types a key on the keyboard.
     *
     * @param key The key to type.
     * 
     * @return True if the key was typed, false otherwise.
     */
    public boolean typeOnKeyboard(String key) {
        Actions actions = new Actions(driver);

        // Use a switch expression to determine the key action
        Keys keyToSend = switch (key.toUpperCase()) {
            case "TAB" -> Keys.TAB;
            case "ENTER" -> Keys.ENTER;
            case "ESCAPE" -> Keys.ESCAPE;
            case "ARROW_UP" -> Keys.ARROW_UP;
            case "ARROW_DOWN" -> Keys.ARROW_DOWN;
            // Add more cases as needed
            default -> null; // Invalid key
        };

        // If the key is invalid, return false
        if (keyToSend == null) {
            System.out.println("Invalid key: " + key);
            return false;
        }

        // Perform the key action
        actions.sendKeys(keyToSend).perform();
        return true;
    }

     public Object clickVerifyAndUploadDocuments(String language) { 
        waitForDuration(5);
        String locator = "fr".equalsIgnoreCase(language) ? LO_LNK_VERIFY_AND_UPLOAD_DOCUMENTS_FR : LO_LNK_VERIFY_AND_UPLOAD_DOCUMENTS;
        String result = clickLocator(locator, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
     }
     
    public Object switchToVerifyDocumentsTab() {
       String result = switchToWindowByPosition(1, FW_ConfigMgr.getDefaultTimeout());
       FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
       return resultObj;
     }

     public Object enterPolicyIssueDate(String language, String policyIssueDate) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_EDT_POLICY_ISSUE_DATE_FR : LO_EDT_POLICY_ISSUE_DATE;
        String result = setText(locator, policyIssueDate, FW_ConfigMgr.getDefaultTimeout(), false);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object enterCommonReferenceNumber(String language, String commonReferenceNumber) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_COMMON_REFERENCE_NUMBER_FR : LO_COMMON_REFERENCE_NUMBER;
        String result = setText(locator, commonReferenceNumber, FW_ConfigMgr.getDefaultTimeout(), false);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object selectChoiceOfFinalyze(String language, String yesOrNo) {
        waitForDuration(5);
        CLICK_YES_OR_NO_TO_FINALYZE = CLICK_YES_OR_NO_TO_FINALYZE + yesOrNo +  "']";
        String locator = "fr".equalsIgnoreCase(language) ? CLICK_YES_OR_NO_TO_FINALYZE_FR : CLICK_YES_OR_NO_TO_FINALYZE;
        String result = clickLocator(locator, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        CLICK_YES_OR_NO_TO_FINALYZE = "//div[div[div[div[div[h4[text()='Are you sure you want to finalize?']]]]]]/following-sibling::div//button//span[text()='";
        return resultObj;
    }

     public Object refreshCurrentPage() {
    String result = refreshPage();
    FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
    return resultObj;
}

    public Object clickClose(String language) { 
        waitForDuration(5);
        String locator = "fr".equalsIgnoreCase(language) ? LO_BUT_CLOSE_FR : LO_BUT_CLOSE;
        String result = clickLocator(locator, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
     }

      public Object clickYesToFinalize(String language) { 
        waitForDuration(5);
        String locator = "fr".equalsIgnoreCase(language) ? LO_BUT_YES_FR : LO_BUT_YES;
        String result = clickLocator(locator, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
     }

      public Object clickTheLink(String language, String link) {
        waitForDuration(5);
        LO_LNK_UPDATED_LINKS = LO_LNK_UPDATED_LINKS + link +  "']]";
        String locator = "fr".equalsIgnoreCase(language) ? LO_LNK_UPDATED_LINKS_FR : LO_LNK_UPDATED_LINKS;
        String result = clickLocator(locator, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        LO_LNK_UPDATED_LINKS = "//a[.//span[text()='";
        return resultObj;
    }

    public Object addCommentToCaptureMissingInfo(String language, String comment) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_EDT_ADD_COMMENT_FR : LO_EDT_ADD_COMMENT;
        String result = setText(locator, comment, FW_ConfigMgr.getDefaultTimeout(), false);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

     /**
     * Scrolls at a given locator.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public Object scrollToSubmit() {
        String result = scrollToLocator(LO_BUT_SUBMIT);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object clickSubmit(String language) { 
        waitForDuration(5);
        String locator = "fr".equalsIgnoreCase(language) ? LO_BUT_SUBMIT_FR : LO_BUT_SUBMIT;
        String result = clickLocator(locator, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
     }

     public Object verifyType(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_TYPE_FR : LO_TXT_TYPE;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object verifyNonMedicalType(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_NON_MEDICAL_TYPE_FR : LO_TXT_NON_MEDICAL_TYPE;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

     public Object verifyNonMedicalCrimeRelated(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_NON_MEDICAL_CRIME_RELATED_FR : LO_TXT_NON_MEDICAL_CRIME_RELATED;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }


    public Object verifyClosed(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_CLOSED_FR : LO_TXT_CLOSED;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

     public Object verifyUnderReview(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_UNDER_REVIEW_FR : LO_TXT_UNDER_REVIEW;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    

    public Object verifyClaimFinalized(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_CLAIM_FINALIZED_FR : LO_TXT_CLAIM_FINALIZED;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object verifyClaimInAssessment(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_CLAIM_IN_ASSESSMENT_FR : LO_TXT_CLAIM_IN_ASSESSMENT;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

     public Object verifyViewAssessmentHub(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_VIEW_ASSESSMENT_HUB_FR : LO_TXT_VIEW_ASSESSMENT_HUB;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

      public Object verifyRequiredFields(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_REQUIRED_FIELD_PARAGRAPH_FR : LO_TXT_REQUIRED_FIELD_PARAGRAPH;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

     public Object verifyViewAllLink(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_LNK_VIEW_ALL_FR : LO_LNK_VIEW_ALL;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

      public Object verifyCorporateClient(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_VERIFY_CORPORATE_CLIENT_FR : LO_TXT_VERIFY_CORPORATE_CLIENT;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

     public Object verifyPolicyNumber(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_VERIFY_POLICY_NUMBER_FR : LO_TXT_VERIFY_POLICY_NUMBER;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

     public Object verifyIssueDate(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_VERIFY_ISSUE_DATE_FR : LO_TXT_VERIFY_ISSUE_DATE;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

     public Object verifyInsuranceType(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_VERIFY_INSURANCE_TYPE_FR : LO_TXT_VERIFY_INSURANCE_TYPE;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

     public Object verifyStatus(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_VERIFY_STATUS_FR : LO_TXT_VERIFY_STATUS;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object verifyFirstName(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_VERIFY_FIRST_NAME_FR : LO_TXT_VERIFY_FIRST_NAME;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

     public Object verifyLastName(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_VERIFY_LAST_NAME_FR : LO_TXT_VERIFY_LAST_NAME;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

     public Object verifyRelation(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_VERIFY_RELATION_FR : LO_TXT_VERIFY_RELATION;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

     public Object verifyPhoneNumber(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_VERIFY_PHONE_NUMBER_FR : LO_TXT_VERIFY_PHONE_NUMBER;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

     public Object verifyEmail(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_VERIFY_EMAIL_FR : LO_TXT_VERIFY_EMAIL;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

     public Object verifyPPHIEmail(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_VERIFY_PPHI_EMAIL_FR : LO_TXT_VERIFY_PPHI_EMAIL;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }


     public Object verifyDateOfBirth(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_VERIFY_DATE_OF_BIRTH_FR : LO_TXT_VERIFY_DATE_OF_BIRTH;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

     public Object verifyAddress(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_VERIFY_ADDRESS_FR : LO_TXT_VERIFY_ADDRESS;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

      public Object clickOnClaimDetails() {
        String result = clickLocator("//div[text()='Claim Details']", FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object verifyTravelDateFrom(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_VERIFY_TRAVEL_DATE_FROM_FR : LO_TXT_VERIFY_TRAVEL_DATE_FROM;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object verifyTravelDateTo(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_VERIFY_TRAVEL_DATE_TO_FR : LO_TXT_VERIFY_TRAVEL_DATE_TO;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object verifyIncidentDate(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_VERIFY_INCIDENT_DATE_FR : LO_TXT_VERIFY_INCIDENT_DATE;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object verifyReportedDate(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_VERIFY_REPORTED_DATE_FR : LO_TXT_VERIFY_REPORTED_DATE;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object verifyJourneyName(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_VERIFY_JOURNEY_NAME_FR : LO_TXT_VERIFY_JOURNEY_NAME;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object verifyRelatedPolicy(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_VERIFY_RELATED_POLICY_FR : LO_TXT_VERIFY_RELATED_POLICY;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object verifyLossValue(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_VERIFY_LOSS_VALUE_FR : LO_TXT_VERIFY_LOSS_VALUE;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;

    }
    
    public Object verifyChannel(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_VERIFY_CHANNEL_FR : LO_TXT_VERIFY_CHANNEL;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object verifyReviewStatus(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_VERIFY_REVIEW_STATUS_FR : LO_TXT_VERIFY_REVIEW_STATUS;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object verifyPrimaryContact(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_VERIFY_PRIMARY_CONTACT_FR : LO_TXT_VERIFY_PRIMARY_CONTACT;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object verifyMobile(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_VERIFY_MOBILE_FR : LO_TXT_VERIFY_MOBILE;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object verifyPreferredLanguage(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_VERIFY_PREFERRED_LANGUAGE_FR : LO_TXT_VERIFY_PREFERRED_LANGUAGE;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object verifySource(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_VERIFY_SOURCE_FR : LO_TXT_VERIFY_SOURCE;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object verifyPPHISource(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_VERIFY_PPHI_SOURCE_FR : LO_TXT_VERIFY_PPHI_SOURCE;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object verifyCoverage(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_VERIFY_COVERAGE_FR : LO_TXT_VERIFY_COVERAGE;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object verifyCategoryType(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_VERIFY_CATEGORY_TYPE_FR : LO_TXT_VERIFY_CATEGORY_TYPE;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object verifyProducts(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_VERIFY_PRODUCTS_FR : LO_TXT_VERIFY_PRODUCTS;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object verifyCommonReference(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_VERIFY_COMMON_REFERENCE_FR : LO_TXT_VERIFY_COMMON_REFERENCE;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object verifyLineOfBusiness(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_VERIFY_LINE_OF_BUSINESS_FR : LO_TXT_VERIFY_LINE_OF_BUSINESS;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object verifyEffectiveStartDate(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_VERIFY_EFFECTIVE_START_DATE_FR : LO_TXT_VERIFY_EFFECTIVE_START_DATE;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object verifyEffectiveEndDate(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_VERIFY_EFFECTIVE_END_DATE_FR : LO_TXT_VERIFY_EFFECTIVE_END_DATE;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object verifyClientRef(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_VERIFY_CLIENT_REF_FR : LO_TXT_VERIFY_CLIENT_REF;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object verifyBrokerSponsorCodeSellingAgent(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_VERIFY_BROKER_SPONSOR_CODE_SELLING_AGENT_FR : LO_TXT_VERIFY_BROKER_SPONSOR_CODE_SELLING_AGENT;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object clickOnMasterPolicy() {
        String result = clickLocator("//div[text()='Master Policy']", FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object verifyMasterPolicyHolder(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_VERIFY_MASTER_POLICY_HOLDER_FR : LO_TXT_VERIFY_MASTER_POLICY_HOLDER;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object verifyPolicyReference(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_VERIFY_POLICY_REFERENCE_FR : LO_TXT_VERIFY_POLICY_REFERENCE;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object verifyProduct(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_VERIFY_PRODUCT_FR : LO_TXT_VERIFY_PRODUCT;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object verifyPolicyIssue(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_VERIFY_POLICY_ISSUE_DATE_FR : LO_TXT_VERIFY_POLICY_ISSUE_DATE;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object verifyMasterPolicyEffectiveStartDate(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_VERIFY_MASTER_POLICY_EFFECTIVE_START_DATE_FR : LO_TXT_VERIFY_MASTER_POLICY_EFFECTIVE_START_DATE;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object verifyMasterPolicyEffectiveEndDate(String language) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_VERIFY_MASTER_POLICY_EFFECTIVE_END_DATE_FR : LO_TXT_VERIFY_MASTER_POLICY_EFFECTIVE_END_DATE;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object clickOnAllClaims() {
        String result = clickLocator("//div[text()='All Claims']", FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object clickOnAdditionalInfo() {
        String result = clickLocator("//div[text()='Additional Info']", FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object verifyUpdatedLinks(String language, String updatedLink) {
         LO_LNK_UPDATED_LINKS = LO_LNK_UPDATED_LINKS + updatedLink +  "']]";
        String locator = "fr".equalsIgnoreCase(language) ? LO_LNK_UPDATED_LINKS_FR : LO_LNK_UPDATED_LINKS;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        LO_LNK_UPDATED_LINKS = "//a[.//span[text()='";
        return resultObj;
    }

    public Object verifyFinancialsPage(String language) {
        waitForDuration(3);
        String result = validateLocatorExists(LO_TXT_FINANCIALS_PAGE,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
 }

    public Object verifyReservesSummary(String language) {
        String result = validateLocatorExists(LO_TXT_RESERVES_SUMMARY,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object verifyReserveSection(String language, String reserveSection) {
        String locator = LO_TXT_RESERVE_SECTION + reserveSection + "']";
        String result = validateLocatorExists(locator,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
}

    public Object clickFinancialsTransactionTab(String language,String tabName) {
        waitForDuration(2);
        String locator = LO_TXT_TRANSACTION_TAB +tabName +"']]";
        String result = clickLocator(locator,FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj =FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object verifyTransactionHeader(String language,String headerName) {
    String locator =LO_TXT_TRANSACTION_HEADER +headerName + "']";
    String result = validateLocatorExists(locator,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
    FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
    return resultObj;
    }

    public Object verifyTransactionValue( String language,String transactionValue) {
    String locator = "//*[normalize-space()='" +transactionValue +"']";
    String result = validateLocatorExists(locator,FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval());
    FW_TestStep resultObj =FW_TestStepUtils.createTestStep(result, Thread.currentThread());
    return resultObj;
    }

     public Object verifyTotalBilled(String language, String summaryEstimatedCosts) {
         LO_TXT_TOTAL_BILLED = LO_TXT_TOTAL_BILLED + summaryEstimatedCosts +  "')]]";
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_TOTAL_BILLED_FR : LO_TXT_TOTAL_BILLED;
        String result = validateLocatorExists(locator, FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        LO_TXT_TOTAL_BILLED = "//p[span[contains(text(), '";
        return resultObj;
    }

            public Object verifyReopenClaim(String language, String reopenClaimVerification) {
            String locator;
            if ("fr".equalsIgnoreCase(language)) {
                    locator = LO_EDT_REOPEN_CLAIM_VERIFY_FR;
                } else {
                    locator = LO_EDT_REOPEN_CLAIM_VERIFY
                            + reopenClaimVerification
                            + "')]]/following-sibling::div//input";
                }

                String result = validateLocatorExists(
                        locator,
                        FW_ConfigMgr.getDefaultTimeout(),
                        FW_ConfigMgr.getDefaultInterval()
                );

                return FW_TestStepUtils.createTestStep(
                        result,
                        Thread.currentThread()
                );
            }

    public Object enterDueDate(String language, String dueDate) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_EDT_DUE_DATE_FR : LO_EDT_DUE_DATE;
        String result = setText(locator, dueDate, FW_ConfigMgr.getDefaultTimeout(), false);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

     public Object enterTime(String language, String time) {
        String locator = "fr".equalsIgnoreCase(language) ? LO_EDT_TIME_FR : LO_EDT_TIME;
        String result = setText(locator, time, FW_ConfigMgr.getDefaultTimeout(), false);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object verifyStatusIsOpen() {
        String result = validateLocatorExists(TXT_STATUS_OPEN, FW_ConfigMgr.getDefaultTimeout(),FW_ConfigMgr.getDefaultInterval());
        return FW_TestStepUtils.createTestStep(result,Thread.currentThread());
     }

}