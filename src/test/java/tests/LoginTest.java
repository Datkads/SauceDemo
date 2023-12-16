package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class LoginTest extends BaseTest {

    @Test(description = "Check standard user login(successful login)")
    public void successfulLogin() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        assertEquals(productsPage.getTitle(), "Products",
                "User is not logged in, or wrong page is opened.");
    }

    @DataProvider
    public Object[][] loginData() {
        return new Object[][] {
                {"", "", "Epic sadface: Username is required"},
                {"standard_user", "", "Epic sadface: Password is required"},
                {"locked_out_user", "secret_sauce", "Epic sadface: Sorry, this user has been locked out."},
        };
    }

    @Test(dataProvider = "loginData", description = "Parameterized testing")
    public void negativeLogin(String user, String password, String expectedError) {
        loginPage.open();
        loginPage.login(user, password);
        assertEquals(loginPage.getError(), expectedError, "Wrong message");
    }

    @Test(description = "Try empty Fields Login")
    public void emptyFieldsLogin() {
        loginPage.open();
        loginPage.login("", "");
        assertEquals(loginPage.getError(), "Epic sadface: Username is required", "Wrong message");
    }

    @Test(description = "Check empty password login")
    public void emptyPasswordFieldLogin() {
        loginPage.open();
        loginPage.login("standard_user", "");
        assertEquals(loginPage.getError(), "Epic sadface: Password is required", "Wrong message");
    }

    @Test(description = "Try locked user login")
    public void lockedUserLogin() {
        loginPage.open();
        loginPage.login("locked_out_user", "secret_sauce");
        assertEquals(loginPage.getError(), "Epic sadface: Sorry, this user has been locked out.",
                "Wrong message");
    }
}
