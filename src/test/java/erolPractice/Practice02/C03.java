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
        List<WebElement> allIframe = driver.findElements(By.tagName("iframe"));
        System.out.println(allIframe.size());

        WebElement iframe = driver.findElement(By.xpath("//iframe[@wmode='transparent']"));
        driver.switchTo().frame(iframe);
        driver.findElement(By.id("player")).click();
        Thread.sleep(3000);

        driver.switchTo().defaultContent();
        WebElement iframe2 = driver.findElement(By.id("a077aa5e"));
        driver.switchTo().frame(iframe2);
        driver.findElement(By.xpath("//img[@src='Jmeter720.png']")).click();
    }
}
