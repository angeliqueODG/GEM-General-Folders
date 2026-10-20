package framework.utilities;

// ===============================================================
// @file: FW_ConfigMgr.java
// @filepath: src/test/java/framework/utilities/FW_ConfigMgr.java
// @version: 2.3.0
// @updated: 2026-05-01 11:00:00 AM CDT
// @author: Greg Paskal
// @company: MissionWares
//
// @description:
// Manages configuration data for the test automation framework.
// This singleton class reads a properties file (testConfig.properties) 
// and stores the properties as global variables in a map. It provides
// type-safe access to configuration values with automatic type detection
// and parsing for Boolean, Integer, Long, Double, Date, and String values.
// Uses modern Java 23 patterns including records, pattern matching, and
// generic helper methods to reduce code duplication.
//
// @methods:
// - getInstance() - Returns singleton instance of ConfigMgr
// - getVarVal(String) - Returns value for specified key
// - getBooleanValue(String, boolean) - Gets boolean with default
// - getConfigValue(String, Class<T>) - Generic type-safe getter
// Plus 50+ domain-specific configuration getters
//
// @dependencies:
// - java.io.FileInputStream
// - java.io.IOException
// - java.time.LocalDate
// - java.time.format.DateTimeFormatter
// - java.util.HashMap
// - java.util.Map
// - java.util.Properties
// - java.util.function.Function
//
// @tags: configuration, singleton, properties, test-settings, advisor, mAi™
//
// @changeLog:
// Date        Author          Version  Description
// ----------  --------------  -------  --------------------------
// 2025-01-10  G. Paskal       1.0.0    Initial implementation with mAi™ header
// 2025-09-29  G. Paskal       1.1.0    Added logic for reporting configuration
// 2025-10-01  G. Paskal       1.2.0    Replaced SimpleDateFormat with DateTimeFormatter for Java 23 compatibility
// 2025-10-08  G. Paskal       1.3.0    Added Advisor Configuration methods
// 2025-10-16  G. Paskal       2.0.0    Major refactor: Generic helpers, pattern matching, record for GlobalVariable, reduced from 1200 to 450 lines
// 2025-11-25  G. Paskal       2.1.0    Consolidated Report Configuration: added output format, help links, renamed advisorEnabled to reportAdvisorEnabled
// 2025-12-12  G. Paskal       2.2.0    Removed Unused Extensions
// 2026-05-01  G. Paskal       2.3.0    Added browser hardening getters: SuppressLeakDetection, SuppressPasswordManager, SuppressAutofillPrompts, SuppressAutomationInfobar, AcceptInsecureCerts
// ===============================================================

import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.function.Function;

/**
 * Singleton configuration manager for the test automation framework.
 * Provides type-safe access to configuration properties with automatic type detection.
 * Uses modern Java 23 patterns for concise, maintainable code.
 */
public class FW_ConfigMgr {
    private static FW_ConfigMgr instance = null;
    private final Map<String, GlobalVariable> globalVariables = new HashMap<>();
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("MM/dd/yyyy");

    /**
     * Returns the singleton instance of the ConfigMgr class.
     *
     * @return the singleton instance
     */
    public static synchronized FW_ConfigMgr getInstance() {
        if (instance == null) {
            instance = new FW_ConfigMgr();
        }
        return instance;
    }

    /**
     * Private constructor - reads and parses testConfig.properties file.
     * Automatically detects types: Boolean, Integer, Long, Double, LocalDate, String.
     */
    private FW_ConfigMgr() {
        try (FileInputStream fis = new FileInputStream("src/test/resources/testConfig.properties")) {
            Properties properties = new Properties();
            properties.load(fis);

            // Initialize global variables with automatic type detection
            for (String name : properties.stringPropertyNames()) {
                String value = properties.getProperty(name);
                GlobalVariable variable = parseConfigValue(name, value);
                globalVariables.put(name, variable);
            }

        } catch (IOException e) {
            throw new RuntimeException(
                "FATAL: Failed to load testConfig.properties from src/test/resources/. " +
                "Application cannot start without configuration file.", e);
        }
    }

