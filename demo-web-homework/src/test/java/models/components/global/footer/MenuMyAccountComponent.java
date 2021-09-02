package models.components.global.footer;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.security.SecureRandom;
import java.util.List;

public class MenuMyAccountComponent {
    private final WebDriver driver;
    private final By myAccountItemSel = By.cssSelector(".column.my-account ul li a");

    public MenuMyAccountComponent(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement myAccountItem() {
        List<WebElement> myAccountItems = driver.findElements(myAccountItemSel);
        WebElement randomMyAccountItem = myAccountItems.get(new SecureRandom().nextInt(myAccountItems.size()));
        return randomMyAccountItem;

    }

    public void getAllMyAccountItems() {
        List<WebElement> myAccountItems = driver.findElements(myAccountItemSel);
        for (WebElement item : myAccountItems) {
            System.out.println(item.getText());
        }
    }

}
