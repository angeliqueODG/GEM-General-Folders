package framework.network;
/**
 * @file FW_Traceroute.java
 * @description Represents the details of a traceroute operation.
 * 
 * This file contains the FW_Traceroute class, which encapsulates the results of a traceroute operation, 
 * including summary details and individual hop information. It provides methods to calculate and retrieve 
 * traceroute statistics such as total hops, average latency, maximum latency, and unreachable hops.
 * 
 * The FW_Traceroute class offers functionalities to:
 * - Get and set the total number of hops in the traceroute.
 * - Get and set the average round-trip time across all hops.
 * - Get and set the hop with the highest latency.
 * - Get and set the count of unreachable hops.
 * - Add and retrieve details of individual hops in the traceroute.
 * - Calculate summary statistics based on the hop details.
 * 
 * This class is designed to encapsulate the results of a traceroute operation and provide utility methods 
 * for analyzing and retrieving traceroute data.
 */

import java.util.ArrayList;
import java.util.List; // Ensure List is imported

/**
 * Represents the details of a class.
 */
public class FW_Traceroute {
    private String host;
    private String ip;
    private double duration;
    private String status;
    private List<FW_TracerouteHop> hopDetails;
    private int hopsTotal;
    private int hopsUnreachable;
    private double hopsLatencyMin;
    private double hopsLatencyMax;
    private double hopsLatencyAverage;
    private double hopsLatencyStdDev;

    /**
     * Constructs a new FW_Traceroute instance.
     */
    public FW_Traceroute() {
        this.host = null;
        this.ip = null;
        this.duration = 0.0;
        this.status = "[Pending]";
        this.hopDetails = new ArrayList<>();
        this.hopsTotal = -1;
        this.hopsUnreachable = -1;
        this.hopsLatencyMin = -1.0;
        this.hopsLatencyMax = -1.0;
        this.hopsLatencyAverage = -1.0;
        this.hopsLatencyStdDev = -1.0;
    }

    /**
     * Returns a string representation of the FW_Traceroute object.
     * This method is overridden to provide a custom string representation of the object.
     * It includes the total hops, average latency, maximum latency hop, and unreachable hops.
     * 
     * @return A string representation of the FW_Traceroute object.
     */
    @Override
    public String toString() {
    return "Traceroute Summary for " + host + " (" + ip + "):\n" +
           "  Duration: " + String.format("%.3f", duration) + " seconds\n" +
           "  Result Overall: " + status + "\n" +
           "  Hops Total: " + hopsTotal + "\n" +
           "  Hops Unreachable: " + hopsUnreachable + "\n" +
           "  Hops Latency Minimum (ms): " + String.format("%.3f", hopsLatencyMin) + "\n" +
           "  Hops Latency Maximum (ms): " + String.format("%.3f", hopsLatencyMax) + "\n" +
           "  Hops Latency Average (ms): " + String.format("%.3f", hopsLatencyAverage) + "\n" +
           "  Hops Latency StdDev (ms): " + String.format("%.3f", hopsLatencyStdDev) + "\n";
    }
    
    // =================================================================================
    // ====================== Class - Getters and Setters - Begin ======================

    public String getHost() {return host;}
    public void setHost(String targetHost) {this.host = targetHost;}

    public String getIp() {return ip;}
    public void setIp(String targetIp) {this.ip = targetIp;}

    public double getDuration() {return duration;}
    public void setDuration(double duration) {this.duration = duration;}

    public String getStatus() {return status;}
    public void setStatus(String overallResult) {this.status = overallResult;}

    public List<FW_TracerouteHop> getHopDetails() {return hopDetails;}
    public void addHopDetail(FW_TracerouteHop hop) {
        if (this.hopDetails == null) {
             this.hopDetails = new ArrayList<>();
        }
        this.hopDetails.add(hop);
    }

    public int getHopsTotal() {return hopsTotal;}
    public void setHopsTotal(int totalHops) {this.hopsTotal = totalHops;}

    public int getHopsUnreachable() {return hopsUnreachable;}
    public void setHopsUnreachable(int unreachableHops) {this.hopsUnreachable = unreachableHops;}

    public double getHopsLatencyMin() {return hopsLatencyMin;}
    public void setHopsLatencyMin(double minLatencyHop) {this.hopsLatencyMin = minLatencyHop;}

