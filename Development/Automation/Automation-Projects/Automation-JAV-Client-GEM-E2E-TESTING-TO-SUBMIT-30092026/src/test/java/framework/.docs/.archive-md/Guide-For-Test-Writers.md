# Test Writer's Guide - mAi Automation Framework

<!-- ===============================================================
@file: Guide-For-Test-Writers.md
@filepath: src/test/java/framework/.docs/Guide-For-Test-Writers.md
@version: 1.0.0
@created: 2025-10-30 02:10:00 PM CDT
@updated: 2025-10-30 02:10:00 PM CDT
@author: Greg Paskal
@company: MissionWares

@description:
Focused reading guide for QA Engineers and Test Developers. This guide provides
a streamlined path through the documentation, focusing only on content relevant
to writing, executing, and maintaining automated tests. Skips architecture
deep-dives, cloud integration details, and framework internals to get test
writers productive quickly.

@audience: QA Engineers, Test Automation Engineers, SDET, Test Developers

@purpose:
Get test writers productive in 90 minutes by focusing on:
- Page Object Model pattern
- Writing test suites and test cases
- Using custom assertions
- Running tests and viewing reports
- Basic troubleshooting

@dependencies:
- Framework documentation files
- Working test environment

@tags: test-writing, qa, sdet, automation, guide, role-based, mAi™

@changeLog:
Date        Author          Version  Description
----------  --------------  -------  --------------------------
2025-10-30  G. Paskal       1.0.0    Initial test writer's guide
=============================================================== -->

<!-- Navigation - Begin -->
[Home](Home.md) | [Overview](Doc-Overview.md) | [Reading Guide](Guide-Reading-Order.md) | [API Docs](../../../../../target/site/index.html)
<!-- Navigation - End -->

---

# 🧪 Test Writer's Guide

**Target Audience**: QA Engineers, Test Automation Engineers, SDET  
**Reading Time**: 90 minutes  
**Goal**: Write and run automated tests  
**Skill Level**: Beginner to Intermediate

---

## Welcome Test Writers! 👋

This guide gets you writing tests **FAST**. We skip the heavy architecture stuff and focus on what you need:
- ✅ Writing tests using Page Objects
- ✅ Using assertions that auto-screenshot
- ✅ Running tests
- ✅ Viewing reports
- ✅ Basic troubleshooting

