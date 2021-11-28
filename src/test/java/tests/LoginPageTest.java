package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest {

    @Test(priority = 1, description = "positive")
    public void loginCorrectUsernameCorrectPassword() {
        loginPage.open();
        Assert.assertEquals(loginPage.getLoginButtonValue(), "LOGIN", "Кнопки LOGIN нет на странице. Мы попали не на ту страницу!");

        loginPage.login("standard_user", "secret_sauce");
        Assert.assertEquals(inventoryPage.getHeaderTitleText(), "PRODUCTS", "Мы не перешли на страницу inventory.html");
    }

    @Test(priority = 2, description = "negative")
    public void loginEmptyUsernameEmptyPassword() {
        loginPage.open();
        Assert.assertEquals(loginPage.getLoginButtonValue(), "LOGIN", "Кнопки LOGIN нет на странице. Мы попали не на ту страницу!");

        loginPage.login("", "");
        Assert.assertEquals(loginPage.getErrorMessage(), "Epic sadface: Username is required", "Сообщение об ошибке не верно");
    }

    @Test(priority = 3, description = "negative")
    public void loginEmptyUsernameCorrectPassword() {
        loginPage.open();
        Assert.assertEquals(loginPage.getLoginButtonValue(), "LOGIN", "Кнопки LOGIN нет на странице. Мы попали не на ту страницу!");

        loginPage.login("", "secret_sauce");
        Assert.assertEquals(loginPage.getErrorMessage(), "Epic sadface: Username is required", "Сообщение об ошибке не верно");
    }

    @Test(priority = 4, description = "negative")
    public void loginCorrectUsernameEmptyPassword() {
        loginPage.open();
        Assert.assertEquals(loginPage.getLoginButtonValue(), "LOGIN", "Кнопки LOGIN нет на странице. Мы попали не на ту страницу!");

        loginPage.login("standard_user", "");
        Assert.assertEquals(loginPage.getErrorMessage(), "Epic sadface: Password is required", "Сообщение об ошибке не верно");
    }

    @Test(priority = 5, description = "negative")
    public void loginNotCorrectUsernameNotCorrectPassword() {
        loginPage.open();
        Assert.assertEquals(loginPage.getLoginButtonValue(), "LOGIN", "Кнопки LOGIN нет на странице. Мы попали не на ту страницу!");

        loginPage.login("dfg", "dghsd");
        Assert.assertEquals(loginPage.getErrorMessage(), "Epic sadface: Username and password do not match any user in this service", "Сообщение об ошибке не верно");
    }

    @Test(priority = 6, description = "negative")
    public void loginLockedUsernameCorrectPassword() {
        loginPage.open();
        Assert.assertEquals(loginPage.getLoginButtonValue(), "LOGIN", "Кнопки LOGIN нет на странице. Мы попали не на ту страницу!");

        loginPage.login("locked_out_user", "secret_sauce");
        Assert.assertEquals(loginPage.getErrorMessage(), "Epic sadface: Sorry, this user has been locked out.", "Сообщение об ошибке не верно");
    }
}
