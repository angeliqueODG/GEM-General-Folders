package framework.image;

// ===============================================================
// @file: FW_Image.java
// @filepath: src/test/java/framework/image/FW_Image.java
// @version: 2.0.0
// @updated: 2025-01-10 11:45:00 AM CST
// @author: Greg Paskal
// @company: MissionWares
//
// @description:
// Represents an image with comprehensive attributes for image processing and
// management. This class encapsulates image metadata including dimensions,
// file locations, transparency information, and buffered image data. Provides
// functionality to track both original and stored image properties, enabling
// efficient image manipulation operations such as trimming, format conversion,
// and compression. Includes a main method for testing image processing workflows
// with sample images.
//
// @dependencies:
// - framework.utilities.FW_ImageUtils
// - framework.utilities.FW_ConfigMgr
// - framework.utilities.FW_FileDirUtils
// - java.awt.image.BufferedImage
//
// @methods:
// - Constructor: Creates FW_Image instance with initial properties
// - main(String[]): Test harness for image processing operations
// - Getters/Setters: Complete property access for all image attributes
// - toString(): Formatted output of image properties
//
// @properties:
// - Image identification (name, type)
// - Dimensions (height, width)
// - Transparency support
// - Origin locations (filepath, URL, response code)
// - Storage locations and sizes
// - BufferedImage data
//
// @tags: image-processing, metadata, buffered-image, file-management, mAi™
//
// @changeLog:
// Date        Author          Version  Description
// ----------  --------------  -------  --------------------------
// 2025-02-17  G. Paskal       1.0.0    Initial implementation
// 2025-01-10  G. Paskal       2.0.0    Added mAi™ header and enhanced documentation
// ===============================================================

import framework.utilities.FW_ImageUtils;
import framework.utilities.FW_ConfigMgr;
import framework.utilities.FW_FileDirUtils;

import java.awt.image.BufferedImage;

/**
 * Represents the details of an image.
 */
public class FW_Image {
    private String imageName;                   //includes the extension
    private String imageType;                   // e.g. jpg, png, etc.
    private int imageHeight;                    // e.g. 1080 in pixels
    private int imageWidth;                     // e.g. 1920 in pixels
    private Boolean imageHasTransparency;       // Does the image have transparency (Alpha channel)
    private String imageOriginFilepath;         // Original filepath location excluding the image name
    private String imageOriginURL;              // Original URL location excluding the image name
    private int imageOriginURLResponseCode;     // HTTP response code from the request to get online image
    private long imageOriginSize;               // Size in bytes of the original image
    private BufferedImage imageBuffer;          // Buffered image stored in memory
    private String imageStoredFilepath;         // Updated filepath location excluding the image name
    private String imageStoredURL;              // Updated URL location excluding the image name
    private long imageStoredSize;               // Size in bytes of the stored image

    /**
     * Constructs a new FW_Image instance.
     * @param imageName the name of the image including extension
     * @param imageOriginFilepath the filepath origin of where the original image was found excluding the image name and extension
     * @param imageOriginURL the url origin of where the original image was found
     * @param imageBuffer the buffered image stored in memory
     * 
     * @return FW_Image instance
     */
    public FW_Image(String imageName, String imageOriginFilepath, String imageOriginURL, BufferedImage imageBuffer) {
        this.imageName = FW_FileDirUtils.getFileName(imageName);
        this.imageType = FW_FileDirUtils.getFileExtension(imageName);
        this.imageOriginFilepath = FW_FileDirUtils.getFilePath(imageOriginFilepath);
        this.imageOriginURL = imageOriginURL;
        this.imageOriginURLResponseCode = 0;
        this.imageBuffer = FW_ImageUtils.getBufferedImage(this.imageName + "." + this.imageType, this.imageOriginFilepath, imageBuffer);
        this.imageHasTransparency = FW_ImageUtils.hasAlphaChannel(this.imageBuffer);
        this.imageHeight = FW_ImageUtils.getImageHeight(this.imageBuffer);
        this.imageWidth = FW_ImageUtils.getImageWidth(this.imageBuffer);
        this.imageOriginSize = -1;
        this.imageStoredFilepath = "";
        this.imageStoredURL = "";
        this.imageStoredSize = -1;
    }

