package tests;

import driver.DriverFactory;
import models.components.global.footer.PoweredByComponent;
import models.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestHomePage {

    @Test
    void testPoweredByPage() {
        WebDriver driver = DriverFactory.getChromeDriver();
        try {
            driver.get("http://demowebshop.tricentis.com/");
            PoweredByComponent poweredByComponent = new PoweredByComponent(driver);
            System.out.println("====PowerBy TestNG====");
            poweredByComponent.getText();

//            String currentUrl = driver.getCurrentUrl();
//            String expectedUrl = "https://the-internet.herokuapp.com/secure";
//            Assert.assertEquals(currentUrl, expectedUrl, "[ERR] Wrong url after login");
        } finally {
            driver.quit();
        }
    }

    @Test
    public static void testPageHeader() {
        WebDriver driver = DriverFactory.getChromeDriver();
        try {
            driver.get("http://demowebshop.tricentis.com/");
            HomePage homePage = new HomePage(driver);
            System.out.println("=====Test header section======");
            // Test Logo src
            String headerImgSrc = homePage.headerComponent().logoImg().getAttribute("src");
            System.out.println("Logo Img src: " + headerImgSrc);
            String expectedUrl = "http://demowebshop.tricentis.com/Themes/DefaultClean/Content/images/logo.png";
            Assert.assertEquals(headerImgSrc, expectedUrl, "[ERR] Wrong logo src");

            // Search an item
            homePage.headerComponent().inputProductNameAndSearch("Lap top");

            // Click on Login link
            homePage.headerComponent().clickOnLoginLink();

            // Click on Logo to back to home screen
            homePage.headerComponent().logoImg().click();

            // Check the shopping cart number
            homePage.headerComponent().getShoppingCartNumber();
        } finally {
            driver.quit();
        }


    }


    // Will be failed
//    @Test
//    void testLoginWithIncorrectCreds() {
//        WebDriver driver = DriverFactory.getChromeDriver();
//
//        try {
//            driver.get("https://the-internet.herokuapp.com/login");
//            LoginPage loginPage = new LoginPage(driver);
//            loginPage.username().sendKeys("username_wrong");
//            loginPage.password().sendKeys("password");
//            loginPage.loginBtn().click();
//
//            String currentUrl = driver.getCurrentUrl();
//            String expectedUrl = "https://the-internet.herokuapp.com/secure";
//
//            Assert.assertEquals(currentUrl, expectedUrl, "[ERR] Wrong url after login");
//        } finally {
//            driver.quit();
//        }
//    }
}
