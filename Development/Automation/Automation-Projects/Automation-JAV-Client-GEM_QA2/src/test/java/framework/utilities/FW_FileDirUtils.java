package framework.utilities;

// ===============================================================
// @file: FW_FileDirUtils.java
// @filepath: src/test/java/framework/utilities/FW_FileDirUtils.java
// @version: 1.0.0
// @updated: 2025-01-10 03:16:00 PM CST
// @author: Greg Paskal
// @company: MissionWares
//
// @description:
// Contains file and directory utilities for the test automation framework.
// This class provides comprehensive file and directory operations including
// file existence checking, directory creation, file searching with recursive
// support, file moving/copying with various modes, size calculations, and
// byte array conversions. Includes a FileInfo inner class for detailed file
// metadata and a Builder pattern for flexible FileInfo construction.
//
// @methods:
// - getFileName(String) - Extracts filename without path and extension
// - getFileExtension(String) - Extracts file extension only
// - getFilePath(String) - Extracts file path only
// - createDirectory(String) - Creates directory if not exists
// - getFileSizeInBytes(String, String) - Returns file size in bytes
// - getByteArrayFromFile(String) - Converts file to byte array
// - fileMove(...) - Moves/copies files with overwrite/append options
// - fileExists(String) - Checks if file exists
// - findFiles(String, String, boolean) - Searches files with keywords
// - getFileExtension(File) - Gets extension from File object
//
// @dependencies:
// - java.io.File
// - java.io.IOException
// - java.io.Serializable
// - java.nio.file.*
// - java.util.*
// - framework.utilities.FW_ConsoleColors
//
// @tags: file-operations, directory, file-search, file-management, mAi™
//
// @changeLog:
// Date        Author          Version  Description
// ----------  --------------  -------  --------------------------
// 2025-01-10  G. Paskal       1.0.0    Initial implementation with mAi™ header
// ===============================================================

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.List;
import java.util.Objects;

/**
 * Contains file and directory utilities.
 */
public class FW_FileDirUtils {

    /**
     * Get the file name only from the full path excluding the path and file extension
     * @param fileName
     * 
     * @return the file name only
     */
    public static String getFileName(String fileName) {

        // Get ready for transformation
        String fileNameOnly = fileName;

        // Remove the extension if fileNameOnly is not empty and contains a dot
        if (!fileNameOnly.isEmpty() && fileNameOnly.contains(".")) {
            fileNameOnly = fileNameOnly.substring(0, fileNameOnly.lastIndexOf("."));
        }

        // Remove the path if fileNameOnly is not empty and contains a slash
        if (!fileNameOnly.isEmpty() && fileNameOnly.contains("/")) {
            fileNameOnly = fileNameOnly.substring(fileNameOnly.lastIndexOf("/") + 1);
        }

        // Return the image name only
        return fileNameOnly;
    }

    /**
     * Get the file extension only from the full file path excluding the path,name and dot.
     * @param fileName
     * 
     * @return the file extension only excluding the dot
     */
    public static String getFileExtension(String fileName) {

        // Get ready for transformation
        String fileExtensionOnly = fileName;

        // Remove the path if fileExtensionOnly is not empty and contains a slash
        if (!fileExtensionOnly.isEmpty() && fileExtensionOnly.contains("/")) {
            fileExtensionOnly = fileExtensionOnly.substring(fileExtensionOnly.lastIndexOf("/") + 1);
        }

        // Remove the name if fileExtensionOnly is not empty and contains a dot
        if (!fileExtensionOnly.isEmpty() && fileExtensionOnly.contains(".")) {
            fileExtensionOnly = fileExtensionOnly.substring(fileExtensionOnly.lastIndexOf(".") + 1);
        }
        
        // Return the file extension only
        return fileExtensionOnly;
    }

    /**
     * Get the file path only from the full file path excluding the file name and extension and the last slash.
     * @param filePath
     * 
     * @return the file path only
     */
    public static String getFilePath(String filePath) {

        // Get ready for transformation
        String filePathOnly = filePath;

        // Remove filename and extension if filePathOnly is not empty and contains a dot
        if (!filePathOnly.isEmpty() && filePathOnly.contains(".")) {
            filePathOnly = filePathOnly.substring(0, filePathOnly.lastIndexOf("."));
        }

        // Ensure the file path ends with a slash
        if (!filePathOnly.isEmpty() && !filePathOnly.endsWith("/")) {
            filePathOnly += "/";
        }

        // Return the file path only
        return filePathOnly;
    }

