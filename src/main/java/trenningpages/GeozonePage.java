package trenningpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class GeozonePage  extends ContentPage {

    private EditGeoZonePage editGeoPage;

    public GeozonePage (WebDriver driver){
        super(driver);
    }

    public void CheckGeozoneOrger() {
        List<WebElement> geozoneList = driver.findElements(By.cssSelector(".dataTable .row a[title='Edit']"));
        int geozoneSize = geozoneList.size();
        for (int i = 0; i <= geozoneSize-1; i++ ) {
            editGeoPage = GetEditGeoZonePage(geozoneList.get(i));
            editGeoPage.CheckZoneList();
            geozoneList = driver.findElements(By.cssSelector(".dataTable .row a[title='Edit']"));
        }
    }

    private EditGeoZonePage GetEditGeoZonePage(WebElement element) {
        element.click();
        return new EditGeoZonePage(driver);
    }
}
