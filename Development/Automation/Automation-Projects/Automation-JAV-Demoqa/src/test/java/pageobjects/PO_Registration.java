package pageobjects;

import org.openqa.selenium.By;
//import org.openqa.selenium.By;
// Import class packages for this Page Object (PO)
import org.openqa.selenium.WebDriver; // Selenium WebDriver
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import framework.automation.FW_Page; // Automation framework Page Object (PO) class
import framework.utilities.ConfigMgr; // Automation framework Configuration Manager to retrieve testConfig.properties values

/**
 * Page Object (PO) class used in the Page Object (PO) design pattern.
 * Inherits from the FW_Page class.
 */
// [Note: Automation Engineer, rename this Page Object (PO) class to match the
// filename.]
public class PO_Registration extends FW_Page {

    // [Note: Automation Engineer, define the Page Object (PO) locators (LO) here.]
    private static final String LO_TXT_REGISTRATION = "//h5";
    private static final String LO_EDT_FIRST_NAME = "//input[@id='firstName']";
    private static final String LO_EDT_LAST_NAME = "//input[@id='lastName']";
    private static final String LO_EDT_EMAIL = "//input[@id='userEmail']";
    private static final String LO_RAD_GENDER = "(//label[@class='custom-control-label'])[1]";
    private static final String LO_EDT_MOBILE = "//input[@id='userNumber']";
    private static final String LO_LST_DATE_REF = "//div[@class='react-datepicker__current-month react-datepicker__current-month--hasYearDropdown react-datepicker__current-month--hasMonthDropdown']";
    private static final String LO_LST_DOB = "//div[@id='dateOfBirth']";
    private static final String PO_LST_DATEPICKER_DAY = "//div[@class='react-datepicker__day react-datepicker__day--020 react-datepicker__day--weekend']']";
    private static final String PO_LST_DATEPICKER_WEEK = "(//div[@class='react-datepicker__week'])[4]";
    private static final String PO_LST_DATEPICKER_MONTH = "//div[@class='react-datepicker__month']";
    private static final String PO_BTN_PREVIOUS_MONTH = "//button[@class='react-datepicker__navigation react-datepicker__navigation--previous']";
    private static final String LO_EDT_SUBJECTS = "//div[@class='subjects-auto-complete__value-container subjects-auto-complete__value-container--is-multi css-1hwfws3']";
    private static final String LO_SLCT_SPORTS = "//input[@id='hobbies-checkbox-1']";
    private static final String LO_SLCT_MUSIC = "//input[@id='hobbies-checkbox-3']";
    private static final String PO_SLCT_PICTURE = "//input[@id='uploadPicture']";
    private static final String PO_EDT_ADDRESS = "//textarea[@id='currentAddress']";
    private static final String PO_LST_STATE = "//div[@id='state']";
    private static final String PO_LST_CITY = "//div[@id='city']";
    private static final String PO_BTN_SUBMIT = "//button[@id='submit']";

    /**
     * Define the Page Object (PO) constructor.
     * 
     * 
     * @param driver The WebDriver object passed from the test method.
     */
    // [Note: Automation Engineer, rename this Page Object (PO) class to match the
    // filename.]
    public PO_Registration(WebDriver driver) {
        super(driver);
    }

    // [Note: Automation Engineer, define the Page Object (PO) methods here.]

