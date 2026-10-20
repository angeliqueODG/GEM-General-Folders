package framework.utilities;

/**
 * @file FW_GoogleCloudUtils.java
 * @description Provides utility methods for working with Google Cloud.
 * 
 * This file contains the FW_GoogleCloudUtils class which provides utility functions for working with Google Cloud.
 * It was initially created to assist with Google BigQuery.
 * It has been enhanced to work with Google Cloud Storage.
 * 
 * The FW_GoogleCloudUtils class offers functionality to:
 * 
 * - checkGoogleCloudProjectIdExist - Check if a Google Cloud Project ID exists
 * 
 * - createGoogleCloudStorageBucket - Create a bucket in Google Cloud Storage
 * - checkGoogleCloudStorageBucketExist - Check if a bucket exists in Google Cloud Storage
 * - uploadFileToGoogleCloudStorageBucket - Upload a file to a bucket in Google Cloud Storage

 * - createBigQueryDataset - Create a BigQuery dataset
 * - checkBigQueryDatasetExist - Check if BigQuery dataset exists
 * 
 * - createBigQueryTable - Create a BigQuery table
 * - checkBigQueryTableExist - Check if BigQuery table exists
 * - waitBigQueryTableExist - Wait for BigQuery table to exist
 * - writeBigQueryTableRows - Write row(s) to BigQuery table
 * - updateBigQueryTableRows - Update row(s) in BigQuery table
 * - deleteBigQueryTableRows - Delete row(s) from BigQuery table
 * - getBigQueryTableRowsCount - Get the row count of BigQuery table
 * 
 * - readSchemaFromFile - Read a schema from a JSON file
 * 
 */

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.bigquery.BigQuery;
import com.google.cloud.bigquery.BigQueryError;
import com.google.cloud.bigquery.BigQueryException;
import com.google.cloud.bigquery.BigQueryOptions;
import com.google.cloud.bigquery.Dataset;
import com.google.cloud.bigquery.DatasetInfo;
import com.google.cloud.bigquery.Field;
import com.google.cloud.bigquery.FieldValueList;
import com.google.cloud.bigquery.InsertAllRequest;
import com.google.cloud.bigquery.InsertAllRequest.RowToInsert;
import com.google.cloud.bigquery.InsertAllResponse;
import com.google.cloud.bigquery.LegacySQLTypeName;
import com.google.cloud.bigquery.QueryJobConfiguration;
import com.google.cloud.bigquery.Schema;
import com.google.cloud.bigquery.StandardTableDefinition;
import com.google.cloud.bigquery.StandardTableDefinition.StreamingBuffer;
import com.google.cloud.bigquery.Table;
import com.google.cloud.bigquery.TableId;
import com.google.cloud.bigquery.TableInfo;
import com.google.cloud.bigquery.TableResult;
import com.google.cloud.bigquery.TimePartitioning;
import com.google.cloud.storage.Blob;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Bucket;
import com.google.cloud.storage.BucketInfo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageClass;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import framework.utilities.FW_FileDirUtils.FileInfo;

/**
 * Utility class for working with Google Cloud.
 */
public class FW_GoogleCloudUtils {

