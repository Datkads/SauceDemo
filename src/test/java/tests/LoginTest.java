package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class LoginTest extends BaseTest {

    @Test
    public void successfulLogin() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        assertEquals(productsPage.getTitle(), "Products",
                "User is not logged in, or wrong page is opened.");
    }

    @Test
    public void emptyFieldsLogin() {
        loginPage.open();
        loginPage.login("", "");
        assertEquals(loginPage.getError(), "Epic sadface: Username is required", "Wrong message");
    }

    @Test
    public void emptyPasswordFieldLogin() {
        loginPage.open();
        loginPage.login("standard_user", "");
        assertEquals(loginPage.getError(), "Epic sadface: Password is required", "Wrong message");
    }

    @Test
    public void lockedUserLogin() {
        loginPage.open();
        loginPage.login("locked_out_user", "secret_sauce");
        assertEquals(loginPage.getError(), "Epic sadface: Sorry, this user has been locked out.",
                "Wrong message");
    }
}

