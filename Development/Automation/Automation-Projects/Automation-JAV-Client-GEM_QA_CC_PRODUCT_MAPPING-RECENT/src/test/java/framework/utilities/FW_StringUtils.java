package framework.utilities;

// ===============================================================
// @file: FW_StringUtils.java
// @filepath: src/test/java/framework/utilities/FW_StringUtils.java
// @version: 1.4.0
// @updated: 2025-10-13 11:35:00 AM CDT
// @author: Greg Paskal
// @company: MissionWares
//
// @description:
// Provides a collection of static utility methods for common string manipulation tasks.
// This class offers robust functions for parsing, cleaning, and formatting strings.
// It includes methods for extracting data from structured text (like meta and
// parameter tags), converting human-readable formats to machine-readable values,
// and sanitizing strings by removing unwanted characters based on predefined rules.
// Key capabilities include a rule-based string cleaner, tag extraction, bordered
// text formatting, and vertical list formatting with optional sorting.
//
// @methods:
// - parseKeywordValue(String, String) - Extracts value associated with keyword
// - extractFirstNumber(String) - Extracts first numeric sequence from string
// - stringCleaner(String, String) - Cleans string by applying sanitization rule
// - metaTag(String) - Extracts content of meta tag [...] from string
// - metaData(String) - Extracts data portion, excluding meta tag
// - parmDuration(String) - Extracts duration value from parameter tag {...}
// - convertHRToMilliseconds(String) - Converts human-readable time to milliseconds
// - formatWithBorder(String) - Wraps multi-line string in decorative border
// - metaExist(String) - Checks for presence of meta tag [...]
// - parmExist(String) - Checks for presence of parameter tag {...}
// - metaInsert(String, String) - Inserts text after meta tag in string
// - formatAsVerticalList(String, String, String) - Formats delimited string as vertical list with optional sorting
//
// @dependencies:
// - java.util.Arrays
// - java.util.HashMap
// - java.util.Map
// - java.util.function.Function
// - java.util.regex.Matcher
// - java.util.regex.Pattern
//
// @tags: string-manipulation, parsing, sanitization, formatting, mAi™
//
// @changeLog:
// Date        Author          Version  Description
// ----------  --------------  -------  --------------------------
// 2025-08-13  G. Paskal       1.0.0    Initial implementation
// 2025-08-13  G. Paskal       1.1.0    Added rule-based string cleaner
// 2025-01-10  G. Paskal       1.2.0    Added mAi™ header standard
// 2025-10-13  G. Paskal       1.3.0    Added formatAsVerticalList with sorting options
// 2025-10-13  G. Paskal       1.4.0    Added removeCustom method for flexible character removal
// ===============================================================

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This class provides a collection of static utility methods for common string manipulation tasks.
 */
public class FW_StringUtils {

    /**
     * Parses a string to find a specific keyword and extracts the value that follows it.
     * <p>
     * This method is designed for semi-structured strings where data is presented
     * in a "Keyword: Value," format. It robustly extracts the value associated
     * with the given keyword, trimming any leading or trailing whitespace from the result.
     * <p>
     * It is critical to check the return value to understand the result of the parse,
     * as it distinguishes between a missing keyword and a keyword with an empty value.
     *
     * @param sourceText The full string to search within (e.g., the speed test result). Must not be null.
     * @param keyword The case-sensitive keyword to search for (e.g., "Download", "Location"). Must not be null.
     * @return <ul>
     * <li>The trimmed {@code String} value if the keyword is found and has a non-empty value.</li>
     * <li>An empty {@code String} ("") if the keyword is found but its value is empty or contains only whitespace.</li>
     * <li>{@code null} if the keyword itself is not found in the source string at all.</li>
     * </ul>
     */
    public static String parseKeywordValue(String sourceText, String keyword) {
        // Ensure inputs are not null to prevent NullPointerException, consistent with other methods.
        if (sourceText == null || keyword == null) {
            return null;
        }

        // This regex pattern is robust and efficient for this task.
        // 1. Pattern.quote(keyword) - Treats the keyword literally to avoid regex conflicts.
        // 2. :\\s* - Looks for a colon, followed by zero or more whitespace characters.
        // 3. ([^,]+) - This is the capture group. It matches and captures one or more
        //              characters that are NOT a comma.
        Pattern pattern = Pattern.compile(Pattern.quote(keyword) + ":\\s*([^,]+)");
        Matcher matcher = pattern.matcher(sourceText);

        if (matcher.find()) {
            // group(1) returns the captured text (our value).
            // .trim() removes any leading/trailing whitespace from the result.
            return matcher.group(1).trim();
        }

        // Return null if the keyword was not found.
        return null;
    }

