package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    public static final String BASE_URL = "https://www.saucedemo.com/"; //Вынесли по причине того, что адрес может изменится и изменим только в одном месте.
    WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }
}