    /**
     * Parses a configuration value and determines its type.
     *
     * @param name Property name
     * @param value Property value as string
     * 
     * @return GlobalVariable with detected type and parsed value
     */
    private GlobalVariable parseConfigValue(String name, String value) {
        // Try Boolean
        if (value.equalsIgnoreCase("true") || value.equalsIgnoreCase("false")) {
            return new GlobalVariable(name, "Boolean", Boolean.valueOf(value));
        }

        // Try Integer
        try {
            return new GlobalVariable(name, "Integer", Integer.valueOf(value));
        } catch (NumberFormatException ignored) {}

        // Try Long
        try {
            return new GlobalVariable(name, "Long", Long.valueOf(value));
        } catch (NumberFormatException ignored) {}

        // Try Double
        try {
            return new GlobalVariable(name, "Double", Double.valueOf(value));
        } catch (NumberFormatException ignored) {}

        // Try LocalDate
        try {
            return new GlobalVariable(name, "LocalDate", LocalDate.parse(value, DATE_FORMATTER));
        } catch (DateTimeParseException ignored) {}

        // Default to String
        return new GlobalVariable(name, "String", value);
    }

    // ═══════════════════════════════════════════════════════════════════════════
    // CORE ACCESS METHODS
    // ═══════════════════════════════════════════════════════════════════════════

    /**
     * Returns the value of the configuration property for the specified key.
     *
     * @param key Configuration property key from testConfig.properties
     * 
     * @return The value of the configuration property
     * 
     * @throws IllegalArgumentException if key is null or empty
     * @throws ConfigurationException if key not found in configuration
     */
    public static Object getVarVal(String key) {
        if (key == null || key.trim().isEmpty()) {
            throw new IllegalArgumentException("Configuration key cannot be null or empty");
        }
        return getInstance().getVar(key).value();
    }

    /**
     * Internal method to retrieve GlobalVariable for a given key.
     *
     * @param key Configuration property key
     * 
     * @return GlobalVariable for the key (never null)
     * 
     * @throws ConfigurationException if key not found
     */
    private GlobalVariable getVar(String key) {
        GlobalVariable var = globalVariables.get(key);

        if (var == null) {
            throw new ConfigurationException(
                "Configuration key '" + key + "' not found in testConfig.properties. " +
                "Verify the key exists and is spelled correctly. " +
                "Total keys loaded: " + globalVariables.size()
            );
        }
        return var;
    }

    // ═══════════════════════════════════════════════════════════════════════════
    // GENERIC HELPER METHODS - These eliminate code duplication
    // ═══════════════════════════════════════════════════════════════════════════

    /**
     * Generic configuration value getter with type safety.
     *
     * @param <T> Expected return type
     * @param key Configuration property key
     * @param type Class object for type checking
     * 
     * @return Typed configuration value
     * 
     * @throws ConfigurationException if key not found, value is null, or type mismatch
     */
    private static <T> T getConfigValue(String key, Class<T> type) {
        Object value = getVarVal(key);

        if (value == null) {
            throw new ConfigurationException(
                "Configuration key '" + key + "' has null value"
            );
        }

        if (type.isInstance(value)) {
            return type.cast(value);
        }

        throw new ConfigurationException(
            "Configuration key '" + key + "' is not a " + type.getSimpleName() +
            " (found: " + value.getClass().getSimpleName() + ")"
        );
    }

    /**
     * Gets a String configuration value with flexible type handling.
     *
     * @param key Configuration property key
     * @param allowConversion If true, converts non-String to String; if false, throws exception
     * 
     * @return String value
     * 
     * @throws ConfigurationException if value is null, not String, and conversion not allowed
     */
    private static String getStringValue(String key, boolean allowConversion) {
        Object value = getVarVal(key);

        if (value == null) {
            throw new ConfigurationException(
                "Configuration key '" + key + "' has null value"
            );
        }

        if (value instanceof String strValue) {
            return strValue;
        }

        if (allowConversion) {
            return value.toString();
        }

        throw new ConfigurationException(
            "Configuration key '" + key + "' is not a String (found: " + 
            value.getClass().getSimpleName() + ")"
        );
    }