    // Main method for testing
    public static void main(String[] args) {
    
        String imageName = "";
        String imageOriginFilepath = "";
        String imageOriginURL = "";
        BufferedImage imageBuffer = null;

        String imageNamePNG = "";
        String imageNameJPG = "";

        // Create an instance of FW_Image
        FW_Image imageObj = new FW_Image(imageName, imageOriginFilepath, imageOriginURL, imageBuffer);
        imageObj = null; // Make this image null to free up memory and prepare for the next image

        // ========================== sampleImage_Blue_Square_Master_6000x6000 - Begin ==========================

        // Example image details
        imageName = "sampleImage_Blue_Square_Master_6000x6000.png";
        imageOriginFilepath = "/Users/gregpaskal/GoogleDrive/Documents/Development/Automation/Automation-Projects/Automation-JAV-SwagLabs/src/test/java/framework/image/samples";
        imageOriginURL = "http://example.com/image";
        imageBuffer = null;

        imageNamePNG = "sampleImage_Blue_Square_Trimmed_999x999.png";
        imageNameJPG = "sampleImage_Blue_Square_Trimmed_999x999.jpg";

        // Create an instance of FW_Image object
        imageObj = new FW_Image(imageName, imageOriginFilepath, imageOriginURL, imageBuffer);

        // Trim image if configured to
        if (FW_ConfigMgr.getImageTrim().toLowerCase().contains("true")) {
            imageObj = FW_ImageUtils.trimImage(imageObj);
        }

        // Update the image name with dimensions and save as PNG
        imageNamePNG = FW_ImageUtils.updateFilenameWithDimensions(imageNamePNG, imageObj.getImageWidth(), imageObj.getImageHeight(), true);
        imageObj.setImageName(imageNamePNG);
        FW_ImageUtils.saveImageAsPNG(imageObj, imageNamePNG, imageOriginFilepath);

        // // Save as JPG
        imageNameJPG = FW_ImageUtils.updateFilenameWithDimensions(imageNameJPG, imageObj.getImageWidth(), imageObj.getImageHeight(), true);
        imageObj.setImageName(imageNameJPG);
        FW_ImageUtils.saveImageAsJPG(imageObj, imageNameJPG, imageOriginFilepath, FW_ConfigMgr.getImageCompressionJPGQuality());

        // Make this image null to free up memory
        imageObj = null;

        // ========================== sampleImage_Blue_Square_Master_6000x6000 - End ==========================

        // ========================== sampleImage_Gradient_LR_Master_200x200 - Begin ==========================

        // Example image details
        imageName = "sampleImage_Gradient_LR_Master_200x200.png";
        imageOriginFilepath = "/Users/gregpaskal/GoogleDrive/Documents/Development/Automation/Automation-Projects/Automation-JAV-SwagLabs/src/test/java/framework/image/samples";
        imageOriginURL = "http://example.com/image";
        imageBuffer = null;

        imageNamePNG = "sampleImage_Gradient_LR_Trimmed_999x999.png";
        imageNameJPG = "sampleImage_Gradient_LR_Trimmed_999x999.jpg";

        // Create an instance of FW_Image object
        imageObj = new FW_Image(imageName, imageOriginFilepath, imageOriginURL, imageBuffer);

        // Trim image if configured to
        if (FW_ConfigMgr.getImageTrim().toLowerCase().contains("true")) {
            imageObj = FW_ImageUtils.trimImage(imageObj);
        }

        // Update the image name with dimensions and save as PNG
        imageNamePNG = FW_ImageUtils.updateFilenameWithDimensions(imageNamePNG, imageObj.getImageWidth(), imageObj.getImageHeight(), true);
        imageObj.setImageName(imageNamePNG);
        FW_ImageUtils.saveImageAsPNG(imageObj, imageNamePNG, imageOriginFilepath);

        // Save as JPG
        imageNameJPG = FW_ImageUtils.updateFilenameWithDimensions(imageNameJPG, imageObj.getImageWidth(), imageObj.getImageHeight(), true);
        imageObj.setImageName(imageNameJPG);
        FW_ImageUtils.saveImageAsJPG(imageObj, imageNameJPG, imageOriginFilepath, FW_ConfigMgr.getImageCompressionJPGQuality());

        // Make this image null to free up memory
        imageObj = null;

        // ========================== ssampleImage_Gradient_LR_Master_200x200 - End ==========================

        // ========================== sampleImage_Gradient_TB_Master_50x50 - Begin ==========================

        // Example image details
        imageName = "sampleImage_Gradient_TB_Master_50x50.png";
        imageOriginFilepath = "/Users/gregpaskal/GoogleDrive/Documents/Development/Automation/Automation-Projects/Automation-JAV-SwagLabs/src/test/java/framework/image/samples";
        imageOriginURL = "http://example.com/image";
        imageBuffer = null;

        imageNamePNG = "sampleImage_Gradient_TB_Trimmed_999x999.png";
        imageNameJPG = "sampleImage_Gradient_TB_Trimmed_999x999.jpg";

        // Create an instance of FW_Image object
        imageObj = new FW_Image(imageName, imageOriginFilepath, imageOriginURL, imageBuffer);

        // Trim image if configured to
        if (FW_ConfigMgr.getImageTrim().toLowerCase().contains("true")) {
            imageObj = FW_ImageUtils.trimImage(imageObj);
        }

        // Update the image name with dimensions and save as PNG
        imageNamePNG = FW_ImageUtils.updateFilenameWithDimensions(imageNamePNG, imageObj.getImageWidth(), imageObj.getImageHeight(), true);
        imageObj.setImageName(imageNamePNG);
        FW_ImageUtils.saveImageAsPNG(imageObj, imageNamePNG, imageOriginFilepath);

        // Save as JPG
        imageNameJPG = FW_ImageUtils.updateFilenameWithDimensions(imageNameJPG, imageObj.getImageWidth(), imageObj.getImageHeight(), true);
        imageObj.setImageName(imageNameJPG);
        FW_ImageUtils.saveImageAsJPG(imageObj, imageNameJPG, imageOriginFilepath, FW_ConfigMgr.getImageCompressionJPGQuality());

        // Make this image null to free up memory
        imageObj = null;

        // ========================== ssampleImage_Gradient_TB_Master_50x50 - End ==========================

        // ========================== sampleImage_Fail_Master_2400x2352 - Begin ==========================

        // Example image details
        imageName = "sampleImage_Realworld_Fail_Master_2400x2352.png";
        imageOriginFilepath = "/Users/gregpaskal/GoogleDrive/Documents/Development/Automation/Automation-Projects/Automation-JAV-SwagLabs/src/test/java/framework/image/samples";
        imageOriginURL = "http://example.com/image";
        imageBuffer = null;

        imageNamePNG = "sampleImage_Realworld_Fail_Trimmed_999x999.png";
        imageNameJPG = "sampleImage_Realworld_Fail_Trimmed_999x999.jpg";

        // Create an instance of FW_Image object
        imageObj = new FW_Image(imageName, imageOriginFilepath, imageOriginURL, imageBuffer);

        // Trim image if configured to
        if (FW_ConfigMgr.getImageTrim().toLowerCase().contains("true")) {
            imageObj = FW_ImageUtils.trimImage(imageObj);
        }

        // Update the image name with dimensions and save as PNG
        imageNamePNG = FW_ImageUtils.updateFilenameWithDimensions(imageNamePNG, imageObj.getImageWidth(), imageObj.getImageHeight(), true);
        imageObj.setImageName(imageNamePNG);
        FW_ImageUtils.saveImageAsPNG(imageObj, imageNamePNG, imageOriginFilepath);

        // Save as JPG
        imageNameJPG = FW_ImageUtils.updateFilenameWithDimensions(imageNameJPG, imageObj.getImageWidth(), imageObj.getImageHeight(), true);
        imageObj.setImageName(imageNameJPG);
        FW_ImageUtils.saveImageAsJPG(imageObj, imageNameJPG, imageOriginFilepath, FW_ConfigMgr.getImageCompressionJPGQuality());

        // Make this image null to free up memory
        imageObj = null;

        // ========================== sampleImage_Fail_Master_2400x2352 - End ==========================

    }

