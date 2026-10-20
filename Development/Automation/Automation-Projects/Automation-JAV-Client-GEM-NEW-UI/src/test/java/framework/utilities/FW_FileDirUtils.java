// This class contains file and directory utilities
package framework.utilities;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Contains file and directory utilities.
 */
public class FW_FileDirUtils {

    /**
     * Checks if a file exists at the specified path.
     * 
     * @param filePath The path of the file to check.
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
     * Finds files in the specified directory that contain the given keyword in their name and end with .java.
     * 
     * @param directory The directory to search in.
     * @param keyword The keyword to filter files by.
     * @param recursive Whether to search directories recursively.
     * @return A list of FileInfo objects matching the criteria.
     */
    public static List<FileInfo> findFiles(String directory, String keyword, boolean recursive) {
        List<FileInfo> fileInfos = new ArrayList<>();
        File dir = new File(directory);
        if (dir.exists() && dir.isDirectory()) {
            File[] files = dir.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isDirectory() && recursive) {
                        fileInfos.addAll(findFiles(file.getAbsolutePath(), keyword, true));
                    } else if (file.getName().contains(keyword) && file.getName().endsWith(".java")) {
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

                            fileInfos.add(new FileInfo(filePath, fileName, lastModified, fileSizeKB, fileExtension, isDirectory, isHidden, isReadable, isWritable, isExecutable, filePathName));
                        } catch (IOException e) {
                            e.printStackTrace();
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