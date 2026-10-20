package framework.audits;

// ===============================================================
// @file: FW_Audit_Ping.java
// @filepath: src/test/java/framework/audits/FW_Audit_Ping.java
// @version: 2.2.1
// @updated: 2025-09-09 09:45:00 AM CDT
// @author: Greg Paskal
// @company: MissionWares
//
// @description:
// Audit class for performing network connectivity tests using ICMP ping.
// This class performs comprehensive ping audits including packet loss calculation,
// round-trip time statistics (min/max/avg), jitter measurement, and standard deviation.
// Integrates with FW_NetworkUtils for core ping functionality and includes GeoIP
// enrichment for location-based network analysis.
//
// Fixed: RTT parsing now correctly retrieves "time" field from ping results instead
// of non-existent "rtt_ms" field. Also handles edge case where MinimumRTT remains
// at Double.MAX_VALUE when no successful pings occur.
//
// @tags: audit, ping, network, connectivity, rtt, jitter, statistics, mAi™
//
// @dependencies:
// - FW_NetworkUtils for core ping operations
// - FW_TestStep for result reporting
// - FW_NetworkDetails for GeoIP information
//
// Note: Uses FW_NetworkUtils.ping() for consistent ping functionality.
// Refactored to use FW_NetworkUtils.ping() to eliminate code duplication.
//
// @changeLog
// Date        Author          Version  Description
// ----------  --------------  -------  --------------------------
// 2025-08-19  G. Paskal       1.0.0    Initial creation
// 2025-08-20  G. Paskal       1.1.0    Refactored to use FW_TestStep.applyNetworkDetails
// 2025-08-20  G. Paskal       1.1.1    Updated main method to initialize TestRunTracker
// 2025-08-21  G. Paskal       2.0.0    Encapsulated ping functionality from FW_Network
// 2025-08-21  G. Paskal       2.1.0    Refactored to use FW_NetworkUtils.ping() and eliminated duplication
// 2025-08-25  G. Paskal       2.2.0    Enabled ping metrics to get recorded for reporting
// 2025-09-09  G. Paskal       2.2.1    Fixed RTT parsing - now correctly retrieves "time" field from ping results
// ===============================================================

// Framework imports
import framework.java.FW_Class;
import framework.junit.FW_CustomAssertJU;
import framework.junit.FW_TestStep;
import framework.junit.FW_TestRunTracker;
import framework.junit.FW_TestStep.TestStepType;
import framework.network.FW_NetworkDetails;
import framework.utilities.FW_ConsoleColors;
import framework.utilities.FW_DateTimeUtils;
import framework.utilities.FW_NetworkUtils;
import framework.utilities.FW_NumberUtils;
import framework.utilities.FW_TestStepUtils;

// Java imports
import java.util.ArrayList;
import java.util.Map;
import java.util.List;

/**
 * This class performs an audit by pinging a specified host multiple times.
 * Uses FW_NetworkUtils.ping() for consistent ping functionality across the framework.
 */
public class FW_Audit_Ping {

    // ===================== Main Method =====================

    public static void main(String[] args) {

        // Initialize the Test Run Tracker to simulate a real test run environment
        FW_TestRunTracker.getInstance();

        // Create an instance of FW_Audit_Ping
        FW_Audit_Ping auditPing = new FW_Audit_Ping();

        // Set parameters for verbose output
        boolean verbose = true; // Enable verbose logging for debugging

        // Define test parameters
        String host = "google.com"; // The target host
        int pingCount = 4; // Number of times to ping
        int pingTimeoutSeconds = 2; // Timeout for each ping

        // Run the ping audit
        Object result = auditPing.runAuditPing(host, pingCount, pingTimeoutSeconds, verbose);

        // Print the final result
        System.out.println(FW_ConsoleColors.PINK + "Final Result: " + result + FW_ConsoleColors.RESET);
    }

    // ===================== Public Methods =====================

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
        String targetHost = FW_NetworkUtils.hostToHostname(host); // Normalize host input
        if (targetHost == null || targetHost.toUpperCase().contains("[FAIL]")) {return "[Fail] - {0.0} - host '" + host + "' is invalid.";}
        if (pingCount <= 0) {return "[Audit Fail] - Ping count must be greater than zero.";}

