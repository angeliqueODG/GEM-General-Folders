package framework.utilities;

// ===============================================================
// @file: FW_DateTimeUtils.java
// @filepath: src/test/java/framework/utilities/FW_DateTimeUtils.java
// @version: 2.1.0
// @updated: 2025-10-16 03:45:00 PM CDT
// @author: Greg Paskal
// @company: MissionWares
//
// @description:
// Enhanced utility class for date, time, and duration helper functions with consistent UTC support.
// This class provides methods for generating timestamps in various formats, all based on UTC
// to ensure consistency across different geographic locations and timezones, as well as
// thread-safe duration wait operations with caller tracking.
// 
// Key Features:
// - UTC-based timestamps for global consistency
// - ISO 8601 format support with milliseconds
// - Human-readable date/time formats
// - Timezone-aware conversions
// - Support for both UTC and local time display
// - Flexible duration wait operations (milliseconds, seconds, minutes, hours)
// - Interruptible waits with caller tracking for debugging
//
// TIMESTAMP OPERATIONS:
// - Get current timestamp in ISO 8601 format (UTC)
// - Get formatted date strings (UTC)
// - Get formatted time strings (UTC)
// - Get combined date/time strings (UTC)
// - Convert between UTC and local time
// - Get timezone information
// - Unix timestamp operations
//
// DURATION OPERATIONS:
// - Wait for specified durations with flexible time units
// - Interruptible wait with proper thread handling
// - Caller information tracking for debugging
// - Optional notification logging
//
// @tags: datetime, timestamp, UTC, timezone, duration, wait, utility, mAi™
//
// @changeLog:
// Date        Author          Version  Description
// ----------  --------------  -------  --------------------------
// 2025-01-01  G. Paskal       1.0.0    Initial creation
// 2025-09-09  G. Paskal       2.0.0    Enhanced with comprehensive UTC support for global consistency
// 2025-09-09  G. Paskal       2.0.1    Enhanced main method with comprehensive format demonstrations
// 2025-10-16  G. Paskal       2.1.0    Added waitForDuration methods for thread wait operations
// ===============================================================

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/**
 * Enhanced utility class for date, time, and duration helper functions with UTC consistency.
 * All timestamp methods return UTC-based values unless explicitly noted otherwise.
 * Duration methods provide flexible, interruptible wait operations with caller tracking.
 */
public class FW_DateTimeUtils {

    // ========== TIMESTAMP CONSTANTS ==========
    
    // Standard date/time format patterns
    private static final String DATE_PATTERN = "MM/dd/yyyy";
    private static final String TIME_PATTERN = "hh:mm:ss a";
    private static final String DATETIME_PATTERN = "MM/dd/yyyy hh:mm:ss a";
    
    // Timezone constants
    private static final ZoneId UTC_ZONE = ZoneOffset.UTC;
    private static final String UTC_TIMEZONE_CODE = "UTC";
    
    // ========== DURATION CONSTANTS ==========
    
    private static final long MILLIS_PER_SECOND = 1000L;
    private static final long MILLIS_PER_MINUTE = 60_000L;
    private static final long MILLIS_PER_HOUR = 3_600_000L;

