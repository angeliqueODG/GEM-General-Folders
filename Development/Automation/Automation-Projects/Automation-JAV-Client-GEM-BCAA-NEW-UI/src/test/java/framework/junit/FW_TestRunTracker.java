package framework.junit;
/**
 * @file FW_TestRunTracker.java
 * @description Tracks the test run details, including test suites, test cases, and test steps.
 * 
 * This file contains the FW_TestRunTracker class which tracks the test run details, including test suites, test cases, and test steps.
 * It includes functionalities to initialize test metadata, increment and decrement test step and test case counts, and print test run metrics.
 * 
 * The FW_TestRunTracker class offers functionalities to:
 * - Initialize test metadata by scanning test assets and calculating summary metrics.
 * - Increment and decrement test step and test case counts.
 * - Print test run metrics.
 * 
 * This class is designed to track the overall test run process, providing detailed information about the test suites, test cases, and test steps.
 */

// Import the required Java libraries
import java.util.List;

/**
 * Tracks the test run details, including test suites, test cases, and test steps.
 */
public class FW_TestRunTracker {

    private static FW_TestRunTracker instance;
    private FW_TestRun testRun;

    /**
     * Main method for debugging purposes.
     *
     * @param args Command line arguments
     */
    public static void main(String[] args) {
        FW_TestRunTracker tracker = FW_TestRunTracker.getInstance();
        tracker.printMetrics();
    }

    // Private constructor to prevent instantiation
    private FW_TestRunTracker() {
        testRun = FW_TestRun.getInstance();
        initializeTestMetadata();
    }

    /**
     * Returns the singleton instance of FW_TestRunTracker. Utilizes the double-checked locking pattern for thread safety.
     *
     * @return The singleton instance of FW_TestRunTracker.
     */
    public static FW_TestRunTracker getInstance() {
        if (instance == null) {
            synchronized (FW_TestRunTracker.class) {
                if (instance == null) {
                    instance = new FW_TestRunTracker();
                }
            }
        }
        return instance;
    }

    /**
     * Initializes the test metadata by scanning test assets and calculating summary metrics.
     */
    public void initializeTestMetadata() {

        // Get the singleton instance of FW_TestRun
        FW_TestRun testRun = FW_TestRun.getInstance();

        // Get Test Suite Collection
        List<FW_TestSuite> testSuitesCollection = FW_TestSuite.getTestSuitesCollection(testRun);
        
        // Add all test suites to the test run collection
        testRun.getTestSuites().addAll(testSuitesCollection);

        // Add all test suites to the list
        //testSuites.addAll(testSuitesCollection);

        // Get a summary of what is included in this Test Run
        FW_TestRun startingTestRunSummary = FW_TestRun.getTestRunSummary(testSuitesCollection);

        // Set initial values in testRun
        testRun.setTestSuitesTotal(startingTestRunSummary.getTestSuitesTotal());
        testRun.setTestCasesTotal(startingTestRunSummary.getTestCasesTotal());
        testRun.setTestStepsTotal(startingTestRunSummary.getTestStepsTotal());
        testRun.setTestCasesExecutable(startingTestRunSummary.getTestCasesExecutable());
        testRun.setTestStepsExecutable(startingTestRunSummary.getTestStepsExecutable());
        testRun.setTestCasesRepeating(startingTestRunSummary.getTestCasesRepeating());
        testRun.setTestStepsRepeating(startingTestRunSummary.getTestStepsRepeating());
        testRun.setTestCasesDisabled(startingTestRunSummary.getTestCasesDisabled());
        testRun.setTestStepsDisabled(startingTestRunSummary.getTestStepsDisabled());
        testRun.setTestCasesRemaining(startingTestRunSummary.getTestCasesExecutable());
        testRun.setTestStepsRemaining(startingTestRunSummary.getTestStepsExecutable());
    }

    /**
     * Returns the test run details.
     *
     * @return The test run details.
     */
    public FW_TestRun getTestRun() {
        return testRun;
    }

    /**
     * Increments the count of completed test steps.
     */
    public void incrementTestStepsCompleted() {
        testRun.setTestStepsCompleted(testRun.getTestStepsCompleted() + 1);
    }

    /**
     * Decrements the count of remaining test steps.
     */
    public void decrementTestStepsRemaining() {
        testRun.setTestStepsRemaining(testRun.getTestStepsRemaining() - 1);
    }

    /**
     * Increments the count of passed test steps.
     */
    public void incrementTestStepsPassed() {
        testRun.setTestStepsPassed(testRun.getTestStepsPassed() + 1);
    }

    /**
     * Increments the count of failed test steps.
     */
    public void incrementTestStepsFailed() {
        testRun.setTestStepsFailed(testRun.getTestStepsFailed() + 1);
    }

