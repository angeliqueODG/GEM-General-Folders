package framework.formatter;
/**
 * @file FW_TestSuiteFormatter.java
 * @description Provides methods for formatting the output of a test suite.
 * 
 * This file contains the FW_TestSuiteFormatter class which provides methods to format the output of a test suite.
 * It includes functionalities to print formatted messages before and after test cases, record test suite start and end times,
 * and print test run metrics.
 * 
 * The FW_TestSuiteFormatter class offers functionalities to:
 * - Print formatted messages before and after test cases.
 * - Record the start and end times of test suites.
 * - Print test run metrics.
 * 
 * This class is designed to enhance the readability and organization of test suite output, making it easier to track
 * the progress and results of test executions.
 */

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.TestInfo;

import framework.FW_version;
import framework.data.FW_TestStepDataCollector;
import framework.junit.FW_TestRunTracker;
import framework.utilities.FW_ConfigMgr;
import framework.utilities.FW_ConsoleColors;
import framework.utilities.FW_POMReader;
import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * This class provides methods for formatting the output of a test suite.
 */
public class FW_TestSuiteFormatter {

    // Declare a variable to store the start time
    private static long startTestSuiteTime;

    /**
     * Default constructor.
     */
    public FW_TestSuiteFormatter() {
        // Default constructor
    }

