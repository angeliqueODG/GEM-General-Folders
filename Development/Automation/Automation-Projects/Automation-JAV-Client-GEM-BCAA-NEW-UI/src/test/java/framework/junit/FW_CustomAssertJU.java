package framework.junit;

// Selenium WebDriver
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

import framework.data.FW_TestStepDataCollector;
import framework.image.FW_Image;
import framework.junit.FW_TestStep.TestStepType;
import framework.reporting.FW_AllureAnnotationStepFail;
import framework.reporting.FW_AllureAnnotationStepPass;
import framework.reporting.FW_AllureAnnotationStepPassWarnCritical;
import framework.reporting.FW_AllureAnnotationStepPassWarnHigh;
import framework.reporting.FW_AllureAnnotationStepPassWarnLow;
import framework.reporting.FW_AllureAnnotationStepPassWarnMedium;
import framework.utilities.FW_ConfigMgr;
import framework.utilities.FW_ConsoleColors;
import framework.utilities.FW_ImageUtils;
import framework.utilities.FW_ReportUtils;
import framework.utilities.FW_ScreenUtils;
import framework.utilities.FW_TestStepUtils;
import io.qameta.allure.Allure;

/**
 * @file FW_CustomAssertJU.java
 * @description Provides custom assertions for the automation framework using JUnit.
 * 
 * This file contains the FW_CustomAssertJU class which provides custom assertions specific to the automation framework utilizing JUnit.
 * It includes functionalities to assert test step results, handle different pass and fail conditions, and integrate with Allure reporting.
 * 
 * The FW_CustomAssertJU class offers functionalities to:
 * - Assert test step results and handle pass and fail conditions.
 * - Integrate with Allure reporting for detailed test step results.
 * - Capture screenshots based on test step results.
 * 
 * This class is designed to enhance the assertion capabilities of the automation framework, providing detailed and customizable
 * assertions for test steps.
 * 
 * @version 1.0
 * @since 2025-01-09
 */
public class FW_CustomAssertJU {

    /**
     * Default constructor.
     */
    public FW_CustomAssertJU() {
        // Default constructor
    }

    // Declare WebDriver instance at class level
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    /**
     * Sets the WebDriver instance.
     * 
     * @param driverInstance the WebDriver instance to set
     */
    public static void setDriver(WebDriver driverInstance) {
        driver.set(driverInstance);
    }

    /**
     * Returns the WebDriver instance.
     * 
     * @return the WebDriver instance
     */
    public static WebDriver getDriver() {
        return driver.get();
    }

