package framework.automation;

// ===============================================================
// @file: FW_Page.java
// @filepath: src/test/java/framework/automation/FW_Page.java
// @version: 1.1.0
// @updated: 2025-09-09 06:35:00 PM CDT
// @author: Greg Paskal
// @company: MissionWares
//
// @description:
// Base class for page objects in the automation framework. Extends FW_Driver
// to provide comprehensive page interaction methods including element validation,
// text manipulation, form controls, navigation, alert handling, iframe/window
// switching, and file uploads. Implements user satisfaction assessment for
// performance monitoring and configurable element highlighting. Designed to be
// extended by specific page object classes representing individual application pages.
//
// @methods:
// - navigateTo(String url) - Navigates to specified URL
// - validateLocatorExists(String, int, int) - Validates element presence
// - setText(String, String, int, boolean) - Sets text in input fields
// - clickLocator(String, int) - Clicks specified element
// - setCheckbox(String, boolean, int) - Sets checkbox state
// - setDropdown(String, String, int) - Selects dropdown value
// - switchToIframe(String, int) - Switches to iframe context
// - validateExactMatch(String, String, String) - Compares strings
// - fileUpload(String, String, int) - Uploads file to element
//
// @dependencies:
// - org.openqa.selenium.WebDriver
// - org.openqa.selenium.support.ui.Select
// - framework.junit.FW_TestStep
// - framework.utilities.FW_ConfigMgr
// - framework.utilities.FW_TestStepUtils
//
// @tags: page-object, selenium, automation, base-class, mAi™
//
// @changeLog:
// Date        Author          Version  Description
// ----------  --------------  -------  --------------------------
// 2025-01-01  G. Paskal       1.0.0    Initial creation
// 2025-09-09  G. Paskal       1.1.0    Updated header to mAi™ standard format
// ===============================================================

import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import framework.junit.FW_TestStep;
import framework.junit.FW_TestStep.TestStepType;
import framework.utilities.FW_CSSUtils;
import framework.utilities.FW_ConfigMgr;
import framework.utilities.FW_DateTimeUtils;
import framework.utilities.FW_PerformanceUtils;
import framework.utilities.FW_StringUtils;
import framework.utilities.FW_TestStepUtils;

/**
 * This class extends FW_Driver and provides additional methods for interacting with a web page.
 */
public class FW_Page extends FW_Driver {
    // Remove the 'driver' field here
    // WebDriver driver; // This is no longer needed

    /**
     * Constructs a new FW_Page with the specified WebDriver.
     *
     * @param driver the WebDriver to be used
     */
    public FW_Page(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }


    /**
     * Takes a screenshot and return is in a test step object.
     * 
     * @param Details
     * 
     * @return
     */
    public Object takeScreenshot(String details) {

        // Prepare the result object
        String metaTag = "[Shot]";
        String durationTag = "{0.0}";
        String resultCombines = metaTag + " - " + durationTag + " - " + details;

        // Build the result object
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(resultCombines, Thread.currentThread(), TestStepType.SCREENSHOT.getValue());

        // Return the result object
        return resultObj;
    }

    public Object recordNote(String details) {

        // Prepare the result object
        String metaTag = "[Note]";
        String durationTag = "{0.0}";
        String resultCombines = metaTag + " - " + durationTag + " - " + details;

        // Build the result object
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(resultCombines, Thread.currentThread(), TestStepType.NOTE.getValue());

        // Return the result object
        return resultObj;
    }

    /**
     * Returns a set containing all the cookies.
     * 
     * @return A Set of all the cookies.
     */
    public Set<Cookie> getAllCookies() {
        return driver.manage().getCookies();
    }

    /**
     * Deletes all cookies and returns a string indicating the result of the operation.
     *
     * @return A string containing the result of the operation.
     */
    public String deleteAllCookies() {
        Instant startTime = Instant.now();
        final String locator = ""; // Placeholder for the locator

        try {
            driver.manage().deleteAllCookies();

            // Process success result details
            Map<String, Object> resultProcessed = FW_TestStepUtils.inStepAnalysis(startTime, true, locator);
            String assessResultTime = (String) resultProcessed.get("assessResultTime");

            return assessResultTime + " - Deleted all cookies."; // Return success.
        } catch (Exception e) {
            // Process failure result details
            Map<String, Object> resultProcessed = FW_TestStepUtils.inStepAnalysis(startTime, false, locator);
            String assessResultFailTime = (String) resultProcessed.get("assessResultFailTime");

            return assessResultFailTime + " - Failed to delete all cookies."; // Return failure.
        }
    }

    /**
     * Sets a cookie and returns a string indicating the result of the operation.
     *
     * @param cookieName  The cookie name to set.
     * @param cookieValue The value to set the named cookie.
     * 
     * @return A string containing the result of the operation.
     */
    public String setCookie(String cookieName, String cookieValue) {
        Instant startTime = Instant.now();
        final String locator = ""; // Placeholder for the locator

        try {
            Cookie cookie = new Cookie.Builder(cookieName, cookieValue).build();
            driver.manage().addCookie(cookie);

            // Process success result details
            Map<String, Object> resultProcessed = FW_TestStepUtils.inStepAnalysis(startTime, true, locator);
            String assessResultTime = (String) resultProcessed.get("assessResultTime");

            return assessResultTime + " - Set cookie '" + cookieName + "' to value '" + cookieValue + "'."; // Return success.

        } catch (Exception e) {
            // Process failure result details
            Map<String, Object> resultProcessed = FW_TestStepUtils.inStepAnalysis(startTime, false, locator);
            String assessResultFailTime = (String) resultProcessed.get("assessResultFailTime");

            return assessResultFailTime + " - Could not set cookie '" + cookieName + "' to value '" + cookieValue + "'."; // Return failure.
        }
    }

    /**
     * Navigates to a URL and returns a string indicating the result of the operation.
     *
     * @param url The URL to load.
     * 
     * @return A string containing the result of the operation.
     */
    public String navigateTo(String url) {
        Instant startTime = Instant.now();
        String locator = "//body"; // XPath for entire webpage
        
        // Validate the URL
        if (url == null || url.isEmpty()) {
            return "Failed - URL cannot be null or empty.";
        }

        try {
            // Load the URL
            boolean result = loadUrl(url);

            // Processing result details
            Map<String, Object> resultProcessed = FW_TestStepUtils.inStepAnalysis(startTime, result, locator);
            String assessResultTime = (String) resultProcessed.get("assessResultTime");
            String assessResultFailTime = (String) resultProcessed.get("assessResultFailTime");
            String assessColor = (String) resultProcessed.get("assessColor");
            boolean highlightLocator = (boolean) resultProcessed.get("highlightLocator");

            // Modify the assessColor CSS for highlighting the locator on load if configured to do so.
            if (("true".equals(FW_ConfigMgr.getLocatorHighlightOnLoad().toLowerCase())) && (result == true)) {
                
                // Break out the style values from assessColor
                Map<String, String> styleValues = FW_CSSUtils.extractStyleValues(assessColor);

                // Build a new assessColor with borderTop but keeping width, style, and color
                assessColor = "arguments[0].style.borderTop='" + styleValues.get("width") + "px " + styleValues.get("style") + " " + styleValues.get("color") + "'";

                // Highlight the locator if configured to do so.
                if (highlightLocator == true) {locatorHighlight(locator, assessColor);}
            }
            
            // Return success or failure message
            if (result == true) {
                return assessResultTime + " - Navigated to URL: '" + url + "'."; // Return success.
            } else {
                return assessResultFailTime + " - Could not navigate to URL: '" + url + "'."; // Return failure.
            }
            
        } catch (Exception e) {
            boolean result = false;
            Map<String, Object> resultProcessed = FW_TestStepUtils.inStepAnalysis(startTime, result, locator);
            String assessResultFailTime = (String) resultProcessed.get("assessResultFailTime");

            return assessResultFailTime + " - An error occurred when navigating to URL: '" + url + "'. " + e.getMessage(); // Return failure.
        }
    }

    /**
     * Validates that the URL contains the specified string. Useful for verifying environment.
     *
     * @param withinURL The string to check for existance within the URL.
     * 
     * @return A string containing the result of the operation.
     */
    public String validateWithinCurrentURL(String withinURL) {
        Instant startTime = Instant.now();
        boolean result = true;
        String locator = withinURL;

        // Get the current URL
        String currentURL = driver.getCurrentUrl();

        // Processing result details
        Map<String, Object> resultProcessed = FW_TestStepUtils.inStepAnalysis(startTime, result, locator);
        String assessResultTime = (String) resultProcessed.get("assessResultTime");
        String assessResultFailTime = (String) resultProcessed.get("assessResultFailTime");

        if (currentURL.contains(withinURL)) {
            return assessResultTime + " - '" + withinURL + "' found within URL '" + currentURL + "'.";
        } else {
            return assessResultFailTime + " - '" + withinURL + "' not found within URL '" + currentURL + "'.";
        }
    }

