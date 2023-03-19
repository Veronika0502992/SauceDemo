package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CartPage extends BasePage {

    String removeFromCartXpath = "//*[text()='%s']/ancestor::*[@class='cart_item_label']//button[text()='Remove']";
    public static final By CHECKOUT_BUTTON = By.id("checkout");
    public static final By CONTINUE_CHOPPING_BUTTON = By.id("continue-shopping");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    /*public void open(){
       driver.get(BASE_URL + "/cart.html");
    }*/
    public void isPageOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("checkout"))).getText();
    }

    public void removeFromCart(String product) {

        By removeFromCarLocator = By.xpath(String.format(removeFromCartXpath, product));
        driver.findElement(removeFromCarLocator).click();
    }

    public void checkout() {
        driver.findElement(CHECKOUT_BUTTON).click();
    }

    public void continueShopping() {
        driver.findElement(CONTINUE_CHOPPING_BUTTON).click();
    }
}
