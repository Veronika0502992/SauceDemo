package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class BuyGoodsTest extends BaseTest {


    @Test(description = "Check that the Sauce Demo is working",retryAnalyzer = Retry.class)
    public void sauceDemoWorks() {

        loginPage.open();
        loginPage.login(USER, PASSWORD);
        String title = productsPage.getTitle();
        assertEquals(title, "Products", "Пользователь не зарегестрирован");

        productsPage.isPageOpened();
        productsPage.addToCart("Sauce Labs Backpack");
        String shoppingCartBadge = driver.findElement(By.cssSelector(".shopping_cart_badge")).getText();
        assertEquals(shoppingCartBadge, "1", "Пустая корзина");
        productsPage.openCart();
        cartPage.isPageOpened();
        cartPage.removeFromCart("Sauce Labs Backpack");


        cartPage.continueShopping();
        productsPage.isPageOpened();
        productsPage.openCart();
        cartPage.isPageOpened();
        cartPage.checkout();


        checkoutPage.isPageOpened();
        checkoutPage.checkout(FIRSTNAME, LASTNAME, ZIP);

        finishPage.isPageOpened();
        finishPage.cancel();
        productsPage.isPageOpened();
        productsPage.openCart();
        cartPage.checkout();
        checkoutPage.isPageOpened();
        checkoutPage.checkout(FIRSTNAME, LASTNAME, ZIP);
        finishPage.isPageOpened();
        finishPage.finish();

        lastPage.isPageOpened();
        lastPage.backHome();
        productsPage.isPageOpened();


    }
}