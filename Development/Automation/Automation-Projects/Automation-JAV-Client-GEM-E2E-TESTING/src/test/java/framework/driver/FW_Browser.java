package framework.driver;

// ===============================================================
// @file: FW_Browser.java
// @filepath: src/test/java/framework/driver/FW_Browser.java
// @version: 2.0.0
// @updated: 2025-01-10 11:40:00 AM CST
// @author: Greg Paskal
// @company: MissionWares
//
// @description:
// Provides utility methods for creating and managing WebDriver instances.
// This class handles the creation of WebDriver instances for Chrome, Firefox,
// and Safari browsers based on configuration settings. Supports headless mode
// operation and browser extension management (specifically SelectorsHub for
// Chrome). Includes functionality to configure WebDriver options, handle
// browser-specific settings, and properly dispose of WebDriver instances
// after test execution.
//
// @dependencies:
// - Selenium WebDriver (Chrome, Firefox, Safari drivers)
// - framework.utilities.FW_ConfigMgr
// - framework.utilities.FW_ConsoleColors
// - framework.utilities.FW_SystemUtils
// - framework.junit.FW_CustomAssertJU
//
// @methods:
// - createWebDriver(): Creates and returns configured WebDriver instance
// - disposeWebDriver(WebDriver): Safely closes browser and releases resources
//
// @configuration:
// Requires the following properties in testConfig.properties:
// - browser: Browser type (chrome, firefox, safari)
// - headless: Run in headless mode (true/false)
// - selectorsHub: Enable SelectorsHub extension (true/false)
// - selectorsHubDirectory: Directory containing SelectorsHub CRX file
//
// @tags: webdriver, browser-automation, selenium, cross-browser, mAi™
//
// @changeLog:
// Date        Author          Version  Description
// ----------  --------------  -------  --------------------------
// 2025-01-01  G. Paskal       1.0.0    Initial implementation
// 2025-01-10  G. Paskal       2.0.0    Added mAi™ header and enhanced documentation
// ===============================================================

import java.io.File;
import java.util.List;

// Selenium WebDriver
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

// Automation framework
import framework.utilities.FW_ConfigMgr;
import framework.utilities.FW_ConsoleColors;
import framework.utilities.FW_SystemUtils;
import framework.junit.FW_CustomAssertJU;

/**
 * The Browser class is a utility class that provides a method to create a WebDriver instance
 * based on the browser type and headless mode specified in the test configuration file.
 */
public class FW_Browser {

    /**
     * Returns a WebDriver instance based on the browser type and headless mode specified.
     * 
     * @return a WebDriver instance
     */
    public static WebDriver createWebDriver() {

        // Get the browser options from testConfig.properties
        String browser = FW_ConfigMgr.getBrowser().toLowerCase();
        String headless = FW_ConfigMgr.getHeadless().toLowerCase();
        String selectorsHub = FW_ConfigMgr.getSelectorsHub().toLowerCase();
        String selectorsHubDirectory = FW_ConfigMgr.getSelectorsHubDirectory().toLowerCase();

        // Get common paths
        String presentProjectPath = FW_SystemUtils.pathPresentProject();
        String presentProjectExtensionsPath = FW_SystemUtils.pathPresentProjectExtensions();

        // **************************************************************
        // Browser Extensions Requirements - Begin

        // Extension - SelectorsHub - Begin
        String selectorsHubCRXPath = ""; // Set default value for SelectorsHub CRX file path

        // Check if SelectorsHub is enabled
        if ("true".equals(selectorsHub)) {

            // Check if the path landmark Automation-Projects exists in the current directory path
            Boolean pathLandmarkExist = FW_SystemUtils.pathLandmarkAutomationProjectsExist();
            if (pathLandmarkExist) {

                // Get the path up to the landmark Automation-Projects
                String selectorsHubPath = presentProjectExtensionsPath + "/" + selectorsHubDirectory;

                // Check if the SelectorsHub directory exists
                Boolean selectorsHubPathExist = FW_SystemUtils.pathExists(selectorsHubPath);

                // If the SelectorsHub directory exists
                if (selectorsHubPathExist) {

                    // Get the SelectorsHub .crx filename
                    List<String> selectorsHubDirectoryFiles = FW_SystemUtils.getFilesInDirectory(selectorsHubPath, ".crx", false);

                    // Determine if just one result was found
                    if (selectorsHubDirectoryFiles.size() == 1) {
                        String selectorsHubCRXFilename = selectorsHubDirectoryFiles.get(0);

                        // Generate the full path to the SelectorsHub .crx file
                        selectorsHubCRXPath = selectorsHubPath + selectorsHubCRXFilename;
                    } else {
                        System.out.println(FW_ConsoleColors.RED + "Warning: SelectorsHub CRX file not found or multiple files found." + FW_ConsoleColors.RESET);
                        System.out.println(FW_ConsoleColors.RED + "File(s) found in directory: " + selectorsHubPath + FW_ConsoleColors.RESET);
                        System.out.println(FW_ConsoleColors.RED + selectorsHubDirectoryFiles + FW_ConsoleColors.RESET);
                        selectorsHub = "false"; // Set to false to prevent usage of selectorsHub
                    }

                // If the SelectorsHub directory does not exist
                } else {
                    System.out.println(FW_ConsoleColors.RED + "Warning: SelectorsHub directory '" + selectorsHubDirectory + "' not found. Please check selectorsHubDirectory in testConfig.properties file." + FW_ConsoleColors.RESET);
                    selectorsHub = "false"; // Set to false to prevent usage of selectorsHub
                }

            }else{
                System.out.println(FW_ConsoleColors.RED + "Warning: 'Automation-Projects' not found in current project path '" + presentProjectPath + "' but was expected." + FW_ConsoleColors.RESET);
                selectorsHub = "false"; // Set to false to prevent usage of selectorsHub
            }

        }
        // Extension - SelectorsHub - End

        // Browser Extensions Requirements - End
        // **************************************************************

        
        WebDriver driver;
        if ("chrome".equals(browser)) {
            ChromeOptions options = new ChromeOptions();
            if ("true".equals(headless)) options.addArguments("--headless");
            if ("true".equals(selectorsHub)) options.addExtensions(new File(selectorsHubCRXPath));
            driver = new ChromeDriver(options);
        } else if ("firefox".equals(browser)) {
            FirefoxOptions options = new FirefoxOptions();
            if ("true".equals(headless)) options.addArguments("--headless");
            driver = new FirefoxDriver(options);
        } else if ("safari".equals(browser)) {
            SafariOptions options = new SafariOptions();
            // Safari doesn't support headless mode as of now
            driver = new SafariDriver(options);
        } else {
            // Default to Chrome if no matching browser is found
            ChromeOptions options = new ChromeOptions();
            if ("true".equals(headless)) options.addArguments("--headless");
            if ("true".equals(selectorsHub)) options.addExtensions(new File(selectorsHubCRXPath));
            driver = new ChromeDriver(options);
        }
        FW_CustomAssertJU.setDriver(driver);
        return driver;
    }

    /**
     * Quits the WebDriver instance, effectively closing the browser window.
     *
     * @param driver the WebDriver instance to quit
     */
    public static void disposeWebDriver(WebDriver driver) {
        // Quit the driver, effectively closing the browser window
        if (driver != null) {
            driver.quit();
        }
    }

}
