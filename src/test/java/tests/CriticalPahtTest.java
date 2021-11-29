package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CriticalPahtTest extends BaseTest {

    @Test(priority = 1, description = "positive")
    public void itemAddToCart() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        Assert.assertEquals(inventoryPage.getHeaderTitleText(), "PRODUCTS", "Мы не перешли на страницу inventory.html");

        inventoryPage.addToCart("Sauce Labs Onesie");
        cartPage.openCart();
        Assert.assertEquals(cartPage.getHeaderTitleText(), "YOUR CART", "Мы не перешли на страницу cart.html");
        //TODO сделать проверку, появился ли продукт в корзине и стакой ли он ценой там
    }

}
