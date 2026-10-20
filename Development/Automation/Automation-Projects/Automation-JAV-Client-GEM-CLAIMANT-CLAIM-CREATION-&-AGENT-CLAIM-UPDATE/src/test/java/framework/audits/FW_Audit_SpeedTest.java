package framework.audits;

// ===============================================================
// @file: FW_Audit_SpeedTest.java
// @filepath: src/test/java/framework/audits/FW_Audit_SpeedTest.java
// @version: 8.0.0
// @updated: 2025-01-14 05:10:00 PM CDT
// @author: Greg Paskal
// @company: MissionWares
//
// @description:
// Performs a comprehensive network speed test similar to speedtest.net service.
// This class conducts location-aware speed testing using regional server pools,
// measures download and upload speeds with virtual threads for optimal performance,
// and calculates network quality metrics including latency, jitter, and overall
// connection quality. Optimized for both high-speed (US) and constrained (Rwanda)
// network environments. Now integrated with FW_NetworkUtils for improved server
// capability detection and network analysis.
//
// @methods:
// - runAuditSpeedTest(Boolean verbose) - Main audit execution method
// - speedTest(boolean verbose) - Performs standardized location-aware speed test
// - selectRegionalServers(location, verbose) - Selects appropriate regional servers
// - findBestRegionalServerWithVirtualThreads(servers, verbose) - Finds optimal server
// - performComprehensiveSpeedTest(server, location, verbose) - Full speed test execution
// - measureUploadSpeedWithVirtualThreads(server, connections, verbose) - Upload speed test
//
// @dependencies:
// - Java 23 (virtual threads)
// - framework.network.FW_NetworkDetails
// - framework.utilities.FW_NetworkUtils
// - framework.junit.FW_CustomAssertJU
//
// @tags: network, speed-test, audit, performance, virtual-threads, upload, download, mAi™
//
// @changeLog:
// Date        Author          Version  Description
// ----------  --------------  -------  --------------------------
// 2025-08-13  G. Paskal       1.0.0    Initial creation
// 2025-08-20  G. Paskal       1.1.0    Updated main method to initialize TestRunTracker
// 2025-08-21  G. Paskal       2.0.0    Encapsulated speed test methods from FW_Network
// 2025-09-09  G. Paskal       2.1.0    Updated header to mAi™ standard format
// 2025-01-30  G. Paskal       3.0.0    Optimized for Java 23 with TCP tuning and parallel improvements
// 2025-01-30  G. Paskal       4.0.0    Enhanced for US/Rwanda dual optimization with adaptive scaling
// 2025-01-30  G. Paskal       5.0.0    Added upload speed testing with server fallback logic
// 2025-01-30  G. Paskal       6.0.0    Robust location-aware upload with dynamic timeouts and sizing
// 2025-01-30  G. Paskal       7.0.0    Enhanced upload verbosity and smart retry logic for accuracy
// 2025-01-14  G. Paskal       8.0.0    Integrated FW_NetworkUtils.ServerCapabilities for improved detection
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
import framework.utilities.FW_PerformanceUtils;
import framework.utilities.FW_StringUtils;
import framework.utilities.FW_NetworkUtils;
import framework.utilities.FW_TestStepUtils;

// Java imports
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/**
 * This class performs an audit of the system network speed.
 * Contains encapsulated speed test methods for comprehensive network analysis.
 */
public class FW_Audit_SpeedTest {

    // ===================== Main Method =====================
    
    public static void main(String[] args) {

        // Initialize the Test Run Tracker to simulate a real test run environment
        FW_TestRunTracker.getInstance();
        
        // Create an instance of FW_Audit_SpeedTest
        FW_Audit_SpeedTest auditSpeedTest = new FW_Audit_SpeedTest();

        // Define audit parameters
        Boolean verbose = true; // Enable verbose logging for debugging
    
        // Run the speed test audit
        Object result = auditSpeedTest.runAuditSpeedTest(verbose);

        // Print the result
        System.out.println(FW_ConsoleColors.PINK + result + FW_ConsoleColors.RESET);
    }

    // ===================== Configuration Constants =====================
    
    // Speed test configuration - optimized for performance
    private static final int TEST_DURATION_SECONDS = 15;
    private static final int UPLOAD_TEST_DURATION_SECONDS = 10; // Shorter for upload
    private static final int BUFFER_SIZE = 2097152; // 2MB buffer
    private static final int MAX_CONNECTIONS = 40;  // Higher maximum for gigabit+ speeds
    private static final byte[] UPLOAD_BUFFER = generateUploadBuffer();
    
    // Region-specific connection limits
    private static final int MAX_CONNECTIONS_AFRICA = 12;  // Conservative for Africa
    private static final int MAX_CONNECTIONS_RWANDA = 8;   // More conservative for Rwanda
    
    // TCP Optimization settings
    static {
        // Configure system properties for optimal HTTP performance
        System.setProperty("http.maxConnections", "50");
        System.setProperty("http.keepAlive", "true");
        System.setProperty("http.maxRedirects", "5");
        System.setProperty("sun.net.http.allowRestrictedHeaders", "true");
    }

    private static byte[] generateUploadBuffer() {
        byte[] buffer = new byte[65536];
        new Random().nextBytes(buffer);
        return buffer;
    }

    private static byte[] getUploadBuffer() {
        return UPLOAD_BUFFER.clone(); // Return a copy to avoid concurrent modification
    }

    // Enhanced regional server pools with upload endpoints
    private static final Map<String, String[]> REGIONAL_SERVERS = Map.of(
        "North America", new String[]{
            "https://speed.cloudflare.com/__down",   // Download only
            "http://speedtest.tele2.net/",           // Both download and upload
            "https://proof.ovh.net/files/",          // Download only
            "http://lg-atl.velia.net/",              // Both download and upload
            "http://speedtest.fremont.linode.com/",
            "http://speedtest.seattle.linode.com/",
            "http://speedtest.atlanta.linode.com/"   // Both download and upload
        },
        "US", new String[]{
            "http://speedtest.atlanta.linode.com/",
            "http://speedtest-nyc1.digitalocean.com/",
            "http://speedtest.miami.linode.com/",
            "https://speed.cloudflare.com/__down"
        },
        "EU", new String[]{
            "https://proof.ovh.net/files/",
            "http://speedtest.tele2.net/",
            "https://bouygues.testdebit.info/",
            "http://speedtest.serverius.net/files/",
            "https://speed.cloudflare.com/__down"
        },
        "AF", new String[]{
            "https://speed.cloudflare.com/__down",    // Prioritize Cloudflare
            "http://speedtest.tele2.net/",            // Europe fallback with upload
            "https://proof.ovh.net/files/",           // Europe fallback
            "http://speedtest.mybroadband.co.za/",    // South Africa
            "http://speedtest.telkom.co.za/"          // South Africa
        },
        "AS", new String[]{
            "http://speedtest-sgp1.digitalocean.com/",
            "http://speedtest.singtel.com/",
            "https://speed.cloudflare.com/__down",
            "http://speedtest.tele2.net/"
        },
        "GLOBAL", new String[]{
            "https://speed.cloudflare.com/__down",
            "http://speedtest.tele2.net/",
            "https://proof.ovh.net/files/"
        }
    );
    
    // Store location for connection optimization
    private FW_NetworkDetails testExecutionLocation;

    // ===================== Public Methods =====================

    /**
     * This method performs an audit of network speed test.
     *
     * @param verbose If true, print detailed execution and parsing steps to standard out.
     * Defaults to false if null.
     *
     * @return Consolidated audit result details.
     */
    public Object runAuditSpeedTest(Boolean verbose) {

        // Set default value for verbose if null
        if (verbose == null) {verbose = false;}

        if (verbose) { System.out.println(FW_ConsoleColors.BLUE + "- Audit - Speed Test (Begin)" + FW_ConsoleColors.RESET);}

        // Perform comprehensive speed test using encapsulated methods
        String result = speedTest(verbose);

        // Create the overall test step result object from the speed test result
        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread(), TestStepType.AUDIT_SPEEDTEST.getValue());
        
        // Get GeoIP details for the current IP address
        FW_NetworkDetails ipNetworkDetails = FW_NetworkUtils.getLocationInfo();

        // Add GeoIP Details to the test step object
        resultObj = FW_TestStepUtils.mergeGeoIPIntoTestStep(ipNetworkDetails, resultObj);

        // Capture markers used for step duplication
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        String testSuiteName = FW_Class.extractSimpleClassName(stackTrace[2].getClassName());
        String testCaseName = stackTrace[2].getMethodName();
        String testStepMethod = stackTrace[1].getMethodName();

