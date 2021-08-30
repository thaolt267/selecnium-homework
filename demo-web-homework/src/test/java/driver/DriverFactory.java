package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {

    public static WebDriver getChromeDriver(){
        String currentProjectLocation = System.getProperty("user.dir");
        String chromeDriverLocation = currentProjectLocation + "\\src\\test\\resources\\drivers\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", chromeDriverLocation);
        return new ChromeDriver();
    }
    public static void main(String[] args) {
        DriverFactory.getChromeDriver();
    }

}