    /**
     * Gets a numeric configuration value and converts to target type.
     *
     * @param <T> Numeric type (Integer, Long, Double, etc.)
     * @param key Configuration property key
     * @param converter Function to convert Number to target type
     * 
     * @return Converted numeric value
     * 
     * @throws ConfigurationException if value is null or not a Number
     */
    private static <T extends Number> T getNumericValue(String key, Function<Number, T> converter) {
        Object value = getVarVal(key);

        if (value == null) {
            throw new ConfigurationException(
                "Configuration key '" + key + "' has null value"
            );
        }

        if (value instanceof Number numValue) {
            return converter.apply(numValue);
        }

        throw new ConfigurationException(
            "Configuration key '" + key + "' is not a Number (found: " +
            value.getClass().getSimpleName() + ")"
        );
    }

    // ═══════════════════════════════════════════════════════════════════════════
    // BOOLEAN HELPERS
    // ═══════════════════════════════════════════════════════════════════════════

    /**
     * Gets a boolean configuration value with a default fallback.
     * This method will NOT throw an exception for missing keys.
     *
     * @param key Property key from testConfig.properties
     * @param defaultValue Default value if key not found or invalid
     * @return Boolean value, or defaultValue if key not found
     */
    public static boolean getBooleanValue(String key, boolean defaultValue) {
        try {
            Object value = getVarVal(key);

            if (value == null) {
                return defaultValue;
            }

            if (value instanceof Boolean boolValue) {
                return boolValue;
            }

            return Boolean.parseBoolean(value.toString());

        } catch (ConfigurationException e) {
            return defaultValue;
        }
    }

    /**
     * Gets a boolean configuration value (defaults to false if not found).
     *
     * @param key Property key from testConfig.properties
     * @return Boolean value (false if not found)
     */
    public static boolean getBooleanValue(String key) {
        return getBooleanValue(key, false);
    }

    // ═══════════════════════════════════════════════════════════════════════════
    // DOMAIN-SPECIFIC GETTERS - Now simplified to one-liners
    // ═══════════════════════════════════════════════════════════════════════════

    // ---------- Version ----------
    public static double getVersion() {return getNumericValue("version", Number::doubleValue);}

    // ---------- Client, Project, Application ----------
    public static String getClientRefID() {return getConfigValue("clientRefID", String.class);}
    public static String getProjectRefID() {return getConfigValue("projectRefID", String.class);}
    public static String getApplicationRefID() {return getConfigValue("applicationRefID", String.class);}

    // ---------- Execution Configuration ----------
    public static String getParallelExecution() {return getStringValue("parallelExecution", true);}
    public static int getParallelExecutionThreads() {return getConfigValue("parallelExecutionThreads", Integer.class);}

    // ---------- User Satisfaction Assessment ----------
    public static String getUserSatisfactionAssessment() {return getStringValue("userSatisfactionAssessment", true);}

    // ---------- Screen Capture Configuration ----------
    public static String getScreenCaptureOnTestStepResults() {return getStringValue("screenCaptureOnTestStepResults", true);}
    public static String getScreenCaptureOnTestStepResultsSelection() {return getStringValue("screenCaptureOnTestStepResultsSelection", true);}

    public static String getScreenCaptureOutputPath() {return getConfigValue("screenCaptureOutputPath", String.class);}
    public static String getScreenCaptureArchivePath() {return getConfigValue("screenCaptureArchivePath", String.class);}

    // ---------- Browser Configuration ----------
    public static String getBrowser() {return getConfigValue("browser", String.class);}
    public static String getHeadless() {return getStringValue("headless", true);}

    // ---------- Browser Hardening (demo / automation pop-up suppression) ----------
    // All five getters default to TRUE if missing from testConfig.properties so that
    // existing checkouts immediately benefit from the hardening without requiring the
    // user to update their config file. To re-enable a specific behavior (e.g. for a
    // security audit run), set the corresponding key to false.
    public static boolean getBrowserSuppressLeakDetection()    {return getBooleanValue("browserSuppressLeakDetection", true);}
    public static boolean getBrowserSuppressPasswordManager()  {return getBooleanValue("browserSuppressPasswordManager", true);}
    public static boolean getBrowserSuppressAutofillPrompts()  {return getBooleanValue("browserSuppressAutofillPrompts", true);}
    public static boolean getBrowserSuppressAutomationInfobar(){return getBooleanValue("browserSuppressAutomationInfobar", true);}
    public static boolean getBrowserAcceptInsecureCerts()      {return getBooleanValue("browserAcceptInsecureCerts", true);}