    /**
     * Main method for testing the writeDataToBigQueryTable method.
     * 
     * @param args Command line arguments.
     */
    public static void main(String[] args) {

        // Get googleCloudProjectId
        String googleCloudProjectId = FW_ConfigMgr.getGoogleCloudProjectId();

        // Get the googleCloudServiceAccountJsonFile from testConfig.properties
        String googleCloudServiceAccountJsonFile = FW_ConfigMgr.getGoogleCloudServiceAccountJsonFile();
        if (googleCloudServiceAccountJsonFile != null) {
            System.out.println(FW_ConsoleColors.GREEN + "  - PASS: googleCloudServiceAccountJsonFile configured in testConfig.properties" + FW_ConsoleColors.RESET);
        } else {
            System.err.println(FW_ConsoleColors.RED + "  - FAIL: googleCloudServiceAccountJsonFile not configured in testConfig.properties" + FW_ConsoleColors.RESET);
            return;
        }

        // ===================== Google Cloud - BigQuery - Access API Key - Begin =====================
        System.out.println(FW_ConsoleColors.CORAL + "- Google Cloud - BigQuery - Access API Key..." + FW_ConsoleColors.RESET);

        // Get the service account credentials
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
        System.out.println(
                FW_ConsoleColors.CORAL + "- Google Cloud - BigQuery - Access Account..." + FW_ConsoleColors.RESET);

        // Create a BigQuery client instance with the service account credentials and
        // project ID
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

        // ===================== Google Cloud - BigQuery - Add Rows - Begin =====================
        System.out.println(FW_ConsoleColors.CORAL + "- Google Cloud - BigQuery - Add Rows..." + FW_ConsoleColors.RESET);

        // Define dataset and table
        String dataset = "dataset_automation_01";
        String table = "table_teststeps_02";

        // Prepare rows to insert
        List<RowToInsert> rowsToAdd = new ArrayList<>();

        // First row of data (column titles)
        String[] columns = {
                "clientRefID", "projectRefID", "applicationRefID", "testRunRefID", "testSuiteRefID", "testSuiteName",
                "testCaseRefID", "testCaseName", "testCaseRepetition", "testCaseRepetitions", "testStepRefID",
                "testStepTimestamp", "testStepRefOrder", "testStepPageObject", "testStepMethod", "testStepParameters",
                "testStepResult", "testStepResultDetails", "testStepScreenshotRef", "testStepScreenshotThumbRef",
                "testStepDurationHR", "testStepDurationMS", "testStepExecuted"
        };

        // Second row of data (values)
        String[] values = {
                "cid-a34d58c2-f086-4489-8a72-1fdb2e1033a5", "pid-8762b98c-835d-4715-b029-39cfb41c5f5d", "aid-7515a4c1-4e38-49ec-9bb6-c04a79a3e0f3",
                "trid-756d2882-210f-497e-a871-4284c02f636a", "tsid-2c79a51c-1623-4483-8bdf-8b6256cf59f8", "TS_Ordering_JUnit",
                "tcid-aacf12cc-3d3a-4b8c-8c96-098a271be9ac", "tc_swaglabs_basic_functionality", "1", "1",
                "tpid-d76c3d59-6de4-4e08-909f-68fe1efc76cc", "2025-03-12T11:55:00.046846Z", "1", "PO_Login", "navigateToURL",
                "https://www.saucedemo.com/v1/", "Pass", "Navigated to URL: 'https://www.saucedemo.com/v1/'.", "", "",
                "0.162", "162", "TRUE"
        };

        // Create a map of column titles to values
        Map<String, Object> rowContent = Map.ofEntries(
                Map.entry(columns[0], values[0]),
                Map.entry(columns[1], values[1]),
                Map.entry(columns[2], values[2]),
                Map.entry(columns[3], values[3]),
                Map.entry(columns[4], values[4]),
                Map.entry(columns[5], values[5]),
                Map.entry(columns[6], values[6]),
                Map.entry(columns[7], values[7]),
                Map.entry(columns[8], values[8]),
                Map.entry(columns[9], values[9]),
                Map.entry(columns[10], values[10]),
                Map.entry(columns[11], values[11]),
                Map.entry(columns[12], values[12]),
                Map.entry(columns[13], values[13]),
                Map.entry(columns[14], values[14]),
                Map.entry(columns[15], values[15]),
                Map.entry(columns[16], values[16]),
                Map.entry(columns[17], values[17]),
                Map.entry(columns[18], values[18]),
                Map.entry(columns[19], values[19]),
                Map.entry(columns[20], values[20]),
                Map.entry(columns[21], values[21]),
                Map.entry(columns[22], values[22]));

        // Add the row to the list
        rowsToAdd.add(RowToInsert.of(rowContent));

        // Define timeout
        int timeout = 60; // in seconds

        // try {
        // // Call the writeDataToBigQueryTable method
        // long rowsWritten = writeBigQueryTableRows(bigquery, dataset, table,
        // rowsToAdd, timeout);

        // if (rowsWritten > 0) {
        // long rowsTotal = FW_GoogleCloudUtils.getBigQueryTableRowsCount(bigquery, dataset, table);
        // System.out.println(FW_ConsoleColors.GREEN + " - PASS: BigQuery load successful! Added " + rowsWritten + " rows to table " + table + " for a total of " + rowsTotal + " rows." + FW_ConsoleColors.RESET);
        // } else {
        // System.err.println(FW_ConsoleColors.RED + " - FAIL: BigQuery load failed." + FW_ConsoleColors.RESET);
        // }
        // } catch (BigQueryException | InterruptedException | TimeoutException e) {
        // e.printStackTrace();
        // System.err.println("Failed to write data to BigQuery table: " + e.getMessage());
        // }

        // ===================== Google Cloud - BigQuery - Add Rows - End =====================

        // ===================== Google Cloud - BigQuery - Check Streaming Buffer - Begin =====================
        System.out.println(FW_ConsoleColors.CORAL + "- Google Cloud - BigQuery - Check Streaming Buffer..." + FW_ConsoleColors.RESET);

        // Check if the table exists
        boolean tableBufferExist = checkBigQueryTableStreamingBufferExist(bigquery, dataset, table);
        if (tableBufferExist == false) {
            System.out.println(FW_ConsoleColors.GREEN + "  - PASS: BigQuery table " + table + " is free to MERGE, UPDATE, or DELETE." + FW_ConsoleColors.RESET);
        } else {
            System.err.println(FW_ConsoleColors.YELLOW + "  - WARN: BigQuery table " + table + " is not free to MERGE, UPDATE, or DELETE." + FW_ConsoleColors.RESET);
        }

        // ===================== Google Cloud - BigQuery - Check Streaming Buffer - End =====================

        // ===================== Google Cloud - BigQuery - Delete Rows - Begin =====================
        System.out.println(FW_ConsoleColors.CORAL + "- Google Cloud - BigQuery - Delete Rows..." + FW_ConsoleColors.RESET);

        // Define dataset and table
        dataset = "dataset_automation_01";
        table = "table_teststeps_02";
        String criteria = "clientRefID = 'cid-a34d58c2-f086-4489-8a72-1fdb2e1033a5'";

        try {
            long rowsDeleted = deleteBigQueryTableRows(bigquery, dataset, table, criteria, true);

            if (rowsDeleted > 0) {
                System.out.println(FW_ConsoleColors.GREEN + "  - PASS: BigQuery delete successful! Deleted " + rowsDeleted + " rows from table " + table + "." + FW_ConsoleColors.RESET);
            } else {
                System.out.println(FW_ConsoleColors.YELLOW + "  - WARN: No rows deleted from table " + table + " based on criteria: " + criteria + "." + FW_ConsoleColors.RESET);
            }
        } catch (BigQueryException | InterruptedException e) {
            System.err.println("Failed to delete rows: " + e.getMessage());
        }

        // ===================== Google Cloud - BigQuery - Delete Rows - Begin =====================

        // // ===================== Google Cloud - BigQuery - Update Rows - Begin =====================
        // System.out.println(FW_ConsoleColors.CORAL + "- Google Cloud - BigQuery - Update Rows..." + FW_ConsoleColors.RESET);

        // // Prepare rows to insert
        // List<RowToInsert> rowsToUpdate = new ArrayList<>();

        // // First row of data (column titles)
        // String[] columnsUpdate = {
        // "clientRefID", "projectRefID", "applicationRefID", "testRunRefID", "testSuiteRefID", "testSuiteName",
        // "testCaseRefID", "testCaseName", "testCaseRepetition", "testCaseRepetitions", "testStepRefID",
        // "testStepTimestamp", "testStepRefOrder", "testStepPageObject", "testStepMethod", "testStepParameters",
        // "testStepResult", "testStepResultDetails", "testStepScreenshotRef", "testStepScreenshotThumbRef",
        // "testStepDurationHR", "testStepDurationMS", "testStepExecuted"
        // };

        // // Second row of data (values)
        // String[] valuesUpdate = {
        // "cid-a34d58c2-f086-4489-8a72-1fdb2e1033a5",
        // "pid-8762b98c-835d-4715-b029-39cfb41c5f5d",
        // "aid-7515a4c1-4e38-49ec-9bb6-c04a79a3e0f3",
        // "trid-756d2882-210f-497e-a871-4284c02f636a",
        // "tsid-2c79a51c-1623-4483-8bdf-8b6256cf59f8", "TS_Ordering_JUnit",
        // "tcid-aacf12cc-3d3a-4b8c-8c96-098a271be9ac",
        // "tc_swaglabs_basic_functionality", "1", "1",
        // "tpid-d76c3d59-6de4-4e08-909f-68fe1efc76cc", "2025-03-12T11:55:00.046846Z",
        // "1", "PO_Login", "navigateToURL",
        // "https://www.saucedemo.com/v1/", "Pass", "Navigated to URL:
        // 'https://www.saucedemo.com/v1/'.", "", "",
        // "0.162", "162", "true"
        // };

        // // Create a map of column titles to values
        // Map<String, Object> rowContentUpdate = Map.ofEntries(
        // Map.entry(columnsUpdate[0], valuesUpdate[0]),
        // Map.entry(columnsUpdate[1], valuesUpdate[1]),
        // Map.entry(columnsUpdate[2], valuesUpdate[2]),
        // Map.entry(columnsUpdate[3], valuesUpdate[3]),
        // Map.entry(columnsUpdate[4], valuesUpdate[4]),
        // Map.entry(columnsUpdate[5], valuesUpdate[5]),
        // Map.entry(columnsUpdate[6], valuesUpdate[6]),
        // Map.entry(columnsUpdate[7], valuesUpdate[7]),
        // Map.entry(columnsUpdate[8], valuesUpdate[8]),
        // Map.entry(columnsUpdate[9], valuesUpdate[9]),
        // Map.entry(columnsUpdate[10], valuesUpdate[10]),
        // Map.entry(columnsUpdate[11], valuesUpdate[11]),
        // Map.entry(columnsUpdate[12], valuesUpdate[12]),
        // Map.entry(columnsUpdate[13], valuesUpdate[13]),
        // Map.entry(columnsUpdate[14], valuesUpdate[14]),
        // Map.entry(columnsUpdate[15], valuesUpdate[15]),
        // Map.entry(columnsUpdate[16], valuesUpdate[16]),
        // Map.entry(columnsUpdate[17], valuesUpdate[17]),
        // Map.entry(columnsUpdate[18], valuesUpdate[18]),
        // Map.entry(columnsUpdate[19], valuesUpdate[19]),
        // Map.entry(columnsUpdate[20], valuesUpdate[20]),
        // Map.entry(columnsUpdate[21], valuesUpdate[21]),
        // Map.entry(columnsUpdate[22], valuesUpdate[22])
        // );

        // // Add the row to the list
        // rowsToUpdate.add(RowToInsert.of(rowContentUpdate));

        // try {
        // // Call the writeDataToBigQueryTable method updateBigQueryTableRows(bigquery, dataset, table, rowsToUpdate, timeout);
        // System.out.println("Data updated to BigQuery table successfully.");
        // } catch (BigQueryException | InterruptedException | TimeoutException e) {
        // e.printStackTrace();
        // System.err.println("Failed to updated data to BigQuery table: " + e.getMessage());
        // }

        // // ===================== Google Cloud - BigQuery - Update Rows - End =====================

    }

