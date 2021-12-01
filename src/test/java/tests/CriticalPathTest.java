package tests;

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
}
