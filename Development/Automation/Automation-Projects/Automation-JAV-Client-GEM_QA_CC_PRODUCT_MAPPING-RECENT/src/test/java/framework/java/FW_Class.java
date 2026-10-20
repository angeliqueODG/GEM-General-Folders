package framework.java;

// ===============================================================
// @file: FW_Class.java
// @filepath: src/test/java/framework/java/FW_Class.java
// @version: 2.0.0
// @updated: 2025-01-10 11:50:00 AM CST
// @author: Greg Paskal
// @company: MissionWares
//
// @description:
// Represents the details of a Java class for code analysis and reflection.
// This class encapsulates class metadata including reference numbers, class
// names, and associated methods. Provides utility functions for generating
// fully qualified class names from file paths and extracting simple class
// names from qualified names. Designed to support test framework operations
// that require class introspection and method discovery.
//
// @dependencies:
// - framework.utilities.FW_ConsoleColors
// - java.nio.file.Path
// - java.nio.file.Paths
// - java.util.List
//
// @methods:
// - Constructor: Creates FW_Class with reference, name, and methods
// - getReferenceNumber(): Returns class reference number
// - setReferenceNumber(int): Sets class reference number
// - getClassName(): Returns class name
// - setClassName(String): Sets class name
// - getMethods(): Returns list of methods
// - setMethods(List): Sets list of methods
// - generateFullyQualifiedClassName(String, String): Creates qualified name from path
// - extractSimpleClassName(String): Extracts simple name from qualified name
// - toString(): Returns string representation
//
// @tags: class-metadata, reflection, code-analysis, java-parsing, mAi™
//
// @changeLog:
// Date        Author          Version  Description
// ----------  --------------  -------  --------------------------
// 2025-01-01  G. Paskal       1.0.0    Initial implementation
// 2025-01-10  G. Paskal       2.0.0    Added mAi™ header and enhanced documentation
// ===============================================================

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