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

        do {
            if(numIcons>1)
                FixSwiminingDucks();
            WebElement element = GetElementByXpath("//table[@class='dataTable rounded-corners']");
            RemoveCurrentProduct();
            numIcons--;
            if(!GetUpdatedSummaryTable(element))
                return true;
        } while (numIcons>0);

        return false;
    }

    private boolean GetUpdatedSummaryTable(WebElement element){
        wait.until(stalenessOf(element));
        return CheckSummaryTable();
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
        ClickButton("remove_cart_item");
    }
}
