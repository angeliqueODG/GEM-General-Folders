package framework.utilities;

import java.lang.reflect.Method;
import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

import framework.java.FW_Class;
import framework.junit.FW_TestCase;
import framework.junit.FW_TestRun;
import framework.junit.FW_TestStep;
import framework.junit.FW_TestStep.TestStepType;
import framework.junit.FW_TestSuite;

public class FW_TestStepUtils {

    /**
     * Creates a new test step with the provided result and current thread information,
     * defaulting the test step type to WEB
     * This is an overloaded method for convenience.
     *
     * @param resultCombined The combined result of the test step.
     * @param currentThread The current thread.
     *
     * @return A new instance of FW_TestStep with type defaulting to WEB_PAGE_LOAD.
     */
    public static FW_TestStep createTestStep(String resultCombined, Thread currentThread) {

        // Default test step type to WEB
        String testStepType = TestStepType.WEB.getValue();

        // Call the main createTestStep method, providing the default type of web (most common)
        return createTestStep(resultCombined, currentThread, testStepType);
    }

    /**
     * Creates a new test step with the provided result and current thread information.
     *
     * @param resultCombined The combined result of the test step.
     * @param currentThread The current thread.
     * @param testStepType The type of the test step (e.g., Web, TraceRoute, Image Audit). 
     * 
     * @return A new instance of FW_TestStep.
     */
    public static FW_TestStep createTestStep(String resultCombined, Thread currentThread, String testStepType) {

        // Get the stack trace from the current thread
        StackTraceElement[] stackTrace = currentThread.getStackTrace();

        // Determine the stackTraceIndexOffset based on what method just called this method
        int stackTraceIndexOffset = 0;

        // Check if createTestStep was what called this method
        if (stackTrace[2].getMethodName().equals("createTestStep")) {
            stackTraceIndexOffset = 1; // Skip the createTestStep method
        }
        
        // Get the class object
        Class<?> classObj;
        try {
            classObj = Class.forName(stackTrace[2 + stackTraceIndexOffset].getClassName());
        } catch (ClassNotFoundException e) {
            System.err.println(FW_ConsoleColors.YELLOW + "Error finding calling class for test step: " + e.getMessage() + FW_ConsoleColors.RESET);
            return null;
        }

        // Assemble test step data from stack trace and provided info

        // Client, Project & Application details
        String clientRefID = ""; // Placeholder for now
        String projectRefID = ""; // Placeholder for now
        String applicationRefID = ""; // Placeholder for now

        // Test Run details
        String testRunRefID = ""; // Placeholder for now

        // Test Suite details
        String testSuiteRefID = ""; // Placeholder for now
        String testSuiteName = FW_Class.extractSimpleClassName(stackTrace[3 + stackTraceIndexOffset].getClassName());

        // Test Case details
        String testCaseRefID = ""; // Placeholder for now
        String testCaseName = stackTrace[3 + stackTraceIndexOffset].getMethodName();
        String testCaseDisplayName = ""; // Placeholder for now
        String testCaseType = ""; // Placeholder for now
        int testCaseRepetition = 0; // Placeholder for now
        int testCaseRepetitions = 0; // Placeholder for now
        int testCaseParameterizedRow = 0; // Placeholder for now
        int testCaseParameterizedRows = 0; // Placeholder for now

        // Test Step details
        int testStepRefOrder = 0; // Placeholder for now
        String testStepPageObject = classObj.getSimpleName(); // Class name
        String testStepMethod = stackTrace[2 + stackTraceIndexOffset].getMethodName();
        String testStepParameters = getMethodParameterNamesAsString(classObj, stackTrace[2 + stackTraceIndexOffset].getMethodName());
        String testStepResult = FW_StringUtils.metaTag(resultCombined);
        String testStepResultDetails = FW_StringUtils.metaData(resultCombined);
        String testStepScreenshotRef = ""; // Placeholder for now
        String testStepScreenshotThumbRef = ""; // Placeholder for now
        float testStepDurationHR = Float.parseFloat(FW_StringUtils.parmDuration(resultCombined));
        long testStepDurationMS = FW_StringUtils.convertHRToMilliseconds(Float.toString(testStepDurationHR));
        boolean testStepExecuted = true;

        // Create an instance of FW_TestStep
        FW_TestStep testStepObj = new FW_TestStep(
            testStepRefOrder,
            testStepPageObject,
            testStepMethod,
            testStepParameters,
            testStepResult,
            testStepResultDetails,
            testStepScreenshotRef,
            testStepScreenshotThumbRef,
            testStepDurationHR,
            testStepDurationMS,
            testStepExecuted,
            clientRefID,
            projectRefID,
            applicationRefID,
            testRunRefID,
            testSuiteRefID,
            testSuiteName,
            testCaseRefID,
            testCaseName,
            testCaseDisplayName,
            testCaseType,
            testCaseRepetition,
            testCaseRepetitions,
            testCaseParameterizedRow,
            testCaseParameterizedRows,
            testStepType
            );

        return testStepObj;
    }

