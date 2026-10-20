package framework.data;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.bigquery.BigQuery;
import com.google.cloud.bigquery.BigQueryException;
import com.google.cloud.bigquery.BigQueryOptions;
import com.google.cloud.bigquery.Dataset;
import com.google.cloud.bigquery.FormatOptions;
import com.google.cloud.bigquery.InsertAllRequest.RowToInsert;
import com.google.cloud.bigquery.JobInfo.WriteDisposition;
import com.google.cloud.bigquery.Schema;
import com.google.cloud.bigquery.TableId;
import com.google.cloud.bigquery.WriteChannelConfiguration;
import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvValidationException;

import framework.utilities.FW_ConfigMgr;
import framework.utilities.FW_ConsoleColors;
import framework.utilities.FW_DateTimeUtils;
import framework.utilities.FW_FileDirUtils;
import framework.utilities.FW_GoogleCloudUtils;;

/**
 * @file FW_GoogleCloudBigQueryUploader.java
 * @description Handles the uploading of a CSV file directly into a BigQuery table.
 * 
 *              This class provides functionalities to:
 *              - Load a CSV file directly into a specified BigQuery table.
 * 
 *              The class uses the BigQuery client library to perform these operations.
 * 
 * @version 1.0
 * @since 2025-01-10
 */
public class FW_GoogleCloudBigQueryUploader {

    /**
     * Main method to handle the uploading of a CSV file to a BigQuery table.
     * 
     * @param args Command-line arguments: <projectId> <datasetName><tableName><serviceAccountJsonFile> <bucketName>
     * @throws IOException          If an I/O error occurs.
     * @throws InterruptedException If the thread is interrupted.
     */
    public static void main(String[] args) throws IOException, InterruptedException {

        // Should we export to BigQuery?
        if ("true".equals(FW_ConfigMgr.getGoogleCloudBigQueryExport())) {
            uploadTestStepsCSV(); // Upload the CSV file to BigQuery
            archiveTestStepsCSV(); // Archive the CSV file after upload
        }
    }

