package Java3HW6.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CreateContactRequestPage extends BaseView {
    public CreateContactRequestPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(name = "crm_contact[lastName]")
    public WebElement requestLastName;

    public CreateContactRequestPage fillLastName(String LastName) {
        requestLastName.sendKeys(LastName);
        return this;
    }

    @FindBy(name = "crm_contact[firstName]")
    public WebElement requestFirstName;

    public CreateContactRequestPage fillFirstName(String firstName) {
        requestFirstName.sendKeys(firstName);
        return this;
    }

    @FindBy(name = "crm_contact[middleName]")
    public WebElement requestMiddleName;

    public CreateContactRequestPage fillMiddleName(String middleName) {
        requestMiddleName.sendKeys(middleName);
        return this;
    }

    @FindBy(name = "crm_contact[status]")
    public WebElement requestStatus;

    public CreateContactRequestPage selectStatus(String status) {
        new Select(requestStatus).selectByVisibleText(status);
        return this;
    }

    @FindBy(xpath = "//button[contains(text(),'Сохранить и закрыть')]")
    public WebElement saveAndCloseButton;


}
