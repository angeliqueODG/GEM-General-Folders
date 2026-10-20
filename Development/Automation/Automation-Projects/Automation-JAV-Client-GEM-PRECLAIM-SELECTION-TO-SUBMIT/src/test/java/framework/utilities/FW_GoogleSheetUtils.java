package framework.utilities;

import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.SheetsScopes;
import com.google.api.services.sheets.v4.model.ValueRange;
import com.google.api.services.sheets.v4.model.Spreadsheet;
import com.google.api.services.sheets.v4.model.Sheet;
import com.google.auth.oauth2.GoogleCredentials;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @file FW_GoogleSheetUtils.java
 * @description Provides utility methods for working with Google Sheets.
 * 
 * This file contains the FW_GoogleSheetUtils class which provides utility functions for working with Google Sheets.
 * It was created to assist with the integration of Google Sheets into the framework and specifically BigQuery.
 * 
 */

/**
 * Utility class for working with Google Sheets.
 */
public class FW_GoogleSheetUtils {

    /**
     * Global instance of the scopes required by this quickstart.
     * If modifying these scopes, delete your previously saved tokens/ folder.
     */
    private static final List<String> SCOPES = Collections.singletonList(SheetsScopes.SPREADSHEETS);

    /**
     * Main method for testing the Google Sheets utility functions.
     * 
     * @param args Command line arguments.
     */
    public static void main(String[] args) {

        String googleSheetName = FW_ConfigMgr.getGoogleSheetName();
        String googleSheetId = FW_ConfigMgr.getGoogleSheetId();
        String googleSheetTabNameClients = FW_ConfigMgr.getGoogleSheetTabNameClients();
        String googleSheetTabNameProjects = FW_ConfigMgr.getGoogleSheetTabNameProjects();
        String googleSheetTabNameApplications = FW_ConfigMgr.getGoogleSheetTabNameApplications();

        // Import Google Sheet tab into BigQuery table
        importGoogleSheetTabIntoBigQuery(googleSheetName, googleSheetId, googleSheetTabNameClients, googleSheetTabNameProjects, googleSheetTabNameApplications);
    }

