package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends BasePage
{

    public static final By FIRSTNAME_INPUT = By.id("first-name");
    public static final By LASTNAME_INPUT = By.id("last-name");
    public static final By ZIP_INPUT = By.id("postal-code");
    public static final By CONTINUE_BUTTON = By.id("continue");


    public CheckoutPage(WebDriver driver){
        super(driver);
    }
    public void open(){
        driver.get(BASE_URL + "/checkout-step-one.html");
    }
public void checkout(String firstName,String lastName, String zip){
    driver.findElement(FIRSTNAME_INPUT).sendKeys(firstName);
    driver.findElement(LASTNAME_INPUT).sendKeys(lastName);
    driver.findElement(ZIP_INPUT).sendKeys(zip);
    //driver.findElement(CONTINUE_BUTTON).click();
}
public void continueButton(){
        driver.findElement(CONTINUE_BUTTON).click();
}



}
