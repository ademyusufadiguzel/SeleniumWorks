package erolPractice.Practice03;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;


public class P06_Actions extends TestBase {
    /*
     -https://jqueryui.com/slider/#colorpicker adrese gidiniz
     -Kutucuk içindeki rengi önce kırmızı sonra sarı yapınız
     -Sarı olduğunu test edelim
     */
//    @Test
//    public void name() {
//        //-https://jqueryui.com/slider/#colorpicker adrese gidiniz
//        driver.get("https://jqueryui.com/slider/#colorpicker");
//        WebElement iframe = driver.findElement(By.xpath("//*[@class='demo-frame']"));
//        driver.switchTo().frame(iframe);
//        //-Kutucuk içindeki rengi önce kırmızı sonra sarı yapınız
//        WebElement yesilTus = driver.findElement(By.xpath("(//*[@class='ui-slider-handle ui-corner-all ui-state-default'])[2]"));
//        WebElement maviTus = driver.findElement(By.xpath("(//*[@class='ui-slider-handle ui-corner-all ui-state-default'])[3]"));
//        Actions actions = new Actions(driver);
//        actions.dragAndDropBy(yesilTus, -175, 0);//Genellikle slider' lar için bu method kullanılır
//        actions.dragAndDropBy(maviTus, -80, 0);
//        actions.dragAndDropBy(yesilTus, 301, 0).release().build().perform();
//        //-Sarı olduğunu test edelim
//        WebElement sari = driver.findElement(By.xpath("//*[@style='background-color: rgb(255, 255, 0);']"));
//        assert sari.isDisplayed();
//    }

    @Test
    public void test1(){
        driver.get("https://jqueryui.com/slider/#colorpicker");
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.DOWN);

        WebElement iframe = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
        driver.switchTo().frame(iframe);

        WebElement greenButton = driver.findElement(By.xpath("(//span[@tabindex='0'])[2]"));
        WebElement blueButton = driver.findElement(By.xpath("(//span[@tabindex='0'])[3]"));

        actions.dragAndDropBy(blueButton, -80,0).release().build().perform();
        actions.dragAndDropBy(greenButton, -170,0).release().build().perform();
        waitFor(5);
        actions.dragAndDropBy(greenButton,350,0).release().build().perform();

        WebElement yellowVisiable = driver.findElement(By.xpath("//div[@style='background-color: rgb(255, 255, 0);']"));
        assert yellowVisiable.isDisplayed();

        waitFor(5);
    }
}