    /**
     * Uploads a CSV file directly into a BigQuery table.
     */
    public static void uploadTestStepsCSV() throws IOException, InterruptedException {

        System.out.println("");
        System.out.println(FW_ConsoleColors.CORAL + "- - - - - Google Cloud - BigQuery Data Export - (Begin) - - - - -" + FW_ConsoleColors.RESET);
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

        // Get googleCloudServiceAccountJsonFile from testConfig.properties
        String googleCloudServiceAccountJsonFile = FW_ConfigMgr.getGoogleCloudServiceAccountJsonFile();
        if (googleCloudServiceAccountJsonFile != null) {
            System.out.println(FW_ConsoleColors.GREEN + "  - PASS: googleCloudServiceAccountJsonFile configured in testConfig.properties" + FW_ConsoleColors.RESET);
        } else {
            System.err.println(FW_ConsoleColors.RED + "  - FAIL: googleCloudServiceAccountJsonFile not configured in testConfig.properties" + FW_ConsoleColors.RESET);
            return;
        }

        // Get dataOutputPath from testConfig.properties
        String dataOutputPath = FW_ConfigMgr.getDataOutputPath();
        if (dataOutputPath != null) {
            System.out.println(FW_ConsoleColors.GREEN + "  - PASS: dataOutputPath configured in testConfig.properties" + FW_ConsoleColors.RESET);
        } else {
            System.err.println(FW_ConsoleColors.RED + "  - FAIL: dataOutputPath not configured in testConfig.properties" + FW_ConsoleColors.RESET);
            return;
        }

        // Get dataTestStepsFilename from testConfig.properties
        String dataTestStepsFilename = FW_ConfigMgr.getDataTestStepsFilename();
        if (dataTestStepsFilename != null) {
            System.out.println(FW_ConsoleColors.GREEN + "  - PASS: dataTestStepsFilename configured in testConfig.properties" + FW_ConsoleColors.RESET);
        } else {
            System.err.println(FW_ConsoleColors.RED + "  - FAIL: dataTestStepsFilename not configured in testConfig.properties" + FW_ConsoleColors.RESET);
            return;
        }

        // Get googleCloudProjectDataset from testConfig.properties
        String googleCloudProjectDataset = FW_ConfigMgr.getGoogleCloudProjectDataset();
        if (googleCloudProjectDataset != null) {
            System.out.println(FW_ConsoleColors.GREEN + "  - PASS: googleCloudProjectDataset configured in testConfig.properties" + FW_ConsoleColors.RESET);
        } else {
            System.err.println(FW_ConsoleColors.RED + "  - FAIL: googleCloudProjectDataset not configured in testConfig.properties" + FW_ConsoleColors.RESET);
            return;
        }

        // Get googleCloudProjectDatasetTableTestSteps from testConfig.properties
        String googleCloudProjectDatasetTableTestSteps = FW_ConfigMgr.getGoogleCloudProjectDatasetTableTestSteps();
        if (googleCloudProjectDatasetTableTestSteps != null) {
            System.out.println(FW_ConsoleColors.GREEN + "  - PASS: googleCloudProjectDatasetTableTestSteps configured in testConfig.properties" + FW_ConsoleColors.RESET);
        } else {
            System.err.println(FW_ConsoleColors.RED + "  - FAIL: googleCloudProjectDatasetTableTestSteps not configured in testConfig.properties" + FW_ConsoleColors.RESET);
            return;
        }

        // Get googleCloudProjectDatasetTableTestStepsSchema from testConfig.properties
        String googleCloudProjectDatasetTableTestStepsSchema = FW_ConfigMgr.getGoogleCloudProjectDatasetTableTestStepsSchema();
        if (googleCloudProjectDatasetTableTestStepsSchema != null) {
            System.out.println(FW_ConsoleColors.GREEN + "  - PASS: googleCloudProjectDatasetTableTestStepsSchema configured in testConfig.properties" + FW_ConsoleColors.RESET);
        } else {
            System.err.println(FW_ConsoleColors.RED + "  - FAIL: googleCloudProjectDatasetTableTestStepsSchema not configured in testConfig.properties" + FW_ConsoleColors.RESET);
            return;
        }

        // ===================== Required testConfig.properties Check - End =====================

        // ===================== Required files Check - Begin =====================
        System.out.println(FW_ConsoleColors.CORAL + "- Check required files exist..." + FW_ConsoleColors.RESET);

        // Check CSV file exists
        Path csvFilePath = Paths.get(dataOutputPath, dataTestStepsFilename);
        if (Files.exists(csvFilePath)) {
            System.out.println(FW_ConsoleColors.GREEN + "  - PASS: CSV file exists at " + csvFilePath.toString() + FW_ConsoleColors.RESET);
        } else {
            System.err.println(FW_ConsoleColors.RED + "  - FAIL: CSV file does not exist at " + csvFilePath.toString() + FW_ConsoleColors.RESET);
            return;
        }

        // Check schema file exists
        Path schemaFilePath = Paths.get(googleCloudProjectDatasetTableTestStepsSchema);
        if (Files.exists(schemaFilePath)) {
            System.out.println(FW_ConsoleColors.GREEN + "  - PASS: Schema file exists at " + schemaFilePath.toString() + FW_ConsoleColors.RESET);
        } else {
            System.err.println(FW_ConsoleColors.RED + "  - FAIL: Schema file does not exist at " + schemaFilePath.toString() + FW_ConsoleColors.RESET);
            return;
        }

        // Check account JSON file exists
        Path serviceAccountJsonFilePath = Paths.get(googleCloudServiceAccountJsonFile);
        if (Files.exists(serviceAccountJsonFilePath)) {
            System.out.println(FW_ConsoleColors.GREEN + "  - PASS: Service Account file exists at " + serviceAccountJsonFilePath.toString() + FW_ConsoleColors.RESET);
        } else {
            System.err.println(FW_ConsoleColors.RED + "  - FAIL: Service Account file does not exist at " + serviceAccountJsonFilePath.toString() + FW_ConsoleColors.RESET);
            return;
        }

        // ===================== Required files Check - End =====================

        // ===================== Google Cloud - BigQuery - Read Schema - Begin =====================
        System.out.println(FW_ConsoleColors.CORAL + "- Google Cloud - BigQuery - Read Schema..." + FW_ConsoleColors.RESET);
        Schema schema;
        try {
            schema = FW_GoogleCloudUtils.readSchemaFromFile(schemaFilePath);
            System.out.println(FW_ConsoleColors.GREEN + "  - PASS: Schema read successfully." + FW_ConsoleColors.RESET);
        } catch (IOException | IllegalArgumentException e) {
            System.out.println(FW_ConsoleColors.RED + "  - FAIL: Could not read schema: " + e.getMessage() + FW_ConsoleColors.RESET);
            return;
        }
        // ===================== Google Cloud - BigQuery - Read Schema - End =====================


        // ===================== Google Cloud - BigQuery - Access API Key - Begin =====================
        System.out.println(FW_ConsoleColors.CORAL + "- Google Cloud - BigQuery - Access API Key..." + FW_ConsoleColors.RESET);

        // Get service account credentials
        GoogleCredentials credentials;
        try (FileInputStream serviceAccountStream = new FileInputStream(googleCloudServiceAccountJsonFile)) {
            credentials = GoogleCredentials.fromStream(serviceAccountStream);
            System.out.println(FW_ConsoleColors.GREEN + "  - PASS: API Key loaded successfully" + FW_ConsoleColors.RESET);
        } catch (IOException e) {
            System.err.println(FW_ConsoleColors.RED + "  - FAIL: Issue encountered loading API Key." + e.getMessage());
            return;
        }
        // ===================== Google Cloud - BigQuery - Access API Key - End =====================

        // ===================== Google Cloud - BigQuery - Access Account - Begin =====================
        System.out.println(FW_ConsoleColors.CORAL + "- Google Cloud - BigQuery - Access Account..." + FW_ConsoleColors.RESET);

        // Create a BigQuery client instance with the service account credentials and project ID
        BigQuery bigquery = BigQueryOptions.newBuilder().setCredentials(credentials).setProjectId(googleCloudProjectId).build().getService();

        // Verify BigQuery client credentials work
        try {
            for (Dataset dataset : bigquery.listDatasets().iterateAll()) {
                System.out.println(FW_ConsoleColors.GREEN + "  - PASS: BigQuery credentials are working. (Dataset:" + dataset.getDatasetId().getDataset() + ")" + FW_ConsoleColors.RESET);
            }
        } catch (BigQueryException e) {
            System.err.println(FW_ConsoleColors.RED + "  - FAIL: BigQuery client credentials failed. Error: " + e.getMessage() + FW_ConsoleColors.RESET);
        }

        // ===================== Google Cloud - BigQuery - Access Account - End =====================

        // ===================== Google Cloud - BigQuery - Verify Dataset - Begin =====================
        System.out.println(FW_ConsoleColors.CORAL + "- Google Cloud - BigQuery - Verify Dataset..." + FW_ConsoleColors.RESET);

        // Check if the dataset exists
        boolean datasetExists = false;
        for (Dataset dataset : bigquery.listDatasets().iterateAll()) {
            if (dataset.getDatasetId().getDataset().equals(googleCloudProjectDataset)) {
                datasetExists = true;
                break;
            }
        }

        // Create the dataset if it does not exist
        if (!datasetExists) {
            Dataset dataset = bigquery.create(Dataset.newBuilder(googleCloudProjectId, googleCloudProjectDataset).build());
            if (dataset != null) {
                System.out.println(FW_ConsoleColors.GREEN + "  - PASS: Dataset created successfully." + FW_ConsoleColors.RESET);
            } else {
                System.err.println(FW_ConsoleColors.RED + "  - FAIL: Dataset creation failed." + FW_ConsoleColors.RESET);
                return;
            }
        } else {
            System.out.println(FW_ConsoleColors.GREEN + "  - PASS: Dataset already exists." + FW_ConsoleColors.RESET);
        }

        // ===================== Google Cloud - BigQuery - Verify Dataset - End =====================

        // ===================== Google Cloud - BigQuery - Verify Table - Begin =====================
        System.out.println(FW_ConsoleColors.CORAL + "- Google Cloud - BigQuery - Verify Table..." + FW_ConsoleColors.RESET);

        // Check if Table Exists
        boolean tableExists = FW_GoogleCloudUtils.checkBigQueryTableExist(bigquery, googleCloudProjectDataset, googleCloudProjectDatasetTableTestSteps);

        // Create the table if it does not exist
        if (tableExists == false) {
            System.out.println(FW_ConsoleColors.YELLOW + "  - INFO: Table " + googleCloudProjectDatasetTableTestSteps + " does not exist. Creating table...");

            // Create the table
            String timePartitionColumn = "testStepTimestamp"; // Column name to use for time partitioning
            tableExists = FW_GoogleCloudUtils.createBigQueryTable(bigquery, googleCloudProjectDataset, googleCloudProjectDatasetTableTestSteps, timePartitionColumn, schema);

            if (tableExists == true) {
                System.out.println(FW_ConsoleColors.GREEN + "  - PASS: Table " + googleCloudProjectDatasetTableTestSteps + " created successfully." + FW_ConsoleColors.RESET);
            } else {
                System.err.println(FW_ConsoleColors.RED + "  - FAIL: Table creation failed." + FW_ConsoleColors.RESET);
                return;
            }

        } else {
            System.out.println(FW_ConsoleColors.GREEN + "  - PASS: Table already exists." + FW_ConsoleColors.RESET);
        }

        // ===================== Google Cloud - BigQuery - Verify Table - End =====================

        // ===================== Google Cloud - BigQuery - Create Write Channel Configuration - Begin =====================
        System.out.println(FW_ConsoleColors.CORAL + "- Google Cloud - BigQuery - Create Write Channel Configuration..." + FW_ConsoleColors.RESET);

        // Create a table ID
        TableId tableId = TableId.of(googleCloudProjectDataset, googleCloudProjectDatasetTableTestSteps);
        // Ensure valid tableId created
        if (tableId != null) {
            System.out.println(FW_ConsoleColors.GREEN + "  - PASS: Table ID created successfully." + FW_ConsoleColors.RESET);
        } else {
            System.err.println(FW_ConsoleColors.RED + "  - FAIL: Table ID not created successfully." + FW_ConsoleColors.RESET);
            return;
        }

        // Create a write channel configuration with the schema
        WriteChannelConfiguration writeChannelConfiguration = WriteChannelConfiguration.newBuilder(tableId)
            .setFormatOptions(FormatOptions.csv())              // Source format
            .setSchema(schema)                                  // Schema
            .setWriteDisposition(WriteDisposition.WRITE_APPEND) // Append to table
            .setMaxBadRecords(10)                 // Max bad records
            .setIgnoreUnknownValues(true)   // Ignore unknown values
            .setAutodetect(false)                    // Auto-detect schema
            .build();
        if (writeChannelConfiguration != null) {
            System.out.println(FW_ConsoleColors.GREEN + "  - PASS: WriteChannelConfiguration created successfully." + FW_ConsoleColors.RESET);
        } else {
            System.err.println(FW_ConsoleColors.RED + "  - FAIL: WriteChannelConfiguration creation failed." + FW_ConsoleColors.RESET);
            return;
        }
        // ===================== Google Cloud - BigQuery - Create Write Channel Configuration - End =====================

        // ===================== Google Cloud - BigQuery - Read CSV File - Begin =====================
        System.out.println(FW_ConsoleColors.CORAL + "- Google Cloud - BigQuery - Read CSV File..." + FW_ConsoleColors.RESET);

        // Create CSV parser
        CSVParser csvParser = new CSVParserBuilder()
            .withSeparator(',')
            .withQuoteChar('"')
            .withEscapeChar('\\')
            .build();
        System.out.println(FW_ConsoleColors.GREEN + "  - INFO: CSV Parser created." + FW_ConsoleColors.RESET);
            
        // Read the CSV file and write rows collection
        List<RowToInsert> rows = new ArrayList<>(); // Initialize list of rows to write to BigQuery

        try (BufferedReader reader = Files.newBufferedReader(csvFilePath);

            // Create a CSV reader
            CSVReader csvReader = new CSVReaderBuilder(reader)
                .withCSVParser(csvParser)
                .build()) {
            System.out.println(FW_ConsoleColors.GREEN + "  - INFO: CSV Reader created." + FW_ConsoleColors.RESET);

            // Read the header row
            String[] headers = csvReader.readNext();
            if (headers == null) {
                System.err.println("CSV file is empty or missing header row.");
                return;
            }
            System.out.println(FW_ConsoleColors.GREEN + "  - INFO: Skip header row. (" + headers.length + " columns)" + FW_ConsoleColors.RESET);

            // Read the remaining rows
            String[] record;
            
            while ((record = csvReader.readNext()) != null) {

                // Create a map to hold the row data
                Map<String, Object> row = new HashMap<>();

                // Map header names (from CSV header) to the actual column values
                for (int i = 0; i < headers.length; i++) {
                    row.put(headers[i], record[i]);
                }

                // Add the row to the list of rows to write to BigQuery
                rows.add(RowToInsert.of(row));
            }

        } catch (IOException | CsvValidationException e) {
            System.err.println("  - FAIL: Error reading CSV file: " + e.getMessage());
        }
        // ===================== Google Cloud - BigQuery - Read CSV File - Begin =====================

        // ===================== Google Cloud - BigQuery - Write Data - Begin =====================
        System.out.println(FW_ConsoleColors.CORAL + "- Google Cloud - BigQuery - Load Data into BigQuery..." + FW_ConsoleColors.RESET);

        // Write the data to BigQuery
        try {
            FW_GoogleCloudUtils.writeBigQueryTableRows(bigquery, googleCloudProjectDataset, googleCloudProjectDatasetTableTestSteps, rows, FW_ConfigMgr.getGoogleCloudBigQueryTimeout());
        } catch (Exception e) {
            System.err.println("  - FAIL: Error writing data to BigQuery: " + e.getMessage());
        }

        // ===================== Google Cloud - BigQuery - Write Data - End =====================

        System.out.println("");
        System.out.println(FW_ConsoleColors.CORAL + "- - - - - Google Cloud - BigQuery Data Export - (End) - - - - -" + FW_ConsoleColors.RESET);
        System.out.println("");

    }

