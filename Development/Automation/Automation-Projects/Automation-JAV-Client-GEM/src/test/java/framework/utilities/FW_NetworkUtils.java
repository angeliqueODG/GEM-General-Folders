package framework.utilities;
/**
 * @file FW_NetworkUtils.java
 * @description This class contains utility methods for network operations.
 * 
 * This file contains the class FW_NetworkUtils, which provides methods for network-related operations.
 *
 * The FW_NetworkUtils class offers functionality to:
 * - Return a hostnname based on IP address
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.UnknownHostException;
import java.time.Duration;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.maxmind.geoip2.DatabaseReader;
import com.maxmind.geoip2.exception.GeoIp2Exception;
import com.maxmind.geoip2.model.AsnResponse;
import com.maxmind.geoip2.model.CityResponse;

import framework.network.FW_IpDetails;
import framework.network.FW_Traceroute;
import framework.network.FW_TracerouteHop;
import framework.network.FW_TracerouteProbe;
import framework.network.FW_TracerouteProbe.ProbeError;

/**
 * This class contains utility methods for network operations.
 */
public class FW_NetworkUtils {

    // Regex for individual probe results (RTT ms, *, !Annotation)
     // Groups: 1:RTT_Value, 2:Asterisk, 3:Annotation (!H, !N, etc.)
    private static final Pattern PROBE_RESULT_PATTERN = Pattern.compile(
        "(?:(\\d+\\.?\\d*)\\s*ms)|(\\*)|(![A-Z])"
    );

