package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.*;
import pages.CartPage;
import pages.CheckoutPage;
import pages.LoginPage;
import pages.ProductsPage;

import java.time.Duration;

@Listeners(TestListener.class)
public class BaseTest {
    WebDriver chrome;
    LoginPage loginPage;
    ProductsPage productsPage;
    CartPage cartPage;
    CheckoutPage checkoutPage;

    @Parameters({"browser"})
    @BeforeMethod(description = "Browser settings setup")
    public void setup(@Optional("chrome") String browser) {
        if(browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            chrome = new ChromeDriver();
            chrome.manage().window().maximize();
        } else if (browser.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            chrome = new EdgeDriver();
            chrome.manage().window().maximize();
        }
        chrome.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        loginPage = new LoginPage(chrome);
        productsPage = new ProductsPage(chrome);
        cartPage = new CartPage(chrome);
        checkoutPage = new CheckoutPage(chrome);
    }

    @AfterMethod(alwaysRun = true, description = "Browser shutdown")
    public void tearDown() {
        if(chrome != null) {
            chrome.quit();
        }
    }
}
