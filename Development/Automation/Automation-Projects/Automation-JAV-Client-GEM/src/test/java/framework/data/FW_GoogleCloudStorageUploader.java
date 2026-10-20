package framework.data;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.Blob;
import com.google.cloud.storage.Bucket;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;

import framework.utilities.FW_ConfigMgr;
import framework.utilities.FW_ConsoleColors;
import framework.utilities.FW_FileDirUtils;
import framework.utilities.FW_FileDirUtils.FileInfo;
import framework.utilities.FW_GoogleCloudUtils;

/**
 * @file FW_GoogleCloudStorageUploader.java
 * @description FW_GoogleCloudStorageUploader class is used to upload files to Google Cloud Storage.
 * 
 * @version
 * @since 2025-03-06
 * 
 */
public class FW_GoogleCloudStorageUploader {
    
    /**
     * Main method to upload the file to Google Cloud Storage
     * 
     * @param args Command-line arguments:
     */
    public static void main(String[] args) {

        // Should we export to Google Cloud Storage?
        if ("true".equals(FW_ConfigMgr.getGoogleCloudStorageExport())) {
            uploadScreenshots();
        }
    }

    /**
     * Upload the screenshot files directly to Google Cloud Storage bucket.
     */
    public static void uploadScreenshots() {

        System.out.println("");
        System.out.println(FW_ConsoleColors.CORAL + "- - - - - Google Cloud - Screenshot Export - (Begin) - - - - -" + FW_ConsoleColors.RESET);
        System.out.println("");

        // ===================== Required testConfig.properties Check - Begin =====================
        System.out.println(FW_ConsoleColors.CORAL + "- Check required testConfig.properties parameters exist..." + FW_ConsoleColors.RESET);

        // Get googleCloudProjectId from testConfig.properties
        String googleCloudProjectId = FW_ConfigMgr.getGoogleCloudProjectId();
        if (googleCloudProjectId != null) {
            System.out.println(FW_ConsoleColors.GREEN + "  - PASS: googleCloudProjectId configured in testConfig.properties" + FW_ConsoleColors.RESET);
        } else {
            System.err.println(FW_ConsoleColors.RED + "  - FAIL: googleCloudProjectId not configured in testConfig.properties" + FW_ConsoleColors.RESET);
            return;
        }

        // Get googleCloudStorageBucket from testConfig.properties
        String bucketName = FW_ConfigMgr.getGoogleCloudStorageBucket();
        if (bucketName != null) {
            System.out.println(FW_ConsoleColors.GREEN + "  - PASS: googleCloudStorageBucket '" + bucketName + "' configured in testConfig.properties" + FW_ConsoleColors.RESET);
        } else {
            System.err.println(FW_ConsoleColors.RED + "  - FAIL: googleCloudStorageBucket not configured in testConfig.properties" + FW_ConsoleColors.RESET);
            return;
        }

        // Get screenCaptureOutputPath from testConfig.properties
        String screenCaptureOutputPath = FW_ConfigMgr.getScreenCaptureOutputPath();
        if (screenCaptureOutputPath != null) {
            System.out.println(FW_ConsoleColors.GREEN + "  - PASS: screenCaptureOutputPath '" + screenCaptureOutputPath + "' configured in testConfig.properties" + FW_ConsoleColors.RESET);
        } else {
            System.err.println(FW_ConsoleColors.RED + "  - FAIL: screenCaptureOutputPath not configured in testConfig.properties" + FW_ConsoleColors.RESET);
            return;
        }

        // Get screenCaptureArchivePath from testConfig.properties
        String screenCaptureArchivePath = FW_ConfigMgr.getScreenCaptureArchivePath();
        if (screenCaptureArchivePath != null) {
            System.out.println(FW_ConsoleColors.GREEN + "  - PASS: screenCaptureArchivePath '" + screenCaptureArchivePath + "' configured in testConfig.properties" + FW_ConsoleColors.RESET);
        } else {
            System.err.println(FW_ConsoleColors.RED + "  - FAIL: screenCaptureArchivePath not configured in testConfig.properties" + FW_ConsoleColors.RESET);
            return;
        }

        // Get the googleCloudServiceAccountJsonFile from testConfig.properties
        String googleCloudServiceAccountJsonFile = FW_ConfigMgr.getGoogleCloudServiceAccountJsonFile();
        if (googleCloudServiceAccountJsonFile != null) {
            System.out.println(FW_ConsoleColors.GREEN + "  - PASS: googleCloudServiceAccountJsonFile '" + googleCloudServiceAccountJsonFile + "' configured in testConfig.properties" + FW_ConsoleColors.RESET);
        } else {
            System.err.println(FW_ConsoleColors.RED + "  - FAIL: googleCloudServiceAccountJsonFile not configured in testConfig.properties" + FW_ConsoleColors.RESET);
            return;
        }

        // ===================== Required testConfig.properties Check - End =====================

        // ===================== Required files & folders Check - Begin =====================

        System.out.println(FW_ConsoleColors.CORAL + "- Check required files and folders exist..." + FW_ConsoleColors.RESET);

        // Check if the screenCaptureOutputPath exists
        if (FW_FileDirUtils.fileExists(screenCaptureOutputPath)) {
            System.out.println(FW_ConsoleColors.GREEN + "  - PASS: Screen Capture Output Path exist at '" + screenCaptureOutputPath.toString() + "'" + FW_ConsoleColors.RESET);
        } else {
            System.err.println(FW_ConsoleColors.RED + "  - FAIL: Screen Capture Output Path does not exist at " + screenCaptureOutputPath.toString() + FW_ConsoleColors.RESET);
            return;
        }

        // ===================== Required files & folders Check - End =====================

        // ===================== Google Cloud - Access API Key - Begin =====================
        System.out.println(FW_ConsoleColors.CORAL + "- Google Cloud - Access API Key..." + FW_ConsoleColors.RESET);

        // Get the service account credentials
        GoogleCredentials credentials;
        try (FileInputStream serviceAccountStream = new FileInputStream(googleCloudServiceAccountJsonFile)) {
            credentials = GoogleCredentials.fromStream(serviceAccountStream);
            System.out.println(FW_ConsoleColors.GREEN + "  - PASS: API Key loaded successfully" + FW_ConsoleColors.RESET);
        } catch (IOException e) {
            System.err.println(FW_ConsoleColors.RED + "  - FAIL: Issue encountered loading API Key." + e.getMessage());
            return;
        }

        // ===================== Google Cloud - Access API Key - End =====================

        // ===================== Google Cloud - Access Account - Begin =====================
        System.out.println(FW_ConsoleColors.CORAL + "- Google Cloud - Access Account..." + FW_ConsoleColors.RESET);

        // Create a Google Cloud Storage client instance with the service account credentials and Project ID
        Storage storage = StorageOptions.newBuilder().setCredentials(credentials).setProjectId(googleCloudProjectId).build().getService();

        // Verify Google Cloud Storage credentials work
        try {

            // List the buckets in the project
            System.out.println(FW_ConsoleColors.GREEN + "    - Buckets in project: " + googleCloudProjectId + FW_ConsoleColors.RESET);
            for (com.google.cloud.storage.Bucket bucket : storage.list().iterateAll()) {
                System.out.println(FW_ConsoleColors.GREEN + "      - " + bucket.getName() + FW_ConsoleColors.RESET);
            }
            System.out.println(FW_ConsoleColors.GREEN + "  - PASS: Google Cloud Storage credentials verified and working" + FW_ConsoleColors.RESET);
        } catch (Exception e) {
            System.err.println(FW_ConsoleColors.RED + "  - FAIL: Google Cloud Storage credentials verification failed and not working." + e.getMessage());
            return;
        }

        // ===================== Google Cloud - Access Account - End =====================

        // ===================== Google Cloud - Verify Bucket - Begin =====================
        System.out.println(FW_ConsoleColors.CORAL + "- Google Cloud - Verify Bucket..." + FW_ConsoleColors.RESET);

        // Check if the bucket exists
        boolean bucketExists = false;
        if (FW_GoogleCloudUtils.checkGoogleCloudStorageBucketExist(storage, bucketName) == true) {
            bucketExists = true;
            System.out.println(FW_ConsoleColors.GREEN + "  - PASS: Bucket '" + bucketName + "' exists" + FW_ConsoleColors.RESET);
        }

        // Create the bucket if it does not exist and return the bucket object
        if (bucketExists == false) {
            System.out.println(FW_ConsoleColors.CORAL + "  - Creating bucket '" + bucketName + "'..." + FW_ConsoleColors.RESET);

            Bucket bucket = FW_GoogleCloudUtils.createGoogleCloudStorageBucket(storage, bucketName);

            if (bucket != null) {
                System.out.println(FW_ConsoleColors.GREEN + "  - PASS: Bucket '" + bucketName + "' created successfully" + FW_ConsoleColors.RESET);
            } else {
                System.err.println(FW_ConsoleColors.RED + "  - FAIL: Bucket '" + bucketName + "' creation failed" + FW_ConsoleColors.RESET);
                return;
            }
        }

        // ===================== Google Cloud - Verify Bucket - End =====================

        // ===================== Google Cloud - Get Files to Upload - Begin =====================
        System.out.println(FW_ConsoleColors.CORAL + "- Google Cloud - Inventory Files to Upload..." + FW_ConsoleColors.RESET);

        // Get the list of files to upload
        List<FileInfo> filesToUpload = FW_FileDirUtils.findFiles(screenCaptureOutputPath, ".jpg, .png", false);

        // Get the count of files to upload
        int fileCount = filesToUpload.size();

        if (fileCount > 0) {
            System.out.println(FW_ConsoleColors.GREEN + "  - PASS: " + fileCount + " files found to upload" + FW_ConsoleColors.RESET);
        } else {

            System.out.println(FW_ConsoleColors.GREEN + "  - INFO: No screenshots to upload" + FW_ConsoleColors.RESET);

            System.out.println("");
            System.out.println(FW_ConsoleColors.CORAL + "- - - - - Google Cloud - Screenshot Export - (End) - - - - -" + FW_ConsoleColors.RESET);
            System.out.println("");

            return;
        }

        // ===================== Google Cloud - Get Files to Upload - End =====================

        // ===================== Google Cloud - Upload Files - Begin =====================
        System.out.println(FW_ConsoleColors.CORAL + "- Google Cloud - Upload Files..." + FW_ConsoleColors.RESET);

        // Upload the files to Google Cloud Storage
        for (FileInfo fileObj : filesToUpload) {

            // Get the file name
            String fileName = fileObj.getFileName();

            // Get the file path
            String filePath = fileObj.getFilePath();

            // Get the file size
            double fileSize = fileObj.getFileSizeKB();

            // Report the file being uploaded
            System.out.println(FW_ConsoleColors.CORAL + "  - Uploading file '" + fileName + "' (" + fileSize + " bytes)..." + FW_ConsoleColors.RESET);

            // Upload the file to Google Cloud Storage
            Blob blob = FW_GoogleCloudUtils.uploadFileToGoogleCloudStorageBucket(storage, bucketName, fileObj);

            // Check if the file was uploaded successfully

            if (blob != null) {
                System.out.println(FW_ConsoleColors.GREEN + "    - PASS: File '" + fileName + "' uploaded successfully" + FW_ConsoleColors.RESET);

                // Move the file to the archive folder
                Boolean moveResult = FW_FileDirUtils.fileMove(filePath, screenCaptureArchivePath, fileName,fileName, true, "overwrite");

                if (moveResult == true) {
                    System.out.println(FW_ConsoleColors.GREEN + "    - PASS: File '" + fileName + "' moved to archive folder" + FW_ConsoleColors.RESET);
                } else {
                    System.err.println(FW_ConsoleColors.RED + "    - FAIL: File '" + fileName + "' failed to move to archive folder" + FW_ConsoleColors.RESET);
                }

            } else {
                System.err.println(FW_ConsoleColors.RED + "    - FAIL: File '" + fileName + "' failed to upload" + FW_ConsoleColors.RESET);
            }
        }

        // ===================== Google Cloud - Upload Files - End =====================

        System.out.println("");
        System.out.println(FW_ConsoleColors.CORAL + "- - - - - Google Cloud - Screenshot Export - (End) - - - - -" + FW_ConsoleColors.RESET);
        System.out.println("");

    }

}