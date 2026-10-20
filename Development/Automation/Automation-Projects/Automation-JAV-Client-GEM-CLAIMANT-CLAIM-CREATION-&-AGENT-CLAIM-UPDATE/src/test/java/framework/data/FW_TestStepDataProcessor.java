package framework.data;

import java.io.IOException;

// ===============================================================
// @file: FW_TestStepDataProcessor.java
// @filepath: src/test/java/framework/data/FW_TestStepDataProcessor.java
// @version: 2.0.0
// @updated: 2025-01-10 11:35:00 AM CST
// @author: Greg Paskal
// @company: MissionWares
//
// @description:
// Processes test step data and writes it to CSV files. This class handles the
// conversion of FW_TestStep objects into CSV rows and manages the writing of
// this data to configured output files. Designed to work with concurrent queues,
// allowing batch processing of test steps for improved performance. Uses
// reflection to dynamically extract field values from test step objects,
// ensuring flexibility as the test step structure evolves.
//
// @dependencies:
// - framework.junit.FW_TestStep
// - framework.utilities.FW_CSVUtils
// - framework.utilities.FW_ConfigMgr
// - java.util.concurrent.ConcurrentLinkedQueue
// - java.lang.reflect.Field
//
// @methods:
// - isBatchProcessing(): Checks if batch processing is enabled
// - getBatchSize(): Returns the configured batch size
// - processTestSteps(ConcurrentLinkedQueue): Writes test steps from queue to CSV
// - convertTestStepToRow(FW_TestStep): Converts test step to CSV row via reflection
//
// @configuration:
// Uses the following from testConfig.properties:
// - dataOutputPath: Directory for CSV output
// - dataTestStepsFilename: Name of the CSV file
//
// @tags: data-processing, csv-export, batch-processing, reflection, mAi™
//
// @changeLog:
// Date        Author          Version  Description
// ----------  --------------  -------  --------------------------
// 2025-01-09  G. Paskal       1.1.0    Initial creation
// 2025-08-20  G. Paskal       1.2.0    Made convertTestStepToRow null-safe
// 2025-01-10  G. Paskal       2.0.0    Added mAi™ header and enhanced documentation
// ===============================================================

import java.lang.reflect.Field;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

import framework.junit.FW_TestStep;
import framework.utilities.FW_CSVUtils;
import framework.utilities.FW_ConfigMgr;
import framework.utilities.FW_ConsoleColors;

/**
 * Processes test step data and writes it to a CSV file.
 */
public class FW_TestStepDataProcessor {

    // Flag to enable or disable batch processing.
    private final boolean batchProcessing;

    // The number of test steps to collect before processing.
    private final int batchSize;

    // The utility for writing data to the CSV file.
    private final FW_CSVUtils csvUtils;

    /**
     * Initializes a new processor with the specified batch processing settings.
     *
     * @param batchProcessing {@code true} to enable batching; {@code false} for immediate processing.
     * @param batchSize The number of test steps in a batch.
     */
    public FW_TestStepDataProcessor(boolean batchProcessing, int batchSize) {
        this.batchProcessing = batchProcessing;
        this.batchSize = batchSize;

        // Initialize the CSV writer utility with the configured output path.
        Path csvPath = Paths.get(FW_ConfigMgr.getDataOutputPath(), FW_ConfigMgr.getDataTestStepsFilename());
        this.csvUtils = new FW_CSVUtils(csvPath);
    }

    /**
     * Checks if batch processing is enabled for this processor.
     *
     * @return {@code true} if batch processing is enabled, otherwise {@code false}.
     */
    public boolean isBatchProcessing() {
        return batchProcessing;
    }

    /**
     * Returns the configured batch size for processing test steps.
     *
     * @return The number of steps per batch.
     */
    public int getBatchSize() {
        return batchSize;
    }

    /**
     * Processes test steps from a queue and writes them to a CSV file.
     *
     * <p>This method drains all items from the provided queue, converts each {@link FW_TestStep}
     * into a CSV row, and then writes the complete list of rows to the file.
     *
     * @param testStepQueue The queue containing test steps to be processed.
     */
    public void processTestSteps(ConcurrentLinkedQueue<FW_TestStep> testStepQueue) {
        // Prepare a list to hold the CSV rows.
        List<String[]> data = new ArrayList<>();

        // Process the test steps queue.
        while (!testStepQueue.isEmpty()) {
            // Retrieve and remove a test step from the queue.
            FW_TestStep testStep = testStepQueue.poll();

            // Convert the test step to a CSV row.
            data.add(convertTestStepToRow(testStep));
        }

        // Write the collected data to the CSV file.
        try {
            csvUtils.writeTestSteps(data);
        } catch (IOException e) {
            System.err.println(FW_ConsoleColors.RED + "⚠️  ERROR: Failed to write test steps to CSV. " + data.size() + " test steps were not saved. " + "Error: " + e.getMessage() + FW_ConsoleColors.RESET);
            // Continue execution - don't throw
        }
    }

    /**
     * Converts a single test step object into a CSV row using reflection.
     *
     * @param testStep The test step object to be converted.
     * @return A string array representing the CSV row.
     */
    private String[] convertTestStepToRow(FW_TestStep testStep) {
        // Get all fields of the FW_TestStep class using reflection.
        Field[] fields = FW_TestStep.class.getDeclaredFields();

        // Create a string array to store the row data.
        String[] row = new String[fields.length];
        
        // Iterate through each field and extract its value.
        for (int i = 0; i < fields.length; i++) {
            // Set the field to be accessible.
            fields[i].setAccessible(true);

            try {
                // Get the field value and convert it to a string, safely handling nulls.
                Object value = fields[i].get(testStep);
                row[i] = (value != null) ? value.toString() : ""; // Safely handle null values
            } catch (IllegalAccessException e) {
                // Handle the exception by logging an error and providing a default value.
                System.err.println("Error accessing field via reflection: " + fields[i].getName());
                e.printStackTrace();
                row[i] = "";
            }
        }
        // Return the final CSV row.
        return row;
    }
}