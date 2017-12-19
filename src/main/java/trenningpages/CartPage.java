package trenningpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;

import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class CartPage extends Page {
    public CartPage(WebDriver driver){ super(driver); }

    public boolean CleanCart() {

        if(!CheckSummaryTable())
           return true;

        int numIcons = GetIconsNumber();
        System.out.println("number is: "+numIcons);

        do {
            if(numIcons>1)
                FixSwiminingDucks();
            WebElement element = driver.findElement(By.xpath("//table[@class='dataTable rounded-corners']"));
    //        pause(1000);
            RemoveCurrentProduct();
            wait.until(stalenessOf(element));
            numIcons--;
            System.out.println("counter is: "+ numIcons);
            if(!CheckSummaryTable())
                return true;
        } while (numIcons>0);

        return false;
    }

    private boolean CheckSummaryTable(){
        if(!isElementPresent(By.xpath("//table[@class='dataTable rounded-corners']"))){
            System.out.println("Cart is empty");
            return false;
        } else
            System.out.println("Cart has product");

        return true;
    }

    private int GetIconsNumber(){
        return GetWebElementQuantity("//ul[@class='shortcuts']/li");
    }

    private boolean FixSwiminingDucks(){
        System.out.println("freeze");
        return ClickCSSElement("li[class='shortcut'] a");
    }

    private void RemoveCurrentProduct(){
        System.out.println("removed");

//        ClickElement(By.cssSelector("button[name='update_cart_item']"));
        wait.until(presenceOfElementLocated(By.cssSelector("button[name='update_cart_item']")));
        ClickElement(By.cssSelector("button[name='remove_cart_item']"));
    }
}