    /**
     * Extracts the first number (integer or decimal) found anywhere in a string.
     *
     * @param input The string to search within (e.g., "Approx. 5 seconds").
     * @return A string containing the first number found, or null if no number is present.
     */
    public static String extractFirstNumber(String input) {
        if (input == null || input.isEmpty()) {
            return null;
        }

        // The new pattern removes the '^' anchor to find the number anywhere.
        // It looks for a sequence of digits, an optional decimal, and more digits.
        Pattern pattern = Pattern.compile("\\d*\\.?\\d+");
        Matcher matcher = pattern.matcher(input);

        if (matcher.find()) {
            // Return the first matching group found in the string.
            return matcher.group(0);
        }

        return null; // Return null if no numeric sequence is found.
    }
    
    /**
     * Determines if a Meta tag beginning with [ and ending with ] is present in the given string.
     * * @param evaluate The string to evaluate for the presence of a meta tag.
     * * @return A boolean value indicating if the meta tag is present.
     */
    public static boolean metaExist(String evaluate) {
        return evaluate.contains("[") && evaluate.contains("]");
    }

    /**
     * Determines if a Parameter tag beginning with { and ending with } is present in the given string.
     * * @param evaluate The string to evaluate for the presence of a parameter tag.
     * * @return A boolean value indicating if the parameter tag is present.
     */
    public static boolean parmExist(String evaluate) {
        return evaluate.contains("{") && evaluate.contains("}");
    }

