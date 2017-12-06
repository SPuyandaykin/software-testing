package BaseTestPages;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import trenningdata.UserData;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    protected WebDriver driver;

    public UserData admin = new UserData("admin", "admin");

    protected WebDriver getWebDriver(){
        if(driver == null){
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
        }
        return driver;
    }

    protected void type(WebElement webElement, String text){
        webElement.clear();
        webElement.sendKeys(text);
    }

    @After
    public void stop (){
        driver.quit();
        driver = null;
    }
}
