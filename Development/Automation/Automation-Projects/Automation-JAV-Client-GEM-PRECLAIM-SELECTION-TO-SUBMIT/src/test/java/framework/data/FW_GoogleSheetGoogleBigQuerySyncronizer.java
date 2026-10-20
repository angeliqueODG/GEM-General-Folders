package framework.data;

import java.io.FileInputStream;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.SheetsScopes;
import com.google.auth.oauth2.GoogleCredentials;

import framework.utilities.FW_ConfigMgr;
import framework.utilities.FW_ConsoleColors;
import framework.utilities.FW_GoogleSheetUtils;

/**
 * @file FW_GoogleSheetGoogleBigQuerySyncronizer.java
 * @description Handles the synchronization between the Google Sheets and Google BigQuery.
 * 
 * @version 1.0
 * @since 2025-03-25
 */
public class FW_GoogleSheetGoogleBigQuerySyncronizer {

    /**
     * Global instance of the scopes required by this quickstart.
     * If modifying these scopes, delete your previously saved tokens/ folder.
     */
    private static final List<String> SCOPES = Collections.singletonList(SheetsScopes.SPREADSHEETS);

    /**
     * Main method to handle synchronization between Google Sheets and Google BigQuery.
     * 
     * @param args Command-line arguments: <projectId> <datasetName><tableName><serviceAccountJsonFile> <bucketName>
     */
    public static void main(String[] args) {

        // Should we syncronize the Google Sheets data to BigQuery?
        if ("true".equals(FW_ConfigMgr.getGoogleSheetSyncToBigQuery())) {
            synchronizeClients();
        }
    }

