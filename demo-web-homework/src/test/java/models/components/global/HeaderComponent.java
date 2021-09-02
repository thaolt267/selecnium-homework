package models.components.global;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HeaderComponent {
    private final WebDriver driver;
    private final By logoImgSel = By.cssSelector(".header-logo a img");
    private final By registerLinkSel = By.cssSelector(".ico-register");
    private final By loginLinkSel = By.cssSelector(".ico-login");
    private final By shoppingCartLinkSel = By.cssSelector(".ico-cart");
    private final By shoppingCartCountSel = By.cssSelector("span.cart-qty");
    private final By wishlistLinkSel = By.cssSelector(".ico-wishlist");
    private final By wishlistCountSel = By.cssSelector("span.wishlist-qty");
    private final By searchTxtSel = By.cssSelector("#small-searchterms");
    private final By searchBtnSel = By.cssSelector("form[action = '/search'] .search-box-button");

    public HeaderComponent(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement logoImg() {
        return this.driver.findElement(logoImgSel);
    }

    public void clickOnRegisterLink() {
        this.driver.findElement(registerLinkSel).click();
    }

    public void clickOnLoginLink() {
        this.driver.findElement(loginLinkSel).click();
    }

    public void clickOnShoppingCartLink() {
        this.driver.findElement(shoppingCartLinkSel).click();
    }

    public void getShoppingCartNumber() {
        String cartNum = driver.findElement(shoppingCartCountSel).getText();
        cartNum = cartNum.replaceAll("\\D+", "");
        System.out.println("Current number of items in the shopping cart: " + cartNum);
    }

    public void clickOnWishlistLink() {
        this.driver.findElement(wishlistLinkSel).click();
    }

    public void getWishlistNumber() {
        String cartNum = driver.findElement(wishlistCountSel).getText();
        cartNum = cartNum.replaceAll("\\D+", "");
        System.out.println("Shopping cart number: " + cartNum);
    }

    public void inputProductNameAndSearch(String productName) {
        this.inputSearchKeywords(productName);
        this.clickOnSearchBtn();
    }

    // Support methods
    private void inputSearchKeywords(String productName) {
        this.driver.findElement(searchTxtSel).sendKeys(productName);
    }

    private void clickOnSearchBtn() {
        this.driver.findElement(searchBtnSel).click();
    }

}
