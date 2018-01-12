package step10;

import BaseTestPages.BaseTest;
import org.junit.Before;
import org.junit.Test;
import trenningpages.AdminPage;
import trenningpages.MenuAdminPage;

public class ProtocolTest extends BaseTest {
    private AdminPage adminPage;
    private MenuAdminPage menuPage;

    @Before
    public void SetUp(){
        adminPage = new AdminPage(getWebDriver());
    }

    @Test
    public void LoggingTest() {

        menuPage = adminPage.OpenAndLogin(admin);
        adminPage.ClickBySelectorButton("//tr");
    }

}