    /**
     * Validates a page exists by checking the passed in locator for existance
     *
     * @param locator  The XPath locator to check for.
     * @param timeout  The number of seconds to wait before timing out.
     * @param interval The number of seconds to wait between checks.
     * 
     * @return A string containing the result of the operation.
     */
    public String validatePageExists(String locator, int timeout, int interval) {
        Instant startTime = Instant.now();
        boolean result = waitToExist(locator, timeout, interval);

        // Processing result details
        Map<String, Object> resultProcessed = FW_TestStepUtils.inStepAnalysis(startTime, result, locator);
        String assessResultTime = (String) resultProcessed.get("assessResultTime");
        String assessResultFailTime = (String) resultProcessed.get("assessResultFailTime");
        String assessColor = (String) resultProcessed.get("assessColor");
        boolean highlightLocator = (boolean) resultProcessed.get("highlightLocator");

        // Highlight the locator if configured to do so.
        String pageLocator = "//body"; // XPath for the entire webpage
        if (highlightLocator == true) {locatorHighlight(pageLocator, assessColor);}

        if (result == true) {
            return assessResultTime + " - Validated page exist based on locator: '" + locator + "' existing."; // Return success.
        } else {
            return assessResultFailTime + " - Validated page does not exist or latent based on locator: '" + locator + "' not existing."; // Return failure.
        }
    }

    /**
     * Validates that the locator exists on the page and returns a string indicating the result of the operation.
     *
     * @param locator  The XPath locator to check for.
     * @param timeout  The number of seconds to wait before timing out.
     * @param interval The number of seconds to wait between checks.
     * 
     * @return A string containing the result of the operation.
     */
    public String validateLocatorExists(String locator, int timeout, int interval) {
        Instant startTime = Instant.now();
        boolean result = waitToExist(locator, timeout, interval);

        // Processing result details
        Map<String, Object> resultProcessed = FW_TestStepUtils.inStepAnalysis(startTime, result, locator);
        String assessResultTime = (String) resultProcessed.get("assessResultTime");
        String assessResultFailTime = (String) resultProcessed.get("assessResultFailTime");
        String assessColor = (String) resultProcessed.get("assessColor");
        boolean highlightLocator = (boolean) resultProcessed.get("highlightLocator");

        if (highlightLocator == true) {locatorHighlight(locator, assessColor);} // Highlight the locator if configured

        if (result == true) {
            return assessResultTime + " - Validated locator: '" + locator + "' exists."; // Return success.
        } else {
            return assessResultFailTime + " - Validated locator: '" + locator + "' does not exist."; // Return failure.
        }
    }

    /**
     * Validates that the locator does not exist on the page and returns a string indicating the result of the operation.
     *
     * @param locator  The XPath locator to check does not exist.
     * @param timeout  The number of seconds to wait before timing out.
     * @param interval The number of seconds to wait between checks.
     * 
     * @return A string containing the result of the operation.
     */
    public String validateLocatorNotExists(String locator, int timeout, int interval) {
        Instant startTime = Instant.now();
        final int maxAttempts = timeout / interval;

        for (int attempt = 0; attempt < maxAttempts; attempt++) {
            locatorHighlightHelper(locator, startTime, ""); // Highlight the locator

            // Check if the locator does not exist
            boolean result = waitToNotExist(locator, 0, 0);

            if (result) {
                // Process success result details
                Map<String, Object> resultProcessed = FW_TestStepUtils.inStepAnalysis(startTime, true, locator);
                String assessResultTime = (String) resultProcessed.get("assessResultTime");
                return assessResultTime + " - Validated locator: '" + locator + "' does not exist."; // Return success
            }

            FW_DateTimeUtils.waitForDuration(interval, "s", false); // Wait before the next check
        }

        // Highlight the locator as a failure
        locatorHighlightHelper(locator, startTime, "Fail");

        // Process failure result details
        Map<String, Object> resultProcessed = FW_TestStepUtils.inStepAnalysis(startTime, false, locator);
        String assessResultFailTime = (String) resultProcessed.get("assessResultFailTime");
        return assessResultFailTime + " - Validated locator: '" + locator + "' still exists after timeout of '" + timeout + "' seconds."; // Return failure
    }

    /**
     * Validates if the given search string is present within the text at the specified locator.
     *
     * @param locator The locator to check.
     * @param search The string to search for within the text at the locator.
     * @param timeout The maximum time to wait for the locator to exist.
     * @param interval The interval at which to check if the locator exists.
     * @param verbose If true, the full text found at the locator will be included in the result.
     *
     * @return A string indicating whether the search string was found within the text at the locator.
     */
    public String validateWithinLocatorText(String locator, String search, int timeout, int interval, boolean verbose) {
        Instant startTime = Instant.now();
        boolean result = waitToExist(locator, timeout, interval);

        // Locator exists, check for search string
        if (result == true) {

            locatorHighlightHelper(locator, startTime, ""); // Highlight the locator

            // Initialize variables
            String locatorText = null;
            int maxAttempts = timeout / interval;

            // Loop through the attempts to find the search string
            for (int attempt = 0; attempt < maxAttempts; attempt++) {
                locatorHighlightHelper(locator, startTime, ""); // Highlight the locator
                locatorText = getLocatorText(locator, timeout, interval); // Get the text at the locator.
                
                // Search string is found return a success message.
                if (locatorText.toLowerCase().contains(search.toLowerCase())) { // Convert to lower case here so return message is consistent.
                    locatorHighlightHelper(locator, startTime, ""); // Highlight the locator

                    // Processing result details
                    Map<String, Object> resultProcessed = FW_TestStepUtils.inStepAnalysis(startTime, result, locator);
                    String assessResultTime = (String) resultProcessed.get("assessResultTime");

                    // Generate success message
                    String message = assessResultTime + " - '" + search + "' found within text at locator: '" + locator + "'.";
                    if (verbose) { message += " - Entire text found: '" + FW_StringUtils.stringCleaner(locatorText, "return") + "'."; } // Enhance with verbose message if requested.
                    return message; // Return the message.
                }

                // Search string is not found wait for the interval and try again.
                FW_DateTimeUtils.waitForDuration(interval, "s", false); // Wait to perform next check

            }

            // Search string not found and maximum iterations reached, return a failure message.
            locatorHighlightHelper(locator, startTime, "Fail"); // Highlight the locator

            // Processing result details
            Map<String, Object> resultProcessed = FW_TestStepUtils.inStepAnalysis(startTime, result, locator);
            String assessResultFailTime = (String) resultProcessed.get("assessResultFailTime");

            // Generate failure message
            String message = assessResultFailTime + " - '" + search + "' not found within text at locator: '" + locator + "' after timeout of '" + timeout + "' seconds.";
            if (verbose == true) { message += " - Entire text found: '" + FW_StringUtils.stringCleaner(locatorText, "return") + "'."; } // Enhance with verbose message if requested.
            return message; // Return the message.

        // Locator - does not exists
        } else {
            locatorHighlightHelper(locator, startTime, "Fail"); // Highlight the locator

            // Processing result details
            Map<String, Object> resultProcessed = FW_TestStepUtils.inStepAnalysis(startTime, result, locator);
            String assessResultFailTime = (String) resultProcessed.get("assessResultFailTime");

            // Return a failure message as the locator does not exist.
            String message = assessResultFailTime + " - Locator: '" + locator + "' does not exist."; // Generate fail message
            return message; // Return the message.
        }
    }

    /**
     * Validates if the given search string is not present within the text at the specified locator.
     *
     * @param locator The locator to check.
     * @param search The string to search for within the text at the locator.
     * @param timeout The maximum time to wait for the locator to exist.
     * @param interval The interval at which to check if the locator exists.
     * @param verbose If true, the full text found at the locator will be included in the result.
     *
     * @return A string indicating whether the search string was not found within the text at the locator.
     * If the locator does not exist, a failure message is returned.
     */
    public String validateNotWithinLocatorText(String locator, String search, int timeout, int interval, boolean verbose) {
        Instant startTime = Instant.now();
        boolean result = waitToExist(locator, timeout, interval);

        // Locator exists, check for search string to not exist
        if (result == true) {

            locatorHighlightHelper(locator, startTime, ""); // Highlight the locator

            // Initialize variables
            String locatorText = null;
            int maxAttempts = timeout / interval;
    
            // Loop through the attempts to find if the search string is not found
            for (int attempt = 0; attempt < maxAttempts; attempt++) {

                locatorHighlightHelper(locator, startTime, ""); // Highlight the locator
                locatorText = getLocatorText(locator, timeout, interval); // Get the text at the locator.
    
                // Search string is not found return a success message.
                if (!locatorText.toLowerCase().contains(search.toLowerCase())) { // Convert to lower case here so return message is consistent.
                    locatorHighlightHelper(locator, startTime, ""); // Highlight the locator

                    // Processing result details
                    Map<String, Object> resultProcessed = FW_TestStepUtils.inStepAnalysis(startTime, result, locator);
                    String assessResultTime = (String) resultProcessed.get("assessResultTime");

                    // Generate success message
                    String message = assessResultTime + " - '" + search + "' not found within text at locator: '" + locator + "'.";
                    if (verbose) { message += " - Entire text found: '" + FW_StringUtils.stringCleaner(locatorText, "return") + "'."; } // Enhance with verbose message if requested.
                    return message; // Return the message.
                }
    
                // Search string is found wait for the interval and try again.
                FW_DateTimeUtils.waitForDuration(interval, "s", false); // Wait to perform next check

            }

            // Search string not found and maximum iterations reached, return a failure message.
            locatorHighlightHelper(locator, startTime, "Fail"); // Highlight the locator

            // Processing result details
            Map<String, Object> resultProcessed = FW_TestStepUtils.inStepAnalysis(startTime, result, locator);
            String assessResultFailTime = (String) resultProcessed.get("assessResultFailTime");

            // Generate failure message
            String message = assessResultFailTime + " - '" + search + "' found within text at locator: '" + locator + "' after timeout of '" + timeout + "' seconds.";
            if (verbose == true) { message += " - Entire text found: '" + FW_StringUtils.stringCleaner(locatorText, "return") + "'."; } // Enhance with verbose message if requested.
            return message; // Return the message.

        // Locator - does not exists
        } else {
            locatorHighlightHelper(locator, startTime, "Fail"); // Highlight the locator

            // Processing result details
            Map<String, Object> resultProcessed = FW_TestStepUtils.inStepAnalysis(startTime, result, locator);
            String assessResultFailTime = (String) resultProcessed.get("assessResultFailTime");

            // Return a failure message as the locator does not exist.
            String message = assessResultFailTime + " - Locator: '" + locator + "' does not exist."; // Generate fail message
            return message; // Return the message.
        }
    }

