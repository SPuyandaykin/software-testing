package step3;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;

public class PhantomJSBrowserTest {
    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void start(){

 //       DesiredCapabilities DesireCaps = new DesiredCapabilities();
 //       File src = new File("c:\\Tools\\Browsers\\phantomjs-2.1.1-windows\\phantomjs.exe");
 //       DesireCaps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, "c:\\Tools\\Browsers\\phantomjs-2.1.1-windows\\");
        File file = new File("C:\\Tools\\Browsers\\phantomjs-2.1.1-windows\\phantomjs.exe");
        System.setProperty("phantomjs.binary.path", file.getAbsolutePath());
        PhantomJSDriver driver = new PhantomJSDriver();
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
