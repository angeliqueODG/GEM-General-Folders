package framework.utilities;

/**
 * @file FW_DateTimeUtils.java
 * @description Utility class for date and time helper functions.
 * 
 * This file contains the FW_DateTimeUtils class which provides utility functions for date and time operations.
 * It includes functionalities to get the current timestamp in ISO 8601 format with milliseconds.
 * 
 * The FW_DateTimeUtils class offers functionalities to:
 * - Get the current timestamp in ISO 8601 format with milliseconds.
 * 
 * This class is designed to provide utility methods for working with date and time.
 */

import java.time.Instant;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

/**
 * Utility class for date and time helper functions.
 */
public class FW_DateTimeUtils {

    /**
     * Gets the current timestamp in ISO 8601 format with milliseconds.
     *
     * @return the current timestamp as a string in ISO 8601 format with milliseconds
     */
    public static String getCurrentTimestamp() {
        return DateTimeFormatter.ISO_INSTANT.format(Instant.now().atOffset(ZoneOffset.UTC));
    }
}