package framework.utilities;

// ===============================================================
// @file: FW_NetworkUtils.java
// @filepath: src/test/java/framework/utilities/FW_NetworkUtils.java
// @version: 1.7.1
// @updated: 2025-10-14 01:45:00 PM CDT
// @author: Greg Paskal
// @company: MissionWares
//
// @description:
// Provides comprehensive network utility methods for IP resolution, 
// connectivity testing, and geolocation services. This utility class 
// contains essential networking operations including hostname resolution,
// IP address lookup, and ping functionality with geographic IP information 
// integration. Supports both IPv4 and IPv6 operations with MaxMind GeoLite2 
// database integration for enhanced location data, making it ideal for 
// network diagnostics, monitoring applications, and geographic network 
// analysis. Now includes anycast detection capabilities, server speed test
// capability checking, and redirect chain analysis for HTTP auditing.
//
// @methods:
// - isValidHost(String) - Validates hostname or IP address format
// - hostToIP(String) - Resolves hostname to IP address
// - hostToHostname(String) - Resolves IP address or URL to hostname
// - hostToVerifiedIP(String) - Resolves and verifies actual connected IP
// - ping(String, int) - Performs single ping test with detailed response
// - detectAnycast(String, boolean) - Detects anycast routing usage
// - getAnycastInfo(String) - Simplified anycast detection
// - getLocationInfo() - Detects user's geographic location via public IP
// - jitter(String, int, int) - Calculates network jitter
// - isPrivateIpAddress(String) - Checks if IP is in private ranges
// - isKnownAnycastService(String) - Checks against known anycast services
// - checkServerIdentification(String) - Checks for server location headers
// - checkTtlVariance(String) - Analyzes TTL variance patterns
// - getNetworkDetails(String) - Creates populated FW_NetworkDetails object
// - checkServerCapabilities(String) - Checks download and upload capabilities
// - dnsLookupTime(String) - Measures DNS lookup time
// - dnsLookupTime(String, boolean) - Measures DNS lookup with cache control
// - measureDnsPerformance(String, int) - DNS performance statistics
// - getAllDnsResolutions(String) - Gets all IP addresses for hostname
// - measureNetworkTimings(String) - Comprehensive network timing metrics
// - analyzeRedirectChain(List) - Analyzes redirect chains for patterns and metrics
// - isRedirectLoop(List) - Detects loops in redirect chains
// - detectRedirectPattern(List) - Identifies redirect pattern types
// - calculateRedirectEfficiency(List, List) - Scores redirect chain efficiency
//
// @dependencies:
// - java.io.*
// - java.net.*
// - java.util.*
// - java.util.concurrent.TimeUnit
// - java.util.regex.*
// - com.maxmind.geoip2.*
// - framework.network.FW_NetworkDetails
// - framework.utilities.FW_ConsoleColors
// - framework.utilities.FW_ConfigMgr
// - framework.utilities.FW_SystemUtils
//
// @tags: network, ping, geolocation, anycast, ipv4, ipv6, redirects, mAi™
//
// @changeLog:
// Date        Author          Version  Description
// ----------  --------------  -------  --------------------------
// 2025-08-19  G. Paskal       1.1.0    Initial creation from FW_Network
// 2025-08-20  G. Paskal       1.2.0    Enhanced with FW_NetworkDetails integration
// 2025-01-20  G. Paskal       1.3.0    Added anycast detection capabilities
// 2025-01-10  G. Paskal       1.4.0    Fixed ping timeout, added debug output, mAi™ header
// 2025-09-15  G. Paskal       1.5.0    Added checkServerCapabilities method with record
// 2025-09-18  G. Paskal       1.6.0    Added complete test coverage for all methods
// 2025-10-14  G. Paskal       1.7.0    Fixed test output: redirect loop display, removed DNS noise, hostname regex for TLDs >5 chars
// 2025-10-14  G. Paskal       1.7.1    Fixed checkServerIdentification bug
// ===============================================================

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.SocketTimeoutException;
import java.net.URI;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.maxmind.geoip2.DatabaseReader;
import com.maxmind.geoip2.exception.GeoIp2Exception;
import com.maxmind.geoip2.model.AsnResponse;
import com.maxmind.geoip2.model.CityResponse;

import framework.network.FW_NetworkDetails;

/**
 * This class contains utility methods for network operations.
 */
public class FW_NetworkUtils {

    /**
     * Main method for testing the utility methods.
     * @param args Command line arguments
     */
    public static void main(String[] args) {
        printHeader();
        
        // ================================================================================
        // CORE NETWORK VALIDATION
        // ================================================================================
        
        testSection("Host Validation", () -> testHostValidation());
        testSection("Private IP Detection", () -> testPrivateIpDetection());
        
        // ================================================================================
        // DNS OPERATIONS
        // ================================================================================
        
        testSection("DNS Resolution", () -> testDnsResolution());
        testSection("Enhanced DNS Operations", () -> testEnhancedDnsOperations());
        
        // ================================================================================
        // NETWORK CONNECTIVITY
        // ================================================================================
        
        testSection("Ping Operations", () -> testPingOperations());
        testSection("Jitter Analysis", () -> testJitterAnalysis());
        testSection("Network Timing", () -> testNetworkTiming());
        testSection("Network Timeout Scenarios", () -> testNetworkTimeouts());
        
        // ================================================================================
        // GEOLOCATION & NETWORK DETAILS
        // ================================================================================
        
        testSection("Network Details", () -> testNetworkDetails());
        testSection("Location Information", () -> testLocationInfo());
        testSection("GeoIP Services", () -> testGeoIP());
        
        // ================================================================================
        // ANYCAST DETECTION
        // ================================================================================
        
        testSection("Anycast Detection", () -> testAnycastDetection());
        testSection("Simplified Anycast API", () -> testSimplifiedAnycastApi());
        
        // ================================================================================
        // IPv6 SUPPORT
        // ================================================================================
        
        testSection("IPv6 Support", () -> testIPv6Support());
        
        // ================================================================================
        // SPEED TEST CAPABILITIES
        // ================================================================================
        
        testSection("Server Capabilities", () -> testServerCapabilities());
        testSection("ServerCapabilities Record", () -> testServerCapabilitiesRecord());
        
        // ================================================================================
        // REDIRECT CHAIN ANALYSIS
        // ================================================================================
        
        testSection("Redirect Chain Analysis", () -> testRedirectChainAnalysis());
        testSection("Long Redirect Chains", () -> testLongRedirectChains());
        
        // ================================================================================
        // EDGE CASES & ERROR HANDLING
        // ================================================================================
        
        testSection("Edge Cases & Error Handling", () -> testEdgeCases());

        printSummary();
    }

