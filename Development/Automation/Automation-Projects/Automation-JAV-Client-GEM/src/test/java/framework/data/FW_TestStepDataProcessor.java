package framework.data;

import java.lang.reflect.Field;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

import framework.junit.FW_TestStep;
import framework.utilities.FW_CSVUtils;
import framework.utilities.FW_ConfigMgr;

/**
 * @file FW_DataProcessor.java
 * @description Processes test step data and writes it to CSV files.
 * 
 * This file contains the FW_DataProcessor class which provides methods to process test step data and write it to CSV files.
 * It includes functionalities to handle batch processing of test steps, convert test step objects to CSV rows, and manage the writing of data to CSV files.
 * 
 * The FW_DataProcessor class offers functionalities to:
 * - Enable or disable batch processing of test steps.
 * - Define the batch size for processing.
 * - Convert test step objects to CSV rows.
 * - Write processed test step data to CSV files.
 * 
 * This class is designed to facilitate the processing and storage of test step data, ensuring that test results are consistently and accurately recorded in CSV files.
 * 
 * @version 1.1
 * @since 2025-01-09
 */

public class FW_TestStepDataProcessor {

    // Flag to enable or disable batch processing
    private boolean batchProcessing;
    private int batchSize;
    private FW_CSVUtils csvUtils;

    /**
     * Initializes a new instance of the FW_DataProcessor class with the specified batch processing and batch size.
     * 
     * @param batchProcessing Flag to enable or disable batch processing.
     * @param batchSize The batch size for processing test steps.
     */
    public FW_TestStepDataProcessor(boolean batchProcessing, int batchSize) {
        this.batchProcessing = batchProcessing;
        this.batchSize = batchSize;

        // Initialize the CSV writer utility
        Path csvPath = Paths.get(FW_ConfigMgr.getDataOutputPath(), FW_ConfigMgr.getDataTestStepsFilename());
        this.csvUtils = new FW_CSVUtils(csvPath);
    }

    /**
     * Returns whether batch processing is enabled.
     * 
     * @return true if batch processing is enabled, false otherwise.
     */
    public boolean isBatchProcessing() {
        return batchProcessing;
    }

    /**
     * Returns the batch size for processing test steps.
     * 
     * @return The batch size for processing test steps.
     */
    public int getBatchSize() {
        return batchSize;
    }

    /**
     * Processes the test steps queue and writes the data to a CSV file.
     * 
     * @param testStepQueue The queue containing test steps to be processed.
     */ 
    public void processTestSteps(ConcurrentLinkedQueue<FW_TestStep> testStepQueue) {
        // Convert test steps to CSV rows
        List<String[]> data = new ArrayList<>();

        // Process the test steps queue
        while (!testStepQueue.isEmpty()) {
            // Retrieve and remove the test step from the queue
            FW_TestStep testStep = testStepQueue.poll();

            // Convert the test step to a CSV row
            data.add(convertTestStepToRow(testStep));
        }

        // Write the test steps data to a CSV file
        csvUtils.writeTestSteps(data);
    }

    /**
     * Converts a test step object to a CSV row.
     * 
     * @param testStep The test step object to be converted.
     * 
     * @return A string array representing the CSV row.
     */
    private String[] convertTestStepToRow(FW_TestStep testStep) {
        // Get all fields of the FW_TestStep class
        Field[] fields = FW_TestStep.class.getDeclaredFields();

        // Create a string array to store the row data
        String[] row = new String[fields.length];

        // Iterate through the fields and extract the data
        for (int i = 0; i < fields.length; i++) {
            // Set the field accessible
            fields[i].setAccessible(true);

            try {
                // Get the field value and convert it to a string
                row[i] = fields[i].get(testStep).toString();
            } catch (IllegalAccessException e) {
                // Handle the exception
                row[i] = "";
            }
        }
        // Return the row data
        return row;
    }
}