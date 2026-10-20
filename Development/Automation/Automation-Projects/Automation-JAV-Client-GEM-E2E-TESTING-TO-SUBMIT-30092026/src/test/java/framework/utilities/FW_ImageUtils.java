package framework.utilities;

// ===============================================================
// @file: FW_ImageUtils.java
// @filepath: src/test/java/framework/utilities/FW_ImageUtils.java
// @version: 1.0.0
// @updated: 2025-01-10 03:22:00 PM CST
// @author: Greg Paskal
// @company: MissionWares
//
// @description:
// Utility class for image helper functions.
// This class provides comprehensive image manipulation capabilities including
// buffered image management, format conversion (PNG/JPG), alpha channel
// operations, image trimming with transparency detection, scaling while
// maintaining aspect ratio, and dimension-based filename updates. Supports
// advanced features like customizable compression quality, transparency
// threshold analysis, and bounding box detection for automatic image cropping.
//
// @methods:
// - getBufferedImage(String, String, BufferedImage) - Returns buffered image
// - saveImageAsPNG(FW_Image, String, String) - Saves as PNG format
// - saveImageAsJPG(FW_Image, String, String, float) - Saves as JPG with compression
// - getImageType(String) - Returns image file type
// - getImageWidth(BufferedImage) - Returns image width
// - getImageHeight(BufferedImage) - Returns image height
// - addAlphaChannel(FW_Image) - Adds transparency channel
// - removeAlphaChannel(FW_Image) - Removes transparency channel
// - customizeAlphaChannel(FW_Image, int) - Adjusts transparency threshold
// - hasAlphaChannel(BufferedImage) - Checks for alpha channel
// - analyzeForTransparency(BufferedImage) - Determines background color
// - trimImage(FW_Image) - Auto-crops transparent borders
// - scaleImage(FW_Image, int, int) - Scales with aspect ratio
// - updateFilenameWithDimensions(String, int, int, boolean) - Updates filename
//
// @dependencies:
// - java.awt.*
// - java.awt.image.BufferedImage
// - java.io.File
// - java.io.IOException
// - javax.imageio.*
// - framework.image.FW_Image
// - framework.utilities.FW_FileDirUtils
// - framework.utilities.FW_DebugUtils
// - framework.utilities.FW_ConfigMgr
// - framework.utilities.FW_ConsoleColors
//
// @tags: image-processing, buffered-image, alpha-channel, compression, mAi™
//
// @changeLog:
// Date        Author          Version  Description
// ----------  --------------  -------  --------------------------
// 2025-01-10  G. Paskal       1.0.0    Initial implementation with mAi™ header
// ===============================================================

// Java file I/O
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;

import framework.image.FW_Image;

/**
 * Utility class for image helper functions.
 */
public class FW_ImageUtils {
    