    /**
     * Main method for testing the utility methods.
     * 
     * @param args Command line arguments
     */
    public static void main(String[] args) {

        // Setup initial variables
        final String hostname = "dns.google";
        final String ipAddress = "8.8.4.4";

        String ipAddressResolved;
        String hostnameResolved;

        // ===================== Network - IP - Begin =====================
        System.out.println(FW_ConsoleColors.CORAL + "- Network - IP - Using IP..." + FW_ConsoleColors.RESET);

        ipAddressResolved = ip(hostname);
        
        if (ipAddressResolved == null) {
            // Handle the null case first
            System.out.println(FW_ConsoleColors.RED + "  - [Fail] - Hostname '" + hostname + "' returns a null IP address." + FW_ConsoleColors.RESET);
        } else if (ipAddressResolved.equals(ipAddress)) {
            // Handle the exact match case (safe to use .equals() now)
            System.out.println(FW_ConsoleColors.GREEN + "  - [Pass] - Hostname '" + hostname + "' resolves to IP address '" + ipAddress + "'." + FW_ConsoleColors.RESET);
        } else {
            // Handle the default case (resolved, but not the expected IP)
            System.out.println(FW_ConsoleColors.RED + "  - [Fail] - Hostname '" + hostname + "' resolves to IP address '" + ipAddressResolved + "' not '" + ipAddress + "'." + FW_ConsoleColors.RESET);
        }
        
        // ===================== Network - IP - End =====================

        // ===================== Network - IP Info - Begin =====================
        System.out.println(FW_ConsoleColors.CORAL + "- Network - IP Info - Using IP..." + FW_ConsoleColors.RESET);

        Map<Integer, Map<String, String>> ipInfo = ipInfo(ipAddress);

        Map<String, String> ipInfoDetails = ipInfo.get(0);
        String status       = ipInfoDetails.get("status");
        String details      = ipInfoDetails.get("details");
        String ip           = ipInfoDetails.get("ip");
        String hostnameInfo = ipInfoDetails.get("hostname");
        String city         = ipInfoDetails.get("city");
        String region       = ipInfoDetails.get("region");
        String country      = ipInfoDetails.get("country");
        String loc          = ipInfoDetails.get("loc");
        String org          = ipInfoDetails.get("org");
        String postal       = ipInfoDetails.get("postal");
        String timezone     = ipInfoDetails.get("timezone");
        String readme       = ipInfoDetails.get("readme");
        String detailsInfo  = ipInfoDetails.get("details");

        // Check if the status is [Fail]
        if (status != null && status.contains("[Fail]")) {
            System.out.println(FW_ConsoleColors.RED + "  - [Fail] - IP Info lookup failed: " + detailsInfo + FW_ConsoleColors.RESET);
        } else {
            System.out.println(FW_ConsoleColors.GREEN + "  - [Pass] - IP Info details for IP address '" + ipAddress + "':" + FW_ConsoleColors.RESET);
        }

        // Print the IP info details
        System.out.println(FW_ConsoleColors.GREEN + "    - Status: " + status + FW_ConsoleColors.RESET);
        System.out.println(FW_ConsoleColors.GREEN + "    - IP: " + ip + FW_ConsoleColors.RESET);
        System.out.println(FW_ConsoleColors.GREEN + "    - Hostname: " + hostnameInfo + FW_ConsoleColors.RESET);
        System.out.println(FW_ConsoleColors.GREEN + "    - City: " + city + FW_ConsoleColors.RESET);
        System.out.println(FW_ConsoleColors.GREEN + "    - Region: " + region + FW_ConsoleColors.RESET);
        System.out.println(FW_ConsoleColors.GREEN + "    - Country: " + country + FW_ConsoleColors.RESET);
        System.out.println(FW_ConsoleColors.GREEN + "    - Location: " + loc + FW_ConsoleColors.RESET);
        System.out.println(FW_ConsoleColors.GREEN + "    - Organization: " + org + FW_ConsoleColors.RESET);
        System.out.println(FW_ConsoleColors.GREEN + "    - Postal Code: " + postal + FW_ConsoleColors.RESET);
        System.out.println(FW_ConsoleColors.GREEN + "    - Timezone: " + timezone + FW_ConsoleColors.RESET);
        System.out.println(FW_ConsoleColors.GREEN + "    - Readme: " + readme + FW_ConsoleColors.RESET);
        System.out.println(FW_ConsoleColors.GREEN + "    - Details: " + details + FW_ConsoleColors.RESET);

        // ===================== Network - IP Info - End =====================

        // ===================== Network - Hostname - Begin =====================
        System.out.println(FW_ConsoleColors.CORAL + "- Network - Hostname - Using Hostname..." + FW_ConsoleColors.RESET);

        hostnameResolved = hostname(ipAddress);
        
        switch (hostnameResolved) {
            case hostname -> {
                System.out.println(FW_ConsoleColors.GREEN + "  - [Pass] - IP address '" + ipAddress + "' resolves to hostname '" + hostname + "'." + FW_ConsoleColors.RESET);
            }
            case null -> {
                System.out.println(FW_ConsoleColors.RED + "  - [Fail] - IP address '" + ipAddress + "' returns a null hostname." + FW_ConsoleColors.RESET);
            }
            default -> {
                System.out.println(FW_ConsoleColors.RED + "  - [Fail] - IP address '" + ipAddress + "' resolves to hostname '" + hostnameResolved + "' not '" + hostname + "'." + FW_ConsoleColors.RESET);
            }
        }
        // ===================== Network - Hostname - End =====================

        // ===================== Network - Ping - Begin =====================
        System.out.println(FW_ConsoleColors.CORAL + "- Network - Ping - Using Host and Timeout..." + FW_ConsoleColors.RESET);

        int pingTimeoutMilliseconds = 1000; // Timeout in milliseconds

        Map<Integer, Map<String, String>> pingResult = ping(hostname, pingTimeoutMilliseconds);

        Map<String, String> pingDetails = pingResult.get(0);
        String pingStatus       = pingDetails.get("status");
        String pingHost         = pingDetails.get("host");
        String pingBytes        = pingDetails.get("bytes");
        String pingIp           = pingDetails.get("ip");
        String pingIcmpSeq      = pingDetails.get("icmp_seq");
        String pingTtl          = pingDetails.get("ttl");
        String pingTime         = pingDetails.get("time");
        String pingDetailsInfo  = pingDetails.get("details");

        // Check if the status is [Fail]
        if (pingStatus != null && pingStatus.contains("[Fail]")) {
            System.out.println(FW_ConsoleColors.RED + "  - [Fail] - Ping failed: " + pingDetailsInfo + FW_ConsoleColors.RESET);
        } else {
            System.out.println(FW_ConsoleColors.GREEN + "  - [Pass] - Ping details for host '" + hostname + "':" + FW_ConsoleColors.RESET);
        }

        // Print the ping details
        System.out.println(FW_ConsoleColors.GREEN + "    - Status: " + pingStatus + FW_ConsoleColors.RESET);
        System.out.println(FW_ConsoleColors.GREEN + "    - Hostname: " + pingHost + FW_ConsoleColors.RESET);
        System.out.println(FW_ConsoleColors.GREEN + "    - Bytes: " + pingBytes + FW_ConsoleColors.RESET);
        System.out.println(FW_ConsoleColors.GREEN + "    - IP: " + pingIp + FW_ConsoleColors.RESET);
        System.out.println(FW_ConsoleColors.GREEN + "    - ICMP Sequence: " + pingIcmpSeq + FW_ConsoleColors.RESET);
        System.out.println(FW_ConsoleColors.GREEN + "    - TTL: " + pingTtl + FW_ConsoleColors.RESET);
        System.out.println(FW_ConsoleColors.GREEN + "    - Time: " + pingTime + FW_ConsoleColors.RESET);
        System.out.println(FW_ConsoleColors.GREEN + "    - Details: " + pingDetailsInfo + FW_ConsoleColors.RESET);

        // ===================== Network - Ping - End =====================

        // ===================== Network - Traceroute - Begin =====================
        System.out.println(FW_ConsoleColors.CORAL + "- Network - Traceroute - Using Host and Timeout..." + FW_ConsoleColors.RESET);

        // --- Traceroute Parameters ---
        String traceHostname = "8.8.4.4"; // Or dns.google
        int maxTracerouteDurationSeconds = 300;
        int maxNumberOfHops = 15; // Maximum number of hops to trace
        int numberOfProbes = 3; // Number of probes per hop (Note: ignored on Windows)
        int maxProbeDurationSeconds = 5; // Max time per probe (-w option)
        boolean resolveNames = true; // Set to true to attempt hostname resolution after trace
        boolean runVerbose = true; // Set to true for detailed testing, false for quiet run

        FW_Traceroute tracerouteResults = traceroute(traceHostname, maxTracerouteDurationSeconds, maxNumberOfHops, numberOfProbes, maxProbeDurationSeconds, resolveNames,runVerbose);

        // --- Detailed Inspection of Results ---
        System.out.println("\n------ Traceroute Results Inspection ------");
        System.out.println(tracerouteResults.toString()); // Use the refined toString()

        System.out.println("\n------ Hop Details ------");
        if (tracerouteResults.getHopDetails() == null || tracerouteResults.getHopDetails().isEmpty()) {
            System.out.println("No hop details were parsed or returned.");
        } else {
            for (FW_TracerouteHop hop : tracerouteResults.getHopDetails()) {

                System.out.println("\n--- Hop: " + hop.getHopNumber() + " ---");
                System.out.println("  Observed IPs: " + hop.getObservedIpAddresses().toString());
                System.out.println("  Hostname: " + (hop.getHostname() != null ? hop.getHostname() : "N/A"));
                System.out.println("  Avg RTT (ms): " + hop.getAverageRtt());
                System.out.println("  Is Unreachable: " + hop.isUnreachable());
                System.out.println("  Packet Loss: " + hop.getPacketLoss());
                System.out.println("  Geo City: " + (hop.getCity() != null ? hop.getCity() : "N/A"));
                System.out.println("  Geo Region: " + (hop.getRegionCode() != null ? hop.getRegionCode() : "N/A"));
                System.out.println("  Geo Country: " + (hop.getCountryCode() != null ? hop.getCountryCode() : "N/A"));
                System.out.println("  Geo Lat: " + (hop.getLatitude() != null ? String.format("%.4f", hop.getLatitude()) : "N/A") + " Lon: " + (hop.getLongitude() != null ? String.format("%.4f", hop.getLongitude()) : "N/A"));
                System.out.println("  Geo ASN: " + (hop.getAsn()));
                System.out.println("  Geo Org: " + (hop.getAsnOrganization() != null ? hop.getAsnOrganization() : "N/A"));

                System.out.println("  Probes:");
                if (hop.getProbes() == null || hop.getProbes().isEmpty()) {
                    System.out.println("    No probes recorded for this hop.");
                } else {
                    for (FW_TracerouteProbe probe : hop.getProbes()) {
                        // Print probe details using its toString or manually
                        System.out.println("    Probe " + probe.getProbeNumber() + ": RTT=" + probe.getRoundTripTime() + " ms, TimedOut=" + probe.isTimedOut() + ", Error=" + probe.getErrorDetails());
                    }
                }
            }
        }
        System.out.println("\n------ End Traceroute Results Inspection ------");
        
        System.out.println(FW_ConsoleColors.GREEN + "  - [Pass] - Traceroute details for host '" + hostname + "':" + FW_ConsoleColors.RESET);
        
        // ===================== Network - Traceroute - End =====================

        // ===================== GeoIP Basic Load Test - Begin =====================
        System.out.println(FW_ConsoleColors.CORAL + "\n- GeoIP Basic Load Test..." + FW_ConsoleColors.RESET);
        
        String cityDbPath = FW_ConfigMgr.getGeoLite2CityDatabase();
        String asnDbPath = FW_ConfigMgr.getGeoLite2ASNDatabase();
        System.out.println("  City DB Path from config: " + cityDbPath);
        System.out.println("  ASN DB Path from config: " + asnDbPath);

        File cityDbFile = new File(cityDbPath);
        File asnDbFile = new File(asnDbPath);

        // Use try-with-resources to ensure readers are closed
        try (DatabaseReader cityReader = new DatabaseReader.Builder(cityDbFile).build();
            DatabaseReader asnReader = new DatabaseReader.Builder(asnDbFile).build()) {

            System.out.println(FW_ConsoleColors.GREEN + "  Successfully loaded GeoIP DatabaseReaders." + FW_ConsoleColors.RESET);

            // Test lookup for a known public IP (e.g., one from your trace or 8.8.8.8)
            String testIpStr = "8.8.8.8"; // Or another public IP
            if (!isPrivateIpAddress(testIpStr)) { // Use the helper
                System.out.println("  Attempting lookup for: " + testIpStr);
                InetAddress testIpAddr = InetAddress.getByName(testIpStr);

                // City Lookup
                try {
                    CityResponse cityResponse = cityReader.city(testIpAddr);
                    if (cityResponse != null) {
                        String geoCity = cityResponse.getCity() != null ? cityResponse.getCity().getName() : "N/A";
                        String geoCountry = cityResponse.getCountry() != null ? cityResponse.getCountry().getIsoCode() : "N/A";
                        Double lat = cityResponse.getLocation() != null ? cityResponse.getLocation().getLatitude() : null;
                        Double lon = cityResponse.getLocation() != null ? cityResponse.getLocation().getLongitude() : null;
                        System.out.println(FW_ConsoleColors.GREEN + "    City Result: " + geoCity + ", " + geoCountry + " (Lat: " + lat + ", Lon: " + lon + ")%n" + FW_ConsoleColors.RESET);
                    } else {
                        System.out.println(FW_ConsoleColors.YELLOW + "    City lookup returned null response." + FW_ConsoleColors.RESET);
                    }
                } catch (GeoIp2Exception e) {
                    System.out.println(FW_ConsoleColors.YELLOW + "    City lookup failed: " + e.getMessage() + FW_ConsoleColors.RESET);
                }

                // ASN Lookup
                try {
                    AsnResponse asnResponse = asnReader.asn(testIpAddr);
                    if (asnResponse != null) {
                        Long asn = asnResponse.getAutonomousSystemNumber();
                        String geoOrg = asnResponse.getAutonomousSystemOrganization(); // Renamed
                        System.out.println(FW_ConsoleColors.GREEN + "    ASN Result: AS" + asn + " " + geoOrg + FW_ConsoleColors.RESET);
                    } else {
                        System.out.println(FW_ConsoleColors.YELLOW + "    ASN lookup returned null response." + FW_ConsoleColors.RESET);
                    }
                } catch (GeoIp2Exception e) {
                    System.out.println(FW_ConsoleColors.YELLOW + "    ASN lookup failed: " + e.getMessage() + FW_ConsoleColors.RESET);
                }
            } else {
                System.out.println(FW_ConsoleColors.YELLOW + "  Skipping lookup for private test IP: " + testIpStr + FW_ConsoleColors.RESET);
            }

        } catch (IOException e) {
            System.err.println(FW_ConsoleColors.RED + "[Error] Failed to load GeoIP DatabaseReader: " + e.getMessage() + FW_ConsoleColors.RESET);
            System.err.println(FW_ConsoleColors.RED + "  Check paths in testConfig.properties and ensure .mmdb files exist and are readable." + FW_ConsoleColors.RESET);
            // e.printStackTrace(); // Optionally print stack trace for detailed debug
        } catch (Exception e) {
            // Catch other potential exceptions during testing
            System.err.println(FW_ConsoleColors.RED + "[Error] Unexpected error during GeoIP test: " + e.getMessage() + FW_ConsoleColors.RESET);
            e.printStackTrace();
        }
        // ===================== GeoIP Basic Load Test - End =====================
    }