    /**
     * Records the start time of the test suite and prints a formatted message.
     *
     * @param testSuiteName the name of the test suite
     */
    public static void beforeAll(String testSuiteName) {

        // Record the start time
        startTestSuiteTime = System.nanoTime();

        // Retrieve test run metrics from FW_TestRunTracker
        FW_TestRunTracker tracker = FW_TestRunTracker.getInstance();
        int totalTestSuites = tracker.getTestRun().getTestSuitesTotal();
        int totalTestCases = tracker.getTestRun().getTestCasesTotal();
        int totalTestSteps = tracker.getTestRun().getTestStepsTotal();

        System.out.println("");
        System.out.println(FW_ConsoleColors.ORANGE + "================================================================================" + FW_ConsoleColors.RESET);
        System.out.println(FW_ConsoleColors.ORANGE + "Test Suite: " + testSuiteName + " - " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm:ss a")) + " - Begin" + FW_ConsoleColors.RESET);
        System.out.println(FW_ConsoleColors.ORANGE + "Config Version: " + FW_ConfigMgr.getVersion() + " - POM Version: " + FW_POMReader.getPomProperty("pom.version") + " - Framework Version: " + FW_version.VERSION + FW_ConsoleColors.RESET);
        System.out.println(FW_ConsoleColors.ORANGE + "Total Test Suites: " + totalTestSuites + " - Total Test Cases: " + totalTestCases + " - Total Test Steps: " + totalTestSteps + FW_ConsoleColors.RESET);
        System.out.println(FW_ConsoleColors.ORANGE + "--------------------------------------------------------------------------------" + FW_ConsoleColors.RESET);
        System.out.println("");
        System.out.println(FW_ConsoleColors.DARK_GREY + "- - - - - Synchronizing Browser and WebDriver - - - - - Begin");
        WebDriverManager.chromedriver().setup(); // Synchronize Chromedriver version with Chrome version
        System.out.println(FW_ConsoleColors.DARK_GREY + "- - - - - Synchronizing Browser and WebDriver - - - - - End" + FW_ConsoleColors.RESET);
    }

    /**
     * Prints a formatted message with the name of the test case.
     *
     * @param testInfo the TestInfo object containing information about the test
     */
    public static void beforeEach(TestInfo testInfo) {
        FW_TestRunTracker tracker = FW_TestRunTracker.getInstance();

        // Retrieve test run metrics from FW_TestRunTracker
        int executableTestCases = tracker.getTestRun().getTestCasesExecutable();
        int completedTestCases = tracker.getTestRun().getTestCasesCompleted();
        int remainingTestCases = tracker.getTestRun().getTestCasesRemaining();
        String testCaseName = tracker.getTestRun().getCurrentTestCaseName();

        // Increment the completed test cases to account for the current test case
        completedTestCases = completedTestCases + 1;

        // Print the test case name and the number of completed and remaining test cases
        System.out.println("");
        System.out.println(FW_ConsoleColors.BLUE + " - - - - Test Case: " + testCaseName + " - Executing " + completedTestCases + " of " + executableTestCases + " with " + remainingTestCases + " remaining - " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm:ss a")) + " - Begin - - - -" + FW_ConsoleColors.RESET);
    }

    /**
     * Prints a formatted message with the name of the test case.
     *
     * @param testInfo the TestInfo object containing information about the test
     */
    public static void afterEach(TestInfo testInfo) {
        FW_TestRunTracker tracker = FW_TestRunTracker.getInstance();

        // Increment the completed test cases
        tracker.incrementTestCasesCompleted();

        // Decrement the remaining test cases
        tracker.decrementTestCasesRemaining();

        // Retrieve test run metrics from FW_TestRunTracker
        int executableTestCases = tracker.getTestRun().getTestCasesExecutable();
        int completedTestCases = tracker.getTestRun().getTestCasesCompleted();
        int remainingTestCases = tracker.getTestRun().getTestCasesRemaining();
        String testCaseName = tracker.getTestRun().getCurrentTestCaseName();

        // Print the test case name and the number of completed and remaining test cases
        System.out.println(FW_ConsoleColors.BLUE + " - - - - Test Case: " + testCaseName + " - Executed " + completedTestCases + " of " + executableTestCases + " with " + remainingTestCases + " remaining - " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm:ss a")) + " - End - - - - -" + FW_ConsoleColors.RESET);
    }

    /**
     * Prints a formatted message indicating that the test case passed.
     */
    public static void testSuccess() {
        System.out.println("***************** Test Case: [Pass] *****************");
    }

    /**
     * Records the end time of the test suite, calculates the elapsed time, and
     * prints a formatted message.
     *
     * @param testSuiteName the name of the test suite
     */
    public static void afterAll(String testSuiteName) {
        // Process any remaining test steps that are in the queue
        FW_TestStepDataCollector.processRemainingTestSteps();

        // Record the end time and calculate the elapsed time
        long endTestSuiteTime = System.nanoTime();
        long elapsedTestSuiteTime = endTestSuiteTime - startTestSuiteTime;
        Duration elapsedTestSuiteDuration = Duration.ofNanos(elapsedTestSuiteTime);
        String elapsedTestSuiteDurationFormatted = String.format("%02d:%02d:%02d", elapsedTestSuiteDuration.toHoursPart(), elapsedTestSuiteDuration.toMinutesPart(), elapsedTestSuiteDuration.toSecondsPart());

        // Retrieve test run metrics from FW_TestRunTracker
        FW_TestRunTracker tracker = FW_TestRunTracker.getInstance();
        int passedTestCases = tracker.getTestRun().getTestCasesPassed();
        int failedTestCases = tracker.getTestRun().getTestCasesFailed();
        int skippedTestCases = tracker.getTestRun().getTestCasesDisabled();
        int completedTestCases = tracker.getTestRun().getTestCasesCompleted();
        int remainingTestCases = tracker.getTestRun().getTestCasesRemaining();

        System.out.println("");
        System.out.println(FW_ConsoleColors.ORANGE + "--------------------------------------------------------------------------------" + FW_ConsoleColors.RESET);
        System.out.println(FW_ConsoleColors.ORANGE + "Test Suite: " + testSuiteName + " - " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm:ss a")) + " - Elapsed:" + elapsedTestSuiteDurationFormatted + " - End" + FW_ConsoleColors.RESET);
        System.out.println(FW_ConsoleColors.ORANGE + "Passed Test Cases: " + passedTestCases + " - Failed Test Cases: " + failedTestCases + " - Skipped Test Cases: " + skippedTestCases + FW_ConsoleColors.RESET);
        System.out.println(FW_ConsoleColors.ORANGE + "Completed Test Cases: " + completedTestCases + " - Remaining Test Cases: " + remainingTestCases + FW_ConsoleColors.RESET);
        System.out.println(FW_ConsoleColors.ORANGE + "================================================================================" + FW_ConsoleColors.RESET);
        System.out.println("");
    }

    /**
     * Prints all the metrics tracked by FW_TestRunTracker.
     */
    public static void printTestRunMetrics() {
        FW_TestRunTracker tracker = FW_TestRunTracker.getInstance();
        tracker.printMetrics();
    }
}