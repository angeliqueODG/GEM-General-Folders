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
import java.util.ArrayList;
import java.util.List;
import java.io.FileWriter;
import org.junit.jupiter.api.Test;
import java.util.*;
/**
 * Page Object (PO) class used in the Page Object (PO) design pattern. Inherits
 * from the CU_Appian class.
 */
// [Note: Automation Engineer, rename this Page Object (PO) class to match the
// filename.]
public class PO_Claim_Submission extends CU_Appian {

    // [Note: Automation Engineer, define the Page Object (PO) locators (LO) here.]
    private static final String LO_TXT_CLAIM_SUBMISSION_PAGE_VERIFY = "//h2[text()='YOUR CLAIM HAS BEEN SUBMITTED!']";
    private static final String LO_TXT_CLAIM_NUMBER = "//p[span[text()='Your claim number is']]";
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
    private static final String LO_TXT_CLAIM_LAST_UPDATED_DATE= "//span[text()=' Last Updated: ']";
    private static final String LO_TXT_VALIDATION_PARAGRAPH= "//p[text()='Claim is undergoing system validation checks.']";
    private static final String LO_TXT_QUICK_ACTIONS_TITLE= "//p[strong[text()='Quick Actions:']]";
    private static final String LO_BUT_ADD_COMMENT_QUICK_ACTIONS= "//div[div[div[div[p[strong[text()='Quick Actions:']]]]]]/following-sibling::div//button[span//span[text()='Add Comment']]";
    private static final String LO_TXT_ADDITIONAL_INFORMATION_HEADING= "//div/h6[text()='Additional Information']";
    String CLICK_CLAIM_NUMBER = "//strong[a[text()='";
    String LO_TXT_SUMMARY_LABEL = "//div[h2[text()='";
    String LO_TXT_TASKS_LABELS = "//div[span[text()='";
    String LO_TXT_STATUSES = "//p[text()='";
    String LO_TXT_ADDITIONAL_INFORMATION_LABELS = "//div[span[text()='";
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

    String claimNumber="";
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
        CLICK_CLAIM_NUMBER = CLICK_CLAIM_NUMBER + temp +  "']]";
        String locator = "fr".equalsIgnoreCase(language) ? CLICK_CLAIM_NUMBER_FR : CLICK_CLAIM_NUMBER;
        String result = clickLocator(locator, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
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

    public Object verifyOpenedClaimAtWhichValidation(String language, String validationStage) {
        waitForDuration(5);
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_OPENED_CLAIM_VALIDATION_FR : LO_TXT_OPENED_CLAIM_VALIDATION;
        String result = validateWithinLocatorText(locator,validationStage,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    public Object verifyClaimLastUpdatedDate(String language, String lastUpdatedDate) {
        waitForDuration(5);
        String locator = "fr".equalsIgnoreCase(language) ? LO_TXT_CLAIM_LAST_UPDATED_DATE_FR : LO_TXT_CLAIM_LAST_UPDATED_DATE;
        String result = validateWithinLocatorText(locator,lastUpdatedDate,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval(),true);
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
        String locator = "fr".equalsIgnoreCase(language) ? LO_BUT_ADD_COMMENT_QUICK_ACTIONS_FR : LO_BUT_ADD_COMMENT_QUICK_ACTIONS;
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
    
}
