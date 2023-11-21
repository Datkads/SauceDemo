package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CartPage extends BasePage {

    private final By CHECKOUT_BUTTON = By.id("checkout");

    public void isOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("checkout")));
    }

    public CartPage(WebDriver chrome) {
        super(chrome);
    }

    public void clickCheckout() {
        chrome.findElement(CHECKOUT_BUTTON).click();
    }

    public void open() {
        chrome.get(BASE_URL + "cart.html");
    }

    public boolean isProductInTheCart(String productName) {
        return chrome.findElement(
                By.xpath(String.format("//div[contains(text(), 'Sauce Labs Bike Light')]", productName))).isDisplayed();
    }

    public String getProductPrice(String productName) {
        return chrome.findElement(By.xpath(String.format("//*[text()='%s']/ancestor::div[@class='cart_item']" +
                "//*[@class='inventory_item_price']", productName))).getText();
    }
}
