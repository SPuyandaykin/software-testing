package BaseTestPages;

import com.google.common.io.Files;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import trenningdata.UserData;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    protected EventFiringWebDriver driver;

    public UserData admin = new UserData("admin", "admin");

    public static class MyListener extends AbstractWebDriverEventListener{
        @Override
        public void onException(Throwable throwable, WebDriver driver) {
            System.out.println("!!! Exception !!! :" + throwable);
            File tmp = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File screen = new File ("screen" + System.currentTimeMillis()+".png");
            try {
                Files.copy(tmp, screen);
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println(screen);
        }

        @Override
        public void beforeFindBy(By by, WebElement element, WebDriver driver) {
            System.out.println(by);
        }

        @Override
        public void afterFindBy(By by, WebElement element, WebDriver driver) {
            System.out.println(by + " found");
        }
    }

    @Before
    public void start(){
        startChromeDriver();
//        startFireFoxDriver();
//        startIEDriver();

        driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
    }

    private void startChromeDriver(){
        driver = new EventFiringWebDriver(new ChromeDriver());
        driver.register(new MyListener());
    }

    private void startFireFoxDriver(){
        driver = new EventFiringWebDriver (new FirefoxDriver());
    }

    private void startIEDriver(){
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
        caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
        driver = new EventFiringWebDriver(new InternetExplorerDriver(caps));
    }

    protected WebDriver getWebDriver(){
        if(driver == null){
            driver = new EventFiringWebDriver (new ChromeDriver());
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
//        driver.quit();
//        driver = null;
    }
}
