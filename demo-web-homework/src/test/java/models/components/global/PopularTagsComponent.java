package models.components.global;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.security.SecureRandom;
import java.util.List;

public class PopularTagsComponent {
    private final WebDriver driver;
    private final By popularTagsListSel = By.cssSelector(".tags li");
    private final By popularTagSel = By.cssSelector(".tags li a[href$='computers']");

    public PopularTagsComponent(WebDriver driver) {
        this.driver = driver;
    }


    public WebElement randomCategoriesItem() {
        List<WebElement> listPopularTags = driver.findElements(popularTagsListSel);
        WebElement randomCategoriesItem = listPopularTags.get(new SecureRandom().nextInt(listPopularTags.size()));
        return randomCategoriesItem;

    }

    public void getAllCategoriesItems() {
        List<WebElement> listPopularTags = driver.findElements(popularTagsListSel);
        for (WebElement item : listPopularTags) {
            System.out.println(item.getText());
        }
    }

    public void clickOnPopularTag(String tagName){
        WebElement popularTag = randomCategoriesItem().findElement(By.cssSelector(tagName));
        
    }

}