    /**
     * Check if a Google Cloud Project ID exists.
     * 
     * @param projectId The Google Cloud Project ID to check.
     * 
     * @return True if the project ID exists, false otherwise.
     */
    public static boolean checkGoogleCloudProjectIdExist(String projectId) {
        return projectId != null && !projectId.isEmpty();
    }

    /**
     * Creates a new bucket in Google Cloud Storage.
     * 
     * @param storage    The Google Cloud Storage client instance.
     * @param bucketName The name of the bucket to create.
     * 
     * @return The created bucket.
     */
    public static Bucket createGoogleCloudStorageBucket(Storage storage, String bucketName) {

        // Define the bucket properties
        BucketInfo bucketInfo = BucketInfo.newBuilder(bucketName)
                .setLocation("us-east1")
                .setStorageClass(StorageClass.STANDARD)
                .setIamConfiguration(BucketInfo.IamConfiguration.newBuilder()
                        .setIsUniformBucketLevelAccessEnabled(true) // Enable uniform bucket-level access
                        .build())
                .setVersioningEnabled(true)
                .build();

        Bucket bucket = storage.create(bucketInfo);

        return bucket;
    }

    /**
     * Check if a bucket exists in Google Cloud Storage.
     * 
     * @param storage    The Google Cloud Storage client instance.
     * @param bucketName The name of the bucket to check.
     * 
     * @return True if the bucket exists, false otherwise.
     */
    public static boolean checkGoogleCloudStorageBucketExist(Storage storage, String bucketName) {
        Bucket bucket = storage.get(bucketName);
        return bucket != null;
    }

