package framework.utilities;

// ===============================================================
// @file: FW_CSSUtils.java
// @filepath: src/test/java/framework/utilities/FW_CSSUtils.java
// @version: 1.0.0
// @updated: 2025-01-10 03:12:00 PM CST
// @author: Greg Paskal
// @company: MissionWares
//
// @description:
// Utility class for CSS helper functions.
// This class provides utility functions for CSS operations, including
// parsing and extracting style values from CSS strings. Designed to
// support dynamic style manipulation and validation in test automation
// scenarios where CSS properties need to be verified or modified.
//
// @methods:
// - extractStyleValues(String) - Extracts style values from CSS string
//
// @dependencies:
// - java.util.regex.Matcher
// - java.util.regex.Pattern
// - java.util.HashMap
// - java.util.Map
//
// @tags: css, utilities, style-parsing, regex, mAi™
//
// @changeLog:
// Date        Author          Version  Description
// ----------  --------------  -------  --------------------------
// 2025-01-10  G. Paskal       1.0.0    Initial implementation with mAi™ header
// ===============================================================

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