    /**
     * Asserts that the given result string contains either "[Pass]" or "[Fail]".
     * If the result is null, the test fails immediately.
     * If the result contains "[Pass]", the test passes.
     * If the result contains "[Fail]", the test fails.
     * If the result contains neither "[Pass]" nor "[Fail]", the test fails with a warning about invalid formatting.
     *
     * @param result the result string to check
     * @return the result passed into the method
     */
    public static String autoPass(Object testStep) {

        // Setup inital variables
        String result; // Used for final result string
        FW_TestStep testStepObj; // A copy of the testStep data to be used across this method.
        
        // Assess the testStep type - Begin
        if (testStep instanceof String) {

            String resultCombined = (String) testStep;

            // Transform the result string into a FW_TestStep object
            testStepObj = FW_TestStepUtils.createTestStep(resultCombined, Thread.currentThread(), TestStepType.UNKNOWN.getValue());

            // Record to the terminal that this test step needs to be configured for a testStepObj
            System.out.println(FW_ConsoleColors.YELLOW + "[Warn]: The test step '" + testStep + "' requires your attention." + FW_ConsoleColors.RESET);
            System.out.println(FW_ConsoleColors.YELLOW + "Review the page object'" + testStep + "' and ensure it's configured correctly." + FW_ConsoleColors.RESET);
            System.out.println(FW_ConsoleColors.YELLOW + "Outdated code will look like 'result = FW_StringUtils.metaInsert(result, getClass().getSimpleName());'" + FW_ConsoleColors.RESET);
            System.out.println(FW_ConsoleColors.YELLOW + "Should be replaced with 'FW_TestStep resultObj = FW_TestStepUtils.createTestStep(result, Thread.currentThread(), TestStepType.TBD.getValue());'" + FW_ConsoleColors.RESET);

        // testStep is an instance of the FW_testStep object
        } else if (testStep instanceof FW_TestStep) {
            // Copy to the testStepObj variable
            testStepObj = (FW_TestStep) testStep;
        } else {
            throw new IllegalArgumentException("Unsupported input type: " + testStep.getClass().getName());
        }
        // Assess the testStep type - End

        // Create a combined result string based on available data
        if (testStepObj.getTestStepDurationMS() > 0) {
            result = "[" + testStepObj.getTestStepResult() + "] - {" + testStepObj.getTestStepDurationHR() + "} - " + testStepObj.getTestStepResultDetails();
        } else {
            result = "[" + testStepObj.getTestStepResult() + "] - " + testStepObj.getTestStepResultDetails();
        }

        // Get a testRunTracker instance
        FW_TestRunTracker testRunTracker = FW_TestRunTracker.getInstance();

        // Increment the completed test steps
        testRunTracker.incrementTestStepsCompleted();

        // Decrement the remaining test steps
        testRunTracker.decrementTestStepsRemaining();

        // Handle null result
        if (testStepObj.getTestStepResult() == null) {
            testStepObj.setTestStepResult("[Fail]: Result is null.");
            stepFail(testStepObj.getTestStepResult(), testStepObj, testRunTracker);
            return testStepObj.getTestStepResult();
        }

        // Handle [Audit Pass] result
        if (testStepObj.getTestStepResult().toUpperCase().contains("AUDIT PASS")) {
            System.out.println(FW_ConsoleColors.GREEN + result + FW_ConsoleColors.RESET);
            Assertions.assertTrue(true);

        // Handle [Audit Fail] result
        } else if (testStepObj.getTestStepResult().toUpperCase().contains("AUDIT FAIL")) {
            System.out.println(FW_ConsoleColors.RED + result + FW_ConsoleColors.RESET);
            Assertions.fail(result);

        // Handle [Pass] result
        } else if (testStepObj.getTestStepResult().toUpperCase().contains("PASS")) {
            stepPass(result, testStepObj, testRunTracker);

        // Handle [Pass Warn - Low] result
        } else if (testStepObj.getTestStepResult().toUpperCase().contains("PASS WARN - LOW")) {
            stepPassWarnLow(result, testStepObj, testRunTracker);

        // Handle [Pass Warn - Medium] result
        } else if (testStepObj.getTestStepResult().toUpperCase().contains("PASS WARN - MEDIUM")) {
            stepPassWarnMedium(result, testStepObj, testRunTracker);

        // Handle [Pass Warn - High] result
        } else if (testStepObj.getTestStepResult().toUpperCase().contains("PASS WARN - HIGH")) {
            stepPassWarnHigh(result, testStepObj, testRunTracker);

        // Handle [Pass Warn - Critical] result
        } else if (testStepObj.getTestStepResult().toUpperCase().contains("PASS WARN - CRITICAL")) {
            stepPassWarnCritical(result, testStepObj, testRunTracker);

        // Handle [Fail] result
        } else if (testStepObj.getTestStepResult().toUpperCase().contains("FAIL")) {
            stepFail(result, testStepObj, testRunTracker);

        // Handle [Shot] result
        } else if (testStepObj.getTestStepResult().toUpperCase().contains("SHOT")) {
            stepScreenshot(result, testStepObj, testRunTracker);

        // Handle [Note] result
        } else if (testStepObj.getTestStepResult().toUpperCase().contains("NOTE")) {
            stepNote(result, testStepObj, testRunTracker);

        // Handle missing Meta tag
        } else {
            System.out.println(FW_ConsoleColors.YELLOW + "[Warn]: Invalid formatting of test result '" + testStepObj.getTestStepResult() + "' which should contain either '[Pass]' or '[Fail]'." + FW_ConsoleColors.RESET);
            Assertions.fail("[Warn]: Invalid step result '[" + testStepObj.getTestStepResult() + "]', please review.");
        }
        return result;
    }