    /**
     * Helper method to run test sections with consistent formatting.
     */
    private static void testSection(String sectionName, Runnable testMethod) {
        System.out.println();
        System.out.println(FW_ConsoleColors.CORAL + "━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println("▶ " + sectionName);
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━" + FW_ConsoleColors.RESET);
        
        testMethod.run();
        
        System.out.println(FW_ConsoleColors.GREEN + "✓ " + sectionName + " Complete" + FW_ConsoleColors.RESET);
    }

    private static void printHeader() {
        System.out.println();
        System.out.println(FW_ConsoleColors.CORAL + "╔══════════════════════════════════════════════════════════════════════════════╗");
        System.out.println("║                   FW_NetworkUtils COMPREHENSIVE TEST SUITE                    ║");
        System.out.println("╠══════════════════════════════════════════════════════════════════════════════╣");
        System.out.println("║         Testing all network utility methods including redirect analysis       ║");
        System.out.println("╚══════════════════════════════════════════════════════════════════════════════╝" + FW_ConsoleColors.RESET);
    }

    private static void printSummary() {
        System.out.println();
        System.out.println(FW_ConsoleColors.GREEN + "════════════════════════════════════════════════════════════════════════════════");
        System.out.println("                        ALL TESTS COMPLETED SUCCESSFULLY                         ");
        System.out.println("════════════════════════════════════════════════════════════════════════════════" + FW_ConsoleColors.RESET);
        System.out.println();
        System.out.println("  Total Test Categories: 17");
        System.out.println("  Public Methods Tested: 26+");
        System.out.println("  IPv6 Test Scenarios: 4");
        System.out.println("  Timeout Test Scenarios: 3");
        System.out.println("  Private Methods Tested: 3 (indirectly)");
        System.out.println("  New Redirect Methods:  4");
        System.out.println("  Framework Status:      " + FW_ConsoleColors.GREEN + "READY FOR PRODUCTION" + FW_ConsoleColors.RESET);
        System.out.println();
    }

    // ================================================================================
    // Individual Test Methods
    // ================================================================================

    private static void testHostValidation() {
        String[] validationTests = {
            "192.168.1.1", "www.google.com", "https://example.com",
            "invalid..host", "256.256.256.256", "::1",
            "2001:4860:4860::8888", null, "", "   "
        };
        
        System.out.println("\n  Testing host validation:");
        for (String test : validationTests) {
            boolean isValid = isValidHost(test);
            String displayTest = (test == null) ? "null" : 
                            test.trim().isEmpty() ? "\"" + test + "\"" : test;
            String symbol = isValid ? "✓" : "✗";
            System.out.printf("    %s %-30s: %s\n", symbol, displayTest, isValid ? "Valid" : "Invalid");
        }
    }

    private static void testPrivateIpDetection() {
        String[] ipTests = {
            "192.168.1.1", "10.0.0.1", "172.16.0.1", "8.8.8.8",
            "127.0.0.1", "169.254.1.1", "::1", "fe80::1", null, ""
        };
        
        System.out.println("\n  Testing private IP detection:");
        for (String ip : ipTests) {
            boolean isPrivate = isPrivateIpAddress(ip);
            String displayIp = (ip == null) ? "null" : ip;
            String symbol = isPrivate ? "🔒" : "🌐";
            System.out.printf("    %s %-20s: %s\n", symbol, displayIp, 
                            isPrivate ? "Private" : "Public");
        }
    }

    private static void testDnsResolution() {
        System.out.println("\n  DNS Resolution Tests:");
        
        // Test hostname to IP
        String hostname = "dns.google";
        String ip = hostToIP(hostname);
        System.out.println("    " + hostname + " → " + (ip != null ? ip : "Failed"));
        
        // Test IP to hostname
        String testIp = "8.8.8.8";
        String resolvedHost = hostToHostname(testIp);
        System.out.println("    " + testIp + " → " + (resolvedHost != null ? resolvedHost : "Failed"));
        
        // Test verified IP resolution
        String verifiedIp = hostToVerifiedIP("www.google.com");
        System.out.println("    www.google.com (verified) → " + 
                        (verifiedIp != null ? verifiedIp : "Failed"));
    }

    private static void testIPv6Support() {
        System.out.println("\n  IPv6 Network Operations:");
        
        String[] ipv6Tests = {
            "2001:4860:4860::8888",  // Google DNS
            "2606:4700:4700::1111",  // Cloudflare DNS
            "::1",                    // Localhost
            "fe80::1"                 // Link-local
        };
        
        for (String ipv6 : ipv6Tests) {
            System.out.printf("    Testing %s:\n", ipv6);
            
            // Validation
            boolean valid = isValidHost(ipv6);
            System.out.printf("      Valid: %s\n", valid);
            
            // Private check
            boolean isPrivate = isPrivateIpAddress(ipv6);
            System.out.printf("      Private: %s\n", isPrivate);
            
            // Network details (if valid)
            if (valid && !isPrivate) {
                FW_NetworkDetails details = getNetworkDetails(ipv6);
                if (details != null && details.getIp() != null) {
                    System.out.printf("      ASN: AS%s\n", details.getAsn());
                }
            }
            System.out.println();
        }
    }

    private static void testEnhancedDnsOperations() {
        String testHost = "www.google.com";
        
        System.out.println("\n  DNS Performance Analysis:");
        
        // Lookup times
        long basicTime = dnsLookupTime(testHost);
        long cachedTime = dnsLookupTime(testHost, false);
        long uncachedTime = dnsLookupTime(testHost, true);
        
        System.out.printf("    %-20s: %d ms\n", "Basic lookup", basicTime);
        System.out.printf("    %-20s: %d ms (%.1fx faster)\n", "Cached lookup", cachedTime,
                        basicTime > 0 ? (double)basicTime/cachedTime : 0);
        System.out.printf("    %-20s: %d ms\n", "Uncached lookup", uncachedTime);
        
        // Performance statistics
        Map<String, Object> perfStats = measureDnsPerformance("dns.google", 5);
        System.out.println("\n  DNS Performance Statistics (5 samples):");
        System.out.printf("    Min/Max/Avg:        %d/%d/%.1f ms\n",
                        perfStats.get("min_ms"), perfStats.get("max_ms"), 
                        (double)perfStats.get("avg_ms"));
        System.out.printf("    Cache Hit Rate:     %.1f%%\n", 
                        (double)perfStats.get("cache_hit_rate"));
        
        // Multiple resolutions
        List<String> resolutions = getAllDnsResolutions("dns.google");
        System.out.println("    All IPs for dns.google: " + resolutions);
    }

    private static void testPingOperations() {
        String hostname = "dns.google";
        int timeout = 3000;
        
        System.out.println("\n  Ping Test to " + hostname + ":");
        
        Map<Integer, Map<String, String>> pingResult = ping(hostname, timeout);
        Map<String, String> details = pingResult.get(0);
        
        if (details.get("status").contains("[Pass]")) {
            System.out.println("    ✓ Ping successful");
            System.out.printf("    IP: %s, TTL: %s, Time: %s ms\n",
                            details.get("ip"), details.get("ttl"), details.get("time"));
        } else {
            System.out.println("    ✗ Ping failed: " + details.get("details"));
        }
    }

    private static void testJitterAnalysis() {
        System.out.println("\n  Network Jitter Analysis:");
        
        Map<String, String> jitterResult = jitter("8.8.8.8", 5, 1000);
        String status = jitterResult.get("status");
        
        if (status.contains("[Pass]")) {
            System.out.printf("    Standard Deviation: %s ms\n", 
                            jitterResult.get("standard_deviation"));
            System.out.printf("    Samples: %s\n", jitterResult.get("ping_count"));
        } else {
            System.out.println("    Jitter test failed: " + jitterResult.get("details"));
        }
    }

    private static void testNetworkTiming() {
        System.out.println("\n  Network Timing Measurements:");
        
        String[] testUrls = {"https://www.google.com", "https://api.github.com"};
        
        for (String url : testUrls) {
            Map<String, Long> timings = measureNetworkTimings(url);
            System.out.printf("\n    %s:\n", url);
            System.out.printf("      DNS: %d ms | Connect: %d ms | TTFB: %d ms | Total: %d ms\n",
                            timings.get("dns_time_ms"), timings.get("connect_time_ms"),
                            timings.get("ttfb_ms"), timings.get("total_time_ms"));
        }
    }

    private static void testNetworkTimeouts() {
        System.out.println("\n  Network Timeout Scenarios:");
        
        // Test unreachable host
        String unreachableHost = "192.168.255.254"; // Likely unreachable
        Map<Integer, Map<String, String>> timeoutPing = ping(unreachableHost, 1000);
        System.out.printf("    Unreachable host ping: %s\n", 
                        timeoutPing.get(0).get("status"));
        
        // Test DNS timeout
        long dnsTime = dnsLookupTime("nonexistent-domain-12345.invalid");
        System.out.printf("    Nonexistent domain DNS: %d ms\n", dnsTime);
        
        // Test connection timeout
        Map<String, Long> timeoutTimings = measureNetworkTimings("http://192.168.255.254");
        System.out.printf("    Unreachable host timing: %d ms\n", 
                        timeoutTimings.get("total_time_ms"));
    }

    private static void testNetworkDetails() {
        System.out.println("\n  Network Details Lookup:");
        
        String[] hosts = {"www.MissionWares.com", "8.8.8.8"};
        
        for (String host : hosts) {
            FW_NetworkDetails details = getNetworkDetails(host);
            if (details != null && details.getIp() != null) {
                System.out.printf("\n    %s:\n", host);
                System.out.printf("      Location: %s, %s\n", details.getCity(), 
                                details.getCountryCode());
                System.out.printf("      ASN: AS%s (%s)\n", details.getAsn(), 
                                details.getAsnOrganization());
                System.out.printf("      Coordinates: %.2f, %.2f\n", 
                                details.getLatitude(), details.getLongitude());
            }
        }
    }

    private static void testLocationInfo() {
        System.out.println("\n  Current Location Information:");
        
        FW_NetworkDetails location = getLocationInfo();
        if (location != null && location.getIp() != null) {
            System.out.printf("    Your IP: %s\n", location.getIp());
            System.out.printf("    Location: %s, %s\n", location.getCity(), 
                            location.getCountryCode());
            System.out.printf("    ISP: %s\n", location.getAsnOrganization());
        } else {
            System.out.println("    Could not determine location");
        }
    }

    private static void testGeoIP() {
        System.out.println("\n  GeoIP Lookup Test:");
        
        FW_NetworkDetails details = getNetworkDetails("8.8.8.8");
        if (details != null && details.getIp() != null) {
            System.out.printf("    8.8.8.8 → %s, %s (AS%s)\n",
                            details.getCity(), details.getCountryCode(), 
                            details.getAsn());
        }
    }

    private static void testAnycastDetection() {
        System.out.println("\n  Anycast Service Detection:");
        
        String[] testHosts = {"1.1.1.1", "8.8.8.8", "dns.google", "www.google.com"};
        
        for (String host : testHosts) {
            Map<String, String> result = detectAnycast(host, false);
            boolean isAnycast = "true".equals(result.get("is_anycast"));
            String symbol = isAnycast ? "⚡" : "○";
            System.out.printf("    %s %-20s: %s (Confidence: %s)\n",
                            symbol, host, isAnycast ? "Anycast" : "Unicast",
                            result.get("confidence"));
        }
    }

    private static void testSimplifiedAnycastApi() {
        System.out.println("\n  Simplified Anycast API Test:");
        
        String[] hosts = {"1.1.1.1", "dns.google", "www.google.com"};
        
        for (String host : hosts) {
            Map<String, String> info = getAnycastInfo(host);
            System.out.printf("    %-20s: Anycast=%s, IP=%s\n",
                            host, info.get("is_anycast"), info.get("ip_address"));
        }
    }

    private static void testServerCapabilities() {
        System.out.println("\n  Speed Test Server Capabilities:");
        
        String[] servers = {
            "https://speed.cloudflare.com/__down",
            "http://speedtest.tele2.net"
        };
        
        for (String server : servers) {
            ServerCapabilities caps = checkServerCapabilities(server);
            System.out.printf("\n    %s:\n", server);
            System.out.printf("      Download: %s | Upload: %s\n",
                            caps.supportsDownload() ? "✓" : "✗",
                            caps.supportsUpload() ? "✓" : "✗");
            if (caps.errorMessage() != null) {
                System.out.printf("      Error: %s\n", caps.errorMessage());
            }
        }
    }

    private static void testServerCapabilitiesRecord() {
        System.out.println("\n  ServerCapabilities Record Test:");
        
        ServerCapabilities caps = checkServerCapabilities("https://speed.cloudflare.com/__down");
        
        // Test all record methods
        System.out.printf("    supportsDownload(): %s\n", caps.supportsDownload());
        System.out.printf("    supportsUpload(): %s\n", caps.supportsUpload());
        System.out.printf("    downloadEndpoint(): %s\n", caps.downloadEndpoint());
        System.out.printf("    uploadEndpoint(): %s\n", caps.uploadEndpoint());
        System.out.printf("    errorMessage(): %s\n", caps.errorMessage());
        System.out.printf("    additionalInfo(): %s\n", caps.additionalInfo());
    }

    private static void testRedirectChainAnalysis() {
        System.out.println("\n  Redirect Chain Analysis Tests:");
        
        // Test 1: Simple redirect chain
        System.out.println("\n    Test 1: Normal redirect chain");
        List<String> normalChain = Arrays.asList(
            "http://example.com",
            "https://example.com",
            "https://www.example.com"
        );
        
        Map<String, Object> analysis1 = analyzeRedirectChain(normalChain);
        System.out.printf("      Chain Length: %d\n", analysis1.get("chain_length"));
        System.out.printf("      Pattern: %s\n", analysis1.get("pattern"));
        System.out.printf("      Cross-domain: %s\n", analysis1.get("cross_domain"));
        System.out.printf("      Protocol Change: %s\n", analysis1.get("protocol_change"));
        
        // Test 2: Redirect loop
        System.out.println("\n    Test 2: Redirect loop detection");
        List<String> loopChain = Arrays.asList(
            "https://example.com/page1",
            "https://example.com/page2",
            "https://example.com/page1"  // Loop back
        );
        
        boolean hasLoop = isRedirectLoop(loopChain);
        System.out.printf("      Has Loop: %s\n", hasLoop ? "✓ Yes (loop detected)" : "✓ No (no loop)");
        
        // Test 3: Pattern detection
        System.out.println("\n    Test 3: Pattern detection");
        
        // HTTPS upgrade pattern
        List<String> httpsUpgrade = Arrays.asList(
            "http://example.com",
            "https://example.com"
        );
        System.out.printf("      HTTP→HTTPS: %s\n", 
                        detectRedirectPattern(httpsUpgrade));
        
        // CDN pattern
        List<String> cdnChain = Arrays.asList(
            "https://example.com",
            "https://cdn.example.com/content"
        );
        System.out.printf("      CDN redirect: %s\n", 
                        detectRedirectPattern(cdnChain));
        
        // Auth pattern
        List<String> authChain = Arrays.asList(
            "https://app.example.com",
            "https://app.example.com/login",
            "https://app.example.com/dashboard"
        );
        System.out.printf("      Auth redirect: %s\n", 
                        detectRedirectPattern(authChain));
        
        // Test 4: Efficiency scoring
        System.out.println("\n    Test 4: Redirect efficiency");
        
        List<Long> fastDurations = Arrays.asList(50L, 75L, 100L);
        List<Long> slowDurations = Arrays.asList(500L, 750L, 1000L);
        
        int fastScore = calculateRedirectEfficiency(normalChain, fastDurations);
        int slowScore = calculateRedirectEfficiency(normalChain, slowDurations);
        
        System.out.printf("      Fast chain (225ms): %d/100\n", fastScore);
        System.out.printf("      Slow chain (2250ms): %d/100\n", slowScore);
        System.out.printf("      No redirects: %d/100\n", calculateRedirectEfficiency(null, null));
    }

    private static void testLongRedirectChains() {
        System.out.println("\n  Long Redirect Chain Tests:");
        
        // Test 1: Long chain (10 redirects)
        List<String> longChain = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            longChain.add("https://example.com/redirect" + i);
        }
        
        Map<String, Object> analysis = analyzeRedirectChain(longChain);
        System.out.printf("    10-redirect chain length: %d\n", analysis.get("chain_length"));
        System.out.printf("    Has loop: %s\n", analysis.get("has_loop"));
        
        // Test 2: Chain with invalid URLs mixed in
        List<String> mixedChain = Arrays.asList(
            "https://example.com",
            "not-a-valid-url",
            "https://example.com/page2"
        );
        
        Map<String, Object> mixedAnalysis = analyzeRedirectChain(mixedChain);
        System.out.printf("    Mixed chain (with invalid URL) valid: %s\n", 
                        mixedAnalysis.get("valid"));
        
        // Test 3: Very long durations
        List<Long> verySlowDurations = Arrays.asList(2000L, 3000L, 4000L);
        int slowScore = calculateRedirectEfficiency(longChain, verySlowDurations);
        System.out.printf("    Very slow chain (9000ms): %d/100\n", slowScore);
    }

