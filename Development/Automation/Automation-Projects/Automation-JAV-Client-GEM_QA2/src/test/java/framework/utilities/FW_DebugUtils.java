package framework.utilities;

// ===============================================================
// @file: FW_DebugUtils.java
// @filepath: src/test/java/framework/utilities/FW_DebugUtils.java
// @version: 2.0.0
// @updated: 2025-09-09 11:30:00 AM CDT
// @author: Greg Paskal
// @company: MissionWares
//
// @description:
// Utility class for debugging with UTC-based timestamps for global consistency.
// This class provides utility functions for debugging purposes, including functionalities
// to log caller method information, print object details, and print strings with hexadecimal codes.
// 
// ENHANCED: Now uses UTC timestamps for all debug logging to ensure consistency across
// different geographic locations when debugging distributed systems.
// 
// The FW_DebugUtils class offers functionalities to:
// - Log caller method information with UTC timestamps
// - Print object details
// - Print strings with hexadecimal codes
// 
// This class is designed to provide utility methods for debugging purposes with
// globally consistent timestamps.
//
// @tags: debug, utility, logging, UTC, mAi™
//
// @changeLog:
// Date        Author          Version  Description
// ----------  --------------  -------  --------------------------
// 2024-12-17  G. Paskal       1.0.0    Initial creation, fixed typos and added null safety
// 2025-09-09  G. Paskal       2.0.0    Updated to use UTC timestamps for global consistency
// ===============================================================

import java.lang.reflect.Field;
import java.lang.reflect.InaccessibleObjectException;
import java.util.Collection;

/**
 * Utility class for debugging with UTC-based timestamps
 */
public class FW_DebugUtils {

    /**
     * Logs information about the caller method, including thread details and class name.
     * Now uses UTC timestamps for global consistency.
     *
     * @param verbosityLevel The level of beautification:
     *                       - 0: Simple output (single line)
     *                       - 1: Decorated output (border above and below)
     *                       - 2: Detailed output with UTC timestamp (multiple lines)
     * @param notify If true (default), prints a message to the terminal about the usage of this method. False only pass back the caller information.
     * 
     * @return Caller Information with UTC timestamp
     */
    public static String getCallerInfo(int verbosityLevel, boolean notify) {
        // Use UTC timestamp for global consistency
        String timestamp = FW_DateTimeUtils.getCurrentDateTimeUTC() + " UTC";
        Thread currentThread = Thread.currentThread();
        String threadName = currentThread.getName();
        long threadId = currentThread.threadId();

        StackTraceElement[] stackTrace = currentThread.getStackTrace();
        
        // Safely get stack elements with bounds checking
        StackTraceElement caller2 = (stackTrace.length > 2) ? stackTrace[2] : null;
        StackTraceElement caller3 = (stackTrace.length > 3) ? stackTrace[3] : null;
        StackTraceElement caller4 = (stackTrace.length > 4) ? stackTrace[4] : null;
        StackTraceElement caller5 = (stackTrace.length > 5) ? stackTrace[5] : null; 

        String callerInfo = formatCallerInfo(verbosityLevel, timestamp, threadName, threadId, caller2, caller3, caller4, caller5);

        if (notify) {
            System.out.println(callerInfo);
        }

        return callerInfo;
    }

