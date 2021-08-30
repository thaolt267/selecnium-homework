package models.components.global;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HeaderComponent {
    private final WebDriver driver;
    private final By logoImgSel = By.cssSelector(".header-logo a img");
    private final By loginLinkSel = By.cssSelector(".ico-login");
    private final By searchTxtSel = By.cssSelector("#small-searchterms");
    private final By searchBtnSel = By.cssSelector("form[action = '/search'] .search-box-button");

    public HeaderComponent(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement logoImg(){
        return this.driver.findElement(logoImgSel);
    }

    public void clickOnLoginLink(){
        this.driver.findElement(loginLinkSel).click();
    }


    public void inputProductNameAndSearch (String productName){
        this.inputSearchkeywords(productName);
        this.clickOnSearchBtn();
    }


    // Support methods
    private void inputSearchkeywords(String productName) {
        this.driver.findElement(searchTxtSel).sendKeys(productName);
    }

    private void clickOnSearchBtn() {
        this.driver.findElement(searchBtnSel).click();
    }
}
