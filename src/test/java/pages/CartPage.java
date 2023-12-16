package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Log4j2
public class CartPage extends BasePage {

    private final By CHECKOUT_BUTTON = By.id("checkout");

    public void isOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("checkout")));
    }

    public CartPage(WebDriver chrome) {
        super(chrome);
    }

    public void clickCheckout() {
        log.info("Pressing the checkout button.");
        chrome.findElement(CHECKOUT_BUTTON).click();
    }

    public void open() {
        chrome.get(BASE_URL + "cart.html");
    }

    public boolean isProductInTheCart(String productName) {
        log.info("Searching '{}' in the cart", productName);
        return chrome.findElement(
                By.xpath(String.format("//div[contains(text(), 'Sauce Labs Bike Light')]", productName))).isDisplayed();
    }

    public String getProductPrice(String productName) {
        log.info("Checking the price of '{}' ", productName);
        return chrome.findElement(By.xpath(String.format("//*[text()='%s']/ancestor::div[@class='cart_item']" +
                "//*[@class='inventory_item_price']", productName))).getText();
    }
}
