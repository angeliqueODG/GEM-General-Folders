package framework.utilities;

// ===============================================================
// @file: FW_CSVUtils.java
// @filepath: src/test/java/framework/utilities/FW_CSVUtils.java
// @version: 1.2.0
// @updated: 2025-01-10 03:14:00 PM CST
// @author: Greg Paskal
// @company: MissionWares
//
// @description:
// Provides utility methods for reading and writing data to CSV files.
// This class facilitates CSV file operations including file creation,
// header management, data writing, and validation. Designed specifically
// for generating CSV reports, logging test results, and handling
// structured data output. Features automatic header verification and
// dynamic header generation based on FW_TestStep class fields using
// reflection.
//
// @methods:
// - FW_CSVUtils(Path) - Constructor with output path
// - initializeCSV() - Creates directories and writes header if needed
// - getRowCount(String) - Returns row count of CSV file
// - getHeader() - Generates header from FW_TestStep fields
// - verifyHeader() - Validates CSV header matches expected format
// - outputHeadersToTerminal(String[], String[]) - Displays header comparison
// - createNewHeaderCSV() - Creates new CSV with updated header
// - writeTestSteps(List<String[]>) - Writes test step data to CSV
//
// @dependencies:
// - java.io.FileWriter
// - java.io.IOException
// - java.lang.reflect.Field
// - java.nio.file.Files
// - java.nio.file.Path
// - java.util.List
// - com.opencsv.CSVWriter
// - framework.junit.FW_TestStep
//
// @tags: csv, file-io, data-export, reporting, mAi™
//
// @changeLog:
// Date        Author          Version  Description
// ----------  --------------  -------  --------------------------
// 2025-01-09  G. Paskal       1.0.0    Initial implementation
// 2025-01-09  G. Paskal       1.1.0    Added header verification
// 2025-01-10  G. Paskal       1.2.0    Added mAi™ header standard
// ===============================================================

import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import com.opencsv.CSVWriter;

import framework.junit.FW_TestStep;

/**
 * Provides utility methods for reading and writing data to CSV files.
 */
public class FW_CSVUtils {

    private final Path outputPath;

    /**
     * Constructs a new FW_CSVUtils with the specified output path.
     *
     * @param outputPath the path to the CSV file where test step data will be written
     */
    public FW_CSVUtils(Path outputPath) {
        this.outputPath = outputPath;
        initializeCSV();
    }

    /**
     * Initializes the CSV file by creating the necessary directories and writing the header row if the file does not exist.
     */
    private void initializeCSV() {
        try {
            // Create the necessary directories if they do not exist
            if (!Files.exists(outputPath)) {
                Files.createDirectories(outputPath.getParent());

                // Write the header row to the CSV file
                try (CSVWriter writer = new CSVWriter(new FileWriter(outputPath.toFile()))) {
                    writer.writeNext(getHeader());
                }
            }
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
            for (StackTraceElement element : e.getStackTrace()) {
                System.err.println("  at " + element);
            }
        }
    }

    /**
     * Get the CSV file row count
     * 
     * @param csvFileNamePath the path to the CSV file
     * 
     * @return the number of rows in the CSV files
     */
    public static int getRowCount(String csvFileNamePath) throws IOException {

        // Convert the string path to a Path object
        Path csvFileNamePathObj = Path.of(csvFileNamePath);

        // Read all lines from the CSV file
        List<String> lines = Files.readAllLines(csvFileNamePathObj);

        // Calculate the number of rows
        int rowCount = lines.size();

        // Return the number of rows in the CSV file
        return rowCount;
    }

    /**
     * Generates the header row for the CSV file based on the fields of the FW_TestStep class.
     *
     * @return an array of strings representing the header row
     */
    private String[] getHeader() {
        Field[] fields = FW_TestStep.class.getDeclaredFields();
        String[] headers = new String[fields.length];

        // Get the names of the fields
        for (int i = 0; i < fields.length; i++) {
            // Set the header to the field name
            headers[i] = fields[i].getName();
        }
        return headers;
    }