    /**
     * Get the text from a locator
     *
     * @param locator  The XPath locator to check for.
     * @param timeout  The number of seconds to wait before timing out.
     * @param interval The number of seconds to wait between checks.
     * 
     * @return A string containing the result of the operation.
     */
    public String getLocatorText(String locator, int timeout, int interval) {
        boolean result = waitToExist(locator, timeout, interval);

        if (result == true) {

            String attributeValue = valueFromLocatorAttribute(locator, "value");
            String textValue = textFromLocator(locator);

            boolean hasText = textValue != null && !textValue.isEmpty();
            boolean hasAttribute = attributeValue != null && !attributeValue.isEmpty();

            if (hasText && hasAttribute) {
                return textValue;
            } else if (hasText) {
                return textValue;
            } else if (hasAttribute) {
                return attributeValue;
            } else {
                return "";
            }

        } else {
            return "";
        }
    }

    /**
     * Sets the text of the locator and returns a string indicating the result of the operation.
     * 
     * @param locator    The XPath locator to check for.
     * @param value      The value to set the locator to.
     * @param timeout    The number of seconds to wait before timing out.
     * @param javascript Whether or not to use the Javascript approach to set the text.
     * 
     * @return A string containing the result of the operation.
     */
    public String setText(String locator, String value, int timeout, boolean javascript) {
        Instant startTime = Instant.now();
        boolean result = waitToExist(locator, timeout, 1);

        // Processing result details
        Map<String, Object> resultProcessed = FW_TestStepUtils.inStepAnalysis(startTime, result, locator);
        String assessResultTime = (String) resultProcessed.get("assessResultTime");
        String assessResultFailTime = (String) resultProcessed.get("assessResultTime");
        String assessColor = (String) resultProcessed.get("assessColor");
        String assessColorFail = (String) resultProcessed.get("assessColorFail");
        boolean highlightLocator = (boolean) resultProcessed.get("highlightLocator");

        // Locator exists, set the text.
        if (result == true) {

            if (javascript == true) {
                try {
                    JavascriptExecutor js = (JavascriptExecutor) driver;
                    WebElement element = driver.findElement(By.xpath(locator));
                    js.executeScript("arguments[0].value='" + value + "';", element);
                } catch (Exception e) {
                    if (highlightLocator == true) {locatorHighlight(locator, assessColorFail);} // Highlight the locator if configured
                    return assessResultFailTime + " - Tried to enter text using the Javascript approach into locator: '" + locator + "' but encountered error. Is element active and able to receive text from a user?"; // Return failure.
                }
            } else {
                try {
                    WebElement element = driver.findElement(By.xpath(locator));
                    element.sendKeys(value);
                } catch (NoSuchElementException e) {
                    if (highlightLocator == true) {locatorHighlight(locator, assessColorFail);} // Highlight the locator if configured
                    return assessResultFailTime + " - No element found with locator: '" + locator + "'. Has the locator been changed or removed?"; // Return failure.
                } catch (Exception e) {
                    if (highlightLocator == true) {locatorHighlight(locator, assessColorFail);} // Highlight the locator if configured
                    return assessResultFailTime + " - Tried to enter text into locator: '" + locator + "' but encountered an error: " + e.getMessage() + ". Is the element active and able to receive text from a user?"; // Return failure.
                }
            }

            if (highlightLocator == true) {locatorHighlight(locator, assessColor);} // Highlight the locator if configured

            return assessResultTime + " - Successfully entered '" + value + "' into locator: '" + locator + "'."; // Return success.

        // Locator does not exists, report failure.
        } else {
            return assessResultFailTime + " - Tried to enter text into locator: '" + locator + "' but locator not found. Check if locator changed or missing?"; // Return failure.
        }
    }

    /**
     * Clicks the locator and returns a string indicating the result of the operation.
     *
     * @param locator The XPath locator to check for.
     * @param timeout The number of seconds to wait before timing out.
     * 
     * @return A string containing the result of the operation.
     */
    public String clickLocator(String locator, int timeout) {
        Instant startTime = Instant.now();
        boolean result = waitToExist(locator, timeout, 1);

        // Processing result details
        Map<String, Object> resultProcessed = FW_TestStepUtils.inStepAnalysis(startTime, result, locator);
        String assessResultTime = (String) resultProcessed.get("assessResultTime");
        String assessResultFailTime = (String) resultProcessed.get("assessResultTime");
        String assessColor = (String) resultProcessed.get("assessColor");
        boolean highlightLocator = (boolean) resultProcessed.get("highlightLocator");

        // If locator exists, set the text.
        if (result == true) {

            try {
                WebElement element = driver.findElement(By.xpath(locator));
                element.click();

                if (highlightLocator == true) {locatorHighlight(locator, assessColor);} // Highlight the locator if configured

                return assessResultTime + " - Clicked locator: '" + locator + "'."; // Return success.

                } catch (NoSuchElementException e) {
                    return assessResultFailTime + " - Element with locator: '" + locator + "' does not exist."; // Return failure.
                } catch (WebDriverException e) {
                    return assessResultFailTime + " - Failed to click locator: '" + locator + "'. Error: " + e.getMessage(); // Return failure.
                }

        // If locator does not exists, report failure.
        } else {
            return assessResultFailTime + " - Tried to click locator: '" + locator + "' but it does not exist within the given timeout."; // Return failure.
        }
    }

    /**
     * Sets the state of a checkbox and returns a string indicating the results
     *
     * @param locator The XPath locator to check for.
     * @param desiredState The desired state of the checkbox.
     * @param timeout The number of seconds to wait before timing out.
     * 
     * @return A string containing the result of the operation.
     */
    public String setCheckbox(String locator, boolean desiredState, int timeout) {
        Instant startTime = Instant.now();
        boolean result = waitToExist(locator, timeout, FW_ConfigMgr.getDefaultInterval());

        // Processing result details
        Map<String, Object> resultProcessed = FW_TestStepUtils.inStepAnalysis(startTime, result, locator);
        String assessResultTime;
        String assessResultFailTime;
        String assessColor = (String) resultProcessed.get("assessColor");
        boolean highlightLocator = (boolean) resultProcessed.get("highlightLocator");

        if (highlightLocator == true) {locatorHighlight(locator, assessColor);} // Highlight the locator if configured

        // Locator exists, set the checkbox state.
        if (result == true) {

            try {
                // Get the checkbox element.
                WebElement checkbox = driver.findElement(By.xpath(locator));

                // Get the current state of the checkbox.
                boolean currentState = checkbox.isSelected();

                // Set the checkbox state based on the desired state.
                if (desiredState == true && currentState == false) {
                    checkbox.click();
                } else if (desiredState == false && currentState == true) {
                    checkbox.click();
                }

                // Processing result details
                resultProcessed = FW_TestStepUtils.inStepAnalysis(startTime, result, locator);
                assessResultTime = (String) resultProcessed.get("assessResultTime");
                assessColor = (String) resultProcessed.get("assessColor");
                highlightLocator = (boolean) resultProcessed.get("highlightLocator");

                if (highlightLocator == true) {locatorHighlight(locator, assessColor);} // Highlight the locator if configured

                return assessResultTime + " - Set checkbox state: '" + desiredState + "' for locator: '" + locator + "'."; // Success message

            // Locator does not exists, report failure.
            } catch (NoSuchElementException e) {

                // Processing result details
                resultProcessed = FW_TestStepUtils.inStepAnalysis(startTime, result, locator);
                assessResultFailTime = (String) resultProcessed.get("assessResultFailTime");
                assessColor = (String) resultProcessed.get("assessColor");
                highlightLocator = (boolean) resultProcessed.get("highlightLocator");

                if (highlightLocator == true) {locatorHighlight(locator, assessColor);} // Highlight the locator if configured

                return assessResultFailTime + " - Element with locator: '" + locator + "' does not exist."; // Return failure.

            // Failed to set the checkbox state.
            } catch (WebDriverException e) {

                // Processing result details
                resultProcessed = FW_TestStepUtils.inStepAnalysis(startTime, result, locator);
                assessResultFailTime = (String) resultProcessed.get("assessResultFailTime");
                assessColor = (String) resultProcessed.get("assessColor");
                highlightLocator = (boolean) resultProcessed.get("highlightLocator");

                if (highlightLocator == true) {locatorHighlight(locator, assessColor);} // Highlight the locator if configured

                return assessResultFailTime + " - Failed to set checkbox state: '" + desiredState + "' for locator: '" + locator + "'. Error: " + e.getMessage(); // Return failure.
            }
        } else {

            // Processing result details
            resultProcessed = FW_TestStepUtils.inStepAnalysis(startTime, result, locator);
            assessResultFailTime = (String) resultProcessed.get("assessResultFailTime");
            assessColor = (String) resultProcessed.get("assessColor");
            highlightLocator = (boolean) resultProcessed.get("highlightLocator");

            if (highlightLocator == true) {locatorHighlight(locator, assessColor);} // Highlight the locator if configured

            return assessResultFailTime + " - Tried to set checkbox state: '" + desiredState + "' for locator: '" + locator + "' but it does not exist within the given timeout."; // Return failure.
        }
    }

