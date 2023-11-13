import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ProductTest extends BaseTest {

    @Test
    public void buyProduct() {
        chrome.get("https://www.saucedemo.com/");
        chrome.findElement(By.id("user-name")).sendKeys("standard_user");
        chrome.findElement(By.id("password")).sendKeys("secret_sauce");
        chrome.findElement(By.id("login-button")).click();
        chrome.findElement(By.xpath("//*[text()='Sauce Labs Bike Light']//ancestor:" +
                ":*[@class='inventory_item']//button")).click();
        chrome.findElement(By.id("shopping_cart_container")).click();
        String productName = chrome.findElement(By.cssSelector(".inventory_item_name")).getText();
        String productPrice = chrome.findElement(By.cssSelector(".inventory_item_price")).getText();

        assertEquals(productPrice, "$9.99", "Wrong price or amount is not displayed");
        assertEquals(productName, "Sauce Labs Bike Light",
                "Wrong product has been added in to the cart");
    }
}