    /**
     * Verifies that the header row in the existing CSV file matches the expected header row.
     * If the headers do not match, outputs the headers to the terminal and creates a new CSV file with the new header.
     *
     * @return true if the header row matches, false otherwise
     */
    private boolean verifyHeader() {
        try {
            // Read the first line of the CSV file
            List<String> lines = Files.readAllLines(outputPath);

            // Check if the file is not empty
            if (!lines.isEmpty()) {
                // Split the header row into an array of strings
                String[] existingHeader = lines.get(0).split(",");

                // Get the new header row
                String[] newHeader = getHeader();

                // Check if the header lengths match
                if (existingHeader.length != newHeader.length) {
                    // Report the mismatch and output the headers
                    System.out.println("Header length mismatch: expected " + newHeader.length + " but found " + existingHeader.length);
                    outputHeadersToTerminal(existingHeader, newHeader);
                    createNewHeaderCSV();
                    return false;
                }

                // Loop through the headers and compare them
                for (int i = 0; i < existingHeader.length; i++) {
                    // Remove leading and trailing double quotes
                    String existingHeaderValue = existingHeader[i].replaceAll("^\"|\"$", ""); // Remove leading and trailing double quotes
                    
                    // Check if the headers do not match
                    if (!existingHeaderValue.equals(newHeader[i])) {
                        // Report the mismatch and output the headers
                        System.out.println("Header mismatch at index " + i + ": expected " + newHeader[i] + " but found " + existingHeader[i]);
                        outputHeadersToTerminal(existingHeader, newHeader);
                        createNewHeaderCSV();
                        return false;
                    }
                }
            }
        } catch (IOException e) {
            System.err.println(FW_ConsoleColors.RED + "Failed to verify CSV header. Could not read file: '" + outputPath + "'. Error: " + e.getMessage() + FW_ConsoleColors.RESET);
            return false;
        }
        return true;
    }

    /**
     * Outputs the existing and new headers to the terminal for visual comparison.
     *
     * @param existingHeader the existing header row in the CSV file
     * @param newHeader the new header row expected
     */
    private void outputHeadersToTerminal(String[] existingHeader, String[] newHeader) {
        System.out.println("Existing Header:");
        for (String header : existingHeader) {
            System.out.print(header + " ");
        }
        System.out.println("\nNew Header:");
        for (String header : newHeader) {
            System.out.print(header + " ");
        }
        System.out.println();
    }

    /**
     * Creates a new CSV file with the new header row.
     */
    private void createNewHeaderCSV() {
        // Create a new file with the new header
        Path newPath = outputPath.getParent().resolve("test-steps-new-header.csv");

        // Write the new header to the file
        try (CSVWriter writer = new CSVWriter(new FileWriter(newPath.toFile()))) {
            writer.writeNext(getHeader());
        } catch (IOException e) {
            System.err.println(FW_ConsoleColors.RED + "Failed to create new header CSV file at: '" + newPath + "'. Error: " + e.getMessage() + FW_ConsoleColors.RESET);
        }
    }

    /**
     * Writes the provided test step data to the CSV file. If the header row does not match the expected format, an exception is thrown.
     *
     * @param data a list of string arrays representing the test step data to be written
     */
    public void writeTestSteps(List<String[]> data) throws IOException {
        // Verify the header before writing the data
        if (!verifyHeader()) {
            throw new IllegalStateException("CSV header does not match the expected format.");
        }
        
        // Write the data to the CSV file
        try (CSVWriter writer = new CSVWriter(new FileWriter(outputPath.toFile(), true))) {
            writer.writeAll(data);
        } catch (IOException e) {
            throw new IOException("Failed to write test steps to CSV file: '" + outputPath + "'. Error: " + e.getMessage(), e);
        }
    }
}