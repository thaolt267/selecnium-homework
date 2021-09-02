package models.components.global;

import models.components.global.topMenu.MenuBooksComponent;
import models.components.global.topMenu.MenuComputersComponent;
import org.openqa.selenium.WebDriver;

public class TopMenuComponent {
    private final WebDriver driver;
    private  MenuBooksComponent menuBooksComponent;
    private  MenuComputersComponent menuComputersComponent;


    public TopMenuComponent(WebDriver driver) {
        this.driver = driver;
    }

    public MenuBooksComponent menuBooksComponent(){
        return new MenuBooksComponent(driver);
    }

    public MenuComputersComponent menuComputersComponent(){
        return new MenuComputersComponent(driver);
    }
}
