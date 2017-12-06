package step4;

import BaseTestPages.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class StickerHomePageTest extends BaseTest {

    @Test
    public void StickerCheck () {
        driver.get("http://localhost/litecart");

        int goodCounter = driver.findElements(By.cssSelector("li[class='product column shadow hover-light']")).size();
        System.out.println("Good number is: " + goodCounter);

        for (int i = 0; i <= goodCounter-1; i++ ) {
            List<WebElement> goodsList = driver.findElements(By.cssSelector("li[class='product column shadow hover-light']"));
            int stickerCount = goodsList.get(i).findElements(By.cssSelector(".image-wrapper > div")).size();
            Assert.assertTrue(stickerCount == 1);
            System.out.println("Sticker label is: " + goodsList.get(i).findElement(By.cssSelector(".image-wrapper div")).getText());
        }
    }
}
