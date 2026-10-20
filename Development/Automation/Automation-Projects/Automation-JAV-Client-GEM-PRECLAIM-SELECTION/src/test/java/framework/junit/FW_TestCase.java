package framework.junit;
/**
 * @file FW_TestCase.java
 * @description Represents the details of a test case within a test suite.
 * 
 * This file contains the FW_TestCase class which represents the details of a test case within a test suite, including its reference ID,
 * name, display name, tags, and list of test steps. It provides methods to get and set these details, as well as methods to process
 * test cases and add test steps.
 * 
 * The FW_TestCase class offers functionalities to:
 * - Get and set the reference ID, name, display name, tags, and list of test steps.
 * - Process test cases and extract relevant details.
 * - Add test steps to the test case.
 * 
 * This class is designed to encapsulate the details of a test case and provide utility methods for working with test case details.
 */

// Import the required Java classes
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;

import framework.utilities.FW_ConfigMgr;
import framework.utilities.FW_JUnitUtils;

/**
 * Represents the details of a test case within a test suite.
 */
public class FW_TestCase implements Cloneable {

    // Client, Project & Application details
    private String clientRefID; // Name of the client
    private String projectRefID; // Name of the project
    private String applicationRefID; // Name of the application

    // Test Run details
    private String testRunRefID; // Test Run reference ID

    // Test Suite details
    private String testSuiteRefID; // Test Suite reference ID
    private String testSuiteName; // Test Suite name
    private FW_TestSuite testSuiteCollection; // Test Suite collection

    // Test Case details
    private boolean isTestCase; // Is this a test case?
    private String testCaseRefID; // Test Case reference ID
    private String testCaseName; // Test Case name
    private String testCaseDisplayName; // Test Case display name
    private String testCaseType; // Type of the test case (e.g., Standard, Repeated, Parameterized)
    private String testCaseTags; // Test Case tags
    private boolean isTestCaseDisabled; // Is this test case disabled?
    private String testCaseDurationHR; // Duration in Human Readable format
    private long testCaseDurationMS; // Duration in milliseconds

    // Test Case Repetition Details
    private boolean isTestCaseRepeated; // Is this a repeated test case?
    private int testCaseRepetitions; // Number of repetitions for this test case
    private int testCaseRepetition; // This repetition number

    // Test Case Parameterization Details
    private boolean isTestCaseParameterized; // Is this a parameterized test case? (Test Driven by datasheet)
    private String testCaseParameterizedCsvFile; // The filename containing the CSV data that drives the test case
    private int testCaseParameterizedCsvFileNumLinesToSkip; // Number of lines to skip in the CSV file typical 1 for header row
    private int testCaseParameterizedRows; // Parameterized rows in this test case
    private int testCaseParameterizedRow; // Current row in the CSV file that drives the test case

    // Test Steps details
    private List<FW_TestStep> testSteps; // List of test steps

    /**
     * Constructs a new FW_TestCase with the specified details.
     *
     * @param testSuiteCollection The test suite collection to which the test case is part of
     * @param testSuiteMethod     The test suite (case) method to process
     * @param testRun             The test run object to which the test case is part of
     * 
     * @return a new FW_TestCase instance
     */
    public FW_TestCase(FW_TestRun testRun, FW_TestSuite testSuiteCollection, Method testSuiteMethod) {

        // Client, Project & Application details
        this.clientRefID = FW_ConfigMgr.getClientRefID();
        this.projectRefID = FW_ConfigMgr.getProjectRefID();
        this.applicationRefID = FW_ConfigMgr.getApplicationRefID();

        // Test Run details
        this.testRunRefID = testRun.getTestRunRefID();

        // Test Suite details
        this.testSuiteRefID = testSuiteCollection.getTestSuiteRefID();
        this.testSuiteName = testSuiteCollection.getTestSuiteName();
        this.testSuiteCollection = testSuiteCollection;

        // Test Case details
        this.isTestCase = false;
        this.testCaseRefID = "tcid-" + UUID.randomUUID().toString(); // Generate a unique UUID for stepRefID
        this.testCaseName = testSuiteMethod.getName();
        this.testCaseDisplayName = "";
        this.testCaseType = "";
        this.testCaseTags = "";
        this.isTestCaseDisabled = false;
        this.testCaseDurationHR = "";
        this.testCaseDurationMS = 0l;

        // Test Case Repetition Details
        this.isTestCaseRepeated = false;
        this.testCaseRepetitions = 0;
        this.testCaseRepetition = 0;

        // Test Case Parameterization Details
        this.isTestCaseParameterized = false;
        this.testCaseParameterizedCsvFile = "";
        this.testCaseParameterizedCsvFileNumLinesToSkip = 0;
        this.testCaseParameterizedRows = 0;
        this.testCaseParameterizedRow = 0;

        // Test Steps details
        this.testSteps = new ArrayList<>();
    }