    /**
     * This method resolves a host to an IP address.
     *
     * @param host The host to resolve.
     *
     * @return The IP address of the host os returned or null if the host cannot be resolved and an error is encountered.
     */
    public static String ip(String host) {

        // Validate input parameters
        if (host == null || host.isEmpty()) {
            System.out.println(FW_ConsoleColors.YELLOW + "- [Warn] - Host cannot be null or empty." + FW_ConsoleColors.RESET);
            return null;
        }

        try {
            InetAddress address = InetAddress.getByName(host);
            String ipAddress = address.getHostAddress();
            return ipAddress;
        } catch (UnknownHostException e) {
            System.out.println(FW_ConsoleColors.YELLOW + "- [Warn] - Unknown host: '" + host + "'." + FW_ConsoleColors.RESET);
            return null;
        } catch (Exception e) {
            System.out.println(FW_ConsoleColors.YELLOW + "- [Warn] - Unexpected error: " + e.getMessage() + FW_ConsoleColors.RESET);
            return null;
        }
    }

    /**
     * This method gets the IP info details of a host.
     *
     * @param host The host or ip to get the IP info details.
     *
     * @return A Map where the key is the hop number and the value is another Map with keys:
     *          "status"    [Pass] if the info lookup was successful, [Fail] otherwise.
     *          "ip"        208.113.156.58
     *          "hostname"  iad1-cr-2.sd.dreamhost.com
     *          "city"      Ashburn
     *          "region"    Virginia
     *          "country"   US
     *          "loc"       39.0437,-77.4875 (latitude, longitude)
     *          "org"       AS26347 New Dream Network, LLC
     *          "postal"    20149
     *          "timezone"  America/New_York
     *          "readme"    https://ipinfo.io/missingauth
     *          "details"   Additional details about the IP info response or any errors that occurred.
     */
    public static Map<Integer, Map<String, String>> ipInfo(String host) {

        // Get the IP address of the host
        String ipAddress = FW_NetworkUtils.ip(host);
    
        // Initialize result Map to store the IP info details
        Map<Integer, Map<String, String>> result = new HashMap<>();
    
        try {
            // Create a new process to execute the curl command
            ProcessBuilder processBuilder = new ProcessBuilder("curl", "http://ipinfo.io/" + ipAddress);
            Process process = processBuilder.start();
    
            // Create a BufferedReader to read the output of the curl command
            BufferedReader stdInput = new BufferedReader(new InputStreamReader(process.getInputStream()));
    
            // Prepare the Map to return the IP info details
            Map<String, String> ipInfoOutput = new HashMap<>();

            // Set default values
            ipInfoOutput.put("status", "[Pass]");
            ipInfoOutput.put("details", "");

            // Regex pattern to match the key-value pairs in the JSON response
            Pattern ipInfoOutpuPattern = Pattern.compile("\"(.*?)\"\\s*:\\s*(\".*?\"|\\d+)");

            String outputLine;
            // Read the output of the curl command line by line
            while ((outputLine = stdInput.readLine()) != null) {

                // Match the line against the ipInfoOutpuPattern
                Matcher ipInfoOutoutMatcher = ipInfoOutpuPattern.matcher(outputLine);

                // If the line matches the ipInfoOutpuPattern, extract the required details
                if (ipInfoOutoutMatcher.find()) {

                    // Add the key-value pair to the response Map
                    String key = ipInfoOutoutMatcher.group(1);
                    String value = ipInfoOutoutMatcher.group(2);
                    ipInfoOutput.put(key, value);
                }
            }

            // Check if "message" contains "Please provide a valid IP address"
            if (ipInfoOutput.get("status") != null && ipInfoOutput.get("status").contains("404")) {

                // Set status to [Fail] and add details
                ipInfoOutput.put("status", "[Fail]");
                ipInfoOutput.put("details", String.format("404 Error - Please provide a valid host or IP address - '%s'.", host));
            }
    
            // Add the Map to the result Map with the sequence number as the key
            result.put(0, ipInfoOutput);
    
        // Read the error output of the curl command line by line
        } catch (IOException e) {
            Map<String, String> ipInfoOutput = new HashMap<>();
            ipInfoOutput.put("status", "[Fail]");
            ipInfoOutput.put("details", "Exception: " + e.getMessage());
            result.put(0, ipInfoOutput);
        }
    
        return result;
    }

