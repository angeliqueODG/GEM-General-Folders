// This code for the JUnit custom assertion
package framework.assertions;

import org.junit.jupiter.api.Assertions;
import io.qameta.allure.Step;

/**
 * This class is used to create custom assertion specific for our autoamtion framework utilizing JUnit.
 */
public class FW_CustomAssertJU {

    // Declare ANSI escape sequences for formatting console output colors
    static String black = "\033[0;30m";         // BLACK
    static String brown = "\033[0;33m";         // BROWN
    static String red = "\033[0;31m";           // RED
    static String orange = "\033[38;5;208m";    // ORANGE
    static String yellow = "\033[0;33m";        // YELLOW
    static String green = "\033[0;32m";         // GREEN
    static String blue = "\033[0;34m";          // BLUE
    static String violet = "\033[0;35m";        // VIOLET
    static String grey = "\033[0;37m";          // GREY
    static String white = "\033[0;97m";         // WHITE
    static String reset = "\033[0m";            // Text Reset

    /**
     * Default constructor.
     */
    public FW_CustomAssertJU() {
        // Default constructor
    }

    /**
     * Asserts that the given result string contains either "[Pass]" or "[Fail]".
     * If the result is null, the test fails immediately.
     * If the result contains "[Pass]", the test passes.
     * If the result contains "[Fail]", the test fails.
     * If the result contains neither "[Pass]" nor "[Fail]", the test fails with a warning about invalid formatting.
     *
     * @param result the result string to check
     */
    @Step("Processing result: {0}")
    public static void autoPass(String result) {

        // Handle null result
        if (result == null) {
            Assertions.fail("Result is null.");
            stepResult(result);
            return;
        }

        // Handle [Audit Pass] result
        if (result.toUpperCase().contains("[AUDIT PASS]")) {
            System.out.println(green + result +  reset);
            Assertions.assertTrue(true);
            stepResult(result);

        // Handle [Audit Fail] result
        } else if (result.toUpperCase().contains("[AUDIT FAIL]")) {
            System.out.println(red + result + reset);
            Assertions.fail(result);
            stepResult(result);

        // Handle [Pass] result
        } else if (result.toUpperCase().contains("[PASS]")) {
            System.out.println(green + result +  reset);
            Assertions.assertTrue(true);
            stepResult(result);

        // Handle [Fail] result
        } else if (result.toUpperCase().contains("[FAIL]")) {
            System.out.println(red + result + reset);
            Assertions.fail(result);
            stepResult(result);

        // Handle missing Meta tag
        } else {
            System.out.println(yellow + "[Warn]: Invalid formatting of test result '" + result + "' which should contain either '[Pass]' or '[Fail]'." + reset);
            Assertions.fail("[Warn]: Invalid formatting of test result '" + result + "' which should contain either '[Pass]' or '[Fail]'.");
            stepResult(result);
        }
    }

    /**
     * The stepResult method is used to sent the step details to the Allure report and listener.
     * @param result
     */
    @Step("Step result: {0}")
    private static void stepResult(String result) {
        // Handle step result
    }

}