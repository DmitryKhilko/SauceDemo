package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class BurgerMenuTest extends BaseTest {

    @Test(priority = 1, description = "positive")
    public void isDisplayedBurgerMenu() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        Assert.assertEquals(inventoryPage.getHeaderTitleText(), "PRODUCTS", "Мы не перешли на страницу inventory.html");
        Assert.assertTrue(burgerMenuPage.getDisplayedBurgerMenu(), "Кнопка BurgerMenu не отображается на странице PRODUCTS");

        burgerMenuPage.openBurgerMenu();

        Assert.assertTrue(burgerMenuPage.getDisplayedBMItemInventory(), "Не отображается пункт меню ALL ITEMS");
        Assert.assertTrue(burgerMenuPage.getDisplayedBMItemAbout(), "Не отображается пункт меню ABOUT");
        Assert.assertTrue(burgerMenuPage.getDisplayedBMItemLogout(), "Не отображается пункт меню LOGOUT");
        Assert.assertTrue(burgerMenuPage.getDisplayedBMItemReset(), "Не отображается пункт меню RESET APP STATE");
    }

    @Test(priority = 2, description = "positive")
    public void isWorkedBMItemLogout() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        Assert.assertEquals(inventoryPage.getHeaderTitleText(), "PRODUCTS", "Мы не перешли на страницу inventory.html");
        Assert.assertTrue(burgerMenuPage.getDisplayedBurgerMenu(), "Кнопка BurgerMenu не отображается на странице PRODUCTS");

        burgerMenuPage.openBurgerMenu();
        burgerMenuPage.selectBMItemLogout();
        Assert.assertEquals(loginPage.getLoginButtonValue(), "LOGIN", "Кнопки LOGIN нет на странице. Мы попали не на ту страницу!");
    }

}
