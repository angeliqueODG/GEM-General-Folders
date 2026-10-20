package framework.java;
/**
 * @file FW_JavaFileParser.java
 * @description A utility class for parsing Java files and extracting class and method details.
 * 
 * This file contains the FW_JavaFileParser class which provides methods to parse Java files and extract class and method details.
 * It includes functionalities to validate file paths, parse Java files, extract class names, and extract method details such as
 * method names, parameters, and bodies.
 * 
 * The FW_JavaFileParser class offers functionalities to:
 * - Validate file paths.
 * - Parse Java files and extract class names.
 * - Extract method details including names, parameters, and bodies.
 * 
 * This class is designed to facilitate the analysis of Java files, providing detailed information about the classes and methods
 * contained within them.
 */

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