    /**
     * Enhanced main method for comprehensive testing and demonstration of all utility methods.
     * Displays all time formats in an organized, easy-to-read format using FW_ConsoleColors.
     *
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        System.out.println("\n" + FW_ConsoleColors.BLUE + "=================================================================================" + FW_ConsoleColors.RESET);
        System.out.println(FW_ConsoleColors.CORAL + "                      FW_DateTimeUtils - Time Format Demonstration" + FW_ConsoleColors.RESET);
        System.out.println(FW_ConsoleColors.BLUE + "=================================================================================" + FW_ConsoleColors.RESET);
        
        // UTC Formats Section
        System.out.println("\n" + FW_ConsoleColors.GREEN + "▶ UTC FORMATS (Global Consistency - Use for Data Lake)" + FW_ConsoleColors.RESET);
        System.out.println("  " + FW_ConsoleColors.YELLOW + "├─" + FW_ConsoleColors.RESET + " ISO 8601 Timestamp:     " + FW_ConsoleColors.PINK + getCurrentTimestamp() + FW_ConsoleColors.RESET);
        System.out.println("  " + FW_ConsoleColors.YELLOW + "├─" + FW_ConsoleColors.RESET + " UTC Date Only:          " + FW_ConsoleColors.PINK + getCurrentDateUTC() + FW_ConsoleColors.RESET);
        System.out.println("  " + FW_ConsoleColors.YELLOW + "├─" + FW_ConsoleColors.RESET + " UTC Time Only:          " + FW_ConsoleColors.PINK + getCurrentTimeUTC() + FW_ConsoleColors.RESET);
        System.out.println("  " + FW_ConsoleColors.YELLOW + "├─" + FW_ConsoleColors.RESET + " UTC Date & Time:        " + FW_ConsoleColors.PINK + getCurrentDateTimeUTC() + FW_ConsoleColors.RESET);
        System.out.println("  " + FW_ConsoleColors.YELLOW + "├─" + FW_ConsoleColors.RESET + " UTC Timezone Code:      " + FW_ConsoleColors.PINK + getTimezoneUTC() + FW_ConsoleColors.RESET);
        System.out.println("  " + FW_ConsoleColors.YELLOW + "└─" + FW_ConsoleColors.RESET + " Reporting Timestamp:    " + FW_ConsoleColors.PINK + getReportingTimestamp() + FW_ConsoleColors.RESET);
        
        // Local Formats Section
        System.out.println("\n" + FW_ConsoleColors.GREEN + "▶ LOCAL FORMATS (System Timezone - Varies by Location)" + FW_ConsoleColors.RESET);
        System.out.println("  " + FW_ConsoleColors.YELLOW + "├─" + FW_ConsoleColors.RESET + " Local Date Only:        " + FW_ConsoleColors.ORANGE + getCurrentDateUTC() + FW_ConsoleColors.RESET);
        System.out.println("  " + FW_ConsoleColors.YELLOW + "├─" + FW_ConsoleColors.RESET + " Local Time Only:        " + FW_ConsoleColors.ORANGE + getCurrentTimeUTC() + FW_ConsoleColors.RESET);
        System.out.println("  " + FW_ConsoleColors.YELLOW + "├─" + FW_ConsoleColors.RESET + " Local Date & Time:      " + FW_ConsoleColors.ORANGE + getCurrentDateTimeUTC() + FW_ConsoleColors.RESET);
        System.out.println("  " + FW_ConsoleColors.YELLOW + "├─" + FW_ConsoleColors.RESET + " Local Timezone:         " + FW_ConsoleColors.ORANGE + getLocalTimezone() + FW_ConsoleColors.RESET);
        System.out.println("  " + FW_ConsoleColors.YELLOW + "└─" + FW_ConsoleColors.RESET + " UTC Offset (hours):     " + FW_ConsoleColors.ORANGE + getTimezoneOffsetHours() + " hours" + FW_ConsoleColors.RESET);
        
        // Unix Timestamps Section
        System.out.println("\n" + FW_ConsoleColors.GREEN + "▶ UNIX TIMESTAMPS (Epoch-based)" + FW_ConsoleColors.RESET);
        long unixTime = getCurrentUnixTimestamp();
        System.out.println("  " + FW_ConsoleColors.YELLOW + "├─" + FW_ConsoleColors.RESET + " Unix Timestamp (sec):   " + FW_ConsoleColors.BLUE + unixTime + FW_ConsoleColors.RESET);
        System.out.println("  " + FW_ConsoleColors.YELLOW + "├─" + FW_ConsoleColors.RESET + " Unix Timestamp (ms):    " + FW_ConsoleColors.BLUE + getCurrentUnixTimestampMillis() + FW_ConsoleColors.RESET);
        System.out.println("  " + FW_ConsoleColors.YELLOW + "└─" + FW_ConsoleColors.RESET + " Formatted Unix Time:    " + FW_ConsoleColors.BLUE + formatUnixTimestamp(unixTime) + FW_ConsoleColors.RESET);
        
        // Precision Variants Section
        System.out.println("\n" + FW_ConsoleColors.GREEN + "▶ PRECISION VARIANTS (ISO 8601 with Different Truncation)" + FW_ConsoleColors.RESET);
        System.out.println("  " + FW_ConsoleColors.YELLOW + "├─" + FW_ConsoleColors.RESET + " With Milliseconds:      " + FW_ConsoleColors.VIOLET + getCurrentTimestamp(ChronoUnit.MILLIS) + FW_ConsoleColors.RESET);
        System.out.println("  " + FW_ConsoleColors.YELLOW + "├─" + FW_ConsoleColors.RESET + " Seconds Only:           " + FW_ConsoleColors.VIOLET + getCurrentTimestamp(ChronoUnit.SECONDS) + FW_ConsoleColors.RESET);
        System.out.println("  " + FW_ConsoleColors.YELLOW + "├─" + FW_ConsoleColors.RESET + " Minutes Only:           " + FW_ConsoleColors.VIOLET + getCurrentTimestamp(ChronoUnit.MINUTES) + FW_ConsoleColors.RESET);
        System.out.println("  " + FW_ConsoleColors.YELLOW + "└─" + FW_ConsoleColors.RESET + " Hours Only:             " + FW_ConsoleColors.VIOLET + getCurrentTimestamp(ChronoUnit.HOURS) + FW_ConsoleColors.RESET);
        
        // Conversion Examples Section
        System.out.println("\n" + FW_ConsoleColors.GREEN + "▶ TIMEZONE CONVERSIONS" + FW_ConsoleColors.RESET);
        String currentUTC = getCurrentTimestamp();
        String localConverted = convertUTCToLocal(currentUTC);
        // Remove timezone suffix for conversion back to UTC
        String localForConversion = localConverted.substring(0, localConverted.lastIndexOf(' '));
        System.out.println("  " + FW_ConsoleColors.YELLOW + "├─" + FW_ConsoleColors.RESET + " Original UTC:           " + FW_ConsoleColors.GREENYELLOW + currentUTC + FW_ConsoleColors.RESET);
        System.out.println("  " + FW_ConsoleColors.YELLOW + "├─" + FW_ConsoleColors.RESET + " Converted to Local:     " + FW_ConsoleColors.GREENYELLOW + localConverted + FW_ConsoleColors.RESET);
        System.out.println("  " + FW_ConsoleColors.YELLOW + "└─" + FW_ConsoleColors.RESET + " Back to UTC:            " + FW_ConsoleColors.GREENYELLOW + convertLocalToUTC(localForConversion) + FW_ConsoleColors.RESET);
        
        // Comparison Section
        System.out.println("\n" + FW_ConsoleColors.GREEN + "▶ GLOBAL CONSISTENCY DEMONSTRATION" + FW_ConsoleColors.RESET);
        System.out.println("  " + FW_ConsoleColors.YELLOW + "├─" + FW_ConsoleColors.RESET + " If this test runs in US (CDT):     " + FW_ConsoleColors.CORAL + "Local: 2:00 PM CDT → UTC: 7:00 PM" + FW_ConsoleColors.RESET);
        System.out.println("  " + FW_ConsoleColors.YELLOW + "├─" + FW_ConsoleColors.RESET + " If this test runs in Africa (CAT): " + FW_ConsoleColors.CORAL + "Local: 9:00 PM CAT → UTC: 7:00 PM" + FW_ConsoleColors.RESET);
        System.out.println("  " + FW_ConsoleColors.YELLOW + "└─" + FW_ConsoleColors.RESET + " " + FW_ConsoleColors.PINK + "Result: Both show SAME UTC time in data lake! ✓" + FW_ConsoleColors.RESET);
        
        // Duration Wait Examples Section
        System.out.println("\n" + FW_ConsoleColors.GREEN + "▶ DURATION WAIT EXAMPLES" + FW_ConsoleColors.RESET);
        System.out.println("  " + FW_ConsoleColors.YELLOW + "├─" + FW_ConsoleColors.RESET + " Wait 1.5 seconds (notify=true):");
        String waitResult1 = waitForDuration(1.5, "s", true);
        System.out.println("  " + FW_ConsoleColors.YELLOW + "│  " + FW_ConsoleColors.RESET + FW_ConsoleColors.CORAL + "Result: " + waitResult1 + FW_ConsoleColors.RESET);
        System.out.println("  " + FW_ConsoleColors.YELLOW + "├─" + FW_ConsoleColors.RESET + " Wait 500 milliseconds (default, silent):");
        String waitResult2 = waitForDuration(0.5);
        System.out.println("  " + FW_ConsoleColors.YELLOW + "│  " + FW_ConsoleColors.RESET + FW_ConsoleColors.CORAL + "Result: " + waitResult2 + FW_ConsoleColors.RESET);
        System.out.println("  " + FW_ConsoleColors.YELLOW + "└─" + FW_ConsoleColors.RESET + " Wait operations completed successfully");
        
        // Recommendations Section
        System.out.println("\n" + FW_ConsoleColors.GREEN + "▶ RECOMMENDATIONS" + FW_ConsoleColors.RESET);
        System.out.println("  " + FW_ConsoleColors.WHITE + "1." + FW_ConsoleColors.RESET + " Use " + FW_ConsoleColors.GREEN + "UTC methods" + FW_ConsoleColors.RESET + " for all data lake reporting");
        System.out.println("  " + FW_ConsoleColors.WHITE + "2." + FW_ConsoleColors.RESET + " Use " + FW_ConsoleColors.YELLOW + "getCurrentTimestamp()" + FW_ConsoleColors.RESET + " for ISO 8601 format");
        System.out.println("  " + FW_ConsoleColors.WHITE + "3." + FW_ConsoleColors.RESET + " Use " + FW_ConsoleColors.YELLOW + "getCurrentDateTimeUTC()" + FW_ConsoleColors.RESET + " for human-readable UTC");
        System.out.println("  " + FW_ConsoleColors.WHITE + "4." + FW_ConsoleColors.RESET + " Local methods are " + FW_ConsoleColors.DARK_GREY + "@Deprecated" + FW_ConsoleColors.RESET + " - use only for display");
        System.out.println("  " + FW_ConsoleColors.WHITE + "5." + FW_ConsoleColors.RESET + " Use " + FW_ConsoleColors.YELLOW + "waitForDuration()" + FW_ConsoleColors.RESET + " for thread waits with caller tracking");
        
        System.out.println("\n" + FW_ConsoleColors.BLUE + "=================================================================================" + FW_ConsoleColors.RESET);
        System.out.println(FW_ConsoleColors.CORAL + "                        Timestamp: " + getCurrentTimestamp() + FW_ConsoleColors.RESET);
        System.out.println(FW_ConsoleColors.BLUE + "=================================================================================" + FW_ConsoleColors.RESET + "\n");
    }

    // ========================================
    // TIMESTAMP METHODS
    // ========================================

    /**
     * Gets the current timestamp in ISO 8601 format with milliseconds (UTC).
     * Format: 2025-09-09T15:30:45.123Z
     *
     * @return the current timestamp as a string in ISO 8601 format with milliseconds
     */
    public static String getCurrentTimestamp() {
        return DateTimeFormatter.ISO_INSTANT.format(Instant.now().atOffset(ZoneOffset.UTC));
    }

