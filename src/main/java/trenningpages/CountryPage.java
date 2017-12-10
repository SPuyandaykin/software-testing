package trenningpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class CountryPage extends ContentPage{
    public CountryPage (WebDriver driver){
        super(driver);
    }

    public void CheckAlphabeticZone() {
        List<WebElement> zoneList = driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr/td[3]"));
        int zoneSize = zoneList.size();
        System.out.println("count zone is: " + zoneSize);
        char prevFirstChar = 'A';

        for (int i = 0; i <= zoneSize-1; i++ ) {
            if(zoneList.get(i).findElement(By.tagName("input")).getAttribute("type").equalsIgnoreCase("text")) {
                continue;
            }
            String currentZone = zoneList.get(i).getText();
            System.out.println("zone is: " + currentZone);
            char currentFirsChar = currentZone.charAt(0);
            Assert.assertTrue(currentFirsChar >= prevFirstChar);
            prevFirstChar = currentFirsChar;
        }
    }
}
