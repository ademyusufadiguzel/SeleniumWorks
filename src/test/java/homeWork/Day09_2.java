package homeWork;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.util.Set;

public class Day09_2 extends TestBase {

       /*
       url'ye git: http://demo.guru99.com/popup.php
       ilk pencereyi al
       "Click Here" butonuna tıklayın
       setteki tüm pencereyi al
       diğer pencereye geç
       e-posta kimliğini (somepne@gmail.com) girin ve bu girişe bir şey yazın
       Gönder düğmesine tıklayarak
       ""This access is valid only for 20 days."" ifadesinin beklendiği gibi olduğunu doğrula
       Tekrar ilk pencereye geç
       İlk pencerede olduğunu doğrula
       */

    @Test
    public void test1() {

        driver.get("http://demo.guru99.com/popup.php");
        String window1 = driver.getWindowHandle();

        driver.findElement(By.xpath("//a[@href='../articles_popup.php']")).click();

        Set<String> allWIndows = driver.getWindowHandles();

        for (String w : allWIndows) {
            if (!w.equals(window1)) {
                driver.switchTo().window(w);
                break;
            }
        }

        driver.findElement(By.xpath("//input[@name='emailid']")).sendKeys("somepne@gmail.com");
        driver.findElement(By.xpath("//input[@name='btnLogin']")).click();

        String actualPageText = driver.findElement(By.xpath("//h3[@style='color:#800080;font-size:22px;font-weight:700;']")).getText();
        Assert.assertTrue(actualPageText.contains("This access is valid only for 20 days."));

        driver.switchTo().window(window1);

        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals("Passed", "https://demo.guru99.com/popup.php", actualUrl);
    }
}