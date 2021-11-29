package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {

    public static final By HEADER_TITLE_CART = By.xpath("//span[@class='title']");
    public static final By CART_LINK = By.xpath("//a[@class='shopping_cart_link']");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    //Метод открытия страницы cart.html
    public void openCart() {
        driver.findElement(CART_LINK).click();
    }

    //Метод определения заголовка страницы
    public String getHeaderTitleText() {
        return driver.findElement(HEADER_TITLE_CART).getText();
    }
}
