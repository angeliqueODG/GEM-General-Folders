package framework.driver;

// ===============================================================
// @file: FW_Browser.java
// @filepath: src/test/java/framework/driver/FW_Browser.java
// @version: 3.1.0
// @updated: 2026-05-01 11:00:00 AM CDT
// @author: Greg Paskal
// @company: MissionWares
//
// @description:
// Provides utility methods for creating and managing WebDriver instances.
// This class handles the creation of WebDriver instances for Chrome, Firefox,
// and Safari browsers based on configuration settings. Supports headless mode
// operation and a generic browser extension management capability for Chrome.
// Includes functionality to configure WebDriver options, handle browser-specific
// settings, and properly dispose of WebDriver instances after test execution.
//
// As of v3.1.0, Chrome is launched with a "demo-hardened" set of options that
// suppress browser pop-ups known to interrupt automated runs and live demos:
//   - "Change your password" (Chrome data-breach leak detection)
//   - "Save password?" / "Update password?" prompts
//   - "Save address?" / "Save card?" autofill prompts
//   - "Chrome is being controlled by automated test software" infobar
//   - Expired / self-signed SSL certificate interstitials
//
// Each suppression is gated by a boolean toggle in testConfig.properties so
// individual behaviors can be re-enabled per environment (e.g. you may want
// SSL warnings to remain visible during a security-focused QA run).
//
// @extension_capability:
// The framework retains the ability to load Chrome browser extensions (.crx files)
// from the project's extensions directory. To install a new extension:
//   1. Place the .crx file under: src/test/java/framework/extensions/<extensionName>/
//   2. Add a configuration property in testConfig.properties for the extension
//   3. Add a getter method in FW_ConfigMgr.java
//   4. Add the extension loader logic in the "Browser Extensions Requirements"
//      block below, following the pattern shown in earlier framework versions
//      (see v2.0.0 history for SelectorsHub reference implementation).
//
// @dependencies:
// - Selenium WebDriver (Chrome, Firefox, Safari drivers)
// - framework.utilities.FW_ConfigMgr
// - framework.utilities.FW_ConsoleColors
// - framework.utilities.FW_SystemUtils
// - framework.junit.FW_CustomAssertJU
//
// @methods:
// - createWebDriver(): Creates and returns configured WebDriver instance
// - disposeWebDriver(WebDriver): Safely closes browser and releases resources
// - buildHardenedChromeOptions(): Internal helper that assembles the demo-hardened ChromeOptions used by Chrome and the default browser branch.
//
// @configuration:
// Requires the following properties in testConfig.properties:
// - browser: Browser type (chrome, firefox, safari)
// - headless: Run in headless mode (true/false)
// - browserSuppressLeakDetection: Suppress "Change your password" dialog (true/false)
// - browserSuppressPasswordManager: Suppress "Save password?" dialog (true/false)
// - browserSuppressAutofillPrompts: Suppress "Save address?"/"Save card?" (true/false)
// - browserSuppressAutomationInfobar: Hide "controlled by automation" banner (true/false)
// - browserAcceptInsecureCerts: Accept expired / self-signed SSL certs (true/false)
//
// @tags: webdriver, browser-automation, selenium, cross-browser, extensions, demo-hardening, mAi™
//
// @changeLog:
// Date        Author          Version  Description
// ----------  --------------  -------  --------------------------
// 2025-01-01  G. Paskal       1.0.0    Initial implementation
// 2025-01-10  G. Paskal       2.0.0    Added mAi™ header and enhanced documentation
// 2025-12-12  G. Paskal       3.0.0    Removed SelectorsHub extension (license discontinued); kept extension scaffolding for future Chrome extensions
// 2026-05-01  G. Paskal       3.1.0    Added demo-hardened ChromeOptions: suppresses Chrome data-breach dialog, password manager prompts, autofill prompts, automation infobar, and SSL certificate interstitials. All toggles configurable via testConfig.properties.
// ===============================================================

