package framework.utilities;
/**
 * @file FW_SystemUtils.java
 * @description Provides utility methods for system needs.
 * 
 * This file contains the FW_SystemUtils class which provides utility functions for system needs.
 * It includes functionalities to get system information such as timezone, hostname, IP addresses, MAC address, username, platform, OS version, and browser details.
 * 
 * The FW_SystemUtils class offers functionalities to:
 * - Get system information such as timezone, hostname, IP addresses, MAC address, username, platform, OS version, and browser details.
 * - Check if a path exists.
 * - Get the current directory path.
 * - Check if a path landmark exists in the current directory path.
 * - Get the directory path for a path landmark.
 * - Get the present project folder name and directory path.
 * - Get the extensions directory path.
 * - Get all files or files with a specific extension from a given directory.
 * 
 * This class is designed to provide utility methods for system needs.
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.URI;
import java.net.URL;
import java.net.UnknownHostException;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Enumeration;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

/**
 * This class provides utility methods for system needs.
 */
public class FW_SystemUtils {

    /**
     * This method returns the current timezone of the system in three-letter abbreviation.
     *
     * @return The current timezone of the system in three-letter abbreviation.
     */
    public static String getTimezone() {
        ZoneId zoneId = ZoneId.systemDefault();
        ZonedDateTime zonedDateTime = ZonedDateTime.now(zoneId);
        return zonedDateTime.format(DateTimeFormatter.ofPattern("z"));
    }

    /**
     * This method returns the computer hostname.
     * 
     * @return The computer hostname.
     */
    public static String getHostName() {
        try {
            InetAddress inetAddress = InetAddress.getLocalHost();
            return inetAddress.getHostName();
        } catch (UnknownHostException e) {
            e.printStackTrace();
            return "Unknown Host";
        }
    }

