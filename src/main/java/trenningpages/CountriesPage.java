package trenningpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class CountriesPage extends ContentPage{
    public CountriesPage(WebDriver driver){
        super(driver);
    }

    public void CheckAlphabeticCountriesOrder() {
        List<WebElement> countriesList = driver.findElements(By.cssSelector(".dataTable .row"));
        int countriesSize = countriesList.size();
        char prevFirstChar = 'A';

        for (int i = 0; i <= countriesSize-1; i++ ) {
            String currentCountry = countriesList.get(i).findElement(By.cssSelector("td a")).getText();
            System.out.println("country is: " + currentCountry);
            char currentFirsChar = currentCountry.charAt(0);
            Assert.assertTrue(currentFirsChar >= prevFirstChar);
            prevFirstChar = currentFirsChar;
        }
    }

    public void CheckCountryZoneAlphabeticOrder() {
        List<WebElement> countList = driver.findElements(By.cssSelector(".dataTable .row"));
        int countriesSize = countList.size();
        for (int i = 0; i <= countriesSize-1; i++ ) {
            List<WebElement> elem = countList.get(i).findElements(By.tagName("td"));
            if(Integer.parseInt(elem.get(5).getText())>0) {
                CheckZoneOrder(elem);
                countList = driver.findElements(By.cssSelector(".dataTable .row"));
            }
        }
    }

    public void CheckZoneOrder(List<WebElement> countryRow){

        countryRow.get(4).findElement(By.tagName("a")).click();

        CountryPage countryPage = new CountryPage(driver);
        countryPage.CheckAlphabeticZone();

        driver.findElement(By.cssSelector(".button-set button[name='cancel']")).click();
    }
}
