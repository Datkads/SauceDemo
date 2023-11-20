package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ProductTest extends BaseTest {

    @Test
    public void buyProduct() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addToCart("Sauce Labs Bike Light");
        productsPage.openCart();
        cartPage.isOpened();
        assertTrue(cartPage.isProductInTheCart("Sauce Labs Bike Light"), "Item is not in a cart.");
        assertEquals(cartPage.getProductPrice("Sauce Labs Bike Light"),
                "$9.99", "Wrong price of the item.");
    }
}