    /**
     * This method returns the private IP address of the computer.
     * 
     * @return The private IP address of the computer.
     */
    public static String getLocalIPAddress() {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface networkInterface = networkInterfaces.nextElement();
                Enumeration<InetAddress> inetAddresses = networkInterface.getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress inetAddress = inetAddresses.nextElement();
                    if (!inetAddress.isLoopbackAddress() && !inetAddress.isLinkLocalAddress() && inetAddress.isSiteLocalAddress()) {
                        return inetAddress.getHostAddress();
                    }
                }
            }
        } catch (SocketException e) {
            e.printStackTrace();
            return "Unknown IP Address";
        }
        return "Unknown IP Address";
    }

    /**
     * This method returns the public IP address of the system.
     *
     * @return The public IP address of the system.
     */
    public static String getPublicIPAddress() {
        String urlString = "http://checkip.amazonaws.com/";

        try {
            URI uri = new URI(urlString);
            URL url = uri.toURL();
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder content = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();
            connection.disconnect();

            return content.toString().trim();
        } catch (Exception e) {
            e.printStackTrace();
            return "Public IP Address Unretrievable";
        }
    }
    /**
     * This method returns the MAC address of the network interface that has a site-local IP address.
     * 
     * @return The MAC address of the network interface, or "Unknown MAC Address" if it cannot be determined.
     */
    public static String getMACAddress() {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface networkInterface = networkInterfaces.nextElement();
                Enumeration<InetAddress> inetAddresses = networkInterface.getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress inetAddress = inetAddresses.nextElement();
                    if (!inetAddress.isLoopbackAddress() && !inetAddress.isLinkLocalAddress() && inetAddress.isSiteLocalAddress()) {
                        byte[] mac = networkInterface.getHardwareAddress();
                        if (mac != null) {
                            StringBuilder macAddress = new StringBuilder();
                            for (int i = 0; i < mac.length; i++) {
                                macAddress.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? ":" : ""));
                            }
                            return macAddress.toString();
                        }
                    }
                }
            }
        } catch (SocketException e) {
            e.printStackTrace();
            return "Unknown MAC Address";
        }
        return "Unknown MAC Address";
    }

    /**
     * This method returns the username of the user logged into the computer.
     * 
     * @return The username of the user logged into the computer.
     */
    public static String getUserName() {
        try {
            String userName = System.getProperty("user.name");
            if (userName == null || userName.isEmpty()) {
                return "Username Unretrievable";
            }
            return userName;
        } catch (SecurityException e) {
            return "SecurityException retrieving username";
        }
    }

    /**
     * This method returns the platform (e.g., Windows, Mac, Linux) the computer is running on.
     *
     * @return The platform the computer is running on, or "Unknown" if the platform cannot be determined.
     */
    public static String getPlatform() {
        try {
            String osName = System.getProperty("os.name").toLowerCase();
            if (osName.contains("win")) {
                return "Windows";
            } else if (osName.contains("mac")) {
                return "Mac";
            } else if (osName.contains("nix") || osName.contains("nux") || osName.contains("aix")) {
                return "Linux";
            } else if (osName.contains("sunos")) {
                return "Solaris";
            } else {
                return "Unknown" + osName;
            }
        } catch (SecurityException e) {
            return "SecurityException retrieving platform";
        }
    }

    /**
     * This method returns the OS version of the computer.
     * 
     * @return The OS version of the computer, or "Unknown Version" if the version cannot be determined.
     */
    public static String getOSVersion() {
        try {
            return System.getProperty("os.version");
        } catch (SecurityException e) {
            return "SecurityException retrieving OS version";
        }
    }

    /**
     * This method returns the browser name used for this automation execution.
     *
     * @return The browser name used for this automation execution.
     */
    public static String getBrowserName() {

        // Get the browser designated for the automation execution
        String browserName = FW_ConfigMgr.getBrowser();
        if (browserName == null || browserName.isEmpty()) {
            return "Browser Unretrievable";
        }
        return browserName;
    }

    /**
     * This method returns the browser version used for this automation execution.
     *
     * @return The browser version used for this automation execution.
     */
    public static String getBrowserVersion() {
        // Get the browser name
        String browserName = getBrowserName();

        WebDriver driver = null;
        try {
            if (browserName.equalsIgnoreCase("chrome")) {
                driver = new ChromeDriver();
            } else if (browserName.equalsIgnoreCase("firefox")) {
                driver = new FirefoxDriver();
            } else if (browserName.equalsIgnoreCase("edge")) {
                driver = new EdgeDriver();
            } else if (browserName.equalsIgnoreCase("ie")) {
                driver = new InternetExplorerDriver();
            } else if (browserName.equalsIgnoreCase("safari")) {
                driver = new SafariDriver();
            } else {
                return "Unsupported Browser";
            }

            Capabilities capabilities = ((RemoteWebDriver) driver).getCapabilities();
            String browserVersion = capabilities.getBrowserVersion();

            if (browserVersion == null || browserVersion.isEmpty()) {
                return "Browser Version Unretrievable";
            }

            // Return the browser version
            return browserVersion;

        } catch (Exception e) {
            System.err.println("Exception occurred while getting browser version: " + e.getMessage());
            e.printStackTrace();
            return "Browser Version Unretrievable";
        } finally {
            if (driver != null) {
                driver.quit();
            }
        }
    }

    /**
     * This method checks if a given path exists.
     *
     * @param path The path to check (e.g. "/Users/user.name/Automation-Projects/Automation-JAV-Sandbox").
     * 
     * @return True if the path exists, false otherwise.
     */
    public static boolean pathExists(String path) {

        // Check if the path is not null or empty
        if (path != null && !path.isEmpty()) {
            File file = new File(path);
            return file.exists(); // Check if the path exists
        } else {
            return false; // Path is null or empty
        }
    }

    /**
     * This method returns the current directory path.
     * 
     * @return The current directory path.
     */
    public static String pathPresentDirectory() {
        String result = System.getProperty("user.dir");
        return result;
    }

    /**
     * This method checks if the "Automation-Projects" path landmark exists in the current directory path.
     * 
     * @return True if the landmark exists in the given path, false otherwise.
     */
    public static boolean pathLandmarkAutomationProjectsExist() {
        String pathLandmark = "Automation-Projects"; // Set the landmark to find
        String presentProjectPath = FW_SystemUtils.pathPresentDirectory(); // Get the current directory path
        Boolean landmarkExistResult = FW_SystemUtils.pathLandmarkExist(presentProjectPath, pathLandmark); // Check is path landmark exists
        return landmarkExistResult;
    }

    /**
     * This method gets the directory path for the "Automation-Projects" path landmark.
     * 
     * @return Returns the directory path including the "Automation-Projects" path landmark, or an empty string if "Automation-Projects" 
     */
    public static String pathLandmarkAutomationProjects() {
        String pathLandmark = "Automation-Projects"; // Set the landmark to find
        Boolean landmarkExistResult = pathLandmarkAutomationProjectsExist();

        if (landmarkExistResult) {
            String presentProjectPath = FW_SystemUtils.pathPresentDirectory(); // Get the current directory path
            String landmarkDirectoryPath = FW_SystemUtils.getLandmarkDirectoryPath(presentProjectPath, pathLandmark, true); // Get the directory path up to the landmark
            return landmarkDirectoryPath;
        } else {
            return "";
        }
    }

    /**
     * This method gets the present project folder name
     * 
     * @return Returns the present project folder name, or an empty string if an error occurs.
     */
    public static String presentProjectFolder() {

        // Get the present project directory path
        String presentProjectPath = FW_SystemUtils.pathPresentProject();

        // Get the present project folder name
        File presentProjectFile = new File(presentProjectPath);

        // Get the present project folder name
        String presentProjectFolderName = presentProjectFile.getName();

        // Return the present project folder name
        return presentProjectFolderName;
    }

    /**
     * This method gets the present project directory path.
     * 
     * @return Returns the present project directory path, or an empty if an error occurs.
     */
    public static String pathPresentProject() {
        String currentDir = FW_SystemUtils.pathPresentDirectory();
        File dir = new File(currentDir);

        // Iterate through the directory path
        while (dir != null) {

            // Get a list of files in the directory
            File[] files = dir.listFiles();

            // Iterate through the files in the directory
            if (files != null) {

                // Check if the directory contains a "src" directory
                for (File file : files) {
                    if (file.isDirectory() && file.getName().equals("src")) {

                        // Return the directory path up to the "src" directory
                        String directoryPath = dir.getAbsolutePath();
                        return directoryPath;
                    }
                }
            }
            // Move up to the parent directory
            dir = dir.getParentFile();
        }

        // Return an empty string if the "src" directory is not found
        return "";
    }

     /**
     * This method gets the extensions directory path.
     * 
     * @return Returns the extensions directory path, or an empty if an error occurs.
     */
    public static String pathPresentProjectExtensions() {
        String presentProjectPath = FW_SystemUtils.pathPresentProject();
        String extensionsDirectoryPath = presentProjectPath + "/src/test/java/framework/extensions";

        Boolean extensionsDirectoryPathExist = FW_SystemUtils.pathExists(extensionsDirectoryPath);

        if (extensionsDirectoryPathExist) {
            return extensionsDirectoryPath;
        } else {
            return "";
        }
    }

    /**
     * This method checks if a path landmark exists in the given path.
     *
     * @param path The path to evaluate (e.g. "/Users/user.name/Automation-Projects/Automation-JAV-Sandbox").
     * @param landmark The landmark in the path to find (e.g. "Automation-Projects").
     * 
     * @return True if the landmark exists in the given path, false otherwise.
     */
    public static boolean pathLandmarkExist(String path, String landmark) {
        if (path != null && !path.isEmpty() && landmark != null && !landmark.isEmpty()) {
            int pathLandmarkLocation = path.indexOf(landmark);
            if (pathLandmarkLocation != -1) {
                return true; // Landmark exists in the path
            } else {
                return false; // Landmark does not exist in the path
            }
        } else {
            return false; // Path or landmark is null or empty
        }
    }

    /**
     * This method returns the directory path up to the landmark.
     *
     * @param path The path to evaluate (e.g. "/Users/user.name/Automation-Projects/Automation-JAV-Sandbox").
     * @param landmark The landmark in the path to find (e.g. "Automation-Projects").
     * @param includeLandmark Whether to include the landmark in the returned path.
     * 
     * @return The directory path up to the landmark, or an empty string if the landmark does not exist in the path.
     */
    public static String getLandmarkDirectoryPath(String path, String landmark, boolean includeLandmark) {
        if (path != null && !path.isEmpty() && landmark != null && !landmark.isEmpty()) {
            int pathLandmarkLocation = path.indexOf(landmark);
            if (pathLandmarkLocation != -1) {
                if (includeLandmark) {
                    return path.substring(0, pathLandmarkLocation + landmark.length());
                } else {
                    return path.substring(0, pathLandmarkLocation);
                }
            }
        }
        return "";
    }

    /**
     * This method returns all files or files with a specific extension from a given directory.
     *
     * @param directoryPath The path of the directory to search.
     * @param extension The file extension to filter by (optional).
     * @param absolutePath True to return absolute paths, false to return relative paths.
     * 
     * @return A list of file paths.
     */
    public static List<String> getFilesInDirectory(String directoryPath, String extension, boolean absolutePath) {
        List<String> fileList = new ArrayList<>(); // Create a list to store file paths
        File directory = new File(directoryPath); // Create a File object from the directory path

        try {
            // Check if the directory exists and is a directory
            if (directory.exists() && directory.isDirectory()) {

                // Get a list of files in the directory
                File[] files = directory.listFiles();

                // Iterate through the files in the directory
                if (files != null) {

                    // Add file paths to the list
                    for (File file : files) {

                        // Check if the file is a regular file
                        if (file.isFile()) {
                            if (extension == null || extension.isEmpty() || extension.equals("*") || file.getName().endsWith(extension)) {
                                
                                // Add the file with the absolute or relative path to the list
                                if (absolutePath) {
                                    fileList.add(file.getAbsolutePath());
                                } else {
                                    fileList.add(directory.toPath().relativize(file.toPath()).toString());
                                }
                            }
                        }
                    }
                }
            } else {
                // Print an error message if the directory does not exist or is not a directory
                System.err.println("The provided path is not a directory or does not exist: " + directoryPath);
            }

        // Print an error message if an exception occurs
        } catch (SecurityException e) {
            System.err.println("Security exception occurred while accessing the directory: " + e.getMessage());

        // Print an error message if a null pointer exception occurs
        } catch (NullPointerException e) {
            System.err.println("Null pointer exception occurred: " + e.getMessage());
        }

        // Return the list of file paths
        return fileList;
    }

}
