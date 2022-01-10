package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import pages.*;

import java.util.concurrent.TimeUnit;

@Listeners(TestListener.class)
public class BaseTest {
    WebDriver driver;
    WebDriverWait wait;
    LoginPage loginPage;
    InventoryPage inventoryPage;
    CartPage cartPage;
    BurgerMenuPage burgerMenuPage;

    //Товары, которые добавляем в корзину
    public static final String ITEM_NAME1 = "Sauce Labs Onesie"; //Добавляемый в корзину товар
    public static final String ITEM_NAME2 = "Sauce Labs Backpack"; //Добавляемый в корзину товар
    public static final String ITEM_NAME3 = "Sauce Labs Fleece Jacket"; //Добавляемый в корзину товар

    @BeforeMethod (description = "Настроить и открыть браузер")
    public void setUp(ITestContext context) {
        //Инициализация webdriver
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless"); // Хром запущен без UI. Тесты ускоряются и становятся более стабильными
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        // Ожидание, указывающее на то какое максимальное количество времени Selenium будет дожидаться появления элемента.
        // В сущности срабатывает каждый раз при вызове функции driver.findElement() или driver.findElements():
        // driver.findElement() - если через 5 секунд элемент не найдет, тест падает.
        // driver.findElements() - если через 5 секунд не будет найдены этот список элементов, он вернет нам size() = 0;
        // если за 5 секунд подгрузилось 5 из 10 элементов, столько driver.findElements() положит в коллекцию.
        // 10 - максимум. Это сколько пользователь ждет до появление элемента. В среднем 2-3 секунды, дальше уже некомфортно.
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); //неявное ожидание
        wait = new WebDriverWait(driver, 5); // явное ожидание
        context.setAttribute("driver", driver);
        //Инициализация страниц, с которыми мы будем работать в тестах
        loginPage = new LoginPage(driver);
        inventoryPage = new InventoryPage(driver);
        cartPage = new CartPage(driver);
        burgerMenuPage = new BurgerMenuPage(driver);
    }
    @AfterMethod (alwaysRun = true, description = "Закрыть браузер")
    public void tearDown() {
        driver.quit();
    }
}
