package Java3HW6Test;

import Java3HW6.pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseTest {
    WebDriver driver;
    WebDriverWait webDriverWait;
    LoginPage loginPage;

    @BeforeAll
    static void beforeAll(){
        WebDriverManager.chromedriver().setup();
    }
    @BeforeEach
    public void setupBrowser(){
        driver = new ChromeDriver();
        webDriverWait = new WebDriverWait(driver, 5);
        loginPage = new LoginPage(driver);
    }

    @AfterEach
    void browserDown(){
        driver.quit();
    }
}
