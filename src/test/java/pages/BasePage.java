package pages;

import org.openqa.selenium.WebDriver;

public abstract class BasePage {

    WebDriver chrome;

    final String BASE_URL = "https://www.saucedemo.com/";

    BasePage(WebDriver chrome) {
        this.chrome = chrome;
    }
}
