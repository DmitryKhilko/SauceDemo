package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestContext;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Log4j2
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
    public InventoryPage(ITestContext driver) {
        super(driver);
    }

    //Описываем методы, характерные для страницы

    //Метод открытия страницы
    @Step("Открыть страницу https://www.saucedemo.com/inventory.html")
    public void open() {
        log.debug("Тест " + context.getAttribute("testName") + ": открыть страницу " + INVENTORY_URL);
        driver.get(INVENTORY_URL);
    }

    //Метод определения заголовка страницы
    @Step("Определить заголовок страницы")
    public String getHeaderTitleText() {
        log.debug("Тест " + context.getAttribute("testName") + ": определить заголовок страницы " + INVENTORY_URL);
        return driver.findElement(HEADER_TITLE_INVENTORY).getText();
    }

    //Метод, который определяет первый товар на странице PRODUCT
    @Step("Определить название первого товара на странице")
    public String getFirstItemInventory() {
        log.debug("Тест " + context.getAttribute("testName") + ": определить название первого товара на странице");
        return driver.findElements(FIRST_ITEM_INVENTORY).get(0).getText();
    }

    //Метод, который определяет цену первого товара на странице PRODUCT
    @Step("Определить цену первого товара на странице")
    public String getPriceFirstItemInventory() {
        log.debug("Тест " + context.getAttribute("testName") + ": определить цену первого товара на странице");
        return driver.findElements(PRICE_FIRST_ITEM_INVENTORY).get(0).getText();
    }

    //Метод определения цены выбранного продукта по имени товара
    @Step("Определить цену выбранного товара по его имени")
    public String getItemPrice(String itemName) {
        log.debug("Тест " + context.getAttribute("testName") + ": определить цену выбранного товара " + itemName);
        return driver.findElement(By.xpath(String.format(PRICE_ITEM, itemName))).getText();
    }

    //Метод добавления в корзину
    @Step("Добавить выбранный товар в корзину")
    public void addToCart(String itemName) {
        log.debug("Тест " + context.getAttribute("testName") + ": добавить товар " + itemName + " в корзину");
        driver.findElement(By.xpath(String.format(ADD_ITEM_BUTTONS, itemName))).click();
    }

    //Метод, который выбирает на странице PRODUCT сортировку товара: A TO Z
    @Step("Выбрать из раскрывающегося списка сотрировку товаров: A TO Z")
    public void sortItemInventoryAZ() {
        log.debug("Тест " + context.getAttribute("testName") + ": выбрать из раскрывающегося списка сотрировку товаров: A TO Z");
        Select dropDownSort = new Select(driver.findElement(PRODUCT_SORT_CONTAINER));
        dropDownSort.selectByIndex(0);
    }

    //Метод, который позволяет проверить правильность сортировки: A TO Z
    //1. содержимое страницы inventory.html заносит в List (findElements)
    //2. сортирует List сортирует (A TO Z)
    //3. выдает первый элемент List для последующего сравнения с первым элементом на странице PRODUCT после ее сортировки
    @Step("Проверить правильность сортировки товаров 'A TO Z'")
    public String getFirstItemAZ() {
        log.debug("Тест " + context.getAttribute("testName") + ": проверить правильность сортировки товаров 'A TO Z'");
        List<WebElement> itemsInventory = driver.findElements(ITEMS_INVENTORY);
        List<String> itemsInInventory = new ArrayList<>();
        for (WebElement webElement : itemsInventory) itemsInInventory.add(webElement.getText());
        Collections.sort(itemsInInventory); //Сортировка по возрастанию
        return itemsInInventory.get(0);
    }

    //Метод, который выбирает на странице PRODUCT сортировку товара: Z TO A
    @Step("Выбрать из раскрывающегося списка сотрировку товаров: Z TO A")
    public void sortItemInventoryZA() {
        log.debug("Тест " + context.getAttribute("testName") + ": выбрать из раскрывающегося списка сотрировку товаров: Z TO A");
        Select dropDownSort = new Select(driver.findElement(PRODUCT_SORT_CONTAINER));
        dropDownSort.selectByIndex(1);
    }

    //Метод, который позволяет проверить правильность сортировки: Z TO A
    @Step("Проверить правильность сортировки товаров 'Z TO A'")
    public String getFirstItemZA() {
        log.debug("Тест " + context.getAttribute("testName") + ": проверить правильность сортировки товаров 'Z TO A'");
        List<WebElement> itemsInventory = driver.findElements(ITEMS_INVENTORY);
        List<String> itemsInInventory = new ArrayList<>();
        for (WebElement webElement : itemsInventory) itemsInInventory.add(webElement.getText());
        itemsInInventory.sort(Collections.reverseOrder()); //Сортировка по убыванию
        return itemsInInventory.get(0);
    }

    //Метод, который выбирает на странице PRODUCT сортировку товара: Price (high to low)
    @Step("Выбрать из раскрывающегося списка сотрировку товаров: Price (high to low)")
    public void sortItemInventoryHiLo() {
        log.debug("Тест " + context.getAttribute("testName") + ": выбрать из раскрывающегося списка сотрировку товаров: Price (high to low)");
        Select dropDownSort = new Select(driver.findElement(PRODUCT_SORT_CONTAINER));
        dropDownSort.selectByIndex(3);
    }

    //Метод, который позволяет проверить правильность сортировки: Price (high to low)
    //Все цены загоняет в List, преобразует их в дробные числа, сортирует по убыванию,
    //выводит самую большую цену, преобразованную опять в формат сайта - "$9.99"
    @Step("Проверить правильность сортировки товаров 'Price (high to low)'")
    public String getMaxPriceInInventory() {
        log.debug("Тест " + context.getAttribute("testName") + ": проверить правильность сортировки товаров 'Price (high to low)' - первый товар с наибольшей ценой");
        List<WebElement> pricesInventory = driver.findElements(PRICES_INVENTORY);
        List<Double> pricesInInventory = new ArrayList<>();
        // Что я делаю тут: "Double.parseDouble(webElement.getText().substring(1))"
        //На сайте цены даны в виде текста $9.99. Мне данный текст нужно конвертировать в дробное число (Double):
        //1. "webElement.getText().substring(1)" - я отбрасываю "$"
        //2. "Double.parseDouble(" - преобразую текст "9.99" в дробное число 9,99
        for (WebElement webElement : pricesInventory)
            pricesInInventory.add(Double.parseDouble(webElement.getText().substring(1)));
        pricesInInventory.sort(Collections.reverseOrder()); //Сортировка по убыванию
        //А потом мы возвращаем цену к виду "$9.99", чтобы сравнить с ценой первого товара на сайте
        return "$" + pricesInInventory.get(0);
    }

    //Метод, который выбирает на странице PRODUCT сортировку товара: Price (low to high)
    @Step("Выбрать из раскрывающегося списка сотрировку товаров: Price (low to high)")
    public void sortItemInventoryLoHi() {
        log.debug("Тест " + context.getAttribute("testName") + ": выбрать из раскрывающегося списка сотрировку товаров: Price (low to high)");
        Select dropDownSort = new Select(driver.findElement(PRODUCT_SORT_CONTAINER));
        dropDownSort.selectByIndex(2);
    }
    //Метод, который позволяет проверить правильность сортировки: Price (low to high)
    @Step("Проверить правильность сортировки товаров 'Price (low to high)'")
    public String getMinPriceInInventory() {
        log.debug("Тест " + context.getAttribute("testName") + ": проверить правильность сортировки товаров 'Price (low to high)' - первый товар с наименьшей ценой");
        List<WebElement> pricesInventory = driver.findElements(PRICES_INVENTORY);
        List<Double> pricesInInventory = new ArrayList<>();
        for (WebElement webElement : pricesInventory)
            pricesInInventory.add(Double.parseDouble(webElement.getText().substring(1)));
        Collections.sort(pricesInInventory); //Сортировка по возрастанию
        return "$" + pricesInInventory.get(0);
    }

    //Метод, который содержимое страницы inventory.html заносит в List (findElements)
    //и List сортирует по возрастанию или убыванию
    @Step("Отсортировать список товаров на странице по возрастанию")
    public List<String> getItemsInventory() {
        log.debug("Тест " + context.getAttribute("testName") + ": отсортировать список товаров на странице по возрастанию");
        List<WebElement> itemsInventory = driver.findElements(ITEMS_INVENTORY);
        List<String> itemsInInventory = new ArrayList<>();
        for (WebElement webElement : itemsInventory) itemsInInventory.add(webElement.getText());
        //Сортировка по возрастанию
        Collections.sort(itemsInInventory);
        //Сортировка по убыванию
        //itemsInInventory.sort(Collections.reverseOrder());
        return itemsInInventory;
    }
}
