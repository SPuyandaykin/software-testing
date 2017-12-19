package trenningpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.support.ui.ExpectedConditions.textToBe;

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

    public int GetQuantityInCart(){
        String sValue = GetTextXPathElement("//span[@class='quantity']");
        return Integer.valueOf(sValue);
    }

    public int WaitQuantityInCart(String waitedValue){
        String sPath = "//span[@class='quantity']";
        wait.until(textToBe(By.xpath(sPath),waitedValue));
        return Integer.valueOf(GetTextXPathElement(sPath));
    }

}
