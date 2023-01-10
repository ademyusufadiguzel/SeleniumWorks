package erolPractice.Practice03;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.security.Key;

public class P07_UpperLowerLetter extends TestBase {

    //google sayfasina gidelim
    //Buyuk kucuk harf olucak sekilde "HeLlO" yazdiralim

    @Test
    public void test01(){
        driver.get("https://www.google.com/");

        WebElement searchBox = driver.findElement(By.xpath("//input[@class='gLFyf']"));
        searchBox.sendKeys(Keys.SHIFT,"h",Keys.SHIFT,"e",Keys.SHIFT,"l", Keys.SHIFT,"l",Keys.SHIFT,"o",Keys.SHIFT);
        waitFor(5);

    }

}
