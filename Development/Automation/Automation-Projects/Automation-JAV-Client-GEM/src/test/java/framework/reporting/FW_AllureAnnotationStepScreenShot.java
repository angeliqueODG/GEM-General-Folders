package framework.reporting;
/**
 * @file FW_AllureAnnotationStepScreenShot.java
 * @description Custom annotation for adding a screenshot to a step in Allure reports.
 * 
 * This file contains the FW_AllureAnnotationStepScreenShot annotation which is used to add a screenshot to a step in Allure reports.
 * It includes a single attribute to specify the screenshot description.
 * 
 * The FW_AllureAnnotationStepScreenShot annotation offers functionalities to:
 * - Add a screenshot to a step in Allure reports.
 * 
 * This annotation is designed to enhance the reporting capabilities of the automation framework by allowing screenshots to be added to steps in Allure reports.
 */

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface FW_AllureAnnotationStepScreenShot {
    String value(); // Example attribute
}