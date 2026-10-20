package framework.utilities;

import java.lang.reflect.Method;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class FW_JUnitUtils {

    /**
     * Checks if the given method is a test case.
     *
     * @param method The method to check.
     *
     * @return True if the method is a test case, false otherwise.
     */
    public static boolean isTestCase(Method method) {

        boolean result = false; // Default to false
        boolean isTest = false; // Default to false
        boolean isRepeatedTest = false; // Default to false
        boolean isParameterizedTest = false; // Default to false

        // Look for annotation type of Test
        isTest = method.isAnnotationPresent(Test.class);

        // Look for annotation type of RepeatedTest
        isRepeatedTest = method.isAnnotationPresent(RepeatedTest.class);

        // Look for annotation type of ParameterizedTest
        isParameterizedTest = method.isAnnotationPresent(ParameterizedTest.class);

        // if Test or RepeatedTest is present, the this is a test case
        if (isTest || isRepeatedTest || isParameterizedTest) {
            result = true;
        }

        // Return the result
        return result;
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