    /**
     * Creates a clone of this FW_TestCase instance.
     *
     * @return A clone of this FW_TestCase instance.
     */
    @Override
    protected FW_TestCase clone() throws CloneNotSupportedException {

        // Create a shallow copy of this FW_TestCase instance
        FW_TestCase cloned = (FW_TestCase) super.clone();

        // Update properties that need to be unique
        cloned.testCaseRefID = UUID.randomUUID().toString(); // Generate a unique UUID for stepRefID
        
        return cloned;
    }

    /**
     * Returns a string representation of the FW_TestCase object.
     * This method is overridden to provide a detailed and readable representation
     * of the FW_TestCase object, including all its fields.
     *
     * @return A string representation of the FW_TestCase object.
     */
    @Override
    public String toString() {
        return "FW_TestCase{" +
                "clientRefID='" + clientRefID + '\'' +
                ", projectRefID='" + projectRefID + '\'' +
                ", applicationRefID='" + applicationRefID + '\'' +
                ", ----------------------------" + '\'' +
                ", testRunRefID='" + testRunRefID + '\'' +
                ", ----------------------------" + '\'' +
                ", testSuiteRefID='" + testSuiteRefID + '\'' +
                ", testSuiteName='" + testSuiteName + '\'' +
                ", testSuiteCollection=" + testSuiteCollection +
                ", ----------------------------" + '\'' +
                 ", isTestCase=" + isTestCase +
                ", testCaseRefID='" + testCaseRefID + '\'' +
                ", testCaseName='" + testCaseName + '\'' +
                ", testCaseDisplayName='" + testCaseDisplayName + '\'' +
                ", testCaseType='" + testCaseType + '\'' +
                ", testCaseTags='" + testCaseTags + '\'' +
                ", isTestCaseDisabled=" + isTestCaseDisabled + '\'' +
                ", testCaseDurationHR='" + testCaseDurationHR + '\'' +
                ", testCaseDurationMS=" + testCaseDurationMS + '\'' +
                ", ----------------------------" + '\'' +
                ", isTestCaseRepeated=" + isTestCaseRepeated + '\'' +
                ", testCaseRepetitions=" + testCaseRepetitions + '\'' +
                ", testCaseRepetition=" + testCaseRepetition + '\'' +
                ", ----------------------------" + '\'' +
                ", isTestCaseParameterized=" + isTestCaseParameterized + '\'' +
                ", testCaseParameterizedCsvFile='" + testCaseParameterizedCsvFile + '\'' +
                ", testCaseParameterizedCsvFileNumLinesToSkip=" + testCaseParameterizedCsvFileNumLinesToSkip + '\'' +
                ", testCaseParameterizedRows=" + testCaseParameterizedRows + '\'' +
                ", testCaseParameterizedRow=" + testCaseParameterizedRow + '\'' +
                ", ----------------------------" + '\'' +
                ", testSteps=" + testSteps +
                '}';
    }

    // =================================================================================
    // ====================== Class - Getters and Setters - Begin ======================

    // Client, Project & Application details
    public String getClientRefID() {return clientRefID;}
    public void setClientRefID(String clientRefID) {this.clientRefID = clientRefID;}
    public String getProjectRefID() {return projectRefID;}
    public void setProjectRefID(String projectRefID) {this.projectRefID = projectRefID;}
    public String getApplicationRefID() {return applicationRefID;}
    public void setApplicationRefID(String applicationRefID) {this.applicationRefID = applicationRefID;}

