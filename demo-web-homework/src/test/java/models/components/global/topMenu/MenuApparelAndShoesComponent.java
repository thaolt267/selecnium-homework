package models.components.global.topMenu;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MenuApparelAndShoesComponent {
    private final WebDriver driver;
    private final By toMenuItemSel = By.cssSelector(".top-menu li:nth-child(4) a");


    public MenuApparelAndShoesComponent(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement menuBook(){
        WebElement topMenuItems = driver.findElement(toMenuItemSel);
        return topMenuItems;
    }

}
