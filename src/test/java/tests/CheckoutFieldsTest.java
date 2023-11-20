package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CheckoutFieldsTest extends BaseTest {

    @Test
    public void emptyFieldsCheck() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.openCart();
        cartPage.clickCheckout();
        checkoutPage.fillInTheFields("", "", "");
        assertEquals(checkoutPage.getError(),
                "Error: First Name is required",
                "Wrong message or not reflected");
    }

    @Test
    public void emptyLastNameCheck() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.openCart();
        cartPage.clickCheckout();
        checkoutPage.fillInTheFields("David", "", "");
        assertEquals(checkoutPage.getError(),
                "Error: Last Name is required",
                "Wrong message or not reflected");
    }

    @Test
    public void emptyPostalCodeCheck() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.openCart();
        cartPage.clickCheckout();
        checkoutPage.fillInTheFields("David", "Gelenidze", "");
        assertEquals(checkoutPage.getError(),
                "Error: Postal Code is required",
                "Wrong message or not reflected");
    }

    @Test
    public void successfulCheckout() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.openCart();
        cartPage.clickCheckout();
        checkoutPage.fillInTheFields("David", "Gelenidze", "123456");
        checkoutPage.clickFinish();
        assertEquals(checkoutPage.getMessage(),
                "Thank you for your order!",
                "Wrong message or not reflected");
    }
}
