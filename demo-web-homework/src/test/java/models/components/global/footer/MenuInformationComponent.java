package models.components.global.footer;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.security.SecureRandom;
import java.util.List;

public class MenuInformationComponent {
    private final WebDriver driver;
    private final By informationItem = By.cssSelector(".column.information ul li");

    public MenuInformationComponent(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement informationItem() {
        List<WebElement> informationItems = driver.findElements(informationItem);
        WebElement randomMenuItem = informationItems.get(new SecureRandom().nextInt(informationItems.size()));
        return randomMenuItem;

    }

    public void getInformationItems(){
        List<WebElement> informationItems = driver.findElements(informationItem);
        for (WebElement item: informationItems){
            System.out.println(item.getText());
        }
    }

//    public static void main(String[] args) {
//        WebDriver driver = DriverFactory.getChromeDriver();
//        driver.get("http://demowebshop.tricentis.com/");
//        MenuInformationComponent menuInformationComponent = new MenuInformationComponent(driver);
//
//        //List information items
//        System.out.println("=====Information items:=====");
//        menuInformationComponent.getInformationItems();
//
//        //Print random information item
//        String informationItemText = menuInformationComponent.informationItem().getText();
//        System.out.println("Random Information item: " + informationItemText);
//
//        driver.quit();
//    }


}
