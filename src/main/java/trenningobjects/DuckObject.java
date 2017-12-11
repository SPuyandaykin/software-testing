package trenningobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import trenningutils.PropertyAnalize;

public class DuckObject {
    protected WebElement element;
    protected PropertyAnalize propertyAnalize;

    public DuckObject(WebElement getElement){
        element = getElement;
        propertyAnalize = new PropertyAnalize();
    }

    public String getDuckName() {
        return element.findElement(By.cssSelector(".name")).getText();
    }

    public void OpenDuckPage() {
        element.findElement(By.cssSelector("a.link")).click();
    }

    public String getRegularPrice() {
        return element.findElement(By.cssSelector(".regular-price")).getText();
    }

    public String getCampaignPrice() {
        return element.findElement(By.cssSelector(".campaign-price")).getText();
    }

    public boolean RegularPriceIsGrayAndCrossed() {

        WebElement regularPrice = element.findElement(By.cssSelector(".regular-price"));
        if(!propertyAnalize.IsFontGrayAndGrossed(regularPrice))
            return false;

        return true;
    }

    public boolean CampaignPriceIsRedAndStrong(){

        WebElement campaingPrice = element.findElement(By.cssSelector(".campaign-price"));
        if(!propertyAnalize.IsFontRedAndStrong(campaingPrice))
            return false;

        return true;
    }

    public boolean RegularPriceFondIsLessCampaignOne() {
        WebElement regularPrice = element.findElement(By.cssSelector(".regular-price"));
        WebElement campaingPrice = element.findElement(By.cssSelector(".campaign-price"));

        if(!propertyAnalize.IsRegularFontLessCampaign(regularPrice, campaingPrice))
            return false;

        return true;
    }
}
