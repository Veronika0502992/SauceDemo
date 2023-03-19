package tests;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class LoginTest extends BaseTest {

    @Test(description = "Check if user can log in", retryAnalyzer = Retry.class)
    public void loginWorks() {
        loginPage.open();
        loginPage.login(USER, PASSWORD);
        String title = productsPage.getTitle();
        assertEquals(title, "Products", "Пользователь не зарегестрирован");
    }

    @DataProvider(name = "Входящие данные для негативных тестов на логин")
    public Object[][] getDataForLogin() {
        return new Object[][]{
                {"", "", "Epic sadface: Username is required"},
                {"p", "p", "Epic sadface: Username and password do not match any user in this service"},
                {"standard_user", "", "Epic sadface: Password is required"},
                {"", "secret_sauce", "Epic sadface: Username is required"},
                {"locked_out_user", "secret_sauce", "Epic sadface: Sorry, this user has been locked out."}
        };
    }


    @Test(description = "Negative login", dataProvider = "Входящие данные для негативных тестов на логин",retryAnalyzer = Retry.class)
    public void negativeLogin(String username, String password, String expectedError) {
        loginPage.open();
        loginPage.login(username, password);
        String error = loginPage.getErrorMessage();
        assertEquals(error, expectedError, "Сообщение об ошибках");

    }


}




