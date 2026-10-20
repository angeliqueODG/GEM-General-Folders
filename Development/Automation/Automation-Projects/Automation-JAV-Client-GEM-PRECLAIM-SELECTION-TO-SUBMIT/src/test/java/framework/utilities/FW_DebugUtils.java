package framework.utilities;
/**
 * @file FW_DebugUtils.java
 * @description Utility class for debugging.
 * 
 * This file contains the FW_DebugUtils class which provides utility functions for debugging purposes.
 * It includes functionalities to log caller method information, print object details, and print strings with hexadecimal codes.
 * 
 * The FW_DebugUtils class offers functionalities to:
 * - Log caller method information.
 * - Print object details.
 * - Print strings with hexadecimal codes.
 * 
 * This class is designed to provide utility methods for debugging purposes.
 */

import java.lang.reflect.Field;
import java.lang.reflect.InaccessibleObjectException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collection;

/**
 * Utility class for debugging
 */
public class FW_DebugUtils {

    /**
     * Logs information about the caller method, including thread details and class name.
     *
     * @param verbosityLevel The level of beautification:
     *                       - 0: Simple output (single line)
     *                       - 1: Decorated output (border above and below)
     *                       - 2: Detailed output with timestamp (multiple lines)
     * @param notify If true (default), prints a message to the terminal about the usage of this method. False only pass back the caller information.
     * 
     * @return Caller Information
     */
    public static String getCallerInfo(int verbosityLevel, boolean notify) {
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm:ss a"));
        Thread currentThread = Thread.currentThread();
        String threadName = currentThread.getName();
        long threadId = currentThread.threadId();

        StackTraceElement[] stackTrace = currentThread.getStackTrace();
        StackTraceElement caller2 = stackTrace[2];
        StackTraceElement caller3 = stackTrace[3];
        StackTraceElement caller4 = stackTrace[4];
        StackTraceElement caller5 = stackTrace[5]; // New step back

        String callerInfo = formatCallerInfo(verbosityLevel, timestamp, threadName, threadId, caller2, caller3, caller4, caller5);

        if (notify) {
            System.out.println(callerInfo);
        }

        return callerInfo;
    }

    private static String formatCallerInfo(int verbosityLevel, String timestamp, String threadName, long threadId, StackTraceElement caller2, StackTraceElement caller3, StackTraceElement caller4, StackTraceElement caller5) {
        String className2 = formatClassName(caller2.getClassName());
        String className3 = formatClassName(caller3.getClassName());
        String className4 = formatClassName(caller4.getClassName());
        String className5 = formatClassName(caller5.getClassName());
    
        String combString = "";
        switch (verbosityLevel) {
            case 0:
                combString = formatSimpleOutput(threadName, threadId, className5, caller5, className4, caller4, className3, caller3, className2, caller2);
                break;
            case 1:
                combString = formatDecoratedOutput(threadName, threadId, className5, caller5, className4, caller4, className3, caller3, className2, caller2);
                break;
            case 2:
                combString = formatDetailedOutput(timestamp, threadName, threadId, className5, caller5, className4, caller4, className3, caller3, className2, caller2);
                break;
            default:
                combString = "Invalid verbosity level. Use 0, 1, or 2.";
                break;
        }
        return FW_ConsoleColors.VIOLET + combString + FW_ConsoleColors.RESET;
    }

    private static String formatClassName(String className) {
        return className.replace("framework.automation.", "").replace("pageobjects.", "");
    }

    private static String formatSimpleOutput(String threadName, long threadId, String className5, StackTraceElement caller5, String className4, StackTraceElement caller4, String className3, StackTraceElement caller3, String className2, StackTraceElement caller2) {
        return "Thread:" + threadName + "(" + threadId + ") - " + className5 + "." + caller5.getMethodName() + ":" + caller5.getLineNumber() + className4 + "." + caller4.getMethodName() + ":" + caller4.getLineNumber() + " ⇄ " + className3 + "." + caller3.getMethodName() + ":" + caller3.getLineNumber() + " ⇄ " + className2 + "." + caller2.getMethodName() + ":" + caller2.getLineNumber();
    }

    private static String formatDecoratedOutput(String threadName, long threadId, String className5, StackTraceElement caller5, String className4, StackTraceElement caller4, String className3, StackTraceElement caller3, String className2, StackTraceElement caller2) {
        String combString = formatSimpleOutput(threadName, threadId, className5, caller5, className4, caller4, className3, caller3, className2, caller2);
        return FW_StringUtils.formatWithBorder(combString);
    }

    private static String formatDetailedOutput(String timestamp, String threadName, long threadId, String className5, StackTraceElement caller5, String className4, StackTraceElement caller4, String className3, StackTraceElement caller3, String className2, StackTraceElement caller2) {
        String combString = "Time: " + timestamp + "\n";
        combString += "Thread: " + threadName + "\n";
        combString += "Thread ID: " + threadId + "\n";
        combString += "Methdod called to:\n";
        combString += "   Class: " + className5 + "\n";
        combString += "   Method: " + caller5.getMethodName() + "()\n";
        combString += "   Line number: " + caller5.getLineNumber() + "\n";
        combString += "Methdod called to:\n";
        combString += "   Class: " + className4 + "\n";
        combString += "   Method: " + caller4.getMethodName() + "()\n";
        combString += "   Line number: " + caller4.getLineNumber() + "\n";
        combString += "Method called from:\n";
        combString += "   Class: " + className3 + "\n";
        combString += "   Method: " + caller3.getMethodName() + "()\n";
        combString += "   Line number: " + caller3.getLineNumber() + "\n";
        combString += "Methdod called from:\n";
        combString += "   Class: " + className2 + "\n";
        combString += "   Method: " + caller2.getMethodName() + "()\n";
        combString += "   Line number: " + caller2.getLineNumber() + "\n";
        return FW_StringUtils.formatWithBorder(combString);
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
     *
     * @param obj The object to print.
     */
    public static void printObjectDetails(Object obj) {
        if (obj == null) {
            System.out.println("null");
            return;
        }

        Class<?> clazz = obj.getClass();
        System.out.println("====================== Object Details - " + clazz.getName() + " - Begin ======================");

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

        System.out.println("====================== Object Details - " + clazz.getName() + " - End ======================\n");
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