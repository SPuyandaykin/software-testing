package trenningpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends Page {
    public LoginPage(WebDriver driver){ super(driver); }

    public void open(){
        driver.findElement(By.cssSelector("a[href*='create_account'")).click();
    }

    public boolean CreateAccount(){
        return true;
    }
}
