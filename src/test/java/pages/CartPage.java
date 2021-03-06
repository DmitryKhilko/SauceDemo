package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.ITestContext;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Log4j2
public class CartPage extends BasePage {
    public static final By HEADER_TITLE_CART = By.xpath("//span[@class='title']");
    public static final By CART_LINK_COUNT = By.xpath("//a[@class='shopping_cart_link']//span[@class='shopping_cart_badge']");
    public static final By ITEM_CART_COUNT = By.xpath("//div[@class='cart_item']");
    public static final By ITEMS_CART = By.xpath("//div[@class='cart_list']//div[@class='inventory_item_name']");
    public static final String PRICE_ITEM_CART = "//div[@class='inventory_item_name' and text()='%s']/../../..//div[@class='inventory_item_price']";
    public static final String ITEM_CART_REMOVE_BUTTON = "//div[@class='inventory_item_name' and text()='%s']/../../..//button";

    public CartPage(ITestContext driver) {
        super(driver);
    }

    //Метод определения заголовка страницы cart.html
    @Step("Определить заголовок страницы https://www.saucedemo.com/cart.html")
    public String getHeaderTitleText() {
        log.debug("Тест " + context.getAttribute("testName") + ": определить заголовок страницы https://www.saucedemo.com/cart.html");
        return driver.findElement(HEADER_TITLE_CART).getText();
    }

    //Метод определения количества товаров в карзине (по цифре на иконке корзины)
    @Step("Определить количество товаров в корзине (по цифре на иконке корзины)")
    public String getCartLinkCount() {
        log.debug("Тест " + context.getAttribute("testName") + ": определить количество товаров в корзине (по цифре на иконке корзины)");
        return driver.findElement(CART_LINK_COUNT).getText();
    }

    //Метод подстчета товаров в корзине (по числу текстовых блоков c товаром)
    @Step("Определить количество товаров в корзине (по числу текстовых блоков c товаром)")
    public Integer getItemsCountInCart() {
        log.debug("Тест " + context.getAttribute("testName") + ": определить количество товаров в корзине (по числу текстовых блоков c товаром)");
        List<WebElement> item = driver.findElements(ITEM_CART_COUNT);
        return item.size();
    }

    //Метод определения цены товара в корзине
    @Step("Определить цену товара, находящегося в корзине")
    public String getItemPriceInCart(String itemNameInCart) {
        log.debug("Тест " + context.getAttribute("testName") + ": определить цену товара " + itemNameInCart + ", находящегося в корзине");
        return driver.findElement(By.xpath(String.format(PRICE_ITEM_CART, itemNameInCart))).getText();
    }

    //Метод удаления товара, находясь на странице cart.html
    @Step("Удалить товар, находящийся в корзине")
    public void deleteItemFromCart(String itemNameInCart) {
        log.debug("Тест " + context.getAttribute("testName") + ": удалить товар " + itemNameInCart + ", находящийся в корзине");
        driver.findElement(By.xpath(String.format(ITEM_CART_REMOVE_BUTTON, itemNameInCart))).click();
    }

    //Метод, который содержимое корзины помещает в List (findElements)
    public List<String> getItemsCart() {
        List<WebElement> itemsCart = driver.findElements(ITEMS_CART);
        List<String> itemsInCart = new ArrayList<>();
        for (WebElement webElement : itemsCart) itemsInCart.add(webElement.getText());
        //Сортировка по возрастанию
        Collections.sort(itemsInCart);
        return itemsInCart;
    }

    //Метод, который вычисляет остаток товаров в корзине
    @Step("Определить остаток товаров в корзине")
    public int getRemainItemsCart() {
        log.debug("Тест " + context.getAttribute("testName") + ": определить остаток товаров в корзине");
        return driver.findElements(ITEMS_CART).size();
    }
}