    /**
     * Sets the state of a radio button and returns a string indicating the results
     *
     * @param locator The XPath locator to check for.
     * @param desiredState The desired state of the radio button.
     * @param timeout The number of seconds to wait before timing out.
     * 
     * @return A string containing the result of the operation.
     */
    public String setRadioButton(String locator, boolean desiredState, int timeout) {
        Instant startTime = Instant.now();
        boolean result = waitToExist(locator, timeout, FW_ConfigMgr.getDefaultInterval());

        // Processing result details
        Map<String, Object> resultProcessed = FW_TestStepUtils.inStepAnalysis(startTime, result, locator);
        String assessResultTime;
        String assessResultFailTime;
        String assessColor = (String) resultProcessed.get("assessColor");
        boolean highlightLocator = (boolean) resultProcessed.get("highlightLocator");

        if (highlightLocator == true) {locatorHighlight(locator, assessColor);} // Highlight the locator if configured

        // Locator exists, set the radio button state.
        if (result == true) {

            try {
                // Get the radio button element.
                WebElement radioButton = driver.findElement(By.xpath(locator));

                // Get the current state of the radio button.
                boolean currentState = radioButton.isSelected();

                // Set the radio button state based on the desired state.
                if (desiredState == true && currentState == false) {
                    radioButton.click();
                } else if (desiredState == false && currentState == true) {
                    radioButton.click();
                }

                // Processing result details
                resultProcessed = FW_TestStepUtils.inStepAnalysis(startTime, result, locator);
                assessResultTime = (String) resultProcessed.get("assessResultTime");
                assessColor = (String) resultProcessed.get("assessColor");
                highlightLocator = (boolean) resultProcessed.get("highlightLocator");

                if (highlightLocator == true) {locatorHighlight(locator, assessColor);} // Highlight the locator if configured

                return assessResultTime + " - Set radio button state: '" + desiredState + "' for locator: '" + locator + "'."; // Success message

            // Locator does not exists, report failure.
            } catch (NoSuchElementException e) {

                // Processing result details
                resultProcessed = FW_TestStepUtils.inStepAnalysis(startTime, result, locator);
                assessResultFailTime = (String) resultProcessed.get("assessResultFailTime");

                return assessResultFailTime + " - Element with locator: '" + locator + "' does not exist."; // Return failure.

            // Failed to set the radio button state.
            } catch (WebDriverException e) {

                // Processing result details
                resultProcessed = FW_TestStepUtils.inStepAnalysis(startTime, result, locator);
                assessResultFailTime = (String) resultProcessed.get("assessResultFailTime");
                assessColor = (String) resultProcessed.get("assessColor");
                highlightLocator = (boolean) resultProcessed.get("highlightLocator");

                if (highlightLocator == true) {locatorHighlight(locator, assessColor);} // Highlight the locator if configured

                return assessResultFailTime + " - Failed to set radio button state: '" + desiredState + "' for locator: '" + locator + "'. Error: " + e.getMessage(); // Return failure.
            }
        } else {

            // Processing result details
            resultProcessed = FW_TestStepUtils.inStepAnalysis(startTime, result, locator);
            assessResultFailTime = (String) resultProcessed.get("assessResultFailTime");
            assessColor = (String) resultProcessed.get("assessColor");
            highlightLocator = (boolean) resultProcessed.get("highlightLocator");

            if (highlightLocator == true) {locatorHighlight(locator, assessColor);} // Highlight the locator if configured

            return assessResultFailTime + " - Tried to set radio button state: '" + desiredState + "' for locator: '" + locator + "' but it does not exist within the given timeout."; // Return failure.
        }
    }

    // TODO: Work on the method more to debug and refine it with the Auto Sample Website
    /**
     * Sets the specified radio button is a radio button group.
     *
     * @param locator The XPath locator for the radio button group.
     * @param desiredRadioButton The desired radio button to select.
     * @param timeout The number of seconds to wait before timing out.
     * 
     * @return A string containing the result of the operation.
     */
    public String selectRadioButtonInGroup(String locator, String desiredRadioButton, int timeout) {
        Instant startTime = Instant.now();
        boolean result = waitToExist(locator, timeout, FW_ConfigMgr.getDefaultInterval());

        // Processing result details
        Map<String, Object> resultProcessed = FW_TestStepUtils.inStepAnalysis(startTime, result, locator);
        String assessResultTime;
        String assessResultFailTime;
        String assessColor = (String) resultProcessed.get("assessColor");
        boolean highlightLocator = (boolean) resultProcessed.get("highlightLocator");

        if (highlightLocator == true) {locatorHighlight(locator, assessColor);} // Highlight the locator if configured

        // Locator exists, set the radio button state.
        if (result == true) {

            try {
                // Find all radio buttons within the group.
                List<WebElement> radioButtons = driver.findElements(By.xpath(locator + "/*[contains(@type,'radio')]"));
                StringBuilder availableRadioButtons = new StringBuilder();
                //boolean radioButtonFound = false;

                // Attempt to select the desired radio button.
                for (WebElement radioButton : radioButtons) {
                    availableRadioButtons.append(radioButton.getAttribute("value")).append(" (").append(radioButton.getText()).append("), ");
                    if (radioButton.getAttribute("value").equals(desiredRadioButton) || radioButton.getText().equals(desiredRadioButton)) {
                        if (!radioButton.isSelected()) {
                            radioButton.click();
                        }
    
                        // Processing result details
                        resultProcessed = FW_TestStepUtils.inStepAnalysis(startTime, result, locator);
                        assessResultTime = (String) resultProcessed.get("assessResultTime");
                        assessColor = (String) resultProcessed.get("assessColor");
                        highlightLocator = (boolean) resultProcessed.get("highlightLocator");

                        if (highlightLocator == true) {locatorHighlight(locator, assessColor);} // Highlight the locator if configured

                        return assessResultTime + " - Selected radio button: '" + desiredRadioButton + "' in group: '" + locator + "'."; // Return success.
                    }
                }
    
                // If the desired radio button was not found in the group.
                resultProcessed = FW_TestStepUtils.inStepAnalysis(startTime, result, locator);
                assessResultFailTime = (String) resultProcessed.get("assessResultFailTime");
                assessColor = (String) resultProcessed.get("assessColor");
                highlightLocator = (boolean) resultProcessed.get("highlightLocator");

                if (highlightLocator == true) {locatorHighlight(locator, assessColor);} // Highlight the locator if configured

                return assessResultFailTime + " - Desired radio button: '" + desiredRadioButton + "' not found in group: '" + locator + "'. Available buttons: " + availableRadioButtons; // Return failure.
    
            } catch (NoSuchElementException e) {

                // If the desired radio button was not found in the group.
                resultProcessed = FW_TestStepUtils.inStepAnalysis(startTime, result, locator);
                assessResultFailTime = (String) resultProcessed.get("assessResultFailTime");

                return assessResultFailTime + " - Radio group with locator: '" + locator + "' does not exist."; // Return failure.

            } catch (WebDriverException e) {

                // If the desired radio button was not found in the group.
                resultProcessed = FW_TestStepUtils.inStepAnalysis(startTime, result, locator);
                assessResultFailTime = (String) resultProcessed.get("assessResultFailTime");
                assessColor = (String) resultProcessed.get("assessColor");
                highlightLocator = (boolean) resultProcessed.get("highlightLocator");

                if (highlightLocator == true) {locatorHighlight(locator, assessColor);} // Highlight the locator if configured

                return assessResultFailTime + " - Failed to select radio button: '" + desiredRadioButton + "' in group: '" + locator + "'. Error: " + e.getMessage(); // Return failure.

            }
        } else {

            // If the desired radio button was not found in the group.
            resultProcessed = FW_TestStepUtils.inStepAnalysis(startTime, result, locator);
            assessResultFailTime = (String) resultProcessed.get("assessResultFailTime");

            return assessResultFailTime + " - Radio group with locator: '" + locator + "' does not exist within the given timeout."; // Return failure.
        }
    }

