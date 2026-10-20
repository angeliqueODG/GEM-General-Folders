package framework.java;

import java.util.List;

/**
 * Represents the details of a class.
 */
public class FW_Class {
    private int referenceNumber;
    private String className;
    private List<FW_Method> methods;

    public FW_Class(int referenceNumber, String className, List<FW_Method> methods) {
        this.referenceNumber = referenceNumber;
        this.className = className;
        this.methods = methods;
    }

    public int getReferenceNumber() {
        return referenceNumber;
    }

    public void setReferenceNumber(int referenceNumber) {
        this.referenceNumber = referenceNumber;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public List<FW_Method> getMethods() {
        return methods;
    }

    public void setMethods(List<FW_Method> methods) {
        this.methods = methods;
    }

    @Override
    public String toString() {
        return "FW_Class{" +
                "referenceNumber=" + referenceNumber +
                ", className='" + className + '\'' +
                ", methods=" + methods +
                '}';
    }
}