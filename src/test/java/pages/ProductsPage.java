package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductsPage extends BasePage {

    private final By TITLE = By.cssSelector(".title");
    private final String ADD_TO_CART_PATTERN = "//*[text()='%s']//ancestor::*[@class='inventory_item']//button";
    private final By CART_LINK = By.id("shopping_cart_container");

    public ProductsPage(WebDriver chrome) {
        super(chrome);
    }

    @Step("Opening the products page")
    public void open() {
        chrome.get(BASE_URL + "inventory.html");
    }

    @Step("Checking if we are on the products page")
    public String getTitle() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(TITLE));
        return chrome.findElement(TITLE).getText();
    }

    @Step("Adding a product to the cart")
    public void addToCart(String product) {
        By addToCartButton = By.xpath(String.format(ADD_TO_CART_PATTERN, product));
        chrome.findElement(addToCartButton).click();
    }

    @Step("Proceeding to the cart")
    public void openCart() {
        chrome.findElement(CART_LINK).click();
    }
}
