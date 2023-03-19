package tests;

import org.testng.annotations.Test;

public class FinishPageTest extends BaseTest {
    @Test(description = "Check that the payment page is working",retryAnalyzer = Retry.class)
    public void finishPageWorks() {
        loginPage.open();
        loginPage.login(USER, PASSWORD);
        productsPage.addToCart("Sauce Labs Backpack");
        productsPage.openCart();
        cartPage.checkout();
        checkoutPage.checkout(FIRSTNAME, LASTNAME, ZIP);
        finishPage.isPageOpened();
        finishPage.cancel();
        productsPage.isPageOpened();
        productsPage.openCart();
        cartPage.checkout();
        checkoutPage.isPageOpened();
        checkoutPage.checkout(FIRSTNAME,LASTNAME,ZIP);
        finishPage.isPageOpened();
        finishPage.finish();
    }
}
