package framework.junit;
/**
 * @file FW_TestStep.java
 * @description Represents the details of a test step within a test case.
 * 
 * This file contains the FW_TestStep class which represents the details of a test step within a test case, including its reference ID,
 * timestamp, order, page object, method, parameters, result, result details, screenshot filename, and duration. It provides methods to
 * get and set these details, as well as methods to extract test steps from a test suite method.
 * 
 * The FW_TestStep class offers functionalities to:
 * - Get and set the reference ID, timestamp, order, page object, method, parameters, result, result details, screenshot filename, and duration.
 * - Extract test steps from a test suite method.
 * 
 * This class is designed to encapsulate the details of a test step and provide utility methods for working with test step details.
 */

// Import the required Java libraries
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import framework.java.FW_Class;
import framework.java.FW_JavaFileParser;
import framework.java.FW_Method;
import framework.utilities.FW_ConfigMgr;
import framework.utilities.FW_ConsoleColors;
import framework.utilities.FW_DateTimeUtils;

/**
 * Represents the details of a test step within a test case.
 */
public class FW_TestStep implements Cloneable{

    // Client, Project & Application details
    private String clientRefID;                 // Name of the client
    private String projectRefID;                // Name of the project
    private String applicationRefID;            // Name of the application

    // Test Run details
    private String testRunRefID;                // Reference ID of the test run

    // Test Suite details
    private String testSuiteRefID;              // Reference ID of the test suite
    private String testSuiteName;               // Name of the test suite

    // Test Case details
    private String testCaseRefID;               // Reference ID of the test case
    private String testCaseName;                // Name of the test case
    private String testCaseDisplayName;         // Display name of the test case
    private String testCaseType;                // Type of the test case (e.g., Standard, Repeated, Parameterized)
    private int testCaseRepetition;             // Repetition number of this test case (Used for Express Regression)
    private int testCaseRepetitions;            // Total repetitions of the these test case (Used for Express Regression)
    private int testCaseParameterizedRow;       // Current parameterized row in this test case
    private int testCaseParameterizedRows;      // Parameterized rows in this test case

    // Test Step details
    private String testStepRefID;               // Reference ID of the test step
    private String testStepType;                // Type of the test step (e.g., Web, TraceRoute, Image Audit)
    private String testStepTimestamp;           // Timestamp of the test step in ISO 8601 format with milliseconds
    private int testStepRefOrder;               // Numerical order the test steps executed in
    private String testStepPageObject;          // Page object associated with the test step
    private String testStepMethod;              // Method associated with the test step
    private String testStepParameters;          // Parameters associated with the test step
    private String testStepResult;              // Result of the test step (e.g., "pass", "fail")
    private String testStepResultDetails;       // Details about the test step results
    private String testStepScreenshotRef;       // Reference to the screenshot taken during testing
    private String testStepScreenshotThumbRef;  // Reference to the thumbnail of the screenshot taken during testing
    private float testStepDurationHR;          // Duration in Human Readable format
    private long testStepDurationMS;            // Duration in milliseconds
    private boolean testStepExecuted;           // Flag to indicate if the test step was executed

    // Location and Network Details (New Fields)
    private double locLatitude;                 // Latitude of the network endpoint location
    private double locLongitude;                // Longitude of the network endpoint location
    private String locIPAddress;                // IP address of the network endpoint location
    private String locCountryCode;              // Country code of the network endpoint location
    private String locStateCode;                // State/Region code of the network endpoint location
    private String locCityName;                 // City name of the network endpoint location
    private Long locASN;                         // ASN of the network endpoint location
    private String locOrganizationName;         // Organization name of the network endpoint location

    /**
     * Defines the possible types of a test step.
     * This helps categorize steps for reporting and analysis.
     * Nested static enum within FW_TestStep.
     */
    public static enum TestStepType { // Defined the enum inside the class

