package framework.audits;

/**
 * @file FW_Audit_Ping.java
 * @description Performs a ping audit to a specified host, logging each attempt.
 */

// Framework imports
import framework.automation.FW_Network;
import framework.java.FW_Class;
import framework.junit.FW_CustomAssertJU;
import framework.junit.FW_TestStep;
import framework.junit.FW_TestStep.TestStepType;
import framework.network.FW_IpDetails;
import framework.utilities.FW_ConsoleColors;
import framework.utilities.FW_NetworkUtils;
import framework.utilities.FW_TestStepUtils;

/**
 * This class performs an audit by pinging a specified host multiple times.
 */
public class FW_Audit_Ping {

    public static void main(String[] args) {

        // Create an instance of FW_Audit_Ping
        FW_Audit_Ping auditPing = new FW_Audit_Ping();

        // Set parameters for verbose output
        boolean verbose = true;

        // Define test parameters
        String host = "google.com"; // The target host
        int pingCount = 4;          // Number of times to ping
        int pingTimeoutSeconds = 2; // Timeout for each ping

        // Run the ping audit
        Object result = auditPing.runAuditPing(host, pingCount, pingTimeoutSeconds, verbose);

        // Print the final result
        System.out.println(FW_ConsoleColors.PINK + "Final Result: " + result + FW_ConsoleColors.RESET);
    }

    /**
     * This method performs an audit by pinging a specified host multiple times.
     *
     * @param host             The target host (hostname or IP address) for the ping.
     * @param pingCount        The number of times to send a ping request.
     * @param pingTimeoutSeconds The timeout in seconds for each ping.
     * @param verbose          If true, print detailed execution steps. Defaults to false if null.
     *
     * @return Consolidated audit result details.
     */
    public Object runAuditPing(String host, int pingCount, int pingTimeoutSeconds, Boolean verbose) {

        // Set default value for verbose if null
        if (verbose == null) {verbose = false;}

        if (verbose) {System.out.println(FW_ConsoleColors.BLUE + "- Audit - Ping (Begin)" + FW_ConsoleColors.RESET);}

        // Input Validation
        if (host == null || host.isEmpty()) {return "[Audit Fail] - Host cannot be null or empty.";}
        String targetHost = FW_NetworkUtils.hostname(host); // Normalize host input
        if (targetHost.toUpperCase().contains("[FAIL]")) {return "[Fail] - {0.0} - host '" + host + "' is invalid.";}
        if (pingCount <= 0) {return "[Audit Fail] - Ping count must be greater than zero.";}

        // Resolve IP Address and GeoIP details once for the entire audit.
        String ipAddress = FW_NetworkUtils.ip(targetHost);
        if (ipAddress == null) {return String.format("[Fail] - {0.0} - Unable to resolve IP address for host '%s'.", targetHost);}
        FW_IpDetails ipDetails = FW_NetworkUtils.getIpDetails(ipAddress);

        // Create a new network object
        FW_Network network = new FW_Network();

        // Set up variables to track success and timing
        int successCount = 0;
        double totalTime = 0;

        // Loop and log each ping attempt as a separate test step
        for (int i = 1; i <= pingCount; i++) {

            // === Prepare test reporting for the new ping attempt - Start ===
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            String testSuiteName = FW_Class.extractSimpleClassName(stackTrace[2].getClassName());
            String testCaseName = stackTrace[2].getMethodName();
            String testStepMethod = stackTrace[1].getMethodName();

            // Insert a new test step into the test run tracker for the ping result
            FW_TestStepUtils.duplicateTestStep(testSuiteName, testCaseName, testStepMethod);
            // === Prepare test reporting for the new ping attempt - End ===

            // Perform a single ping test
            String pingResult = network.pingTest(targetHost, pingTimeoutSeconds, 1);

            // Create a new test step to capture the ping result
            FW_TestStep pingTestStepResultObj = FW_TestStepUtils.createTestStep(pingResult, Thread.currentThread(), TestStepType.AUDIT_PING.getValue());
            pingTestStepResultObj.setTestStepRefOrder(i); // Set the ping attempt number

            // Add the resolved GeoIP details to the test step object
            if (ipDetails != null) {
                pingTestStepResultObj.setLocLatitude(ipDetails.getLatitude() != null ? ipDetails.getLatitude() : 0.0);
                pingTestStepResultObj.setLocLongitude(ipDetails.getLongitude() != null ? ipDetails.getLongitude() : 0.0);
                pingTestStepResultObj.setLocIPAddress(ipAddress);
                pingTestStepResultObj.setLocCountryCode(ipDetails.getCountryCode() != null ? ipDetails.getCountryCode() : "");
                pingTestStepResultObj.setLocStateCode(ipDetails.getRegionCode() != null ? ipDetails.getRegionCode() : "");
                pingTestStepResultObj.setLocCityName(ipDetails.getCity() != null ? ipDetails.getCity() : "");
                pingTestStepResultObj.setLocASN(ipDetails.getAsn() != null ? ipDetails.getAsn().longValue() : null);
                pingTestStepResultObj.setLocOrganizationName(ipDetails.getAsnOrganization() != null ? ipDetails.getAsnOrganization() : "");
            }
            pingTestStepResultObj.setTestStepExecuted(true);

            if (pingTestStepResultObj.getTestStepResult().equalsIgnoreCase("Pass")) {
                
                // Increment success count and accumulate total time
                successCount++;

                // Aggregate the total time taken for successful pings
                totalTime += pingTestStepResultObj.getTestStepDurationMS();
            }

            // Because this is an audit and we did not account for it at the time of analyzing the initial test steps.
            // Record the individual audit step for reporting.
            FW_CustomAssertJU.autoPass(pingTestStepResultObj);
        }

        // --- Create a final summary result for the entire audit ---
        String overallStatus;
        double averageTimeInMilliseconds = (successCount > 0) ? totalTime / successCount : 0.0;
        String overallDetails;

        if (successCount > 0) {

            // Add GeoIP details to the final summary string
            String locationInfo = (ipDetails != null && ipDetails.getCity() != null) ? String.format(" (%s, %s - %s)", ipDetails.getCity(), ipDetails.getRegionCode(), ipDetails.getAsnOrganization()): "";

            String performanceSummary = String.format(" Average time: %.2f ms.", averageTimeInMilliseconds);
            if (successCount == pingCount) {
                overallStatus = "[Pass]";
                overallDetails = String.format("Successfully pinged '%s' %d times." + performanceSummary, targetHost, pingCount);
            } else {
                overallStatus = "[Note]";
                overallDetails = String.format("Successfully pinged '%s' %d out of %d times." + performanceSummary, targetHost, successCount, pingCount);
            }
        } else {
            overallStatus = "[Fail]";
            overallDetails = String.format("Failed to ping '%s' in %d attempts.", targetHost, pingCount);
        }

        // Convert the average time from milliseconds back to seconds for consistency.
        double averageTimeInSeconds = averageTimeInMilliseconds / 1000.0;

        // Format the final result string
        String finalResultString = String.format("%s - {%.5f} - %s", overallStatus, averageTimeInSeconds, overallDetails);
        
        // Create test step result object regarding the overall ping result
        FW_TestStep overallStepResultObj = FW_TestStepUtils.createTestStep(finalResultString, Thread.currentThread(), TestStepType.AUDIT_PING.getValue());

        if (verbose) {System.out.println(FW_ConsoleColors.BLUE + "- Audit - Ping (End)" + FW_ConsoleColors.RESET);}

        return overallStepResultObj;
    }
}