    /**
     * Duplicate a testStep within a test run object.
     * This can be useful for audits when the initial test steps are unknown at the beginning of the test run.
     * 
     * @param testSuiteName
     * @param testCaseName
     * @param testStepMethod
     * 
     * @return The duplicated test step object.
     */
    public static FW_TestStep duplicateTestStep(String testSuiteName, String testCaseName, String testStepMethod) {

        // Get testRun object instance
        FW_TestRun testRunObj = FW_TestRun.getInstance();

        // Find the Test Suite
        for (FW_TestSuite testRunTestSuite : testRunObj.getTestSuites()) {
            if (testRunTestSuite.getTestSuiteName().equals(testSuiteName)) {

                // Find the Test Case
                for (FW_TestCase testRunTestCase : testRunTestSuite.getTestCases()) {
                    if (testRunTestCase.getTestCaseName().equals(testCaseName)) {

                        // Find the Test Step Method
                        for (FW_TestStep testRunTestStep : testRunTestCase.getTestSteps()) {
                            if (testRunTestStep.getTestStepMethod().equals(testStepMethod)) {

                                // Get the test step object to duplicate
                                FW_TestStep indTestStepObj = testRunTestStep.clone();

                                // ======= Modify the indTestStepObj with the testRunTestStep values when applicable - (Begin) ======

                                // Client, Project & Application details
                                indTestStepObj.setClientRefID(testRunTestStep.getClientRefID());
                                indTestStepObj.setProjectRefID(testRunTestStep.getProjectRefID());
                                indTestStepObj.setApplicationRefID(testRunTestStep.getApplicationRefID());

                                // Test Run details
                                indTestStepObj.setTestRunRefID(testRunTestStep.getTestRunRefID());

                                // Test Suite details
                                indTestStepObj.setTestSuiteRefID(testRunTestStep.getTestSuiteRefID());
                                indTestStepObj.setTestSuiteName(testRunTestStep.getTestSuiteName());

                                // Test Case details
                                indTestStepObj.setTestCaseRefID(testRunTestStep.getTestCaseRefID());
                                indTestStepObj.setTestCaseName(testRunTestStep.getTestCaseName());
                                indTestStepObj.setTestCaseDisplayName(testRunTestStep.getTestCaseDisplayName());
                                indTestStepObj.setTestCaseType(testRunTestStep.getTestCaseType());
                                indTestStepObj.setTestCaseRepetition(testRunTestStep.getTestCaseRepetition());
                                indTestStepObj.setTestCaseRepetitions(testRunTestStep.getTestCaseRepetitions());
                                indTestStepObj.setTestCaseParameterizedRow(testRunTestStep.getTestCaseParameterizedRow());
                                indTestStepObj.setTestCaseParameterizedRows(testRunTestStep.getTestCaseParameterizedRows());

                                // Test Step details
                                indTestStepObj.setTestStepRefID("tpid-" + UUID.randomUUID().toString()); // Generate a unique UUID for stepRefID
                                indTestStepObj.setTestStepType(testRunTestStep.getTestStepType());
                                indTestStepObj.setTestStepRefOrder(testRunTestCase.getTestSteps().size() + 1);
                                indTestStepObj.setTestStepPageObject(testRunTestStep.getTestStepPageObject());
                                indTestStepObj.setTestStepMethod(testRunTestStep.getTestStepMethod());
                                indTestStepObj.setTestStepParameters(testRunTestStep.getTestStepParameters());
                                indTestStepObj.setTestStepResult("");
                                indTestStepObj.setTestStepResultDetails(testRunTestStep.getTestStepResultDetails());
                                indTestStepObj.setTestStepScreenshotRef(testRunTestStep.getTestStepScreenshotRef());
                                indTestStepObj.setTestStepScreenshotThumbRef(testRunTestStep.getTestStepScreenshotThumbRef());
                                indTestStepObj.setTestStepDurationHR(0);
                                indTestStepObj.setTestStepDurationMS(0);
                                indTestStepObj.setTestStepExecuted(testRunTestStep.getTestStepExecuted());

                                // Location and Network Details (New Fields)
                                indTestStepObj.setLocLatitude(0.0);
                                indTestStepObj.setLocLongitude(0.0);
                                indTestStepObj.setLocIPAddress(testRunTestStep.getLocIPAddress());
                                indTestStepObj.setLocCountryCode(testRunTestStep.getLocCountryCode());
                                indTestStepObj.setLocStateCode(testRunTestStep.getLocStateCode());
                                indTestStepObj.setLocCityName(testRunTestStep.getLocCityName());
                                indTestStepObj.setLocASN(testRunTestStep.getLocASN());
                                indTestStepObj.setLocOrganizationName(testRunTestStep.getLocOrganizationName());

                                // ======= Modify the indTestStepObj with the testRunTestStep values when applicable - (End) ======

                                // Add the new test step to the test case
                                testRunTestCase.getTestSteps().add(indTestStepObj);

                                return indTestStepObj; // Return the duplicated test step
                        }
                    }
                    // Log if the test step method is not found
                    System.err.println("Error: Test step with method '" + testStepMethod + "' not found in test case '" + testCaseName + "'.");
                    return null;
                }
            }
            // Log if the test case is not found
            System.err.println("Error: Test case '" + testCaseName + "' not found in test suite '" + testSuiteName + "'.");
            return null;
        }
    }
    // Log if the test suite is not found
    System.err.println("Error: Test suite '" + testSuiteName + "' not found.");
    return null;
}

