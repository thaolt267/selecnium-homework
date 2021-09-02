package models.components.global;

import models.components.global.topMenu.MenuApparelAndShoesComponent;
import models.components.global.topMenu.MenuBooksComponent;
import models.components.global.topMenu.MenuComputersComponent;
import models.components.global.topMenu.MenuElectronicsComponent;
import org.openqa.selenium.WebDriver;

public class TopMenuComponent {
    private final WebDriver driver;
    private  MenuBooksComponent menuBooksComponent;
    private  MenuComputersComponent menuComputersComponent;
    private MenuElectronicsComponent menuElectronicsComponent;
    private MenuApparelAndShoesComponent menuApparelAndShoesComponent;


    public TopMenuComponent(WebDriver driver) {
        this.driver = driver;
    }

    public MenuBooksComponent menuBooksComponent(){
        return new MenuBooksComponent(driver);
    }

    public MenuComputersComponent menuComputersComponent(){
        return new MenuComputersComponent(driver);
    }

    public MenuElectronicsComponent menuElectronicsComponent(){
        return new MenuElectronicsComponent(driver);
    }

    public MenuApparelAndShoesComponent menuApparelAndShoesComponent(){
        return new MenuApparelAndShoesComponent(driver);
    }
}
