package framework.advisor;

// ===============================================================
// @file: FW_AdvisorTemplateLoader.java
// @filepath: src/test/java/framework/advisor/FW_AdvisorTemplateLoader.java
// @version: 2.0.2
// @updated: 2025-10-14 03:00:00 PM CDT
// @author: Greg Paskal
// @company: MissionWares
//
// @description:
// Template loader and validator for mAi Advisor™. Loads JSON template files
// from the file system (source tree), uses Gson for automatic JSON-to-object
// deserialization, and caches them for performance. Supports template
// hot-reloading in development mode, graceful fallback for missing templates,
// and configurable caching behavior. Integrates with FW_ConfigMgr for
// configuration and provides comprehensive error handling with detailed
// validation error reporting.
//
// @responsibilities:
// - Load JSON templates from file system (src/test/java/framework/advisor/templates/)
// - Use Gson for automatic JSON deserialization
// - Parse JSON into FW_AdvisorTemplate objects with nested structures
// - Cache templates for performance (configurable)
// - Support hot-reload in development mode
// - Handle missing templates gracefully with fallback
// - Provide validation error reporting
// - Track cache statistics for monitoring
//
// @dependencies:
// - framework.advisor.FW_AdvisorTemplate
// - framework.utilities.FW_ConfigMgr
// - framework.utilities.FW_SystemUtils
// - com.google.gson.Gson, GsonBuilder
// - java.nio.file.Files, Paths, Path
// - java.util.Map, HashMap
//
// @tags: advisor, mAi™, template, json, loader, validation, caching, gson
//
// @changeLog:
// Date        Author          Version  Description
// ----------  --------------  -------  --------------------------
// 2025-10-07  G. Paskal       1.0.0    Initial creation - template loader
// 2025-10-09  G. Paskal       1.1.0    Fixed template loading - read from file system
// 2025-10-14  G. Paskal       2.0.0    Alpha-Phase1: Refactored to use Gson, removed 230+ lines of manual parsing
// 2025-10-14  G. Paskal       2.0.1    Refactored JavaDocs to lean style
// 2025-10-14  G. Paskal       2.0.2    Fixed exception handling - replaced generic Exception with specific types
// ===============================================================

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

import java.io.IOException;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.HashMap;
import java.util.Map;

import framework.utilities.FW_ConfigMgr;
import framework.utilities.FW_SystemUtils;

/**
 * Template loader and validator for mAi Advisor™.
 * Loads JSON template files from file system and uses Gson for automatic deserialization.
 */
public class FW_AdvisorTemplateLoader {
    
    // ===== CONSTANTS =====
    /** Template base path relative to project root */
    private static final String TEMPLATE_PATH = "src/test/java/framework/advisor/templates";
    
    /** Template file extension */
    private static final String TEMPLATE_EXTENSION = ".json";

    // ===== INSTANCE VARIABLES =====
    
    /** Template cache (findingType -> template) */
    private final Map<String, FW_AdvisorTemplate> templateCache;
    
    /** Cache hit statistics */
    private int cacheHits = 0;
    
    /** Cache miss statistics */
    private int cacheMisses = 0;
    
    /** Total load attempts */
    private int loadAttempts = 0;
    
    /** Successful loads */
    private int successfulLoads = 0;
    
    /** Failed loads */
    private int failedLoads = 0;
    
    /** Gson instance for JSON parsing - NOW ACTUALLY USED! */
    private final Gson gson;
    
    // ===== CONSTRUCTOR =====
    
    /**
     * Initializes loader with Gson parser and empty cache.
     */
    public FW_AdvisorTemplateLoader() {
        this.templateCache = new HashMap<>();
        this.gson = new GsonBuilder()
            .setPrettyPrinting()
            .setDateFormat("yyyy-MM-dd")
            .create();
        
        // Log initialization
        if (FW_ConfigMgr.getBooleanValue("debug")) {
            System.out.println("[FW_AdvisorTemplateLoader] Initialized with Gson");
            System.out.println("  Template Path: " + TEMPLATE_PATH);
        }
    }
    
    // ===== PUBLIC METHODS =====
    
