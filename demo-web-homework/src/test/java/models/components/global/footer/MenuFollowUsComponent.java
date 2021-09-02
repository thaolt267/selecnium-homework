package models.components.global.footer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.security.SecureRandom;
import java.util.List;

public class MenuFollowUsComponent {
    private final WebDriver driver;
    private final By followUsItemSel = By.cssSelector(".column.follow-us ul li a");

    public MenuFollowUsComponent(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement followUsItem() {
        List<WebElement> followUsItems = driver.findElements(followUsItemSel);
        WebElement randomFollowUstItem = followUsItems.get(new SecureRandom().nextInt(followUsItems.size()));
        return randomFollowUstItem;

    }

    public void getAllMyAccountItems() {
        List<WebElement> followUsItems = driver.findElements(followUsItemSel);
        for (WebElement item : followUsItems) {
            System.out.println(item.getText());
        }
    }
}