    /**
     * The stepPass method is used to send the pass step details to the Allure report and listener.
     * 
     * @param result the result string to be reported
     */
    @FW_AllureAnnotationStepPass("Step: {0}")
    private static void stepPass(String result, FW_TestStep testStepObj, FW_TestRunTracker testRunTracker) {
        System.out.println(FW_ConsoleColors.GREEN + result + FW_ConsoleColors.RESET);

        // Update the testRun with the updated testStep result
        testStepObj = FW_TestStepUtils.updateTestStepResult(testRunTracker.getTestRun(),testStepObj);

        // Update the testStepsPassed count
        testRunTracker.incrementTestStepsPassed();

        // Make a copy of testStepObj due to lambda expression below
        FW_TestStep finalTestStepObj = testStepObj;

        // Set pass context for the Allure reporting
        Allure.step("Step: " + result, () -> {

            // Take a screenshot if screenCaptureOnTestStepResults = true and screenCaptureOnTestStepResultsSelection = pass
            if (FW_ConfigMgr.getScreenCaptureOnTestStepResults().toLowerCase().contains("true")) {
                if (FW_ConfigMgr.getScreenCaptureOnTestStepResultsSelection().toLowerCase().contains("pass")) {

                    FW_Image screenshotImageObj = FW_ScreenUtils.takeScreenshot(getDriver(), "Pass", FW_ConfigMgr.getScreenCaptureOutputPath());
                
                    // Add screenshot details to testStepObj testStepScreenshotRef
                    String screenshotRef = FW_ConfigMgr.getGoogleCloudStorageBaseURL() + FW_ConfigMgr.getGoogleCloudStorageBucket() + "/" + screenshotImageObj.getImageName() + "." + screenshotImageObj.getImageType();
                    finalTestStepObj.setTestStepScreenshotRef(screenshotRef);

                    // Generate a thumbnail of the screenshot
                    FW_Image screenshotThumbImageObj = FW_ImageUtils.scaleImage(screenshotImageObj, FW_ConfigMgr.getImageThumbnailMaxSize(), FW_ConfigMgr.getImageThumbnailMaxSize());

                    // Add screenshot thumbnail details to testStepObj testStepScreenshotRef
                    String imageNameThumb = screenshotThumbImageObj.getImageName() + "_Thumb" + "." + screenshotThumbImageObj.getImageType();
                    String screenshotThumbGoogleRef = FW_ConfigMgr.getGoogleCloudStorageBaseURL() + FW_ConfigMgr.getGoogleCloudStorageBucket() + "/" + imageNameThumb;
                    finalTestStepObj.setTestStepScreenshotThumbRef(screenshotThumbGoogleRef);

                    // Based on if the image conversion to JPG is enabled, save the image as PNG or JPG with the specified quality
                    if (FW_ConfigMgr.getImageConversionToJPG().equalsIgnoreCase("true")) {
                        FW_ImageUtils.saveImageAsJPG(screenshotThumbImageObj, imageNameThumb, FW_ConfigMgr.getScreenCaptureOutputPath(), FW_ConfigMgr.getImageThumbnailCompressionJPGQuality());
                    } else {
                        FW_ImageUtils.saveImageAsPNG(screenshotThumbImageObj, imageNameThumb, FW_ConfigMgr.getScreenCaptureOutputPath());
                    }
                }
            }
            // Feed the testStepObj into the data collector
            FW_TestStepDataCollector.collect(finalTestStepObj);

            Assertions.assertTrue(true); // Pass the step
        });
    }

