package models.components.global.footer;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.security.SecureRandom;
import java.util.List;

public class MenuInformationComponent {
    private final WebDriver driver;
    private final By informationItemSel = By.cssSelector(".column.information ul li a");

    public MenuInformationComponent(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement informationItem() {
        List<WebElement> informationItems = driver.findElements(informationItemSel);
        WebElement randomMenuItem = informationItems.get(new SecureRandom().nextInt(informationItems.size()));
        return randomMenuItem;

    }

    public void getAllInformationItems() {
        List<WebElement> informationItems = driver.findElements(informationItemSel);
        for (WebElement item : informationItems) {
            System.out.println(item.getText());
        }
    }


}
