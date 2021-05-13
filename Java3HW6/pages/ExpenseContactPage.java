package Java3HW6.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ExpenseContactPage extends BaseView{

    public ExpenseContactPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[text()='Создать контактное лицо']")
        public WebElement createContactButton;
}
