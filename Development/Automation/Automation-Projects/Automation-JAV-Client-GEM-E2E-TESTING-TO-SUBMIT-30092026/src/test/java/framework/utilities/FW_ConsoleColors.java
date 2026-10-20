package framework.utilities;

// ===============================================================
// @file: FW_ConsoleColors.java
// @filepath: src/test/java/framework/utilities/FW_ConsoleColors.java
// @version: 1.0.0
// @updated: 2025-01-10 03:10:00 PM CST
// @author: Greg Paskal
// @company: MissionWares
//
// @description:
// Manages console colors for the test automation framework.
// This class provides ANSI escape codes for changing text color in the console,
// enabling colored output for better readability of test results, logs, and
// status messages. Supports a wide range of colors including standard and
// extended RGB color codes.
//
// @methods:
// - None (contains only public static final color constants)
//
// @dependencies:
// - None (standalone utility class)
//
// @tags: console, ansi, colors, terminal, output-formatting, mAi™
//
// @changeLog:
// Date        Author          Version  Description
// ----------  --------------  -------  --------------------------
// 2025-01-10  G. Paskal       1.0.0    Initial implementation with mAi™ header
// ===============================================================

/**
 * Provides ANSI escape codes for console text coloring.
 */
public class FW_ConsoleColors {
    public static final String BLACK = "\033[0;30m";            // BLACK
    public static final String BROWN = "\033[38;5;94m";         // BROWN
    public static final String RED = "\033[38;2;255;0;0m";      // RED
    public static final String PINK = "\033[38;2;255;193;203m"; // PINK
    public static final String CORAL = "\033[38;2;255;127;80m"; // CORAL
    public static final String ORANGE = "\033[38;2;255;165;0m"; // ORANGE
    public static final String YELLOW = "\033[38;2;255;255;0m"; // YELLOW
    public static final String GREEN = "\033[38;2;0;128;1m";    // GREEN
    public static final String GREENYELLOW = "\033[38;2;173;255;47m"; // GREEN YELLOW
    public static final String BLUE = "\033[0;34m";             // BLUE
    public static final String VIOLET = "\033[0;35m";           // VIOLET
    public static final String GREY = "\033[0;37m";             // GREY
    public static final String DARK_GREY = "\033[0;90m";        // DARK GREY
    public static final String WHITE = "\033[0;97m";            // WHITE
    public static final String RESET = "\033[0m";               // Text Reset
}
