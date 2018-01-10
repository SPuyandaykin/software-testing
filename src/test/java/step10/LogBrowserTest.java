package step10;

import BaseTestPages.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import trenningpages.AdminPage;
import trenningpages.CatalogPage;
import trenningpages.HomePage;
import trenningpages.MenuAdminPage;

public class LogBrowserTest  extends BaseTest {
    private AdminPage adminPage;
    private MenuAdminPage menuPage;
    private CatalogPage catalogPage;

    @Before
    public void SetUp(){
        adminPage = new AdminPage(getWebDriver());
    }

    @Test
    public void LoggingTest() {

        menuPage = adminPage.OpenAndLogin(admin);
        catalogPage = menuPage.OpenCatalogSubPage();
        catalogPage.ExpandMenu("Rubber Ducks");
        catalogPage.ExpandMenu("Subcategory");
        Assert.assertTrue(catalogPage.OpenAllProducts());
        driver.manage().logs().get("browser").forEach(l -> System.out.println(l));
    }
}
