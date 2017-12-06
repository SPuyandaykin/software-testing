package trenningpages;

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
}