    // Test Run details
    public String getTestRunRefID() {return testRunRefID;}
    public void   setTestRunRefID(String testRunRefID) {this.testRunRefID = testRunRefID;}

    // Test Suite details
    public String getTestSuiteRefID() {return testSuiteRefID;}
    public void setTestSuiteRefID(String testSuiteRefID) {this.testSuiteRefID = testSuiteRefID;}
    public String getTestSuiteName() {return testSuiteName;}
    public void setTestSuiteName(String testSuiteName) {this.testSuiteName = testSuiteName;}
    public FW_TestSuite getTestSuiteCollection() {return testSuiteCollection;}
    public void setTestSuiteCollection(FW_TestSuite testSuiteCollection) {this.testSuiteCollection = testSuiteCollection;}

    // Test Case details
    public boolean isTestCase() {return isTestCase;}
    public void setIsTestCase(boolean isTestCase) {this.isTestCase = isTestCase;}
    public String getTestCaseRefID() {return testCaseRefID;}
    public void setTestCaseRefID(String testCaseRefID) {this.testCaseRefID = testCaseRefID;}
    public String getTestCaseName() {return testCaseName;}
    public void setTestCaseName(String testCaseName) {this.testCaseName = testCaseName;}
    public String getTestCaseDisplayName() {return testCaseDisplayName;}
    public void setTestCaseDisplayName(String testCaseDisplayName) {this.testCaseDisplayName = testCaseDisplayName;}
    public String getTestCaseType() {return testCaseType;}
    public void setTestCaseType(String testCaseType) {this.testCaseType = testCaseType;}
    public String getTestCaseTags() {return testCaseTags;}
    public void setTestCaseTags(String testCaseTags) {this.testCaseTags = testCaseTags;}
    public boolean isTestCaseDisabled() {return isTestCaseDisabled;}
    public void setTestCaseDisabled(boolean isTestCaseDisabled) {this.isTestCaseDisabled = isTestCaseDisabled;}
    public String getTestCaseDurationHR() {return testCaseDurationHR;}
    public void setTestCaseDurationHR(String testCaseDurationHR) {this.testCaseDurationHR = testCaseDurationHR;}
    public long getTestCaseDurationMS() {return testCaseDurationMS;}
    public void setTestCaseDuration(long testCaseDurationMS) {this.testCaseDurationMS = testCaseDurationMS;}

    // Test Case Repetition Details
    public boolean isTestCaseRepeated() {return isTestCaseRepeated;}
    public void setIsTestCaseRepeated(boolean isTestCaseRepeated) {this.isTestCaseRepeated = isTestCaseRepeated;}
    public int getTestCaseRepetitions() {return testCaseRepetitions;}
    public void setTestCaseRepetitions(int testCaseRepetitions) {this.testCaseRepetitions = testCaseRepetitions;}
    public int getTestCaseRepetition() {return testCaseRepetition;}
    public void setTestCaseRepetition(int testCaseRepetition) {this.testCaseRepetition = testCaseRepetition;}

    // Test Case Parameterization Details
    public boolean isTestCaseParameterized() {return isTestCaseParameterized;}
    public void setIsTestCaseParameterized(boolean isTestCaseParameterized) {this.isTestCaseParameterized = isTestCaseParameterized;}
    public String getTestCaseParameterizedCsvFile() {return testCaseParameterizedCsvFile;}
    public void setTestCaseParameterizedCsvFile(String testCaseParameterizedCsvFile) {this.testCaseParameterizedCsvFile = testCaseParameterizedCsvFile;}
    public int getTestCaseParameterizedCsvFileNumLinesToSkip() {return testCaseParameterizedCsvFileNumLinesToSkip;}
    public void setTestCaseParameterizedCsvFileNumLinesToSkip(int testCaseParameterizedCsvFileNumLinesToSkip) {this.testCaseParameterizedCsvFileNumLinesToSkip = testCaseParameterizedCsvFileNumLinesToSkip;}
    public int getTestCaseParameterizedRows() {return testCaseParameterizedRows;}
    public void setTestCaseParameterizedRows(int testCaseParameterizedRows) {this.testCaseParameterizedRows = testCaseParameterizedRows;}
    public int getTestCaseParameterizedRow() {return testCaseParameterizedRow;}
    public void setTestCaseParameterizedRow(int testCaseParameterizedRow) {this.testCaseParameterizedRow = testCaseParameterizedRow;}

