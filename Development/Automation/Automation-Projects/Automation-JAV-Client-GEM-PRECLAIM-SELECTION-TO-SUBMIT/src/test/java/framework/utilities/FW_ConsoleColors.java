package framework.utilities;
/**
 * @file FW_ConsoleColors.java
 * @description Manages the console colors for the test automation framework.
 * 
 * This file contains the FW_ConsoleColors class which provides ANSI escape codes for changing the text color in the console.
 * 
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
