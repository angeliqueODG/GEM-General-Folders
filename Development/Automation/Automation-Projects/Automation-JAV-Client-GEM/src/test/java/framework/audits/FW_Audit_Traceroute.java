package framework.audits;
/**
 * @file FW_Audit_Traceroute.java
 * @description Performs an audit of the network hops to a specified host.
 */

 // Framework imports
import framework.java.FW_Class;
import framework.junit.FW_CustomAssertJU;
import framework.junit.FW_TestStep;
import framework.junit.FW_TestStep.TestStepType;
import framework.network.FW_Traceroute;
import framework.network.FW_TracerouteHop;
import framework.utilities.FW_ConsoleColors;
import framework.utilities.FW_NetworkUtils;
import framework.utilities.FW_TestStepUtils;

/**
 * This class performs an audit of the hops to a specified host using traceroute.
 */
public class FW_Audit_Traceroute {

    public static void main(String[] args) {
        // Create an instance of FW_Audit_Traceroute
        FW_Audit_Traceroute auditTraceroute = new FW_Audit_Traceroute();
    
        // Define test parameters
        String host = "dns.google"; // Replace with the target host
        int maxTracerouteDurationSeconds = 120; // Maximum duration for the traceroute
        int maxNumberOfHops = 30; // Maximum number of hops to trace
        Boolean verbose = true; // Enable verbose logging for debugging
    
        // Run the traceroute audit
        Object result = auditTraceroute.runAuditTraceroute(host, maxTracerouteDurationSeconds, maxNumberOfHops, verbose);
    
        // Print the result
        System.out.println(FW_ConsoleColors.PINK + result + FW_ConsoleColors.RESET);
    }