    /**
     * Scrolls to the locator.
     *
     * @param locator The XPath locator to check for.
     * 
     * @return A string containing the result of the operation.
     */
    public String scrollToLocator(String locator) {
        Instant startTime = Instant.now();
        boolean result = waitToExist(locator, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());

        // Processing result details
        Map<String, Object> resultProcessed = FW_TestStepUtils.inStepAnalysis(startTime, result, locator);
        String assessResultTime;
        String assessResultFailTime = (String) resultProcessed.get("assessResultFailTime");
        String assessColor = (String) resultProcessed.get("assessColor");
        boolean highlightLocator = (boolean) resultProcessed.get("highlightLocator");

        // Highlight the locator if configured to do so.
        if (highlightLocator == true) {locatorHighlight(locator, assessColor);}

        // Locator exists, set the radio button state.
        if (result == true) {

            // Scroll to the locator
            result = scrollTo(locator);

            // Processing result details
            resultProcessed = FW_TestStepUtils.inStepAnalysis(startTime, result, locator);
            assessResultTime = (String) resultProcessed.get("assessResultTime");
            assessResultFailTime = (String) resultProcessed.get("assessResultFailTime");
            assessColor = (String) resultProcessed.get("assessColor");
            highlightLocator = (boolean) resultProcessed.get("highlightLocator");

            if (highlightLocator == true) {locatorHighlight(locator, assessColor);} // Highlight the locator if configured

            // Generate success message
            if (result == true) {
                return assessResultTime + " - Scrolled to locator: '" + locator + "'."; // Return success.
            } else {
                return assessResultFailTime + " - Failed to scroll to locator: '" + locator + "'."; // Return failure.
            }
        } else {
            return assessResultFailTime + " - Could not scroll to locator: '" + locator + "' does not exist."; // Return failure.
        }
    }

    /**
     * Mouse over the element specified by the locator.
     *
     * @param locator The locator of the element.
     * @param timeout The number of seconds to wait before timing out.
     * 
     * @return A string containing the result of the operation.
     */
    public String mouseOverLocator(String locator, int timeout) {
        Instant startTime = Instant.now();
        boolean result = waitToExist(locator, timeout, FW_ConfigMgr.getDefaultInterval());

        // Processing result details
        Map<String, Object> resultProcessed = FW_TestStepUtils.inStepAnalysis(startTime, result, locator);
        String assessResultTime = (String) resultProcessed.get("assessResultTime");
        String assessResultFailTime = (String) resultProcessed.get("assessResultFailTime");
        String assessColor = (String) resultProcessed.get("assessColor");
        boolean highlightLocator = (boolean) resultProcessed.get("highlightLocator");

        if (highlightLocator == true) {locatorHighlight(locator, assessColor);} // Highlight the locator if configured

        // Locator exists, mouse over the element.
        if (result == true) {

            try {
                Actions actions = new Actions(driver);
                WebElement element = driver.findElement(By.xpath(locator));
                actions.moveToElement(element).perform();

                return assessResultTime + " - Successfully moused over locator: '" + locator + "'."; // Return success.
            } catch (Exception e) {
                return  assessResultFailTime + " - Could not mouse over locator '" + locator + "'."; // Return failure.
            }
        } else {
            return assessResultFailTime + " - Could not mouse over because locator '" + locator + "' does not exist."; // Return failure.
        }
    }

    /**
     * Drag and Drop the locatorStarting to locatorDestination.
     *
     * @param locatorStarting The XPath locator of the source element.
     * @param locatorDestination The XPath locator of the target element.
     * @param timeout The number of seconds to wait before timing out.
     *
     * @return A string containing the result of the operation.
     */
    public String dragAndDropLocators(String locatorStarting, String locatorDestination, int timeout) {
        Instant startTime = Instant.now();
        boolean resultStarting = waitToExist(locatorStarting, timeout, FW_ConfigMgr.getDefaultInterval());

        // Processing result details for starting locator
        Map<String, Object> resultProcessed = FW_TestStepUtils.inStepAnalysis(startTime, resultStarting, locatorStarting);
        String assessResultTime;
        String assessResultFailTime = (String) resultProcessed.get("assessResultFailTime");
        String assessColor = (String) resultProcessed.get("assessColor");
        boolean highlightLocator = (boolean) resultProcessed.get("highlightLocator");

        // The starting locator exists.
        if (resultStarting == true) {

            if (highlightLocator == true) {locatorHighlight(locatorStarting, assessColor);} // Highlight the locator if configured

            // Check if the destination locator exists.
            boolean resultDestination = waitToExist(locatorDestination, timeout, FW_ConfigMgr.getDefaultInterval());

            // Processing result details for destination locator
            resultProcessed = FW_TestStepUtils.inStepAnalysis(startTime, resultDestination, locatorDestination);
            assessResultTime = (String) resultProcessed.get("assessResultTime");
            assessResultFailTime = (String) resultProcessed.get("assessResultFailTime");
            assessColor = (String) resultProcessed.get("assessColor");
            highlightLocator = (boolean) resultProcessed.get("highlightLocator");

            // The destination locator exists.
            if (resultDestination == true) {

                if (highlightLocator == true) {locatorHighlight(locatorDestination, assessColor);} // Highlight the locator if configured

                try {
                    Actions actions = new Actions(driver);
                    WebElement elementStarting = driver.findElement(By.xpath(locatorStarting));
                    WebElement elementDestination = driver.findElement(By.xpath(locatorDestination));
                    actions.dragAndDrop(elementStarting, elementDestination).perform();

                    return assessResultTime + " - Drag and drop successful "; // Return success.

                // Failed to drag and drop.
                } catch (Exception e) {
                    return assessResultFailTime + " - Could not drag from starting locator '" + locatorStarting + "' to destination locator '" + locatorDestination + "'."; // Return failure.
                }

            // Destination locator does not exist.
            } else {
                return assessResultFailTime + " - Could not drag to destination locator '" + locatorDestination + "' does not exist."; // Return failure.
            }

        // Starting locator does not exist.
        } else {
            return assessResultFailTime + " - Could not drag for starting locator '" + locatorStarting + "' does not exist."; // Return failure.
        }
    }

    /**
     * Sets the value of a dropdown.
     *
     * @param locator The XPath locator of the dropdown.
     * @param dropdownValue The value to select from the dropdown
     * @param timeout The number of seconds to wait before timing out.
     * 
     * @return A string containing the result of the operation.
     */
    public String setDropdown(String locator, String dropdownValue, int timeout) {
        Instant startTime = Instant.now();
        boolean result = waitToExist(locator, timeout, FW_ConfigMgr.getDefaultInterval());

        // Processing result details
        Map<String, Object> resultProcessed = FW_TestStepUtils.inStepAnalysis(startTime, result, locator);
        String assessResultTime;
        String assessResultFailTime = (String) resultProcessed.get("assessResultFailTime");
        String assessColor = (String) resultProcessed.get("assessColor");
        boolean highlightLocator = (boolean) resultProcessed.get("highlightLocator");

        if (highlightLocator == true) {locatorHighlight(locator, assessColor);} // Highlight the locator if configured

        // Locator exists, set the dropdown value.
        if (result == true) {

            // Find the dropdown element.
            try {
                WebElement element = driver.findElement(By.xpath(locator));

                // Report if the element is not a dropdown.
                if (!element.getTagName().equalsIgnoreCase("select")) {
                    return assessResultFailTime + " - Element at locator '" + locator + "' is not a dropdown.";
                }

                // Select the dropdown value.
                Select dropdown = new Select(element);
                dropdown.selectByVisibleText(dropdownValue);

                // Processing result details
                resultProcessed = FW_TestStepUtils.inStepAnalysis(startTime, result, locator);
                assessResultTime = (String) resultProcessed.get("assessResultTime");
                assessColor = (String) resultProcessed.get("assessColor");
                highlightLocator = (boolean) resultProcessed.get("highlightLocator");

                if (highlightLocator == true) {locatorHighlight(locator, assessColor);} // Highlight the locator if configured

                return assessResultTime + " - Selected dropdown '" + dropdownValue + "' from locator '" + locator + "'."; // Return success.

            } catch (NoSuchElementException e) {

                // Processing result details
                resultProcessed = FW_TestStepUtils.inStepAnalysis(startTime, result, locator);
                assessResultFailTime = (String) resultProcessed.get("assessResultFailTime");
                assessColor = (String) resultProcessed.get("assessColor");
                highlightLocator = (boolean) resultProcessed.get("highlightLocator");

                if (highlightLocator == true) {locatorHighlight(locator, assessColor);} // Highlight the locator if configured

                return assessResultFailTime + " - Dropdown '" + dropdownValue + "' does not exist within locator '" + locator + "'."; // Return failure.

            } catch (Exception e) {

                // Processing result details
                resultProcessed = FW_TestStepUtils.inStepAnalysis(startTime, result, locator);
                assessResultFailTime = (String) resultProcessed.get("assessResultFailTime");
                assessColor = (String) resultProcessed.get("assessColor");
                highlightLocator = (boolean) resultProcessed.get("highlightLocator");

                if (highlightLocator == true) {locatorHighlight(locator, assessColor);} // Highlight the locator if configured

                return assessResultFailTime + " - An unexpected error occurred while selecting dropdown." + e.getMessage(); // Return failure.
            }

        // Locator does not exist, report failure.
        } else {
            return assessResultFailTime + "- Could not select dropdown because locator '" + locator + "' does not exist."; // Return failure.
        }
    }

