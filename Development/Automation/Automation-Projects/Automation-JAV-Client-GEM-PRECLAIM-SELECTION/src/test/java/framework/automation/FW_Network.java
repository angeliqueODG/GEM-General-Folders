package framework.automation;

/**
 * @file FW_Network.java
 * @description Provides networking utility methods.
 * 
 * This file contains the FW_Network class which provides methods to perform various network-related actions,
 * such as ping tests, jitter tests, speed tests, and traceroute tests. It handles the execution and result processing of these tests.
 * 
 * The FW_Network class offers functionalities to:
 * - Perform ping tests to check the reachability of a host.
 * - Conduct jitter tests to measure the variability in ping response times.
 * - Execute speed tests to determine download speeds.
 * - Perform traceroute tests to trace the path packets take to a host.
 * - Resolve hostnames to IP addresses and vice versa.
 * - Retrieve detailed IP information for a given host.
 * 
 * This class is designed to be used for network diagnostics and performance measurements, providing detailed
 * results and handling various network-related operations.
 */

import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import framework.network.FW_Traceroute;
import framework.utilities.FW_ConsoleColors;
import framework.utilities.FW_NetworkUtils;

/**
 * This class provides a wrapper around common networking utility methods.
 */
public class FW_Network {

    /**
     * Main method for testing the FW_Network utility functions.
     * 
     * @param args Command line arguments.
     */
    public static void main(String[] args) {

        // Create an instance of the FW_Network class
        FW_Network network = new FW_Network();
        String result;

        // ===================== Network - Ping - Begin =====================

        System.out.println(FW_ConsoleColors.CORAL + "- Network - Ping - Using Hostname..." + FW_ConsoleColors.RESET);

        // Test pingTest method
        result = network.pingTest("google.com", 1);

        // Print the result of the ping test
        if (result.toUpperCase().contains("[PASS]")) {
            System.out.println(FW_ConsoleColors.GREEN + "  - " + result + FW_ConsoleColors.RESET);
        } else {
            System.out.println(FW_ConsoleColors.RED + "  - " + result + FW_ConsoleColors.RESET);
        }

        System.out.println(FW_ConsoleColors.CORAL + "- Network - Ping - Using IP..." + FW_ConsoleColors.RESET);

        // Test pingTest method
        result = network.pingTest("8.8.8.8", 1);

        // Print the result of the ping test
        if (result.toUpperCase().contains("[PASS]")) {
            System.out.println(FW_ConsoleColors.GREEN + "  - " + result + FW_ConsoleColors.RESET);
        } else {
            System.out.println(FW_ConsoleColors.RED + "  - " + result + FW_ConsoleColors.RESET);
        }

        // ===================== Network Tests - Ping - End =====================

        // ===================== Network - Traceroute - Begin =====================
        System.out.println(FW_ConsoleColors.CORAL + "- Network - Traceroute - Using Hostname..." + FW_ConsoleColors.RESET);

        // Test tracerouteTest method
        String tracerouteResult = network.tracerouteTest("dns.google",120);

        // Print the result of the traceroute test
        if (tracerouteResult.toUpperCase().contains("[PASS]")) {
            System.out.println(FW_ConsoleColors.GREEN + "  - " + tracerouteResult + FW_ConsoleColors.RESET);
        } else {
            System.out.println(FW_ConsoleColors.RED + "  - " + tracerouteResult + FW_ConsoleColors.RESET);
        }
    }

