package framework.utilities;

/**
 * @file FW_CSSUtils.java
 * @description Utility class for CSS helper functions.
 * 
 * This file contains the FW_CSSUtils class which provides utility functions for CSS operations.
 * It includes functionalities to extract style values from a given style string.
 * 
 * The FW_CSSUtils class offers functionalities to:
 * - Extract style values from a given style string.
 * 
 * This class is designed to provide utility methods for working with CSS.
 */

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.HashMap;
import java.util.Map;

/**
 * Utility class for CSS helper functions.
 */
public class FW_CSSUtils {

    /**
     * Extracts the style values from the given style string.
     * 
     * @param styleString string resembling "arguments[0].style.border='3px solid green'"
     * 
     * @return a Map containing the extracted values, or an empty Map if no match is found
     *       The Map contains the following keys:
     *          - property: the CSS property
     *          - width: the width value
     *          - style: the style value
     *          - color: the color value
     */
    public static Map<String, String> extractStyleValues(String styleString) {

        // RegEx pattern for extracting style values
        String REGEX = "arguments\\[0\\]\\.style\\.(\\w+)='(\\d+)px (\\w+) (\\w+)'";

        Pattern pattern = Pattern.compile(REGEX);
        Matcher matcher = pattern.matcher(styleString);

        Map<String, String> styleValues = new HashMap<>();

        if (matcher.find()) {
            styleValues.put("property", matcher.group(1));
            styleValues.put("width", matcher.group(2));
            styleValues.put("style", matcher.group(3));
            styleValues.put("color", matcher.group(4));
        }
        
        return styleValues;
    }
}