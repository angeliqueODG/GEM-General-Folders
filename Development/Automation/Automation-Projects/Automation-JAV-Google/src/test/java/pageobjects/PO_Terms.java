package pageobjects;

import org.openqa.selenium.WebDriver;
import framework.automation.FW_Page;

public class PO_Terms extends FW_Page {
    private static final String L0_LNK_TERMS = "//span[contains(text(), 'Terms of Service')]";
    private static final String L0_LNK_PRIVACY = "//a[@href='https://policies.google.com/privacy?hl=en-RW&fg=1']";
    private static final String L0_LNK_BackHome = "//a[@href='https://www.google.com/']";

    private static final String L0_IML0_TXT_PRIVACY_POLICY = "//span[text()='Privacy Policy']";

    public PO_Terms(WebDriver driver) {
        super(driver);
    }

    public String validateOnPageTerms() {
        return validateLocatorExists(L0_LNK_TERMS, 10, 1);
    }

    public String validateOnPagePrivacy() {
        return validateLocatorExists(L0_LNK_PRIVACY, 10, 1);
    }

    public String validateOnPrivacy() {
        return validateLocatorExists(L0_IML0_TXT_PRIVACY_POLICY, 10, 1);
    }

    public String validateOnPageBackHome() {
        return clickLocator(L0_LNK_BackHome, 10);
    }

}
