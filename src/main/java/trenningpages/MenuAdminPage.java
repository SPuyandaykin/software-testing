package trenningpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MenuAdminPage extends Page {

    public MenuAdminPage(WebDriver driver){
        super(driver);
    }

    public int counterSectionMenu(){
        return driver.findElements(By.cssSelector("#box-apps-menu #app-")).size();
    }

    public int counterSubMenu(){
        int counter = 0;
        if(elementNotExist(By.cssSelector("ul.docs li")))
            System.out.println("SubMenus not exist");
        else
            counter = driver.findElements(By.cssSelector("ul.docs li")).size();
        return counter;
    }

    public ContentPage selectMainMenu(int numSection){
        List<WebElement> mainMenu = driver.findElements(By.cssSelector("#box-apps-menu #app-"));
        mainMenu.get(numSection).click();
        return new ContentPage(driver);
    }

    public ContentPage selectSubMenu(int numSection){
        List<WebElement> subMenu = driver.findElements(By.cssSelector("ul.docs li"));
        subMenu.get(numSection).click();
        return new ContentPage(driver);
    }

    public boolean isTitleH1Exist(){
        return IsElementExists(By.cssSelector("h1"));
    }

    public CountriesPage OpenCountriesPage() {
        OpenMenu("Countries");
        return new CountriesPage(driver);
    }

    private void OpenMenu(String menuName) {
        String searchPath = "//a[./span[contains(text(),'"+menuName+"')]]";
        driver.findElement(By.xpath(searchPath)).click();
    }

    public GeozonePage OpenGeozonePage() {
        OpenMenu("Geo Zones");
        return new GeozonePage (driver);
    }

    public SecurityPage OpenSecuritySubPage() {
        OpenMenu("Settings");
        OpenMenu("Security");
        return new SecurityPage (driver);
    }

    public CustomersPage OpenCustomersPage() {
        OpenMenu("Customers");
        return new CustomersPage (driver);
    }
}
