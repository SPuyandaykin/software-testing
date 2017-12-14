package trenningpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TablePage extends ContentPage {
    public TablePage (WebDriver driver){ super(driver); }

    protected int GetRowsNumber(){
        return driver.findElements(By.xpath("//tr[@class='row']")).size();
    }
}
