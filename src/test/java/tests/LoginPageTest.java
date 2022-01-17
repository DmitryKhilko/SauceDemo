package tests;

import io.qameta.allure.Description;
import io.qameta.allure.TmsLink;
import lombok.extern.log4j.Log4j2;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;
import utils.AllureUtils;

@Log4j2
public class LoginPageTest extends BaseTest {
    @TmsLink("8537") // ссылка на тест-кейс в TMS
    @Description("!!!!Тест проверяет возможность входа в SauceDemo с корректными логином и паролем.")
    @Test(priority = 1, description = "Вход в программу с корректными логином и паролем")
    public void loginCorrectUsernameCorrectPassword(ITestContext context) {
        loginPage.open();
        Assert.assertEquals(loginPage.getLoginButtonValue(), "LOGIN", "Кнопки LOGIN нет на странице. Мы попали не на ту страницу!");
        AllureUtils.takeScreenshot(driver); //Принудительно выводим скриншот

        loginPage.login("standard_user", System.getProperty("testProp")); // для запуска тестов с передачей параметра mvn  clean test -Dtest=LoginPageTest -DtestProp=secret_sauce

        log.debug("Тест " + context.getAttribute("testName") + ": сравнить ожидаемое значение заголовка страницы с фактическим");
        Assert.assertEquals(inventoryPage.getHeaderTitleText(), "PRODUCTS", "Мы не перешли на страницу inventory.html");
        AllureUtils.takeScreenshot(driver); //Принудительно выводим скриншот
    }

    @Test(priority = 2, description = "Попытка входа в программу с пустым логином и корректным паролем")
    public void loginEmptyUsernameCorrectPassword() {
        loginPage.open();
        Assert.assertEquals(loginPage.getLoginButtonValue(), "LOGIN", "Кнопки LOGIN нет на странице. Мы попали не на ту страницу!");
        AllureUtils.takeScreenshot(driver); //Принудительно выводим скриншот

        loginPage.login("", "secret_sauce");
        Assert.assertEquals(loginPage.getErrorMessage(), "Epic sadface: Username is required", "Сообщение об ошибке не верно");
        AllureUtils.takeScreenshot(driver); //Принудительно выводим скриншот
    }

    @Test(priority = 3, description = "Попытка входа в программу с корректным логином и пустым паролем")
    public void loginCorrectUsernameEmptyPassword() {
        loginPage.open();
        Assert.assertEquals(loginPage.getLoginButtonValue(), "LOGIN", "Кнопки LOGIN нет на странице. Мы попали не на ту страницу!");
        AllureUtils.takeScreenshot(driver); //Принудительно выводим скриншот

        loginPage.login("standard_user", "");
        Assert.assertEquals(loginPage.getErrorMessage(), "Epic sadface: Password is required", "Сообщение об ошибке не верно");
        AllureUtils.takeScreenshot(driver); //Принудительно выводим скриншот
    }

    @Test(priority = 4, description = "Попытка входа в программу с некорректным логином и некорректным паролем")
    public void loginNotCorrectUsernameNotCorrectPassword() {
        loginPage.open();
        Assert.assertEquals(loginPage.getLoginButtonValue(), "LOGIN", "Кнопки LOGIN нет на странице. Мы попали не на ту страницу!");
        AllureUtils.takeScreenshot(driver); //Принудительно выводим скриншот

        loginPage.login("dfg", "dghsd");
        Assert.assertEquals(loginPage.getErrorMessage(), "Epic sadface: Username and password do not match any user in this service", "Сообщение об ошибке не верно");
        AllureUtils.takeScreenshot(driver); //Принудительно выводим скриншот
    }

    @Test(priority = 5, description = "Попытка входа в программу с логином заблокированного пользователя и корректным паролем")
    public void loginLockedUsernameCorrectPassword() {
        loginPage.open();
        Assert.assertEquals(loginPage.getLoginButtonValue(), "LOGIN", "Кнопки LOGIN нет на странице. Мы попали не на ту страницу!");
        AllureUtils.takeScreenshot(driver); //Принудительно выводим скриншот

        loginPage.login("locked_out_user", "secret_sauce");
        Assert.assertEquals(loginPage.getErrorMessage(), "Epic sadface: Sorry, this user has been locked out.", "Сообщение об ошибке не верно");
        AllureUtils.takeScreenshot(driver); //Принудительно выводим скриншот
    }
}
