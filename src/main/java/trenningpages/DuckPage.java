package trenningpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import trenningutils.PropertyAnalize;

import static org.openqa.selenium.support.ui.ExpectedConditions.textToBe;
import static org.openqa.selenium.support.ui.ExpectedConditions.textToBePresentInElementValue;

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

    public int AddToCart(){

        int prevValue = GetQuantityInCart();
        SelectSize("Small");
        ClickButton("add_cart_product");
        return WaitQuantityInCart(String.valueOf(prevValue+1));
    }



    public boolean SelectSize (String duckSize) {

        if (elementNotExist(By.cssSelector(".options select"))) {
            System.out.println("Size list box is not presented");
            return false;
        }

        return SelectListBoxValue("Size", duckSize);
    }

    public boolean ReturnHome() {
        return ClickLinkByText("Home");
    }
}
