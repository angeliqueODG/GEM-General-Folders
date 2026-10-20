package framework.utilities;

// ===============================================================
// @file: FW_PerformanceUtils.java
// @filepath: src/test/java/framework/utilities/FW_PerformanceUtils.java
// @version: 1.0.0
// @updated: 2025-01-10 03:30:00 PM CST
// @author: Greg Paskal
// @company: MissionWares
//
// @description:
// Provides utility methods related to performance measurement and assessment.
// This class provides utility functions for performance-related operations
// including customer satisfaction assessment based on elapsed time thresholds
// and elapsed time calculations. Designed to evaluate test execution performance
// and provide visual feedback through CSS color coding based on response times.
//
// @methods:
// - calcSatisfactionAssessment(Instant, Instant) - Calculates satisfaction level
// - calcElapsedTime(Instant, Instant) - Calculates elapsed time in seconds
//
// @dependencies:
// - java.time.Duration
// - java.time.Instant
// - java.util.HashMap
// - java.util.Map
// - framework.utilities.FW_ConfigMgr
//
// @tags: performance, timing, satisfaction-metrics, elapsed-time, mAi™
//
// @changeLog:
// Date        Author          Version  Description
// ----------  --------------  -------  --------------------------
// 2025-01-10  G. Paskal       1.0.0    Initial implementation with mAi™ header
// ===============================================================

import java.time.Duration;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

/**
 * This class provides utility methods related to performance.
 */
public class FW_PerformanceUtils {

    /**
     * Calculate typical customer satisfaction assessment based on the elapsed time.
     *
     * @param startTime The start time.
     * @param finishTime The finish time.
     * 
     * @return A map containing the results of the satisfaction assessment.
     * 
     */
    public static Map<String, String> calcSatisfactionAssessment(Instant startTime, Instant finishTime) {
        Map<String, String> results = new HashMap<>();
        Duration duration = Duration.between(startTime, finishTime);
        double elapsedTime = duration.toMillis() / 1000.0; // Changed to double
        
        String assessResult;
        String assessColor;
        if (elapsedTime <= 2.0) {
            assessResult = "[Pass]";
            assessColor = FW_ConfigMgr.getLocatorHighlightPassCSS();
        } else if (elapsedTime <= 3.0) {
            assessResult = "[Pass Warn - Low]";
            assessColor = FW_ConfigMgr.getLocatorHighlightWarnLowCSS();
        } else if (elapsedTime <= 5.0) {
            assessResult = "[Pass Warn - Medium]";
            assessColor = FW_ConfigMgr.getLocatorHighlightWarnMediumCSS();
        } else if (elapsedTime <= 10.0) {
            assessResult = "[Pass Warn - High]";
            assessColor = FW_ConfigMgr.getLocatorHighlightWarnHighCSS();
        } else {
            assessResult = "[Pass Warn - Critical]";
            assessColor = FW_ConfigMgr.getLocatorHighlightWarnCriticalCSS();
        }

        results.put("elapsedTime", String.valueOf(elapsedTime));
        results.put("assessResult", assessResult);
        results.put("assessColor", assessColor);

        return results;
    }

    /**
     * Calculate elapsed time.
     * 
     * @param startTime The start time.
     * @param finishTime The finish time.
     *  
     * @return The elapsed time.
     */
    public static double calcElapsedTime(Instant startTime, Instant finishTime) {
        Duration duration = Duration.between(startTime, finishTime);
        double elapsedTime = duration.toMillis() / 1000.0; // Changed to double
        return elapsedTime;   
    }

}