    /**
     * Gets the current timestamp in ISO 8601 format with custom precision (UTC).
     *
     * @param truncateTo the ChronoUnit to truncate to (e.g., ChronoUnit.SECONDS, ChronoUnit.MILLIS)
     * @return the current timestamp truncated to the specified precision
     */
    public static String getCurrentTimestamp(ChronoUnit truncateTo) {
        Instant now = Instant.now();
        if (truncateTo != null) {
            now = now.truncatedTo(truncateTo);
        }
        return DateTimeFormatter.ISO_INSTANT.format(now.atOffset(ZoneOffset.UTC));
    }

    /**
     * Gets the current date in UTC in the format MM/dd/yyyy.
     * Example: 09/09/2025
     *
     * @return the current date string in UTC
     */
    public static String getCurrentDateUTC() {
        ZonedDateTime utcNow = ZonedDateTime.now(UTC_ZONE);
        return utcNow.format(DateTimeFormatter.ofPattern(DATE_PATTERN));
    }

    /**
     * Gets the current time in UTC in the format hh:mm:ss a.
     * Example: 03:30:45 PM
     *
     * @return the current time string in UTC
     */
    public static String getCurrentTimeUTC() {
        ZonedDateTime utcNow = ZonedDateTime.now(UTC_ZONE);
        return utcNow.format(DateTimeFormatter.ofPattern(TIME_PATTERN));
    }

