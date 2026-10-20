package framework.http;

// ===============================================================
// @file: FW_HttpExecutor.java
// @filepath: src/test/java/framework/http/FW_HttpExecutor.java
// @version: 1.2.0
// @updated: 2025-11-06 17:15:00 PM CDT
// @author: Greg Paskal
// @company: MissionWares
//
// @description:
// HTTP execution engine that handles the complete lifecycle of HTTP requests
// and responses, fully populating the FW_Http data model. This class centralizes
// all HTTP transaction execution logic, including network analysis, timing
// capture, request/response handling, and performance metrics. Designed to be
// the single point of HTTP execution for the framework, used by audits, tests,
// and monitoring tools. Leverages FW_NetworkUtils and FW_HttpUtils internally
// while providing a clean API for HTTP transaction execution.
//
// @dependencies:
// - java.net.*
// - java.io.*
// - java.util.*
// - java.nio.charset.StandardCharsets
// - java.security.cert.*
// - javax.net.ssl.*
// - framework.http.FW_Http
// - framework.utilities.FW_HttpUtils
// - framework.utilities.FW_NetworkUtils
// - framework.utilities.FW_DateTimeUtils
// - framework.utilities.FW_ConsoleColors
// - framework.network.FW_NetworkDetails
//
// @methods:
// - main(String[] args) - Test harness for the executor
// - execute(String url) - Simple GET request execution
// - executeWithOptions(String url, Map options) - Configurable execution
// - executePost(String url, String body) - POST request execution
// - executePut(String url, String body) - PUT request execution
// - executeDelete(String url) - DELETE request execution
// - handleRedirects() - Manual redirect chain handling
// - populateRequestDetails() - Captures all request information
// - populateResponseDetails() - Captures all response information
// - populateNetworkDetails() - Network and DNS information
// - populateTimingDetails() - Comprehensive timing metrics
// - populateSecurityDetails() - Security analysis
// - calculatePerformanceScore() - Performance scoring
// - validateResponseContent() - Content validation
//
// @tags: http, executor, client, request, response, timing, redirect, mAi™
//
// @changeLog:
// Date        Author          Version  Description
// ----------  --------------  -------  --------------------------
// 2025-01-23  G. Paskal       1.0.0    Initial implementation with mAi™ header
// 2025-09-24  G. Paskal       1.1.0    Added manual redirect chain tracking
// 2025-10-14  G. Paskal       1.1.1    Fixed crash with certain hosts via FW_NetworkUtils anycast detection
// 2025-11-06  G. Paskal       1.2.0    Priority 4: Enhanced certificate capture with deep SSL analysis (serial, algo, key size, SANs, chain, trust level)
// ===============================================================

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.security.cert.CertificateException;
import java.security.PublicKey;
import java.security.interfaces.RSAPublicKey;
import java.security.interfaces.ECPublicKey;
import java.util.*;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLPeerUnverifiedException;
import java.util.zip.GZIPInputStream;
import java.util.zip.InflaterInputStream;

import framework.network.FW_NetworkDetails;
import framework.utilities.FW_ConsoleColors;
import framework.utilities.FW_DateTimeUtils;
import framework.utilities.FW_HttpUtils;
import framework.utilities.FW_NetworkUtils;

/**
 * HTTP execution engine that handles complete HTTP transaction lifecycle.
 */
public class FW_HttpExecutor {
    
    // Configuration constants
    private static final int DEFAULT_CONNECT_TIMEOUT = 10000; // 10 seconds
    private static final int DEFAULT_READ_TIMEOUT = 30000; // 30 seconds
    private static final int MAX_RESPONSE_SIZE = 10 * 1024 * 1024; // 10MB
    private static final int BUFFER_SIZE = 8192;
    private static final boolean DEFAULT_FOLLOW_REDIRECTS = true;
    private static final int MAX_REDIRECTS = FW_HttpUtils.getMaxRedirectDepth();
    
    /**
     * Main method for testing the HTTP executor.
     */
    public static void main(String[] args) {
        System.out.println(FW_ConsoleColors.CORAL + "\n╔══════════════════════════════════════════════════════════════════════════════╗");
        System.out.println("║                          FW_HttpExecutor TEST SUITE                            ║");
        System.out.println("╚══════════════════════════════════════════════════════════════════════════════╝" + FW_ConsoleColors.RESET);
        
        // Test URLs
        String[] testUrls = {
            "https://httpbin.org/get",
            "https://httpbin.org/status/404",
            "https://httpbin.org/redirect/3",  // Changed to 3 to show chain
            "https://api.github.com"
        };
        
        // Test 1: Simple GET requests
        System.out.println(FW_ConsoleColors.CORAL + "\n━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println("TEST 1: Simple GET Requests");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━" + FW_ConsoleColors.RESET);
        
        for (String url : testUrls) {
            System.out.println(FW_ConsoleColors.BLUE + "\nExecuting: " + url + FW_ConsoleColors.RESET);
            
            FW_Http result = execute(url);
            printQuickSummary(result);
        }
        
        // Test 2: POST request
        System.out.println(FW_ConsoleColors.CORAL + "\n━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println("TEST 2: POST Request with JSON Body");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━" + FW_ConsoleColors.RESET);
        
        String postUrl = "https://httpbin.org/post";
        String jsonBody = "{\"test\": \"data\", \"framework\": \"MissionWares\"}";
        
        System.out.println(FW_ConsoleColors.BLUE + "\nExecuting POST to: " + postUrl + FW_ConsoleColors.RESET);
        System.out.println("Body: " + jsonBody);
        
        FW_Http postResult = executePost(postUrl, jsonBody, "application/json");
        printQuickSummary(postResult);
        
        // Test 3: Custom options - No redirect following
        System.out.println(FW_ConsoleColors.CORAL + "\n━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println("TEST 3: Request with Custom Options (No Redirect Following)");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━" + FW_ConsoleColors.RESET);
        
        Map<String, Object> options = new HashMap<>();
        options.put("followRedirects", false);
        options.put("connectTimeout", 5000);
        options.put("customHeader", "X-Test-Header: TestValue");
        
        System.out.println(FW_ConsoleColors.BLUE + "\nExecuting with no redirect following: " + "https://httpbin.org/redirect/1" + FW_ConsoleColors.RESET);
        FW_Http optionsResult = executeWithOptions("https://httpbin.org/redirect/1", options);
        printQuickSummary(optionsResult);
        
        // Test 4: Performance analysis
        System.out.println(FW_ConsoleColors.CORAL + "\n━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println("TEST 4: Performance and Timing Analysis");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━" + FW_ConsoleColors.RESET);
        
        String perfUrl = "https://www.google.com";
        System.out.println(FW_ConsoleColors.BLUE + "\nAnalyzing performance for: " + perfUrl + FW_ConsoleColors.RESET);
        
        FW_Http perfResult = execute(perfUrl);
        printDetailedTimings(perfResult);
        
        // Test 5: Complex redirect chain
        System.out.println(FW_ConsoleColors.CORAL + "\n━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println("TEST 5: Complex Redirect Chain Analysis");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━" + FW_ConsoleColors.RESET);
        
        String redirectUrl = "https://httpbin.org/redirect/5";
        System.out.println(FW_ConsoleColors.BLUE + "\nAnalyzing redirect chain for: " + redirectUrl + FW_ConsoleColors.RESET);
        
        FW_Http redirectResult = execute(redirectUrl);
        printRedirectDetails(redirectResult);
        
        System.out.println(FW_ConsoleColors.CORAL + "\n════════════════════════════════════════════════════════════════════════════════");
        System.out.println(FW_ConsoleColors.GREEN + "All FW_HttpExecutor tests completed!" + FW_ConsoleColors.RESET);
        System.out.println(FW_ConsoleColors.CORAL + "════════════════════════════════════════════════════════════════════════════════\n" + FW_ConsoleColors.RESET);

        // Test 6: Redirect limit with lower threshold
        System.out.println(FW_ConsoleColors.CORAL + "\n━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println("TEST 6: Redirect Limit Test (Max 2)");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━" + FW_ConsoleColors.RESET);

        // Temporarily set max redirects to 2
        System.setProperty("fw.http.max.redirects", "2");

        redirectUrl = "https://httpbin.org/redirect/4";  // 4 redirects, but limit is 2
        System.out.println(FW_ConsoleColors.BLUE + "\nTesting redirect limit with: " + redirectUrl + FW_ConsoleColors.RESET);

        FW_Http limitTest = execute(redirectUrl);
        printRedirectDetails(limitTest);

        // Reset property
        System.clearProperty("fw.http.max.redirects");
    }
    
