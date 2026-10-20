package framework.utilities;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import com.opencsv.CSVWriter;

import framework.junit.FW_TestStep;

/**
 * @file FW_CSVUtils.java
 * @description Provides utility methods for reading and writing data to CSV files.
 * 
 * This file contains the FW_CSVUtils class which provides methods to facilitate reading and writing data to CSV files.
 * It includes functionalities to create CSV files, write headers, append rows of data, and handle file I/O operations.
 * 
 * The FW_CSVUtils class offers functionalities to:
 * - Create and initialize CSV files with specified headers.
 * - Append rows of data to existing CSV files.
 * - Handle file I/O operations efficiently.
 * - Ensure data is written in a consistent and structured format.
 * 
 * This class is designed to be used for generating CSV reports, logging test results, and any other operations
 * that require structured data to be written to CSV files.
 * 
 * @version 1.2
 * @since 2025-01-09
 */
public class FW_CSVUtils {

    private Path outputPath;

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
            // Handle the exception appropriately
            e.printStackTrace();
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
            // Handle the exception appropriately
            e.printStackTrace();
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
            // Handle the exception appropriately
            e.printStackTrace();
        }
    }

    /**
     * Writes the provided test step data to the CSV file. If the header row does not match the expected format, an exception is thrown.
     *
     * @param data a list of string arrays representing the test step data to be written
     */
    public void writeTestSteps(List<String[]> data) {
        // Verify the header before writing the data
        if (!verifyHeader()) {
            throw new IllegalStateException("CSV header does not match the expected format.");
        }
        // Write the data to the CSV file
        try (CSVWriter writer = new CSVWriter(new FileWriter(outputPath.toFile(), true))) {
            writer.writeAll(data);
        } catch (IOException e) {
            // Handle the exception appropriately
            e.printStackTrace();
        }
    }
}