    /**
     * Main method for testing image utility functions.
     * Tests buffered image operations, alpha channel manipulation, trimming, scaling, and file operations.
     * 
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        System.out.println(FW_ConsoleColors.CORAL + "========================================" + FW_ConsoleColors.RESET);
        System.out.println(FW_ConsoleColors.CORAL + "   FW_ImageUtils - Test Suite" + FW_ConsoleColors.RESET);
        System.out.println(FW_ConsoleColors.CORAL + "========================================" + FW_ConsoleColors.RESET);
        System.out.println("");

        // Define test image details
        String imageName = "sampleImage_Blue_Square_Master_6000x6000.png";
        String imageFilepath = "/Users/gregpaskal/GoogleDrive/Documents/Development/Automation/Automation-Projects/Automation-JAV-mAi/src/test/java/framework/image/samples/";
        String outputFilepath = imageFilepath + "output/";
        
        // Test 1: Load buffered image
        System.out.println(FW_ConsoleColors.BLUE + "Test 1: Load Buffered Image" + FW_ConsoleColors.RESET);
        BufferedImage bufferedImage = getBufferedImage(imageName, imageFilepath, null);
        if (bufferedImage != null) {
            System.out.println(FW_ConsoleColors.GREEN + "  PASS: Image loaded successfully" + FW_ConsoleColors.RESET);
            System.out.println("  - Original dimensions: " + getImageWidth(bufferedImage) + "x" + getImageHeight(bufferedImage));
            System.out.println("  - Has alpha channel: " + hasAlphaChannel(bufferedImage));
        } else {
            System.out.println(FW_ConsoleColors.RED + "  FAIL: Image not loaded" + FW_ConsoleColors.RESET);
            return;
        }
        System.out.println("");

        // Test 2: Create FW_Image object and add alpha channel
        System.out.println(FW_ConsoleColors.BLUE + "Test 2: Add Alpha Channel" + FW_ConsoleColors.RESET);
        FW_Image imageObj = new FW_Image(imageName, imageFilepath, "", bufferedImage);
        imageObj = addAlphaChannel(imageObj);
        System.out.println(FW_ConsoleColors.GREEN + "  PASS: Alpha channel added" + FW_ConsoleColors.RESET);
        System.out.println("  - Has transparency: " + imageObj.getImageHasTransparency());
        System.out.println("");

        // Test 3: Analyze for transparency
        System.out.println(FW_ConsoleColors.BLUE + "Test 3: Analyze Transparency Color" + FW_ConsoleColors.RESET);
        int transparencyColor = analyzeForTransparency(imageObj.getImageBuffer());
        System.out.println(FW_ConsoleColors.GREEN + "  PASS: Background color analyzed" + FW_ConsoleColors.RESET);
        System.out.println(String.format("  - Background RGB: 0x%06X", transparencyColor));
        System.out.println("");

        // Test 4: Trim image
        System.out.println(FW_ConsoleColors.BLUE + "Test 4: Trim Image" + FW_ConsoleColors.RESET);
        FW_Image trimmedImage = trimImage(imageObj);
        System.out.println(FW_ConsoleColors.GREEN + "  PASS: Image trimmed" + FW_ConsoleColors.RESET);
        System.out.println("  - Original: " + getImageWidth(bufferedImage) + "x" + getImageHeight(bufferedImage));
        System.out.println("  - Trimmed: " + trimmedImage.getImageWidth() + "x" + trimmedImage.getImageHeight());
        System.out.println("");

        // Test 5: Scale image
        System.out.println(FW_ConsoleColors.BLUE + "Test 5: Scale Image" + FW_ConsoleColors.RESET);
        FW_Image scaledImage = scaleImage(trimmedImage, 800, 800);
        System.out.println(FW_ConsoleColors.GREEN + "  PASS: Image scaled" + FW_ConsoleColors.RESET);
        System.out.println("  - Scaled dimensions: " + scaledImage.getImageWidth() + "x" + scaledImage.getImageHeight());
        System.out.println("");

        // Test 6: Update filename with dimensions
        System.out.println(FW_ConsoleColors.BLUE + "Test 6: Update Filename With Dimensions" + FW_ConsoleColors.RESET);
        String originalFilename = "test_image_999x999.png";
        String updatedFilename = updateFilenameWithDimensions(originalFilename, scaledImage.getImageWidth(), scaledImage.getImageHeight(), true);
        System.out.println(FW_ConsoleColors.GREEN + "  PASS: Filename updated" + FW_ConsoleColors.RESET);
        System.out.println("  - Original: " + originalFilename);
        System.out.println("  - Updated: " + updatedFilename);
        System.out.println("");

        // Test 7: Save as PNG
        System.out.println(FW_ConsoleColors.BLUE + "Test 7: Save Image As PNG" + FW_ConsoleColors.RESET);
        String pngFilename = "test_output_" + scaledImage.getImageWidth() + "x" + scaledImage.getImageHeight() + ".png";
        scaledImage = saveImageAsPNG(scaledImage, pngFilename, outputFilepath);
        if (FW_FileDirUtils.fileExists(outputFilepath + pngFilename)) {
            System.out.println(FW_ConsoleColors.GREEN + "  PASS: PNG file saved" + FW_ConsoleColors.RESET);
            System.out.println("  - Location: " + outputFilepath + pngFilename);
        } else {
            System.out.println(FW_ConsoleColors.RED + "  FAIL: PNG file not saved" + FW_ConsoleColors.RESET);
        }
        System.out.println("");

        // Test 8: Save as JPG with compression
        System.out.println(FW_ConsoleColors.BLUE + "Test 8: Save Image As JPG (80% quality)" + FW_ConsoleColors.RESET);
        String jpgFilename = "test_output_" + scaledImage.getImageWidth() + "x" + scaledImage.getImageHeight() + ".jpg";
        scaledImage = saveImageAsJPG(scaledImage, jpgFilename, outputFilepath, 80.0f);
        if (FW_FileDirUtils.fileExists(outputFilepath + jpgFilename)) {
            System.out.println(FW_ConsoleColors.GREEN + "  PASS: JPG file saved" + FW_ConsoleColors.RESET);
            System.out.println("  - Location: " + outputFilepath + jpgFilename);
        } else {
            System.out.println(FW_ConsoleColors.RED + "  FAIL: JPG file not saved" + FW_ConsoleColors.RESET);
        }
        System.out.println("");

        // Test 9: Remove alpha channel
        System.out.println(FW_ConsoleColors.BLUE + "Test 9: Remove Alpha Channel" + FW_ConsoleColors.RESET);
        FW_Image imageWithoutAlpha = removeAlphaChannel(scaledImage);
        System.out.println(FW_ConsoleColors.GREEN + "  PASS: Alpha channel removed" + FW_ConsoleColors.RESET);
        System.out.println("  - Has transparency: " + imageWithoutAlpha.getImageHasTransparency());
        System.out.println("");

        // Summary
        System.out.println(FW_ConsoleColors.CORAL + "========================================" + FW_ConsoleColors.RESET);
        System.out.println(FW_ConsoleColors.GREEN + "   All Tests Completed Successfully!" + FW_ConsoleColors.RESET);
        System.out.println(FW_ConsoleColors.CORAL + "========================================" + FW_ConsoleColors.RESET);
    }

    /**
     * Return a buffered image object from an image file and filepath or a passed in buffered image
     * This method provides multiple checks to ensure a buffered image is returned
     * 
     * @param imageName Name of the image including the extension
     * @param imageFilepath Filepath where the image is stored excluding the image name
     * @param imageBuffer An either null or valid passed in buffered image
     * 
     * @return BufferedImage object
     */
    public static BufferedImage getBufferedImage(String imageName, String imageFilepath, BufferedImage imageBuffer) {

        // Check if imageBuffer is not null
        if (imageBuffer != null) {

            // We already have a buffered image, return it
            return imageBuffer;
        }

        // Ensure imageFilepath ends with a slash
        imageFilepath = FW_FileDirUtils.getFilePath(imageFilepath);

        // Check if filepath is not null and does not exist
        if ((!imageFilepath.isEmpty()) && (FW_FileDirUtils.fileExists(imageFilepath) == false)) {
            System.out.println(FW_ConsoleColors.RED + "[" + FW_DebugUtils.getClassName() + " - " + FW_DebugUtils.getMethodName() + "] - Local filepath '" + imageFilepath + "' does not exist." + FW_ConsoleColors.RESET);
            return null;
        }

        // Check if imageName length is greater than 1 and filepath is not null and fullFilepath does not exist
        String fullFilepath = imageFilepath + imageName; // Configure the full filepath
        if ((imageName.length() > 1) && (!imageFilepath.isEmpty()) && (FW_FileDirUtils.fileExists(fullFilepath) == false)) {
            System.out.println(FW_ConsoleColors.RED + "[" + FW_DebugUtils.getClassName() + " - " + FW_DebugUtils.getMethodName() + "] - Local filepath '" + fullFilepath + "' does not exist." + FW_ConsoleColors.RESET);
            return null;
        }

        // Check if imageName length is greater than 1 and filepath is not null
        if ((imageName.length() > 1) && (!imageFilepath.isEmpty())) {
            try {
                BufferedImage bufferedImage = ImageIO.read(new File(fullFilepath)); // Create buffered image object
                return bufferedImage; // Return the image
            } catch (IOException e) {  // ✅ CORRECT: } closes the try block
                System.out.println(FW_ConsoleColors.RED + "[" + FW_DebugUtils.getClassName() + " - " + FW_DebugUtils.getMethodName() + "] - Error reading image file '" + fullFilepath + "': " + e.getMessage() + FW_ConsoleColors.RESET);
                return null;
            }
        } else {
            return null;
        }
    }

