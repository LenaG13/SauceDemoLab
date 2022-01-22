package saucedemotest;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProductTest extends BaseTest {

    public static final String TEST_PRODUCT_TITLE = "Test.allTheThings() T-Shirt (Red)";
    //public static final String PRODUCT_XPATH_PATTERN = "//div[contains(text(),'%s')]";
    public static final String TEST_PRODUCT_TITLE2 = "Sauce Labs Backpack";
    public static final String ADD_TO_CART_BUTTON = "ADD TO CART";
    public static final String REMOVE_BUTTON = "REMOVE";

    @BeforeMethod
    private void login() {
        loginPage.open();
        Assert.assertTrue(loginPage.isPageLoaded(), "Login page was not loaded");
        loginPage.login(USERNAME, PASSWORD);
        Assert.assertTrue(catalogPage.isPageLoaded(), "Catalog page was not loaded");
    }

    @Test
    public void checkImageProductTest() {
        Assert.assertTrue(catalogPage.productImg(TEST_PRODUCT_TITLE2), "IMG of the product was not displayed");
    }

    @Test
    public void checkProductButtonTest() {
        Assert.assertEquals(catalogPage.getProductTitle(TEST_PRODUCT_TITLE),
                ADD_TO_CART_BUTTON,"Title of the button ADD_TO_CART is not correct");
        catalogPage.addProductToCart(TEST_PRODUCT_TITLE);
        Assert.assertEquals(catalogPage.getProductTitle(TEST_PRODUCT_TITLE),REMOVE_BUTTON,
                "Title of the button Remove is not correct");
    }

    @Test
    public void checkCartButtonTest() {
        Assert.assertTrue(catalogPage.isDisplayedCartButton(),
                "Shopping Cart button was not displayed");
    }

    @Test
    public void checkMenuButtonTest() {
        Assert.assertTrue(catalogPage.isDisplayedMenuButton(),
                "Menu button was not displayed");
    }

    @Test
    public void addProductToCartTest() {
        catalogPage.addProductToCart(TEST_PRODUCT_TITLE);
        cartPage.open();
        cartPage.isPageLoaded();
        Assert.assertEquals(cartPage.findProductByNameInCard(TEST_PRODUCT_TITLE), TEST_PRODUCT_TITLE, "Selected product is not in the cart");
    }

    @Test
    public void removeAddedProductTest(){
        addProductToCartTest();
        cartPage.removeProduct();
        Assert.assertTrue(cartPage.isCartEmpty(), "Product was not removed");
    }

    @Test
    public void logoutTest() {
        catalogPage.logout();
        Assert.assertTrue(loginPage.isPageLoaded(), "User cannot logout");
    }

    @Test
    public void purchaseProduct() {
        catalogPage.addProductToCart(TEST_PRODUCT_TITLE2);
        cartPage.open();
        cartPage.isPageLoaded();
        cartPage.clickContinueShopping();
        catalogPage.addProductToCart(TEST_PRODUCT_TITLE2);
        cartPage.open();
        cartPage.isPageLoaded();
        cartPage.clickCheckoutButton();
        checkoutOneStepPage.fillFormCheckoutStepOne(FIRST_NAME,LAST_NAME,ZIP_CODE);
        checkoutTwoStepPage.clickFinishButton();
        checkoutCompletePage.clickBackHomeButton();
        Assert.assertTrue(catalogPage.isPageLoaded(), "Catalog was not loaded");
    }

}
