# Automation Framework - Test Execution - Within VSCode

<!-- Navigation - Begin -->
[Home](Home.md) | [Overview](Overview.md) | [Setup](Setup.md) | [Test](Test.md) | [Diagrams](Diagrams.md) | [API Docs](../../../../../target/site/index.html)
<!-- Navigation - End -->

---

# Running Test Automation with Maven

## Running the Tests

1. Open the automation project within VSCode.
2. Right-click on the "Maven" section in the sidebar and look for a popup option labeled "Run Maven Commands".
3. Select `verify`, which is the lifecycle phase that executes the automation and generates the Allure Report.

## Launching the Allure Report

1. Open a terminal and navigate to the root directory of the project (e.g., `Automation-JAV-SwagLabs`).
2. Ensure the `allure-report` directory exists and that a Maven `verify` run has completed.
3. Type `allure open` and press `Enter`.
4. A Java instance should start, and the Allure report should open.
5. Press `Ctrl+C` to exit.

## Launching JavaDocs

1. Open a terminal and navigate to the root directory of the project (e.g., `Automation-JAV-SwagLabs`).
2. Perform a Maven `site` run to generate the JavaDocs.
3. In the terminal, type `open -a "Google Chrome" target/site/index.html` and press `Enter`.
4. A Chrome instance should launch with the JavaDocs displayed.
5. Close Chrome when finished.

## Note

Utilize the Maven `clean` option to clear out all test reporting, including historical data and JavaDocs.