    /**
     * Imports a Google Sheet tab into a BigQuery table.
     * 
     * @param varGoogleSheetName The name of the Google Sheet.
     * @param varGoogleSheetId The ID of the Google Sheet.
     * @param varGoogleSheetTabNameClients The name of Clients tab in the Google Sheet.
     * @param varGoogleSheetTabNameProjects The name of Projects tab in the Google Sheet.
     * @param varGoogleSheetTabNameApplications The name of Applications tab in the Google Sheet.
     */
    public static void importGoogleSheetTabIntoBigQuery(String varGoogleSheetName, String varGoogleSheetId, String varGoogleSheetTabNameClients, String varGoogleSheetTabNameProjects, String varGoogleSheetTabNameApplications) {

        System.out.println("");
        System.out.println(FW_ConsoleColors.CORAL + "- - - - - Google Sheet - Import into BigQuery - (Begin) - - - - -" + FW_ConsoleColors.RESET);
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

        // Get the googleCloudServiceAccountJsonFile from testConfig.properties
        String googleCloudServiceAccountJsonFile = FW_ConfigMgr.getGoogleCloudServiceAccountJsonFile();
        if (googleCloudServiceAccountJsonFile != null) {
            System.out.println(FW_ConsoleColors.GREEN + "  - PASS: googleCloudServiceAccountJsonFile configured in testConfig.properties" + FW_ConsoleColors.RESET);
        } else {
            System.err.println(FW_ConsoleColors.RED + "  - FAIL: googleCloudServiceAccountJsonFile not configured in testConfig.properties" + FW_ConsoleColors.RESET);
            return;
        }

        // Get the googleCloudProjectDataset from testConfig.properties
        String googleCloudProjectDataset = FW_ConfigMgr.getGoogleCloudProjectDataset();
        if (googleCloudProjectDataset != null) {
            System.out.println(FW_ConsoleColors.GREEN + "  - PASS: googleCloudProjectDataset configured in testConfig.properties" + FW_ConsoleColors.RESET);
        } else {
            System.err.println(FW_ConsoleColors.RED + "  - FAIL: googleCloudProjectDataset not configured in testConfig.properties" + FW_ConsoleColors.RESET);
            return;
        }

        // Get the googleCloudProjectDatasetTableClients from testConfig.properties
        String googleCloudProjectDatasetTableClients = FW_ConfigMgr.getGoogleCloudProjectDatasetTableClients();
        if (googleCloudProjectDatasetTableClients != null) {
            System.out.println(FW_ConsoleColors.GREEN + "  - PASS: googleCloudProjectDatasetTableClients configured in testConfig.properties" + FW_ConsoleColors.RESET);
        } else {
            System.err.println(FW_ConsoleColors.RED + "  - FAIL: googleCloudProjectDatasetTableClients not configured in testConfig.properties" + FW_ConsoleColors.RESET);
            return;
        }

        // Get the googleCloudProjectDatasetTableClientsSchema from testConfig.properties
        String googleCloudProjectDatasetTableClientsSchema = FW_ConfigMgr.getGoogleCloudProjectDatasetTableClientsSchema();
        if (googleCloudProjectDatasetTableClientsSchema != null) {
            System.out.println(FW_ConsoleColors.GREEN + "  - PASS: googleCloudProjectDatasetTableClientsSchema configured in testConfig.properties" + FW_ConsoleColors.RESET);
        } else {
            System.err.println(FW_ConsoleColors.RED + "  - FAIL: googleCloudProjectDatasetTableClientsSchema not configured in testConfig.properties" + FW_ConsoleColors.RESET);
            return;
        }

        // Get the googleCloudProjectDatasetTableProjects from testConfig.properties
        String googleCloudProjectDatasetTableProjects = FW_ConfigMgr.getGoogleCloudProjectDatasetTableProjects();
        if (googleCloudProjectDatasetTableProjects != null) {
            System.out.println(FW_ConsoleColors.GREEN + "  - PASS: googleCloudProjectDatasetTableProjects configured in testConfig.properties" + FW_ConsoleColors.RESET);
        } else {
            System.err.println(FW_ConsoleColors.RED + "  - FAIL: googleCloudProjectDatasetTableProjects not configured in testConfig.properties" + FW_ConsoleColors.RESET);
            return;
        }

        // Get the googleCloudProjectDatasetTableProjectsSchema from testConfig.properties
        String googleCloudProjectDatasetTableProjectsSchema = FW_ConfigMgr.getGoogleCloudProjectDatasetTableProjectsSchema();
        if (googleCloudProjectDatasetTableProjectsSchema != null) {
            System.out.println(FW_ConsoleColors.GREEN + "  - PASS: googleCloudProjectDatasetTableProjectsSchema configured in testConfig.properties" + FW_ConsoleColors.RESET);
        } else {
            System.err.println(FW_ConsoleColors.RED + "  - FAIL: googleCloudProjectDatasetTableProjectsSchema not configured in testConfig.properties" + FW_ConsoleColors.RESET);
            return;
        }

        // Get the googleCloudProjectDatasetTableApplications from testConfig.properties
        String googleCloudProjectDatasetTableApplications = FW_ConfigMgr.getGoogleCloudProjectDatasetTableApplications();
        if (googleCloudProjectDatasetTableApplications != null) {
            System.out.println(FW_ConsoleColors.GREEN + "  - PASS: googleCloudProjectDatasetTableApplications configured in testConfig.properties" + FW_ConsoleColors.RESET);
        } else {
            System.err.println(FW_ConsoleColors.RED + "  - FAIL: googleCloudProjectDatasetTableApplications not configured in testConfig.properties" + FW_ConsoleColors.RESET);
            return;
        }

        // Get the googleCloudProjectDatasetTableApplicationsSchema from testConfig.properties
        String googleCloudProjectDatasetTableApplicationsSchema = FW_ConfigMgr.getGoogleCloudProjectDatasetTableApplicationsSchema();
        if (googleCloudProjectDatasetTableApplicationsSchema != null) {
            System.out.println(FW_ConsoleColors.GREEN + "  - PASS: googleCloudProjectDatasetTableApplicationsSchema configured in testConfig.properties" + FW_ConsoleColors.RESET);
        } else {
            System.err.println(FW_ConsoleColors.RED + "  - FAIL: googleCloudProjectDatasetTableApplicationsSchema not configured in testConfig.properties" + FW_ConsoleColors.RESET);
            return;
        }

        // Get the googleCloudProjectDatasetTableTestSteps from testConfig.properties
        String googleCloudProjectDatasetTableTestSteps = FW_ConfigMgr.getGoogleCloudProjectDatasetTableTestSteps();
        if (googleCloudProjectDatasetTableTestSteps != null) {
            System.out.println(FW_ConsoleColors.GREEN + "  - PASS: googleCloudProjectDatasetTableTestSteps configured in testConfig.properties" + FW_ConsoleColors.RESET);
        } else {
            System.err.println(FW_ConsoleColors.RED + "  - FAIL: googleCloudProjectDatasetTableTestSteps not configured in testConfig.properties" + FW_ConsoleColors.RESET);
            return;
        }

        // Get the googleCloudProjectDatasetTableTestStepsSchema from testConfig.properties
        String googleCloudProjectDatasetTableTestStepsSchema = FW_ConfigMgr.getGoogleCloudProjectDatasetTableTestStepsSchema();
        if (googleCloudProjectDatasetTableTestStepsSchema != null) {
            System.out.println(FW_ConsoleColors.GREEN + "  - PASS: googleCloudProjectDatasetTableTestStepsSchema configured in testConfig.properties" + FW_ConsoleColors.RESET);
        } else {
            System.err.println(FW_ConsoleColors.RED + "  - FAIL: googleCloudProjectDatasetTableTestStepsSchema not configured in testConfig.properties" + FW_ConsoleColors.RESET);
            return;
        }

        // Get googleSheetSyncToBigQuery from testConfig.properties
        String googleSheetSyncToBigQuery = FW_ConfigMgr.getGoogleSheetSyncToBigQuery();
        if (googleSheetSyncToBigQuery != null) {
            System.out.println(FW_ConsoleColors.GREEN + "  - PASS: googleSheetSyncToBigQuery configured in testConfig.properties" + FW_ConsoleColors.RESET);
        } else {
            System.err.println(FW_ConsoleColors.RED + "  - FAIL: googleSheetSyncToBigQuery not configured in testConfig.properties" + FW_ConsoleColors.RESET);
            return;
        }

        // Get the googleSheetName from testConfig.properties
        String googleSheetName = FW_ConfigMgr.getGoogleSheetName();
        if (googleSheetName != null) {
            System.out.println(FW_ConsoleColors.GREEN + "  - PASS: googleSheetName configured in testConfig.properties" + FW_ConsoleColors.RESET);
        } else {
            System.err.println(FW_ConsoleColors.RED + "  - FAIL: googleSheetName not configured in testConfig.properties" + FW_ConsoleColors.RESET);
            return;
        }

        // Get the googleSheetId from testConfig.properties
        String googleSheetId = FW_ConfigMgr.getGoogleSheetId();
        if (googleSheetId != null) {
            System.out.println(FW_ConsoleColors.GREEN + "  - PASS: googleSheetId configured in testConfig.properties" + FW_ConsoleColors.RESET);
        } else {
            System.err.println(FW_ConsoleColors.RED + "  - FAIL: googleSheetId not configured in testConfig.properties" + FW_ConsoleColors.RESET);
            return;
        }

        // Get the googleSheetTabNameClients from testConfig.properties
        String googleSheetTabNameClients = FW_ConfigMgr.getGoogleSheetTabNameClients();
        if (googleSheetTabNameClients != null) {
            System.out.println(FW_ConsoleColors.GREEN + "  - PASS: googleSheetTabNameClients configured in testConfig.properties" + FW_ConsoleColors.RESET);
        } else {
            System.err.println(FW_ConsoleColors.RED + "  - FAIL: googleSheetTabNameClients not configured in testConfig.properties" + FW_ConsoleColors.RESET);
            return;
        }
        
        // Get the googleSheetTabNameProjects from testConfig.properties
        String googleSheetTabNameProjects = FW_ConfigMgr.getGoogleSheetTabNameProjects();
        if (googleSheetTabNameProjects != null) {
            System.out.println(FW_ConsoleColors.GREEN + "  - PASS: googleSheetTabNameProjects configured in testConfig.properties" + FW_ConsoleColors.RESET);
        } else {
            System.err.println(FW_ConsoleColors.RED + "  - FAIL: googleSheetTabNameProjects not configured in testConfig.properties" + FW_ConsoleColors.RESET);
            return;
        }

        // Get the googleSheetTabNameApplications from testConfig.properties
        String googleSheetTabNameApplications = FW_ConfigMgr.getGoogleSheetTabNameApplications();
        if (googleSheetTabNameApplications != null) {
            System.out.println(FW_ConsoleColors.GREEN + "  - PASS: googleSheetTabNameApplications configured in testConfig.properties" + FW_ConsoleColors.RESET);
        } else {
            System.err.println(FW_ConsoleColors.RED + "  - FAIL: googleSheetTabNameApplications not configured in testConfig.properties" + FW_ConsoleColors.RESET);
            return;
        }

        // ===================== Required testConfig.properties Check - End =====================

        // ===================== Required files Check - Begin =====================
        System.out.println(FW_ConsoleColors.CORAL + "- Check required files exist..." + FW_ConsoleColors.RESET);

        // Check account JSON file exists
        Path serviceAccountJsonFilePath = Paths.get(googleCloudServiceAccountJsonFile);
        if (Files.exists(serviceAccountJsonFilePath)) {
            System.out.println(FW_ConsoleColors.GREEN + "  - PASS: Service Account file exists at " + serviceAccountJsonFilePath.toString() + FW_ConsoleColors.RESET);
        } else {
            System.err.println(FW_ConsoleColors.RED + "  - FAIL: Service Account file does not exist at " + serviceAccountJsonFilePath.toString() + FW_ConsoleColors.RESET);
            return;
        }

        // Check googleCloudProjectDatasetTableClientsSchema file exists
        Path googleCloudProjectDatasetTableClientsSchemaFilePath = Paths.get(googleCloudProjectDatasetTableClientsSchema);
        if (Files.exists(googleCloudProjectDatasetTableClientsSchemaFilePath)) {
            System.out.println(FW_ConsoleColors.GREEN + "  - PASS: Schema file exists at " + googleCloudProjectDatasetTableClientsSchemaFilePath.toString() + FW_ConsoleColors.RESET);
        } else {
            System.err.println(FW_ConsoleColors.RED + "  - FAIL: Schema file does not exist at " + googleCloudProjectDatasetTableClientsSchemaFilePath.toString() + FW_ConsoleColors.RESET);
            return;
        }

        // Check googleCloudProjectDatasetTableProjectsSchema file exists
        Path googleCloudProjectDatasetTableProjectsSchemaFilePath = Paths.get(googleCloudProjectDatasetTableProjectsSchema);
        if (Files.exists(googleCloudProjectDatasetTableProjectsSchemaFilePath)) {
            System.out.println(FW_ConsoleColors.GREEN + "  - PASS: Schema file exists at " + googleCloudProjectDatasetTableProjectsSchemaFilePath.toString() + FW_ConsoleColors.RESET);
        } else {
            System.err.println(FW_ConsoleColors.RED + "  - FAIL: Schema file does not exist at " + googleCloudProjectDatasetTableProjectsSchemaFilePath.toString() + FW_ConsoleColors.RESET);
            return;
        }

        // Check googleCloudProjectDatasetTableApplicationsSchema file exists
        Path googleCloudProjectDatasetTableApplicationsSchemaFilePath = Paths.get(googleCloudProjectDatasetTableApplicationsSchema);
        if (Files.exists(googleCloudProjectDatasetTableApplicationsSchemaFilePath)) {
            System.out.println(FW_ConsoleColors.GREEN + "  - PASS: Schema file exists at " + googleCloudProjectDatasetTableApplicationsSchemaFilePath.toString() + FW_ConsoleColors.RESET);
        } else {
            System.err.println(FW_ConsoleColors.RED + "  - FAIL: Schema file does not exist at " + googleCloudProjectDatasetTableApplicationsSchemaFilePath.toString() + FW_ConsoleColors.RESET);
            return;
        }

        // Check googleCloudProjectDatasetTableTestStepsSchema file exists
        Path googleCloudProjectDatasetTableTestStepsSchemaFilePath = Paths.get(googleCloudProjectDatasetTableTestStepsSchema);
        if (Files.exists(googleCloudProjectDatasetTableTestStepsSchemaFilePath)) {
            System.out.println(FW_ConsoleColors.GREEN + "  - PASS: Schema file exists at " + googleCloudProjectDatasetTableTestStepsSchemaFilePath.toString() + FW_ConsoleColors.RESET);
        } else {
            System.err.println(FW_ConsoleColors.RED + "  - FAIL: Schema file does not exist at " + googleCloudProjectDatasetTableTestStepsSchemaFilePath.toString() + FW_ConsoleColors.RESET);
            return;
        }

        // ===================== Required files Check - End =====================

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
            e.printStackTrace();
            return;
        }
        // ===================== Google Cloud - Access API Key - End =====================

