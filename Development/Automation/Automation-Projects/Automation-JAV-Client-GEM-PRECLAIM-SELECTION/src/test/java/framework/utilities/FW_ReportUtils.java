package framework.utilities;
/**
 * @file FW_ReportUtils.java
 * @description Provides utility methods related to reporting.
 * 
 * This file contains the FW_ReportUtils class which provides utility functions for reporting purposes.
 * It includes functionalities to record notes, derive test step state, print messages, and print test run metrics.
 * 
 * The FW_ReportUtils class offers functionalities to:
 * - Record notes.
 * - Derive test step state.
 * - Print messages.
 * - Print test run metrics.
 * 
 * This class is designed to provide utility methods for reporting purposes.
 */

// Automation framework
import framework.reporting.FW_AllureAnnotationNote;
import framework.reporting.FW_AllureAnnotationStepScreenShot;
import framework.junit.FW_TestRunTracker;
import framework.image.FW_Image;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

// Automation Reporting
import io.qameta.allure.Allure;
import io.qameta.allure.model.Status;

/**
 * This class provides utility methods related to reporting.
 */
public class FW_ReportUtils {

    /**
     * Attach screenshot to the Allure report and return the screenshot image object.
     * 
     * @param screenshotImageObj The screenshot image object
     * 
     * @return The screenshot image object
     * 
     */
    @FW_AllureAnnotationStepScreenShot("Screenshot: {0}")
    public static FW_Image recordScreenshotToAllure(FW_Image screenshotImageObj) {

        String fileName = screenshotImageObj.getImageName() + "." + screenshotImageObj.getImageType();
        String filePath = screenshotImageObj.getImageStoredFilepath() + fileName;
        String imageType = screenshotImageObj.getImageType();

        // Set screenshot context for the Allure reporting
        Allure.step("Screenshot: " + fileName, () -> {

            // Attach the screenshot to the Allure report
            try {
                if (imageType.toLowerCase().contains("jpg")) {
                    Allure.addAttachment("Screenshot: " + fileName, "image/jpg", Files.newInputStream(Paths.get(filePath)), ".jpg");
                } else {
                    Allure.addAttachment("Screenshot: " + fileName, "image/png", Files.newInputStream(Paths.get(filePath)), ".png");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        return screenshotImageObj;
    }

    /**
     * Record note.
     *
     * @param note The note to record
     */
    @FW_AllureAnnotationNote("Note: {0}")
    public static void recordNoteToAllure(String note) {
        note = note.toString();
        System.out.println(FW_ConsoleColors.YELLOW + "[Note] - " + note + FW_ConsoleColors.RESET);
        // Attach the note to the Allure report
        Allure.step("Note: " + note, Status.BROKEN); // BROKEN status is used for notes in Allure as it represents the color yellow.
    }

    /**
     * Derive the test step state based on the time taken to execute the test step.
     *
     * @param startingTime The time when the test step started
     * @param actualTime The actual time at the moment of the test step state determination
     * @param timeout The timeout for the test step to complete
     * @param timeoutWarnThreshold The threshold percentage of the timeout to consider the test step as a warning
     * 
     * @return The determined result of [Pass], [Pass Warn], or [Fail]
     */
    public static String getTestStepState(long startingTime, long actualTime, int timeout, int timeoutWarnThreshold) {
        long timeTaken = actualTime - startingTime;
        if (timeTaken <= timeout) {
            if (timeTaken <= timeout * timeoutWarnThreshold / 100.0) {
                return "[Pass]";
            } else {
                return "[Pass Warn]";
            }
        } else {
            return "[Fail]";
        }
    }

    /**
     * Prints a message to the console.
     *
     * @param message The message to print
     */
    public static void printMessage(String message) {
        System.out.println(message);
    }

    /**
     * Prints all the metrics tracked by FW_TestRunTracker.
     */
    public static void printTestRunMetrics() {
        FW_TestRunTracker tracker = FW_TestRunTracker.getInstance();
        tracker.printMetrics();
    }

}