package burakPractice.day04;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.Set;

public class C03_WindowHandles extends TestBase {

    // 'https://www.n11.com' adresine gidin
    // arama motoruna 'oppo' yazıp aratın
    // ilk ürüne tıklayın
    // Basligin 'Oppo' icerdigini test edin.
    // ilk sayfaya donun ve Title'ını yazdırın

    @Test
    public void test1(){
        driver.get("https://www.n11.com");
        String w1 = driver.getWindowHandle();

        driver.findElement(By.id("searchData")).sendKeys("oppo", Keys.ENTER);
        driver.findElement(By.xpath("(//div[@data-position='1'])[1]")).click();
        Set<String> allWindows = driver.getWindowHandles();

        for (String w : allWindows){
            if (!w.equals(w1)){
                driver.switchTo().window(w);
                break;
            }
        }

        String productTitle = driver.findElement(By.tagName("h1")).getText();
        Assert.assertTrue(productTitle.contains("Oppo"));

        driver.switchTo().window(w1);
        System.out.println(driver.getTitle());
        waitFor(5);
    }
}