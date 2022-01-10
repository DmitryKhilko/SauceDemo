package tests;

import io.qameta.allure.Description;
import io.qameta.allure.TmsLink;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.AllureUtils;

public class LoginPageTest extends BaseTest {
    @TmsLink("8537") // ссылка на тест-кейс в TMS
    @Description("Тест проверяет возможность входа в SauceDemo с корректными логином и паролем.")
    @Test(priority = 1, description = "Вход в программу с корректными логином и паролем")
    public void loginCorrectUsernameCorrectPassword() {
        loginPage.open();
        Assert.assertEquals(loginPage.getLoginButtonValue(), "LOGIN", "Кнопки LOGIN нет на странице. Мы попали не на ту страницу!");

        loginPage.login("standard_user", System.getProperty("testProp")); // для запуска тестов с передачей параметра mvn  clean test -Dtest=LoginPageTest -DtestProp=secret_sauce

        Assert.assertEquals(inventoryPage.getHeaderTitleText(), "PRODUCTS", "Мы не перешли на страницу inventory.html");
        //Принудительно выводим скриншот
        AllureUtils.takeScreenshot(driver);
    }

    @Test(priority = 2, description = "Попытка входа в программу с пустым логином и корректным паролем")
    public void loginEmptyUsernameCorrectPassword() {
        loginPage.open();
        Assert.assertEquals(loginPage.getLoginButtonValue(), "LOGIN", "Кнопки LOGIN нет на странице. Мы попали не на ту страницу!");

        loginPage.login("", "secret_sauce");
        Assert.assertEquals(loginPage.getErrorMessage(), "Epic sadface: Username is required", "Сообщение об ошибке не верно");
    }

    @Test(priority = 3, description = "Попытка входа в программу с корректным логином и пустым паролем")
    public void loginCorrectUsernameEmptyPassword() {
        loginPage.open();
        Assert.assertEquals(loginPage.getLoginButtonValue(), "LOGIN", "Кнопки LOGIN нет на странице. Мы попали не на ту страницу!");

        loginPage.login("standard_user", "");
        Assert.assertEquals(loginPage.getErrorMessage(), "Epic sadface: Password is required", "Сообщение об ошибке не верно");
    }

    @Test(priority = 4, description = "Попытка входа в программу с некорректным логином и некорректным паролем")
    public void loginNotCorrectUsernameNotCorrectPassword() {
        loginPage.open();
        Assert.assertEquals(loginPage.getLoginButtonValue(), "LOGIN", "Кнопки LOGIN нет на странице. Мы попали не на ту страницу!");

        loginPage.login("dfg", "dghsd");
        Assert.assertEquals(loginPage.getErrorMessage(), "Epic sadface: Username and password do not match any user in this service", "Сообщение об ошибке не верно");
    }

    @Test(priority = 5, description = "Попытка входа в программу с логином заблокированного пользователя и корректным паролем")
    public void loginLockedUsernameCorrectPassword() {
        loginPage.open();
        Assert.assertEquals(loginPage.getLoginButtonValue(), "LOGIN", "Кнопки LOGIN нет на странице. Мы попали не на ту страницу!");

        loginPage.login("locked_out_user", "secret_sauce");
        Assert.assertEquals(loginPage.getErrorMessage(), "Epic sadface: Sorry, this user has been locked out.", "Сообщение об ошибке не верно");
    }
}
