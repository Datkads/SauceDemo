package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {

    private final String PRODUCT_NAME_PATTERN = "//*[text()='%s']";
    private final String PRODUCT_PRICE_PATTERN = "//*[text()='%s']";
    private final By CHECKOUT_BUTTON = By.id("remove-sauce-labs-backpack");

    public CartPage(WebDriver chrome) {
        super(chrome);
    }

    public void open() {
        chrome.get(BASE_URL + "cart.html");
    }

    public String getProductName(String productName) {
        By name = By.xpath(String.format(PRODUCT_NAME_PATTERN, productName));
        return chrome.findElement(name).getText();
    }

    public String getProductPrice(String productPrice) {
        By price = By.xpath(String.format(PRODUCT_PRICE_PATTERN, productPrice));
        return chrome.findElement(price).getText();
    }
}