    /**
     * Create a new file path directory if it does not exist
     * @param filePath
     * 
     * @return true if directory was created or already exists, false if directory could not be created
     */
    public static boolean createDirectory(String filePath) {

        // Create a new file object
        File directory = new File(filePath);

        // Check if directory exists
        if (directory.exists() == false) {

            // Directory does not exist, create it
            directory.mkdirs();

            // Confirm directory was created
            if (directory.exists() == false) {
                System.err.println(FW_ConsoleColors.RED + "Directory could not be created: " + filePath + FW_ConsoleColors.RESET);
                return false;
            }
        }
        return true;
    }

    /**
     * Gets the file size in bytes
     *
     * @param fileName Name of the file including the extension
     * @param filePath Filepath where the file is stored excluding the file name
     * 
     * @return File size in bytes
     */
    public static long getFileSizeInBytes(String fileName, String filePath) {
        // Check if filepath ends with a slash and add it if not
        filePath = filePath.endsWith("/") ? filePath : filePath + "/";

        // Check if filepath exists
        if (fileExists(filePath) == false) {
            System.err.println(FW_ConsoleColors.RED + "Filepath does not exist: " + filePath + FW_ConsoleColors.RESET);
            return -1;
        }

        // Check if file exists
        String fullFilepath = filePath + fileName; // Configure the full filepath
        if (fileExists(fullFilepath) == false) {
            System.err.println(FW_ConsoleColors.RED + "File does not exist: " + fullFilepath + FW_ConsoleColors.RESET);
            return -1;
        }

        // Get file size
        File file = new File(fullFilepath);
        return file.length();
    }

    /**
     * Get ByteArrayInputStream from a file
     * 
     * @param filePathName The path and name of the file including the extension
     * 
     * @return ByteArray from the file
     * 
     * @throws IOException if the file is not found
     */
    public static byte[] getByteArrayFromFile(String filePathName) throws IOException {

        // Create a new path object
        Path filePathObj = Paths.get(filePathName);

        File fileObj = new File(filePathName);

        // Get the filePath and fileName
        String filePath = filePathObj.getParent().toString();

        // Check if filepath ends with a slash and add it if not
        filePath = filePath.endsWith("/") ? filePath : filePath + "/";

        // Check if filepath exists
        if (fileExists(filePath) == false) {
            System.err.println(FW_ConsoleColors.RED + "Filepath does not exist: " + filePath + FW_ConsoleColors.RESET);
            return null;
        }

        // Check if file exists
        if (fileExists(filePathName) == false) {
            System.err.println(FW_ConsoleColors.RED + "File does not exist: " + filePathName + FW_ConsoleColors.RESET);
            return null;
        }

        // Read the file content into a byte array
        byte[] fileContent = Files.readAllBytes(fileObj.toPath());

        // Return the file content in byte array
        return fileContent;
    }