    /**
     * The stepPassWarnLow method is used to send the details to the Allure report and listener.
     * 
     * @param result the result string to be reported
     */
    @FW_AllureAnnotationStepPassWarnLow("Step: {0}")
    private static void stepPassWarnLow(String result, FW_TestStep testStepObj, FW_TestRunTracker testRunTracker) {
        System.out.println(FW_ConsoleColors.GREENYELLOW + result + FW_ConsoleColors.RESET);

        // Update the testRun with the updated testStep result
        testStepObj = FW_TestStepUtils.updateTestStepResult(testRunTracker.getTestRun(),testStepObj);

        // Update the testStepsPassed count
        testRunTracker.incrementTestStepsPassed();

        // Make a copy of testStepObj due to lambda expression below
        FW_TestStep finalTestStepObj = testStepObj;

        // Set pass context for the Allure reporting
        Allure.step("Step: " + result, () -> {

            // Take a screenshot if screenCaptureOnTestStepResults = true and screenCaptureOnTestStepResultsSelection = warnlow
            if (FW_ConfigMgr.getScreenCaptureOnTestStepResults().toLowerCase().contains("true")) {
                if (FW_ConfigMgr.getScreenCaptureOnTestStepResultsSelection().toLowerCase().contains("warnlow")) {

                    FW_Image screenshotImageObj = FW_ScreenUtils.takeScreenshot(getDriver(), "Pass-Warn-Low", FW_ConfigMgr.getScreenCaptureOutputPath());
                
                    // Add screenshot details to testStepObj testStepScreenshotRef
                    String screenshotRef = FW_ConfigMgr.getGoogleCloudStorageBaseURL() + FW_ConfigMgr.getGoogleCloudStorageBucket() + "/" + screenshotImageObj.getImageName() + "." + screenshotImageObj.getImageType();
                    finalTestStepObj.setTestStepScreenshotRef(screenshotRef);

                    // Generate a thumbnail of the screenshot
                    FW_Image screenshotThumbImageObj = FW_ImageUtils.scaleImage(screenshotImageObj, FW_ConfigMgr.getImageThumbnailMaxSize(), FW_ConfigMgr.getImageThumbnailMaxSize());

                    // Add screenshot thumbnail details to testStepObj testStepScreenshotRef
                    String imageNameThumb = screenshotThumbImageObj.getImageName() + "_Thumb" + "." + screenshotThumbImageObj.getImageType();
                    String screenshotThumbGoogleRef = FW_ConfigMgr.getGoogleCloudStorageBaseURL() + FW_ConfigMgr.getGoogleCloudStorageBucket() + "/" + imageNameThumb;
                    finalTestStepObj.setTestStepScreenshotThumbRef(screenshotThumbGoogleRef);

                    // Based on if the image conversion to JPG is enabled, save the image as PNG or JPG with the specified quality
                    if (FW_ConfigMgr.getImageConversionToJPG().equalsIgnoreCase("true")) {
                        FW_ImageUtils.saveImageAsJPG(screenshotThumbImageObj, imageNameThumb, FW_ConfigMgr.getScreenCaptureOutputPath(), FW_ConfigMgr.getImageThumbnailCompressionJPGQuality());
                    } else {
                        FW_ImageUtils.saveImageAsPNG(screenshotThumbImageObj, imageNameThumb, FW_ConfigMgr.getScreenCaptureOutputPath());
                    }
                }
            }
            // Feed the testStepObj into the data collector
            FW_TestStepDataCollector.collect(finalTestStepObj);

            Assertions.assertTrue(true); // Pass the step
        });
    }

    /**
     * The stepPassWarnMedium method is used to send the details to the Allure report and listener.
     * 
     * @param result the result string to be reported
     */
    @FW_AllureAnnotationStepPassWarnMedium("Step: {0}")
    private static void stepPassWarnMedium(String result, FW_TestStep testStepObj, FW_TestRunTracker testRunTracker) {
        System.out.println(FW_ConsoleColors.YELLOW + result + FW_ConsoleColors.RESET);

        // Update the testRun with the updated testStep result
        testStepObj = FW_TestStepUtils.updateTestStepResult(testRunTracker.getTestRun(),testStepObj);

        // Update the testStepsPassed count
        testRunTracker.incrementTestStepsPassed();

        // Make a copy of testStepObj due to lambda expression below
        FW_TestStep finalTestStepObj = testStepObj;

        // Set pass context for the Allure reporting
        Allure.step("Step: " + result, () -> {

            // Take a screenshot if screenCaptureOnTestStepResults = true and screenCaptureOnTestStepResultsSelection = warnmedium
            if (FW_ConfigMgr.getScreenCaptureOnTestStepResults().toLowerCase().contains("true")) {
                if (FW_ConfigMgr.getScreenCaptureOnTestStepResultsSelection().toLowerCase().contains("warnmedium")) {

                    FW_Image screenshotImageObj = FW_ScreenUtils.takeScreenshot(getDriver(), "Pass-Warn-Medium", FW_ConfigMgr.getScreenCaptureOutputPath());
                
                    // Add screenshot details to testStepObj testStepScreenshotRef
                    String screenshotRef = FW_ConfigMgr.getGoogleCloudStorageBaseURL() + FW_ConfigMgr.getGoogleCloudStorageBucket() + "/" + screenshotImageObj.getImageName() + "." + screenshotImageObj.getImageType();
                    finalTestStepObj.setTestStepScreenshotRef(screenshotRef);

                    // Generate a thumbnail of the screenshot
                    FW_Image screenshotThumbImageObj = FW_ImageUtils.scaleImage(screenshotImageObj, FW_ConfigMgr.getImageThumbnailMaxSize(), FW_ConfigMgr.getImageThumbnailMaxSize());

                    // Add screenshot thumbnail details to testStepObj testStepScreenshotRef
                    String imageNameThumb = screenshotThumbImageObj.getImageName() + "_Thumb" + "." + screenshotThumbImageObj.getImageType();
                    String screenshotThumbGoogleRef = FW_ConfigMgr.getGoogleCloudStorageBaseURL() + FW_ConfigMgr.getGoogleCloudStorageBucket() + "/" + imageNameThumb;
                    finalTestStepObj.setTestStepScreenshotThumbRef(screenshotThumbGoogleRef);

                    // Based on if the image conversion to JPG is enabled, save the image as PNG or JPG with the specified quality
                    if (FW_ConfigMgr.getImageConversionToJPG().equalsIgnoreCase("true")) {
                        FW_ImageUtils.saveImageAsJPG(screenshotThumbImageObj, imageNameThumb, FW_ConfigMgr.getScreenCaptureOutputPath(), FW_ConfigMgr.getImageThumbnailCompressionJPGQuality());
                    } else {
                        FW_ImageUtils.saveImageAsPNG(screenshotThumbImageObj, imageNameThumb, FW_ConfigMgr.getScreenCaptureOutputPath());
                    }
                }
            }

            // Feed the testStepObj into the data collector
            FW_TestStepDataCollector.collect(finalTestStepObj);

            Assertions.assertTrue(true); // Pass the step
        });
    }

