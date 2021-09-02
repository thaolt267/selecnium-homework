package models.components.global.topMenu;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.security.SecureRandom;
import java.util.List;

public class MenuElectronicsComponent {
    private final WebDriver driver;
    private final By toMenuItemSel = By.cssSelector(".top-menu li");
    private final By dropdownComputerSel = By.cssSelector("ul li");
    private final By itemDetailsSel = By.cssSelector("a");

    final int ELECTRONICS_MENU_INDEX = 2;


    public MenuElectronicsComponent(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement menuElectronics() {
        List<WebElement> topMenuItems = driver.findElements(toMenuItemSel);
        WebElement menuElectronic = topMenuItems.get(ELECTRONICS_MENU_INDEX).findElement(itemDetailsSel);
        return menuElectronic;
    }

    public WebElement randomDropdownElectronicsItem() {

        Actions actions = new Actions(driver);

        // Declare a list top menu item
        List<WebElement> topMenuItems = driver.findElements(toMenuItemSel);

        // Mouse hover to the electronics menu
        actions.moveToElement(menuElectronics()).perform();

        //Declare a list electronics dropdown item
        List<WebElement> dropdownElectronics = topMenuItems.get(ELECTRONICS_MENU_INDEX).findElements(dropdownComputerSel);

        // Select random an item in electronics dropdown
        WebElement randomDropdownItem = dropdownElectronics.get(new SecureRandom().nextInt(dropdownElectronics.size()));

        //Random item details
        WebElement dropdownItemDetail = randomDropdownItem.findElement(itemDetailsSel);

        return dropdownItemDetail;

    }

}
