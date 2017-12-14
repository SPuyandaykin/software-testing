package trenningpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContentPage extends Page{
    public ContentPage (WebDriver driver){ super(driver); }

    public boolean isTitleH1Exist(){
        return IsElementExists(By.cssSelector("h1"));
    }

    public String GetTitleH1 (){
        if (isTitleH1Exist())
            return driver.findElement(By.cssSelector("h1")).getText();

        return "";
    }

    public String GetAdminNotice(){
        return GetTextCSSElement(".notice success");
    }

}
