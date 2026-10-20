package framework.data;

// ===============================================================
// @file: FW_GoogleSheetGoogleBigQuerySyncronizer.java
// @filepath: src/test/java/framework/data/FW_GoogleSheetGoogleBigQuerySyncronizer.java
// @version: 2.0.0
// @updated: 2025-01-10 11:30:00 AM CST
// @author: Greg Paskal
// @company: MissionWares
//
// @description:
// Handles the synchronization of data between Google Sheets and Google BigQuery.
// This class provides a workflow for authenticating with Google services, reading
// data from specified Google Sheet tabs, and preparing it for insertion into
// BigQuery tables. Supports configuration-driven synchronization with validation
// checks for authentication, sheet existence, and tab availability. Designed for
// automated data pipeline operations between Google Workspace and Google Cloud.
//
// @dependencies:
// - Google Sheets API v4
// - Google Auth OAuth2
// - Framework utilities (ConfigMgr, GoogleSheetUtils, ConsoleColors)
//
// @methods:
// - main(String[]): Main entry point to trigger the synchronization
// - synchronizeClients(): Synchronizes client data from Google Sheets to BigQuery
//
// @configuration:
// Requires the following properties in testConfig.properties:
// - googleCloudProjectId
// - googleCloudServiceAccountJsonFile
// - googleSheetId
// - googleSheetTabNameClients
// - googleCloudProjectDataset
// - googleCloudProjectDatasetTableClients
// - googleCloudProjectDatasetTableClientsSchema
// - googleSheetSyncToBigQuery (true/false flag)
//
// @tags: google-sheets, bigquery, data-sync, etl, google-cloud, mAi™
//
// @changeLog:
// Date        Author          Version  Description
// ----------  --------------  -------  --------------------------
// 2025-03-25  G. Paskal       1.0.0    Initial implementation
// 2025-01-10  G. Paskal       2.0.0    Added mAi™ header and enhanced documentation
// ===============================================================

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
 *
 * @description
 * <p>Handles the synchronization of data between Google Sheets and Google BigQuery.
 * This class provides a workflow for authenticating with Google services, reading data
 * from a Google Sheet, and preparing it for insertion into a BigQuery table.
 *
 * @Methods
 * <ul>
 * <li>{@link #main(String[])} - The main entry point to trigger the synchronization.</li>
 * <li>{@link #synchronizeClients()} - Synchronizes client data from Google Sheets to BigQuery.</li>
 * </ul>
 *
 * @version 1.0
 * @since 2025-03-25
 */
public class FW_GoogleSheetGoogleBigQuerySyncronizer {

    // Global instance of the scopes required for Google Sheets API access.
    private static final List<String> SCOPES = Collections.singletonList(SheetsScopes.SPREADSHEETS);

    /**
     * The main entry point to initiate the synchronization process.
     *
     * @param args Command-line arguments are not used in this method.
     */
    public static void main(String[] args) {
        // Only proceed if the configuration flag is set to true.
        if ("true".equals(FW_ConfigMgr.getGoogleSheetSyncToBigQuery())) {
            synchronizeClients();
        }
    }

    /**
     * Synchronizes data from the 'Clients' tab in Google Sheets to a BigQuery table.
     */
    public static void synchronizeClients() {
        System.out.println("");
        System.out.println(FW_ConsoleColors.CORAL + "- - - - - Synchronize - Google Sheet to BigQuery - Client - (Begin) - - - - -" + FW_ConsoleColors.RESET);
        System.out.println("");

        // ===================== Required testConfig.properties Check - Begin =====================
        System.out.println(FW_ConsoleColors.CORAL + "- Check required testConfig.properties parameters exist..." + FW_ConsoleColors.RESET);

        // Get googleCloudProjectId from testConfig.properties.
        String googleCloudProjectId = FW_ConfigMgr.getGoogleCloudProjectId();
        if (googleCloudProjectId != null) {
            System.out.println(FW_ConsoleColors.GREEN + "  - PASS: googleCloudProjectId configured in testConfig.properties" + FW_ConsoleColors.RESET);
        } else {
            System.err.println(FW_ConsoleColors.RED + "  - FAIL: googleCloudProjectId not configured in testConfig.properties" + FW_ConsoleColors.RESET);
            return;
        }

        // Get googleCloudServiceAccountJsonFile from testConfig.properties.
        String googleCloudServiceAccountJsonFile = FW_ConfigMgr.getGoogleCloudServiceAccountJsonFile();
        if (googleCloudServiceAccountJsonFile != null) {
            System.out.println(FW_ConsoleColors.GREEN + "  - PASS: googleCloudServiceAccountJsonFile configured in testConfig.properties" + FW_ConsoleColors.RESET);
        } else {
            System.err.println(FW_ConsoleColors.RED + "  - FAIL: googleCloudServiceAccountJsonFile not configured in testConfig.properties" + FW_ConsoleColors.RESET);
            return;
        }

        // Get googleSheetId from testConfig.properties.
        String googleSheetId = FW_ConfigMgr.getGoogleSheetId();
        if (googleSheetId != null) {
            System.out.println(FW_ConsoleColors.GREEN + "  - PASS: googleSheetId configured in testConfig.properties" + FW_ConsoleColors.RESET);
        } else {
            System.err.println(FW_ConsoleColors.RED + "  - FAIL: googleSheetId not configured in testConfig.properties" + FW_ConsoleColors.RESET);
            return;
        }

        // Get googleSheetTabNameClients from testConfig.properties.
        String googleSheetTabNameClients = FW_ConfigMgr.getGoogleSheetTabNameClients();
        if (googleSheetTabNameClients != null) {
            System.out.println(FW_ConsoleColors.GREEN + "  - PASS: googleSheetTabNameClients configured in testConfig.properties" + FW_ConsoleColors.RESET);
        } else {
            System.err.println(FW_ConsoleColors.RED + "  - FAIL: googleSheetTabNameClients not configured in testConfig.properties" + FW_ConsoleColors.RESET);
            return;
        }

        // Get googleCloudProjectDataset from testConfig.properties.
        String googleCloudProjectDataset = FW_ConfigMgr.getGoogleCloudProjectDataset();
        if (googleCloudProjectDataset != null) {
            System.out.println(FW_ConsoleColors.GREEN + "  - PASS: googleCloudProjectDataset configured in testConfig.properties" + FW_ConsoleColors.RESET);
        } else {
            System.err.println(FW_ConsoleColors.RED + "  - FAIL: googleCloudProjectDataset not configured in testConfig.properties" + FW_ConsoleColors.RESET);
            return;
        }

        // Get googleCloudProjectDatasetTableClients from testConfig.properties.
        String googleCloudProjectDatasetTableClients = FW_ConfigMgr.getGoogleCloudProjectDatasetTableClients();
        if (googleCloudProjectDatasetTableClients != null) {
            System.out.println(FW_ConsoleColors.GREEN + "  - PASS: googleCloudProjectDatasetTableClients configured in testConfig.properties" + FW_ConsoleColors.RESET);
        } else {
            System.err.println(FW_ConsoleColors.RED + "  - FAIL: googleCloudProjectDatasetTableClients not configured in testConfig.properties" + FW_ConsoleColors.RESET);
            return;
        }

        // Get googleCloudProjectDatasetTableClientsSchema from testConfig.properties.
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

        // Get the service account credentials.
        GoogleCredentials credentials;
        try (FileInputStream serviceAccountStream = new FileInputStream(googleCloudServiceAccountJsonFile)) {
            // Create scoped credentials for the Sheets API.
            credentials = GoogleCredentials.fromStream(serviceAccountStream).createScoped(SCOPES);

            // Check if the credentials are valid.
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

        // Get the Sheets API client.
        Sheets sheetAPIClient;
        try {
            // Create the Sheets API client.
            sheetAPIClient = FW_GoogleSheetUtils.getGoogleSheetsService(credentials);

            // Check if the Sheets API client is valid.
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

        // Check if the Google Sheet exists and get the tabs.
        List<String> sheetTabs = FW_GoogleSheetUtils.getGoogleSheetTabs(sheetAPIClient, googleSheetId);
        if (sheetTabs != null) {
            System.out.println(FW_ConsoleColors.GREEN + "  - PASS: Google Sheet exists with tabs: " + sheetTabs + FW_ConsoleColors.RESET);
        } else {
            System.err.println(FW_ConsoleColors.RED + "  - FAIL: Google Sheet does not exist." + FW_ConsoleColors.RESET);
            return;
        }
        // ===================== Google Sheets - Access Sheet Tabs - End =====================

        // ===================== Google Sheets - Access Tab - Begin =====================
        System.out.println(FW_ConsoleColors.CORAL + "- Google Sheets - Access Tab..." + FW_ConsoleColors.RESET);

        // Check if the 'Clients' tab exists.
        if (FW_GoogleSheetUtils.validateGoogleSheetTabExists(sheetAPIClient, googleSheetId, googleSheetTabNameClients) == true) {
            System.out.println(FW_ConsoleColors.GREEN + "  - PASS: Google Sheet tab clients '" + googleSheetTabNameClients + "' exists" + FW_ConsoleColors.RESET);
        } else {
            System.err.println(FW_ConsoleColors.RED + "  - FAIL: Google Sheet tab clients '" + googleSheetTabNameClients + "' does not exist" + FW_ConsoleColors.RESET);
            return;
        }
        // ===================== Google Sheets - Access Tab - End =====================

        // ===================== Google Sheets - Access Tab Rows - Begin =====================
        System.out.println(FW_ConsoleColors.CORAL + "- Google Sheets - Access Tab Rows..." + FW_ConsoleColors.RESET);

        // Read data from the Google Sheet 'Clients' tab.
        List<Map<String, Object>> data_clients = FW_GoogleSheetUtils.readDataFromGoogleSheet(sheetAPIClient, googleSheetId, googleSheetTabNameClients);
        if (data_clients == null || data_clients.isEmpty()) {
            return;
        }

        // ===================== Google Sheets - Access Tab Rows - End =====================

        System.out.println("");
        System.out.println(FW_ConsoleColors.CORAL + "- - - - - Synchronize - Google Sheet to BigQuery - Client - (End) - - - - -" + FW_ConsoleColors.RESET);
        System.out.println("");
    }
}