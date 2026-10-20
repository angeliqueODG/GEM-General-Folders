package framework.junit;

import framework.formatter.FW_TestSuiteFormatter;

/**
 * Manages the preparation, execution, and reporting of test runs.
 */
public class FW_TestRunManager {

    private static FW_TestRunManager instance;

    /**
     * Main method for debugging purposes.
     *
     * @param args Command line arguments
     */
    public static void main(String[] args) {
        FW_TestRunManager testRunManager = FW_TestRunManager.getInstance();

        // Prepare for a test run
        testRunManager.prepareTestRun();

        // Print initial test run metrics
        //FW_TestSuiteFormatter.printTestRunMetrics();
    }

    // Private constructor to prevent instantiation
    private FW_TestRunManager() {
        
    }

    /**
     * Returns the singleton instance of FW_TestRunManager.
     *
     * @return The singleton instance of FW_TestRunManager.
     */
    public static FW_TestRunManager getInstance() {
        if (instance == null) {
            instance = new FW_TestRunManager();
        }
        return instance;
    }

    /**
     * Prepares the test run by scanning test assets and initializing the test run tracker.
     */
    public void prepareTestRun() {

        // Scan test assets (Get initial Test Run Metrics)
        FW_TestAssetScanner.scanTestAssets();

    }

}