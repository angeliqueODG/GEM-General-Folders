package framework.junit;
/**
 * @file FW_TestSuite.java
 * @description Represents the details and metrics of a test suite.
 * 
 * This file contains the FW_TestSuite class which represents the details and metrics of a test suite, including its reference ID,
 * name, file details, and list of test cases. It provides methods to get and set these details, as well as methods to process
 * test suites and extract test cases.
 * 
 * The FW_TestSuite class offers functionalities to:
 * - Get and set the reference ID, name, file details, and list of test cases.
 * - Process test suites and extract test cases.
 * 
 * This class is designed to encapsulate the details of a test suite and provide utility methods for working with test suite details.
 */

// Import the required Java classes
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import framework.java.FW_Class;
import framework.utilities.FW_CSVUtils;
import framework.utilities.FW_ConfigMgr;
import framework.utilities.FW_ConsoleColors;
import framework.utilities.FW_FileDirUtils;
import framework.utilities.FW_FileDirUtils.FileInfo;
import framework.utilities.FW_JUnitUtils;
import framework.utilities.FW_SystemUtils;

/**
 * Represents the details and metrics of a test suite.
 */
public class FW_TestSuite {

    // Client, Project & Application details
    private String clientRefID;         // Name of the client
    private String projectRefID;        // Name of the project
    private String applicationRefID;    // Name of the application

    // Test Run details
    private String testRunRefID; // Test Run reference ID

    // Test Suite details
    private String testSuiteRefID;              // Test Suite reference ID
    private String testSuiteName;               // Test Suite name
    private String testSuiteFileName;           // Test Suite file name
    private String testSuiteFileNameExtension;  // Test Suite file name extension
    private String testSuiteFilePath;           // Test Suite file path
    private String testSuiteFilePathFileName;   // Test Suite file path and file name
    private Double testSuiteFileSizeKB;         // File size in KB
    private long testSuiteLastModified;         // Last modified timestamp
    private String testSuiteDurationHR;         // Duration in Human Readable format
    private long testSuiteDurationMS;           // Duration in milliseconds

    // Test Case details
    private List<FW_TestCase> testCases;    // List of test cases
    private int testCasesTotal;             // Total test cases - Total count of all the actual test cases including repeated and parameterized test cases each count as 1
    private int testCasesExecutable;        // Executable test cases - Total count of all executable test cases, excluding disabled or skipped parameterized test case rows.
    private int testCasesDisabled;          // Disabled test cases - Total count of all the disabled test cases, including disabled parameterized test case rows set to skip.
    private int testCasesRepeating;         // Repeating test cases - Total number of test cases that repeat ingnoring repetiton count, i.e. if a test case is repeated 5 times, it counts as 1 repeating test case.
    private int testCaseRepetition;         // The current test case repetition
    private int testCaseRepetitions;        // Total number of repetitions for the current test case
    private int testCasesParameterized;     // Total number of parameterized test cases, i.e. if a test case is parameterized with 5 rows, it counts as 1 parameterized test case.
    private int testCaseParameterizedRow;   // The current parameterized row for the test case
    private int testCaseParameterizedRows;  // Total number of parameterized rows for the current test case

    // Test Class details
    private String testClassName;               // Test Class name
    private String testClassNameFullyQualified; // Fully qualified Test Class name
    private String testClassFileName;           // Test Class file name
    private String testClassFilePath;           // Test Class file path
    private String testClassFilePathFileName;   // Test Class file path and file name

