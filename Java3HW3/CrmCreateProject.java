package Java3HW3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class CrmCreateProject {
    private static WebDriver driver;
    private static final String LOGIN_PAGE_URL = "https://crm.geekbrains.space/user/login";

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);

        login();

        Actions actions = new Actions(driver);
        WebElement projectMenuIcon = driver.findElement(By.xpath("//span[text()='Проекты']/ancestor::a"));
        actions.moveToElement(projectMenuIcon).perform();

        driver.findElement(By.xpath("//span[text()='Все проекты']")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//a[text()='Создать проект']")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//input[@name='crm_project[name]']")).sendKeys("MyFirstCorporation");

        driver.findElement(By.xpath("//span[text()='Укажите организацию']/..")).click();
        driver.findElement(By.xpath("//input[@class='select2-input select2-focused']")).sendKeys("Test_from_GB");
        driver.findElement(By.xpath("//input[@class='select2-input select2-focused']")).sendKeys(Keys.ENTER);

        driver.findElement(By.xpath("//textarea[@name='crm_project[uniqueDescription]']")).sendKeys("5 из 5.");
        driver.findElement(By.xpath("//textarea[@name='crm_project[uniqueDescription]']")).sendKeys(Keys.ENTER);
        driver.findElement(By.xpath("//textarea[@name='crm_project[uniqueDescription]']")).sendKeys("Уважение.");
        driver.findElement(By.xpath("//textarea[@name='crm_project[uniqueDescription]']")).sendKeys(Keys.ENTER);
        driver.findElement(By.xpath("//textarea[@name='crm_project[uniqueDescription]']")).sendKeys("Надёжность.");
        driver.findElement(By.xpath("//textarea[@name='crm_project[uniqueDescription]']")).sendKeys(Keys.ENTER);
        driver.findElement(By.xpath("//textarea[@name='crm_project[uniqueDescription]']")).sendKeys("Постоянство.");
        driver.findElement(By.xpath("//textarea[@name='crm_project[uniqueDescription]']")).sendKeys(Keys.ENTER);


        driver.findElement(By.xpath("//input[@data-name='field__1']")).click();

        driver.findElement(By.xpath("//select[@name='crm_project[priority]']/option[4]")).click();
        driver.findElement(By.xpath("//select[@name='crm_project[financeSource]']/option[2]")).click();
        driver.findElement(By.xpath("//select[@name='crm_project[businessUnit]']/option[2]")).click();

        driver.findElement(By.xpath("//select[@name='crm_project[curator]']/option[9]")).click();
        driver.findElement(By.xpath("//select[@name='crm_project[rp]']/option[7]")).click();
        driver.findElement(By.xpath("//select[@name='crm_project[administrator]']/option[12]")).click();
        driver.findElement(By.xpath("//select[@name='crm_project[manager]']/option[15]")).click();

        driver.findElement(By.xpath("//input[@id='s2id_autogen2']")).click();
        driver.findElement(By.xpath("//input[@id='s2id_autogen2']")).sendKeys("Биллинг");
        driver.findElement(By.xpath("//input[@class='select2-input select2-focused']")).sendKeys(Keys.ENTER);

        Thread.sleep(1000);
        Select selectContact = new Select(driver.findElement(By.name("crm_project[contactMain]")));
        selectContact.selectByVisibleText("Smith John");

        driver.findElement(By.xpath("//input[@id='s2id_autogen4']")).click();
        driver.findElement(By.xpath("//input[@id='s2id_autogen4']")).sendKeys("Ivanov Ivan");
        driver.findElement(By.xpath("//input[@class='select2-input select2-focused']")).sendKeys(Keys.ENTER);

        driver.findElement(By.xpath("//a[contains(text(),'Добавить адрес')]")).click();
        driver.findElement(By.xpath("//input[@data-ftid='crm_project_addresses_1_search']")).sendKeys("127018, г Москва, ул Советской Армии, д 21, кв 15");
        driver.findElement(By.xpath("//a[@data-fias='fed18d75-b7f6-46ca-ab5f-3ce32ea358b0']")).click();


        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@id,'planning')]"))); // находим iframe
        driver.findElement(By.xpath("//body")).sendKeys("Планирование");


        driver.switchTo().defaultContent();

        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@id,'requirementsManagement')]")));
        driver.findElement(By.xpath("//body")).sendKeys("Управление требованиями");

        driver.switchTo().defaultContent();


        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@id,'development')]")));
        driver.findElement(By.xpath("//body")).sendKeys("Разработка");

        driver.switchTo().defaultContent();


        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@id,'testing')]")));
        driver.findElement(By.xpath("//body")).sendKeys("Тестирование");

        driver.switchTo().defaultContent();

        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@id,'other')]")));
        driver.findElement(By.xpath("//body")).sendKeys("Прочее");

        driver.switchTo().defaultContent();

        driver.findElement(By.xpath("//input[@name='crm_project[configManagement]']")).sendKeys("Управление конфигурацией успешно");
        driver.findElement(By.xpath("//input[@name='crm_project[sharedFolder]']")).sendKeys("/geekbrains/space");

        driver.findElement(By.xpath("//select[@name='crm_project[msProjectPlan]']/option[6]")).click();

        driver.findElement(By.xpath("//input[@data-name='field__skip-speed-checks']")).click();

        driver.findElement(By.xpath("//select[@name='crm_project[reportInterval]']/option[4]")).click();

        Thread.sleep(2000);

        driver.findElement(By.xpath("//*[@id='s2id_autogen5']")).click();


        driver.findElement(By.xpath("//*[@id='s2id_autogen5']")).sendKeys("Доработка и тестирование корпоративного сайта");
        driver.findElement(By.xpath("//input[@class='select2-input select2-focused']")).sendKeys(Keys.ENTER);

        driver.findElement(By.xpath("//*[@id='s2id_autogen6']")).click();

        driver.findElement(By.xpath("//*[@id='s2id_autogen6']")).sendKeys("№23455");
        driver.findElement(By.xpath("//input[@class='select2-input select2-focused']")).sendKeys(Keys.ENTER);

        driver.findElement(By.xpath("//button[contains(text(),'Сохранить и закрыть')]")).click();


        //Thread.sleep(10000);
        //driver.quit();


    }

    private static void login() {
        driver.get(LOGIN_PAGE_URL);
        driver.findElement(By.id("prependedInput")).sendKeys("Applanatest1");
        driver.findElement(By.id("prependedInput2")).sendKeys("Student2020!");
        driver.findElement(By.id("_submit")).click();
    }
}


