package Java3HW6.pages;


import Java3Lesson6.pages.NavigationMenu;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BaseView {


    public NavigationMenu navigationMenu;

    public MainPage(WebDriver driver) {
        super(driver);
        navigationMenu = new NavigationMenu(driver);
    }

    @FindBy(xpath = "//a[@title='Geekbrains']")
    public WebElement buttonGeekBrainsHome;

    public By buttonGeekBrainsHomeLocator = By.xpath("//a[@title='Geekbrains']");

}
