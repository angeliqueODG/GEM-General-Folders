package framework.utilities;

// ===============================================================
// @file: FW_POMReader.java
// @filepath: src/test/java/framework/utilities/FW_POMReader.java
// @version: 1.0.0
// @updated: 2025-01-10 03:32:00 PM CST
// @author: Greg Paskal
// @company: MissionWares
//
// @description:
// Provides methods for reading the Maven POM file.
// This class provides utility functions for extracting properties and
// configuration values from the project's pom.xml file. Designed to
// enable runtime access to Maven project configuration, allowing tests
// and framework components to retrieve build properties dynamically.
//
// @methods:
// - getPomProperty(String) - Retrieves property value from POM file
//
// @dependencies:
// - org.apache.maven.model.Model
// - org.apache.maven.model.io.xpp3.MavenXpp3Reader
// - java.io.FileReader
//
// @tags: maven, pom, configuration, properties, mAi™
//
// @changeLog:
// Date        Author          Version  Description
// ----------  --------------  -------  --------------------------
// 2025-01-10  G. Paskal       1.0.0    Initial implementation with mAi™ header
// ===============================================================

import org.apache.maven.model.Model;
import org.apache.maven.model.io.xpp3.MavenXpp3Reader;
import java.io.FileReader;
import java.io.IOException;
import org.codehaus.plexus.util.xml.pull.XmlPullParserException;

/**
 * This class provides methods for reading the POM file.
 */
public class FW_POMReader {

    /**
     * Retrieves the value of a specified property from the POM file.
     *
     * @param propertyName The name of the property to retrieve.
     *
     * @return The value of the specified property, or null if the property is not found.
     */
    public static String getPomProperty(String propertyName) {
        MavenXpp3Reader reader = new MavenXpp3Reader();
        try {
            Model model = reader.read(new FileReader("./pom.xml"));
            return model.getProperties().getProperty(propertyName);
        } catch (IOException | XmlPullParserException e) {
            System.err.println("Warning: Could not read pom.xml: " + e.getMessage());
            return null;
        }
    }
}