package framework.utilities;

// ===============================================================
// @file: FW_ReportUtils.java
// @filepath: src/test/java/framework/utilities/FW_ReportUtils.java
// @version: 1.5.1
// @updated: 2025-11-07 02:50:00 PM CDT
// @author: Greg Paskal
// @company: MissionWares
//
// @description:
// Provides utility methods related to reporting with comprehensive HTTP audit support.
// This class provides utility functions for test reporting purposes including
// screenshot attachment to Allure reports, note recording, test step state
// determination based on execution time, console message printing, test
// run metrics display, and enhanced HTTP audit report generation with comprehensive
// metrics, grades, finding counts, and detailed analysis. Integrates with Allure
// reporting framework for enhanced test result visualization and markdown report
// management with full audit data support.
//
// @methods:
// - recordScreenshotToAllure(FW_Image) - Attaches screenshot to Allure report
// - recordNoteToAllure(String) - Records note with yellow status in Allure
// - getTestStepState(long, long, int, int) - Determines pass/warn/fail state
// - printMessage(String) - Prints message to console
// - printTestRunMetrics() - Displays all tracked test metrics
// - generateHttpAuditReport(FW_Http, FW_TestStep, FW_ReportConfig) - Generates comprehensive markdown report with config
// - generateReportFilename(FW_Http, FW_ReportConfig) - Generates standardized filename
// - generateReportSuffix(FW_AdvisorAudience, ReportDepth) - Generates human-readable suffix
// - formatAudienceName(String) - Formats audience enum to human-readable form
// - formatDepthName(String) - Formats depth enum to human-readable form
// - extractDomain(String) - Extracts clean domain from URL (preserves www, uses dashes)
// - printAuditSummary(FW_Http) - Prints audit summary to console
// - archiveReport(String, String) - Archives report file
// - validateAuditData(FW_Http) - Validates audit data completeness
//
// @dependencies:
// - framework.reporting.FW_AllureAnnotationNote
// - framework.reporting.FW_AllureAnnotationStepScreenShot
// - framework.reporting.FW_HttpReporter (deprecated - for backward compatibility)
// - framework.reporting.FW_ReportGenerator (new - topic-based architecture)
// - framework.reporting.FW_ReportContext (new)
// - framework.reporting.FW_TopicRegistry (new)
// - framework.reporting.topics.* (8 topic implementations)
// - framework.reporting.FW_ReportConfig
// - framework.advisor.FW_AdvisorAudience
// - framework.http.FW_Http
// - framework.junit.FW_TestRunTracker
// - framework.junit.FW_TestStep
// - framework.image.FW_Image
// - framework.utilities.FW_ConsoleColors
// - framework.utilities.FW_ConfigMgr
// - framework.utilities.FW_DateTimeUtils
// - framework.utilities.FW_FileDirUtils
// - io.qameta.allure.Allure
// - io.qameta.allure.model.Status
// - java.io.IOException
// - java.nio.file.*
//
// @tags: reporting, allure, screenshots, metrics, test-results, audit, mAi™
//
// @changeLog:
// Date        Author          Version  Description
// ----------  --------------  -------  --------------------------
// 2025-01-10  G. Paskal       1.0.0    Initial implementation with mAi™ header
// 2025-09-29  G. Paskal       1.1.0    Added HTTP audit report generation and archiving
// 2025-09-29  G. Paskal       1.1.1    Fixed hostname handling and timestamp usage
// 2025-10-06  G. Paskal       1.2.0    Enhanced with comprehensive audit data support
// 2025-11-05  G. Paskal       1.3.0    Priority 9: Multi-report generation with FW_ReportConfig
// 2025-11-05  G. Paskal       1.4.0    Priority 9: SUMMARY depth rename, new filename format
// 2025-11-06  G. Paskal       1.4.1    BUG FIX: Added setReportFilename() call to display filename at report top
// 2025-11-07  G. Paskal       1.5.0    TASK 11: Migrated to topic-based architecture - replaced FW_HttpReporter with FW_ReportGenerator
// 2025-11-07  G. Paskal       1.5.1    BUG FIX: Added convertDepth() to bridge OLD/NEW ReportDepth enums
// ===============================================================

