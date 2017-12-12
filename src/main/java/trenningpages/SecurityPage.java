package trenningpages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SecurityPage extends ContentPage {

    public SecurityPage (WebDriver driver){
        super(driver);
    }

    public void CaptchaMode (String s_flag){
        String paramName = "CAPTCHA";
        ChangeParamMode(paramName, s_flag);
    }

    public void ChangeParamMode(String parName, String s_flag){
        String spath = "//table[@class='dataTable']/tbody/tr/td[contains(.,'"+parName+"')]/parent::node()";
        WebElement element = driver.findElement(By.xpath(spath));
        if(element.findElement(By.xpath(spath+"/td[2]/span")).getText().equalsIgnoreCase(s_flag))
            return;

        element.findElement(By.xpath(spath+"/td[3]/a")).click();
        driver.findElement(By.xpath("//td/label/input[@value='"+ConvertFlagToInt(s_flag)+"']")).click();
        driver.findElement(By.cssSelector("button[name='save']")).click();
    }

    private String ConvertFlagToInt(String s_flag) {
        if(s_flag.equalsIgnoreCase("False"))
            return "0";
        return "1";
    }
}