    /**
     * This method performs an auditof the network hops to a specified host.
     *
     * @param host The target host (hostname or IP address) for the traceroute.
     * @param maxTracerouteDurationSeconds The maximum total duration (in seconds) the traceroute process is allowed to run.
     * @param maxNumberOfHops The maximum number of hops to trace.
     * @param verbose If true, print detailed execution and parsing steps to standard out. Defaults to false if null.
     *
     * @return Consolidated audit result details.
     */
    public Object runAuditTraceroute (String host, int maxTracerouteDurationSeconds, int maxNumberOfHops, Boolean verbose) {

        // Set default value for verbose if null
        if (verbose == null) {verbose = false;}

        if (verbose) { System.out.println(FW_ConsoleColors.BLUE + "- Audit - Traceroute (Begin)" + FW_ConsoleColors.RESET); }

        int numberOfProbes = 3; // Default number of probes per hop
        int maxProbeDurationSeconds = 5; // Default maximum duration for each probe in seconds
        boolean resolveHostnames = true; // Default to resolving hostnames

        // --- Input Validation ---
        if (host == null || host.isEmpty()) {return "[Audit Fail] - Host cannot be null or empty.";}
        host = FW_NetworkUtils.hostname(host); // Normalize the host input
        if (host.toUpperCase().contains("[FAIL]")) {return "[Fail] - {0.0} - host '" + host + "' is invalid.";}
        if (maxTracerouteDurationSeconds <= 0) {return "[Audit Fail] - Maximum traceroute duration must be greater than zero.";}
        if (maxNumberOfHops <= 0) {return "[Audit Fail] - Maximum number of hops must be greater than zero.";}

        // Perform traceroute and return tracerouteResult object
        FW_Traceroute tracerouteResultObj = FW_NetworkUtils.traceroute(host, maxTracerouteDurationSeconds, maxNumberOfHops, numberOfProbes, maxProbeDurationSeconds, resolveHostnames, verbose);

        // Get total number of hops from the traceroute result
        int hopsTotal = tracerouteResultObj.getHopsTotal();

        // Loop and return individual hop results as steps
        for (int i = 0; i < hopsTotal; i++) {

            // === Insert Test Step in preparation for this new hop result - Start ===
            // Capture markers used for step duplication
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            String testSuiteName = FW_Class.extractSimpleClassName(stackTrace[2].getClassName());
            String testCaseName = stackTrace[2].getMethodName();
            String testStepMethod = stackTrace[1].getMethodName();

            // Insert a new test step into the test run tracker for the hop result
            FW_TestStepUtils.duplicateTestStep(testSuiteName, testCaseName, testStepMethod);
            // === Insert Test Step in preparation for this new hop result - End ===

            // Declare variables for hop result status and details
            String hopResultStatus;
            String hopResultDetails;

            // Get the individual hop result
            FW_TracerouteHop hopResultObj = tracerouteResultObj.getHopDetails().get(i);

            // Create hopResultStatus and hopResultDetails based on if hope was reachable or not
            if (hopResultObj.isUnreachable()) {
                hopResultStatus = "[Note]";
                hopResultDetails =
                "Hop: " + hopResultObj.getHopNumber() + " " +
                "* * *" + " " +
                "(No response from host probe within " + maxProbeDurationSeconds + " second timeout.)";
            } else {
                hopResultStatus = "[Pass]";
                hopResultDetails =
                "Hop: " + hopResultObj.getHopNumber() + " " +
                (hopResultObj.getObservedIpAddresses() != null ? hopResultObj.getObservedIpAddresses() + " " : "") +
                (hopResultObj.getCountryCode() != null ? hopResultObj.getCountryCode() + " " : "") +
                (hopResultObj.getRegionCode() != null ? hopResultObj.getRegionCode() + " " : "") +
                (hopResultObj.getCity() != null ? hopResultObj.getCity() + " " : "") +
                (hopResultObj.getLatitude() != null && hopResultObj.getLongitude() != null ? "Lat/Lon: " + hopResultObj.getLatitude() + "," + hopResultObj.getLongitude() + " " : "") +
                (hopResultObj.getAsn() != null && hopResultObj.getAsn() != 0 ? "ASN: " + hopResultObj.getAsn() + " " : "") +
                (hopResultObj.getAsnOrganization() != null ? "Org: " + hopResultObj.getAsnOrganization() : "");
            }

            // Get the hop duration
            String hopResultDuration = hopResultObj.getAverageRtt() > 0 ? String.format("%.3f", hopResultObj.getAverageRtt()) : "0.0";

            // Create the hop result based on the hop result status, duration, and details
            String hopResult = hopResultStatus + " - {" + hopResultDuration + "} - " + hopResultDetails;

            // Create a new test step to capture the hop step result
            FW_TestStep hopTestStepResultObj = FW_TestStepUtils.createTestStep(hopResult,Thread.currentThread(), TestStepType.AUDIT_TRACEROUTE.getValue());

            // Add specific hop details to the test step result object
            hopTestStepResultObj.setTestStepRefOrder(hopResultObj.getHopNumber()); // Set the hop number as the test case repetition
            hopTestStepResultObj.setLocLatitude(hopResultObj.getLatitude() != null ? hopResultObj.getLatitude() : 0.0);
            hopTestStepResultObj.setLocLongitude(hopResultObj.getLongitude() != null ? hopResultObj.getLongitude() : 0.0);
            hopTestStepResultObj.setLocIPAddress(hopResultObj.getObservedIpAddresses() != null ? String.join(",",hopResultObj.getObservedIpAddresses()) : "");
            hopTestStepResultObj.setLocCountryCode(hopResultObj.getCountryCode() != null ? hopResultObj.getCountryCode() : "");
            hopTestStepResultObj.setLocStateCode(hopResultObj.getRegionCode() != null ? hopResultObj.getRegionCode() : "");
            hopTestStepResultObj.setLocCityName(hopResultObj.getCity() != null ? hopResultObj.getCity() : "");
            hopTestStepResultObj.setLocASN(hopResultObj.getAsn());
            hopTestStepResultObj.setLocOrganizationName(hopResultObj.getAsnOrganization() != null ? hopResultObj.getAsnOrganization() : "");
            hopTestStepResultObj.setTestStepExecuted(true);

            // Because this is an audit and we did not account for it at the time of analyzing the initial test steps.
            // Record the individual audit step for reporting.
            FW_CustomAssertJU.autoPass(hopTestStepResultObj);
        }

        // Create test step result object regarding the overall traceroute result
        FW_TestStep tracerouteOverallStepResultObj = FW_TestStepUtils.createTestStep(tracerouteResultObj.getStatus(), Thread.currentThread(), TestStepType.AUDIT_TRACEROUTE.getValue());

        if (verbose) { System.out.println(FW_ConsoleColors.BLUE + "- Audit - Traceroute (End)" + FW_ConsoleColors.RESET); }

        return tracerouteOverallStepResultObj;
    }
}
