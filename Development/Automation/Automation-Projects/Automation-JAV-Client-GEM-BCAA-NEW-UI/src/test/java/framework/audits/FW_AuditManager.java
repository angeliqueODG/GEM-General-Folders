package framework.audits;

/**
 * @file FW_AuditManager.java
 * @description Centralized manager for all framework audit instances.
 * This enum implements the Singleton pattern, ensuring only one instance
 * of each audit class is created and shared across the framework.
 */

// --- Local Imports ---
import framework.audits.FW_Audit_Ping;
import framework.audits.FW_Audit_Sandbox;
import framework.audits.FW_Audit_SpeedTest;
import framework.audits.FW_Audit_Traceroute;
import framework.java.FW_Class;

// --- Java Imports ---
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Centralized manager for all framework audit instances using the Singleton pattern.
 */
public enum FW_AuditManager {
    INSTANCE; // The single, globally accessible instance of the enum

    // Declared audit instances.
    private final FW_Audit_Ping auditPing;
    private final FW_Audit_Sandbox auditSandbox;
    private final FW_Audit_SpeedTest auditSpeedTest;
    private final FW_Audit_Traceroute auditTraceroute;

    // Map to associate getter method names with their corresponding audit class names.
    private final Map<String, String> auditGetterToClassNameMap;

    /**
     * The private constructor is called only once by the JVM when the enum is first accessed.
     * It initializes all audit instances and populates the lookup map.
     */
    private FW_AuditManager() {
        // Initialize all audit instances
        this.auditPing = new FW_Audit_Ping();
        this.auditSandbox = new FW_Audit_Sandbox();
        this.auditSpeedTest = new FW_Audit_SpeedTest();
        this.auditTraceroute = new FW_Audit_Traceroute();

        // Initialize the map to link getter methods to class names for reflection/logging
        Map<String, String> tempMap = new HashMap<>();
        tempMap.put("getAuditPing", FW_Class.extractSimpleClassName(FW_Audit_Ping.class.getName()));
        tempMap.put("getAuditSandbox", FW_Class.extractSimpleClassName(FW_Audit_Sandbox.class.getName()));
        tempMap.put("getAuditSpeedTest", FW_Class.extractSimpleClassName(FW_Audit_SpeedTest.class.getName()));
        tempMap.put("getAuditTraceroute", FW_Class.extractSimpleClassName(FW_Audit_Traceroute.class.getName()));

        // Make the map unmodifiable for thread safety and immutability
        this.auditGetterToClassNameMap = Collections.unmodifiableMap(tempMap);
    }

    // --- Getters to Access Audit Instances ---
    public FW_Audit_Ping getAuditPing() { return auditPing; }
    public FW_Audit_Sandbox getAuditSandbox() { return auditSandbox; }
    public FW_Audit_SpeedTest getAuditSpeedTest() { return auditSpeedTest; }
    public FW_Audit_Traceroute getAuditTraceroute() { return auditTraceroute; }

    /**
     * Retrieves the simple class name of an audit using its getter method name.
     *
     * @param getterMethodName The name of the getter method (e.g., "getAuditPing").
     * @return The simple class name (e.g., "FW_Audit_Ping"). Returns the input if no match is found.
     */
    public String getAuditClassNameFromGetter(String getterMethodName) {
        // Return the mapped class name, or the getter name itself as a fallback.
        return auditGetterToClassNameMap.getOrDefault(getterMethodName, getterMethodName);
    }

    // ======================================================================================
    // Note: Remember to update FW_TestStep.java to include the new audit types if necessary.
    // ======================================================================================

}