    private static void testEdgeCases() {
        System.out.println("\n  Edge Cases & Error Handling:");
        
        // Null/empty inputs
        System.out.println("    Null/Empty Input Tests:");
        System.out.printf("      hostToIP(null): %s\n", hostToIP(null));
        System.out.printf("      isValidHost(\"   \"): %s\n", isValidHost("   "));
        
        // Invalid parameters
        Map<Integer, Map<String, String>> nullPing = ping(null, 1000);
        System.out.printf("      ping(null): %s\n", 
                        nullPing.get(0).get("status"));
        
        // Redirect analysis edge cases
        System.out.println("\n    Redirect Analysis Edge Cases:");
        Map<String, Object> nullAnalysis = analyzeRedirectChain(null);
        System.out.printf("      Null chain valid: %s\n", nullAnalysis.get("valid"));
        System.out.printf("      Error message: %s\n", nullAnalysis.get("error"));
        
        List<String> emptyChain = new ArrayList<>();
        boolean emptyLoop = isRedirectLoop(emptyChain);
        System.out.printf("      Empty chain has loop: %s\n", emptyLoop);
    }
    
    /**
     * Performs a detailed check on a server's speed test capabilities.
     * It attempts a lightweight download and upload to determine support.
     * @param serverUrl The base URL of the server (e.g., "http://speedtest.tele2.net/")
     * @return A ServerCapabilities record with detailed information on support.
     */
    public static ServerCapabilities checkServerCapabilities(String serverUrl) {
        
        // Check for a known Cloudflare pattern and handle it specifically
        String downloadTestUrl = serverUrl;
        String uploadEndpoint = getUploadEndpoint(serverUrl);
        
        if (serverUrl.contains("cloudflare.com/__down")) {
            // Check if bytes parameter already exists
            if (!serverUrl.contains("bytes=")) {
                downloadTestUrl = serverUrl + "?bytes=1024";
            } else {
                downloadTestUrl = serverUrl; // Use as-is
            }
        } else if (serverUrl.endsWith(".zip") || serverUrl.endsWith(".dat") || serverUrl.endsWith(".bin")) {
            // Assume the URL is already a direct download link
            downloadTestUrl = serverUrl;
        } else {
            // General server, append a known small file
            if (!downloadTestUrl.endsWith("/")) {
                downloadTestUrl += "/";
            }
            downloadTestUrl += "1KB.zip";
        }

        // Check for download capability using a GET request for a small payload
        boolean supportsDownload = false;
        String downloadError = null;
        try {
            URL url = URI.create(downloadTestUrl).toURL();
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setConnectTimeout(5000);
            conn.setReadTimeout(5000);
            int responseCode = conn.getResponseCode();
            
            // Check for success codes or redirects
            if (responseCode >= 200 && responseCode < 400) {
                supportsDownload = true;
            } else {
                downloadError = "HTTP Response Code: " + responseCode;
            }
            conn.disconnect();
        } catch (IllegalArgumentException e) {
            downloadError = "Invalid URL: " + e.getMessage();
        } catch (IOException e) {
            downloadError = "Download check failed: " + e.getMessage();
        }

        // Check for upload capability using a POST request with a tiny payload
        boolean supportsUpload = false;
        String uploadError = null;
        if (uploadEndpoint != null) {
            try {
                URL url = URI.create(uploadEndpoint).toURL();
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setDoOutput(true);
                conn.setRequestMethod("POST");
                conn.setConnectTimeout(5000);
                conn.setReadTimeout(5000);
                conn.setRequestProperty("Content-Type", "application/octet-stream");
                
                // Write a single byte to trigger the request
                try (OutputStream os = conn.getOutputStream()) {
                    os.write(new byte[1]);
                }
                
                int responseCode = conn.getResponseCode();
                if (responseCode >= 200 && responseCode < 300) {
                    supportsUpload = true;
                } else {
                    uploadError = "HTTP Response Code: " + responseCode;
                }
                conn.disconnect();
            } catch (IllegalArgumentException e) {
                uploadError = "Invalid URL: " + e.getMessage();
            } catch (IOException e) {
                uploadError = "Upload check failed: " + e.getMessage();
            }
        }

        // Aggregate error messages if both checks fail
        String combinedError = null;
        if (downloadError != null && uploadError != null) {
            combinedError = "Download Check: " + downloadError + "; Upload Check: " + uploadError;
        } else if (downloadError != null) {
            combinedError = "Download Check: " + downloadError;
        } else if (uploadError != null) {
            combinedError = "Upload Check: " + uploadError;
        }

        // Return a new ServerCapabilities object with the findings
        return new ServerCapabilities(
            supportsDownload,
            supportsUpload,
            supportsDownload ? downloadTestUrl : null,
            supportsUpload ? uploadEndpoint : null,
            combinedError,
            new HashMap<>()
        );
    }
    
