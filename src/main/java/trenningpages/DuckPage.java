package trenningpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import trenningutils.PropertyAnalize;

public class DuckPage extends ContentPage {
    protected PropertyAnalize propertyAnalize;

    public DuckPage(WebDriver driver){
        super(driver);
        propertyAnalize = new PropertyAnalize();
    }


    public String getDuckName() {
        return driver.findElement(By.cssSelector("h1.title")).getText();
    }

    public String getRegularPrice() {
        return driver.findElement(By.cssSelector(".regular-price")).getText();
    }

    public String getCampaignPrice() {
        return driver.findElement(By.cssSelector(".campaign-price")).getText();
    }

    public boolean RegularPriceIsGrayAndCrossed() {

        WebElement regularPrice = driver.findElement(By.cssSelector(".regular-price"));
        if(!propertyAnalize.IsFontGrayAndGrossed(regularPrice))
            return false;

        return true;
    }

    public boolean CampaignPriceIsRedAndStrong() {
        WebElement regularPrice = driver.findElement(By.cssSelector(".campaign-price"));
        if(!propertyAnalize.IsFontRedAndStrong(regularPrice))
            return false;

        return true;
    }

    public boolean RegularPriceFondIsLessCampaignOne() {
        WebElement regularPrice = driver.findElement(By.cssSelector(".regular-price"));
        WebElement campaingPrice = driver.findElement(By.cssSelector(".campaign-price"));

        if(!propertyAnalize.IsRegularFontLessCampaign(regularPrice, campaingPrice))
            return false;

        return true;
    }
}
