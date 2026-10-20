package framework.utilities;
/**
 * @file FW_StringUtils.java
 * @description Provides utility methods for string manipulation.
 * 
 * This file contains the FW_StringUtils class which provides utility functions for string manipulation.
 * It includes functionalities to check for meta and parameter tags, extract meta tags and data, format strings with borders, convert human-readable durations to milliseconds, and clean strings based on various rules.
 * 
 * The FW_StringUtils class offers functionalities to:
 * - Check for meta and parameter tags.
 * - Extract meta tags and data.
 * - Format strings with borders.
 * - Convert human-readable durations to milliseconds.
 * - Clean strings based on various rules.
 * 
 * This class is designed to provide utility methods for string manipulation.
 */

import java.util.function.Function;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//import org.checkerframework.checker.units.qual.s;

/**
 * This class provides methods for reading the POM file.
 */
public class FW_StringUtils {

    /**
     * Determins if a Meta tag beginning with [ and ending with ] is present in the given string.
     * 
     * @param evaluate The string to evaluate for the presence of a meta tag.
     * 
     * @return A boolean value indicating if the meta tag is present.
     */
    public static boolean metaExist(String evaluate) {
        return evaluate.contains("[") && evaluate.contains("]");
    }

    /**
     * Determins if a Parameter tag beginning with { and ending with } is present in the given string.
     * 
     * @param evaluate The string to evaluate for the presence of a parameter tag.
     * 
     * @return A boolean value indicating if the parameter tag is present.
     */
    public static boolean parmExist(String evaluate) {
        return evaluate.contains("{") && evaluate.contains("}");
    }

    /**
     * Extracts the meta tag from the given string.
     * 
     * @param original
     * 
     * @return The meta tag extracted from the original string.
     */
    public static String metaTag(String original) {
        if (original == null || !metaExist(original)) {
            return "";
        }

        // Extract meta tag
        String tag = original.substring(original.indexOf("[") + 1, original.indexOf("]"));

        // Trim leading and trailing whitespace
        tag = tag.trim();

        return tag;
    }

    /**
     * Extracts the data excluding the meta tag from the given string.
     * 
     * @param original
     *  
     * @return The string excluding the meta tag.
     */
    public static String metaData(String original) {
        if (original == null || !metaExist(original)) {
            return "";
        }

        // Extract data excluding meta tag
        String data = original.substring(original.indexOf("]") + 1);
        
        // Remove leading " - " if it exists
        if (data.startsWith(" - ")) {data = data.substring(3);}

        // Remove any parameter data if it exists
        if (parmExist(data)) {

            // Remove all parameter data including opening and closing brackets
            data = data.replaceAll("\\{.*?\\}", "");

            // Remove leading " - " if it exists
            if (data.startsWith(" - ")) {data = data.substring(3);}
        }   

        // Trim leading and trailing whitespace
        data = data.trim();

        return data;
    }

    /**
     * Extracts the parameter duration from the given string.
     * 
     * @param original The original string containing the parameter.
     * 
     * @return The parameter duration extracted from the original string
     */
    public static String parmDuration(String original) {
        if (original == null || !parmExist(original)) {
            return "0.0";
        }
    
        try {
            // Extract duration parameter tag
            String parm = original.substring(original.indexOf("{") + 1, original.indexOf("}"));
    
            // Trim leading and trailing whitespace
            parm = parm.trim();
    
            return parm;
        } catch (Exception e) {
            // Handle any exception that occurs
            e.printStackTrace();
            return "";
        }
    }

    /**
     * Modifies original string by inserting inset string directly after first occurrence of "]" character.
     *
     * @param original The original string containing a meta which will be modified.
     * @param insert The string to insert into the original string containing thge meta
     *
     * @return The modified string containing the meta with the insert string.
     */
    public static String metaInsert(String original, String insert) {
        return original.replaceFirst("]", "] - " + insert);
    }

