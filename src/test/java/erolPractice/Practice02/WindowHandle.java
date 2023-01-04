package erolPractice.Practice02;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.TestBase;

public class WindowHandle extends TestBase {


    //Amazon anasayfa adresine gidin.
    //Sayfa’nin window handle degerini String bir degiskene atayin
    //Sayfa title’nin “Amazon” icerdigini test edin
    //Yeni bir tab olusturup, acilan tab’da techproeducation.com adresine gidin
    //Sayfa title’nin “TECHPROEDUCATION” icerdigini test edin
    //Yeni bir window olusturup, acilan sayfada walmart.com adresine gidin
    //Sayfa title’nin “Walmart” icerdigini test edin
    //Ilk acilan sayfaya donun ve amazon sayfasina dondugunuzu test edin

    @Test
    public void test1(){
        driver.get("https://amazon.com");
        String w1 = driver.getWindowHandle();

        String pageTitle = driver.getTitle();
        Assert.assertTrue(pageTitle.contains("Amazon"));

        driver.switchTo().newWindow(WindowType.TAB); //Yeni bir sekme acmis olduk
        driver.get("https://techproeducation.com");
        String w2 = driver.getWindowHandle();
        String pageTitle2 = driver.getTitle();
        Assert.assertFalse(pageTitle2.contains("TECHPROEDUCATION"));

        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://walmart.com");
        String pageTitle3 = driver.getTitle();
        Assert.assertTrue(pageTitle3.contains("Walmart"));

        driver.switchTo().window(w1);
        String url = driver.getCurrentUrl();
        String expectedUrl = "https://www.amazon.com/";
        Assert.assertEquals(expectedUrl, url);





    }
}
