package trenningpages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends Page {
    public LoginPage(WebDriver driver){ super(driver); }

    public void open(){
        driver.findElement(By.cssSelector("a[href*='create_account'")).click();
    }

    public boolean CreateAccount(String userEmail, String userPassword){

        SetTaxID("1111");
        SetCompany("Testing LTD");
        SetFirstName("Sergey");
        SetLastName("Ivanov");
        SetAddress1("Kremlin, bld #1");
        SetAddress2("Red Square, 500m left, then 200m right");
        SetPostcode("12345");
        SetCity("Moscow");
        SelectCounty("United States");
        SelectState("California");
        SetEmail(userEmail);
        SetPhone("+71111111111");
        SetSubscribe("No");
        SetPassword(userPassword);
        SetConfirmPassword(userPassword);

        CreateAccountButton();
        return CheckCustomerIsLogged();
    }

    private boolean CheckCustomerIsLogged(){
        if(!driver.findElement(By.cssSelector("div[id='box-account'] .title"))
                .getText().equalsIgnoreCase("Account"))
            return false;

        return true;
    }

    public boolean LogIn(String userEmail, String userPassword) {
        SetEmail(userEmail);
        SetPassword(userPassword);
        ClickButton("login");
        return CheckCustomerIsLogged();
    }

    public boolean LogOut() {
        Assert.assertTrue(ClickXPathElement("//a[contains(text(),'Logout')]"));

        if(!driver.findElement(By.cssSelector("div[id='box-account-login'] .title"))
                .getText().equalsIgnoreCase("Login"))
            return false;

        return true;
    }

    private void CreateAccountButton(){
        Assert.assertTrue(ClickButton("create_account"));
    }

    private void SetConfirmPassword(String sValue) {
        Assert.assertTrue(SetEditBoxValue("confirmed_password", sValue));
    }

    private void SetPassword(String sValue) {
        Assert.assertTrue(SetEditBoxValue("password", sValue));
    }

    private void SetSubscribe(String sValue) {
        Assert.assertTrue(SetCheckBox("newsletter", sValue));
    }

    private void SetPhone(String sValue) {
        Assert.assertTrue(SetEditBoxValue("phone", sValue));
    }

    private void SetEmail(String sValue) {
        Assert.assertTrue(SetEditBoxValue("email", sValue));
    }

    private void SelectCounty(String sValue) {
        Assert.assertTrue(SelectListBoxValue("country_code", sValue));
    }

    private void SelectState(String sValue) {
        Assert.assertTrue(SelectListBoxValue("zone_code", sValue));
    }

    private void SetCity(String sValue) {
        Assert.assertTrue(SetEditBoxValue("city", sValue));
    }

    private void SetPostcode(String sValue) {
        Assert.assertTrue(SetEditBoxValue("postcode", sValue));
    }

    private void SetAddress2(String sValue) {
        Assert.assertTrue(SetEditBoxValue("address2", sValue));
    }

    private void SetAddress1(String sValue) {
        Assert.assertTrue(SetEditBoxValue("address1", sValue));
    }

    private void SetLastName(String sValue) {
        Assert.assertTrue(SetEditBoxValue("lastname", sValue));
    }

    private void SetFirstName(String sValue) {
        Assert.assertTrue(SetEditBoxValue("firstname", sValue));
    }

    private void SetCompany(String sValue) {
        Assert.assertTrue(SetEditBoxValue("company", sValue));
    }

    private void SetTaxID(String sValue) {
        Assert.assertTrue(SetEditBoxValue("tax_id", sValue));
    }

    public String GetCurrentCustomer() {
        OpenEditPage();
        String fullName = GetEditBoxValue("firstname")+" "+GetEditBoxValue("lastname");
        Assert.assertFalse(fullName.equals(""));

        return fullName;
    }

    public void OpenEditPage(){
        ClickLinkByText("Edit Account");
        Assert.assertTrue(GetTextCSSElement("#edit-account h1")
                .equalsIgnoreCase("Edit Account"));
    }


}