    /**
     * Return all test step objects for a given test run.
     * 
     * @param testRun
     * @param testStepObj
     * 
     * @return an array of test step objects.
     */
    public static FW_TestStep[] getTestSteps(FW_TestRun testRun, FW_TestStep testStepObj) {

        // Get the test suite name, test case name, and test step method name
        String testSuiteName = testStepObj.getTestSuiteName();
        String testCaseName = testStepObj.getTestCaseName();
        String testStepMethod = testStepObj.getTestStepMethod();
        boolean testCaseRepeats = testRun.isCurrentTestCaseRepeats();
        int testCaseRepetition = testRun.getCurrentTestCaseRepetition();
        boolean testCaseParameterized = testRun.isCurrentTestCaseParameterized();
        int testCaseParameterizedRow = testRun.getCurrentTestCaseParameterizedRow();
        

        // Find the Test Suite
        for (FW_TestSuite testSuite : testRun.getTestSuites()) {
            if (testSuite.getTestSuiteName().equals(testSuiteName)) {

                // Find the Test Case
                for (FW_TestCase testCase : testSuite.getTestCases()) {
                    if (testCase.getTestCaseName().equals(testCaseName)) {

                        // If the test case does not repeat or the testCaseRepetition matches the testStepObj testCaseRepetition then continue
                        if (testCaseRepeats == false && testCaseParameterized == false ||
                            testCaseRepeats == true && testCaseRepetition == testCase.getTestCaseRepetition() ||
                            testCaseParameterized == true && testCaseParameterizedRow == testCase.getTestCaseParameterizedRow()) {

                            // Find the Test Step (loop)
                            for (FW_TestStep testStep : testCase.getTestSteps()) {

                                // If the test step method matches then add it to the array
                                if (testStep.getTestStepMethod().equals(testStepMethod)) {
                                    return testCase.getTestSteps().toArray(new FW_TestStep[0]);
                                }
                            }
                        }
                    }
                }
            }
        }
        return null;
    }

