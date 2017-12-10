package step4;

import BaseTestPages.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import trenningpages.AdminPage;
import trenningpages.ContentPage;
import trenningpages.MenuAdminPage;

import java.util.List;

public class OpenAllAdminMenuTest extends BaseTest {

    private AdminPage adminPage;
    private MenuAdminPage menuPage;
    private ContentPage contentPage;

    @Test
    public void MenuOpen () {

        adminPage = new AdminPage(getWebDriver());
        menuPage = new MenuAdminPage(getWebDriver());

        adminPage.open();
        adminPage.loginAs(admin);

        int sizeMenu = menuPage.counterSectionMenu();
        for (int i = 0; i <= sizeMenu-1; i++ ) {
            contentPage = menuPage.selectMainMenu(i);
            Assert.assertTrue(contentPage.isTitleH1Exist());

            int sizeSubMenu = menuPage.counterSubMenu();
            for (int j = 0; j <= sizeSubMenu-1; j++ ) {
                if(j == 0){
                    System.out.println("1st SubMenu has been tested on parent's menu level");
                    continue;
                }
                contentPage = menuPage.selectSubMenu(j);
                Assert.assertTrue(contentPage.isTitleH1Exist());
            }
        }

    }
}
