package framework.reporting;

// ===============================================================
// @file: FW_AllureAnnotationStepPassWarnHigh.java
// @filepath: src/test/java/framework/reporting/FW_AllureAnnotationStepPassWarnHigh.java
// @version: 1.0.0
// @updated: 2025-01-10 02:58:00 PM CST
// @author: Greg Paskal
// @company: MissionWares
//
// @description:
// Custom annotation for marking a step as passed with a high warning 
// in Allure reports. This annotation is used to mark test steps that pass
// but have significant issues that should be addressed soon. Enhances the 
// reporting capabilities of the automation framework by allowing nuanced 
// test results with severity indicators.
//
// @methods:
// - value() - Returns the high warning description for the step
//
// @dependencies:
// - java.lang.annotation.ElementType
// - java.lang.annotation.Retention
// - java.lang.annotation.RetentionPolicy
// - java.lang.annotation.Target
//
// @tags: allure, reporting, annotation, test-warning, high-priority, mAi™
//
// @changeLog:
// Date        Author          Version  Description
// ----------  --------------  -------  --------------------------
// 2025-01-10  G. Paskal       1.0.0    Initial implementation with mAi™ header
// ===============================================================

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface FW_AllureAnnotationStepPassWarnHigh {
    String value(); // Example attribute
}