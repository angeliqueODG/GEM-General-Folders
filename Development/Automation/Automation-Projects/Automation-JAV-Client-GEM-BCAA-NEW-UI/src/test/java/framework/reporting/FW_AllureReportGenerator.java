package framework.reporting;

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
            System.out.println(FW_ConsoleColors.GREEN + "Allure report generation completed with exit code: " + exitCode + FW_ConsoleColors.RESET);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("");
        System.out.println(FW_ConsoleColors.CORAL + "- - - - - Reporting - Generate Allure Report - (End) - - - - -" + FW_ConsoleColors.RESET);
        System.out.println("");

    }
}
