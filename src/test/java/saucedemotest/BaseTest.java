package saucedemotest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import web.pages.*;

import java.time.Duration;

public class BaseTest {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected LoginPage loginPage;
    protected CatalogPage catalogPage;
    protected CartPage cartPage;
    protected CheckoutOneStepPage checkoutOneStepPage;
    protected CheckoutTwoStepPage checkoutTwoStepPage;
    protected CheckoutCompletePage checkoutCompletePage;

    public static final String USERNAME = "standard_user";
    public static final String PASSWORD = "secret_sauce";

    public static final String FIRST_NAME = "FIRST_NAME";
    public static final String LAST_NAME = "LAST_NAME";
    public static final String ZIP_CODE = "123";

    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless");
        chromeOptions.addArguments("--ignore-popup-blocking");
        chromeOptions.addArguments("--ignore-certificate-errors");
        driver = new ChromeDriver(chromeOptions);
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        loginPage = new LoginPage(driver, wait);
        catalogPage = new CatalogPage(driver, wait);
        cartPage = new CartPage(driver, wait);
        checkoutOneStepPage = new CheckoutOneStepPage(driver, wait);
        checkoutTwoStepPage = new CheckoutTwoStepPage(driver, wait);
        checkoutCompletePage = new CheckoutCompletePage(driver, wait);

    }

    @AfterClass(alwaysRun = true)
    public void teardown() {
        driver.close();
        driver.quit();
    }

}