// Automation framework
import framework.reporting.FW_AllureAnnotationNote;
import framework.reporting.FW_AllureAnnotationStepScreenShot;
import framework.reporting.FW_HttpReporter;
import framework.reporting.ReportDepth;
import framework.reporting.FW_ReportConfig;
import framework.reporting.FW_ReportGenerator;
import framework.reporting.FW_ReportContext;
import framework.reporting.FW_TopicRegistry;
import framework.reporting.topics.HttpCertificateTopic;
import framework.reporting.topics.HttpSecurityHeadersTopic;
import framework.reporting.topics.HttpPerformanceTopic;
import framework.reporting.topics.HttpDnsNetworkTopic;
import framework.reporting.topics.HttpContentTopic;
import framework.reporting.topics.HttpRedirectTopic;
import framework.reporting.topics.HttpCookieTopic;
import framework.reporting.topics.HttpCorsTopic;
import framework.advisor.FW_AdvisorAudience;
import framework.junit.FW_TestRunTracker;
import framework.image.FW_Image;
import framework.http.FW_Http;
import framework.junit.FW_TestStep;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

// Automation Reporting
import io.qameta.allure.Allure;
import io.qameta.allure.model.Status;

/**
 * This class provides utility methods related to reporting with comprehensive audit support.
 */
public class FW_ReportUtils {

    /**
     * Converts OLD ReportDepth enum (from FW_HttpReporter) to NEW standalone ReportDepth enum.
     * This bridging method maintains backward compatibility during migration.
     * 
     * @param oldDepth The OLD ReportDepth from FW_HttpReporter
     * @return The NEW standalone ReportDepth
     */
    private static ReportDepth convertDepth(FW_HttpReporter.ReportDepth oldDepth) {
        switch (oldDepth) {
            case SUMMARY:
                return ReportDepth.SUMMARY;
            case STANDARD:
                return ReportDepth.STANDARD;
            case TECHNICAL:
                return ReportDepth.TECHNICAL;
            case COMPREHENSIVE:
                return ReportDepth.COMPREHENSIVE;
            default:
                return ReportDepth.STANDARD; // Safe default
        }
    }

    /**
     * Attach screenshot to the Allure report and return the screenshot image object.
     * 
     * @param screenshotImageObj The screenshot image object
     * 
     * @return The screenshot image object
     * 
     */
    @FW_AllureAnnotationStepScreenShot("Screenshot: {0}")
    public static FW_Image recordScreenshotToAllure(FW_Image screenshotImageObj) {

        String fileName = screenshotImageObj.getImageName() + "." + screenshotImageObj.getImageType();
        String filePath = screenshotImageObj.getImageStoredFilepath() + fileName;
        String imageType = screenshotImageObj.getImageType();

        // Set screenshot context for the Allure reporting
        Allure.step("Screenshot: " + fileName, () -> {

            // Attach the screenshot to the Allure report
            try {
                if (imageType.toLowerCase().contains("jpg")) {
                    Allure.addAttachment("Screenshot: " + fileName, "image/jpg", Files.newInputStream(Paths.get(filePath)), ".jpg");
                } else {
                    Allure.addAttachment("Screenshot: " + fileName, "image/png", Files.newInputStream(Paths.get(filePath)), ".png");
                }
            } catch (IOException e) {
                // Log failure as Allure step - visible in report
                Allure.step("⚠️ Failed to attach screenshot: " + e.getMessage());
            }
        });

        return screenshotImageObj;
    }

    /**
     * Record note.
     *
     * @param note The note to record
     */
    @FW_AllureAnnotationNote("Note: {0}")
    public static void recordNoteToAllure(String note) {
        // Line removed - note is already a String
        System.out.println(FW_ConsoleColors.YELLOW + "[Note] - " + note + FW_ConsoleColors.RESET);
        // Attach the note to the Allure report (only if running in JUnit context)
        if (FW_TestRunTracker.getInstance() != null) {
            Allure.step("Note: " + note, Status.BROKEN); // BROKEN status is used for notes in Allure as it represents the color yellow.
        }
    }

