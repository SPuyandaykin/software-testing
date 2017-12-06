package trenningpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage extends Page{
    public HomePage(WebDriver driver){
        super(driver);
    }

    public void open(){
        driver.get("http://localhost/litecart");
    }

    public int counterGoods(){
        return driver.findElements(By.cssSelector("li[class='product column shadow hover-light']")).size();
    }

    public int getStickerNumber(int numberDuck){
        List<WebElement> listDucks = driver.findElements(By.cssSelector("li[class='product column shadow hover-light']"));
        return listDucks.get(numberDuck).findElements(By.cssSelector(".image-wrapper > div")).size();
    }
}