    /**
     * Formats caller information based on verbosity level
     */
    private static String formatCallerInfo(int verbosityLevel, String timestamp, String threadName, long threadId, StackTraceElement caller2, StackTraceElement caller3, StackTraceElement caller4, StackTraceElement caller5) {
        // Safely handle null callers
        String className2 = (caller2 != null) ? formatClassName(caller2.getClassName()) : "N/A";
        String className3 = (caller3 != null) ? formatClassName(caller3.getClassName()) : "N/A";
        String className4 = (caller4 != null) ? formatClassName(caller4.getClassName()) : "N/A";
        String className5 = (caller5 != null) ? formatClassName(caller5.getClassName()) : "N/A";

        String combString = switch (verbosityLevel) {
            case 0 -> formatSimpleOutput(threadName, threadId, className5, caller5, className4, caller4, className3, caller3, className2, caller2);
            case 1 -> formatDecoratedOutput(threadName, threadId, className5, caller5, className4, caller4, className3, caller3, className2, caller2);
            case 2 -> formatDetailedOutput(timestamp, threadName, threadId, className5, caller5, className4, caller4, className3, caller3, className2, caller2);
            default -> "Invalid verbosity level. Use 0, 1, or 2.";
        };

        return FW_ConsoleColors.VIOLET + combString + FW_ConsoleColors.RESET;
    }

    /**
     * Formats class name by removing framework prefixes
     */
    private static String formatClassName(String className) {
        return className.replace("framework.automation.", "").replace("pageobjects.", "");
    }

    /**
     * Formats simple single-line output
     */
    private static String formatSimpleOutput(String threadName, long threadId, String className5, StackTraceElement caller5, String className4, StackTraceElement caller4, String className3, StackTraceElement caller3, String className2, StackTraceElement caller2) {
        StringBuilder sb = new StringBuilder();
        sb.append("Thread:").append(threadName).append("(").append(threadId).append(") - ");
        
        // Build the call chain with null safety
        if (caller5 != null) {
            sb.append(className5).append(".").append(caller5.getMethodName()).append(":").append(caller5.getLineNumber());
        } else {
            sb.append("N/A");
        }
        
        sb.append(" ⇄ ");
        
        if (caller4 != null) {
            sb.append(className4).append(".").append(caller4.getMethodName()).append(":").append(caller4.getLineNumber());
        } else {
            sb.append("N/A");
        }
        
        sb.append(" ⇄ ");
        
        if (caller3 != null) {
            sb.append(className3).append(".").append(caller3.getMethodName()).append(":").append(caller3.getLineNumber());
        } else {
            sb.append("N/A");
        }
        
        sb.append(" ⇄ ");
        
        if (caller2 != null) {
            sb.append(className2).append(".").append(caller2.getMethodName()).append(":").append(caller2.getLineNumber());
        } else {
            sb.append("N/A");
        }
        
        return sb.toString();
    }

    /**
     * Formats decorated output with border
     */
    private static String formatDecoratedOutput(String threadName, long threadId, String className5, StackTraceElement caller5, 
                                            String className4, StackTraceElement caller4, String className3, StackTraceElement caller3, 
                                            String className2, StackTraceElement caller2) {
        String combString = formatSimpleOutput(threadName, threadId, className5, caller5, className4, caller4, className3, caller3, className2, caller2);
        return FW_StringUtils.formatWithBorder(combString);
    }