    // ---------- Image Configuration ----------
    public static String getImageTrim() {return getStringValue("imageTrim", true);}
    public static int getImageTrimBackgroundThreshold() {return getConfigValue("imageTrimBackgroundThreshold", Integer.class);}
    public static String getImageConversionToJPG() {return getStringValue("imageConversionToJPG", true);}
    public static int getImageCompressionJPGQuality() {return getConfigValue("imageCompressionJPGQuality", Integer.class);}
    public static int getImageThumbnailMaxSize() {return getConfigValue("imageThumbnailMaxSize", Integer.class);}
    public static int getImageThumbnailCompressionJPGQuality() {return getConfigValue("imageThumbnailCompressionJPGQuality", Integer.class);}

    // ---------- Data Configuration ----------
    public static String getDataTestStepsFilename() {return getConfigValue("dataTestStepsFilename", String.class);}
    public static String getDataOutputPath() {return getConfigValue("dataOutputPath", String.class);}
    public static String getDataArchivePath() {return getConfigValue("dataArchivePath", String.class);}

    // ---------- Report Configuration ----------
    public static String getReportOutputPath() {return getConfigValue("reportOutputPath", String.class);}
    public static String getReportArchivePath() {return getConfigValue("reportArchivePath", String.class);}

    // ---------- Report Output Configuration ----------
    public static String getReportOutputMarkdown() {return getStringValue("reportOutputMarkdown", true);}
    public static String getReportOutputHtml() {return getStringValue("reportOutputHtml", true);}

    // ---------- Report Help Links ----------
    public static String getReportHelpLinksEnabled() {return getStringValue("reportHelpLinksEnabled", true);}
    public static String getReportHelpLinksProvider() {return getConfigValue("reportHelpLinksProvider", String.class);}

    // ---------- Report Advisor ----------
    public static String getReportAdvisorEnabled() {return getStringValue("reportAdvisorEnabled", true);}

    // ---------- GeoIP Configuration ----------
    public static String getGeoLite2ASNDatabase() {return getConfigValue("geoLite2ASNDatabase", String.class);}
    public static String getGeoLite2CityDatabase() {return getConfigValue("geoLite2CityDatabase", String.class);}

    // ---------- Google Sheet Configuration ----------
    public static String getGoogleSheetSyncToBigQuery() {return getStringValue("googleSheetSyncToBigQuery", true);}
    public static String getGoogleSheetName() {return getConfigValue("googleSheetName", String.class);}
    public static String getGoogleSheetId() {return getConfigValue("googleSheetId", String.class);}
    public static String getGoogleSheetTabNameClients() {return getConfigValue("googleSheetTabNameClients", String.class);}
    public static String getGoogleSheetTabNameProjects() {return getConfigValue("googleSheetTabNameProjects", String.class);}
    public static String getGoogleSheetTabNameApplications() {return getConfigValue("googleSheetTabNameApplications", String.class);}

    // ---------- Google Cloud Configuration ----------
    public static String getGoogleCloudProjectId() {return getConfigValue("googleCloudProjectId", String.class);}
    public static String getGoogleCloudServiceAccountJsonFile() {return getConfigValue("googleCloudServiceAccountJsonFile", String.class);}
    public static String getGoogleCloudStorageExport() {return getStringValue("googleCloudStorageExport", true);}
    public static String getGoogleCloudStorageBaseURL() {return getConfigValue("googleCloudStorageBaseURL", String.class);}
    public static String getGoogleCloudStorageBucket() {return getConfigValue("googleCloudStorageBucket", String.class);}
    public static String getGoogleCloudBigQueryExport() {return getStringValue("googleCloudBigQueryExport", true);}
    public static int getGoogleCloudBigQueryTimeout() {return getConfigValue("googleCloudBigQueryTimeout", Integer.class);}
    public static int getGoogleCloudBigQueryMaxAttempts() {return getConfigValue("googleCloudBigQueryMaxAttempts", Integer.class);}
    public static String getGoogleCloudProjectDataset() {return getConfigValue("googleCloudProjectDataset", String.class);}
    public static String getGoogleCloudProjectDatasetTableClients() {return getConfigValue("googleCloudProjectDatasetTableClients", String.class);}
    public static String getGoogleCloudProjectDatasetTableClientsSchema() {return getConfigValue("googleCloudProjectDatasetTableClientsSchema", String.class);}
    public static String getGoogleCloudProjectDatasetTableProjects() {return getConfigValue("googleCloudProjectDatasetTableProjects", String.class);}
    public static String getGoogleCloudProjectDatasetTableProjectsSchema() {return getConfigValue("googleCloudProjectDatasetTableProjectsSchema", String.class);}
    public static String getGoogleCloudProjectDatasetTableApplications() {return getConfigValue("googleCloudProjectDatasetTableApplications", String.class);}
    public static String getGoogleCloudProjectDatasetTableApplicationsSchema() {return getConfigValue("googleCloudProjectDatasetTableApplicationsSchema", String.class);}
    public static String getGoogleCloudProjectDatasetTableTestSteps() {return getConfigValue("googleCloudProjectDatasetTableTestSteps", String.class);}
    public static String getGoogleCloudProjectDatasetTableTestStepsSchema() {return getConfigValue("googleCloudProjectDatasetTableTestStepsSchema", String.class);}