    /**
     * Executes a simple GET request.
     *
     * @param url The URL to request
     * @return Populated FW_Http object
     */
    public static FW_Http execute(String url) {
        return executeWithOptions(url, new HashMap<>());
    }
    
    /**
     * Executes an HTTP request with custom options.
     *
     * @param url The URL to request
     * @param options Execution options
     * @return Populated FW_Http object
     */
    public static FW_Http executeWithOptions(String urlString, Map<String, Object> options) {
        FW_Http transaction = new FW_Http();
        
        try {
            // Start request timestamp
            String requestTimestamp = FW_DateTimeUtils.getCurrentTimestamp();
            transaction.setRequestTimestamp(requestTimestamp);
            transaction.setHttpTimestamp(requestTimestamp);
            
            // Validate URL
            if (!FW_NetworkUtils.isValidHost(urlString)) {
                URL tempUrl = URI.create(urlString).toURL();
                if (!FW_NetworkUtils.isValidHost(tempUrl.getHost())) {
                    throw new IllegalArgumentException("Invalid URL or host: " + urlString);
                }
            }
            
            // Initialize basic transaction data
            transaction.setHttpRefID("exec-" + UUID.randomUUID().toString());
            transaction.setHttpName("HTTP Execution: " + urlString);
            transaction.setHttpType("EXECUTE");
            transaction.setRequestUrl(urlString);
            
            // Parse URL components
            URL url = URI.create(urlString).toURL();
            populateUrlComponents(transaction, url);
            
            // Capture pre-request network details
            long overallStart = System.currentTimeMillis();

            populateNetworkDetails(transaction, url);
            
            // Check if we should follow redirects
            boolean shouldFollowRedirects = (boolean) options.getOrDefault("followRedirects", DEFAULT_FOLLOW_REDIRECTS);
            
            if (shouldFollowRedirects) {
                // Manual redirect handling for complete chain tracking
                executeWithRedirectHandling(transaction, urlString, options, overallStart);
            } else {
                // Single request without redirect following
                executeSingleRequest(transaction, urlString, options, overallStart);
            }
            
        } catch (Exception e) {
            handleExecutionError(transaction, e);
        }
        
        return transaction;
    }
    
