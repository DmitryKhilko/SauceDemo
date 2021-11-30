package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CriticalPathTest extends BaseTest {

    @Test(priority = 1, description = "positive")
    public void itemAddToCart() {

        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        Assert.assertEquals(inventoryPage.getHeaderTitleText(), "PRODUCTS", "Мы не перешли на страницу inventory.html");

        String itemName1 = "Sauce Labs Onesie";
        String itemName2 = "Sauce Labs Fleece Jacket";
        String itemName3 = "Sauce Labs Backpack";

        List<String> itemsSelected = new ArrayList<>();
        itemsSelected.add(itemName1 + inventoryPage.getItemPrice(itemName1));
        itemsSelected.add(itemName2 + inventoryPage.getItemPrice(itemName2));
        itemsSelected.add(itemName3 + inventoryPage.getItemPrice(itemName3));
        Collections.sort(itemsSelected);
        //System.out.println(itemsSelected);

        inventoryPage.addToCart(itemName1);
        inventoryPage.addToCart(itemName2);
        inventoryPage.addToCart(itemName3);

        cartPage.openCartPage();
        Assert.assertEquals(cartPage.getHeaderTitleText(), "YOUR CART", "Мы не перешли на страницу cart.html");

        List<String> itemsInCart = new ArrayList<>();
        itemsInCart.add(cartPage.getItemNameInCart(1) + cartPage.getItemPriceInCart(1));
        itemsInCart.add(cartPage.getItemNameInCart(2) + cartPage.getItemPriceInCart(2));
        itemsInCart.add(cartPage.getItemNameInCart(3) + cartPage.getItemPriceInCart(3));
        Collections.sort(itemsInCart);
        //System.out.println(itemsInCart);

        Assert.assertEquals(itemsInCart.get(0), itemsSelected.get(0), "Выбранного товара нет в корзине");
        Assert.assertEquals(itemsInCart.get(1), itemsSelected.get(1), "Выбранного товара нет в корзине");
        Assert.assertEquals(itemsInCart.get(2), itemsSelected.get(2), "Выбранного товара нет в корзине");
    }

    @Test(priority = 2, description = "positive")
    public void itemCountInCart() {

        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        Assert.assertEquals(inventoryPage.getHeaderTitleText(), "PRODUCTS", "Мы не перешли на страницу inventory.html");

        Integer itemsSelectedCount = 4;
        String itemName1 = "Sauce Labs Onesie";
        String itemName2 = "Sauce Labs Fleece Jacket";
        String itemName3 = "Sauce Labs Backpack";
        String itemName4 = "Sauce Labs Bike Light";

        inventoryPage.addToCart(itemName1);
        inventoryPage.addToCart(itemName2);
        inventoryPage.addToCart(itemName3);
        inventoryPage.addToCart(itemName4);

        cartPage.openCartPage();
        Assert.assertEquals(cartPage.getHeaderTitleText(), "YOUR CART", "Мы не перешли на страницу cart.html");

        //System.out.println(cartPage.getCartLinkCount());
        //System.out.println(cartPage.getItemsCountInCart());
        Assert.assertEquals(cartPage.getCartLinkCount(), Integer.toString(itemsSelectedCount), "Выбранное руками количество товара не соответствует количеству товара в корзине");
        Assert.assertEquals(cartPage.getItemsCountInCart(), itemsSelectedCount, "Выбранное руками количество товара не соответствует количеству товара на иконке корзины");
    }
}
