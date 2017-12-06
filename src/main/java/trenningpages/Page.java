package trenningpages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Page {
    protected WebDriver driver;

    public Page(WebDriver driver){
        this.driver = driver;
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
