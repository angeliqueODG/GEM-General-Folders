package framework.audits;
/**
 * @file FW_Audit_SpeedTest.java
 * @description Performs a speed test similar to the speedtest.net service.
 */

// Framework imports
import framework.automation.FW_Network;
import framework.junit.FW_TestStep;
import framework.junit.FW_TestStep.TestStepType;
import framework.utilities.FW_ConsoleColors;
import framework.utilities.FW_TestStepUtils;

/**
 * This class performs an audit of the system network speed.
 */
public class FW_Audit_SpeedTest {

    public static void main(String[] args) {

        // Create an instance of FW_Audit_Traceroute
        FW_Audit_SpeedTest auditSpeedTest = new FW_Audit_SpeedTest();

        // Set parameters for verbose output
        boolean verbose = true;
    
        // Run the traceroute audit
        Object result = auditSpeedTest.runAuditSpeedTest(verbose);

        // Print the final result
        System.out.println(FW_ConsoleColors.PINK + "Final Result: " + result + FW_ConsoleColors.RESET);
    }

    /**
     * This method performs an audit of network speed test.
     *
     * @param verbose If true, print detailed execution and parsing steps to standard out. Defaults to false if null.
     *
     * @return Consolidated audit result details.
     */
    public Object runAuditSpeedTest (Boolean verbose) {

        // Set default value for verbose if null
        if (verbose == null) {verbose = false;}

        if (verbose) { System.out.println(FW_ConsoleColors.BLUE + "- Audit - Speed Test (Begin)" + FW_ConsoleColors.RESET); }

        // Create new network object
        FW_Network network = new FW_Network();

        // Perform speed test
        String result = network.speedTest();

        FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread(), TestStepType.AUDIT_SPEEDTEST.getValue());

        if (verbose) { System.out.println(FW_ConsoleColors.BLUE + "- Audit - Speed Test (End)" + FW_ConsoleColors.RESET); }

        return resultObj;
    }
}