    /**
     * Retrieves GeoIP and ASN details for a single public IP address using local MaxMind databases.
     *
     * @param ipAddress The public IP address to look up.
     * @return An FW_IpDetails object populated with location and network data, or null if the IP is private or a lookup fails.
     */
    public static FW_IpDetails getIpDetails(String ipAddress) {
        // 1. Validate the input IP address
        if (ipAddress == null || ipAddress.isEmpty() || isPrivateIpAddress(ipAddress)) {
            return null; // Don't perform lookups for null, empty, or private IPs
        }

        // 2. Get database file paths from the configuration manager
        File cityDbFile = new File(FW_ConfigMgr.getGeoLite2CityDatabase());
        File asnDbFile = new File(FW_ConfigMgr.getGeoLite2ASNDatabase());

        // Check that database files are available and readable
        if (!cityDbFile.exists() || !asnDbFile.exists()) {
            System.out.println(FW_ConsoleColors.RED + "  - [Warn] - Skipping GeoIP resolution: Database file(s) not found." + FW_ConsoleColors.RESET);
            return null;
        }

        FW_IpDetails details = new FW_IpDetails();

        // 3. Use try-with-resources to safely open and close the database readers
        try (DatabaseReader cityReader = new DatabaseReader.Builder(cityDbFile).build();
             DatabaseReader asnReader = new DatabaseReader.Builder(asnDbFile).build()) {

            InetAddress ip = InetAddress.getByName(ipAddress);

            // 4. Perform City and ASN lookups, handling exceptions for each
            try {
                CityResponse cityResponse = cityReader.city(ip);
                if (cityResponse != null) {
                    if (cityResponse.getCity() != null) details.setCity(cityResponse.getCity().getName());
                    if (cityResponse.getCountry() != null) details.setCountryCode(cityResponse.getCountry().getIsoCode());
                    if (cityResponse.getMostSpecificSubdivision() != null) details.setRegionCode(cityResponse.getMostSpecificSubdivision().getIsoCode());
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
            System.err.println(FW_ConsoleColors.RED + "[Error] Failed GeoIP lookup for " + ipAddress + ": " + e.getMessage() + FW_ConsoleColors.RESET);
            return null; // Return null on a significant error like file read or invalid IP
        }

        return details;
    }

    /**
    * This method resolves a host or IP to a hostname.
    *
    * @param host The host or IP to resolve.
    *
    * @return The hostname of the host or null if the host cannot be resolved or an error is encountered.
    */
   public static String hostname(String host) {

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
               URI uri = new URI(host);
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
       } catch (URISyntaxException e) {
           System.out.println(FW_ConsoleColors.YELLOW + "- [Warn] - Invalid URL format: '" + host + "'." + FW_ConsoleColors.RESET);
           return null;
       } catch (Exception e) {
           System.out.println(FW_ConsoleColors.YELLOW + "- [Warn] - Unexpected error: " + e.getMessage() + FW_ConsoleColors.RESET);
           return null;
       }
   }

    /**
     * Pings a specified host and returns a detailed report of the ping response.
     * The report includes the status, host, number of bytes, IP address, ICMP sequence, TTL, and response time.
     *
     * @param host The host to ping.
     * @param pingTimeoutMilliseconds The timeout for the ping in milliseconds.
     * 
     * @return A Map where the key is the ICMP sequence number and the value is another Map with keys:
     *         "status"     "[Pass]" if the ping was successful, "[Fail]" otherwise.
     *         "host"       The host that was pinged.
     *         "bytes"      The number of bytes in the ping response.
     *         "ip"         The IP address from the ping response.
     *         "icmp_seq"   The ICMP sequence number from the ping response.
     *         "ttl"        The TTL from the ping response.
     *         "time"       The response time from the ping response.
     *         "details"    Additional details about the ping response or any errors that occurred.
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

            // Determine the ping command based on the OS
            if (os.contains("Windows")) {
                processBuilder = new ProcessBuilder("ping", "-n", "1", "-w", String.valueOf(pingTimeoutMilliseconds), host);
            } else {
                processBuilder = new ProcessBuilder("ping", "-c", "1", "-W", String.valueOf(pingTimeoutMilliseconds), host);
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

                // Process only the lines that contain "icmp_seq="
                if (outputLine.contains("icmp_seq=")) {

                    // Match the line against the pattern
                    Matcher pingOutputMatcher = pingOutputPattern.matcher(outputLine);

                    // If the line matches the pattern, extract the required details
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
                        result.put(seq, pingOutput);
                    }
                }
            }

            // Read the error output of the ping command line by line
            while ((outputLine = stdError.readLine()) != null) {
                Map<String, String> pingOutput = new HashMap<>();
                pingOutput.put("status", "[Fail]");
    
                // Process only the lines that contain "unknown host"
                if (outputLine.toLowerCase().contains("unknown host")) {
                    pingOutput.put("details", "Unknown Host: " + host);
                } else if (outputLine.toLowerCase().contains("some other error")) {
                    pingOutput.put("details", "Some Other Error: " + outputLine);
                } else {
                    pingOutput.put("details", "Unrecognized Error: " + outputLine);
                }
                result.put(0, pingOutput);
            }
    
        } catch (Exception e) {
            Map<String, String> pingOutput = new HashMap<>();
            pingOutput.put("status",    "[Fail]");
            pingOutput.put("details",   "Exception: " + e.getMessage());
            result.put(0, pingOutput);
        }
    
        // Return the result Map
        return result;
    }

    /**
     * Executes a traceroute command to the specified host and returns a traceroute object.
     *
     * @param host The target host (hostname or IP address) for the traceroute.
     * @param maxTracerouteDurationSeconds The maximum total duration (in seconds) the traceroute process is allowed to run.
     * @param maxNumberOfHops The maximum number of hops to trace
     * @param numberOfProbes The number of probes to send per hop
     * @param maxProbeDurationSeconds The maximum duration (in seconds) to wait for each probe reply (-w option).
     * @param resolveHostnames If true, attempt to resolve IP addresses to hostnames *after* the trace completes.
     * @param verbose If true, print detailed execution and parsing steps to standard out. Defaults to false if null.
     *
     * @return An FW_Traceroute object containing the traceroute results, including overall status and detailed hop/probe data.
     *         "status"                 "[Pass]" if the traceroute was successful, "[Fail]" otherwise.
     *         "targetHost"             The target host that was traced. (e.g., "google.com")
     *         "targetIp"               The resolved IP address of the target host.
     *         "hopsTotal"              The total number of hops recorded in the traceroute.
     *         "hopsUnreachable"        The number of hops that were unreachable. (e.g. represented by "* * *")
     *         "hopsLatenancyAverage"   The average latency of the hops in milliseconds.
     *         "hopsLatenancyMax"       The maximum latency recorded for any hop in milliseconds.
     *         "hopDetails"             A list of FW_TracerouteHop objects, each representing an individual hop in the traceroute.
     */
    public static FW_Traceroute traceroute(String host, int maxTracerouteDurationSeconds, int maxNumberOfHops, int numberOfProbes, int maxProbeDurationSeconds, boolean resolveHostnames, Boolean verbose) {

        // Should we perform verbose terminal output?
        final boolean isVerbose = (verbose != null && verbose);

        // Initialize the traceroute result object
        FW_Traceroute tracerouteResult = new FW_Traceroute();
        tracerouteResult.setHost(host);

        // --- Input Validation ---
        if (host == null || host.isEmpty()) {
            tracerouteResult.setStatus("[Fail] - {0.0} - Target host cannot be null or empty.");
            return tracerouteResult;
        }

        if (maxTracerouteDurationSeconds <= 0) {
            tracerouteResult.setStatus("[Fail] - {0.0} - maxTracerouteDurationSeconds must be greater than zero.");
            return tracerouteResult;
        }

        // Get the host name and validate it
        host = FW_NetworkUtils.hostname(host);
        if (host.toUpperCase().contains("[FAIL]")) {
            tracerouteResult.setStatus("[Fail] - {0.0} - host '" + host + "' is invalid.");
            return tracerouteResult;
        }

        // Get the IP address of the host and validate it
        String targetIp = ip(host);
        if (targetIp != null) {
            tracerouteResult.setIp(targetIp);
        } else {
             tracerouteResult.setIp("");
        }

        // --- Variable Setup ---
        boolean isWindows = (FW_SystemUtils.getPlatform()).contains("windows");
        ProcessBuilder processBuilder;
        Process process = null; // For the ProcessBuilder
        BufferedReader stdInput = null;
        BufferedReader stdError = null;
        Pattern hopPattern; // Primary pattern for lines with IP/Host
        FW_TracerouteHop currentHopForContinuations = null;

        // Groups: 1:HopNum, 2:RestOfLine (e.g., "* * *")
        final Pattern TIMEOUT_LINE_PATTERN = Pattern.compile("^\\s*(\\d+)\\s+(.*)$");

        // Groups: 1:IP_Address, 2:ProbesString
        final Pattern CONTINUATION_LINE_PATTERN = Pattern.compile("^\\s*(\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3})\\s+(.*)$");
        
        try {
        
            // Perform Traceroute command for a Windows machine
            if (isWindows) {
                processBuilder = new ProcessBuilder("tracert", "-d", "-w", String.valueOf(maxProbeDurationSeconds * 1000), host);

                // Define the regex pattern for Windows traceroute output
                hopPattern = Pattern.compile(
                    "^\\s*(\\d+)\\s+(?:\\*\\s+){1,}(?:Request timed out\\.|\\*\\s+){0,}|" + // Handle lines with only timeouts first
                    "^\\s*(\\d+)\\s+((?:<?\\d+\\s+ms\\s+)|(?:\\*\\s+))+ (\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}).*$" // Handle lines with RTTs and IP
                );
            
                // Perform Traceroute command for a Unix machine
            } else {
                processBuilder = new ProcessBuilder("traceroute", "-n", "-m", String.valueOf(maxNumberOfHops), "-q", String.valueOf(numberOfProbes), "-w", String.valueOf(maxProbeDurationSeconds), host);
                
                // Define the regex pattern for Unix traceroute output
                hopPattern = Pattern.compile("^\\s*(\\d+)\\s+(?:(?:([a-zA-Z0-9.\\-]+)\\s+\\((\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3})\\))|(\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}))\\s+(.*)$");
            }

            // --- Execution ---
            if (isVerbose) { System.out.println(FW_ConsoleColors.BLUE + "  - Executing: " + String.join(" ", processBuilder.command()) + FW_ConsoleColors.RESET); }

            // Start the actual traceroute process and set up readers
            process = processBuilder.start();
            stdInput = new BufferedReader(new InputStreamReader(process.getInputStream()));
            stdError = new BufferedReader(new InputStreamReader(process.getErrorStream()));

            // Prepare variable for parsiging results
            Map<String, Object> resultProcessed = new HashMap<>();
            String outputLine;
            Instant startTime = Instant.now();

            // --- Main Parsing Loop - Begin ---
            // This loop will continue until continueTracerouteCapture is no longer true at which time nothing in this loop will be executed.
            while (((Boolean) (resultProcessed = checkTimeoutAliveReadLine(startTime, maxTracerouteDurationSeconds, stdInput, process)).get("continueTracerouteCapture")) == true) {

                // Read the output line
                tracerouteResult.setDuration((double) resultProcessed.get("elapsedTime"));
                boolean continueTracerouteCapture = (boolean) resultProcessed.get("continueTracerouteCapture");
                tracerouteResult.setStatus((String) resultProcessed.get("status"));
                outputLine = (String) resultProcessed.get("line");

                // If verbose, print the output line
                if (isVerbose) {System.out.println(FW_ConsoleColors.DARK_GREY + "    - Line: " + outputLine + FW_ConsoleColors.RESET);}

                // Clean up results to begin parsing
                String trimmedLine = outputLine.trim();

                // Skip processing empty or header lines
                if (trimmedLine.isEmpty() ||
                    trimmedLine.toLowerCase().contains("traceroute to") ||
                    trimmedLine.toLowerCase().contains("tracing route to")) {
                    continue; // Skip running the rest of the code below and return back to the top of the While loop.
                }

                // Look for the hop pattern in the output line
                Matcher hopMatcher = hopPattern.matcher(trimmedLine);
                Matcher timeoutMatcher = null;
                Matcher continuationMatcher = null;

                // Upon match of what we are looking for, we will parse the line
                if (hopMatcher.matches()) {

                    // --- Primary Parsing Logic ---
                    currentHopForContinuations = null;
                    try {
                        int hopNum = -1;
                        String ip = null;
                        String hostName = null;
                        String probesPart = null;
            
                        // Parsing Windows results
                        if (isWindows) {

                            if (hopMatcher.group(1) != null) {
                                hopNum = Integer.parseInt(hopMatcher.group(1));
                                ip = null;
                                probesPart = trimmedLine;

                                if(isVerbose){System.out.println(FW_ConsoleColors.YELLOW + "    - [Note] Win Timeout Line Detected (Primary Pattern)" + FW_ConsoleColors.RESET);}

                            } else if (hopMatcher.group(2) != null) {
                                hopNum = Integer.parseInt(hopMatcher.group(2));
                                ip = hopMatcher.group(4);
                                probesPart = hopMatcher.group(3);

                                if(isVerbose){System.out.println(FW_ConsoleColors.YELLOW + "     - [Note] Win Data Line Detected" + FW_ConsoleColors.RESET);}

                            } else {
                                continue; // Skip if no match
                            }

                        // Parsing Unix results
                        } else {
                            hopNum = Integer.parseInt(hopMatcher.group(1));
                            hostName = hopMatcher.group(2);
                            ip = (hostName != null) ? hopMatcher.group(3) : hopMatcher.group(4);
                            probesPart = hopMatcher.group(5);

                            if (ip == null) {
                                continue; // Skip if no IP found
                            }
                        }
            
                        // Create the hop object
                        FW_TracerouteHop hop = new FW_TracerouteHop(hopNum);
                        if (ip != null) {
                             hop.addObservedIpAddress(ip);
                        }

                        // Set the hostname if available
                        if (hostName != null && !hostName.isEmpty() && !hostName.equals(ip)) {
                             hop.setHostname(hostName);
                        }
            
                        // Parse probes for this hop, passing the IP found
                        parseAndAddProbes(hop, probesPart, trimmedLine, numberOfProbes, ip, isVerbose);
            
                        tracerouteResult.addHopDetail(hop); // Add the newly created hop to the traceroute result object

                        currentHopForContinuations = hop; // Set state for potential continuation lines

                    } catch (Exception e) {
                        System.err.println(FW_ConsoleColors.RED + "     - [Error] - Unexpected error parsing primary hop line: '" + trimmedLine + "'. Error: " + e.getMessage() + FW_ConsoleColors.RESET);
                        currentHopForContinuations = null; // Reset state on error
                    }
                    // --- End Primary Parsing Logic ---

                } else if (!isWindows && (timeoutMatcher = TIMEOUT_LINE_PATTERN.matcher(outputLine)).matches()) {

                    // --- Fallback Timeout Logic ---
                    currentHopForContinuations = null; // Reset state tracker on a new timeout hop line
                     try {

                         int hopNum = Integer.parseInt(timeoutMatcher.group(1));
                         String probesPart = timeoutMatcher.group(2);
            
                         FW_TracerouteHop hop = new FW_TracerouteHop(hopNum); // Create hop with no IP/Host
            
                         // Parse the "* * *" part, passing null for IP
                         parseAndAddProbes(hop, probesPart, trimmedLine, numberOfProbes, null, isVerbose);
            
                         tracerouteResult.addHopDetail(hop); // Add the newly created hop
                         currentHopForContinuations = hop; // Set state for potential continuation lines (less likely after pure timeout)
            
                     } catch (Exception e) {
                          System.err.println(FW_ConsoleColors.RED + "[Error] - Unexpected error parsing timeout line: '" + outputLine + "'. Error: " + e.getMessage() + FW_ConsoleColors.RESET);
                          currentHopForContinuations = null; // Reset state on error
                     }
                    // --- End Fallback Logic ---
            
                } else if (!isWindows && currentHopForContinuations != null && (continuationMatcher = CONTINUATION_LINE_PATTERN.matcher(outputLine)).matches()) {
                    
                    // --- Continuation Line Logic ---
                     try {
                         String ip = continuationMatcher.group(1); // IP on this continuation line
                         String probesPart = continuationMatcher.group(2); // Probes on this line
            
                         // Add this newly observed IP to the *previous* hop object
                         currentHopForContinuations.addObservedIpAddress(ip);
            
                         // Parse probes found on *this* line, associating them with THIS line's IP
                         // These probes are added to the *same* previous hop object
                         parseAndAddProbes(currentHopForContinuations, probesPart, trimmedLine, numberOfProbes, ip, isVerbose);
                        
                     } catch (Exception e) {
                        System.err.println(FW_ConsoleColors.RED + "[Error] - Unexpected error parsing continuation line: '" + outputLine + "'. Error: " + e.getMessage() + FW_ConsoleColors.RESET);
                    }            
                } else {
                    // --- Unrecognized Line ---
                    if (isVerbose) { System.out.println(FW_ConsoleColors.YELLOW + "    - [Warn] - Unrecognized line format skipped: '" + trimmedLine + "'" + FW_ConsoleColors.RESET); }
                }

                // Check if continueTracerouteCapture is "false" to exit the loop
                if (continueTracerouteCapture == false) {

                    // Set the traceroute result status
                    tracerouteResult.setStatus((String) resultProcessed.get("status"));

                    break; // Exit the loop
                }
            }
            // --- Main Parsing Loop - End ---

            // Read the output line
            tracerouteResult.setDuration((double) resultProcessed.get("elapsedTime"));
            tracerouteResult.setStatus((String) resultProcessed.get("status"));

        } catch (IOException | RuntimeException e) {
            if (e instanceof IOException) tracerouteResult.setStatus("[Fail] - IOException: " + e.getMessage());
            else tracerouteResult.setStatus("[Fail] - Unexpected Exception: " + e.getClass().getName() + " - " + e.getMessage());
        } finally {
            // Close resources
            if (stdInput != null) try { stdInput.close(); } catch (IOException e) {/* ignore */}
            if (process != null) process.destroy();
        }

        // --- Post-processing: Calculate Hop Metrics - RTT, Packet Loss, Unreachable FLag (Begin) ---
        if (tracerouteResult.getHopDetails() != null && !tracerouteResult.getHopDetails().isEmpty()) {
            if (isVerbose) { System.out.println(FW_ConsoleColors.BLUE + "  - Calculating hop metrics..." + FW_ConsoleColors.RESET); }
            for (FW_TracerouteHop hop : tracerouteResult.getHopDetails()) {
                hop.calculateAndUpdateMetrics();
            }
        }
        // --- Post-processing: Calculate Hop Metrics - RTT, Packet Loss, Unreachable FLag (End) ---

        // --- Post-processing: Resolve Hop Hostnames (Begin) ---
        if (resolveHostnames && tracerouteResult.getStatus() != null && !tracerouteResult.getStatus().startsWith("[Fail]")) {

            if (isVerbose) { System.out.println(FW_ConsoleColors.BLUE + "  - Resolving hostnames..." + FW_ConsoleColors.RESET); }
            Map<String, String> ipToHostnameCache = new HashMap<>();

            if (tracerouteResult.getHopDetails() != null) {
                for (FW_TracerouteHop hop : tracerouteResult.getHopDetails()) {

                    String ip = hop.getPrimaryIpAddress(); // Get primary IP

                    // Check if resolution needed (IP exists AND hostname not already set)
                    if (ip != null && !ip.isEmpty() && (hop.getHostname() == null || hop.getHostname().isEmpty())) {

                        // Use cache or perform lookup
                        String resolvedHostname = ipToHostnameCache.computeIfAbsent(ip, k -> {
                            return hostname(k); // Call the hostname utility method
                        });

                        // Determine the display result and update hop object only on success
                        String displayResult;
                        if (resolvedHostname != null && !resolvedHostname.equals(ip)) {
                            // Successful resolution to a distinct hostname
                            hop.setHostname(resolvedHostname); // Update the actual hop data
                            displayResult = resolvedHostname;  // Use the hostname for display
                        } else {
                            // Resolution failed, returned null, or returned the IP itself
                            displayResult = "(Unable to resolve)"; // Use the fallback text for display
                        }

                        // --- Print the new formatted line for EVERY attempt ---
                        if (isVerbose) {
                            String output = String.format("    - IP: %-15s -> %s", ip, displayResult);
                            System.out.println(FW_ConsoleColors.DARK_GREY + output + FW_ConsoleColors.RESET);
                        }
                        // --- Ensure any previous verbose prints in this block are removed ---

                    } // End if resolution needed
                } // End for loop over hops
            }
        }
        // --- Post-processing: Resolve Hop Hostnames (End) ---

        // --- Post-processing: Resolve Hop GeoIP Details - Country Code, Region Code, City, Latitude, Longitude (Begin) ---
        DatabaseReader cityDbReader = null;
        DatabaseReader asnDbReader = null;
        try {
            // --- Initialize DB Readers using FW_ConfigMgr ---
            String cityDbPath = FW_ConfigMgr.getGeoLite2CityDatabase();
            String asnDbPath = FW_ConfigMgr.getGeoLite2ASNDatabase();
            File cityDbFile = new File(cityDbPath);
            File asnDbFile = new File(asnDbPath);

            // Check if files exist before attempting to load
            if (cityDbFile.exists() && cityDbFile.canRead() && asnDbFile.exists() && asnDbFile.canRead()) {
                 cityDbReader = new DatabaseReader.Builder(cityDbFile).build();
                 asnDbReader = new DatabaseReader.Builder(asnDbFile).build();
                 if (isVerbose) { System.out.println(FW_ConsoleColors.BLUE + "  - Attempting GeoIP resolution..." + FW_ConsoleColors.RESET); }
            } else {
                // Print essential config warning regardless of verbosity
                System.out.println(FW_ConsoleColors.RED + "    - Skipping GeoIP resolution: GeoLite2 database file(s) not found or not readable at configured paths:" + FW_ConsoleColors.RESET);
                System.out.println(FW_ConsoleColors.YELLOW + "    - City Path: " + cityDbPath + " (Exists: " + cityDbFile.exists() + ", Readable: " + cityDbFile.canRead() + ")" + FW_ConsoleColors.RESET);
                System.out.println(FW_ConsoleColors.YELLOW + "    - ASN Path: " + asnDbPath + " (Exists: " + asnDbFile.exists() + ", Readable: " + asnDbFile.canRead() + ")" + FW_ConsoleColors.RESET);
            }

            // Perform lookups only if readers were successfully initialized
            if (cityDbReader != null && asnDbReader != null && tracerouteResult.getHopDetails() != null) {
                for (FW_TracerouteHop hop : tracerouteResult.getHopDetails()) {

                    // Use primary IP for lookup, skip if null or private
                    String ip = hop.getPrimaryIpAddress(); // Get first IP observed for the hop

                    if (ip != null && !ip.isEmpty() && !isPrivateIpAddress(ip)) {

                        InetAddress ipAddress = null;
                        try {
                             ipAddress = InetAddress.getByName(ip);

                            // --- 1. Perform Lookups and Store Results ---
                            String city = "N/A", region = "N/A", country = "N/A";
                            Double latitude = null, longitude = null;
                            Long asn = 0L;
                            String asnOrg = "N/A";

                            // City Lookup (catch exceptions locally)
                            try {
                                CityResponse cityResponse = cityDbReader.city(ipAddress);
                                if (cityResponse != null) {
                                    if (cityResponse.getCity() != null) city = cityResponse.getCity().getName();
                                    if (cityResponse.getCountry() != null) country = cityResponse.getCountry().getIsoCode();
                                    if (cityResponse.getMostSpecificSubdivision() != null) region = cityResponse.getMostSpecificSubdivision().getIsoCode();
                                    if (cityResponse.getLocation() != null) {
                                        latitude = cityResponse.getLocation().getLatitude();
                                        longitude = cityResponse.getLocation().getLongitude();
                                    }
                                }
                            } catch (GeoIp2Exception e) {
                                // City/Location data not found - variables retain default "N/A"/null
                            } catch (IOException e) {
                                // Log IO error during city lookup if needed, but retain defaults
                                System.out.println(FW_ConsoleColors.RED + "      - [Error] GeoIP City lookup IO error for " + ip + ": " + e.getMessage() + FW_ConsoleColors.RESET);
                            }

                            // ASN Lookup (catch exceptions locally)
                            try {
                                AsnResponse asnResponse = asnDbReader.asn(ipAddress);
                                if (asnResponse != null) {

                                    asn = asnResponse.getAutonomousSystemNumber();
                                    asnOrg = asnResponse.getAutonomousSystemOrganization();
                                    if (asnOrg == null) asnOrg = "N/A"; // Ensure ASN Org is not null for formatting
                                }
                            } catch (GeoIp2Exception e) {
                                // ASN data not found - variables retain default null/"N/A"
                            } catch (IOException e) {
                                // Log IO error during ASN lookup if needed, but retain defaults
                                System.out.println(FW_ConsoleColors.RED + "      - [Error] GeoIP ASN lookup IO error for " + ip + ": " + e.getMessage() + FW_ConsoleColors.RESET);
                            }

                            // --- Construct and Print Single Verbose Line ---
                            if (isVerbose) {
                                // Format Lat/Lon, handling nulls from the variables
                                String latStr = (latitude != null) ? String.format("%.4f", latitude) : "N/A";
                                String lonStr = (longitude != null) ? String.format("%.4f", longitude) : "N/A";
                                String asnStr = (asn != null) ? "AS" + asn : "N/A";

                                String displayCountry = (country != null) ? country : "N/A";
                                String displayRegion = (region != null) ? region : "N/A";
                                String displayCity = (city != null) ? city : "N/A";
                                String displayAsnOrg = (asnOrg != null) ? asnOrg : "N/A";

                                // Use the 'display' variables in the format string
                                String output = String.format("    - GeoIP: %-15s | Ctry: %-2s | Reg: %-3s | City: %-15s | Lat/Lon: %s,%s | ASN: %-7s | Org: %s",
                                                            ip, displayCountry, displayRegion, displayCity, latStr, lonStr, asnStr, displayAsnOrg);
                                System.out.println(FW_ConsoleColors.DARK_GREY + output + FW_ConsoleColors.RESET);
                            }

                            // --- Populate Hop Object ---
                            // Set the values on the actual hop object using the variables gathered above
                            hop.setCity("N/A".equals(city) ? null : city);
                            hop.setCountryCode("N/A".equals(country) ? null : country);
                            hop.setRegionCode("N/A".equals(region) ? null : region);
                            hop.setLatitude(latitude);
                            hop.setLongitude(longitude);
                            hop.setAsn(asn);
                            hop.setAsnOrganization("N/A".equals(asnOrg) ? null : asnOrg);

                        } catch (UnknownHostException e) {
                             System.out.println(FW_ConsoleColors.YELLOW + "    GeoIP: Could not create InetAddress for " + ip + FW_ConsoleColors.RESET);
                        }
                    } else if (isVerbose && ip != null && isPrivateIpAddress(ip)) {
                        System.out.println(FW_ConsoleColors.DARK_GREY + "    - GeoIP: " + ip + " (Private IP Address)" + FW_ConsoleColors.RESET);
                    }
                } // End for loop
            }

        } catch (IOException e) {
             System.out.println(FW_ConsoleColors.RED + "[Error] Could not initialize GeoIP DatabaseReader(s): " + e.getMessage() + FW_ConsoleColors.RESET);
             // e.printStackTrace(); // Consider logging stack trace
        } finally {
             // Ensure DB readers are closed
             if (cityDbReader != null) try { cityDbReader.close(); } catch (IOException e) {/* ignore */}
             if (asnDbReader != null) try { asnDbReader.close(); } catch (IOException e) {/* ignore */}
        }
        // --- Post-processing: Resolve Hop GeoIP Details - Country Code, Region Code, City, Latitude, Longitude (End) ---

        // --- Post-processing: Calculate Traceroute Summary Details - Hops Total, Hops Unreachable, Latency Avg, Latency Min, Latency Max, Larwncy Std Deviation (Begin) ---
        if (isVerbose) { System.out.println(FW_ConsoleColors.BLUE + "  - Calculate Summary..." + FW_ConsoleColors.RESET); }

        tracerouteResult.calculateSummary();

        // Print the traceroute tracerouteResult object to console (For Debugging)
        if (isVerbose) {
            // Header line - String concatenation is fine here
            System.out.println(FW_ConsoleColors.DARK_GREY + "    - Traceroute Result: Summary for " + tracerouteResult.getHost() + " (" + tracerouteResult.getIp() + ")" + FW_ConsoleColors.RESET);

            // Use String.format for the data lines
            System.out.println(FW_ConsoleColors.DARK_GREY + String.format("    - Duration: %.3f", tracerouteResult.getDuration()) + FW_ConsoleColors.RESET); 
            System.out.println(FW_ConsoleColors.DARK_GREY + String.format("    - Hops Total: %d", tracerouteResult.getHopsTotal()) + FW_ConsoleColors.RESET); 
            System.out.println(FW_ConsoleColors.DARK_GREY + String.format("    - Hops Unreachable: %d", tracerouteResult.getHopsUnreachable()) + FW_ConsoleColors.RESET);
            System.out.println(FW_ConsoleColors.DARK_GREY + String.format("    - Hops Latency Minimum: %.3f", tracerouteResult.getHopsLatencyMin()) + FW_ConsoleColors.RESET);
            System.out.println(FW_ConsoleColors.DARK_GREY + String.format("    - Hops Latency Maximum: %.3f", tracerouteResult.getHopsLatencyMax()) + FW_ConsoleColors.RESET);
            System.out.println(FW_ConsoleColors.DARK_GREY + String.format("    - Hops Latency Average: %.3f", tracerouteResult.getHopsLatencyAverage()) + FW_ConsoleColors.RESET);
            System.out.println(FW_ConsoleColors.DARK_GREY + String.format("    - Hops Latency Standard Deviation: %.3f", tracerouteResult.getHopsLatencyStdDev()) + FW_ConsoleColors.RESET);
            System.out.println(FW_ConsoleColors.DARK_GREY + String.format("    - Result: %s", tracerouteResult.getStatus()) + FW_ConsoleColors.RESET);
        }
        // --- Post-processing: Calculate Traceroute Summary Details - Hops Total, Hops Unreachable, Latency Avg, Latency Min, Latency Max, Larwncy Std Deviation (End) ---

        // Return the traceroute result
        return tracerouteResult;
    }

    /**
     * Checks if timeout has been reached, if the process is alive, and reads a line from the process's standard output.
     * Includes verbose logging if enabled.
     *
     * @param startTime The start time.
     * @param timeoutDurationSeconds The timeout duration in seconds.
     * @param stdInput The BufferedReader for the process's standard output.
     * @param process The process being monitored.
     * 
     * @return The line read from the process, or null if the process is not alive or if the end of the stream is reached.
     *        A Map containing the analysis results:
     *        - "elapsedTime": The elapsed time since startTime
     *        - "continueTracerouteCapture": true if the process is alive and a line was read, false otherwise.
     *        - "status": [Pass] or [Fail] status message incluing additional details.
     *        - "line": The line read from the process's standard output or null if the end of the stream is reached.
     * 
     * @throws IOException If an I/O error occurs during readLine().
     */
    private static Map<String, Object> checkTimeoutAliveReadLine(Instant startTime, int timeoutDurationSeconds, BufferedReader stdInput, Process process) throws IOException {

        // Create a map to store the analysis results
        Map<String, Object> analysisResults = new HashMap<>();

        // Calculate elapsed time since the start time
        double elapsedTime = Duration.between(startTime, Instant.now()).toMillis() / 1000.0;

        // Perform Timeout analysis - Begin
        if (elapsedTime > timeoutDurationSeconds) {

            // If the elapsed time exceeds the timeout duration, return a fail result
            analysisResults.put("elapsedTime", elapsedTime);
            analysisResults.put("continueTracerouteCapture", false);
            analysisResults.put("status", "[Fail] - {" + elapsedTime + "} - Traceroute timeout exceeded: " + timeoutDurationSeconds + " seconds.");
            analysisResults.put("line", null);
            return analysisResults;
        }
        // Perform Timeout analysis - End

        // Capture the process state to determine if it is still alive
        boolean isProcessAlive = process.isAlive();

        // Perform Process analysis - Begin
        if (isProcessAlive == false) {
            analysisResults.put("elapsedTime", elapsedTime);
            analysisResults.put("continueTracerouteCapture", false);
            analysisResults.put("status", "[Pass] - {" + elapsedTime + "} - Traceroute process has complelted.");
            analysisResults.put("line", null);
            return analysisResults;
        }
        // Perform Process analysis - End

        // Perform ReadLine analysis - Begin
        String line = stdInput.readLine();

        // Update the elapsed time to account for delay in readline operation
        elapsedTime = Duration.between(startTime, Instant.now()).toMillis() / 1000.0;

        // Ensure readLine() is not null
        if (line == null) {
            // If the line is null, return a fail result
            analysisResults.put("elapsedTime", elapsedTime);
            analysisResults.put("continueTracerouteCapture", false);
            analysisResults.put("status", "[Note] - {" + elapsedTime + "} - Traceroute end of stream reached.");
            analysisResults.put("line", null);
            return analysisResults;
        } else {
            // If the line is not null, return a pass result
            analysisResults.put("elapsedTime", elapsedTime);
            analysisResults.put("continueTracerouteCapture", true);
            analysisResults.put("status", "[Pass] - {" + elapsedTime + "} - Traceroute output line read successfully.");
            analysisResults.put("line", line);
            return analysisResults;
        }
    }

    /**
     * Helper method to parse the probe results string and add FW_TracerouteProbe objects to the current hop.
     * @param currentHop The hop to add probes to.
     * @param probesPart The string segment containing probe results (e.g., "1.234 ms * 2.345 ms !H").
     * @param originalLine The full original output line for context in error messages.
     * @param expectedProbes The number of probes expected (e.g., from -q parameter).
     * @param isVerbose If true, print detailed execution and parsing steps to standard out.
     */
    private static void parseAndAddProbes(FW_TracerouteHop currentHop, String probesPart, String originalLine, int expectedProbes, String sourceIp, boolean isVerbose) {
        if (currentHop == null) return; // Safety check
        if (probesPart == null || probesPart.trim().isEmpty()) {
            // Handle cases where no probe part was found (e.g., potentially windows timeout line where IP wasn't parsed)
            // We might need to fill based on expected number of probes if context allows
            // Example: Fill with timeouts if appropriate for the context (e.g., known timeout line)
             if (probesPart == null) { // If probesPart itself is null, stronger indicator maybe
                 for (int i = 1; i <= expectedProbes; i++) {
                    currentHop.addProbe(new FW_TracerouteProbe(i, 0, true, ProbeError.TIMEOUT, null)); // <-- ADDED null
                }
             }
            return;
        }

        Matcher probeMatcher = PROBE_RESULT_PATTERN.matcher(probesPart.trim());
        int probeIndex = (currentHop.getProbes() == null ? 0 : currentHop.getProbes().size()) + 1;
        while (probeMatcher.find()) {
            double rtt = 0.0; // Default RTT for timeout/error (since validation requires >= 0)
            boolean timedOut = false;
            ProbeError error = ProbeError.NONE;

            if (probeMatcher.group(1) != null) { // Group 1: RTT value
                try {
                    rtt = Double.parseDouble(probeMatcher.group(1));
                    timedOut = false;
                    error = ProbeError.NONE;
                } catch (NumberFormatException nfe) {
                    System.err.println(FW_ConsoleColors.RED+ "[Error] - Could not parse RTT value: " + probeMatcher.group(1) + " in line: " + originalLine + FW_ConsoleColors.RESET);
                    timedOut = true; error = ProbeError.UNKNOWN_ERROR; rtt = 0.0;
                }
            } else if (probeMatcher.group(2) != null) { // Group 2: Asterisk (*)
                timedOut = true;
                error = ProbeError.TIMEOUT; // <<< MAKE SURE THIS LINE IS HERE AND SAVED
                rtt = 0.0;

            } else if (probeMatcher.group(3) != null) { // Group 3: Annotation (!H, !N, etc.)
                timedOut = true; // Treat annotations as failure/timeout
                rtt = 0.0;
                String annotation = probeMatcher.group(3);
                switch (annotation) { // Use the ProbeError enum from FW_TracerouteProbe
                    case "!H": error = ProbeError.HOST_UNREACHABLE; break;
                    case "!N": error = ProbeError.NETWORK_UNREACHABLE; break;
                    case "!P": error = ProbeError.PROTOCOL_UNREACHABLE; break;
                    case "!X": case "!A": error = ProbeError.ADMIN_PROHIBITED; break;
                    // Add more cases for !F, !S, etc. if needed
                    default: error = ProbeError.UNKNOWN_ERROR; break;
                }
            } else {
                 System.out.println(FW_ConsoleColors.YELLOW + "[Warn] - Probe regex matched but no known group captured in: " + probesPart + FW_ConsoleColors.RESET);
                 timedOut = true; error = ProbeError.UNKNOWN_ERROR; rtt = 0.0;
            }

            // Create and add the probe
            FW_TracerouteProbe probe = new FW_TracerouteProbe(probeIndex++, rtt, timedOut, error, sourceIp);
            currentHop.addProbe(probe);

        } // End while probeMatcher.find()

         // Optional: Check if the number of probes found matches expectedProbes?
         if (probeIndex -1 != expectedProbes) {
         }

    } // End parseAndAddProbes helper method

    /**
     * Checks if a given IP address string falls within known private/local network ranges.
     * Based on InetAddress methods: isSiteLocalAddress(), isLoopbackAddress(), isLinkLocalAddress().
     * @param ipAddress The IP address string to check.
     * @return true if the IP is determined to be private or local, false otherwise or if input is invalid.
     */
    private static boolean isPrivateIpAddress(String ipAddress) {
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

}