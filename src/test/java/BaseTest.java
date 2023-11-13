import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    WebDriver chrome;

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        chrome = new ChromeDriver();
        chrome.manage().window().maximize();
        chrome.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        chrome.quit();
    }
}
