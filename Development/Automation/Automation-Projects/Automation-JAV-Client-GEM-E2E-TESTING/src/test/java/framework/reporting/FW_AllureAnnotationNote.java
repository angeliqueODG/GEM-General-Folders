package framework.reporting;

// ===============================================================
// @file: FW_AllureAnnotationNote.java
// @filepath: src/test/java/framework/reporting/FW_AllureAnnotationNote.java
// @version: 1.0.0
// @updated: 2025-01-10 02:50:00 PM CST
// @author: Greg Paskal
// @company: MissionWares
//
// @description:
// Custom annotation for adding notes to Allure reports.
// This annotation is used to add custom notes to Allure test reports,
// enhancing the reporting capabilities of the automation framework
// by allowing descriptive notes to be attached to test methods.
//
// @methods:
// - value() - Returns the note text to be added to the report
//
// @dependencies:
// - java.lang.annotation.ElementType
// - java.lang.annotation.Retention
// - java.lang.annotation.RetentionPolicy
// - java.lang.annotation.Target
//
// @tags: allure, reporting, annotation, test-metadata, mAi™
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
public @interface FW_AllureAnnotationNote {
    String value(); // Example attribute
}