    /**
     * Upload a file to a specified bucket in Google Cloud Storage.
     * 
     * @param storage    The Google Cloud Storage client instance.
     * @param bucketName The name of the bucket to upload the file to.
     * @param fileObject The file object related to the file to upload.
     * 
     * @return The created Blob.
     */
    public static Blob uploadFileToGoogleCloudStorageBucket(Storage storage, String bucketName, FileInfo fileObj) {

        // Get the file name
        String fileName = fileObj.getFileName();

        // Get the file extension
        String fileExtension = fileObj.getFileExtension();

        // Get the file name
        String filePathName = fileObj.getFilePathName();

        // Determine the MIME type based on the file extension using a switch expression
        String mimeType = switch (fileExtension) {
            case "jpg", "jpeg" -> "image/jpeg";
            case "png" -> "image/png";
            default -> "application/octet-stream"; // Fallback for unknown types
        };

        // Create the BlobId which contains the bucket name and file name
        BlobId blobId = BlobId.of(bucketName, fileName);

        // Create the BlobInfo which contains the BlobId and file info
        BlobInfo blobInfo = BlobInfo.newBuilder(blobId)
                .setContentType(mimeType)
                .build();

        // Upload the file to the bucket
        try {

            // Get the Byte array of the file
            byte[] fileBytes = FW_FileDirUtils.getByteArrayFromFile(filePathName);

            // Upload to Google Cloud Storage bucket
            Blob blob = storage.create(blobInfo, fileBytes);

            // Return the Blob
            return blob;

        } catch (IOException e) {
            System.err.println("Failed to read file: " + e.getMessage());
            throw new RuntimeException("File upload failed", e);
        }
    }

    /**
     * Creates a new dataset in BigQuery.
     * 
     * @param bigquery
     * @param datasetId
     * 
     * @return True if the dataset was created successfully, false otherwise.
     */
    public static boolean createBigQueryDataset(BigQuery bigquery, String datasetId) {
        DatasetInfo datasetInfo = DatasetInfo.newBuilder(datasetId).build();
        Dataset dataset = bigquery.create(datasetInfo);
        return dataset != null;
    }

    /**
     * Check if a dataset exists in BigQuery.
     * 
     * @param bigquery  The BigQuery client instance.
     * @param datasetId The ID of the dataset to check.
     * 
     * @return True if the dataset exists, false otherwise.
     */
    public static boolean checkBigQueryDatasetExist(BigQuery bigquery, String datasetId) {
        Dataset dataset = bigquery.getDataset(datasetId);
        return dataset != null;
    }