    /**
     * Formats the given multiline string with a border and padding.
     *
     * @param input The string to format.
     * 
     * @return The formatted string.
     */
    public static String formatWithBorder(String input) {
        String[] lines = input.split("\n");
        int maxLength = Arrays.stream(lines).mapToInt(String::length).max().orElse(0);
    
        String border = "═".repeat(maxLength + 2); // 2 is for the padding
        StringBuilder result = new StringBuilder("╔").append(border).append("╗\n");
    
        for (String line : lines) {
            String spaces = " ".repeat(maxLength - line.length());
            result.append("║ ").append(line).append(spaces).append(" ║\n");
        }
        result.append("╚").append(border).append("╝");
        return result.toString();
    }

    /**
     * Converts a human-readable duration string into total milliseconds.
     *
     * @param duration The human-readable duration string (e.g., "14:23:59:59.123").
     * @return The total duration in milliseconds, or 0l if the input is invalid.
     */
    public static long convertHRToMilliseconds(String duration) {
        if (duration == null || duration.isEmpty()) {
            return 0l;
        }

        try {
            long totalMilliseconds = 0l;

            // Split the duration string by ":"
            String[] parts = duration.split(":");

            // Handle milliseconds part
            String lastPart = parts[parts.length - 1];
            String[] secondsAndMillis = lastPart.split("\\.");
            long seconds = 0l;
            long milliseconds = 0l;

            if (secondsAndMillis.length > 0) {
                seconds = Long.parseLong(secondsAndMillis[0]);
            }
            if (secondsAndMillis.length > 1) {
                milliseconds = Long.parseLong(secondsAndMillis[1]);
            }

            // Calculate total milliseconds
            totalMilliseconds += milliseconds;
            totalMilliseconds += seconds * 1000;

            // Handle minutes, hours, and days if present
            if (parts.length > 1) {
                long minutes = Long.parseLong(parts[parts.length - 2]);
                totalMilliseconds += minutes * 60 * 1000;
            }
            if (parts.length > 2) {
                long hours = Long.parseLong(parts[parts.length - 3]);
                totalMilliseconds += hours * 60 * 60 * 1000;
            }
            if (parts.length > 3) {
                long days = Long.parseLong(parts[parts.length - 4]);
                totalMilliseconds += days * 24 * 60 * 60 * 1000;
            }

            return totalMilliseconds;
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return 0l;
        }
    }

    // The following methods are using for cleaning strings

    /**
     * Removes unwanted characters from a string based on a given rule.
     * 
     * @param string The string to clean.
     * @param rule The rule to apply for cleaning the string.
     *              - "punctuation": Removes punctuation characters.
     *              - "currency": Removes currency symbols.
     *              - "space": Removes space characters.
     *              - "return": Removes return characters.
     *              - "doubleSpaceReturn": Removes double space and return characters.
     *              - "invisible": Removes invisible characters.
     *              - "percent": Removes percent characters.
     *              - "phone": Removes phone characters.
     *              - "date": Removes date characters.
     *              - "alpha": Removes alpha characters.
     *              - "numeric": Removes numeric characters.
     * 
     * @return The cleaned string.
     */
    public static String stringCleaner(String originalString, String rule) {
        String cleanedString = rules.getOrDefault(rule, Function.identity()).apply(originalString);
        return cleanedString;
    }

    /**
     * A map of string cleaning rules.
     */
    private static final Map<String, Function<String, String>> rules = new HashMap<>();
    static {
        rules.put("punctuation", FW_StringUtils::removePunctuation);
        rules.put("currency", FW_StringUtils::removeCurrency);
        rules.put("space", FW_StringUtils::removeSpace);
        rules.put("return", FW_StringUtils::removeReturn);
        rules.put("doubleSpaceReturn", FW_StringUtils::removeDoubleSpaceReturn);
        rules.put("invisible", FW_StringUtils::removeInvisible);
        rules.put("percent", FW_StringUtils::removePercent);
        rules.put("phone", FW_StringUtils::removePhone);
        rules.put("date", FW_StringUtils::removeDate);
        rules.put("alpha", FW_StringUtils::removeAlpha);
        rules.put("numeric", FW_StringUtils::removeNumeric);
    }