    /**
     * Derive the test step state based on the time taken to execute the test step.
     *
     * @param startingTime The time when the test step started
     * @param actualTime The actual time at the moment of the test step state determination
     * @param timeout The timeout for the test step to complete
     * @param timeoutWarnThreshold The threshold percentage of the timeout to consider the test step as a warning
     * 
     * @return The determined result of [Pass], [Pass Warn], or [Fail]
     */
    public static String getTestStepState(long startingTime, long actualTime, int timeout, int timeoutWarnThreshold) {
        long timeTaken = actualTime - startingTime;
        if (timeTaken <= timeout) {
            if (timeTaken <= timeout * timeoutWarnThreshold / 100.0) {
                return "[Pass]";
            } else {
                return "[Pass Warn]";
            }
        } else {
            return "[Fail]";
        }
    }

    /**
     * Prints a message to the console.
     *
     * @param message The message to print
     */
    public static void printMessage(String message) {
        System.out.println(message);
    }

    /**
     * Prints all the metrics tracked by FW_TestRunTracker.
     */
    public static void printTestRunMetrics() {
        FW_TestRunTracker tracker = FW_TestRunTracker.getInstance();
        tracker.printMetrics();
    }

    /**
     * Validates that audit data has been properly populated in the FW_Http object.
     * 
     * @param httpResultObj The FW_Http object to validate
     * @return true if audit data is complete, false otherwise
     */
    public static boolean validateAuditData(FW_Http httpResultObj) {
        if (httpResultObj == null) {
            System.err.println(FW_ConsoleColors.RED + "[Error] FW_Http object is null" + FW_ConsoleColors.RESET);
            return false;
        }
        
        boolean isValid = true;
        
        // Check if audit scores have been populated
        if (httpResultObj.getOverallScore() < 0) {
            System.out.println(FW_ConsoleColors.YELLOW + "[Warning] Overall score not populated" + FW_ConsoleColors.RESET);
            isValid = false;
        }
        
        if (httpResultObj.getSecurityScore() < 0) {
            System.out.println(FW_ConsoleColors.YELLOW + "[Warning] Security score not populated" + FW_ConsoleColors.RESET);
            isValid = false;
        }
        
        if (httpResultObj.getComplianceScore() < 0) {
            System.out.println(FW_ConsoleColors.YELLOW + "[Warning] Compliance score not populated" + FW_ConsoleColors.RESET);
            isValid = false;
        }
        
        // Check if grades have been assigned
        if (httpResultObj.getOverallGrade() == null || httpResultObj.getOverallGrade().isEmpty()) {
            System.out.println(FW_ConsoleColors.YELLOW + "[Warning] Overall grade not assigned" + FW_ConsoleColors.RESET);
            isValid = false;
        }
        
        return isValid;
    }