    /**
     * Increments the count of completed test cases.
     */
    public void incrementTestCasesCompleted() {
        testRun.setTestCasesCompleted(testRun.getTestCasesCompleted() + 1);
    }

    /**
     * Decrements the count of remaining test cases.
     */
    public void decrementTestCasesRemaining() {
        testRun.setTestCasesRemaining(testRun.getTestCasesRemaining() - 1);
    }

    /**
     * Increments the count of passed test cases.
     */
    public void incrementTestCasesPassed() {
        testRun.setTestCasesPassed(testRun.getTestCasesPassed() + 1);
    }

    /**
     * Increments the count of failed test cases.
     */
    public void incrementTestCasesFailed() {
        testRun.setTestCasesFailed(testRun.getTestCasesFailed() + 1);
    }

    /**
     * Prints all the metrics tracked by FW_TestRunTracker.
     */
    public void printMetrics() {
        System.out.println("========== Test Run Metrics ==========");
        System.out.println("Test Run Date: " + testRun.getTestRunDate());
        System.out.println("Test Run Time: " + testRun.getTestRunTime());
        System.out.println("Test Run Timezone: " + testRun.getTestRunTimezone());
        System.out.println("Test Run Location: " + testRun.getTestRunLocation());
        System.out.println("Test Run Repository Name: " + testRun.getTestRunRepositoryName());
        System.out.println("--------------------------------------");
        System.out.println("Test Execution Hostname: " + testRun.getTestExecutionHostname());
        System.out.println("Test Execution Local IP: " + testRun.getTestExecutionLocalIP());
        System.out.println("Test Execution Public IP: " + testRun.getTestExecutionPublicIP());
        System.out.println("Test Execution MAC: " + testRun.getTestExecutionMAC());
        System.out.println("Test Execution User: " + testRun.getTestExecutionUser());
        System.out.println("Test Execution Platform: " + testRun.getTestExecutionPlatform());
        System.out.println("Test Execution OS Version: " + testRun.getTestExecutionOSVersion());
        System.out.println("Test Execution Browser: " + testRun.getTestExecutionBrowser());
        System.out.println("Test Execution Browser Version: " + testRun.getTestExecutionBrowserVersion());
        System.out.println("--------------------------------------");
        System.out.println("Client RefID: " + testRun.getClientRefID());
        System.out.println("Project RefID: " + testRun.getProjectRefID());
        System.out.println("Application RefID: " + testRun.getApplicationRefID());
        System.out.println("--------------------------------------");
        System.out.println("Test Run RefID: " + testRun.getTestRunRefID());
        System.out.println("Test Run DurationHR: " + testRun.getTestRunDurationHR());
        System.out.println("Test Run DurationMS: " + testRun.getTestRunDurationMS());
        System.out.println("--------------------------------------");
        System.out.println("Test Suites Total: " + testRun.getTestSuitesTotal());
        System.out.println("Test Suites Completed: " + testRun.getTestSuitesCompleted());
        System.out.println("Test Suites Remaining: " + testRun.getTestSuitesRemaining());
        System.out.println("Test Suites Passed: " + testRun.getTestSuitesPassed());
        System.out.println("Test Suites Failed: " + testRun.getTestSuitesFailed());
        System.out.println("--------------------------------------");
        System.out.println("Test Cases Total: " + testRun.getTestCasesTotal());
        System.out.println("Test Cases Executable: " + testRun.getTestCasesExecutable());
        System.out.println("Test Cases Repeating: " + testRun.getTestCasesRepeating());
        System.out.println("Test Cases Disabled: " + testRun.getTestCasesDisabled());
        System.out.println("Test Cases Completed: " + testRun.getTestCasesCompleted());
        System.out.println("Test Cases Remaining: " + testRun.getTestCasesRemaining());
        System.out.println("Test Cases Passed: " + testRun.getTestCasesPassed());
        System.out.println("Test Cases Failed: " + testRun.getTestCasesFailed());
        System.out.println("--------------------------------------");
        System.out.println("Test Steps Total: " + testRun.getTestStepsTotal());
        System.out.println("Test Steps Executable: " + testRun.getTestStepsExecutable());
        System.out.println("Test Steps Repeating: " + testRun.getTestStepsRepeating());
        System.out.println("Test Steps Disabled: " + testRun.getTestStepsDisabled());
        System.out.println("Test Steps Completed: " + testRun.getTestStepsCompleted());
        System.out.println("Test Steps Remaining: " + testRun.getTestStepsRemaining());
        System.out.println("Test Steps Passed: " + testRun.getTestStepsPassed());
        System.out.println("Test Steps Failed: " + testRun.getTestStepsFailed());
        System.out.println("======================================");
    }
}