    /**
     * Moves or copies a file from the source directory to the destination directory.
     * 
     * @param sourceDirectoryPath The path of the source directory.
     * @param destinationDirectoryPath The path of the destination directory.
     * @param sourceFilename The name of the source file.
     * @param destinationFilename The name of the destination file.
     * @param deleteSourceFile If true, deletes the source file after moving; if false, keeps the source file.
     * @param operationMode The operation mode determins what to do if there is an existing destination file: "overwrite", "append", or "" (Warn and don't overwrite).
     * 
     * @return true if the file was successfully moved or copied, false otherwise.
     */
    public static boolean fileMove(String sourceDirectoryPath, String destinationDirectoryPath, String sourceFilename, String destinationFilename, boolean deleteSourceFile, String operationMode) {
        
        // Create the source and destination paths
        Path sourcePath = Paths.get(sourceDirectoryPath, sourceFilename);
        Path destinationPath = Paths.get(destinationDirectoryPath, destinationFilename);

        try {
            // Verify the source file exists
            if (!fileExists(sourcePath.toString())) {
                System.err.println(FW_ConsoleColors.RED + "Source file does not exist: " + sourcePath + FW_ConsoleColors.RESET);
                return false;
            }

            // Ensure the destination directory exists
            Files.createDirectories(destinationPath.getParent());

            // Copy the file to the destination based on the operation mode
            switch (operationMode.toLowerCase()) {
                case "overwrite" -> Files.copy(sourcePath, destinationPath, StandardCopyOption.REPLACE_EXISTING);
                case "append" -> Files.write(destinationPath, Files.readAllBytes(sourcePath), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
                default -> {
                    if (Files.exists(destinationPath)) {
                        System.err.println(FW_ConsoleColors.YELLOW + "Destination file already exists and overwrite is not enabled: " + destinationPath + FW_ConsoleColors.RESET);
                        return false;
                    }
                    Files.copy(sourcePath, destinationPath);
                }
            }

            // If deleteSourceFile is true, delete the source file
            if (deleteSourceFile) {
                Files.delete(sourcePath);
            }

            return true;

        } catch (IOException e) {
            System.err.println(FW_ConsoleColors.RED + "Failed to move file from '" + sourcePath + "' to '" + destinationPath + "'. Operation mode: " + operationMode + ". Error: " + e.getMessage() + FW_ConsoleColors.RESET);
            return false;
        }
    }

    /**
     * Checks if a file exists at the specified path.
     * 
     * @param filePath The path of the file to check.
     * 
     * @return true if the file exists, false otherwise.
     */
    public static boolean fileExists(String filePath) {
        try {
            File file = new File(filePath);
            return file.exists();
        } catch (SecurityException e) {
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Finds files in the specified directory that contain any of the given keywords in their name.
     * 
     * @param directory The directory to search in.
     * @param keywords The comma-separated keywords to filter files by. If an empty string, all files are returned. (.jpg, .png, .txt)
     * @param recursive Whether to search directories recursively. True to search recursively, false otherwise.
     * @return A list of FileInfo objects matching the criteria.
     */
    public static List<FileInfo> findFiles(String directory, String keywords, boolean recursive) {
        List<FileInfo> fileInfos = new ArrayList<>();
        Set<String> filePaths = new HashSet<>();
        File dir = new File(directory);

        // Split the keywords by comma and trim whitespace
        String[] keywordArray = keywords.split(",");
        for (int i = 0; i < keywordArray.length; i++) {
            keywordArray[i] = keywordArray[i].trim();
        }

        if (dir.exists() && dir.isDirectory()) {
            File[] files = dir.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isDirectory() && recursive) {
                        fileInfos.addAll(findFiles(file.getAbsolutePath(), keywords, true));
                    } else {
                        boolean matchesKeyword = keywords.isEmpty();
                        for (String keyword : keywordArray) {
                            if (file.getName().contains(keyword)) {
                                matchesKeyword = true;
                                break;
                            }
                        }
                        if (matchesKeyword && !file.isDirectory()) {
                            try {
                                String filePath = file.getParentFile().getAbsolutePath();
                                String fileName = file.getName();
                                long lastModified = file.lastModified();
                                double fileSizeKB = file.length() / 1024.0;
                                String fileExtension = getFileExtension(file);
                                boolean isDirectory = file.isDirectory();
                                boolean isHidden = file.isHidden();
                                boolean isReadable = file.canRead();
                                boolean isWritable = file.canWrite();
                                boolean isExecutable = file.canExecute();
                                String filePathName = file.getCanonicalPath();

                                // Add to fileInfos if not already added
                                if (filePaths.add(filePathName)) {
                                    fileInfos.add(new FileInfo(filePath, fileName, lastModified, fileSizeKB, fileExtension, isDirectory, isHidden, isReadable, isWritable, isExecutable, filePathName));
                                }
                            } catch (IOException e) {
                                System.err.println(FW_ConsoleColors.YELLOW + "⚠️  Warning: Could not resolve canonical path for file '" + file.getAbsolutePath() + "'. Skipping. Reason: " + e.getMessage() + FW_ConsoleColors.RESET);
                                // Continue processing other files
                            }
                        }
                    }
                }
            }
        }
        return fileInfos;
    }

    /**
     * Returns the file extension of the given file.
     * 
     * @param file The file for which to get the extension.
     * @return The file extension, or an empty string if the file has no extension.
     */
    public static String getFileExtension(File file) {
        String fileName = file.getName();
        int dotIndex = fileName.lastIndexOf('.');
        return (dotIndex == -1) ? "" : fileName.substring(dotIndex + 1);
    }

    /**
     * Represents information about a file.
     */
    public static class FileInfo implements Serializable {
        private static final long serialVersionUID = 1L;

        private String filePath;
        private String fileName;
        private long lastModified;
        private double fileSizeKB;
        private String fileExtension;
        private boolean isDirectory;
        private boolean isHidden;
        private boolean isReadable;
        private boolean isWritable;
        private boolean isExecutable;
        private String filePathName;

