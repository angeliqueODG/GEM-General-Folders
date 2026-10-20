package framework.java;

import java.util.List;

/**
 * Represents the details of a method within a class.
 */
public class FW_Method {
    private int referenceNumber;
    private String methodName;
    private String methodBody;
    private List<String> methodParameters;

    public FW_Method(int referenceNumber, String methodName, String methodBody, List<String> methodParameters) {
        this.referenceNumber = referenceNumber;
        this.methodName = methodName;
        this.methodBody = methodBody;
        this.methodParameters = methodParameters;
    }

    public int getReferenceNumber() {
        return referenceNumber;
    }

    public void setReferenceNumber(int referenceNumber) {
        this.referenceNumber = referenceNumber;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public String getMethodBody() {
        return methodBody;
    }

    public void setMethodBody(String methodBody) {
        this.methodBody = methodBody;
    }

    public List<String> getMethodParameters() {
        return methodParameters;
    }

    public void setMethodParameters(List<String> methodParameters) {
        this.methodParameters = methodParameters;
    }

    @Override
    public String toString() {
        return "FW_Method{" +
                "referenceNumber=" + referenceNumber +
                ", methodName='" + methodName + '\'' +
                ", methodBody='" + methodBody + '\'' +
                ", methodParameters=" + methodParameters +
                '}';
    }
}