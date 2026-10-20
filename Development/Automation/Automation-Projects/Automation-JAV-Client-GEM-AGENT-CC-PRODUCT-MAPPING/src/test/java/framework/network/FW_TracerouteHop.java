package framework.network;

// ===============================================================
// @file: FW_TracerouteHop.java
// @filepath: src/test/java/framework/network/FW_TracerouteHop.java
// @version: 2.0.0
// @updated: 2025-01-10 12:45:00 PM CST
// @author: Greg Paskal
// @company: MissionWares
//
// @description:
// Represents the details of an individual hop in a traceroute operation.
// This class encapsulates hop-specific data including hop number, observed
// IP addresses, hostname, probe results, packet loss statistics, and average
// round-trip time. Integrates with FW_NetworkDetails to provide comprehensive
// geographic and network information for each hop. Supports multiple probes
// per hop and tracks unreachable states with error details. Provides backward
// compatibility through delegated getters for location data.
//
// @dependencies:
// - java.util (ArrayList, HashSet, List, Set, stream.Collectors)
// - framework.network.FW_NetworkDetails
// - framework.network.FW_TracerouteProbe
//
// @methods:
// - Constructor: Initializes hop with hop number
// - addObservedIpAddress(String): Adds IP to observed set
// - addProbe(FW_TracerouteProbe): Adds probe result
// - determineAverageRtt(): Calculates average RTT from probes
// - determineReachability(): Checks if hop is reachable
// - determinePacketLoss(): Calculates packet loss percentage
// - getPrimaryIpAddress(): Returns first observed IP
// - calculateAndUpdateMetrics(): Updates all metrics
// - toString(): Returns formatted hop details
// - Full set of getters/setters including delegated location getters
//
// @tags: traceroute-hop, network-probe, packet-loss, rtt-analysis, mAi™
//
// @changeLog:
// Date        Author          Version  Description
// ----------  --------------  -------  --------------------------
// 2025-04-28  G. Paskal       1.0.0    Initial creation
// 2025-08-20  G. Paskal       1.1.0    Refactored to use FW_NetworkDetails object
// 2025-01-10  G. Paskal       2.0.0    Added mAi™ header and enhanced documentation
// ===============================================================

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Represents the details of an individual hop in a traceroute operation.
 */
public class FW_TracerouteHop {
    private int hopNumber;                      // Sequential hop number
    private final Set<String> observedIpAddresses;
    private String hostname;
    private List<FW_TracerouteProbe> probes;
    private String packetLoss;
    private double averageRtt;
    private boolean unreachable;
    private FW_NetworkDetails networkDetails; // Consolidated network/geo details
    private String errorDetails;
    
    /**
     * Constructs a new FW_TracerouteHop instance.
     * * @param hopNumber The sequential hop number.
     */
    public FW_TracerouteHop(int hopNumber) {
        this.hopNumber = hopNumber;
        this.probes = new ArrayList<>();
        this.observedIpAddresses = new HashSet<>();
        this.packetLoss = "N/A";
        this.averageRtt = -1.0;
        this.unreachable = false;
        this.networkDetails = new FW_NetworkDetails(null); // Initialize with a default empty object
        this.errorDetails = "";
    }

    // =================================================================================
    // ====================== Class - Getters and Setters - Begin ======================

    public int getHopNumber() { return hopNumber; }
    public void setHopNumber(int hopNumber) { this.hopNumber = hopNumber; }
    public String getHostname() { return hostname; }
    public void setHostname(String hostname) { this.hostname = hostname; }
    public List<FW_TracerouteProbe> getProbes() { return probes; }
    public void setProbes(List<FW_TracerouteProbe> probes) { this.probes = probes; }
    public Set<String> getObservedIpAddresses() { return observedIpAddresses; }
    public String getPacketLoss() { return packetLoss; }
    public void setPacketLoss(String packetLoss) { this.packetLoss = packetLoss; }
    public double getAverageRtt() { return averageRtt; }
    public void setAverageRtt(double averageRtt) { this.averageRtt = averageRtt; }
    public boolean isUnreachable() { return unreachable; }
    public void setUnreachable(boolean unreachable) { this.unreachable = unreachable; }
    public String getErrorDetails() { return errorDetails; }
    public void setErrorDetails(String errorDetails) { this.errorDetails = errorDetails; }
    public FW_NetworkDetails getNetworkDetails() { return networkDetails; }
    public void setNetworkDetails(FW_NetworkDetails networkDetails) { this.networkDetails = networkDetails; }

    // Delegated Getters for backward compatibility
    public String getCity() { return networkDetails != null ? networkDetails.getCity() : null; }
    public String getCountryCode() { return networkDetails != null ? networkDetails.getCountryCode() : null; }
    public String getRegionCode() { return networkDetails != null ? networkDetails.getRegion() : null; }
    public Double getLatitude() { return networkDetails != null ? networkDetails.getLatitude() : null; }
    public Double getLongitude() { return networkDetails != null ? networkDetails.getLongitude() : null; }
    public Integer getAsn() { return networkDetails != null ? networkDetails.getAsn() : null; }
    public String getAsnOrganization() { return networkDetails != null ? networkDetails.getAsnOrganization() : null; }
    
    // ====================== Class - Getters and Setters - End ======================
    // ===============================================================================

    public void addObservedIpAddress(String ip) {
        if (ip != null && !ip.isEmpty()) {
            this.observedIpAddresses.add(ip);
        }
    }
    
    public void addProbe(FW_TracerouteProbe probe) {
        this.probes.add(probe);
    }

    public double determineAverageRtt() {
        if (probes == null || probes.isEmpty()) {
            return -1.0;
        }
        return probes.stream()
            .filter(probe -> !probe.isTimedOut() && probe.getErrorDetails() == FW_TracerouteProbe.ProbeError.NONE)
            .mapToDouble(FW_TracerouteProbe::getRoundTripTime)
            .average()
            .orElse(-1.0);
    }

    public boolean determineReachability() {
        if (probes == null || probes.isEmpty()) { return false; }
        return probes.stream()
                     .allMatch(probe -> probe.isTimedOut() || probe.getErrorDetails() != FW_TracerouteProbe.ProbeError.NONE);
    }

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
        return observedIpAddresses.iterator().next();
    }

    public void calculateAndUpdateMetrics() {
        this.averageRtt = determineAverageRtt();
        this.unreachable = determineReachability();
        this.packetLoss = determinePacketLoss();
    }

    @Override
    public String toString() {
        String probesString = (probes == null) ? "N/A" : probes.stream().map(FW_TracerouteProbe::toString).collect(Collectors.joining(", "));
        String ipsString = (observedIpAddresses == null || observedIpAddresses.isEmpty()) ? "N/A" : String.join(" | ", observedIpAddresses);
        return "Hop " + hopNumber + ": IPs=[" + ipsString + "]" +
               ", Host=" + (hostname != null ? hostname : "N/A") +
               ", AvgRTT=" + String.format("%.3f", getAverageRtt()) +
               ", Unreachable=" + isUnreachable() +
               ", Loss=" + getPacketLoss() +
               ", Probes=[" + probesString + "]" +
               ", Loc=" + (getCity() != null ? getCity() : "Unknown") +
               (errorDetails != null && !errorDetails.isEmpty() ? ", Err=" + errorDetails : "");
    }
}