        /**
         * Constructs a new FileInfo with the specified details.
         *
         * @param filePath      the path of the file
         * @param fileName      the name of the file
         * @param lastModified  the last modified timestamp of the file
         * @param fileSizeKB    the size of the file in kilobytes
         * @param fileExtension the extension of the file
         * @param isDirectory   whether the file is a directory
         * @param isHidden      whether the file is hidden
         * @param isReadable    whether the file is readable
         * @param isWritable    whether the file is writable
         * @param isExecutable  whether the file is executable
         * @param filePathName  the canonical path of the file
         */
        public FileInfo(String filePath, String fileName, long lastModified, double fileSizeKB, String fileExtension,
                        boolean isDirectory, boolean isHidden, boolean isReadable, boolean isWritable, boolean isExecutable, String filePathName) {
            if (filePath == null || fileName == null) {
                throw new IllegalArgumentException("File path and name cannot be null");
            }
            this.filePath = filePath;
            this.fileName = fileName;
            this.lastModified = lastModified;
            this.fileSizeKB = fileSizeKB;
            this.fileExtension = fileExtension;
            this.isDirectory = isDirectory;
            this.isHidden = isHidden;
            this.isReadable = isReadable;
            this.isWritable = isWritable;
            this.isExecutable = isExecutable;
            this.filePathName = filePathName;
        }

        // Getters
        public String getFilePath() {
            return filePath;
        }

        public String getFileName() {
            return fileName;
        }

        public long getLastModified() {
            return lastModified;
        }

        public double getFileSizeKB() {
            return fileSizeKB;
        }

        public String getFileExtension() {
            return fileExtension;
        }

        public boolean isDirectory() {
            return isDirectory;
        }

        public boolean isHidden() {
            return isHidden;
        }

        public boolean isReadable() {
            return isReadable;
        }

        public boolean isWritable() {
            return isWritable;
        }

        public boolean isExecutable() {
            return isExecutable;
        }

        public String getFilePathName() {
            return filePathName;
        }

        // Equals and hashCode methods
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            FileInfo fileInfo = (FileInfo) o;
            return lastModified == fileInfo.lastModified &&
                    Double.compare(fileInfo.fileSizeKB, fileSizeKB) == 0 &&
                    isDirectory == fileInfo.isDirectory &&
                    isHidden == fileInfo.isHidden &&
                    isReadable == fileInfo.isReadable &&
                    isWritable == fileInfo.isWritable &&
                    isExecutable == fileInfo.isExecutable &&
                    Objects.equals(filePath, fileInfo.filePath) &&
                    Objects.equals(fileName, fileInfo.fileName) &&
                    Objects.equals(fileExtension, fileInfo.fileExtension) &&
                    Objects.equals(filePathName, fileInfo.filePathName);
        }

        @Override
        public int hashCode() {
            return Objects.hash(filePath, fileName, lastModified, fileSizeKB, fileExtension, isDirectory, isHidden, isReadable, isWritable, isExecutable, filePathName);
        }

        /**
         * Builder class for FileInfo.
         */
        public static class Builder {
            private String filePath;
            private String fileName;
            private long lastModified;
            private double fileSizeKB;
            private String fileExtension;
            private boolean isDirectory;
            private boolean isHidden;
            private boolean isReadable;
            private boolean isWritable;
            private boolean isExecutable;
            private String filePathName;

            public Builder setFilePath(String filePath) {
                this.filePath = filePath;
                return this;
            }

            public Builder setFileName(String fileName) {
                this.fileName = fileName;
                return this;
            }

            public Builder setLastModified(long lastModified) {
                this.lastModified = lastModified;
                return this;
            }

            public Builder setFileSizeKB(double fileSizeKB) {
                this.fileSizeKB = fileSizeKB;
                return this;
            }

            public Builder setFileExtension(String fileExtension) {
                this.fileExtension = fileExtension;
                return this;
            }

            public Builder setIsDirectory(boolean isDirectory) {
                this.isDirectory = isDirectory;
                return this;
            }

            public Builder setIsHidden(boolean isHidden) {
                this.isHidden = isHidden;
                return this;
            }

            public Builder setIsReadable(boolean isReadable) {
                this.isReadable = isReadable;
                return this;
            }

            public Builder setIsWritable(boolean isWritable) {
                this.isWritable = isWritable;
                return this;
            }

            public Builder setIsExecutable(boolean isExecutable) {
                this.isExecutable = isExecutable;
                return this;
            }

            public Builder setFilePathName(String filePathName) {
                this.filePathName = filePathName;
                return this;
            }

            public FileInfo build() {
                return new FileInfo(filePath, fileName, lastModified, fileSizeKB, fileExtension, isDirectory, isHidden, isReadable, isWritable, isExecutable, filePathName);
            }
        }
    }
}