**Skip to**: [Quick Start (5 min)](#quick-start-5-minutes) if you're in a hurry!

---

## Table of Contents

### **ESSENTIAL** (Must Read - 60 min)
1. [Quick Start](#quick-start-5-minutes) (5 min) 🚀
2. [Your First Test](#your-first-test-20-minutes) (20 min) 🚀
3. [Page Object Pattern](#page-object-pattern-15-minutes) (15 min) 🚀
4. [Custom Assertions](#custom-assertions-10-minutes) (10 min) 🚀
5. [Running Tests](#running-tests-10-minutes) (10 min) 🚀

### **IMPORTANT** (Read Soon - 30 min)
6. [Test Organization](#test-organization-10-minutes) (10 min)
7. [Viewing Reports](#viewing-reports-10-minutes) (10 min)
8. [Common Patterns](#common-patterns-10-minutes) (10 min)

### **REFERENCE** (Use When Needed)
9. [Troubleshooting](#troubleshooting)
10. [Command Reference](#command-reference)
11. [Best Practices](#best-practices)

### **ADVANCED** (Optional)
12. [HTTP Security Tests](#http-security-tests) (Optional)
13. [Network Diagnostic Tests](#network-diagnostic-tests) (Optional)

---

# ESSENTIAL READING

---

## Quick Start (5 Minutes)

**Goal**: See a test run successfully

### Step 1: Verify Setup

```bash
# Check Java version (need 23+)
java -version

# Check Maven
mvn -version

# Navigate to project
cd path/to/Automation-JAV-mAi
```

### Step 2: Run Example Test

```bash
# Run the sample test
mvn test -Dtest=TS_Ordering_JUnit
```

### Step 3: Check Results

```bash
# View report
allure serve target/allure-results
```

**✅ Success?** Continue to [Your First Test](#your-first-test-20-minutes)  
**❌ Errors?** See [Troubleshooting](#troubleshooting)

---

## Your First Test (20 Minutes)

**Goal**: Write a complete test from scratch

### Step 1: Create Page Object

**File**: `src/test/java/pageobjects/PO_ExamplePage.java`

```java
package pageobjects;

import org.openqa.selenium.WebDriver;
import framework.automation.FW_Page;
import framework.junit.FW_CustomAssertJU;

public class PO_ExamplePage extends FW_Page {
    
    // Constructor
    public PO_ExamplePage(WebDriver driver) {
        super(driver);
    }
    
    // Locators (use Selenium locator syntax)
    private String btn_submit = "id=submit-button";
    private String txt_username = "name=username";
    private String txt_password = "css=input[type='password']";
    private String lbl_welcomeMessage = "xpath=//h1[@class='welcome']";
    
    // Actions
    public void navigateToPage() {
        String url = "https://example.com/login";
        FW_CustomAssertJU.navigateToURL(driver, url);
    }
    
    public void enterUsername(String username) {
        FW_CustomAssertJU.sendKeys(driver, txt_username, username);
    }
    
    public void enterPassword(String password) {
        FW_CustomAssertJU.sendKeys(driver, txt_password, password);
    }
    
    public void clickSubmit() {
        FW_CustomAssertJU.click(driver, btn_submit);
    }
    
    public void verifyWelcomeMessage() {
        FW_CustomAssertJU.elementExists(driver, lbl_welcomeMessage);
    }
}
```

### Step 2: Create Test Suite

**File**: `src/test/java/testsuites/TS_MyFirstTests_JUnit.java`

```java
package testsuites;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import pageobjects.PO_ExamplePage;
import framework.automation.FW_Driver;
import framework.junit.FW_TestSuite;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TS_MyFirstTests_JUnit extends FW_TestSuite {
    
    // Page Objects
    PO_ExamplePage examplePage;
    
    @BeforeAll
    void setupSuite() {
        // Initialize WebDriver
        driver = FW_Driver.createDriver("chrome", false);
        
        // Initialize Page Objects
        examplePage = new PO_ExamplePage(driver);
    }
    
    @AfterAll
    void teardownSuite() {
        // Close browser
        if (driver != null) {
            driver.quit();
        }
    }
    
    @Test
    @Order(1)
    void tc_login_successful() {
        // Navigate to page
        examplePage.navigateToPage();
        
        // Enter credentials
        examplePage.enterUsername("testuser");
        examplePage.enterPassword("password123");
        
        // Click submit
        examplePage.clickSubmit();
        
        // Verify welcome message
        examplePage.verifyWelcomeMessage();
    }
}
```

### Step 3: Run Your Test

```bash
mvn test -Dtest=TS_MyFirstTests_JUnit
```

### Step 4: Check Results

```bash
allure serve target/allure-results
```

**✅ Test Passed?** Great! Continue to [Page Object Pattern](#page-object-pattern-15-minutes)  
**❌ Test Failed?** See error message and check:
- Is the URL correct?
- Are the locators correct?
- Is ChromeDriver version correct?

---

## Page Object Pattern (15 Minutes)

**Goal**: Master the Page Object Model

### What is a Page Object?

A Page Object represents a web page in code:
- **Locators** - Element selectors (private strings)
- **Actions** - Methods that interact with elements (public)
- **No Assertions** - Page Objects just do actions, assertions happen in tests

### Locator Syntax

```java
// ID
private String btn_login = "id=login-button";

// Name
private String txt_username = "name=user";

// CSS Selector
private String div_content = "css=div.content";

// XPath
private String lnk_logout = "xpath=//a[@class='logout']";

// Link Text
private String lnk_home = "linkText=Home";

// Partial Link Text
private String lnk_settings = "partialLinkText=Sett";
```

### Page Object Structure

```java
public class PO_MyPage extends FW_Page {
    
    // 1. Constructor
    public PO_MyPage(WebDriver driver) {
        super(driver);
    }
    
    // 2. Locators (PRIVATE)
    private String element1 = "id=example";
    private String element2 = "css=.button";
    
    // 3. Actions (PUBLIC)
    public void doSomething() {
        FW_CustomAssertJU.click(driver, element1);
    }
    
    public void doSomethingElse(String text) {
        FW_CustomAssertJU.sendKeys(driver, element2, text);
    }
}
```

### Best Practices

✅ **DO**:
- Use descriptive locator names (`btn_submit`, `txt_email`)
- Use prefixes: `btn_`, `txt_`, `lbl_`, `lnk_`, `chk_`, `drp_`
- Keep actions simple (one thing per method)
- Use FW_CustomAssertJU for interactions

❌ **DON'T**:
- Put assertions in Page Objects
- Make locators public
- Use Thread.sleep() (use waits instead)
- Hardcode test data in Page Objects

---

## Custom Assertions (10 Minutes)

**Goal**: Use assertions that auto-capture screenshots

### Why FW_CustomAssertJU?

Standard Selenium:
```java
// No screenshot on failure ❌
driver.findElement(By.id("button")).click();
```

Framework Custom Assertion:
```java
// Auto-screenshot on failure ✅
FW_CustomAssertJU.click(driver, "id=button");
```

### All Available Assertions

#### Navigation
```java
// Navigate to URL
FW_CustomAssertJU.navigateToURL(driver, "https://example.com");
```

#### Existence
```java
// Check element exists
FW_CustomAssertJU.elementExists(driver, "id=submit");

// Check element does NOT exist
FW_CustomAssertJU.elementDoesNotExist(driver, "id=error");
```

#### Interaction
```java
// Click element
FW_CustomAssertJU.click(driver, "id=button");

// Type text
FW_CustomAssertJU.sendKeys(driver, "name=username", "testuser");

// Clear and type
FW_CustomAssertJU.clearAndSendKeys(driver, "name=email", "test@example.com");

// Select dropdown by visible text
FW_CustomAssertJU.selectDropdownByVisibleText(driver, "id=country", "United States");

// Upload file
FW_CustomAssertJU.uploadFile(driver, "id=file-upload", "/path/to/file.pdf");
```

#### Verification
```java
// Check element is displayed
FW_CustomAssertJU.elementIsDisplayed(driver, "css=.message");

// Check element is enabled
FW_CustomAssertJU.elementIsEnabled(driver, "id=submit-btn");

// Verify text equals
FW_CustomAssertJU.verifyTextEquals(driver, "css=.title", "Welcome");

// Verify text contains
FW_CustomAssertJU.verifyTextContains(driver, "id=message", "success");

// Verify attribute
FW_CustomAssertJU.verifyAttributeEquals(driver, "id=link", "href", "https://example.com");
```

### Example Usage

```java
@Test
void tc_complete_form() {
    // Navigate
    FW_CustomAssertJU.navigateToURL(driver, "https://example.com/form");
    
    // Fill form
    FW_CustomAssertJU.sendKeys(driver, "name=firstName", "John");
    FW_CustomAssertJU.sendKeys(driver, "name=lastName", "Doe");
    FW_CustomAssertJU.sendKeys(driver, "name=email", "john@example.com");
    
    // Select dropdown
    FW_CustomAssertJU.selectDropdownByVisibleText(driver, "id=country", "USA");
    
    // Check checkbox
    FW_CustomAssertJU.click(driver, "id=agreeTerms");
    
    // Submit
    FW_CustomAssertJU.click(driver, "id=submitBtn");
    
    // Verify success
    FW_CustomAssertJU.verifyTextContains(driver, "css=.success-message", "Thank you");
}
```

---

## Running Tests (10 Minutes)

**Goal**: Run tests efficiently

### Run All Tests

```bash
mvn clean verify
```

### Run Specific Test Suite

```bash
mvn test -Dtest=TS_Login_JUnit
```

### Run Multiple Suites

```bash
mvn test -Dtest=TS_Login_JUnit,TS_Registration_JUnit
```

### Run Single Test Case

```bash
mvn test -Dtest=TS_Login_JUnit#tc_login_successful
```

### Run with Different Browser

```bash
# Chrome (default)
mvn test -Dtest=TS_Login_JUnit -Dbrowser=chrome

# Firefox
mvn test -Dtest=TS_Login_JUnit -Dbrowser=firefox

# Edge
mvn test -Dtest=TS_Login_JUnit -Dbrowser=edge
```

### Run in Headless Mode

```bash
mvn test -Dtest=TS_Login_JUnit -Dheadless=true
```

### Parallel Execution

Edit `testConfig.properties`:
```properties
parallelExecution=true
parallelExecutionThreads=4
```

Then run:
```bash
mvn verify
```

---

# IMPORTANT READING

---

## Test Organization (10 Minutes)

### File Naming Convention

```
Test Suites:    TS_<Name>_JUnit.java
Test Cases:     tc_<description>
Page Objects:   PO_<PageName>.java
```

### Test Suite Structure

```java
@TestInstance(TestInstance.Lifecycle.PER_CLASS)  // One driver for all tests
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)  // Run in order
public class TS_Example_JUnit extends FW_TestSuite {
    
    // Page Objects
    PO_LoginPage loginPage;
    PO_HomePage homePage;
    
    // Setup (runs once before all tests)
    @BeforeAll
    void setupSuite() {
        driver = FW_Driver.createDriver("chrome", false);
        loginPage = new PO_LoginPage(driver);
        homePage = new PO_HomePage(driver);
    }
    
    // Cleanup (runs once after all tests)
    @AfterAll
    void teardownSuite() {
        if (driver != null) {
            driver.quit();
        }
    }
    
    // Optional: runs before each test
    @BeforeEach
    void setupTest() {
        // Reset state if needed
    }
    
    // Optional: runs after each test
    @AfterEach
    void cleanupTest() {
        // Clean up after each test
    }
    
    // Tests (in order)
    @Test
    @Order(1)
    void tc_first_test() { /* ... */ }
    
    @Test
    @Order(2)
    void tc_second_test() { /* ... */ }
}
```

### Directory Structure

```
src/test/java/
├── pageobjects/
│   ├── PO_LoginPage.java
│   ├── PO_HomePage.java
│   └── PO_ProfilePage.java
├── testsuites/
│   ├── TS_Login_JUnit.java
│   ├── TS_Registration_JUnit.java
│   └── TS_UserProfile_JUnit.java
└── framework/
    └── (framework classes)
```

---

## Viewing Reports (10 Minutes)

### Allure Report (Primary)

```bash
# Generate and open report
allure serve target/allure-results
```

**Report Includes**:
- ✅ Test results (Pass/Fail)
- ✅ Screenshots (on failure)
- ✅ Test duration
- ✅ Test steps
- ✅ Categories (suites)

### Console Output

During test execution, watch for:
```
[INFO] Running testsuites.TS_Login_JUnit
  - PASS: Navigated to URL: 'https://example.com'
  - PASS: Element clicked: 'id=login-button'
  - PASS: Text entered: 'username'
[INFO] Tests run: 3, Failures: 0, Errors: 0, Skipped: 0
```

### Screenshots

**Location**: `target/screenshots/`

Screenshots are automatically taken:
- ✅ On every assertion failure
- ✅ On test errors
- ✅ On demand (manual)

**Manual Screenshot**:
```java
FW_CustomAssertJU.takeScreenshot(driver, "my-screenshot");
```

### Test Data

**Location**: `target/data/TestStepsData.csv`

Contains every test step:
- Test suite name
- Test case name
- Step description
- Result (Pass/Fail)
- Duration
- Screenshot reference

---

## Common Patterns (10 Minutes)

### Pattern 1: Login Flow

```java
public void performLogin(String username, String password) {
    loginPage.enterUsername(username);
    loginPage.enterPassword(password);
    loginPage.clickLoginButton();
    homePage.verifyUserLoggedIn();
}
```

### Pattern 2: Form Submission

```java
@Test
void tc_submit_registration_form() {
    registrationPage.enterFirstName("John");
    registrationPage.enterLastName("Doe");
    registrationPage.enterEmail("john@example.com");
    registrationPage.selectCountry("United States");
    registrationPage.agreeToTerms();
    registrationPage.clickSubmit();
    registrationPage.verifySuccessMessage();
}
```

### Pattern 3: Data-Driven Test

```java
@Test
void tc_login_with_multiple_users() {
    String[][] users = {
        {"user1", "pass1"},
        {"user2", "pass2"},
        {"user3", "pass3"}
    };
    
    for (String[] user : users) {
        performLogin(user[0], user[1]);
        homePage.verifyUserLoggedIn();
        homePage.logout();
    }
}
```

### Pattern 4: Wait for Element

```java
// Built into FW_CustomAssertJU (implicit wait)
FW_CustomAssertJU.elementExists(driver, "id=slow-element");

// Custom explicit wait (if needed)
WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("element")));
```

### Pattern 5: Conditional Logic

```java
@Test
void tc_handle_optional_popup() {
    loginPage.navigateToPage();
    
    // Check if popup exists (doesn't fail if not found)
    boolean popupExists = driver.findElements(By.id("popup")).size() > 0;
    
    if (popupExists) {
        FW_CustomAssertJU.click(driver, "id=closePopup");
    }
    
    // Continue with test
    loginPage.enterUsername("testuser");
}
```

---

# REFERENCE SECTIONS

---

## Troubleshooting

### Test Won't Run

**Problem**: `mvn test` does nothing  
**Solution**:
- Check test class ends with `_JUnit.java`
- Verify `@Test` annotation present
- Check Maven output for errors

### ChromeDriver Issues

**Problem**: `ChromeDriver version mismatch`  
**Solution**:
```bash
# Check Chrome version
chrome --version

# Update ChromeDriver to match
# Download from: https://chromedriver.chromium.org/
```

**Problem**: `ChromeDriver not in PATH`  
**Solution**:
- Add ChromeDriver location to system PATH
- Or specify in `testConfig.properties`:
```properties
chromeDriverPath=/path/to/chromedriver
```

### Element Not Found

**Problem**: `NoSuchElementException`  
**Solutions**:
1. Check locator syntax is correct
2. Check element exists on page (F12 DevTools)
3. Wait for page to load (increase implicit wait)
4. Check element is in iframe (switch context if needed)

### Tests Pass Locally, Fail in CI

**Common Causes**:
- Different browser versions
- Network speed differences
- Screen resolution differences

**Solutions**:
- Use headless mode in CI
- Increase timeouts
- Use explicit waits for dynamic content

### Allure Report Won't Open

**Problem**: `allure: command not found`  
**Solution**:
```bash
# Install Allure
brew install allure  # Mac
scoop install allure # Windows
```

---

## Command Reference

### Maven Test Commands

```bash
# Run all tests
mvn clean verify

# Run specific suite
mvn test -Dtest=TS_Login_JUnit

# Run multiple suites
mvn test -Dtest=TS_Login_JUnit,TS_Registration_JUnit

# Run single test case
mvn test -Dtest=TS_Login_JUnit#tc_login_successful

# Skip tests
mvn clean install -DskipTests

# Run with system properties
mvn test -Dbrowser=firefox -Dheadless=true
```

### Report Commands

```bash
# View Allure report
allure serve target/allure-results

# Generate Allure report
allure generate target/allure-results

# View JavaDocs
mvn site
open target/site/index.html
```

### Cleanup Commands

```bash
# Clean build artifacts
mvn clean

# Remove test data
rm -rf target/data/*

# Remove screenshots
rm -rf target/screenshots/*
```

---

## Best Practices

### Test Writing

✅ **DO**:
- Use descriptive test names (`tc_login_with_valid_credentials`)
- One assertion per test when possible
- Keep tests independent (can run in any order)
- Use Page Objects for all interactions
- Add @Order to control execution sequence

❌ **DON'T**:
- Use Thread.sleep() (use waits instead)
- Hardcode test data
- Test multiple things in one test
- Skip error handling
- Ignore failed tests

### Page Objects

✅ **DO**:
- One Page Object per page/component
- Use descriptive locator names
- Keep actions simple (one thing per method)
- Return void or boolean (not elements)
- Use FW_CustomAssertJU for interactions

❌ **DON'T**:
- Put assertions in Page Objects
- Make locators public
- Return WebElements
- Add business logic
- Access database directly

### Assertions

✅ **DO**:
- Use FW_CustomAssertJU for auto-screenshots
- Verify expected outcomes
- Check both positive and negative cases
- Add descriptive error messages

❌ **DON'T**:
- Use bare Selenium commands
- Skip verifications
- Assume success without checking
- Over-assert (too many checks)

---

# ADVANCED (OPTIONAL)

---

## HTTP Security Tests

**File**: [Doc-HTTP-Assessment.md](Doc-HTTP-Assessment.md)

### Quick Example

```java
import framework.audits.FW_Audit_HttpReview;
import framework.http.FW_Http;

@Test
void tc_security_audit() {
    String url = "https://example.com";
    FW_Http http = new FW_Http(driver);
    
    // Perform HTTP audit
    FW_Audit_HttpReview.performAudit(driver, url, true);
    
    // Report generated in target/reports/
}
```

### What It Checks

- HTTPS/SSL configuration
- Security headers (CSP, HSTS, X-Frame-Options)
- Cookie security
- Server configuration

**Report Location**: `target/reports/HTTP_Audit_Report_*.md`

---

## Network Diagnostic Tests

**File**: [Doc-Network-Diagnostics.md](Doc-Network-Diagnostics.md)

### Quick Example

```java
import framework.audits.FW_Audit_Ping;

@Test
void tc_ping_test() {
    String host = "www.google.com";
    FW_Audit_Ping.performPing(driver, host, 4, 1000);
}
```

### Available Tests

- **Ping**: Check host reachability
- **Traceroute**: Network path analysis
- **Speed Test**: Bandwidth measurement

---

# Quick Reference Card

**Print this section!**

### Common Commands
```bash
mvn test -Dtest=TS_MyTests_JUnit        # Run suite
mvn test -Dtest=*_JUnit#tc_specific     # Run test
allure serve target/allure-results       # View report
```

### Common Assertions
```java
FW_CustomAssertJU.navigateToURL(driver, url);
FW_CustomAssertJU.click(driver, locator);
FW_CustomAssertJU.sendKeys(driver, locator, text);
FW_CustomAssertJU.elementExists(driver, locator);
FW_CustomAssertJU.verifyTextEquals(driver, locator, expected);
```

### Locator Syntax
```java
"id=element-id"
"name=element-name"
"css=.class-name"
"xpath=//div[@class='test']"
```

### Test Structure
```java
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TS_Name_JUnit extends FW_TestSuite {
    @BeforeAll void setupSuite() { }
    @AfterAll void teardownSuite() { }
    @Test @Order(1) void tc_test() { }
}
```

---

# Next Steps

**You've completed the Test Writer's Guide!** 🎉

**Now**:
1. ✅ Write your first 3 tests
2. ✅ Run them successfully
3. ✅ Review reports
4. ✅ Share with your team

**Need More?**
- [Complete Reading Guide](Guide-Reading-Order.md) - Full documentation
- [DevOps Guide](Guide-For-DevOps.md) - CI/CD integration
- [Framework Maintainer Guide](Guide-For-Framework-Maintainers.md) - Extending framework

---

**Version**: 1.0.0  
**Last Updated**: 2025-10-30 02:10:00 PM CDT  
**Copyright** © 2025 MissionWares. All Rights Reserved.