    /**
     * Executes a request with manual redirect handling.
     */
    private static void executeWithRedirectHandling(FW_Http transaction, String initialUrl, Map<String, Object> options, long overallStart) throws Exception {

        String currentUrl = initialUrl;
        String currentMethod = (String) options.getOrDefault("method", "GET");
        Map<String, Object> currentOptions = new HashMap<>(options);
        
        // Always disable automatic redirects for manual handling
        currentOptions.put("followRedirects", false);
        
        int redirectCount = 0;
        List<String> visitedUrls = new ArrayList<>();
        visitedUrls.add(currentUrl);
        
        HttpURLConnection lastConnection = null;
        boolean finalResponseCaptured = false;
        
        try {
            while (redirectCount <= MAX_REDIRECTS) {  // Changed to <= to allow capturing final response
                long hopStart = System.currentTimeMillis();
                
                // Check if we've exceeded the redirect limit BEFORE making the request
                if (redirectCount >= MAX_REDIRECTS) {
                    // We've hit the limit - set error state
                    transaction.setMaxRedirectsReached(MAX_REDIRECTS);
                    transaction.setHasError(true);
                    transaction.setErrorType("TooManyRedirects");
                    transaction.setErrorMessage("Maximum redirect limit (" + MAX_REDIRECTS + ") exceeded");
                    
                    // Calculate total time spent
                    long overallEnd = System.currentTimeMillis();
                    transaction.setTotalDurationMs(overallEnd - overallStart);
                    
                    // Set a pseudo response to indicate the issue
                    transaction.setResponseStatusCode(310); // Using 310 as custom code for too many redirects
                    transaction.setResponseStatusMessage("Too Many Redirects");
                    transaction.setResponseTimestamp(FW_DateTimeUtils.getCurrentTimestamp());
                    
                    // Human readable duration
                    long totalTime = overallEnd - overallStart;
                    if (totalTime < 1000) {
                        transaction.setTotalDurationHR(totalTime + "ms");
                    } else {
                        transaction.setTotalDurationHR(String.format("%.2fs", totalTime / 1000.0));
                    }
                    
                    // Set minimal scores to indicate error state
                    transaction.setPerformanceScore(0);
                    transaction.setSecurityScore(0);
                    transaction.setComplianceScore(0);
                    
                    break;
                }
                
                // Create connection for this hop
                URL url = URI.create(currentUrl).toURL();
                lastConnection = createConnection(url, currentOptions);
                
                // Set the current method (may have changed due to redirect)
                currentOptions.put("method", currentMethod);
                configureConnection(lastConnection, transaction, currentOptions);
                
                // Execute request
                long connectStart = System.currentTimeMillis();
                if (currentOptions.containsKey("_bodyToWrite")) {
                    String bodyToWrite = (String) currentOptions.get("_bodyToWrite");
                    try (OutputStream os = lastConnection.getOutputStream()) {
                        os.write(bodyToWrite.getBytes(StandardCharsets.UTF_8));
                        os.flush();
                    }
                    currentOptions.remove("_bodyToWrite");
                } else {
                    lastConnection.connect();
                }
                long connectEnd = System.currentTimeMillis();
                
                // Capture response code
                int statusCode = lastConnection.getResponseCode();
                
                // If not a redirect, we're done
                if (!FW_HttpUtils.isRedirect(statusCode)) {
                    // Final response - capture everything
                    captureResponse(lastConnection, transaction);
                    finalResponseCaptured = true;
                    
                    // Update timing for final request
                    long overallEnd = System.currentTimeMillis();
                    populateTimingDetails(transaction, overallStart, overallEnd, connectStart, connectEnd);
                    
                    // Populate analysis fields
                    populateSecurityAnalysis(transaction);
                    calculatePerformanceScore(transaction);
                    validateResponseContent(transaction);
                    
                    // Set final URL
                    transaction.setFinalUrl(currentUrl);
                    
                    lastConnection.disconnect();
                    break;
                }
                
                // Handle redirect
                String location = lastConnection.getHeaderField("Location");
                if (location == null || location.isEmpty()) {
                    // Invalid redirect - capture what we have
                    captureResponse(lastConnection, transaction);
                    finalResponseCaptured = true;
                    
                    // Calculate timings
                    long overallEnd = System.currentTimeMillis();
                    populateTimingDetails(transaction, overallStart, overallEnd, connectStart, connectEnd);
                    
                    // Set error for invalid redirect
                    transaction.setHasError(true);
                    transaction.setErrorType("InvalidRedirect");
                    transaction.setErrorMessage("Redirect response missing Location header");
                    
                    lastConnection.disconnect();
                    break;
                }
                
                // Build absolute redirect URL
                String nextUrl = FW_HttpUtils.buildRedirectUrl(currentUrl, location);
                
                // Check for redirect loop
                if (visitedUrls.contains(nextUrl)) {
                    transaction.setRedirectLoop(true);
                    
                    // Capture redirect hop before breaking
                    long hopDuration = System.currentTimeMillis() - hopStart;
                    Map<String, String> hopHeaders = captureHeaders(lastConnection);
                    transaction.addRedirectHop(currentUrl, statusCode, location, hopDuration, hopHeaders);
                    
                    // Still capture the final response
                    captureResponse(lastConnection, transaction);
                    finalResponseCaptured = true;
                    
                    // Calculate timings
                    long overallEnd = System.currentTimeMillis();
                    populateTimingDetails(transaction, overallStart, overallEnd, connectStart, connectEnd);
                    
                    // Set error for loop
                    transaction.setHasError(true);
                    transaction.setErrorType("RedirectLoop");
                    transaction.setErrorMessage("Redirect loop detected: " + nextUrl);
                    
                    lastConnection.disconnect();
                    break;
                }
                
                // Capture redirect hop details
                long hopDuration = System.currentTimeMillis() - hopStart;
                Map<String, String> hopHeaders = captureHeaders(lastConnection);
                
                // Add to redirect chain
                transaction.addRedirectHop(currentUrl, statusCode, location, hopDuration, hopHeaders);
                
                // Determine next method based on status code
                String nextMethod = FW_HttpUtils.getRedirectMethod(currentMethod, statusCode);
                
                // Check if we should follow this redirect
                if (!FW_HttpUtils.shouldFollowRedirect(currentMethod, statusCode)) {
                    // Don't follow - capture current response as final
                    captureResponse(lastConnection, transaction);
                    finalResponseCaptured = true;
                    
                    // Calculate timings
                    long overallEnd = System.currentTimeMillis();
                    populateTimingDetails(transaction, overallStart, overallEnd, connectStart, connectEnd);
                    
                    // Populate analysis fields
                    populateSecurityAnalysis(transaction);
                    calculatePerformanceScore(transaction);
                    validateResponseContent(transaction);
                    
                    // Set final URL (stays at current since we didn't follow)
                    transaction.setFinalUrl(currentUrl);
                    
                    lastConnection.disconnect();
                    break;
                }
                
                // Clear body for method changes to GET
                if (!nextMethod.equals(currentMethod) && "GET".equals(nextMethod)) {
                    currentOptions.remove("body");
                    currentOptions.remove("_bodyToWrite");
                    currentOptions.remove("contentType");
                }
                
                lastConnection.disconnect();
                
                // Prepare for next iteration
                currentUrl = nextUrl;
                currentMethod = nextMethod;
                visitedUrls.add(nextUrl);
                redirectCount++;
            }
            
        } catch (Exception e) {
            // Handle any exceptions during redirect processing
            handleExecutionError(transaction, e);
            
            // Still try to calculate elapsed time
            long overallEnd = System.currentTimeMillis();
            long totalTime = overallEnd - overallStart;
            transaction.setTotalDurationMs(totalTime);
            
            if (totalTime < 1000) {
                transaction.setTotalDurationHR(totalTime + "ms");
            } else {
                transaction.setTotalDurationHR(String.format("%.2fs", totalTime / 1000.0));
            }
            
            // Clean up connection if still open
            if (lastConnection != null) {
                try {
                    lastConnection.disconnect();
                } catch (Exception ignored) {}
            }
            
            throw e; // Re-throw for upstream handling
        }
        
        // Ensure we always have timing data
        if (!finalResponseCaptured && transaction.getTotalDurationMs() == 0) {
            long overallEnd = System.currentTimeMillis();
            long totalTime = overallEnd - overallStart;
            transaction.setTotalDurationMs(totalTime);
            
            if (transaction.hasRedirect()) {
                transaction.setTotalDurationHR(String.format("%.2fs (redirects: %dms)", 
                    totalTime / 1000.0, transaction.getRedirectTotalDurationMs()));
            } else {
                if (totalTime < 1000) {
                    transaction.setTotalDurationHR(totalTime + "ms");
                } else {
                    transaction.setTotalDurationHR(String.format("%.2fs", totalTime / 1000.0));
                }
            }
        }
        
        // Set redirect type if we had redirects
        if (transaction.hasRedirect()) {
            analyzeRedirectType(transaction);
        }
    }

    /**
     * Helper method to capture headers from a connection.
     */
    private static Map<String, String> captureHeaders(HttpURLConnection connection) {
        Map<String, String> headers = new HashMap<>();
        connection.getHeaderFields().forEach((key, values) -> {
            if (key != null && values != null && !values.isEmpty()) {
                headers.put(key, String.join(", ", values));
            }
        });
        return headers;
    }

    /**
     * Executes a single request without redirect handling.
     */
    private static void executeSingleRequest(FW_Http transaction, String urlString, 
                                            Map<String, Object> options, long overallStart) throws Exception {
        URL url = URI.create(urlString).toURL();
        HttpURLConnection connection = createConnection(url, options);
        configureConnection(connection, transaction, options);
        
        // Execute request
        long connectStart = System.currentTimeMillis();
        if (options.containsKey("_bodyToWrite")) {
            String bodyToWrite = (String) options.get("_bodyToWrite");
            try (OutputStream os = connection.getOutputStream()) {
                os.write(bodyToWrite.getBytes(StandardCharsets.UTF_8));
                os.flush();
            }
            options.remove("_bodyToWrite");
        } else {
            connection.connect();
        }
        long connectEnd = System.currentTimeMillis();
        
        // Capture response
        captureResponse(connection, transaction);
        
        // Calculate timings
        long overallEnd = System.currentTimeMillis();
        populateTimingDetails(transaction, overallStart, overallEnd, connectStart, connectEnd);
        
        // Populate analysis fields
        populateSecurityAnalysis(transaction);
        calculatePerformanceScore(transaction);
        validateResponseContent(transaction);
        
        connection.disconnect();
    }
    
