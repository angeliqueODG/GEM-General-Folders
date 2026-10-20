package framework.reporting;
/**
 * @file FW_AllureAnnotationStepPassWarnHigh.java
 * @description Custom annotation for marking a step as passed with a high warning in Allure reports.
 * 
 * This file contains the FW_AllureAnnotationStepPassWarnHigh annotation which is used to mark a step as passed with a high warning in Allure reports.
 * It includes a single attribute to specify the step description.
 * 
 * The FW_AllureAnnotationStepPassWarnHigh annotation offers functionalities to:
 * - Mark a step as passed with a high warning in Allure reports.
 * 
 * This annotation is designed to enhance the reporting capabilities of the automation framework by allowing steps to be marked as passed with a high warning in Allure reports.
 */

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface FW_AllureAnnotationStepPassWarnHigh {
    String value(); // Example attribute
}