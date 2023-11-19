package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {

    private final By CHECKOUT_BUTTON = By.id("remove-sauce-labs-backpack");

    public CartPage(WebDriver chrome) {
        super(chrome);
    }

    public void open() {
        chrome.get(BASE_URL + "cart.html");
    }

    public boolean isProductInTheCart(String productName) {
        return chrome.findElement(
                By.xpath(String.format("//div[contains(text(), 'Sauce Labs Bike Light')]", productName))).isDisplayed();
    }

    public String getProductPrice() {
        return chrome.findElement(By.cssSelector(".inventory_item_price")).getText();
    }
}
