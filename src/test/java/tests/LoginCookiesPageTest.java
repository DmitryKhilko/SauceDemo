package tests;

import org.openqa.selenium.Cookie;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;
//Только в первом тесте логинимся, в остальных записываем cookies (где есть логин и пароль)
public class LoginCookiesPageTest extends BaseTest {
    Set<Cookie> cookies;
    @Test (priority = 1)
    public void loginCorrectUsernameCorrectPassword() {
        loginPage.open();
        Assert.assertEquals(loginPage.getLoginButtonValue(), "LOGIN", "Кнопки LOGIN нет на странице. Мы попали не на ту страницу!");

        loginPage.login("standard_user", "secret_sauce");
        Assert.assertEquals(inventoryPage.getHeaderTitleText(), "PRODUCTS", "Мы не перешли на страницу inventory.html");

        cookies= driver.manage().getCookies(); // забираем все cookies в коллекцию
    }

    @Test (priority = 2)
    public void test1() {
        loginPage.open(); //как передать домен без открытия страницы?
        //Записываем в cookies ранее сохраненные  cookies (после входа с паролем)
        for (Cookie ck: cookies){
            driver.manage().addCookie(ck);
        }
        inventoryPage.open();
    }

    @Test (priority = 3)
    public void test2() {
        loginPage.open();
        //Записываем в cookies ранее сохраненные  cookies (после входа с паролем)
        for (Cookie ck: cookies){
            driver.manage().addCookie(ck);
        }
        inventoryPage.open();
    }


}
