package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
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

    public void fillInTheFields(String firstName, String lastName, String postalCode) {
        log.info("Filling in the fields with data: '{}', '{}', '{}'", firstName, lastName, postalCode);
        chrome.findElement(FIRST_NAME_INPUT).sendKeys(firstName);
        chrome.findElement(LAST_NAME_INPUT).sendKeys(lastName);
        chrome.findElement(POSTAL_NAME_INPUT).sendKeys(postalCode);
        chrome.findElement(CONTINUE_BUTTON).click();
    }

    public String getError() {
        return chrome.findElement(ERROR_MESSAGE).getText();
    }

    public String getMessage() {
        return chrome.findElement(SUCCESSFUL_MESSAGE).getText();
    }

    public void clickFinish() {
        log.info("Pressing the finish button.");
        chrome.findElement(FINISH_BUTTON).click();
    }
}