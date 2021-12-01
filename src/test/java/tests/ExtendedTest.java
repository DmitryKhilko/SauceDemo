package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ExtendedTest extends BaseTest {

    @Test(priority = 1, description = "Сверка количества товаров в корзине и счетчика на иконке корзины")
    public void itemCountInCart() throws InterruptedException {
        Integer itemsSelectedCount = 2; //Количество добавляемого товара

        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        //Добавлил задержку, так периодически не добавляется 4 товара, а меньше
        Thread.sleep(1000);
        inventoryPage.addToCart(itemName1);
        Thread.sleep(1000);
        inventoryPage.addToCart(itemName2);

        cartPage.openCartPage();
        //System.out.println(cartPage.getCartLinkCount());
        //System.out.println(cartPage.getItemsCountInCart());
        Assert.assertEquals(cartPage.getCartLinkCount(), Integer.toString(itemsSelectedCount), "Выбранное руками количество товара не соответствует количеству товара в корзине");
        Assert.assertEquals(cartPage.getItemsCountInCart(), itemsSelectedCount, "Выбранное руками количество товара не соответствует количеству товара на иконке корзины");
    }

    @Test(priority = 2, description = "Сверка количества товаров в корзине и счетчика на иконке корзины при удалени товара из корзины, находясь на странице YOUR CART")
    public void itemCountAfterDeleteFromCart() throws InterruptedException {
        String itemDeleteName = "Sauce Labs Onesie"; //Удаляемый из корзины товар
        Integer itemsRemainInCart = 1; //Количество товара, которое должно остаться после удаления товаров в корзине

        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        //Добавлил задержку, так периодически не добавляется 4 товара, а меньше
        Thread.sleep(1000);
        inventoryPage.addToCart(itemName1);
        Thread.sleep(1000);
        inventoryPage.addToCart(itemName2);

        cartPage.openCartPage();
        Thread.sleep(1000);
        cartPage.deleteItemFromCart(itemDeleteName);
        //System.out.println(cartPage.getCartLinkCount());
        //System.out.println(cartPage.getItemsCountInCart());
        Assert.assertEquals(cartPage.getCartLinkCount(), Integer.toString(itemsRemainInCart), "Оставшееся после удаления количество товара в корзине не соответствует ожидаемому остатку товара");
        Assert.assertEquals(cartPage.getItemsCountInCart(), itemsRemainInCart, "Оставшееся после удаления количество товара на иконке корзины не соответствует ожидаемому остатку товара");
    }

    @Test(priority = 3, description = "Проверка сортировки товаров на странице PRODUCTS: NAME A TO Z")
    public void itemsInventorySortAZ() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        inventoryPage.sortItemInventoryAZ();
        //System.out.println("Ожидаемый первый товар на странице PRODUCT: "+inventoryPage.getFirstItemAZ());
        //System.out.println("Фактический первый товар на странице PRODUCT: "+inventoryPage.getFirstItemInventory());
        Assert.assertEquals(inventoryPage.getFirstItemInventory(),inventoryPage.getFirstItemAZ(),"Сортировка 'NAME A TO Z' на странице PRODUCT произведена неправильно");
    }

    @Test(priority = 4, description = "Проверка сортировки товаров на странице PRODUCTS: NAME Z TO A")
    public void itemsInventorySortZA() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        inventoryPage.sortItemInventoryZA();
        Assert.assertEquals(inventoryPage.getFirstItemInventory(),inventoryPage.getFirstItemZA(),"Сортировка 'NAME Z TO A' на странице PRODUCT произведена неправильно");
    }

    @Test(priority = 5, description = "Проверка сортировки товаров на странице PRODUCTS: Price (low to high)")
    public void itemsInventorySortLoHi() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        inventoryPage.sortItemInventoryLoHi();
        Assert.assertEquals(inventoryPage.getPriceFirstItemInventory(),inventoryPage.getMinPriceInInventory(),"Сортировка 'Price (low to high)' на странице PRODUCT произведена неправильно");
    }

    @Test(priority = 6, description = "Проверка сортировки товаров на странице PRODUCTS: Price (high to low)")
    public void itemsInventorySortHiLo() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        inventoryPage.sortItemInventoryHiLo();
        Assert.assertEquals(inventoryPage.getPriceFirstItemInventory(),inventoryPage.getMaxPriceInInventory(),"Сортировка 'Price (high to low)' на странице PRODUCT произведена неправильно");
    }
}
