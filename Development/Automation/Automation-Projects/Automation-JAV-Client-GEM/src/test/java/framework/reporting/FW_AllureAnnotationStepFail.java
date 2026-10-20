package framework.reporting;
/**
 * @file FW_AllureAnnotationStepFail.java
 * @description Custom annotation for marking a step as failed in Allure reports.
 * 
 * This file contains the FW_AllureAnnotationStepFail annotation which is used to mark a step as failed in Allure reports.
 * It includes a single attribute to specify the step description.
 * 
 * The FW_AllureAnnotationStepFail annotation offers functionalities to:
 * - Mark a step as failed in Allure reports.
 * 
 * This annotation is designed to enhance the reporting capabilities of the automation framework by allowing steps to be marked as failed in Allure reports.
 */

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface FW_AllureAnnotationStepFail {
    String value(); // Example attribute
}