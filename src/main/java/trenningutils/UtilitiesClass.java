package trenningutils;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class UtilitiesClass {
    public UtilitiesClass (){}

    public boolean CheckAlpabeticList (List<WebElement> listWeb){
        char prevFirstChar = 'A';
        int listSize = listWeb.size();
        System.out.println("Element counter is: " + listSize);
        for (int i = 0; i <= listSize-1; i++ ) {
            String currentZone = listWeb.get(i).getText();
            char currentFirstChar = currentZone.charAt(0);
            System.out.println("first letter is: " + currentFirstChar);
            if(currentFirstChar < prevFirstChar)
                return false;
            prevFirstChar = currentFirstChar;
        }
        return true;
    }

    public String EmailGenerator (String domain) {
            int a = (int) (Math.random()*(1000+1));
            String s = Integer.toString(a);
            return "sergey"+s+domain;
    }
}