        // Get the IP Address from the host
        String ipAddress = FW_NetworkUtils.hostToIP(targetHost);
        if (ipAddress == null) {return String.format("[Fail] - {0.0} - Unable to resolve IP address for host '%s'.", targetHost);}

        if (verbose) {System.out.println(FW_ConsoleColors.BLUE + "  - host: '" + targetHost + "' resolves to IP: " + ipAddress + FW_ConsoleColors.RESET);}

        FW_NetworkDetails ipNetworkDetails = FW_NetworkUtils.getNetworkDetails(ipAddress);

        // Set up variables to track success and timing
        int pingSuccessCount = 0;                       // Count of successful pings that did not return a status of [Fail]
        int pingFailCount = 0;                          // Count of failed pings
        double pingPacketLossPercentage = 0;            // The percentage of lost ping packets
        double rttTotalTime_ms = 0;                     // The total accumulated round-trip time for successful pings
        double rttMinimumTime_ms = Double.MAX_VALUE;    // The minimum round-trip time observed (start with MAX for proper comparison)
        double rttMaximumTime_ms = 0;                   // The maximum round-trip time observed
        double rttAverageTime_ms = 0;                   // The average round-trip time observed
        double rttStandardDeviation_ms = 0;             // The standard deviation of round-trip times
        double rttJitter_ms = 0;                        // The average jitter (variation between consecutive pings)

        // Lists to store RTT values for statistical calculations
        List<Double> rttValues = new ArrayList<>();     // All successful RTT values
        List<Double> jitterValues = new ArrayList<>();  // Differences between consecutive RTTs
        Double previousRtt = null;                      // Track previous RTT for jitter calculation

        int pingTimeoutMilliseconds = pingTimeoutSeconds * 1000;

        // Loop and log each ping attempt as a separate test step
        for (int individualPingOrderNum = 1; individualPingOrderNum <= pingCount; individualPingOrderNum++) {

            // Perform a single ping test using FW_NetworkUtils.ping()
            Map<Integer, Map<String, String>> individualPingResultMap = FW_NetworkUtils.ping(targetHost, pingTimeoutMilliseconds);
            Map<String, String> individualPingResultDetails = individualPingResultMap.get(0);

            // Check if ping was successful or failed
            boolean isPingSuccessful = individualPingResultDetails.get("status").equalsIgnoreCase("[Pass]");
            
            if (isPingSuccessful) {
                pingSuccessCount++;
                
                // Parse RTT value for successful pings
                String rttString = individualPingResultDetails.get("time");
                if (rttString != null && !rttString.isEmpty()) {
                    try {
                        double currentRtt = Double.parseDouble(rttString);
                        
                        // Store RTT value for statistics
                        rttValues.add(currentRtt);
                        
                        // Update total RTT
                        rttTotalTime_ms += currentRtt;
                        
                        // Update minimum RTT
                        if (currentRtt < rttMinimumTime_ms) {
                            rttMinimumTime_ms = currentRtt;
                        }
                        
                        // Update maximum RTT
                        if (currentRtt > rttMaximumTime_ms) {
                            rttMaximumTime_ms = currentRtt;
                        }
                        
                        // Calculate jitter (difference from previous RTT)
                        if (previousRtt != null) {
                            double jitter = Math.abs(currentRtt - previousRtt);
                            jitterValues.add(jitter);
                        }
                        previousRtt = currentRtt;
                        
                    } catch (NumberFormatException e) {
                        // Log error but continue processing
                        System.err.println("Failed to parse RTT value: " + rttString);
                    }
                }
            } else {
                pingFailCount++;
                // Reset previous RTT on failure to avoid incorrect jitter calculation
                previousRtt = null;
            }
            
            // Optional: Add small delay between pings to avoid network flooding
            if (individualPingOrderNum < pingCount) {
                FW_DateTimeUtils.waitForDuration(100,"ms", false);
            }
        }

        // Calculate final statistics after all pings are complete
        if (pingCount > 0) {

            // Calculate packet loss percentage
            pingPacketLossPercentage = FW_NumberUtils.roundToDecimalPlaces((pingFailCount / (double) pingCount) * 100, 1);

        }