    /**
     * Constructs a new FW_TestSuite with the specified suite name.
     *
     * @param fileInfo file information object containing the test suite file details.
     * @param testRun  The test run object to which the test suite is part of.
     * 
     * @return a new FW_TestSuite instance
     */
    public FW_TestSuite(FileInfo fileInfo, FW_TestRun testRun) {

        // Client, Project & Application details
        this.clientRefID = FW_ConfigMgr.getClientRefID();
        this.projectRefID = FW_ConfigMgr.getProjectRefID();
        this.applicationRefID = FW_ConfigMgr.getApplicationRefID();

        // Test Run details
        this.testRunRefID = testRun.getTestRunRefID();

        // Test Suite details
        this.testSuiteRefID = "tsid-" + UUID.randomUUID().toString(); // Generate a unique UUID for stepRefID
        this.testSuiteName = fileInfo.getFileName().replace(".java", "");
        this.testSuiteFileName = fileInfo.getFileName();
        this.testSuiteFileNameExtension = fileInfo.getFileExtension();
        this.testSuiteFilePath = fileInfo.getFilePath();
        this.testSuiteFilePathFileName = fileInfo.getFilePathName();
        this.testSuiteFileSizeKB = fileInfo.getFileSizeKB();
        this.testSuiteLastModified = fileInfo.getLastModified();
        this.testSuiteDurationHR = "";
        this.testSuiteDurationMS = 0l;

        // Test Case details
        this.testCases = new ArrayList<>();
        this.testCasesTotal = 0;             // Total test cases - Total count of all the actual test cases including repeated and parameterized test cases each count as 1
        this.testCasesExecutable = 0;        // Executable test cases - Total count of all executable test cases, excluding disabled or skipped parameterized test case rows.
        this.testCasesDisabled = 0;          // Disabled test cases - Total count of all the disabled test cases, including disabled parameterized test case rows set to skip.
        this.testCasesRepeating = 0;         // Repeating test cases - Total number of test cases that repeat ingnoring repetiton count, i.e. if a test case is repeated 5 times, it counts as 1 repeating test case.
        this.testCasesParameterized = 0;     // Total number of parameterized test cases, i.e. if a test case is parameterized with 5 rows, it counts as 1 parameterized test case.

        // Test Class details
        this.testClassName = fileInfo.getFileName().replace(".java", "");
        this.testClassFileName = fileInfo.getFileName().replace(".java", ".class");
        this.testClassFilePath = fileInfo.getFilePath().replace("src/test/java", "target/test-classes");
        this.testClassFilePathFileName = testClassFilePath + "/" + testClassFileName;
        this.testClassNameFullyQualified = FW_Class.generateFullyQualifiedClassName(FW_SystemUtils.pathPresentProject(),testClassFilePathFileName);
    }

