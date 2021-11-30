package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class BurgerMenuPage extends BasePage {
    public static final By BURGER_MENU_BUTTON = By.xpath("//button[@id='react-burger-menu-btn']");
    public static final By BM_ITEMS = By.xpath("//nav[@class='bm-item-list']//a[@class='bm-item menu-item']");
    public static final By BM_ITEM_INVENTORY = By.xpath("//a[@id='inventory_sidebar_link']");
    public static final By BM_ITEM_ABOUT = By.xpath("//a[@id='about_sidebar_link']");
    public static final By BM_ITEM_LOGOUT = By.xpath("//a[@id='logout_sidebar_link']");
    public static final By BM_ITEM_RESET = By.xpath("//a[@id='reset_sidebar_link']");

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

    //Метод проверки видимости пункта меню ALL ITEMS
    public Boolean getDisplayedBMItemInventory() {
        return driver.findElement(BM_ITEM_INVENTORY).isDisplayed();
    }

    //Метод проверки видимости пункта меню ABOUT
    public Boolean getDisplayedBMItemAbout() {
        return driver.findElement(BM_ITEM_ABOUT).isDisplayed();
    }

    //Метод проверки видимости пункта меню LOGOUT
    public Boolean getDisplayedBMItemLogout() {
        return driver.findElement(BM_ITEM_LOGOUT).isDisplayed();
    }

    //Метод проверки видимости пункта меню RESET APP STATE
    public Boolean getDisplayedBMItemReset() {
        return driver.findElement(BM_ITEM_RESET).isDisplayed();
    }

    //Метод открытия кнопки меню
    public void selectBMItemLogout() {
        driver.findElement(BM_ITEM_LOGOUT).click();
    }
}
