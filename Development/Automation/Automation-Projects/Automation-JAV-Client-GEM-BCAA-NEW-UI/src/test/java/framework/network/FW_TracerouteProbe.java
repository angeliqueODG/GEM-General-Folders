package framework.network;

/**
 * @file FW_TracerouteProbe.java
 * @description Represents the details of an individual probe in a traceroute operation.
 * 
 * This file contains the FW_TracerouteProbe class, which encapsulates the details of a single probe in a traceroute operation, 
 * including its probe number, round-trip time (RTT), timeout status, and error details.
 * 
 * The FW_TracerouteProbe class offers functionalities to:
 * - Get and set the sequential probe number.
 * - Get and set the round-trip time (RTT) for the probe.
 * - Get and set the timeout status of the probe.
 * - Get and set error details or anomalies for the probe.
 * - Generate a string representation of the probe details.
 * 
 * This class is designed to encapsulate the details of an individual probe in a traceroute operation and provide utility methods 
 * for analyzing and retrieving probe-specific data.
 */
public class FW_TracerouteProbe {
    private int probeNumber; // Sequential probe number
    private double roundTripTime; // Round-trip time in milliseconds
    private boolean timedOut; // Indicates if the probe timed out
    private ProbeError errorDetails; // Notes on anomalies (e.g., "Timeout", "Network unreachable")
    private String sourceIpAddress; // Source IP address of the probe (Because load balancing can cause different source IPs to be used)

    /**
     * Constructs a new FW_TracerouteProbe instance.
     * 
     * @param probeNumber The sequential probe number.
     * @param roundTripTime The round-trip time in milliseconds.
     * @param timedOut Indicates if the probe timed out.
     * @param errorDetails Notes on anomalies or errors for the probe.
     * @param sourceIpAddress The specific IP address that responded to this probe. <--- ADD THIS PARAM
     */
    public FW_TracerouteProbe(int probeNumber, double roundTripTime, boolean timedOut, ProbeError errorDetail, String sourceIpAddress) {

        if (probeNumber < 1) { // Changed check to < 1
            throw new IllegalArgumentException("Probe number must be positive (>= 1).");
}

        if (roundTripTime < 0) {
            throw new IllegalArgumentException("Round-trip time cannot be negative.");
        }
        
        this.probeNumber = probeNumber;
        this.roundTripTime = roundTripTime;
        this.timedOut = timedOut;
        this.errorDetails = (errorDetail != null) ? errorDetail : ProbeError.NONE;
        this.sourceIpAddress = sourceIpAddress;
    }

    // No-argument constructor with default values
    public FW_TracerouteProbe() {
        this.probeNumber = 0;
        this.roundTripTime = 0;
        this.timedOut = false;
        this.errorDetails = ProbeError.NONE;
        this.sourceIpAddress = null;
    }

    // =================================================================================
    // ====================== Class - Getters and Setters - Begin ======================

    public int getProbeNumber() {
        return probeNumber;
    }

    public void setProbeNumber(int probeNumber) {
        if (probeNumber < 1) { // Changed check to < 1
            throw new IllegalArgumentException("Probe number must be positive (>= 1).");
        }
        this.probeNumber = probeNumber;
    }

    public double getRoundTripTime() {
        return roundTripTime;
    }

    public void setRoundTripTime(double roundTripTime) {
        if (roundTripTime < 0) {
            throw new IllegalArgumentException("Round-trip time cannot be negative.");
        }
        this.roundTripTime = roundTripTime;
    }

    public boolean isTimedOut() {
        return timedOut;
    }

    public void setTimedOut(boolean timedOut) {
        this.timedOut = timedOut;
    }

    public ProbeError getErrorDetails() {
        return errorDetails;
    }

    public void setErrorDetails(ProbeError errorDetails) {
        this.errorDetails = errorDetails;
    }

    public String getSourceIpAddress() {
        return sourceIpAddress;
    }

    public void setSourceIpAddress(String sourceIpAddress) {
        this.sourceIpAddress = sourceIpAddress;
    }

    // ====================== Class - Getters and Setters - End ======================
    // ===============================================================================

    /**
     * Returns a string representation of the FW_TracerouteProbe object.
     * This method is overridden to provide a custom string representation of the object.
     * It includes the probe number, round-trip time, timeout status, and error details.
     * 
     * @return A string representation of the FW_TracerouteProbe object.
     */
    @Override
    public String toString() {
        // Maybe add source IP to toString for debugging?
        return "Probe " + probeNumber + ": RTT=" + (timedOut ? "Timeout" : roundTripTime + "ms") +
               ", Error=" + errorDetails + ", FromIP=" + (sourceIpAddress != null ? sourceIpAddress : "N/A"); // Added FromIP
    }

    // Enum for error details
    public enum ProbeError {
        NONE,                   // Successful probe
        TIMEOUT,                // Explicit timeout ('*')
        NETWORK_UNREACHABLE,    // Map !N (Network Unreachable)
        HOST_UNREACHABLE,       // Map !H (Host Unreachable) - Added
        PROTOCOL_UNREACHABLE,   // Map !P (Protocol Unreachable) - Added
        ADMIN_PROHIBITED,       // Map !X, !A (Admin Prohibited) - Added
        // You could add more specific ones if needed:
        // FRAGMENTATION_NEEDED, // Map !F
        // SOURCE_ROUTE_FAILED,  // Map !S
        TRANSIENT_ERROR,        // For temporary network issues? Maybe map !Q, !I, !T?
        DNS_FAILURE,            // Less likely from traceroute itself, but possible
        ICMP_BLOCKED,           // Could be inferred from consistent timeouts/errors
        UNKNOWN_ERROR           // Catch-all for other annotations or issues
    }

}