    /**
     * Prints a comprehensive audit summary to the console.
     * 
     * @param httpResultObj The FW_Http object containing audit results
     */
    public static void printAuditSummary(FW_Http httpResultObj) {
        if (httpResultObj == null) {
            System.err.println(FW_ConsoleColors.RED + "[Error] Cannot print audit summary - FW_Http object is null" + FW_ConsoleColors.RESET);
            return;
        }
        
        System.out.println("\n" + FW_ConsoleColors.CORAL + "╔══════════════════════════════════════════════════════════════════════════════╗" + FW_ConsoleColors.RESET);
        System.out.println(FW_ConsoleColors.CORAL + "║                        HTTP AUDIT SUMMARY                                     ║" + FW_ConsoleColors.RESET);
        System.out.println(FW_ConsoleColors.CORAL + "╚══════════════════════════════════════════════════════════════════════════════╝" + FW_ConsoleColors.RESET);
        
        // Overall Assessment
        System.out.println("\n" + FW_ConsoleColors.BLUE + "OVERALL ASSESSMENT:" + FW_ConsoleColors.RESET);
        System.out.println("  Score: " + FW_ConsoleColors.CORAL + httpResultObj.getOverallScore() + "/100" + FW_ConsoleColors.RESET);
        System.out.println("  Grade: " + FW_ConsoleColors.CORAL + httpResultObj.getOverallGrade() + FW_ConsoleColors.RESET);
        
        // Security Assessment
        System.out.println("\n" + FW_ConsoleColors.BLUE + "SECURITY ASSESSMENT:" + FW_ConsoleColors.RESET);
        System.out.println("  Score: " + FW_ConsoleColors.CORAL + httpResultObj.getSecurityScore() + "/100" + FW_ConsoleColors.RESET);
        System.out.println("  Grade: " + FW_ConsoleColors.CORAL + httpResultObj.getSecurityGrade() + FW_ConsoleColors.RESET);
        
        // Compliance Assessment
        System.out.println("\n" + FW_ConsoleColors.BLUE + "COMPLIANCE ASSESSMENT:" + FW_ConsoleColors.RESET);
        System.out.println("  Score: " + FW_ConsoleColors.CORAL + httpResultObj.getComplianceScore() + "/100" + FW_ConsoleColors.RESET);
        System.out.println("  Grade: " + FW_ConsoleColors.CORAL + httpResultObj.getComplianceGrade() + FW_ConsoleColors.RESET);
        
        // Performance Assessment
        System.out.println("\n" + FW_ConsoleColors.BLUE + "PERFORMANCE ASSESSMENT:" + FW_ConsoleColors.RESET);
        System.out.println("  Score: " + FW_ConsoleColors.CORAL + httpResultObj.getPerformanceScore() + "/100" + FW_ConsoleColors.RESET);
        System.out.println("  Grade: " + FW_ConsoleColors.CORAL + httpResultObj.getPerformanceGrade() + FW_ConsoleColors.RESET);
        
        // Finding Counts
        int totalFindings = httpResultObj.getCriticalFindingsCount() + 
                           httpResultObj.getHighFindingsCount() + 
                           httpResultObj.getMediumFindingsCount() + 
                           httpResultObj.getLowFindingsCount();
        
        if (totalFindings > 0) {
            System.out.println("\n" + FW_ConsoleColors.BLUE + "FINDINGS BY SEVERITY:" + FW_ConsoleColors.RESET);
            if (httpResultObj.getCriticalFindingsCount() > 0) {
                System.out.println("  " + FW_ConsoleColors.RED + "Critical: " + httpResultObj.getCriticalFindingsCount() + FW_ConsoleColors.RESET);
            }
            if (httpResultObj.getHighFindingsCount() > 0) {
                System.out.println("  " + FW_ConsoleColors.YELLOW + "High: " + httpResultObj.getHighFindingsCount() + FW_ConsoleColors.RESET);
            }
            if (httpResultObj.getMediumFindingsCount() > 0) {
                System.out.println("  " + FW_ConsoleColors.BLUE + "Medium: " + httpResultObj.getMediumFindingsCount() + FW_ConsoleColors.RESET);
            }
            if (httpResultObj.getLowFindingsCount() > 0) {
                System.out.println("  " + FW_ConsoleColors.GREEN + "Low: " + httpResultObj.getLowFindingsCount() + FW_ConsoleColors.RESET);
            }
            if (httpResultObj.getInfoFindingsCount() > 0) {
                System.out.println("  " + FW_ConsoleColors.CORAL + "Info: " + httpResultObj.getInfoFindingsCount() + FW_ConsoleColors.RESET);
            }
        }
        
        // Vulnerabilities
        if (httpResultObj.hasVulnerabilities() && httpResultObj.getVulnerabilityDetails() != null) {
            System.out.println("\n" + FW_ConsoleColors.RED + "VULNERABILITIES DETECTED:" + FW_ConsoleColors.RESET);
            String[] vulns = httpResultObj.getVulnerabilityDetails().split(";");
            for (String vuln : vulns) {
                System.out.println("  • " + vuln.trim());
            }
        }
        
        // Audit Summary
        if (httpResultObj.getAuditSummary() != null && !httpResultObj.getAuditSummary().isEmpty()) {
            System.out.println("\n" + FW_ConsoleColors.BLUE + "AUDIT SUMMARY:" + FW_ConsoleColors.RESET);
            String[] summaryLines = httpResultObj.getAuditSummary().split("\n");
            for (String line : summaryLines) {
                System.out.println("  " + line);
            }
        }
        
        System.out.println("\n" + FW_ConsoleColors.CORAL + "════════════════════════════════════════════════════════════════════════════════\n" + FW_ConsoleColors.RESET);
    }

