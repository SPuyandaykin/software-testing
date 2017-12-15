package step6;

import BaseTestPages.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import trenningpages.*;

public class NewGoodAddTest extends BaseTest {
    private HomePage homePage;
    private AdminPage adminPage;
    private MenuAdminPage menuPage;
    private CatalogPage catalogPage;

    String newProduct = "Silver Duck";

    @Before
    public void SetUp(){
        adminPage = new AdminPage(getWebDriver());
        homePage = new HomePage(getWebDriver());
    }

    @Test
    public void GoodsAddingTest() {

       menuPage = adminPage.OpenAndLogin(admin);
        catalogPage = menuPage.OpenCatalogSubPage();
        Assert.assertTrue(catalogPage.AddNewProduct(newProduct));
        homePage.open();
        Assert.assertTrue(homePage.isProductExist(newProduct));

        DeleteNewProduct(); //clean base
    }

    public void DeleteNewProduct(){
        menuPage = adminPage.OpenAndLogin(admin);
        catalogPage = menuPage.OpenCatalogSubPage();
        Assert.assertTrue(catalogPage.DeleteProduct(newProduct));
    }
}

