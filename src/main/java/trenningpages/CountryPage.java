package trenningpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.testng.Assert;

import java.util.List;
import java.util.Set;

public class CountryPage extends ContentPage{

    String countryName;
    String mainWindow;

    public CountryPage (WebDriver driver){ super(driver); }

    public void CheckAlphabeticZone() {
        List<WebElement> zoneList = driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr/td[3]"));
        int zoneSize = zoneList.size();
        System.out.println("count zone is: " + zoneSize);
        char prevFirstChar = 'A';

        for (int i = 0; i <= zoneSize-1; i++ ) {
            if(zoneList.get(i).findElement(By.tagName("input")).getAttribute("type").equalsIgnoreCase("text")) {
                continue;
            }
            String currentZone = zoneList.get(i).getText();
            System.out.println("zone is: " + currentZone);
            char currentFirsChar = currentZone.charAt(0);
            Assert.assertTrue(currentFirsChar >= prevFirstChar);
            prevFirstChar = currentFirsChar;
        }
    }

    public boolean CreateNewCountry(String name) {

        countryName = name;
        Assert.assertTrue(SetStatus("Enabled"));
        Assert.assertTrue(SetCodeAlfa2());
        Assert.assertTrue(SetCodeAlfa3());
        Assert.assertTrue(SetName());
        Assert.assertTrue(SetDomecticName());
        Assert.assertTrue(SetTaxIDFormat());
        Assert.assertTrue(SetAddressFormat());
        Assert.assertTrue(SetPostCodeFormat());
        Assert.assertTrue(SetCurrencyCode());
        Assert.assertTrue(SetPhoneCode());
        Assert.assertTrue(SetZones());

//        ClickButton("save");

        return true;
    }

    private boolean SetStatus(String enabled) {

        return true;
    }

    private boolean SetCodeAlfa2() {
        String alfa2 = GetAlpha2Value();
        alfa2 = "AA"; //don't duplicate "RU" code
        return SetEditBoxValue("iso_code_2", alfa2);
    }

    private String GetAlpha2Value(){
        String urlFull = GetUrlLinkFollowingEditBox("iso_code_2");
        mainWindow = OpenAndSwitchToURL(urlFull);
        WebElement tableForFind = FindTableWithKeyText("ISO 3166-2:", 5);
        String codeAlfa2  = GetColumnTextByTextInOtherColumnInTable(tableForFind, countryName, 1);
        ReturnToMainWindow(mainWindow);
        return codeAlfa2;
    }

    private boolean SetCodeAlfa3() {
        String alfa3 = GetAlpha3Value();
        return SetEditBoxValue("iso_code_3", alfa3);
    }

    private String GetAlpha3Value(){
        String urlFull = GetUrlLinkPrecedingEditBox("iso_code_3");
        mainWindow = OpenAndSwitchToURL(urlFull);
        String codeAlfa3  = GetColumnTextByTextInOtherColumnOnPage(countryName, 1);
        ReturnToMainWindow(mainWindow);
        return codeAlfa3;
    }

    private boolean SetName() {
        return SetEditBoxValue("name", countryName);
    }
    private boolean SetDomecticName() {
        return SetEditBoxValue("domestic_name", countryName +" - home, sweet home");
    }
    private boolean SetTaxIDFormat() {
        String taxFormat = OpenAndCloseOtherWindow("tax_id_format");
        return SetEditBoxValue("tax_id_format", taxFormat);
    }

    private String OpenAndCloseOtherWindow(String editFieldName){
        String urlFull = GetUrlLinkPrecedingEditBox(editFieldName);
        mainWindow = OpenAndSwitchToURL(urlFull);
        ReturnToMainWindow(mainWindow);
        return ""; // cannot get info from external source
    }

    private boolean SetAddressFormat() {
        String addressFormat = GetAddressFormatExternal();
        return SetTextAreaValue("textarea[name='address_format']", addressFormat);
    }

    private String GetAddressFormatExternal(){
        String urlFull = GetUrlLinkPrecedingTextArea("address_format");
        mainWindow = OpenAndSwitchToURL(urlFull);
        ReturnToMainWindow(mainWindow);

        String addressFormat = "%company\n" +
                "%firstname %lastname\n" +
                "%address1\n" +
                "%address2\n" +
                "%postcode %city\n" +
                "%zone_name\n" +
                "%country_name";
        return addressFormat;
    }

    private boolean SetPostCodeFormat() {
        String postCodeFormat = OpenAndCloseOtherWindow("postcode_format");
        postCodeFormat = "\\d{6}";
        return SetEditBoxValue("postcode_format", postCodeFormat);
    }
    private boolean SetCurrencyCode() {
        String currencyCode = OpenAndCloseOtherWindow("currency_code");
        currencyCode = "RUB";
        return SetEditBoxValue("currency_code", currencyCode);
    }
    private boolean SetPhoneCode() {
        String phoneCode = GetPhoneCodeExternal();
        return SetEditBoxValue("phone_code", phoneCode);
    }

    private String GetPhoneCodeExternal(){
        String urlFull = GetUrlLinkPrecedingEditBox("phone_code");
        mainWindow = OpenAndSwitchToURL(urlFull);
        String codePhone  = driver.findElement(By.xpath("//a[contains(@title,'Russia')]//preceding::a[1]")).getText();
        ReturnToMainWindow(mainWindow);
        return codePhone;
    }

    private boolean SetZones() {

        return true;
    }


}