    /**
     * Generates a comprehensive HTTP audit markdown report and saves it to the configured output directory.
     * Includes all audit scores, grades, finding counts, and detailed analysis.
     * Uses FW_ReportConfig to determine report depth and target audience for customized output.
     * 
     * @param httpResultObj The FW_Http object containing HTTP transaction details and audit results
     * @param testStepObj The FW_TestStep object containing test step information
     * @param config FW_ReportConfig object specifying report depth and target audience
     * @return The full path to the generated report file, or null if generation failed
     * 
     * @example
     * FW_ReportConfig config = FW_ReportConfig.create()
     *     .audience(FW_AdvisorAudience.DEVELOPER)
     *     .depth(ReportDepth.STANDARD);
     * String reportPath = generateHttpAuditReport(httpObj, testStepObj, config);
     */
    public static String generateHttpAuditReport(FW_Http httpResultObj, FW_TestStep testStepObj, FW_ReportConfig config) {
        
        try {
            // Validate input
            if (httpResultObj == null) {
                System.err.println(FW_ConsoleColors.RED + "[Error] Cannot generate report - FW_Http object is null" + FW_ConsoleColors.RESET);
                return null;
            }
            
            // Validate audit data completeness
            boolean hasAuditData = validateAuditData(httpResultObj);
            if (!hasAuditData) {
                System.out.println(FW_ConsoleColors.YELLOW + "[Warning] Audit data may be incomplete - generating report anyway" + FW_ConsoleColors.RESET);
            }
            
            // Get report configuration
            String reportOutputPath = FW_ConfigMgr.getReportOutputPath();
            if (reportOutputPath == null || reportOutputPath.isEmpty()) {
                System.err.println(FW_ConsoleColors.RED + "[Error] reportOutputPath not configured in testConfig.properties" + FW_ConsoleColors.RESET);
                return null;
            }
            
            // Ensure report directory exists
            if (!FW_FileDirUtils.createDirectory(reportOutputPath)) {
                System.err.println(FW_ConsoleColors.RED + "[Error] Could not create report directory: " + reportOutputPath + FW_ConsoleColors.RESET);
                return null;
            }
            
            // Generate filename using new convention (Priority 9)
            String reportFilename = generateReportFilename(httpResultObj, config);
            String reportFullPath = reportOutputPath + "/" + reportFilename;
            
            System.out.println(FW_ConsoleColors.BLUE + "\n[Report] Generating comprehensive HTTP audit report..." + FW_ConsoleColors.RESET);
            System.out.println("  Target: " + httpResultObj.getRequestUrl());
            System.out.println("  Config: " + config.toString());
            System.out.println("  Output: " + reportFullPath);

            // ========== NEW ARCHITECTURE: Topic-Based Reporting (Task 11) ==========
            // Create topic registry with all 8 topics
            FW_TopicRegistry<FW_Http> registry = new FW_TopicRegistry<>();
            registry.register(new HttpCertificateTopic());
            registry.register(new HttpSecurityHeadersTopic());
            registry.register(new HttpPerformanceTopic());
            registry.register(new HttpDnsNetworkTopic());
            registry.register(new HttpContentTopic());
            registry.register(new HttpRedirectTopic());
            registry.register(new HttpCookieTopic());
            registry.register(new HttpCorsTopic());
            
            // Create report generator
            FW_ReportGenerator<FW_Http> generator = new FW_ReportGenerator<>(registry);
            
            // Create report context (replaces individual setter calls)
            FW_ReportContext context = FW_ReportContext.builder()
                .withDepth(convertDepth(config.getDepth()))  // Convert OLD enum to NEW enum
                .withAudience(config.getAudience())
                .withFilename(reportFilename)
                .build();

            // Generate the report content using NEW topic-based system
            String reportContent = generator.generateReport(httpResultObj, context);
            
            // Add comprehensive test step information if available
            if (testStepObj != null) {
                StringBuilder enhancedReport = new StringBuilder(reportContent);
                enhancedReport.append("\n\n---\n\n");
                enhancedReport.append("## Test Execution Context\n\n");
                enhancedReport.append("| Property | Value |\n");
                enhancedReport.append("|----------|-------|\n");
                
                if (testStepObj.getTestSuiteName() != null) {
                    enhancedReport.append("| Test Suite | `").append(testStepObj.getTestSuiteName()).append("` |\n");
                }
                if (testStepObj.getTestCaseName() != null) {
                    enhancedReport.append("| Test Case | `").append(testStepObj.getTestCaseName()).append("` |\n");
                }
                if (testStepObj.getTestStepRefID() != null) {
                    enhancedReport.append("| Test Step | `").append(testStepObj.getTestStepRefID()).append("` |\n");
                }
                if (testStepObj.getTestStepTimestamp() != null) {
                    enhancedReport.append("| Execution Time | ").append(testStepObj.getTestStepTimestamp()).append(" |\n");
                }
                if (testStepObj.getTestStepDurationMS() > 0) {
                    enhancedReport.append("| Duration | ").append(testStepObj.getTestStepDurationMS()).append("ms |\n");
                }
                
                reportContent = enhancedReport.toString();
            }
            
            // Write report to file using new generator
            generator.writeReportToFile(reportContent, reportFullPath);
            
            // Print audit summary to console
            System.out.println(FW_ConsoleColors.BLUE + "\n[Report] Audit Metrics Summary:" + FW_ConsoleColors.RESET);

            System.out.println("  Overall Score: " + FW_ConsoleColors.CORAL + httpResultObj.getOverallScore() + "/100 (" + httpResultObj.getOverallGrade() + ")" + FW_ConsoleColors.RESET);
            System.out.println("  Security Score: " + FW_ConsoleColors.CORAL + httpResultObj.getSecurityScore() + "/100 (" + httpResultObj.getSecurityGrade() + ")" + FW_ConsoleColors.RESET);
            System.out.println("  Compliance Score: " + FW_ConsoleColors.CORAL + httpResultObj.getComplianceScore() + "/100 (" + httpResultObj.getComplianceGrade() + ")" + FW_ConsoleColors.RESET);
            
            int totalFindings = httpResultObj.getCriticalFindingsCount() + 
                               httpResultObj.getHighFindingsCount() + 
                               httpResultObj.getMediumFindingsCount() + 
                               httpResultObj.getLowFindingsCount();
            
            if (totalFindings > 0) {
                System.out.println("  Total Findings: " + FW_ConsoleColors.YELLOW + totalFindings + FW_ConsoleColors.RESET + 
                                 " (Critical: " + httpResultObj.getCriticalFindingsCount() + 
                                 ", High: " + httpResultObj.getHighFindingsCount() + 
                                 ", Medium: " + httpResultObj.getMediumFindingsCount() + 
                                 ", Low: " + httpResultObj.getLowFindingsCount() + ")");
            } else {
                System.out.println("  Total Findings: " + FW_ConsoleColors.GREEN + "0" + FW_ConsoleColors.RESET);
            }
            
            System.out.println(FW_ConsoleColors.GREEN + "\n[Success] HTTP audit report generated: " + reportFullPath + FW_ConsoleColors.RESET);
            
            // Record to Allure if available
            if (FW_TestRunTracker.getInstance() != null) {
                recordNoteToAllure("HTTP Audit Report: " + reportFilename);
                recordNoteToAllure(String.format("Audit Scores - Overall: %d/100 (%s), Security: %d/100 (%s), Compliance: %d/100 (%s)",
                    httpResultObj.getOverallScore(), httpResultObj.getOverallGrade(),
                    httpResultObj.getSecurityScore(), httpResultObj.getSecurityGrade(),
                    httpResultObj.getComplianceScore(), httpResultObj.getComplianceGrade()));
                
                if (totalFindings > 0) {
                    recordNoteToAllure(String.format("Findings: %d Critical, %d High, %d Medium, %d Low",
                        httpResultObj.getCriticalFindingsCount(),
                        httpResultObj.getHighFindingsCount(),
                        httpResultObj.getMediumFindingsCount(),
                        httpResultObj.getLowFindingsCount()));
                }
            }
            
            return reportFullPath;
            
        } catch (IOException e) {
            // File I/O errors (most likely: can't create directory, can't write file)
            System.err.println(FW_ConsoleColors.RED + "[Error] Failed to write HTTP audit report: " + e.getMessage() + FW_ConsoleColors.RESET);
            return null;
        } catch (RuntimeException e) {
            // Unexpected errors (NullPointerException, IllegalArgumentException, etc.)
            System.err.println(FW_ConsoleColors.RED + "[Error] Unexpected error generating HTTP audit report: " + e.getClass().getSimpleName() + " - " + e.getMessage() + FW_ConsoleColors.RESET);
            return null;
        }
    }
    
