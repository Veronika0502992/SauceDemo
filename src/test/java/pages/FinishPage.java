package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class FinishPage extends BasePage {
    public static final By FINISH_BUTTON = By.id("finish");
    public static final By CANCEL_BUTTON = By.id("cancel");

    public FinishPage(WebDriver driver) {
        super(driver);
    }

    public void isPageOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(TITLE)).getText();
    }

    @Step("Переход на страницу завершения покупки")
    public void finish() {
        driver.findElement(FINISH_BUTTON).click();
    }

    @Step("Возвращение на страницу товаров")
    public void cancel() {
        driver.findElement(CANCEL_BUTTON).click();
    }
}