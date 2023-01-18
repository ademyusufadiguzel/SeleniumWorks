package erolPractice.Practice04;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.*;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class P02_ScreenShot extends TestBase {

    //Amazon sayfasına gidelim
    //Tüm sayfanın resmini alalım
    //Yeni bir sekmede techproeducation sayfasına gidip sayfanın resmini alalım
    //Tekrar amazon sayfasına dönüp iphone aratalım
    //Arama sonucunun resmini alalım

    String currentDate;
    @Test
    public void test1() throws IOException {
        driver.get("https://www.amazon.com/");

        /*
        FILEUTILS CLASS'I, FILE OBJECT'LERI ILE BIRLIKTE KULLANABILECEGIMIZ METHOD'LAR ICERIR.
        BU METHOD'LARI KULLANARAK DOSYALARDA OKUMA, YAZMA VE KOPYALAMA ISLEMLERINI COK DAHA KOLAY YAPABILIRIZ.
         */

        currentDate = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

        TakesScreenshot scrnSht = (TakesScreenshot) driver;
        FileUtils.copyFile(scrnSht.getScreenshotAs(OutputType.FILE),new File("target/ScreenShots/"+currentDate+"image.png"));
        waitFor(3);

        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.techproeducation.com/");

        FileUtils.copyFile(scrnSht.getScreenshotAs(OutputType.FILE), new File("target/ScreenShots/"+currentDate+"image.png"));

        switchToWindow(1);
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iPhone", Keys.ENTER);

        WebElement searchResult = driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));

        File image = searchResult.getScreenshotAs(OutputType.FILE);
        String path = System.getProperty("user.dir")+"target/ScreenShots/"+currentDate+"image.png";
        FileUtils.copyFile(image, new File(path));

        waitFor(2);
    }
}