    /**
     * Archives a report file by moving it from the output directory to the archive directory.
     * 
     * @param reportFilePath The full path to the report file to archive
     * @param archiveFilename Optional custom archive filename (null to auto-generate)
     * @return true if archiving succeeded, false otherwise
     */
    public static boolean archiveReport(String reportFilePath, String archiveFilename) {
        
        try {
            // Get configuration
            String reportOutputPath = FW_ConfigMgr.getReportOutputPath();
            String reportArchivePath = FW_ConfigMgr.getReportArchivePath();
            
            if (reportArchivePath == null || reportArchivePath.isEmpty()) {
                System.err.println(FW_ConsoleColors.RED + "[Error] reportArchivePath not configured in testConfig.properties" + FW_ConsoleColors.RESET);
                return false;
            }
            
            // Extract filename from full path
            Path path = Paths.get(reportFilePath);
            String originalFilename = path.getFileName().toString();
            
            // Generate archive filename if not provided
            if (archiveFilename == null || archiveFilename.isEmpty()) {
                String timestamp = FW_DateTimeUtils.getCurrentTimestamp();
                
                // Clean timestamp for filename
                timestamp = timestamp.replace(":", "-").replace(".", "_").replace("Z", "");
                archiveFilename = originalFilename.replace(".md", "_archived_" + timestamp + ".md");
            }
            
            // Move file to archive
            boolean result = FW_FileDirUtils.fileMove(
                reportOutputPath,
                reportArchivePath,
                originalFilename,
                archiveFilename,
                true,  // Delete source file after move
                "append"  // Append if archive file exists
            );
            
            if (result) {
                System.out.println(FW_ConsoleColors.GREEN + "[Success] Report archived: " + archiveFilename + FW_ConsoleColors.RESET);
            } else {
                System.err.println(FW_ConsoleColors.RED + "[Error] Failed to archive report" + FW_ConsoleColors.RESET);
            }
            
            return result;
            
        } catch (Exception e) {
            System.err.println(FW_ConsoleColors.RED + "[Error] Exception during report archiving: " + e.getMessage() + FW_ConsoleColors.RESET);
            return false;
        }
    }
    
