package trenningpages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.textToBe;

public class HomePage extends ContentPage {
    public HomePage(WebDriver driver){ super(driver); }

    public void open(){
        driver.get("http://localhost/litecart");
    }

    public int counterGoods(){
        return driver.findElements(By.xpath("//li[@class='product column shadow hover-light']")).size();
    }

    public int getStickerNumber(int numberDuck){
        List<WebElement> listDucks = driver.findElements(By.className("image-wrapper"));
        return listDucks.get(numberDuck).findElements(By.cssSelector("div[class^='sticker']")).size();
    }

    public WebElement GetDuckForTest(String sectionOfCatalog, int elementInSection) {
        String spath = "//h3[contains(.,'"+sectionOfCatalog+"')]/..//div[@class='content']/ul/li";
        List<WebElement> elements = driver.findElements(By.xpath(spath));
        Assert.assertTrue(elements.size()>=elementInSection);
        return elements.get(elementInSection-1);
    }

    public boolean isProductExist(String newProduct){
        return SearchProduct(newProduct).GetTitleH1().equals(newProduct);
    }

    public DuckPage SearchProduct(String newProduct) {

        SetEditBoxValue("query", newProduct);
        SendEnterToEditBox("query");
        return new DuckPage(driver);
    }

    public CartPage OpenCartPage(){
        ClickLinkByText("Checkout");
        return new CartPage(driver);
    }

}
