package models.components.global;

import driver.DriverFactory;
import models.components.global.topMenu.MenuComputersComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CommunityPollComponent {
    private final WebDriver driver;
    private final By communityPollTitleSel = By.cssSelector(".block.block-poll .title");
    private final By communityPollOptionSel = By.cssSelector(".block.block-poll .poll-options [type='radio']");
    private final By voteBtnSel = By.id("vote-poll-1");

    final int FIRST_CHECKBOX_INDEX = 0;
    final int SECOND_CHECKBOX_INDEX = 1;
    final int THIRD_CHECKBOX_INDEX = 2;
    final int FOURTH_CHECKBOX_INDEX = 3;

    public CommunityPollComponent(WebDriver driver) {
        this.driver = driver;
    }

    public String getCommunityPollTitle(){
        return this.driver.findElement(communityPollTitleSel).getText();
    }

    public void selectAnCommunityPollCheckbox(int checkboxIndex){
        List<WebElement> communityPollGroup = driver.findElements(communityPollOptionSel);
        WebElement checkbox = communityPollGroup.get(checkboxIndex);
        checkbox.click();
    }

    public WebElement voteBtn() {
        return this.driver.findElement(voteBtnSel);
    }


    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = DriverFactory.getChromeDriver();
        driver.get("http://demowebshop.tricentis.com/");
        CommunityPollComponent communityPollComponent = new CommunityPollComponent(driver);
        communityPollComponent.selectAnCommunityPollCheckbox(communityPollComponent.FIRST_CHECKBOX_INDEX);
        communityPollComponent.voteBtn().click();
        Thread.sleep(3000);
        driver.quit();
    }
}
