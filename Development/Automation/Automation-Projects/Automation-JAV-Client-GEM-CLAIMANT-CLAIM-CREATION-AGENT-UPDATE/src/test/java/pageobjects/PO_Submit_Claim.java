package pageobjects;

// Import class packages for this Page Object (PO)
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By; // Customization for Appian and where FW_Page is extended
import org.openqa.selenium.WebDriver;

import customizations.automation.CU_Appian;
import framework.utilities.FW_ConfigMgr;
import framework.utilities.FW_StringUtils;

/**
 * Page Object (PO) class used in the Page Object (PO) design pattern. Inherits from the CU_Appian class.
 */
// [Note: Automation Engineer, rename this Page Object (PO) class to match the filename.]
public class PO_Submit_Claim extends CU_Appian {

    // [Note: Automation Engineer, define the Page Object (PO) locators (LO) here.]
    private static final String LO_TXT_CLAIM_OPENING = "//h1[contains(text(),'Claim Opening - ')]";
    private static final String LO_LBL_CLAIM_SUBMISSION = "//h2[contains(text(),'YOUR CLAIM HAS BEEN SUBMITTED!')]";
    private static final String LO_TXT_CLAIM_NUMBER = "//p[span[text()='Your claim number is']]";
    private static final String LO_BUT_BACK = "//span[text()='Back']";
     // [Note: Automation Engineer, define the Page Object (PO) locators (LO) here.]
    private static final String LO_TXT_CLAIM_SUBMISSION_PAGE_VERIFY = "//h2[text()='YOUR CLAIM HAS BEEN SUBMITTED!']";
    private static final String LO_BUT_CLAIMS_NAV_LINK = "//div[span='Claims']";
    private static final String LO_EDT_CLAIM_NUMBER_OBTAINED = "//div[div[div[div[button[span//span[text()='Search']]]]]]/div//input";
    private static final String LO_EDT_SEARCH_BUTTON_CLAIM_NUMBER = "//button[span//span[text()='Search']]";
    private static final String LO_BUT_UPDATE_CLAIM_TYPES = "(//button[span//span[text()='Update Claims']])[1]";
    String CLICK_CLAIM_NUMBER = "//strong[a[text()='";
    //-------------------------------------------- FR locators----------------------------------------------------------------------
    private static final String LO_TXT_CLAIM_SUBMISSION_PAGE_VERIFY_FR = "";
    private static final String LO_TXT_CLAIM_NUMBER_FR = "";
    private static final String LO_BUT_CLAIMS_NAV_LINK_FR = "";
    private static final String LO_EDT_CLAIM_NUMBER_OBTAINED_FR = "";
    private static final String LO_EDT_SEARCH_BUTTON_CLAIM_NUMBER_FR = "";
    String CLICK_CLAIM_NUMBER_FR = "";
    private static final String LO_BUT_UPDATE_CLAIM_TYPES_FR = "";

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
    // [Note: Automation Engineer, rename this Page Object (PO) class to match the filename.]
    public PO_Submit_Claim(WebDriver driver) {
        super(driver);
    }

    /**
     * Validates if current webpage is loaded and correct.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateOnPage() {
        String result = validateLocatorExists(LO_TXT_CLAIM_OPENING, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if "YOUR CLAIM HAS BEEN SUBMITTED!" exists.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateClaimSubmissionSuccess() {
        String result = validateLocatorExists(LO_LBL_CLAIM_SUBMISSION, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Validates if "Your Claim Number is" text exists.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateYourClaimNumber() {
        String result = validateLocatorExists(LO_TXT_CLAIM_NUMBER, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Clicks the  "Back" button.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String clickBackButton() {
        String result = clickLocator(LO_BUT_BACK, FW_ConfigMgr.getDefaultTimeout());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
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
}