    /**
     * Switches to the iframe specified by the locator.
     *
     * @param locator The locator of the iframe.
     * @param timeout The time to wait before switching to the iframe.
     * 
     * @return A string containing the result of the operation.
     */
    public String switchToIframe(String locator, int timeout) {
        Instant startTime = Instant.now();
        boolean result = waitToExist(locator, timeout, FW_ConfigMgr.getDefaultInterval());

        // Processing result details
        Map<String, Object> resultProcessed = FW_TestStepUtils.inStepAnalysis(startTime, result, locator);
        String assessResultTime;
        String assessResultFailTime = (String) resultProcessed.get("assessResultFailTime");
        String assessColor = (String) resultProcessed.get("assessColor");
        boolean highlightLocator = (boolean) resultProcessed.get("highlightLocator");

        // Locator exists, switch to the iframe.
        if (result == true) {

            if (highlightLocator == true) {locatorHighlight(locator, assessColor);} // Highlight the locator if configured

            // Switch to the iframe.
            try {
                // Switch to the iframe
                driver.switchTo().frame(locator);

                // Processing result details
                resultProcessed = FW_TestStepUtils.inStepAnalysis(startTime, result, locator);
                assessResultTime = (String) resultProcessed.get("assessResultTime");

                return assessResultTime + " - Successfully switched to the iframe '" + locator + "'."; // Return success.

            } catch (Exception e) {
                return assessResultFailTime + " - Could not switch to iframe '" + locator + "'. Has it been loaded and does it exist?"; // Return failure.
            }
        } else {
            return assessResultFailTime + " - Could not find the iframe '" + locator + "'."; // Return failure.
        }
    }

    /**
     * Attempts to switch the WebDriver's context from an iFrame back to the parent frame.
     *
     * @return A string containing the result of the operation.
     */
    public String switchToParentFrame() {
        Instant startTime = Instant.now();

        String locator = "parent frame"; // This is just a placeholder for the locator
        boolean result = true;

        // Processing result details
        Map<String, Object> resultProcessed;
        String assessResultTime;
        String assessResultFailTime;

        // Switch to the parent frame.
        try {

            // Switch to the parent frame
            driver.switchTo().defaultContent();

            // Processing result details
            resultProcessed = FW_TestStepUtils.inStepAnalysis(startTime, result, locator);
            assessResultTime = (String) resultProcessed.get("assessResultTime");

            return assessResultTime + " - Successfully switched out of iFrame back to the parent."; // Return success.

        } catch (WebDriverException e) {

            // Processing result details
            resultProcessed = FW_TestStepUtils.inStepAnalysis(startTime, result, locator);
            assessResultFailTime = (String) resultProcessed.get("assessResultFailTime");

            // Generate failure message
            return assessResultFailTime + " - Could not switch to the parent of the iFrame. Did an error occur within the iFrame?"; // Return failure.
        }
    }

    /**
     * Switches to the given window position, which is zero-based
     *
     * @param position The index of the window to switch to
     * @param timeout  The number of seconds to wait before timing out.
     * 
     * @return A string containing the result of the operation
     */
    public String switchToWindowByPosition(int position, int timeout) {
        Instant startTime = Instant.now();

        String locator = String.valueOf(position); // Lets use the position as the locator
        boolean result = true;

        // Processing result details
        Map<String, Object> resultProcessed;
        String assessResultTime;
        String assessResultFailTime;

        // Initialize variables
        ArrayList<String> windows = new ArrayList<>(driver.getWindowHandles()); // Get all the window handles
        int windowsCount = windows.size(); // Get the number of windows
        int interval = FW_ConfigMgr.getDefaultInterval();
        int maxAttempts = timeout / interval;

        // Loop until the window count is greater than the position or the timeout is reached
        for (int attempt = 0; attempt < maxAttempts; attempt++) {

            // Window count contains window at position
            if (windowsCount >= (position + 1)) { // Position is zero-based so add 1 as windosCount is 1-based
                try {
                    // Switch to the window at the position
                    driver.switchTo().window(windows.get(position));
                    String windowTitle = driver.getTitle();

                    // Which success message to generate?
                    if ("true".equals(FW_ConfigMgr.getUserSatisfactionAssessment().toLowerCase())) {

                        // Processing result details
                        resultProcessed = FW_TestStepUtils.inStepAnalysis(startTime, result, locator);
                        assessResultTime = (String) resultProcessed.get("assessResultTime");
                        
                        return assessResultTime + " - Switched to window at position " + position + " with window title '" + windowTitle; // Return success.
                    }
                    
                } catch (NoSuchWindowException e) {

                    // Processing result details
                    resultProcessed = FW_TestStepUtils.inStepAnalysis(startTime, result, locator);
                    assessResultFailTime = (String) resultProcessed.get("assessResultFailTime");

                    return assessResultFailTime + " - No such window at position " + position + "."; // Return failure.

                } catch (WebDriverException e) {

                    // Processing result details
                    resultProcessed = FW_TestStepUtils.inStepAnalysis(startTime, result, locator);
                    assessResultFailTime = (String) resultProcessed.get("assessResultFailTime");

                    return assessResultFailTime + " - WebDriver error occurred while switching to window at position " + position + "."; // Return failure.

                } catch (Exception e) {

                    // Processing result details
                    resultProcessed = FW_TestStepUtils.inStepAnalysis(startTime, result, locator);
                    assessResultFailTime = (String) resultProcessed.get("assessResultFailTime");

                    return assessResultFailTime + " - Unexpected error occurred while switching to window at position " + position + "."; // Return failure.
                }
            } else {
                // If the search string is not found wait for the interval and try again.
                FW_DateTimeUtils.waitForDuration(interval, "s", false); // Wait to perform next check
            }

            // If the window count is still less than the position, refresh the window count and try again.
            windows = new ArrayList<>(driver.getWindowHandles()); // Get all the window handles
            windowsCount = windows.size(); // Get the number of windows
        }

        // Processing result details
        resultProcessed = FW_TestStepUtils.inStepAnalysis(startTime, result, locator);
        assessResultFailTime = (String) resultProcessed.get("assessResultFailTime");

        // Generate failure message
        return assessResultFailTime + " - Could not switch to the new window. Is the new window open?"; // Return failure.
    }

    /**
     * Switches back to the originating, parent window
     *
     * @return A string containing the result of the operation
     */
    public String switchToParentWindow() {
        Instant startTime = Instant.now();
    
        String locator = "parent frame"; // Placeholder for the locator
    
        try {
            // Switch to the parent frame
            driver.switchTo().window(driver.getWindowHandles().iterator().next());
    
            // Process success result details
            Map<String, Object> resultProcessed = FW_TestStepUtils.inStepAnalysis(startTime, true, locator);
            String assessResultTime = (String) resultProcessed.get("assessResultTime");
    
            return assessResultTime + " - Successfully switched to the original window."; // Return success.
    
        } catch (Exception e) {
            // Process failure result details
            Map<String, Object> resultProcessed = FW_TestStepUtils.inStepAnalysis(startTime, false, locator);
            String assessResultFailTime = (String) resultProcessed.get("assessResultFailTime");
    
            return assessResultFailTime + " - Could not switch to the original window. Is it still open?"; // Return failure.
        }
    }

    /**
     * Changes the size of the current window.
     *
     * @param size represents sizes typical for mobile, tablet, and desktop.
     * 
     * @return A string containing the result of the operation.
     */
    public String resizeWindow(String size) {
        Instant startTime = Instant.now();

        String locator = size; // Use the size as the locator
        boolean result = true;

        // Processing result details
        Map<String, Object> resultProcessed = FW_TestStepUtils.inStepAnalysis(startTime, result, locator);
        String assessResultTime = (String) resultProcessed.get("assessResultTime");
        String assessResultFailTime = (String) resultProcessed.get("assessResultFailTime");

        try {
            // Use a switch expression to determine the window size
            Dimension dimension = switch (size.toLowerCase()) {
                case "mobile" -> new Dimension(540, 960);
                case "tablet" -> new Dimension(768, 1024);
                case "tablet_large" -> new Dimension(912, 1368);
                case "desktop" -> new Dimension(1440, 900);
                case "desktop_large" -> new Dimension(1920, 1080);
                default -> null; // Invalid size
            };

            // If the size is invalid, return a failure message
            if (dimension == null) {
                return assessResultFailTime + " - " + size + " isn't a valid window size. Please choose mobile, tablet, tablet_large, desktop, or desktop_large.";
            }

            // Resize the window
            driver.manage().window().setSize(dimension);

            return assessResultTime + " - The window has been resized to " + size + "."; // Return success

        } catch (Exception e) {
            return assessResultFailTime + " - The window wasn't resized to " + size + "."; // Return failure
        }
    }