        // Audit types, alphabetized
        AUDIT_PING("audit_ping"),
        AUDIT_SANDBOX("audit_sandbox"),
        AUDIT_SPEEDTEST("audit_speedtest"),
        AUDIT_TRACEROUTE("audit_traceroute"),

        // General action types, alphabetized
        NOTE("note"),
        SCREENSHOT("screenshot"),
        WEB("web"),
        
        // Default or fallback type
        UNKNOWN("unknown");

        private final String value;

        // Enum constructor for the constants
        TestStepType(String value) {
            this.value = value;
        }

        /**
         * Gets the String value associated with the enum constant, suitable for storing in the database schema.
         * 
         * @return The String value of the test step type.
         */
        public String getValue() {
            return value;
        }

        /**
         * Optional: Helper method to get an enum constant from its String value.
         * Useful if you ever need to convert a String from the database back to an enum.
         * @param value The String value to look up.
         * @return The corresponding TestStepType enum constant, or UNKNOWN if not found.
         */
        public static TestStepType fromValue(String value) {
            for (TestStepType type : values()) {
                if (type.value.equalsIgnoreCase(value)) { // Use equalsIgnoreCase for flexible lookup
                    return type;
                }
            }
            return UNKNOWN; // Return UNKNOWN for any value not recognized
        }
    }

    /**
     * Constructor to create an instance of the FW_TestStep class.
     *
     * @param testStepRefOrder              Numerical order the test steps executed in
     * @param testStepPageObject            Page object associated with the test step
     * @param testStepMethod                Method associated with the test step
     * @param testStepParameters            Parameters associated with the test step
     * @param testStepResult                Result of the test step (e.g., "pass", "fail")
     * @param testStepResultDetails         Details about the test step results
     * @param testStepScreenshotRef         Reference to the screenshot taken during testing
     * @param testStepScreenshotThumbRef    Reference to the thumbnail of the screenshot taken during testing
     * @param testStepDurationHR            Duration in Human Readable format
     * @param testStepDurationMS            Duration in milliseconds
     * @param testStepExecuted              Flag to indicate if the test step was executed
     * @param clientRefID                   ID of the client
     * @param projectRefID                  ID of the project
     * @param applicationRefID              ID of the application
     * @param testRunRefID                  Reference ID of the test run
     * @param testSuiteRefID                Reference ID of the test suite
     * @param testSuiteName                 Name of the test suite
     * @param testCaseRefID                 Reference ID of the test case
     * @param testCaseName                  Name of the test case
     * @param testCaseDisplayName           Display name of the test case
     * @param testCaseType                  Type of the test case (e.g., Standard, Repeated, Parameterized)
     * @param testCaseRepetition            Repetition number of this test case (Used for Express Regression)
     * @param testCaseRepetitions           Total repetitions of the these test case (Used for Express Regression)
     * @param testCaseParameterizedRow      Current parameterized row in this test case
     * @param testCaseParameterizedRows     Parameterized rows in this test case
     * @param testStepType                  Type of the test step (e.g., Web, TraceRoute, Image Audit)
     * 
     * @return An instance of the FW_TestStep class.
     */
    public FW_TestStep(
        int testStepRefOrder,
        String testStepPageObject,
        String testStepMethod,
        String testStepParameters,
        String testStepResult,
        String testStepResultDetails,
        String testStepScreenshotRef,
        String testStepScreenshotThumbRef,
        float testStepDurationHR,
        long testStepDurationMS,
        boolean testStepExecuted,
        String clientRefID,
        String projectRefID,
        String applicationRefID,
        String testRunRefID,
        String testSuiteRefID,
        String testSuiteName,
        String testCaseRefID,
        String testCaseName,
        String testCaseDisplayName,
        String testCaseType,
        int testCaseRepetition,
        int testCaseRepetitions,
        int testCaseParameterizedRow,
        int testCaseParameterizedRows,
        String testStepType
        ) {
        
        // Client, Project & Application details
        this.clientRefID = FW_ConfigMgr.getClientRefID();
        this.projectRefID = FW_ConfigMgr.getProjectRefID();
        this.applicationRefID = FW_ConfigMgr.getApplicationRefID();

        // Test Run details
        this.testRunRefID = testRunRefID;

        // Test Suite details
        this.testSuiteRefID = testSuiteRefID;
        this.testSuiteName = testSuiteName;

        // Test Case details
        this.testCaseRefID = testCaseRefID;
        this.testCaseName = testCaseName;
        this.testCaseDisplayName = testCaseDisplayName;
        this.testCaseType = testCaseType;
        this.testCaseRepetition = testCaseRepetition;
        this.testCaseRepetitions = testCaseRepetitions;
        this.testCaseParameterizedRow = testCaseParameterizedRow;
        this.testCaseParameterizedRows = testCaseParameterizedRows;

        // Test Step details
        this.testStepRefID = "tpid-" + UUID.randomUUID().toString(); // Generate a unique UUID for stepRefID
        this.testStepType = testStepType;
        this.testStepTimestamp = FW_DateTimeUtils.getCurrentTimestamp(); // Set the timestamp using the utility method
        this.testStepRefOrder = testStepRefOrder;
        this.testStepPageObject = testStepPageObject;
        this.testStepMethod = testStepMethod;
        this.testStepParameters = testStepParameters;
        this.testStepResult = testStepResult;
        this.testStepResultDetails = testStepResultDetails;
        this.testStepScreenshotRef = testStepScreenshotRef;
        this.testStepScreenshotThumbRef = testStepScreenshotThumbRef;
        this.testStepDurationHR = testStepDurationHR;
        this.testStepDurationMS = testStepDurationMS;
        this.testStepExecuted = testStepExecuted;

        // Initialize new location/network fields to default values
        this.locLatitude = 0.0;
        this.locLongitude = 0.0;
        this.locIPAddress = "";
        this.locCountryCode = "";
        this.locStateCode = "";
        this.locCityName = "";
        this.locASN = 0L; 
        this.locOrganizationName = "";
    }