        // ===================== Google Sheets - Get Sheet API Client - Begin =====================
        System.out.println(FW_ConsoleColors.CORAL + "- Google Sheets - Get Seet API Client..." + FW_ConsoleColors.RESET);

        // Get the Sheets API client
        Sheets sheetAPIClient;
        try {
            // Create the Sheets API client
            sheetAPIClient = getGoogleSheetsService(credentials);

            // Check if the Sheets API client is valid
            if (sheetAPIClient == null) {
                System.err.println(FW_ConsoleColors.RED + "  - FAIL: Issue encountered creating Google Sheets API client." + FW_ConsoleColors.RESET);
                return;
            }
            System.out.println(FW_ConsoleColors.GREEN + "  - PASS: Google Sheets API client created successfully" + FW_ConsoleColors.RESET);
        } catch (GeneralSecurityException | IOException e) {
            System.err.println(FW_ConsoleColors.RED + "  - FAIL: Issue encountered creating Google Sheets API client." + e.getMessage() + FW_ConsoleColors.RESET);
            e.printStackTrace();
            return;
        }
        // ===================== Google Sheets - Get Sheet API Client - End =====================

        // ===================== Google Sheets - Access Sheet Tabs - Begin =====================
        System.out.println(FW_ConsoleColors.CORAL + "- Google Sheets - Access Sheet Tabs..." + FW_ConsoleColors.RESET);