    // =================================================================================
    // ====================== Class - Getters and Setters - Begin ======================

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getImageType() {
        return imageType;
    }

    public void setImageType(String imageType) {
        this.imageType = imageType;
    }

    public int getImageHeight() {
        return imageHeight;
    }

    public void setImageHeight(int imageHeight) {
        this.imageHeight = imageHeight;
    }

    public int getImageWidth() {
        return imageWidth;
    }

    public void setImageWidth(int imageWidth) {
        this.imageWidth = imageWidth;
    }

    public Boolean getImageHasTransparency() {
        return imageHasTransparency;
    }

    public void setImageHasTransparency(Boolean imageHasTransparency) {
        this.imageHasTransparency = imageHasTransparency;
    }

    public String getImageOriginFilepath() {
        return imageOriginFilepath;
    }

    public void setImageOriginFilepath(String imageFoundLocalFilepath) {
        this.imageOriginFilepath = imageFoundLocalFilepath;
    }

    public String getImageOriginURL() {
        return imageOriginURL;
    }

    public void setImageOriginURL(String imageFoundOnlineURL) {
        this.imageOriginURL = imageFoundOnlineURL;
    }

    public int getImageOriginURLResponseCode() {
        return imageOriginURLResponseCode;
    }

    public void setImageOriginURLResponseCode(int imageRequestResponseCode) {
        this.imageOriginURLResponseCode = imageRequestResponseCode;
    }

