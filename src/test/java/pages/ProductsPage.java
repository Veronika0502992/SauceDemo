package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductsPage extends BasePage {


    String addToCartXpath = "//*[text()='%s']/ancestor::*[@class='inventory_item']//button[text()='Add to cart']";

    public static final By CART = By.id("shopping_cart_container");

    public ProductsPage(WebDriver driver) {

        super(driver);
    }

    public void open() {
        driver.get(BASE_URL + "/inventory.html");
    }

    public void isPageOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(TITLE)).getText();
    }

    public void addToCart(String product) {

        By addToCartLocator = By.xpath(String.format(addToCartXpath, product));
        driver.findElement(addToCartLocator).click();

    }

    public void openCart() {

        driver.findElement(CART).click();
    }

    public void cartPage() {
        //driver.findElement();
    }

}