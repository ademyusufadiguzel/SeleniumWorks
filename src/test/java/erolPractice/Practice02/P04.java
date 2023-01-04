package erolPractice.Practice02;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

public class P04 extends TestBase {

    //    - https://html.com/tags/iframe/ adresine gidiniz
    //    - youtube videosunu çalıştırınız
    //    - üç saniye çalıştıktan sonra sayfayı yenileyiniz
    //    - yeni sekmede amazon adresine gidiniz
    //    - iphone aratınız
    //    - arama sonucu olarak sadece sonuc sayısını yazdırınız
    //    - ilk sekmeye geri dönüp url'ini konsola yazdıralım
    //    - ilk sekmeyi kapatalım
    //    - Sonra diğer sekmeyide kapatalım
    @Test
    public void test01() throws InterruptedException {
        //- https://html.com/tags/iframe/ adresine gidiniz
        driver.get("https://html.com/tags/iframe/");
        //- youtube videosunu çalıştırınız
        WebElement iframe = driver.findElement(By.cssSelector("iframe[frameborder='0']"));
        driver.switchTo().frame(iframe);
        driver.findElement(By.cssSelector("button[aria-label='Oynat']")).click();
        //- üç saniye çalıştıktan sonra sayfayı yenileyiniz
        Thread.sleep(3000);
        driver.navigate().refresh();
        //- yeni sekmede amazon adresine gidiniz
        //- iphone aratınız
        //- arama sonucu olarak sadece sonuc sayısını yazdırınız
        //- ilk sekmeye geri dönüp url'ini konsola yazdıralım
        //- ilk sekmeyi kapatalım
        //- Sonra diğer sekmeyide kapatalım
    }

}
