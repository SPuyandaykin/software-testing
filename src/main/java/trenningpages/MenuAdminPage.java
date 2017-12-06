package trenningpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MenuAdminPage extends Page {

    public MenuAdminPage(WebDriver driver){
        super(driver);
    }

    public int counterSectionMenu(){
        return driver.findElements(By.cssSelector("#box-apps-menu #app-")).size();
    }

    public int counterSubMenu(){
        return driver.findElements(By.cssSelector("ul.docs li")).size();
    }

    public void selectMainMenu(int numSection){
        List<WebElement> mainMenu = driver.findElements(By.cssSelector("#box-apps-menu #app-"));
        mainMenu.get(numSection).click();
    }

    public void selectSubMenu(int numSection){
        List<WebElement> subMenu = driver.findElements(By.cssSelector("ul.docs li"));
        subMenu.get(numSection).click();
    }

    public boolean isTitleH1Exist(){
        boolean flag = IsElementExists(By.cssSelector("h1"));
        if(flag)
            System.out.println("Menu title H1 is: " + driver.findElement(By.cssSelector("h1")).getText());
        else
            System.out.println("Menu title H1 doesn't exist");
        return flag;
    }
}
