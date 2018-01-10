package trenningpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage extends ContentPage{
    public ProductPage (WebDriver driver){
        super(driver);
    }

    public void AddProduct(String productName) {

        SetupGeneralParams(productName);
        SetupInformationParams();
        SetupPricesParams();
        SaveParams();
    }

    public void SetupGeneralParams(String sname){

        SelectTab("General");

        EnableStatus("Enabled");
        SetName(sname);
        SetCode("st001");
        SetCategories("Rubber Ducks");
        SetCategories("Subcategory");
        SetDefaultCategory("Subcategory");
        SetProguctGroup("Unisex");
        SetQuantity("10");
        SetSoldOutStatus("Temporary sold out");
        UploadImage("silver_duck.jpg");
        SetDateValidFrom("14.12.2017");
        SetDateValidTo("14.12.2018");
    }

    private void SetDateValidTo(String sParam) {
        SetEditBoxValue("date_valid_to", sParam);
    }

    private void SetDateValidFrom(String sParam) {
        SetEditBoxValue("date_valid_from", sParam);
    }

    private void UploadImage(String sParam) {
        String filePath = "\\src\\res\\silver-duck.jpg";
        UploadFileFromFolder(filePath);
    }

    private void SetSoldOutStatus(String sParam) {
        SelectListBoxValue("sold_out_status_id", sParam);
    }

    private void SetQuantity(String sParam) {
        SetEditBoxValue("quantity", sParam);
    }

    private void SetProguctGroup(String sParam) {
        String spath ="//tbody/tr/td[2][contains(.,'"+sParam+"')]/parent::node()/td/input";
        ClickXPathElement(spath);
    }

    private void SetDefaultCategory(String sParam) {
        SelectListBoxValue("default_category_id", sParam);
    }

    private void SetCategories(String sParam) {
        String spath = "//input[@type='checkbox'][@data-name='" + sParam + "']";
        ClickXPathElement(spath);
    }

    private void SetCode(String sParam) {
        SetEditBoxValue("code", sParam);
    }

    private void SetName(String sParam) {
        SetEditBoxValue("name[en]", sParam);
    }

    private void EnableStatus(String sParam) {
        String spath = "//*[contains(text(),' "+sParam+"')]";
        ClickXPathElement(spath);
    }


    public void SetupInformationParams(){

        SelectTab("Information");

        SetManufacturer("ACME Corp.");
        SetKeywords("silver, duck, buy, mir, trud, mai");
        SetShortDescription("Silver ducks are the best ducks in the World");
        SetDescription("bla-bla-bla and ga-ga-ga");
        SetHeadTitle("Buy Silver duck and be happy");
        SetMeta("meta words for silver duck's page");

    }

    private void SetMeta(String sParam) {
        SetEditBoxValue("meta_description[en]", sParam);
    }

    private void SetHeadTitle(String sParam) {
        SetEditBoxValue("head_title[en]", sParam);
    }

    private void SetDescription(String sParam) {
        SetTextAreaValue(".trumbowyg-editor", sParam);
    }

    private void SetShortDescription(String sParam) {
        SetEditBoxValue("short_description[en]", sParam);
    }

    private void SetKeywords(String sParam) {
        SetEditBoxValue("keywords", sParam);
    }

    private void SetManufacturer(String sParam) {
        SelectListBoxValue("manufacturer_id", sParam);
    }

    public void SetupPricesParams(){

        SelectTab("Prices");

        SetPurchasePrice("10");
        SelectCurrency("US Dollars");
        SetUSDPrice("20");
        SetUSDTax("3.4");
        SetEuroPrice("31.2");
        SetEuroTax("7.56");

    }

    private void SetEuroTax(String sParam) {
        SetEditBoxValue("gross_prices[EUR]", sParam);
    }

    private void SetEuroPrice(String sParam) {
        SetEditBoxValue("prices[EUR]", sParam);
    }

    private void SetUSDTax(String sParam) {
        SetEditBoxValue("gross_prices[USD]", sParam);
    }

    private void SetUSDPrice(String sParam) {
        SetEditBoxValue("prices[USD]", sParam);
    }

    private void SelectCurrency(String sParam) {
        SelectListBoxValue("purchase_price_currency_code", sParam);
    }

    private void SetPurchasePrice(String sParam) {
        SetEditBoxValue("purchase_price", sParam);
    }

    private void SelectTab(String sTab){
        ClickLinkByText(sTab);
    }

    private void SaveParams(){
        ClickButton("save");
    }

    public void DeleteProduct(String productName) {
        ClickButton("delete");
        driver.switchTo().alert().accept();
    }

    public void CancelProduct() {
        ClickButton("cancel");
    }
}