    /**
     * The stepPassWarnHigh method is used to send the details to the Allure report and listener.
     * 
     * @param result the result string to be reported
     */
    @FW_AllureAnnotationStepPassWarnHigh("Step: {0}")
    private static void stepPassWarnHigh(String result, FW_TestStep testStepObj, FW_TestRunTracker testRunTracker) {
        System.out.println(FW_ConsoleColors.ORANGE + result + FW_ConsoleColors.RESET);

        // Update the testRun with the updated testStep result
        testStepObj = FW_TestStepUtils.updateTestStepResult(testRunTracker.getTestRun(),testStepObj);

        // Update the testStepsPassed count
        testRunTracker.incrementTestStepsPassed();

        // Make a copy of testStepObj due to lambda expression below
        FW_TestStep finalTestStepObj = testStepObj;

        // Set pass context for the Allure reporting
        Allure.step("Step: " + result, () -> {

            // Take a screenshot if screenCaptureOnTestStepResults = true and screenCaptureOnTestStepResultsSelection = warnhigh
            if (FW_ConfigMgr.getScreenCaptureOnTestStepResults().toLowerCase().contains("true")) {
                if (FW_ConfigMgr.getScreenCaptureOnTestStepResultsSelection().toLowerCase().contains("warnhigh")) {

                    FW_Image screenshotImageObj = FW_ScreenUtils.takeScreenshot(getDriver(), "Pass-Warn-High", FW_ConfigMgr.getScreenCaptureOutputPath());
                    
                    // Add screenshot details to testStepObj testStepScreenshotRef
                    String screenshotRef = FW_ConfigMgr.getGoogleCloudStorageBaseURL() + FW_ConfigMgr.getGoogleCloudStorageBucket() + "/" + screenshotImageObj.getImageName() + "." + screenshotImageObj.getImageType();
                    finalTestStepObj.setTestStepScreenshotRef(screenshotRef);

                    // Generate a thumbnail of the screenshot
                    FW_Image screenshotThumbImageObj = FW_ImageUtils.scaleImage(screenshotImageObj, FW_ConfigMgr.getImageThumbnailMaxSize(), FW_ConfigMgr.getImageThumbnailMaxSize());

                    // Add screenshot thumbnail details to testStepObj testStepScreenshotRef
                    String imageNameThumb = screenshotThumbImageObj.getImageName() + "_Thumb" + "." + screenshotThumbImageObj.getImageType();
                    String screenshotThumbGoogleRef = FW_ConfigMgr.getGoogleCloudStorageBaseURL() + FW_ConfigMgr.getGoogleCloudStorageBucket() + "/" + imageNameThumb;
                    finalTestStepObj.setTestStepScreenshotThumbRef(screenshotThumbGoogleRef);

                    // Based on if the image conversion to JPG is enabled, save the image as PNG or JPG with the specified quality
                    if (FW_ConfigMgr.getImageConversionToJPG().equalsIgnoreCase("true")) {
                        FW_ImageUtils.saveImageAsJPG(screenshotThumbImageObj, imageNameThumb, FW_ConfigMgr.getScreenCaptureOutputPath(), FW_ConfigMgr.getImageThumbnailCompressionJPGQuality());
                    } else {
                        FW_ImageUtils.saveImageAsPNG(screenshotThumbImageObj, imageNameThumb, FW_ConfigMgr.getScreenCaptureOutputPath());
                    }
                }
            }

            // Feed the testStepObj into the data collector
            FW_TestStepDataCollector.collect(finalTestStepObj);

            Assertions.assertTrue(true); // Pass the step
        });
    }

