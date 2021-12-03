package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class LocatorsList extends BaseTest {
    @Test
    public void locatorsList() {

        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");


        //id
        driver.findElement(By.id("inventory_container"));
        //name
        driver.findElement(By.name("add-to-cart-sauce-labs-bike-light"));
        //classname
        driver.findElement(By.className("inventory_list"));
        //tagname
        driver.findElement(By.tagName("div"));
        //linktext
        driver.findElement(By.linkText("Twitter"));
        //partiallinktext
        driver.findElement(By.partialLinkText("Linked"));
        //xpath
        //xpath: поиск по атрибуту, например By.xpath("//tag[@attribute='value']")
        driver.findElement(By.xpath("//div[@class='inventory_item_price']"));
        //xpath: поиск по тексту, например By.xpath("//tag[text()='text']")
        driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']"));
        //xpath: поиск по частичному совпадению атрибута, например By.xpath("//tag[contains(@attribute,'text')]")
        driver.findElement(By.xpath("//div[contains(@class,'item_name')]"));
        //xpath: поиск по частичному совпадению текста, например By.xpath("//tag[contains(text(),'text')]")
        driver.findElement(By.xpath("//div[contains(text(),'$')]"));
        //ancestor, например //*[text()='Enterprise Testing']//ancestor::div - поиск самого верхнего родительского тега
        driver.findElement(By.xpath("//*[text()='Sauce Labs Bolt T-Shirt']//ancestor::div"));
        //descendant (поиск потомков узла)
        driver.findElement(By.xpath("//div[@id='contents_wrapper']//descendant::div[@class='inventory_item_name']"));
        //following (Выбирает все в элементы после закрывающего тега текущего узла)
        driver.findElement(By.xpath("//div[@id='contents_wrapper']//following::footer"));
        //parent (верхний уровень)
        driver.findElement(By.xpath("//div[@id='inventory_container']//parent::div"));
        //preceding (верхний уровень)
        driver.findElement(By.xpath("//div[@id='contents_wrapper']//preceding::noscript"));
        //*поиск элемента с условием AND, например //input[@class='_2zrpKA _1dBPDZ' and @type='text']
        driver.findElement(By.xpath("//div[@class='inventory_item_name' and text()='Sauce Labs Backpack']"));
        //css
        //css (.class)
        driver.findElement(By.cssSelector(".inventory_item_desc"));
        //css (.class1.class2) - такого не нашел
        //css (#id)
        driver.findElement(By.cssSelector("#add-to-cart-sauce-labs-bolt-t-shirt"));
        //css (tagname)
        driver.findElement(By.cssSelector("body"));
        //css (tagname.class)
        driver.findElement(By.cssSelector("div.inventory_item_desc"));
        //css ([attribute=value] - Обозначает элемент с именем атрибута attr и значением в точности совпадающим с value)
        driver.findElement(By.cssSelector("div[class='inventory_item_price']"));
        //css ([attribute~=value] - Обозначает элемент с именем атрибута attr значением которого является набор слов разделённых пробелами, одно из которых в точности равно value)
        driver.findElement(By.cssSelector("button[class~='btn']"));
        //css ([attribute|=value] - Обозначает элемент с именем атрибута attr. Его значение при этом может быть или в точности равно "value" или может начинаться с "value" со сразу же следующим "-" (U+002D). Это может быть использовано когда язык описывается с подходом.)
        driver.findElement(By.cssSelector("button[id|='add']"));
        //css ([attribute^=value] - Обозначает элемент с именем атрибута attr значение которого начинается с "value")
        driver.findElement(By.cssSelector("button[name^='add']"));
        //css ([attribute$=value] - Обозначает элемент с именем атрибута attr чьё значение заканчивается на "value")
        driver.findElement(By.cssSelector("button[data-test$='pack']"));
        //css ([attribute*=value] - Обозначает элемент с именем атрибута attr чьё значение содержит по крайней мере одно вхождение строки "value" как подстроки)
        driver.findElement(By.cssSelector("button[data-test*='cart']"));
    }
}
