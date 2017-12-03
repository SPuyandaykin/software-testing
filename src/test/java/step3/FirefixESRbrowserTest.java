package step3;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;

public class FirefixESRbrowserTest {
    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void start(){

        FirefoxOptions ffOptions = new FirefoxOptions();
        ffOptions.setBinary("C:\\Tools\\Browsers\\Mozilla Firefox\\firefox.exe").setLegacy(true);
        driver = new FirefoxDriver(ffOptions);
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
