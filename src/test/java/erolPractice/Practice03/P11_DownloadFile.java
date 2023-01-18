package erolPractice.Practice03;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.io.File;

public class P11_DownloadFile extends TestBase {

    //https://www.selenium.dev/downloads/ adresine gidelim
    //Platforms Supported by Selenium altındaki Browsers bölümü görünene kadar sayfayı indirelim
    //Browser bölümünden Chrome driver bölümündeki documentation linkine tıklıyalım
    //All versions available in Downloads altında Latest stable release olan linki tıklayalım
    //Açılan pencerede chromedriver'i indirelim
    //Driver'in indiğini doğrulayalım

    @Test
    public void test(){
        driver.get("https://www.selenium.dev/downloads/");
        Actions actions = new Actions(driver);
        WebElement button = driver.findElement(By.xpath("//button[@aria-controls='supported-browsers']"));
        actions.moveToElement(button).perform();
        button.click();

        WebElement documentation = driver.findElement(By.xpath("(//div[@class='card mb-3 border-0'])[5]//a[text()='documentation']"));
        actions.moveToElement(documentation).perform();
        documentation.click();

        driver.findElement(By.xpath("(//a[@class='XqQF9c'])[2]")).click();

        switchToWindow(2);
        driver.findElement(By.xpath("//*[text()='chromedriver_win32.zip']")).click();
        waitFor(4);

        String path = "C:\\Users\\Adem Yusuf\\Downloads\\chromedriver_win32.zip";
        File file = new File(path);
        assert file.exists();

        waitFor(5);
    }
}