    /**
     * Validates if current webpage is loaded and correct.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String validateOnStudentRegistrationForm() {
        return validateLocatorExists(LO_TXT_REGISTRATION, (Integer) ConfigMgr.getVarVal("defaultTimeout"),
                (Integer) ConfigMgr.getVarVal("defaultInterval"));
    }

    /**
     * Enter First Name.
     * 
     * @param firstName The text to enter in the username field.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String enterFirstName(String firstName) {
        String result = setText(LO_EDT_FIRST_NAME, firstName, (Integer) ConfigMgr.getVarVal("defaultTimeout"), false);
        return result;
    }

    /**
     * Enter last name.
     * 
     * @param lastName The text to enter in the password field.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String enterLastName(String lastName) {
        String result = setText(LO_EDT_LAST_NAME, lastName, (Integer) ConfigMgr.getVarVal("defaultTimeout"), false);
        return result;
    }

    /**
     * Enter email.
     * 
     * @param email The text to enter in the password field.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String enterEmail(String email) {
        String result = setText(LO_EDT_EMAIL, email, (Integer) ConfigMgr.getVarVal("defaultTimeout"), false);
        return result;
    }

    /**
     * Type on Keyboard TAB key.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String pressTab() throws Exception {
        Thread.sleep(3000);
        typeOnKeyboard("TAB");
        return "[PASS]-  Pressed the TAB Key";
    }

    /**
     * Click on Gender radio buton.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String clickGender() {
        return clickLocator(LO_RAD_GENDER, (Integer) ConfigMgr.getVarVal("defaultTimeout"));
    }

    /**
     * Enter mobile number.
     * 
     * @param mobile The text to enter in the password field.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String enterMobile(String mobile) {
        String result = setText(LO_EDT_MOBILE, mobile, (Integer) ConfigMgr.getVarVal("defaultTimeout"), false);
        return result;
    }

    /**
     * Click to select the date of birth.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String clickDOB() {
        return clickLocator(LO_LST_DOB, 10);
    }

    public String previousMonth() {
        WebElement todayMonth = getElement(LO_LST_DATE_REF);
        String todayMonthText = todayMonth.getText();
        String month = "November 1988";
        while (!month.equals(todayMonthText)) {
            clickPrevBtn();
            todayMonth = getElement(LO_LST_DATE_REF);
            todayMonthText = todayMonth.getText();
        }

        return clickLocator(PO_LST_DATEPICKER_MONTH, (Integer) ConfigMgr.getVarVal("defaultTimeout"));
    }

    /**
     * Enter subjects. PO_BTN_PEVIOUS_MONTH
     * 
     * return clickLocator(PO_LST_DATEPICKER_WEEK,
     * (Integer)ConfigMgr.getVarVal("defaultTimeout"));
     * return clickLocator(PO_LST_DATEPICKER_DAY, (Integer)
     * ConfigMgr.getVarVal("defaultTimeout"));
     * }
     * 
     * @param subjects The text to enter in the password field.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String enterSubjects(String subjects) {
        String result = setText(LO_EDT_SUBJECTS, subjects, (Integer) ConfigMgr.getVarVal("defaultTimeout"), false);
        return result;
    }

    /**
     * Click to select hobby as Sports.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String clickSports() {
        return clickLocator(LO_SLCT_SPORTS, (Integer) ConfigMgr.getVarVal("defaultTimeout"));
    }

    public String clickPrevBtn() {
        return clickLocator(PO_BTN_PREVIOUS_MONTH, (Integer) ConfigMgr.getVarVal("defaultTimeout"));
    }

    /**
     * Click to select hobby as Music.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String clickMusic() {
        return clickLocator(LO_SLCT_MUSIC, (Integer) ConfigMgr.getVarVal("defaultTimeout"));
    }

    /**
     * Click to select a picture.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String clickPicture() {
        return clickLocator(PO_SLCT_PICTURE, (Integer) ConfigMgr.getVarVal("defaultTimeout"));
    }

    /**
     * Enter Current address.
     * 
     * @param currentAddress text to enter in the password field.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String enterCurrentAddress(String currentAddress) {
        String result = setText(PO_EDT_ADDRESS, currentAddress, (Integer) ConfigMgr.getVarVal("defaultTimeout"), false);
        return result;
    }

    /**
     * Click and press ARROW_DOWN KEY to select State.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String clickState() {
        return clickLocator(PO_LST_STATE, (Integer) ConfigMgr.getVarVal("defaultTimeout"));
    }

    /**
     * Click and press ARROW_DOWN KEY to select City.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String clickCity() {
        return clickLocator(PO_LST_CITY, (Integer) ConfigMgr.getVarVal("defaultTimeout"));
    }

    /**
     * Click Submit button.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String clickSubmit() {
        return clickLocator(PO_BTN_SUBMIT, (Integer) ConfigMgr.getVarVal("defaultTimeout"));
    }

}