        // Check if the Google Sheet exists and get the tabs
        List<String> sheetTabs = getGoogleSheetTabs(sheetAPIClient, googleSheetId);
        if (sheetTabs != null) {
            System.out.println(FW_ConsoleColors.GREEN + "  - PASS: Google Sheet exists with tabs: " + sheetTabs + FW_ConsoleColors.RESET);
        } else {
            System.err.println(FW_ConsoleColors.RED + "  - FAIL: Google Sheet does not exist." + FW_ConsoleColors.RESET);
        }
        // ===================== Google Sheets - Access Sheet Tabs - End =====================

        // ===================== Google Sheets - Access Tab Rows - Begin =====================
        System.out.println(FW_ConsoleColors.CORAL + "- Google Sheets - Access Tab Rows..." + FW_ConsoleColors.RESET);

        // Read data from the Google Sheet tab clients
        List<Map<String, Object>> data_clients = readDataFromGoogleSheet(sheetAPIClient, googleSheetId, googleSheetTabNameClients);
        if (data_clients == null || data_clients.isEmpty()) {return;}

        // Read data from the Google Sheet tab projects
        List<Map<String, Object>> data_projects = readDataFromGoogleSheet(sheetAPIClient, googleSheetId, googleSheetTabNameProjects);
        if (data_projects == null || data_projects.isEmpty()) {return;}