// Java
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Selenium WebDriver
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

// Automation framework
import framework.utilities.FW_ConfigMgr;
import framework.junit.FW_CustomAssertJU;

/**
 * The Browser class is a utility class that provides a method to create a WebDriver instance
 * based on the browser type and headless mode specified in the test configuration file.
 *
 * <p>As of v3.1.0, Chrome instances are launched with a demo-hardened set of options
 * that suppress disruptive browser pop-ups (data-breach warnings, password manager
 * prompts, autofill prompts, automation banner, and SSL interstitials). Each
 * suppression is independently configurable via testConfig.properties.</p>
 *
 * <p>The framework supports loading Chrome browser extensions via .crx files placed in
 * the project's extensions directory. See the @extension_capability section in the
 * file header for instructions on adding a new extension.</p>
 */
public class FW_Browser {

    /**
     * Returns a WebDriver instance based on the browser type and headless mode specified.
     *
     * @return a WebDriver instance
     */
    public static WebDriver createWebDriver() {

        // Get the browser options from testConfig.properties
        String browser = FW_ConfigMgr.getBrowser().toLowerCase();
        String headless = FW_ConfigMgr.getHeadless().toLowerCase();

        // **************************************************************
        // Browser Extensions Requirements - Begin
        //
        // No extensions are currently configured. The extension capability
        // remains in the framework for future use. To add a Chrome extension:
        //
        //   1. Place the .crx file in:
        //      src/test/java/framework/extensions/<extensionName>/
        //
        //   2. Add config properties in testConfig.properties:
        //      myExtension=true
        //      myExtensionDirectory=myextensionname/
        //
        //   3. Add getters in FW_ConfigMgr.java:
        //      public static String getMyExtension() {...}
        //      public static String getMyExtensionDirectory() {...}
        //
        //   4. Add the extension discovery and loading logic here, then call
        //      options.addExtensions(new File(extensionCRXPath)) in the
        //      Chrome and default branches below.
        //
        // Browser Extensions Requirements - End
        // **************************************************************

        WebDriver driver;
        if ("chrome".equals(browser)) {
            ChromeOptions options = buildHardenedChromeOptions(headless);
            // Add extensions here when configured (see scaffolding above)
            driver = new ChromeDriver(options);
        } else if ("firefox".equals(browser)) {
            FirefoxOptions options = new FirefoxOptions();
            if ("true".equals(headless)) options.addArguments("--headless");
            // SSL handling is the only demo-hardening item that meaningfully applies to Firefox; the password / autofill prompts are Chrome-specific.
            if (FW_ConfigMgr.getBrowserAcceptInsecureCerts()) {
                options.setAcceptInsecureCerts(true);
            }
            driver = new FirefoxDriver(options);
        } else if ("safari".equals(browser)) {
            SafariOptions options = new SafariOptions();
            // Safari doesn't support headless mode as of now.
            // Safari also does not honor most Chrome-style suppression flags; SSL trust on Safari is managed through macOS Keychain. No-op here.
            driver = new SafariDriver(options);
        } else {
            // Default to Chrome if no matching browser is found
            ChromeOptions options = buildHardenedChromeOptions(headless);
            // Add extensions here when configured (see scaffolding above)
            driver = new ChromeDriver(options);
        }
        FW_CustomAssertJU.setDriver(driver);
        return driver;
    }

