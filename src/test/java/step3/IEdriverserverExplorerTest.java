package step3;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

public class IEdriverserverExplorerTest {
    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void start(){
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
        caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
        driver = new InternetExplorerDriver(caps);
        wait = new WebDriverWait(driver,10);
    }

    @Test
    public void myFirstTest(){
        driver.get("http://localhost/litecart/admin");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();

        Assert.assertTrue(driver.getTitle().equals("My Store"));
    }

    @After
    public void stop (){
        driver.quit();
        driver = null;
    }
}
