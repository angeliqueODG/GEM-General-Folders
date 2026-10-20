package pageobjects;

// Import class packages for this Page Object (PO)
import org.openqa.selenium.WebDriver; // Selenium WebDriver
import org.openqa.selenium.WebElement;

import framework.automation.FW_Page; // Automation framework Page Object (PO) class
import org.openqa.selenium.By;

/**
 * Page Object (PO) class used in the Page Object (PO) design pattern.
 * Inherits from the FW_Page class.
 */
// [Note: Automation Engineer, rename this Page Object (PO) class to match the
// filename.]
public class PO_Order extends FW_Page {

    // [Note: Automation Engineer, define the Page Object (PO) locators (LO) here.]
    private static final String LO_EDT_ADDRESS1 = "//input[@name='order.shipAddress1']";
    private static final String LO_EDT_ADDRESS2 = "//input[@name='order.shipAddress2']";

    /**
     * Define the Page Object (PO) constructor.
     * 
     * @param driver The WebDriver object passed from the test method.
     */
    // [Note: Automation Engineer, rename this Page Object (PO) class to match the
    // filename.]
    public PO_Order(WebDriver driver) {
        super(driver);
    }

    // [Note: Automation Engineer, define the Page Object (PO) methods here.]

    /**
     * Clicks the locator Clears text and returns a string indicating the result of
     * the
     * operation.
     *
     * @param locator The XPath locator to check for.
     * @param timeout The number of seconds to wait before timing out.
     * @return A string containing the result of the operation.
     */
    /**
     * Enter your Address 1
     * 
     * @param deleteAndenterAddress1 The text to enter in the address 1 field.
     * @param driver
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     * 
     *         details.
     * 
     */
    public String deleteAndenterAddress1(String deleteAndenterAddress1, WebDriver driver) {
        try {
            WebElement address1Field = driver.findElement(By.xpath(LO_EDT_ADDRESS1));
            address1Field.clear(); // Clear the text field
            address1Field.sendKeys(deleteAndenterAddress1); // Enter the new text
            return "[PASS] Successfully entered address 1: " + deleteAndenterAddress1;
        } catch (Exception e) {
            return "[FAIL] Failed to enter address 1: " + e.getMessage();
        }
    }

    /**
     * Clicks the locator Clears text and returns a string indicating the result of
     * the
     * operation.
     *
     * @param locator The XPath locator to check for.
     * @param timeout The number of seconds to wait before timing out.
     * @return A string containing the result of the operation.
     */
    /**
     * Enter your Address 2
     * 
     * @param deleteAndenterAddress2 The text to enter in the address 1 field.
     * @param driver
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     * 
     *         details.
     * 
     */
    public String deleteAndenterAddress2(String deleteAndenterAddress2, WebDriver driver) {
        try {
            WebElement address1Field = driver.findElement(By.xpath(LO_EDT_ADDRESS2));
            address1Field.clear();
            address1Field.sendKeys(deleteAndenterAddress2);
            return "[PASS] Successfully entered address 1: " + deleteAndenterAddress2;
        } catch (Exception e) {
            return "[FAIL] Failed to enter address 1: " + e.getMessage();
        }
    }

}