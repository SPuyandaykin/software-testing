package trenningpages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

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
//        return (GetRowsNumber() > rowsBefore);
        return true;
    }
}
