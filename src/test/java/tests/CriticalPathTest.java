package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CriticalPathTest extends BaseTest {
    @Test(priority = 1, description = "Добавление трёх товаров в корзину")
    public void itemAddToCart() throws InterruptedException {
        String itemName1 = "Sauce Labs Onesie";
        String itemName2 = "Sauce Labs Fleece Jacket";
        String itemName3 = "Sauce Labs Backpack";

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
        Integer itemsSelectedCount = 4;
        String itemName1 = "Sauce Labs Onesie";
        String itemName2 = "Sauce Labs Fleece Jacket";
        String itemName3 = "Sauce Labs Backpack";
        String itemName4 = "Sauce Labs Bike Light";

        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
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
        System.out.println(cartPage.getCartLinkCount());
        System.out.println(cartPage.getItemsCountInCart());
        Assert.assertEquals(cartPage.getCartLinkCount(), Integer.toString(itemsSelectedCount), "Выбранное руками количество товара не соответствует количеству товара в корзине");
        Assert.assertEquals(cartPage.getItemsCountInCart(), itemsSelectedCount, "Выбранное руками количество товара не соответствует количеству товара на иконке корзины");
    }
    @Test(priority = 3, description = "Сверка количества товаров в корзине и счетчика на иконке корзины при удалени товара из корзины, находясь на странице YOUR CART")
    public void itemCountAfterDeleteFromCart() throws InterruptedException {
        Integer itemsRemainInCart = 3; //Количество товара, которое должно остаться после удаления товаров в корзине
        String itemName1 = "Sauce Labs Onesie"; //Добавляемый в корзину товар
        String itemName2 = "Sauce Labs Fleece Jacket"; //Добавляемый в корзину товар
        String itemName3 = "Sauce Labs Backpack"; //Добавляемый в корзину товар
        String itemName4 = "Sauce Labs Bike Light"; //Добавляемый в корзину товар
        String itemDeleteName = "Sauce Labs Fleece Jacket"; //Удаляемый из корзины товар

        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
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
        Thread.sleep(2000);
        cartPage.deleteItemFromCart(itemDeleteName);
        //System.out.println(cartPage.getCartLinkCount());
        //System.out.println(cartPage.getItemsCountInCart());
        Assert.assertEquals(cartPage.getCartLinkCount(), Integer.toString(itemsRemainInCart), "Оставшееся после удаления количество товара в корзине не соответствует ожидаемому остатку товара");
        Assert.assertEquals(cartPage.getItemsCountInCart(), itemsRemainInCart, "Оставшееся после удаления количество товара на иконке корзины не соответствует ожидаемому остатку товара");
    }
}