    // Test Steps details
    public List<FW_TestStep> getTestSteps() {return testSteps;}
    public void setTestSteps(List<FW_TestStep> testSteps) {this.testSteps = testSteps;}

    // ====================== Class - Getters and Setters - End ======================
    // ===============================================================================

    /**
     * Adds a test step to the test steps collection.
     *
     * @param testStep the test step to add
     */
    public void addTestStep(FW_TestStep testStep) {
        this.testSteps.add(testStep);
    }

    /**
     * Returns the number of test steps in the test steps collection.
     *
     * @return the number of test steps in the test steps collection
     */
    public int getTestStepCount() {
        return testSteps.size();
    }

    /**
     * Processes the test case details from the specified test suite method.
     *
     * @param testRun                           the test run object to which the test suite is part of
     * @param testSuiteCollection               the test suite collection to which the test case is part of
     * @param testSuiteRefID                    the reference ID of the test suite
     * @param testSuiteName                     the name of the test suite
     * @param testSuiteMethod                   the test suite (case) method to process
     * @param testCaseRepetition                the repetition number of the test case
     * @param testCaseRepetitions               the total number of repetitions for the test case
     * @param testCaseParameterizedRow          the current row in the CSV file that drives the test case
     * @param testCaseParameterizedRows         the number of rows in the CSV file that drives the test case
     * 
     * @return a test case collection
     */
    public static FW_TestCase processTestCase(FW_TestRun testRun, FW_TestSuite testSuiteCollection, Method testSuiteMethod, int testCaseRepetition, int testCaseRepetitions, int testCaseParameterizedRow, int testCaseParameterizedRows) {

        String testCaseName = "";
        String testCaseNameRepeatedPortion = "";
        String testCaseNameParameterizedPortion = "";

        String testCaseNameDetailed = "";
        String testCaseNameDetailedRepeatedPortion = "";
        String testCaseNameDetailedParameterizedPortion = "";

        // Create test case object
        FW_TestCase testCaseObj = new FW_TestCase(testRun, testSuiteCollection, testSuiteMethod);

        // This is a test case so set isTestCase to true
        testCaseObj.setIsTestCase(true);

        // Get the test case name and display name
        testCaseName = testSuiteMethod.getName();
        testCaseNameDetailed = testSuiteMethod.isAnnotationPresent(DisplayName.class) ? testSuiteMethod.getAnnotation(DisplayName.class).value() : testSuiteMethod.getName();

        // Unique parameter settings for each type of test case
        if (FW_JUnitUtils.isRepeatedTestCase(testSuiteMethod) == true) {
            // This test case is repeated
            testCaseObj.setTestCaseType("Repeated"); // Set the type of the test case
            testCaseNameRepeatedPortion = "_rep_" + (testCaseRepetition + 1) + "_of_" + testCaseRepetitions; // Set name for repeated test case
            testCaseNameDetailedRepeatedPortion = " - Repetition " + (testCaseRepetition + 1) + " of " + testCaseRepetitions; // Set detailed name for repeated test case
            testCaseObj.setIsTestCaseRepeated(true); // Set repeated test case flag
            testCaseObj.setTestCaseRepetition(testCaseRepetition + 1); // Set the test case repetition number
            testCaseObj.setTestCaseRepetitions(testCaseRepetitions); // Set the total number of repetitions for this test case
        } else if (FW_JUnitUtils.isTestCaseParameterized(testSuiteMethod) == true) {
            // This test case is parameterized
            testCaseObj.setTestCaseType("Parameterized"); // Set the type of the test case
            testCaseNameParameterizedPortion = "_row_" + (testCaseParameterizedRow + 1) + "_of_" + testCaseParameterizedRows; // Set name for parameterized test case
            testCaseNameDetailedParameterizedPortion = " - Row " + (testCaseParameterizedRow + 1) + " of " + testCaseParameterizedRows; // Set detailed name for parameterized test case
            testCaseObj.setIsTestCaseParameterized(true); // Set parameterized test case flag
            testCaseObj.setTestCaseParameterizedRow(testCaseParameterizedRow + 1); // Set the current row to the next row
            testCaseObj.setTestCaseParameterizedRows(testCaseParameterizedRows); // Set the row count to the total number of rows
            testCaseObj.setTestCaseParameterizedCsvFile(FW_JUnitUtils.getTestCaseParameterizedCsvFileSource(testSuiteMethod));
            testCaseObj.setTestCaseParameterizedCsvFileNumLinesToSkip(FW_JUnitUtils.getTestCaseParameterizedCsvFileSourceNumLinesToSkip(testSuiteMethod));  
        } else {
            // This is a standard test case
            testCaseObj.setTestCaseType("Standard"); // Set the type of the test case
            testCaseNameRepeatedPortion = ""; // Set name if not repeated
            testCaseNameDetailedRepeatedPortion = ""; // Set detailed name if not repeated
            testCaseObj.setIsTestCaseRepeated(false); // Set repeated test case flag
            testCaseObj.setTestCaseRepetition(0); // Set the test case repetition number
            testCaseObj.setTestCaseRepetitions(0); // Set the total number of repetitions for this test case
            testCaseObj.setIsTestCaseParameterized(false); // Set parameterized test case flag
            testCaseObj.setTestCaseParameterizedRow(0); // Set the current row to 0
            testCaseObj.setTestCaseParameterizedRows(0); // Set the row count to 0
        }

        // Build the test case name and display name
        //testCaseObj.setTestCaseName(testCaseName + testCaseNameRepeatedPortion + testCaseNameParameterizedPortion);
        testCaseObj.setTestCaseName(testCaseName); // Use the simplified version of the test case name
        testCaseObj.setTestCaseDisplayName(testCaseNameDetailed + testCaseNameDetailedRepeatedPortion + testCaseNameDetailedParameterizedPortion);

        // For Debugging purposes, print the test case details
        // System.out.println(FW_ConsoleColors.GREENYELLOW + "      - testCaseName: " + testCaseObj.getTestCaseName() + " - testCaseDisplayName: " + testCaseObj.getTestCaseDisplayName() + " - testCaseType: " + testCaseObj.getTestCaseType() + FW_ConsoleColors.RESET);
                    
        // Get Annotation - Disabled
        boolean isTestCaseDisabled = testSuiteMethod.isAnnotationPresent(Disabled.class);
        testCaseObj.setTestCaseDisabled(isTestCaseDisabled);

        // Initialize testCaseTags
        String testCaseTags = "";

        // Capture all the tags
        Tag[] tagAnnotations = testSuiteMethod.getAnnotationsByType(Tag.class);

        // Capture all testCaseTags
        if (tagAnnotations.length > 0) {
            // Capture all testCaseTags
            Stream<Tag> tagStream = Arrays.stream(tagAnnotations); // Create a stream from the array of Tag annotations
            Stream<String> tagValuesStream = tagStream.map(Tag::value); // Map each Tag annotation to its value
            String[] tagValuesArray = tagValuesStream.toArray(String[]::new); // Collect the mapped tag values into a String array
            testCaseTags = String.join(", ", tagValuesArray); // Join the elements of the String array into a single string, separated by ", "
        }

        // Set testCaseTags
        testCaseObj.setTestCaseTags(testCaseTags);

        // Get the test steps collection from the test suite method
        List<FW_TestStep> testStepsCollection = FW_TestStep.getTestSteps(testCaseObj, testSuiteMethod);

        // Add all test step collections to the test case collection
        testStepsCollection.forEach(testCaseObj::addTestStep);

        return testCaseObj;
    }
}