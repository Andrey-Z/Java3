package Java3HW3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class CrmCreateContacts {

    private static WebDriver driver;
    private static final String LOGIN_PAGE_URL = "https://crm.geekbrains.space/user/login";


    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);

        login();

        Actions actions = new Actions(driver);
        WebElement counterAgents = driver.findElement(By.xpath("//span[text()='Контрагенты']//ancestor::a"));
        actions.moveToElement(counterAgents).perform(); //после описания действия, команда "выполнить"(perform)

        driver.findElement(By.xpath("//span[text()='Контактные лица']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[text()='Создать контактное лицо']")).click();

        driver.findElement((By.xpath("//input[@name='crm_contact[lastName]']"))).sendKeys("Ivanov");
        driver.findElement((By.xpath("//input[@name='crm_contact[firstName]']"))).sendKeys("Petr");
        driver.findElement((By.xpath("//input[@name='crm_contact[middleName]']"))).sendKeys("Andreev");

        driver.findElement(By.xpath("//input[@placeholder='Укажите дату']")).click();
        driver.findElement(By.xpath("//select[@data-handler='selectMonth']/option[7]")).click();
        driver.findElement(By.xpath("//select[@data-handler='selectYear']/option[49]")).click();
        driver.findElement(By.xpath("//a[text()='27']")).click();


        driver.findElement(By.xpath("//select[@name='crm_contact[birthdayRemindBefore]']/option[2]")).click();

        driver.findElement(By.xpath("//span[text()='Укажите организацию']/..")).click();
        driver.findElement(By.xpath("//input[@class='select2-input select2-focused']")).sendKeys("Test_from_GB");
        driver.findElement(By.xpath("//input[@class='select2-input select2-focused']")).sendKeys(Keys.ENTER);

        driver.findElement(By.xpath("//input[@name='crm_contact[jobTitle]']")).sendKeys("Director");
        driver.findElement(By.xpath("//input[@name='crm_contact[companyBusinessUnit]']")).sendKeys("Alpha");
        driver.findElement(By.xpath("//input[@name='crm_contact[department]']")).sendKeys("Criminal");
        driver.findElement(By.xpath("//input[@name='crm_contact[supervisor]']")).sendKeys("John.Smith");
        driver.findElement(By.xpath("//input[@name='crm_contact[alternate]']")).sendKeys("Angelina.Jolie");

        driver.findElement(By.xpath("//a[text()='Добавить телефон']")).click();
        driver.findElement(By.xpath("//select[@name='crm_contact[phones][1][type]']/option[4]")).click();
        driver.findElement(By.xpath("//input[@name='crm_contact[phones][1][prefixCode]']")).sendKeys("913");
        driver.findElement(By.xpath("//input[@name='crm_contact[phones][1][phone]']")).sendKeys("1234567");
        driver.findElement(By.xpath("//input[@name='crm_contact[phones][1][internalCode]']")).sendKeys("Доб.3");

        driver.findElement(By.xpath("//input[@name='crm_contact[email]']")).sendKeys("123@mail.ru");


        driver.findElement(By.xpath("//select[@name='crm_contact[status]']/option[6]")).click();
        driver.findElement(By.xpath("//button[contains(@class,'btn btn-success action-button')]")).click();


        Thread.sleep(7000);
        driver.quit();
    }

    private static void login() {
        driver.get(LOGIN_PAGE_URL);
        driver.findElement(By.id("prependedInput")).sendKeys("Applanatest1");
        driver.findElement(By.id("prependedInput2")).sendKeys("Student2020!");
        driver.findElement(By.id("_submit")).click();
    }
}
