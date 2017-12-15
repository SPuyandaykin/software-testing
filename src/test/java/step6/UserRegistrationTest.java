package step6;

import BaseTestPages.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import trenningpages.*;
import trenningutils.UtilitiesClass;

public class UserRegistrationTest extends BaseTest {

    private HomePage homePage;
    private AdminPage adminPage;
    private MenuAdminPage menuPage;
    private SecurityPage securityPage;
    private LoginPage loginPage;
    private CustomersPage customersPage;
    private UtilitiesClass utilitiesClass;

    String userEmail = "yyy@yandex.ru";
    String userPassword = "Test";

    @Before
    public void SetUp(){
        adminPage = new AdminPage(getWebDriver());
        loginPage = new LoginPage(getWebDriver());
        homePage = new HomePage(getWebDriver());
        utilitiesClass = new UtilitiesClass();
    }

    @Test
    public void CreateUserTest() {

        userEmail = utilitiesClass.EmailGenerator("@yandex.ru");

        TurnOffCaptcha();

        homePage.open();
        loginPage.open();
        Assert.assertTrue(loginPage.CreateAccount(userEmail, userPassword));
        Assert.assertTrue(loginPage.LogOut());
        Assert.assertTrue(loginPage.LogIn(userEmail, userPassword));
        Assert.assertTrue(loginPage.LogOut());

        DeleteCurrentUser();
    }

    public void TurnOffCaptcha(){
        menuPage = adminPage.OpenAndLogin(admin);
        securityPage = menuPage.OpenSecuritySubPage();
        securityPage.CaptchaMode("False");
    }

    public void DeleteCurrentUser(){
        String customerName;

        Assert.assertTrue(loginPage.LogIn(userEmail, userPassword));
        customerName = loginPage.GetCurrentCustomer();
        System.out.println("customer is: "+customerName);
        Assert.assertTrue(loginPage.LogOut());
        menuPage = adminPage.OpenAndLogin(admin);
        customersPage = menuPage.OpenCustomersPage();
        Assert.assertTrue(customersPage.DeleteCustomer(customerName));
    }

}