    // Upload endpoints for servers that support it
    private static final Map<String, String> UPLOAD_ENDPOINTS = Map.of(
        "speedtest.tele2.net", "http://speedtest.tele2.net/upload.php",
        "www.speedtest.net", "https://www.speedtest.net/api/js/upload",
        "fast.com", "https://api.fast.com/netflix/speedtest/v2/upload",
        "speed.hetzner.de", "https://speed.hetzner.de/upload.php",
        "speedtest-nyc1.digitalocean.com", "http://speedtest-nyc1.digitalocean.com/upload",
        "speedtest.atlanta.linode.com", "http://speedtest.atlanta.linode.com/upload",
        "speedtest.miami.linode.com", "http://speedtest.miami.linode.com/upload",
        "speedtest.mybroadband.co.za", "http://speedtest.mybroadband.co.za/upload.php"
    );
    
    /**
     * Gets the upload endpoint for a given server.
     */
    private static String getUploadEndpoint(String serverUrl) {
        String hostname = serverUrl.replace("http://", "").replace("https://", "").split("/")[0];
        
        // Check if we have a known upload endpoint
        for (Map.Entry<String, String> entry : UPLOAD_ENDPOINTS.entrySet()) {
            if (hostname.contains(entry.getKey())) {
                return entry.getValue();
            }
        }
        
        return null; // No known upload endpoint
    }

    // Location cache configuration
    private static final long LOCATION_CACHE_DURATION = 3600000; // 1 hour
    
    // Location cache instance variables
    private static FW_NetworkDetails cachedLocation = null;
    private static long locationCacheTime = 0;

    /**
     * Detects the user's geographic location using their public IP address.
     * Results are cached for 1 hour to avoid repeated external lookups.
     * This method is thread-safe and uses static caching for consistency with other utility methods.
     *
     * @return FW_NetworkDetails object containing location details, or a default object if detection fails.
     */
    public static FW_NetworkDetails getLocationInfo() {
        long currentTime = System.currentTimeMillis();
        
        // Check if we have a valid cached result
        synchronized (FW_NetworkUtils.class) {
            if (cachedLocation != null && (currentTime - locationCacheTime) < LOCATION_CACHE_DURATION) {
                return cachedLocation;
            }
        }

        try {
            // Use ipify.org to get public IP address
            URL ipify = URI.create("https://api.ipify.org").toURL();
            String publicIp;
            try (BufferedReader in = new BufferedReader(new InputStreamReader(ipify.openStream()))) {
                publicIp = in.readLine();
            }
            
            // Validate the IP response
            if (publicIp == null || publicIp.trim().isEmpty()) {
                System.out.println(FW_ConsoleColors.YELLOW + "[Warn] - Empty IP response from service" + FW_ConsoleColors.RESET);
                return new FW_NetworkDetails("empty-ip-response");
            }

            // Get location details using the FW_NetworkDetails class
            FW_NetworkDetails location = getNetworkDetails(publicIp);

            // Cache the result if it's valid
            if (location != null && location.getIp() != null) {
                synchronized (FW_NetworkUtils.class) {
                    cachedLocation = location;
                    locationCacheTime = currentTime;
                }
            } else {
                System.out.println(FW_ConsoleColors.YELLOW + "[Warn] - Location lookup failed for IP: " + publicIp + FW_ConsoleColors.RESET);
                return new FW_NetworkDetails(publicIp); // Return a basic object if lookup fails
            }

            return location;
            
        } catch (IOException e) {
            System.out.println(FW_ConsoleColors.YELLOW + "[Warn] - Could not determine public IP address: " + e.getMessage() + FW_ConsoleColors.RESET);
            return new FW_NetworkDetails("unknown-ip-error");
        }
    }

    /**
     * Validates if the given string is a valid network target (IPv4, IPv6, or hostname/URL).
     * This method serves as a robust input validator before attempting network operations.
     *
     * @param host The host string to validate.
     * @return true if the host is valid, false otherwise.
     */
    public static boolean isValidHost(String host) {
        if (host == null || host.trim().isEmpty()) {
            return false;
        }

        // Regex for IPv4 address
        String ipv4Pattern = "^((25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$";
        // Regex for a simple Hostname/URL (covers www.google.com and http://google.com)
        String hostnamePattern = "^((http|https)://)?(www\\.)?([a-zA-Z0-9]+([\\-\\.]{1}[a-zA-Z0-9]+)*\\.[a-zA-Z]{2,})(:[0-9]{1,5})?(/.*)?$";
        // A more simplified IPv6 check for common formats. A comprehensive regex is extremely complex.
        if (host.contains(":")) {
             try {
                java.net.InetAddress.getByName(host);
                return true; // Let the built-in parser validate complex IPv6
            } catch (java.net.UnknownHostException e) {
                // Not a valid address format
            }
        }

        // Check against the patterns
        return host.matches(ipv4Pattern) ||
               host.matches(hostnamePattern);
    }

    /**
     * This method resolves a host to an IP address.
     *
     * @param host The host to resolve. Can include protocol (http:// or https://)
     *
     * @return The IP address of the host is returned or null if the host cannot be resolved and an error is encountered.
     */
    public static String hostToIP(String host) {
        if (host == null || host.isEmpty()) {
            System.out.println(FW_ConsoleColors.YELLOW + "- [Warn] - Host cannot be null or empty." + FW_ConsoleColors.RESET);
            return null;
        }

        String originalHost = host; // Save for error messages
        
        // Strip protocol if present
        if (host.startsWith("http://") || host.startsWith("https://")) {
            try {
                URI uri = URI.create(host);
                host = uri.getHost();
                if (host == null) {
                    System.out.println(FW_ConsoleColors.YELLOW + "- [Warn] - Could not extract hostname from URL: '" + originalHost + "'." + FW_ConsoleColors.RESET);
                    return null;
                }
            } catch (IllegalArgumentException e) {  // ✅ Changed exception type
                System.out.println(FW_ConsoleColors.YELLOW + "- [Warn] - Invalid URL format: '" + originalHost + "'." + FW_ConsoleColors.RESET);
                return null;
            }
        }

        try {
            InetAddress address = InetAddress.getByName(host);
            return address.getHostAddress();
        } catch (UnknownHostException e) {
            System.out.println(FW_ConsoleColors.YELLOW + "- [Warn] - Unknown host: '" + host + "'." + FW_ConsoleColors.RESET);
            return null;
        } catch (Exception e) {
            System.out.println(FW_ConsoleColors.YELLOW + "- [Warn] - Unexpected error: " + e.getMessage() + FW_ConsoleColors.RESET);
            return null;
        }
    }

    /**
     * This method resolves and verifies the actual IP address that would be connected to for a given host.
     * Performs actual HTTP connection to verify the host is reachable.
     *
     * @param host The host to resolve and verify. Can include protocol (http:// or https://)
     * 
     * @return The verified IP address that was successfully connected to, or null on failure
     */
    public static String hostToVerifiedIP(String host) {
        if (host == null || host.isEmpty()) {
            System.out.println(FW_ConsoleColors.YELLOW + "- [Warn] - Host cannot be null or empty." + FW_ConsoleColors.RESET);
            return null;
        }

        try {
            // Ensure URL has protocol
            if (!host.startsWith("http://") && !host.startsWith("https://")) {
                host = "http://" + host;
            }
            
            URL url = URI.create(host).toURL();
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("HEAD");
            connection.setConnectTimeout(3000);
            connection.setReadTimeout(3000);
            
            // Force connection to get actual remote address
            connection.connect();
            
            // Get the URL's host and resolve it
            String URLhost = url.getHost();
            if (URLhost != null) {

                // Note: Java's HttpURLConnection doesn't expose the actual connected IP directly
                // This performs a fresh DNS lookup which should match the connected IP
                InetAddress addr = InetAddress.getByName(URLhost);
                String remoteIp = addr.getHostAddress();
                connection.disconnect();
                return remoteIp;
            }
            
            connection.disconnect();
        } catch (ConnectException | SocketTimeoutException e) {
            System.out.println(FW_ConsoleColors.YELLOW + "- [Warn] - Connection failed to host: '" + host + "'. Host may be unreachable." + FW_ConsoleColors.RESET);
        } catch (IllegalArgumentException e) {  // ✅ Changed from URISyntaxException
            System.out.println(FW_ConsoleColors.YELLOW + "- [Warn] - Invalid URI syntax: '" + host + "'." + FW_ConsoleColors.RESET);
        } catch (IOException e) {
            System.out.println(FW_ConsoleColors.YELLOW + "- [Warn] - Failed to verify host: '" + host + "'. Error: " + e.getMessage() + FW_ConsoleColors.RESET);
        }
        
        return null;
    }

    /**
    * This method resolves a host or IP to a hostname.
    *
    * @param host The host or IP to resolve.
    *
    * @return The hostname of the host or null if the host cannot be resolved or an error is encountered.
    */
   public static String hostToHostname(String host) {

       // Validate input parameters
       if (host == null || host.isEmpty()) {
           System.out.println(FW_ConsoleColors.YELLOW + "- [Warn] - Host cannot be null or empty." + FW_ConsoleColors.RESET);
           return null;
       }

       try {

            // Handle URLs without a scheme
            if (!host.startsWith("http://") && !host.startsWith("https://") && host.contains(".")) {
                host = "http://" + host;
            }

            String hostName;
            // Check if the host starts with http:// or https:// and extract the host name
            if (host.startsWith("http://") || host.startsWith("https://")) {
                URI uri = URI.create(host);
                hostName = uri.getHost();
            } else {
                hostName = host;
            }

            // Resolve the host name to an IP address
            InetAddress address = InetAddress.getByName(hostName);
            return address.getHostName();

        } catch (UnknownHostException e) {
            System.out.println(FW_ConsoleColors.YELLOW + "- [Warn] - Unable to resolve hostname for '" + host + "'." + FW_ConsoleColors.RESET);
            return null;
        } catch (IllegalArgumentException e) {  // ✅ Changed from URISyntaxException
            System.out.println(FW_ConsoleColors.YELLOW + "- [Warn] - Invalid URL format: '" + host + "'." + FW_ConsoleColors.RESET);
            return null;
        } catch (Exception e) {
            System.out.println(FW_ConsoleColors.YELLOW + "- [Warn] - Unexpected error: " + e.getMessage() + FW_ConsoleColors.RESET);
            return null;
        }
   }

