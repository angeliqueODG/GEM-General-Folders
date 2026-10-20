package framework.java;
/**
 * @file FW_Class.java
 * @description Represents the details of a class.
 * 
 * This file contains the FW_Class class which represents the details of a class, including its reference number,
 * class name, and list of methods. It provides methods to get and set these details, as well as utility methods
 * to generate fully qualified class names and extract simple class names.
 * 
 * The FW_Class class offers functionalities to:
 * - Get and set the reference number of the class.
 * - Get and set the name of the class.
 * - Get and set the list of methods in the class.
 * - Generate fully qualified class names based on the base directory and class file path.
 * - Extract simple class names from fully qualified class names.
 * 
 * This class is designed to encapsulate the details of a class and provide utility methods for working with class names.
 */

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import framework.utilities.FW_ConsoleColors;

/**
 * Represents the details of a class.
 */
public class FW_Class {
    private int referenceNumber;
    private String className;
    private List<FW_Method> methods;

    /**
     * Constructs a new FW_Class instance.

     * @param referenceNumber the reference number of the class
     * @param className the name of the class
     * @param methods the list of methods in the class
     */
    public FW_Class(int referenceNumber, String className, List<FW_Method> methods) {
        this.referenceNumber = referenceNumber;
        this.className = className;
        this.methods = methods;
    }

    /**
     * Gets the reference number of the class.
     *
     * @return the reference number
     */
    public int getReferenceNumber() {
        return referenceNumber;
    }

    /**
     * Sets the reference number of the class.
     *
     * @param referenceNumber the new reference number
     */
    public void setReferenceNumber(int referenceNumber) {
        this.referenceNumber = referenceNumber;
    }

    /**
     * Gets the name of the class.
     *
     * @return the class name
     */
    public String getClassName() {
        return className;
    }

    /**
     * Sets the name of the class.
     *
     * @param className the new class name
     */
    public void setClassName(String className) {
        this.className = className;
    }

    /**
     * Gets the list of methods in the class.
     *
     * @return the list of methods
     */
    public List<FW_Method> getMethods() {
        return methods;
    }

    /**
     * Sets the list of methods in the class.
     *
     * @param methods the new list of methods
     */
    public void setMethods(List<FW_Method> methods) {
        this.methods = methods;
    }

    /**
     * Generates a fully qualified class name based on the base directory and class file path.
     *
     * @param baseDir the base directory of the project
     * @param classFilePath the file path of the class
     * 
     * @return the fully qualified class name
     */
    public static String generateFullyQualifiedClassName(String baseDir, String classFilePath) {

        // Check if baseDir or classFilePath is null
        if (baseDir == null || classFilePath == null) {

            // Print a warning message about the base directory or class file path being null
            System.err.println(FW_ConsoleColors.RED + "Warning: Base directory or class file path is null. Cannot generate fully qualified class name." + FW_ConsoleColors.RESET);
        }

        // Convert the base directory and class file path to Path objects
        Path basePath = Paths.get(baseDir);
        Path classPath = Paths.get(classFilePath);

        // Get the relative path from the base directory to the class file
        Path relativePath = basePath.relativize(classPath);

        // Convert the relative path to a string and replace slashes with dots
        String classPathExp = relativePath.toString()
            .replace("target/test-classes/", "")
            .replace(".class", "")
            .replace("/", ".");

        return classPathExp;
    }

    /**
     * Extracts the simple class name from a fully qualified class name.
     *
     * @param fullClassName the fully qualified class name
     * 
     * @return the simple class name
     */
    public static String extractSimpleClassName(String fullClassName) {
        if (fullClassName == null || fullClassName.isEmpty()) {
            return "Unknown";
        }
        String[] parts = fullClassName.split("\\.");
        return parts[parts.length - 1];
    }

    /**
     * Returns a string representation of the FW_Class instance.
     *
     * @return a string representation of the object
     */
    @Override
    public String toString() {
        return "FW_Class{" +
                "referenceNumber=" + referenceNumber +
                ", className='" + className + '\'' +
                ", methods=" + methods +
                '}';
    }
}