        if (pingSuccessCount > 0 && !rttValues.isEmpty()) {
            rttAverageTime_ms = FW_NumberUtils.roundToDecimalPlaces(rttTotalTime_ms / pingSuccessCount, 2);
            rttStandardDeviation_ms = FW_NumberUtils.roundToDecimalPlaces(calculateStandardDeviation(rttValues, rttAverageTime_ms), 2);
            rttMinimumTime_ms = FW_NumberUtils.roundToDecimalPlaces(rttMinimumTime_ms, 2);
            rttMaximumTime_ms = FW_NumberUtils.roundToDecimalPlaces(rttMaximumTime_ms, 2);
            if (!jitterValues.isEmpty()) {
                rttJitter_ms = FW_NumberUtils.roundToDecimalPlaces(jitterValues.stream().mapToDouble(Double::doubleValue).average().orElse(0), 2);
            }
        } else {
            // Handle case where no successful pings occurred - reset MinimumRTT to 0
            if (rttMinimumTime_ms == Double.MAX_VALUE) {
                rttMinimumTime_ms = 0.0;
            }
        }

        // --- Create a final summary result for the entire audit ---
        String overallPingResultStatus;
        String overallPingResultDetails;
        
        if (pingSuccessCount > 0) {

            // Add GeoIP details to the final summary string
            String locationInfo = (ipNetworkDetails != null && ipNetworkDetails.getCity() != null) ?
                String.format(" (%s, %s - %s)", ipNetworkDetails.getCity(), ipNetworkDetails.getRegion(), ipNetworkDetails.getAsnOrganization()): "";

            String performanceSummary = String.format(" Average time: %.2f ms.", rttAverageTime_ms);
            if (pingSuccessCount == pingCount) {
                overallPingResultStatus = "[Pass]";
                overallPingResultDetails = String.format("Successfully pinged '%s' %d times." + performanceSummary + locationInfo, targetHost, pingCount);
            } else {
                overallPingResultStatus = "[Note]";
                overallPingResultDetails = String.format("Successfully pinged '%s' %d out of %d times." + performanceSummary + locationInfo, targetHost, pingSuccessCount, pingCount);
            }
        } else {
            overallPingResultStatus = "[Fail]";
            overallPingResultDetails = String.format("Failed to ping '%s' in %d attempts.", targetHost, pingCount);
        }

        // Convert the average time from milliseconds back to seconds for consistency.
        double averageTimeInSeconds = rttAverageTime_ms / 1000.0;

        String finalResultString = String.format("%s - {%.5f} - %s PacketLoss: %.1f%%, AverageRTT: %.2f ms, MinimumRTT: %.2f ms, MaximumRTT: %.2f ms, Jitter: %.2f ms, StdDev: %.2f ms", overallPingResultStatus, averageTimeInSeconds, overallPingResultDetails, pingPacketLossPercentage, rttAverageTime_ms, rttMinimumTime_ms, rttMaximumTime_ms, rttJitter_ms, rttStandardDeviation_ms);

        // Create test step result object regarding the overall ping result
        FW_TestStep overallStepResultObj = FW_TestStepUtils.createTestStep(finalResultString, Thread.currentThread(), TestStepType.AUDIT_PING.getValue());

        // Add GeoIP Details to the test step object
        overallStepResultObj = FW_TestStepUtils.mergeGeoIPIntoTestStep(ipNetworkDetails, overallStepResultObj);

        // Capture markers used for step duplication
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        String testSuiteName = FW_Class.extractSimpleClassName(stackTrace[2].getClassName());
        String testCaseName = stackTrace[2].getMethodName();
        String testStepMethod = stackTrace[1].getMethodName();

        // ====================================================================
        // === Prepare reporting metrics from ping test - PacketLoss - Begin ===

        // Duplicate test step to store specific metrics
        FW_TestStepUtils.duplicateTestStep(testSuiteName, testCaseName, testStepMethod);

        // Create test step object for the specific metric
        FW_TestStep resultMetricPacketLossObj = FW_TestStepUtils.createTestStep(finalResultString, Thread.currentThread(), TestStepType.AUDIT_PING.getValue());

        // Add GeoIP Details to the test step object
       resultMetricPacketLossObj = FW_TestStepUtils.mergeGeoIPIntoTestStep(ipNetworkDetails, resultMetricPacketLossObj);

