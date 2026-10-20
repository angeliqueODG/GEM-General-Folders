package customizations.automation;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import framework.utilities.FW_ConfigMgr;
import framework.utilities.FW_PerformanceUtils;

/**
 * This class extends FW_Page and provides specilized methods for the Appian
 * platform.
 */
public class CU_Appian extends framework.automation.FW_Page {
    protected WebDriver driver;

    /**
     * Constructs a new CU_Appian with the specified WebDriver.
     *
     * @param driver the WebDriver to be used
     */
    public CU_Appian(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
    List<String> VisitorToCanada = List.of("Itemized receipts for all bills and invoices", "Proof of payment for Self-Paid Expenses", "Medical Records including complete diagnosis by attending physician","Proof of Travel", "Police Accident Report - MVA including report number (if applicable)", "Proof of Arrival to Canada", "Other supporting documents");
    List<String> Student = List.of("Itemized receipts for bills and invoices", "Provincial Form", "Proof of payment for Self-Paid Expenses", "Proof of Travel  (outside of province)","Other supporting documents");
    List<String> Expatriate = List.of("Itemized receipts for bills and invoices", "Proof of payment for Self-Paid Expenses", "Medical Records including complete diagnosis by attending physician", "Proof of Travel","Police Accident Report - MVA including report number (if applicable)", "Other supporting documents");
    List<String> EmergencyMedicalTravel = List.of("Itemized receipts for all bills and invoices", "Provincial Form ","Proof of payment for Self-Paid Expenses", "Medical Records including complete diagnosis by attending physician","Proof of Travel", "Police Accident Report - MVA including report number (if applicable)", "Other supporting documents");

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

    public String checkElementsInDropdown() {
    // Locate and click on the dropdown toggle (if necessary)
    WebElement dropdownToggle = driver.findElement(By.xpath("//div[@role='combobox']"));
    dropdownToggle.click();
    
    // Wait for the dropdown items to be visible
    //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='dropdown']//div//span")));

    // List of expected items
    List<String> expectedItems = List.of("Amex", "Mastercard", "Visa", "Other");

    // Create a set to store the actual dropdown items' text (to avoid duplicates)
    Set<String> allDropdownItems = new HashSet<>();

    // Scroll through the dropdown until we find all the expected items or no more items load
    boolean allItemsFound = false;
    int attempts = 0;

    while (!allItemsFound && attempts < 5) {  // Limit scrolling attempts
        // Locate all visible dropdown options (all <span> elements inside <div> under #dropdown)
        List<WebElement> dropdownOptions = driver.findElements(By.xpath("//div[@role='combobox']//span"));

        // Add the current items to the set
        for (WebElement option : dropdownOptions) {
            String itemText = option.getText().trim();  // Trim any leading/trailing whitespace
            allDropdownItems.add(itemText);
        }

        // Check if we found all expected items
        if (allDropdownItems.containsAll(expectedItems)) {
            allItemsFound = true;
        } else {
            // Scroll down to the next set of items
            WebElement lastItem = dropdownOptions.get(dropdownOptions.size() - 1);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", lastItem);
            // Wait for the next set of items to load (optional but can be helpful)
            try {
                Thread.sleep(1000);  // Sleep for a second to allow items to load
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            attempts++;
        }
    }

    // Check if all expected items were found
    List<String> missingItems = new ArrayList<>();
    for (String expectedItem : expectedItems) {
        if (!allDropdownItems.contains(expectedItem)) {
            missingItems.add(expectedItem);
        }
    }

    // Return the result message based on missing items
    if (missingItems.isEmpty()) {
        return "[PASS]: All items are present in the dropdown. Items: " + allDropdownItems;
    } else {
        return "[FAIL]: The following items are missing from the dropdown: " + missingItems;
    }
}

public String getAllDropdownOptionsAsString(String locator, int timeout, int expectedCount) {

    // Get the dropdown item options
    List<String> optionNames = getDropdownOptionsAppian(locator);

    // Get the number of dropdown options
    int optionCount = optionNames.size();
    System.out.println(optionCount);
    System.out.println(optionNames);
    if (expectedCount==(optionCount - 1)) {
        return "[Pass] - Dropdown '" + locator + "' contains the expected number of options: " + expectedCount + ". Found including default: " + optionCount;
    } else {
        return "[Fail] - Dropdown '" + locator + "' does not contain the expected number of options. Expected: " + expectedCount + ", Found: " + optionCount;
    }
    // Set the dropdown value to the desired value
    //typeOnKeyboard("ARROW_DOWN");
    //waitForDuration(50, "ms", false); // This was necessary for Appians dropdown latenancy
    // String stringNumber = String.valueOf(optionCount); // or Integer.toString(number)
    // return stringNumber;
}

public String countDropdownAppian(String locator, String dropdownString, int expectedValue, int timeout) {

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
        int optionCount2 = optionNames.size();
        int count = 0;
        int temp;
        // Check if the dropdown has options
        if (optionCount2 == 0) {
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
            ArrayList<String> arr = new ArrayList<>();
            String currentValue="";
            // Loop up to 10 times to set the dropdown value
            for (int i = 0; i <= optionCount2 * 20; i++) {
                // Get value of dropdown
                currentValue = element.getText();
                
                // Check if the dropdown is already set to the desired value
                if (currentValue.equals(dropdownString) && count>0) {
                    temp = count-1;
                    //count = -1;
                    System.out.println("Total items in the dropdown is: " + temp + " Minus 1 for the default item placeholder : " + dropdownString);
                    System.out.println("Expected number of items in the dropdown is: " + expectedValue);
                    //Close the dropdown
                   typeOnKeyboard("ENTER");
                   System.out.println(arr);
                   // Check if the expected value is equal to the actual value
                   if (temp!=expectedValue) {
                    
                    //return "[Fail] - The number count from the dropdown is " + temp + " Expected count is " + expectedValue;
                    return "[Fail] - The number count from the dropdown is " + temp + " Expected count is: " + expectedValue;
                    
                }
                    return "[Pass] - End of dropdown" + dropdownString + " from locator " + locator + " containing " + temp + " options.";
                } else {
                    if(count!=0 && count!=-1){
                        arr.add(currentValue);
                    }
                    // Set the dropdown value to the desired value
                    typeOnKeyboard("ARROW_DOWN");
                    waitForDuration(50, "ms", false); // This was necessary for Appians dropdown latenancy
                    count++;
                }
            }

            // If the dropdown value was not set reviewing all items
            return "[Fail] - You passed the wrong default placeholder value " + dropdownString + "' from locator '" + locator + "Expected value is: " + currentValue;

        } catch (NoSuchElementException e) {
            return "[Fail] - Dropdown '" + dropdownString + "' does not exist within locator '" + locator + "'.";
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            return "[Fail] - An unexpected error occurred while selecting dropdown.";
        }

    } else {
        return "[Fail] - Could not select dropdown because locator '" + locator + "' does not exist.";
    }

}


public String countDropdownAppian2(String locator, String dropdownString, int expectedValue, int timeout, List<String> preDefinedArray) {

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
        int optionCount2 = optionNames.size();
        int count = 0;
        int temp;
        int j;
        int w;
        ArrayList<String> arrIconsistency = new ArrayList<>();
        ArrayList<String> arrIconsistency2 = new ArrayList<>();
        // Check if the dropdown has options
        if (optionCount2 == 0) {
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
            ArrayList<String> arr = new ArrayList<>();
            String currentValue="";
            // Loop up to 10 times to set the dropdown value
            for (int i = 0; i <= optionCount2 * 20; i++) {
                // Get value of dropdown
                currentValue = element.getText();
                
                // Check if the dropdown is already set to the desired value
                if (currentValue.equals(dropdownString) && count>0) {
                    temp = count-1;
                    //count = -1;
                    System.out.println("Total items in the dropdown is: " + temp + " Minus 1 for the default item placeholder : " + dropdownString);
                    System.out.println("Expected number of items in the dropdown is: " + expectedValue);
                    //Close the dropdown
                    for (j=0, w=0; j<arr.size();) {
                        String current1= arr.get(j);
                        String current2= preDefinedArray.get(w);
                        if(!preDefinedArray.contains(current1)){
                            arrIconsistency.add(current1);
                        }
                        if(!arr.contains(current2)){
                            arrIconsistency2.add(current2);
                        }
                        j++;
                        w++;
                    }
                    
                    if(arrIconsistency.size()!=0) {
                       return "[Fail] - Expected and Actual items from the dropdown do not match: "+ "\n\n"+"Expected Items that are not in the dropdown are: "+"\n \n"+arrIconsistency2+"\n \n"+
                       "\n\n Unexpected items in the dropdown are : " + "\n\n"+arrIconsistency+"\n\n However the expected and actual number of items from the dropdwon is correct: "+ preDefinedArray.size();

                    }
                    else if (arrIconsistency.size()==0 && arrIconsistency2.size()==0) {
                        return "[Pass] - Expected and Actual items in the dropdown match.";
                    }
                //    typeOnKeyboard("ENTER");
                //    System.out.println(arr);
                   // Check if the expected value is equal to the actual value
                   else if (temp!=expectedValue) {
                    
                    //return "[Fail] - The number count from the dropdown is " + temp + " Expected count is " + expectedValue;
                    return "[Fail] - The number count from the dropdown is " + temp + " Expected count is: " + expectedValue;
                    
                    }
                    return "[Pass] - End of dropdown" + dropdownString + " from locator " + locator + " containing " + temp + " options.";
                } else {
                    if(count!=0 && count!=-1){
                        arr.add(currentValue);
                    }
                    // Set the dropdown value to the desired value
                    typeOnKeyboard("ARROW_DOWN");
                    waitForDuration(50, "ms", false); // This was necessary for Appians dropdown latenancy
                    count++;
                }
            }

            // If the dropdown value was not set reviewing all items
            return "[Fail] - You passed the wrong default placeholder value " + dropdownString + "' from locator '" + locator + "Expected value is: " + currentValue;

        } catch (NoSuchElementException e) {
            return "[Fail] - Dropdown '" + dropdownString + "' does not exist within locator '" + locator + "'.";
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            return "[Fail] - An unexpected error occurred while selecting dropdown.";
        }

    } else {
        return "[Fail] - Could not select dropdown because locator '" + locator + "' does not exist.";
    }

}


public String countDropdownAppianExpense(String locator, String dropdownString, int expectedValue, int timeout, String[] expectedArr) {

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
        int optionCount2 = optionNames.size();
        int count = 0;
        int temp;
        // Check if the dropdown has options
        if (optionCount2 == 0) {
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
            ArrayList<String> arr = new ArrayList<>();
            String currentValue="";
            // Loop up to 10 times to set the dropdown value
            for (int i = 0; i <= optionCount2 * 20; i++) {
                // Get value of dropdown
                currentValue = element.getText();
                
                // Check if the dropdown is already set to the desired value
                if (currentValue.equals(dropdownString) && count>0) {
                    temp = count-1;
                    //count = -1;
                    System.out.println("Total items in the dropdown is: " + temp + " Minus 1 for the default item placeholder : " + dropdownString);
                    System.out.println("Expected number of items in the dropdown is: " + expectedValue);
                    //Close the dropdown
                   typeOnKeyboard("ENTER");
                   System.out.println(arr);
                   // Check if the expected value is equal to the actual value
                   if (temp!=expectedValue) {
                    System.out.println("------------------------------------------------------------");
                    System.out.println("The expected Array is : " + Arrays.toString(expectedArr));
                    System.out.println("------------------------------------------------------------");
                    System.out.println("The Actual Array is : " + arr);
                    return "[Fail] - The number count from the dropdown is " + temp + "' Expected count is '" + expectedValue;
                    
                }
                    return "[Pass] - End of dropdown" + dropdownString + "' from locator '" + locator + " containing '" + temp + "' options.";
                } else {
                    if(count!=0 && count!=-1){
                        arr.add(currentValue);
                    }
                    // Set the dropdown value to the desired value
                    typeOnKeyboard("ARROW_DOWN");
                    waitForDuration(50, "ms", false); // This was necessary for Appians dropdown latenancy
                    count++;
                }
            }

            // If the dropdown value was not set reviewing all items
            return "[Fail] - You passed the wrong default placeholder value " + dropdownString + "' from locator '" + locator + "Expected value is: " + currentValue;

        } catch (NoSuchElementException e) {
            return "[Fail] - Dropdown '" + dropdownString + "' does not exist within locator '" + locator + "'.";
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            return "[Fail] - An unexpected error occurred while selecting dropdown.";
        }

    } else {
        return "[Fail] - Could not select dropdown because locator '" + locator + "' does not exist.";
    }

}

}