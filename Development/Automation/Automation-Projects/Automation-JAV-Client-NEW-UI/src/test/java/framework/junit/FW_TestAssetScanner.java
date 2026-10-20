package framework.junit;

import framework.java.FW_Class;
import framework.java.FW_JavaFileParser;
import framework.java.FW_Method;
import framework.utilities.FW_FileDirUtils;
import framework.utilities.FW_FileDirUtils.FileInfo;
import framework.utilities.FW_ReportUtils;
import framework.utilities.FW_SystemUtils;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Scans test classes and counts the total number of test suites, and test cases to be executed.
 */
public class FW_TestAssetScanner {

    /**
     * Main method for debugging purposes.
     *
     * @param args Command line arguments
     */
    public static void main(String[] args) {
        List<FW_TestSuite> discoveredTestAssets = scanTestAssets();
        FW_ReportUtils.printTestRunMetrics();
    }

    /**
     * Scans and processes test assets.
     *
     * @return A list of FW_TestSuite objects containing the details of each test suite.
     */
    public static List<FW_TestSuite> scanTestAssets() {
        try {
            // Find Test Suite files in the 'src/test/java' directory that contain 'JUnit.java' in their names
            List<FileInfo> testSuiteFiles = FW_FileDirUtils.findFiles("src/test/java", "JUnit.java", false);

            // Process the test Suite File and get the test suite details
            return processTestSuites(testSuiteFiles);
        } catch (Exception e) {
            // Handle any exceptions that occur during the execution
            System.out.println("An error occurred while scanning test classes");
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    /**
     * Processes a list of Test Suite files to collect test details.
     *
     * @param testSuiteFiles The list of test files to process.
     * 
     * @return A list of FW_TestSuite objects containing the details of each test suite.
     */
    private static List<FW_TestSuite> processTestSuites(List<FileInfo> testSuiteFiles) {

        // Create a collection to store the test suite details
        List<FW_TestSuite> testSuiteDetails = new ArrayList<>();

        // Process each test suite file
        for (FileInfo fileInfo : testSuiteFiles) {
            String testSuite = fileInfo.getFileName();
            testSuiteDetails.add(processTestSuite(testSuite));
        }

        // Return the collection of test suite details
        return testSuiteDetails;
    }

    /**
     * Processes a single Test Suite file to collect test details.
     *
     * @param testSuite The name of the test suite file to process.
     * 
     * @return An FW_TestSuite object containing the details of the test suite.
     */
    private static FW_TestSuite processTestSuite(String testSuite) {

        // Create an FW_TestSuite object to store the test suite details
        FW_TestSuite testSuiteDetails = new FW_TestSuite(testSuite);

        // Process the test suite file
        try {
            // What is the compiled location for classes?
            String compiledTestClassDir = "target/test-classes";

            // Get base directory path
            String baseDir = FW_SystemUtils.pathPresentProject();

            // Build the full path to the compiled test class
            String compiledTestClass = baseDir + "/" + compiledTestClassDir + "/" + testSuite.replace(".java", ".class");
            
            // Check if the compiled test class exists
            if (!FW_FileDirUtils.fileExists(compiledTestClass)) {
                System.out.println("Compiled test-class does not exist: '" + compiledTestClass + "'");
                return testSuiteDetails;
            }
            // Transform filepath to the classpath
            String classPath = testSuite.replace(".java", "");

            // Validate that the class exists and can be loaded
            Class<?> classRef;
            try {
                classRef = Class.forName(classPath);
            } catch (ClassNotFoundException e) {
                System.out.println("Class not found: " + classPath);
                e.printStackTrace();
                return testSuiteDetails;
            }

            // Initialize the test suite details
            String suiteName = classRef.getSimpleName();
            Method[] methods = classRef.getDeclaredMethods();
            int totalTestCount = 0;
            int executedTestCount = 0;
            int repeatingTestCount = 0;
            int disabledTestCount = 0;

            // Determine the annotations for each Test Case
            for (Method method : methods) {
                boolean isTest = method.isAnnotationPresent(Test.class);
                boolean isRepeatedTest = method.isAnnotationPresent(RepeatedTest.class);
    
                if (isTest || isRepeatedTest) {
                    int repeatCount = isRepeatedTest ? method.getAnnotation(RepeatedTest.class).value() : 1;
                    totalTestCount += repeatCount;
    
                    // Get Annotation - DisplayName
                    String displayName = method.isAnnotationPresent(DisplayName.class) ? method.getAnnotation(DisplayName.class).value() : method.getName();
                    // Get Annotation - Disabled
                    boolean isDisabled = method.isAnnotationPresent(Disabled.class);
                    // Get Annotation - Tag
                    String tags = "";
                    if (method.isAnnotationPresent(Tag.class)) {
                        // Check if the method has the Tag annotation
                        Tag[] tagAnnotations = method.getAnnotationsByType(Tag.class);  // Get all Tag annotations present on the method
                        Stream<Tag> tagStream = Arrays.stream(tagAnnotations);          // Create a stream from the array of Tag annotations
                        Stream<String> tagValuesStream = tagStream.map(Tag::value);     // Map each Tag annotation to its value
                        String[] tagValuesArray = tagValuesStream.toArray(String[]::new); // Collect the mapped tag values into a String array
                        tags = String.join(", ", tagValuesArray);                       // Join the elements of the String array into a single string, separated by ", "
                    }
                    // Increment the executed test count if the test is not disabled
                    if (!isDisabled) {
                        executedTestCount += repeatCount;
                    } else {
                        // Increment the disabled test count if the test is disabled
                        disabledTestCount += repeatCount;
                    }
                    // Increment the repeating test count if the test is repeated
                    if (isRepeatedTest) {
                        repeatingTestCount += repeatCount;
                    }
                    // Count the test steps by analyzing the method body
                    int testSteps = countTestSteps(method);
    
                    // Create a FW_TestCase object and add it to the list
                    FW_TestCase testCaseDetails = new FW_TestCase(suiteName, method.getName(), displayName, tags, isDisabled, repeatCount);
                    testCaseDetails.setTestSteps(testSteps); // Set the test steps
                    testSuiteDetails.addTestCase(testCaseDetails);
                }
            }
            testSuiteDetails.setTotalTestCount(totalTestCount);
            testSuiteDetails.setExecutedTestCount(executedTestCount);
            testSuiteDetails.setRepeatingTestCount(repeatingTestCount);
            testSuiteDetails.setDisabledTestCount(disabledTestCount);
        } catch (Exception e) {
            System.out.println("Reflection error while processing test suite: " + testSuite);
            e.printStackTrace();
        }
        return testSuiteDetails;
    }

    /**
     * Calculates the summary metrics from the test suite details.
     *
     * @param testSuiteDetails The list of test suite details.
     * @return The summary metrics.
     */
    public static FW_TestRun calculateSummary(List<FW_TestSuite> testSuiteDetails) {
        FW_TestRun testRun = new FW_TestRun();
        int totalTestSuites = testSuiteDetails.size();
        int totalTestCases = 0;
        int totalTestSteps = 0;
        int executableTestCases = 0;
        int executableTestSteps = 0;
        int repeatingTestCases = 0;
        int repeatingTestSteps = 0;
        int disabledTestCases = 0;
        int disabledTestSteps = 0;
        int completedTestCases = 0;     // Placeholder, to be updated during test execution
        int completedTestSteps = 0;     // Placeholder, to be updated during test execution
        int completedTestSuites = 0;    // Placeholder, to be updated during test execution
        int remainingTestCases = 0;     // Placeholder, to be updated during test execution
        int remainingTestSteps = 0;     // Placeholder, to be updated during test execution
        int remainingTestSuites = 0;    // Placeholder, to be updated during test execution
        int passedTestCases = 0;        // Placeholder, to be updated during test execution
        int passedTestSteps = 0;        // Placeholder, to be updated during test execution
        int passedTestSuites = 0;       // Placeholder, to be updated during test execution
        int failedTestCases = 0;        // Placeholder, to be updated during test execution
        int failedTestSteps = 0;        // Placeholder, to be updated during test execution
        int failedTestSuites = 0;       // Placeholder, to be updated during test execution
        long totalRunTime = 0;          // Placeholder, to be updated during test execution

        for (FW_TestSuite testSuite : testSuiteDetails) {
            totalTestCases += testSuite.getTotalTestCount();
            executableTestCases += testSuite.getExecutedTestCount();
            repeatingTestCases += testSuite.getRepeatingTestCount();
            disabledTestCases += testSuite.getDisabledTestCount();

            // Sum up the total test steps from each test case within the test suite
            for (FW_TestCase testCase : testSuite.getTestCases()) {
                int testSteps = testCase.getTestSteps() * testCase.getRepetitions(); // Account for repetitions
                totalTestSteps += testSteps;

                if (!testCase.isDisabled()) {
                    executableTestSteps += testSteps;
                } else {
                    disabledTestSteps += testSteps;
                }

                if (testCase.getRepetitions() > 1) {
                    repeatingTestSteps += testCase.getTestSteps() * testCase.getRepetitions();
                }
            }
        }

        // Set Remaining Test Cases and Remaining Test Steps
        remainingTestCases = executableTestCases - completedTestCases;
        remainingTestSteps = executableTestSteps - completedTestSteps;

        // Wright the summary metrics to the FW_TestRun object
        testRun.setTotalTestSuites(totalTestSuites);
        testRun.setTotalTestCases(totalTestCases);
        testRun.setTotalTestSteps(totalTestSteps);
        testRun.setExecutableTestCases(executableTestCases);
        testRun.setExecutableTestSteps(executableTestSteps);
        testRun.setRepeatingTestCases(repeatingTestCases);
        testRun.setRepeatingTestSteps(repeatingTestSteps);
        testRun.setDisabledTestCases(disabledTestCases);
        testRun.setDisabledTestSteps(disabledTestSteps);
        testRun.setCompletedTestCases(completedTestCases);
        testRun.setCompletedTestSteps(completedTestSteps);
        testRun.setCompletedTestSuites(completedTestSuites);
        testRun.setRemainingTestCases(remainingTestCases);
        testRun.setRemainingTestSteps(remainingTestSteps);
        testRun.setRemainingTestSuites(remainingTestSuites);
        testRun.setPassedTestCases(passedTestCases);
        testRun.setPassedTestSteps(passedTestSteps);
        testRun.setPassedTestSuites(passedTestSuites);
        testRun.setFailedTestCases(failedTestCases);
        testRun.setFailedTestSteps(failedTestSteps);
        testRun.setFailedTestSuites(failedTestSuites);
        testRun.setTotalRunTime(totalRunTime);

        return testRun;
    }

    /**
     * Counts the number of test steps in a method by analyzing the method body.
     *
     * @param method The method to analyze.
     * @return The number of test steps.
     */
    private static int countTestSteps(Method method) {
        int testSteps = 0;
        try {
            // Use JavaParser to get the method body as a string
            FW_Class parsedClass = FW_JavaFileParser.parseJavaFile("src/test/java/" + method.getDeclaringClass().getSimpleName() + ".java");
            if (parsedClass != null) {
                for (FW_Method fwMethod : parsedClass.getMethods()) {
                    if (fwMethod.getMethodName().equals(method.getName())) {
                        String methodBody = fwMethod.getMethodBody();
                        // Count the occurrences of "FW_CustomAssertJU" in the method body
                        testSteps = methodBody.split("FW_CustomAssertJU").length - 1;
                        break;
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Error while counting test steps: " + e.getMessage());
            e.printStackTrace();
        }
        return testSteps;
    }

}