    /**
     * Removes punctuation characters from the string.
     *
     * @param string The input string.
     * @return The cleaned string.
     */
    private static String removePunctuation(String string) {
        string = string.replace("!", "");  // Remove Exclamation marks
        string = string.replace("\"", ""); // Remove Double quotes
        string = string.replace("'", "");  // Remove Single quotes
        string = string.replace(",", "");  // Remove Commas
        string = string.replace("-", "");  // Remove Hyphens
        string = string.replace(".", "");  // Remove Periods
        string = string.replace(":", "");  // Remove Colons
        string = string.replace(";", "");  // Remove Semicolons
        string = string.replace("?", "");  // Remove Question marks
        return string;
    }

    /**
     * Removes currency-related characters from the string.
     *
     * @param string The input string.
     * @return The cleaned string.
     */
    private static String removeCurrency(String string) {
        string = string.replace("$", "");  // Remove Dollar signs
        string = string.replace(",", "");  // Remove Commas
        return string;
    }

    /**
     * Removes space characters from the string.
     *
     * @param string The input string.
     * @return The cleaned string.
     */
    private static String removeSpace(String string) {
        string = string.replace("\u0020", "");  // Remove Spaces (hex value \u0020)
        string = string.replace("\u00A0", "");  // Remove Non-breaking spaces (hex value \u00A0)
        return string;
    }

    /**
     * Removes return characters from the string.
     *
     * @param string The input string.
     * @return The cleaned string.
     */
    private static String removeReturn(String string) {
        string = string.replace("\r", " "); // Remove Linefeed characters (hex value \\u000A)
        string = string.replace("\n", " "); // Remove Carriage return characters (hex value \\u000D)
        return string;
    }

    /**
     * Removes double spaces and return characters from the string.
     *
     * @param string The input string.
     * @return The cleaned string.
     */
    private static String removeDoubleSpaceReturn(String string) {
        string = string.replace("\r", " "); // Remove Linefeed characters (hex value \\u000A)
        string = string.replace("\n", " "); // Remove Carriage return characters (hex value \\u000D)
        string = string.replaceAll("[\\u0020\\u00A0]+", " ").trim(); // Squeeze spaces (including non-breaking spaces) and trim
        return string;
    }

    /**
     * Removes invisible characters from the string.
     *
     * @param string The input string.
     * @return The cleaned string.
     */
    private static String removeInvisible(String string) {
        string = string.replace("\u0000", "");  // Remove NULL characters
        string = string.replace("\u0009", "");  // Remove Tab characters
        string = removeSpace(string);           // Remove spaces (including non-breaking spaces)
        string = removeReturn(string);          // Remove return characters (linefeed and carriage return)
        return string;
    }

    /**
     * Removes percent characters from the string.
     *
     * @param string The input string.
     * @return The cleaned string.
     */
    private static String removePercent(String string) {
        string = string.replace("%", ""); // Remove Percent signs
        return string;
    }

    /**
     * Removes phone-related characters from the string.
     *
     * @param string The input string.
     * @return The cleaned string.
     */
    private static String removePhone(String string) {
        string = string.replace("(", ""); // Remove Opening parentheses
        string = string.replace(")", ""); // Remove Closing parentheses
        string = string.replace("-", ""); // Remove Hyphens
        string = removeSpace(string);     // Remove spaces (including non-breaking spaces)
        return string;
    }

    /**
     * Removes date-related characters from the string.
     *
     * @param string The input string.
     * @return The cleaned string.
     */
    private static String removeDate(String string) {
        string = string.replace("/", ""); // Remove Slashes
        string = string.replace("-", ""); // Remove Hyphens
        string = removeSpace(string);     // Remove spaces (including non-breaking spaces)
        return string;
    }

    /**
     * Removes alphabetic characters from the string.
     *
     * @param string The input string.
     * @return The cleaned string.
     */
    private static String removeAlpha(String string) {
        string = string.replaceAll("[A-Za-z]", ""); // Remove Alphabetic characters
        return string;
    }

    /**
     * Removes numeric characters from the string.
     *
     * @param string The input string.
     * @return The cleaned string.
     */
    private static String removeNumeric(String string) {
        string = string.replaceAll("[0-9]", ""); // Remove Numeric characters
        return string;
    }

}