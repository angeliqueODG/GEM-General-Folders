package pageobjects;

// Import class packages for this Page Object (PO)
import org.openqa.selenium.WebDriver; // Selenium WebDriver
import framework.automation.FW_Page; // Automation framework Page Object (PO) class
import framework.utilities.FW_ConfigMgr; // Automation framework Configuration Manager to retrieve testConfig.properties values
import framework.utilities.FW_StringUtils;// [Note: Import any other required libraries here.]

/**
 * Page Object (PO) class used in the Page Object (PO) design pattern.
 * Inherits from the FW_Page class.
 */
// [Note: Automation Engineer, rename this Page Object (PO) class to match the
// filename.]
public class PO_Catalog extends FW_Page {

    // [Note: Automation Engineer, define the Page Object (PO) locators (LO) here.]
    private static final String LO_IMG_CAT = "//img[@src='../images/cats_icon.gif']";
    private static final String LO_LNK_CATS = "//div[@id='Catalog']";
    private static final String LO_LNK_PERSIAN = "//a[contains(text(),'FL-DLH-02')]";
    private static final String LO_LBL_PERSIAN = "//h2";
    private static final String LO_BUT_ADD_TO_CART_FEMALE = "(//a[contains(text(),'Add to Cart')])[1]";
    private static final String LO_EDT_SEARCH = "//input[@name='keyword']";
    private static final String LO_BUT_SEARCH = "//input[@name='searchProducts']";
    private static final String LO_LBL_PRODUCT_VERIFY = "//td[3]";
    private static final String LO_LNK_QUESTION_MARK = " //a[contains(text(),'?')]";
    private static final String PO_LBL_DEMO_VERIFY = "//h1[contains(text(),'JPetStore Demo')]";
    private static final String LO_LNK_KNOWN_ISSUES = "//a[contains(text(),'Known Issues')]";
    private static final String LO_LBL_Home = "//div[@id='LogoContent']";
    private static final String LO_BUT_SIGN_IN = " //a[contains(text(),'Sign In')]";
    private static final String LO_LBL_SIGN_IN_VERIFY = "//p[1]";
    private static final String LO_BUT_REGISTER_NOW = "//a[contains(text(),'Register Now!')]";
    private static final String LO_LBL_REGISTER_NOW_VERIFY = "//h3[1]";
    private static final String LO_EDT_USER_ID = "//input[@name='username']";
    private static final String LO_EDT_PASSWORD = "//input[@name='password']";
    private static final String LO_EDT_REPEAT_PASSWORD = "//input[@name='repeatedPassword']";
    private static final String LO_EDT_FIRST_NAME = "//input[@name='account.firstName']";
    private static final String LO_EDT_LAST_NAME = "//input[@name='account.lastName']";
    private static final String LO_EDT_EMAIL = "//input[@name='account.email']";
    private static final String LO_EDT_PHONE = "//input[@name='account.phone']";
    private static final String LO_EDT_ADDRESS1 = "//input[@name='account.address1']";
    private static final String LO_EDT_ADDRESS2 = "//input[@name='account.address2']";
    private static final String LO_EDT_CITY = "//input[@name='account.city']";
    private static final String LO_EDT_STATE = "//input[@name='account.state']";
    private static final String LO_EDT_ZIP = "//input[@name='account.zip']";
    private static final String LO_EDT_COUNTRY = "//input[@name='account.country']";
    private static final String LO_LST_LANGUAGE = "//select[@name='account.languagePreference']";
    private static final String LO_CHK_MY_LIST = "//input[@name='account.listOption']";
    private static final String LO_CHK_MY_BANNER = "//input[@name='account.bannerOption']";
    private static final String LO_BUT_SAVE_AC_INFO = "//input[@name='newAccount']";
    private static final String LO_LBL_SEARCH = "//div[@id='Content']";
    private static final String LO_IMG_CART = "//img[@name='img_cart']";
    private static final String LO_IMG_FISH = "//img[@src='../images/fish_icon.gif']";
    private static final String LO_LBL_FISH = "//div[@id='Catalog']";
    private static final String LO_LNK_ANGELFISH = "//a[contains(text(),'FI-SW-01')]";
    private static final String LO_LBL_ANGELFISH = "//div[@id='Catalog']";
    private static final String LO_LNK_ADD_TO_CART = " (//a[contains(text(),'Add to Cart')])[1]";
    private static final String LO_LBL_PRODUCT_ID = "//div[@id='Catalog']";
    private static final String LO_LNK_PRODUCT_ID = "//a[contains(text(),'FI-SW-02')]";
    private static final String LO_LNK_ITEM_ID_EST = " //a[contains(text(),'EST-3')]";
    private static final String LO_LBL_FI_SW = "(//td)[2]";
    private static final String LO_LBL_TOOTHLESS_TIGER = "(//td)[3]";
    private static final String LO_LBL_PRICE = "(//td)[4]";
    private static final String LO_LNK_Q = "//a[contains(text(),'?')]";

