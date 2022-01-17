package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.ITestContext;

import java.util.ArrayList;
import java.util.List;

@Log4j2
public class BurgerMenuPage extends BasePage {
    public static final By BURGER_MENU_BUTTON = By.xpath("//button[@id='react-burger-menu-btn']");
    public static final By BM_ITEMS = By.xpath("//nav[@class='bm-item-list']//a[@class='bm-item menu-item']");
    //public static final By BM_ITEM_INVENTORY = By.xpath("//a[@id='inventory_sidebar_link']");
    //public static final By BM_ITEM_ABOUT = By.xpath("//a[@id='about_sidebar_link']");
    public static final By BM_ITEM_LOGOUT = By.xpath("//a[@id='logout_sidebar_link']");
    //public static final By BM_ITEM_RESET = By.xpath("//a[@id='reset_sidebar_link']");
    public static final By CART_LINK = By.xpath("//a[@class='shopping_cart_link']");

    public BurgerMenuPage(ITestContext driver) {
        super(driver);
    }

    //Метод определения видимости кнопки меню на текущей странице
    @Step("Определить видимость кнопки BurgerMenu на текущей странице")
    public Boolean getDisplayedBurgerMenu() {
        log.debug("Тест " + context.getAttribute("testName") + ": определить видимость кнопки BurgerMenu на текущей странице");
        return driver.findElement(BURGER_MENU_BUTTON).isDisplayed();
    }

    //Метод открытия кнопки меню
    @Step("Нажать кнопку BurgerMenu для отображения меню приложения SauceDemo")
    public void openBurgerMenu() {
        log.debug("Тест " + context.getAttribute("testName") + ": нажать кнопку BurgerMenu для отображения меню приложения SauceDemo");
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
        log.debug("Тест " + context.getAttribute("testName") + ": выбрать пункт меню LOGOUT");
        driver.findElement(BM_ITEM_LOGOUT).click();
    }

    //Метод определения видимости иконки корзины на текущей странице
    @Step("Определить видимость иконки корзины на текущей странице")
    public Boolean getDisplayedCartLink() {
        log.debug("Тест " + context.getAttribute("testName") + ": определить видимость иконки корзины на текущей странице");
        return driver.findElement(CART_LINK).isDisplayed();
    }

    //Метод перехода на страницу cart.html кликом по иконке корзины
    @Step("Перейти в корзину с помощью клика по иконке корзины")
    public void openCartPage() {
        log.debug("Тест " + context.getAttribute("testName") + ": перейти в корзину с помощью клика по иконке корзины");
        driver.findElement(CART_LINK).click();
    }
}
