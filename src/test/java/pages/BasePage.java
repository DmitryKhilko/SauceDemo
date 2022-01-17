package pages;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;

public class BasePage {

    public static final String BASE_URL = "https://www.saucedemo.com/"; //Вынесли по причине того, что адрес может изменится и изменим только в одном месте.
    public static final String INVENTORY_URL = "https://www.saucedemo.com/inventory.html";
    ITestContext context;
    WebDriver driver;

    public BasePage(ITestContext context) {
        this.context = context;
        driver = (WebDriver) context.getAttribute("driver");
    }
}