    // ---------- Locator Configuration ----------
    public static int getDefaultTimeout() {return getConfigValue("defaultTimeout", Integer.class);}
    public static int getDefaultInterval() {return getConfigValue("defaultInterval", Integer.class);}

    // ---------- Locator Highlighting Configuration ----------
    public static String getLocatorHighlight() {return getStringValue("locatorHighlight", true);}
    public static String getLocatorHighlightOnLoad() {return getStringValue("locatorHighlightOnLoad", true);}
    public static String getLocatorHighlightCSS() {return getStringValue("locatorHighlightCSS", true);}
    public static String getLocatorHighlightPassCSS() {return getStringValue("locatorHighlightPassCSS", true);}
    public static String getLocatorHighlightWarnCSS() {return getStringValue("locatorHighlightWarnCSS", true);}
    public static String getLocatorHighlightWarnLowCSS() {return getStringValue("locatorHighlightWarnLowCSS", true);}
    public static String getLocatorHighlightWarnMediumCSS() {return getStringValue("locatorHighlightWarnMediumCSS", true);}
    public static String getLocatorHighlightWarnHighCSS() {return getStringValue("locatorHighlightWarnHighCSS", true);}
    public static String getLocatorHighlightWarnCriticalCSS() {return getStringValue("locatorHighlightWarnCriticalCSS", true);}
    public static String getLocatorHighlightFailCSS() {return getStringValue("locatorHighlightFailCSS", true);}

    // ---------- Framework Configuration ----------
    public static String getFrameworkDebug() {return getStringValue("frameworkDebug", true);}
}

// ═══════════════════════════════════════════════════════════════════════════
// SUPPORTING CLASSES
// ═══════════════════════════════════════════════════════════════════════════

/**
 * Represents a configuration variable with name, type, and parsed value.
 * Java 23 record provides immutability, automatic equals/hashCode/toString,
 * and pattern matching support.
 *
 * @param name The configuration key name
 * @param type The detected type (Boolean, Integer, Long, Double, LocalDate, String)
 * @param value The parsed value as an object
 */
record GlobalVariable(String name, String type, Object value) {
    /**
     * Compact constructor with validation.
     */
    public GlobalVariable {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Variable name cannot be null or blank");
        }
        if (type == null || type.isBlank()) {
            throw new IllegalArgumentException("Variable type cannot be null or blank");
        }
    }
}

/**
 * Exception thrown when a configuration key is not found or has invalid type.
 * Provides context about which key caused the error to aid debugging.
 */
class ConfigurationException extends RuntimeException {
    private final String configKey;

    /**
     * Constructs a ConfigurationException with a message.
     *
     * @param message The detail message
     */
    public ConfigurationException(String message) {
        super(message);
        this.configKey = null;
    }

    /**
     * Constructs a ConfigurationException with message and key.
     *
     * @param message The detail message
     * @param configKey The configuration key that caused the error
     */
    public ConfigurationException(String message, String configKey) {
        super(message);
        this.configKey = configKey;
    }

    /**
     * Returns the configuration key that caused this exception.
     *
     * @return The config key, or null if not specified
     */
    public String getConfigKey() {
        return configKey;
    }
}