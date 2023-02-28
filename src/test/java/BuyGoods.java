import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class BuyGoods extends BaseTest

{
    @Test
    public void SauceDemoWorks(){
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        String title = driver.findElement(By.cssSelector(".title")).getText();
        assertEquals(title, "Products", "Пользователь не зарегестрирован");
        driver.findElement(By.xpath("//*[text()='Sauce Labs Backpack']/ancestor::*[@class='inventory_item']//button[text()='Add to cart']")).click();
        String shoppingCartBadge = driver.findElement(By.cssSelector(".shopping_cart_badge")).getText();
        assertEquals(shoppingCartBadge,"1","Пустая корзина");
        driver.findElement(By.xpath("//*[@class='shopping_cart_link']")).click();
        String title1 = driver.findElement(By.cssSelector(".title")).getText();
        assertEquals(title1,"Your Cart","Корзина не открылась");
        driver.findElement(By.id("checkout")).click();
        String title3 = driver.findElement(By.cssSelector(".title")).getText();
        assertEquals(title3, "Checkout: Your Information","Страница покупки не открылась");
        driver.findElement(By.xpath("//*[@data-test='firstName']")).sendKeys("ppp");
        driver.findElement(By.xpath("//*[@data-test='lastName']")).sendKeys("ppp");
        driver.findElement(By.xpath("//*[@data-test='postalCode']")).sendKeys("111");
        driver.findElement(By.name("continue")).click();
        String title4 = driver.findElement(By.cssSelector(".title")).getText();
        assertEquals(title4, "Checkout: Overview","Страница оплаты не открылась");
        driver.findElement(By.xpath("//*[@class='btn btn_action btn_medium cart_button']")).click();
        String completeHeader = driver.findElement(By.cssSelector(".complete-header")).getText();
        assertEquals(completeHeader,"Thank you for your order!","Покупка не совершена");
    }

}
