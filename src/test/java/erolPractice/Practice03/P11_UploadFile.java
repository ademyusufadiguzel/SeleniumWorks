package erolPractice.Practice03;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class P11_UploadFile extends TestBase {

    //https://demo.guru99.com/test/upload/ adresine gidiniz
    //Bilgisayarınızdan herhangi bir dosyayı upload ediniz
    // I accept terms of service bölümünü tikleyin
    // Submit File buttonuna basınız
    // "1 file has been successfully uploaded" görünür olduğunu test edin

    @Test
    public void test1(){
        driver.get("https://demo.guru99.com/test/upload/");

        WebElement fileUploadButton = driver.findElement(By.xpath("//input[@type='file']"));
        String path = "C:\\Users\\Adem Yusuf\\Downloads\\logo.jpeg";
        fileUploadButton.sendKeys(path);

        driver.findElement(By.xpath("//input[@type='checkbox']")).click();
        driver.findElement(By.xpath("//button[@id='submitbutton']")).click();

        assert driver.findElement(By.xpath("//h3[@id='res']")).isDisplayed();


    }


}