    /**
     * Generates standardized report filename using Priority 9 naming convention.
     * Format: Audit_HttpReview_{domain}_{date}_{time}_{Audience-Depth}.md
     * 
     * @param httpResultObj The FW_Http object containing URL information
     * @param config The FW_ReportConfig containing depth and audience settings
     * @return Formatted filename string
     * 
     * @example
     * "Audit_HttpReview_www-saucedemo-com_2025-11-05_15-54-52_Executive-Summary.md"
     * "Audit_HttpReview_github-com_2025-11-05_15-54-52_Developer-Standard.md"
     */
    private static String generateReportFilename(FW_Http httpResultObj, FW_ReportConfig config) {
        String domain = extractDomain(httpResultObj.getRequestUrl());
        
        // Get timestamp and split into date and time components
        String timestamp = FW_DateTimeUtils.getCurrentTimestamp();
        // Remove Z and milliseconds, split into date and time
        timestamp = timestamp.replace("Z", "").split("\\.")[0]; // "2025-11-05T15:54:52"
        String[] parts = timestamp.split("T");
        String date = parts[0]; // "2025-11-05"
        String time = parts[1].replace(":", "-"); // "15-54-52"
        
        // Generate suffix based on audience and depth
        String suffix = generateReportSuffix(config.getAudience(), config.getDepth());
        
        return String.format("Audit_HttpReview_%s_%s_%s_%s.md", domain, date, time, suffix);
    }
    
