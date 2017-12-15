package trenningpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TablePage extends ContentPage {
    public TablePage (WebDriver driver){ super(driver); }

    protected int GetRowsNumber(){
        return driver.findElements(By.xpath("//tr[@class='row']")).size();
    }

    protected boolean EditElementInTable(String objectName){
        String sPath = "//table[@class='dataTable']/tbody/tr/td/a[contains(.,'" + objectName + "')]";

        if(isElementPresent(By.xpath(sPath))){
            driver.findElement(By.xpath(sPath)).click();
            return true;
        }

        return false;
    }
}