    /**
     * The stepPassWarnCritical method is used to send the details to the Allure report and listener.
     * 
     * @param result the result string to be reported
     */
    @FW_AllureAnnotationStepPassWarnCritical("Step: {0}")
    private static void stepPassWarnCritical(String result, FW_TestStep testStepObj, FW_TestRunTracker testRunTracker) {
        System.out.println(FW_ConsoleColors.CORAL + result + FW_ConsoleColors.RESET);

        // Update the testRun with the updated testStep result
        testStepObj = FW_TestStepUtils.updateTestStepResult(testRunTracker.getTestRun(),testStepObj);

        // Update the testStepsPassed count
        testRunTracker.incrementTestStepsPassed();

        // Make a copy of testStepObj due to lambda expression below
        FW_TestStep finalTestStepObj = testStepObj;

        // Set pass context for the Allure reporting
        Allure.step("Step: " + result, () -> {

            // Take a screenshot if screenCaptureOnTestStepResults = true and screenCaptureOnTestStepResultsSelection = warncritical
            if (FW_ConfigMgr.getScreenCaptureOnTestStepResults().toLowerCase().contains("true")) {
                if (FW_ConfigMgr.getScreenCaptureOnTestStepResultsSelection().toLowerCase().contains("warncritical")) {

                    FW_Image screenshotImageObj = FW_ScreenUtils.takeScreenshot(getDriver(), "Pass-Warn-Critical", FW_ConfigMgr.getScreenCaptureOutputPath());
                
                    // Add screenshot details to testStepObj testStepScreenshotRef
                    String screenshotRef = FW_ConfigMgr.getGoogleCloudStorageBaseURL() + FW_ConfigMgr.getGoogleCloudStorageBucket() + "/" + screenshotImageObj.getImageName() + "." + screenshotImageObj.getImageType();
                    finalTestStepObj.setTestStepScreenshotRef(screenshotRef);

                    // Generate a thumbnail of the screenshot
                    FW_Image screenshotThumbImageObj = FW_ImageUtils.scaleImage(screenshotImageObj, FW_ConfigMgr.getImageThumbnailMaxSize(), FW_ConfigMgr.getImageThumbnailMaxSize());

                    // Add screenshot thumbnail details to testStepObj testStepScreenshotRef
                    String imageNameThumb = screenshotThumbImageObj.getImageName() + "_Thumb" + "." + screenshotThumbImageObj.getImageType();
                    String screenshotThumbGoogleRef = FW_ConfigMgr.getGoogleCloudStorageBaseURL() + FW_ConfigMgr.getGoogleCloudStorageBucket() + "/" + imageNameThumb;
                    finalTestStepObj.setTestStepScreenshotThumbRef(screenshotThumbGoogleRef);

                    // Based on if the image conversion to JPG is enabled, save the image as PNG or JPG with the specified quality
                    if (FW_ConfigMgr.getImageConversionToJPG().equalsIgnoreCase("true")) {
                        FW_ImageUtils.saveImageAsJPG(screenshotThumbImageObj, imageNameThumb, FW_ConfigMgr.getScreenCaptureOutputPath(), FW_ConfigMgr.getImageThumbnailCompressionJPGQuality());
                    } else {
                        FW_ImageUtils.saveImageAsPNG(screenshotThumbImageObj, imageNameThumb, FW_ConfigMgr.getScreenCaptureOutputPath());
                    }
                }
            }
            
            // Feed the testStepObj into the data collector
            FW_TestStepDataCollector.collect(finalTestStepObj);

            Assertions.assertTrue(true); // Pass the step
        });
    }

