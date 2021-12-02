package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CriticalPathTest extends BaseTest {

    @Test(priority = 1, description = "Добавление трёх товаров в корзину")
    public void itemAddToCart() throws InterruptedException {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");

        List<String> itemsSelected = new ArrayList<>();
        itemsSelected.add(itemName1);
        itemsSelected.add(itemName2);
        itemsSelected.add(itemName3);
        Collections.sort(itemsSelected);
        //System.out.println(itemsSelected);

        //Добавлил задержку, так периодически не добавляется 3 товара, а только 2
        Thread.sleep(2000);
        inventoryPage.addToCart(itemName1);
        Thread.sleep(2000);
        inventoryPage.addToCart(itemName2);
        Thread.sleep(2000);
        inventoryPage.addToCart(itemName3);

        cartPage.openCartPage();

//        System.out.println("Товары в козине");
//        for (int i=0; i<cartPage.getItemsCart().size();i++){
//            System.out.println(cartPage.getItemsCart().get(i));
//        }

        Assert.assertEquals(cartPage.getItemsCart().get(0), itemsSelected.get(0), "Выбранного товара нет в корзине");
        Assert.assertEquals(cartPage.getItemPriceInCart(cartPage.getItemsCart().get(0)), inventoryPage.getItemPrice(itemsSelected.get(0)), "Цена выбранного товара не совпадает с ценой соответствующего товара в корзине");
        Assert.assertEquals(cartPage.getItemsCart().get(1), itemsSelected.get(1), "Выбранного товара нет в корзине");
        Assert.assertEquals(cartPage.getItemPriceInCart(cartPage.getItemsCart().get(1)), inventoryPage.getItemPrice(itemsSelected.get(1)), "Цена выбранного товара не совпадает с ценой соответствующего товара в корзине");
        Assert.assertEquals(cartPage.getItemsCart().get(2), itemsSelected.get(2), "Выбранного товара нет в корзине");
        Assert.assertEquals(cartPage.getItemPriceInCart(cartPage.getItemsCart().get(2)), inventoryPage.getItemPrice(itemsSelected.get(2)), "Цена выбранного товара не совпадает с ценой соответствующего товара в корзине");
    }

    //Тест - удаление всех товаров с корзины (как со страницы PRODUCT, так и из корзины
    //div[@class='cart_list']//div[@class='inventory_item_name'] - это товар в корзине.
    // После добавления в корзину, создаем List из товаров. Его size() будет больше 0.
    // Проверить, если после удаления ввсех товаров мотод создания List будет создавать просто пустой массив (size = 0), то с помощью этого
    // можно сделать проверку. Это оптимально будет... Просто он может начать ругаться, что не находит таких элементов...
    // Там конечно появляются "<div class="removed_cart_item"></div>" - можно подсчитать их количество. Если оно будет равно изначально добавленному - значит корзина пуста.

// Класс!!! Мы все кнопки удалили с экрана, а потом пытаемся сформировать List из кнопок
// Программа поискала и выдала, что их нет - size() = 0!!!!
/// Так можно и пункты меню искать при ролевых моделях
//    @Test
//    public void addRemoveElements() {
//        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
//        WebElement cmdAddElement = driver.findElement(By.xpath(cmdAddElementLocator));
//        cmdAddElement.click();
//        cmdAddElement.click();
//        List<WebElement> cmdDelete = driver.findElements(By.xpath(cmdDeleteLocator));
//        Assert.assertEquals(cmdDelete.size(), 2, "Количество элементов не равно 2");
//
//        cmdDelete.get(1).click();
//        cmdDelete = driver.findElements(By.xpath(cmdDeleteLocator));
//        Assert.assertEquals(cmdDelete.size(), 1, "Количество элементов не равно 1");
//
//        cmdDelete.get(0).click();
//        cmdDelete = driver.findElements(By.xpath(cmdDeleteLocator));
//        Assert.assertEquals(cmdDelete.size(), 0, "Количество элементов не равно 0");
//    }
//
//    java.lang.AssertionError: Количество элементов не равно 0
//    Expected :1
//    Actual   :0






}
