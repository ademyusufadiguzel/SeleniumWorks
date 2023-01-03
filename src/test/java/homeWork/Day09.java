package homeWork;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day09 extends TestBase {

    //go to web site : https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/
    //maximize the web site
    // ikinci emojiye tıklayın
    // ikinci emoji altındaki tüm öğelere tıklayın
    // ana iframe'e geri dön
    //formu doldurun,(Formu istediğiniz metinlerle doldurun)
    // uygula butonuna tıklayın

    @Test
    public void tes1() throws InterruptedException {
        driver.get("https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/");

        WebElement iframe = driver.findElement(By.xpath("//iframe[@id='emoojis']"));
        driver.switchTo().frame(iframe).findElement(By.xpath("//a[@href='#nature']")).click();

        List<WebElement> emojiList = driver.findElements(By.xpath("//*[@class='mdl-tabs__panel is-active']//img"));
        for (WebElement w: emojiList){
            w.click();
        }
        driver.switchTo().defaultContent();

        Thread.sleep(3000);

        List<WebElement> inputList = driver.findElements(By.xpath("//input"));

        List<String> inputWordsList = new ArrayList<>(Arrays.asList("tes1","test2","tes3", "tes4", "tes5", "tes6", "tes7", "tes8", "tes9", "tes10", "tes11"));

        for (int i = 0; i < inputList.size(); i++) {
            inputList.get(i).sendKeys(inputWordsList.get(i));
        }

        driver.findElement(By.id("send")).click();

        WebElement codeBlock = driver.findElement(By.id("code"));
        Assert.assertTrue(codeBlock.isDisplayed());

        Thread.sleep(5000);
    }
}
