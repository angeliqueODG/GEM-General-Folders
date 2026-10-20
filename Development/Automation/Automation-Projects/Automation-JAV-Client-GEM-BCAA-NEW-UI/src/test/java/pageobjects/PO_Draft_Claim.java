package pageobjects;

// Import class packages for this Page Object (PO)
import org.openqa.selenium.WebDriver;

import customizations.automation.CU_Appian; // Customization for Appian and where FW_Page is extended

import framework.junit.FW_TestStep;
import framework.utilities.FW_ConfigMgr;
import framework.utilities.FW_TestStepUtils;

public class PO_Draft_Claim extends CU_Appian {

    private static final String LO_BUT_BACK = "//button[@type='button']//span//span[contains(text(),'Back')]"; // Had to use double span to isolate from accessibility
    private static final String LO_BUT_RETURN_TO_HOMEPAGE = "//button[@type='button']//span//span[contains(text(),'Return to homepage')]"; // Had to use double span to isolate from accessibility
    private static final String LO_TXT_CONTINUE_DRAFT_CLAIM = "//h4[contains(text(), 'Continue Draft Claim')]/..";
    private static final String LO_TXT_CONTINUE_DRAFT_CLAIM_VERIFY = "//span[contains(text(), 'Continue Draft Claim')]/..";
    private static final String LO_TXT_RESUME_DRAFT_CLAIM_VERIFY = "//span[contains(text(), 'Resume Draft Claim')]";
    private static final String LO_EDT_INTENT_ID = "//div[label='Intent ID']/following-sibling::div//input";
    private static final String LO_EDT_EMAIL = "//div[label='Email']/following-sibling::div//input";
    private static final String LO_EDT_FIRST_NAME = "//div[label='First Name']/following-sibling::div//input";
    private static final String LO_EDT_LAST_NAME = "//div[label='Last Name']/following-sibling::div//input";
    private static final String LO_EDT_DATE_OF_BIRTH = "//div[label='Date of Birth']/following-sibling::div//input";
    private static final String LO_TXT_CLAIM_AS_DRAFT_HEADER = "//h2/span[contains(text(), 'Save claim as a draft')]";

    /**
     * Define the Page Object (PO) constructor.
     * @param driver The WebDriver object passed from the test method.
     */
    public PO_Draft_Claim(WebDriver driver) {
        super(driver);
    }

    /**
     * Validates if current webpage is loaded and correct. 
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object validateOnPage() {
        String result = validateLocatorExists(LO_TXT_CONTINUE_DRAFT_CLAIM, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if current webpage is loaded and correct. 
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object verifyOnPage() {
        String result = validateLocatorExists(LO_TXT_CONTINUE_DRAFT_CLAIM_VERIFY, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Validates if the 'Resume Draft Claim' text is present on the page.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object verifyOnPageResumeDraftClaim() {
        String result = validateLocatorExists(LO_TXT_RESUME_DRAFT_CLAIM_VERIFY, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Enters the Intent ID.
     * 
     * @param intentID The Intent ID to enter.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object enterIntentID(String intentID) {
        String result = setText(LO_EDT_INTENT_ID, intentID, FW_ConfigMgr.getDefaultTimeout(), false);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Enters the Email.
     * 
     * @param email The Email to enter.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object enterEmail(String email) {
        String result = setText(LO_EDT_EMAIL, email, FW_ConfigMgr.getDefaultTimeout(), false);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Enters the First Name.
     * 
     * @param firstName The First Name to enter.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object enterFirstName(String firstName) {
        String result = setText(LO_EDT_FIRST_NAME, firstName, FW_ConfigMgr.getDefaultTimeout(), false);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Enters the Last Name.
     * 
     * @param lastName The Last Name to enter.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object enterLastName(String lastName) {
        String result = setText(LO_EDT_LAST_NAME, lastName, FW_ConfigMgr.getDefaultTimeout(), false);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Enters the Date of Birth.
     * 
     * @param dateOfBirth The Date of Birth to enter.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object enterDateOfBirth(String dateOfBirth) {
        String result = setText(LO_EDT_DATE_OF_BIRTH, dateOfBirth, FW_ConfigMgr.getDefaultTimeout(), false);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
    
    /**
     * Clicks the 'Back' Button.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object clickBackButton() {
        String result = clickLocator(LO_BUT_BACK, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Clicks the 'Return to homepage' Button.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object clickReturnToHomepageButton() {
        String result = clickLocator(LO_BUT_RETURN_TO_HOMEPAGE, FW_ConfigMgr.getDefaultTimeout());
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }

    /**
     * Scrolls to the top of the page.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public Object scrollTop() {
        String result = scrollToLocator(LO_TXT_CLAIM_AS_DRAFT_HEADER);
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread());
        return resultObj;
    }
}
