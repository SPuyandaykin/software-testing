package trenningpages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import trenningutils.UtilitiesClass;

import java.util.concurrent.TimeUnit;

public class Page {

    protected WebDriver driver;
    protected WebDriverWait wait;

    protected UtilitiesClass utility;

    public Page(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 3);

        utility = new UtilitiesClass();
    }

    protected void type(WebElement webElement, String text){
        webElement.clear();
        webElement.sendKeys(text);
    }

    public boolean IsElementExists(By iClassName)
    {
        if(driver.findElements(iClassName).size()>0) {
            return true;
        }
        else {
            System.out.println("Element is not exist: "+ iClassName);
            return false;
        }
    }

    public boolean elementNotExist(By iClassName)
    {
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        try {
            driver.findElement(iClassName).isDisplayed();
            driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
            return false;
        }catch (NoSuchElementException e){
            driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
            return true;
        }
    }

    public boolean isElementPresent(By iClassName)
    {
        if(!IsElementExists(iClassName)) {
            return false;
        }

        try {
            driver.findElement(iClassName).isDisplayed();
            return true;
        }catch (NoSuchElementException e){
//        }catch (StaleElementReferenceException e){
            System.out.println("Element is not displayed: "+ iClassName);
            return false;
        }
    }

    public boolean SetCheckBox(String fieldName, String fieldValue) {
        String selectorPath = "input[name="+fieldName+"]";
        return SetSelectorCheckBox(selectorPath, fieldValue);

    }

    public boolean ClickButton(String fieldName){
        String selectorPath = "button[name="+fieldName+"]";
        return ClickBySelectorButton(selectorPath);
    }

    public boolean SelectListBoxValue(String fieldName, String fieldValue) {
        String selectorPath = "select[name*="+fieldName+"]";
        return ClickOnSelectedListBoxElement(selectorPath, fieldValue);
    }

    public boolean SetEditBoxValue(String fieldName, String fieldValue) {
        String selectorPath = "input[name='"+fieldName+"']";
        return SetSelectorEditBoxValue(selectorPath, fieldValue);
    }

    public boolean SendEnterToEditBox(String fieldName) {
        String selectorPath = "input[name='"+fieldName+"']";
        if(isElementPresent(By.cssSelector(selectorPath))){
            driver.findElement(By.cssSelector(selectorPath)).sendKeys(Keys.ENTER);
            return true;
        }

        return false;
    }

    public String GetEditBoxValue(String fieldName) {
        String selectorPath = "input[name="+fieldName+"]";
        return GetEditBoxPropery(selectorPath, "value");
    }

    public boolean ClickOnSelectedListBoxElement(String cssPath, String fieldValue){
        if(isElementPresent(By.cssSelector(cssPath))) {
            Select dateDropDown=new Select(driver.findElement(By.cssSelector(cssPath)));
            dateDropDown.selectByVisibleText(fieldValue);
            return true;
        }
        return false;
    }

    public boolean ClickBySelectorButton(String cssPath){
        if(isElementPresent(By.cssSelector(cssPath))) {
            driver.findElement(By.cssSelector(cssPath)).click();
            return true;
        }

        return false;
    }

    public boolean SetSelectorCheckBox(String cssPath, String value){

        if(!isElementPresent(By.cssSelector(cssPath))){
            return false;
        }

        if(GetCurrentCheckboxStatus(cssPath).equalsIgnoreCase(ConvertStringToCheckboxStatus(value)))
            return true;

        driver.findElement(By.cssSelector(cssPath)).click();
        return true;
    }

    public String GetCurrentCheckboxStatus(String cssPath){
        return driver.findElement(By.cssSelector(cssPath)).getAttribute("checked");
    }

    public boolean SetSelectorEditBoxValue(String cssPath, String value){

        if(isElementPresent(By.cssSelector(cssPath))){
            WebElement element = driver.findElement(By.cssSelector(cssPath));
            if(!element.getAttribute("type").equalsIgnoreCase("date"))
                element.clear();
            element.sendKeys(value);
            return true;
        }

        return false;
    }

    public boolean SetTextAreaValue(String cssPath, String value){

        if(isElementPresent(By.cssSelector(cssPath))){
            WebElement element = driver.findElement(By.cssSelector(cssPath));
            element.clear();
            element.sendKeys(value);
            return true;
        }

        return false;
    }

    protected String GetEditBoxPropery(String cssPath, String propertyName){
        if(isElementPresent(By.cssSelector(cssPath)))
            return driver.findElement(By.cssSelector(cssPath)).getAttribute(propertyName);

        return "";
    }

    protected String ConvertStringToBooleanStr(String s_flag) {
        if(s_flag.equalsIgnoreCase("False"))
            return "0";
        return "1";
    }

    protected String ConvertStringToCheckboxStatus(String s_flag) {
        if(s_flag.equalsIgnoreCase("Yes"))
            return "True";
        return "False";
    }

    protected boolean ClickXPathElement(String sPath){
        return ClickElement(By.xpath(sPath));
    }

    protected boolean ClickCSSElement(String sPath){
        return ClickElement(By.cssSelector(sPath));
    }

    protected boolean ClickElement(By iClassName){
        if(isElementPresent(iClassName)){
            driver.findElement(iClassName).click();
            return true;}

        return false;
    }

    protected String GetTextXPathElement(String sPath){
        return GetTextElement(By.xpath(sPath));
    }

    protected String GetTextCSSElement(String sPath){
        return GetTextElement(By.cssSelector(sPath));
    }

    protected String GetTextElement(By iClassName) {
        if(isElementPresent(iClassName)){
            return driver.findElement(iClassName).getText(); }

        return "";
    }

    protected boolean ClickLinkByText(String sText){
        String sPath = "//a[contains(text(),'"+sText+"')]";
        if(isElementPresent(By.xpath(sPath))){
            driver.findElement(By.xpath(sPath)).click();
            return true;
        }

        return false;
    }

    protected boolean UploadFileFromFolder(String fileName){
        String filePath = System.getProperty("user.dir")+fileName;
        String sPath = "//input[@type='file']";
        if(isElementPresent(By.xpath(sPath))) {
            System.out.println(filePath);
            driver.findElement(By.xpath(sPath)).sendKeys(filePath);
            return true;
        }

        return false;
    }

    protected WebElement GetElementByXpath (String sPath){
        if(isElementPresent(By.xpath(sPath)))
            return driver.findElement(By.xpath(sPath));

        return null;
    }

    protected int GetWebElementQuantity(String sPath){
        if (isElementPresent(By.xpath(sPath)))
            return driver.findElements(By.xpath(sPath)).size();

        return 0;
    }

    public void pause(Integer milliseconds){
        try {
            TimeUnit.MILLISECONDS.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