        // ====================================================================
        // === Prepare reporting metrics from speed test - Download - Begin ===

        // Duplicate test step to store specific metrics
        FW_TestStepUtils.duplicateTestStep(testSuiteName, testCaseName, testStepMethod);

        // Capture specific metric based on keyword
        String downloadStr = FW_StringUtils.extractFirstNumber(FW_StringUtils.parseKeywordValue(result, "Download"));

        // Transform specific metric into desired data type
        double downloadNum = (downloadStr != null) ? Double.parseDouble(downloadStr) : 0.0;

        // Create test step object for the specific metric
        FW_TestStep resultMetricDownloadObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread(), TestStepType.AUDIT_SPEEDTEST.getValue());

        // Add GeoIP Details to the test step object
        resultMetricDownloadObj = FW_TestStepUtils.mergeGeoIPIntoTestStep(ipNetworkDetails, resultMetricDownloadObj);

        // Add specific metric to the test step object
        resultMetricDownloadObj.setTestStepRefOrder(1);
        resultMetricDownloadObj.setTestStepResultMetricKey("Download");
        resultMetricDownloadObj.setTestStepResultMetricNumber(downloadNum);
        resultMetricDownloadObj.setTestStepExecuted(true);
        resultMetricDownloadObj.setTestStepDurationHR(0);
        resultMetricDownloadObj.setTestStepDurationMS(0);

        // Return the test step object for the specific metric to be processed as a result
        FW_CustomAssertJU.autoPass(resultMetricDownloadObj);
        
        // === Prepare reporting metrics from speed test - Download - End ===
        // ====================================================================

        // ====================================================================
        // === Prepare reporting metrics from speed test - Upload - Begin ===

        // Duplicate test step to store specific metrics
        FW_TestStepUtils.duplicateTestStep(testSuiteName, testCaseName, testStepMethod);

        // Capture specific metric based on keyword
        String uploadStr = FW_StringUtils.extractFirstNumber(FW_StringUtils.parseKeywordValue(result, "Upload"));

        // Transform parsed metric into number
        double uploadNum = (uploadStr != null) ? Double.parseDouble(uploadStr) : 0.0;

        // Create test step object for the specific metric
        FW_TestStep resultMetricUploadObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread(), TestStepType.AUDIT_SPEEDTEST.getValue());

        // Add GeoIP Details to the test step object
        resultMetricUploadObj = FW_TestStepUtils.mergeGeoIPIntoTestStep(ipNetworkDetails, resultMetricUploadObj);

        // Add specific audit details to the test step object
        resultMetricUploadObj.setTestStepRefOrder(2);
        resultMetricUploadObj.setTestStepResultMetricKey("Upload");
        resultMetricUploadObj.setTestStepResultMetricNumber(uploadNum);
        resultMetricUploadObj.setTestStepExecuted(true);
        resultMetricUploadObj.setTestStepDurationHR(0);
        resultMetricUploadObj.setTestStepDurationMS(0);

        // Record the individual audit step for reporting.
        FW_CustomAssertJU.autoPass(resultMetricUploadObj);

        // === Prepare reporting metrics from speed test - Upload - End ===
        // ====================================================================

        // ====================================================================
        // === Prepare reporting metrics from speed test - Latency - Begin ===

        // Duplicate test step to store specific metrics
        FW_TestStepUtils.duplicateTestStep(testSuiteName, testCaseName, testStepMethod);

        // Capture specific metric based on keyword
        String latencyStr = FW_StringUtils.extractFirstNumber(FW_StringUtils.parseKeywordValue(result, "Latency"));

        // Transform parsed metric into number
        double latencyNum = (latencyStr != null) ? Double.parseDouble(latencyStr) : 0.0;

        // Create test step object for the specific metric
        FW_TestStep resultMetricLatencyObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread(), TestStepType.AUDIT_SPEEDTEST.getValue());

        // Add GeoIP Details to the test step object
        resultMetricLatencyObj = FW_TestStepUtils.mergeGeoIPIntoTestStep(ipNetworkDetails, resultMetricLatencyObj);

        // Add specific audit details to the test step object
        resultMetricLatencyObj.setTestStepRefOrder(3);
        resultMetricLatencyObj.setTestStepResultMetricKey("Latency");
        resultMetricLatencyObj.setTestStepResultMetricNumber(latencyNum);
        resultMetricLatencyObj.setTestStepExecuted(true);
        resultMetricLatencyObj.setTestStepDurationHR(0);
        resultMetricLatencyObj.setTestStepDurationMS(0);

        // Record the individual audit step for reporting.
        FW_CustomAssertJU.autoPass(resultMetricLatencyObj);

        // === Prepare reporting metrics from speed test - Latency - End ===
        // ====================================================================

        // ====================================================================
        // === Prepare reporting metrics from speed test - Jitter - Begin ===

        // Duplicate test step for required details
        FW_TestStepUtils.duplicateTestStep(testSuiteName, testCaseName, testStepMethod);

        // Capture specific metric based on keyword
        String jitterStr = FW_StringUtils.extractFirstNumber(FW_StringUtils.parseKeywordValue(result, "Jitter"));

        // Transform parsed metric into number
        double jitterNum = (jitterStr != null) ? Double.parseDouble(jitterStr) : 0.0;

        // Create test step object for the specific metric
        FW_TestStep resultMetricJitterObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread(), TestStepType.AUDIT_SPEEDTEST.getValue());

        // Add GeoIP Details to the test step object
        resultMetricJitterObj = FW_TestStepUtils.mergeGeoIPIntoTestStep(ipNetworkDetails, resultMetricJitterObj);

        // Add specific audit details to the test step object
        resultMetricJitterObj.setTestStepRefOrder(4);
        resultMetricJitterObj.setTestStepResultMetricKey("Jitter");
        resultMetricJitterObj.setTestStepResultMetricNumber(jitterNum);
        resultMetricJitterObj.setTestStepExecuted(true);
        resultMetricJitterObj.setTestStepDurationHR(0);
        resultMetricJitterObj.setTestStepDurationMS(0);

        // Record the individual audit step for reporting.
        FW_CustomAssertJU.autoPass(resultMetricJitterObj);

        // === Prepare reporting metrics from speed test - Jitter - End ===
        // ====================================================================

        // ====================================================================
        // === Prepare reporting metrics from speed test - Quality - Begin ===

        // Duplicate test step for required details
        FW_TestStepUtils.duplicateTestStep(testSuiteName, testCaseName, testStepMethod);

        // Capture specific metric based on keyword
        String qualityStr = FW_StringUtils.extractFirstNumber(FW_StringUtils.parseKeywordValue(result, "Quality"));

        // Transform parsed metric into number
        double qualityNum = (qualityStr != null) ? Double.parseDouble(qualityStr.split("/")[0]) : 0.0;
        
        // Create test step object for the specific metric
        FW_TestStep resultMetricQualityObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread(), TestStepType.AUDIT_SPEEDTEST.getValue());

        // Add GeoIP Details to the test step object
        resultMetricQualityObj = FW_TestStepUtils.mergeGeoIPIntoTestStep(ipNetworkDetails, resultMetricQualityObj);

        // Add specific audit details to the test step object
        resultMetricQualityObj.setTestStepRefOrder(5);
        resultMetricQualityObj.setTestStepResultMetricKey("Quality");
        resultMetricQualityObj.setTestStepResultMetricNumber(qualityNum);
        resultMetricQualityObj.setTestStepExecuted(true);
        resultMetricQualityObj.setTestStepDurationHR(0);
        resultMetricQualityObj.setTestStepDurationMS(0);

        // Record the individual audit step for reporting.
        FW_CustomAssertJU.autoPass(resultMetricQualityObj);

        // === Prepare reporting metrics from speed test - Quality - End ===
        // ====================================================================

        if (verbose) {System.out.println(FW_ConsoleColors.BLUE + "- Audit - Speed Test (End)" + FW_ConsoleColors.RESET);}

        return resultObj;
    }

    // ===================== Private Speed Test Methods (Encapsulated) =====================

    /**
     * Performs a standardized location-aware speed test with optional verbose output.
     * Uses Java 23 virtual threads for optimal performance.
     *
     * @param verbose If true, prints detailed progress information
     * @return A comprehensive speed test result string
     */
    private String speedTest(boolean verbose) {
        Instant startTime = Instant.now();
        
        try {

            // Phase 1: Detect testing execution location
            if (verbose) {printJourneyHeader("PHASE 1: LOCATION DISCOVERY", "Determining current network location and regional context");}

            testExecutionLocation = FW_NetworkUtils.getLocationInfo();
            
            if (verbose && testExecutionLocation != null) {
                System.out.printf(FW_ConsoleColors.BLUE + "Detected location: %s, %s, %s%n" + FW_ConsoleColors.RESET,
                    testExecutionLocation.getCity(), 
                    testExecutionLocation.getRegion(), 
                    testExecutionLocation.getCountryCode());
            }
            
            // Phase 2: Select regional servers based on location
            if (verbose) {printJourneyHeader("PHASE 2: REGIONAL SERVER SELECTION", "Identifying optimal server pools for your region");}

            String[] testExecutionLocationRegionalServers = selectRegionalServers(testExecutionLocation, verbose);
            
            if (testExecutionLocationRegionalServers == null || testExecutionLocationRegionalServers.length == 0) {
                return "[Fail] - Unable to determine regional servers for location";
            }

            // Phase 3: Find best server from regional pool
            if (verbose) {printJourneyHeader("PHASE 3: SERVER LATENCY TESTING", "Sending scout connections to find the fastest responding server");}

            String bestSpeedTestServerLocation = findBestRegionalServerWithVirtualThreads(testExecutionLocationRegionalServers, verbose);
            if (bestSpeedTestServerLocation == null) {
                return "[Fail] - No responsive servers found in regional pool";
            }

            SpeedTestResult result = performComprehensiveSpeedTest(bestSpeedTestServerLocation, testExecutionLocation, verbose);

            // Calculate elapsed time
            Instant currentTime = Instant.now();
            double elapsedTimeSeconds = FW_PerformanceUtils.calcElapsedTime(startTime, currentTime);

            if (result.successful()) {

                if (verbose) {
                    long totalTimeMs = Duration.between(startTime, Instant.now()).toMillis();
                    printJourneySummary(result, totalTimeMs);
                }

                return String.format("[Pass] - {%.2f} - Download: %.2f Mbps, Upload: %.2f Mbps, Latency: %.1f ms, Jitter: %.1f ms, Quality: %.0f/100 (%s), Location: %s, Server: %s", 
                    elapsedTimeSeconds,
                    result.downloadSpeed(),
                    result.uploadSpeed(),
                    result.latency(), 
                    result.jitter(),
                    result.qualityScore(),
                    result.qualityRating(),
                    (testExecutionLocation != null ? testExecutionLocation.getCity() + ", " + testExecutionLocation.getRegion() + ", " + testExecutionLocation.getCountryCode() : "Unknown"), 
                    bestSpeedTestServerLocation);
            } else {
                return "[Fail] - {0.0} - " + result.errorMessage();
            }

        } catch (Exception e) {
            return "[Fail] - {0.0} - Standardized speed test error: " + e.getMessage();
        }
    }

    /**
     * Selects appropriate regional servers based on location.
     * Enhanced for Rwanda/Africa optimization.
     *
     * @param location The network location details
     * @param verbose Whether to print verbose output
     * @return Array of regional server URLs
     */
    private String[] selectRegionalServers(FW_NetworkDetails location, boolean verbose) {
        String region = "GLOBAL";
        
        if (location != null) {
            // Check for specific countries first
            if ("RW".equals(location.getCountryCode()) || 
                "KE".equals(location.getCountryCode()) || 
                "UG".equals(location.getCountryCode()) ||
                "TZ".equals(location.getCountryCode()) ||
                "BI".equals(location.getCountryCode())) {
                // East African countries - use Africa pool with Cloudflare priority
                region = "AF";
            } else if (location.getContinent() != null && !location.getContinent().isEmpty()) {
                region = location.getContinent();
            }
        }
        
        String[] servers = REGIONAL_SERVERS.getOrDefault(region, REGIONAL_SERVERS.get("GLOBAL"));
        
        if (verbose) {
            System.out.printf(FW_ConsoleColors.BLUE + "Selected regional server pool: %s (%d servers)%n" + FW_ConsoleColors.RESET, 
                region, servers.length);
        }
        
        return servers;
    }

    /**
     * Finds the best server using virtual threads for parallel testing.
     * Adjusted timeouts for high-latency regions.
     *
     * @param servers Array of server URLs to test
     * @param verbose Whether to print verbose output
     * @return URL of the best performing server
     */
    private String findBestRegionalServerWithVirtualThreads(String[] servers, boolean verbose) {
        if (verbose) {
            System.out.println(FW_ConsoleColors.BLUE + "Testing regional servers with virtual threads..." + FW_ConsoleColors.RESET);
        }

        // Adjust timeout based on location
        int timeoutSeconds = isConstrainedNetwork() ? 20 : 15;

        try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
            var serverLatencies = new ConcurrentHashMap<String, Double>();
            var latch = new CountDownLatch(servers.length);

            for (String server : servers) {
                executor.submit(() -> {
                    try {
                        double latency = measureServerLatencyFast(server);
                        if (latency < 3000) { // Allow higher latency for Africa
                            serverLatencies.put(server, latency);
                        }
                        if (verbose) {
                            System.out.printf(FW_ConsoleColors.DARK_GREY + "  Server %s: %.1f ms%n" + FW_ConsoleColors.RESET, 
                                server, latency);
                        }
                    } catch (Exception e) {
                        if (verbose) {
                            System.out.printf(FW_ConsoleColors.YELLOW + "  Server %s: unreachable%n" + FW_ConsoleColors.RESET, 
                                server);
                        }
                    } finally {
                        latch.countDown();
                    }
                });
            }

            try {
                latch.await(timeoutSeconds, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            String bestServer = serverLatencies.entrySet().stream()
                .min(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);

            if (verbose && bestServer != null) {
                System.out.printf(FW_ConsoleColors.GREEN + "  Best regional server: %s (%.1f ms)%n" + FW_ConsoleColors.RESET, 
                    bestServer, serverLatencies.get(bestServer));
            }

            return bestServer;
        }
    }

    /**
     * Performs comprehensive speed test with all metrics including upload.
     * Now uses FW_NetworkUtils for enhanced server capability detection.
     *
     * @param server The server URL to test against
     * @param location The network location details
     * @param verbose Whether to print verbose output
     * @return SpeedTestResult containing all test metrics
     */
    private SpeedTestResult performComprehensiveSpeedTest(String server, FW_NetworkDetails location, boolean verbose) {
        try {
            // PHASE 4: CONNECTION OPTIMIZATION
            if (verbose) {
                System.out.println("\n" + FW_ConsoleColors.CORAL + "═══════════════════════════════════════════════════════════════════" + FW_ConsoleColors.RESET);
                System.out.println(FW_ConsoleColors.CORAL + "▶ PHASE 4: CONNECTION OPTIMIZATION" + FW_ConsoleColors.RESET);
                System.out.println(FW_ConsoleColors.BLUE + "  Analyzing network capacity to determine optimal connection count" + FW_ConsoleColors.RESET);
                System.out.println(FW_ConsoleColors.CORAL + "───────────────────────────────────────────────────────────────────" + FW_ConsoleColors.RESET);
            }

            // Determine optimal connection count with location awareness
            int optimalConnections = determineOptimalConnections(server, verbose);
            
            if (verbose) {System.out.println(FW_ConsoleColors.GREEN + "  ✓ Optimal connections determined: " + optimalConnections + FW_ConsoleColors.RESET);}
            
            // PHASE 5: DOWNLOAD SPEED TEST
            if (verbose) {
                System.out.println("\n" + FW_ConsoleColors.CORAL + "═══════════════════════════════════════════════════════════════════" + FW_ConsoleColors.RESET);
                System.out.println(FW_ConsoleColors.CORAL + "▶ PHASE 5: DOWNLOAD SPEED TEST" + FW_ConsoleColors.RESET);
                System.out.println(FW_ConsoleColors.BLUE + "  Deploying " + optimalConnections + " parallel connections for maximum throughput measurement" + FW_ConsoleColors.RESET);
                System.out.println(FW_ConsoleColors.CORAL + "───────────────────────────────────────────────────────────────────" + FW_ConsoleColors.RESET);
            }
            
            // Perform main download test
            double downloadSpeed = measureDownloadSpeedWithVirtualThreads(server, optimalConnections, verbose);
            
            if (verbose) {System.out.println(FW_ConsoleColors.GREEN + String.format("  ✓ Download test complete: %.2f Mbps", downloadSpeed) + FW_ConsoleColors.RESET);}
            
            // PHASE 6: UPLOAD SPEED TEST
            if (verbose) {
                System.out.println("\n" + FW_ConsoleColors.CORAL + "═══════════════════════════════════════════════════════════════════" + FW_ConsoleColors.RESET);
                System.out.println(FW_ConsoleColors.CORAL + "▶ PHASE 6: UPLOAD SPEED TEST" + FW_ConsoleColors.RESET);
                System.out.println(FW_ConsoleColors.BLUE + "  Testing outbound capacity with adaptive connection management" + FW_ConsoleColors.RESET);
                System.out.println(FW_ConsoleColors.CORAL + "───────────────────────────────────────────────────────────────────" + FW_ConsoleColors.RESET);
            }
            
            // Perform upload test with retry logic using enhanced server detection
            double uploadSpeed = 0.0;
            String uploadEndpoint = findUploadCapableServerEnhanced(server, verbose);
            
            if (uploadEndpoint != null) {
                String uploadServerHost = uploadEndpoint.replace("http://", "").replace("https://", "").split("/")[0];
                if (verbose) {System.out.println(FW_ConsoleColors.BLUE + "  Upload server: " + uploadServerHost + FW_ConsoleColors.RESET);}
                
                int uploadConnections = determineOptimalUploadConnections(downloadSpeed, verbose);
                
                // Try upload test with retry logic
                for (int attempt = 1; attempt <= 2; attempt++) {
                    if (verbose && attempt > 1) {System.out.println(FW_ConsoleColors.YELLOW + "  ⚠ Upload test retry needed (attempt " + attempt + "/2)" + FW_ConsoleColors.RESET);}
                    
                    uploadSpeed = measureUploadSpeedWithVirtualThreads(uploadEndpoint, uploadConnections, verbose);
                    
                    if (uploadSpeed > 0) {
                        if (verbose) {System.out.println(FW_ConsoleColors.GREEN + String.format("  ✓ Upload test complete: %.2f Mbps", uploadSpeed) + FW_ConsoleColors.RESET);}
                        break; // Success, exit retry loop
                    }
                    
                    // If first attempt failed, try with fewer connections
                    if (attempt == 1) {
                        uploadConnections = Math.max(4, uploadConnections / 2);
                        if (verbose) {System.out.println(FW_ConsoleColors.YELLOW + "  ↻ Reducing connections to " + uploadConnections + " for retry" + FW_ConsoleColors.RESET);}
                    }
                }
                
                if (uploadSpeed == 0 && verbose) {System.out.println(FW_ConsoleColors.RED + "  ✗ Upload test failed after retries" + FW_ConsoleColors.RESET);}
            } else if (verbose) {System.out.println(FW_ConsoleColors.YELLOW + "  ⚠ No upload-capable server available - skipping upload test" + FW_ConsoleColors.RESET);}
            
            // PHASE 7: NETWORK QUALITY ASSESSMENT
            if (verbose) {
                System.out.println("\n" + FW_ConsoleColors.CORAL + "═══════════════════════════════════════════════════════════════════" + FW_ConsoleColors.RESET);
                System.out.println(FW_ConsoleColors.CORAL + "▶ PHASE 7: NETWORK QUALITY ASSESSMENT" + FW_ConsoleColors.RESET);
                System.out.println(FW_ConsoleColors.BLUE + "  Measuring latency, jitter, and calculating overall connection quality" + FW_ConsoleColors.RESET);
                System.out.println(FW_ConsoleColors.CORAL + "───────────────────────────────────────────────────────────────────" + FW_ConsoleColors.RESET);
            }
            
            // Measure latency with improved accuracy
            if (verbose) {System.out.print(FW_ConsoleColors.DARK_GREY + "  Measuring latency..." + FW_ConsoleColors.RESET);}
            double latency = measureServerLatency(server);
            if (verbose) {System.out.println(FW_ConsoleColors.GREEN + String.format(" %.1f ms", latency) + FW_ConsoleColors.RESET);}
            
            // Measure jitter using FW_NetworkUtils's jitter method
            if (verbose) {System.out.print(FW_ConsoleColors.DARK_GREY + "  Measuring jitter..." + FW_ConsoleColors.RESET);}
            String hostname = server.replace("http://", "").replace("https://", "").split("/")[0];
            Map<String, String> jitterResult = FW_NetworkUtils.jitter(hostname, 10, 1000);
            double jitterMs = Double.parseDouble(jitterResult.get("standard_deviation"));
            if (verbose) {System.out.println(FW_ConsoleColors.GREEN + String.format(" %.1f ms", jitterMs) + FW_ConsoleColors.RESET);}
            
            // Calculate quality score with upload included
            double qualityScore = calculateConnectionQualityWithUpload(downloadSpeed, uploadSpeed, latency, jitterMs);
            String qualityRating = qualityScore >= 80 ? "Excellent" : 
                                qualityScore >= 60 ? "Good" :
                                qualityScore >= 40 ? "Fair" :
                                qualityScore >= 20 ? "Poor" : "Very Poor";
            
            if (verbose) {System.out.println(FW_ConsoleColors.GREEN + String.format("  ✓ Quality score calculated: %.0f/100 (%s)", qualityScore, qualityRating) + FW_ConsoleColors.RESET);}
            
            return new SpeedTestResult(
                downloadSpeed, 
                uploadSpeed,
                latency, 
                jitterMs, 
                qualityScore, 
                null,  // Quality rating will be auto-calculated
                location, 
                server, 
                true, 
                null
            );
            
        } catch (Exception e) {
            if (verbose) {System.out.println(FW_ConsoleColors.RED + "  ✗ Comprehensive test failed: " + e.getMessage() + FW_ConsoleColors.RESET);}
            return new SpeedTestResult(0, 0, 0, 0, 0, "Failed", location, server, false, "Comprehensive test failed: " + e.getMessage());
        }
    }

    // ===================== Private Helper Methods =====================

    /**
     * Enhanced method to find an upload-capable server using FW_NetworkUtils.
     * Leverages the new ServerCapabilities detection for more reliable results.
     */
    private String findUploadCapableServerEnhanced(String currentServer, boolean verbose) {
        // First check if current server supports upload using FW_NetworkUtils
        FW_NetworkUtils.ServerCapabilities currentCaps = FW_NetworkUtils.checkServerCapabilities(currentServer);
        
        if (currentCaps.supportsUpload() && currentCaps.uploadEndpoint() != null) {
            if (verbose) {
                System.out.println(FW_ConsoleColors.GREEN + 
                    "  Current server supports upload testing" + 
                    FW_ConsoleColors.RESET);
            }
            return currentCaps.uploadEndpoint();
        }
        
        // Current server doesn't support upload, find alternative
        if (verbose) {
            System.out.println(FW_ConsoleColors.YELLOW + 
                "  Current server doesn't support upload, scanning for alternatives..." + 
                FW_ConsoleColors.RESET);
        }
        
        // Test a prioritized list of fallback servers
        String[] fallbackServers = {
            "http://speedtest.tele2.net",
            "http://speed.hetzner.de",
            "http://speedtest-nyc1.digitalocean.com",
            "http://speedtest.atlanta.linode.com",
            "http://speedtest.miami.linode.com",
            "http://speedtest.mybroadband.co.za"
        };
        
        // Use virtual threads to check multiple servers in parallel
        try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
            var validServers = new ConcurrentHashMap<String, String>();
            var latch = new CountDownLatch(fallbackServers.length);
            
            for (String fallback : fallbackServers) {
                executor.submit(() -> {
                    try {
                        FW_NetworkUtils.ServerCapabilities caps = FW_NetworkUtils.checkServerCapabilities(fallback);
                        if (caps.supportsUpload() && caps.uploadEndpoint() != null) {
                            validServers.put(fallback, caps.uploadEndpoint());
                            if (verbose) {
                                System.out.println(FW_ConsoleColors.DARK_GREY + 
                                    "    ✓ " + fallback + " supports upload" + 
                                    FW_ConsoleColors.RESET);
                            }
                        }
                    } catch (Exception e) {
                        // Server not reachable, ignore
                    } finally {
                        latch.countDown();
                    }
                });
            }
            
            // Wait for all checks to complete
            try {
                latch.await(5, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            
            // Return the first valid server found
            if (!validServers.isEmpty()) {
                Map.Entry<String, String> entry = validServers.entrySet().iterator().next();
                if (verbose) {
                    System.out.println(FW_ConsoleColors.BLUE + 
                        "  Using fallback server for upload: " + entry.getKey() + 
                        FW_ConsoleColors.RESET);
                }
                return entry.getValue();
            }
        }
        
        if (verbose) {
            System.out.println(FW_ConsoleColors.YELLOW + 
                "  No upload-capable servers found" + 
                FW_ConsoleColors.RESET);
        }
        
        return null; // No upload-capable server found
    }

    /**
     * Checks if we're on a constrained network (Rwanda or Africa).
     */
    private boolean isConstrainedNetwork() {
        return testExecutionLocation != null && 
               ("RW".equals(testExecutionLocation.getCountryCode()) || 
                "AF".equals(testExecutionLocation.getContinent()));
    }

    /**
     * Checks if we're specifically in Rwanda.
     */
    private boolean isRwanda() {
        return testExecutionLocation != null && 
               "RW".equals(testExecutionLocation.getCountryCode());
    }

    /**
     * Determines optimal upload connection count based on download speed and location.
     */
    private int determineOptimalUploadConnections(double downloadSpeed, boolean verbose) {
        int connections;
        
        if (isRwanda()) {
            // Very conservative for Rwanda
            if (downloadSpeed < 5) {
                connections = 1;
            } else if (downloadSpeed < 20) {
                connections = 2;
            } else {
                connections = 4;
            }
        } else if (isConstrainedNetwork()) {
            // Conservative for Africa
            if (downloadSpeed < 20) {
                connections = 4;
            } else if (downloadSpeed < 50) {
                connections = 8;
            } else {
                connections = 12;
            }
        } else {
            // Reduced but still aggressive for US/high-speed
            if (downloadSpeed < 100) {
                connections = 8;
            } else if (downloadSpeed < 500) {
                connections = 16;
            } else if (downloadSpeed < 800) {
                connections = 20;
            } else {
                connections = 24;  // Reduced from 40 for more stable results
            }
        }
        
        if (verbose) {
            String locationNote = isRwanda() ? " (Rwanda: 3-10 Mbps expected)" : 
                                isConstrainedNetwork() ? " (Africa: 10-50 Mbps expected)" : 
                                " (US: 600-800 Mbps expected)";
            System.out.printf(FW_ConsoleColors.BLUE + 
                "  Using %d connections for upload test%s%n" + 
                FW_ConsoleColors.RESET, connections, locationNote);
        }
        
        return connections;
    }

    /**
     * Measures upload speed with enhanced verbosity and proper timeout handling.
     */
    private double measureUploadSpeedWithVirtualThreads(String uploadUrl, int connections, boolean verbose) 
            throws InterruptedException {
        
        // Add progress tracking
        AtomicInteger activeUploads = new AtomicInteger(0);
        AtomicInteger successfulUploads = new AtomicInteger(0);
        AtomicInteger failedUploads = new AtomicInteger(0);
        
        if (verbose) {
            System.out.printf(FW_ConsoleColors.BLUE + 
                "  Starting %d-connection upload test to %s (%d seconds)...%n" + 
                FW_ConsoleColors.RESET, connections, 
                uploadUrl.replace("http://", "").replace("https://", "").split("/")[0], 
                UPLOAD_TEST_DURATION_SECONDS);
        }
        
        // Use ExecutorService that we can shutdown forcefully
        var executor = Executors.newVirtualThreadPerTaskExecutor();
        
        try {
            final ConcurrentHashMap<Integer, Double> connectionSpeeds = new ConcurrentHashMap<>();
            CountDownLatch completionLatch = new CountDownLatch(connections);
            
            // Track thread references for forced interruption
            List<Thread> uploadThreads = Collections.synchronizedList(new ArrayList<>());
                        
            for (int i = 0; i < connections; i++) {
                final int connectionId = i;
                executor.submit(() -> {
                    // Store thread reference
                    Thread currentThread = Thread.currentThread();
                    uploadThreads.add(currentThread);
                    
                    activeUploads.incrementAndGet();
                    if (verbose) {
                        printProgressBar(activeUploads.get(), connections, "Uploading");
                    }
                    
                    try {
                        // Add per-connection timeout
                        long connectionTimeout = (UPLOAD_TEST_DURATION_SECONDS + 2) * 1000L;
                        long bytesUploaded = uploadForDurationWithTimeout(
                            uploadUrl, 
                            connectionId,
                            UPLOAD_TEST_DURATION_SECONDS * 1000L,
                            connectionTimeout,
                            false
                        );
                        
                        if (bytesUploaded > 0) {
                            double duration = UPLOAD_TEST_DURATION_SECONDS;
                            double speedMbps = (bytesUploaded * 8.0 / (1024.0 * 1024.0)) / duration;
                            
                            // Only include reasonable speeds (filter outliers)
                            if (speedMbps > 0.5 && speedMbps < 2000) { // Lowered threshold
                                connectionSpeeds.put(connectionId, speedMbps);
                                successfulUploads.incrementAndGet();
                                
                                if (verbose) {
                                    System.out.print("\r" + " ".repeat(70) + "\r");
                                    System.out.printf(FW_ConsoleColors.DARK_GREY + 
                                        "    Connection %d: SUCCESS - %.1f Mbps (%d/%d successful)%n" + 
                                        FW_ConsoleColors.RESET, connectionId, speedMbps,
                                        successfulUploads.get(), connections);
                                }
                            }
                        } else {
                            failedUploads.incrementAndGet();
                            if (verbose) {
                                System.out.print("\r" + " ".repeat(70) + "\r");
                                System.out.printf(FW_ConsoleColors.YELLOW + 
                                    "    Connection %d: No data uploaded%n" + 
                                    FW_ConsoleColors.RESET, connectionId);
                            }
                        }
                    } catch (InterruptedException e) {
                        // Thread was interrupted by timeout
                        Thread.currentThread().interrupt();
                        failedUploads.incrementAndGet();
                        if (verbose) {
                            System.out.print("\r" + " ".repeat(70) + "\r");
                            System.out.printf(FW_ConsoleColors.YELLOW + 
                                "    Connection %d: TIMEOUT - interrupted%n" + 
                                FW_ConsoleColors.RESET, connectionId);
                        }
                    }
                    // Removed the catch(Exception) block since uploadForDurationWithTimeout only throws InterruptedException now
                    finally {
                        activeUploads.decrementAndGet();
                        completionLatch.countDown();
                        uploadThreads.remove(Thread.currentThread());
                        
                        if (verbose && activeUploads.get() > 0) {
                            printProgressBar((int)(connections - completionLatch.getCount()), 
                                        connections, "Uploading");
                        }
                    }
                });
            }
            
            // Wait with absolute timeout and force shutdown if needed
            boolean completed = completionLatch.await(UPLOAD_TEST_DURATION_SECONDS + 5, TimeUnit.SECONDS);
            
            if (!completed) {
                // Force shutdown - interrupt all hanging threads
                if (verbose) {
                    System.out.print("\r" + " ".repeat(70) + "\r");
                    System.out.println(FW_ConsoleColors.YELLOW + 
                        "  ⚠ Upload test timeout reached - forcing thread termination" + 
                        FW_ConsoleColors.RESET);
                }
                
                // Interrupt all remaining threads
                uploadThreads.forEach(Thread::interrupt);
                
                // Shutdown executor immediately
                executor.shutdownNow();
                
                // Give threads a moment to clean up
                FW_DateTimeUtils.waitForDuration(500, "ms", false);
            }
            
            // Clear the progress bar line if still visible
            if (verbose) {
                System.out.print("\r" + " ".repeat(70) + "\r");
            }

            // Calculate results based on what completed
            if (connectionSpeeds.isEmpty()) {
                if (verbose) {
                    System.out.println(FW_ConsoleColors.YELLOW + 
                        "  ⚠ No successful upload connections" + FW_ConsoleColors.RESET);
                }
                return 0.0;
            }
            
            // Convert to list and sort
            List<Double> speeds = new ArrayList<>(connectionSpeeds.values());
            Collections.sort(speeds);
            
            // Remove outliers if we have enough samples
            if (speeds.size() > 5) {
                int trimCount = speeds.size() / 4;
                speeds = speeds.subList(trimCount, speeds.size() - trimCount);
            }
            
            // Calculate aggregate speed
            double medianSpeed = speeds.get(speeds.size() / 2);
            double totalSpeed = medianSpeed * speeds.size();
            
            if (verbose) {
                System.out.printf(FW_ConsoleColors.GREEN + 
                    "  Upload result: %.1f Mbps median × %d connections = %.1f Mbps total%n" + 
                    FW_ConsoleColors.RESET, 
                    medianSpeed, speeds.size(), totalSpeed);
                
                System.out.printf(FW_ConsoleColors.BLUE + 
                    "  Connection summary: %d successful, %d failed out of %d total%n" + 
                    FW_ConsoleColors.RESET, 
                    successfulUploads.get(), failedUploads.get(), connections);
            }
            
            return Math.min(totalSpeed, 950); // Sanity cap for gigabit
            
        } finally {
            // Ensure executor is always shut down
            if (!executor.isShutdown()) {
                executor.shutdownNow();
            }
        }
    }

    private long uploadForDurationWithTimeout(String urlString, int connectionId, long durationMs, long absoluteTimeoutMs, boolean verbose) 
            throws InterruptedException {
        
        long totalBytes = 0;
        long startTime = System.currentTimeMillis();
        long absoluteEndTime = startTime + absoluteTimeoutMs;
        
        // Start with reasonable chunk size
        long chunkSize = 10 * 1024 * 1024; // 10MB chunks
        int consecutiveFailures = 0;
        
        while (System.currentTimeMillis() - startTime < durationMs) {
            // Check absolute timeout
            if (System.currentTimeMillis() > absoluteEndTime) {
                if (verbose) {
                    System.out.printf(FW_ConsoleColors.YELLOW + 
                        "    Connection %d: Absolute timeout reached%n" + 
                        FW_ConsoleColors.RESET, connectionId);
                }
                break;
            }
            
            // Check for thread interruption
            if (Thread.currentThread().isInterrupted()) {
                throw new InterruptedException("Upload thread interrupted");
            }
            
            try {
                long chunkBytes = uploadChunkWithTimeout(urlString, chunkSize, 5000); // 5 second chunk timeout
                if (chunkBytes > 0) {
                    totalBytes += chunkBytes;
                    consecutiveFailures = 0;
                    
                    // Gradually increase chunk size on success
                    if (chunkSize < 50 * 1024 * 1024) {
                        chunkSize = Math.min(chunkSize * 2, 50 * 1024 * 1024);
                    }
                }
            } catch (InterruptedException e) {
                // Re-throw interruption to maintain thread interruption status
                throw e;
            } catch (IOException e) {
                // Handle network/IO failures
                consecutiveFailures++;
                if (consecutiveFailures > 3) {
                    // Too many failures, give up on this connection
                    if (verbose) {
                        System.out.printf(FW_ConsoleColors.YELLOW + 
                            "    Connection %d: Too many consecutive failures%n" + 
                            FW_ConsoleColors.RESET, connectionId);
                    }
                    break;
                }
                
                // Reduce chunk size on failure
                chunkSize = Math.max(chunkSize / 2, 1024 * 1024); // Min 1MB
            }
            
            // Check remaining time
            if (System.currentTimeMillis() - startTime > durationMs - 500) {
                break;
            }
        }
        
        return totalBytes;
    }

    private long uploadChunkWithTimeout(String urlString, long targetSize, int timeoutMs) 
            throws IOException, InterruptedException {
        
        URL url = URI.create(urlString).toURL();
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        
        try {
            // Set aggressive timeouts
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setRequestMethod("POST");
            connection.setConnectTimeout(Math.min(timeoutMs, 3000));
            connection.setReadTimeout(timeoutMs);
            connection.setChunkedStreamingMode(65536);
            connection.setRequestProperty("Connection", "close"); // Don't keep alive
            
            String hostname = url.getHost();
            boolean isTele2 = hostname.contains("tele2");
            
            if (isTele2) {
                String boundary = "----WebKitFormBoundary7MA4YWxkTrZu0gW";
                connection.setRequestProperty("Content-Type", 
                    "multipart/form-data; boundary=" + boundary);
            } else {
                connection.setRequestProperty("Content-Type", "application/octet-stream");
            }
            
            connection.setRequestProperty("User-Agent", "Mozilla/5.0 SpeedTest/8.0");
            connection.setUseCaches(false);
            
            // Reuse a pre-generated pattern for efficiency
            byte[] buffer = getUploadBuffer();
            
            long bytesWritten = 0;
            
            try (OutputStream out = connection.getOutputStream();
                BufferedOutputStream bufferedOut = new BufferedOutputStream(out, 131072)) {
                
                if (isTele2) {
                    String boundary = "----WebKitFormBoundary7MA4YWxkTrZu0gW";
                    String header = "--" + boundary + "\r\n" +
                                "Content-Disposition: form-data; name=\"upload_file\"; " +
                                "filename=\"speedtest.dat\"\r\n" +
                                "Content-Type: application/octet-stream\r\n\r\n";
                    bufferedOut.write(header.getBytes());
                }
                
                while (bytesWritten < targetSize) {
                    // Check for interruption
                    if (Thread.currentThread().isInterrupted()) {
                        throw new InterruptedException("Upload interrupted");
                    }
                    
                    bufferedOut.write(buffer);
                    bytesWritten += buffer.length;
                    
                    // Flush periodically
                    if (bytesWritten % (5 * 1024 * 1024) == 0) {
                        bufferedOut.flush();
                    }
                }
                
                if (isTele2) {
                    String boundary = "----WebKitFormBoundary7MA4YWxkTrZu0gW";
                    String footer = "\r\n--" + boundary + "--\r\n";
                    bufferedOut.write(footer.getBytes());
                }
                
                bufferedOut.flush();
            }
            
            // Get response with timeout
            int responseCode = connection.getResponseCode();
            
            if (responseCode >= 200 && responseCode < 300) {
                return bytesWritten;
            } else if (responseCode == 413) {
                throw new IOException("Chunk too large - reduce size");
            } else {
                throw new IOException("Server returned HTTP " + responseCode);
            }
            
        } finally {
            connection.disconnect();
        }
    }

    /**
     * Measures server latency for selection using GET request for accuracy.
     * Adjusted for high-latency networks.
     *
     * @param serverUrl The server URL to test
     * @return Latency in milliseconds
     * @throws Exception If connection fails
     */
    private double measureServerLatencyFast(String serverUrl) throws Exception {
        Instant start = Instant.now();
        
        // Adjust URL for different server types
        String testUrl;
        if (serverUrl.contains("cloudflare.com/__down")) {
            testUrl = serverUrl + "?bytes=1024";
        } else if (serverUrl.endsWith("/")) {
            testUrl = serverUrl + "1KB.zip";
        } else {
            testUrl = serverUrl + "/1KB.zip";
        }
        
        URL url = URI.create(testUrl).toURL();

        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        // Increase timeouts for constrained networks
        connection.setConnectTimeout(isConstrainedNetwork() ? 10000 : 5000);
        connection.setReadTimeout(isConstrainedNetwork() ? 15000 : 10000);
        connection.setRequestProperty("User-Agent", "Mozilla/5.0 (compatible; SpeedTest/8.0)");
        
        // Actually read first byte to measure true latency
        try (InputStream is = connection.getInputStream()) {
            is.read(); // Read first byte
        }
        
        Instant end = Instant.now();
        double latency = Duration.between(start, end).toMillis() / 2.0; // Divide by 2 for one-way latency
        connection.disconnect();
        
        return latency;
    }

    /**
     * Determines optimal connection count with location-aware scaling.
     * Conservative for Rwanda, aggressive for US.
     *
     * @param server The server URL to test against
     * @param verbose Whether to print verbose output
     * @return Optimal number of connections to use
     */
    private int determineOptimalConnections(String server, boolean verbose) {
        try {
            // Fewer initial connections for constrained networks
            int testConnections = isConstrainedNetwork() ? 4 : 8;
            long totalBytes = downloadMultipleConnections(server, testConnections, 2000);
            double speedMbps = (totalBytes * 8.0) / (1024.0 * 1024.0 * 2.0);
            
            int connections;
            int maxAllowed;
            
            // Determine max connections based on location
            if (isRwanda()) {
                maxAllowed = MAX_CONNECTIONS_RWANDA;
                if (speedMbps < 5) {
                    connections = 2;
                } else if (speedMbps < 15) {
                    connections = 4;
                } else if (speedMbps < 30) {
                    connections = 6;
                } else {
                    connections = 8;  // Max for Rwanda even on fiber
                }
            } else if (isConstrainedNetwork()) {
                maxAllowed = MAX_CONNECTIONS_AFRICA;
                if (speedMbps < 10) {
                    connections = 4;
                } else if (speedMbps < 50) {
                    connections = 8;
                } else {
                    connections = 12;
                }
            } else {
                // US/High-speed optimization
                maxAllowed = MAX_CONNECTIONS;
                if (speedMbps < 10) {
                    connections = 6;
                } else if (speedMbps < 50) {
                    connections = 12;
                } else if (speedMbps < 200) {
                    connections = 16;
                } else if (speedMbps < 500) {
                    connections = 24;
                } else if (speedMbps < 800) {
                    connections = 32;
                } else {
                    connections = 40;  // Gigabit+
                }
            }
            
            connections = Math.min(connections, maxAllowed);
            
            if (verbose) {
                String locationNote = isRwanda() ? " (Rwanda optimization)" : 
                                    isConstrainedNetwork() ? " (Africa optimization)" : "";
                System.out.printf(FW_ConsoleColors.BLUE + "  Speed estimate: %.1f Mbps, using %d connections%s%n" + 
                    FW_ConsoleColors.RESET, speedMbps, connections, locationNote);
            }
            
            return connections;
            
        } catch (Exception e) {
            return isConstrainedNetwork() ? 4 : 8;
        }
    }

    /**
     * Downloads using multiple connections for speed estimation.
     *
     * @param server The server URL
     * @param connections Number of parallel connections
     * @param timeoutMs Timeout in milliseconds
     * @return Total bytes downloaded
     * @throws Exception If download fails
     */
    private long downloadMultipleConnections(String server, int connections, long timeoutMs) throws Exception {
        try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
            var totalBytes = new AtomicLong(0);
            var latch = new CountDownLatch(connections);
            
            String testUrl;
            if (server.contains("cloudflare.com/__down")) {
                testUrl = server + "?bytes=10485760";
            } else if (server.endsWith("/")) {
                testUrl = server + "10MB.zip";
            } else {
                testUrl = server + "/10MB.zip";
            }
            
            for (int i = 0; i < connections; i++) {
                executor.submit(() -> {
                    try {
                        long bytes = downloadWithDurationLimit(testUrl, timeoutMs);
                        totalBytes.addAndGet(bytes);
                    } catch (Exception e) {
                        // Ignore individual connection failures
                    } finally {
                        latch.countDown();
                    }
                });
            }
            
            try {
                latch.await(timeoutMs + 2000, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            
            return totalBytes.get();
        }
    }

    /**
     * Measures download speed using virtual threads with true parallel startup.
     *
     * @param server The server URL
     * @param connections Number of parallel connections
     * @param verbose Whether to print verbose output
     * @return Download speed in Mbps
     * @throws Exception If download fails
     */
    @SuppressWarnings("BusyWait") // Intentional staggering of connection starts
    private double measureDownloadSpeedWithVirtualThreads(String server, int connections, boolean verbose) 
            throws Exception {
        // Adjust file size based on expected speed
        int fileSizeMB = isConstrainedNetwork() ? 50 : 100;
        String testUrl;
        if (server.contains("cloudflare.com/__down")) {
            testUrl = server + "?bytes=" + (1024 * 1024 * fileSizeMB);
        } else if (server.endsWith("/")) {
            testUrl = server + fileSizeMB + "MB.zip";
        } else {
            testUrl = server + "/" + fileSizeMB + "MB.zip";
        }
        
        try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
            var totalBytesDownloaded = new AtomicLong(0);
            var completionLatch = new CountDownLatch(connections);
            
            if (verbose) {
                System.out.printf(FW_ConsoleColors.BLUE + 
                    "  Starting %d-connection download test (%d seconds)...%n" + 
                    FW_ConsoleColors.RESET, connections, TEST_DURATION_SECONDS);
            }

            // Create all tasks first for true parallel startup
            List<Runnable> downloadTasks = new ArrayList<>();
            for (int i = 0; i < connections; i++) {
                final int connectionId = i;
                downloadTasks.add(() -> {
                    try {
                        // Smaller random offset for constrained networks
                        int maxDelay = isConstrainedNetwork() ? 50 : 100;
                        FW_DateTimeUtils.waitForDuration((long)(Math.random() * maxDelay), "ms", false);

                        long bytesDownloaded = downloadWithOptimizedSettings(testUrl, TEST_DURATION_SECONDS * 1000L);
                        totalBytesDownloaded.addAndGet(bytesDownloaded);
                        
                        if (verbose) {
                            System.out.printf(FW_ConsoleColors.DARK_GREY + 
                                "    Connection %d: %.2f MB%n" + 
                                FW_ConsoleColors.RESET, connectionId, bytesDownloaded / (1024.0 * 1024.0));
                        }
                        
                    } catch (Exception e) {
                        if (verbose) {
                            System.out.printf(FW_ConsoleColors.YELLOW + 
                                "    Connection %d error: %s%n" + 
                                FW_ConsoleColors.RESET, connectionId, e.getMessage());
                        }
                    } finally {
                        completionLatch.countDown();
                    }
                });
            }

            // Start all connections simultaneously
            Instant testStart = Instant.now();
            downloadTasks.forEach(executor::submit);
            
            // Wait for completion with longer timeout for constrained networks
            int timeoutSeconds = TEST_DURATION_SECONDS + (isConstrainedNetwork() ? 20 : 10);
            boolean completed = completionLatch.await(timeoutSeconds, TimeUnit.SECONDS);
            Instant testEnd = Instant.now();
            
            if (!completed) {
                throw new Exception("Download test did not complete within timeout");
            }
            
            // Calculate speed
            double actualDuration = Duration.between(testStart, testEnd).toMillis() / 1000.0;
            long totalBytes = totalBytesDownloaded.get();
            double megabits = (totalBytes * 8.0) / (1024.0 * 1024.0);
            double speedMbps = megabits / actualDuration;
            
            if (verbose) {
                System.out.printf(FW_ConsoleColors.GREEN + 
                    "  Download result: %.2f MB in %.2f seconds = %.2f Mbps%n" + 
                    FW_ConsoleColors.RESET, totalBytes / (1024.0 * 1024.0), actualDuration, speedMbps);
            }

            return speedMbps;
        }
    }

    /**
     * Downloads from URL with duration limit.
     *
     * @param urlString The URL to download from
     * @param durationMs Maximum duration in milliseconds
     * @return Number of bytes downloaded
     * @throws Exception If download fails
     */
    private long downloadWithDurationLimit(String urlString, long durationMs) throws Exception {
        // Prevent caching
        long timestamp = System.currentTimeMillis();
        String urlWithTimestamp = urlString + (urlString.contains("?") ? "&" : "?") + "t=" + timestamp;
        URL url = URI.create(urlWithTimestamp).toURL();
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        
        // Adjust timeouts for constrained networks
        connection.setConnectTimeout(isConstrainedNetwork() ? 10000 : 5000);
        connection.setReadTimeout(isConstrainedNetwork() ? 30000 : 15000);
        connection.setRequestProperty("Cache-Control", "no-cache");
        connection.setRequestProperty("Pragma", "no-cache");
        
        long totalBytes = 0;
        Instant startTime = Instant.now();
        
        try (InputStream in = connection.getInputStream()) {
            byte[] buffer = new byte[BUFFER_SIZE];
            int bytesRead;
            
            while ((bytesRead = in.read(buffer)) != -1) {
                totalBytes += bytesRead;
                
                if (Duration.between(startTime, Instant.now()).toMillis() > durationMs) {
                    break;
                }
            }
        } finally {
            connection.disconnect();
        }
        
        return totalBytes;
    }

    /**
     * Downloads with fully optimized connection settings and enhanced buffer reading.
     * Adaptive for both high-speed and constrained networks.
     *
     * @param urlString The URL to download from
     * @param durationMs Maximum duration in milliseconds
     * @return Number of bytes downloaded
     * @throws Exception If download fails
     */
    private long downloadWithOptimizedSettings(String urlString, long durationMs) throws Exception {
        // Add timestamp to prevent caching
        long timestamp = System.currentTimeMillis();
        String finalUrl = urlString + (urlString.contains("?") ? "&" : "?") + "nocache=" + timestamp;
        URL url = URI.create(finalUrl).toURL();
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        
        // Optimized TCP and HTTP settings with adaptive timeouts
        connection.setConnectTimeout(isConstrainedNetwork() ? 10000 : 5000);
        connection.setReadTimeout(isConstrainedNetwork() ? 45000 : 30000);
        connection.setRequestProperty("User-Agent", "Mozilla/5.0 (compatible; SpeedTest/8.0)");
        connection.setRequestProperty("Accept-Encoding", "identity");
        connection.setRequestProperty("Cache-Control", "no-cache");
        connection.setRequestProperty("Connection", "keep-alive");
        
        // Optimize connection settings
        connection.setUseCaches(false);
        connection.setInstanceFollowRedirects(true);
        
        long totalBytes = 0;
        Instant startTime = Instant.now();
        Instant lastCheck = startTime;
        
        // Adjust buffer size for constrained networks
        int bufferSize = isConstrainedNetwork() ? BUFFER_SIZE / 2 : BUFFER_SIZE;
        
        try (InputStream in = connection.getInputStream();
            BufferedInputStream bufferedIn = new BufferedInputStream(in, bufferSize * 2)) {
            
            byte[] buffer = new byte[bufferSize];
            
            while (true) {
                // Try to read full buffer for better efficiency
                int offset = 0;
                while (offset < buffer.length) {
                    int read = bufferedIn.read(buffer, offset, buffer.length - offset);
                    if (read == -1) break;
                    offset += read;
                    totalBytes += read;
                }
                
                // Check time less frequently to reduce overhead
                Instant now = Instant.now();
                if (Duration.between(lastCheck, now).toMillis() > 100) {
                    if (Duration.between(startTime, now).toMillis() > durationMs) {
                        break;
                    }
                    lastCheck = now;
                }
                
                if (offset < buffer.length) break; // EOF reached
            }
        } finally {
            connection.disconnect();
        }
        
        return totalBytes;
    }

    /**
     * Measures server latency accurately using GET requests.
     * Adaptive for high-latency networks.
     *
     * @param serverUrl The server URL
     * @return Latency in milliseconds
     * @throws Exception If measurement fails
     */
    @SuppressWarnings("BusyWait") // Intentional staggering of connection starts
    private double measureServerLatency(String serverUrl) throws Exception {
        List<Double> latencies = new ArrayList<>();
        int samples = isConstrainedNetwork() ? 3 : 5; // Fewer samples for slow networks
        
        for (int i = 0; i < samples; i++) {
            Instant start = Instant.now();
            
            // Use small file for latency measurement
            String testUrl;
            if (serverUrl.contains("cloudflare.com/__down")) {
                testUrl = serverUrl + "?bytes=1024";
            } else if (serverUrl.endsWith("/")) {
                testUrl = serverUrl + "1KB.zip";
            } else {
                testUrl = serverUrl + "/1KB.zip";
            }
            
            URL url = URI.create(testUrl).toURL();

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(isConstrainedNetwork() ? 10000 : 5000);
            connection.setReadTimeout(isConstrainedNetwork() ? 10000 : 5000);
            
            // Actually read first byte to measure true latency
            try (InputStream is = connection.getInputStream()) {
                is.read(); // Read first byte
            }
            
            Instant end = Instant.now();
            double latency = Duration.between(start, end).toMillis() / 2.0; // Divide by 2 for one-way
            latencies.add(latency);
            
            connection.disconnect();

            if (i < samples - 1) FW_DateTimeUtils.waitForDuration(50, "ms", false);
        }

        // Return median for stability
        latencies.sort(Double::compareTo);
        return latencies.get(latencies.size() / 2);
    }

    /**
     * Calculates connection quality score including upload speed.
     *
     * @param downloadMbps Download speed in Mbps
     * @param uploadMbps Upload speed in Mbps
     * @param latencyMs Latency in milliseconds
     * @param jitterMs Jitter in milliseconds
     * @return Quality score from 0 to 100
     */
    private double calculateConnectionQualityWithUpload(double downloadMbps, double uploadMbps, 
                                                        double latencyMs, double jitterMs) {
        // Adjust scoring based on location
        if (isRwanda()) {
            // Adjusted expectations for Rwanda
            double downloadScore = Math.min(downloadMbps * 4, 30);  // Max 30 points
            double uploadScore = Math.min(uploadMbps * 5, 20);      // Max 20 points
            double latencyScore = Math.max(0, 30 - (latencyMs / 20));
            double jitterScore = Math.max(0, 20 - (jitterMs / 2));
            return Math.min(100, downloadScore + uploadScore + latencyScore + jitterScore);
        } else if (isConstrainedNetwork()) {
            // Adjusted for Africa
            double downloadScore = Math.min(downloadMbps * 2.5, 30);
            double uploadScore = Math.min(uploadMbps * 3, 20);
            double latencyScore = Math.max(0, 30 - (latencyMs / 15));
            double jitterScore = Math.max(0, 20 - (jitterMs * 0.75));
            return Math.min(100, downloadScore + uploadScore + latencyScore + jitterScore);
        } else {
            // Standard scoring for high-speed networks
            double downloadScore = Math.min(downloadMbps * 1.5, 30);  // Max 30 points
            double uploadScore = Math.min(uploadMbps * 2, 20);        // Max 20 points
            double latencyScore = Math.max(0, 30 - (latencyMs / 10));
            double jitterScore = Math.max(0, 20 - jitterMs);
            return Math.min(100, downloadScore + uploadScore + latencyScore + jitterScore);
        }
    }

    private void printProgressBar(int current, int total, String label) {
        int barLength = 30;
        int filled = (int) ((double) current / total * barLength);
        StringBuilder bar = new StringBuilder("[");
        
        for (int i = 0; i < barLength; i++) {
            if (i < filled) bar.append("█");
            else bar.append("░");
        }
        bar.append("]");
        
        int percentage = (int) ((double) current / total * 100);
        
        // Use \r to overwrite the same line
        System.out.printf("\r  %s %s %d/%d connections (%d%%)", 
            label, bar.toString(), current, total, percentage);
        System.out.flush();  // Ensure immediate output
    }

    private void printJourneyHeader(String phase, String description) {
        System.out.println("\n" + FW_ConsoleColors.CORAL + "═══════════════════════════════════════════════════════════════════" + FW_ConsoleColors.RESET);
        System.out.println(FW_ConsoleColors.CORAL + "▶ " + phase + FW_ConsoleColors.RESET);
        System.out.println(FW_ConsoleColors.BLUE + "  " + description + FW_ConsoleColors.RESET);
        System.out.println(FW_ConsoleColors.CORAL + "───────────────────────────────────────────────────────────────────" + FW_ConsoleColors.RESET);
    }

    private void printJourneySummary(SpeedTestResult result, long totalTimeMs) {
        System.out.println("\n" + FW_ConsoleColors.CORAL + "═══════════════════════════════════════════════════════════════════" + FW_ConsoleColors.RESET);
        System.out.println(FW_ConsoleColors.CORAL + "▶ JOURNEY COMPLETE - FINAL REPORT" + FW_ConsoleColors.RESET);
        System.out.println(FW_ConsoleColors.CORAL + "───────────────────────────────────────────────────────────────────" + FW_ConsoleColors.RESET);
        
        System.out.printf(FW_ConsoleColors.WHITE + "  📍 Location:    %s, %s, %s%n", 
            result.location().getCity(), 
            result.location().getRegion(), 
            result.location().getCountryCode());
        System.out.printf("  🌐 Server Used: %s%n", result.serverUsed());
        System.out.printf("  ⏱️  Total Time:  %.1f seconds%n%n", totalTimeMs / 1000.0);
        
        System.out.println("  Performance Metrics:");
        System.out.printf("  📥 Download:    %.2f Mbps%n", result.downloadSpeed());
        System.out.printf("  📤 Upload:      %.2f Mbps%n", result.uploadSpeed());
        System.out.printf("  ⚡ Latency:     %.1f ms%n", result.latency());
        System.out.printf("  📊 Jitter:      %.1f ms%n", result.jitter());
        System.out.printf("  ⭐ Quality:     %.0f/100 (%s)%n" + FW_ConsoleColors.RESET, 
            result.qualityScore(), result.qualityRating());
        
        System.out.println(FW_ConsoleColors.CORAL + "═══════════════════════════════════════════════════════════════════\n" + FW_ConsoleColors.RESET);
    }

    // ===================== Inner Classes / Records =====================

    /**
     * Record for comprehensive speed test results with validation.
     */
    private record SpeedTestResult(
        double downloadSpeed,
        double uploadSpeed,
        double latency,
        double jitter,
        double qualityScore,
        String qualityRating,
        FW_NetworkDetails location,
        String serverUsed,
        boolean successful,
        String errorMessage
    ) {
        public SpeedTestResult {
            downloadSpeed = Math.max(0, downloadSpeed);
            uploadSpeed = Math.max(0, uploadSpeed);
            latency = Math.max(0, latency);
            jitter = Math.max(0, jitter);
            qualityScore = Math.min(100, Math.max(0, qualityScore));
            
            java.util.Objects.requireNonNull(location, "Location cannot be null");
            
            if (!successful && errorMessage == null) {
                errorMessage = "Unknown error occurred";
            }

            if (successful == true) {
                if (qualityRating == null) {
                    qualityRating = calculateQualityRating(qualityScore);
                }
            }
        }
        
        private static String calculateQualityRating(double score) {
            if (score >= 80) {
                return "Excellent";
            } else if (score >= 60) {
                return "Good";
            } else if (score >= 40) {
                return "Fair";
            } else if (score >= 20) {
                return "Poor";
            } else {
                return "Very Poor";
            }
        }
    }
}