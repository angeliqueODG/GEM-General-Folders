package framework.reporting;
/**
 * @file FW_AllureAnnotationNote.java
 * @description Custom annotation for adding notes to Allure reports.
 * 
 * This file contains the FW_AllureAnnotationNote annotation which is used to add custom notes to Allure reports.
 * It includes a single attribute to specify the note value.
 * 
 * The FW_AllureAnnotationNote annotation offers functionalities to:
 * - Add custom notes to Allure reports.
 * 
 * This annotation is designed to enhance the reporting capabilities of the automation framework by allowing custom notes to be added to Allure reports.
 */

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface FW_AllureAnnotationNote {
    String value(); // Example attribute
}