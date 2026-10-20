package customizations.automation;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import framework.utilities.FW_ConfigMgr;
import framework.utilities.FW_PerformanceUtils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

/**
 * This class extends FW_Page and provides specilized methods for the Appian
 * platform.
 */
public class CU_Appian extends framework.automation.FW_Page {
    WebDriver driver;

    /**
     * Constructs a new CU_Appian with the specified WebDriver.
     *
     * @param driver the WebDriver to be used
     */
    public CU_Appian(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    /**
     * Set the appian dropdown state to open or closed.
     * 
     * @param locator  The XPath locator of the dropdown.
     * @param state    The state to set the dropdown to. Valid values are "open" or
     *                 "closed".
     * @param timeout  The maximum time to wait for the locator to exist.
     * @param interval The interval at which to check if the locator exists.
     * 
     * @return true if the dropdown state was set successfully, false otherwise.
     */
    public String setDropdownStateAppian(String locator, String state, int timeout, int interval) {
        Instant startTime = Instant.now();
        boolean result = waitToExist(locator, timeout, interval);
        Map<String, String> userSatisfactionAssessment = FW_PerformanceUtils.calcSatisfactionAssessment(startTime,
                Instant.now());

        // The locator exists
        if (result == true) {

            try {
                WebElement dropdown = getLocatorElement(locator);

                // Check if the dropdown is already in the desired state
                if (state.equalsIgnoreCase("open") && dropdown.getAttribute("aria-expanded").equalsIgnoreCase("true")) {
                    return "[Pass] - Dropdown is already in the 'open' state.";
                } else if (state.equalsIgnoreCase("closed")
                        && dropdown.getAttribute("aria-expanded").equalsIgnoreCase("false")) {
                    return "[Pass] - Dropdown is already in the 'closed' state.";
                }

                // Initialize variables
                boolean stateChanged = false;
                int maxAttempts = timeout / interval;

                for (int attempt = 0; attempt < maxAttempts; attempt++) {
                    locatorHighlightHelper(locator, startTime, ""); // Highlight the locator

                    // Click because the dropdown is not in the desired state
                    dropdown.click();

                    // Get the current state of the dropdown
                    String currentState = dropdown.getAttribute("aria-expanded");

                    // Check if the state of the dropdown has changed
                    if (state.equalsIgnoreCase("open") && currentState.equalsIgnoreCase("true")) {
                        stateChanged = true;
                        break; // Break out of the loop
                    } else if (state.equalsIgnoreCase("closed") && currentState.equalsIgnoreCase("false")) {
                        stateChanged = true;
                        break; // Break out of the loop
                    } else {

                        // If the state has not changed wait for the interval and try again.
                        waitForDuration(interval, "s", false); // Wait to perform next check
                    }

                }

                // Return the result of the operation when the state has changed
                if (stateChanged == true) {
                    if ("true".equals(FW_ConfigMgr.getLocatorHighlight().toLowerCase())) {
                        if ("true".equals(FW_ConfigMgr.getUserSatisfactionAssessment().toLowerCase())) {
                            locatorHighlight(locator, (userSatisfactionAssessment.get("assessColor")));
                            return userSatisfactionAssessment.get("assessResult") + " - Dropdown state set to '" + state
                                    + "' successfully.";
                        } else {
                            locatorHighlight(locator, FW_ConfigMgr.getLocatorHighlightCSS());
                            return "[Pass] - Dropdown state set to '" + state + "' successfully.";
                        }
                    } else {
                        return "[Pass] - Dropdown state set to '" + state + "' successfully.";
                    }
                    // Return an error message if the state of the dropdown did not change
                } else {
                    if ("true".equals(FW_ConfigMgr.getLocatorHighlight().toLowerCase())) {
                        locatorHighlightHelper(locator, startTime, "Fail"); // Highlight the locator
                    }
                    return "[Fail] - Failed to set dropdown state to '" + state + "' within the timeout of '" + timeout
                            + "' seconds."; // Generate fail message
                }
            } catch (NoSuchElementException e) {
                if ("true".equals(FW_ConfigMgr.getLocatorHighlight().toLowerCase())) {
                    locatorHighlight(locator, FW_ConfigMgr.getLocatorHighlightFailCSS());
                }
                return "[Fail] - Locator: '" + locator + "' does not exist.";
            }

            // Locator - does not exists
        } else {
            // Return a failure message as the locator does not exist.
            locatorHighlightHelper(locator, startTime, "Fail"); // Highlight the locator
            return "[Fail] - Locator: '" + locator + "' does not exist."; // Generate fail message
        }

    }

    /**
     * Get the number of dropdown options in an Appian dropdown.
     *
     * @param locator The XPath locator of the dropdown.
     * 
     * @return A interger containing the number of dropdown options.
     */
    public List<String> getDropdownOptionsAppian(String locator) {

        // The collection containing the dropdown option names
        List<String> optionNames = new ArrayList<>();

        try {
            WebElement dropdown = getLocatorElement(locator);

            // Open the dropdown
            setDropdownStateAppian(locator, "open", FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());

            // Get the ID of the options container from the aria-controls attribute
            String optionsContainerId = dropdown.getAttribute("aria-controls");

            // Locate the options container
            WebElement optionsContainer = driver.findElement(By.id(optionsContainerId));

            // Locate the list of options within the container
            List<WebElement> options = optionsContainer.findElements(By.xpath(".//li"));

            // Extract the text from each option and add it to the list
            for (WebElement option : options) {
                optionNames.add(option.getText());
            }

        } catch (NoSuchElementException e) {
            // Return an empty list if the dropdown is not found
            return new ArrayList<>();
        }

        // Return the list of option names
        return optionNames;
    }

    /**
     * Sets the value of a dropdown (Appian implementation)
     *
     * @param locator       The XPath locator of the dropdown.
     * @param dropdownValue The value to select from the dropdown
     * @param timeout       The number of seconds to wait before timing out.
     * 
     * @return A string containing the result of the operation.
     */
    public String setDropdownAppian(String locator, String dropdownValue, int timeout) {

        Instant startTime = Instant.now();
        boolean result = waitToExist(locator, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        Map<String, String> userSatisfactionAssessment = FW_PerformanceUtils.calcSatisfactionAssessment(startTime, Instant.now());

        if (result == true) {

            // Highlight the locator if configured to do so.
            if ("true".equals(FW_ConfigMgr.getLocatorHighlight().toLowerCase())) {
                if ("true".equals(FW_ConfigMgr.getUserSatisfactionAssessment().toLowerCase())) {
                    locatorHighlight(locator, (userSatisfactionAssessment.get("assessColor")));
                } else {
                    locatorHighlight(locator, FW_ConfigMgr.getLocatorHighlightCSS());
                }
            }

            // Get the dropdown item options
            List<String> optionNames = getDropdownOptionsAppian(locator);

            // Get the number of dropdown options
            int optionCount = optionNames.size();

            // Check if the dropdown has options
            if (optionCount == 0) {
                return "[Fail] - Dropdown '" + locator + "' does not contain any options.";
            }

            try {
                WebElement element = getLocatorElement(locator);

                // Check if the element is a combobox
                if (!element.getAriaRole().equalsIgnoreCase("combobox")) {
                    return "[Fail] - Element at locator '" + locator + "' is not a dropdown.";
                }

                // Open the dropdown
                setDropdownStateAppian(locator, "open", FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());

                // Loop up to 10 times to set the dropdown value
                for (int i = 0; i <= optionCount * 20; i++) {

                    // Get value of dropdown
                    String currentValue = element.getText();

                    // Check if the dropdown is already set to the desired value
                    if (currentValue.equals(dropdownValue)) {

                        // Close the dropdown
                        typeOnKeyboard("ENTER");
                        return "[Pass] - Selected dropdown '" + dropdownValue + "' from locator '" + locator + " containing '" + optionCount + "' options.";
                    } else {
                        // Set the dropdown value to the desired value
                        typeOnKeyboard("ARROW_DOWN");
                        waitForDuration(50, "ms", false); // This was necessary for Appians dropdown latenancy
                    }
                }

                // If the dropdown value was not set reviewing all items
                return "[Fail] - Could not select dropdown '" + dropdownValue + "' from locator '" + locator + "' after trying all '" + optionCount + "' options.";

            } catch (NoSuchElementException e) {
                return "[Fail] - Dropdown '" + dropdownValue + "' does not exist within locator '" + locator + "'.";
            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
                return "[Fail] - An unexpected error occurred while selecting dropdown.";
            }

        } else {
            return "[Fail] - Could not select dropdown because locator '" + locator + "' does not exist.";
        }

    }

}