    /**
     * Synchornize data from Google Sheets to Google BigQuery - Clients
     */
    public static void synchronizeClients() {

        System.out.println("");
        System.out.println(FW_ConsoleColors.CORAL + "- - - - - Synchronize - Google Sheet to BigQuery - Client - (Begin) - - - - -" + FW_ConsoleColors.RESET);
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

        // Get googleSheetId from testConfig.properties
        String googleSheetId = FW_ConfigMgr.getGoogleSheetId();
        if (googleSheetId != null) {
            System.out.println(FW_ConsoleColors.GREEN + "  - PASS: googleSheetId configured in testConfig.properties" + FW_ConsoleColors.RESET);
        } else {
            System.err.println(FW_ConsoleColors.RED + "  - FAIL: googleSheetId not configured in testConfig.properties" + FW_ConsoleColors.RESET);
            return;
        }

        // Get googleSheetTabNameClients from testConfig.properties
        String googleSheetTabNameClients = FW_ConfigMgr.getGoogleSheetTabNameClients();
        if (googleSheetTabNameClients != null) {
            System.out.println(FW_ConsoleColors.GREEN + "  - PASS: googleSheetTabNameClients configured in testConfig.properties" + FW_ConsoleColors.RESET);
        } else {
            System.err.println(FW_ConsoleColors.RED + "  - FAIL: googleSheetTabNameClients not configured in testConfig.properties" + FW_ConsoleColors.RESET);
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

        // Get googleCloudProjectDatasetTableClients from testConfig.properties
        String googleCloudProjectDatasetTableClients = FW_ConfigMgr.getGoogleCloudProjectDatasetTableClients();
        if (googleCloudProjectDatasetTableClients != null) {
            System.out.println(FW_ConsoleColors.GREEN + "  - PASS: googleCloudProjectDatasetTableClients configured in testConfig.properties" + FW_ConsoleColors.RESET);
        } else {
            System.err.println(FW_ConsoleColors.RED + "  - FAIL: googleCloudProjectDatasetTableClients not configured in testConfig.properties" + FW_ConsoleColors.RESET);
            return;
        }

        // Get googleCloudProjectDatasetTableClientsSchema from testConfig.properties
        String googleCloudProjectDatasetTableClientsSchema = FW_ConfigMgr.getGoogleCloudProjectDatasetTableClientsSchema();
        if (googleCloudProjectDatasetTableClientsSchema != null) {
            System.out.println(FW_ConsoleColors.GREEN + "  - PASS: googleCloudProjectDatasetTableClientsSchema configured in testConfig.properties" + FW_ConsoleColors.RESET);
        } else {
            System.err.println(FW_ConsoleColors.RED + "  - FAIL: googleCloudProjectDatasetTableClientsSchema not configured in testConfig.properties" + FW_ConsoleColors.RESET);
            return;
        }

        // ===================== Required testConfig.properties Check - End =====================

        // ===================== Google Cloud - Access API Key - Begin =====================
        System.out.println(FW_ConsoleColors.CORAL + "- Google Cloud - Access API Key..." + FW_ConsoleColors.RESET);

        // Get the service account credentials
        GoogleCredentials credentials;
        try (FileInputStream serviceAccountStream = new FileInputStream(googleCloudServiceAccountJsonFile)) {
            //credentials = GoogleCredentials.fromStream(serviceAccountStream);
            credentials = GoogleCredentials.fromStream(serviceAccountStream).createScoped(SCOPES);

            // Check if the credentials are valid
            if (credentials.createScoped(SCOPES) == null) {
                System.err.println(FW_ConsoleColors.RED + "  - FAIL: Issue encountered loading API Key." + FW_ConsoleColors.RESET);
                return;
            }
            System.out.println(FW_ConsoleColors.GREEN + "  - PASS: API Key loaded successfully" + FW_ConsoleColors.RESET);
        } catch (IOException e) {
            System.err.println(FW_ConsoleColors.RED + "  - FAIL: Issue encountered loading API Key." + e.getMessage() + FW_ConsoleColors.RESET);
            return;
        }
        // ===================== Google Cloud - Access API Key - End =====================

        // ===================== Google Sheets - Get Sheet API Client - Begin =====================
        System.out.println(FW_ConsoleColors.CORAL + "- Google Sheets - Get Sheet API Client..." + FW_ConsoleColors.RESET);

        // Get the Sheets API client
        Sheets sheetAPIClient;
        try {
            // Create the Sheets API client
            sheetAPIClient = FW_GoogleSheetUtils.getGoogleSheetsService(credentials);

            // Check if the Sheets API client is valid
            if (sheetAPIClient == null) {
                System.err.println(FW_ConsoleColors.RED + "  - FAIL: Issue encountered creating Google Sheets API client." + FW_ConsoleColors.RESET);
                return;
            }
            System.out.println(FW_ConsoleColors.GREEN + "  - PASS: Google Sheets API client created successfully" + FW_ConsoleColors.RESET);
        } catch (GeneralSecurityException | IOException e) {
            System.err.println(FW_ConsoleColors.RED + "  - FAIL: Issue encountered creating Google Sheets API client." + e.getMessage() + FW_ConsoleColors.RESET);
            return;
        }
        // ===================== Google Sheets - Get Sheet API Client - End =====================

        // ===================== Google Sheets - Access Sheet Tabs - Begin =====================
        System.out.println(FW_ConsoleColors.CORAL + "- Google Sheets - Access Sheet Tabs..." + FW_ConsoleColors.RESET);

        // Check if the Google Sheet exists and get the tabs
        List<String> sheetTabs = FW_GoogleSheetUtils.getGoogleSheetTabs(sheetAPIClient, googleSheetId);
        if (sheetTabs != null) {
            System.out.println(FW_ConsoleColors.GREEN + "  - PASS: Google Sheet exists with tabs: " + sheetTabs + FW_ConsoleColors.RESET);
        } else {
            System.err.println(FW_ConsoleColors.RED + "  - FAIL: Google Sheet does not exist." + FW_ConsoleColors.RESET);
        }
        // ===================== Google Sheets - Access Sheet Tabs - End =====================

        // ===================== Google Sheets - Access Tab - Begin =====================
        System.out.println(FW_ConsoleColors.CORAL + "- Google Sheets - Access Tab..." + FW_ConsoleColors.RESET);

        // Check if Google Sheet tab clients exists
        if (FW_GoogleSheetUtils.validateGoogleSheetTabExists(sheetAPIClient, googleSheetId, googleSheetTabNameClients)) {
            System.out.println(FW_ConsoleColors.GREEN + "  - PASS: Google Sheet tab clients '" + googleSheetTabNameClients + "' exists" + FW_ConsoleColors.RESET);
        } else {
            System.err.println(FW_ConsoleColors.RED + "  - FAIL: Google Sheet tab clients '" + googleSheetTabNameClients + "' does not exist" + FW_ConsoleColors.RESET);
            return;
        }
        // ===================== Google Sheets - Access Tab - End =====================

        // ===================== Google Sheets - Access Tab Rows - Begin =====================
        System.out.println(FW_ConsoleColors.CORAL + "- Google Sheets - Access Tab Rows..." + FW_ConsoleColors.RESET);

        // Read data from the Google Sheet tab clients
        List<Map<String, Object>> data_clients = FW_GoogleSheetUtils.readDataFromGoogleSheet(sheetAPIClient, googleSheetId, googleSheetTabNameClients);
        if (data_clients == null || data_clients.isEmpty()) {return;}

        // ===================== Google Sheets - Access Tab Rows - End =====================

        System.out.println("");
        System.out.println(FW_ConsoleColors.CORAL + "- - - - - Synchronize - Google Sheet to BigQuery - Client - (End) - - - - -" + FW_ConsoleColors.RESET);
        System.out.println("");

    }
}