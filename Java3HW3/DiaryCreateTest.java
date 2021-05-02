package Java3HW3;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DiaryCreateTest {
    
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://diary.ru");
        Cookie sessionCookie = driver.manage().getCookieNamed("PHPSESSID");
        driver.manage().deleteCookie(sessionCookie);
        Cookie cookie = new Cookie("PHPSESSID", "hiedlbq6q6dav3d2ih2e0bd4ft");
        driver.manage().addCookie(cookie);
        driver.navigate().refresh();
        Thread.sleep(5000);
        //driver.close();

        driver.findElement(By.xpath("//span[@class='i-menu-dis']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[text()='Почтовые уведомления']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@id='mailform-notify_bd_fav']")).click();
        driver.findElement(By.xpath("//input[@id='mailform-notify_bd_pch']")).click();
        driver.findElement(By.xpath("//*[@id='mailform-email_umail']/label[2]/input")).click(); //короче, чем этот и 2 ниже xpath не нашел, пришлось воспользоваться xpath от chrome)
        driver.findElement(By.xpath("//*[@id='mailform-email_notification']/label[2]/input")).click();
        driver.findElement(By.xpath("//*[@id='mailform-email_on_comments']/label[1]/input")).click();
        driver.findElement(By.xpath("//button[@id='btn_submit_mail']")).click();

        driver.get("https://diary.ru/discussion");
        driver.findElement(By.xpath("//input[@name='daysnum']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@name='daysnum']")).sendKeys(Keys.CONTROL + "A");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@name='daysnum']")).sendKeys(Keys.DELETE);
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@name='daysnum']")).sendKeys("77");
        driver.findElement(By.xpath("//input[@id='ch_all']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[@id='drop_right_menu']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[text()='Выход']")).click();

        Thread.sleep(5000);
        driver.quit();

    }
}