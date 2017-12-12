package trenningpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import trenningdata.UserData;

public class AdminPage extends Page{

    public AdminPage(WebDriver driver){
        super(driver);
    }

    public void open(){
        driver.get("http://localhost/litecart/admin");
    }

    public void loginAs (UserData admin){
        WebElement nameField = driver.findElement(By.name("username"));
        WebElement passField = driver.findElement(By.name("password"));
        type(nameField, admin.name);
        type(passField, admin.password);
        driver.findElement(By.name("login")).click();
    }

     public MenuAdminPage OpenAndLogin(UserData admin) {
        open();
        loginAs(admin);

        return new MenuAdminPage(driver);
    }

}
