package framework.driver;
/**
 * @file FW_Browser.java
 * @description Provides utility methods for creating and managing WebDriver instances.
 * 
 * This file contains the FW_Browser class which provides methods to create and manage WebDriver instances
 * based on the browser type and headless mode specified in the test configuration file. It also includes
 * functionalities to handle browser extensions and dispose of WebDriver instances.
 * 
 * The FW_Browser class offers functionalities to:
 * - Create WebDriver instances for Chrome, Firefox, and Safari.
 * - Configure WebDriver options such as headless mode and browser extensions.
 * - Dispose of WebDriver instances to close browser windows.
 * 
 * This class is designed to facilitate the setup and teardown of WebDriver instances, ensuring that tests
 * can be executed in different browser environments with the specified configurations.
 */

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
        String selectorsHub = FW_ConfigMgr.getSelctorsHub().toLowerCase();
        String selectorsHubDirectory = FW_ConfigMgr.getSelctorsHubDirectory().toLowerCase();

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
