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

        String itemName1 = "Sauce Labs Onesie";
        String itemName2 = "Sauce Labs Fleece Jacket";
        String itemName3 = "Sauce Labs Backpack";

        List<String> itemsSelected = new ArrayList<>();
        itemsSelected.add(itemName1);
        itemsSelected.add(itemName2);
        itemsSelected.add(itemName3);
        Collections.sort(itemsSelected);
        //System.out.println(itemsSelected);

        inventoryPage.addToCart(itemName1);
        //Добавлил задержку, так периодически не добавляется 3 товара, а только 2
        Thread.sleep(2000);
        inventoryPage.addToCart(itemName2);
        Thread.sleep(2000);
        inventoryPage.addToCart(itemName3);

        cartPage.openCartPage();

        List<String> itemsInCart = new ArrayList<>();
        itemsInCart.add(cartPage.getItemNameInCart(1));
        itemsInCart.add(cartPage.getItemNameInCart(2));
        itemsInCart.add(cartPage.getItemNameInCart(3));
        Collections.sort(itemsInCart);
        //System.out.println(itemsInCart);

        Assert.assertEquals(itemsInCart.get(0), itemsSelected.get(0), "Выбранного товара нет в корзине");
        Assert.assertEquals(cartPage.getItemPriceInCart(itemsInCart.get(0)), inventoryPage.getItemPrice(itemsSelected.get(0)), "Цена выбранного товара не совпадает с ценой соответствующего товара в корзине");

        Assert.assertEquals(itemsInCart.get(1), itemsSelected.get(1), "Выбранного товара нет в корзине");
        Assert.assertEquals(cartPage.getItemPriceInCart(itemsInCart.get(1)), inventoryPage.getItemPrice(itemsSelected.get(1)), "Цена выбранного товара не совпадает с ценой соответствующего товара в корзине");

        Assert.assertEquals(itemsInCart.get(2), itemsSelected.get(2), "Выбранного товара нет в корзине");
        Assert.assertEquals(cartPage.getItemPriceInCart(itemsInCart.get(2)), inventoryPage.getItemPrice(itemsSelected.get(2)), "Цена выбранного товара не совпадает с ценой соответствующего товара в корзине");
    }

    @Test(priority = 2, description = "Сверка количества товаров в корзине и счетчика на иконке корзины")
    public void itemCountInCart() throws InterruptedException {

        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");

        Integer itemsSelectedCount = 4;
        String itemName1 = "Sauce Labs Onesie";
        String itemName2 = "Sauce Labs Fleece Jacket";
        String itemName3 = "Sauce Labs Backpack";
        String itemName4 = "Sauce Labs Bike Light";

        //Добавлил задержку, так периодически не добавляется 4 товара, а меньше
        Thread.sleep(2000);
        inventoryPage.addToCart(itemName1);
        Thread.sleep(2000);
        inventoryPage.addToCart(itemName2);
        Thread.sleep(2000);
        inventoryPage.addToCart(itemName3);
        Thread.sleep(2000);
        inventoryPage.addToCart(itemName4);

        cartPage.openCartPage();

        //System.out.println(cartPage.getCartLinkCount());
        //System.out.println(cartPage.getItemsCountInCart());
        Assert.assertEquals(cartPage.getCartLinkCount(), Integer.toString(itemsSelectedCount), "Выбранное руками количество товара не соответствует количеству товара в корзине");
        Assert.assertEquals(cartPage.getItemsCountInCart(), itemsSelectedCount, "Выбранное руками количество товара не соответствует количеству товара на иконке корзины");
    }
}