    /**
     * Updates the result of a test step in the test run object.
     *
     * @param testRun The overall test run object to update.
     * @param indTestStepObj The individual test step object to update.
     * 
     * @return The updated test step object.
     */
    public static FW_TestStep updateTestStepResult(FW_TestRun testRun, FW_TestStep indTestStepObj) {

        // Get the test suite name, test case name, and test step method from the testStepObj
        // To be used to find the correct testStep to update in the testRun object.
        String indTestSuiteName = indTestStepObj.getTestSuiteName();
        String indTestCaseName = indTestStepObj.getTestCaseName();
        String indTestStepMethod = indTestStepObj.getTestStepMethod();
        boolean testRunTestCaseRepeats = testRun.isCurrentTestCaseRepeats();
        int testRunTestCaseRepetition = testRun.getCurrentTestCaseRepetition();
        boolean testRunTestCaseParameterized = testRun.isCurrentTestCaseParameterized();
        int testRunTestCaseRow = testRun.getCurrentTestCaseParameterizedRow();

        // Find the Test Suite within the testRun
        for (FW_TestSuite testRunTestSuite : testRun.getTestSuites()) {
            if (testRunTestSuite.getTestSuiteName().equals(indTestSuiteName)) {

                // Find the Test Case within the testSuite
                for (FW_TestCase testRunTestCase : testRunTestSuite.getTestCases()) {
                    if (testRunTestCase.getTestCaseName().equals(indTestCaseName)) {

                        // If the test case does not repeat or the testCaseRepetition matches the testStepObj testCaseRepetition then continue
                        if (testRunTestCaseRepeats == false && testRunTestCaseParameterized == false ||
                            testRunTestCaseRepeats == true && testRunTestCaseRepetition == testRunTestCase.getTestCaseRepetition() ||
                            testRunTestCaseParameterized == true && testRunTestCaseRow == testRunTestCase.getTestCaseParameterizedRow()) {

                            // Reset the matchFound flag - method match not yet found
                            boolean matchFound = false;

                            // Find the Test Step (loop)
                            int i = 0;
                            while (i < testRunTestCase.getTestSteps().size()) {

                                // Get the testRunTestStep (Based on the index of i)
                                FW_TestStep testRunTestStep = testRunTestCase.getTestSteps().get(i);

                                // Get the testRunTestStepMethod
                                String testRunTestStepMethod = testRunTestStep.getTestStepMethod();

                                // Get the testRunTestStepResult
                                String testRunTestStepResult = testRunTestStep.getTestStepResult();

                                // For Debugging - Print the testRunTestStepMethod and testRunTestStepResult
                                // System.out.println(FW_ConsoleColors.PINK + "i: " + i + " - testRunTestStepMethod: " + testRunTestStepMethod + " - indTestStepMethod: " + indTestStepMethod + " - testRunTestStepResult: '" + testRunTestStepResult + "'" + FW_ConsoleColors.RESET);

                                // Look for matching testStepMethod and empty testStepResult
                                if (testRunTestStepMethod.equals(indTestStepMethod) && testRunTestStepResult.isEmpty()) {

                                    // This value is unnecessary
                                    matchFound = true;

                                    // For Debugging - Print that a match was found
                                    // System.out.println(FW_ConsoleColors.GREENYELLOW + "i: " + i + " - testRunTestStepMethod: " + testRunTestStepMethod + " - indTestStepMethod: " + indTestStepMethod + " - testRunTestStepResult: '" + testRunTestStepResult + "'" + " (Match Found)" + FW_ConsoleColors.RESET);

                                    // ======= Update the testRunTestStep with the indTestStepObj values when applicable - (Begin) ======

                                    // Client, Project & Application details
                                    // testRunTestStep.setClientRefID(testRunTestStep.getClientRefID()); // No update required
                                    // testRunTestStep.setProjectRefID(testRunTestStep.getProjectRefID()); // No update required
                                    // testRunTestStep.setApplicationRefID(testRunTestStep.getApplicationRefID()); // No update required

                                    // Test Run details
                                    // testRunTestStep.setTestRunRefID(testRunTestStep.getTestRunRefID()); // No update required

                                    // Test Suite details
                                    // testRunTestStep.setTestSuiteRefID(testRunTestStep.getTestSuiteRefID()); // No update required
                                    // testRunTestStep.setTestSuiteName(testRunTestStep.getTestSuiteName()); // No update required

                                    // Test Case details
                                    // testRunTestStep.setTestCaseRefID(testRunTestStep.getTestCaseRefID()); // No update required
                                    // testRunTestStep.setTestCaseName(testRunTestStep.getTestCaseName()); // No update required
                                    // testRunTestStep.setTestCaseRepetition(testRunTestStep.getTestCaseRepetition()); // No update required
                                    // testRunTestStep.setTestCaseRepetitions(testRunTestStep.getTestCaseRepetitions()); // No update required

                                    // Test Step details
                                    // testRunTestStep.setTestStepRefID(testRunTestStep.getTestStepRefID()); // No update required
                                    testRunTestStep.setTestStepType(indTestStepObj.getTestStepType());
                                    testRunTestStep.setTestStepTimestamp(indTestStepObj.getTestStepTimestamp());
                                    // testRunTestStep.setTestStepRefOrder(testRunTestStep.getTestStepRefOrder()); // No update requiredt
                                    testRunTestStep.setTestStepPageObject(indTestStepObj.getTestStepPageObject());
                                    // testRunTestStep.setTestStepMethod(testRunTestStep.getTestStepMethod()); // No update required
                                    // testRunTestStep.setTestStepParameters(testRunTestStep.getTestStepParameters()); // No update required
                                    testRunTestStep.setTestStepResult(indTestStepObj.getTestStepResult());
                                    testRunTestStep.setTestStepResultDetails(indTestStepObj.getTestStepResultDetails());
                                    testRunTestStep.setTestStepScreenshotRef(indTestStepObj.getTestStepScreenshotRef());
                                    testRunTestStep.setTestStepScreenshotThumbRef(indTestStepObj.getTestStepScreenshotThumbRef());
                                    testRunTestStep.setTestStepDurationHR(indTestStepObj.getTestStepDurationHR());
                                    testRunTestStep.setTestStepDurationMS(indTestStepObj.getTestStepDurationMS());
                                    testRunTestStep.setTestStepExecuted(indTestStepObj.getTestStepExecuted());

                                    // Location and Network Details (New Fields)
                                    testRunTestStep.setLocLatitude(indTestStepObj.getLocLatitude());
                                    testRunTestStep.setLocLongitude(indTestStepObj.getLocLongitude());
                                    testRunTestStep.setLocIPAddress(indTestStepObj.getLocIPAddress());
                                    testRunTestStep.setLocCountryCode(indTestStepObj.getLocCountryCode());
                                    testRunTestStep.setLocStateCode(indTestStepObj.getLocStateCode());
                                    testRunTestStep.setLocCityName(indTestStepObj.getLocCityName());
                                    testRunTestStep.setLocASN(indTestStepObj.getLocASN());
                                    testRunTestStep.setLocOrganizationName(indTestStepObj.getLocOrganizationName());

                                    // ======= Update the testRunTestStep with the indTestStepObj values when applicable - (End) ======

                                    // Copy results to the indTestStepObj for return
                                    indTestStepObj = testRunTestStep;

                                    // Break the loop because we found the test step to update
                                    return indTestStepObj;

                                } else {
                                    i++;
                                }
                            }

                            // Warning - No match found for this following testSuiteName, testCaseName, and testStepMethod
                            if (matchFound == false) {

                                // Get the class and method that made the call
                                StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
                                StackTraceElement caller = stackTraceElements[2]; // The caller is at index 2
                                String callingClass = caller.getClassName();
                                String callingMethod = caller.getMethodName();

                                System.out.println(FW_ConsoleColors.YELLOW + "[Warn] - Framework error encountered, when trying to match testStep results to update. '" + callingClass + "." + callingMethod + "'." + FW_ConsoleColors.RESET);
                                System.out.println(FW_ConsoleColors.YELLOW + "Possible cause is the addition of a new objet type (e.g. PageObject, ActionObject, etc.)" + FW_ConsoleColors.RESET);
                                System.out.println(FW_ConsoleColors.YELLOW + "No match found for testSuiteName: " + indTestSuiteName + ", testCaseName: " + indTestCaseName + ", testStepMethod: " + indTestStepMethod + FW_ConsoleColors.RESET);
                            
                                // No point in looping through the rest of the test cases and suites.
                                return indTestStepObj;
                            }
                        }
                    }
                }
            }
        }
        return indTestStepObj;
    }

