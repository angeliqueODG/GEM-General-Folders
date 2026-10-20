package framework.utilities;
/**
 * @file FW_ScreenUtils.java
 * @description Provides utility methods for taking screenshots.
 * 
 * This file contains the FW_ScreenUtils class which provides utility functions for taking screenshots.
 * It includes functionalities to take a screenshot of the current page and trim the image.
 * 
 * The FW_ScreenUtils class offers functionalities to:
 * - Take a screenshot of the current page.
 * - Trim the image.
 * 
 * This class is designed to provide utility methods for taking screenshots.
 */

// Selenium WebDriver
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

// Automation framework
import framework.image.FW_Image;

// Java file I/O
import java.io.ByteArrayInputStream;
import java.io.IOException;

// Image manipulation (Note these often show up as red in VSCode, but they are valid)
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

/**
 * This class provides utility methods for taking screenshots.
 */
public class FW_ScreenUtils {

    /**
     * Takes a screenshot of the current page and saves it to the specified directory returning an image object.
     * 
     * @param driver
     * @param fileNameReference
     * @param screenshotDestinationDirectoryPath
     * 
     * @return An FW_Image object.
     */
    public static FW_Image takeScreenshot(WebDriver driver, String fileNameReference, String screenshotDestinationDirectoryPath) {

        // Get a screenshot image object
        FW_Image screenshotImageObj = FW_ScreenUtils.getScreenshotImage(driver, fileNameReference, screenshotDestinationDirectoryPath);
        
        // Record screenshot in Allure
        screenshotImageObj = FW_ReportUtils.recordScreenshotToAllure(screenshotImageObj);

        return screenshotImageObj;
    }


    /**
     * Takes a screenshot of the current page and retunr an FW_Image object.
     *
     * @param driver The WebDriver object.
     * @param fileNameReference The name of the screenshot.
     * @param screenshotDestinationDirectoryPath The directory to save the screenshot.
     * 
     * @return An FW_Image object.
     */
    public static FW_Image getScreenshotImage(WebDriver driver, String fileNameReference, String screenshotDestinationDirectoryPath) {

        // Check if driver is null
        if (driver == null) {
            // Get the class and method that made the call
            StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
            StackTraceElement caller = stackTraceElements[2]; // The caller is at index 2
            String callingClass = caller.getClassName();
            String callingMethod = caller.getMethodName();

            // Return the error message
            System.out.println(FW_ConsoleColors.ORANGE + "[Warn] - Framework error encountered, driver parameter was null. Check called code '" + callingClass + "." + callingMethod + "'." + FW_ConsoleColors.RESET);
        }

        // Get the Screen Capture options from testConfig.properties

        // Get the project directory path - e.g. /Users/gregpaskal/Documents/Development/Automation/Automation-Projects/Automation-JAV-SwagLabs
        String projectDirectoryPath = FW_SystemUtils.pathPresentDirectory();
        projectDirectoryPath = projectDirectoryPath.endsWith("/") ? projectDirectoryPath : projectDirectoryPath + "/";

        // Build screenshot destination directory path excluding the file name
        screenshotDestinationDirectoryPath = projectDirectoryPath + screenshotDestinationDirectoryPath;
        screenshotDestinationDirectoryPath = screenshotDestinationDirectoryPath.endsWith("/") ? screenshotDestinationDirectoryPath : screenshotDestinationDirectoryPath + "/";

        // Check and create the new screenshot directory if not exists
        if (FW_FileDirUtils.fileExists(screenshotDestinationDirectoryPath) == false) {
            FW_FileDirUtils.createDirectory(screenshotDestinationDirectoryPath);
        }

        // Determine final filename extension based on imageConversionToJPG setting
        String finalFilenameExtension = ".png";
        if (FW_ConfigMgr.getImageConversionToJPG().toLowerCase().contains("true")) {
            finalFilenameExtension = ".jpg";
        }

        // Create file name with timestamp and extension
        final String fileName = fileNameReference + "_" + System.currentTimeMillis() + finalFilenameExtension;

        // Initialize the screenshot taker
        TakesScreenshot screenshotTaker = (TakesScreenshot) driver;

        // Throw an exception if the screenshot taker is not initialized
        if (screenshotTaker == null) {
            throw new IllegalStateException("Screenshot taker is not initialized.");
        }

        // Create an instance of the FW_Image class
        FW_Image screenshotImageObj = null;

        try {

            // Take the screenshot and store it as a byte array
            byte[] screenshotByteArray = screenshotTaker.getScreenshotAs(OutputType.BYTES);

            // Convert the byte array into a BufferedImage
            BufferedImage screenshotBufferedImage = ImageIO.read(new ByteArrayInputStream(screenshotByteArray));

            // Create an instance of FW_Image
            screenshotImageObj = new FW_Image(fileName, screenshotDestinationDirectoryPath, "", screenshotBufferedImage);

            // Ensure the image has an alpha channel
            screenshotImageObj = FW_ImageUtils.addAlphaChannel(screenshotImageObj);

            // Trim the buffered image
            if (FW_ConfigMgr.getImageTrim().toLowerCase().contains("true")) {
                screenshotImageObj = FW_ImageUtils.trimImage(screenshotImageObj);
            }

            // What file type to save as
            if (FW_ConfigMgr.getImageConversionToJPG().toLowerCase().contains("true")) {
                // Save as JPG
                String imageNameJPG = fileName;
                screenshotImageObj = FW_ImageUtils.saveImageAsJPG(screenshotImageObj, imageNameJPG, screenshotDestinationDirectoryPath, FW_ConfigMgr.getImageCompressionJPGQuality());
            } else {
                // Save as PNG
                String imageNamePNG = fileName;
                screenshotImageObj = FW_ImageUtils.saveImageAsPNG(screenshotImageObj, imageNamePNG, screenshotDestinationDirectoryPath);
            }
        
        } catch (IOException e) {
            System.out.println(FW_ConsoleColors.YELLOW + "[" + FW_DebugUtils.getClassName() + " - " + FW_DebugUtils.getMethodName() + "] - Error encountered while taking screenshot." + FW_ConsoleColors.RESET);
        }

        System.out.println(FW_ConsoleColors.BROWN + "[Screenshot] - " + fileName + FW_ConsoleColors.RESET);

        // Return the FW_Image object
        return screenshotImageObj;
    }
}
