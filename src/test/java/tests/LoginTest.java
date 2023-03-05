package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class LoginTest extends BaseTest
{
    @Test
public void LoginWorks(){
        loginPage.open();
        loginPage.login(USER,PASSWORD);

        //String title = productsPage.getTitle();
        //assertEquals(title,"Products","Пользователь не зарегестрирован");




        //driver.get("https://www.saucedemo.com/");
        //driver.findElement(By.id("user-name")).sendKeys("standard_user");
        //driver.findElement(By.id("password")).sendKeys("standard_user");
        //driver.findElement(By.id("login-button")).click();
        //<span class="title">Products</span>
        //String title = driver.findElement(By.cssSelector(".title")).getText();
        //assertEquals(title,"Products","Пользователь не зарегестрирован");
        //<div class="error-message-container error"><h3 data-test="error"><button class="error-button"><svg aria-hidden="true" focusable="false" data-prefix="fas" data-icon="times" class="svg-inline--fa fa-times fa-w-11 " role="img" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 352 512"><path fill="currentColor" d="M242.72 256l100.07-100.07c12.28-12.28 12.28-32.19 0-44.48l-22.24-22.24c-12.28-12.28-32.19-12.28-44.48 0L176 189.28 75.93 89.21c-12.28-12.28-32.19-12.28-44.48 0L9.21 111.45c-12.28 12.28-12.28 32.19 0 44.48L109.28 256 9.21 356.07c-12.28 12.28-12.28 32.19 0 44.48l22.24 22.24c12.28 12.28 32.2 12.28 44.48 0L176 322.72l100.07 100.07c12.28 12.28 32.2 12.28 44.48 0l22.24-22.24c12.28-12.28 12.28-32.19 0-44.48L242.72 256z"></path></svg></button>Epic sadface: Username is required</h3></div>

    }
    @Test
    public void UserNameIsWrong(){
        loginPage.open();
        loginPage.login("","");
        String error = loginPage.getErrorMessage();
        assertEquals(error,"Epic sadface: Username is required","Сообщение об ошибке");

    }



    @Test
    public void SmallUsernameOrPassword(){
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("p");
        driver.findElement(By.id("password")).sendKeys("p");
        driver.findElement(By.id("login-button")).click();
        String error = driver.findElement(By.cssSelector("[data-test=error]")).getText();
        assertEquals(error, "Epic sadface: Username and password do not match any user in this service",
                            "Сообщение об ошибке2");
    }
    @Test
    public void FillOnlyUsername(){
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("");
        driver.findElement(By.id("login-button")).click();
        String error = driver.findElement(By.cssSelector("[data-test=error]")).getText();
        assertEquals(error, "Epic sadface: Password is required",
                            "Сообщение об ошибке3");
    }
    @Test
    public void FillOnlyPassword(){
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        String error = driver.findElement(By.cssSelector("[data-test=error]")).getText();
        assertEquals(error, "Epic sadface: Username is required",
                "Сообщение об ошибке4");
    }
    @Test
    public void BlockedUser(){
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("locked_out_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        String error = driver.findElement(By.cssSelector("[data-test=error]")).getText();
        assertEquals(error, "Epic sadface: Sorry, this user has been locked out.",
                "Сообщение об ошибке5");
    }
}




