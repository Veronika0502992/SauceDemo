package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CartPageTest extends BaseTest{
@Test(description = "Check the presence of goods in the cart and the possibility of deleting goods from the cart",retryAnalyzer = Retry.class)
    public void cartPageWorks(){
    loginPage.open();
    loginPage.login(USER, PASSWORD);
    productsPage.addToCart("Sauce Labs Backpack");
    productsPage.openCart();
    cartPage.isPageOpened();
    cartPage.removeFromCart("Sauce Labs Backpack");
    cartPage.continueShopping();
    productsPage.isPageOpened();
    productsPage.openCart();
    cartPage.isPageOpened();
    cartPage.checkout();
}
}
