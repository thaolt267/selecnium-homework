package models.pages;

import driver.DriverFactory;
import models.components.global.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HomePageTest {
    private final WebDriver driver;
    private HeaderComponent headerComponent;
    private FooterComponent footerComponent;
    private TopMenuComponent topMenuComponent;
    private CategoriesComponent categoriesComponent;
    private CommunityPollComponent communityPollComponent;
    private NewsLetterComponent newsLetterComponent;

    final int FIRST_CHECKBOX_INDEX = 0;
    final int SECOND_CHECKBOX_INDEX = 1;
    final int THIRD_CHECKBOX_INDEX = 2;
    final int FOURTH_CHECKBOX_INDEX = 3;

    public HomePageTest(WebDriver driver) {
        this.driver = driver;
    }

    public HeaderComponent headerComponent() {
        return new HeaderComponent(this.driver);
    }

    public FooterComponent footerComponent() {
        return new FooterComponent(this.driver);
    }

    public TopMenuComponent topMenuComponent() {
        return new TopMenuComponent(this.driver);
    }

    public CategoriesComponent categoriesComponent() {
        return new CategoriesComponent(this.driver);
    }

    public CommunityPollComponent communityPollComponent() {
        return new CommunityPollComponent(this.driver);
    }

    public NewsLetterComponent newsLetterComponent() {
        return new NewsLetterComponent(this.driver);
    }

    @Test
    public static void testPageHeader(WebDriver driver) {

        HomePageTest homePage = new HomePageTest(driver);
        System.out.println("=====Test header section======");
        // Test Logo src
        String headerImgSrc = homePage.headerComponent().logoImg().getAttribute("src");
        System.out.println("Logo Img src: " + headerImgSrc);

        // Search an item
        homePage.headerComponent().inputProductNameAndSearch("Lap top");

        // Click on Login link
        homePage.headerComponent().clickOnLoginLink();

        // Click on Logo to back to home screen
        homePage.headerComponent().logoImg().click();

        // Check the shopping cart number
        homePage.headerComponent().getShoppingCartNumber();


    }

    public static void testPageFooter(WebDriver driver) {

        HomePageTest homePage = new HomePageTest(driver);

        System.out.println("=====Test footer section======");
        // Test Powered By footer text and link
        String poweredByText = homePage.footerComponent().poweredByComponent().getText();
        String poweredByTeLink = homePage.footerComponent().poweredByComponent().getLink();
        System.out.println("Powered by: " + poweredByText);
        System.out.println("Powered by link: " + poweredByTeLink);

        // Test Information column text

        //List information items
        System.out.println("Information items: ");
        homePage.footerComponent().menuInformationComponent().getAllInformationItems();

        //Print random information item
        String informationRandomItemText = homePage.footerComponent().menuInformationComponent().informationItem().getText();
        System.out.println("Random Information item: " + informationRandomItemText);

        // Click on random Information item
        homePage.footerComponent().menuInformationComponent().informationItem().click();


    }

    public static void testTopMenu(WebDriver driver) {
        HomePageTest homePage = new HomePageTest(driver);

        // Check top menu Books and then click on it
        WebElement menuBook = homePage.topMenuComponent().menuBooksComponent().menuBook();
        System.out.println("The 1st top menu item is: " + menuBook.getText());
        menuBook.click();

        // Check top menu Computers title
        WebElement menuComputer = homePage.topMenuComponent().menuComputersComponent().menuComputer();
        System.out.println("The 2nd top menu item is: " + menuComputer.getText());
        menuComputer.click();

        // Select an item in Computers Dropdown
        WebElement dropdownComputerItem = homePage.topMenuComponent().menuComputersComponent().randomDropdownComputerItem();
        System.out.println("The selected Computers Dropdown item is: " + dropdownComputerItem.getText());
        dropdownComputerItem.click();

    }

    public static void testCategories(WebDriver driver) {
        HomePageTest homePage = new HomePageTest(driver);

        //Print categories title and all categories
        String categoriesTitle = homePage.categoriesComponent().getCategoriesTitle();
        System.out.println("====" + categoriesTitle + "=====");
        homePage.categoriesComponent().getAllCategoriesItems();

        //Select random categories item and click on the link
        WebElement randomCategoriesItem = homePage.categoriesComponent().randomCategoriesItem();
        System.out.println("The selected categories item is: " + randomCategoriesItem.getText());
        randomCategoriesItem.click();

    }

    public static void testNewsLetter(WebDriver driver) {
        HomePageTest homePage = new HomePageTest(driver);

        //Check Sign up for our newsletter
        homePage.newsLetterComponent().newsLetterEmail("testnew@gmail.com");
        homePage.newsLetterComponent().subscribeBtn();

    }

    public static void testCommunityPoll(WebDriver driver) {
        HomePageTest homePage = new HomePageTest(driver);

        // Select item and vote
        homePage.communityPollComponent().selectAnCommunityPollCheckbox(homePage.THIRD_CHECKBOX_INDEX);
        homePage.communityPollComponent().voteBtn().click();

    }

    @BeforeTest
    public void beforeTest(){

    }


    public static void main(String[] args) {
        WebDriver driver = DriverFactory.getChromeDriver();
        try {
            driver.get("http://demowebshop.tricentis.com/");
            testPageHeader(driver);
//            testPageFooter(driver);
//            testTopMenu(driver);
//            testCategories(driver);
//            testNewsLetter(driver);
//            testCommunityPoll(driver);
            Thread.sleep(3000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }

}
