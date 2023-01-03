package erolPractice.Practice02;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class C03 extends TestBase {

    //1) http://demo.guru99.com/test/guru99home/ sitesine gidiniz
    //2) sayfadaki iframe sayısını bulunuz.
    //3) ilk iframe'deki (Youtube) play butonuna tıklayınız.
    //4) ilk iframe'den çıkıp ana sayfaya dönünüz
    //5) ikinci iframe'deki (Jmeter Made Easy) linke (https://www.guru99.com/live-selenium-project.html)
    //tıklayınız

    @Test
    public void test1() throws InterruptedException {
        driver.get("http://demo.guru99.com/test/guru99home/");

        List<WebElement> iframeSayisi = driver.findElements(By.xpath("//iframe"));
        System.out.println(iframeSayisi.size());

        WebElement iframe1 = driver.findElement(By.xpath("//*[@wmode='transparent']"));
        driver.switchTo().frame(iframe1);
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("button[aria-label='Oynat']")).click();

        driver.switchTo().defaultContent();
        driver.navigate().refresh();
        Thread.sleep(3000);

        WebElement iframe2 = driver.findElement(By.id("a077aa5e"));
        driver.switchTo().frame(iframe2).findElement(By.xpath("//img[@src='Jmeter720.png']")).click();



    }

}
