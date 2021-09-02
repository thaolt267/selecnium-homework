package models.components.global.topMenu;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.security.SecureRandom;
import java.util.List;

public class MenuComputersComponent {
    private final WebDriver driver;
    final int COMPUTER_MENU_INDEX = 1;
    private final By toMenuItemSel = By.cssSelector(".top-menu li");
    private final By dropdownComputerSel = By.cssSelector("ul li");
    private final By itemDetailsSel = By.cssSelector("a");


    public MenuComputersComponent(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement menuComputer() {
        List<WebElement> topMenuItems = driver.findElements(toMenuItemSel);
        WebElement menuComputer = topMenuItems.get(COMPUTER_MENU_INDEX).findElement(itemDetailsSel);
        return menuComputer;
    }

    public WebElement randomDropdownComputerItem() {

        Actions actions = new Actions(driver);

        // Declare a list top menu item
        List<WebElement> topMenuItems = driver.findElements(toMenuItemSel);

        // Mouse hover to the computer menu
        actions.moveToElement(menuComputer()).perform();

        //Declare a list computer dropdown item
        List<WebElement> dropdownComputerItems = topMenuItems.get(COMPUTER_MENU_INDEX).findElements(dropdownComputerSel);

        // Select random an item in computer dropdown
        WebElement randomDropdownItem = dropdownComputerItems.get(new SecureRandom().nextInt(dropdownComputerItems.size()));

        //Random item details
        WebElement dropdownItemDetail = randomDropdownItem.findElement(itemDetailsSel);

        return dropdownItemDetail;

    }

}
