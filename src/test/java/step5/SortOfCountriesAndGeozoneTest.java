package step5;

import BaseTestPages.BaseTest;
import org.junit.Before;
import org.junit.Test;
import trenningpages.AdminPage;
import trenningpages.CountriesPage;
import trenningpages.GeozonePage;
import trenningpages.MenuAdminPage;

public class SortOfCountriesAndGeozoneTest extends BaseTest {

    private AdminPage adminPage;
    private MenuAdminPage menuPage;
    private CountriesPage countriesPage;
    private GeozonePage geozonePage;

    @Before
    public void SetUp(){
        adminPage = new AdminPage(getWebDriver());
        menuPage = adminPage.OpenAndLogin(admin);
    }

    @Test
    public void SortingTest () {

        countriesPage = menuPage.OpenCountriesPage();
        countriesPage.CheckAlphabeticCountriesOrder();
        countriesPage.CheckCountryZoneAlphabeticOrder();
    }

    @Test
    public void GeoZoneTest (){

        geozonePage = menuPage.OpenGeozonePage();
        geozonePage.CheckGeozoneOrger();
    }
}