    /**
     * The stepFail method is used to send the step details to the Allure report and listener.
     * 
     * @param result the result string to be reported
     */
    @FW_AllureAnnotationStepFail("Step: {0}")
    private static void stepFail(String result, FW_TestStep testStepObj, FW_TestRunTracker testRunTracker) {
        System.out.println(FW_ConsoleColors.RED + result + FW_ConsoleColors.RESET);

        // Update the testRun with the updated testStep result
        testStepObj = FW_TestStepUtils.updateTestStepResult(testRunTracker.getTestRun(),testStepObj);

        // Update the testStepsFailed count
        testRunTracker.incrementTestStepsFailed();

        // Make a copy of testStepObj due to lambda expression below
        FW_TestStep finalTestStepObj = testStepObj;

        // Set fail context for the Allure reporting
        Allure.step("Step: " + result, () -> {

            // Take a screenshot if screenCaptureOnTestStepResults = true and screenCaptureOnTestStepResultsSelection = fail
            if (FW_ConfigMgr.getScreenCaptureOnTestStepResults().toLowerCase().contains("true")) {
                if (FW_ConfigMgr.getScreenCaptureOnTestStepResultsSelection().toLowerCase().contains("fail")) {

                    // Take screenshot
                    FW_Image screenshotImageObj = FW_ScreenUtils.takeScreenshot(getDriver(), "Fail", FW_ConfigMgr.getScreenCaptureOutputPath());

                    // Add screenshot details to testStepObj testStepScreenshotRef
                    String screenshotRef = FW_ConfigMgr.getGoogleCloudStorageBaseURL() + FW_ConfigMgr.getGoogleCloudStorageBucket() + "/" + screenshotImageObj.getImageName() + "." + screenshotImageObj.getImageType();
                    finalTestStepObj.setTestStepScreenshotRef(screenshotRef);

                    // Generate a thumbnail of the screenshot
                    FW_Image screenshotThumbImageObj = FW_ImageUtils.scaleImage(screenshotImageObj, FW_ConfigMgr.getImageThumbnailMaxSize(), FW_ConfigMgr.getImageThumbnailMaxSize());

                    // Add screenshot thumbnail details to testStepObj testStepScreenshotRef
                    String imageNameThumb = screenshotThumbImageObj.getImageName() + "_Thumb" + "." + screenshotThumbImageObj.getImageType();
                    String screenshotThumbGoogleRef = FW_ConfigMgr.getGoogleCloudStorageBaseURL() + FW_ConfigMgr.getGoogleCloudStorageBucket() + "/" + imageNameThumb;
                    finalTestStepObj.setTestStepScreenshotThumbRef(screenshotThumbGoogleRef);

                    // Based on if the image conversion to JPG is enabled, save the image as PNG or JPG with the specified quality
                    if (FW_ConfigMgr.getImageConversionToJPG().equalsIgnoreCase("true")) {
                        FW_ImageUtils.saveImageAsJPG(screenshotThumbImageObj, imageNameThumb, FW_ConfigMgr.getScreenCaptureOutputPath(), FW_ConfigMgr.getImageThumbnailCompressionJPGQuality());
                    } else {
                        FW_ImageUtils.saveImageAsPNG(screenshotThumbImageObj, imageNameThumb, FW_ConfigMgr.getScreenCaptureOutputPath());
                    }
                }
            }

            // Feed the testStepObj into the data collector
            FW_TestStepDataCollector.collect(finalTestStepObj);

            // Record the remaining test steps that were not executed due to early failure
            FW_TestStep[] testSteps = FW_TestStepUtils.getTestSteps(testRunTracker.getTestRun(), finalTestStepObj);
            for (FW_TestStep testStep : testSteps) {
                if (testStep.getTestStepExecuted() == false) {

                    // Set necessary details for the skipped test step
                    testStep.setTestStepResult("Skip");
                    testStep.setTestStepResultDetails("Step not executed due to early failure at test step " + finalTestStepObj.getTestStepRefOrder());

                    // Feed the testStep into the data collector
                    FW_TestStepDataCollector.collect(testStep);
                }
            }

            Assertions.fail(result); // Fail the test
        });
    }

