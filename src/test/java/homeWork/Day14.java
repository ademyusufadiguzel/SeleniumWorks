package homeWork;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utilities.TestBase;

public class Day14 extends TestBase {

    //https://www.n11.com/ ' da
    //Decision table testing yaparak tum olasiliklar icin login page'in bize verecegi responselari test edin.
    //n11ValidEmail=test.123.yap@gmail.com
    //n11ValidPassword=Deneme123!

    @Test
    public void test1(){
        driver.get("https://www.n11.com/");

        driver.findElement(By.xpath("//a[@title='Giriş Yap']")).click();

        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("test.123.yap@gmail.com", Keys.TAB,"Deneme123!");

        waitFor(3);
        driver.findElement(By.xpath("//div[@id='loginButton']")).click();

        waitFor(5);
    }
}