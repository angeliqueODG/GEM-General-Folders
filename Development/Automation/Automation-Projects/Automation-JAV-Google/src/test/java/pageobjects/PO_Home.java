package pageobjects;

// Import class packages for this Page Object (PO)
import org.openqa.selenium.WebDriver;
import framework.automation.FW_Page;

/**
 * Page Object (PO) class used in the Page Object (PO) design pattern.
 * Inherits from the FW_Page class.
 */
// [Note: Automation Engineer, rename this Page Object (PO) class to match the
// filename.]
public class PO_Home extends FW_Page {

    // [Note: Automation Engineer, define the Page Object (PO) locators (LO) here.]
    private static final String LO_LNK_GOOGLE_APPS = "//a[@aria-label='Google apps']";
    private static final String LO_EDT_SEARCH = "//textarea[@id='APjFqb']";
    private static final String LO_BUT_BASE_GOOGLE_SEARCH = "//div[@class='FPdoLc lJ9FBc']//input[@value='Google Search']";
    private static final String L0_LNK_TERMS = "//a[@href='https://policies.google.com/terms?hl=en-RW&fg=1']";
    private static final String L0_LNK_Privacy = "//a[@href='https://policies.google.com/privacy?hl=en-RW&fg=1']";
    private static final String L0_LNK_BackHome = "//a[@href='https://www.google.com/']";
    private static final String LO_LNK_About = "//*[text()='About']";
    private static final String L0_TXT_TERMS_OF_SERVICE = "//span[text()='Terms of Service']";

    public PO_Home(WebDriver driver) {
        super(driver);
    }

    public String validateOnPage() {
        return validateLocatorExists(LO_LNK_GOOGLE_APPS, 10, 1);
    }

    public String enterSearch(String search) {
        String result = setText(LO_EDT_SEARCH, search, 10, false);
        typeOnKeyboard("TAB"); // Close the dropdown if it exists
        return result;
    }

    public String clickBaseGoogleSearch() {
        return clickLocator(LO_BUT_BASE_GOOGLE_SEARCH, 10);
    }

    public String validateOnPageBackHome() {
        return clickLocator(L0_LNK_BackHome, 10);
    }

    public String clickTermsLink() {
        return clickLocator(L0_LNK_TERMS, 10);
    }

    public String clickPrivacyLink() {
        return clickLocator(L0_LNK_Privacy, 10);
    }

    public String clickAboutLink() {
        return clickLocator(LO_LNK_About, 10);
    }

    public String validateLinkTerms() {
        return validateLocatorExists(L0_TXT_TERMS_OF_SERVICE, 10, 1);
    }

}
