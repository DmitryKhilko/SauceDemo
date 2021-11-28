package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InventoryPage extends BasePage {

    //Перечисляем локаторы, которые будут использованы на странице
    //Именовать константы также, как их именуют разработчики в HTML-коде
    public static final By HEADER_TITLE_INVENTORY = By.xpath("//span[@class='title']");
    public static final String ADD_ITEM_BUTTONS = "//div[div[a[div[@class='inventory_item_name' and text() ='%s']]]]//button";
    public static final String PRICE_ITEM = "//div[div[a[div[@class='inventory_item_name' and text() ='%s']]]]//div[@class='inventory_item_price']";
    public static final By CART_LINK = By.xpath("//a[@class='shopping_cart_link']");

    //Создаем конструктор, который позволит при создании класса InventoryPage назначать ему driver
    public InventoryPage(WebDriver driver) {
        super(driver);
    }

    //Описываем методы, характерные для страницы
    //Метод открытия страницы cart.html
    public void openCart() {
        driver.findElement(CART_LINK).click();
    }

    //Метод определения цены выбранного продукта
    public void getPriceItem(String itemPrice) {
        driver.findElement(By.xpath(String.format(PRICE_ITEM, itemPrice))).getText();
    }

    //Метод добавления в корзину
    public void addToCart(String itemName) {
        driver.findElement(By.xpath(String.format(ADD_ITEM_BUTTONS, itemName))).click();
    }

    //Метод удаления с корзины не выходя со страницы
    public void removeFromCart() {

    }

    //Метод определения заголовка страницы
    public String getHeaderTitleText() {
        return driver.findElement(HEADER_TITLE_INVENTORY).getText();
    }
}