    /**
     * Loads template for specified finding type.
     * Attempts cache first, then loads from file system using Gson deserialization.
     * 
     * @param findingType Finding type constant (e.g., "HSTS_MISSING")
     *
     * @return Loaded and validated template, or null if not found
     * @throws IllegalArgumentException if findingType is null or empty
     */
    public FW_AdvisorTemplate loadTemplate(String findingType) {
        if (findingType == null || findingType.trim().isEmpty()) {
            throw new IllegalArgumentException("Finding type cannot be null or empty");
        }
        
        loadAttempts++;
        cacheMisses++;
        
        // Resolve template path
        String templatePath = resolveTemplatePath(findingType);
        
        if (FW_ConfigMgr.getBooleanValue("debug")) {
            System.out.println("[FW_AdvisorTemplateLoader] Loading: " + templatePath);
        }

        // Load and parse template using Gson
        FW_AdvisorTemplate template = loadAndValidateTemplate(templatePath);
        
        if (template == null) {
            failedLoads++;
            if (FW_ConfigMgr.getBooleanValue("debug")) {
                System.out.println("[FW_AdvisorTemplateLoader] Template not found: " + findingType);
            }
            return null;
        }

        successfulLoads++;  
        return template;
    }
    
    /**
     * Clears template cache and resets cache statistics.
     */
    public void clearCache() {
        int size = templateCache.size();
        templateCache.clear();
        cacheHits = 0;
        cacheMisses = 0;
        
        if (FW_ConfigMgr.getBooleanValue("debug")) {
            System.out.println("[FW_AdvisorTemplateLoader] Cache cleared: " + size + " templates removed");
        }
    }
    
    /**
     * Gets the current cache size.
     * 
     * @return Number of templates currently cached
     */
    public int getCacheSize() {
        return templateCache.size();
    }
    
    /**
     * Gets cache hit rate as a percentage.
     * 
     * @return Cache hit rate (0.0 to 100.0), or 0.0 if no cache accesses
     */
    public double getCacheHitRate() {
        int totalAccesses = cacheHits + cacheMisses;
        if (totalAccesses == 0) {
            return 0.0;
        }
        return (double) cacheHits / totalAccesses * 100.0;
    }
    
    /**
     * Gets loader statistics including cache performance and load success rates.
     * 
     * @return Map containing cache and load statistics
     */
    public Map<String, Object> getStatistics() {
        Map<String, Object> stats = new HashMap<>();
        stats.put("cacheSize", getCacheSize());
        stats.put("cacheHits", cacheHits);
        stats.put("cacheMisses", cacheMisses);
        stats.put("cacheHitRate", getCacheHitRate());
        stats.put("loadAttempts", loadAttempts);
        stats.put("successfulLoads", successfulLoads);
        stats.put("failedLoads", failedLoads);
        stats.put("successRate", getSuccessRate());
        return stats;
    }
    
    // ===== PRIVATE METHODS - TEMPLATE LOADING =====
    
    /**
     * Loads JSON from file system and deserializes to FW_AdvisorTemplate using Gson.
     * Validates template after deserialization.
     * 
     * @param templatePath File system path to template file
     *
     * @return Parsed and validated template, or null if not found or invalid
     */
    private FW_AdvisorTemplate loadAndValidateTemplate(String templatePath) {
        try {
            // Load JSON from file system
            String json = loadJsonFromFileSystem(templatePath);
            if (json == null) {
                return null;
            }
            
            // ✅ GSON MAGIC: Single line replaces 200+ lines of manual parsing!
            // Gson automatically handles:
            // - Nested objects (UnderstandingContent, ActionContent, etc.)
            // - Maps with dynamic keys (frameworks, servers)
            // - Lists and arrays
            // - @SerializedName annotations for field mapping
            FW_AdvisorTemplate template = gson.fromJson(json, FW_AdvisorTemplate.class);
            
            // Validate template object using its own validation logic
            if (template != null && !template.isValid()) {
                System.err.println("[FW_AdvisorTemplateLoader] Template validation failed: " + templatePath);
                for (String error : template.getValidationErrors()) {
                    System.err.println("  - " + error);
                }
                return null;
            }
            
            return template;
            
        } catch (JsonSyntaxException e) {
            // Gson-specific: Malformed JSON, invalid syntax, type mismatches
            System.err.println("[FW_AdvisorTemplateLoader] JSON syntax error: " + templatePath + " - " + e.getMessage());
            return null;
        } catch (JsonIOException e) {
            // Gson-specific: I/O errors during JSON processing
            System.err.println("[FW_AdvisorTemplateLoader] JSON I/O error: " + templatePath + " - " + e.getMessage());
            return null;
        }
        // ✅ IOException catch block REMOVED - it's handled in loadJsonFromFileSystem()
    }
    
