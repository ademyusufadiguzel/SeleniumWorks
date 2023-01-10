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

    @Test
    public void test1(){
        driver.get("http://szimek.github.io/signature_pad/");
        Actions actions = new Actions(driver);



        WebElement drawBox = driver.findElement(By.xpath("//canvas[@style='touch-action: none; user-select: none;']"));


    }

}
