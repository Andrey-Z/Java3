package Java3HW6.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BaseView {



    @FindBy(id = "prependedInput" )
    public WebElement inputLogin;

    @FindBy(id = "prependedInput2" )
    public WebElement inputPassword;

    @FindBy(id = "_submit" )
    public WebElement buttonSubmit;

    public LoginPage(WebDriver driver) {
        super(driver);
    }


    public LoginPage fillInputLogin(String login){
        inputLogin.sendKeys(login);
        return this;
    }

    public LoginPage fillInputPassword(String passwords){
        inputPassword.sendKeys(passwords);
        return this;
    }

    public MainPage submitLogin(){
        buttonSubmit.click();
        return new MainPage(driver);
    }

    public MainPage login(String login, String password) {
        inputLogin.sendKeys(login);
        inputPassword.sendKeys(password);
        buttonSubmit.click();
        webDriverWait.until(ExpectedConditions.
                presenceOfElementLocated(new MainPage(driver).buttonGeekBrainsHomeLocator));
        return new MainPage(driver);
    }

}