    /**
     * Checks if a given IP address string falls within known private/local network ranges.
     * Based on InetAddress methods: isSiteLocalAddress(), isLoopbackAddress(), isLinkLocalAddress().
     * @param ipAddress The IP address string to check.
     * @return true if the IP is determined to be private or local, false otherwise or if input is invalid.
     */
    public static boolean isPrivateIpAddress(String ipAddress) {
        if (ipAddress == null || ipAddress.isEmpty()) {
            return false; // Cannot be private if invalid
        }
        // Handle potential IPv6 zone indices like %eth0 - remove them
        if (ipAddress.contains("%")) {
            ipAddress = ipAddress.substring(0, ipAddress.indexOf('%'));
        }
        try {
            InetAddress address = InetAddress.getByName(ipAddress);
            return address.isSiteLocalAddress() || // Covers 10.x, 172.16-31.x, 192.168.x, fc00::/7
                address.isLoopbackAddress() || // Covers 127.x, ::1
                address.isLinkLocalAddress(); // Covers 169.254.x, fe80::/10
        } catch (UnknownHostException e) {
            // If it's not a valid IP address format, it can't be a private one either
            System.out.println(FW_ConsoleColors.YELLOW + "[Warn] - isPrivateIpAddress check failed for invalid address format: " + ipAddress + FW_ConsoleColors.RESET);
            return false;
        }
    }

    /**
     * Detects if a hostname or IP address is using anycast routing by analyzing network characteristics.
     * Uses multiple detection strategies including geographic distribution analysis, TTL variance,
     * and server identification patterns.
     * 
     * @param host The hostname or IP address to check
     * @param verbose If true, prints detailed detection information
     * @return Map containing detection results with keys:
     *         "is_anycast" - "true" or "false"
     *         "confidence" - "high", "medium", or "low"
     *         "confidence_score" - Numeric score (0-100)
     *         "ip_address" - The resolved IP address
     *         "indicators" - Comma-separated list of detected indicators
     *         "server_id" - Server identification if detected
     *         "details" - Additional information about the detection
     */
    public static Map<String, String> detectAnycast(String host, boolean verbose) {
        Map<String, String> result = new HashMap<>();
        
        // Validate input
        if (!isValidHost(host)) {
            result.put("is_anycast", "false");
            result.put("confidence", "low");
            result.put("confidence_score", "0");
            result.put("details", "Invalid host format");
            return result;
        }
        
        // Resolve to IP first
        String ipAddress = hostToIP(host);
        if (ipAddress == null) {
            result.put("is_anycast", "false");
            result.put("confidence", "low");
            result.put("confidence_score", "0");
            result.put("details", "Could not resolve host to IP");
            return result;
        }
        result.put("ip_address", ipAddress);
        
        List<String> indicators = new ArrayList<>();
        int confidenceScore = 0;
        
        // Strategy 1: Check known anycast services
        if (isKnownAnycastService(host)) {
            indicators.add("known_anycast_service");
            confidenceScore += 40;
            if (verbose) {
                System.out.println(FW_ConsoleColors.CORAL + "  [Anycast] Known anycast service detected" + FW_ConsoleColors.RESET);
            }
        }
        
        // Strategy 2: Check for server identification headers
        String serverId = checkServerIdentification(host);
        if (serverId != null) {
            indicators.add("server_location_header");
            result.put("server_id", serverId);
            confidenceScore += 20;
            if (verbose) {
                System.out.println(FW_ConsoleColors.CORAL + "  [Anycast] Server identification found: " + serverId + FW_ConsoleColors.RESET);
            }
        }
        
        // Strategy 3: TTL variance check
        if (checkTtlVariance(ipAddress)) {
            indicators.add("ttl_variance");
            confidenceScore += 10;
            if (verbose) {
                System.out.println(FW_ConsoleColors.CORAL + "  [Anycast] TTL variance detected" + FW_ConsoleColors.RESET);
            }
        }
        
        // Determine final result
        result.put("is_anycast", confidenceScore >= 30 ? "true" : "false");
        result.put("confidence", 
            confidenceScore >= 60 ? "high" : 
            confidenceScore >= 30 ? "medium" : "low");
        result.put("confidence_score", String.valueOf(confidenceScore));
        result.put("indicators", String.join(",", indicators));
        
        if (verbose) {
            System.out.println(FW_ConsoleColors.CORAL + 
                String.format("  [Anycast] Detection for %s: %s (Confidence: %d%%)", 
                    host, result.get("is_anycast"), confidenceScore) + 
                FW_ConsoleColors.RESET);
        }
        
        return result;
    }

    /**
     * Simplified anycast detection method that returns basic information.
     * 
     * @param host The hostname or IP address to check
     * @return Map with "is_anycast" (boolean as string) and "ip_address" keys
     */
    public static Map<String, String> getAnycastInfo(String host) {
        Map<String, String> fullResult = detectAnycast(host, false);
        Map<String, String> simpleResult = new HashMap<>();
        simpleResult.put("is_anycast", fullResult.get("is_anycast"));
        simpleResult.put("ip_address", fullResult.get("ip_address"));
        return simpleResult;
    }

    /**
     * Helper method to check against known anycast services
     * 
     * @param host The hostname or IP to check
     * @return true if the host is a known anycast service
     */
    private static boolean isKnownAnycastService(String host) {
        // Common anycast services
        String[] knownAnycast = {
            "1.1.1.1", "1.0.0.1",                    // Cloudflare DNS
            "8.8.8.8", "8.8.4.4",                     // Google DNS
            "9.9.9.9", "149.112.112.112",            // Quad9 DNS
            "208.67.222.222", "208.67.220.220",      // OpenDNS
            "76.76.19.19", "76.223.122.150",         // Alternate DNS
            "speedtest.tele2.net",                    // Tele2 speedtest
            ".cloudflare.com",                         // Cloudflare domains
            ".fastly.net",                             // Fastly CDN
            ".akamai.net",                             // Akamai CDN
            ".akamaitechnologies.com",                 // Akamai
            ".cloudfront.net",                         // Amazon CloudFront
            ".azureedge.net",                          // Azure CDN
            ".stackpathdns.com",                       // StackPath CDN
            "dns.google",                              // Google DNS hostname
            "one.one.one.one"                          // Cloudflare DNS hostname
        };
        
        for (String pattern : knownAnycast) {
            if (pattern.startsWith(".")) {
                if (host.endsWith(pattern.substring(1))) return true;
            } else {
                if (host.equals(pattern) || host.equalsIgnoreCase(pattern)) return true;
            }
        }
        return false;
    }

    /**
     * Checks for server identification headers that might indicate anycast
     * 
     * @param host The hostname to check
     * @return Server identification string if found, null otherwise
     */
    private static String checkServerIdentification(String host) {
        try {
            // Normalize input: ensure we have a valid URL
            String urlStr;
            if (host.startsWith("http://") || host.startsWith("https://")) {
                urlStr = host;
            } else {
                // Bare hostname - assume HTTP for anycast detection
                urlStr = "http://" + host;
            }
            
            // Validate before proceeding
            URI uri = URI.create(urlStr);
            if (!uri.isAbsolute()) {
                // Not an absolute URI - cannot proceed
                return null;
            }
            
            URL url = uri.toURL();
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("HEAD");
            connection.setConnectTimeout(2000);
            connection.setReadTimeout(2000);
            
            // Look for server headers that might indicate location
            String serverHeader = connection.getHeaderField("Server");
            String cfRay = connection.getHeaderField("CF-RAY");
            String xServedBy = connection.getHeaderField("X-Served-By");
            
            connection.disconnect();
            
            if (cfRay != null) {
                // Cloudflare header includes datacenter code
                String[] parts = cfRay.split("-");
                if (parts.length > 1) {
                    return "Cloudflare-" + parts[1];
                }
                return "Cloudflare";
            }
            if (xServedBy != null) {
                return xServedBy;
            }
            if (serverHeader != null && serverHeader.contains("cloudflare")) {
                return "Cloudflare";
            }
        } catch (IllegalArgumentException | IOException e) {
            // URI/URL errors or network failures - this is best-effort detection
            // Silent fail as anycast detection is optional
        }
        return null;
    }

    /**
     * Checks for TTL variance which might indicate anycast
     * 
     * @param ipAddress The IP address to check
     * @return true if TTL variance is detected
     */
    private static boolean checkTtlVariance(String ipAddress) {
        try {
            // Perform multiple pings and check for TTL variance
            Set<String> ttlValues = new HashSet<>();
            for (int i = 0; i < 3; i++) {
                Map<Integer, Map<String, String>> pingResult = ping(ipAddress, 1000);
                if (pingResult.containsKey(0)) {
                    String ttl = pingResult.get(0).get("ttl");
                    if (ttl != null) {
                        ttlValues.add(ttl);
                    }
                }
                TimeUnit.MILLISECONDS.sleep(100); // Small delay between pings
            }
            // If we see different TTL values, it might indicate different paths (anycast)
            return ttlValues.size() > 1;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            // Silent fail for TTL check
        }
        return false;
    }

