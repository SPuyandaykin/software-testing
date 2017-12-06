package step4;

import BaseTestPages.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import trenningpages.AdminPage;
import trenningpages.MenuAdminPage;

import java.util.List;

public class OpenAllAdminMenuTest extends BaseTest {

    private AdminPage adminPage;
    private MenuAdminPage menuPage;

    @Test
    public void MenuOpen () {

        adminPage = new AdminPage(getWebDriver());
        menuPage = new MenuAdminPage(getWebDriver());

        adminPage.open();
        adminPage.loginAs(admin);

        int sizeMenu = menuPage.counterSectionMenu();
        for (int i = 0; i <= sizeMenu-1; i++ ) {
            menuPage.selectMainMenu(i);
            Assert.assertTrue(menuPage.isTitleH1Exist());

            int sizeSubMenu = menuPage.counterSubMenu();
            for (int j = 0; j <= sizeSubMenu-1; j++ ) {
                if(j == 0){
                    System.out.println("1st SubMenu has been tested on parent's menu level");
                    continue;
                }
                menuPage.selectSubMenu(j);
                Assert.assertTrue(menuPage.isTitleH1Exist());
            }
        }

    }
}
