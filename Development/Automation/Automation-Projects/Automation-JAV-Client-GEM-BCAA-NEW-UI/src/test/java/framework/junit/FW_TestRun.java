package framework.junit;
/**
 * @file FW_TestRun.java
 * @description Represents the details of a test run.
 * 
 * This file contains the FW_TestRun class which represents the details of a test run, including initiation details, environment details,
 * and metrics for test suites, test cases, and test steps. It provides methods to get and set these details, as well as methods to
 * calculate and summarize test run metrics.
 * 
 * The FW_TestRun class offers functionalities to:
 * - Get and set initiation details, environment details, and metrics for test suites, test cases, and test steps.
 * - Calculate and summarize test run metrics.
 * 
 * This class is designed to encapsulate the details of a test run and provide utility methods for working with test run metrics.
 */

// Import the required Java libraries
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.TestInfo;

import framework.utilities.FW_ConfigMgr;
import framework.utilities.FW_SystemUtils;

/**
 * Represents the details of a test run.
 */
public class FW_TestRun {

    // Singleton instance of FW_TestRun
    private static FW_TestRun instance;

    // Test Initiation details
    private String testRunDate; // Date when the test run was initiated
    private String testRunTime; // Time when the test run was initiated
    private String testRunTimezone; // Timezone where the test run was from
    private String testRunLocation; // Location where the test run was initiated
    private String testRunRepositoryName; // Name of the repository where the tests are stored

    // Test Environment details
    private String testExecutionHostname; // Hostname of the machine where the tests are executed
    private String testExecutionLocalIP; // Local IP Address where the tests are executed
    private String testExecutionPublicIP; // Public IP Address where the tests are executed
    private String testExecutionMAC; // MAC Address of the machine where the tests are executed
    private String testExecutionUser; // User who executed the tests
    private String testExecutionPlatform; // Platform (mac, windows, linux)
    private String testExecutionOSVersion; // Operating System (mac, windows, linux)
    private String testExecutionBrowser; // Browser (chrome, firefox, safari)
    private String testExecutionBrowserVersion; // Browser version

    // Client, Project & Application details
    private String clientRefID; // Name of the client
    private String projectRefID; // Name of the project
    private String applicationRefID; // Name of the application

    // Test Run details
    private String testRunRefID; // Unique identifier for the test run
    private String testRunDurationHR; // Duration in Human Readable format
    private long testRunDurationMS; // Duration in milliseconds

    // Test Suite details
    private List<FW_TestSuite> testSuites; // List of test suites
    private int testSuitesTotal; // count of total test suites
    private int testSuitesCompleted; // count of completed test suites
    private int testSuitesRemaining; // count of remaining test suites
    private int testSuitesPassed; // count of passed test suites
    private int testSuitesFailed; // count of failed test suites

    // Test Case details
    private int testCasesTotal; // count of total test cases
    private int testCasesExecutable; // count of executable test cases
    private int testCasesRepeating; // count of repeating test cases
    private int testCasesParameterized; // count of parameterized test cases
    private int testCasesDisabled; // count of disabled test cases
    private int testCasesCompleted; // count of completed test cases
    private int testCasesRemaining; // count of remaining test cases
    private int testCasesPassed; // count of passed test cases
    private int testCasesFailed; // count of failed test cases

    // Test Step details
    private int testStepsTotal; // count of total test steps
    private int testStepsExecutable; // count of executable test steps
    private int testStepsRepeating; // count of repeating test steps
    private int testStepsParameterized; // count of parameterized test steps
    private int testStepsDisabled; // count of disabled test steps
    private int testStepsCompleted; // count of completed test steps
    private int testStepsRemaining; // count of remaining test steps
    private int testStepsPassed; // count of passed test steps
    private int testStepsFailed; // count of failed test steps

    // Current Execution details
    private String currentTestSuiteName; // Name of the current test suite
    private String currentTestCaseName; // Name of the current test case
    private boolean currentTestCaseRepeats; // Flag to indicate if the current test case is repeatable
    private int currentTestCaseRepetition; // Repetition of the current test case
    private int currentTestCaseRepetitions; // Total repetitions for the current test case
    private boolean currentTestCaseParameterized; // Flag to indicate if the current test case is parameterized
    private int currentTestCaseParameterizedRow; // Current row for parameterized tests
    private int currentTestCaseParameterizedRows; // Total rows for parameterized tests