        // Add specific metric to the test step object
        resultMetricPacketLossObj.setTestStepRefOrder(1);
        resultMetricPacketLossObj.setTestStepResultMetricKey("PacketLoss");
        resultMetricPacketLossObj.setTestStepResultMetricNumber(pingPacketLossPercentage);
        resultMetricPacketLossObj.setTestStepExecuted(true);
        resultMetricPacketLossObj.setTestStepDurationHR(0);
        resultMetricPacketLossObj.setTestStepDurationMS(0);

        // Return the test step object for the specific metric to be processed as a result
        FW_CustomAssertJU.autoPass(resultMetricPacketLossObj);

        // === Prepare reporting metrics from ping test - PacketLoss - End ===
        // ====================================================================

        // ====================================================================
        // === Prepare reporting metrics from ping test - AverageRTT - Begin ===

        // Duplicate test step to store specific metrics
        FW_TestStepUtils.duplicateTestStep(testSuiteName, testCaseName, testStepMethod);

        // Create test step object for the specific metric
        FW_TestStep resultMetricAverageRttObj = FW_TestStepUtils.createTestStep(finalResultString, Thread.currentThread(), TestStepType.AUDIT_PING.getValue());

        // Add GeoIP Details to the test step object
       resultMetricAverageRttObj = FW_TestStepUtils.mergeGeoIPIntoTestStep(ipNetworkDetails, resultMetricAverageRttObj);

        // Add specific metric to the test step object
        resultMetricAverageRttObj.setTestStepRefOrder(2);
        resultMetricAverageRttObj.setTestStepResultMetricKey("AverageRTT");
        resultMetricAverageRttObj.setTestStepResultMetricNumber(rttAverageTime_ms);
        resultMetricAverageRttObj.setTestStepExecuted(true);
        resultMetricAverageRttObj.setTestStepDurationHR(0);
        resultMetricAverageRttObj.setTestStepDurationMS(0);

        // Return the test step object for the specific metric to be processed as a result
        FW_CustomAssertJU.autoPass(resultMetricAverageRttObj);

        // === Prepare reporting metrics from ping test - AverageRTT - End ===
        // ====================================================================

        // ====================================================================
        // === Prepare reporting metrics from ping test - MinimumRTT - Begin ===

        // Duplicate test step to store specific metrics
        FW_TestStepUtils.duplicateTestStep(testSuiteName, testCaseName, testStepMethod);

        // Create test step object for the specific metric
        FW_TestStep resultMetricMinRttObj = FW_TestStepUtils.createTestStep(finalResultString, Thread.currentThread(), TestStepType.AUDIT_PING.getValue());

        // Add GeoIP Details to the test step object
        resultMetricMinRttObj = FW_TestStepUtils.mergeGeoIPIntoTestStep(ipNetworkDetails, resultMetricMinRttObj);

        // Add specific metric to the test step object
        resultMetricMinRttObj.setTestStepRefOrder(3);
        resultMetricMinRttObj.setTestStepResultMetricKey("MinimumRTT");
        resultMetricMinRttObj.setTestStepResultMetricNumber(rttMinimumTime_ms);
        resultMetricMinRttObj.setTestStepExecuted(true);
        resultMetricMinRttObj.setTestStepDurationHR(0);
        resultMetricMinRttObj.setTestStepDurationMS(0);

        // Return the test step object for the specific metric to be processed as a result
        FW_CustomAssertJU.autoPass(resultMetricMinRttObj);

        // === Prepare reporting metrics from ping test - MinimumRTT - End ===
        // ====================================================================

        // ====================================================================
        // === Prepare reporting metrics from ping test - MaximumRTT - Begin ===

        // Duplicate test step to store specific metrics
        FW_TestStepUtils.duplicateTestStep(testSuiteName, testCaseName, testStepMethod);

        // Create test step object for the specific metric
        FW_TestStep resultMetricMaxRttObj = FW_TestStepUtils.createTestStep(finalResultString, Thread.currentThread(), TestStepType.AUDIT_PING.getValue());

        // Add GeoIP Details to the test step object
        resultMetricMaxRttObj = FW_TestStepUtils.mergeGeoIPIntoTestStep(ipNetworkDetails, resultMetricMaxRttObj);

