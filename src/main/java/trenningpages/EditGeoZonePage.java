package trenningpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class EditGeoZonePage extends ContentPage{
    public EditGeoZonePage (WebDriver driver){
        super(driver);
    }

    public void CheckZoneList() {

        List<WebElement> zoneList = driver.findElements
                (By.xpath("//table[@class='dataTable']/tbody/tr/td[3]/select/option[@selected='selected']"));
        Assert.assertTrue(utility.CheckAlpabeticList(zoneList));

        driver.findElement(By.cssSelector(".button-set button[name='cancel']")).click();
    }
}
