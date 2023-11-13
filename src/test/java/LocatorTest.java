import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class LocatorTest extends BaseTest {

    @Test
    public void locatorsChecks() {
        chrome.get("https://www.saucedemo.com/");
        chrome.findElement(By.id("login-button"));
        chrome.findElement(By.name("login-button"));
        chrome.findElement(By.className("submit-button"));
        chrome.findElement(By.tagName("input"));

        chrome.findElement(By.xpath("//input[@data-test='login-button']"));
        chrome.findElement(By.xpath("//h4[text()='Accepted usernames are:']"));
        chrome.findElement(By.xpath("//input[contains(@value,'Login')]"));
        chrome.findElement(By.xpath("//h4[contains(text(), 'users')]"));
        chrome.findElement(By.xpath("//*[text()='locked_out_user']//ancestor::div"));
        chrome.findElement(By.xpath("//div[@class='login_wrapper-inner']//descendant::form"));
        chrome.findElement(By.xpath("//*[text()='Accepted usernames are:']//following::br"));
        chrome.findElement(By.xpath("//input[@type='password']//parent::div[@class='form_group']"));
        chrome.findElement(By.xpath("//div[@id='login_credentials']//preceding::div[@id='login_button_container']"));

        chrome.findElement(By.cssSelector("[data-test='login-button']"));
        chrome.findElement(By.cssSelector("[class='submit-button btn_action']"));
    }
}
