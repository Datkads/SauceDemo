package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Log4j2
public class ProductsPage extends BasePage {

    private final By TITLE = By.cssSelector(".title");
    private final String ADD_TO_CART_PATTERN = "//*[text()='%s']//ancestor::*[@class='inventory_item']//button";
    private final By CART_LINK = By.id("shopping_cart_container");

    public ProductsPage(WebDriver chrome) {
        super(chrome);
    }

    public void open() {
        chrome.get(BASE_URL + "inventory.html");
    }

    public String getTitle() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(TITLE));
        return chrome.findElement(TITLE).getText();
    }

    public void addToCart(String product) {
        log.info("Adding '{}' to cart", product);
        By addToCartButton = By.xpath(String.format(ADD_TO_CART_PATTERN, product));
        chrome.findElement(addToCartButton).click();
    }

    public void openCart() {
        chrome.findElement(CART_LINK).click();
    }
}
