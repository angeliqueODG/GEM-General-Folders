package pageobjects;

import org.openqa.selenium.WebDriver;
import framework.automation.FW_Page;

public class PO_About extends FW_Page {
    // private static final String LO_LNK_OnGoAbout = "//*[text()='About']";
    private static final String LO_LNK_OnAboutPage = "//a[@data-g-action='home']";
    private static final String L0_LNK_BackHome = "//a[@href='https://www.google.com/?utm_source=about&utm_medium=referral&utm_campaign=footer-link']";

    public PO_About(WebDriver driver) {
        super(driver);
    }

    public String validateOnPageAbout() {
        return validateLocatorExists(LO_LNK_OnAboutPage, 10, 1);
    }

    public String validateOnPage() {
        return validateLocatorExists(LO_LNK_OnAboutPage, 10, 1);
    }

    public String validateOnPageBackHome() {
        return clickLocator(L0_LNK_BackHome, 10);
    }

    public String clickOnPageBackHome() {
        return clickLocator(L0_LNK_BackHome, 10);
    }
}
