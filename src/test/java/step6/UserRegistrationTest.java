package step6;

import BaseTestPages.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import trenningpages.*;

public class UserRegistrationTest extends BaseTest {

    private HomePage homePage;
    private AdminPage adminPage;
    private MenuAdminPage menuPage;
    private SecurityPage securityPage;
    private LoginPage loginPage;

    public void SetUp(){
        adminPage = new AdminPage(getWebDriver());
        menuPage = adminPage.OpenAndLogin(admin);
        loginPage = new LoginPage(getWebDriver());
    }

    @Test
    public void CreateUserTest() {

 //       TurnOffCaptcha();

        homePage = new HomePage(getWebDriver());
        loginPage = new LoginPage(getWebDriver());

        homePage.open();
        loginPage.open();
        Assert.assertTrue(loginPage.CreateAccount());


//        DeleteNewUser();
    }

    public void TurnOffCaptcha(){
        adminPage = new AdminPage(getWebDriver());
        menuPage = adminPage.OpenAndLogin(admin);
        securityPage = menuPage.OpenSecuritySubPage();
        securityPage.CaptchaMode("False");
    }

    public void DeleteNewUser(){
        adminPage.open();

    }

//    @Test
//    public void LoginNewUserTest(){
//
//    }
}
