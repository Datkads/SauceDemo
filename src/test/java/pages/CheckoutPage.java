package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends BasePage {

    private final By FIRST_NAME_INPUT = By.id("first-name");
    private final By LAST_NAME_INPUT = By.id("last-name");
    private final By POSTAL_NAME_INPUT = By.id("postal-code");
    private final By CONTINUE_BUTTON = By.id("continue");
    private final By FINISH_BUTTON = By.id("finish");
    private final By ERROR_MESSAGE = By.cssSelector("[data-test=error]");
    private final By SUCCESSFUL_MESSAGE = By.cssSelector("[class=complete-header]");

    public CheckoutPage(WebDriver chrome) {
        super(chrome);
    }

    @Step("Finishing checkout with {firstName}, {lastName}, {postalCode} data")
    public void fillInTheFields(String firstName, String lastName, String postalCode) {
        chrome.findElement(FIRST_NAME_INPUT).sendKeys(firstName);
        chrome.findElement(LAST_NAME_INPUT).sendKeys(lastName);
        chrome.findElement(POSTAL_NAME_INPUT).sendKeys(postalCode);
        chrome.findElement(CONTINUE_BUTTON).click();
    }

    @Step("Taking expected error")
    public String getError() {
        return chrome.findElement(ERROR_MESSAGE).getText();
    }

    @Step("Taking expected successful message")
    public String getMessage() {
        return chrome.findElement(SUCCESSFUL_MESSAGE).getText();
    }

    @Step("Pressing the FINISH button")
    public void clickFinish() {
        chrome.findElement(FINISH_BUTTON).click();
    }
}