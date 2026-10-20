package framework.network;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @file FW_TracerouteHop.java
 * @description Represents the details of an individual hop in a traceroute operation.
 * 
 * This file contains the FW_TracerouteHop class, which encapsulates the details of a single hop in a traceroute operation, 
 * including its hop number, IP address, hostname, round-trip times (RTT), packet loss, location, and error details.
 * 
 * The FW_TracerouteHop class offers functionalities to:
 * - Get and set the sequential hop number.
 * - Get and set the IP address of the hop.
 * - Get and set the resolved hostname of the hop.
 * - Add and retrieve round-trip times (RTT) for the hop.
 * - Get and set the packet loss percentage or status for the hop.
 * - Get and set the geographical location of the hop.
 * - Get and set error details or anomalies for the hop.
 * - Calculate the average round-trip time (RTT) for the hop.
 * - Generate a string representation of the hop details.
 * 
 * This class is designed to encapsulate the details of an individual hop in a traceroute operation and provide utility methods 
 * for analyzing and retrieving hop-specific data.
 */
public class FW_TracerouteHop {
    private int hopNumber;                      // Sequential hop number
    private Set<String> observedIpAddresses;    // Set of observed IP addresses for this hop
    private String hostname;                    // Resolved hostname of the hop 
    private List<FW_TracerouteProbe> probes;    // List of probes for this hop
    private String packetLoss;                  // Can be a percentage or a boolean-like string (e.g., "0%", "100%")
    private double averageRtt;                  // Average RTT for this hop
    private boolean unreachable;                // Indicates if the hop is unreachable
    private String location;                    // Geo data (e.g., "United States, New York")
    private String city;                        // e.g., "New York"
    private String countryCode;                 // e.g., "US", "GB" (ISO 3166-1 alpha-2)
    private String regionCode;                  // e.g., "CA", "NY" (ISO 3166-2)
    private Double latitude;                    // GPS Latitude
    private Double longitude;                   // GPS Longitude
    private Long asn;                           // ASN number
    private String asnOrganization;             // ASN organization name
    private String errorDetails;                // Notes on anomalies (e.g., "Timeout", "Filtered hop")
    
    /**
     * Constructs a new FW_TracerouteHop instance.
     * 
     * @param hopNumber The sequential hop number.
     */
    public FW_TracerouteHop(int hopNumber) {
        this.hopNumber = hopNumber;
        this.probes = new ArrayList<>();
        this.observedIpAddresses = new HashSet<>();
        this.packetLoss = "N/A";
        this.averageRtt = -1.0;
        this.unreachable = false;
        this.location = "Unknown";
        this.city = null;
        this.countryCode = null;
        this.regionCode = null;
        this.latitude = null;
        this.longitude = null;
        this.asn = 0L;
        this.asnOrganization = null;
        this.errorDetails = "";
        
    }

    // =================================================================================
    // ====================== Class - Getters and Setters - Begin ======================

    public int getHopNumber() {
        return hopNumber;
    }

    public void setHopNumber(int hopNumber) {
        this.hopNumber = hopNumber;
    }

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public List<FW_TracerouteProbe> getProbes() {
        return probes;
    }

    public void setProbes(List<FW_TracerouteProbe> probes) {
        this.probes = probes;
    }

    public Set<String> getObservedIpAddresses() {
        return observedIpAddresses;
    }

    public void addObservedIpAddress(String ip) {
        if (ip != null && !ip.isEmpty()) {
            this.observedIpAddresses.add(ip);
        }
    }

    public String getPacketLoss() {
        return packetLoss;
    }

    public void setPacketLoss(String packetLoss) {
        this.packetLoss = packetLoss;
    }

    public double getAverageRtt() {
        return averageRtt;
    }

    public void setAverageRtt(double averageRtt) {
        this.averageRtt = averageRtt;
    }

    public boolean isUnreachable() {
        return unreachable;
    }

