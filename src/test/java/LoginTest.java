import org.openqa.selenium.By;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTest {

    @Test
    public void successfulLogin() {
        chrome.get("https://www.saucedemo.com/");
        chrome.findElement(By.id("user-name")).sendKeys("standard_user");
        chrome.findElement(By.id("password")).sendKeys("secret_sauce");
        chrome.findElement(By.id("login-button")).click();
        String title = chrome.findElement(By.cssSelector(".title")).getText();
        assertEquals(title, "Products", "User is not logged in, or wrong page is opened.");
    }

    @Test
    public void emptyFieldsLogin() {
        chrome.get("https://www.saucedemo.com/");
        chrome.findElement(By.id("login-button")).click();
        boolean error = chrome.findElement(By.cssSelector("[data-test=error]")).isDisplayed();
        assertTrue(error, "Error message is not displayed.");
    }

    @Test
    public void emptyPasswordFieldLogin() {
        chrome.get("https://www.saucedemo.com/");
        chrome.findElement(By.id("user-name")).sendKeys("standard_user");
        chrome.findElement(By.id("login-button")).click();
        boolean error = chrome.findElement(By.cssSelector("[data-test=error]")).isDisplayed();
        assertTrue(error, "Error message is not displayed.");
    }

    @Test
    public void lockedUserLogin() {
        chrome.get("https://www.saucedemo.com/");
        chrome.findElement(By.id("user-name")).sendKeys("locked_out_user");
        chrome.findElement(By.id("password")).sendKeys("secret_sauce");
        chrome.findElement(By.id("login-button")).click();
        boolean error = chrome.findElement(By.cssSelector("[data-test=error]")).isDisplayed();
        assertTrue(error, "Error message is not displayed.");
    }
}
