package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CartPage extends BasePage {
    public static final By HEADER_TITLE_CART = By.xpath("//span[@class='title']");
    public static final By CART_LINK = By.xpath("//a[@class='shopping_cart_link']");
    public static final By CART_LINK_COUNT = By.xpath("//a[@class='shopping_cart_link']//span[@class='shopping_cart_badge']");
    public static final By ITEM_CART_COUNT = By.xpath("//div[@class='cart_item']");
    public static final String ITEM_CART = "//div[@class='cart_item'][%s]//div[@class='inventory_item_name']";
    public static final String PRICE_ITEM_CART = "//div[@class='inventory_item_name' and text()='%s']/../../..//div[@class='inventory_item_price']";

    public CartPage(WebDriver driver) {
        super(driver);
    }

    //Метод определения видимости иконки корзины на текущей странице
    public Boolean getDisplayedCartLink() {
        return driver.findElement(CART_LINK).isDisplayed();
    }

    //Метод открытия страницы cart.html
    public void openCartPage() {
        driver.findElement(CART_LINK).click();
    }

    //Метод определения заголовка страницы cart.html
    public String getHeaderTitleText() {
        return driver.findElement(HEADER_TITLE_CART).getText();
    }

    //Метод определения количества товаров в карзине (по цифре на иконке корзины)
    public String getCartLinkCount() {
        return driver.findElement(CART_LINK_COUNT).getText();
    }

    //Метод подстчета товаров в корзине (по числу текстовых блоков c товаром)
    public Integer getItemsCountInCart() {
        List<WebElement> item = driver.findElements(ITEM_CART_COUNT);
        return item.size();
    }

    //Метод определения наименования товара в корзине
    public String getItemNameInCart(int itemNameInCart) {
        return driver.findElement(By.xpath(String.format(ITEM_CART, itemNameInCart))).getText();
    }

    //Метод определения цены товара в корзине
    public String getItemPriceInCart(String itemNameInCart) {
        return driver.findElement(By.xpath(String.format(PRICE_ITEM_CART, itemNameInCart))).getText();
    }
}
