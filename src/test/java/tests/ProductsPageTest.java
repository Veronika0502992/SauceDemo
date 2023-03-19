package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ProductsPageTest extends BaseTest {

    @Test(description = "Check adding item to cart",retryAnalyzer = Retry.class)
    public void productsPageWorks() {
        loginPage.open();
        loginPage.login(USER, PASSWORD);
        productsPage.isPageOpened();
        productsPage.addToCart("Sauce Labs Backpack");
        String shoppingCartBadge = driver.findElement(By.cssSelector(".shopping_cart_badge")).getText();
        assertEquals(shoppingCartBadge, "1", "Пустая корзина");
        productsPage.openCart();
    }
}
