package framework.reporting;

// ===============================================================
// @file: FW_AllureAnnotationStepPass.java
// @filepath: src/test/java/framework/reporting/FW_AllureAnnotationStepPass.java
// @version: 1.0.0
// @updated: 2025-01-10 02:54:00 PM CST
// @author: Greg Paskal
// @company: MissionWares
//
// @description:
// Custom annotation for marking a step as passed in Allure reports.
// This annotation is used to mark test steps as passed in Allure test reports,
// enhancing the reporting capabilities of the automation framework
// by allowing explicit success marking with descriptive messages.
//
// @methods:
// - value() - Returns the success description for the step
//
// @dependencies:
// - java.lang.annotation.ElementType
// - java.lang.annotation.Retention
// - java.lang.annotation.RetentionPolicy
// - java.lang.annotation.Target
//
// @tags: allure, reporting, annotation, test-success, mAi™
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
public @interface FW_AllureAnnotationStepPass {
    String value(); // Example attribute
}