    /**
     * Define the Page Object (PO) constructor.
     * 
     * @param driver The WebDriver object passed from the test method.
     */
    // [Note: Automation Engineer, rename this Page Object (PO) class to match the
    // filename.]
    public PO_Catalog(WebDriver driver) {
        super(driver);
    }

    // [Note: Automation Engineer, define the Page Object (PO) methods here.]

    /**
     * Click on the "Catalog" image.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String clickCat() {
        String result = clickLocator(LO_IMG_CAT, FW_ConfigMgr.getDefaultTimeout());
        return result;
    }

    /**
     * Verify you're on "Cats" page
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */

    public String validateOnCats() {
        String result = validateWithinLocatorText(LO_LNK_CATS, "Cats",
                FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval(), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName());
        return result;
    }

    /**
     * Click on the "Persian" link.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String clickPersian() {
        String result = clickLocator(LO_LNK_PERSIAN, FW_ConfigMgr.getDefaultTimeout());
        return result;
    }

    /**
     * Verify you're on "Persian" page
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String validateOnPersian() {
        String result = validateWithinLocatorText(LO_LBL_PERSIAN, "Persian",
                FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval(), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName());
        return result;
    }

    /**
     * Click on "Add to cart" of "Adult Female Persian"
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String clickAddToCartFemalePersian() {
        String result = clickLocator(LO_BUT_ADD_TO_CART_FEMALE, FW_ConfigMgr.getDefaultTimeout());
        return result;
    }

    /**
     * Enter The product name in the search field
     * 
     * @param typeProductName The text to enter in the password field.
     * 
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     * 
     *         details.
     * 
     */
    public String typeProductName(String typeProductName) {
        String result = setText(LO_EDT_SEARCH, typeProductName, FW_ConfigMgr.getDefaultTimeout(), false);
        return result;
    }

    /**
     * Click on "Search" button
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */

    public String clickSearch() {
        String result = clickLocator(LO_BUT_SEARCH, FW_ConfigMgr.getDefaultTimeout());
        return result;
    }

    /**
     * Verify you're on "Iguana" product page
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */

    public String validateOnIguana() {
        String result = validateWithinLocatorText(LO_LBL_PRODUCT_VERIFY, "Iguana",
                FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval(), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName());
        return result;
    }

