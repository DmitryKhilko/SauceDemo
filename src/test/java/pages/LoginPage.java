package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    //Перечисляем локаторы, которые будут использованы на странице
    //Именовать константы также, как их именуют разработчики в HTML-коде
    public static final By USERNAME_INPUT = By.xpath("//input[@id='user-name']");
    public static final By PASSWORD_INPUT = By.xpath("//input[@id='password']");
    public static final By LOGIN_BUTTON = By.xpath("//input[@id='login-button']");
    public static final By ERROR_MESSAGE = By.xpath("//div[@class='error-message-container error']");

    //Создаем конструктор, который позволит при создании класса LoginPage назначать ему driver
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    //Описываем методы, характерные для страницы
    //Метод открытия страницы
    public void open() {
        driver.get(BASE_URL);
    }

    //Метод проверки существования кнопки LOGIN (убедимся, что мы попали на ту страницу, которую надо по наличию кнопки)
    public String getLoginButtonValue() {
        return driver.findElement(LOGIN_BUTTON).getAttribute("value").toUpperCase();
    }

    //Метод логина
    public void login(String userName, String password) {
        //ввод имени пользователя
        driver.findElement(USERNAME_INPUT).sendKeys(userName);
        //ввод пароля
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
        //нажатие кнопки LOGIN
        driver.findElement(LOGIN_BUTTON).click();
    }

    //Метод проверки вывода сообщения об ошибке
    public String getErrorMessage() {
        return driver.findElement(ERROR_MESSAGE).getText();
    }
}
