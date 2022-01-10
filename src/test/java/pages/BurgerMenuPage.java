package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;


public class BurgerMenuPage extends BasePage {
    public static final By BURGER_MENU_BUTTON = By.xpath("//button[@id='react-burger-menu-btn']");
    public static final By BM_ITEMS = By.xpath("//nav[@class='bm-item-list']//a[@class='bm-item menu-item']");
    //public static final By BM_ITEM_INVENTORY = By.xpath("//a[@id='inventory_sidebar_link']");
    //public static final By BM_ITEM_ABOUT = By.xpath("//a[@id='about_sidebar_link']");
    public static final By BM_ITEM_LOGOUT = By.xpath("//a[@id='logout_sidebar_link']");
    //public static final By BM_ITEM_RESET = By.xpath("//a[@id='reset_sidebar_link']");
    public static final By CART_LINK = By.xpath("//a[@class='shopping_cart_link']");

    public BurgerMenuPage(WebDriver driver) {
        super(driver);
    }

    //Метод определения видимости кнопки меню на текущей странице
    @Step("Определить видимость кнопки BurgerMenu на текущей странице")
    public Boolean getDisplayedBurgerMenu() {
        return driver.findElement(BURGER_MENU_BUTTON).isDisplayed();
    }

    //Метод открытия кнопки меню
    @Step("Нажать кнопку BurgerMenu для отображения меню приложения SauceDemo")
    public void openBurgerMenu() {
        driver.findElement(BURGER_MENU_BUTTON).click();
    }

    //Метод, который пункты меню заносит в List
    public List<String> getItemsBM() {
        List<WebElement> itemsBM = driver.findElements(BM_ITEMS);
        List<String> itemsMenuBM = new ArrayList<>();
        for (WebElement webElement : itemsBM) itemsMenuBM.add(webElement.getText());
        return itemsMenuBM;
    }

    //Метод открытия пункта меню LOGOUT
    @Step("Выбрать пункт меню LOGOUT")
    public void selectBMItemLogout() {
        driver.findElement(BM_ITEM_LOGOUT).click();
    }

    //Метод определения видимости иконки корзины на текущей странице
    @Step("Определить видимость иконки корзины на текущей странице")
    public Boolean getDisplayedCartLink() {
        return driver.findElement(CART_LINK).isDisplayed();
    }

    //Метод перехода на страницу cart.html кликом по иконке корзины
    @Step("Перейти в корзину с помощью клика по иконке корзины")
    public void openCartPage() {
        driver.findElement(CART_LINK).click();
    }

}
