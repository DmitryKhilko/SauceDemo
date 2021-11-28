package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {

    public static final By HEADER_TITLE_CART = By.xpath("//span[@class='title']");

    public CartPage(WebDriver driver) {
        super(driver);
    }

}
