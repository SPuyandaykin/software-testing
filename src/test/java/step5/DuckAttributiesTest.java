package step5;

import BaseTestPages.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import trenningobjects.DuckObject;
import trenningpages.DuckPage;
import trenningpages.HomePage;

public class DuckAttributiesTest extends BaseTest {

    private HomePage homePage;


    @Test
    public void AttributiesTest () {

        DuckObject duckObject;
        DuckPage duckPage;
        homePage = new HomePage(getWebDriver());

        homePage.open();
        duckObject = new DuckObject(homePage.GetDuckForTest("Campaigns", 1));
        String duckName = duckObject.getDuckName();
        String regularPrice = duckObject.getRegularPrice();
        String campaignPrice = duckObject.getCampaignPrice();

        Assert.assertTrue(duckObject.RegularPriceIsGrayAndCrossed());
        Assert.assertTrue(duckObject.CampaignPriceIsRedAndStrong());
        Assert.assertTrue(duckObject.RegularPriceFondIsLessCampaignOne());

        duckObject.OpenDuckPage();
        duckPage = new DuckPage(getWebDriver());
        Assert.assertEquals(duckPage.getDuckName(),duckName);
        Assert.assertEquals(duckPage.getRegularPrice(),regularPrice);
        Assert.assertEquals(duckPage.getCampaignPrice(),campaignPrice);
        Assert.assertTrue(duckPage.RegularPriceIsGrayAndCrossed());
        Assert.assertTrue(duckPage.CampaignPriceIsRedAndStrong());
        Assert.assertTrue(duckPage.RegularPriceFondIsLessCampaignOne());

    }
}
