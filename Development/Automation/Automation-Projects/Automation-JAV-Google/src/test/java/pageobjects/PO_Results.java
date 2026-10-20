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
public class PO_Results extends FW_Page {

    // [Note: Automation Engineer, define the Page Object (PO) locators (LO) here.]

    private static final String L0_RESULTSTATS_SEARCH_RESULTS = "( //h3[contains(text(),'Apple')])[1]";
    private static final String L0_LNK_BackHome = "//a[@id='logo']";

    public PO_Results(WebDriver driver) {
        super(driver);
    }

    public String validateOnPage() {
        return validateLocatorExists(L0_RESULTSTATS_SEARCH_RESULTS, 10, 1);
    }

    public String validateOnPageBackHome() {
        return clickLocator(L0_LNK_BackHome, 10);
    }

}
