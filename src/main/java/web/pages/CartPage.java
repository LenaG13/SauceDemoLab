package web.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CartPage extends BasePage {

    public static final String BASE_URL = "https://www.saucedemo.com/cart.html";
    private static final By TITLE_LOCATOR = By.xpath("//span[@class='title' and text()='Your Cart']");

    public CartPage(WebDriver driver) {
        super(driver);
        this.baseUrl = BASE_URL;
        this.basePageElementId = TITLE_LOCATOR;
    }

    private static final By PRODUCT_TITLE_IN_CART = By.className("inventory_item_name");
    private static final By RESET_APP_STATE = By.id("reset_sidebar_link");
    private static final By BURGER_MENU_ICON = By.id("react-burger-menu-btn");
    private static final By PRODUCT_IN_CART = By.className("//div[@class='cart_item']");
    private static final By REMOVE_BUTTON = By.xpath("//div[@class='cart_item']//button");
    private static final By CONTINUE_SHOPPING_BUTTON = By.id("continue-shopping");
    private static final By CHECKOUT_BUTTON = By.id("checkout");

    public String findProductByNameInCard(String partialProductTitle) {
        return driver.findElement(PRODUCT_TITLE_IN_CART).getText();
    }

    public void clickContinueShopping() {
        driver.findElement(CONTINUE_SHOPPING_BUTTON).click();
    }

    public void clickCheckoutButton() {
        driver.findElement(CHECKOUT_BUTTON).click();
    }

    public void removeProduct() {
        driver.findElement(REMOVE_BUTTON);
    }

    public void clickRemoveButton() {
        driver.findElement(REMOVE_BUTTON).click();
    }

    public void clearCart() {
        driver.findElement(BURGER_MENU_ICON).click();
        driver.findElement(RESET_APP_STATE).click();
    }

    public boolean isCartEmpty() {
        List<WebElement> products = driver.findElements(PRODUCT_IN_CART);
        if (products.isEmpty()) {
            return true;
        }
        return false;
    }

}