    /**
     * Returns a string representation of the FW_TestSuite object. This method is overridden to provide a detailed and readable representation of the FW_TestSuite object, including all its fields.
     *
     * @return A string representation of the FW_TestSuite object.
     */
    @Override
    public String toString() {
        return "FW_TestSuite{" +
                "clientRefID='" + clientRefID + '\'' +
                ", projectRefID='" + projectRefID + '\'' +
                ", applicationRefID='" + applicationRefID + '\'' +
                ", ----------------------------" + '\'' +
                ", testRunRefID='" + testRunRefID + '\'' +
                ", ----------------------------" + '\'' +
                ", testSuiteRefID='" + testSuiteRefID + '\'' +
                ", suiteSuiteName='" + testSuiteName + '\'' +
                ", testSuiteFileName='" + testSuiteFileName + '\'' +
                ", testSuiteFileNameExtension='" + testSuiteFileNameExtension + '\'' +
                ", testSuiteFilePath='" + testSuiteFilePath + '\'' +
                ", testSuiteFilePathName='" + testSuiteFilePathFileName + '\'' +
                ", testSuiteFileSizeKB=" + testSuiteFileSizeKB +
                ", testSuiteLastModified=" + testSuiteLastModified +
                ", testSuiteDurationHR='" + testSuiteDurationHR + '\'' +
                ", testSuiteDurationMS=" + testSuiteDurationMS +
                ", ----------------------------" + '\'' +
                ", testCases=" + testCases + '\'' +
                ", testCasesTotal=" + testCasesTotal + '\'' +
                ", testCasesExecutable=" + testCasesExecutable + '\'' +
                ", testCasesDisabled=" + testCasesDisabled + '\'' +
                ", testCasesRepeating=" + testCasesRepeating + '\'' +
                ", testCasesParameterized=" + testCasesParameterized + '\'' +
                ", ----------------------------" + '\'' +
                ", testClassName='" + testClassName + '\'' +
                ", testClassNameFullyQualified='" + testClassNameFullyQualified + '\'' +
                ", testClassFileName='" + testClassFileName + '\'' +
                ", testClassFilePath='" + testClassFilePath + '\'' +
                ", testClassFilePathName='" + testClassFilePathFileName +
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
    public void setTestRunRefID(String testRunRefID) {this.testRunRefID = testRunRefID;}

    // Test Suite details
    public String getTestSuiteRefID() {return testSuiteRefID;}
    public void setTestSuiteRefID(String testSuiteRefID) {this.testSuiteRefID = testSuiteRefID;}
    public String getTestSuiteName() {return testSuiteName;}
    public void setTestSuiteName(String suiteName) {this.testSuiteName = suiteName;}
    public String getTestSuiteFileName() {return testSuiteFileName;}
    public void setTestSuiteFileName(String testSuiteFileName) {this.testSuiteFileName = testSuiteFileName;}
    public String getTestSuiteFileNameExtension() {return testSuiteFileNameExtension;}
    public void setTestSuiteFileNameExtension(String testSuiteFileNameExtension) {this.testSuiteFileNameExtension = testSuiteFileNameExtension;}
    public String getTestSuiteFilePath() {return testSuiteFilePath;}
    public void setTestSuiteFilePath(String testSuiteFilePath) {this.testSuiteFilePath = testSuiteFilePath;}
    public String getTestSuiteFilePathFileName() {return testSuiteFilePathFileName;}
    public void setTestSuiteFilePathFileName(String testSuiteFilePathFileName) {this.testSuiteFilePathFileName = testSuiteFilePathFileName;}
    public double getTestSuiteFileSizeKB() {return testSuiteFileSizeKB;}
    public void setTestSuiteFileSizeKB(Double testSuiteFileSizeKB) {this.testSuiteFileSizeKB = testSuiteFileSizeKB;}
    public long getTestSuiteLastModified() {return testSuiteLastModified;}
    public void setTestSuiteLastModified(long testSuiteLastModified) {this.testSuiteLastModified = testSuiteLastModified;}
    public String getTestSuiteDurationHR() {return testSuiteDurationHR;}
    public void setTestSuiteDurationHR(String testSuiteDurationHR) {this.testSuiteDurationHR = testSuiteDurationHR;}
    public long getTestSuiteDurationMS() {return testSuiteDurationMS;}
    public void setTestSuiteDurationMS(long testSuiteDurationMS) {this.testSuiteDurationMS = testSuiteDurationMS;}

    // Test Case details
    public List<FW_TestCase> getTestCases() {return testCases;}
    public void setTestCases(List<FW_TestCase> testCases) {this.testCases = testCases;}
    public int getTestCasesTotal() {return testCasesTotal;}
    public void setTestCasesTotal(int totalTestCount) {this.testCasesTotal = totalTestCount;}
    public int getTestCasesExecutable() {return testCasesExecutable;}
    public void setTestCasesExecutable(int executableTestCount) {this.testCasesExecutable = executableTestCount;}
    public int getTestCasesDisabled() {return testCasesDisabled;}
    public void setTestCasesDisabled(int disabledTestCount) {this.testCasesDisabled = disabledTestCount;}
    public int getTestCasesRepeating() {return testCasesRepeating;}
    public void setTestCasesRepeating(int repeatingTestCount) {this.testCasesRepeating = repeatingTestCount;}
    public int getTestCasesParameterized() {return testCasesParameterized;}
    public void setTestCasesParameterized(int testCasesParameterized) {this.testCasesParameterized = testCasesParameterized;}
    public int getTestCaseRepetition() {return testCaseRepetition;}
    public void setTestCaseRepetition(int testCaseRepetition) {this.testCaseRepetition = testCaseRepetition;}
    public int getTestCaseRepetitions() {return testCaseRepetitions;}
    public void setTestCaseRepetitions(int testCaseRepetitions) {this.testCaseRepetitions = testCaseRepetitions;}
    public int getTestCaseParameterizedRow() {return testCaseParameterizedRow;}
    public void setTestCaseParameterizedRow(int testCaseParameterizedRow) {this.testCaseParameterizedRow = testCaseParameterizedRow;}
    public int getTestCaseParameterizedRows() {return testCaseParameterizedRows;}
    public void setTestCaseParameterizedRows(int testCaseParameterizedRows) {this.testCaseParameterizedRows = testCaseParameterizedRows;}

    // Test Class details
    public String getTestClassName() {return testClassName;}
    public void setTestClassName(String testClassName) {this.testClassName = testClassName;}
    public String getTestClassNameFullyQualified() {return testClassNameFullyQualified;}
    public void setTestClassNameFullyQualified(String testClassNameFullyQualified) {this.testClassNameFullyQualified = testClassNameFullyQualified;}
    public String getTestClassFileName() {return testClassFileName;}
    public void setTestClassFileName(String testClassFileName) {this.testClassFileName = testClassFileName;}
    public String getTestClassFilePath() {return testClassFilePath;}
    public void setTestClassFilePath(String testClassFilePath) {this.testClassFilePath = testClassFilePath;}
    public String getTestClassFilePathFileName() {return testClassFilePathFileName;}
    public void setTestClassFilePathFileName(String testClassFilePathFileName) {this.testClassFilePathFileName = testClassFilePathFileName;}

    public void addTestCase(FW_TestCase testCase) {this.testCases.add(testCase);}

    // ====================== Class - Getters and Setters - End ======================
    // ===============================================================================

    /**
     * Get a collection of all the test run assets.
     *
     * @return A collection of test suite objects.
     */
    public static List<FW_TestSuite> getTestSuitesCollection(FW_TestRun testRun) {
        try {
            // Get the test suite files
            List<FileInfo> testSuiteFiles = getTestSuiteFiles(testRun);

            // Process the test suite files and get the test suite collection
            List<FW_TestSuite> testSuitesCollection = processTestSuites(testSuiteFiles, testRun);

            // Return the test suite collection
            return testSuitesCollection;

        } catch (Exception e) {
            // Handle any exceptions that occur during the execution
            System.out.println("An error occurred while scanning test classes");
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    /**
     * Get the test suite files in the 'src/test/java' directory that contain 'JUnit.java' in their names.
     *
     * @return A list of FileInfo objects representing the test suite files.
     */
    private static List<FileInfo> getTestSuiteFiles(FW_TestRun testRun) {
        try {

            String testSuiteDir = "src/test/java"; // The directory to search for test suite files

            String testSuiteFilePattern = "JUnit.java"; // The pattern to match the test suite files

            // Find the test suite files in the specified directory
            List<FileInfo> testSuiteFiles = FW_FileDirUtils.findFiles(testSuiteDir, testSuiteFilePattern, true);

            return testSuiteFiles;

        } catch (Exception e) {
            System.out.println("An error occurred while finding test suite files");
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    /**
     * Processes a list of Test Suites and retun a test suite collection.
     *
     * @param testSuiteFiles The list of test files to process.
     * 
     * @return A collection of test suites objects.
     */
    public static List<FW_TestSuite> processTestSuites(List<FileInfo> testSuiteFiles, FW_TestRun testRun) {

        // Create a collection to store the test suites collection
        List<FW_TestSuite> testSuitesCollection = new ArrayList<>();

        // Process each test suite file
        for (FileInfo fileInfo : testSuiteFiles) {

            // Process the test suite file and add the details to the collection
            testSuitesCollection.add(processTestSuite(fileInfo, testRun));
        }

        // Return the collection of test suite details
        return testSuitesCollection;
    }

    /**
     * Processes a single Test Suite file to collect test details.
     *
     * @param fileInfo The file information object containing the test suite file details.
     * 
     * @return A collection of test suite object.
     */
    private static FW_TestSuite processTestSuite(FileInfo fileInfo, FW_TestRun testRun) {

        // Initialize the test suite details
        int testCasesTotal = 0;         // Total test cases - Total count of all the actual test cases including repeated and parameterized test cases each count as 1
        int testCasesExecutable = 0;    // Executable test cases - Total count of all executable test cases, excluding disabled or skipped parameterized test case rows.
        int testCasesDisabled = 0;      // Disabled test cases - Total count of all the disabled test cases, including disabled parameterized test case rows set to skip.

        int testCasesRepeating = 0;     // Repeating test cases - Total number of test cases that repeat ingnoring repetiton count, i.e. if a test case is repeated 5 times, it counts as 1 repeating test case.
        int testCaseRepetitions = 0;    // Total number of repetitions for the current test case
        int testCaseRepetition = 0;     // The current test case repetition

        int testCasesParameterized = 0;     // Total number of parameterized test cases, i.e. if a test case is parameterized with 5 rows, it counts as 1 parameterized test case.
        int testCaseParameterizedRow = 0;   // The current parameterized row for the test case
        int testCaseParameterizedRows = 0;  // Total number of parameterized rows for the current test case
        String testCasesParameterizedCSVFileName = "";      // The CSV file name for the parameterized test case
        String testCasesParameterizedCSVFileNamePath = "";  // The CSV file path for the parameterized test case
        int testCasesParameterizedCSVFileNumLinesToSkip = 0; // The number of lines to skip in the CSV file for the parameterized test case

        // Create an FW_TestSuite object to store the test suite details
        FW_TestSuite testSuiteObj = new FW_TestSuite(fileInfo, testRun);

        // Process the test suite file
        try {

            // Validate that the compiled testSuiteObject file exists
            if (!FW_FileDirUtils.fileExists(testSuiteObj.testClassFilePathFileName)) {
                System.out.println("Compiled test-class does not exist: '" + testSuiteObj.testClassFilePathFileName + "'");
                return testSuiteObj;
            }

            // Validate that the TestSuite class exists and can be loaded
            Class<?> classRef;
            try {
                classRef = Class.forName(testSuiteObj.testClassNameFullyQualified);
            } catch (ClassNotFoundException e) {
                System.out.println(FW_ConsoleColors.RED + "Class: " + testSuiteObj.testClassNameFullyQualified + " not found." + FW_ConsoleColors.RESET);
                return testSuiteObj;
            }

            // Get all the methods in the class. These include setupTestSuite(), setupTestCase(), tearDownEach((), and tearDownTestSuite() methods.
            Method[] testSuiteMethods = classRef.getDeclaredMethods();

            // ================ Loop - Test Suite Methods - Begin ================
            for (Method testSuiteMethod : testSuiteMethods) {

                // For Debugging purposes, print the test suite method details
                // System.out.println(FW_ConsoleColors.GREENYELLOW + "  - testSuiteMethod: " + testSuiteMethod.getName() + " (Candidate)" + FW_ConsoleColors.RESET);

                // If this is not a valid test case method then skip it.
                if (!FW_JUnitUtils.isTestCase(testSuiteMethod)) {
                    continue; // Not a test case, skip to the next loop iteration
                }

                // Is this a repeated test case?
                if (FW_JUnitUtils.isRepeatedTestCase(testSuiteMethod)) {
                    testCasesRepeating = testCasesRepeating + 1; // Increment the repeating test count
                    testCaseRepetitions = FW_JUnitUtils.getRepeatedTestCaseCount(testSuiteMethod); // Record how many times this specific test case is repeated
                } else {
                    testCaseRepetitions = 1; // Since this is not a repeated test case, set the repetitions to 1
                }

                // Is this a parameterized test case?
                if (FW_JUnitUtils.isTestCaseParameterized(testSuiteMethod)) {

                    // Increment the parameterized test count
                    testCasesParameterized = testCasesParameterized + 1;

                    // Get the CSV file name
                    testCasesParameterizedCSVFileName = FW_JUnitUtils.getTestCaseParameterizedCsvFileSource(testSuiteMethod);

                    // Get the CSV file name path
                    testCasesParameterizedCSVFileNamePath = "src/test/resources" + testCasesParameterizedCSVFileName;

                    // Get the number of lines to skip in the CSV file (These are typically the column header lines)
                    testCasesParameterizedCSVFileNumLinesToSkip = FW_JUnitUtils.getTestCaseParameterizedCsvFileSourceNumLinesToSkip(testSuiteMethod);

                    // Check if the CSV file exists
                    if (!FW_FileDirUtils.fileExists(testCasesParameterizedCSVFileNamePath)) {
                        System.out.println(FW_ConsoleColors.RED + "Warning: CSV file '" + testCasesParameterizedCSVFileNamePath + "' does not exist. Skipping test case: " + testSuiteMethod.getName() + FW_ConsoleColors.RESET);
                        continue; // Skip to the next test case
                    }

                    // Get the number of rows in the CSV file
                    testCaseParameterizedRows = FW_CSVUtils.getRowCount(testCasesParameterizedCSVFileNamePath);

                    // Adjust the testCaseParameterizedRows to account for the number of lines to skip
                    testCaseParameterizedRows = testCaseParameterizedRows - testCasesParameterizedCSVFileNumLinesToSkip;

                } else
                {
                    // If this is not a parameterized test case but its critical for the loop below to work for this to be set to 1.
                    testCaseParameterizedRows = 1;
                }

                // ================ Loop - Test Case - Repetitions - Begin ================
                for (testCaseRepetition = 0; testCaseRepetition < testCaseRepetitions; testCaseRepetition++) {

                    // For Debugging purposes, print the test case details
                    // System.out.println(FW_ConsoleColors.GREENYELLOW + "    - testCaseRepetition: " + (testCaseRepetition + 1) + " of " + testCaseRepetitions + " (Begin)" + FW_ConsoleColors.RESET);

                    // ================ Loop - Test Case - Parameterized Rows - Begin ================
                    for (testCaseParameterizedRow = 0; testCaseParameterizedRow < testCaseParameterizedRows; testCaseParameterizedRow++) {

                        // For Debugging purposes, print the test case details
                        // System.out.println(FW_ConsoleColors.GREENYELLOW + "      - testCaseRepetition: " + (testCaseRepetition + 1) + " of " + testCaseRepetitions + " - testCaseParameterizedRow: " + (testCaseParameterizedRow + 1) + " of " + testCaseParameterizedRows + " (Begin)" + FW_ConsoleColors.RESET);

                        // Process and return the test case details
                        FW_TestCase testCaseObj = FW_TestCase.processTestCase(testRun, testSuiteObj, testSuiteMethod, testCaseRepetition, testCaseRepetitions, testCaseParameterizedRow, testCaseParameterizedRows);

                        // Increment the total test case count
                        testCasesTotal = testCasesTotal + 1; // Increment the total test case count by 1 for each valid test casse

                        // Increment Executable and Disabled test case counts
                        if (!testCaseObj.isTestCaseDisabled()) {
                            testCasesExecutable = testCasesExecutable + 1;
                        } else {
                            testCasesDisabled += testCasesDisabled + 1;
                        }

                        // Update the test case repetition
                        testCaseObj.setTestCaseRepetition(testCaseRepetition + 1);

                        // Add the test case to the test suite collection
                        testSuiteObj.addTestCase(testCaseObj);

                        // For Debugging purposes, print the test case details
                        // System.out.println(FW_ConsoleColors.GREENYELLOW + "      - testCaseRepetition: " + (testCaseRepetition + 1) + " of " + testCaseRepetitions + " - testCaseParameterizedRow: " + (testCaseParameterizedRow + 1) + " of " + testCaseParameterizedRows + " (End)" + FW_ConsoleColors.RESET);
                    }
                    // ================ Loop - Test Case - Parameterized Rows - End ================

                    // For Debugging purposes, print the test case details
                    // System.out.println(FW_ConsoleColors.GREENYELLOW + "    - testCaseRepetition: " + (testCaseRepetition + 1) + " of " + testCaseRepetitions + " (End)" + FW_ConsoleColors.RESET);
                }
                // ================ Loop - Test Case - Repetitions - End ================

            }
            // ================ Loop - Test Suite Methods - End ================


            // Update the test suite collection with the test counts
            testSuiteObj.setTestCasesTotal(testCasesTotal); // Total test cases
            testSuiteObj.setTestCasesExecutable(testCasesExecutable);// Total executed test cases
            testSuiteObj.setTestCasesDisabled(testCasesDisabled); // Total disabled test cases
            testSuiteObj.setTestCasesRepeating(testCasesRepeating); // Total repeating test cases
            testSuiteObj.setTestCasesParameterized(testCasesParameterized); // Total parameterized test cases

        } catch (Exception e) {
            System.out.println("Reflection error while processing test suite: " + testSuiteObj.testSuiteName);
            e.printStackTrace();
        }
        return testSuiteObj;
    }

}