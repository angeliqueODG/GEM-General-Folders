package framework.reporting;

// ===============================================================
// @file: FW_AllureAnnotationStepFail.java
// @filepath: src/test/java/framework/reporting/FW_AllureAnnotationStepFail.java
// @version: 1.0.0
// @updated: 2025-01-10 02:52:00 PM CST
// @author: Greg Paskal
// @company: MissionWares
//
// @description:
// Custom annotation for marking a step as failed in Allure reports.
// This annotation is used to mark test steps as failed in Allure test reports,
// enhancing the reporting capabilities of the automation framework
// by allowing explicit failure marking with descriptive messages.
//
// @methods:
// - value() - Returns the failure description for the step
//
// @dependencies:
// - java.lang.annotation.ElementType
// - java.lang.annotation.Retention
// - java.lang.annotation.RetentionPolicy
// - java.lang.annotation.Target
//
// @tags: allure, reporting, annotation, test-failure, mAi™
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
public @interface FW_AllureAnnotationStepFail {
    String value(); // Example attribute
}