    /**
     * Creates a new, partitioned table in the specified dataset in BigQuery.
     * 
     * @param bigquery            The BigQuery client instance.
     * @param dataset             The dataset
     * @param table               The table to create.
     * @param timePartitionColumn The column to use for time partitioning.
     * @param schema              The schema of the table.
     * 
     * @return True if the table was created successfully, false otherwise.
     */
    public static boolean createBigQueryTable(BigQuery bigquery, String dataset, String table, String timePartitionColumn, Schema schema) {

        // Create the table ID
        TableId tableID = TableId.of(dataset, table);

        // Create the time partitioning configuration
        TimePartitioning timePartitioning = TimePartitioning.newBuilder(TimePartitioning.Type.DAY).setField(timePartitionColumn).build();

        // Create the table definition
        StandardTableDefinition.Builder tableDefinitionBuilder = StandardTableDefinition.newBuilder().setSchema(schema).setTimePartitioning(timePartitioning);

        // Create the table info
        TableInfo tableInfo = TableInfo.newBuilder(tableID, tableDefinitionBuilder.build()).build();

        // Create the table
        Table createdTable = bigquery.create(tableInfo);

        // Synchronization to wait for table creation
        long startTime = System.currentTimeMillis();
        long timeout = 10000; // 10 seconds timeout
        while (bigquery.getTable(tableID) == null) {
            if (System.currentTimeMillis() - startTime > timeout) {
                System.err.println(FW_ConsoleColors.RED + "  - FAIL: BigQuery Table creation timed out." + FW_ConsoleColors.RESET);
                return false;
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Return true if table was created successfully
        return createdTable != null;
    }

    /**
     * Checks if a table exists in a specified dataset in BigQuery.
     * 
     * @param bigquery  The BigQuery client instance.
     * @param datasetId The ID of the dataset.
     * @param tableId   The ID of the table to check.
     * 
     * @return True if the table exists, false otherwise.
     */
    public static boolean checkBigQueryTableExist(BigQuery bigquery, String datasetId, String tableId) {
        Table table = bigquery.getTable(TableId.of(datasetId, tableId));
        return table != null;
    }

    /**
     * Wait for a BigQuery table to exist
     * 
     * @param bigquery
     * @param dataset
     * @param table
     * @param timeout  // in seconds
     * 
     * @return
     */
    public static boolean waitBigQueryTableExist(BigQuery bigquery, String dataset, String table, int timeout) {

        // Create the table ID
        TableId tableID = TableId.of(dataset, table);

        // Synchronization to wait for table creation
        long startTime = System.currentTimeMillis();

        // Wait for the table to exist
        while (bigquery.getTable(tableID) == null) {

            if (System.currentTimeMillis() - startTime > (timeout * 1000)) {
                System.err.println(FW_ConsoleColors.RED + "  - FAIL: BigQuery Table: " + table + " not found." + FW_ConsoleColors.RESET);
                return false;
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return true;
    }

    /**
     * Writes data to a specified table in BigQuery from a list of rows and returns the total number of rows successfully written. It sends the rows in batches to avoid payload size limits.
     *
     * @param bigquery The BigQuery client instance.
     * @param dataset  The dataset.
     * @param table    The table to write to.
     * @param rows     The complete list of rows to write to the table.
     * @param timeout  The timeout for the operation.
     *
     * @return The total number of rows written, or -1 if a critical error occurs.
     *
     * @throws InterruptedException If the thread is interrupted.
     * @throws TimeoutException     If the table existence check times out.
     */
    public static long writeBigQueryTableRows(BigQuery bigquery, String dataset, String table, List<RowToInsert> rows, int timeout) throws InterruptedException, TimeoutException {

        // Create retry parameters
        int maxRetries = FW_ConfigMgr.getGoogleCloudBigQueryMaxAttempts();
        long retryDelaySeconds = 2;
        final int maxRowsPerWrite = 500; // BigQuery has a limit of 500 rows per insertAll request

        // Create the table ID
        TableId tableId = TableId.of(dataset, table);

        // Check if table exists before starting any batching
        boolean tableReady = FW_GoogleCloudUtils.waitBigQueryTableExist(bigquery, dataset, table, FW_ConfigMgr.getGoogleCloudBigQueryTimeout());
        if (tableReady == false) {
            System.err.println(FW_ConsoleColors.RED + "  - FAIL: Table " + table + " not found or not ready." + FW_ConsoleColors.RESET);
            return -1;
        }

        long totalRowsWritten = 0;

        // Batch Writing Logic (Begin)
        for (int i = 0; i < rows.size(); i += maxRowsPerWrite) {
            int end = Math.min(i + maxRowsPerWrite, rows.size());
            List<RowToInsert> batch = rows.subList(i, end);

            // Write attempt Loop (Begin)
            boolean batchSuccess = false;
            for (int attempt = 1; attempt <= maxRetries; attempt++) {

                try {

                    //Build and send the request for the current batch
                    InsertAllRequest insertRequest = InsertAllRequest.newBuilder(tableId).setRows(batch).build();
                    InsertAllResponse response = bigquery.insertAll(insertRequest);

                    // Check response for errors (Begin)
                    if (response.hasErrors()) {

                        System.err.println(FW_ConsoleColors.RED + "  - ERROR: BigQuery insert failed for a batch. Logging row-level errors." + FW_ConsoleColors.RESET);

                        // Iterate through the insert errors
                        for (Map.Entry<Long, List<BigQueryError>> entry : response.getInsertErrors().entrySet()) {
                            
                            // The key 'Long' is the 0-based index of the row within the batch
                            long errorIndex = entry.getKey();
                            RowToInsert failedRow = batch.get((int)errorIndex);
                            System.err.println(FW_ConsoleColors.RED + "    - Row Index (in batch): " + errorIndex + " | Row Content: " + failedRow.getContent() + FW_ConsoleColors.RESET);

                            // Log the errors for this specific row
                            for (BigQueryError error : entry.getValue()) {
                                System.err.println(FW_ConsoleColors.RED + "      - Reason: " + error.getReason() + " | Message: " + error.getMessage() + FW_ConsoleColors.RESET);
                            }

                        }

                        // For simplicity, we fail the entire operation if any batch has errors.
                        return -1;
                    }
                    // Check response for errors (End)

                    // If no errors, the batch was accepted successfully.
                    batchSuccess = true;
                    break; // Exit retry loop for this batch

                } catch (BigQueryException e) {
                    System.out.println(FW_ConsoleColors.YELLOW + "  - INFO: BigQuery exception on batch insert. Attempt " + attempt + " of " + maxRetries + ". Retrying..." + FW_ConsoleColors.RESET);
                    System.out.println(FW_ConsoleColors.GREENYELLOW + "    - Exception: " + e.getMessage() + FW_ConsoleColors.RESET);
                    if (attempt < maxRetries) {
                        Thread.sleep(TimeUnit.SECONDS.toMillis(retryDelaySeconds * attempt)); // Exponential backoff
                    } else {
                        System.err.println(FW_ConsoleColors.RED + "  - FAIL: BigQuery exception after max retries. Aborting." + FW_ConsoleColors.RESET);
                        e.printStackTrace(); // Log the full exception on final failure
                        return -1;
                    }
                }
            }
            // Write attempt Loop (Begin)

            if (batchSuccess) {
                totalRowsWritten += batch.size();
                System.out.println(FW_ConsoleColors.GREEN + "  - INFO: Successfully wrote batch of " + batch.size() + " rows. Total written so far: " + totalRowsWritten);
            } else {
                System.err.println(FW_ConsoleColors.RED + "  - FAIL: Failed to write a batch after " + maxRetries + " retries. Aborting operation." + FW_ConsoleColors.RESET);
                return -1; // Failed to write a batch, abort all.
            }
        }
        // Batch Writing Logic (End)

        return totalRowsWritten;
    }

    // TODO: I am stuck here a bit with the way the SQL query is getting constructed and executed
    // when it comes to updating (MERGE) the rows in the table. Monday, see if you can come up
    // with an imporved approach, maybe breaking this SQL down a little at a time. I am even
    // wondering if we are updating based on the correct data. Since this is getting called
    // from the main method and is almost acting as a unit test, you might just need to ensure your
    // test for updating is using valid data.
    /**
     * Updates or inserts rows in a specified table in BigQuery, one row at a time.
     * 
     * @param bigquery The BigQuery client instance.
     * @param dataset  The dataset.
     * @param table    The table to update or insert rows into.
     * @param rows     The rows to update or insert.
     * @param timeout  The timeout for the operation.
     * 
     * @throws BigQueryException    If a BigQuery error occurs.
     * @throws InterruptedException If the thread is interrupted.
     * @throws TimeoutException     If the operation times out.
     */
    public static void updateBigQueryTableRows(BigQuery bigquery, String dataset, String table, List<RowToInsert> rows, int timeout) throws BigQueryException, InterruptedException, TimeoutException {

        // Ensure table does not have streaming buffer which would prevent MERGE, UPDATE, or DELETE
        boolean tableBufferExist = checkBigQueryTableStreamingBufferExist(bigquery, dataset, table);
        if (tableBufferExist) {
            System.out.println(FW_ConsoleColors.YELLOW + "  - WARN: BigQuery table " + table + " is not free at this moment to MERGE, UPDATE, or DELETE." + FW_ConsoleColors.RESET);
            return;
        }

        // Create retry logic
        int maxRetries = FW_ConfigMgr.getGoogleCloudBigQueryMaxAttempts();
        long retryDelaySeconds = 2;

        // Process each row individually
        for (RowToInsert row : rows) {
            for (int attempt = 1; attempt <= maxRetries; attempt++) {
                try {
                    // Check if table exists
                    boolean tableReady = FW_GoogleCloudUtils.waitBigQueryTableExist(bigquery, dataset, table, FW_ConfigMgr.getGoogleCloudBigQueryTimeout());
                    if (!tableReady) {
                        List<BigQueryError> errors = new ArrayList<>();
                        errors.add(new BigQueryError("notFound", "global", "Table " + table + " not found."));
                        throw new BigQueryException(errors);
                    }

                    // Construct the MERGE query for the current row
                    StringBuilder mergeQuery = new StringBuilder();
                    mergeQuery.append(String.format("MERGE `%s.%s.%s` T ", bigquery.getOptions().getProjectId(), dataset, table));
                    mergeQuery.append("USING (SELECT ");
                    mergeQuery.append("STRUCT(");
                    int j = 0;
                    for (Map.Entry<String, Object> entry : row.getContent().entrySet()) {
                        Object value = entry.getValue();
                        String escapedValue = value instanceof String ? ((String) value).replace("'", "''") : value.toString();
                        mergeQuery.append(String.format("'%s' AS %s", escapedValue, entry.getKey()));
                        if (j < row.getContent().size() - 1) {
                            mergeQuery.append(", ");
                        }
                        j++;
                    }
                    mergeQuery.append(")) S ");
                    mergeQuery.append("ON T.clientRefID = S.clientRefID ");
                    mergeQuery.append("WHEN MATCHED THEN ");
                    mergeQuery.append("UPDATE SET ");
                    int k = 0;
                    for (String key : row.getContent().keySet()) {
                        if (!key.equals("clientRefID")) {
                            mergeQuery.append(String.format("T.%s = S.%s", key, key));
                            if (k < row.getContent().size() - 2) {
                                mergeQuery.append(", ");
                            }
                            k++;
                        }
                    }
                    mergeQuery.append(" ");
                    mergeQuery.append("WHEN NOT MATCHED THEN ");
                    mergeQuery.append("INSERT (");
                    int l = 0;
                    for (String key : row.getContent().keySet()) {
                        mergeQuery.append(key);
                        if (l < row.getContent().size() - 1) {
                            mergeQuery.append(", ");
                        }
                        l++;
                    }
                    mergeQuery.append(") VALUES (");
                    int m = 0;
                    for (String key : row.getContent().keySet()) {
                        mergeQuery.append(String.format("S.%s", key));
                        if (m < row.getContent().size() - 1) {
                            mergeQuery.append(", ");
                        }
                        m++;
                    }
                    mergeQuery.append(")");

                    // Log the SQL query
                    System.out.println("------- SQL Begin ------");
                    System.out.println(mergeQuery.toString());
                    System.out.println("------- SQL End ------");

                    // Execute the MERGE query for the current row
                    QueryJobConfiguration queryConfig = QueryJobConfiguration.newBuilder(mergeQuery.toString()).build();
                    bigquery.query(queryConfig);

                    System.out.println(FW_ConsoleColors.GREEN + "  - PASS: BigQuery MERGE operation successful for row: "+ row.getContent() + FW_ConsoleColors.RESET);
                    break; // Exit retry loop on success

                } catch (BigQueryException e) {

                    // Check if we still have retries available
                    if (attempt < maxRetries) {
                        System.out.println(FW_ConsoleColors.YELLOW + "  - INFO: BigQuery error encountered for row: " + row.getContent() + " - Attempt " + attempt + " of " + maxRetries + " - Retrying..." + FW_ConsoleColors.RESET);
                        Thread.sleep(TimeUnit.SECONDS.toMillis(retryDelaySeconds * attempt)); // Exponential backoff
                    } else {
                        System.out.println(FW_ConsoleColors.RED + "  - FAIL: BigQuery Exception encountered for row: " + row.getContent() + " - Skipping..." + FW_ConsoleColors.RESET);
                        throw e; // Stop processing this row
                    }
                }
            }
        }
    }

    /**
     * Gets the row count of a specified table in BigQuery.
     * 
     * @param bigquery The BigQuery client instance.
     * @param dataset  The dataset
     * @param table    The table to get the row count for.
     * 
     * @return The row count of the table.
     * 
     * @throws BigQueryException If a BigQuery error occurs.
     */
    public static long getBigQueryTableRowsCount(BigQuery bigquery, String dataset, String table) throws BigQueryException {
        String query = String.format("SELECT COUNT(*) as total_rows FROM `%s.%s`", dataset, table);
        QueryJobConfiguration queryConfig = QueryJobConfiguration.newBuilder(query).build();
        try {
            TableResult result = bigquery.query(queryConfig);
            FieldValueList row = result.iterateAll().iterator().next();
            long rowCount = row.get("total_rows").getLongValue();
            return rowCount;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            List<BigQueryError> errors = new ArrayList<>();
            errors.add(new BigQueryError("notFound", "global", "Table " + table + " not found."));
            throw new BigQueryException(errors);
        } catch (BigQueryException e) {
            throw e;
        }
    }

    /**
     * Deletes rows from a specified table in BigQuery based on the given criteria
     * and returns the number of rows deleted.
     * 
     * @param bigquery The BigQuery client instance.
     * @param dataset  The dataset containing the table.
     * @param table    The table to delete rows from.
     * @param criteria The WHERE clause criteria for deleting rows (e.g., "clientRefID = '12345'").
     * @param verbose  Whether to report with verbose output. (default: false)
     * 
     * @return The number of rows deleted. -1 if an error occurs.
     * 
     * @throws BigQueryException    If a BigQuery error occurs.
     * @throws InterruptedException If the thread is interrupted.
     */
    public static long deleteBigQueryTableRows(BigQuery bigquery, String dataset, String table, String criteria, Boolean verbose) throws BigQueryException, InterruptedException {

        // Ensure table does not have streaming buffer which would prevent MERGE, UPDATE, or DELETE
        boolean tableBufferExist = checkBigQueryTableStreamingBufferExist(bigquery, dataset, table);
        if (tableBufferExist) {
            if (verbose == true) {System.out.println(FW_ConsoleColors.YELLOW + "  - WARN: BigQuery table " + table + " is not free at this moment to MERGE, UPDATE, or DELETE." + FW_ConsoleColors.RESET);}
            return -1;
        }

        // Get the initial row count
        long initialRowCount = getBigQueryTableRowsCount(bigquery, dataset, table);

        // Build the SQL query
        StringBuilder sqlQueryBuilder = new StringBuilder();
        sqlQueryBuilder.append("DELETE FROM");
        sqlQueryBuilder.append(" ");
        sqlQueryBuilder.append("`");
        sqlQueryBuilder.append(bigquery.getOptions().getProjectId());
        sqlQueryBuilder.append(".");
        sqlQueryBuilder.append(dataset);
        sqlQueryBuilder.append(".");
        sqlQueryBuilder.append(table);
        sqlQueryBuilder.append("`");
        sqlQueryBuilder.append(" ");

        // Add WHERE clause
        sqlQueryBuilder.append("WHERE");
        sqlQueryBuilder.append(" ");
        sqlQueryBuilder.append(criteria);

        // Convert the query to a string
        String sqlQuery = sqlQueryBuilder.toString();

        // Log the SQL query
        if (verbose == true) {
            System.out.println(FW_ConsoleColors.WHITE + "   ------- SQL Begin ------" + FW_ConsoleColors.RESET);
            System.out.println(FW_ConsoleColors.WHITE + "   " + sqlQuery + FW_ConsoleColors.RESET);
            System.out.println(FW_ConsoleColors.WHITE + "   ------- SQL End ------" + FW_ConsoleColors.RESET);
        }

        // Create the query job configuration
        QueryJobConfiguration queryConfig = QueryJobConfiguration.newBuilder(sqlQuery).build();

        try {

            // Execute the SQL query
            TableResult result = bigquery.query(queryConfig);

            // Get the final row count
            long finalRowCount = result.getTotalRows();

            // Calculate the number of rows deleted
            long rowsDeleted = initialRowCount - finalRowCount;

            if (verbose == true) {System.out.println(FW_ConsoleColors.GREEN + "  - PASS: Deleted " + rowsDeleted + " of " + initialRowCount + " rows from table: " + table + " with a remaining row count of: " + finalRowCount + "." + FW_ConsoleColors.RESET);}
            return rowsDeleted;

        } catch (BigQueryException e) {
            if (verbose == true) {System.err.println(FW_ConsoleColors.RED + "  - FAIL: Failed to delete rows from table: " + table + " with total rows: " + initialRowCount + ". Error: " + e.getMessage() + FW_ConsoleColors.RESET);}
            return -1; // Return -1 if an error occurs
        }
    }

    /**
     * Checks if the streaming buffer is present for a specified table in BigQuery.
     * 
     * @param bigquery The BigQuery client instance.
     * @param dataset  The dataset containing the table.
     * @param table    The table to check for a streaming buffer.
     * 
     * @return True if the streaming buffer is present, false otherwise.
     */
    public static boolean checkBigQueryTableStreamingBufferExist(BigQuery bigquery, String dataset, String table) {

        // Check if the table exists
        boolean tableExists = checkBigQueryTableExist(bigquery, dataset, table);
        if (tableExists == false) {
            System.err.println(FW_ConsoleColors.RED + "  - FAIL: Table " + table + " not found in dataset " + dataset + "." + FW_ConsoleColors.RESET);
            return false;
        }

        // Create the table ID
        TableId tableID = TableId.of(dataset, table);

        // Get the table object
        Table tableObj = bigquery.getTable(tableID);

        // Get the table definition and check for the streaming buffer
        if (tableObj.getDefinition() instanceof StandardTableDefinition) {
            StandardTableDefinition tableDefinition = tableObj.getDefinition();
            StreamingBuffer streamingBuffer = tableDefinition.getStreamingBuffer();
            if (streamingBuffer != null) {
                System.out.println(FW_ConsoleColors.YELLOW + "  - INFO: Streaming buffer is present for table: " + table + FW_ConsoleColors.RESET);
                System.out.println(FW_ConsoleColors.YELLOW + "    Estimated rows in streaming buffer: " + streamingBuffer.getEstimatedRows() + FW_ConsoleColors.RESET);
                return true;
            }
        }

        return false;
    }

    /**
     * Reads the schema from a JSON file.
     * 
     * @param schemaFilePath The path to the schema JSON file.
     * 
     * @return The schema object.
     * @throws IOException If an I/O error occurs.
     */
    public static Schema readSchemaFromFile(Path schemaFilePath) throws IOException {
        try (FileInputStream schemaStream = new FileInputStream(schemaFilePath.toFile())) {
            Gson gson = new Gson();
            Type fieldType = new TypeToken<List<Map<String, Object>>>() {}.getType();
            List<Map<String, Object>> fieldsList = gson.fromJson(new InputStreamReader(schemaStream), fieldType);

            List<Field> fields = new ArrayList<>();
            for (Map<String, Object> fieldMap : fieldsList) {
                String name = (String) fieldMap.get("name");
                String type = (String) fieldMap.get("type");
                String mode = (String) fieldMap.get("mode");
                Field field = Field.newBuilder(name, LegacySQLTypeName.valueOf(type))
                        .setMode(Field.Mode.valueOf(mode))
                        .build();
                fields.add(field);
            }
            return Schema.of(fields);
        } catch (IOException | IllegalArgumentException e) {
            throw new IOException("FAIL: Could not read schema" + e.getMessage());
        }
    }
}