package step7;

import BaseTestPages.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import trenningobjects.DuckObject;
import trenningpages.CartPage;
import trenningpages.DuckPage;
import trenningpages.HomePage;

public class CartTest extends BaseTest {
    private HomePage homePage;
    private CartPage cartPage;

    @Before
    public void SetUp(){
        homePage = new HomePage(getWebDriver());
    }

    @Test
    public void CartTesting() {

        homePage.open();
        Assert.assertTrue(AddProductToCart(3));
        cartPage = homePage.OpenCartPage();
        Assert.assertTrue(cartPage.CleanCart());
    }

    private boolean AddProductToCart(int quantity){
        DuckObject duckObject;
        DuckPage duckPage;

        for (int i = 1; i <= quantity; i++ ) {
            duckObject = new DuckObject(homePage.GetDuckForTest("Most Popular", i));
            duckObject.OpenDuckPage();
            duckPage = new DuckPage(getWebDriver());
            duckPage.AddToCart();
            duckPage.ReturnHome();
        }

        return (homePage.GetQuantityInCart()==quantity);
    }

}