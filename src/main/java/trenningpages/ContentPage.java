package trenningpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContentPage  extends Page{
    public ContentPage (WebDriver driver){ super(driver); }

    public boolean isTitleH1Exist(){
        return IsElementExists(By.cssSelector("h1"));
    }
}
