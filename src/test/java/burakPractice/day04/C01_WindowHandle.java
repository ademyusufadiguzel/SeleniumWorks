package burakPractice.day04;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

public class C01_WindowHandle extends TestBase {

    // 1- https://www.amazon.com sayfasına gidin
    // 2- nutella icin arama yapın
    // 3- yeni bir tab'da ilk urunun resmine tıklayınız
    // 4- yeni tab'da acilan urunun basligini yazdirin
    // 5- ilk sayfaya gecip url'i yazdırın

    @Test
    public void test1(){
        driver.get("https://www.amazon.com/");

        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("nutella", Keys.ENTER);


        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.amazon.com/");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("nutella", Keys.ENTER);

        driver.findElement(By.xpath("//div[@data-index='1']//img[@data-image-index='1']")).click();
        String productTitle = driver.findElement(By.id("productTitle")).getText();
        System.out.println(productTitle);

        switchToWindow(1);
        System.out.println(driver.getCurrentUrl());
    }
}