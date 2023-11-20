package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {

    WebDriver chrome;
    WebDriverWait wait;

    final String BASE_URL = "https://www.saucedemo.com/";

    BasePage(WebDriver chrome) {
        this.chrome = chrome;
        wait = new WebDriverWait(chrome, 20);
    }
}