    /**
     * Save image object as a PNG file overwriting the original file if it exists and applying the compression quality
     * 
     * @param imageObj the image object containing the buffered image to save as a JPG file
     * @param imageName the name of the image to save
     * @param imageFilepath the filepath to save the image
     * 
     * @return The updated image object with the stored filepath
     */
    public static FW_Image saveImageAsPNG(FW_Image imageObj, String imageName, String imageFilepath) {

        // Ensure imageFilepath ends with a slash
        imageFilepath = FW_FileDirUtils.getFilePath(imageFilepath);

        // Check if filepath does not exist and create it if it does not exist
        if (FW_FileDirUtils.fileExists(imageFilepath) == false) {
            FW_FileDirUtils.createDirectory(imageFilepath);
        }

        // Check if imageName length is greater than 1 and filepath is not null
        String fullFilepath = imageFilepath + imageName; // Configure the full filepath
        if ((imageName.length() > 1) && (!imageFilepath.isEmpty())) {
            try {

                // Write the image as a PNG file
                ImageIO.write(imageObj.getImageBuffer(), "png", new File(fullFilepath)); // Save the image

                // Check if new PNG file was created
                if (FW_FileDirUtils.fileExists(fullFilepath) == false) {
                    System.out.println(FW_ConsoleColors.RED + "[" + FW_DebugUtils.getClassName() + " - " + FW_DebugUtils.getMethodName() + "] - Failed to create PNG file '" + fullFilepath + "'." + FW_ConsoleColors.RESET);
                    return imageObj;
                }

                // Update the image object with stored filepath
                imageObj.setImageStoredFilepath(imageFilepath);

                // Return the image object
                return imageObj;

            } catch (IOException e) {
                System.out.println(FW_ConsoleColors.RED + "[" + FW_DebugUtils.getClassName() + " - " + FW_DebugUtils.getMethodName() + "] - Error saving image file '" + fullFilepath + "': " + e.getMessage() + FW_ConsoleColors.RESET);
                return imageObj;
            }
        } else {
            return imageObj;
        }
    }

