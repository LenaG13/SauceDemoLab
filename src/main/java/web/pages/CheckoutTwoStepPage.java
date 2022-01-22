package web.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutTwoStepPage extends BasePage {

    public static final String BASE_URL = "https://www.saucedemo.com/checkout-step-two.html";
    private static final By TITLE_LOCATOR = By.xpath("//span[@class='title' and text()='Checkout: Overview']");

    public CheckoutTwoStepPage(WebDriver driver) {
        super(driver);
        this.baseUrl = BASE_URL;
        this.basePageElementId = TITLE_LOCATOR;
    }

    private static final By FINISH_BUTTON = By.id("finish");

    public void clickFinishButton() {
        driver.findElement(FINISH_BUTTON).click();
    }

}