    /**
     * This method checks if a host is reachable by sending a single ping.
     * This is an overloaded method that defaults to 1 ping attempt.
     *
     * @param host The host to check.
     * @param pingTimeoutSeconds The timeout for the ping in seconds.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String pingTest(String host, int pingTimeoutSeconds) {
        // Call the more detailed pingTest method with a default of 1 attempt.
        return pingTest(host, pingTimeoutSeconds, 1);
    }

    /**
     * This method checks if a host is reachable and returns a verbose result, including the IP address.
     * It can perform single or multiple pings and average the results.
     *
     * @param host The host to check.
     * @param pingTimeoutSeconds The timeout for the ping in seconds.
     * @param pingAttempts The number of times to ping the host. Use 1 for a single check.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details and the IP address.
     */
    public String pingTest(String host, int pingTimeoutSeconds, int pingAttempts) {

        // --- Input Validation ---
        if (host == null || host.isEmpty()) {
            return "[Fail] - {0.0} - Host cannot be null or empty.";
        }
        if (pingTimeoutSeconds <= 0) {
            return "[Fail] - {0.0} - Ping timeout must be greater than zero.";
        }
        if (pingAttempts <= 0) {
            return "[Fail] - {0.0} - Ping attempts must be greater than zero.";
        }

        // Convert pingTimeout to milliseconds
        int pingTimeoutMilliseconds = pingTimeoutSeconds * 1000;

        // Extract the hostname from the host string
        String targetHostname = FW_NetworkUtils.hostname(host);

        // if the hostname is null, return a failure message
        if (targetHostname == null) {
            return "[Fail] - {0.0} - Host '" + host + "' is invalid.";
        }

        // If the hostname contains "[Fail]", return result immediately
        if (targetHostname.toUpperCase().contains("[FAIL]")) {
            return targetHostname;
        }

        // Resolve the IP address of the host
        String ipAddress = FW_NetworkUtils.ip(targetHostname);
        if (ipAddress == null) {
            return String.format("[Fail] - {0.0} - Unable to resolve IP address for host '%s'.", targetHostname);
        }

        // Initialize counters for the ping loop
        int successfulPings = 0;
        double totalPingTime = 0;

        // Loop to retry the ping operation
        for (int i = 0; i < pingAttempts; i++) {

            // Perform the ping operation and get the results
            Map<Integer, Map<String, String>> combinedPingResults = FW_NetworkUtils.ping(targetHostname, pingTimeoutMilliseconds);

            // Check if the ping operation returned any results
            if (combinedPingResults != null && !combinedPingResults.isEmpty()) {

                // Get the individual ping result for the first ICMP sequence
                Map<String, String> individualPingResult = combinedPingResults.get(0);

                // Check if there is a result for the first ICMP sequence
                if (individualPingResult != null) {

                    // Get the status of the ping operation
                    String pingStatus = individualPingResult.get("status").toUpperCase();

                    // Check if the ping operation was successful
                    if (pingStatus.contains("[PASS]")) {

                        // Increment the successful ping count
                        successfulPings++;

                        // Calculate the total ping time
                        totalPingTime += Double.parseDouble(individualPingResult.get("time"));
                    }
                }
            }
        }

        // Calculate average ping time
        if (successfulPings > 0) {
            double averagePingTimeMilliSeconds = totalPingTime / successfulPings;
            double averagePingTimeSeconds = averagePingTimeMilliSeconds / 1000.0;
            String resultDetails;

            // Tailor the success message based on the number of attempts
            if (pingAttempts > 1) {
                resultDetails = String.format("Pinged host '%s' (IP: %s) successfully %d out of %d times. Average time: %.2f ms.", targetHostname, ipAddress, successfulPings, pingAttempts, averagePingTimeMilliSeconds);
            } else {
                resultDetails = String.format("Pinged host '%s' (IP: %s) successfully. Time: %.2f ms.", targetHostname, ipAddress, averagePingTimeMilliSeconds);
            }
            return String.format("[Pass] - {%.5f} - %s", averagePingTimeSeconds, resultDetails);
        } else {
            return String.format("[Fail] - {0.0} - Unable to ping host '%s' (IP: %s) after %d attempts.", targetHostname, ipAddress, pingAttempts);
        }
    }