    /**
     * Save image object as a JPG file overwriting the original file if it exists and applying the compression quality
     * 
     * @param imageObj the image object containing the buffered image to save as a JPG file
     * @param imageName the name of the image to save
     * @param imageFilepath the filepath to save the image
     * @param compressionQuality the compression quality to apply to the JPG file from 0 to 100 with 100 being the highest quality, lowest compression
     * 
     * @return The updated image object with the stored filepath
     */
    public static FW_Image saveImageAsJPG(FW_Image imageObj, String imageName, String imageFilepath, float compressionQuality) {

        // Ensure imageFilepath ends with a slash
        imageFilepath = FW_FileDirUtils.getFilePath(imageFilepath);

        // Check if filepath does not exist and create it if it does not exist
        if (!FW_FileDirUtils.fileExists(imageFilepath)) {
            FW_FileDirUtils.createDirectory(imageFilepath);
        }

        // Check that the compression quality is within the valid range
        if (compressionQuality < 0) {
            compressionQuality = 0;
        } else if (compressionQuality > 100) {
            compressionQuality = 100;
        }
        
        // Check if imageName length is greater than 1 and filepath is not null
        String fullFilepath = imageFilepath + imageName; // Configure the full filepath
        if (imageName.length() > 1 && !imageFilepath.isEmpty()) {
            ImageWriter jpgWriter = null;
            ImageOutputStream outputStream = null;
            try {
                // Convert image to RGB color space if necessary
                BufferedImage rgbImage = new BufferedImage(imageObj.getImageBuffer().getWidth(), imageObj.getImageBuffer().getHeight(), BufferedImage.TYPE_INT_RGB);
                Graphics2D g = rgbImage.createGraphics();
                g.drawImage(imageObj.getImageBuffer(), 0, 0, null);
                g.dispose();

                // Get an ImageWriter for JPG format
                jpgWriter = ImageIO.getImageWritersByFormatName("jpg").next();
                ImageWriteParam jpgWriteParam = jpgWriter.getDefaultWriteParam();

                // Set the compression quality
                jpgWriteParam.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
                jpgWriteParam.setCompressionQuality(compressionQuality * 0.01f);

                // Write the image as a JPG file
                File jpgFile = new File(fullFilepath);
                outputStream = ImageIO.createImageOutputStream(jpgFile);
                jpgWriter.setOutput(outputStream);
                IIOImage outputImage = new IIOImage(rgbImage, null, null);
                jpgWriter.write(null, outputImage, jpgWriteParam);

                // Check if new JPG file was created
                if (FW_FileDirUtils.fileExists(fullFilepath) == false) {
                    System.out.println(FW_ConsoleColors.RED + "[" + FW_DebugUtils.getClassName() + " - " + FW_DebugUtils.getMethodName() + "] - Failed to create JPG file '" + fullFilepath + "'." + FW_ConsoleColors.RESET);
                    return imageObj;
                }

                // Update the image object with stored filepath
                imageObj.setImageStoredFilepath(imageFilepath);

                // Return the image object
                return imageObj;

            } catch (IOException e) {
                System.out.println(FW_ConsoleColors.RED + "[" + FW_DebugUtils.getClassName() + " - " + FW_DebugUtils.getMethodName() + "] - Error saving image file '" + fullFilepath + "': " + e.getMessage() + FW_ConsoleColors.RESET);
                return imageObj;
            } finally {
                // Ensure resources are properly closed
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (IOException e) {
                        System.out.println(FW_ConsoleColors.RED + "[" + FW_DebugUtils.getClassName() + " - " + FW_DebugUtils.getMethodName() + "] - Error closing output stream: " + e.getMessage() + FW_ConsoleColors.RESET);
                    }
                }
                if (jpgWriter != null) {
                    jpgWriter.dispose();
                }
            }
        } else {
            return imageObj;
        }
    }

    /**
     * Gets the image type
     *
     * @param imageName the name of the image
     * @return the image type
     */
    public static String getImageType(String imageName) {
        return imageName.substring(imageName.lastIndexOf(".") + 1);
    }

    /**
     * Get the image width from a buffered image
     * 
     * @param bufferedImage
     * 
     * @return the image width
     */
    public static int getImageWidth(BufferedImage bufferedImage) {

        // Ensure the buffered image is not null
        if (bufferedImage == null) {
            return -1;
        }

        // Get the image width
        int width = bufferedImage.getWidth();

        // Return the image width
        return width;
    }

    /**
     * Get the image height from a buffered image
     * 
     * @param bufferedImage
     * 
     * @return the image height
     */
    public static int getImageHeight(BufferedImage bufferedImage) {

        // Ensure the buffered image is not null
        if (bufferedImage == null) {
            return -1;
        }

        // Get the image height
        int height = bufferedImage.getHeight();

        // Return the image height
        return height;
    }

    /**
     * Adds an alpha channel to a buffered image.
     * 
     * @param imageObj the image object containing the buffered image to add an alpha channel to
     * 
     * @return updated image object with the alpha channel added
     */
    public static FW_Image addAlphaChannel(FW_Image imageObj) {

        // Get the buffered image
        BufferedImage bufferedImage = imageObj.getImageBuffer();

        // Ensure the buffered image is not null
        if (bufferedImage == null) {
            return imageObj;
        }

        // Ensure the image does not already have an alpha channel
        if (hasAlphaChannel(bufferedImage) == true) {

            // Set the imageHasTransparency flag to true
            imageObj.setImageHasTransparency(true);

            // Return the image object
            return imageObj;
        }

        // Create a new image with an alpha channel
        BufferedImage imageWithAlpha = new BufferedImage(bufferedImage.getWidth(), bufferedImage.getHeight(), BufferedImage.TYPE_INT_ARGB);
        
        // Copy the original image to the new image with an alpha channel
        Graphics2D graphicImageObj = imageWithAlpha.createGraphics();

        // Draw the original image onto the new image
        graphicImageObj.drawImage(bufferedImage, 0, 0, null);

        // Dispose of the graphics context
        graphicImageObj.dispose();

        // Set the image buffer to the new image with the alpha channel
        imageObj.setImageBuffer(imageWithAlpha);

        // Check if the image has transparency
        if (hasAlphaChannel(imageWithAlpha) == true) {

            // Set the imageHasTransparency flag to true
            imageObj.setImageHasTransparency(true);
        } else {

            // Set the imageHasTransparency flag to false
            imageObj.setImageHasTransparency(false);

            // Print a warning message
            System.out.println(FW_ConsoleColors.YELLOW + "[FW_ImageUtils - addAlphaChannel] - Warning: The image does not have an alpha channel." + FW_ConsoleColors.RESET);
        }
        
        // Return the image object
        return imageObj;
    }

    /**
     * Removes the alpha channel from a buffered image.
     * 
     * @param imageObj the image object containing the buffered image to remove the alpha channel from
     * 
     * @return updated image object without the alpha channel
     */
    public static FW_Image removeAlphaChannel(FW_Image imageObj) {

        // Get the buffered image
        BufferedImage bufferedImage = imageObj.getImageBuffer();

        // Ensure the buffered image is not null
        if (bufferedImage == null) {
            return imageObj;
        }

        // Ensure the image has an alpha channel
        if (!hasAlphaChannel(bufferedImage)) {

            // Set the imageHasTransparency flag to false
            imageObj.setImageHasTransparency(false);

            // Return the image object
            return imageObj;
        }

        // Create a new image without an alpha channel
        BufferedImage imageWithoutAlpha = new BufferedImage(bufferedImage.getWidth(), bufferedImage.getHeight(), BufferedImage.TYPE_INT_RGB);
        
        // Copy the original image to the new image without an alpha channel
        Graphics2D graphicImageObj = imageWithoutAlpha.createGraphics();

        // Draw the original image onto the new image
        graphicImageObj.drawImage(bufferedImage, 0, 0, Color.WHITE, null);

        // Dispose of the graphics context
        graphicImageObj.dispose();

        // Set the image buffer to the new image without the alpha channel
        imageObj.setImageBuffer(imageWithoutAlpha);

        // Set the imageHasTransparency flag to false
        imageObj.setImageHasTransparency(false);

        // Return the image object
        return imageObj;
    }

    /**
     * Customize alpha channel within the buffered image within the image object
     * 
     * @param imageObj the image object containing the buffered image to add an alpha channel to
     * @param transparencyThreshold the transparency threshold from 0 to 100 (percentage) where 0 means no deviation from the detarmined background color
     * 
     * @return updated image object with the alpha channel added
     */
    public static FW_Image customizeAlphaChannel(FW_Image imageObj, int transparencyThreshold) {

        // Get the buffered image
        BufferedImage bufferedImage = imageObj.getImageBuffer();

        // Ensure the buffered image is not null
        if (bufferedImage == null) {
            return imageObj;
        }

        // Ensure the image has an alpha channel
        if (hasAlphaChannel(bufferedImage) == false) {
            return imageObj;
        }

        // Get the alpha channel transparency color excluding the alpha channel
        int transparencyColor = analyzeForTransparency(bufferedImage);

        // Calculate the deviation for each color component
        int transparencyRed = (transparencyColor >> 16) & 0xff;
        int transparencyGreen = (transparencyColor >> 8) & 0xff;
        int transparencyBlue = transparencyColor & 0xff;

        // Calculate the allowable deviation for each color component
        int allowableDeviation = (int) (255 * (transparencyThreshold / 100.0));

        // Set the alpha channel transparency based on the transparency color and values within the threshold
        for (int x = 0; x < imageObj.getImageWidth(); x++) {
            for (int y = 0; y < imageObj.getImageHeight(); y++) {

                // Get the RGB value for the pixel
                int rgb = bufferedImage.getRGB(x, y);

                // Get the alpha, red, green, and blue values
                int alpha = (rgb >> 24) & 0xff;
                int red = (rgb >> 16) & 0xff;
                int green = (rgb >> 8) & 0xff;
                int blue = rgb & 0xff;

                // If alpha is already 0, skip analysis on this pixel and leave it as is
                if (alpha != 0) {

                    int redDeviation = Math.abs(red - transparencyRed);
                    int greenDeviation = Math.abs(green - transparencyGreen);
                    int blueDeviation = Math.abs(blue - transparencyBlue);

                    // If the deviations are within the allowable range, set the alpha to 0
                    if (redDeviation <= allowableDeviation && greenDeviation <= allowableDeviation && blueDeviation <= allowableDeviation) {
                        alpha = 0;
                    }
                }

                // Set the new RGB value with the updated alpha channel
                int newRGB = (alpha << 24) | (red << 16) | (green << 8) | blue;

                // Set the new RGB value to the buffered image
                bufferedImage.setRGB(x, y, newRGB);

            }
        }

        // Set the buffered image to the image object
        imageObj.setImageBuffer(bufferedImage);

        return imageObj;
    }

    /**
     * Check if the image has an alpha channel.
     * 
     * @param bufferedImage the buffered image to check
     * 
     * @return true if the image has an alpha channel, false otherwise
     */
    public static boolean hasAlphaChannel(BufferedImage bufferedImage) {

        // Ensure the buffered image is not null
        if (bufferedImage == null) {
            return false;
        }

        return bufferedImage.getColorModel().hasAlpha();
    }

    /**
     * Sets the alpha channel within the bounding box to the specified alpha value.
     * 
     * @param bufferedImage the buffered image
     * @param left the left boundary of the bounding box
     * @param right the right boundary of the bounding box
     * @param top the top boundary of the bounding box
     * @param bottom the bottom boundary of the bounding box
     * @param alphaValue the alpha value to set (0-255)
     */
    private static void setAlphaChannelWithinBoundingBox(BufferedImage bufferedImage, int left, int right, int top, int bottom, int alphaValue) {
        for (int x = left; x <= right; x++) {
            for (int y = top; y <= bottom; y++) {
                int rgb = bufferedImage.getRGB(x, y);
                int red = (rgb >> 16) & 0xff;
                int green = (rgb >> 8) & 0xff;
                int blue = rgb & 0xff;
                int newRGB = (alphaValue << 24) | (red << 16) | (green << 8) | blue;
                bufferedImage.setRGB(x, y, newRGB);
            }
        }
    }
    
    /**
     * Analyzes the top-left, top-right, bottom-left, bottom-right, top-middle, bottom-middle, left-middle, and right-middle pixels to determine the background color.
     * The most consistent color across these sample points will be used as the background color for transparency.
     *
     * @param image The original BufferedImage.
     * 
     * @return The RGB color to be used as the background color for transparency excluding the alpha channel.
     */
    public static int analyzeForTransparency(BufferedImage image) {
        int width = image.getWidth();
        int height = image.getHeight();

        // Get the corner and middle edge pixels
        int topLeft = image.getRGB(0, 0);
        int topRight = image.getRGB(width - 1, 0);
        int bottomLeft = image.getRGB(0, height - 1);
        int bottomRight = image.getRGB(width - 1, height - 1);
        int topMiddle = image.getRGB(width / 2, 0);
        int bottomMiddle = image.getRGB(width / 2, height - 1);
        int leftMiddle = image.getRGB(0, height / 2);
        int rightMiddle = image.getRGB(width - 1, height / 2);

        // Count the occurrences of each color
        Map<Integer, Integer> colorCount = new HashMap<>();
        colorCount.put(topLeft, colorCount.getOrDefault(topLeft, 0) + 1);
        colorCount.put(topRight, colorCount.getOrDefault(topRight, 0) + 1);
        colorCount.put(bottomLeft, colorCount.getOrDefault(bottomLeft, 0) + 1);
        colorCount.put(bottomRight, colorCount.getOrDefault(bottomRight, 0) + 1);
        colorCount.put(topMiddle, colorCount.getOrDefault(topMiddle, 0) + 1);
        colorCount.put(bottomMiddle, colorCount.getOrDefault(bottomMiddle, 0) + 1);
        colorCount.put(leftMiddle, colorCount.getOrDefault(leftMiddle, 0) + 1);
        colorCount.put(rightMiddle, colorCount.getOrDefault(rightMiddle, 0) + 1);

        // Find the most consistent color
        int backgroundColor = topLeft;
        int maxCount = 0;
        for (Map.Entry<Integer, Integer> entry : colorCount.entrySet()) {
            if (entry.getValue() > maxCount) {
                backgroundColor = entry.getKey();
                maxCount = entry.getValue();
            }
        }

        // Mask out the alpha channel
        backgroundColor &= 0x00FFFFFF;

        return backgroundColor;
    }

    /**
     * Trim the image from a buffered image, returning the trimmed buffered image.
     *
     * @param imageObj the image object containing the buffered image to trim
     * 
     * @return updated image object with the trimmed buffered image
     */
    public static FW_Image trimImage(FW_Image imageObj) {
        
        // Ensure the image has an alpha channel
        imageObj = FW_ImageUtils.addAlphaChannel(imageObj);

        // Customized the alpha channel for transparency
        imageObj = FW_ImageUtils.customizeAlphaChannel(imageObj, FW_ConfigMgr.getImageTrimBackgroundThreshold());

        // Get the buffered image
        BufferedImage bufferedImage = imageObj.getImageBuffer();

        // Ensure the buffered image is not null
        if (bufferedImage == null) {
            return imageObj;
        }

        // Get the image width and height before trimming
        int beforeWidth = imageObj.getImageWidth();
        int beforeHeight = imageObj.getImageHeight();

        // Get the bounding box of the image
        int left = getLeftBoundary(bufferedImage);
        int right = getRightBoundary(bufferedImage);
        int top = getTopBoundary(bufferedImage);
        int bottom = getBottomBoundary(bufferedImage);

        // Set the alpha channel within the bounding box to 255 so that the image is not transparent within the bounding box
        setAlphaChannelWithinBoundingBox(bufferedImage, left, right, top, bottom, 255);

        // Trim the image based on the bounding box
        bufferedImage = bufferedImage.getSubimage(left, top, right - left + 1, bottom - top + 1);

        // Set the image object with the trimmed buffered image
        imageObj.setImageBuffer(bufferedImage);

        // Remove the alpha channel
        imageObj = FW_ImageUtils.removeAlphaChannel(imageObj);

        // Update the image width and height
        imageObj.setImageWidth(getImageWidth(bufferedImage));
        imageObj.setImageHeight(getImageHeight(bufferedImage));

        // Calculate the savings
        if (FW_ConfigMgr.getBooleanValue("debug")) {

            // Get the image width and height after trimming
            int afterWidth = imageObj.getImageWidth();
            int afterHeight = imageObj.getImageHeight();

            long savingsBytes = (long) (beforeWidth * beforeHeight) - (afterWidth * afterHeight);
            float savingsPercent = 100f * savingsBytes / (beforeWidth * beforeHeight);
            System.out.println(FW_ConsoleColors.BROWN + "[Trim Image] - Original: " + beforeWidth + "x" + beforeHeight + " --> Trimmed: " + afterWidth + "x" + afterHeight + " --> Saved: " + String.format("%.1f", savingsPercent) + "%" + FW_ConsoleColors.RESET);
        }

        // return results
        return imageObj;
    }

    /**
     * Scales the image to fit within the specified maxWidth and maxHeight while maintaining the aspect ratio.
     * 
     * @param imageObj The FW_Image object to be scaled.
     * @param maxWidth The maximum width of the scaled image.
     * @param maxHeight The maximum height of the scaled image.
     * @return A new FW_Image object with the scaled image and updated parameters.
     */
    public static FW_Image scaleImage(FW_Image imageObj, int maxWidth, int maxHeight) {
        BufferedImage originalImage = imageObj.getImageBuffer();
        int originalWidth = originalImage.getWidth();
        int originalHeight = originalImage.getHeight();

        // Calculate the scaling factor to maintain the aspect ratio
        double scalingFactor = Math.min((double) maxWidth / originalWidth, (double) maxHeight / originalHeight);

        // Calculate the new dimensions
        int newWidth = (int) (originalWidth * scalingFactor);
        int newHeight = (int) (originalHeight * scalingFactor);

        // Create a new buffered image with the new dimensions
        BufferedImage scaledImage = new BufferedImage(newWidth, newHeight, originalImage.getType());
        Graphics2D g2d = scaledImage.createGraphics();
        g2d.drawImage(originalImage.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH), 0, 0, null);
        g2d.dispose();

        // Create a new FW_Image object with the scaled image and updated parameters
        FW_Image scaledImageObj = new FW_Image(
            imageObj.getImageName(),
            imageObj.getImageOriginFilepath(),
            imageObj.getImageOriginURL(),
            scaledImage
        );
        scaledImageObj.setImageType(imageObj.getImageType());
        scaledImageObj.setImageWidth(newWidth);
        scaledImageObj.setImageHeight(newHeight);

        return scaledImageObj;
    }

    /**
     * Updates the filename with the provided width and height dimensions.
     * If the filename contains a pattern like 999x999, 1234x5678, or nnnxnnn, it substitutes these numbers with the provided width and height.
     * If the filename does not contain these patterns, it adds the width and height information to the end of the filename if addDimensionsIfMissing parameter is true.
     *
     * @param filename The original filename
     * @param width The width to be included in the filename
     * @param height The height to be included in the filename
     * @param addDimensionsIfMissing Indicates whether to add the dimensions to the end of the filename if the patterns are not found
     * 
     * @return The updated filename
     */
    public static String updateFilenameWithDimensions(String filename, int width, int height, boolean addDimensionsIfMissing) {
        String numberPattern = "\\d+x\\d+";
        String placeholderPattern = "n+x+n+";
        String dimensions = width + "x" + height;

        // Check if the filename contains the number or placeholder pattern
        if (filename.matches(".*" + numberPattern + ".*") || filename.matches(".*" + placeholderPattern + ".*")) {
            filename = filename.replaceAll(numberPattern, dimensions);
            filename = filename.replaceAll(placeholderPattern, dimensions);
        } else if (addDimensionsIfMissing) {
            // Add dimensions to the end of the filename if the patterns are not found
            int dotIndex = filename.lastIndexOf('.');
            if (dotIndex != -1) {
                filename = filename.substring(0, dotIndex) + "_" + dimensions + filename.substring(dotIndex);
            } else {
                filename = filename + "_" + dimensions;
            }
        }
        return filename;
    }

    private static int getLeftBoundary(BufferedImage bufferedImage) {
        int left = 0;
        outer:
        for (int x = 0; x < bufferedImage.getWidth(); x++) {
            for (int y = 0; y < bufferedImage.getHeight(); y++) {
                int rgb = bufferedImage.getRGB(x, y);
                if (isNonTransparent(rgb)) {left = x; break outer;}
            }
        }
        return left;
    }

    private static int getRightBoundary(BufferedImage bufferedImage) {
        int right = bufferedImage.getWidth() - 1;
        outer:
        for (int x = bufferedImage.getWidth() - 1; x >= 0; x--) {
            for (int y = 0; y < bufferedImage.getHeight(); y++) {
                int rgb = bufferedImage.getRGB(x, y);
                if (isNonTransparent(rgb)) {right = x; break outer;}
            }
        }
        return right;
    }

    private static int getTopBoundary(BufferedImage bufferedImage) {
        int top = 0;
        outer:
        for (int y = 0; y < bufferedImage.getHeight(); y++) {
            for (int x = 0; x < bufferedImage.getWidth(); x++) {
                int rgb = bufferedImage.getRGB(x, y);
                if (isNonTransparent(rgb)) {top = y; break outer;}
            }
        }
        return top;
    }

    private static int getBottomBoundary(BufferedImage bufferedImage) {
        int bottom = bufferedImage.getHeight() - 1;
        outer:
        for (int y = bufferedImage.getHeight() - 1; y >= 0; y--) {
            for (int x = 0; x < bufferedImage.getWidth(); x++) {
                int rgb = bufferedImage.getRGB(x, y);
                if (isNonTransparent(rgb)) {bottom = y; break outer;}
            }
        }
        return bottom;
    }

    // Method to check if a pixel is non-transparent
    private static boolean isNonTransparent(int rgb) {
        int alpha = (rgb >> 24) & 0xff;
        return alpha != 0; // Pixel is non-transparent if alpha is not zero
    }

}