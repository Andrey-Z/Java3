package Java3HW6Test;

import Java3HW6.pages.CounterPartiesSubMenu;
import Java3HW6.pages.CreateContactRequestPage;
import Java3HW6.pages.ExpenseContactPage;
import Java3HW6.pages.LoginPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static Java3HW6Test.Configuration.BASE_URL;

public class LoginWithPageObjectTests  extends BaseTest {



    @BeforeEach
    public void goToPage(){
    driver.get(BASE_URL);
    }

    @Test
        void loginTest(){
        loginPage.inputLogin.sendKeys("Applanatest1");
        loginPage.inputPassword.sendKeys("Student2020!");
        loginPage.buttonSubmit.click();
    }

    @Test
    void loginTestWithFluentPage(){
        new LoginPage(driver)
                .fillInputLogin("Applanatest1")
                .fillInputPassword("Student2020!")
                .submitLogin();
    }

    @Test
    void createNewCounterParties() throws InterruptedException {
        new LoginPage(driver).login("Applanatest1", "Student2020!")
                .navigationMenu.openNavigationMenuItem("Контрагенты");
        new CounterPartiesSubMenu(driver).counterPartiesButton.click();
        new ExpenseContactPage(driver).createContactButton.click();

        new CreateContactRequestPage(driver)
                .fillFirstName("Petrov")
                .fillLastName("Petr")
                .fillMiddleName("Andreevich")
                .selectStatus("Неактивный")
                .saveAndCloseButton.click();

        Thread.sleep(5000);
    }

}
