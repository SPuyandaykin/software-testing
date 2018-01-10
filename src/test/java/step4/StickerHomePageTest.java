package step4;

import BaseTestPages.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import trenningpages.HomePage;

import java.util.List;

public class StickerHomePageTest extends BaseTest {

    private HomePage homePage;

    @Test
    public void StickerCheck () {

        homePage = new HomePage(getWebDriver());

        homePage.open();

        int goodCounter = homePage.counterGoods();
        System.out.println("counter :"+goodCounter);
        for (int i = 0; i <= goodCounter-1; i++ ) {
            Assert.assertTrue(homePage.getStickerNumber(i) == 1);
        }
    }
}
