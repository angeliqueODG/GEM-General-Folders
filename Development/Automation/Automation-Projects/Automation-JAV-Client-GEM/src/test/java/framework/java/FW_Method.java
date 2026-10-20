package framework.java;
/**
 * @file FW_Method.java
 * @description Represents the details of a method within a class.
 * 
 * This file contains the FW_Method class which represents the details of a method within a class, including its reference number,
 * method name, method body, and list of parameters. It provides methods to get and set these details, as well as a method to
 * return a string representation of the FW_Method instance.
 * 
 * The FW_Method class offers functionalities to:
 * - Get and set the reference number of the method.
 * - Get and set the name of the method.
 * - Get and set the body of the method.
 * - Get and set the list of parameters of the method.
 * - Return a string representation of the FW_Method instance.
 * 
 * This class is designed to encapsulate the details of a method and provide utility methods for working with method details.
 */

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