    /**
     * Get the parameter names of a method as a comma-separated string.
     *
     * @param clazz Class object.
     * @param methodName Method name.
     * 
     * @return Comma-separated parameter names.
     */
    private static String getMethodParameterNamesAsString(Class<?> clazz, String methodName) {
        try {
            // Find the method by name
            Method method = Arrays.stream(clazz.getDeclaredMethods())
                    .filter(m -> m.getName().equals(methodName))
                    .findFirst()
                    .orElse(null);

            if (method != null) {
                // Get the parameter names as a comma-separated string
                return Arrays.stream(method.getParameters())
                        .map(p -> p.getName())
                        .collect(Collectors.joining(", "));
            }
        } catch (SecurityException e) {
            System.err.println(FW_ConsoleColors.YELLOW + "Security occured: " + e + FW_ConsoleColors.RESET);
        }
        return "";
    }

    /**
     * Perform an in-step analysis based on the moment in time of the test step.
     *
     * @param startTime The start time.
     * @param result The result of the test step.
     * @param locator The locator of the test step.
     * 
     * @return A map collection containing the results of the assessment.
     *       The map contains the following keys:
     *          - elapsedTime: The elapsed time in seconds.
     *          - assessResult: The assessment result.
     *          - assessResultTime: The assessment result and elapsed time.
     *          - assessResultFailTime: The assessment result for fail and elapsed time.
     *          - assessColor: The assessment color.
     *          - assessColorPass: The assessment color for pass
     *          - assessColorFail: The assessment color for fail
     *          - highlightLocator: true = highlight the locator, false = do not highlight the locator.
     */
    public static Map<String, Object> inStepAnalysis(Instant startTime, boolean result, String locator) {

        // Calculate the elapsed time
        Instant currentTime = Instant.now();
        Duration duration = Duration.between(startTime, currentTime);
        double elapsedTime = duration.toMillis() / 1000.0; // Changed to double

        // Get the highlight locator setting
        String highlightLocatorConfig = FW_ConfigMgr.getLocatorHighlight().toLowerCase();
        boolean highlightLocator = Boolean.parseBoolean(highlightLocatorConfig); // Convert to boolean
        
        // Calculate the assessment result and color
        String assessResult;
        String assessColor;
        String assessColorPass = FW_ConfigMgr.getLocatorHighlightPassCSS();
        String assessColorFail = FW_ConfigMgr.getLocatorHighlightFailCSS();

        // Should we perform locator highlighting?
        if ("true".equals(FW_ConfigMgr.getLocatorHighlight().toLowerCase())) {
                assessColor = FW_ConfigMgr.getLocatorHighlightCSS();
        }

        // Should we perform Satisfaction Assessment?
        if (("true".equals(FW_ConfigMgr.getUserSatisfactionAssessment().toLowerCase())) && (result == true)) {
            if (elapsedTime <= 2.0) {
                assessColor = FW_ConfigMgr.getLocatorHighlightPassCSS();
            } else if (elapsedTime <= 3.0) {
                assessColor = FW_ConfigMgr.getLocatorHighlightWarnLowCSS();
            } else if (elapsedTime <= 5.0) {
                assessColor = FW_ConfigMgr.getLocatorHighlightWarnMediumCSS();
            } else if (elapsedTime <= 10.0) {
                assessColor = FW_ConfigMgr.getLocatorHighlightWarnHighCSS();
            } else {
                assessColor = FW_ConfigMgr.getLocatorHighlightWarnCriticalCSS();
            }
        } else if (("true".equals(FW_ConfigMgr.getUserSatisfactionAssessment().toLowerCase())) && (result == false)) {
            assessColor = FW_ConfigMgr.getLocatorHighlightFailCSS();
        } else {
            assessColor = "";
        }

        // Should we perform the user satisfaction assessment? (More than [Pass} or [Fail])
        if ((result == true) &&("true".equals(FW_ConfigMgr.getUserSatisfactionAssessment().toLowerCase()))) {
            if (elapsedTime <= 2.0) {
                assessResult = "[Pass]";
            } else if (elapsedTime <= 3.0) {
                assessResult = "[Pass Warn - Low]";
            } else if (elapsedTime <= 5.0) {
                assessResult = "[Pass Warn - Medium]";
            } else if (elapsedTime <= 10.0) {
                assessResult = "[Pass Warn - High]";
            } else {
                assessResult = "[Pass Warn - Critical]";
            }
        } else if (result == true) {
            assessResult = "[Pass]";
        } else {
            // Perform the standard assessment
            assessResult = "[Fail]";
        }

        // Highlight the locator
        if ("true".equals(FW_ConfigMgr.getLocatorHighlight().toLowerCase())) {
            // At some point I would like to figure out how to highlight the locator
        }

        // The named collection of the analysis results
        Map<String, Object> analysisResults = new HashMap<>();
        analysisResults.put("elapsedTime", elapsedTime);
        analysisResults.put("assessResult", assessResult);
        analysisResults.put("assessResultTime", assessResult + " - {" + elapsedTime + "}");
        analysisResults.put("assessResultFailTime", "[Fail] - {" + elapsedTime + "}");
        analysisResults.put("assessColor", assessColor);
        analysisResults.put("assessColorPass", assessColorPass);
        analysisResults.put("assessColorFail", assessColorFail);
        analysisResults.put("highlightLocator", highlightLocator);

        return analysisResults;
    }
}