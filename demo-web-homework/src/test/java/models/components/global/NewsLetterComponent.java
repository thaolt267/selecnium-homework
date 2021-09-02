package models.components.global;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NewsLetterComponent {
    private final WebDriver driver;
    private final By newsLetterTitleSel = By.cssSelector(".block.block-newsletter .title");
    private final By newsLetterEmailSel = By.id("newsletter-email");
    private final By subscribeBtnSel = By.id("newsletter-subscribe-button");

    public NewsLetterComponent(WebDriver driver) {
        this.driver = driver;
    }

    public String getNewsLetterTitle(){
        return this.driver.findElement(newsLetterTitleSel).getText();
    }

    public void newsLetterEmail(String email) {
        this.driver.findElement(newsLetterEmailSel).sendKeys(email);
    }

    public void subscribeBtn() {
        this.driver.findElement(subscribeBtnSel).click();
    }

}
