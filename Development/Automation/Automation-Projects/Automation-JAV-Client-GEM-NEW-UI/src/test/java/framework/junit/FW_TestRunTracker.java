package framework.junit;

import java.util.ArrayList;
import java.util.List;

/**
 * Tracks the test run details, including test suites, test cases, and test steps.
 */
public class FW_TestRunTracker {

    private static FW_TestRunTracker instance;
    private List<FW_TestSuite> testSuites;
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
        testSuites = new ArrayList<>();
        testRun = new FW_TestRun();
        // Initialize test metadata
        initializeTestMetadata();
    }

    /**
     * Returns the singleton instance of FW_TestRunTracker.
     * 
     * @return The singleton instance of FW_TestRunTracker.
     */
    public static FW_TestRunTracker getInstance() {
        if (instance == null) {
            instance = new FW_TestRunTracker();
        }
        return instance;
    }

    /**
     * Initializes the test metadata by scanning test assets and calculating summary metrics.
     */
    private void initializeTestMetadata() {
        // Call FW_TestAssetScanner to get initial values
        List<FW_TestSuite> testSuiteDetailsCollection = FW_TestAssetScanner.scanTestAssets();
        
        // Add all test suites to the list
        testSuites.addAll(testSuiteDetailsCollection);

        // Calculate the summary metrics
        FW_TestRun initialTestRun = FW_TestAssetScanner.calculateSummary(testSuiteDetailsCollection);

        // Set initial values in testRun
        testRun.setTotalTestSuites(initialTestRun.getTotalTestSuites());
        testRun.setTotalTestCases(initialTestRun.getTotalTestCases());
        testRun.setTotalTestSteps(initialTestRun.getTotalTestSteps());
        testRun.setExecutableTestCases(initialTestRun.getExecutableTestCases());
        testRun.setExecutableTestSteps(initialTestRun.getExecutableTestSteps());
        testRun.setRepeatingTestCases(initialTestRun.getRepeatingTestCases());
        testRun.setRepeatingTestSteps(initialTestRun.getRepeatingTestSteps());
        testRun.setDisabledTestCases(initialTestRun.getDisabledTestCases());
        testRun.setDisabledTestSteps(initialTestRun.getDisabledTestSteps());
        testRun.setRemainingTestCases(initialTestRun.getExecutableTestCases());
        testRun.setRemainingTestSteps(initialTestRun.getExecutableTestSteps());
    }

    /**
     * Returns the list of test suites.
     *
     * @return The list of test suites.
     */
    public List<FW_TestSuite> getTestSuites() {
        return testSuites;
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
     * Updates the status of a test step.
     *
     * @param caseName The name of the test case.
     * @param stepName The name of the test step.
     * @param passed   Whether the test step passed.
     */
    public void updateTestStepStatus(String caseName, String stepName, boolean passed) {
        for (FW_TestSuite suite : testSuites) {
            for (FW_TestCase testCase : suite.getTestCases()) {
                if (testCase.getTestCaseName().equals(caseName)) {
                    testCase.updateStepStatus(stepName, passed);
                    return;
                }
            }
        }
    }

    /**
     * Increments the count of completed test steps.
     */
    public void incrementCompletedTestSteps() {
        testRun.setCompletedTestSteps(testRun.getCompletedTestSteps() + 1);
    }

    /**
     * Decrements the count of remaining test steps.
     */
    public void decrementRemainingTestSteps() {
        testRun.setRemainingTestSteps(testRun.getRemainingTestSteps() - 1);
    }

    /**
     * Increments the count of completed test cases.
     */
    public void incrementCompletedTestCases() {
        testRun.setCompletedTestCases(testRun.getCompletedTestCases() + 1);
    }

    /**
     * Decrements the count of remaining test cases.
     */
    public void decrementRemainingTestCases() {
        testRun.setRemainingTestCases(testRun.getRemainingTestCases() - 1);
    }

    /**
     * Increments the count of passed test cases.
     */
    public void incrementPassedTestCases() {
        testRun.setPassedTestCases(testRun.getPassedTestCases() + 1);
    }

    /**
     * Increments the count of failed test cases.
     */
    public void incrementFailedTestCases() {
        testRun.setFailedTestCases(testRun.getFailedTestCases() + 1);
    }

    /**
     * Prints all the metrics tracked by FW_TestRunTracker.
     */
    public void printMetrics() {
        System.out.println("========== Test Run Metrics ==========");
        System.out.println("Total Test Suites: " + testRun.getTotalTestSuites());
        System.out.println("Total Test Cases: " + testRun.getTotalTestCases());
        System.out.println("Total Test Steps: " + testRun.getTotalTestSteps());
        System.out.println("Executable Test Cases: " + testRun.getExecutableTestCases());
        System.out.println("Executable Test Steps: " + testRun.getExecutableTestSteps());
        System.out.println("Repeating Test Cases: " + testRun.getRepeatingTestCases());
        System.out.println("Repeating Test Steps: " + testRun.getRepeatingTestSteps());
        System.out.println("Disabled Test Cases: " + testRun.getDisabledTestCases());
        System.out.println("Disabled Test Steps: " + testRun.getDisabledTestSteps());
        System.out.println("Completed Test Cases: " + testRun.getCompletedTestCases());
        System.out.println("Completed Test Steps: " + testRun.getCompletedTestSteps());
        System.out.println("Remaining Test Cases: " + testRun.getRemainingTestCases());
        System.out.println("Remaining Test Steps: " + testRun.getRemainingTestSteps());
        System.out.println("Passed Test Cases: " + testRun.getPassedTestCases());
        System.out.println("Passed Test Steps: " + testRun.getPassedTestSteps());
        System.out.println("Failed Test Cases: " + testRun.getFailedTestCases());
        System.out.println("Failed Test Steps: " + testRun.getFailedTestSteps());
        System.out.println("Total Run Time: " + testRun.getTotalRunTime());
        System.out.println("======================================");
    }
}