    /**
     * Generates human-readable suffix for report filename based on audience and depth.
     * Special case: EXECUTIVE audience + SUMMARY depth = "Executive-Summary"
     * Default pattern: "{Audience}-{Depth}" with proper capitalization
     * 
     * @param audience The target audience enum
     * @param depth The report depth enum
     * @return Formatted suffix string
     * 
     * @example
     * EXECUTIVE + SUMMARY → "Executive-Summary"
     * DEVELOPER + STANDARD → "Developer-Standard"
     * SECURITY_ENGINEER + COMPREHENSIVE → "Security-Comprehensive"
     */
    private static String generateReportSuffix(framework.advisor.FW_AdvisorAudience audience, framework.reporting.FW_HttpReporter.ReportDepth depth) {
        // Special case: Executive Summary
        if (audience == framework.advisor.FW_AdvisorAudience.EXECUTIVE && 
            depth == framework.reporting.FW_HttpReporter.ReportDepth.SUMMARY) {
            return "Executive-Summary";
        }
        
        // Convert audience name to proper case
        String audienceName = formatAudienceName(audience.name());
        
        // Convert depth to proper case
        String depthName = formatDepthName(depth.name());
        
        return audienceName + "-" + depthName;
    }
    
    /**
     * Formats audience enum name to human-readable form.
     * 
     * @param audienceName The raw enum name (e.g., "SECURITY_ENGINEER")
     * @return Formatted name (e.g., "Security")
     */
    private static String formatAudienceName(String audienceName) {
        switch (audienceName) {
            case "SECURITY_ENGINEER":
                return "Security";
            case "OPS_INFRASTRUCTURE":
                return "Ops";
            case "QA_TESTER":
                return "QA";
            case "PROJECT_MANAGER":
                return "PM";
            case "DEVELOPER":
                return "Developer";
            case "EXECUTIVE":
                return "Executive";
            default:
                // Fallback: capitalize first letter
                return audienceName.substring(0, 1).toUpperCase() + 
                       audienceName.substring(1).toLowerCase();
        }
    }
    
    /**
     * Formats depth enum name to human-readable form.
     * 
     * @param depthName The raw enum name (e.g., "COMPREHENSIVE")
     * @return Formatted name (e.g., "Comprehensive")
     */
    private static String formatDepthName(String depthName) {
        // Simple capitalize first letter, rest lowercase
        return depthName.substring(0, 1).toUpperCase() + 
               depthName.substring(1).toLowerCase();
    }
    
    /**
     * Extracts clean domain name from URL for use in filenames.
     * Removes protocol, path, port, and query parameters.
     * Preserves subdomains (including www) and converts dots to dashes.
     * 
     * @param url The full URL string
     * @return Clean domain name safe for filenames
     * 
     * @example
     * "https://www.example.com:8080/path?query=value" → "www-example-com"
     * "http://subdomain.example.com/" → "subdomain-example-com"
     * "https://saucedemo.com/" → "saucedemo-com"
     */
    private static String extractDomain(String url) {
        if (url == null || url.isEmpty()) {
            return "unknown";
        }
        
        try {
            // Remove protocol (http:// or https://) but KEEP www
            String domain = url.replaceFirst("^https?://", "");
            
            // Remove path (everything after first /)
            domain = domain.replaceFirst("/.*$", "");
            
            // Remove port (everything after :)
            domain = domain.replaceFirst(":.*$", "");
            
            // Replace dots with dashes for filename safety
            domain = domain.replace(".", "-");
            
            // Clean any remaining invalid characters
            domain = domain.replaceAll("[^a-zA-Z0-9-]", "_");
            
            return domain.isEmpty() ? "unknown" : domain;
        } catch (Exception e) {
            return "unknown";
        }
    }
}