    /**
     * Executes a script with a given locator.
     *
     * @param javascript The JavaScript to execute.
     * @param locator The locator to execute the JavaScript upon.
     * 
     * @return A string containing the result of the operation.
     */
    public String executeScript(String javascript, String locator) {
        Instant startTime = Instant.now();

        boolean result = true;

        // Processing result details
        Map<String, Object> resultProcessed = FW_TestStepUtils.inStepAnalysis(startTime, result, locator);
        String assessResultTime = (String) resultProcessed.get("assessResultTime");
        String assessResultFailTime = (String) resultProcessed.get("assessResultFailTime");

        // Execute the JavaScript
        try {
            // Execute the JavaScript
            executeJavascript(javascript, locator);

            return assessResultTime + " - Successfully executed JavaScript with " + locator; // Return success.

        } catch (Exception e) {
            return assessResultFailTime + " - Encountered error executing JavaScript with " + locator; // Return failure.
        }
    }

    /**
     * Validate is the actual value is empty.
     *
     * @param actual The actual string.
     * @param description Description to include with the returned result for context
     * 
     * @return A string containing the result of the operation.
     */
    public String validateEmpty(String actual, String description) {
        Instant startTime = Instant.now();

        String locator = description; // This is just a placeholder for the locator
        boolean result = true;

        // Processing result details
        Map<String, Object> resultProcessed = FW_TestStepUtils.inStepAnalysis(startTime, result, locator);
        String assessResultTime = (String) resultProcessed.get("assessResultTime");
        String assessResultFailTime = (String) resultProcessed.get("assessResultFailTime");

        // Check for null values.
        if (actual == null) {
            return assessResultTime + " - " + description + " - Actual value is null."; // Return success.
        }

        // Get length now that we know we don't have a null value.
        int actualLength = actual.length();

        // Check if actual length is greater than 0.
        if (actualLength != 0) {
            return assessResultFailTime + " - " +  description + " - Actual '" + actual + "' (" + actualLength + ") value is not empty."; // Return failure.
        }
        // Default return is pass as value is empty.
        return assessResultTime + " - " +  description + " - Actual '" + actual + "' (" + actualLength + ") value is empty."; // Return success.
    }

    /**
     * Compare two strings and return a string indicating the result of the operation.
     *
     * @param expected The expected string.
     * @param actual The actual string.
     * @param description Description to include with the returned result for context
     * 
     * @return A string containing the result of the operation.
     */
    public String validateExactMatch(String expected, String actual, String description) {
        Instant startTime = Instant.now();

        String locator = description; // This is just a placeholder for the locator
        boolean result = true;

        // Processing result details
        Map<String, Object> resultProcessed = FW_TestStepUtils.inStepAnalysis(startTime, result, locator);
        String assessResultTime = (String) resultProcessed.get("assessResultTime");
        String assessResultFailTime = (String) resultProcessed.get("assessResultFailTime");

        // Check if expected and actual are equal.
        if (Objects.equals(expected, actual)) {
            if (expected == null) {
                return assessResultTime + " - " +  description + " - Expected and actual values are null and identical."; // Return success.
            } else {
                return assessResultTime + " - " +  description + " - Expected '" + expected + "' (" + expected.length() + ") and actual '" + actual + "' (" + actual.length() + ") values are identical."; // Return success.
            }
        }
    
        // If they are not equal, check if either is null.
        if (expected == null) {
            return assessResultFailTime + " - " +  description + " - Expected is null and actual is not null."; // Return failure.
        }
    
        if (actual == null) {
            return assessResultFailTime + " - " +  description + " - Expected is not null and actual is null."; // Return failure.
        }
    
        // If neither is null and they are not equal, they must be of different lengths.
        return assessResultFailTime + " - " +  description + " - Expected '" + expected + "' (" + expected.length() + ") and actual '" + actual + "' (" + actual.length() + ") values are different."; // Return failure.
    }

    /**
     * Validates if the expected string is within the actual string.
     *
     * @param search The string to search for.
     * @param full The string to search within.
     * @param description Description to include with the returned result for context
     * 
     * @return A string containing the result of the operation.
     */
    public String validateWithinMatch(String search, String full, String description) {
        Instant startTime = Instant.now();

        String locator = description; // This is just a placeholder for the locator
        boolean result = true;

        // Processing result details
        Map<String, Object> resultProcessed = FW_TestStepUtils.inStepAnalysis(startTime, result, locator);
        String assessResultTime = (String) resultProcessed.get("assessResultTime");
        String assessResultFailTime = (String) resultProcessed.get("assessResultFailTime");

        // Check if the search value is within the full value.
        if (full.contains(search)) {

            // Get index of expected within actual.
            int indexStart = full.indexOf(search);
            int indexEnd = indexStart + search.length() - 1;

            return assessResultTime + " - " +  description + " - Search value '" + search + "' is within full value '" + full + "' at position " + indexStart + " to " + indexEnd + "."; // Return success.
        } else {
            return assessResultFailTime + " - " +  description + " - Search value '" + search + "' is not within full value '" + full + "'."; // Return failure.
        }
    }

    /**
     * Validates if the expected integer matches the actual integer.
     *
     * @param expected The expected integer.
     * @param actual The actual integer.
     * @param description The description of the validation.
     * 
     * @return A string containing the result of the validation.
     */
    public String validateIntegerMatch(int expected, int actual, String description) {
        Instant startTime = Instant.now();

        String locator = description; // This is just a placeholder for the locator
        boolean result = true;

        // Processing result details
        Map<String, Object> resultProcessed = FW_TestStepUtils.inStepAnalysis(startTime, result, locator);
        String assessResultTime = (String) resultProcessed.get("assessResultTime");
        String assessResultFailTime = (String) resultProcessed.get("assessResultFailTime");

        // Check if expected and actual integers are equal.
        if (expected == actual) {
            return assessResultTime + " - " + description + " - Expected integer value '" + expected + "' matches actual integer value '" + actual + "'"; // Return success.
        } else {
            return assessResultFailTime + " - " + description + " - Expected integer value '" + expected + "' does not match actual integer value '" + actual + "'"; // Return failure.
        }
    }

    /**
     * Validates if the expected float matches the actual float.
     *
     * @param expected The expected float.
     * @param actual The actual float.
     * @param description The description of the validation.
     * 
     * @return A string containing the result of the validation.
     */
    public String validateFloatMatch(float expected, float actual, String description) {
        Instant startTime = Instant.now();

        String locator = description; // This is just a placeholder for the locator
        boolean result = true;

        // Processing result details
        Map<String, Object> resultProcessed = FW_TestStepUtils.inStepAnalysis(startTime, result, locator);
        String assessResultTime = (String) resultProcessed.get("assessResultTime");
        String assessResultFailTime = (String) resultProcessed.get("assessResultFailTime");

        // Check if expected and actual floats are equal.
        if (expected == actual) {
            return assessResultTime + " - " + description + " - Expected float value '" + expected + "' matches actual float value '" + actual + "'"; // Return success.
        } else {
            return assessResultFailTime + " - " + description + " - Expected float value '" + expected + "' does not match actual float value '" + actual + "'"; // Return failure.
        }
    }

    /**
     * Validates if an alert exists on the page.
     *
     * @param timeout  The number of seconds to wait for alert to appear.
     * @param interval The number of seconds to wait between checks.
     * 
     * @return A string containing the result of the operation.
     */
    public String validateAlertExists(int timeout, int interval) {
        Instant startTime = Instant.now();
        String locator = ""; // This is just a placeholder for the locator
        boolean result = waitForAlertToExist(timeout, interval);

        // Processing result details
        Map<String, Object> resultProcessed = FW_TestStepUtils.inStepAnalysis(startTime, result, locator);
        String assessResultTime = (String) resultProcessed.get("assessResultTime");
        String assessResultFailTime = (String) resultProcessed.get("assessResultFailTime");

        // Processing result details
        if (result == true) {
            return assessResultTime + " - Alert was present."; // Return success.
        } else {
            return assessResultFailTime + " - Alert was never present"; // Return failure.
        }
    }

