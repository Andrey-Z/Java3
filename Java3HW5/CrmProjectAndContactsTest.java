package Java3HW5Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

public class CrmProjectAndContactsTest {

    private static WebDriver driver;
    private static final String BASE_URL = "https://crm.geekbrains.space/user/login";
    private static WebDriverWait webDriverWait;

    @BeforeSuite
    @DisplayName("Будет выполняться перед всеми тестами")
    void setupDataBase() {
        System.out.println("Выполняется перед всеми тестами");
    }

    @BeforeTest
    void setUp() {
        WebDriverManager.chromedriver().setup();
        System.out.println("Выполняется перед всеми тестами, но после @BeforeSuite при его наличии");
    }

    @BeforeMethod
    void openBrowser() {
        System.out.println("Выполняется перед каждым тестом");
        driver = new ChromeDriver();
        webDriverWait = new WebDriverWait(driver, 5);
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        driver.get(BASE_URL);
        login();

    }

    @Test(description = "Создание проекта", enabled = true)
    @DisplayName("Начало теста")
    void crmTest1() throws InterruptedException {
        Actions actions = new Actions(driver);
        WebElement projectMenuIcon = driver.findElement(By.xpath("//span[text()='Проекты']/ancestor::a"));
        assertThat(projectMenuIcon.getText(), containsString("Проекты"));
        actions.moveToElement(projectMenuIcon).perform();


        driver.findElement(By.xpath("//span[text()='Все проекты']")).click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Все проекты']")));


        driver.findElement(By.xpath("//a[text()='Создать проект']")).click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='Создать проект']")));


        WebElement newProject = driver.findElement(By.xpath("//h5[span='Основная информация']"));
        assertThat(newProject.getText(), containsString("Основная информация"));

        driver.findElement(By.xpath("//input[@name='crm_project[name]']")).sendKeys("MySecondCorporation");
        driver.findElement(By.xpath("//span[text()='Укажите организацию']/..")).click();
        driver.findElement(By.xpath("//input[@class='select2-input select2-focused']")).sendKeys("Test_from_GB");
        driver.findElement(By.xpath("//input[@class='select2-input select2-focused']")).sendKeys(Keys.ENTER);

        Select crmPriority = new Select(driver.findElement(By.name("crm_project[priority]")));
        crmPriority.selectByVisibleText("Высокий");
        Select crmFinance = new Select(driver.findElement(By.name("crm_project[financeSource]")));
        crmFinance.selectByVisibleText("Из средств заказчика");
        Select crmBusiness = new Select(driver.findElement(By.name("crm_project[businessUnit]")));
        crmBusiness.selectByVisibleText("Research & Development");
        Select crmCurator = new Select(driver.findElement(By.name("crm_project[curator]")));
        crmCurator.selectByVisibleText("Ким Юрий");
        Select crmRp = new Select(driver.findElement(By.name("crm_project[rp]")));
        crmRp.selectByVisibleText("Андреев Сергей");
        Select crmAdmin = new Select(driver.findElement(By.name("crm_project[administrator]")));
        crmAdmin.selectByVisibleText("Ломакина Ксения");
        Select crmManager = new Select(driver.findElement(By.name("crm_project[manager]")));
        crmManager.selectByVisibleText("Митрофанов Никита");
        Select selectContact = new Select(driver.findElement(By.name("crm_project[contactMain]")));
        selectContact.selectByVisibleText("Smith John");

        driver.findElement(By.xpath("//input[@id='s2id_autogen4']")).click();
        driver.findElement(By.xpath("//input[@id='s2id_autogen4']")).sendKeys("Ivanov Ivan");
        driver.findElement(By.xpath("//input[@class='select2-input select2-focused']")).sendKeys(Keys.ENTER);

