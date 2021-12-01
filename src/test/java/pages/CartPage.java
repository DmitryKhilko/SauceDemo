package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CartPage extends BasePage {
    public static final By HEADER_TITLE_CART = By.xpath("//span[@class='title']");
    public static final By CART_LINK = By.xpath("//a[@class='shopping_cart_link']");
    public static final By CART_LINK_COUNT = By.xpath("//a[@class='shopping_cart_link']//span[@class='shopping_cart_badge']");
    public static final By ITEM_CART_COUNT = By.xpath("//div[@class='cart_item']");
    public static final By ITEMS_CART = By.xpath("//div[@class='cart_list']//div[@class='inventory_item_name']");
    public static final String PRICE_ITEM_CART = "//div[@class='inventory_item_name' and text()='%s']/../../..//div[@class='inventory_item_price']";
    public static final String ITEM_CART_REMOVE_BUTTON = "//div[@class='inventory_item_name' and text()='%s']/../../..//button";

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

    //Метод определения цены товара в корзине
    public String getItemPriceInCart(String itemNameInCart) {
        return driver.findElement(By.xpath(String.format(PRICE_ITEM_CART, itemNameInCart))).getText();
    }

    //Метод удаления товара, находясь на странице cart.html
    public void deleteItemFromCart(String itemNameInCart) {
        driver.findElement(By.xpath(String.format(ITEM_CART_REMOVE_BUTTON, itemNameInCart))).click();
    }

    //Метод, который содержимое корзины помещает в List (findElements)
    public List<String> getItemsCart() {
        List<WebElement> itemsCart = driver.findElements(ITEMS_CART);
        List<String> itemsInCart = new ArrayList<>();
        for (WebElement webElement : itemsCart) itemsInCart.add(webElement.getText());
        //Сортировка по возрастанию
        Collections.sort(itemsInCart);
        //Сортировка по убыванию
        //itemsInCart.sort(Collections.reverseOrder());
        return itemsInCart;
    }
}