    /**
     * Archives the CSV file after it has been uploaded to BigQuery.
     */
    public static void archiveTestStepsCSV() {

        System.out.println("");
        System.out.println(
                FW_ConsoleColors.CORAL + "- - - - - Archive Test Data - (Begin) - - - - -" + FW_ConsoleColors.RESET);
        System.out.println("");

        // ===================== Required testConfig.properties Check - Begin =====================
        System.out.println(FW_ConsoleColors.CORAL + "- Get required testConfig.properties parameters exist..."
                + FW_ConsoleColors.RESET);

        // Get dataOutputPath from testConfig.properties
        String dataOutputPath = FW_ConfigMgr.getDataOutputPath();
        if (dataOutputPath != null) {
            System.out.println(FW_ConsoleColors.GREEN + " - PASS: dataOutputPath gatherd from testConfig.properties"
                    + FW_ConsoleColors.RESET);
        } else {
            System.err.println(FW_ConsoleColors.RED + " - FAIL: dataOutputPath not found in testConfig.properties"
                    + FW_ConsoleColors.RESET);
            return;
        }

        // Get dataTestStepsFilename from testConfig.properties
        String dataTestStepsFilename = FW_ConfigMgr.getDataTestStepsFilename();
        if (dataTestStepsFilename != null) {
            System.out.println(FW_ConsoleColors.GREEN
                    + "  - PASS: dataTestStepsFilename configured in testConfig.properties" + FW_ConsoleColors.RESET);
        } else {
            System.err.println(
                    FW_ConsoleColors.RED + "  - FAIL: dataTestStepsFilename not configured in testConfig.properties"
                            + FW_ConsoleColors.RESET);
            return;
        }

        // Get dataArchivePath from testConfig.properties
        String dataArchivePath = FW_ConfigMgr.getDataArchivePath();
        if (dataArchivePath != null) {
            System.out.println(FW_ConsoleColors.GREEN + "  - PASS: dataArchivePath configured in testConfig.properties"
                    + FW_ConsoleColors.RESET);
        } else {
            System.err.println(FW_ConsoleColors.RED
                    + "  - FAIL: dataArchivePath not configured in testConfig.properties" + FW_ConsoleColors.RESET);
            return;
        }
        // ===================== Required testConfig.properties Check - End =====================

        // ===================== Required files Check - Begin =====================
        System.out.println(FW_ConsoleColors.CORAL + "- Check required files exist..." + FW_ConsoleColors.RESET);

        // Check CSV file exists
        Path csvFilePath = Paths.get(dataOutputPath, dataTestStepsFilename);
        if (Files.exists(csvFilePath)) {
            System.out.println(FW_ConsoleColors.GREEN + "  - PASS: CSV file exists at " + csvFilePath.toString()
                    + FW_ConsoleColors.RESET);
        } else {
            System.err.println(FW_ConsoleColors.RED + "  - FAIL: CSV file does not exist at " + csvFilePath.toString()
                    + FW_ConsoleColors.RESET);
            return;
        }

        // ===================== Required files Check - End =====================

        // ===================== Archive CSV file - Begin =====================
        System.out.println(FW_ConsoleColors.CORAL + "- Archive CSV file..." + FW_ConsoleColors.RESET);

        // Create the archive filename with a timestamp
        String timestamp = FW_DateTimeUtils.getCurrentTimestamp();
        String replacementFilename = "_" + timestamp + ".csv";
        String dataTestStepsArchiveFilename = dataTestStepsFilename.replace(".csv", replacementFilename);

        // Move the CSV file to the archive directory
        boolean archiveResult = FW_FileDirUtils.fileMove(dataOutputPath, dataArchivePath, dataTestStepsFilename,
                dataTestStepsArchiveFilename, true, "append");
        if (archiveResult) {
            System.out.println(
                    FW_ConsoleColors.GREEN + "  - PASS: CSV file archived successfully." + FW_ConsoleColors.RESET);
        } else {
            System.err.println(FW_ConsoleColors.RED + "  - FAIL: Error archiving CSV file." + FW_ConsoleColors.RESET);
        }

        System.out.println("");
        System.out.println(FW_ConsoleColors.CORAL + "- - - - - Archive Test Data - (End) - - - - -" + FW_ConsoleColors.RESET);
        System.out.println("");
    }
}