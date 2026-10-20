package pageobjects;

// Import class packages for this Page Object (PO)
import org.openqa.selenium.WebDriver;   // Selenium WebDriver
import framework.automation.FW_Page;    // Automation framework Page Object (PO) class
import framework.utilities.FW_ConfigMgr;   // Automation framework Configuration Manager to retrieve testConfig.properties values
import framework.utilities.FW_StringUtils; // Automation framework String Utilities

import org.openqa.selenium.WebElement; // Selenium WebElement
import org.openqa.selenium.By; // Selenium By
import org.openqa.selenium.JavascriptExecutor; // Selenium JavaScriptExecutor
import java.util.Arrays; // Java Arrays
import java.util.List; // Java List Object properties values
import java.io.File; // Java File

/**
 * Page Object (PO) class used in the Page Object (PO) design pattern.
 * Inherits from the FW_Page class.
 */
// [Note: Automation Engineer, rename this Page Object (PO) class to match the filename.]
public class PO_Required_Documentss extends FW_Page {
    WebDriver driver; // Note sure why this is required but this will not work without it.

    // [Note: Automation Engineer, define the Page Object (PO) locators (LO) here.]
    private static final String LO_LBL_REQUIRED_DOCUMENTS="//h4[contains(text(),'Required Documents')]";
    private static final String LO_UPLOAD_PROOF_OF_PAYMENT = "(//button[@class='Button---btn Button---default_direction Button---primary Button---small Button---minimize_width Button---icon_only Button---no_label Button---icon_start'])[1]";
    private static final String LO_UPLOAD_TRAVEL_INVOICE = "//div[span='Original Booking Invoice']//input";
    private static final String LO_UPLOAD_ORIGINAL_ITINERARY = "//div[span='Original Travel Itinerary']//input";
    private static final String LO_DOC_CREDIT_CARD_STATEMENT = "//div[span='Credit Card Statement']//input";
    private static final String LO_DOC_CAUSE_OF_CLAIM = "//div[span='Proof of Cause of Claim']//input";
    private static final String LO_UPLOAD_CANCELLATION_PROOF = "//div[span='Proof of Cancellation']//input";
    private static final String LO_UPLOAD_EVENT_PROOF = "//div[span=\"Proof of Cause of Claim - GEM Medical Certificate or Doctor's Note\"]//input";
    private static final String LO_BUT_CONTINUE = "(//span//span[contains(text(), 'Continue')])";
    
    /**
     * Define the Page Object (PO) constructor.
     * @param driver The WebDriver object passed from the test method.
     */
    // [Note: Automation Engineer, rename this Page Object (PO) class to match the filename.]
    public PO_Required_Documentss(WebDriver driver) {
        super(driver);
    }

     /**
     * Verify on Required Documents page by "Required Documents"
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String validateRequiredDocuments() {
        String result = validateWithinLocatorText(LO_LBL_REQUIRED_DOCUMENTS, "Required Documents",
                FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval(), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName());
        return result;
    }

    /**
     * Uploads a file to a web app.
     * 
     * @param filePath The relative path of the file from the user's home directory.
     * @param locator  The XPath of the file input element on the web page.
     * 
     * @return A string message indicating the success or failure of the file upload.
     */
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
     * Uploads a payment proof document.
     * 
     * @param filePath The relative path of the payment proof file from the user's home directory.
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String uploadProofOfPayment(String filePath) {
        String result = uploadFileV2(filePath, LO_UPLOAD_PROOF_OF_PAYMENT);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    // /**
    //  * Uploads a travel invoice.
    //  * 
    //  * @param filePath The relative path of the invoice file from the user's home directory.
    //  * @return A string including [PASS] or [FAIL] along with specific result details.
    //  */
    // public String uploadTravelInvoice(String filePath) {
    //     String result = uploadFileV2(filePath, LO_UPLOAD_TRAVEL_INVOICE);
    //     result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
    //     return result;
    // }

    // /**
    //  * Uploads an original itinerary.
    //  * 
    //  * @param filePath The relative path of the itinerary file from the user's home directory.
    //  * @return A string including [PASS] or [FAIL] along with specific result details.
    //  */
    // public String uploadORIGINALITINERARY(String filePath) {
    //     String result = uploadFileV2(filePath, LO_UPLOAD_ORIGINAL_ITINERARY);
    //     result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
    //     return result;
    // }

    // /**
    //  * Uploads a cancellation proof document.
    //  * 
    //  * @param filePath The relative path of the cancellation proof file from the user's home directory.
    //  * @return A string including [PASS] or [FAIL] along with specific result details.
    //  */
    // public String uploadCANCELLATIONPROOF(String filePath) {
    //     String result = uploadFileV2(filePath, LO_UPLOAD_CANCELLATION_PROOF);
    //     result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
    //     return result;
    // }

    // /**
    //  * Uploads the credit card statement.
    //  * 
    //  * @param filePath The relative path of the itinerary file from the user's home directory.
    //  * @return A string including [PASS] or [FAIL] along with specific result details.
    //  */
    // public String uploadCreditCardStatement(String filePath) {
    //     String result = uploadFileV2(filePath, LO_DOC_CREDIT_CARD_STATEMENT);
    //     result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
    //     return result;
    // }

    // /**
    //  * Uploads the cause of the claim.
    //  * 
    //  * @param filePath The relative path of the itinerary file from the user's home directory.
    //  * @return A string including [PASS] or [FAIL] along with specific result details.
    //  */

    // public String uploadCauseOfClaim(String filePath) {
    //     String result = uploadFileV2(filePath, LO_DOC_CAUSE_OF_CLAIM);
    //     result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
    //     return result;
    // }

    // /**
    //  * Uploads an event proof document.
    //  * 
    //  * @param filePath The relative path of the event proof file from the user's home directory.
    //  * @return A string including [PASS] or [FAIL] along with specific result details.
    //  */
    // public String uploadEVENTPROOF(String filePath) {
    //     String result = uploadFileV2(filePath, LO_UPLOAD_EVENT_PROOF);
    //     result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
    //     return result;
    // }
    // /**
    //  * Clicks "Continue" button.
    //  * 
    //  * @return A string including [PASS] or [FAIL] along with specific result details.
    //  */
    // public String clickContinueButton() {
    //     String result = clickLocator(LO_BUT_CONTINUE, 3);
    //     result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
    //     return result;
    // }
   



}