    /**
     * Analyzes and sets the redirect type based on the chain.
     */
    private static void analyzeRedirectType(FW_Http transaction) {
        List<Integer> statusCodes = transaction.getRedirectStatusCodes();
        if (statusCodes == null || statusCodes.isEmpty()) {
            return;
        }
        
        boolean hasPermanent = false;
        boolean hasTemporary = false;
        
        for (int code : statusCodes) {
            if (FW_HttpUtils.isPermanentRedirect(code)) {
                hasPermanent = true;
            } else if (FW_HttpUtils.isTemporaryRedirect(code)) {
                hasTemporary = true;
            }
        }
        
        if (hasPermanent && hasTemporary) {
            transaction.setRedirectType("mixed");
        } else if (hasPermanent) {
            transaction.setRedirectType("permanent");
        } else if (hasTemporary) {
            transaction.setRedirectType("temporary");
        } else {
            transaction.setRedirectType("unknown");
        }
    }
    
    /**
     * Executes a POST request with a body.
     *
     * @param url The URL to request
     * @param body The request body
     * @param contentType The content type
     * @return Populated FW_Http object
     */
    public static FW_Http executePost(String url, String body, String contentType) {
        Map<String, Object> options = new HashMap<>();
        options.put("method", "POST");
        options.put("body", body);
        options.put("contentType", contentType);
        return executeWithOptions(url, options);
    }
    
    /**
     * Executes a PUT request with a body.
     *
     * @param url The URL to request
     * @param body The request body
     * @param contentType The content type
     * @return Populated FW_Http object
     */
    public static FW_Http executePut(String url, String body, String contentType) {
        Map<String, Object> options = new HashMap<>();
        options.put("method", "PUT");
        options.put("body", body);
        options.put("contentType", contentType);
        return executeWithOptions(url, options);
    }
    
    /**
     * Executes a DELETE request.
     *
     * @param url The URL to request
     * @return Populated FW_Http object
     */
    public static FW_Http executeDelete(String url) {
        Map<String, Object> options = new HashMap<>();
        options.put("method", "DELETE");
        return executeWithOptions(url, options);
    }
    
    // ===============================================================
    // Private Helper Methods (unchanged from original)
    // ===============================================================
    
    private static void populateUrlComponents(FW_Http transaction, URL url) {
        transaction.setRequestHost(url.getHost());
        transaction.setRequestPath(url.getPath().isEmpty() ? "/" : url.getPath());
        transaction.setRequestQuery(FW_HttpUtils.extractQueryString(url.toString()));
        transaction.setSecure(FW_HttpUtils.isHttps(url.toString()));
        transaction.setRequestProtocol(url.getProtocol().toUpperCase());
    }
    
    private static void populateNetworkDetails(FW_Http transaction, URL url) throws Exception {
        String host = url.getHost();
        
        // DNS timing and resolution
        long dnsStart = System.currentTimeMillis();
        List<String> allIps = FW_NetworkUtils.getAllDnsResolutions(host);
        long dnsEnd = System.currentTimeMillis();
        
        transaction.setDnsLookupDurationMs(dnsEnd - dnsStart);
        
        if (!allIps.isEmpty()) {
            transaction.setDnsResolvedIps(String.join(",", allIps));
            transaction.setIsDnsLoadBalanced(allIps.size() > 1);
            transaction.setRemoteIpAddress(allIps.get(0));
            
            // Use verified IP if possible
            String verifiedIp = FW_NetworkUtils.hostToVerifiedIP(url.toString());
            if (verifiedIp != null) {
                transaction.setRemoteIpAddress(verifiedIp);
            }
        }
        
        // Hostname resolution
        String resolvedHostname = FW_NetworkUtils.hostToHostname(host);
        if (resolvedHostname != null) {
            transaction.setRemoteHostname(resolvedHostname);
        }
        
        // Port
        int port = url.getPort();
        if (port == -1) {
            port = url.getProtocol().equalsIgnoreCase("https") ? 443 : 80;
        }
        transaction.setRemotePort(port);
        
        // Geolocation and network details
        FW_NetworkDetails networkDetails = FW_NetworkUtils.getNetworkDetails(host);
        if (networkDetails != null) {
            Map<String, Object> metadata = transaction.getMetadata();
            metadata.put("network.country", networkDetails.getCountry());
            metadata.put("network.city", networkDetails.getCity());
            metadata.put("network.asn", networkDetails.getAsn());
            metadata.put("network.asn_org", networkDetails.getAsnOrganization());
            metadata.put("network.latitude", networkDetails.getLatitude());
            metadata.put("network.longitude", networkDetails.getLongitude());
            metadata.put("network.is_anycast", networkDetails.getIsAnycast());
        }
        
        // Anycast detection
        Map<String, String> anycastInfo = FW_NetworkUtils.detectAnycast(host, false);
        if (anycastInfo != null && "true".equals(anycastInfo.get("is_anycast"))) {
            transaction.getMetadata().put("network.anycast_indicators", anycastInfo.get("indicators"));
        }
    }
    
    private static HttpURLConnection createConnection(URL url, Map<String, Object> options) throws IOException {
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        
        // Set timeouts
        int connectTimeout = (int) options.getOrDefault("connectTimeout", DEFAULT_CONNECT_TIMEOUT);
        int readTimeout = (int) options.getOrDefault("readTimeout", DEFAULT_READ_TIMEOUT);
        connection.setConnectTimeout(connectTimeout);
        connection.setReadTimeout(readTimeout);
        
        // ALWAYS disable automatic redirects for manual handling
        connection.setInstanceFollowRedirects(false);
        
        return connection;
    }
    
