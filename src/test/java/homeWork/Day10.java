package homeWork;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.Set;

public class Day10 extends TestBase {
    //https://demoqa.com/ url'ine gidin.
    //Alerts, Frame & Windows Butonuna click yap
    //""Please select an item from left to start practice."" yazısının görünür olduğunu doğrula
    //Sol'da açılan Menu den ""Browser Windows"" butonuna click yap
    //New Tab butonunun görünür olduğunu doğrula
    //New Tab butonuna click yap
    //Açılan yeni Tab da ""This is a sample page"" yazısının görünür olduğunu doğrula
    //İlk Tab'a geri dön
    //New Tab butonunun görünür olduğunu doğrula
    @Test
    public void test1() throws InterruptedException {
        driver.get("https://demoqa.com/");
        String window1 = driver.getWindowHandle();

        driver.findElement(By.xpath("(//div[@class='card mt-4 top-card'])[3]")).click();

        String text1 = driver.findElement(By.xpath("//div[@class='col-12 mt-4 col-md-6']")).getText();
        Assert.assertEquals("Passed", "Please select an item from left to start practice.", text1);
        Thread.sleep(3000);

        driver.findElement(By.xpath("(//li[@id='item-0'])[3]")).click();

        WebElement newTabButton = driver.findElement(By.id("tabButton"));
        Assert.assertTrue(newTabButton.isDisplayed());

        newTabButton.click();

        Set<String> allWindows = driver.getWindowHandles();

        for (String w : allWindows){
            if (!w.contains(window1)){
                driver.switchTo().window(w);
                break;
            }
        }

        String window2Text = driver.findElement(By.id("sampleHeading")).getText();
        Assert.assertEquals("Passed", "This is a sample page", window2Text);

        driver.switchTo().window(window1);
        Assert.assertTrue(newTabButton.isDisplayed());
    }
}


