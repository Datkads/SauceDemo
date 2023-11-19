package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    private final By USERNAME_INPUT = By.id("user-name");
    private final By PASSWORD_INPUT = By.id("password");
    private final By LOGIN_BUTTON = By.id("login-button");
    private final By ERROR_MESSAGE = By.cssSelector("[data-test=error]");

    public LoginPage(WebDriver chrome) {
        super(chrome);
    }

    public void open() {
        chrome.get(BASE_URL);
    }

    public void login(String user, String password) {
        chrome.findElement(USERNAME_INPUT).sendKeys(user);
        chrome.findElement(PASSWORD_INPUT).sendKeys(password);
        chrome.findElement(LOGIN_BUTTON).click();
    }

    public String getError() {
        return chrome.findElement(ERROR_MESSAGE).getText();
    }
}
