package framework.audits;

// ===============================================================
// @file: FW_AuditManager.java
// @filepath: src/test/java/framework/audits/FW_AuditManager.java
// @version: 1.0.1
// @updated: 2025-09-09 06:20:00 PM CDT
// @author: Greg Paskal
// @company: MissionWares
//
// @description:
// Centralized manager for all framework audit instances. This enum implements the
// Singleton pattern, ensuring only one instance of each audit class is created
// and shared across the framework. It provides a single point of access for all
// audit functionality including ping, sandbox validation, speed tests, and
// traceroute diagnostics.
//
// @methods:
// - getAuditPing() - Returns singleton FW_Audit_Ping instance
// - getAuditSandbox() - Returns singleton FW_Audit_Sandbox instance
// - getAuditSpeedTest() - Returns singleton FW_Audit_SpeedTest instance
// - getAuditTraceroute() - Returns singleton FW_Audit_Traceroute instance
// - getAuditClassNameFromGetter(String) - Maps getter method names to class names
//
// @dependencies:
// - framework.audits.FW_Audit_Ping
// - framework.audits.FW_Audit_Sandbox
// - framework.audits.FW_Audit_SpeedTest
// - framework.audits.FW_Audit_Traceroute
// - framework.java.FW_Class
//
// @tags: audit, manager, singleton, framework, enum-singleton, mAi™
//
// @changeLog:
// Date        Author          Version  Description
// ----------  --------------  -------  --------------------------
// 2025-07-01  G. Paskal       1.0.0    Initial creation, file header added
// 2025-09-09  G. Paskal       1.0.1    Enhanced header documentation
// ===============================================================

// --- Local Imports ---
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
    private final FW_Audit_HttpReview auditHttpReview;
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
        this.auditHttpReview = new FW_Audit_HttpReview();
        this.auditPing = new FW_Audit_Ping();
        this.auditSandbox = new FW_Audit_Sandbox();
        this.auditSpeedTest = new FW_Audit_SpeedTest();
        this.auditTraceroute = new FW_Audit_Traceroute();

        // Initialize the map to link getter methods to class names for reflection/logging
        Map<String, String> tempMap = new HashMap<>();
        tempMap.put("getAuditHttpReview", FW_Class.extractSimpleClassName(FW_Audit_HttpReview.class.getName()));
        tempMap.put("getAuditPing", FW_Class.extractSimpleClassName(FW_Audit_Ping.class.getName()));
        tempMap.put("getAuditSandbox", FW_Class.extractSimpleClassName(FW_Audit_Sandbox.class.getName()));
        tempMap.put("getAuditSpeedTest", FW_Class.extractSimpleClassName(FW_Audit_SpeedTest.class.getName()));
        tempMap.put("getAuditTraceroute", FW_Class.extractSimpleClassName(FW_Audit_Traceroute.class.getName()));

        // Make the map unmodifiable for thread safety and immutability
        this.auditGetterToClassNameMap = Collections.unmodifiableMap(tempMap);
    }

    // --- Getters to Access Audit Instances ---
    public FW_Audit_HttpReview getAuditHttpReview() { return auditHttpReview; }
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