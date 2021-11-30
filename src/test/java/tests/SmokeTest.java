package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SmokeTest extends BaseTest {

    @Test(priority = 1, description = "Проверка наличия кнопки меню и наличия всех пунктов меню")
    public void isDisplayedBurgerMenu() throws InterruptedException {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        Assert.assertTrue(burgerMenuPage.getDisplayedBurgerMenu(), "Кнопка BurgerMenu не отображается на странице PRODUCTS");

        burgerMenuPage.openBurgerMenu();
        //Добавлил задержку, так как меню открывается с задержкой после нажатия на кнопку BurgerMenu
        Thread.sleep(2000);
        Assert.assertTrue(burgerMenuPage.getDisplayedBMItemInventory(), "Не отображается пункт меню ALL ITEMS");
        Assert.assertTrue(burgerMenuPage.getDisplayedBMItemAbout(), "Не отображается пункт меню ABOUT");
        Assert.assertTrue(burgerMenuPage.getDisplayedBMItemLogout(), "Не отображается пункт меню LOGOUT");
        Assert.assertTrue(burgerMenuPage.getDisplayedBMItemReset(), "Не отображается пункт меню RESET APP STATE");
    }

    @Test(priority = 2, description = "Проверка работоспособности пункта меню LOGOUT")
    public void isWorkedBMItemLogout() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        burgerMenuPage.openBurgerMenu();
        burgerMenuPage.selectBMItemLogout();
        Assert.assertEquals(loginPage.getLoginButtonValue(), "LOGIN", "Кнопки LOGIN нет на странице. Мы попали не на ту страницу!");
    }

    @Test(priority = 3, description = "Проверка наличия иконки корзины на текущей странице")
    public void isDisplayedCartLink() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        Assert.assertTrue(cartPage.getDisplayedCartLink(), "Иконка корзины не отображается на странице PRODUCTS");
    }

    @Test(priority = 4, description = "Проверка перехода на страницу корзины")
    public void jumpToCartPage() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        cartPage.openCartPage();
        Assert.assertEquals(cartPage.getHeaderTitleText(), "YOUR CART", "Мы не перешли на страницу cart.html");
    }
}
