package trenningpages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;

public class CustomersPage extends ContentPage {
    public CustomersPage (WebDriver driver){
        super(driver);
    }

    public boolean DeleteCustomer(String customerName) {

        int rowsBefore = driver.findElements(By.cssSelector(".dataTable tr")).size();
        System.out.println("row is: " + rowsBefore);
        if (rowsBefore <= 2) {
                System.out.println("There are no customers");
                return false;
        }

        String sPath = "//table[@class='dataTable']/tbody/tr/td[5][contains(.,'" + customerName + "')]/a";
        ClickElement(By.xpath(sPath));
        DeleteCustomerButton();

        int rowsAfter = driver.findElements(By.cssSelector(".dataTable tr")).size();
        if(rowsAfter>=rowsBefore)
            return true;

        return true;
    }
    protected boolean DeleteCustomerButton()
    {
        ClickButton("delete");
        driver.switchTo().alert().accept();
        return true;
    }
}
