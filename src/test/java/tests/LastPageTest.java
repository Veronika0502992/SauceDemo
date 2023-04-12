package tests;

import org.testng.annotations.Test;

public class LastPageTest extends BaseTest {
    @Test(description = "Check that the payment went through and the purchase was made",retryAnalyzer = Retry.class)
    public void lastPageWorks() {
        loginPage.open();
        loginPage.login(USER, PASSWORD);
        productsPage.addToCart("Sauce Labs Backpack");
        productsPage.openCart();
        cartPage.checkout();
        checkoutPage.checkout(FIRSTNAME, LASTNAME, ZIP);
        finishPage.isPageOpened();
        finishPage.finish();
        lastPage.isPageOpened();
        lastPage.backHome();
        productsPage.isPageOpened();
    }
}