    /**
     * Gets the current date and time in UTC in the format MM/dd/yyyy hh:mm:ss a.
     * Example: 09/09/2025 03:30:45 PM
     *
     * @return the current date and time string in UTC
     */
    public static String getCurrentDateTimeUTC() {
        ZonedDateTime utcNow = ZonedDateTime.now(UTC_ZONE);
        return utcNow.format(DateTimeFormatter.ofPattern(DATETIME_PATTERN));
    }

    /**
     * Gets the timezone code for UTC.
     * Always returns "UTC" for consistency.
     *
     * @return "UTC" string
     */
    public static String getTimezoneUTC() {
        return UTC_TIMEZONE_CODE;
    }

    /**
     * Gets the system's local timezone abbreviation.
     * Example: "CDT", "EST", "PST", "CAT", "SAST"
     *
     * @return the local timezone abbreviation
     */
    public static String getLocalTimezone() {
        ZoneId zoneId = ZoneId.systemDefault();
        ZonedDateTime zonedDateTime = ZonedDateTime.now(zoneId);
        return zonedDateTime.format(DateTimeFormatter.ofPattern("z"));
    }

    /**
     * Converts a UTC timestamp to local time.
     *
     * @param utcTimestamp the UTC timestamp in ISO 8601 format
     * @return the local time string in the format MM/dd/yyyy hh:mm:ss a with timezone
     */
    public static String convertUTCToLocal(String utcTimestamp) {
        try {
            Instant instant = Instant.parse(utcTimestamp);
            ZonedDateTime localTime = instant.atZone(ZoneId.systemDefault());
            return localTime.format(DateTimeFormatter.ofPattern(DATETIME_PATTERN + " z"));
        } catch (Exception e) {
            return "Invalid UTC timestamp: " + utcTimestamp;
        }
    }