        // Add specific metric to the test step object
        resultMetricMaxRttObj.setTestStepRefOrder(4);
        resultMetricMaxRttObj.setTestStepResultMetricKey("MaximumRTT");
        resultMetricMaxRttObj.setTestStepResultMetricNumber(rttMaximumTime_ms);
        resultMetricMaxRttObj.setTestStepExecuted(true);
        resultMetricMaxRttObj.setTestStepDurationHR(0);
        resultMetricMaxRttObj.setTestStepDurationMS(0);

        // Return the test step object for the specific metric to be processed as a result
        FW_CustomAssertJU.autoPass(resultMetricMaxRttObj);

        // === Prepare reporting metrics from ping test - MaximumRTT - End ===
        // ====================================================================

        // ====================================================================
        // === Prepare reporting metrics from ping test - Jitter - Begin ===

        // Duplicate test step to store specific metrics
        FW_TestStepUtils.duplicateTestStep(testSuiteName, testCaseName, testStepMethod);

        // Create test step object for the specific metric
        FW_TestStep resultMetricJitterObj = FW_TestStepUtils.createTestStep(finalResultString, Thread.currentThread(), TestStepType.AUDIT_PING.getValue());

        // Add GeoIP Details to the test step object
        resultMetricJitterObj = FW_TestStepUtils.mergeGeoIPIntoTestStep(ipNetworkDetails, resultMetricJitterObj);

        // Add specific metric to the test step object
        resultMetricJitterObj.setTestStepRefOrder(5);
        resultMetricJitterObj.setTestStepResultMetricKey("Jitter");
        resultMetricJitterObj.setTestStepResultMetricNumber(rttJitter_ms);
        resultMetricJitterObj.setTestStepExecuted(true);
        resultMetricJitterObj.setTestStepDurationHR(0);
        resultMetricJitterObj.setTestStepDurationMS(0);

        // Return the test step object for the specific metric to be processed as a result
        FW_CustomAssertJU.autoPass(resultMetricJitterObj);

        // === Prepare reporting metrics from ping test - Jitter - End ===
        // ====================================================================

        // ====================================================================
        // === Prepare reporting metrics from ping test - StandardDeviation - Begin ===

        // Duplicate test step to store specific metrics
        FW_TestStepUtils.duplicateTestStep(testSuiteName, testCaseName, testStepMethod);

        // Create test step object for the specific metric
        FW_TestStep resultMetricStdDevObj = FW_TestStepUtils.createTestStep(finalResultString, Thread.currentThread(), TestStepType.AUDIT_PING.getValue());

        // Add GeoIP Details to the test step object
        resultMetricStdDevObj = FW_TestStepUtils.mergeGeoIPIntoTestStep(ipNetworkDetails, resultMetricStdDevObj);

        // Add specific metric to the test step object
        resultMetricStdDevObj.setTestStepRefOrder(6);
        resultMetricStdDevObj.setTestStepResultMetricKey("StandardDeviation");
        resultMetricStdDevObj.setTestStepResultMetricNumber(rttStandardDeviation_ms);
        resultMetricStdDevObj.setTestStepExecuted(true);
        resultMetricStdDevObj.setTestStepDurationHR(0);
        resultMetricStdDevObj.setTestStepDurationMS(0);

        // Return the test step object for the specific metric to be processed as a result
        FW_CustomAssertJU.autoPass(resultMetricStdDevObj);

        // === Prepare reporting metrics from ping test - StandardDeviation - End ===
        // ====================================================================

        if (verbose) {System.out.println(FW_ConsoleColors.BLUE + "- Audit - Ping (End)" + FW_ConsoleColors.RESET);}

        return overallStepResultObj;
    }

    // ===================== Private Ping Methods (Encapsulated) =====================

    // Helper method to calculate standard deviation
    private static double calculateStandardDeviation(List<Double> values, double mean) {
        if (values.size() <= 1) {
            return 0.0;
        }
        
        double sumSquaredDifferences = 0.0;
        for (Double value : values) {
            double difference = value - mean;
            sumSquaredDifferences += difference * difference;
        }
        
        // Using sample standard deviation (n-1) for better estimation
        return Math.sqrt(sumSquaredDifferences / (values.size() - 1));
    }
}