package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.BurgerMenuPage;
import pages.CartPage;
import pages.InventoryPage;
import pages.LoginPage;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    WebDriver driver;
    LoginPage loginPage;
    InventoryPage inventoryPage;
    CartPage cartPage;
    BurgerMenuPage burgerMenuPage;

    //Товары, которые добавляем в корзину
    String itemName1 = "Sauce Labs Onesie"; //Добавляемый в корзину товар
    String itemName2 = "Sauce Labs Backpack"; //Добавляемый в корзину товар
    String itemName3 = "Sauce Labs Fleece Jacket"; //Добавляемый в корзину товар

    @BeforeMethod
    public void setUp() {
        //Инициализация webdriver
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless"); // Хром запущен без UI - тесты ускоряются и становятся более стабильными
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        //Инициализация страниц, с которыми мы будем работать в тестах
        loginPage = new LoginPage(driver);
        inventoryPage = new InventoryPage(driver);
        cartPage = new CartPage(driver);
        burgerMenuPage = new BurgerMenuPage(driver);
    }

    @AfterMethod
    public void closeBrowser() {
       driver.quit();
    }
}
