package erolPractice.Practice02;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.Set;

public class P05 extends TestBase {

    // https://the-internet.herokuapp.com/iframe adresine gidiniz
    // An iFrame conteining... başlığının altındaki Text Box’a “Techproeducation” yazin.
    // TextBox’in altinda bulunan “Elemental Selenium” linkinin gorunur oldugunu test edin
    // Elemental Selenium linkine tıklayın
    // Açılan sayfada sayfa başlığını yazdırınız
    // Elemental Selenium başlığı altındaki "Source Labs" linkinin gorunur olduğunu test edin
    // Source labs linkine tıklayın
    // Açılan sayfada sayfa başlığını yazdırınız
    // ilk sekmeye geri dönelim ve url'ini yazdıralım
    // ilk sekmeyi kapatalım

    @Test
    public void test1() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/iframe");
        String w1 = driver.getWindowHandle();
        WebElement iframe = driver.findElement(By.id("mce_0_ifr"));
        driver.switchTo().frame(iframe);

        WebElement textbox = driver.findElement(By.xpath("//p"));
        textbox.clear();
        textbox.sendKeys("Techproeducation");

        driver.switchTo().defaultContent();

        WebElement elemntalSelenium = driver.findElement(By.xpath("//*[.='Elemental Selenium']"));
        Assert.assertTrue(elemntalSelenium.isDisplayed());
        elemntalSelenium.click();

        Set<String> allWindow = driver.getWindowHandles();

        for (String w : allWindow) {
            if (!w.contains(w1)) {
                driver.switchTo().window(w);
                break;
            }
        }

        String w2 = driver.getWindowHandle();
        System.out.println(driver.getTitle());
        WebElement sourceLabs = driver.findElement(By.xpath("//a[@class='link']"));
        Assert.assertTrue(sourceLabs.isDisplayed());
        sourceLabs.click();

        Set<String> allWindow2 = driver.getWindowHandles();

        for (String w : allWindow2){
            if (!w.contains(w1) && !w.contains(w2)){
                driver.switchTo().window(w);
                break;
            }
        }

        System.out.println(driver.getTitle());

        driver.switchTo().window(w1);
        System.out.println(driver.getCurrentUrl());

        driver.close();
        Thread.sleep(3000);
    }
}
