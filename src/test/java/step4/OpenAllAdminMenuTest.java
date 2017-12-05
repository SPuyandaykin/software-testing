package step4;

import BaseTestPages.BaseTest;
import org.junit.Test;

public class OpenAllAdminMenuTest extends BaseTest {

    @Test
    public void MenuOpen () {
        driver.get("http://localhost/litecart/admin");
    }
}
