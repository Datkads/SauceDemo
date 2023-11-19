package tests;

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

        chrome.findElement(By.id("user-name")).sendKeys("standard_user");
        chrome.findElement(By.id("password")).sendKeys("secret_sauce");
        chrome.findElement(By.id("login-button")).click();
        chrome.findElement(By.linkText("Sauce Labs Backpack"));
        chrome.findElement(By.partialLinkText("Backpack"));

        chrome.get("https://www.saucedemo.com/");
        chrome.findElement(By.xpath("//input[@data-test='login-button']"));
        chrome.findElement(By.xpath("//h4[text()='Accepted usernames are:']"));
        chrome.findElement(By.xpath("//input[contains(@value,'Login')]"));
        chrome.findElement(By.xpath("//h4[contains(text(), 'users')]"));
        chrome.findElement(By.xpath("//*[text()='locked_out_user']//ancestor::div"));
        chrome.findElement(By.xpath("//div[@class='login_wrapper-inner']//descendant::form"));
        chrome.findElement(By.xpath("//*[text()='Accepted usernames are:']//following::br"));
        chrome.findElement(By.xpath("//input[@type='password']//parent::div[@class='form_group']"));
        chrome.findElement(By.xpath("//div[@id='login_credentials']//" +
                "preceding::div[@id='login_button_container']"));
        chrome.findElement(By.xpath("//input[@class='submit-button btn_action' and @type='submit']"));

        chrome.findElement(By.cssSelector(".login-box"));
        chrome.findElement(By.cssSelector(".submit-button.btn_action"));
        chrome.findElement(By.cssSelector(".btn_action"));
        chrome.findElement(By.cssSelector("#password"));
        chrome.findElement(By.cssSelector("form"));
        chrome.findElement(By.cssSelector("div.login_logo"));
        chrome.findElement(By.cssSelector("[placeholder='Username']"));
        chrome.get("https://www.saucedemo.com/inventory.html");
        chrome.findElement(By.cssSelector("[class~='inventory_item_label']"));
        chrome.findElement(By.cssSelector("[class|='inventory_item']"));
        chrome.findElement(By.cssSelector("a[href^='https']"));
        chrome.findElement(By.cssSelector("a[href$='.com/']"));
        chrome.findElement(By.cssSelector("a[href*='facebook']"));
    }
}