    /**
     * The stepScreenshot method is used to send the step details to the Allure report and listener.
     * 
     * @param result the result string to be reported
     */
    private static void stepScreenshot(String result, FW_TestStep testStepObj, FW_TestRunTracker testRunTracker) {
        System.out.println(FW_ConsoleColors.YELLOW + result + FW_ConsoleColors.RESET);

        // Update the testRun with the updated testStep result
        testStepObj = FW_TestStepUtils.updateTestStepResult(testRunTracker.getTestRun(),testStepObj);

         // Make a copy of testStepObj due to lambda expression below
        FW_TestStep finalTestStepObj = testStepObj;
        
        // Set screenshot context for the Allure reporting
        Allure.step("Step: " + result, () -> {

            // Take a screenshot if screenCaptureOnTestStepResults = true and screenCaptureOnTestStepResultsSelection = fail
            if (FW_ConfigMgr.getScreenCaptureOnTestStepResults().toLowerCase().contains("true")) {

                // Take screenshot
                FW_Image screenshotImageObj = FW_ScreenUtils.takeScreenshot(getDriver(), "Screenshot", FW_ConfigMgr.getScreenCaptureOutputPath());

                // Add screenshot details to testStepObj testStepScreenshotRef
                String screenshotRef = FW_ConfigMgr.getGoogleCloudStorageBaseURL() + FW_ConfigMgr.getGoogleCloudStorageBucket() + "/" + screenshotImageObj.getImageName() + "." + screenshotImageObj.getImageType();
                finalTestStepObj.setTestStepScreenshotRef(screenshotRef);

                // Generate a thumbnail of the screenshot
                FW_Image screenshotThumbImageObj = FW_ImageUtils.scaleImage(screenshotImageObj, FW_ConfigMgr.getImageThumbnailMaxSize(), FW_ConfigMgr.getImageThumbnailMaxSize());

                // Add screenshot thumbnail details to testStepObj testStepScreenshotRef
                String imageNameThumb = screenshotThumbImageObj.getImageName() + "_Thumb" + "." + screenshotThumbImageObj.getImageType();
                String screenshotThumbGoogleRef = FW_ConfigMgr.getGoogleCloudStorageBaseURL() + FW_ConfigMgr.getGoogleCloudStorageBucket() + "/" + imageNameThumb;
                finalTestStepObj.setTestStepScreenshotThumbRef(screenshotThumbGoogleRef);

                // Based on if the image conversion to JPG is enabled, save the image as PNG or JPG with the specified quality
                if (FW_ConfigMgr.getImageConversionToJPG().equalsIgnoreCase("true")) {
                    FW_ImageUtils.saveImageAsJPG(screenshotThumbImageObj, imageNameThumb, FW_ConfigMgr.getScreenCaptureOutputPath(), FW_ConfigMgr.getImageThumbnailCompressionJPGQuality());
                } else {
                    FW_ImageUtils.saveImageAsPNG(screenshotThumbImageObj, imageNameThumb, FW_ConfigMgr.getScreenCaptureOutputPath());
                }
            }

            // Feed the testStepObj into the data collector
            FW_TestStepDataCollector.collect(finalTestStepObj);

            Assertions.assertTrue(true); // Pass the step
        });
    }

    /**
     * The stepNote method is used to send the step details to the Allure report and listener.
     * 
     * @param result the result string to be reported
     */
    private static void stepNote(String result, FW_TestStep testStepObj, FW_TestRunTracker testRunTracker) {
        System.out.println(FW_ConsoleColors.YELLOW + result + FW_ConsoleColors.RESET);

        // Update the testRun with the updated testStep result
        testStepObj = FW_TestStepUtils.updateTestStepResult(testRunTracker.getTestRun(),testStepObj);

         // Make a copy of testStepObj due to lambda expression below
        FW_TestStep finalTestStepObj = testStepObj;

        // Record note to the Allure report
        FW_ReportUtils.recordNoteToAllure(result);

        // Feed the testStepObj into the data collector
        FW_TestStepDataCollector.collect(finalTestStepObj);

        Assertions.assertTrue(true); // Pass the step
    }

}