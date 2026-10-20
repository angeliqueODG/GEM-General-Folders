package framework.formatter;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.junit.jupiter.api.TestInfo;
import framework.FW_version;
import framework.utilities.FW_ConfigMgr;
import framework.utilities.FW_POMReader;
import framework.junit.FW_TestRunTracker;

/**
 * This class provides methods for formatting the output of a test suite.
 */
public class FW_TestSuiteFormatter {

    // Declare ANSI escape sequences for formatting console output colors
    static String black =       "\033[0;30m";            // BLACK
    static String brown =       "\033[38;5;94m";         // BROWN
    static String red =         "\033[38;2;255;0;0m";    // RED
    static String pink =        "\033[38;2;255;193;203m";// PINK
    static String coral =       "\033[38;2;255;127;80m"; // CORAL
    static String orange =      "\033[38;2;255;165;0m";  // ORANGE
    static String yellow =      "\033[38;2;255;255;0m";  // YELLOW
    static String green =       "\033[38;2;0;128;1m";    // GREEN
    static String greenyellow = "\033[38;2;173;255;47m"; // GREEN YELLOW
    static String blue =        "\033[0;34m";            // BLUE
    static String violet =      "\033[0;35m";            // VIOLET
    static String grey =        "\033[0;37m";            // GREY
    static String darkGrey =    "\033[0;90m";            // DARK GREY
    static String white =       "\033[0;97m";            // WHITE
    static String reset =       "\033[0m";               // Text Reset

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
        int totalTestSuites = tracker.getTestRun().getTotalTestSuites();
        int totalTestCases = tracker.getTestRun().getTotalTestCases();
        int totalTestSteps = tracker.getTestRun().getTotalTestSteps();

        System.out.println("");
        System.out.println(orange + "================================================================================" + reset);
        System.out.println(orange + "Test Suite: " + testSuiteName + " - " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm:ss a")) + " - Begin" + reset);
        System.out.println(orange + "Config Version: " + FW_ConfigMgr.getVersion() + " - POM Version: " + FW_POMReader.getPomProperty("pom.version") + " - Framework Version: " + FW_version.VERSION + reset);
        System.out.println(orange + "Total Test Suites: " + totalTestSuites + " - Total Test Cases: " + totalTestCases + " - Total Test Steps: " + totalTestSteps + reset);
        System.out.println(orange + "--------------------------------------------------------------------------------" + reset);
        System.out.println("");
        System.out.println(darkGrey + "- - - - - Synchronizing Browser and WebDriver - - - - - Begin");
        WebDriverManager.chromedriver().setup(); // Synchronize Chromedriver version with Chrome version
        System.out.println(darkGrey + "- - - - - Synchronizing Browser and WebDriver - - - - - End" + reset);
    }

    /**
     * Prints a formatted message with the name of the test case.
     *
     * @param testInfo the TestInfo object containing information about the test
     */
    public static void beforeEach(TestInfo testInfo) {
        FW_TestRunTracker tracker = FW_TestRunTracker.getInstance();

        // Retrieve test run metrics from FW_TestRunTracker
        int executableTestCases = tracker.getTestRun().getExecutableTestCases();
        int completedTestCases = tracker.getTestRun().getCompletedTestCases();
        int remainingTestCases = tracker.getTestRun().getRemainingTestCases();
        String testCaseName = testInfo.getDisplayName();

        // Increment the completed test cases to account for the currrnt test case
        completedTestCases = completedTestCases + 1;

        // Print the test case name and the number of completed and remaining test cases
        System.out.println("");
        System.out.println(blue + " - - - - Test Case: " + testCaseName + " - Test: " + completedTestCases + " of " + executableTestCases + " Remain: " + remainingTestCases + " - " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm:ss a")) + " - Begin - - - -" + reset);
    }

    /**
     * Prints a formatted message with the name of the test case.
     *
     * @param testInfo the TestInfo object containing information about the test
     */
    public static void afterEach(TestInfo testInfo) {
        FW_TestRunTracker tracker = FW_TestRunTracker.getInstance();

        // Increment the completed test cases
        tracker.incrementCompletedTestCases();

        // Decrement the remaining test cases
        tracker.decrementRemainingTestCases();

        // Retrieve test run metrics from FW_TestRunTracker
        int executableTestCases = tracker.getTestRun().getExecutableTestCases();
        int completedTestCases = tracker.getTestRun().getCompletedTestCases();
        int remainingTestCases = tracker.getTestRun().getRemainingTestCases();
        String testCaseName = testInfo.getDisplayName();

        // Print the test case name and the number of completed and remaining test cases
        System.out.println(blue + " - - - - Test Case: " + testCaseName + " - Test: " + completedTestCases + " of " + executableTestCases + " Remain: " + remainingTestCases + " - " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm:ss a")) + " - End - - - - -" + reset);
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
        // Record the end time and calculate the elapsed time
        long endTestSuiteTime = System.nanoTime();
        long elapsedTestSuiteTime = endTestSuiteTime - startTestSuiteTime;
        Duration elapsedTestSuiteDuration = Duration.ofNanos(elapsedTestSuiteTime);
        String elapsedTestSuiteDurationFormatted = String.format("%02d:%02d:%02d", elapsedTestSuiteDuration.toHoursPart(), elapsedTestSuiteDuration.toMinutesPart(), elapsedTestSuiteDuration.toSecondsPart());

        // Retrieve test run metrics from FW_TestRunTracker
        FW_TestRunTracker tracker = FW_TestRunTracker.getInstance();
        int passedTestCases = tracker.getTestRun().getPassedTestCases();
        int failedTestCases = tracker.getTestRun().getFailedTestCases();
        int skippedTestCases = tracker.getTestRun().getDisabledTestCases();
        int completedTestCases = tracker.getTestRun().getCompletedTestCases();
        int remainingTestCases = tracker.getTestRun().getRemainingTestCases();

        System.out.println("");
        System.out.println(orange + "--------------------------------------------------------------------------------" + reset);
        System.out.println(orange + "Test Suite: " + testSuiteName + " - " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm:ss a")) + " - Elapsed:" + elapsedTestSuiteDurationFormatted + " - End" + reset);
        System.out.println(orange + "Passed Test Cases: " + passedTestCases + " - Failed Test Cases: " + failedTestCases + " - Skipped Test Cases: " + skippedTestCases + reset);
        System.out.println(orange + "Completed Test Cases: " + completedTestCases + " - Remaining Test Cases: " + remainingTestCases + reset);
        System.out.println(orange + "================================================================================" + reset);
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