    /**
     * Click on "Question Mark" link
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String clickQuestionMark() {
        String result = clickLocator(LO_LNK_QUESTION_MARK, FW_ConfigMgr.getDefaultTimeout());
        return result;
    }

    /**
     * Verify you're on "JPetStore Demo" page
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String validateOnDemo() {
        String result = validateWithinLocatorText(PO_LBL_DEMO_VERIFY, "JPetStore Demo",
                FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval(), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName());
        return result;
    }

    /**
     * Click on "Known Issues" link
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String clickKnownIssues() {
        String result = clickLocator(LO_LNK_KNOWN_ISSUES, FW_ConfigMgr.getDefaultTimeout());
        return result;
    }

    /**
     * Validates if current webpage is loaded and correct.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     * 
     */
    public String validateOnPage() {
        String result = validateLocatorExists(LO_LBL_Home, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    /**
     * Click Sign in button.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     * 
     */
    public String clickSignIn() {
        String result = clickLocator(LO_BUT_SIGN_IN, FW_ConfigMgr.getDefaultTimeout());
        return result;
    }

    /**
     * Validates if current webpage is loaded and correct.
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     * 
     */
    public String validateOnSignInVerify() {
        String result = validateLocatorExists(LO_LBL_SIGN_IN_VERIFY, FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName());
        return result;
    }

    /**
     * Click Register Now in button.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     * 
     */
    public String clickRegisterNow() {
        String result = clickLocator(LO_BUT_REGISTER_NOW, FW_ConfigMgr.getDefaultTimeout());
        return result;
    }

    /**
     * Verify if you're on the right page "User Information"
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */

    public String validateOnUserInfo() {
        String result = validateWithinLocatorText(LO_LBL_REGISTER_NOW_VERIFY, "User Information",
                FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval(), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName());
        return result;
    }

    /**
     * Enter user Id.
     * 
     * @param userId The text to enter in the password field.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String enterUserId(String userId) {
        String result = setText(LO_EDT_USER_ID, userId, (Integer) FW_ConfigMgr.getVarVal("defaultTimeout"), false);
        return result;
    }

    /**
     * Enter the password.
     * 
     * @param password The text to enter in the password field.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     * 
     */
    public String enterPassword(String password) {
        String result = setText(LO_EDT_PASSWORD, password, FW_ConfigMgr.getDefaultTimeout(), false);
        return result;
    }

    /**
     * Repeat the password.
     * 
     * @param repeatPassword The text to enter in the password field.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     * 
     */
    public String repeatPassword(String repeatPassword) {
        String result = setText(LO_EDT_REPEAT_PASSWORD, repeatPassword, FW_ConfigMgr.getDefaultTimeout(), false);
        return result;
    }

    /**
     * Repeat First Name.
     * 
     * @param enterFirstName The text to enter in the password field.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     * 
     */
    public String enterFirstName(String enterFirstName) {
        String result = setText(LO_EDT_FIRST_NAME, enterFirstName, FW_ConfigMgr.getDefaultTimeout(), false);
        return result;
    }

    /**
     * Enter Last Name.
     * 
     * @param enterLastName The text to enter in the password field.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     * 
     */
    public String enterLastName(String enterLastName) {
        String result = setText(LO_EDT_LAST_NAME, enterLastName, FW_ConfigMgr.getDefaultTimeout(), false);
        return result;
    }

    /**
     * Enter your Email
     * 
     * @param enterEmail The text to enter in the password field.
     * 
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     * 
     *         details.
     * 
     */
    public String enterEmail(String enterEmail) {
        String result = setText(LO_EDT_EMAIL, enterEmail, FW_ConfigMgr.getDefaultTimeout(), false);
        return result;
    }

    /**
     * Enter your Phone
     * 
     * @param enterPhone The text to enter in the password field.
     * 
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     * 
     *         details.
     * 
     */
    public String enterPhone(String enterPhone) {
        String result = setText(LO_EDT_PHONE, enterPhone, FW_ConfigMgr.getDefaultTimeout(), false);
        return result;
    }

    /**
     * Enter your Address 1
     * 
     * @param enterAddress1 The text to enter in the password field.
     * 
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     * 
     *         details.
     * 
     */
    public String enterAddress1(String enterAddress1) {
        String result = setText(LO_EDT_ADDRESS1, enterAddress1, FW_ConfigMgr.getDefaultTimeout(), false);
        return result;
    }

    /**
     * Enter your Address 2
     * 
     * @param enterAddress2 The text to enter in the password field.
     * 
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     * 
     *         details.
     * 
     */
    public String enterAddress2(String enterAddress2) {
        String result = setText(LO_EDT_ADDRESS2, enterAddress2, FW_ConfigMgr.getDefaultTimeout(), false);
        return result;
    }

    /**
     * Enter your City
     * 
     * @param enterCity The text to enter in the password field.
     * 
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     * 
     *         details.
     * 
     */
    public String enterCity(String enterCity) {
        String result = setText(LO_EDT_CITY, enterCity, FW_ConfigMgr.getDefaultTimeout(), false);
        return result;
    }

    /**
     * Enter your State
     * 
     * @param enterState The text to enter in the password field.
     * 
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     * 
     *         details.
     * 
     */
    public String enterState(String enterState) {
        String result = setText(LO_EDT_STATE, enterState, FW_ConfigMgr.getDefaultTimeout(), false);
        return result;
    }

    /**
     * Enter your Zip
     * 
     * @param enterZip The text to enter in the password field.
     * 
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     * 
     *         details.
     * 
     */
    public String enterZip(String enterZip) {
        String result = setText(LO_EDT_ZIP, enterZip, FW_ConfigMgr.getDefaultTimeout(), false);
        return result;
    }

    /**
     * Enter your Country
     * 
     * @param enterCountry The text to enter in the password field.
     * 
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     * 
     *         details.
     * 
     */
    public String enterCountry(String enterCountry) {
        String result = setText(LO_EDT_COUNTRY, enterCountry, FW_ConfigMgr.getDefaultTimeout(), false);
        return result;
    }

    /**
     * Click to select language.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     * 
     */
    public String selectLang() {
        String result = clickLocator(LO_LST_LANGUAGE, FW_ConfigMgr.getDefaultTimeout());
        return result;
    }

    /**
     * Click to tick the check box.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     * 
     */
    public String checkMyListBox() {
        String result = clickLocator(LO_CHK_MY_LIST, FW_ConfigMgr.getDefaultTimeout());
        return result;
    }

    /**
     * Click to tick the check box.
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     * 
     */
    public String checkMyBannerBox() {
        String result = clickLocator(LO_CHK_MY_BANNER, FW_ConfigMgr.getDefaultTimeout());
        return result;
    }

    /**
     * Click "Save Account Information" button
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     * 
     */
    public String clickSaveAccountInfo() {
        String result = clickLocator(LO_BUT_SAVE_AC_INFO, FW_ConfigMgr.getDefaultTimeout());
        return result;
    }

    /**
     * Verify you're on "Persian" page
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String validateOnSearchVerify() {
        String result = validateWithinLocatorText(LO_LBL_SEARCH,
                "Please enter a keyword to search for, then press the search button.",
                FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval(), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName());
        return result;
    }

    /**
     * click on "Cart" icon
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */

    public String clickOnCart() {
        String result = clickLocator(LO_IMG_CART, FW_ConfigMgr.getDefaultTimeout());
        return result;
    }

    /**
     * Click on "Fish" image
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */

    public String clickOnFish() {
        String result = clickLocator(LO_IMG_FISH, FW_ConfigMgr.getDefaultTimeout());
        return result;
    }

    /**
     * Verify you're on "Fish" page
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String validateOnFish() {
        String result = validateWithinLocatorText(LO_LBL_FISH, "Fish",
                FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval(), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName());
        return result;
    }

    /**
     * Click on "Angelfish" link
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */
    public String clickOnAngelFish() {
        String result = clickLocator(LO_LNK_ANGELFISH, FW_ConfigMgr.getDefaultTimeout());
        return result;
    }

    /**
     * Verify you're on "Angelfish" page
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */

    public String validateOnAngelFish() {
        String result = validateWithinLocatorText(LO_LBL_ANGELFISH, "Angelfish",
                FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval(), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName());
        return result;
    }

    /**
     * Click on "Add to Cart" link
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */

    public String clickAddToCart() {
        String result = clickLocator(LO_LNK_ADD_TO_CART, FW_ConfigMgr.getDefaultTimeout());
        return result;
    }

    /**
     * Verify you're on "Angelfish" page
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */

    public String validateOnFishLink() {
        String result = validateWithinLocatorText(LO_IMG_FISH, "Fish",
                FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval(), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName());
        return result;
    }

    /**
     * Verify you're on "Product Id" label
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */

    public String validateOnProductId() {
        String result = validateWithinLocatorText(LO_LBL_PRODUCT_ID, "Product ID",
                FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval(), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName());
        return result;
    }

    /**
     * Click on "Product Id" link
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */

    public String clickOnProductId() {
        String result = clickLocator(LO_LNK_PRODUCT_ID, FW_ConfigMgr.getDefaultTimeout());
        return result;
    }

    /**
     * Verify you're on "EST-3"
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */

    public String validateOnItemIdEst() {
        String result = validateWithinLocatorText(LO_LNK_ITEM_ID_EST, "EST-3",
                FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval(), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName());
        return result;
    }

    /**
     * Verify you're on "FI-SW-02"
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */

    public String validateOnFiSw() {
        String result = validateWithinLocatorText(LO_LBL_FI_SW, "FI-SW-02",
                FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval(), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName());
        return result;
    }

    /**
     * Verify you're on "Toothless Tiger"
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */

    public String validateOnToothlessTiger() {
        String result = validateWithinLocatorText(LO_LBL_TOOTHLESS_TIGER, "Toothless Tiger",
                FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval(), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName());
        return result;
    }

    /**
     * Verify Price is "$18.50"
     *
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */

    public String validateOnPrice() {
        String result = validateWithinLocatorText(LO_LBL_PRICE, "$18.50",
                FW_ConfigMgr.getDefaultTimeout(),
                FW_ConfigMgr.getDefaultInterval(), false);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName());
        return result;
    }

    /**
     * Click on "?" link
     * 
     * @return A string including [PASS] or [FAIL] along with specific result
     *         details.
     */

    public String clickOnQ() {
        String result = clickLocator(LO_LNK_Q, FW_ConfigMgr.getDefaultTimeout());
        return result;
    }

}