    public double getHopsLatencyMax() {return hopsLatencyMax;}
    public void setHopsLatencyMax(double maxLatencyHop) {this.hopsLatencyMax = maxLatencyHop;}

    public double getHopsLatencyStdDev() {return hopsLatencyStdDev;}
    public void setHopsLatencyStdDev(double stdDev) {this.hopsLatencyStdDev = stdDev;}

    public double getHopsLatencyAverage() {return hopsLatencyAverage;}
    public void setHopsLatencyAverage(double averageLatency) {this.hopsLatencyAverage = averageLatency;}

    // ====================== Class - Getters and Setters - End ======================
    // ===============================================================================

    public boolean isValid() {
        return hopDetails != null && !hopDetails.isEmpty();
    }

    /**
     * Calculates summary statistics for the traceroute operation based on collected hop details.
     * Call this *after* the traceroute process is complete and hops have been added.
     */
    public void calculateSummary() {

        if (hopDetails == null || hopDetails.isEmpty()) {
            this.hopsTotal = 0;
            this.hopsUnreachable = 0;
            this.hopsLatencyAverage = -1.0;
            this.hopsLatencyMax = -1.0;
            this.hopsLatencyMin = -1.0;
            this.hopsLatencyStdDev = -1.0;
            return;
        }

        this.hopsTotal = hopDetails.size();
        int unreachableCount = 0;
        double sumLatency = 0.0;
        double maxLatency = 0.0;
        double minLatency = Double.MAX_VALUE;
        int validLatencyHopCount = 0;

        // First pass: Calculate Sum, Min, Max, Counts
        for (FW_TracerouteHop hop : hopDetails) {
            if (hop.isUnreachable()) { // Assuming isUnreachable covers cases with no valid RTT
                unreachableCount++;
            } else {
                // Consider only hops with valid average RTT for latency stats
                double avgRtt = hop.getAverageRtt();
                // Ensure getAverageRtt() returns a non-negative value for valid hops
                // or Double.NaN / negative if not calculated/valid. Adjust condition if needed.
                if (avgRtt >= 0 && !Double.isNaN(avgRtt)) {
                    validLatencyHopCount++;
                    sumLatency += avgRtt;
                    if (avgRtt > maxLatency) {
                        maxLatency = avgRtt;
                    }
                    if (avgRtt < minLatency) {
                        minLatency = avgRtt;
                    }
                } else {
                     // Optionally count hops that responded but had only timeouts/errors
                     // For now, we treat them like unreachable for latency stats
                     unreachableCount++; // Or handle differently if needed
                }
            }
        }

        // Assign calculated values
        this.hopsUnreachable = unreachableCount;
        this.hopsLatencyMax = (validLatencyHopCount > 0) ? maxLatency : -1.0;
        this.hopsLatencyMin = (validLatencyHopCount > 0) ? minLatency : -1.0;

        // Calculate Average Latency
        if (validLatencyHopCount > 0) {
            this.hopsLatencyAverage = sumLatency / validLatencyHopCount;
        } else {
            this.hopsLatencyAverage = -1.0;
        }

        // Second pass: Calculate Standard Deviation (needs the average)
        if (validLatencyHopCount > 1) { // StdDev requires at least 2 data points
            double sumSquaredDifferences = 0.0;
            for (FW_TracerouteHop hop : hopDetails) {
                // Use the same condition to include only valid hops
                double avgRtt = hop.getAverageRtt();
                if (!hop.isUnreachable() && avgRtt >= 0 && !Double.isNaN(avgRtt)) {
                    double difference = avgRtt - this.hopsLatencyAverage;
                    sumSquaredDifferences += difference * difference;
                }
            }
            // Use N-1 for sample standard deviation
            double variance = sumSquaredDifferences / (validLatencyHopCount - 1);
            this.hopsLatencyStdDev = Math.sqrt(variance);
        } else {
            // If 0 or 1 valid hops, standard deviation is 0 or undefined.
            // Setting to 0.0 is common, or use -1.0 to indicate not applicable.
            this.hopsLatencyStdDev = (validLatencyHopCount == 1) ? 0.0 : -1.0;
        }

        // Ensure you have assigned values to all relevant summary fields here
    }
}