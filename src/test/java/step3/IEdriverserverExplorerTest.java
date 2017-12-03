package step3;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class IEdriverserverExplorerTest {
    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void start(){
//        System.setProperty("webdriver.ie.driver", "c://Tools/drivers/IEDriverServer.exe");
        driver = new InternetExplorerDriver();
        wait = new WebDriverWait(driver,10);
    }

    @Test
    public void myFirstTest(){
        driver.get("http://localhost/litecart/admin");
        driver.findElement(By.name("username")).sendKeys("admin");
//        driver.findElement(By.name("password")).sendKeys("admin");
//        driver.findElement(By.name("login")).click();

//        Assert.assertTrue(driver.getTitle().equals("My Store"));
    }

    @After
    public void stop (){
//        driver.quit();
//        driver = null;
    }
}