    /**
     * Formats detailed multi-line output with UTC timestamp
     * Last updated: 09/09/2025 11:30 AM CDT - Updated to use UTC timestamps
     */
    private static String formatDetailedOutput(String timestamp, String threadName, long threadId, String className5, StackTraceElement caller5, String className4, StackTraceElement caller4, String className3, StackTraceElement caller3, String className2, StackTraceElement caller2) {
        StringBuilder sb = new StringBuilder();
        sb.append("Time: ").append(timestamp).append("\n");
        sb.append("Thread: ").append(threadName).append("\n");
        sb.append("Thread ID: ").append(threadId).append("\n");
        
        // Caller 5 info with null safety
        sb.append("Method called to:\n");
        sb.append("   Class: ").append(className5).append("\n");
        if (caller5 != null) {
            sb.append("   Method: ").append(caller5.getMethodName()).append("()\n");
            sb.append("   Line number: ").append(caller5.getLineNumber()).append("\n");
        } else {
            sb.append("   Method: N/A\n");
            sb.append("   Line number: N/A\n");
        }
        
        // Caller 4 info with null safety
        sb.append("Method called to:\n");
        sb.append("   Class: ").append(className4).append("\n");
        if (caller4 != null) {
            sb.append("   Method: ").append(caller4.getMethodName()).append("()\n");
            sb.append("   Line number: ").append(caller4.getLineNumber()).append("\n");
        } else {
            sb.append("   Method: N/A\n");
            sb.append("   Line number: N/A\n");
        }
        
        // Caller 3 info with null safety
        sb.append("Method called from:\n");
        sb.append("   Class: ").append(className3).append("\n");
        if (caller3 != null) {
            sb.append("   Method: ").append(caller3.getMethodName()).append("()\n");
            sb.append("   Line number: ").append(caller3.getLineNumber()).append("\n");
        } else {
            sb.append("   Method: N/A\n");
            sb.append("   Line number: N/A\n");
        }
        
        // Caller 2 info with null safety
        sb.append("Method called from:\n");
        sb.append("   Class: ").append(className2).append("\n");
        if (caller2 != null) {
            sb.append("   Method: ").append(caller2.getMethodName()).append("()\n");
            sb.append("   Line number: ").append(caller2.getLineNumber()).append("\n");
        } else {
            sb.append("   Method: N/A\n");
            sb.append("   Line number: N/A\n");
        }
        
        return FW_StringUtils.formatWithBorder(sb.toString());
    }

    /**
     * Returns the name of the class that called this method.
     */
    public static String getClassName() {
        StackTraceElement caller = Thread.currentThread().getStackTrace()[3];
        String className = caller.getClassName();
        return className;
    }

    /**
     * Returns the name of the method that called this method.
     */
    public static String getMethodName() {
        StackTraceElement caller = Thread.currentThread().getStackTrace()[3];
        String methodName = caller.getMethodName();
        return methodName;
    }

    /**
     * Prints detailed information about an object, including its fields and nested objects.
     * Includes UTC timestamp in the output header for consistent debugging logs.
     *
     * @param obj The object to print.
     */
    public static void printObjectDetails(Object obj) {
        if (obj == null) {
            System.out.println("null");
            return;
        }

        Class<?> clazz = obj.getClass();
        String timestamp = FW_DateTimeUtils.getCurrentDateTimeUTC() + " UTC";
        System.out.println("====================== Object Details - " + clazz.getName() + " - " + timestamp + " - Begin ======================");

        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            if (java.lang.reflect.Modifier.isStatic(field.getModifiers())) {
                continue;
            }

            if (!field.canAccess(obj)) {
                try {
                    field.setAccessible(true);
                } catch (InaccessibleObjectException e) {
                    System.out.println(field.getName() + ": [access denied]");
                    continue;
                }
            }

            try {
                Object value = field.get(obj);
                if (value instanceof Collection) {
                    System.out.println(field.getName() + ": " + value.getClass().getName() + " (size: " + ((Collection<?>) value).size() + ")");
                    for (Object item : (Collection<?>) value) {
                        printObjectDetails(item);
                    }
                } else {
                    System.out.println(field.getName() + ": " + value);
                }
            } catch (IllegalAccessException | IllegalArgumentException e) {
                System.out.println(field.getName() + ": [access denied]");
            }
        }

        System.out.println("====================== Object Details - " + clazz.getName() + " - " + timestamp + " - End ======================\n");
    }

    /**
     * Prints each character of the input string along with its hexadecimal code.
     *
     * @param string The input string.
     */
    public static void printStringWithHexCodes(String string) {
        if (string == null || string.isEmpty()) {
            System.out.println("Input string is null or empty.");
            return;
        }

        StringBuilder result = new StringBuilder();
        for (char ch : string.toCharArray()) {
            result.append(ch)
                .append("{\\u")
                .append(String.format("%04X", (int) ch))
                .append("} ");
        }

        // Print the result to the terminal
        System.out.println(result.toString().trim());
    }
}