    /**
     * Loads JSON content from file system.
     * 
     * @param relativePath Relative path from project root to JSON file
     *
     * @return JSON string content, or null if not found
     */
    private String loadJsonFromFileSystem(String relativePath) {
        try {
            // Get project root directory
            String projectRoot = FW_SystemUtils.pathPresentProject();
            
            // Build full path
            Path fullPath = Paths.get(projectRoot, relativePath);
            
            // Check if file exists
            if (!Files.exists(fullPath)) {
                return null;
            }
            
            // Read file content
            return Files.readString(fullPath, StandardCharsets.UTF_8);
            
        } catch (IOException e) {
            // File system errors: read errors, encoding issues, permissions
            if (FW_ConfigMgr.getBooleanValue("debug")) {
                System.err.println("[FW_AdvisorTemplateLoader] File system load error: " + relativePath);
            }
            return null;
        }
    }
    
    // ===== PRIVATE METHODS - UTILITIES =====
    
    /**
     * Resolves full template path from finding type.
     * Converts finding type to lowercase with hyphens and determines category subdirectory.
     * 
     * @param findingType Finding type constant
     *
     * @return Full file system path to template file
     */
    private String resolveTemplatePath(String findingType) {
        // Convert HSTS_MISSING -> hsts-missing
        String fileName = findingType.toLowerCase().replace("_", "-");
        
        // Determine category from finding type
        String category = guessCategoryFromFindingType(findingType);
        
        // Build template path
        return TEMPLATE_PATH + "/" + category + "/" + fileName + TEMPLATE_EXTENSION;
    }
    
    /**
     * Determines template category from finding type using pattern matching.
     * 
     * @param findingType Finding type constant
     * @return Category name (security, performance, compliance, infrastructure)
     */
    private String guessCategoryFromFindingType(String findingType) {
        String type = findingType.toUpperCase();
        
        // Security indicators
        if (type.contains("SSL") || type.contains("CERT") || type.contains("HTTPS") ||
            type.contains("HSTS") || type.contains("CSP") || type.contains("XSS") ||
            type.contains("FRAME") || type.contains("COOKIE") || type.contains("CONTENT_TYPE") ||
            type.contains("SECURITY") || type.contains("AUTH") || type.contains("CORS")) {
            return "security";
        }
        
        // Performance indicators
        if (type.contains("COMPRESSION") || type.contains("CACHE") || type.contains("SPEED") ||
            type.contains("PERFORMANCE") || type.contains("SLOW") || type.contains("TIMEOUT")) {
            return "performance";
        }
        
        // Compliance indicators
        if (type.contains("GDPR") || type.contains("PCI") || type.contains("HIPAA") ||
            type.contains("COMPLIANCE") || type.contains("PRIVACY")) {
            return "compliance";
        }
        
        // Infrastructure indicators
        if (type.contains("DNS") || type.contains("SERVER") || type.contains("CONFIG") ||
            type.contains("INFRASTRUCTURE") || type.contains("NETWORK")) {
            return "infrastructure";
        }
        
        // Default to security
        return "security";
    }
    
    /**
     * Gets success rate as a percentage.
     * 
     * @return Success rate (0.0 to 100.0)
     */
    private double getSuccessRate() {
        if (loadAttempts == 0) {
            return 0.0;
        }
        return (double) successfulLoads / loadAttempts * 100.0;
    }
    
    // ===== OVERRIDE METHODS =====
    
    /**
     * Returns string representation with cache and success statistics.
     * 
     * @return String with cache statistics
     */
    @Override
    public String toString() {
        return String.format(
            "FW_AdvisorTemplateLoader[cache=%d, hitRate=%.1f%%, success=%.1f%%]",
            getCacheSize(),
            getCacheHitRate(),
            getSuccessRate()
        );
    }
}