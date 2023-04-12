package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CheckoutPageTest extends BaseTest {
    @Test(description = "Check if the user can enter data for the purchase of goods",retryAnalyzer = Retry.class)
    public void checkoutPageWorks() {
        loginPage.open();
        loginPage.login(USER, PASSWORD);
        productsPage.addToCart("Sauce Labs Backpack");
        productsPage.openCart();
        cartPage.checkout();
        checkoutPage.isPageOpened();
        checkoutPage.checkout(FIRSTNAME, LASTNAME, ZIP);

    }


    @DataProvider(name = "Входящие данные для негативных тестов на оформление заказа")
    public Object[][] getDataForCheckout() {
        return new Object[][]{
                {"", "", "", "Error: First Name is required"},
                {"ppp", "", "ppp", "Error: Last Name is required"},
                {"ppp", "ppp", "", "Error: Postal Code is required"},


        };
    }


    @Test(description = "Negative checkout", dataProvider = "Входящие данные для негативных тестов на оформление заказа",retryAnalyzer = Retry.class)
    public void negativeCheckout(String firstName, String lastName, String zip, String expectedError) {
        loginPage.open();
        loginPage.login(USER, PASSWORD);
        productsPage.addToCart("Sauce Labs Backpack");
        productsPage.openCart();
        cartPage.checkout();
        checkoutPage.checkout(firstName, lastName, zip);
        String error = checkoutPage.getErrorMessage();
        assertEquals(error, expectedError, "Сообщение об ошибках");

    }
}
