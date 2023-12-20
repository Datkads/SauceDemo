package pages;

import io.qameta.allure.Step;
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

    @Step("Opening login page")
    public void open() {
        chrome.get(BASE_URL);
    }

    @Step("Login by {user}")
    public void login(String user, String password) {
        chrome.findElement(USERNAME_INPUT).sendKeys(user);
        chrome.findElement(PASSWORD_INPUT).sendKeys(password);
        chrome.findElement(LOGIN_BUTTON).click();
    }

    @Step("Taking expected error")
    public String getError() {
        return chrome.findElement(ERROR_MESSAGE).getText();
    }
}
