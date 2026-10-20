package framework.reporting;
/**
 * @file FW_AllureAnnotationStepPassWarnCritical.java
 * @description Custom annotation for marking a step as passed with a critical warning in Allure reports.
 * 
 * This file contains the FW_AllureAnnotationStepPassWarnCritical annotation which is used to mark a step as passed with a critical warning in Allure reports.
 * It includes a single attribute to specify the step description.
 * 
 * The FW_AllureAnnotationStepPassWarnCritical annotation offers functionalities to:
 * - Mark a step as passed with a critical warning in Allure reports.
 * 
 * This annotation is designed to enhance the reporting capabilities of the automation framework by allowing steps to be marked as passed with a critical warning in Allure reports.
 */

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface FW_AllureAnnotationStepPassWarnCritical {
    String value(); // Example attribute
}