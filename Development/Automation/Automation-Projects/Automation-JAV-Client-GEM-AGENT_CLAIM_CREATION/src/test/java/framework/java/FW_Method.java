package framework.java;

// ===============================================================
// @file: FW_Method.java
// @filepath: src/test/java/framework/java/FW_Method.java
// @version: 2.0.0
// @updated: 2025-01-10 12:00:00 PM CST
// @author: Greg Paskal
// @company: MissionWares
//
// @description:
// Represents the details of a method within a Java class. This class
// encapsulates method metadata including reference numbers, method names,
// method bodies, and parameter lists. Designed to work with FW_JavaFileParser
// and FW_Class to provide a complete representation of Java code structure
// for analysis and introspection purposes. Supports test framework operations
// that require detailed method information.
//
// @dependencies:
// - java.util.List
//
// @methods:
// - Constructor: Creates FW_Method with reference, name, body, and parameters
// - getReferenceNumber(): Returns method reference number
// - setReferenceNumber(int): Sets method reference number
// - getMethodName(): Returns method name
// - setMethodName(String): Sets method name
// - getMethodBody(): Returns method body content
// - setMethodBody(String): Sets method body content
// - getMethodParameters(): Returns list of method parameters
// - setMethodParameters(List): Sets list of method parameters
// - toString(): Returns string representation
//
// @tags: method-metadata, code-analysis, java-parsing, mAi™
//
// @changeLog:
// Date        Author          Version  Description
// ----------  --------------  -------  --------------------------
// 2025-01-01  G. Paskal       1.0.0    Initial implementation
// 2025-01-10  G. Paskal       2.0.0    Added mAi™ header and enhanced documentation
// ===============================================================

// Import the required Java classes
import java.util.List;

/**
 * Represents the details of a method within a class.
 */
public class FW_Method {
    private int referenceNumber;
    private String methodName;
    private String methodBody;
    private List<String> methodParameters;

    /**
     * Constructs a new FW_Method instance.
     *
     * @param referenceNumber the reference number of the method
     * @param methodName the name of the method
     * @param methodBody the body of the method
     * @param methodParameters the list of parameters of the method
     */
    public FW_Method(int referenceNumber, String methodName, String methodBody, List<String> methodParameters) {
        this.referenceNumber = referenceNumber;
        this.methodName = methodName;
        this.methodBody = methodBody;
        this.methodParameters = methodParameters;
    }

    /**
     * Returns a string representation of the FW_Method instance.
     *
     * @return a string representation of the object
     */
    @Override
    public String toString() {
        return "FW_Method{" +
                "referenceNumber=" + referenceNumber +
                ", methodName='" + methodName + '\'' +
                ", methodBody='" + methodBody + '\'' +
                ", methodParameters=" + methodParameters +
                '}';
    }

    // =================================================================================
    // ====================== Class - Getters and Setters - Begin ======================

    public int getReferenceNumber() {return referenceNumber;}
    public void setReferenceNumber(int referenceNumber) {this.referenceNumber = referenceNumber;}

    public String getMethodName() {return methodName;}
    public void setMethodName(String methodName) {this.methodName = methodName;}

    public String getMethodBody() {return methodBody;}
    public void setMethodBody(String methodBody) {this.methodBody = methodBody;}

    public List<String> getMethodParameters() {return methodParameters;}
    public void setMethodParameters(List<String> methodParameters) {this.methodParameters = methodParameters;}

    // ====================== Class - Getters and Setters - End ======================
    // ===============================================================================

}