    public long getImageOriginSize() {
        return imageOriginSize;
    }

    public void setImageOriginSize(long imageSizeInBytes) {
        this.imageOriginSize = imageSizeInBytes;
    }

    public BufferedImage getImageBuffer() {
        return imageBuffer;
    }

    public void setImageBuffer(BufferedImage imageBuffer) {
        this.imageBuffer = imageBuffer;
    }

    public String getImageStoredFilepath() {
        return imageStoredFilepath;
    }

    public void setImageStoredFilepath(String imageStoredLocalFilepath) {
        this.imageStoredFilepath = imageStoredLocalFilepath;
    }

    public String getImageStoredURL() {
        return imageStoredURL;
    }

    public void setImageStoredURL(String imageStoredOnlineURL) {
        this.imageStoredURL = imageStoredOnlineURL;
    }

    public long getImageStoredSize() {
        return imageStoredSize;
    }

    public void setImageStoredSize(long imageStoredSize) {
        this.imageStoredSize = imageStoredSize;
    }

    // ====================== Class - Getters and Setters - End ======================
    // ===============================================================================

    // toString method for easy printing
    @Override
    public String toString() {
        return "FW_Image{" +
                "imageName='" + imageName + '\'' +
                ", imageType='" + imageType + '\'' +
                ", imageOriginFilepath='" + imageOriginFilepath + '\'' +
                ", imageOriginURL='" + imageOriginURL + '\'' +
                ", imageOriginURLResponseCode=" + imageOriginURLResponseCode +
                ", imageBuffer=" + imageBuffer +
                ", imageHasTransparency=" + imageHasTransparency +
                ", imageHeight=" + imageHeight +
                ", imageWidth=" + imageWidth +
                ", imageOriginSize=" + imageOriginSize +
                ", imageStoredFilepath='" + imageStoredFilepath + '\'' +
                ", imageStoredURL='" + imageStoredURL + '\'' +
                ", imageStoredSize=" + imageStoredSize +
                '}';
    }
}