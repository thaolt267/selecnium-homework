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
            testHomePageHeader(driver);
            Thread.sleep(2000);
            testHomePageFooter(driver);


        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }

    public static void testHomePageHeader(WebDriver driver) {

        HomePage homePage = new HomePage(driver);

        String headerImgSrc = homePage.headerComponent().logoImg().getAttribute("src");
        System.out.println("Logo Img src: " + headerImgSrc);
        homePage.headerComponent().inputProductNameAndSearch("Lap top");

    }

    public static void testHomePageFooter(WebDriver driver) {

        HomePage homePage = new HomePage(driver);

        String poweredByText = homePage.footerComponent().poweredByComponent().getText();
        System.out.println("Powered by: " + poweredByText);

    }

}
