package framework.audits;

// ===============================================================
// @file: FW_Audit_Traceroute.java
// @filepath: src/test/java/framework/audits/FW_Audit_Traceroute.java
// @version: 2.2.0
// @updated: 2025-09-09 06:15:00 PM CDT
// @author: Greg Paskal
// @company: MissionWares
//
// @description:
// Performs comprehensive network traceroute audits to analyze routing paths
// to specified hosts. This self-contained implementation includes encapsulated
// traceroute functionality with platform-specific support for Windows and Unix
// systems. Features early termination detection for unreachable paths, GeoIP
// resolution for hop locations, and detailed probe-level metrics including RTT,
// packet loss, and error conditions.
//
// @methods:
// - runAuditTraceroute(host, maxDuration, maxHops, verbose) - Main audit method
// - traceroute(host, maxDuration, maxHops, probes, probeDuration, resolve, maxUnreachable, verbose) - Core traceroute
// - checkTimeoutAliveReadLine(startTime, timeout, reader, process) - Process monitoring
// - parseAndAddProbes(hop, probes, line, expected, ip) - Probe parsing
//
// @dependencies:
// - framework.network.FW_Traceroute
// - framework.network.FW_TracerouteHop
// - framework.network.FW_TracerouteProbe
// - framework.utilities.FW_NetworkUtils
// - framework.junit.FW_CustomAssertJU
//
// @tags: network, traceroute, audit, routing, geoip, diagnostics, mAi™
//
// @changeLog:
// Date        Author          Version  Description
// ----------  --------------  -------  --------------------------
// 2025-08-19  G. Paskal       1.0.0    Initial creation
// 2025-08-20  G. Paskal       1.1.0    Refactored to use FW_NetworkDetails and applyNetworkDetails
// 2025-08-21  G. Paskal       2.0.0    Encapsulated traceroute and dependencies as private methods
// 2025-09-08  G. Paskal       2.1.0    Added early termination on consecutive unreachable hops
// 2025-09-09  G. Paskal       2.2.0    Updated header to mAi™ standard format
// ===============================================================

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.Duration;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Framework imports
import framework.java.FW_Class;
import framework.junit.FW_CustomAssertJU;
import framework.junit.FW_TestStep;
import framework.junit.FW_TestRunTracker;
import framework.junit.FW_TestStep.TestStepType;
import framework.network.FW_NetworkDetails;
import framework.network.FW_Traceroute;
import framework.network.FW_TracerouteHop;
import framework.network.FW_TracerouteProbe;
import framework.network.FW_TracerouteProbe.ProbeError;
import framework.utilities.FW_ConsoleColors;
import framework.utilities.FW_NetworkUtils;
import framework.utilities.FW_SystemUtils;
import framework.utilities.FW_TestStepUtils;

/**
 * This class performs an audit of the hops to a specified host using traceroute.
 * Contains self-contained traceroute implementation with all required dependencies.
 */
public class FW_Audit_Traceroute {

    // Regex for individual probe results (RTT ms, *, !Annotation)
    // Groups: 1:RTT_Value, 2:Asterisk, 3:Annotation (!H, !N, etc.)
    private static final Pattern PROBE_RESULT_PATTERN = Pattern.compile(
        "(?:(\\d+\\.?\\d*)\\s*ms)|(\\*)|(![A-Z])"
    );

    public static void main(String[] args) {
        // Initialize the Test Run Tracker
        FW_TestRunTracker.getInstance();
        
        // Parse command-line arguments or use defaults
        String host = (args.length > 0) ? args[0] : "dns.google";
        int maxDuration = (args.length > 1) ? Integer.parseInt(args[1]) : 120;
        int maxHops = (args.length > 2) ? Integer.parseInt(args[2]) : 30;
        Boolean verbose = (args.length > 3) ? Boolean.valueOf(args[3]) : Boolean.TRUE;
        
        // Run the audit
        FW_Audit_Traceroute auditTraceroute = new FW_Audit_Traceroute();
        Object result = auditTraceroute.runAuditTraceroute(host, maxDuration, maxHops, verbose);
        
        // Print result
        System.out.println(FW_ConsoleColors.PINK + "\n=== FINAL RESULT ===" + FW_ConsoleColors.RESET);
        System.out.println(FW_ConsoleColors.PINK + result + FW_ConsoleColors.RESET);
    }

