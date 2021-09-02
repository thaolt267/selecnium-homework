package models.components.global.topMenu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MenuBooksComponent {
    private final WebDriver driver;
    final int BOOK_MENU_INDEX = 0;
    private final By toMenuItemSel = By.cssSelector(".top-menu li a");


    public MenuBooksComponent(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement menuBook(){
        List<WebElement> topMenuItems = driver.findElements(toMenuItemSel);
        return topMenuItems.get(BOOK_MENU_INDEX);
    }

}
