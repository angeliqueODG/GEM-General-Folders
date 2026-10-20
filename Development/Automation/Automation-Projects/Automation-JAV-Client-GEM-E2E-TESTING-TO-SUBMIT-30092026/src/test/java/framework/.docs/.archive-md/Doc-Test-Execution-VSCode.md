# Automation Framework - Test Execution - Within VSCode

<!-- ===============================================================
@file: Doc-Test-Execution-VSCode.md
@filepath: src/test/java/framework/.docs/Doc-Test-Execution-VSCode.md
@version: 1.2.0
@updated: 2025-10-30 11:56:00 AM CDT
@author: Greg Paskal
@company: MissionWares

@description:
Comprehensive guide for executing automated tests within Visual Studio Code.
This document covers Maven command execution, test running strategies, report
generation with Allure, JavaDocs creation, and debugging techniques. Includes
commands for HTTP security assessment and network diagnostics tests.

@dependencies:
- Visual Studio Code
- Maven extension for VSCode
- Java Extension Pack
- Allure Report framework
- Google Chrome (for reports)

@tags: test-execution, vscode, maven, allure-report, javadocs, mAi™

@changeLog:
Date        Author          Version  Description
----------  --------------  -------  --------------------------
2025-01-01  G. Paskal       1.0.0    Initial test execution guide
2025-09-09  G. Paskal       1.1.0    Added mAi™ header and expanded content
2025-10-30  G. Paskal       1.2.0    Added HTTP and Network test commands
=============================================================== -->

<!-- Navigation - Begin -->
[Home](Home.md) | [Overview](Doc-Overview.md) | [Setup](Doc-Setup.md) | [Test](Doc-Test-Development.md) | [Diagrams](Diagrams.md) | [API Docs](../../../../../target/site/index.html)
<!-- Navigation - End -->

---

# Running Test Automation with Maven

This guide covers various methods for executing tests within VSCode and generating reports.

## VSCode Setup

### Required Extensions
- **Java Extension Pack** - Microsoft
- **Maven for Java** - Microsoft
- **Test Runner for Java** - Microsoft
- **XML** - Red Hat (for POM file support)

### Workspace Settings
Ensure your `.vscode/settings.json` includes:
```json
{
    "java.home": "/opt/homebrew/opt/openjdk/",
    "java.configuration.updateBuildConfiguration": "automatic",
    "java.debug.settings.onBuildFailureProceed": true
}
```

## Running Tests via Maven

### Method 1: Maven Sidebar

1. Open the automation project within VSCode
2. Right-click on the "Maven" section in the sidebar
3. Look for "Run Maven Commands" in the popup menu
4. Select `verify` to execute all tests and generate reports

### Method 2: Terminal Commands

Open the integrated terminal (`Terminal > New Terminal`) and run:

```bash
# Run all tests
mvn verify

# Run specific test suite
mvn test -Dtest=TS_Authentication_JUnit

# Run specific test method
mvn test -Dtest=TS_Authentication_JUnit#testValidLogin

# Run HTTP security assessment
mvn test -Dtest=TS_HttpAssessment_JUnit

# Run network diagnostics
mvn test -Dtest=TS_Network_JUnit

# Run with specific browser
mvn test -Dbrowser=chrome

# Run with custom configuration
mvn test -DconfigFile=test-staging.properties
```

### Method 3: Test Explorer

1. Open the Test Explorer sidebar (flask icon)
2. Navigate to your test classes
3. Click the play button next to:
   - Package level (run all tests in package)
   - Class level (run all tests in class)
   - Method level (run individual test)

### Method 4: Code Lens

With Java extensions installed, you'll see "Run Test" and "Debug Test" links above:
- Test classes
- Test methods

Click these to execute tests directly from the editor.

## Maven Lifecycle Phases

| Phase | Description | Command |
|-------|-------------|---------|
| `clean` | Remove previous build artifacts | `mvn clean` |
| `compile` | Compile source code | `mvn compile` |
| `test` | Run unit tests | `mvn test` |
| `verify` | Run integration tests | `mvn verify` |
| `site` | Generate project documentation | `mvn site` |

## Launching Allure Report

### Generate and Open Report

1. Open terminal to project root directory:
   ```bash
   cd ~/Documents/Development/Automation/Automation-Projects/Automation-JAV-mAi
   ```

2. Ensure test execution has completed:
   ```bash
   mvn verify
   ```

3. Generate and open Allure report:
   ```bash
   allure open
   ```

4. The report opens in your default browser
5. Press `Ctrl+C` in terminal to stop the server

### Alternative: Generate Static Report

```bash
# Generate report without server
allure generate --clean

# Open in browser manually
open allure-report/index.html
```

## Launching JavaDocs

### Generate JavaDocs

1. Navigate to project root:
   ```bash
   cd ~/Documents/Development/Automation/Automation-Projects/Automation-JAV-mAi
   ```

2. Generate JavaDocs:
   ```bash
   mvn site
   ```

3. Open in Chrome:
   ```bash
   open -a "Google Chrome" target/site/index.html
   ```

### Alternative Browsers