    /**
     * Private constructor to prevent instantiation.
     */
    private FW_TestRun() {

        // Test Initiation detail
        this.testRunDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        this.testRunTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("hh:mm:ss a"));
        this.testRunTimezone = FW_SystemUtils.getTimezone();
        this.testRunLocation = FW_SystemUtils.pathPresentDirectory();
        this.testRunRepositoryName = FW_SystemUtils.presentProjectFolder();

        // Test Environment details
        this.testExecutionHostname = FW_SystemUtils.getHostName();
        this.testExecutionLocalIP = FW_SystemUtils.getLocalIPAddress();
        this.testExecutionPublicIP = FW_SystemUtils.getPublicIPAddress();
        this.testExecutionMAC = FW_SystemUtils.getMACAddress();
        this.testExecutionUser = FW_SystemUtils.getUserName();
        this.testExecutionPlatform = FW_SystemUtils.getPlatform();
        this.testExecutionOSVersion = FW_SystemUtils.getOSVersion();
        this.testExecutionBrowser = FW_SystemUtils.getBrowserName();
        this.testExecutionBrowserVersion = FW_SystemUtils.getBrowserVersion();

        // Client, Project & Application details
        this.clientRefID = FW_ConfigMgr.getClientRefID();
        this.projectRefID = FW_ConfigMgr.getProjectRefID();
        this.applicationRefID = FW_ConfigMgr.getApplicationRefID();

        // Test Run details
        this.testRunRefID = "trid-" + UUID.randomUUID().toString(); // Generate a unique UUID for testRunRefID
        this.testRunDurationHR = ""; // Placeholder for the test run duration in Human Readable format
        this.testRunDurationMS = 0l; // Placeholder for the test run duration in milliseconds

        // Test Suite details
        this.testSuites = new ArrayList<>();
        this.testSuitesTotal = 0;
        this.testSuitesCompleted = 0;
        this.testSuitesRemaining = 0;
        this.testSuitesPassed = 0;
        this.testSuitesFailed = 0;

        // Test Case details
        this.testCasesTotal = 0;
        this.testCasesExecutable = 0;
        this.testCasesRepeating = 0;
        this.testCasesParameterized = 0;
        this.testCasesDisabled = 0;
        this.testCasesCompleted = 0;
        this.testCasesRemaining = 0;
        this.testCasesPassed = 0;
        this.testCasesFailed = 0;

        // Test Step details
        this.testStepsTotal = 0;
        this.testStepsExecutable = 0;
        this.testStepsRepeating = 0;
        this.testStepsParameterized = 0;
        this.testStepsDisabled = 0;
        this.testStepsCompleted = 0;
        this.testStepsRemaining = 0;
        this.testStepsPassed = 0;
        this.testStepsFailed = 0;

