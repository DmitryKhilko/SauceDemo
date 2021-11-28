package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CriticalPahtTest extends BaseTest {

    @Test(priority = 1, description = "positive")
    public void itemAddToCart() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        inventoryPage.addToCart("Sauce Labs Onesie");
        inventoryPage.openCart();
        //cartPage.open();
        //TODO сделать проверку, появился ли продукт в корзине и стакой ли он ценой там
    }

}
