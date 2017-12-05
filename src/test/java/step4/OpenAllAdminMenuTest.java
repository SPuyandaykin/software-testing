package step4;

import BaseTestPages.BaseTest;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class OpenAllAdminMenuTest extends BaseTest {

    @Test
    public void MenuOpen () {
        driver.get("http://localhost/litecart/admin");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
        WebElement menu = driver.findElement(By.cssSelector("#box-apps-menu"));
        List<WebElement> mainMenu = menu.findElements(By.cssSelector("#app-"));
        System.out.println(mainMenu.size());
    }
}