        // Current Execution details
        this.currentTestSuiteName = "";
        this.currentTestCaseName = "";
        this.currentTestCaseRepeats = false;
        this.currentTestCaseRepetition = 0;
        this.currentTestCaseRepetitions = 0;
        this.currentTestCaseParameterized = false;
        this.currentTestCaseParameterizedRow = 0;
        this.currentTestCaseParameterizedRows = 0;
    }

    /**
     * Returns the singleton instance of FW_TestRun. Utilizes the double-checked
     * locking pattern for thread safety.
     *
     * @return The singleton instance of FW_TestRun.
     */
    public static FW_TestRun getInstance() {
        if (instance == null) {
            synchronized (FW_TestRun.class) {
                if (instance == null) {
                    instance = new FW_TestRun();
                }
            }
        }
        return instance;
    }

    /**
     * Update the Current Test Run Metrics (overloaded, no RepetitionInfo).
     * Parses repetition info from TestInfo display name if present.
     *
     * @param testInfo The test information passed from the test suite.
     */
    public static void updateCurrentTestRunMetrics(TestInfo testInfo) {

        // Get the singleton instance of FW_TestRun
        String displayName = testInfo.getDisplayName();
        boolean isCurrentTestCaseRepeats = false;
        int currentRepetition = 0;
        int totalRepetitions = 0;
        boolean isCurrentTestCaseParameterized = false;
        int currentRow = 0;
        int totalRows = 0;

        // If test is repeated then parse the repetition info from the display name
        if (displayName != null && displayName.toLowerCase().contains("repetition")) {

            isCurrentTestCaseRepeats = true; // Set the current test case repeats flag

            try {
                // Use regex to split case-insensitively
                String[] parts = displayName.split("(?i)repetition");
                if (parts.length > 1) {
                    String[] nums = parts[1].trim().split("(?i)of");
                    if (nums.length == 2) {
                        currentRepetition = Integer.parseInt(nums[0].trim());
                        totalRepetitions = Integer.parseInt(nums[1].trim());
                    }
                }
            } catch (Exception e) {
                // Fallback to defaults if parsing fails
                currentRepetition = 0;
                totalRepetitions = 0;
            }
        }

        // If test is parameterized then parse the row info from the display name
        if (displayName != null && displayName.toLowerCase().contains("row")) {

            isCurrentTestCaseParameterized = true; // Set the current test case parameterized flag

            try {
                // Use regex to split case-insensitively
                String[] parts = displayName.split("(?i)row");
                if (parts.length > 0) {
                    String[] nums = parts[1].trim().split("(?i)of");
                    if (nums.length == 2) {
                        currentRow = Integer.parseInt(nums[0].trim());
                        totalRows = Integer.parseInt(nums[1].trim());
                    } else if (nums.length == 1) {
                        currentRow = Integer.parseInt(nums[0].trim());
                        totalRows = 0; // Default to 0 if only current row is specified
                    }

                }
            } catch (Exception e) {
                // Fallback to defaults if parsing fails
                currentRow = 0;
                totalRows = 0;
            }
        }

        // Update the singleton instance of FW_TestRun
        instance.setCurrentTestSuiteName(testInfo.getTestClass().get().getSimpleName());
        instance.setCurrentTestCaseName(displayName);
        instance.setCurrentTestCaseRepeats(isCurrentTestCaseRepeats);
        instance.setCurrentTestCaseRepetition(currentRepetition);
        instance.setCurrentTestCaseRepetitions(totalRepetitions);
        instance.setCurrentTestCaseParameterized(isCurrentTestCaseParameterized);
        instance.setCurrentTestCaseParameterizedRow(currentRow);
        instance.setCurrentTestCaseParameterizedRows(totalRows);

        // Print the current test run metrics to the console
        // System.out.println("Current Test Run Metrics Updated:");
        // System.out.println("Current Test Suite Name: " + instance.getCurrentTestSuiteName());
        // System.out.println("Current Test Case Name: " + instance.getCurrentTestCaseName());
        // System.out.println("Current Test Case Repeats: " + instance.isCurrentTestCaseRepeats());
        // System.out.println("Current Test Case Repetition: " + instance.getCurrentTestCaseRepetition());
        // System.out.println("Current Test Case Repetitions: " + instance.getCurrentTestCaseRepetitions());
        // System.out.println("Current Test Case Parameterized: " + instance.isCurrentTestCaseParameterized());
        // System.out.println("Current Test Case Row: " + instance.getCurrentTestCaseParameterizedRow());
        // System.out.println("Current Test Case Rows: " + instance.getCurrentTestCaseParameterizedRows());
        // System.out.println("---------------------------------------------------");
    }

    /**
     * Reset the Current Test Run Metrics
     * 
     * @param testInfo The test information passed from the test suite.
     * 
     * @return The updated test run metrics.
     */
    public static void updateCurrentTestRunMetricsReset(TestInfo testInfo) {

        // Update the singleton instance of FW_TestRun
        instance.setCurrentTestSuiteName(""); // Set the current test suite name
        instance.setCurrentTestCaseName(""); // Set the current test case name
        instance.setCurrentTestCaseRepeats(false); // Set the current test case repeats flag
        instance.setCurrentTestCaseRepetition(0); // Set the current test case repetition
        instance.setCurrentTestCaseRepetitions(0); // Set the total test case repetitions
        instance.setCurrentTestCaseParameterized(false); // Set the current test case parameterized flag
        instance.setCurrentTestCaseParameterizedRow(0); // Set the current test case row
        instance.setCurrentTestCaseParameterizedRows(0); // Set the total test case rows
    }

    /**
     * Returns a string representation of the FW_TestRun object.
     * This method is overridden to provide a detailed and readable representation
     * of the FW_TestRun object, including all its fields.
     *
     * @return A string representation of the FW_TestRun object.
     */
    @Override
    public String toString() {
        return "FW_TestRun{" +
                "testRunDate='" + testRunDate + '\'' +
                ", testRunTime='" + testRunTime + '\'' +
                ", testRunTimezone='" + testRunTimezone + '\'' +
                ", testRunLocation='" + testRunLocation + '\'' +
                ", testRunRepositoryName='" + testRunRepositoryName + '\'' +
                ", ----------------------------" + '\'' +
                ", testExecutionHostname='" + testExecutionHostname + '\'' +
                ", testExecutionLocalIP='" + testExecutionLocalIP + '\'' +
                ", testExecutionPublicIP='" + testExecutionPublicIP + '\'' +
                ", testExecutionMAC='" + testExecutionMAC + '\'' +
                ", testExecutionUser='" + testExecutionUser + '\'' +
                ", testExecutionPlatform='" + testExecutionPlatform + '\'' +
                ", testExecutionOSVersion='" + testExecutionOSVersion + '\'' +
                ", testExecutionBrowser='" + testExecutionBrowser + '\'' +
                ", testExecutionBrowserVersion='" + testExecutionBrowserVersion + '\'' +
                ", ----------------------------" + '\'' +
                ", clientRefID='" + clientRefID + '\'' +
                ", projectRefID='" + projectRefID + '\'' +
                ", applicationRefID='" + applicationRefID + '\'' +
                ", ----------------------------" + '\'' +
                ", testRunRefID='" + testRunRefID + '\'' +
                ", testRunDurationHR='" + testRunDurationHR + '\'' +
                ", testRunDurationMS='" + testRunDurationMS + '\'' +
                ", ----------------------------" + '\'' +
                ", testSuites=" + testSuites + '\'' +
                ", testSuitesTotal=" + testSuitesTotal + '\'' +
                ", testSuitesCompleted=" + testSuitesCompleted + '\'' +
                ", testSuitesRemaining=" + testSuitesRemaining + '\'' +
                ", testSuitesPassed=" + testSuitesPassed + '\'' +
                ", testSuitesFailed=" + testSuitesFailed + '\'' +
                ", ----------------------------" + '\'' +
                ", testCasesTotal=" + testCasesTotal + '\'' +
                ", testCasesExecutable=" + testCasesExecutable + '\'' +
                ", testCasesRepeating=" + testCasesRepeating + '\'' +
                ", testCasesParameterized=" + testCasesParameterized + '\'' +
                ", testCasesDisabled=" + testCasesDisabled + '\'' +
                ", testCasesCompleted=" + testCasesCompleted + '\'' +
                ", testCasesRemaining=" + testCasesRemaining + '\'' +
                ", testCasesPassed=" + testCasesPassed + '\'' +
                ", testCasesFailed=" + testCasesFailed + '\'' +
                ", ----------------------------" + '\'' +
                ", testStepsTotal=" + testStepsTotal + '\'' +
                ", testStepsExecutable=" + testStepsExecutable + '\'' +
                ", testStepsRepeating=" + testStepsRepeating + '\'' +
                ", testStepsParameterized=" + testStepsParameterized + '\'' +
                ", testStepsDisabled=" + testStepsDisabled + '\'' +
                ", testStepsCompleted=" + testStepsCompleted + '\'' +
                ", testStepsRemaining=" + testStepsRemaining + '\'' +
                ", testStepsPassed=" + testStepsPassed + '\'' +
                ", testStepsFailed=" + testStepsFailed + '\'' +
                ", ----------------------------" + '\'' +
                ", currentTestSuiteName=" + currentTestSuiteName + '\'' +
                ", currentTestCaseName=" + currentTestCaseName + '\'' +
                ", currentTestCaseRepeats=" + currentTestCaseRepeats + '\'' +
                ", currentTestCaseRepetition=" + currentTestCaseRepetition + '\'' +
                ", currentTestCaseRepetitions=" + currentTestCaseRepetitions + '\'' +
                ", currentTestCaseParameterized=" + currentTestCaseParameterized + '\'' +
                ", currentTestCaseRow=" + currentTestCaseParameterizedRow + '\'' +
                ", currentTestCaseRows=" + currentTestCaseParameterizedRows +
                '}';
    }

    // =================================================================================
    // ====================== Class - Getters and Setters - Begin ======================

    // Test Initiation details
    public String getTestRunDate() {return testRunDate;}
    public void setTestRunDate(String testRunDate) {this.testRunDate = testRunDate;}
    public String getTestRunTime() {return testRunTime;}
    public void setTestRunTime(String testRunTime) {this.testRunTime = testRunTime;}
    public String getTestRunTimezone() {return testRunTimezone;}
    public void setTestRunTimezone(String testRunTimezone) {this.testRunTimezone = testRunTimezone;}
    public String getTestRunLocation() {return testRunLocation;}
    public void setTestRunLocation(String testRunLocation) {this.testRunLocation = testRunLocation;}
    public String getTestRunRepositoryName() {return testRunRepositoryName;}
    public void setTestRunRepositoryName(String testRunRepositoryName) {this.testRunRepositoryName = testRunRepositoryName;}

    // Test Environment details
    public String getTestExecutionHostname() {return testExecutionHostname;}
    public void setTestExecutionHostname(String testExecutionHostname) {this.testExecutionHostname = testExecutionHostname;}
    public String getTestExecutionLocalIP() {return testExecutionLocalIP;}
    public void setTestExecutionLocalIP(String testExecutionLocalIP) {this.testExecutionLocalIP = testExecutionLocalIP;}
    public String getTestExecutionPublicIP() {return testExecutionPublicIP;}
    public void setTestExecutionPublicIP(String testExecutionPublicIP) {this.testExecutionPublicIP = testExecutionPublicIP;}
    public String getTestExecutionMAC() {return testExecutionMAC;}
    public void setTestExecutionMAC(String testExecutionMAC) {this.testExecutionMAC = testExecutionMAC;}
    public String getTestExecutionUser() {return testExecutionUser;}
    public void setTestExecutionUser(String testExecutionUser) {this.testExecutionUser = testExecutionUser;}
    public String getTestExecutionPlatform() {return testExecutionPlatform;}
    public void setTestExecutionPlatform(String testExecutionPlatform) {this.testExecutionPlatform = testExecutionPlatform;}
    public String getTestExecutionOSVersion() {return testExecutionOSVersion;}
    public void setTestExecutionOSVersion(String testExecutionOSVersion) {this.testExecutionOSVersion = testExecutionOSVersion;}
    public String getTestExecutionBrowser() {return testExecutionBrowser;}
    public void setTestExecutionBrowser(String testExecutionBrowser) {this.testExecutionBrowser = testExecutionBrowser;}
    public String getTestExecutionBrowserVersion() {return testExecutionBrowserVersion;}
    public void setTestExecutionBrowserVersion(String testExecutionBrowserVersion) {this.testExecutionBrowserVersion = testExecutionBrowserVersion;}

    // Client, Project & Application details
    public String getClientRefID() {return clientRefID;}
    public void setClientRefID(String clientRefID) {this.clientRefID = clientRefID;}
    public String getProjectRefID() {return projectRefID;}
    public void setProjectRefID(String projectRefID) {this.projectRefID = projectRefID;}
    public String getApplicationRefID() {return applicationRefID;}
    public void setApplicationRefID(String applicationRefID) {this.applicationRefID = applicationRefID;}

    // Test Run details
    public String getTestRunRefID() {return testRunRefID;}
    public void setTestRunRefID(String testRunRefID) {this.testRunRefID = testRunRefID;}
    public String getTestRunDurationHR() {return testRunDurationHR;}
    public void setTestRunDurationHR(String testRunDurationHR) {this.testRunDurationHR = testRunDurationHR;}
    public long getTestRunDurationMS() {return testRunDurationMS;}
    public void setTestRunDurationMS(long testRunDurationMS) {this.testRunDurationMS = testRunDurationMS;}

    // Test Suite details
    public List<FW_TestSuite> getTestSuites() {return testSuites;}
    public void setTestSuites(List<FW_TestSuite> testSuites) {this.testSuites = testSuites;}
    public int getTestSuitesTotal() {return testSuitesTotal;}
    public void setTestSuitesTotal(int testSuitesTotal) {this.testSuitesTotal = testSuitesTotal;}
    public int getTestSuitesCompleted() {return testSuitesCompleted;}
    public void setTestSuitesCompleted(int testSuitesCompleted) {this.testSuitesCompleted = testSuitesCompleted;}
    public int getTestSuitesRemaining() {return testSuitesRemaining;}
    public void setTestSuitesRemaining(int testSuitesRemaining) {this.testSuitesRemaining = testSuitesRemaining;}
    public int getTestSuitesPassed() {return testSuitesPassed;}
    public void setTestSuitesPassed(int testSuitesPassed) {this.testSuitesPassed = testSuitesPassed;}
    public int getTestSuitesFailed() {return testSuitesFailed;}
    public void setTestSuitesFailed(int testSuitesFailed) {this.testSuitesFailed = testSuitesFailed;}

    // Test Case details
    public int getTestCasesTotal() {return testCasesTotal;}
    public void setTestCasesTotal(int testCasesTotal) {this.testCasesTotal = testCasesTotal;}
    public int getTestCasesExecutable() {return testCasesExecutable;}
    public void setTestCasesExecutable(int testCasesExecutable) {this.testCasesExecutable = testCasesExecutable;}
    public int getTestCasesRepeating() {return testCasesRepeating;}
    public void setTestCasesRepeating(int testCasesRepeating) {this.testCasesRepeating = testCasesRepeating;}
    public int getTestCasesParameterized() {return testCasesParameterized;}
    public void setTestCasesParameterized(int testCasesParameterized) {this.testCasesParameterized = testCasesParameterized;}
    public int getTestCasesDisabled() {return testCasesDisabled;}
    public void setTestCasesDisabled(int testCasesDisabled) {this.testCasesDisabled = testCasesDisabled;}
    public int getTestCasesCompleted() {return testCasesCompleted;}
    public void setTestCasesCompleted(int testCasesCompleted) {this.testCasesCompleted = testCasesCompleted;}
    public int getTestCasesRemaining() {return testCasesRemaining;}
    public void setTestCasesRemaining(int testCasesRemaining) {this.testCasesRemaining = testCasesRemaining;}
    public int getTestCasesPassed() {return testCasesPassed;}
    public void setTestCasesPassed(int testCasesPassed) {this.testCasesPassed = testCasesPassed;}
    public int getTestCasesFailed() {return testCasesFailed;}
    public void setTestCasesFailed(int testCasesFailed) {this.testCasesFailed = testCasesFailed;}

    // Test Step details
    public int getTestStepsTotal() {return testStepsTotal;}
    public void setTestStepsTotal(int testStepsTotal) {this.testStepsTotal = testStepsTotal;}
    public int getTestStepsExecutable() {return testStepsExecutable;}
    public void setTestStepsExecutable(int testStepsExecutable) {this.testStepsExecutable = testStepsExecutable;}
    public int getTestStepsRepeating() {return testStepsRepeating;}
    public void setTestStepsRepeating(int testStepsRepeating) {this.testStepsRepeating = testStepsRepeating;}
    public int getTestStepsParameterized() {return testStepsParameterized;}
    public void setTestStepsParameterized(int testStepsParameterized) {this.testStepsParameterized = testStepsParameterized;}
    public int getTestStepsDisabled() {return testStepsDisabled;}
    public void setTestStepsDisabled(int testStepsDisabled) {this.testStepsDisabled = testStepsDisabled;}
    public int getTestStepsCompleted() {return testStepsCompleted;}
    public void setTestStepsCompleted(int testStepsCompleted) {this.testStepsCompleted = testStepsCompleted;}
    public int getTestStepsRemaining() {return testStepsRemaining;}
    public void setTestStepsRemaining(int testStepsRemaining) {this.testStepsRemaining = testStepsRemaining;}
    public int getTestStepsPassed() {return testStepsPassed;}
    public void setTestStepsPassed(int testStepsPassed) {this.testStepsPassed = testStepsPassed;}
    public int getTestStepsFailed() {return testStepsFailed;}
    public void setTestStepsFailed(int testStepsFailed) {this.testStepsFailed = testStepsFailed;}

    // Current Execution details
    public String getCurrentTestSuiteName() {return currentTestSuiteName;}
    public void setCurrentTestSuiteName(String currentTestSuiteName) {this.currentTestSuiteName = currentTestSuiteName;}
    public String getCurrentTestCaseName() {return currentTestCaseName;}
    public void setCurrentTestCaseName(String currentTestCaseName) {this.currentTestCaseName = currentTestCaseName;}
    public boolean isCurrentTestCaseRepeats() {return currentTestCaseRepeats;}
    public void setCurrentTestCaseRepeats(boolean currentTestCaseRepeats) {this.currentTestCaseRepeats = currentTestCaseRepeats;}
    public int getCurrentTestCaseRepetition() {return currentTestCaseRepetition;}
    public void setCurrentTestCaseRepetition(int currentTestCaseRepetition) {this.currentTestCaseRepetition = currentTestCaseRepetition;}
    public int getCurrentTestCaseRepetitions() {return currentTestCaseRepetitions;}
    public void setCurrentTestCaseRepetitions(int currentTestCaseRepetitions) {this.currentTestCaseRepetitions = currentTestCaseRepetitions;}
    public boolean isCurrentTestCaseParameterized() {return currentTestCaseParameterized;}
    public void setCurrentTestCaseParameterized(boolean currentTestCaseParameterized) {this.currentTestCaseParameterized = currentTestCaseParameterized;}
    public int getCurrentTestCaseParameterizedRow() {return currentTestCaseParameterizedRow;}
    public void setCurrentTestCaseParameterizedRow(int currentTestCaseRow) {this.currentTestCaseParameterizedRow = currentTestCaseRow;}
    public int getCurrentTestCaseParameterizedRows() {return currentTestCaseParameterizedRows;}
    public void setCurrentTestCaseParameterizedRows(int currentTestCaseRows) {this.currentTestCaseParameterizedRows = currentTestCaseRows;}

    // ====================== Class - Getters and Setters - End ======================
    // ===============================================================================

    /**
     * Add a test suite to the list of test suites.
     *
     * @param testSuite The test suite to add.
     */
    public void addTestSuites(Collection<FW_TestSuite> testSuites) {
        this.testSuites.addAll(testSuites);
    }

    /**
     * Get the Test Run summary metrics.
     *
     * @param testSuiteDetails The list of test suite details.
     * 
     * @return The summary metrics.
     */
    public static FW_TestRun getTestRunSummary(List<FW_TestSuite> testSuiteDetails) {

        // Initialize the FW_TestRun object
        FW_TestRun testRun = FW_TestRun.getInstance();

        // ====== Initialize the summary metrics - (Begin) ======

        // Test Run details
        String testRunDurationHR = "";
        long testRunDurationMS = 0l;

        // Test Suite details
        int testSuitesTotal = testSuiteDetails.size();
        int testSuitesCompleted = 0;
        int testSuitesRemaining = 0;
        int testSuitesPassed = 0;
        int testSuitesFailed = 0;

        // Test Case details
        int testCasesTotal = 0;
        int testCasesExecutable = 0;
        int testCasesRepeating = 0;
        int testCasesParameterized = 0;
        int testCasesDisabled = 0;
        int testCasesCompleted = 0;
        int testCasesRemaining = 0;
        int testCasesPassed = 0;
        int testCasesFailed = 0;

        // Test Step details
        int testStepsTotal = 0;
        int testStepsExecutable = 0;
        int testStepsRepeating = 0;
        int testStepsParameterized = 0;
        int testStepsDisabled = 0;
        int testStepsCompleted = 0;
        int testStepsRemaining = 0;
        int testStepsPassed = 0;
        int testStepsFailed = 0;

        // ====== Initialize the summary metrics - (End) ======

        // Capture totals for each test suite
        for (FW_TestSuite testSuite : testSuiteDetails) {
            testCasesTotal += testSuite.getTestCasesTotal(); // Total number of test cases
            testCasesExecutable += testSuite.getTestCasesExecutable(); // Number of executable test cases
            testCasesRepeating += testSuite.getTestCasesRepeating(); // Number of repeating test cases
            testCasesParameterized += testSuite.getTestCasesParameterized(); // Number of parameterized test cases
            testCasesDisabled += testSuite.getTestCasesDisabled(); // Number of disabled test cases

            // Get the collection of test cases from the test suite
            List<FW_TestCase> testCases = testSuite.getTestCases();

            // Loop through each test case and gather the metrics
            for (FW_TestCase testCase : testCases) {
                // Calculate the total test steps for each test case.
                int testSteps = testCase.getTestStepCount() * testCase.getTestCaseRepetitions(); // Account for repetitions

                // Add to the total number of test steps
                testStepsTotal += testSteps;

                // Calculate the totals based in the test is active or disabled.
                if (!testCase.isTestCaseDisabled()) {
                    testStepsExecutable += testSteps; // Calculate the number of executable test steps
                } else {
                    testStepsDisabled += testSteps; // Calculate the number of disabled test steps
                }

                // Calculate the number of repeating test steps
                if (testCase.getTestCaseRepetitions() > 1) {
                    testStepsRepeating += testCase.getTestStepCount() * testCase.getTestCaseRepetitions();
                }

                // Calculate the number of parameterized test steps
                if (testCase.isTestCaseParameterized()) {
                    testStepsParameterized += testCase.getTestStepCount() * testCase.getTestCaseParameterizedRows();
                }
            }
        }

        // Set Remaining Test Cases and Remaining Test Steps
        testCasesRemaining = testCasesExecutable - testCasesCompleted;
        testStepsRemaining = testStepsExecutable - testStepsCompleted;

        // ====== Write the summary metrics to the FW_TestRun object - (Begin) ======

        // Test Run details
        testRun.setTestRunDurationHR(testRunDurationHR);
        testRun.setTestRunDurationMS(testRunDurationMS);

        // Test Suite details
        testRun.setTestSuitesTotal(testSuitesTotal);
        testRun.setTestSuitesCompleted(testSuitesCompleted);
        testRun.setTestSuitesRemaining(testSuitesRemaining);
        testRun.setTestSuitesPassed(testSuitesPassed);
        testRun.setTestSuitesFailed(testSuitesFailed);

        // Test Case details
        testRun.setTestCasesTotal(testCasesTotal);
        testRun.setTestCasesExecutable(testCasesExecutable);
        testRun.setTestCasesRepeating(testCasesRepeating);
        testRun.setTestCasesParameterized(testCasesParameterized);
        testRun.setTestCasesDisabled(testCasesDisabled);
        testRun.setTestCasesCompleted(testCasesCompleted);
        testRun.setTestCasesRemaining(testCasesRemaining);
        testRun.setTestCasesPassed(testCasesPassed);
        testRun.setTestCasesFailed(testCasesFailed);

        // Test Step details
        testRun.setTestStepsTotal(testStepsTotal);
        testRun.setTestStepsExecutable(testStepsExecutable);
        testRun.setTestStepsRepeating(testStepsRepeating);
        testRun.setTestStepsParameterized(testStepsParameterized);
        testRun.setTestStepsDisabled(testStepsDisabled);
        testRun.setTestStepsCompleted(testStepsCompleted);
        testRun.setTestStepsRemaining(testStepsRemaining);
        testRun.setTestStepsPassed(testStepsPassed);
        testRun.setTestStepsFailed(testStepsFailed);

        // ====== Write the summary metrics to the FW_TestRun object - (End) ======

        return testRun;
    }
}