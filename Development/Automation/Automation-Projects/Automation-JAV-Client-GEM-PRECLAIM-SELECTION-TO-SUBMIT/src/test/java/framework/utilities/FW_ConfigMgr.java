package framework.utilities;
/**
 * @file FW_ConfigMgr.java
 * @description Manages configuration data for the test automation framework.
 * 
 * This file contains the FW_ConfigMgr class which reads a properties file (testConfig.properties) and stores the properties as global variables in a map.
 * It includes functionalities to initialize global variables, retrieve configuration values, and manage configuration data that needs to be accessed globally within the test automation framework.
 * 
 * The FW_ConfigMgr class offers functionalities to:
 * - Initialize global variables by reading the properties file.
 * - Retrieve configuration values.
 * - Manage configuration data globally.
 * 
 * This class is designed to manage the overall configuration process, ensuring that configuration data is properly initialized and accessible throughout the test automation framework.
 */

import java.io.FileInputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * The ConfigMgr class is a singleton class that reads a properties file (testConfig.properties)
 * and stores the properties as global variables in a map. This class is used to manage
 * configuration data that needs to be accessed globally within the test autoamtion and framework.
 */
public class FW_ConfigMgr {
    private static FW_ConfigMgr instance = null; // Singleton instance
    private Map<String, GlobalVariable> globalVariables = new HashMap<>();
    private SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");

    /**
     * Returns the singleton instance of the ConfigMgr class.
     * If the instance does not exist, it is created.
     *
     * @return the singleton instance of the ConfigMgr class
     */
    public static synchronized FW_ConfigMgr getInstance() {
        if (instance == null) {
            instance = new FW_ConfigMgr();
        }
        return instance;
    }