        // Read data from the Google Sheet tab applications
        List<Map<String, Object>> data_applications = readDataFromGoogleSheet(sheetAPIClient, googleSheetId, googleSheetTabNameApplications);
        if (data_applications == null || data_applications.isEmpty()) {return;}

        // ===================== Google Sheets - Access Tab Rows - End =====================

        System.out.println("");
        System.out.println(FW_ConsoleColors.CORAL + "- - - - - Google Sheet - Import into BigQuery - (End) - - - - -" + FW_ConsoleColors.RESET);
        System.out.println("");
    }

    /**
     * Initializes the Sheets API client.
     * 
     * @param credentials The Google credentials.
     * 
     * @return An instance of the Sheets API client.
     * 
     * @throws GeneralSecurityException If there is a security exception.
     * @throws IOException If there is an I/O exception.
     */
    public static Sheets getGoogleSheetsService(GoogleCredentials credentials) throws GeneralSecurityException, IOException {

        // Build a new authorized API client service
        final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();

        // Load service account credentials
        GoogleCredentials credential = credentials;

        // Create an HttpRequestInitializer to set credentials and other request properties
        HttpRequestInitializer requestInitializer = request -> {
            credential.refreshIfExpired(); // Ensure the token is valid
            request.getHeaders().putAll(credential.getRequestMetadata());
            request.setConnectTimeout(60000);  // 1-minute connect timeout
            request.setReadTimeout(60000);    // 1-minute read timeout
        };

        // Build the Sheets API client
        Sheets sheetAPIClient = new Sheets.Builder(HTTP_TRANSPORT, GsonFactory.getDefaultInstance(), requestInitializer)
            .setApplicationName("Google Sheets API")
            .build();

        return sheetAPIClient;
    }

    /**
     * Get a list of all sheet tab names in a Google Sheet.
     * 
     * @param sheetAPIClient The Sheet API client.
     * @param spreadsheetId The ID of the spreadsheet.
     * 
     * @return A list of all sheet tab names null otherwise.
     */
    public static List<String> getGoogleSheetTabs(Sheets sheetAPIClient, String spreadsheetId) {
        try {
            Spreadsheet spreadsheet = sheetAPIClient.spreadsheets().get(spreadsheetId).execute();
            if (spreadsheet != null && spreadsheet.getSheets() != null) {
                List<Sheet> sheets = spreadsheet.getSheets();
                return sheets.stream()
                        .map(sheet -> sheet.getProperties().getTitle())
                        .collect(Collectors.toList());
            }
        } catch (IOException e) {
            //e.printStackTrace();
        }
        return null;
    }

    /**
     * Validate the Google Sheet tab exists.
     * 
     * @param sheetAPIClient
     * @param spreadsheetId
     * @param tabName
     * 
     * @return true if the tab exists, false otherwise.
     */
    public static boolean validateGoogleSheetTabExists(Sheets sheetAPIClient, String spreadsheetId, String tabName) {
        List<String> sheetTabs = getGoogleSheetTabs(sheetAPIClient, spreadsheetId);
        return sheetTabs != null && sheetTabs.contains(tabName);
    }

    /**
     * Get the Google Sheet tab row count.
     * 
     * @param sheetAPIClient
     * @param spreadsheetId
     * @param tabName
     * 
     * @return The row count of the tab or -1 if the tab does not exist.
     */
    public static int getGoogleSheetTabRowCount(Sheets sheetAPIClient, String spreadsheetId, String tabName) {
        
        // Confirm the tab name exists before proceeding
        if (!validateGoogleSheetTabExists(sheetAPIClient, spreadsheetId, tabName)) {
            return -1;
        }
        
        // Get the row count
        try {
            String range = tabName + "!A1:Z"; // Adjust the range as needed to cover all columns
            ValueRange response = sheetAPIClient.spreadsheets().values().get(spreadsheetId, range).execute();
            List<List<Object>> values = response.getValues();

            // Check if the values are empty
            if (values == null || values.isEmpty()) {
                return -1;
            }

            // Return the row count
            return values.size();

        } catch (IOException e) {
            //e.printStackTrace();

            // Return -1 if an exception occurs
            return -1;
        }
    }

    /**
     * Get the Google Sheet tab column count.
     * 
     * @param sheetAPIClient
     * @param spreadsheetId
     * @param tabName
     * 
     * @return The column count of the tab or -1 if the tab does not exist.
     */
    public static int getGoogleSheetTabColumnCount(Sheets sheetAPIClient, String spreadsheetId, String tabName) {
        
        // Confirm the tab name exists before proceeding
        if (!validateGoogleSheetTabExists(sheetAPIClient, spreadsheetId, tabName)) {
            return -1;
        }
        
        // Get the column count
        try {
            String range = tabName + "!A1:Z"; // Adjust the range as needed to cover all columns
            ValueRange response = sheetAPIClient.spreadsheets().values().get(spreadsheetId, range).execute();
            List<List<Object>> values = response.getValues();

            // Check if the values are empty
            if (values == null || values.isEmpty()) {
                return -1;
            }

            // Return the column count
            return values.get(0).size();

        } catch (IOException e) {
            //e.printStackTrace();

            // Return -1 if an exception occurs
            return -1;
        }
    }

    /**
     * Reads data from a Google Sheet.
     * 
     * @param sheetAPIClient The Sheets API client.
     * @param spreadsheetId The ID of the spreadsheet.
     * @param tabName The name of the tab to read data from.
     * 
     * @return A list of maps representing the data.
     */
    public static List<Map<String, Object>> readDataFromGoogleSheet(Sheets sheetAPIClient, String spreadsheetId, String tabName) {
        
        // Initialize an empty list to store the data
        List<Map<String, Object>> data = new ArrayList<>();

        try {
            // Confirm the tab name exists before proceeding
            List<String> sheetTabs = getGoogleSheetTabs(sheetAPIClient, spreadsheetId);
            if (sheetTabs == null || !sheetTabs.contains(tabName)) {
                System.err.println(FW_ConsoleColors.RED + "  - FAIL: Google Sheet tab does not exist." + FW_ConsoleColors.RESET);
                return null;
            }

            String range = tabName + "!A1:Z"; // Adjust the range as needed to cover all columns
            ValueRange response = sheetAPIClient.spreadsheets().values().get(spreadsheetId, range).execute();
            List<List<Object>> values = response.getValues();
            if (values == null || values.isEmpty()) {
                System.err.println(FW_ConsoleColors.RED + "  - FAIL: No data found in Google tab " + tabName + "." + FW_ConsoleColors.RESET);
                return null;
            }

            List<Object> headers = values.get(0);
            for (int i = 1; i < values.size(); i++) {
                List<Object> row = values.get(i);
                Map<String, Object> rowData = new HashMap<>();
                for (int j = 0; j < headers.size(); j++) {
                    rowData.put(headers.get(j).toString(), row.get(j));
                }
                data.add(rowData);
            }

            // Get the number of rows and columns
            int rowCount = data.size();
            int columnCount = data.get(0).size();

            System.out.println(FW_ConsoleColors.GREEN + "  - PASS: Google tab " + tabName + " data read successfully with " + rowCount + " rows and " + columnCount + " columns." + FW_ConsoleColors.RESET);
        } catch (IOException e) {
            System.err.println(FW_ConsoleColors.RED + "  - FAIL: Issue encountered reading Google Sheet data. " + e.getMessage() + FW_ConsoleColors.RESET);
            e.printStackTrace();
            return null;
        }
        return data;
    }
}