    /**
     * Create a deep copy of the current FW_TestStep object.
     * 
     * @return A new instance of FW_TestStep with the same values as the current object.
     */
    @Override
    public FW_TestStep clone() {
        try {
            return (FW_TestStep) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError("Cloning not supported", e);
        }
    }

    /**
     * Returns a string representation of the FW_TestStep object.
     * This method is overridden to provide a detailed and readable representation
     * of the FW_TestStep object, including all its fields, with improved formatting.
     *
     * @return A string representation of the FW_TestStep object.
     */
    @Override
    public String toString() {

        String indent = "    "; // 4 spaces for indentation
        String newline = "\n"; // Newline for better formatting
        String quote = "'"; // Single quote for string values
        String className = FW_Class.extractSimpleClassName(this.getClass().getName());

        StringBuilder sb = new StringBuilder(""); // Start with a newline for better visual separation
        sb.append(className).append(newline);

        // --- Reference IDs ---
        sb.append(indent).append("Client/Project/Application IDs:").append(newline);
        sb.append(indent).append(indent).append("clientRefID=").append(quote).append(clientRefID).append(quote).append(newline);
        sb.append(indent).append(indent).append("projectRefID=").append(quote).append(projectRefID).append(quote).append(newline);
        sb.append(indent).append(indent).append("applicationRefID=").append(quote).append(applicationRefID).append(quote).append(newline);

        sb.append(indent).append("---------------------------------").append(newline);

        // --- Test Run Details ---
        sb.append(indent).append("Test Run Details:").append(newline);
        sb.append(indent).append(indent).append("testRunRefID=").append(quote).append(testRunRefID).append(quote).append(newline);

        sb.append(indent).append("---------------------------------").append(newline);

        // --- Test Suite Details ---
        sb.append(indent).append("Test Suite Details:").append(newline);
        sb.append(indent).append(indent).append("testSuiteRefID=").append(quote).append(testSuiteRefID).append(quote).append(newline);
        sb.append(indent).append(indent).append("testSuiteName=").append(quote).append(testSuiteName).append(quote).append(newline);

        sb.append(indent).append("---------------------------------").append(newline);

        // --- Test Case Details ---
        sb.append(indent).append("Test Case Details:").append(newline);
        sb.append(indent).append(indent).append("testCaseRefID=").append(quote).append(testCaseRefID).append(quote).append(newline);
        sb.append(indent).append(indent).append("testCaseName=").append(quote).append(testCaseName).append(quote).append(newline);
        sb.append(indent).append(indent).append("testCaseDisplayName=").append(quote).append(testCaseDisplayName).append(quote).append(newline);
        sb.append(indent).append(indent).append("testCaseType=").append(quote).append(testCaseType).append(quote).append(newline);
        sb.append(indent).append(indent).append("testCaseRepetition=").append(quote).append(testCaseRepetition).append(quote).append(newline);
        sb.append(indent).append(indent).append("testCaseRepetitions=").append(quote).append(testCaseRepetitions).append(quote).append(newline);
        sb.append(indent).append(indent).append("testCaseParameterizedRow=").append(quote).append(testCaseParameterizedRow).append(quote).append(newline);
        sb.append(indent).append(indent).append("testCaseParameterizedRows=").append(quote).append(testCaseParameterizedRows).append(quote).append(newline);

        sb.append(indent).append("---------------------------------").append(newline);

        // --- Test Step Details ---
        sb.append(indent).append("Test Step Details:").append(newline);
        sb.append(indent).append(indent).append("testStepRefID=").append(quote).append(testStepRefID).append(quote).append(newline);
        sb.append(indent).append(indent).append("testStepType=").append(quote).append(testStepType).append(quote).append(newline);
        sb.append(indent).append(indent).append("testStepTimestamp=").append(quote).append(testStepTimestamp).append(quote).append(newline);
        sb.append(indent).append(indent).append("testStepRefOrder=").append(quote).append(testStepRefOrder).append(quote).append(newline);
        sb.append(indent).append(indent).append("testStepPageObject=").append(quote).append(testStepPageObject).append(quote).append(newline);
        sb.append(indent).append(indent).append("testStepMethod=").append(quote).append(testStepMethod).append(quote).append(newline);
        sb.append(indent).append(indent).append("testStepParameters=").append(quote).append(testStepParameters).append(quote).append(newline);
        sb.append(indent).append(indent).append("testStepResult=").append(quote).append(testStepResult).append(quote).append(newline);
        sb.append(indent).append(indent).append("testStepResultDetails=").append(quote).append(testStepResultDetails).append(quote).append(newline);
        sb.append(indent).append(indent).append("testStepScreenshotRef=").append(quote).append(testStepScreenshotRef).append(quote).append(newline);
        sb.append(indent).append(indent).append("testStepScreenshotThumbRef=").append(quote).append(testStepScreenshotThumbRef).append(quote).append(newline);
        sb.append(indent).append(indent).append("testStepDurationHR=").append(quote).append(testStepDurationHR).append(quote).append(newline);
        sb.append(indent).append(indent).append("testStepDurationMS=").append(quote).append(testStepDurationMS).append(quote).append(newline);
        sb.append(indent).append(indent).append("testStepExecuted=").append(quote).append(testStepExecuted).append(quote).append(newline);

        sb.append(indent).append("---------------------------------").append(newline);

        // --- Location Details ---
        sb.append(indent).append("Location Details:").append(newline);
        sb.append(indent).append(indent).append("locLatitude=").append(quote).append(locLatitude).append(quote).append(newline);
        sb.append(indent).append(indent).append("locLongitude=").append(quote).append(locLongitude).append(quote).append(newline);
        sb.append(indent).append(indent).append("locIPAddress=").append(quote).append(locIPAddress).append(quote).append(newline);
        sb.append(indent).append(indent).append("locCountryCode=").append(quote).append(locCountryCode).append(quote).append(newline);
        sb.append(indent).append(indent).append("locStateCode=").append(quote).append(locStateCode).append(quote).append(newline);
        sb.append(indent).append(indent).append("locCityName=").append(quote).append(locCityName).append(quote).append(newline);
        sb.append(indent).append(indent).append("locASN=").append(quote).append(locASN).append(quote).append(newline);
        sb.append(indent).append(indent).append("locOrganizationName=").append(quote).append(locOrganizationName).append(quote);

        return sb.toString();
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

    // Test Suite details
    public void setTestRunRefID(String testRunRefID) {this.testRunRefID = testRunRefID;}

    // Test Suite details
    public String getTestSuiteRefID() {return testSuiteRefID;}
    public void setTestSuiteRefID(String testSuiteRefID) {this.testSuiteRefID = testSuiteRefID;}
    public String getTestSuiteName() {return testSuiteName;}
    public void setTestSuiteName(String testSuiteName) {this.testSuiteName = testSuiteName;}

    // Test Case details
    public String getTestCaseRefID() {return testCaseRefID;}
    public void setTestCaseRefID(String testCaseRefID) {this.testCaseRefID = testCaseRefID;}
    public String getTestCaseName() {return testCaseName;}
    public void setTestCaseName(String testCaseName) {this.testCaseName = testCaseName;}
    public String getTestCaseDisplayName() {return testCaseDisplayName;}
    public void setTestCaseDisplayName(String testCaseDisplayName) {this.testCaseDisplayName = testCaseDisplayName;}
    public String getTestCaseType() {return testCaseType;}
    public void setTestCaseType(String testCaseType) {this.testCaseType = testCaseType;}
    public int getTestCaseRepetition() {return testCaseRepetition;}
    public void setTestCaseRepetition(int testCaseRepetition) {this.testCaseRepetition = testCaseRepetition;}
    public int getTestCaseRepetitions() {return testCaseRepetitions;}
    public void setTestCaseRepetitions(int testCaseRepetitions) {this.testCaseRepetitions = testCaseRepetitions;}
    public int getTestCaseParameterizedRow() {return testCaseParameterizedRow;}
    public void setTestCaseParameterizedRow(int testCaseParameterizedRow) {this.testCaseParameterizedRow = testCaseParameterizedRow;}
    public int getTestCaseParameterizedRows() {return testCaseParameterizedRows;}
    public void setTestCaseParameterizedRows(int testCaseParameterizedRows) {this.testCaseParameterizedRows = testCaseParameterizedRows;}

    // Test Step details
    public String getTestStepRefID() {return testStepRefID;}
    public void setTestStepRefID(String testStepRefID) {this.testStepRefID = testStepRefID;}
    public String getTestStepType() {return testStepType;}
    public void setTestStepType(String testStepType) {this.testStepType = testStepType;}
    public String getTestStepTimestamp() {return testStepTimestamp;}
    public void setTestStepTimestamp(String testStepTimestamp) {this.testStepTimestamp = testStepTimestamp;}
    public int getTestStepRefOrder() {return testStepRefOrder;}
    public void setTestStepRefOrder(int testStepRefOrder) {this.testStepRefOrder = testStepRefOrder;}
    public String getTestStepPageObject() {return testStepPageObject;}
    public void setTestStepPageObject(String testStepPageObject) {this.testStepPageObject = testStepPageObject;}
    public String getTestStepMethod() {return testStepMethod;}
    public void setTestStepMethod(String testStepMethod) {this.testStepMethod = testStepMethod;}
    public String getTestStepParameters() {return testStepParameters;}
    public void setTestStepParameters(String testStepParameters) {this.testStepParameters = testStepParameters;}
    public String getTestStepResult() {return testStepResult;}
    public void setTestStepResult(String testStepResult) {this.testStepResult = testStepResult;}
    public String getTestStepResultDetails() {return testStepResultDetails;}
    public void setTestStepResultDetails(String testStepResultDetails) {this.testStepResultDetails = testStepResultDetails;}
    public String getTestStepScreenshotRef() {return testStepScreenshotRef;}
    public void setTestStepScreenshotRef(String testStepScreenshotRef) {this.testStepScreenshotRef = testStepScreenshotRef;}
    public String getTestStepScreenshotThumbRef() {return testStepScreenshotThumbRef;}
    public void setTestStepScreenshotThumbRef(String testStepScreenshotThumbRef) {this.testStepScreenshotThumbRef = testStepScreenshotThumbRef;}
    public float getTestStepDurationHR() {return testStepDurationHR;}
    public void setTestStepDurationHR(float testStepDurationHR) {this.testStepDurationHR = testStepDurationHR;}
    public long getTestStepDurationMS() {return testStepDurationMS;}
    public void setTestStepDurationMS(long testStepDurationMS) {this.testStepDurationMS = testStepDurationMS;}
    public boolean getTestStepExecuted() {return testStepExecuted;}
    public void setTestStepExecuted(boolean testStepExecuted) {this.testStepExecuted = testStepExecuted;}

    // Location and Network Details (New Fields)
    public double getLocLatitude() {return locLatitude;}
    public void setLocLatitude(double locLatitude) {this.locLatitude = locLatitude;}
    public double getLocLongitude() {return locLongitude;}
    public void setLocLongitude(double locLongitude) {this.locLongitude = locLongitude;}
    public String getLocIPAddress() {return locIPAddress;}
    public void setLocIPAddress(String locIPAddress) {this.locIPAddress = locIPAddress;}
    public String getLocCountryCode() {return locCountryCode;}
    public void setLocCountryCode(String locCountryCode) {this.locCountryCode = locCountryCode;}
    public String getLocStateCode() {return locStateCode;}
    public void setLocStateCode(String locStateCode) {this.locStateCode = locStateCode;}
    public String getLocCityName() {return locCityName;}
    public void setLocCityName(String locCityName) {this.locCityName = locCityName;}
    public Long getLocASN() {return locASN;}
    public void setLocASN(Long locASN) {this.locASN = locASN;}
    public String getLocOrganizationName() {return locOrganizationName;}
    public void setLocOrganizationName(String locOrganizationName) {this.locOrganizationName = locOrganizationName;}

    // ====================== Class - Getters and Setters - End ======================
    // ===============================================================================

    /**
     * Get the test steps from a test suite method.
     *
     * @param testCaseCollection The test case collection to analyze.
     * @param testSuiteMethod The test suite method to analyze.
     * 
     * @return A collection of test steps.
     */
    static List<FW_TestStep> getTestSteps(FW_TestCase testCaseCollection, Method testSuiteMethod) {
    
        // Create a collection to store the test steps
        List<FW_TestStep> testStepsCollection = new ArrayList<>();
    
        try {
    
            // Get the Test Suite file path
            String testSuiteFilePathFileName = testCaseCollection.getTestSuiteCollection().getTestSuiteFilePathFileName();
    
            // Parse the Test Suite file to get the test case methods
            FW_Class testSuiteParsed = FW_JavaFileParser.parseJavaFile(testSuiteFilePathFileName);
            
            // Check if the test suite was parsed successfully
            if (testSuiteParsed != null) {
    
                // Iterate through the test case methods in the test suite
                for (FW_Method testCaseMethod : testSuiteParsed.getMethods()) {
    
                    // Ensure that the test case method is part of the right test suite
                    if (testCaseMethod.getMethodName().equals(testSuiteMethod.getName())) {
    
                        // Get the test case method body as a string
                        String testCaseMethodBody = testCaseMethod.getMethodBody();
    
                        // RegEx to match Page Objects (po_) method calls
                        String testStepPageObjectMethodAndParamsRegEx = "(?i)\\b(?:" + // Non-capturing group (?: )
                                     "(" + "po_[a-zA-Z0-9_]+" + ")|" +           // Group 1: po_xxx
                                     "(" + "ao_[a-zA-Z0-9_]+" + ")|" +           // Group 2: ao_xxx
                                     "(" + "fw_audit[a-zA-Z0-9_]+" + ")|" +      // Group 3: fw_audit_xxx variable names (old style)
                                     "(" + "FW_AuditManager\\.INSTANCE\\.getAudit[a-zA-Z0-9_]+\\(\\)" + ")" + // Group 4: FW_AuditManager.INSTANCE.getAuditXxx()
                                     ")\\.(\\w+)\\((.*)\\)"; 
    
                        // Compile the patterns
                        Pattern methodCallAndParamsPattern = Pattern.compile(testStepPageObjectMethodAndParamsRegEx);
    
                        // Split the test case method body into test step rows based on newline characters
                        String[] testStepRows = testCaseMethodBody.split("\n");
    
                        // Iterate through the test step rows to extract the test step details
                        int testStepIndex = 1;
                        for (String testStepRow : testStepRows) {

                            // Trim the row to remove leading and trailing whitespace
                            testStepRow = testStepRow.trim();
    
                            // Check if the test step row contains the "FW_CustomAssertJU" keyword
                            if (testStepRow.contains("FW_CustomAssertJU")) {

                                // We use ONE matcher for method calls and parameters
                                Matcher mainMatcher = methodCallAndParamsPattern.matcher(testStepRow);
                                
                                String testStepPageObjectName = "";
                                String testStepPageObjectMethod = "";
                                String testStepPageObjectParameters = "";
    
                                if (mainMatcher.find()) {
                                    // Debugging prints (keep them for now to confirm!)
                                    // System.out.println(FW_ConsoleColors.PINK + "Matcher found a match!" + FW_ConsoleColors.RESET);
                                    // System.out.println(FW_ConsoleColors.PINK + "Full match (Group 0): " + mainMatcher.group(0) + FW_ConsoleColors.RESET);
                                    // System.out.println(FW_ConsoleColors.PINK + "Group 1 (po_): " + mainMatcher.group(1) + FW_ConsoleColors.RESET); // Should be po_ value or null
                                    // System.out.println(FW_ConsoleColors.PINK + "Group 2 (ao_): " + mainMatcher.group(2) + FW_ConsoleColors.RESET); // Should be ao_ value or null
                                    // System.out.println(FW_ConsoleColors.PINK + "Group 3 (fw_audit_old): " + mainMatcher.group(3) + FW_ConsoleColors.RESET); // Should be fw_audit_old value or null
                                    // System.out.println(FW_ConsoleColors.PINK + "Group 4 (FW_AuditManager): " + mainMatcher.group(4) + FW_ConsoleColors.RESET); // Should be FW_AuditManager value or null
                                    // System.out.println(FW_ConsoleColors.PINK + "Group 5 (Method Name): " + mainMatcher.group(5) + FW_ConsoleColors.RESET); // Should be the method name
                                    // System.out.println(FW_ConsoleColors.PINK + "Group 6 (Parameters): " + mainMatcher.group(6) + FW_ConsoleColors.RESET); // Should be the parameters

                                    // Extract the object/path part using conditional checks for the non-null group
                                    if (mainMatcher.group(1) != null) { // po_xxx (now Group 1)
                                        testStepPageObjectName = mainMatcher.group(1);
                                    } else if (mainMatcher.group(2) != null) { // ao_xxx (now Group 2)
                                        testStepPageObjectName = mainMatcher.group(2);
                                    } else if (mainMatcher.group(3) != null) { // fw_audit_xxx (old style) (now Group 3)
                                        testStepPageObjectName = mainMatcher.group(3);
                                    } else if (mainMatcher.group(4) != null) { // FW_AuditManager.INSTANCE.getAuditXxx() (new style) (now Group 4)
                                        testStepPageObjectName = mainMatcher.group(4);

                                        // Transform FW_AuditManager call to actual audit class name
                                        int lastDotIndex = testStepPageObjectName.lastIndexOf('.');
                                        int lastParenIndex = testStepPageObjectName.lastIndexOf('(');
                                        if (lastDotIndex != -1 && lastParenIndex != -1 && lastParenIndex > lastDotIndex) {
                                            String getterMethodName = testStepPageObjectName.substring(lastDotIndex + 1, lastParenIndex);
                                            // Use the FW_AuditManager's lookup method
                                            testStepPageObjectName = framework.audits.FW_AuditManager.INSTANCE.getAuditClassNameFromGetter(getterMethodName);
                                        }

                                    }

                                    // Extract the method name (Now Group 5)
                                    testStepPageObjectMethod = mainMatcher.group(5);

                                    // Extract the parameters string (Now Group 6)
                                    testStepPageObjectParameters = mainMatcher.group(6);
                                }
    
                                // Post-process cleanup - Remove leading and trailing whitespace
                                testStepPageObjectParameters = testStepPageObjectParameters.trim(); // Add this line


                                // Post-process cleanup - Remove quotes from parameters if they are wrapped in quotes.
                                if (testStepPageObjectParameters.startsWith("\"") && testStepPageObjectParameters.endsWith("\"")) {
                                    testStepPageObjectParameters = testStepPageObjectParameters.substring(1, testStepPageObjectParameters.length() - 1);
                                }

                                // Post-process cleanup - Trim any trailing ')'
                                if (testStepPageObjectParameters.endsWith(")")) { // Check if it ends with ')'
                                    // Make sure it's not the only character or an empty string before trimming
                                    if (testStepPageObjectParameters.length() > 0) {
                                        testStepPageObjectParameters = testStepPageObjectParameters.substring(0, testStepPageObjectParameters.length() - 1);
                                    }
                                }

                                // Debugging prints (keep them for now to confirm!)
                                // System.out.println(FW_ConsoleColors.PINK + "Test Step Page Object Name:" + testStepPageObjectName + FW_ConsoleColors.RESET);
                                // System.out.println(FW_ConsoleColors.PINK + "Test Step Page Object Method: " + testStepPageObjectMethod + FW_ConsoleColors.RESET);
                                // System.out.println(FW_ConsoleColors.PINK + "Test Step Page Object Parameters: " + testStepPageObjectParameters + FW_ConsoleColors.RESET);

                                // Add the test step details to the collection
                                testStepsCollection.add(new FW_TestStep(
                                    testStepIndex,
                                    testStepPageObjectName,
                                    testStepPageObjectMethod,
                                    testStepPageObjectParameters,
                                    "", // testStepResult
                                    "", // testStepResultDetails
                                    "", // testStepScreenshotRef
                                    "", // testStepScreenshotThumbRef
                                    0f, // testStepDurationHR
                                    0l, // testStepDurationMS
                                    false, // testStepExecuted
                                    testCaseCollection.getClientRefID(),
                                    testCaseCollection.getProjectRefID(),
                                    testCaseCollection.getApplicationRefID(),
                                    testCaseCollection.getTestRunRefID(),
                                    testCaseCollection.getTestSuiteRefID(),
                                    testCaseCollection.getTestSuiteName(),
                                    testCaseCollection.getTestCaseRefID(),
                                    testCaseCollection.getTestCaseName(),
                                    testCaseCollection.getTestCaseDisplayName(),
                                    testCaseCollection.getTestCaseType(),
                                    testCaseCollection.getTestCaseRepetition(),
                                    testCaseCollection.getTestCaseRepetitions(),
                                    testCaseCollection.getTestCaseParameterizedRow(),
                                    testCaseCollection.getTestCaseParameterizedRows(),
                                    ""
                                ));
                                
                                // Increment the test step index
                                testStepIndex++;
                            }
                        }
                        break;
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Error while counting test steps: " + e.getMessage());
            e.printStackTrace();
        }
        return testStepsCollection;
    }
}