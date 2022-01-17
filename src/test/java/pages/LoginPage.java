package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.testng.ITestContext;

@Log4j2
public class LoginPage extends BasePage {
    //Перечисляем локаторы, которые будут использованы на странице
    //Именовать константы также, как их именуют разработчики в HTML-коде
    public static final By USERNAME_INPUT = By.xpath("//input[@id='user-name']");
    public static final By PASSWORD_INPUT = By.xpath("//input[@id='password']");
    public static final By LOGIN_BUTTON = By.xpath("//input[@id='login-button']");
    public static final By ERROR_MESSAGE = By.xpath("//div[@class='error-message-container error']");

    //Создаем конструктор, который позволит при создании класса LoginPage назначать ему driver
    public LoginPage(ITestContext driver) {
        super(driver);
    }

    //Описываем методы, характерные для страницы
    //Метод открытия страницы
    @Step("Открыть стартовую страницу приложения SauceDemo https://www.saucedemo.com")
    public void open() {
        log.debug("Тест " + context.getAttribute("testName") + ": открыть страницу " + BASE_URL);
        driver.get(BASE_URL);
    }

    //Метод проверки существования кнопки LOGIN (убедимся, что мы попали на ту страницу, которую надо по наличию кнопки)
    @Step("Проверить существование кнопки LOGIN на стартовой странице приложения SauceDemo")
    public String getLoginButtonValue() {
        log.debug("Тест " + context.getAttribute("testName") + ": проверить существование кнопки LOGIN на стартовой странице приложения SauceDemo");
        return driver.findElement(LOGIN_BUTTON).getAttribute("value").toUpperCase();
    }

    //Метод логина
    //@Step("Войти в приложение SauceDemo под пользователем '{userName}' и паролем '{password}'")
    @Step("Войти в приложение SauceDemo")
    public void login(String userName, String password) {
        log.debug("Тест " + context.getAttribute("testName") + ": войти в приложение SauceDemo");
        driver.findElement(USERNAME_INPUT).sendKeys(userName); //ввод имени пользователя
        driver.findElement(PASSWORD_INPUT).sendKeys(password); //ввод пароля
        driver.findElement(LOGIN_BUTTON).click(); //нажатие кнопки LOGIN
    }

    //Метод проверки вывода сообщения об ошибке
    @Step("Вывести сообщения об ошибке при неудачном входе в приложение SauceDemo")
    public String getErrorMessage() {
        log.debug("Тест " + context.getAttribute("testName") + ": вывести сообщения об ошибке при неудачном входе в приложение SauceDemo");
        return driver.findElement(ERROR_MESSAGE).getText();
    }
}