    /**
     * Converts a local time to UTC timestamp.
     *
     * @param localDateTime the local date/time in the format MM/dd/yyyy hh:mm:ss a
     * @return the UTC timestamp in ISO 8601 format
     */
    public static String convertLocalToUTC(String localDateTime) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATETIME_PATTERN);
            LocalDateTime ldt = LocalDateTime.parse(localDateTime, formatter);
            ZonedDateTime localZoned = ldt.atZone(ZoneId.systemDefault());
            ZonedDateTime utcZoned = localZoned.withZoneSameInstant(UTC_ZONE);
            return utcZoned.format(DateTimeFormatter.ISO_INSTANT);
        } catch (Exception e) {
            return "Invalid local datetime: " + localDateTime;
        }
    }

    /**
     * Gets the current Unix timestamp (seconds since epoch).
     *
     * @return the current Unix timestamp
     */
    public static long getCurrentUnixTimestamp() {
        return Instant.now().getEpochSecond();
    }

    /**
     * Gets the current Unix timestamp in milliseconds.
     *
     * @return the current Unix timestamp in milliseconds
     */
    public static long getCurrentUnixTimestampMillis() {
        return Instant.now().toEpochMilli();
    }

    /**
     * Formats a Unix timestamp to a readable UTC date/time string.
     *
     * @param unixTimestamp the Unix timestamp (seconds since epoch)
     * @return formatted date/time string in UTC
     */
    public static String formatUnixTimestamp(long unixTimestamp) {
        Instant instant = Instant.ofEpochSecond(unixTimestamp);
        ZonedDateTime utcTime = instant.atZone(UTC_ZONE);
        return utcTime.format(DateTimeFormatter.ofPattern(DATETIME_PATTERN + " 'UTC'"));
    }

    /**
     * Gets the offset between local timezone and UTC in hours.
     * Positive values mean local time is ahead of UTC.
     *
     * @return the timezone offset in hours
     */
    public static int getTimezoneOffsetHours() {
        ZonedDateTime now = ZonedDateTime.now();
        return now.getOffset().getTotalSeconds() / 3600;
    }

    /**
     * Creates a standardized timestamp string for reporting.
     * Format: ISO 8601 with additional timezone info for clarity.
     * Example: "2025-09-09T15:30:45.123Z (UTC)"
     *
     * @return standardized timestamp for reporting
     */
    public static String getReportingTimestamp() {
        String isoTimestamp = getCurrentTimestamp();
        return isoTimestamp + " (UTC)";
    }

    // ========================================
    // DURATION/WAIT METHODS
    // ========================================

    /**
     * Wait for a specified duration with default values (seconds, no notification).
     * This is a convenience overload that defaults to seconds and silent operation.
     * 
     * @param waitDuration The duration to wait with at least two decimal places.
     * 
     * @return Details of where this was called from.
     */
    public static String waitForDuration(double waitDuration) {
        return waitForDuration(waitDuration, "s", false);
    }

    /**
     * Wait for a specified duration of time and allows interruption.
     * Supports flexible time units and optional caller notification.
     * 
     * @param waitDuration The duration to wait with at least two decimal places.
     * @param durationType The duration type - (ms = milliseconds, s = seconds (default), m = minutes, h = hours)
     * @param notify If true, prints a message to the terminal about the usage of this method.
     * 
     * @return Details of where this was called from, including interruption status if applicable.
     */
    public static String waitForDuration(double waitDuration, String durationType, boolean notify) {

        // Validate waitDuration is non-negative
        if (waitDuration < 0) {
            throw new IllegalArgumentException("Wait duration cannot be negative: " + waitDuration);
        }

        // Handle null durationType by setting a default value
        if (durationType == null) {
            durationType = "s"; // default to seconds
        }

        // Set the number of milliseconds based on the duration type
        long milliseconds = (long) switch (durationType.trim().toLowerCase()) {
            case "ms", "milliseconds" -> waitDuration;
            case "s", "seconds" -> waitDuration * MILLIS_PER_SECOND;
            case "m", "minutes" -> waitDuration * MILLIS_PER_MINUTE;
            case "h", "hours" -> waitDuration * MILLIS_PER_HOUR;
            default -> waitDuration * MILLIS_PER_SECOND; // Default to seconds
        };

        // Prepare the caller information
        String callerInfo = "waitForDuration called - " + FW_DebugUtils.getCallerInfo(0, false);
        
        // Print the caller information if notify is true
        if (notify) {
            System.out.println(FW_ConsoleColors.CORAL + callerInfo + FW_ConsoleColors.RESET);
        }
        
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // Restore interrupted status
            System.out.println(FW_ConsoleColors.YELLOW + "Wait was interrupted." + FW_ConsoleColors.RESET);
            return callerInfo + " - Wait interrupted.";
        }
        
        return callerInfo;
    }
}