```bash
# Safari
open -a "Safari" target/site/index.html

# Firefox
open -a "Firefox" target/site/index.html

# Default browser
open target/site/index.html
```

## Debugging Tests

### Setting Breakpoints

1. Click in the gutter next to line numbers to set breakpoints
2. Right-click on test method and select "Debug Test"
3. Use Debug Console to inspect variables

### Debug Configuration

Create `.vscode/launch.json`:
```json
{
    "version": "0.2.0",
    "configurations": [
        {
            "type": "java",
            "name": "Debug Current Test",
            "request": "launch",
            "mainClass": "",
            "projectName": "Automation-JAV-mAi"
        }
    ]
}
```

### Remote Debugging

For Maven Surefire debugging:
```bash
mvn -Dmaven.surefire.debug test
```

Then attach debugger on port 5005.

## Test Execution Options

### Parallel Execution
```bash
# Run tests in parallel
mvn test -Djunit.jupiter.execution.parallel.enabled=true
```

### Skip Tests
```bash
# Build without running tests
mvn install -DskipTests

# Skip test compilation and execution
mvn install -Dmaven.test.skip=true
```

### Test Filtering
```bash
# Run tests with specific tags
mvn test -Dgroups="smoke"

# Exclude tests with tags
mvn test -DexcludedGroups="slow"
```

## Advanced Feature Tests

### HTTP Security Assessment

Run comprehensive HTTP security audits:
```bash
# Run HTTP assessment suite
mvn test -Dtest=TS_HttpAssessment_JUnit

# Run specific HTTP audit
mvn test -Dtest=TS_HttpAssessment_JUnit#testHttpSecurityHeaders
```

View HTTP diagnostic reports:
- Location: `target/http-reports/`
- HTML report with color-coded findings
- Includes mAi Advisor™ recommendations

### Network Diagnostics

Run network connectivity and performance tests:
```bash
# Run all network tests
mvn test -Dtest=TS_Network_JUnit

# Run ping test only
mvn test -Dtest=TS_Network_JUnit#testPing

# Run traceroute only
mvn test -Dtest=TS_Network_JUnit#testTraceroute

# Run speed test only
mvn test -Dtest=TS_Network_JUnit#testSpeedTest
```

## Cleaning Build Artifacts

### Complete Clean
```bash
# Remove all generated files
mvn clean
```

This removes:
- `target/` directory
- Test reports
- Compiled classes
- JavaDocs
- Allure results
- HTTP diagnostic reports

### Selective Clean
```bash
# Clean only Allure results
rm -rf allure-results/

# Clean only reports
rm -rf allure-report/

# Clean only JavaDocs
rm -rf target/site/

# Clean HTTP reports
rm -rf target/http-reports/
```

## Common Issues and Solutions

### Issue: Maven Commands Not Found
**Solution**: Ensure Maven is in PATH and restart VSCode

### Issue: Tests Not Discovered
**Solution**: Refresh Java projects: `Cmd+Shift+P` → "Java: Reload Projects"

### Issue: Allure Command Not Found
**Solution**: Install Allure via Homebrew: `brew install allure`

### Issue: Out of Memory Errors
**Solution**: Increase Maven memory:
```bash
export MAVEN_OPTS="-Xmx2048m -XX:MaxPermSize=512m"
```

### Issue: HTTP Reports Not Generated
**Solution**: Ensure target directory exists and tests completed successfully

## Tips and Tricks

### Quick Commands

Add to `package.json` scripts or create shell aliases:
```bash
# ~/.zshrc or ~/.bash_profile
alias test-all="mvn clean verify"
alias test-smoke="mvn test -Dgroups=smoke"
alias test-http="mvn test -Dtest=TS_HttpAssessment_JUnit"
alias test-network="mvn test -Dtest=TS_Network_JUnit"
alias report="allure open"
alias docs="mvn site && open target/site/index.html"
```

### VSCode Tasks

Create `.vscode/tasks.json`:
```json
{
    "version": "2.0.0",
    "tasks": [
        {
            "label": "Run All Tests",
            "type": "shell",
            "command": "mvn clean verify",
            "group": "test"
        },
        {
            "label": "Run HTTP Assessment",
            "type": "shell",
            "command": "mvn test -Dtest=TS_HttpAssessment_JUnit",
            "group": "test"
        },
        {
            "label": "Run Network Tests",
            "type": "shell",
            "command": "mvn test -Dtest=TS_Network_JUnit",
            "group": "test"
        },
        {
            "label": "Generate Report",
            "type": "shell",
            "command": "allure open",
            "group": "build"
        }
    ]
}
```

## Next Steps

- Review [Test Development Guide](Doc-Test-Development.md)
- Explore [Framework Architecture](Diagram-Architecture.md)
- Check [API Documentation](../../../../../target/site/index.html)
- Study [Maven POM Configuration](../../../../../pom.xml)
- Learn about [HTTP Assessment](Doc-HTTP-Assessment.md)
- Understand [Network Diagnostics](Doc-Network-Diagnostics.md)

---

**Version**: 1.2.0  
**Last Updated**: 2025-10-30 11:56:00 AM CDT  
**Copyright** © 2025 MissionWares. All Rights Reserved.