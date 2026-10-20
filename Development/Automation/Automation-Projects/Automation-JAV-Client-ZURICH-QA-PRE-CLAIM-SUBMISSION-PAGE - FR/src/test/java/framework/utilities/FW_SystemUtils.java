package framework.utilities;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * This class provides utility methods for system needs.
 */
public class FW_SystemUtils {

    /**
     * This method checks if a given path exists.
     *
     * @param path The path to check (e.g. "/Users/user.name/Automation-Projects/Automation-JAV-Sandbox").
     * 
     * @return True if the path exists, false Autrewise.
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
     * @return True if the landmark exists in the given path, false Autrewise.
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
     * @return True if the landmark exists in the given path, false Autrewise.
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
