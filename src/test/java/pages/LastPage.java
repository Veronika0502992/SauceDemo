package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LastPage extends BasePage {
    public static final By BACK_HOME_BUTTON = By.id("back-to-products");

    public LastPage(WebDriver driver) {
        super(driver);
    }

    public void isPageOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class=complete-header]"))).getText();
    }

    @Step("Возвращение на страницу товаров после совершения покупки")
    public void backHome() {
        driver.findElement(BACK_HOME_BUTTON).click();
    }
}