    private static void configureConnection(HttpURLConnection connection, FW_Http transaction, 
                                        Map<String, Object> options) throws Exception {
        // Set method
        String method = (String) options.getOrDefault("method", "GET");
        if (!FW_HttpUtils.isValidHttpMethod(method)) {
            throw new IllegalArgumentException("Invalid HTTP method: " + method);
        }
        connection.setRequestMethod(method);
        transaction.setRequestMethod(method);
        
        // Set standard headers
        connection.setRequestProperty("User-Agent", FW_HttpUtils.createUserAgent("FW_HttpExecutor", "1.1"));
        connection.setRequestProperty("Accept", "*/*");
        connection.setRequestProperty("Accept-Language", "en-US,en;q=0.9");
        connection.setRequestProperty("Cache-Control", "no-cache");
        connection.setRequestProperty("Accept-Encoding", "gzip, deflate, br");
        
        // Add custom headers
        if (options.containsKey("customHeader")) {
            String header = (String) options.get("customHeader");
            String[] parts = header.split(":", 2);
            if (parts.length == 2) {
                connection.setRequestProperty(parts[0].trim(), parts[1].trim());
            }
        }
        
        // Handle authentication
        if (options.containsKey("username") && options.containsKey("password")) {
            String auth = FW_HttpUtils.createBasicAuth(
                (String) options.get("username"),
                (String) options.get("password")
            );
            connection.setRequestProperty("Authorization", auth);
            transaction.setRequestAuthentication("Basic");
        }
        
        // Handle request body for POST/PUT - PREPARE but DON'T WRITE YET
        if (options.containsKey("body")) {
            connection.setDoOutput(true);
            String body = (String) options.get("body");
            String contentType = (String) options.getOrDefault("contentType", "text/plain");
            
            connection.setRequestProperty("Content-Type", contentType);
            connection.setRequestProperty("Content-Length", String.valueOf(body.length()));
            
            transaction.setRequestContentType(contentType);
            transaction.setRequestBodyString(body);
            transaction.setRequestBody(body.getBytes(StandardCharsets.UTF_8));
            transaction.setRequestBodySize(body.length());
            
            // Store body in options for later writing (AFTER connect)
            options.put("_bodyToWrite", body);
        }
        
        // Store request headers
        Map<String, String> requestHeaders = new HashMap<>();
        connection.getRequestProperties().forEach((key, value) -> {
            if (key != null && value != null && !value.isEmpty()) {
                requestHeaders.put(key, String.join(", ", value));
            }
        });
        transaction.setRequestHeaders(requestHeaders);
        
        // Capture TLS details for HTTPS
        if (connection instanceof HttpsURLConnection) {
            captureTlsDetails(transaction);
        }
    }
    
    // [Remaining helper methods unchanged from original - captureTlsDetails, captureResponse, 
    //  captureResponseBody, populateTimingDetails, populateSecurityAnalysis, 
    //  calculatePerformanceScore, calculateComplianceScore, validateResponseContent, 
    //  handleExecutionError]
    
    /**
     * Captures TLS/SSL details for HTTPS connections.
     * This method prepares for TLS capture but doesn't connect yet.
     */
    private static void captureTlsDetails(FW_Http transaction) {
        try {
            // Just set basic TLS info - actual certificate details will be 
            // captured after connection is established
            transaction.setTlsVersion("TLS");
            // Mark that we should capture certificates later
            transaction.setSecure(true);
        } catch (Exception e) {
            // Best effort - TLS details are not critical
        }
    }
    
    /**
     * Captures the complete HTTP response including headers, body, and certificates.
     */
    private static void captureResponse(HttpURLConnection connection, FW_Http transaction) throws Exception {

        // Null safety check
        if (connection == null) {
            throw new IllegalArgumentException("Connection cannot be null");
        }

        // Response timestamp
        transaction.setResponseTimestamp(FW_DateTimeUtils.getCurrentTimestamp());
        
        // Capture TLS/Certificate details now that we're connected (for HTTPS)
        if (connection instanceof HttpsURLConnection httpsConn) {  // ✅ Pattern matching
            try {
                // Now that we're connected, we can get the cipher suite
                String cipherSuite = httpsConn.getCipherSuite();
                if (cipherSuite != null) {
                    transaction.setTlsCipherSuite(cipherSuite);
                }
                
                // Get server certificates
                Certificate[] certs = httpsConn.getServerCertificates();
                if (certs != null && certs.length > 0 && certs[0] instanceof X509Certificate cert) {
                    // Basic certificate info (existing)
                    transaction.setCertificateSubject(cert.getSubjectX500Principal().toString());
                    transaction.setCertificateIssuer(cert.getIssuerX500Principal().toString());
                    transaction.setCertificateExpiryMs(cert.getNotAfter().getTime());
                    
                    // Priority 4: Enhanced certificate details
                    enhancedCertificateCapture(cert, certs, transaction);
                    
                    // Check certificate validity
                    try {
                        cert.checkValidity();
                        transaction.setHasValidCertificate(true);
                    } catch (CertificateException e) {
                        transaction.setHasValidCertificate(false);
                    }
                }
            } catch (SSLPeerUnverifiedException | IllegalStateException e) {  // ✅ Specific exceptions
                // Certificate capture is best-effort - don't fail the entire request
                // Some servers might not provide certificates in certain scenarios
            }
        }
        
        // Status code and message
        int statusCode = connection.getResponseCode();

        transaction.setResponseStatusCode(statusCode);
        transaction.setResponseStatusMessage(FW_HttpUtils.getReasonPhrase(statusCode));
        transaction.setResponseProtocol("HTTP/1.1");
        
        // Response headers
        Map<String, String> responseHeaders = new HashMap<>();
        connection.getHeaderFields().forEach((key, values) -> {
            if (key != null && values != null && !values.isEmpty()) {
                responseHeaders.put(key, String.join(", ", values));
            }
        });
        transaction.setResponseHeaders(responseHeaders);
        
        // Specific header fields
        transaction.setResponseContentType(connection.getContentType());
        transaction.setResponseEncoding(connection.getContentEncoding());
        transaction.setResponseLocation(connection.getHeaderField("Location"));
        transaction.setResponseServer(connection.getHeaderField("Server"));
        transaction.setResponseETag(connection.getHeaderField("ETag"));
        transaction.setResponseLastModified(connection.getHeaderField("Last-Modified"));
        transaction.setCompressed(FW_HttpUtils.isCompressed(responseHeaders));
        
        // Parse and store cookies
        List<String> cookieHeaders = connection.getHeaderFields().get("Set-Cookie");
        if (cookieHeaders != null) {
            Map<String, String> cookies = new HashMap<>();
            for (String cookieHeader : cookieHeaders) {
                FW_HttpUtils.Cookie cookie = FW_HttpUtils.parseCookie(cookieHeader);
                if (cookie != null) {
                    cookies.put(cookie.name, cookie.value);
                }
            }
            transaction.setResponseCookies(cookies);
        }
        
        // Capture response body
        captureResponseBody(connection, transaction);
        
        transaction.setResponseComplete(true);
    }

