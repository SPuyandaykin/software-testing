package step4;

import BaseTestPages.BaseTest;
import org.junit.Assert;
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

        int sizeMenu = driver.findElements(By.cssSelector("#box-apps-menu #app-")).size();
        System.out.println("Menu number is: " + sizeMenu);

        for (int i = 0; i <= sizeMenu-1; i++ ) {
            List<WebElement> mainMenu = driver.findElements(By.cssSelector("#box-apps-menu #app-"));
            mainMenu.get(i).click();
            Assert.assertTrue(IsElementExists(By.cssSelector("h1")));
            System.out.println("Menu title is: " + driver.findElement(By.cssSelector("h1")).getText());

            int sizeSubMenu = driver.findElements(By.cssSelector("ul.docs li")).size();
            System.out.println("SubMenu number is: " + sizeSubMenu);

            for (int j = 0; j <= sizeSubMenu-1; j++ ) {
                if(j == 0){
                    System.out.println("1st SubMenu has been tested on parent's menu level");
                    continue;
                }
                List<WebElement> subMenu = driver.findElements(By.cssSelector("ul.docs li"));
                subMenu.get(j).click();
                Assert.assertTrue(IsElementExists(By.cssSelector("h1")));
                System.out.println("SubMenu title is: " + driver.findElement(By.cssSelector("h1")).getText());
            }
        }

    }
}
