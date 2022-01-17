package tests;

import lombok.extern.log4j.Log4j2;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.AllureUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Log4j2
public class CriticalPathTest extends BaseTest {

    @Test(priority = 1, description = "Добавление трёх товаров в корзину")
    public void addItemToCart() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");

        List<String> itemsSelected = new ArrayList<>();
        itemsSelected.add(ITEM_NAME1);
        itemsSelected.add(ITEM_NAME2);
        itemsSelected.add(ITEM_NAME3);
        Collections.sort(itemsSelected);
        //System.out.println(itemsSelected);

        inventoryPage.addToCart(ITEM_NAME1);
        inventoryPage.addToCart(ITEM_NAME2);
        inventoryPage.addToCart(ITEM_NAME3);

        burgerMenuPage.openCartPage();
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
        AllureUtils.takeScreenshot(driver); //Принудительно выводим скриншот
    }

    @Test(priority = 2, description = "Удаление товаров из корзины")
    public void deleteAllItemFromCart() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");

        inventoryPage.addToCart(ITEM_NAME1);
        inventoryPage.addToCart(ITEM_NAME2);
        inventoryPage.addToCart(ITEM_NAME3);

        burgerMenuPage.openCartPage();
        cartPage.deleteItemFromCart(ITEM_NAME1);
        cartPage.deleteItemFromCart(ITEM_NAME2);
        cartPage.deleteItemFromCart(ITEM_NAME3);

        Assert.assertEquals(cartPage.getRemainItemsCart(), 0, "Из корзине не удалены все товары");
        AllureUtils.takeScreenshot(driver); //Принудительно выводим скриншот
    }
}