    public void setUnreachable(boolean unreachable) {
        this.unreachable = unreachable;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getRegionCode() {
        return regionCode;
    }

    public void setRegionCode(String regionCode) {
        this.regionCode = regionCode;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Long getAsn() {
        return asn;
    }

    public void setAsn(Long asn) {
        this.asn = asn;
    }

    public String getAsnOrganization() {
        return asnOrganization;
    }

    public void setAsnOrganization(String asnOrganization) {
        this.asnOrganization = asnOrganization;
    }

    public String getErrorDetails() {
        return errorDetails;
    }

    public void setErrorDetails(String errorDetails) {
        this.errorDetails = errorDetails;
    }

    // ====================== Class - Getters and Setters - End ======================
    // ===============================================================================

    /**
     * Adds a probe to the list of probes for this hop.
     * 
     * @param probe The FW_TracerouteProbe object to be added.
     */
    public void addProbe(FW_TracerouteProbe probe) {
        this.probes.add(probe);
    }

    /**
     * Determines the average RTT from successful probes. Does NOT store it.
     * A successful probe is one that did not time out and had no error.
     *
     * @return The average RTT in milliseconds, or -1.0 if there are no successful probes.
     */
    public double determineAverageRtt() {

        // Filter out probes that timed out and calculate the average RTT
        if (probes == null || probes.isEmpty()) {
            return -1.0; // No probes
        }

        return probes.stream()
            // Filter for probes that were successful (no timeout AND no error)
            .filter(probe -> !probe.isTimedOut() && probe.getErrorDetails() == FW_TracerouteProbe.ProbeError.NONE)
            .mapToDouble(FW_TracerouteProbe::getRoundTripTime) // Use the correct getter
            .average() // Calculate average
            .orElse(-1.0); // Return -1.0 if no successful probes were found
    }

    /**
     * Determines if the hop is unreachable (all probes failed). Does NOT store it.
     * @return true if all probes failed, false otherwise.
     */
    public boolean determineReachability() {

        // Check if all probes are either timed out or have an error
        if (probes == null || probes.isEmpty()) { return false; } // No probes -> not determined unreachable
        return probes.stream()
                     .allMatch(probe -> probe.isTimedOut() || probe.getErrorDetails() != FW_TracerouteProbe.ProbeError.NONE);
    }

     /**
     * Determines the packet loss percentage string. Does NOT store it.
     * @return Packet loss string (e.g., "0%", "100%", "N/A").
     */
    public String determinePacketLoss() {
        if (probes == null || probes.isEmpty()) { return "N/A"; }
        long failedProbes = probes.stream()
                                 .filter(probe -> probe.isTimedOut() || probe.getErrorDetails() != FW_TracerouteProbe.ProbeError.NONE)
                                 .count();
        int totalProbes = probes.size();
        double lossPercentage = (totalProbes == 0) ? 0.0 : (double) failedProbes / totalProbes * 100.0;
        return String.format("%.0f%%", lossPercentage);
    }

    public String getPrimaryIpAddress() {
        if (observedIpAddresses == null || observedIpAddresses.isEmpty()) {
            return null;
        }
        // Return the first element encountered (iteration order isn't guaranteed for HashSet,
        // but good enough for a 'primary' representation if needed)
        return observedIpAddresses.iterator().next();
    }

    /**
     * Calculates the average RTT, reachability, and packet loss based on
     * the current probe data and updates the corresponding fields in this object.
     * This should be called after all probes for the hop have been added.
     */
    public void calculateAndUpdateMetrics() {
        this.averageRtt = determineAverageRtt();
        this.unreachable = determineReachability();
        this.packetLoss = determinePacketLoss();
    }

    /**
     * Returns a string representation of the FW_TracerouteHop object.
     * This method is overridden to provide a custom string representation of the object.
     * It includes the hop number, IP address, hostname, RTT values, packet loss, location, and error details.
     * 
     * @return A string representation of the FW_TracerouteHop object.
     */
    @Override
    public String toString() {
        // Now uses the getters for the stored fields
        String probesString = (probes == null) ? "N/A" : probes.stream()
                                    .map(FW_TracerouteProbe::toString)
                                    .collect(Collectors.joining(", "));
        String ipsString = (observedIpAddresses == null || observedIpAddresses.isEmpty()) ? "N/A" : String.join(" | ", observedIpAddresses);

        return "Hop " + hopNumber + ": IPs=[" + ipsString + "]" +
               ", Host=" + (hostname != null ? hostname : "N/A") +
               ", AvgRTT=" + String.format("%.3f", getAverageRtt()) + // Use getter
               ", Unreachable=" + isUnreachable() + // Use getter
               ", Loss=" + getPacketLoss() + // Use getter
               ", Probes=[" + probesString + "]" +
               ", Loc=" + location +
               (errorDetails != null && !errorDetails.isEmpty() ? ", Err=" + errorDetails : "");
    }
}