    /**
     * Validates if an alert does not exist on the page.
     *
     * @param timeout  The number of seconds to wait for alert to disappear.
     * @param interval The number of seconds to wait between checks.
     * 
     * @return A string containing the result of the operation.
     */
    public String validateAlertDoesntExist(int timeout, int interval) {
        Instant startTime = Instant.now();
        String locator = ""; // This is just a placeholder for the locator
        boolean result = waitForAlertToNotExist(timeout, interval);

        // Processing result details
        Map<String, Object> resultProcessed = FW_TestStepUtils.inStepAnalysis(startTime, result, locator);
        String assessResultTime = (String) resultProcessed.get("assessResultTime");
        String assessResultFailTime = (String) resultProcessed.get("assessResultFailTime");

        //Return the result of the operation
        if (result == true) {
            return assessResultTime + " - An alert was not present."; // Return success.
        } else {
            return assessResultFailTime + " - An alert was present even after timeout."; // Return failure.
        }
    }

    /**
     * Checks for the alert to exist, and then tries to accept it.
     *
     * @return A string containing the result of the validation.
     */
    public String acceptAlert() {
        Instant startTime = Instant.now();
        String locator = ""; // This is just a placeholder for the locator
        boolean result = true;

        // Processing result details
        Map<String, Object> resultProcessed = FW_TestStepUtils.inStepAnalysis(startTime, result, locator);
        String assessResultTime = (String) resultProcessed.get("assessResultTime");
        String assessResultFailTime;

        // Check for the alert to exist, and then try to accept it.
        if (!alertExist()) {

            result = false; // Set result to false

            // Processing result details
            resultProcessed = FW_TestStepUtils.inStepAnalysis(startTime, result, locator);
            assessResultFailTime = (String) resultProcessed.get("assessResultFailTime");

            return assessResultFailTime + " - No alert is present to accept."; // Return failure.
        }

        if (!alertAccept()) {

            result = false; // Set result to false

            // Processing result details
            resultProcessed = FW_TestStepUtils.inStepAnalysis(startTime, result, locator);
            assessResultFailTime = (String) resultProcessed.get("assessResultFailTime");

            return assessResultFailTime + " - Could not accept the alert. Is it able to be accepted?"; // Return failure.
        }
        return assessResultTime + " - Accepted the alert."; // Return success.
    }

    /**
     * Checks for the alert to exist, and then tries to dismiss it.
     *
     * @return A string containing the result of the validation.
     */
    public String dismissAlert() {
        Instant startTime = Instant.now();
        String locator = ""; // This is just a placeholder for the locator
        boolean result = true;

        // Processing result details
        Map<String, Object> resultProcessed = FW_TestStepUtils.inStepAnalysis(startTime, result, locator);
        String assessResultTime = (String) resultProcessed.get("assessResultTime");
        String assessResultFailTime;

        // Check for the alert does not exist.
        if (!alertExist()) {

            result = false; // Set result to false

            // Processing result details
            resultProcessed = FW_TestStepUtils.inStepAnalysis(startTime, result, locator);
            assessResultFailTime = (String) resultProcessed.get("assessResultFailTime");

            return assessResultFailTime + " - No alert is present to dismiss."; // Return failure.
        }

        if (!alertDismiss()) {

            result = false; // Set result to false

            // Processing result details
            resultProcessed = FW_TestStepUtils.inStepAnalysis(startTime, result, locator);
            assessResultFailTime = (String) resultProcessed.get("assessResultFailTime");

            return assessResultFailTime + " - Could not dismiss the alert. Is it able to be dismissed?"; // Return failure.
        }
        return assessResultTime + " - Dismissed the alert."; // Return success.
    }

    /**
     * Sets the text of an alert if it exists and is interactable.
     *
     * @param value The text to be set in the alert text field.
     * 
     * @return A string containing the result of the validation.
     */
    public String setAlertText(String value) {
        Instant startTime = Instant.now();
        String locator = ""; // This is just a placeholder for the locator
        boolean result;

        // Processing result details
        Map<String, Object> resultProcessed;
        String assessResultTime;
        String assessResultFailTime;

        // Check for the alert to exist and be interactable.
        if (!alertExist() || !alertInteractable()) {

            result = false; // Set result to false

            // Processing result details
            resultProcessed = FW_TestStepUtils.inStepAnalysis(startTime, result, locator);
            assessResultFailTime = (String) resultProcessed.get("assessResultFailTime");

            return assessResultFailTime + " - No alert is present to dismiss."; // Return failure.
        }

        // Set the text of the alert.
        try {
            driver.switchTo().alert().sendKeys(value);

            result = true;

            // Processing result details
            resultProcessed = FW_TestStepUtils.inStepAnalysis(startTime, result, locator);
            assessResultTime = (String) resultProcessed.get("assessResultTime");

            return assessResultTime + "  Sent '" + value + "' to alert."; // Return success.
        } catch (Exception e) {

            result = false;

            // Processing result details
            resultProcessed = FW_TestStepUtils.inStepAnalysis(startTime, result, locator);
            assessResultFailTime = (String) resultProcessed.get("assessResultFailTime");

            return assessResultFailTime + " - Could not send '" + value + "' to the alert. Is it interactable?"; // Return failure.
        }

    }

    /**
     * Upload a file once the file path and locator have been verified
     * 
     * @param locator The XPath locator related to the upload element
     * @param file The file path and filename to upload.
     * @param timeout The number of seconds to wait before timing out.
     * 
     * @return A string containing the result of the validation.
     */
    public String fileUpload(String locator, String file, int timeout) {
        Instant startTime = Instant.now();
        boolean result;

        // Processing result details
        Map<String, Object> resultProcessed;
        String assessResultTime;
        String assessResultFailTime;

        // Check if the file exists
        if (!Files.exists(Paths.get(file))) {

            result = false; // Set result to false

            // Processing result details
            resultProcessed = FW_TestStepUtils.inStepAnalysis(startTime, result, locator);
            assessResultFailTime = (String) resultProcessed.get("assessResultFailTime");

            return assessResultFailTime + " - Expected the file path '" + file + "'' to be a valid file path.";
        }

        result = waitToExist(locator, timeout, 1);
        if (result == false) {

            // Processing result details
            resultProcessed = FW_TestStepUtils.inStepAnalysis(startTime, result, locator);
            assessResultFailTime = (String) resultProcessed.get("assessResultFailTime");

            return assessResultFailTime + " - Expected to upload a file into '" + locator + "'' but it could not be found. Has the locator been changed or removed?"; // Return failure.
        }

        // Upload the file
        try {
            driver.findElement(By.xpath(locator)).sendKeys(file);

            // File Upload is successful
            result = true;

            // Processing result details
            resultProcessed = FW_TestStepUtils.inStepAnalysis(startTime, result, locator);
            assessResultTime = (String) resultProcessed.get("assessResultTime");

            return assessResultTime + " - Successfully uploaded the file '" + file + "'' into " + locator + "."; // Return success.

        } catch (Exception e) {

            // File Upload failed
            result = false;

            // Processing result details
            resultProcessed = FW_TestStepUtils.inStepAnalysis(startTime, result, locator);
            assessResultFailTime = (String) resultProcessed.get("assessResultFailTime");

            return assessResultFailTime + " - Expected to upload the file '" + file + "'' into " + locator + " but encountered an error. Is the file upload active and able to receive input from the user?"; // Return failure.
        }
    }

    /** 
     * Refreshes the current page and returns a string indicating the result of the operation.
     * 
     * @return A string containing the result of the operation.
     * 
     * 
     */

     public String refreshPage() {

    Instant startTime = Instant.now();

    boolean result = true;

    try {

        driver.navigate().refresh();

        return "[Pass] - Page refreshed successfully.";

    } catch (Exception e) {

        result = false;

        return "[Fail] - Unable to refresh the page.";

    }

}

    /**
     * Validates that the locator exists on the page and returns a string indicating the result of the operation.
     *
     * @param locator  The XPath locator to check for.
     * @param timeout  The number of seconds to wait before timing out.
     * @param interval The number of seconds to wait between checks.
     * 
     * @return A string containing the result of the operation.
     */
    public String validateLocatorExistsAOB(String locator, int timeout, int interval) {
        Instant startTime = Instant.now();
        boolean result = waitToExist(locator, timeout, interval);
        Map<String, String> userSatisfactionAssessment = FW_PerformanceUtils.calcSatisfactionAssessment(startTime, Instant.now());

        if (result == true) {

            if ("true".equals(FW_ConfigMgr.getLocatorHighlight().toLowerCase())) {
                if ("true".equals(FW_ConfigMgr.getUserSatisfactionAssessment().toLowerCase())) {
                    locatorHighlight(locator, (userSatisfactionAssessment.get("assessColor")));
                    return userSatisfactionAssessment.get("assessResult") + " - Validated locator: '" + locator + "' exists.";
                } else {
                    locatorHighlight(locator, FW_ConfigMgr.getLocatorHighlightCSS());
                    return "[Pass] - Validated locator: '" + locator + "' exists.";
                } 
            } else {
                return "[Pass] - Validated locator: '" + locator + "' exists.";
            }

        } else {

            if ("true".equals(FW_ConfigMgr.getLocatorHighlight().toLowerCase())) {
                locatorHighlight(locator, FW_ConfigMgr.getLocatorHighlightFailCSS());
                return "[Fail] - Validated locator: '" + locator + "' exists and it should not.";
            } else {
                return "[Fail] - Validated locator: '" + locator + "' exists and it should not.";
            }
        }
    }
}