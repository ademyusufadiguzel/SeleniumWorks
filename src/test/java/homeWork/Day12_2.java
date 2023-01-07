package homeWork;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class Day12_2 extends TestBase {

    //1. "http://webdriveruniversity.com/Actions" sayfasina gidin
    //2. "Hover over Me First" kutusunun ustune gelin
    //3. "Link 1" e tiklayin
    //4. Popup mesajini yazdirin
    //5. Popup'i tamam diyerek kapatin
    //6. "Click and hold" kutusuna basili tutun
    //7. "Click and hold" kutusunda cikan yaziyi yazdirin
    //8. "Double click me" butonunu cift tiklayin
    //9. "Double click me" butonunun renk değiştridiğini doğrulayın

    @Test
    public void hoverOver(){
        driver.get("http://webdriveruniversity.com/Actions");
        Actions actions = new Actions(driver);

        WebElement hoverOverButton = driver.findElement(By.xpath("//button[.='Hover Over Me First!']"));
        actions.moveToElement(hoverOverButton).perform();

        driver.findElement(By.linkText("Link 1")).click();
        waitFor(3);

        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();

        WebElement clickHold = driver.findElement(By.xpath("//p[.='Click and Hold!']"));
        actions.clickAndHold(clickHold).perform();

        String text = driver.findElement(By.id("click-box")).getText();
        System.out.println(text);

        WebElement doubleClick = driver.findElement(By.xpath("//div[@class='div-double-click']"));
        actions.doubleClick(doubleClick).perform();

        WebElement doubleClicked = driver.findElement(By.xpath("//div[@class='div-double-click double']"));
        Assert.assertTrue(doubleClicked.isEnabled());
    }
}