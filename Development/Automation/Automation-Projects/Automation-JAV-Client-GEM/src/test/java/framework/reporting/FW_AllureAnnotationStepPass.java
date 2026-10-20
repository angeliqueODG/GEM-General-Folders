package framework.reporting;
/**
 * @file FW_AllureAnnotationStepPass.java
 * @description Custom annotation for marking a step as passed in Allure reports.
 * 
 * This file contains the FW_AllureAnnotationStepPass annotation which is used to mark a step as passed in Allure reports.
 * It includes a single attribute to specify the step description.
 * 
 * The FW_AllureAnnotationStepPass annotation offers functionalities to:
 * - Mark a step as passed in Allure reports.
 * 
 * This annotation is designed to enhance the reporting capabilities of the automation framework by allowing steps to be marked as passed in Allure reports.
 */

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface FW_AllureAnnotationStepPass {
    String value(); // Example attribute
}