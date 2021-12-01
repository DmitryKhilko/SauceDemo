package pages;

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

    public BurgerMenuPage(WebDriver driver) {
        super(driver);
    }

    //Метод определения видимости кнопки меню на текущей странице
    public Boolean getDisplayedBurgerMenu() {
        return driver.findElement(BURGER_MENU_BUTTON).isDisplayed();
    }

    //Метод открытия кнопки меню
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

    //Метод открытия кнопки меню
    public void selectBMItemLogout() {
        driver.findElement(BM_ITEM_LOGOUT).click();
    }
}
