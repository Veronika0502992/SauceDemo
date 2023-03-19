package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ProblemUserTest extends BaseTest
{
    @Test(description = "Check if user can log in", retryAnalyzer = Retry.class)
public void loginWorks() {
        loginPage.open();
        loginPage.login(System.getProperty(("user")), PASSWORD);
        String title = productsPage.getTitle();
        assertEquals(title,"Products","Пользователь не зарегестрирован");
    }


}




