# Automation Framework - Usage

<!-- Navigation - Begin -->
[Home](Home.md) | [Overview](Overview.md) | [Setup](Setup.md) | [Test](Test.md) | [Diagrams](Diagrams.md) | [API Docs](../../../../../target/site/index.html)
<!-- Navigation - End -->

---

## Writing Tests

Write your test cases using JUnit 5 and Selenium WebDriver. Here is an example test case:

```java
package testsuites;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TC_SampleTest {
    @Test
    public void tc_sampleTest() {
        // Your test code here
        assertTrue(true);
    }
}