    /**
     * Extracts the meta tag from the given string.
     * * @param original The string to extract the meta tag from.
     * * @return The meta tag extracted from the original string.
     */
    public static String metaTag(String original) {
        if (original == null || metaExist(original) == false) {
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
     * * @param original The string to extract the data from.
     * * @return The string excluding the meta tag.
     */
    public static String metaData(String original) {
        if (original == null || metaExist(original) == false) {
            return "";
        }

        // Extract data excluding meta tag
        String data = original.substring(original.indexOf("]") + 1);
        
        // Remove leading " - " if it exists
        if (data.startsWith(" - ")) {
            data = data.substring(3);
        }

        // Remove any parameter data if it exists
        if (parmExist(data) == true) {

            // Remove all parameter data including opening and closing brackets
            data = data.replaceAll("\\{.*?\\}", "");

            // Remove leading " - " if it exists
            if (data.startsWith(" - ")) {
                data = data.substring(3);
            }
        }   

        // Trim leading and trailing whitespace
        data = data.trim();

        return data;
    }

    /**
     * Extracts the parameter duration from the given string.
     * * @param original The original string containing the parameter.
     * * @return The parameter duration extracted from the original string
     */
    public static String parmDuration(String original) {
        if (original == null || parmExist(original) == false) {
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
        return original.replaceFirst("\\]", "] - " + insert);
    }

    /**
     * Formats the given multiline string with a border and padding.
     *
     * @param input The string to format.
     * * @return The formatted string.
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
            return 0L;
        }

        try {
            long totalMilliseconds = 0L;

            // Split the duration string by ":"
            String[] parts = duration.split(":");

            // Handle milliseconds part
            String lastPart = parts[parts.length - 1];
            String[] secondsAndMillis = lastPart.split("\\.");
            long seconds = 0L;
            long milliseconds = 0L;

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
            return 0L;
        }
    }

    /**
     * Formats a delimited string as a vertical list with optional sorting and custom line separator.
     * <p>
     * Takes a string containing delimited values and returns each value separated by the specified
     * line separator. Each item is trimmed of leading and trailing whitespace. Empty items after 
     * trimming are excluded from the result. The list can optionally be sorted alphabetically.
     * <p>
     * <b>Common Line Separators:</b>
     * <ul>
     * <li>"\n" - Standard newline (default for plain text)</li>
     * <li>"&lt;br&gt;" - HTML line break (for markdown tables and HTML)</li>
     * <li>"&lt;br/&gt;" - XHTML line break</li>
     * <li>", " - Comma-space (for inline lists)</li>
     * </ul>
     * <p>
     * <b>Sort Options:</b>
     * <ul>
     * <li>"" or "none" - Keep original order</li>
     * <li>"ascending" or "asc" - Sort A to Z (case-insensitive)</li>
     * <li>"descending" or "desc" - Sort Z to A (case-insensitive)</li>
     * </ul>
     *
     * @param delimitedString The string containing delimited values (e.g., "a,b,c")
     * @param delimiter The delimiter separating values (e.g., ",")
     * @param lineSeparator The separator to use between items (e.g., "\n", "&lt;br&gt;", ", ")
     * @param sortOrder Sort option: "", "none", "ascending", "asc", "descending", "desc"
     * 
     * @return A string with each value separated by lineSeparator, or empty string if input is null/empty
     */
    public static String formatAsVerticalList(String delimitedString, String delimiter, String lineSeparator, String sortOrder) {
        // Handle null or empty input
        if (delimitedString == null || delimitedString.isEmpty()) {
            return "";
        }
        
        // Handle null delimiter - default to comma
        if (delimiter == null) {
            delimiter = ",";
        }
        
        // Handle null sortOrder - default to no sorting
        if (sortOrder == null) {
            sortOrder = "";
        }
        
        // Handle null or empty lineSeparator - default to newline
        if (lineSeparator == null || lineSeparator.isEmpty()) {
            lineSeparator = "\n";
        }
        
        // Split the string by delimiter
        String[] items = delimitedString.split(Pattern.quote(delimiter));
        
        // Trim each item and filter out empty strings
        String[] trimmedItems = Arrays.stream(items)
                .map(String::trim)
                .filter(s -> !s.isEmpty())
                .toArray(String[]::new);
        
        // Sort if requested
        String sortLower = sortOrder.toLowerCase().trim();
        if (sortLower.equals("ascending") || sortLower.equals("asc")) {
            // Sort ascending (A to Z) - case insensitive
            Arrays.sort(trimmedItems, String.CASE_INSENSITIVE_ORDER);
        } else if (sortLower.equals("descending") || sortLower.equals("desc")) {
            // Sort descending (Z to A) - case insensitive
            Arrays.sort(trimmedItems, String.CASE_INSENSITIVE_ORDER.reversed());
        }
        // else: keep original order (no sorting)
        
        // Join with specified line separator
        return String.join(lineSeparator, trimmedItems);
    }

    // The following methods are using for cleaning strings

    /**
     * Removes unwanted characters from a string based on a given rule.
     * * @param originalString The string to clean.
     * @param rule The rule to apply for cleaning the string.
     * - "punctuation": Removes punctuation characters.
     * - "currency": Removes currency symbols.
     * - "space": Removes space characters.
     * - "return": Removes return characters.
     * - "doubleSpaceReturn": Removes double space and return characters.
     * - "invisible": Removes invisible characters.
     * - "percent": Removes percent characters.
     * - "phone": Removes phone characters.
     * - "date": Removes date characters.
     * - "alpha": Removes alpha characters.
     * - "numeric": Removes numeric characters.
     * * @return The cleaned string.
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
        string = string.replace("\r", " "); // Remove Linefeed characters
        string = string.replace("\n", " "); // Remove Carriage return characters
        return string;
    }

    /**
     * Removes double spaces and return characters from the string.
     *
     * @param string The input string.
     * @return The cleaned string.
     */
    private static String removeDoubleSpaceReturn(String string) {
        string = string.replace("\r", " "); // Remove Linefeed characters
        string = string.replace("\n", " "); // Remove Carriage return characters
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

    /**
     * Removes specified custom characters from a string.
     *
     * @param string The input string to process
     * @param charsToRemove Characters to remove (e.g., ".,;:!" removes punctuation)
     * 
     * @return The cleaned string, or original string if input is null
     */
    public static String removeCustom(String string, String charsToRemove) {
        // Handle null input
        if (string == null || charsToRemove == null) {
            return string;
        }
        
        // Optimization: return immediately if nothing to remove
        if (charsToRemove.isEmpty() || string.isEmpty()) {
            return string;
        }

        // Remove each character individually
        String result = string;
        for (char c : charsToRemove.toCharArray()) {
            result = result.replace(String.valueOf(c), "");
        }

        return result;
    }

}