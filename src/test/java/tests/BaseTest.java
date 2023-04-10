package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.*;

import java.time.Duration;
@Listeners(TestListener.class)
public class  BaseTest {
    WebDriver driver;
    LoginPage loginPage;
    ProductsPage productsPage;
    CartPage cartPage;
    CheckoutPage checkoutPage;
    FinishPage finishPage;
    LastPage lastPage;

    public static final String USER = "standard_user";
    public static final String PASSWORD = "secret_sauce";
    public static final String FIRSTNAME = "anna";
    public static final String LASTNAME = "anna";
    public static final String ZIP = "1111";

    @Parameters({"browser"})

    @BeforeMethod
    public void setUp(@Optional("chrome") String browser, ITestContext testContext) {
        if (browser.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            //options.addArguments("--headless");
            driver = new ChromeDriver(options);
        } else if (browser.equals("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }
        testContext.setAttribute("driver",driver);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        cartPage = new CartPage(driver);
        checkoutPage = new CheckoutPage(driver);
        finishPage = new FinishPage(driver);
        lastPage = new LastPage(driver);
    }
        @AfterMethod(alwaysRun = true)
        public void tearDown (){

            if (driver != null) ;
            driver.quit();
        }
    }



