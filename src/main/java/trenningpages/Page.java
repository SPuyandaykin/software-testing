package trenningpages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import trenningutils.UtilitiesClass;

import java.util.concurrent.TimeUnit;

public class Page {

    protected WebDriver driver;
    protected WebDriverWait wait;

    protected UtilitiesClass utility;

    public Page(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 3);

        utility = new UtilitiesClass();
    }

    protected void type(WebElement webElement, String text){
        webElement.clear();
        webElement.sendKeys(text);
    }

    public boolean IsElementExists(By iClassName)
    {
        if(driver.findElements(iClassName).size()>0) {
            return true;
        }
        else {
            return false;
        }
    }

    public boolean elementNotExist(By iClassName)
    {
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        try {
            driver.findElement(iClassName).isDisplayed();
            driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
            return false;
        }catch (NoSuchElementException e){
            driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
            return true;
        }
    }

    public boolean isElementPresent(By iClassName)
    {
        try {
            driver.findElement(iClassName).isDisplayed();
            return true;
        }catch (NoSuchElementException e){
            return false;
        }
    }
}