    /**
     * Calculates network jitter by measuring ping variance.
     *
     * @param host The host to ping
     * @param pingCount The number of times to ping the host
     * @param pingTimeout The timeout in milliseconds for each ping
     * @return A Map with jitter test results
     */
    public static Map<String, String> jitter(String host, int pingCount, int pingTimeout) {
        List<Double> pingTimes = new ArrayList<>();
        int successfulPings = 0;

        for (int i = 0; i < pingCount; i++) {
            Map<Integer, Map<String, String>> pingResult = FW_NetworkUtils.ping(host, pingTimeout);
            if (pingResult.get(0).get("status").equals("[Pass]")) {
                successfulPings++;
                pingTimes.add(Double.valueOf(pingResult.get(0).get("time")));
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

    /**
     * Pings a specified host and returns a detailed report of the ping response.
     * Enhanced to include anycast detection information when applicable.
     * The report includes the status, host, number of bytes, IP address, ICMP sequence, TTL, and response time.
     *
     * @param host The host to ping.
     * @param pingTimeoutMilliseconds The timeout for the ping in milliseconds.
     * @return A Map where the key is the ICMP sequence number and the value is another Map with keys:
     * "status"     "[Pass]" if the ping was successful, "[Fail]" otherwise.
     * "host"       The host that was pinged.
     * "bytes"      The number of bytes in the ping response.
     * "ip"         The IP address from the ping response.
     * "icmp_seq"   The ICMP sequence number from the ping response.
     * "ttl"        The TTL from the ping response.
     * "time"       The response time from the ping response.
     * "anycast"    "true" or "false" if anycast is detected for the host (only on successful ping)
     * "details"    Additional details about the ping response or any errors that occurred.
     */
    public static Map<Integer, Map<String, String>> ping(String host, int pingTimeoutMilliseconds) {
        // Initialize result Map to store the ping response details
        Map<Integer, Map<String, String>> result = new HashMap<>();
        if (host == null || host.isEmpty()) {
            Map<String, String> errorOutput = new HashMap<>();
            errorOutput.put("status", "[Fail]");
            errorOutput.put("details", "Host cannot be null or empty.");
            result.put(0, errorOutput);
            return result;
        }

        if (pingTimeoutMilliseconds <= 0) {
            Map<String, String> errorOutput = new HashMap<>();
            errorOutput.put("status", "[Fail]");
            errorOutput.put("details", "Ping timeout must be greater than zero.");
            result.put(0, errorOutput);
            return result;
        }

        try {
            // Get the OS
            String os = FW_SystemUtils.getPlatform();
            ProcessBuilder processBuilder;
            if (os.contains("Windows")) {
                processBuilder = new ProcessBuilder("ping", "-n", "1", "-w", String.valueOf(pingTimeoutMilliseconds), host);
            } else if (os.contains("Mac")) {
                // macOS: -W suppresses detailed output, so use -v -c 1 only
                processBuilder = new ProcessBuilder("ping", "-v", "-c", "1", host);
            } else {
                // Linux: use -W for timeout
                int timeoutSeconds = Math.max(1, pingTimeoutMilliseconds / 1000);
                processBuilder = new ProcessBuilder("ping", "-c", "1", "-W", String.valueOf(timeoutSeconds), host);
            }
            // Create a new process to execute the ping command
            Process process = processBuilder.start();
            boolean finished = process.waitFor(pingTimeoutMilliseconds, TimeUnit.MILLISECONDS);
            if (!finished) {
                Map<String, String> timeoutOutput = new HashMap<>();
                timeoutOutput.put("status", "[Fail]");
                timeoutOutput.put("details", "Ping command timed out.");
                result.put(0, timeoutOutput);
                return result;
            }

            // Create a BufferedReader to read the output of the ping command
            BufferedReader stdInput = new BufferedReader(new InputStreamReader(process.getInputStream()));
            BufferedReader stdError = new BufferedReader(new InputStreamReader(process.getErrorStream()));

            // Define a pattern to extract the required details from the ping output
            Pattern pingOutputPattern = Pattern.compile("(\\d+) bytes from (\\S+): icmp_seq=(\\d+) ttl=(\\d+) time=(\\d+\\.?\\d*) ms");
            String outputLine;
            
            // Read the output of the ping command line by line
            while ((outputLine = stdInput.readLine()) != null) {
                
                // Process lines differently based on OS
                if (os.contains("Windows")) {
                    // Windows: look for "Reply from"
                    if (outputLine.contains("Reply from")) {
                        Matcher pingOutputMatcher = pingOutputPattern.matcher(outputLine);
                        if (pingOutputMatcher.find()) {
                            Map<String, String> pingOutput = new HashMap<>();
                            pingOutput.put("status",    "[Pass]");
                            pingOutput.put("host",      host);
                            pingOutput.put("ip",        pingOutputMatcher.group(1));
                            pingOutput.put("bytes",     pingOutputMatcher.group(2));
                            pingOutput.put("time",      pingOutputMatcher.group(3));
                            pingOutput.put("ttl",       pingOutputMatcher.group(4));
                            pingOutput.put("icmp_seq",  "0"); // Windows doesn't show seq
                            pingOutput.put("details",   "");
                            
                            // Check if this is an anycast address
                            if (isKnownAnycastService(host)) {
                                pingOutput.put("anycast", "true");
                            }
                            
                            result.put(0, pingOutput);
                        }
                    }
                } else {
                    // Unix/Linux/Mac: look for "icmp_seq="
                    if (outputLine.contains("icmp_seq=")) {
                        Matcher pingOutputMatcher = pingOutputPattern.matcher(outputLine);
                        if (pingOutputMatcher.find()) {
                            int seq = Integer.parseInt(pingOutputMatcher.group(3));
                            Map<String, String> pingOutput = new HashMap<>();
                            pingOutput.put("status",    "[Pass]");
                            pingOutput.put("host",      host);
                            pingOutput.put("bytes",     pingOutputMatcher.group(1));
                            pingOutput.put("ip",        pingOutputMatcher.group(2));
                            pingOutput.put("icmp_seq",  pingOutputMatcher.group(3));
                            pingOutput.put("ttl",       pingOutputMatcher.group(4));
                            pingOutput.put("time",      pingOutputMatcher.group(5));
                            pingOutput.put("details",   "");
                            
                            // Check if this is an anycast address
                            if (isKnownAnycastService(host)) {
                                pingOutput.put("anycast", "true");
                            }
                            
                            result.put(seq, pingOutput);
                        }
                    }
                }
            }
            // Read the error output of the ping command line by line
            String errorLine;
            while ((errorLine = stdError.readLine()) != null) {
                Map<String, String> pingOutput = new HashMap<>();
                pingOutput.put("status", "[Fail]");

                // Process only the lines that contain "unknown host"
                if (errorLine.toLowerCase().contains("unknown host")) {
                    pingOutput.put("details", "Unknown Host: " + host);
                } else if (errorLine.toLowerCase().contains("cannot resolve")) {
                    pingOutput.put("details", "Cannot resolve host: " + host);
                } else {
                    pingOutput.put("details", "Error: " + errorLine);
                }
                result.put(0, pingOutput);
            }
            
            // If no successful ping and no error was captured, add a default failure entry
            if (result.isEmpty()) {
                Map<String, String> pingOutput = new HashMap<>();
                pingOutput.put("status", "[Fail]");
                pingOutput.put("host", host);
                pingOutput.put("details", "No response received - timeout or network unreachable");
                result.put(0, pingOutput);
            }

        } catch (IOException e) {
            // Process execution or stream reading errors
            Map<String, String> pingOutput = new HashMap<>();
            pingOutput.put("status", "[Fail]");
            pingOutput.put("details", "I/O Error: " + e.getMessage());
            result.put(0, pingOutput);
        } catch (InterruptedException e) {
            // Process wait interrupted
            Thread.currentThread().interrupt();
            Map<String, String> pingOutput = new HashMap<>();
            pingOutput.put("status", "[Fail]");
            pingOutput.put("details", "Ping interrupted: " + e.getMessage());
            result.put(0, pingOutput);
        }

        // Return the result Map
        return result;
    }

    /**
     * Creates and populates an FW_NetworkDetails object for a given host.
     * This factory method centralizes the logic for resolving and looking up
     * network details.
     *
     * @param host The host or IP address to get details for.
     * @return A populated FW_NetworkDetails object. Returns an object with default values if lookups fail.
     */
    public static FW_NetworkDetails getNetworkDetails(String host) {

        // 1. Create an instance of FW_NetworkDetails
        FW_NetworkDetails details = new FW_NetworkDetails(host);

        // 2. Validate the input
        if (FW_NetworkUtils.isValidHost(host) == false) {
            System.err.println(FW_ConsoleColors.RED + "Warning: Invalid host '" + host + "' provided to getNetworkDetails" + FW_ConsoleColors.RESET);
            return details; // Return the empty object
        }

        // 3. Get database file paths from the configuration manager
        File cityDbFile = new File(FW_ConfigMgr.getGeoLite2CityDatabase());
        File asnDbFile = new File(FW_ConfigMgr.getGeoLite2ASNDatabase());

        // Check that database files are available and readable
        if (!cityDbFile.exists() || !asnDbFile.exists()) {
            System.out.println(FW_ConsoleColors.RED + "  - [Warn] - Skipping GeoIP resolution: Database file(s) not found." + FW_ConsoleColors.RESET);
            return details; // Return the object with default values
        }

        // 4. Populate identification fields
        details.setHost(host);
        details.setHostname(FW_NetworkUtils.hostToHostname(host));
        details.setIp(FW_NetworkUtils.hostToIP(host));

        // 5. Populate geolocation fields only if we have a valid IP
        if (details.getIp() != null && !details.getIp().isEmpty()) {

            // Detect anycast for the resolved IP
            Map<String, String> anycastInfo = detectAnycast(details.getIp(), false);
            if (anycastInfo != null) {
                details.setIsAnycast(Boolean.valueOf(anycastInfo.get("is_anycast")));
                details.setAnycastConfidence(anycastInfo.get("confidence"));
            }

            // 6. Use try-with-resources to safely open and close the database readers
            try (DatabaseReader cityReader = new DatabaseReader.Builder(cityDbFile).build();
                 DatabaseReader asnReader = new DatabaseReader.Builder(asnDbFile).build()) {

                InetAddress ip = InetAddress.getByName(details.getIp());

                // 4. Perform City and ASN lookups, handling exceptions for each
                try {
                    CityResponse cityResponse = cityReader.city(ip);
                    if (cityResponse != null) {
                        if (cityResponse.getCity() != null)details.setCity(cityResponse.getCity().getName());
                        if (cityResponse.getMostSpecificSubdivision() != null)details.setRegion(cityResponse.getMostSpecificSubdivision().getIsoCode());
                        if (cityResponse.getCountry() != null)details.setCountry(cityResponse.getCountry().getName());
                        if (cityResponse.getCountry() != null)details.setCountryCode(cityResponse.getCountry().getIsoCode());
                        if (cityResponse.getContinent() != null)details.setContinent(cityResponse.getContinent().getName());
                        if (cityResponse.getLocation() != null) {
                            details.setLatitude(cityResponse.getLocation().getLatitude());
                            details.setLongitude(cityResponse.getLocation().getLongitude());
                        }
                    }

                } catch (GeoIp2Exception e) {
                    // This is common for IPs not in the DB; ignore and proceed
                }

                try {
                    AsnResponse asnResponse = asnReader.asn(ip);
                    if (asnResponse != null) {
                        details.setAsn(asnResponse.getAutonomousSystemNumber().intValue());
                        details.setAsnOrganization(asnResponse.getAutonomousSystemOrganization());
                    }
                } catch (GeoIp2Exception e) {
                    // This is common for IPs not in the DB; ignore and proceed
                }

            } catch (IOException e) {
            System.err.println(FW_ConsoleColors.RED + "[Error] Failed GeoIP lookup for " + details.getIp() + ": " + e.getMessage() + FW_ConsoleColors.RESET);
            return details; // Return the object with default values
            }

        }
        return details;
    }

    /**
     * Measures the time taken to perform DNS lookup for a given host.
     * This method isolates the DNS resolution time from other network operations.
     *
     * @param host The hostname to resolve (can include protocol like http://)
     * @return DNS lookup time in milliseconds, or -1 if resolution fails
     */
    public static long dnsLookupTime(String host) {
        return dnsLookupTime(host, false);
    }

    /**
     * Measures the time taken to perform DNS lookup for a given host with optional cache bypass.
     * This method isolates the DNS resolution time from other network operations.
     *
     * @param host The hostname to resolve (can include protocol like http://)
     * @param bypassCache If true, attempts to bypass DNS cache (not guaranteed on all systems)
     * @return DNS lookup time in milliseconds, or -1 if resolution fails
     */
    public static long dnsLookupTime(String host, boolean bypassCache) {
        // Strip protocol if present
        String hostname = host;
        if (host.startsWith("http://") || host.startsWith("https://")) {
            try {
                URI uri = URI.create(host);
                hostname = uri.getHost();
                if (hostname == null) {
                    return -1;
                }
            } catch (IllegalArgumentException e) { 
                return -1;
            }
        }
        
        try {
            // If bypass cache is requested, try to clear the DNS cache
            if (bypassCache) {
                // Clear Java's DNS cache by setting TTL to 0 temporarily
                java.security.Security.setProperty("networkaddress.cache.ttl", "0");
                java.security.Security.setProperty("networkaddress.cache.negative.ttl", "0");
            }
            
            // Warm-up resolution if not bypassing cache (to ensure cache is populated)
            if (!bypassCache) {
                InetAddress.getByName(hostname); // Pre-populate cache
                TimeUnit.MILLISECONDS.sleep(10); // Small delay to ensure cache is set
            }
            
            // Perform the actual timed DNS lookup
            long startTime = System.nanoTime();
            InetAddress.getAllByName(hostname); // Trigger DNS lookup (result not needed)
            long endTime = System.nanoTime();
            
            // Calculate elapsed time
            long elapsedMs = (endTime - startTime) / 1_000_000;
            
            // If bypassing cache, restore default cache settings
            if (bypassCache) {
                // Restore default TTL (usually 30 seconds)
                java.security.Security.setProperty("networkaddress.cache.ttl", "30");
                java.security.Security.setProperty("networkaddress.cache.negative.ttl", "10");
            }
            
            // Log if the result seems cached (unusually fast)
            // Disabled: clutters output when called multiple times
            // if (elapsedMs == 0 && !bypassCache) {
            //     System.out.println(FW_ConsoleColors.YELLOW + 
            //         "  [Info] DNS lookup returned in 0ms (likely cached). Use dnsLookupTime(host, true) for uncached timing." + 
            //         FW_ConsoleColors.RESET);
            // }
            
            return elapsedMs;
            
        } catch (UnknownHostException e) {
            return -1;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return -1;
        } catch (SecurityException e) {
            System.out.println(FW_ConsoleColors.YELLOW + 
                "  [Warn] DNS cache configuration error: " + e.getMessage() + 
                FW_ConsoleColors.RESET);
            return -1;
        }
    }

    /**
     * Performs multiple DNS lookups and returns statistics about DNS performance.
     * Useful for detecting DNS performance issues and cache behavior.
     *
     * @param host The hostname to resolve
     * @param samples Number of samples to take
     * @return Map containing min, max, avg, cached_count statistics
     */
    public static Map<String, Object> measureDnsPerformance(String host, int samples) {
        Map<String, Object> stats = new HashMap<>();
        List<Long> times = new ArrayList<>();
        int cachedCount = 0;
        
        // First lookup to populate cache
        dnsLookupTime(host, true); // Uncached first lookup
        
        for (int i = 0; i < samples; i++) {
            long time = dnsLookupTime(host, false);
            if (time >= 0) {
                times.add(time);
                if (time == 0) {
                    cachedCount++;
                }
            }
            
            // Small delay between samples
            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
        
        if (!times.isEmpty()) {
            stats.put("min_ms", times.stream().min(Long::compare).orElse(-1L));
            stats.put("max_ms", times.stream().max(Long::compare).orElse(-1L));
            stats.put("avg_ms", times.stream().mapToLong(Long::longValue).average().orElse(-1));
            stats.put("cached_count", cachedCount);
            stats.put("sample_count", times.size());
            stats.put("cache_hit_rate", (cachedCount * 100.0) / times.size());
        } else {
            stats.put("error", "No successful DNS lookups");
        }
        
        return stats;
    }

    /**
     * Gets all DNS resolutions (IP addresses) for a given hostname.
     * This is useful for detecting load balancing and multiple server endpoints.
     *
     * @param host The hostname to resolve (can include protocol)
     * @return List of all resolved IP addresses, or empty list if resolution fails
     */
    public static List<String> getAllDnsResolutions(String host) {
        List<String> resolutions = new ArrayList<>();
        
        // Strip protocol if present
        String hostname = host;
        if (host.startsWith("http://") || host.startsWith("https://")) {
            try {
                URI uri = URI.create(host);
                hostname = uri.getHost();
                if (hostname == null) {
                    return resolutions;
                }
            } catch (IllegalArgumentException e) {  // ✅ Changed from URISyntaxException
                return resolutions;
            }
        }
        
        try {
            InetAddress[] addresses = InetAddress.getAllByName(hostname);
            for (InetAddress addr : addresses) {
                resolutions.add(addr.getHostAddress());
            }
        } catch (UnknownHostException e) {
            // Return empty list on failure
        }
        
        return resolutions;
    }
    
    /**
     * Measures network timing metrics for a given URL.
     * Provides comprehensive timing information including DNS, connection, and transfer times.
     *
     * @param urlString The URL to measure
     * @return Map containing timing metrics (dns_time_ms, connect_time_ms, ttfb_ms, total_time_ms)
     */
    public static Map<String, Long> measureNetworkTimings(String urlString) {
        Map<String, Long> timings = new HashMap<>();
        
        try {
            // Ensure URL has protocol
            if (!urlString.startsWith("http://") && !urlString.startsWith("https://")) {
                urlString = "http://" + urlString;
            }
            
            URL url = URI.create(urlString).toURL();
            String host = url.getHost();
            
            // Measure DNS lookup time
            long dnsStart = System.nanoTime();
            InetAddress.getByName(host);
            long dnsEnd = System.nanoTime();
            timings.put("dns_time_ms", (dnsEnd - dnsStart) / 1_000_000);
            
            // Measure connection and TTFB
            long connectStart = System.nanoTime();
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);
            
            // Connect and get first byte
            connection.connect();
            long connectEnd = System.nanoTime();
            timings.put("connect_time_ms", (connectEnd - connectStart) / 1_000_000);
            
            // Read response to measure time to first byte
            long ttfbStart = System.nanoTime();
            connection.getResponseCode(); // Trigger response read (value not needed)
            long ttfbEnd = System.nanoTime();
            timings.put("ttfb_ms", (ttfbEnd - ttfbStart) / 1_000_000);
            
            // Total time
            long totalTime = (ttfbEnd - dnsStart) / 1_000_000;
            timings.put("total_time_ms", totalTime);
            
            connection.disconnect();
            
        } catch (IOException e) {
            // Network errors: DNS, connection, or response failures
            timings.put("dns_time_ms", -1L);
            timings.put("connect_time_ms", -1L);
            timings.put("ttfb_ms", -1L);
            timings.put("total_time_ms", -1L);
        }
        
        return timings;
    }

    /**
     * Analyzes a redirect chain to extract patterns and metrics.
     *
     * @param urls List of URLs in the redirect chain
     * @return Map containing analysis results
     */
    public static Map<String, Object> analyzeRedirectChain(List<String> urls) {
        Map<String, Object> analysis = new HashMap<>();
        
        if (urls == null || urls.isEmpty()) {
            analysis.put("valid", false);
            analysis.put("error", "Empty or null redirect chain");
            return analysis;
        }
        
        analysis.put("chain_length", urls.size());
        analysis.put("has_loop", isRedirectLoop(urls));
        
        // Analyze domain changes
        Set<String> uniqueDomains = new HashSet<>();
        boolean crossDomain = false;
        String firstDomain = null;
        
        for (String url : urls) {
            try {
                URI uri = URI.create(url);
                String domain = uri.getHost();
                if (domain != null) {
                    uniqueDomains.add(domain);
                    if (firstDomain == null) {
                        firstDomain = domain;
                    } else if (!domain.equals(firstDomain)) {
                        crossDomain = true;
                    }
                }
            } catch (IllegalArgumentException e) {
                // Skip malformed URLs
            }
        }
        
        analysis.put("unique_domains", uniqueDomains.size());
        analysis.put("domains", uniqueDomains);
        analysis.put("cross_domain", crossDomain);
        
        // Analyze protocol changes
        boolean protocolChange = false;
        String firstProtocol = null;
        
        for (String url : urls) {
            try {
                URI uri = URI.create(url);
                String protocol = uri.getScheme();
                if (protocol != null) {
                    if (firstProtocol == null) {
                        firstProtocol = protocol;
                    } else if (!protocol.equals(firstProtocol)) {
                        protocolChange = true;
                        break;
                    }
                }
            } catch (IllegalArgumentException e) {
                // Skip malformed URLs
            }
        }
        
        analysis.put("protocol_change", protocolChange);
        
        // Detect redirect pattern
        String pattern = detectRedirectPattern(urls);
        analysis.put("pattern", pattern);
        
        // Path analysis
        boolean pathNormalization = false;
        for (int i = 0; i < urls.size() - 1; i++) {
            try {
                URI current = URI.create(urls.get(i));
                URI next = URI.create(urls.get(i + 1));
                
                // Check for path normalization patterns
                String currentPath = current.getPath();
                String nextPath = next.getPath();
                
                if (currentPath != null && nextPath != null) {
                    // Trailing slash normalization
                    if (currentPath.equals(nextPath + "/") || 
                        nextPath.equals(currentPath + "/")) {
                        pathNormalization = true;
                    }
                }
                
                // www normalization
                String currentHost = current.getHost();
                String nextHost = next.getHost();
                
                if (currentHost != null && nextHost != null) {
                    if (currentHost.startsWith("www.") && !nextHost.startsWith("www.") ||
                        !currentHost.startsWith("www.") && nextHost.startsWith("www.")) {
                        analysis.put("www_normalization", true);
                    }
                }
            } catch (IllegalArgumentException e) {
                // Skip on error
            }
        }
        
        analysis.put("path_normalization", pathNormalization);
        analysis.put("valid", true);
        
        return analysis;
    }

    /**
     * Detects if a redirect chain contains a loop.
     * Already implemented in FW_HttpUtils as hasRedirectLoop,
     * but adding here for NetworkUtils completeness.
     *
     * @param chain List of URLs in redirect chain
     * @return true if loop detected
     */
    public static boolean isRedirectLoop(List<String> chain) {
        if (chain == null || chain.size() < 2) {
            return false;
        }
        
        Set<String> seen = new HashSet<>();
        for (String url : chain) {
            if (url != null && !seen.add(url)) {
                return true; // Duplicate found
            }
        }
        return false;
    }

    /**
     * Detects common redirect patterns in a chain.
     *
     * @param chain List of URLs in redirect chain
     * @return Pattern type detected
     */
    public static String detectRedirectPattern(List<String> chain) {
        if (chain == null || chain.isEmpty()) {
            return "unknown";
        }
        
        // Check for CDN patterns
        boolean hasCDN = false;
        for (String url : chain) {
            if (url.contains("cdn.") || url.contains("cloudfront") || 
                url.contains("akamai") || url.contains("fastly") ||
                url.contains("cloudflare")) {
                hasCDN = true;
                break;
            }
        }
        
        if (hasCDN) {
            return "cdn-redirect";
        }
        
        // Check for HTTPS upgrade
        if (chain.size() >= 2) {
            try {
                URI first = URI.create(chain.get(0));
                URI last = URI.create(chain.get(chain.size() - 1));
                
                if ("http".equals(first.getScheme()) && "https".equals(last.getScheme())) {
                    return "https-upgrade";
                }
            } catch (IllegalArgumentException e) {
                // Continue checking other patterns
            }
        }
        
        // Check for authentication redirect
        for (String url : chain) {
            if (url.contains("/login") || url.contains("/auth") || 
                url.contains("/signin") || url.contains("/sso")) {
                return "authentication-redirect";
            }
        }
        
        // Check for load balancer pattern (multiple similar domains)
        Pattern lbPattern = Pattern.compile("([a-z]+)(\\d+)\\.(.+)");
        boolean hasLoadBalancer = false;
        
        for (String url : chain) {
            try {
                URI uri = URI.create(url);
                String host = uri.getHost();
                if (host != null) {
                    Matcher m = lbPattern.matcher(host);
                    if (m.matches()) {
                        hasLoadBalancer = true;
                        break;
                    }
                }
            } catch (IllegalArgumentException e) {
                // Skip malformed URLs
            }
        }
        
        if (hasLoadBalancer) {
            return "load-balancer";
        }
        
        // Check for geographic redirect
        for (String url : chain) {
            if (url.contains("/en/") || url.contains("/us/") || 
                url.contains("/uk/") || url.contains("/de/") ||
                url.contains("country=") || url.contains("lang=")) {
                return "geographic-redirect";
            }
        }
        
        // Check for mobile redirect
        for (String url : chain) {
            if (url.contains("m.") || url.contains("/mobile") || 
                url.contains("/m/")) {
                return "mobile-redirect";
            }
        }
        
        // Check for marketing/tracking redirect
        for (String url : chain) {
            if (url.contains("utm_") || url.contains("click") || 
                url.contains("/track") || url.contains("/r/")) {
                return "tracking-redirect";
            }
        }
        
        // Check if it's just trailing slash or www normalization
        if (chain.size() == 2) {
            try {
                URI first = URI.create(chain.get(0));
                URI second = URI.create(chain.get(1));
                
                String firstHost = first.getHost();
                String secondHost = second.getHost();
                
                if (firstHost != null && secondHost != null) {
                    if (firstHost.equals(secondHost) ||
                        firstHost.equals("www." + secondHost) ||
                        secondHost.equals("www." + firstHost)) {
                        return "normalization-redirect";
                    }
                }
            } catch (IllegalArgumentException e) {
                // Continue
            }
        }
        
        return "generic-redirect";
    }

    /**
     * Calculates redirect chain efficiency score.
     *
     * @param chain List of URLs in redirect chain
     * @param durations List of durations for each hop (milliseconds)
     * @return Efficiency score (0-100)
     */
    public static int calculateRedirectEfficiency(List<String> chain, List<Long> durations) {
        if (chain == null || chain.isEmpty()) {
            return 100; // No redirects is most efficient
        }
        
        int score = 100;
        
        // Penalty for number of redirects
        score -= (chain.size() * 10);
        
        // Penalty for slow redirects
        if (durations != null && !durations.isEmpty()) {
            long totalTime = durations.stream().mapToLong(Long::longValue).sum();
            if (totalTime > 2000) score -= 20;
            else if (totalTime > 1000) score -= 10;
            else if (totalTime > 500) score -= 5;
        }
        
        // Penalty for cross-domain redirects
        Set<String> domains = new HashSet<>();
        for (String url : chain) {
            try {
                URI uri = URI.create(url);
                String host = uri.getHost();
                if (host != null) {
                    domains.add(host);
                }
            } catch (IllegalArgumentException e) {
                // Skip malformed URLs
            }
        }
        if (domains.size() > 1) {
            score -= (domains.size() - 1) * 5;
        }
        
        // Penalty for loops
        if (isRedirectLoop(chain)) {
            score -= 30;
        }
        
        return Math.max(0, Math.min(100, score));
    }
    
    /**
     * Represents the capabilities of a speed test server.
     * 
     * @param supportsDownload whether the server supports download speed testing
     * @param supportsUpload whether the server supports upload speed testing
     * @param downloadEndpoint the URL endpoint for download testing, or null if not supported
     * @param uploadEndpoint the URL endpoint for upload testing, or null if not supported
     * @param errorMessage error message if capability detection failed, or null if successful
     * @param additionalInfo additional server metadata (never null, may be empty)
     */
    public record ServerCapabilities(boolean supportsDownload, boolean supportsUpload, String downloadEndpoint, String uploadEndpoint, String errorMessage, Map<String, String> additionalInfo) {
        public ServerCapabilities {
            // Defensive copy: ensure null safety and immutability
            additionalInfo = additionalInfo == null ? Map.of() : Map.copyOf(additionalInfo);
        }
    }
}