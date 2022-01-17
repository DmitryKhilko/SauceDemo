package tests;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;
import utils.AllureUtils;

@Log4j2
public class SmokeTest extends BaseTest {
    @Test(priority = 1, description = "Проверка наличия кнопки и наличия всех пунктов меню BurgerMenu")
    public void isDisplayedBurgerMenu(ITestContext context) {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");

        Assert.assertTrue(burgerMenuPage.getDisplayedBurgerMenu(), "Кнопка BurgerMenu не отображается на странице PRODUCTS");
        AllureUtils.takeScreenshot(driver); //Принудительно выводим скриншот

        burgerMenuPage.openBurgerMenu();
        //Добавлил задержку, так как меню открывается с задержкой после нажатия на кнопку BurgerMenu
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("inventory_sidebar_link")));

        log.debug("Тест " + context.getAttribute("testName") + ": проверить наличие всех пунктов меню BurgerMenu");
        Assert.assertEquals(burgerMenuPage.getItemsBM().get(0), "ALL ITEMS", "Не отображается пункт меню ALL ITEMS");
        Assert.assertEquals(burgerMenuPage.getItemsBM().get(1), "ABOUT", "Не отображается пункт меню ABOUT");
        Assert.assertEquals(burgerMenuPage.getItemsBM().get(2), "LOGOUT", "Не отображается пункт меню LOGOUT");
        Assert.assertEquals(burgerMenuPage.getItemsBM().get(3), "RESET APP STATE", "Не отображается пункт меню RESET APP STATE");
        AllureUtils.takeScreenshot(driver); //Принудительно выводим скриншот
    }

    @Test(priority = 2, description = "Проверка работоспособности пункта меню LOGOUT")
    public void isWorkedBMItemLogout() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        burgerMenuPage.openBurgerMenu();
        burgerMenuPage.selectBMItemLogout();
        Assert.assertEquals(loginPage.getLoginButtonValue(), "LOGIN", "Кнопки LOGIN нет на странице. Мы попали не на ту страницу!");
        AllureUtils.takeScreenshot(driver); //Принудительно выводим скриншот
    }

    @Test(priority = 3, description = "Проверка наличия иконки корзины на текущей странице")
    public void isDisplayedCartLink() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        Assert.assertTrue(burgerMenuPage.getDisplayedCartLink(), "Иконка корзины не отображается на странице PRODUCTS");
        AllureUtils.takeScreenshot(driver); //Принудительно выводим скриншот
    }

    @Test(priority = 4, description = "Проверка перехода на страницу корзины")
    public void jumpToCartPage(ITestContext context) {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        burgerMenuPage.openCartPage();

        log.debug("Тест " + context.getAttribute("testName") + ": сравнить ожидаемое значение заголовка страницы с фактическим");
        Assert.assertEquals(cartPage.getHeaderTitleText(), "YOUR CART", "Мы не перешли на страницу cart.html");
        AllureUtils.takeScreenshot(driver); //Принудительно выводим скриншот
    }
}
