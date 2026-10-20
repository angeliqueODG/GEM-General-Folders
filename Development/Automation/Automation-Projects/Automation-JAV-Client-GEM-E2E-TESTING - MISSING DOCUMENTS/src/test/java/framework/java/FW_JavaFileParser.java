package framework.java;

// ===============================================================
// @file: FW_JavaFileParser.java
// @filepath: src/test/java/framework/java/FW_JavaFileParser.java
// @version: 2.0.0
// @updated: 2025-01-10 11:55:00 AM CST
// @author: Greg Paskal
// @company: MissionWares
//
// @description:
// A utility class for parsing Java source files and extracting class and method
// details using the JavaParser library. Provides comprehensive analysis of Java
// code structure including class names, method signatures, parameters, and method
// bodies. Implements a visitor pattern to traverse the abstract syntax tree (AST)
// and collect detailed information about code elements. Designed to support test
// framework operations requiring code introspection and analysis.
//
// @dependencies:
// - com.github.javaparser.JavaParser
// - com.github.javaparser.ast.CompilationUnit
// - com.github.javaparser.ast.body.MethodDeclaration
// - com.github.javaparser.ast.visitor.VoidVisitorAdapter
// - framework.utilities.FW_DebugUtils
// - java.io.FileInputStream
//
// @methods:
// - main(String[]): Test harness for parser functionality
// - parseJavaFile(String): Parses Java file and returns FW_Class object
// - MethodVisitor.visit(): Extracts method details from AST
// - extractMethodParameters(MethodDeclaration): Gets method parameters
// - extractMethodBody(MethodDeclaration): Gets method body content
//
// @tags: java-parser, ast, code-analysis, visitor-pattern, mAi™
//
// @changeLog:
// Date        Author          Version  Description
// ----------  --------------  -------  --------------------------
// 2025-01-01  G. Paskal       1.0.0    Initial implementation
// 2025-01-10  G. Paskal       2.0.0    Added mAi™ header and enhanced documentation
// ===============================================================

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ParseProblemException;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

import framework.utilities.FW_DebugUtils;

/**
 * A utility class for parsing Java files and extracting class and method details.
 */
public class FW_JavaFileParser {

    private static int classCounter = 1;
    private static int methodCounter = 1;

    /**
     * The main method for testing the parser.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {

        // Used for testing the parser
        String filePath = "src/test/java/testsuites/TS_SwagLabs_JUnit.java"; // Path to your Java file

        // Parse the Java file and print the extracted class and method details
        FW_Class parsedClass = parseJavaFile(filePath);

        if (parsedClass != null) {
            FW_DebugUtils.printObjectDetails(parsedClass); // Call debugging utility to print the parsed class details
        } else {
            System.out.println("Failed to parse the Java file.");
        }
    }

    /**
     * Parses a Java file and extracts the class and method details.
     *
     * @param filePath The path to the Java file to parse.
     * 
     * @return An FW_Class object containing the parsed class and method details, or null if parsing fails.
     */
    public static FW_Class parseJavaFile(String filePath) {

        // Validate the file path
        if (filePath == null || filePath.isEmpty()) {
            throw new IllegalArgumentException("File path cannot be null or empty.");
        }

        // Parse the Java file
        try (FileInputStream fileContents = new FileInputStream(filePath)) {

            // Parse the Java file
            JavaParser parser = new JavaParser();
            CompilationUnit parsedJavaFile = parser.parse(fileContents).getResult().orElseThrow(() -> new IOException("Parsing failed"));

            // Extract class name from the parsed file
            String className = parsedJavaFile.getType(0).getNameAsString();

            // Extract method details from the parsed file
            List<FW_Method> methods = new ArrayList<>();
            parsedJavaFile.accept(new MethodVisitor(), methods);

            // Return the parsed class object
            return new FW_Class(classCounter++, className, methods);

        } catch (IOException | ParseProblemException e) {
            System.err.println("Error occurred while parsing the file: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    /**
     * A visitor class for extracting method details from a CompilationUnit.
     * This class extends VoidVisitorAdapter and visits each method declaration in the parsed Java file.
     */
    private static class MethodVisitor extends VoidVisitorAdapter<List<FW_Method>> {

        /**
         * Visits a method declaration and extracts its details.
         *
         * @param md      The method declaration to visit.
         * @param methods The list to store the extracted method details.
         */
        @Override
        public void visit(MethodDeclaration md, List<FW_Method> methods) {
            super.visit(md, methods);

            // Extract method name
            String methodName = md.getNameAsString();

            // Extract method parameters
            List<String> methodParameters = extractMethodParameters(md);

            // Extract method body
            String methodBody = extractMethodBody(md);

            // Add the extracted method details to the list
            methods.add(new FW_Method(methodCounter++, methodName, methodBody, methodParameters));
        }

        /**
         * Extracts the parameters of a method declaration.
         *
         * @param md The method declaration.
         * 
         * @return A list of parameters as strings.
         */
        private List<String> extractMethodParameters(MethodDeclaration md) {
            List<String> methodParameters = new ArrayList<>();
            md.getParameters().forEach(param -> methodParameters.add(param.toString()));
            return methodParameters;
        }

        /**
         * Extracts the body of a method declaration.
         *
         * @param md The method declaration.
         * 
         * @return The method body as a string, or an empty string if the body is not present.
         */
        private String extractMethodBody(MethodDeclaration md) {
            return md.getBody().map(Object::toString).orElse("");
        }
    }
}