    /**
     * Captures the response body from the connection.
     */
    private static void captureResponseBody(HttpURLConnection connection, FW_Http transaction) throws IOException {
        InputStream inputStream = null;
        try {
            // Get appropriate stream based on response code
            if (FW_HttpUtils.isClientError(connection.getResponseCode()) || 
                FW_HttpUtils.isServerError(connection.getResponseCode())) {
                inputStream = connection.getErrorStream();
            } else {
                inputStream = connection.getInputStream();
            }
            
            if (inputStream == null) {
                return;
            }

            // Handle decompression
            String encoding = connection.getContentEncoding();
            if (encoding != null) {
                if ("gzip".equalsIgnoreCase(encoding)) {
                    inputStream = new GZIPInputStream(inputStream);
                } else if ("deflate".equalsIgnoreCase(encoding)) {
                    inputStream = new InflaterInputStream(inputStream);
                }
            }
            
            // Read response body with size limit
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            byte[] buffer = new byte[BUFFER_SIZE];
            int bytesRead;
            long totalBytes = 0;
            
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                if (totalBytes + bytesRead > MAX_RESPONSE_SIZE) {
                    break;
                }
                baos.write(buffer, 0, bytesRead);
                totalBytes += bytesRead;
            }
            
            byte[] responseBytes = baos.toByteArray();
            transaction.setResponseBody(responseBytes);
            transaction.setResponseBodySize(responseBytes.length);
            
            // Convert to string for text content
            String contentType = transaction.getResponseContentType();
            if (contentType != null && (FW_HttpUtils.isHtmlContent(contentType) || 
                                    FW_HttpUtils.isJsonContent(contentType) || 
                                    FW_HttpUtils.isXmlContent(contentType) ||
                                    contentType.contains("text"))) {
                String charset = FW_HttpUtils.getCharset(contentType);
                transaction.setResponseBodyString(new String(responseBytes, charset));
                transaction.setResponseCharset(charset);
            }
            
            // Compression ratio calculation
            if (FW_HttpUtils.isCompressed(transaction.getResponseHeaders())) {
                long contentLength = FW_HttpUtils.getContentLength(transaction.getResponseHeaders());
                if (contentLength > 0 && responseBytes.length > 0) {
                    double ratio = (double) responseBytes.length / contentLength;
                    transaction.setCompressionRatio(ratio);
                }
            }
            
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }
    }

    private static void populateTimingDetails(FW_Http transaction, long overallStart, long overallEnd,
                                             long connectStart, long connectEnd) {
        // Connection time
        transaction.setConnectionDurationMs(connectEnd - connectStart);
        
        // Total time (includes redirects if any)
        long totalTime = overallEnd - overallStart;
        transaction.setTotalDurationMs(totalTime);
        
        // Subtract redirect time from total for actual request/response time
        if (transaction.hasRedirect()) {
            long redirectTime = transaction.getRedirectTotalDurationMs();
            
            // Human readable duration
            transaction.setTotalDurationHR(String.format("%.2fs (redirects: %dms)", 
                totalTime / 1000.0, redirectTime));
        } else {
            // Human readable duration
            if (totalTime < 1000) {
                transaction.setTotalDurationHR(totalTime + "ms");
            } else {
                transaction.setTotalDurationHR(String.format("%.2fs", totalTime / 1000.0));
            }
        }
        
        // Try to get more detailed timings using NetworkUtils
        Map<String, Long> detailedTimings = FW_NetworkUtils.measureNetworkTimings(transaction.getFinalUrl() != null ? 
            transaction.getFinalUrl() : transaction.getRequestUrl());
        if (detailedTimings != null) {
            Long ttfb = detailedTimings.get("ttfb_ms");
            if (ttfb != null && ttfb > 0) {
                transaction.setResponseWaitDurationMs(ttfb);
                // Calculate receive time
                long receiveTime = totalTime - ttfb - transaction.getRedirectTotalDurationMs();
                if (receiveTime > 0) {
                    transaction.setResponseReceiveDurationMs(receiveTime);
                }
            }
        }
    }
    
    private static void populateSecurityAnalysis(FW_Http transaction) {
        Map<String, String> headers = transaction.getResponseHeaders();
        
        // Security score
        Map<String, Object> securityAnalysis = FW_HttpUtils.analyzeSecurityPosture(headers);
        transaction.setSecurityScore((Integer) securityAnalysis.get("score"));
        
        // Security headers check
        transaction.setHasSecurityHeaders(
            FW_HttpUtils.hasHSTS(headers) ||
            headers.containsKey("Content-Security-Policy") ||
            FW_HttpUtils.hasClickjackingProtection(headers) ||
            FW_HttpUtils.hasXSSProtection(headers)
        );
        
        // Vulnerability detection
        List<FW_HttpUtils.Cookie> cookies = new ArrayList<>();
        if (transaction.getResponseCookies() != null) {
            transaction.getResponseCookies().forEach((name, value) -> {
                cookies.add(new FW_HttpUtils.Cookie(name, value));
            });
        }
        
        List<String> vulnerabilities = FW_HttpUtils.detectVulnerabilities(headers, cookies);
        if (!vulnerabilities.isEmpty()) {
            transaction.setHasVulnerabilities(true);
            transaction.setVulnerabilityDetails(String.join("; ", vulnerabilities));
        }
        
        // Cache analysis
        transaction.setCacheable(FW_HttpUtils.isCacheable(headers));
        transaction.setCacheMaxAge(FW_HttpUtils.getCacheMaxAge(headers));
        
        // API detection
        String contentType = transaction.getResponseContentType();
        if (contentType != null) {
            transaction.setIsApiEndpoint(
                FW_HttpUtils.isJsonContent(contentType) ||
                FW_HttpUtils.isXmlContent(contentType)
            );
        }
        
        // Compliance score
        calculateComplianceScore(transaction);
    }
    
    private static void calculatePerformanceScore(FW_Http transaction) {
        int score = 100;
        
        // Response time penalties
        long totalTime = transaction.getTotalDurationMs();
        if (totalTime > 5000) score -= 30;
        else if (totalTime > 3000) score -= 20;
        else if (totalTime > 2000) score -= 10;
        else if (totalTime > 1000) score -= 5;
        
        // DNS time penalty
        long dnsTime = transaction.getDnsLookupDurationMs();
        if (dnsTime > 500) score -= 10;
        else if (dnsTime > 200) score -= 5;
        
        // Redirect penalty
        if (transaction.hasRedirect()) {
            score -= (transaction.getRedirectCount() * 5); // 5 points per redirect
        }
        
        // Compression bonus
        if (transaction.isCompressed()) {
            score += 10;
            // Extra bonus for good compression ratio
            if (transaction.getCompressionRatio() > 0 && transaction.getCompressionRatio() < 0.5) {
                score += 5;
            }
        }
        
        // Caching bonus
        if (transaction.isCacheable()) {
            score += 5;
            // Extra bonus for long cache times
            if (transaction.getCacheMaxAge() > 3600) {
                score += 5;
            }
        }
        
        // Size penalties
        long size = transaction.getResponseBodySize();
        if (size > 5_000_000) score -= 20;  // Over 5MB
        else if (size > 1_000_000) score -= 10; // Over 1MB
        else if (size > 500_000) score -= 5; // Over 500KB
        
        // HTTP/2 or better bonus (if we could detect it)
        // For now, just check if it's HTTPS which often means HTTP/2
        if (transaction.isSecure()) {
            score += 5;
        }
        
        transaction.setPerformanceScore(Math.max(0, Math.min(100, score)));
    }
    
    private static void calculateComplianceScore(FW_Http transaction) {
        int score = 50; // Base score
        
        Map<String, String> headers = transaction.getResponseHeaders();
        
        // HTTPS usage
        if (transaction.isSecure()) {
            score += 10;
        }
        
        // HSTS
        if (FW_HttpUtils.hasHSTS(headers)) {
            score += 10;
            long hstsMaxAge = FW_HttpUtils.getHSTSMaxAge(headers);
            if (hstsMaxAge >= 31536000) { // 1 year
                score += 5;
            }
        }
        
        // CSP
        if (headers.containsKey("Content-Security-Policy")) {
            score += 10;
        }
        
        // Valid certificate
        if (transaction.hasValidCertificate()) {
            score += 10;
        }
        
        // No critical vulnerabilities
        if (!transaction.hasVulnerabilities()) {
            score += 10;
        }
        
        // Additional security headers
        if (FW_HttpUtils.hasClickjackingProtection(headers)) {
            score += 5;
        }
        
        transaction.setComplianceScore(Math.min(100, score));
    }
    
    private static void validateResponseContent(FW_Http transaction) {
        String contentType = transaction.getResponseContentType();
        String body = transaction.getResponseBodyString();
        
        if (body != null && !body.isEmpty()) {
            if (FW_HttpUtils.isJsonContent(contentType)) {
                // Simple JSON validation - just check if it starts/ends correctly
                String trimmed = body.trim();
                if ((trimmed.startsWith("{") && trimmed.endsWith("}")) ||
                    (trimmed.startsWith("[") && trimmed.endsWith("]"))) {
                    transaction.setContentValidation("VALID_JSON_STRUCTURE");
                } else {
                    transaction.setContentValidation("INVALID_JSON_STRUCTURE");
                }
            } else if (FW_HttpUtils.isXmlContent(contentType)) {
                if (body.trim().startsWith("<?xml") || body.trim().startsWith("<")) {
                    transaction.setContentValidation("XML_PRESENT");
                }
            } else if (FW_HttpUtils.isHtmlContent(contentType)) {
                if (body.toLowerCase().contains("<html") || body.toLowerCase().contains("<!doctype")) {
                    transaction.setContentValidation("HTML_PRESENT");
                }
            } else {
                transaction.setContentValidation("CONTENT_PRESENT");
            }
        }
    }
    
    private static void handleExecutionError(FW_Http transaction, Exception e) {
        transaction.setHasError(true);
        transaction.setErrorType(e.getClass().getSimpleName());
        transaction.setErrorMessage(e.getMessage());

        // Capture stack trace
        StringBuilder stackTrace = new StringBuilder();
        stackTrace.append(e.toString()).append("\n");
        for (StackTraceElement element : e.getStackTrace()) {
            stackTrace.append("  at ").append(element.toString()).append("\n");
            if (stackTrace.length() > 1000) {
                stackTrace.append("  ...\n");
                break;
            }
        }
        transaction.setErrorStackTrace(stackTrace.toString());
        
        // Set response timestamp even on error
        transaction.setResponseTimestamp(FW_DateTimeUtils.getCurrentTimestamp());
    }
    
    // ===============================================================
    // Test Helper Methods - Enhanced for Redirect Display
    // ===============================================================
    
    private static void printQuickSummary(FW_Http http) {
        System.out.println("  Status:      " + getStatusColor(http.getResponseStatusCode()) + 
                         http.getResponseStatusCode() + " " + http.getResponseStatusMessage() + FW_ConsoleColors.RESET);
        System.out.println("  Time:        " + http.getTotalDurationMs() + "ms");
        System.out.println("  Size:        " + http.getResponseBodySize() + " bytes");
        System.out.println("  Type:        " + http.getResponseContentType());
        System.out.println("  Secure:      " + (http.isSecure() ? "Yes (HTTPS)" : "No (HTTP)"));
        
        // Show redirect info if present
        if (http.hasRedirect()) {
            System.out.println("  Redirects:   " + FW_ConsoleColors.YELLOW + http.getRedirectCount() + 
                             " (" + http.getRedirectType() + ")" + FW_ConsoleColors.RESET);
            System.out.println("  Final URL:   " + http.getFinalUrl());
        }
        
        if (http.getPerformanceScore() >= 0) {
            System.out.println("  Performance: " + getScoreColor(http.getPerformanceScore()) + 
                             http.getPerformanceScore() + "/100" + FW_ConsoleColors.RESET);
        }
        
        if (http.hasError()) {
            System.out.println(FW_ConsoleColors.RED + "  Error:       " + http.getErrorMessage() + FW_ConsoleColors.RESET);
        }
    }
    
    private static void printDetailedTimings(FW_Http http) {
        System.out.println("\n  Timing Breakdown:");
        System.out.println("  ├─ DNS Lookup:     " + http.getDnsLookupDurationMs() + "ms");
        System.out.println("  ├─ Connection:     " + http.getConnectionDurationMs() + "ms");
        
        if (http.hasRedirect()) {
            System.out.println("  ├─ Redirects:      " + http.getRedirectTotalDurationMs() + "ms");
        }
        
        if (http.getResponseWaitDurationMs() > 0) {
            System.out.println("  ├─ Wait (TTFB):    " + http.getResponseWaitDurationMs() + "ms");
        }
        if (http.getResponseReceiveDurationMs() > 0) {
            System.out.println("  ├─ Download:       " + http.getResponseReceiveDurationMs() + "ms");
        }
        System.out.println("  └─ Total:          " + http.getTotalDurationMs() + "ms");
        
        System.out.println("\n  Scores:");
        System.out.println("  ├─ Performance:    " + getScoreColor(http.getPerformanceScore()) + 
                         http.getPerformanceScore() + "/100" + FW_ConsoleColors.RESET);
        System.out.println("  ├─ Security:       " + getScoreColor(http.getSecurityScore()) + 
                         http.getSecurityScore() + "/100" + FW_ConsoleColors.RESET);
        System.out.println("  └─ Compliance:     " + getScoreColor(http.getComplianceScore()) + 
                         http.getComplianceScore() + "/100" + FW_ConsoleColors.RESET);
    }
    
    private static void printRedirectDetails(FW_Http http) {
        printQuickSummary(http);
        
        if (http.hasRedirect()) {
            System.out.println("\n  Redirect Chain Analysis:");
            System.out.println("  ├─ Total Redirects: " + http.getRedirectCount());
            System.out.println("  ├─ Redirect Type:   " + http.getRedirectType());
            System.out.println("  ├─ Redirect Time:   " + http.getRedirectTotalDurationMs() + "ms");
            
            if (http.isRedirectLoop()) {
                System.out.println(FW_ConsoleColors.RED + "  ├─ Loop Detected:   YES" + FW_ConsoleColors.RESET);
            }
            
            System.out.println("  └─ Redirect Hops:");
            
            List<String> urls = http.getRedirectUrls();
            List<Integer> codes = http.getRedirectStatusCodes();
            List<Long> durations = http.getRedirectDurations();
            
            for (int i = 0; i < urls.size(); i++) {
                String symbol = (i == urls.size() - 1) ? "└" : "├";
                System.out.printf("      %s─ %d. [%d] %s (%dms)\n",
                    symbol,
                    i + 1,
                    codes.get(i),
                    urls.get(i),
                    durations.get(i));
            }
            
            System.out.println("\n  Final Destination: " + FW_ConsoleColors.GREEN + http.getFinalUrl() + FW_ConsoleColors.RESET);
        }
        
        printDetailedTimings(http);
    }
    
    private static String getStatusColor(int code) {
        if (FW_HttpUtils.isSuccess(code)) return FW_ConsoleColors.GREEN;
        if (FW_HttpUtils.isRedirect(code)) return FW_ConsoleColors.YELLOW;
        return FW_ConsoleColors.RED;
    }
    
    private static String getScoreColor(int score) {
        if (score >= 80) return FW_ConsoleColors.GREEN;
        if (score >= 60) return FW_ConsoleColors.YELLOW;
        return FW_ConsoleColors.RED;
    }
    
    // ========== PRIORITY 4: ENHANCED CERTIFICATE CAPTURE METHODS ==========
    
    /**
     * Captures enhanced certificate details including serial number, signature algorithm,
     * public key details, SANs, chain information, and security analysis.
     * 
     * @param cert The primary X509Certificate
     * @param certs The full certificate chain
     * @param transaction The FW_Http transaction to populate
     */
    private static void enhancedCertificateCapture(X509Certificate cert, Certificate[] certs, FW_Http transaction) {
        try {
            // Certificate serial number (hex format)
            transaction.setCertificateSerialNumber(cert.getSerialNumber().toString(16).toUpperCase());
            
            // Certificate version
            transaction.setCertificateVersion(cert.getVersion());
            
            // Signature algorithm
            String sigAlg = cert.getSigAlgName();
            transaction.setCertificateSignatureAlgorithm(sigAlg);
            
            // Public key analysis
            PublicKey publicKey = cert.getPublicKey();
            String keyAlgorithm = publicKey.getAlgorithm();
            transaction.setCertificatePublicKeyAlgorithm(keyAlgorithm);
            
            // Determine key size based on algorithm type
            int keySize = 0;
            boolean smallKey = false;
            
            if (publicKey instanceof RSAPublicKey) {
                RSAPublicKey rsaKey = (RSAPublicKey) publicKey;
                keySize = rsaKey.getModulus().bitLength();
                smallKey = (keySize < 2048);  // RSA keys should be >= 2048 bits
            } else if (publicKey instanceof ECPublicKey) {
                ECPublicKey ecKey = (ECPublicKey) publicKey;
                // For EC keys, get the field size (curve size)
                keySize = ecKey.getParams().getCurve().getField().getFieldSize();
                smallKey = (keySize < 256);  // EC keys should be >= 256 bits
            }
            
            transaction.setCertificatePublicKeySize(keySize);
            transaction.setCertificateSmallKeySize(smallKey);
            
            // Subject Alternative Names (SANs)
            try {
                Collection<List<?>> sans = cert.getSubjectAlternativeNames();
                if (sans != null) {
                    List<String> sanList = new ArrayList<>();
                    for (List<?> san : sans) {
                        // SAN entry format: [type, value]
                        // Type 2 = DNS name, Type 7 = IP address
                        if (san.size() >= 2) {
                            sanList.add(san.get(1).toString());
                        }
                    }
                    transaction.setCertificateSubjectAlternativeNames(sanList);
                }
            } catch (Exception e) {
                // SANs are optional, continue if not present
            }
            
            // Weak signature algorithm detection
            String sigAlgUpper = sigAlg.toUpperCase();
            boolean weakSig = sigAlgUpper.contains("MD5") || sigAlgUpper.contains("SHA1WITH");
            transaction.setCertificateWeakSignature(weakSig);
            
            // Self-signed detection
            boolean selfSigned = cert.getSubjectX500Principal().equals(cert.getIssuerX500Principal());
            transaction.setCertificateIsSelfSigned(selfSigned);
            
            // Certificate chain analysis
            transaction.setCertificateChainLength(certs.length);
            List<String> chainIssuers = new ArrayList<>();
            for (Certificate c : certs) {
                if (c instanceof X509Certificate) {
                    X509Certificate x509 = (X509Certificate) c;
                    chainIssuers.add(x509.getIssuerX500Principal().toString());
                }
            }
            transaction.setCertificateChainIssuers(chainIssuers);
            
            // Chain validity - basic check (2+ certs expected for proper chain)
            transaction.setCertificateChainValid(certs.length >= 2 && !selfSigned);
            
            // EV certificate detection
            boolean isEV = detectEVCertificate(cert);
            transaction.setCertificateIsEV(isEV);
            
            // Trust level determination
            String trustLevel = determineTrustLevel(cert, selfSigned, isEV);
            transaction.setCertificateTrustLevel(trustLevel);
            
        } catch (Exception e) {
            // Enhanced certificate analysis is best-effort
            // Don't fail the entire transaction if certificate analysis fails
            System.err.println("Enhanced certificate analysis error: " + e.getMessage());
        }
    }
    
    /**
     * Detects if a certificate is an Extended Validation (EV) certificate.
     * EV certificates contain specific policy OIDs in the Certificate Policies extension.
     * 
     * @param cert The X509Certificate to analyze
     * @return true if EV certificate detected, false otherwise
     */
    private static boolean detectEVCertificate(X509Certificate cert) {
        try {
            // Certificate Policies extension OID: 2.5.29.32
            byte[] policiesExt = cert.getExtensionValue("2.5.29.32");
            
            if (policiesExt != null) {
                // Convert to string for OID search
                String policiesStr = new String(policiesExt);
                
                // Common EV policy OIDs:
                // 2.23.140.1.1 - CA/Browser Forum EV Certificate Policy
                // Various CA-specific EV OIDs also exist
                return policiesStr.contains("2.23.140.1.1");
            }
        } catch (Exception e) {
            // Best effort - if we can't determine, assume not EV
        }
        return false;
    }
    
    /**
     * Determines the trust level of a certificate based on validation type.
     * 
     * @param cert The X509Certificate to analyze
     * @param selfSigned Whether the certificate is self-signed
     * @param isEV Whether the certificate is EV
     * @return Trust level: "EV", "OV", "DV", or "SELF_SIGNED"
     */
    private static String determineTrustLevel(X509Certificate cert, boolean selfSigned, boolean isEV) {
        if (selfSigned) {
            return "SELF_SIGNED";
        }
        
        if (isEV) {
            return "EV";  // Extended Validation - highest trust
        }
        
        // Check for Organization (O=) in subject DN
        // OV certificates have organization information
        // DV certificates typically only have domain info (CN=)
        String subject = cert.getSubjectX500Principal().toString();
        
        // Look for O= but exclude generic "Domain Control Validated" text
        if (subject.contains("O=") && !subject.contains("O=Domain Control Validated")) {
            // Has organization info - likely OV (Organization Validated)
            return "OV";
        }
        
        // Default to DV (Domain Validated)
        return "DV";
    }
}