    /**
     * This method performs an audit of the network hops to a specified host.
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

        // Define audit parameters
        int numberOfProbes = 3; // Default number of probes per hop
        int maxProbeDurationSeconds = 5; // Default maximum duration for each probe in seconds
        boolean resolveHostnames = true; // Default to resolving hostnames
        int maxConsecutiveUnreachableHops = 3; // Stop after this many consecutive unreachable hops

        // --- Input Validation ---
        if (host == null || host.isEmpty()) {return "[Audit Fail] - Host cannot be null or empty.";}
        host = FW_NetworkUtils.hostToHostname(host); // Normalize the host input
        if (host.toUpperCase().contains("[FAIL]")) {return "[Fail] - {0.0} - host '" + host + "' is invalid.";}
        if (maxTracerouteDurationSeconds <= 0) {return "[Audit Fail] - Maximum traceroute duration must be greater than zero.";}
        if (maxNumberOfHops <= 0) {return "[Audit Fail] - Maximum number of hops must be greater than zero.";}

        // Perform traceroute and return tracerouteResult object using private method
        FW_Traceroute tracerouteResultObj = traceroute(host, maxTracerouteDurationSeconds, 
            maxNumberOfHops, numberOfProbes, maxProbeDurationSeconds, resolveHostnames, maxConsecutiveUnreachableHops, verbose);

        // Get total number of hops from the traceroute result
        int hopsTotal = tracerouteResultObj.getHopsTotal();
        // Loop and return individual hop results as steps
        for (int i = 0; i < hopsTotal; i++) {

            // === Insert Test Step in preparation for this new hop result - Start ===
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
                hopResultDetails = "Hop: " + hopResultObj.getHopNumber() + " " + "* * *" + " " + "(No response from host probe within " + maxProbeDurationSeconds + " second timeout.)";

            // If hop is reachable but is a private IP address, skip GeoIP details
            } else if (FW_NetworkUtils.isPrivateIpAddress(hopResultObj.getPrimaryIpAddress()) == true) {
                hopResultStatus = "[Pass]";
                hopResultDetails =
                "Hop: " + hopResultObj.getHopNumber() + " " +
                (hopResultObj.getObservedIpAddresses() != null ? hopResultObj.getObservedIpAddresses() + " " : "") +
                "(Private IP Address) ";

            // If hop is reachable and is a public IP address, include GeoIP details if available
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
            String hopResultDuration = hopResultObj.getAverageRtt() > 0 ?
                String.format("%.3f", hopResultObj.getAverageRtt()) : "0.0";

            // Create the hop result based on the hop result status, duration, and details
            String hopResult = hopResultStatus + " - {" + hopResultDuration + "} - " + hopResultDetails;
            // Create a new test step to capture the hop step result
            FW_TestStep hopTestStepResultObj = FW_TestStepUtils.createTestStep(hopResult,Thread.currentThread(), TestStepType.AUDIT_TRACEROUTE.getValue());
            
            // Add specific hop details to the test step result object
            hopTestStepResultObj.setTestStepRefOrder(hopResultObj.getHopNumber());
            hopTestStepResultObj.applyNetworkDetails(hopResultObj.getNetworkDetails()); // Use the new helper method
            hopTestStepResultObj.setTestStepExecuted(true);

            // Record the individual audit step for reporting.
            FW_CustomAssertJU.autoPass(hopTestStepResultObj);
        }

        // Create test step result object regarding the overall traceroute result
        FW_TestStep tracerouteOverallStepResultObj = FW_TestStepUtils.createTestStep(tracerouteResultObj.getStatus(), Thread.currentThread(), TestStepType.AUDIT_TRACEROUTE.getValue());
        if (verbose) { System.out.println(FW_ConsoleColors.BLUE + "- Audit - Traceroute (End)" + FW_ConsoleColors.RESET); }

        return tracerouteOverallStepResultObj;
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
     * @param maxConsecutiveUnreachableHops Maximum consecutive unreachable hops before early termination.
     * @param verbose If true, print detailed execution and parsing steps to standard out. Defaults to false if null.
     *
     * @return An FW_Traceroute object containing the traceroute results, including overall status and detailed hop/probe data.
     */
    private FW_Traceroute traceroute(String host, int maxTracerouteDurationSeconds, int maxNumberOfHops, int numberOfProbes, int maxProbeDurationSeconds, boolean resolveHostnames, int maxConsecutiveUnreachableHops, Boolean verbose) {

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
        host = FW_NetworkUtils.hostToHostname(host);
        if (host.toUpperCase().contains("[FAIL]")) {
            tracerouteResult.setStatus("[Fail] - {0.0} - host '" + host + "' is invalid.");
            return tracerouteResult;
        }

        // Get the IP address of the host and validate it
        String targetIp = FW_NetworkUtils.hostToIP(host);
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
        Pattern hopPattern; // Primary pattern for lines with IP/Host
        FW_TracerouteHop currentHopForContinuations = null;
        // Groups: 1:HopNum, 2:RestOfLine (e.g., "* * *")
        final Pattern TIMEOUT_LINE_PATTERN = Pattern.compile("^\\s*(\\d+)\\s+(.*)$");
        // Groups: 1:IP_Address, 2:ProbesString
        final Pattern CONTINUATION_LINE_PATTERN = Pattern.compile("^\\s*(\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3})\\s+(.*)$");
        
        // Early termination tracking variables
        int consecutiveUnreachableHops = 0;
        boolean earlyTermination = false;

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

            // Prepare variable for parsing results
            Map<String, Object> resultProcessed = new HashMap<>();
            String outputLine;
            Instant startTime = Instant.now();

            // --- Main Parsing Loop - Begin ---
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
                        int hopNum;
                        String ip;
                        String hostName = null;
                        String probesPart;

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
                        parseAndAddProbes(hop, probesPart, trimmedLine, numberOfProbes, ip);
                        tracerouteResult.addHopDetail(hop); // Add the newly created hop to the traceroute result object

                        currentHopForContinuations = hop; // Set state for potential continuation lines
                        
                        // Check if this hop is unreachable (all probes timed out)
                        boolean hopIsUnreachable = true;
                        if (hop.getProbes() != null && !hop.getProbes().isEmpty()) {
                            for (FW_TracerouteProbe probe : hop.getProbes()) {
                                if (!probe.isTimedOut()) {
                                    hopIsUnreachable = false;
                                    break;
                                }
                            }
                        }

                        if (hopIsUnreachable) {
                            consecutiveUnreachableHops++;
                            if (isVerbose) {System.out.println(FW_ConsoleColors.YELLOW + "    - [Note] Unreachable hop detected. Consecutive count: " + consecutiveUnreachableHops + FW_ConsoleColors.RESET);}
                            
                            // Check if we've hit the threshold
                            if (consecutiveUnreachableHops >= maxConsecutiveUnreachableHops) {
                                earlyTermination = true;
                                tracerouteResult.setStatus("[Pass] - {" + String.format("%.3f", Duration.between(startTime, Instant.now()).toMillis() / 1000.0) + "} - Traceroute terminated early after " + consecutiveUnreachableHops + " consecutive unreachable hops (likely firewall/filtering).");
                                if (isVerbose) {System.out.println(FW_ConsoleColors.BLUE + "  - Early termination triggered: " + consecutiveUnreachableHops + " consecutive unreachable hops detected" + FW_ConsoleColors.RESET);}
                                break; // Exit the main parsing loop
                            }
                        } else {
                            // Reset counter when we get a reachable hop
                            if (consecutiveUnreachableHops > 0) {
                                if (isVerbose) {System.out.println(FW_ConsoleColors.GREEN + "    - [Note] Reachable hop detected. Resetting consecutive unreachable counter." + FW_ConsoleColors.RESET);}
                            }
                            consecutiveUnreachableHops = 0;
                        }

                    } catch (NumberFormatException | NullPointerException e) {
                        System.err.println(FW_ConsoleColors.RED + "     - [Error] - Unexpected error parsing primary hop line: '" + trimmedLine + "'. Error: " + e.getMessage() + FW_ConsoleColors.RESET);
                        currentHopForContinuations = null; // Reset state on error
                    }
                    // --- End Primary Parsing Logic ---

                } else if (!isWindows && (timeoutMatcher = TIMEOUT_LINE_PATTERN.matcher(outputLine)).matches()) {

                    // --- Fallback Timeout Logic ---
                     try {
                         int hopNum = Integer.parseInt(timeoutMatcher.group(1));
                         String probesPart = timeoutMatcher.group(2);
            
                         FW_TracerouteHop hop = new FW_TracerouteHop(hopNum); // Create hop with no IP/Host

                         // Extract IP if present in the probes part
                         String extractedIp = null;
                         Pattern ipPattern = Pattern.compile("(\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3})");
                         Matcher ipMatcher = ipPattern.matcher(probesPart);
                         if (ipMatcher.find()) {
                             extractedIp = ipMatcher.group(1);
                             hop.addObservedIpAddress(extractedIp);
                             if (isVerbose) {System.out.println(FW_ConsoleColors.CORAL + "    - [Note] IP extracted from timeout line: " + extractedIp + FW_ConsoleColors.RESET);}
                         }
            
                         // Parse the "* * *" part, passing null for IP
                         parseAndAddProbes(hop, probesPart, trimmedLine, numberOfProbes, extractedIp);
                         tracerouteResult.addHopDetail(hop); // Add the newly created hop
                         currentHopForContinuations = hop; // Set state for potential continuation lines (less likely after pure timeout)
                         
                         // Increment consecutive unreachable counter for timeout-only hops
                         consecutiveUnreachableHops++;
                         if (isVerbose) {System.out.println(FW_ConsoleColors.YELLOW + "    - [Note] Timeout hop detected. Consecutive unreachable count: " + consecutiveUnreachableHops + FW_ConsoleColors.RESET);}
                         
                         // Check if we've hit the threshold
                         if (consecutiveUnreachableHops >= maxConsecutiveUnreachableHops) {
                             earlyTermination = true;
                             tracerouteResult.setStatus("[Pass] - {" + String.format("%.3f", Duration.between(startTime, Instant.now()).toMillis() / 1000.0) + "} - Traceroute terminated early after " + consecutiveUnreachableHops + " consecutive unreachable hops (likely firewall/filtering).");
                             if (isVerbose) {System.out.println(FW_ConsoleColors.BLUE + "  - Early termination triggered: " + consecutiveUnreachableHops + " consecutive unreachable hops detected" + FW_ConsoleColors.RESET);}
                             break; // Exit the main parsing loop
                         }
            
                     } catch (RuntimeException e) {
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
                         parseAndAddProbes(currentHopForContinuations, probesPart, trimmedLine, numberOfProbes, ip);
                     } catch (Exception e) {
                        System.err.println(FW_ConsoleColors.RED + "[Error] - Unexpected error parsing continuation line: '" + outputLine + "'. Error: " + e.getMessage() + FW_ConsoleColors.RESET);
                     }            
                } else {
                    // --- Unrecognized Line ---
                    if (isVerbose) { System.out.println(FW_ConsoleColors.YELLOW + "    - [Warn] - Unrecognized line format skipped: '" + trimmedLine + "'" + FW_ConsoleColors.RESET); }
                }

                // Check if continueTracerouteCapture is "false" or early termination triggered to exit the loop
                if (continueTracerouteCapture == false || earlyTermination == true) {
		
                    // Set the traceroute result status
                    if (earlyTermination == false) {
                        tracerouteResult.setStatus((String) resultProcessed.get("status"));
                    }
                    break; // Exit the loop
                }
            }
            // --- Main Parsing Loop - End ---

            // Terminate the process if early termination was triggered
            if (earlyTermination && process.isAlive()) {
                process.destroyForcibly(); // Force kill the traceroute process
                if (isVerbose) {System.out.println(FW_ConsoleColors.BLUE + "  - Traceroute process terminated" + FW_ConsoleColors.RESET);}
            }

            // Read the output line
            tracerouteResult.setDuration((double) resultProcessed.get("elapsedTime"));
            if (earlyTermination == false) {
                tracerouteResult.setStatus((String) resultProcessed.get("status"));
            }

        } catch (IOException | RuntimeException e) {
            if (e instanceof IOException) tracerouteResult.setStatus("[Fail] - IOException: " + e.getMessage());
            else tracerouteResult.setStatus("[Fail] - Unexpected Exception: " + e.getClass().getName() + " - " + e.getMessage());
        } finally {
            // Close resources
            if (stdInput != null) try { stdInput.close(); } catch (IOException e) {/* ignore */}
            if (process != null) process.destroy();
        }

        // --- Post-processing: Calculate Hop Metrics - RTT, Packet Loss, Unreachable Flag (Begin) ---
        if (tracerouteResult.getHopDetails() != null && !tracerouteResult.getHopDetails().isEmpty()) {
            if (isVerbose) { System.out.println(FW_ConsoleColors.BLUE + "  - Calculating hop metrics..." + FW_ConsoleColors.RESET); }
            for (FW_TracerouteHop hop : tracerouteResult.getHopDetails()) {
                hop.calculateAndUpdateMetrics();
            }
        }
        // --- Post-processing: Calculate Hop Metrics - RTT, Packet Loss, Unreachable Flag (End) ---

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
                            return FW_NetworkUtils.hostToHostname(k); // Call the FW_NetworkUtils hostname utility method
                        });

                        // Determine the display result and update hop object only on success
                        String displayResult;
                        if (resolvedHostname != null && !resolvedHostname.equals(ip)) {
                            // Successful resolution to a distinct hostname
                            hop.setHostname(resolvedHostname); // Update the actual hop data
                            displayResult = resolvedHostname; // Use the hostname for display
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

        // --- Post-processing: Resolve Hop GeoIP ipNetworkDetails (Begin) ---
        if (tracerouteResult.getHopDetails() != null) {
            if (isVerbose == true) { System.out.println(FW_ConsoleColors.BLUE + "  - Attempting GeoIP resolution..." + FW_ConsoleColors.RESET); }
            for (FW_TracerouteHop hop : tracerouteResult.getHopDetails()) {
                String ip = hop.getPrimaryIpAddress();
                if (ip != null && !ip.isEmpty() && !FW_NetworkUtils.isPrivateIpAddress(ip)) {
                    // Create and populate FW_NetworkDetails for the hop's IP
                    FW_NetworkDetails ipNetworkDetails = FW_NetworkUtils.getNetworkDetails(ip);
                    hop.setNetworkDetails(ipNetworkDetails); // Attach the ipNetworkDetails object to the hop

                    if (isVerbose == true) {
                        String latStr = (ipNetworkDetails.getLatitude() != null) ? String.format("%.4f", ipNetworkDetails.getLatitude()) : "N/A";
                        String lonStr = (ipNetworkDetails.getLongitude() != null) ? String.format("%.4f", ipNetworkDetails.getLongitude()) : "N/A";
                        String asnStr = (ipNetworkDetails.getAsn() != null) ? "AS" + ipNetworkDetails.getAsn() : "N/A";
                        String output = String.format("    - GeoIP: %-15s | Ctry: %-2s | Reg: %-3s | City: %-15s | Lat/Lon: %s,%s | ASN: %-7s | Org: %s", ip, ipNetworkDetails.getCountryCode(), ipNetworkDetails.getRegion(), ipNetworkDetails.getCity(), latStr, lonStr, asnStr, ipNetworkDetails.getAsnOrganization());
                        System.out.println(FW_ConsoleColors.DARK_GREY + output + FW_ConsoleColors.RESET);
                    }
                } else if (isVerbose == true && ip != null && FW_NetworkUtils.isPrivateIpAddress(ip)) {

                    // Create and populate FW_NetworkDetails for the hop's IP
                    FW_NetworkDetails ipNetworkDetails = FW_NetworkUtils.getNetworkDetails(ip);
                    hop.setNetworkDetails(ipNetworkDetails); // Attach the ipNetworkDetails object to the hop
                    System.out.println(FW_ConsoleColors.DARK_GREY + "    - IP: " + ip + " (Private IP Address)" + FW_ConsoleColors.RESET);
                }
            }
        }
        // --- Post-processing: Resolve Hop GeoIP ipNetworkDetails (End) ---

        // --- Post-processing: Calculate Traceroute Summary Details (Begin) ---
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
        // --- Post-processing: Calculate Traceroute Summary Details (End) ---

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
     * @return A Map containing the analysis results:
     * - "elapsedTime": The elapsed time since startTime
     * - "continueTracerouteCapture": true if the process is alive and a line was read, false otherwise.
     * - "status": [Pass] or [Fail] status message including additional details.
     * - "line": The line read from the process's standard output or null if the end of the stream is reached.
     * @throws IOException If an I/O error occurs during readLine().
     */
    private Map<String, Object> checkTimeoutAliveReadLine(Instant startTime, int timeoutDurationSeconds, BufferedReader stdInput, Process process) throws IOException {

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
            analysisResults.put("status", "[Pass] - {" + elapsedTime + "} - Traceroute process has completed.");
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
     * @param sourceIp The IP address associated with this set of probes.
     */
    private void parseAndAddProbes(FW_TracerouteHop currentHop, String probesPart, String originalLine, int expectedProbes, String sourceIp) {
        if (currentHop == null) return; // Safety check
        if (probesPart == null || probesPart.trim().isEmpty()) {
            if (probesPart == null) { 
                 for (int i = 1; i <= expectedProbes; i++) {
                    currentHop.addProbe(new FW_TracerouteProbe(i, 0, true, ProbeError.TIMEOUT, null));
                }
             }
            return;
        }

        Matcher probeMatcher = PROBE_RESULT_PATTERN.matcher(probesPart.trim());
        int probeIndex = (currentHop.getProbes() == null ? 0 : currentHop.getProbes().size()) + 1;
        
        while (probeMatcher.find()) {
            double rtt;
            boolean timedOut = false;
            ProbeError error = ProbeError.NONE;

            if (probeMatcher.group(1) != null) { // Group 1: RTT value
                try {
                    rtt = Double.parseDouble(probeMatcher.group(1));
                } catch (NumberFormatException nfe) {
                    System.err.println(FW_ConsoleColors.RED+ "[Error] - Could not parse RTT value: " + probeMatcher.group(1) + " in line: " + originalLine + FW_ConsoleColors.RESET);
                    timedOut = true; 
                    error = ProbeError.UNKNOWN_ERROR; 
                    rtt = 0.0;
            }
            } else if (probeMatcher.group(2) != null) { // Group 2: Asterisk (*)
                timedOut = true;
                error = ProbeError.TIMEOUT;
                rtt = 0.0;
            } else if (probeMatcher.group(3) != null) { // Group 3: Annotation (!H, !N, etc.)
                timedOut = true;
                rtt = 0.0;
                String annotation = probeMatcher.group(3);
                error = switch (annotation) {
                    case "!H" -> ProbeError.HOST_UNREACHABLE;
                    case "!N" -> ProbeError.NETWORK_UNREACHABLE;
                    case "!P" -> ProbeError.PROTOCOL_UNREACHABLE;
                    case "!X", "!A" -> ProbeError.ADMIN_PROHIBITED;
                    default -> ProbeError.UNKNOWN_ERROR;
                };
            } else {
                 System.out.println(FW_ConsoleColors.YELLOW + "[Warn] - Probe regex matched but no known group captured in: " + probesPart + FW_ConsoleColors.RESET);
                 timedOut = true; error = ProbeError.UNKNOWN_ERROR; rtt = 0.0;
            }

            FW_TracerouteProbe probe = new FW_TracerouteProbe(probeIndex++, rtt, timedOut, error, sourceIp);
            currentHop.addProbe(probe);
        }
    }
}