        driver.findElement(By.xpath("//a[contains(text(),'Добавить адрес')]")).click();
        driver.findElement(By.xpath("//input[@data-ftid='crm_project_addresses_1_search']")).sendKeys("127018, г Москва, ул Советской Армии, д 21, кв 15");
        driver.findElement(By.xpath("//a[@data-fias='fed18d75-b7f6-46ca-ab5f-3ce32ea358b0']")).click();

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@data-fias='fed18d75-b7f6-46ca-ab5f-3ce32ea358b0']")));
        // iframes
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@id,'planning')]")));
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

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='crm_project[sharedFolder]']")));

        Select msProjectPlan = new Select(driver.findElement(By.name("crm_project[msProjectPlan]")));
        msProjectPlan.selectByVisibleText("Проект 5");

        driver.findElement(By.xpath("//input[@data-name='field__skip-speed-checks']")).click();

        Select reportInterval = new Select(driver.findElement(By.name("crm_project[reportInterval]")));
        reportInterval.selectByVisibleText("Ежеквартально");

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='s2id_autogen5']")));

        driver.findElement(By.xpath("//*[@id='s2id_autogen5']")).click();


        driver.findElement(By.xpath("//*[@id='s2id_autogen5']")).sendKeys("Доработка и тестирование корпоративного сайта");
        driver.findElement(By.xpath("//input[@class='select2-input select2-focused']")).sendKeys(Keys.ENTER);

        driver.findElement(By.xpath("//*[@id='s2id_autogen6']")).click();

        driver.findElement(By.xpath("//*[@id='s2id_autogen6']")).sendKeys("№23455");
        driver.findElement(By.xpath("//input[@class='select2-input select2-focused']")).sendKeys(Keys.ENTER);

        driver.findElement(By.xpath("//button[contains(text(),'Сохранить и закрыть')]")).click();

        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Проект сохранен']")));

        driver.findElement(By.xpath("//*[text()='Проект сохранен']"));

        WebElement projectSave = driver.findElement(By.xpath("//*[text()='Проект сохранен']"));
        assertThat(projectSave.getText(), containsString("Проект сохранен"));

    }

    @Test(description = "Новый контакт", enabled = true)
    @DisplayName("Создание контакта")
    void crmTest2() throws InterruptedException {

        Actions actions = new Actions(driver);
        WebElement counterAgents = driver.findElement(By.xpath("//span[text()='Контрагенты']//ancestor::a"));
        actions.moveToElement(counterAgents).perform();

        driver.findElement(By.xpath("//span[text()='Контактные лица']")).click();
        //Thread.sleep(3000);
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='Создать контактное лицо']")));
        driver.findElement(By.xpath("//a[text()='Создать контактное лицо']")).click();


        WebElement newContact = driver.findElement(By.xpath("//h5[span='Сведения']"));
        assertThat(newContact.getText(), containsString("Сведения"));

        driver.findElement((By.xpath("//input[@name='crm_contact[lastName]']"))).sendKeys("Ivanov");
        driver.findElement((By.xpath("//input[@name='crm_contact[firstName]']"))).sendKeys("Petr");
        driver.findElement((By.xpath("//input[@name='crm_contact[middleName]']"))).sendKeys("Andreev");

        driver.findElement(By.xpath("//span[text()='Укажите организацию']/..")).click();
        driver.findElement(By.xpath("//input[@class='select2-input select2-focused']")).sendKeys("Test_from_GB");
        driver.findElement(By.xpath("//input[@class='select2-input select2-focused']")).sendKeys(Keys.ENTER);

        driver.findElement(By.xpath("//input[@name='crm_contact[jobTitle]']")).sendKeys("Director");

        Select statusContact = new Select(driver.findElement(By.name("crm_contact[status]")));
        statusContact.selectByVisibleText("Неактивный");


        driver.findElement(By.xpath("//button[@data-action='{\"route\":\"crm_contact_view\",\"params\":{\"id\":\"$id\"}}']")).click();

        WebElement contactSave = driver.findElement(By.xpath("//div[@class='flash-messages-holder']"));
        assertThat(contactSave.getText(), containsString("Контактное лицо сохранено"));
    }


    private static void login() {
        driver.findElement(By.id("prependedInput")).sendKeys("Applanatest1");
        driver.findElement(By.id("prependedInput2")).sendKeys("Student2020!");
        driver.findElement(By.id("_submit")).click();
    }

    @AfterMethod
    @DisplayName("Выполняется после тестов")
    void closeBrowser() {
        //driver.quit();
    }


}
