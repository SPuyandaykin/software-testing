package step8;

import BaseTestPages.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import trenningpages.AdminPage;
import trenningpages.CountriesPage;
import trenningpages.MenuAdminPage;

public class LinkNewWindowTest extends BaseTest {
    private AdminPage adminPage;
    private MenuAdminPage menuPage;
    private CountriesPage countriesPage;

    @Before
    public void SetUp(){
        adminPage = new AdminPage(getWebDriver());
    }

    @Test
    public void LinkTest() {

        menuPage = adminPage.OpenAndLogin(admin);
        countriesPage = menuPage.OpenCountriesPage();
        Assert.assertTrue(countriesPage.AddNewCountry("Russia"));
    }

}
