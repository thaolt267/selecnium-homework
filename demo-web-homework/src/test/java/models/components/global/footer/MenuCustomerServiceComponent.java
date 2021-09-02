package models.components.global.footer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.security.SecureRandom;
import java.util.List;

public class MenuCustomerServiceComponent {
    private final WebDriver driver;
    private final By customerServiceItemSel = By.cssSelector(".column.customer-service ul li a");

    public MenuCustomerServiceComponent(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement customerServiceItem() {
        List<WebElement> customerServiceItems = driver.findElements(customerServiceItemSel);
        WebElement randomCustomerServiceItem = customerServiceItems.get(new SecureRandom().nextInt(customerServiceItems.size()));
        return randomCustomerServiceItem;

    }

    public void getAllCustomerServiceItems() {
        List<WebElement> customerServiceItems = driver.findElements(customerServiceItemSel);
        for (WebElement item : customerServiceItems) {
            System.out.println(item.getText());
        }
    }
}