    /**
     * This method checks the traceroute to a host and returns a verbose result.
     *
     * @param host The host to check.
     * @param maxTracerouteDurationSeconds The maximum duration (in seconds) the traceroute process is allowed to run.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String tracerouteTest(String host, int maxTracerouteDurationSeconds) {

        // Default variables
        int maxNumberOfHops = 15; // Maximum number of hops to trace
        int numberOfProbes = 3; // Number of probes to send
        int maxProbeDurationSeconds = 5; // Maximum duration for each probe in seconds

        // --- Input Validation ---
        if (host == null || host.isEmpty()) {
            return "[Fail] - {0.0} - Target host cannot be null or empty.";
        }

        host = FW_NetworkUtils.hostname(host);
        if (host.toUpperCase().contains("[FAIL]")) {
            return "[Fail] - {0.0} - host '" + host + "' is invalid.";
        }

        if (maxTracerouteDurationSeconds <= 0) {
            return "[Fail] - {0.0} - maxTracerouteDurationSeconds must be greater than zero.";
        }

        // Perform traceroute and return tracerouteResult object
        FW_Traceroute tracerouteResult = FW_NetworkUtils.traceroute(host, maxTracerouteDurationSeconds, maxNumberOfHops, numberOfProbes, maxProbeDurationSeconds, true, true);

        // Check if the traceroute operation returned any results
        if (tracerouteResult != null && tracerouteResult.isValid()) {

            // Get the status of the traceroute operation
            String tracerouteStatus = tracerouteResult.getStatus().toUpperCase();

            // Get duration contained within {nnn.nnn} from the tracerouteStatus 
            String tracerouteExecutionDuration = tracerouteResult.getDuration() > 0 ? String.format("%.3f", tracerouteResult.getDuration()) : "0.0";

            // Check if the traceroute operation was successful
            if (tracerouteStatus.contains("[PASS]")) {
                return String.format("[Pass] - {" + tracerouteExecutionDuration + "} - Traceroute to host '" + host + "' completed successfully.");
            } else {
                return String.format("[Fail] - {" + tracerouteExecutionDuration + "} - Traceroute to host '" + host + "' failed with status '" + tracerouteStatus + "'.");
            }

        }

        // Return a failure message for an unknown error
        return String.format("[Fail] - Tried to traceroute to host '" + host + "' within '" + maxTracerouteDurationSeconds + "' seconds but encountered an unknown error.");
    }

    /**
     * This method chechs for network jitter.
     *
     * @param host The host to check.
     * @param pingCount The number of times to ping the host.
     * @param pingTimeout The timeout for the ping in milliseconds.
     * @param acceptableDeviation The acceptable deviation in milliseconds.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String jitterTest(String host, int pingCount, int pingTimeout, int acceptableDeviation) {
        // Perform the jitter test and get the results
        Map<String, String> jitterResult = jitter(host, pingCount, pingTimeout);
    
        // Get the status of the jitter test
        String jitterStatus = jitterResult.get("status").toUpperCase();
    
        // Check if the jitter test was successful
        if (jitterStatus.contains("[PASS]")) {
            // Get the standard deviation from the jitter result
            double standardDeviation = Double.parseDouble(jitterResult.get("standard_deviation"));
    
            // Check if the standard deviation is within the acceptable range
            if (standardDeviation <= acceptableDeviation) {
                // Return a success message with the standard deviation
                return String.format("[Pass] - Jitter test passed with standard deviation of %s milliseconds.", standardDeviation);
            } else {
                // Return a failure message with the standard deviation
                return String.format("[Fail] - Jitter test failed with standard deviation of %s milliseconds.", standardDeviation);
            }
        } else {
            // Return a failure message with the jitter test status
            return String.format("[Fail] - Jitter test failed with status '%s'.", jitterStatus);
        }
    }

    /**
     * This method checks the download speed of a file.
     *
     * @return A string including [PASS] or [FAIL] along with specific result details.
     */
    public String speedTest() {

        // Perform the speed test and get the results
        try {
            URI uri = new URI("http://speedtest.tele2.net/10MB.zip");
            URL url = uri.toURL();
            URLConnection connection = url.openConnection();
    
            // Set a connection timeout to prevent hanging indefinitely
            connection.setConnectTimeout(5000); // 5 seconds
            connection.setReadTimeout(15000);   // 15 seconds for reading data

            // Start timer
            Instant start = Instant.now();
            long totalBytesRead = 0; // Keep track of total bytes

            // Download file
            try (InputStream in = connection.getInputStream()) {
                byte[] buffer = new byte[8192];
                int bytesRead;
                while ((bytesRead = in.read(buffer)) != -1) {

                    // Accumulate bytes read
                    totalBytesRead += bytesRead;
                }
            }
    
            // Stop timer
            Instant end = Instant.now();
    
            // Calculate speed
            long dataSizeBytes = connection.getContentLengthLong();

            if (dataSizeBytes == -1) {
                // If Content-Length is not provided by the server, use totalBytesRead
                dataSizeBytes = totalBytesRead;
            }

            if (dataSizeBytes == 0) {
                 return "[Fail] - No data downloaded or file size is 0.";
            }

            long timeTakenMS = Duration.between(start, end).toMillis();

            if (timeTakenMS == 0) {
                return "[Fail] - Download completed too quickly to measure accurately (time taken was 0 ms).";
            }

            double dataSizeMegabits = (dataSizeBytes * 8.0) / (1024.0 * 1024.0); // Convert bytes to megabits
            double timeTakenSeconds = timeTakenMS / 1000.0; // Convert milliseconds to seconds
            double speedMbps = dataSizeMegabits / timeTakenSeconds;

            String result = String.format("[Pass] - {%.2f} - Download speed: %.2f Mbps", speedMbps, speedMbps);
            
            return result;

        } catch (Exception e) {
            System.err.println("Error during speed test: " + e.getMessage()); // Log error for debugging
            return "[Fail] - Error performing speed test: " + e.getClass().getSimpleName();
        }
    }

    // ===================== Supporting Methods - Begin =====================


    /**
     * Performs a jitter test by pinging a host multiple times and calculating the standard deviation of the ping times.
     *
     * @param host The host to ping.
     * @param pingCount The number of times to ping the host.
     * @param pingTimeout The timeout in milliseconds for each ping.
     * 
     * @return A Map with the following keys:
     *         "status" - "[Pass]" if all pings were successful, "[Fail]" otherwise.
     *         "host" - The host that was pinged.
     *         "ping_count" - The number of times the host was pinged.
     *         "standard_deviation" - The standard deviation of the ping times, formatted to two decimal places.
     */
    public Map<String, String> jitter(String host, int pingCount, int pingTimeout) {
        List<Double> pingTimes = new ArrayList<>();
        int successfulPings = 0;
    
        for (int i = 0; i < pingCount; i++) {
            Map<Integer, Map<String, String>> pingResult = FW_NetworkUtils.ping(host, pingTimeout);
            if (pingResult.get(0).get("status").equals("[Pass]")) {
                successfulPings++;
                pingTimes.add(Double.parseDouble(pingResult.get(0).get("time")));
            }
        }
    
        double mean = pingTimes.stream().mapToDouble(val -> val).average().orElse(0.0);
        double standardDeviation = Math.sqrt(pingTimes.stream().mapToDouble(val -> (val - mean) * (val - mean)).average().orElse(0.0));
    
        Map<String, String> result = new HashMap<>();
        result.put("status", successfulPings == pingCount ? "[Pass]" : "[Fail]");
        result.put("host", host);
        result.put("ping_count", String.valueOf(pingCount));
        result.put("standard_deviation", String.format("%.2f", standardDeviation));
    
        return result;
    }
}