    /**
     * Constructs a new ConfigMgr object and reads the testConfig.properties file.
     */
    private FW_ConfigMgr() {
        try {
            FileInputStream fis = new FileInputStream("src/test/resources/testConfig.properties");
            Properties properties = new Properties();
            properties.load(fis);

            // Initialize global variables
            for (String name : properties.stringPropertyNames()) {
                String value = properties.getProperty(name);
                String type = "String"; // default type
                Object parsedValue = value; // default parsed value

                if (value.equalsIgnoreCase("true") || value.equalsIgnoreCase("false")) {
                    type = "Boolean";
                    parsedValue = Boolean.parseBoolean(value);
                } else {
                    try {
                        parsedValue = Integer.parseInt(value);
                        type = "Integer";
                    } catch (NumberFormatException e1) {
                        try {
                            parsedValue = Long.parseLong(value);
                            type = "Long";
                        } catch (NumberFormatException e2) {
                            try {
                                parsedValue = Double.parseDouble(value);
                                type = "Double";
                            } catch (NumberFormatException e3) {
                                try {
                                    parsedValue = dateFormat.parse(value);
                                    type = "Date";
                                } catch (ParseException e4) {
                                    // value is a string, no need to parse it
                                }
                            }
                        }
                    }
                }

                globalVariables.put(name, new GlobalVariable(name, type, parsedValue));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Returns the GlobalVariable associated with the specified key.
     *
     * @param key the key whose associated GlobalVariable is to be returned
     * @return the GlobalVariable associated with the specified key, or null if this map contains no mapping for the key
     */
    public GlobalVariable getVar(String key) {
        GlobalVariable var = globalVariables.get(key);
        if (var == null) {
            var = new GlobalVariable(key,"String",""); // Set to return an empty string if the key is not found
        }
        return var;
    }

    /**
     * Returns the value of the GlobalVariable associated with the specified key.
     *
     * @param key the key whose associated GlobalVariable's value is to be returned
     * @return the value of the GlobalVariable associated with the specified key, or null if this map contains no mapping for the key
     */
    public static Object getVarVal(String key) {
        return getInstance().getVar(key).getValue();
    }

    /**
     * Returns the version in testConfig.properties.
     *
     * @return the version of the testConfig.properties file
     */
    public static double getVersion() {
        Object value = getVarVal("version");
        if (value instanceof Number) {
            return ((Number) value).doubleValue();
        } else {
            throw new RuntimeException("version is not a Number");
        }
    }

    // ############### Client, Project, Application Configuration ###############

    /**
     * Returns the clientRefID testConfig.properties value.
     * 
     * @return the clientRefID value.
     */
    public static String getClientRefID() {
        Object value = getVarVal("clientRefID");
        if (value instanceof String) {
            return (String) value;
        } else {
            throw new RuntimeException("clientRefID is not a String");
        }
    }

    /**
     * Returns the projectRefID testConfig.properties value.
     * 
     * @return the projectRefID value.
     */
    public static String getProjectRefID() {
        Object value = getVarVal("projectRefID");
        if (value instanceof String) {
            return (String) value;
        } else {
            throw new RuntimeException("projectRefID is not a String");
        }
    }

    /**
     * Returns the applicationRefID testConfig.properties value.
     * 
     * @return the applicationRefID value.
     */
    public static String getApplicationRefID() {
        Object value = getVarVal("applicationRefID");
        if (value instanceof String) {
            return (String) value;
        } else {
            throw new RuntimeException("applicationRefID is not a String");
        }
    }

    // ############### Execution Configuration ###############

    /**
     * Returns the parallelExecution testConfig.properties value.
     *
     * @return the parallelExecution value.
     */
    public static String getParallelExecution() {
        Object value = getVarVal("parallelExecution");
        value = value.toString(); // convert to type String
        if (value instanceof String) {
            return (String) value;
        } else {
            throw new RuntimeException("parallelExecution is not a String");
        }
    }

    /**
     * Returns the parallelExecutionThreads testConfig.properties value.
     *
     * @return the parallelExecutionThreads value.
     */
    public static int getParallelExecutionThreads() {
        Object value = getVarVal("parallelExecutionThreads");
        if (value instanceof Integer) {
            return (Integer) value;
        } else {
            throw new RuntimeException("parallelExecutionThreads is not an Integer");
        }
    }

    // ############### User Satisfaction Assessment configuration ###############

    /**
     * Returns the userSatisfactionAssessment testConfig.properties value.
     *
     * @return the userSatisfactionAssessment value.
     */
    public static String getUserSatisfactionAssessment() {
        Object value = getVarVal("userSatisfactionAssessment");
        value = value.toString(); // convert to type String
        if (value instanceof String) {
            return (String) value;
        } else {
            throw new RuntimeException("userSatisfactionAssessment is not a String");
        }
    }

    // ############### Screen capture configuration ###############

    /**
     * Returns the screenCaptureOnTestStepResults testConfig.properties value.
     *
     * @return the screenCaptureOnTestStepResults value.
     */
    public static String getScreenCaptureOnTestStepResults() {
        Object value = getVarVal("screenCaptureOnTestStepResults");
        value = value.toString(); // convert to type String
        if (value instanceof String) {
            return (String) value;
        } else {
            throw new RuntimeException("screenCaptureOnTestStepResults is not a String");
        }
    }

    /**
     * Returns the screenCaptureOnTestStepResultsSelection testConfig.properties value.
     *
     * @return the screenCaptureOnTestStepResultsSelection value.
     */
    public static String getScreenCaptureOnTestStepResultsSelection() {
        Object value = getVarVal("screenCaptureOnTestStepResultsSelection");
        value = value.toString(); // convert to type String
        if (value instanceof String) {
            return (String) value;
        } else {
            throw new RuntimeException("screenCaptureOnTestStepResultsSelection is not a String");
        }
    }

    /**
     * Returns the screenCaptureOutputPath testConfig.properties value.
     *
     * @return the screenCaptureOutputPath value.
     */
    public static String getScreenCaptureOutputPath() {
        Object value = getVarVal("screenCaptureOutputPath");
        if (value instanceof String) {
            return (String) value;
        } else {
            throw new RuntimeException("screenCaptureOutputPath is not a String");
        }
    }

    /**
     * Returns the screenCaptureArchivePath testConfig.properties value.
     * 
     * @return the screenCaptureArchivePath value.
     */
    public static String getScreenCaptureArchivePath() {
        Object value = getVarVal("screenCaptureArchivePath");
        if (value instanceof String) {
            return (String) value;
        } else {
            throw new RuntimeException("screenCaptureArchivePath is not a String");
        }
    }

    // ############### Browser configuration ###############

    /**
     * Returns the browser testConfig.properties value.
     *
     * @return the browser value.
     */
    public static String getBrowser() {
        Object value = getVarVal("browser");
        if (value instanceof String) {
            return (String) value;
        } else {
            throw new RuntimeException("browser is not a String");
        }
    }

    /**
     * Returns the headless testConfig.properties value.
     *
     * @return the headless value.
     */
    public static String getHeadless() {
        Object value = getVarVal("headless");
        value = value.toString(); // convert to type String
        if (value instanceof String) {
            return (String) value;
        } else {
            throw new RuntimeException("headless is not a String");
        }
    }

    /**
     * Returns the selectorsHub testConfig.properties value.
     *
     * @return the selectorsHub value.
     */
    public static String getSelctorsHub() {
        Object value = getVarVal("selectorsHub");
        value = value.toString(); // convert to type String
        if (value instanceof String) {
            return (String) value;
        } else {
            throw new RuntimeException("selectorsHub is not a String");
        }
    }

    /**
     * Returns the selectorsHubDirectory testConfig.properties value.
     *
     * @return the selectorsHubDirectory value.
     */
    public static String getSelctorsHubDirectory() {
        Object value = getVarVal("selectorsHubDirectory");
        value = value.toString(); // convert to type String
        if (value instanceof String) {
            return (String) value;
        } else {
            throw new RuntimeException("selectorsHubDirectory is not a String");
        }
    }

    // ############### Image configuration ###############
    /**
     * Returns the imageTrim testConfig.properties value.
     *
     * @return the imageTrim value.
     */
    public static String getImageTrim() {
        Object value = getVarVal("imageTrim");
        value = value.toString(); // convert to type String
        if (value instanceof String) {
            return (String) value;
        } else {
            throw new RuntimeException("imageTrim is not a String");
        }
    }

    /**
     * Returns the imageTrimBackgroundThreshold testConfig.properties value.
     * 
     * @return the imageTrimBackgroundThreshold value.
     */
    public static int getImageTrimBackgroundThreshold() {
        Object value = getVarVal("imageTrimBackgroundThreshold");
        if (value instanceof Integer) {
            return (Integer) value;
        } else {
            throw new RuntimeException("imageTrimBackgroundThreshold is not an Integer");
        }
    }

    /**
     * Returns the imageConversionToJPG testConfig.properties value.
     *
     * @return the imageConversionToJPG value.
     */
    public static String getImageConversionToJPG() {
        Object value = getVarVal("imageConversionToJPG");
        value = value.toString(); // convert to type String
        if (value instanceof String) {
            return (String) value;
        } else {
            throw new RuntimeException("imageConversionToJPG is not a String");
        }
    }
    
    /**
     * Returns the imageCompressionJPGQuality testConfig.properties value.
     * 
     * @return the imageCompressionJPGQuality value.
     */
    public static int getImageCompressionJPGQuality() {
        Object value = getVarVal("imageCompressionJPGQuality");
        if (value instanceof Integer) {
            return (Integer) value;
        } else {
            throw new RuntimeException("imageCompressionJPGQuality is not an Integer");
        }
    }

    /**
     * Returns the imageThumbnailMaxSize testConfig.properties value.
     * 
     * @return the imageThumbnailMaxSize value.
     */
    public static int getImageThumbnailMaxSize() {
        Object value = getVarVal("imageThumbnailMaxSize");
        if (value instanceof Integer) {
            return (Integer) value;
        } else {
            throw new RuntimeException("imageThumbnailMaxSize is not an Integer");
        }
    }

    /**
     * Returns the imageThumbnailCompressionJPGQuality testConfig.properties value.
     * 
     * @return the imageThumbnailCompressionJPGQuality value.
     */
    public static int getImageThumbnailCompressionJPGQuality() {
        Object value = getVarVal("imageThumbnailCompressionJPGQuality");
        if (value instanceof Integer) {
            return (Integer) value;
        } else {
            throw new RuntimeException("imageThumbnailCompressionJPGQuality is not an Integer");
        }
    }

    // ############### Data Configuration ###############

    /**
     * Returns the dataTestStepsFilename testConfig.properties value.
     * 
     * @return the dataTestStepsFilename value.
     */
    public static String getDataTestStepsFilename() {
        Object value = getVarVal("dataTestStepsFilename");
        if (value instanceof String) {
            return (String) value;
        } else {
            throw new RuntimeException("dataTestStepsFilename is not a String");
        }
    }

    /**
     * Returns the dataOutputPath testConfig.properties value.
     * 
     * @return the dataOutputPath value.
     */
    public static String getDataOutputPath() {
        Object value = getVarVal("dataOutputPath");
        if (value instanceof String) {
            return (String) value;
        } else {
            throw new RuntimeException("dataOutputPath is not a String");
        }
    }

    /**
     * Returns the dataArchivePath testConfig.properties value.
     * 
     * @return the dataArchivePath value.
     */
    public static String getDataArchivePath() {
        Object value = getVarVal("dataArchivePath");
        if (value instanceof String) {
            return (String) value;
        } else {
            throw new RuntimeException("dataArchivePath is not a String");
        }
    }

    // ############### GeoIP configuration ###############
    /**
     * Returns the geoLite2ASNDatabase testConfig.properties value.
     * 
     * @return the geoLite2ASNDatabase value.
     */
    public static String getGeoLite2ASNDatabase() {
        Object value = getVarVal("geoLite2ASNDatabase");
        if (value instanceof String) {
            return (String) value;
        } else {
            throw new RuntimeException("geoLite2ASNDatabase is not a String");
        }
    }
    
    /**
     * Returns the geoLite2CityDatabase testConfig.properties value.
     * 
     * @return the geoLite2CityDatabase value.
     */
    public static String getGeoLite2CityDatabase() {
        Object value = getVarVal("geoLite2CityDatabase");
        if (value instanceof String) {
            return (String) value;
        } else {
            throw new RuntimeException("geoLite2CityDatabase is not a String");
        }
    }

    // ############### Google Sheet Configuration ###############

    /**
     * Returns the googleSheetSyncToBigQuery testConfig.properties value.
     * 
     * @return the googleSheetSyncToBigQuery value.
     */
    public static String getGoogleSheetSyncToBigQuery() {
        Object value = getVarVal("googleSheetSyncToBigQuery");
        value = value.toString(); // convert to type String
        if (value instanceof String) {
            return (String) value;
        } else {
            throw new RuntimeException("googleSheetSyncToBigQuery is not a String");
        }
    }

    /**
     * Returns the googleSheetName testConfig.properties value.
     * 
     * @return the googleSheetName value.
     */
    public static String getGoogleSheetName() {
        Object value = getVarVal("googleSheetName");
        if (value instanceof String) {
            return (String) value;
        } else {
            throw new RuntimeException("googleSheetName is not a String");
        }
    }

    /**
     * Returns the googleSheetId testConfig.properties value.
     * 
     * @return the googleSheetId value.
     */
    public static String getGoogleSheetId() {
        Object value = getVarVal("googleSheetId");
        if (value instanceof String) {
            return (String) value;
        } else {
            throw new RuntimeException("googleSheetId is not a String");
        }
    }

    /**
     * Returns the googleSheetTabNameClients testConfig.properties value.
     * 
     * @return the googleSheetTabNameClients value.
     */
    public static String getGoogleSheetTabNameClients() {
        Object value = getVarVal("googleSheetTabNameClients");
        if (value instanceof String) {
            return (String) value;
        } else {
            throw new RuntimeException("googleSheetTabNameClients is not a String");
        }
    }

    /**
     * Returns the googleSheetTabNameProjects testConfig.properties value.
     * 
     * @return the googleSheetTabNameProjects value.
     */
    public static String getGoogleSheetTabNameProjects() {
        Object value = getVarVal("googleSheetTabNameProjects");
        if (value instanceof String) {
            return (String) value;
        } else {
            throw new RuntimeException("googleSheetTabNameProjects is not a String");
        }
    }

    /**
     * Returns the googleSheetTabNameApplications testConfig.properties value.
     * 
     * @return the googleSheetTabNameApplications value.
     */
    public static String getGoogleSheetTabNameApplications() {
        Object value = getVarVal("googleSheetTabNameApplications");
        if (value instanceof String) {
            return (String) value;
        } else {
            throw new RuntimeException("googleSheetTabNameApplications is not a String");
        }
    }

    // ############### Google Cloud Configuration ###############

    /**
     * Returns the googleCloudProjectId value.
     * 
     * @return the googleCloudProjectId value.
     */
    public static String getGoogleCloudProjectId() {
        Object value = getVarVal("googleCloudProjectId");
        if (value instanceof String) {
            return (String) value;
        } else {
            throw new RuntimeException("googleCloudProjectId is not a String");
        }
    }

    /**
     * Returns the googleCloudServiceAccountJsonFile value.
     * 
     * @return the googleCloudServiceAccountJsonFile value.
     */
    public static String getGoogleCloudServiceAccountJsonFile() {
        Object value = getVarVal("googleCloudServiceAccountJsonFile");
        if (value instanceof String) {
            return (String) value;
        } else {
            throw new RuntimeException("googleCloudServiceAccountJsonFile is not a String");
        }
    }

    // ---------- Google Cloud - Storage ----------

    /**
     * Returns the googleCloudStorageExport option
     * 
     * @return the googleCloudStorageExport value.
     */
    public static String getGoogleCloudStorageExport() {
        Object value = getVarVal("googleCloudStorageExport");
        value = value.toString(); // convert to type String
        if (value instanceof String) {
            return (String) value;
        } else {
            throw new RuntimeException("googleCloudStorageExport is not a String");
        }
    }

    /**
     * Returns the googleCloudStorageBaseURL value.
     * 
     * @return the googleCloudStorageBaseURL value.
     */
    public static String getGoogleCloudStorageBaseURL() {
        Object value = getVarVal("googleCloudStorageBaseURL");
        if (value instanceof String) {
            return (String) value;
        } else {
            throw new RuntimeException("googleCloudStorageBaseURL is not a String");
        }
    }

    /**
     * Returns the googleCloudStorageBucket value.
     * 
     * @return the googleCloudStorageBucket value.
     */
    public static String getGoogleCloudStorageBucket() {
        Object value = getVarVal("googleCloudStorageBucket");
        if (value instanceof String) {
            return (String) value;
        } else {
            throw new RuntimeException("googleCloudStorageBucket is not a String");
        }
    }

    // ---------- Google Cloud - BigQuery ----------

     /**
     * Returns the googleCloudBigQueryExport option
     *
     * @return the googleCloudBigQueryExport value.
     */
    public static String getGoogleCloudBigQueryExport() {
        Object value = getVarVal("googleCloudBigQueryExport");
        value = value.toString(); // convert to type String
        if (value instanceof String) {
            return (String) value;
        } else {
            throw new RuntimeException("googleCloudBigQueryExport is not a String");
        }
    }

    /**
     * Returns the googleCloudBigQueryTimeout option
     * 
     * @return the googleCloudBigQueryTimeout value.
     */
    public static int getGoogleCloudBigQueryTimeout() {
        Object value = getVarVal("googleCloudBigQueryTimeout");
        if (value instanceof Integer) {
            return (Integer) value;
        } else {
            throw new RuntimeException("googleCloudBigQueryTimeout is not an Integer");
        }
    }

    /**
     * Returns the googleCloudBigQueryMaxAttempts option
     * 
     * @return the googleCloudBigQueryMaxAttempts value.
     */
    public static int getGoogleCloudBigQueryMaxAttempts() {
        Object value = getVarVal("googleCloudBigQueryMaxAttempts");
        if (value instanceof Integer) {
            return (Integer) value;
        } else {
            throw new RuntimeException("googleCloudBigQueryMaxAttempts is not an Integer");
        }
    }

    /**
     * Returns the googleCloudProjectDataset value.
     * 
     * @return the googleCloudProjectDataset value.
     */
    public static String getGoogleCloudProjectDataset() {
        Object value = getVarVal("googleCloudProjectDataset");
        if (value instanceof String) {
            return (String) value;
        } else {
            throw new RuntimeException("googleCloudProjectDataset is not a String");
        }
    }

    /**
     * Returns the googleCloudProjectDatasetTableClients value.
     *  
     * @return the googleCloudProjectDatasetTableClients value.
     */
    public static String getGoogleCloudProjectDatasetTableClients() {
        Object value = getVarVal("googleCloudProjectDatasetTableClients");
        if (value instanceof String) {
            return (String) value;
        } else {
            throw new RuntimeException("googleCloudProjectDatasetTableClients is not a String");
        }
    }

    /**
     * Returns the googleCloudProjectDatasetTableClientsSchema value.
     * 
     * @return the googleCloudProjectDatasetTableClientsSchema value.
     */
    public static String getGoogleCloudProjectDatasetTableClientsSchema() {
        Object value = getVarVal("googleCloudProjectDatasetTableClientsSchema");
        if (value instanceof String) {
            return (String) value;
        } else {
            throw new RuntimeException("googleCloudProjectDatasetTableClientsSchema is not a String");
        }
    }

    /**
     * Returns the googleCloudProjectDatasetTableProjects value.
     * 
     * @return the googleCloudProjectDatasetTableProjects value.
     */
    public static String getGoogleCloudProjectDatasetTableProjects() {
        Object value = getVarVal("googleCloudProjectDatasetTableProjects");
        if (value instanceof String) {
            return (String) value;
        } else {
            throw new RuntimeException("googleCloudProjectDatasetTableProjects is not a String");
        }
    }

    /**
     * Returns the googleCloudProjectDatasetTableProjectsSchema value.
     * 
     * @return the googleCloudProjectDatasetTableProjectsSchema value.
     */
    public static String getGoogleCloudProjectDatasetTableProjectsSchema() {
        Object value = getVarVal("googleCloudProjectDatasetTableProjectsSchema");
        if (value instanceof String) {
            return (String) value;
        } else {
            throw new RuntimeException("googleCloudProjectDatasetTableProjectsSchema is not a String");
        }
    }

    /**
     * Returns the googleCloudProjectDatasetTableApplications value.
     *  
     * @return the googleCloudProjectDatasetTableApplications value.
     */
    public static String getGoogleCloudProjectDatasetTableApplications() {
        Object value = getVarVal("googleCloudProjectDatasetTableApplications");
        if (value instanceof String) {
            return (String) value;
        } else {
            throw new RuntimeException("googleCloudProjectDatasetTableApplications is not a String");
        }
    }

    /**
     * Returns the googleCloudProjectDatasetTableApplicationsSchema value.
     * 
     * @return the googleCloudProjectDatasetTableApplicationsSchema value.
     */
    public static String getGoogleCloudProjectDatasetTableApplicationsSchema() {
        Object value = getVarVal("googleCloudProjectDatasetTableApplicationsSchema");
        if (value instanceof String) {
            return (String) value;
        } else {
            throw new RuntimeException("googleCloudProjectDatasetTableApplicationsSchema is not a String");
        }
    }

    /**
     * Returns the googleCloudProjectDatasetTableTestSteps value.
     * 
     * @return the googleCloudProjectDatasetTableTestSteps value.
     */
    public static String getGoogleCloudProjectDatasetTableTestSteps() {
        Object value = getVarVal("googleCloudProjectDatasetTableTestSteps");
        if (value instanceof String) {
            return (String) value;
        } else {
            throw new RuntimeException("googleCloudProjectDatasetTableTestSteps is not a String");
        }
    }

    /**
     * Returns the googleCloudProjectDatasetTableTestStepsSchema value.
     * 
     * @return the googleCloudProjectDatasetTableTestStepsSchema value.
     */
    public static String getGoogleCloudProjectDatasetTableTestStepsSchema() {
        Object value = getVarVal("googleCloudProjectDatasetTableTestStepsSchema");
        if (value instanceof String) {
            return (String) value;
        } else {
            throw new RuntimeException("googleCloudProjectDatasetTableTestStepsSchema is not a String");
        }
    }

    // ############### Locator configuration ###############

    /**
     * Returns the defaultTimeout testConfig.properties value.
     *
     * @return the defaultTimeout value.
     */
    public static int getDefaultTimeout() {
        Object value = getVarVal("defaultTimeout");
        if (value instanceof Integer) {
            return (Integer) value;
        } else {
            throw new RuntimeException("defaultTimeout is not an Integer");
        }
    }

    /**
     * Returns the defaultInterval testConfig.properties value.
     *
     * @return the defaultInterval value.
     */
    public static int getDefaultInterval() {
        Object value = getVarVal("defaultInterval");
        if (value instanceof Integer) {
            return (Integer) value;
        } else {
            throw new RuntimeException("defaultInterval is not an Integer");
        }
    }

    // ############### Locator highlighting configuration ###############

    /**
     * Returns the locatorHighlight testConfig.properties value.
     *
     * @return the locatorHighlight value.
     */
    public static String getLocatorHighlight() {
        Object value = getVarVal("locatorHighlight");
        value = value.toString(); // convert to type String
        if (value instanceof String) {
            return (String) value;
        } else {
            throw new RuntimeException("locatorHighlight is not a String");
        }
    }

    /**
     * Returns the locatorHighlightOnLoad testConfig.properties value.
     * 
     * @return the locatorHighlightOnLoad value.
     */
    public static String getLocatorHighlightOnLoad() {
        Object value = getVarVal("locatorHighlightOnLoad");
        value = value.toString(); // convert to type String
        if (value instanceof String) {
            return (String) value;
        } else {
            throw new RuntimeException("locatorHighlightOnLoad is not a String");
        }
    }

    /**
     * Returns the locatorHighlightCSS testConfig.properties value.
     *
     * @return the locatorHighlightCSS value.
     */
    public static String getLocatorHighlightCSS() {
        Object value = getVarVal("locatorHighlightCSS");
        value = value.toString(); // convert to type String
        if (value instanceof String) {
            return (String) value;
        } else {
            throw new RuntimeException("locatorHighlightCSS is not a String");
        }
    }

    /**
     * Returns the locatorHighlightPassCSS testConfig.properties value.
     *
     * @return the locatorHighlightPassCSS value.
     */
    public static String getLocatorHighlightPassCSS() {
        Object value = getVarVal("locatorHighlightPassCSS");
        value = value.toString(); // convert to type String
        if (value instanceof String) {
            return (String) value;
        } else {
            throw new RuntimeException("locatorHighlightPassCSS is not a String");
        }
    }

    /**
     * Returns the locatorHighlightWarnCSS testConfig.properties value.
     *
     * @return the locatorHighlightWarnCSS value.
     */
    public static String getLocatorHighlightWarnCSS() {
        Object value = getVarVal("locatorHighlightWarnCSS");
        value = value.toString(); // convert to type String
        if (value instanceof String) {
            return (String) value;
        } else {
            throw new RuntimeException("locatorHighlightWarnCSS is not a String");
        }
    }

    /**
     * Returns the locatorHighlightWarnLowCSS testConfig.properties value.
     *
     * @return the locatorHighlightWarnLowCSS value.
     */
    public static String getLocatorHighlightWarnLowCSS() {
        Object value = getVarVal("locatorHighlightWarnLowCSS");
        value = value.toString(); // convert to type String
        if (value instanceof String) {
            return (String) value;
        } else {
            throw new RuntimeException("locatorHighlightWarnLowCSS is not a String");
        }
    }

    /**
     * Returns the locatorHighlightWarnMediumCSS testConfig.properties value.
     *
     * @return the locatorHighlightWarnMediumCSS value.
     */
    public static String getLocatorHighlightWarnMediumCSS() {
        Object value = getVarVal("locatorHighlightWarnMediumCSS");
        value = value.toString(); // convert to type String
        if (value instanceof String) {
            return (String) value;
        } else {
            throw new RuntimeException("locatorHighlightWarnMediumCSS is not a String");
        }
    }

    /**
     * Returns the locatorHighlightWarnHighCSS testConfig.properties value.
     *
     * @return the locatorHighlightWarnHighCSS value.
     */
    public static String getLocatorHighlightWarnHighCSS() {
        Object value = getVarVal("locatorHighlightWarnHighCSS");
        value = value.toString(); // convert to type String
        if (value instanceof String) {
            return (String) value;
        } else {
            throw new RuntimeException("locatorHighlightWarnHighCSS is not a String");
        }
    }

    /**
     * Returns the locatorHighlightWarnCriticalCSS testConfig.properties value.
     *
     * @return the locatorHighlightWarnCriticalCSS value.
     */
    public static String getLocatorHighlightWarnCriticalCSS() {
        Object value = getVarVal("locatorHighlightWarnCriticalCSS");
        value = value.toString(); // convert to type String
        if (value instanceof String) {
            return (String) value;
        } else {
            throw new RuntimeException("locatorHighlightWarnCriticalCSS is not a String");
        }
    }

    /**
     * Returns the locatorHighlightFailCSS testConfig.properties value.
     *
     * @return the locatorHighlightFailCSS value.
     */
    public static String getLocatorHighlightFailCSS() {
        Object value = getVarVal("locatorHighlightFailCSS");
        value = value.toString(); // convert to type String
        if (value instanceof String) {
            return (String) value;
        } else {
            throw new RuntimeException("locatorHighlightFailCSS is not a String");
        }
    }
}

/**
 * This class represents a global variable with a name, type, and value.
 */
class GlobalVariable {
    private String name;
    private String type;
    private Object value;

    /**
     * Constructs a new GlobalVariable with the specified name, type, and value.
     *
     * @param name the name of the global variable
     * @param type the type of the global variable
     * @param value the value of the global variable
     */
    public GlobalVariable(String name, String type, Object value) {
        this.name = name;
        this.type = type;
        this.value = value;
    }

    /**
     * Returns the name of this global variable.
     *
     * @return the name of this global variable
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the type of this global variable.
     *
     * @return the type of this global variable
     */
    public String getType() {
        return type;
    }
    
    /**
     * Returns the value of this global variable.
     *
     * @return the value of this global variable
     */
    public Object getValue() {
        return value;
    }
}