    /**
     * Builds a ChromeOptions instance pre-configured for clean automation runs.
     *
     * <p>Each suppression is gated by a configuration toggle so the behavior can
     * be turned off per-environment without touching code (e.g. when running a
     * security-focused QA pass that needs to see SSL warnings).</p>
     *
     * <p>Implementation notes for future maintainers:
     * <ul>
     *   <li><b>profile.password_manager_leak_detection</b> is the specific Chrome
     *       preference that governs the "Change your password" data-breach dialog.
     *       This is the dialog that began appearing in Chrome 124+ and was the
     *       trigger for adding this hardening method.</li>
     *   <li><b>credentials_enable_service</b> + <b>profile.password_manager_enabled</b>
     *       together suppress the older "Save password?" / "Update password?" prompts.</li>
     *   <li><b>--disable-blink-features=AutomationControlled</b> hides the
     *       <code>navigator.webdriver</code> JavaScript flag, which some sites use
     *       to surface extra warnings to bots.</li>
     *   <li><b>setAcceptInsecureCerts(true)</b> is the W3C-standard capability that
     *       handles expired / self-signed certificates. We deliberately do NOT add
     *       <code>--ignore-certificate-errors</code> as a command-line flag because
     *       <code>setAcceptInsecureCerts</code> is the modern, supported path; the
     *       old flag is redundant when the capability is set.</li>
     * </ul>
     * </p>
     *
     * @param headless "true" or "false" (already lowercased by caller)
     *
     * @return ChromeOptions ready to hand to ChromeDriver
     */
    private static ChromeOptions buildHardenedChromeOptions(String headless) {

        ChromeOptions options = new ChromeOptions();

        // ---- Headless mode (existing behavior) ---------------------------------
        if ("true".equals(headless)) {
            options.addArguments("--headless");
        }

        // ---- Suppress automation infobar ---------------------------------------
        // Hides the yellow "Chrome is being controlled by automated test software"
        // bar at the top of the window. Optional; recommended for live demos.
        if (FW_ConfigMgr.getBrowserSuppressAutomationInfobar()) {
            options.setExperimentalOption(
                "excludeSwitches",
                List.of("enable-automation")
            );
            options.addArguments("--disable-blink-features=AutomationControlled");
        }

        // ---- Always-helpful housekeeping switches ------------------------------
        // These prevent first-run / default-browser overlays that can also
        // interfere with demos. Not gated — they're zero-risk for automation.
        options.addArguments("--no-first-run");
        options.addArguments("--no-default-browser-check");

        // ---- User-profile preferences ------------------------------------------
        // We collect any pref-based suppressions in a single map and apply them
        // together. This is the only way Chrome accepts these toggles.
        Map<String, Object> prefs = new HashMap<>();

        // The big one — disables the "Change your password" data-breach dialog.
        // This is the suppression that motivated the v3.1.0 update.
        if (FW_ConfigMgr.getBrowserSuppressLeakDetection()) {
            prefs.put("profile.password_manager_leak_detection", false);
        }

        // Suppresses the "Save password?" / "Update password?" prompts.
        // Two prefs are required — Chrome reads both.
        if (FW_ConfigMgr.getBrowserSuppressPasswordManager()) {
            prefs.put("credentials_enable_service", false);
            prefs.put("profile.password_manager_enabled", false);
        }

        // Suppresses "Save address?" and "Save card?" autofill prompts.
        if (FW_ConfigMgr.getBrowserSuppressAutofillPrompts()) {
            prefs.put("autofill.profile_enabled", false);
            prefs.put("autofill.credit_card_enabled", false);
        }

        if (!prefs.isEmpty()) {
            options.setExperimentalOption("prefs", prefs);
        }

        // ---- SSL / certificate handling ----------------------------------------
        // setAcceptInsecureCerts is the W3C-standard capability and is preferred
        // over the legacy --ignore-certificate-errors switch. It also works on
        // Firefox, so we use the same pattern there.
        if (FW_ConfigMgr.getBrowserAcceptInsecureCerts()) {
            options.setAcceptInsecureCerts(true);
        }

        return options;
    }

    /**
     * Quits the WebDriver instance, effectively closing the browser window.
     *
     * @param driver the WebDriver instance to quit
     */
    public static void disposeWebDriver(WebDriver driver) {
        // Quit the driver, effectively closing the browser window
        if (driver != null) {
            driver.quit();
        }
    }

}