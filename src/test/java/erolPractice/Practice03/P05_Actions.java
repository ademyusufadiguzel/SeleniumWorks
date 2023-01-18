package erolPractice.Practice03;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class P05_Actions extends TestBase {

    /*
    - http://szimek.github.io/signature_pad/ sayfasına gidiniz
    - Çıkan ekrana istediğiniz çizgi yada şekli çiziniz
    - Cizdikten sonra clear buttonuna basalim
    - Son olarak sayfayı temizleyiniz
    */

//    @Test
//    public void name() throws InterruptedException {
//        driver.get("http://szimek.github.io/signature_pad/");
//        WebElement yaziTahtasi = driver.findElement(By.xpath("//canvas"));
//        Actions actions = new Actions(driver);
//        actions.moveToElement(yaziTahtasi).clickAndHold();
//        for (int i = 0; i < 10; i++) {
//            actions.moveByOffset(-5,-5);
//        }
//        for (int i = 0; i < 10; i++) {
//            actions.moveByOffset(0,5);
//        }
//        for (int i = 0; i < 10; i++) {
//            actions.moveByOffset(5,0);
//        }
//        actions.release().build().perform();
//        Thread.sleep(5000);
//        driver.findElement(By.xpath("//*[text()='Clear']")).click();
//    }

    @Test
    public void test1(){
        driver.get("http://szimek.github.io/signature_pad/");
        WebElement canvas = driver.findElement(By.tagName("Canvas"));
        Actions actions = new Actions(driver);

        actions.moveToElement(canvas).moveByOffset(-50,52).clickAndHold();

        for (int i = 0; i < 15; i++) {
            actions.moveByOffset(4,-10);
        }
        for (int i = 0; i < 16; i++) {
            actions.moveByOffset(4,10);
        }
        for (int i = 0; i < 26; i++) {
            actions.moveByOffset(-6,-4);
        }
        for (int i = 0; i < 46; i++) {
            actions.moveByOffset(4,0);
        }
        for (int i = 0; i < 26; i++) {
            actions.moveByOffset(-6,4);
        }

        actions.build().perform();

        waitFor(5);



    }






























}
