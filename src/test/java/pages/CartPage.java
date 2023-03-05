package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage
{
   String removeFromCartXpath = "//*[text()='%s']/ancestor::*[@class='cart_item_label']//button[text()='Remove']";
public static final By CHECKOUT_BUTTON = By.id("checkout");
public CartPage(WebDriver driver){
   super(driver);
}
public void open(){
   driver.get(BASE_URL + "/cart.html");
}
   public void removeFromCart(String product)
   {

      By removeFromCarLocator = By.xpath(String.format(removeFromCartXpath,product));
      driver.findElement(removeFromCarLocator).click();
   }
public void checkout(){
   driver.findElement(CHECKOUT_BUTTON).click();
}
}
