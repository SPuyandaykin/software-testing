package trenningpages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CatalogPage extends TablePage {
    public CatalogPage(WebDriver driver){
        super(driver);
    }

    public boolean AddNewProduct(String productName) {
        ProductPage productPage;

        int rowsBefore = GetRowsNumber();
        ClickXPathElement("//a[@class='button'][2]");
        productPage = new ProductPage(driver);
        productPage.AddProduct(productName);
        return (GetRowsNumber() > rowsBefore);
    }

    public boolean DeleteProduct(String productName) {
        ProductPage productPage;

        int rowsBefore = GetRowsNumber();
        productPage = SelectProduct(productName);
        productPage.DeleteProduct(productName);
        return (GetRowsNumber() < rowsBefore);
    }

    public ProductPage SelectProduct(String productName){
        EditElementInTable(productName);
        return new ProductPage(driver);
    }

    public void ExpandMenu (String menuName){
        SelectProduct(menuName);
    }

    public boolean OpenAllProducts(){
        int productCounter = driver.findElements(By.xpath("//td/img/following::a[1]")).size();

        for (int i = 0; i <= productCounter-1; i++ ) {
            List<WebElement> productList = driver.findElements(By.xpath("//td/img/following::a[1]"));
            productList.get(i).click();
            ProductPage productPage = new ProductPage(driver);
            productPage.CancelProduct();
        }
        return true;
    }

}
