package step10;

import BaseTestPages.BaseTest;
import net.lightbody.bmp.core.har.Har;
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
        proxy.newHar();
        menuPage = adminPage.OpenAndLogin(admin);
        Har har = proxy.endHar();
        har.getLog().getEntries().forEach(l -> System.out.println(l.getResponse().getStatus() + ":" + l.getRequest().getUrl()));
 //       adminPage.ClickBySelectorButton("//tr");
    }

}
