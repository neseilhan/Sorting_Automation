package dev.neseilhan.sortingautomation.pages;

import dev.neseilhan.sortingautomation.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
/**
 * Page Object representing the Login page.
 *
 * <p>Handles:
 * - Login form interactions
 * - Page validation</p>
 *
 * Uses Page Object Model design pattern.
 *
 * @author Nese Ilhan
 * @version 1.0
 */
public class LoginPage extends BasePage {

    private final By usernameInput = By.cssSelector("[data-test='username']");
    private final By passwordInput = By.cssSelector("[data-test='password']");
    private final By loginButton = By.cssSelector("[data-test='login-button']");
    private final By loginLogo = By.xpath("//div[@class='login_logo' and text()='Swag Labs']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Opens the login page URL.
     *
     * @param url application URL
     */
    public void open(String url) {
        driver.get(url);
    }

    /**
     * Checks whether login page is loaded.
     *
     * @return true if login page is visible
     */
    public boolean isLoginPageLoaded() {
        return waitForVisibility(loginLogo).isDisplayed();
    }

    /**
     * Enters username.
     *
     * @param username user name
     */
    public void enterUsername(String username) {
        type(usernameInput, username);
    }

    /**
     * Enters password.
     *
     * @param password user password
     */
    public void enterPassword(String password) {
        type(passwordInput, password);
    }

    /**
     * Clicks login button.
     */
    public void clickLogin() {
        click(loginButton);
    }

    /**
     * Performs login and navigates to inventory page.
     *
     * @param username username
     * @param password password
     * @return InventoryPage instance
     */
    public InventoryPage loginAs(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLogin();
        return new InventoryPage(driver);
    }
}