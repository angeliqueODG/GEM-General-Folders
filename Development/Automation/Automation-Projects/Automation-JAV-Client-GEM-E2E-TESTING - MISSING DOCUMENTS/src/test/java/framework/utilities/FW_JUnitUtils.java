package framework.utilities;

// ===============================================================
// @file: FW_JUnitUtils.java
// @filepath: src/test/java/framework/utilities/FW_JUnitUtils.java
// @version: 1.0.1
// @updated: 2025-01-10 03:24:00 PM CST
// @author: Greg Paskal
// @company: MissionWares
//
// @description:
// Utility class for JUnit test framework helper functions.
// This class provides methods to identify and analyze JUnit test methods,
// including detection of standard tests, repeated tests, and parameterized
// tests. Supports extraction of test configuration details such as CSV file
// sources, repetition counts, and test case metadata. Designed to work with
// JUnit 5 annotations and provide runtime introspection of test methods.
//
// @methods:
// - isTestCase(Method) - Checks if method is any type of test case
// - isTestCaseParameterized(Method) - Checks for parameterized test
// - getTestCaseParameterizedCsvFileSource(Method) - Gets CSV source path
// - getTestCaseParameterizedCsvFileSourceNumLinesToSkip(Method) - Gets skip lines
// - getTestCaseParameterizedCsvFileSourceRowCount(Method) - Gets CSV row count
// - isRepeatedTestCase(Method) - Checks for repeated test
// - getRepeatedTestCaseCount(Method) - Gets repetition count
//
// @dependencies:
// - java.lang.reflect.Method
// - org.junit.jupiter.api.RepeatedTest
// - org.junit.jupiter.api.Test
// - org.junit.jupiter.params.ParameterizedTest
// - org.junit.jupiter.params.provider.CsvFileSource
// - framework.utilities.FW_FileDirUtils
//
// @tags: junit, test-utilities, reflection, parameterized-tests, mAi™
//
// @changeLog:
// Date        Author          Version  Description
// ----------  --------------  -------  --------------------------
// 2025-01-10  G. Paskal       1.0.0    Initial implementation with mAi™ header
// 2025-10-16  G. Paskal       1.0.1    isTestCase simplified
// ===============================================================

import java.lang.reflect.Method;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

/**
 * Utility class for JUnit test framework helper functions.
 */
public class FW_JUnitUtils {

    /**
     * Checks if the given method is a test case.
     *
     * @param method The method to check.
     *
     * @return True if the method is a test case, false otherwise.
     */
    public static boolean isTestCase(Method method) {
        boolean hasTestAnnotation = method.isAnnotationPresent(Test.class);
        boolean hasRepeatedTestAnnotation = method.isAnnotationPresent(RepeatedTest.class);
        boolean hasParameterizedTestAnnotation = method.isAnnotationPresent(ParameterizedTest.class);
        
        return hasTestAnnotation || hasRepeatedTestAnnotation || hasParameterizedTestAnnotation;
    }

    /**
     * Checks if the given method is a test case that is parameterized.
     *
     * @param method The method to check.
     * 
     * @return True if the method is a parameterized test case, false otherwise.
     */
    public static boolean isTestCaseParameterized(Method method) {
        return method.isAnnotationPresent(ParameterizedTest.class);
    }

    /**
     * If the tst case is parameterized, what is the CsvFileSource resource
     * 
     * @param method
     * 
     * @return The CsvFileSource resource
     */
    public static String getTestCaseParameterizedCsvFileSource(Method method) {

        // Ensure this is a parameterized test case
        if (!isTestCaseParameterized(method)) {
            return null; // Not a parameterized test case
        }

        CsvFileSource csvFileSource = method.getAnnotation(CsvFileSource.class);
        if (csvFileSource != null) {
            return String.join(",", csvFileSource.resources());
        }

        return null; // No CsvFileSource annotation present;
    }

    /**
     * If the tst case is parameterized, what is the CsvFileSource numLinesToSkip
     * 
     * @param method
     * 
     * @return The CsvFileSource numLinesToSkip
     */
    public static int getTestCaseParameterizedCsvFileSourceNumLinesToSkip(Method method) {

        // Ensure this is a parameterized test case
        if (!isTestCaseParameterized(method)) {
            return 0; // Not a parameterized test case
        }

        CsvFileSource csvFileSource = method.getAnnotation(CsvFileSource.class);
        if (csvFileSource != null) {
            return csvFileSource.numLinesToSkip();
        }

        return 0; // No CsvFileSource annotation present;
    }

    /**
     * Return the row count for the parameterized test case CSV file
     * 
     * @param method
     * 
     * @return The row count for the parameterized test case CSV file
     */
    public static int getTestCaseParameterizedCsvFileSourceRowCount(Method method) {

        // Ensure this is a parameterized test case
        if (!isTestCaseParameterized(method)) {
            return 0; // Not a parameterized test case
        }

        // Get the CsvFileSource resources filename
        String csvFileSourceResources = getTestCaseParameterizedCsvFileSource(method);
        if (csvFileSourceResources != null) {
            return 0;
        }

        // Get the CsvFileSource numLinesToSkip
        int csvFileSourceResourcesNumLinesToSkip = getTestCaseParameterizedCsvFileSourceNumLinesToSkip(method);
        if (csvFileSourceResourcesNumLinesToSkip > 0) {
            return 0;
        }

        // Verify the CSV file exists
        csvFileSourceResources = "src/test/resources/" + csvFileSourceResources;
        if (!FW_FileDirUtils.fileExists(csvFileSourceResources)) {
            return 0; // File does not exist
        }

        return 0; // No CsvFileSource annotation present;
    }

    /**
     * Checks if the given method is a repeated test case.
     *
     * @param method The method to check.
     *
     * @return True if the method is a repeated test case, false otherwise.
     */
    public static boolean isRepeatedTestCase(Method method) {
        return method.isAnnotationPresent(RepeatedTest.class);
    }

    /**
     * Return an integer value for the number of repetitions for a repeated test case.
     * 
     * @param method The method to check.
     * 
     * @return The number of repetitions for a repeated test case.
     */
    public static int getRepeatedTestCaseCount(Method method) {

        // Ensure this is a test case
        if (!isRepeatedTestCase(method)) {
            return 0; // Not a test case
        }

        // Ensure this is a repeated test case
        if (!isRepeatedTestCase(method)) {
            return 0; // Not a repeated test case
        }

        // Get the number of repetitions
        RepeatedTest annotation = method.getAnnotation(RepeatedTest.class);

        // Return the number of repetitions
        return annotation.value();
    }


}