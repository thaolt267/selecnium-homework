package models.components.global;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.security.SecureRandom;
import java.util.List;

public class CategoriesComponent {
    private final WebDriver driver;
    private final By categoriesTitleSel = By.cssSelector(".block.block-category-navigation .title strong");
    private final By categoriesListSel = By.cssSelector(".block.block-category-navigation .listbox .list li");

    public CategoriesComponent(WebDriver driver) {
        this.driver = driver;
    }

    public String getCategoriesTitle(){
        return this.driver.findElement(categoriesTitleSel).getText();
    }

    public WebElement randomCategoriesItem() {
        List<WebElement> listCategories = driver.findElements(categoriesListSel);
        WebElement randomCategoriesItem = listCategories.get(new SecureRandom().nextInt(listCategories.size()));
        return randomCategoriesItem;

    }

    public void getAllCategoriesItems() {
        List<WebElement> listCategories = driver.findElements(categoriesListSel);
        for (WebElement item : listCategories) {
            System.out.println(item.getText());
        }
    }

}
