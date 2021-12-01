package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InventoryPage extends BasePage {
    //Перечисляем локаторы, которые будут использованы на странице
    //Именовать константы также, как их именуют разработчики в HTML-коде
    public static final By HEADER_TITLE_INVENTORY = By.xpath("//span[@class='title']");
    public static final String ADD_ITEM_BUTTONS = "//div[div[a[div[@class='inventory_item_name' and text() ='%s']]]]//button";
    //%s - это подстановка, потом вместо данной переменной будет подставляться название товара
    //Потом это вставится в конструкцию String.format(ADD_ITEM_BUTTONS, itemName), где itemName - название товара
    public static final String PRICE_ITEM = "//div[div[a[div[@class='inventory_item_name' and text() ='%s']]]]//div[@class='inventory_item_price']";
    public static final By ITEMS_INVENTORY = By.xpath("//div[@class='inventory_list']//div[@class='inventory_item_name']");
    public static final By PRICES_INVENTORY = By.xpath("//div[@class='inventory_list']//div[@class='inventory_item_price']");
    public static final By FIRST_ITEM_INVENTORY = By.xpath("//div[@class='inventory_list']//div[@class='inventory_item_name'][1]");
    public static final By PRICE_FIRST_ITEM_INVENTORY = By.xpath("//div[@class='inventory_list']//div[@class='inventory_item_price'][1]");
    public static final By PRODUCT_SORT_CONTAINER = By.xpath("//select[@class='product_sort_container']");

    //Создаем конструктор, который позволит при создании класса InventoryPage назначать ему driver
    public InventoryPage(WebDriver driver) {
        super(driver);
    }

    //Описываем методы, характерные для страницы
    //Метод определения заголовка страницы
    public String getHeaderTitleText() {
        return driver.findElement(HEADER_TITLE_INVENTORY).getText();
    }

    //Метод, который определяет первый товар на странице PRODUCT
    public String getFirstItemInventory() {
        return driver.findElements(FIRST_ITEM_INVENTORY).get(0).getText();
    }

    //Метод, который определяет цену первого товара на странице PRODUCT
    public String getPriceFirstItemInventory() {
        return driver.findElements(PRICE_FIRST_ITEM_INVENTORY).get(0).getText();
    }

    //Метод определения цены выбранного продукта по имени товара
    public String getItemPrice(String itemName) {
        return driver.findElement(By.xpath(String.format(PRICE_ITEM, itemName))).getText();
    }

    //Метод добавления в корзину
    public void addToCart(String itemName) {
        driver.findElement(By.xpath(String.format(ADD_ITEM_BUTTONS, itemName))).click();
    }

    //Метод, который выбирает на странице PRODUCT сортировку товара: A TO Z
    public void sortItemInventoryAZ() {
        Select dropDownSort = new Select(driver.findElement(PRODUCT_SORT_CONTAINER));
        dropDownSort.selectByIndex(0);
    }

    //Метод, который позволяет проверить правильность сортировки: A TO Z
    //1. содержимое страницы inventory.html заносит в List (findElements)
    //2. сортирует List сортирует (A TO Z)
    //3. выдает первый элемент List для последующего сравнения с первым элементом на странице PRODUCT после ее сортировки
    public String getFirstItemAZ() {
        List<WebElement> itemsInventory = driver.findElements(ITEMS_INVENTORY);
        List<String> itemsInInventory = new ArrayList<>();
        for (WebElement webElement : itemsInventory) itemsInInventory.add(webElement.getText());
        Collections.sort(itemsInInventory); //Сортировка по возрастанию
        return itemsInInventory.get(0);
    }

    //Метод, который выбирает на странице PRODUCT сортировку товара: Z TO A
    public void sortItemInventoryZA() {
        Select dropDownSort = new Select(driver.findElement(PRODUCT_SORT_CONTAINER));
        dropDownSort.selectByIndex(1);
    }

    //Метод, который позволяет проверить правильность сортировки: Z TO A
    public String getFirstItemZA() {
        List<WebElement> itemsInventory = driver.findElements(ITEMS_INVENTORY);
        List<String> itemsInInventory = new ArrayList<>();
        for (WebElement webElement : itemsInventory) itemsInInventory.add(webElement.getText());
        itemsInInventory.sort(Collections.reverseOrder()); //Сортировка по убыванию
        return itemsInInventory.get(0);
    }

    //Метод, который выбирает на странице PRODUCT сортировку товара: Price (high to low)
    public void sortItemInventoryHiLo() {
        Select dropDownSort = new Select(driver.findElement(PRODUCT_SORT_CONTAINER));
        dropDownSort.selectByIndex(3);
    }

    //Метод, который позволяет проверить правильность сортировки: Price (high to low)
    //Все цены загоняет в List, преобразует их в дробные числа, сортирует по убыванию,
    //выводит самую большую цену, преобразованную опять в формат сайта - "$9.99"
    public String getMaxPriceInInventory() {
        List<WebElement> pricesInventory = driver.findElements(PRICES_INVENTORY);
        List<Double> pricesInInventory = new ArrayList<>();
        // Что я делаю тут: "Double.parseDouble(webElement.getText().substring(1))"
        //На сайте цены даны в виде текста $9.99. Мне данный текст нужно конвертировать в дробное число (Double):
        //1. "webElement.getText().substring(1)" - я отбразываю "$"
        //2. "Double.parseDouble(" - преобразую текст "9.99" в дробное число 9,99
        for (WebElement webElement : pricesInventory) pricesInInventory.add(Double.parseDouble(webElement.getText().substring(1)));
        pricesInInventory.sort(Collections.reverseOrder()); //Сортировка по убыванию
        //А потом мы возвращаем цену к виду "$9.99", чтобы сравнить с ценой первого товара на сайте
        return "$"+pricesInInventory.get(0);
    }

    //Метод, который выбирает на странице PRODUCT сортировку товара: Price (low to high)
    public void sortItemInventoryLoHi() {
        Select dropDownSort = new Select(driver.findElement(PRODUCT_SORT_CONTAINER));
        dropDownSort.selectByIndex(2);
    }

    public String getMinPriceInInventory() {
        List<WebElement> pricesInventory = driver.findElements(PRICES_INVENTORY);
        List<Double> pricesInInventory = new ArrayList<>();
        for (WebElement webElement : pricesInventory) pricesInInventory.add(Double.parseDouble(webElement.getText().substring(1)));
        Collections.sort(pricesInInventory); //Сортировка по возрастанию
        return "$"+pricesInInventory.get(0);
    }

//    //Метод, который содержимое страницы inventory.html заносит в List (findElements)
//    //и List сортирует по возрастанию или убыванию
//    public List<String> getItemsInventory() {
//        List<WebElement> itemsInventory = driver.findElements(ITEMS_INVENTORY);
//        List<String> itemsInInventory = new ArrayList<>();
//        for (WebElement webElement : itemsInventory) itemsInInventory.add(webElement.getText());
//        //Сортировка по возрастанию
//        Collections.sort(itemsInInventory);
//        //Сортировка по убыванию
//        //itemsInInventory.sort(Collections.reverseOrder());
//        return itemsInInventory;
//    }
}
