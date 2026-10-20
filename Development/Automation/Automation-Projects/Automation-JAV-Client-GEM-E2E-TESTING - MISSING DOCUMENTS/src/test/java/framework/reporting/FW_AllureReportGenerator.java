package framework.reporting;

// ===============================================================
// @file: FW_AllureReportGenerator.java
// @filepath: src/test/java/framework/reporting/FW_AllureReportGenerator.java
// @version: 1.0.0
// @updated: 2025-01-10 03:06:00 PM CST
// @author: Greg Paskal
// @company: MissionWares
//
// @description:
// Utility class for generating Allure test reports from test execution results.
// This class provides functionality to programmatically generate Allure reports
// by executing the Allure CLI command-line tool. It processes test results from
// the allure-results directory and generates HTML reports in the allure-report
// directory with automatic cleanup of previous reports.
//
// @methods:
// - main(String[]) - Entry point for standalone report generation
// - generateReport() - Generates Allure report from results directory
//
// @dependencies:
// - java.io.File
// - java.io.IOException
// - framework.utilities.FW_ConsoleColors
// - Allure CLI (external dependency)
//
// @tags: allure, reporting, test-results, html-reports, mAi™
//
// @changeLog:
// Date        Author          Version  Description
// ----------  --------------  -------  --------------------------
// 2025-01-10  G. Paskal       1.0.0    Initial implementation with mAi™ header
// ===============================================================

import java.io.File;
import java.io.IOException;

import framework.utilities.FW_ConsoleColors;

public class FW_AllureReportGenerator {
    public static void main(String[] args) {

        // Generate Allure report
        generateReport();
    }

    /**
     * Generates an Allure report from the specified results directory.
     */
    public static void generateReport() {

        System.out.println("");
        System.out.println(FW_ConsoleColors.CORAL + "- - - - - Reporting - Generate Allure Report - (Begin) - - - - -" + FW_ConsoleColors.RESET);
        System.out.println("");

        // Set the path to the Allure executable and the results directory
        String allureExecutable = "allure";
        String resultsDirectory = "./allure-results";
        String reportDirectory = "./allure-report";

        // Create a process builder to run the Allure command
        ProcessBuilder processBuilder = new ProcessBuilder(
            allureExecutable,
            "generate",
            resultsDirectory,
            "--clean",
            "-o",
            reportDirectory
        );

        // Set the working directory and redirect error stream
        processBuilder.directory(new File(System.getProperty("user.dir")));
        processBuilder.redirectErrorStream(true);

        // Start the process and wait for it to complete
        try {
            Process process = processBuilder.start();
            int exitCode = process.waitFor();
            
            if (exitCode == 0) {
                System.out.println(FW_ConsoleColors.GREEN + "✓ Allure report generation completed successfully." + FW_ConsoleColors.RESET);
            } else {
                System.err.println(FW_ConsoleColors.YELLOW + "⚠️  Allure report generation completed with non-zero exit code: " + exitCode + FW_ConsoleColors.RESET);
            }
        } catch (IOException e) {
            System.err.println(FW_ConsoleColors.RED + "ERROR: Failed to generate Allure report. Could not execute command: '" + allureExecutable + " generate " + resultsDirectory + "'. " + "Error: " + e.getMessage() + FW_ConsoleColors.RESET);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();  // Restore interrupted status
            System.err.println(FW_ConsoleColors.RED + "ERROR: Allure report generation was interrupted. " + "Error: " + e.getMessage() + FW_ConsoleColors.RESET);
        }

        System.out.println("");
        System.out.println(FW_ConsoleColors.CORAL + "- - - - - Reporting - Generate Allure Report - (End) - - - - -" + FW_ConsoleColors.RESET);
        System.out.println("");

    }
}
