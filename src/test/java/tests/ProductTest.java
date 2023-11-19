package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ProductTest extends BaseTest {

    @Test
    public void buyProduct() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addToCart("Sauce Labs Bike Light");
        productsPage.openCart();
        assertEquals(cartPage.getProductName("Sauce Labs Bike Light"), "Sauce Labs Bike Light",
                "Wrong price or amount is not displayed");
        assertEquals(cartPage.getProductPrice("9.99"), "$9.99",
                "Wrong product has been added in to the cart");
    }
}