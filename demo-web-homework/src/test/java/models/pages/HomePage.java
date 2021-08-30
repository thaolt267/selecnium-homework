package models.pages;

import driver.DriverFactory;
import models.components.global.FooterComponent;
import models.components.global.HeaderComponent;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private final WebDriver driver;
    private HeaderComponent headerComponent;
    private FooterComponent footerComponent;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public HeaderComponent headerComponent() {
        return new HeaderComponent(this.driver);
    }

    public FooterComponent footerComponent() {
        return new FooterComponent(this.driver);
    }


    public static void main(String[] args) {
        WebDriver driver = DriverFactory.getChromeDriver();
        try {
            driver.get("http://demowebshop.tricentis.com/");
//            testHomePageHeader(driver);
//            testHomePageHeader(driver);
            testHomePageFooter(driver);
            Thread.sleep(2000);



        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }

    public static void testHomePageHeader(WebDriver driver) {

        HomePage homePage = new HomePage(driver);
        System.out.println("=====Test header section======");
        // Test Logo src
        String headerImgSrc = homePage.headerComponent().logoImg().getAttribute("src");
        System.out.println("Logo Img src: " + headerImgSrc);

        // Search an item
        homePage.headerComponent().inputProductNameAndSearch("Lap top");

    }

    public static void testHomePageFooter(WebDriver driver) {

        HomePage homePage = new HomePage(driver);

        System.out.println("=====Test footer section======");
        // Test Powered By footer text and link
        String poweredByText = homePage.footerComponent().poweredByComponent().getText();
        String poweredByTeLink = homePage.footerComponent().poweredByComponent().getLink();
        System.out.println("Powered by: " + poweredByText);
        System.out.println("Powered by link: " + poweredByTeLink);

        // Test Information column text
        String informationRandomItemText = homePage.footerComponent.menuInformationComponent().informationItem().getText();
        System.out.println("Random Information item: " + informationRandomItemText);
//        homePage.footerComponent.menuInformationComponent().getInformationItems();

    }

}
